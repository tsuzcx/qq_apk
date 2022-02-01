package org.apache.commons.cli;

public class UnrecognizedOptionException
  extends ParseException
{
  private String option;
  
  public UnrecognizedOptionException(String paramString)
  {
    super(paramString);
  }
  
  public UnrecognizedOptionException(String paramString1, String paramString2)
  {
    this(paramString1);
    this.option = paramString2;
  }
  
  public String getOption()
  {
    return this.option;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.UnrecognizedOptionException
 * JD-Core Version:    0.7.0.1
 */