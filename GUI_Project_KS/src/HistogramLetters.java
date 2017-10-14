/**
 * Created by Gor on 7/13/2017.
 */

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class HistogramLetters {
    private int m_n;
    private Scanner input;
    private ArrayList<Double> chart_prob_results;
    private ArrayList<Character> chart_letter_results;

    public HistogramLetters(int occurrence)
    {
        this.m_n = occurrence;

        chart_letter_results = new ArrayList<>();
        chart_prob_results = new ArrayList<>();

        for (int i = 0; i < m_n; i++)
        {
            chart_letter_results.add('a');
        }

        for (int j = 0; j < m_n; j++)
        {
            chart_prob_results.add(0.0);
        }
    }

    public void openFile()
    {
        try
        {
            input = new Scanner(Paths.get("Emma.txt"));
        }

        catch (IOException Except)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public void readFile()
    {
        int min_index = 0;
        for (char ch = 'a'; ch <= 'z'; ch++)
        {
            double total_count = 0;
            double letter_count = 0;

            openFile();

            while (input.hasNext())
            {
                String str = input.next();
                for (int count = 0; count < str.length(); count++)
                {
                    char c = str.charAt(count);
                    if ( (Character.isLetter(c))) {total_count++;}
                    if ( (Character.toLowerCase(c) == ch) || (Character.toUpperCase(c) == ch) ){letter_count ++;}
                }
            }
            double prob = letter_count / total_count;
            findMinIndex();
             if (prob > chart_prob_results.get(findMinIndex()))
             {
                 chart_letter_results.set(findMinIndex(), ch);
                 chart_prob_results.set(findMinIndex(), Math.round(prob * 10000.0)/10000.0);
             }
        }
        closeFile();
    }


    public void closeFile()
    {
        if (input != null)
        {
            input.close();
        }
    }

    public String getLetterIndex(int index){
        return String.valueOf(chart_letter_results.get(index));
    }

    public double getProb(int index){return chart_prob_results.get(index);}

    public int getSize(){return chart_prob_results.size();}

    public int findMinIndex()
    {
        int min_index = 0;  //INITIALIZE THE MIN_INDEX FOR COMPARISON
        for (int i = 1; i < chart_prob_results.size(); i++)
        {
            if (chart_prob_results.get(i) < chart_prob_results.get(min_index)){min_index = i;}
        }
        return min_index;
    }

}

