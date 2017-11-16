import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SpellChecker
{
  private LinkedList []ht; 
  private DataReader dictionaryReader;
  private DataReader documentReader;
  private int dictSize;

  private int getAddr(String word)
  {
    int addr = 0;

    word = word.toLowerCase();
    for (int index=0; index < word.length(); index++)
      addr += Character.getNumericValue(word.charAt(index));

    return addr % ht.length;
  }


  private int searchWord (String word)
  {
    
    int count=0;
    String tryWord;

    try
    {
      Float.valueOf(word);
      return 0;
    }
    catch (NumberFormatException e)
    { } 
    tryWord = word;
    if (ht[getAddr(tryWord)].contains(tryWord))
      return ht[getAddr(tryWord)].indexOf(tryWord) + 1;
    else
        count += (ht[getAddr(tryWord)].size());

    if (word.endsWith("ing"))
    {
      
      tryWord = word.substring(0, word.length() - 3);  
      if (ht[getAddr(tryWord)].contains(tryWord))
        return count + ht[getAddr(tryWord)].indexOf(tryWord) + 1;
      else
        count +=ht[getAddr(tryWord)].size();

     
      tryWord = word.substring(0, word.length() - 3) + "e";  
      if (ht[getAddr(tryWord)].contains(tryWord))
        return count + ht[getAddr(tryWord)].indexOf(tryWord) + 1;
      else
        count +=ht[getAddr(tryWord)].size();
    }

    if (word.endsWith("ies"))
    {
    
      tryWord = word.substring(0, word.length() - 3) + "y";
      if (ht[getAddr(tryWord)].contains(tryWord))
        return count + ht[getAddr(tryWord)].indexOf(tryWord) + 1;
      else
        count +=ht[getAddr(tryWord)].size();
    }


    if ( word.endsWith("es") || word.endsWith("ly") || word.endsWith("ed"))
    {
     
      tryWord = word.substring(0, word.length() - 2);  
      if (ht[getAddr(tryWord)].contains(tryWord))
        return count + ht[getAddr(tryWord)].indexOf(tryWord) + 1;
      else
        count +=ht[getAddr(tryWord)].size();
    }

    if (word.endsWith("es") || word.endsWith("ed"))
    {
      
      tryWord = word.substring(0, word.length() - 1);  
      if (ht[getAddr(tryWord)].contains(tryWord))
        return count + ht[getAddr(tryWord)].indexOf(tryWord) + 1;
      else
        count +=ht[getAddr(tryWord)].size();
    }

    if (word.endsWith("s"))
    {
     
      tryWord = word.substring(0, word.length() - 1);  
      if (ht[getAddr(tryWord)].contains(tryWord))
        return count + ht[getAddr(tryWord)].indexOf(tryWord) + 1;
      else
        count +=ht[getAddr(tryWord)].size();
    }

    return -1*count;
  }

  public SpellChecker (String dictionaryFile, 
                       String documentFile,
                       int tableSize)
  {
    try
    {
      dictSize = 0;
      dictionaryReader = new DataReader (dictionaryFile);
      documentReader = new DataReader (documentFile);
    }
    catch (Exception e)
    {
      
      System.out.println (e);
      System.exit (-1);
    }

    ht = new LinkedList[tableSize];
    for (int listNumber=0; listNumber < tableSize; 
         ht[listNumber++] = new LinkedList());

    try
    {
      while (true)
      {
        String word = dictionaryReader.readWord().toLowerCase();
        ht[getAddr(word)].add(word);
        dictSize++;
      }
    }
    catch (EOFException e)
    { }

    catch (Exception e)
    { 
     
      System.out.println (e);
      System.exit (-2);
    } 
  }

  public void printHistogramAndAverage()
  {
   
  }

  public void spellCheck()
  {
    String line = ""; 
    int lineNumber = 0;
    long searchCount = 0;
    long wordCount = 0;

    try
    {
      while (true)
      {
        line = documentReader.readLine();
        lineNumber++;

        StringTokenizer lineTokenizer = 
          new StringTokenizer (line, " -\t\n\r\f,.?\":;!(){}/+*=|[]<>%\\");
             
        while (lineTokenizer.hasMoreTokens()) 
        {
          String word = lineTokenizer.nextToken();
          wordCount++;

          int thisCount = searchWord(word.toLowerCase());
          searchCount += (thisCount > 0 ? thisCount : -1*thisCount);

          if (thisCount < 0)
          {
            System.out.println (line); 
            System.out.println (word + "\n"); 
          }
        }
      }
    }
    catch (IOException e)
    { } 
    catch (Exception e)
    {
     
      System.out.println (e);
      System.exit (-3);
    }

    System.out.println ("Average list search was " + 
                        (float)searchCount/(float)wordCount);
  }

  
    
  public static void main (String []args)
  {
    if(args.length<3)
    {
      System.out.println("usage: java SpellChecker [dictionary] [document]
                          [table size]");
      System.exit(-4);
    }

    SpellChecker ht = new SpellChecker (args[0], args[1], 
                                        Integer.parseInt(args[2]));
    System.out.println(ht);
    ht.printHistogramAndAverage();
    ht.spellCheck();
  }
}