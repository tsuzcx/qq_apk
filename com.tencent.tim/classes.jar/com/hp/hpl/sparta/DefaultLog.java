package com.hp.hpl.sparta;

import java.io.PrintStream;

class DefaultLog
  implements ParseLog
{
  public void error(String paramString1, String paramString2, int paramInt)
  {
    System.err.println(paramString2 + "(" + paramInt + "): " + paramString1 + " (ERROR)");
  }
  
  public void note(String paramString1, String paramString2, int paramInt)
  {
    System.out.println(paramString2 + "(" + paramInt + "): " + paramString1 + " (NOTE)");
  }
  
  public void warning(String paramString1, String paramString2, int paramInt)
  {
    System.out.println(paramString2 + "(" + paramInt + "): " + paramString1 + " (WARNING)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.DefaultLog
 * JD-Core Version:    0.7.0.1
 */