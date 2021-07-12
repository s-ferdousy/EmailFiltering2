public class Likelihood extends Dictionary {

    String[] word1 = super.SpamDictionary();
    String[] word2 = super.HamDictionary();

    public Likelihood() {
    }

    public double[] Freq(String[] words) {
        double[] frequency = new double[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    frequency[i]++;
                }
            }
        }
        return frequency;
    }

    public double[] LikelihoodOfWordsInSpam() {
        double[] frq_of_spam_word = Freq(word1);
        double[] PWS = new double[frq_of_spam_word.length];
        double x = frq_of_spam_word.length;
        for(int i=0; i<PWS.length; i++){
            PWS[i] = (double) frq_of_spam_word[i]/PWS.length;
        }
        return PWS;
    }
    public double[] LikelihoodOfWordsInHam() {
        double[] frq_of_ham_word = Freq(word2);
        double[] PWH = new double[frq_of_ham_word.length];
        for(int i=0; i<PWH.length; i++){
            PWH[i] = (double) frq_of_ham_word[i]/PWH.length;
        }
        return PWH;
    }
}
