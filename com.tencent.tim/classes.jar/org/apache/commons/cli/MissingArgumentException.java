package org.apache.commons.cli;

public class MissingArgumentException
  extends ParseException
{
  private Option option;
  
  public MissingArgumentException(String paramString)
  {
    super(paramString);
  }
  
  public MissingArgumentException(Option paramOption)
  {
    this("Missing argument for option: " + paramOption.getKey());
    this.option = paramOption;
  }
  
  public Option getOption()
  {
    return this.option;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.MissingArgumentException
 * JD-Core Version:    0.7.0.1
 */