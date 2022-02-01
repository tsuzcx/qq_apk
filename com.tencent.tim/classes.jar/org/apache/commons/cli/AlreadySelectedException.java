package org.apache.commons.cli;

public class AlreadySelectedException
  extends ParseException
{
  private OptionGroup group;
  private Option option;
  
  public AlreadySelectedException(String paramString)
  {
    super(paramString);
  }
  
  public AlreadySelectedException(OptionGroup paramOptionGroup, Option paramOption)
  {
    this("The option '" + paramOption.getKey() + "' was specified but an option from this group " + "has already been selected: '" + paramOptionGroup.getSelected() + "'");
    this.group = paramOptionGroup;
    this.option = paramOption;
  }
  
  public Option getOption()
  {
    return this.option;
  }
  
  public OptionGroup getOptionGroup()
  {
    return this.group;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.AlreadySelectedException
 * JD-Core Version:    0.7.0.1
 */