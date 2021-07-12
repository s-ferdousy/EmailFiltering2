import java.util.HashSet;

public class Dictionary extends Input {

    String ham = super.SampleHamInput();
    String spam = super.SampleSpamInput();
    String new_email = super.NewEmail();

    public Dictionary() {

    }

    public String[] SpamDictionary() {
        String[] spam_words = spam.split(" ");
        return spam_words;
    }

    public String[] HamDictionary() {
        String[] ham_words = ham.split(" ");
        return ham_words;
    }

    public String[] NewEmailWords() {
        String[] email_words = new_email.split(" ");
        return email_words;
    }

    public String[] HamSpamWords() {
        String[] spam_words = SpamDictionary();
        String[] ham_words = HamDictionary();
        String[] dictionary_words = new String[spam_words.length + ham_words.length];
        System.arraycopy(ham_words, 0, dictionary_words, 0, ham_words.length);
        System.arraycopy(spam_words, 0, dictionary_words, ham_words.length, spam_words.length);
        return dictionary_words;
        }

    public String[] AllWords() {
        String[] dictionary_words = HamSpamWords();
        String[] new_words = NewEmailWords();
        String[] all_words = new String[dictionary_words.length + new_words.length];
        System.arraycopy(dictionary_words, 0, all_words, 0, dictionary_words.length);
        System.arraycopy(new_words, 0, all_words, dictionary_words.length, new_words.length);
        return all_words;
    }
    public String[] CommonWords() {
        String[] arr1 = HamDictionary();
        String[] arr2 = SpamDictionary();
        String[] arr3 = NewEmailWords();

        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < arr1.length; i++)
        {
            for (int j = 0; j < arr2.length; j++)
            {
                if(arr1[i].equals(arr2[j]))
                {
                    set.add(arr1[i]);
                }
            }
        }
        String[] arr = new String[set.size()];
        set.toArray(arr);
        HashSet<String> set2 = new HashSet<String>();
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr3.length; j++)
            {
                if(arr[i].equals(arr3[j]))
                {
                    set2.add(arr[i]);
                }
            }
        }
        String[] common_word = new String[set.size()];
        set2.toArray(common_word);
        return common_word;
    }
}