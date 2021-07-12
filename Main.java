import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double P_S = 0.2;
        double P_H = 0.8;
        Likelihood Likelihood = new Likelihood();
        String[] word_set = Likelihood.CommonWords();
        List<String> list = new ArrayList<String>();
        for(String s : word_set) {
            if(s != null && s.length() > 0) {
                list.add(s);
            }
        }
        word_set = list.toArray(new String[list.size()]);
        for (int i = 0; i<word_set.length; i++) {
            System.out.println("based on sample emails and the word_set: "+ word_set[i]);
        }
        double[] PWS = Likelihood.LikelihoodOfWordsInSpam();
        double[] PWH = Likelihood.LikelihoodOfWordsInHam();
        String[] spam_words = Likelihood.SpamDictionary();
        String[] ham_words = Likelihood.HamDictionary();
        double[] P_W_S = new double[word_set.length];
        double[] P_W_H = new double[word_set.length];
        double[] P_S_W = new double[PWS.length];
        double[] P_H_W = new double[PWH.length];
        int index=0;
        for (int i = 0; i < spam_words.length; i++) {
            for(int j = 0; j < word_set.length; j++) {
                if(word_set[j].equals(spam_words[i])) {
                    P_W_S[index] = PWS[i];
                    index++;
                }
            }
        }
        int index2=0;
        for (int x = 0; x < ham_words.length; x++) {
            for(int y = 0; y < word_set.length; y++) {
                if(word_set[y].equals(ham_words[x])) {
                    P_W_H[index2] = PWH[x];
                    index2++;
                }
            }
        }
        for (int i = 0; i <P_W_S.length ; i++) {
            P_S_W[i] = (P_W_S[i] * P_S)/ (P_W_S[i] * P_S + P_W_H[i] * P_H);
        }
        for (int i = 0; i <P_W_H.length ; i++) {
            P_H_W[i] = (P_W_H[i] * P_H) / (P_W_H[i] * P_H + P_W_S[i] * P_S);
        }
        double MP_H_W = 1;
        double SP_H_W = 1.0;
        double MP_S_W = 1;
        double SP_S_W = 1.0;
        double hsub[] = new double[word_set.length];
        for (int i = 0; i<word_set.length; i++) {
            MP_H_W = MP_H_W * P_H_W[i];
            hsub[i] = 1 - P_H_W[i];
        }
        for (int i=0;i<hsub.length; i++){
            SP_H_W = SP_H_W*hsub[i];
        }

        double ssub[] = new double[word_set.length];
        for (int i = 0; i<word_set.length; i++) {
            MP_S_W = MP_S_W * P_S_W[i];
            ssub[i] = 1 - P_S_W[i];
        }
        for (int i=0;i<ssub.length; i++){
            SP_S_W = SP_S_W*ssub[i];
        }
        double PS = MP_S_W / (MP_S_W + SP_S_W);
        double PH = MP_H_W / (MP_H_W + SP_H_W);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Probability that the new email is spam: " + Double.valueOf(df.format(PS*100)) + "%");
        System.out.println("Probability that the new email is ham: " + Double.valueOf(df.format(PH*100)) + "%");

    }
}
