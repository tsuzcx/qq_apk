package org.apache.commons.cli;

public final class OptionBuilder
{
  private static String argName;
  private static String description;
  private static OptionBuilder instance = new OptionBuilder();
  private static String longopt;
  private static int numberOfArgs = -1;
  private static boolean optionalArg;
  private static boolean required;
  private static Object type;
  private static char valuesep;
  
  public static Option create()
    throws IllegalArgumentException
  {
    if (longopt == null)
    {
      reset();
      throw new IllegalArgumentException("must specify longopt");
    }
    return create(null);
  }
  
  public static Option create(char paramChar)
    throws IllegalArgumentException
  {
    return create(String.valueOf(paramChar));
  }
  
  public static Option create(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramString = new Option(paramString, description);
      paramString.setLongOpt(longopt);
      paramString.setRequired(required);
      paramString.setOptionalArg(optionalArg);
      paramString.setArgs(numberOfArgs);
      paramString.setType(type);
      paramString.setValueSeparator(valuesep);
      paramString.setArgName(argName);
      return paramString;
    }
    finally
    {
      reset();
    }
  }
  
  public static OptionBuilder hasArg()
  {
    numberOfArgs = 1;
    return instance;
  }
  
  public static OptionBuilder hasArg(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      numberOfArgs = i;
      return instance;
    }
  }
  
  public static OptionBuilder hasArgs()
  {
    numberOfArgs = -2;
    return instance;
  }
  
  public static OptionBuilder hasArgs(int paramInt)
  {
    numberOfArgs = paramInt;
    return instance;
  }
  
  public static OptionBuilder hasOptionalArg()
  {
    numberOfArgs = 1;
    optionalArg = true;
    return instance;
  }
  
  public static OptionBuilder hasOptionalArgs()
  {
    numberOfArgs = -2;
    optionalArg = true;
    return instance;
  }
  
  public static OptionBuilder hasOptionalArgs(int paramInt)
  {
    numberOfArgs = paramInt;
    optionalArg = true;
    return instance;
  }
  
  public static OptionBuilder isRequired()
  {
    required = true;
    return instance;
  }
  
  public static OptionBuilder isRequired(boolean paramBoolean)
  {
    required = paramBoolean;
    return instance;
  }
  
  private static void reset()
  {
    description = null;
    argName = "arg";
    longopt = null;
    type = null;
    required = false;
    numberOfArgs = -1;
    optionalArg = false;
    valuesep = '\000';
  }
  
  public static OptionBuilder withArgName(String paramString)
  {
    argName = paramString;
    return instance;
  }
  
  public static OptionBuilder withDescription(String paramString)
  {
    description = paramString;
    return instance;
  }
  
  public static OptionBuilder withLongOpt(String paramString)
  {
    longopt = paramString;
    return instance;
  }
  
  public static OptionBuilder withType(Object paramObject)
  {
    type = paramObject;
    return instance;
  }
  
  public static OptionBuilder withValueSeparator()
  {
    valuesep = '=';
    return instance;
  }
  
  public static OptionBuilder withValueSeparator(char paramChar)
  {
    valuesep = paramChar;
    return instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.OptionBuilder
 * JD-Core Version:    0.7.0.1
 */