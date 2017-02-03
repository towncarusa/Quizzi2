import com.example.android.quizzi2.R;

/**
 * Created by Camilo on 1/28/2017.
 */


public class  QuizBook {

    public static String[]  questions = new String []{
            "The Earth is the third planet from the Sun.",
            "An Atom is made of electrons and water.",
            "There are two Oxygen atoms and one Hydrogen atom in water.",
            "Leaves keep plants in the ground.",
            "Elephants are Mammals.",
            "We can see UltraViolet rays with our eyes.",
            "Marbles are a toy.",
            "The Sun is the fifth planet in the Solar System.",
            "Bees help us grow food.",
            "Baseball was invented in ancient Egypt."
    };

    public static int[]  images = new int[]{
            R.drawable.img_1earth,R.drawable.img_2atom,R.drawable.img_3h2o,R.drawable.img_4leaf,R.drawable.img_5elephant,
            R.drawable.img_6eye,R.drawable.img_7marbles,R.drawable.img_8sun,R.drawable.img_9bee,R.drawable.img_10,
    };

    public static boolean[]    answers = new boolean[]{

            true,false,true,false,true,false,
            true,false,true,false
    };

}
