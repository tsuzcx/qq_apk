package org.apache.commons.cli;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CommandLine
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List args = new LinkedList();
  private List options = new ArrayList();
  
  private Option resolveOption(String paramString)
  {
    paramString = Util.stripLeadingHyphens(paramString);
    Iterator localIterator = this.options.iterator();
    while (localIterator.hasNext())
    {
      Option localOption = (Option)localIterator.next();
      if (paramString.equals(localOption.getOpt())) {
        return localOption;
      }
      if (paramString.equals(localOption.getLongOpt())) {
        return localOption;
      }
    }
    return null;
  }
  
  void addArg(String paramString)
  {
    this.args.add(paramString);
  }
  
  void addOption(Option paramOption)
  {
    this.options.add(paramOption);
  }
  
  public List getArgList()
  {
    return this.args;
  }
  
  public String[] getArgs()
  {
    String[] arrayOfString = new String[this.args.size()];
    this.args.toArray(arrayOfString);
    return arrayOfString;
  }
  
  public Object getOptionObject(char paramChar)
  {
    return getOptionObject(String.valueOf(paramChar));
  }
  
  public Object getOptionObject(String paramString)
  {
    try
    {
      Object localObject = getParsedOptionValue(paramString);
      return localObject;
    }
    catch (ParseException localParseException)
    {
      System.err.println("Exception found converting " + paramString + " to desired type: " + localParseException.getMessage());
    }
    return null;
  }
  
  public Properties getOptionProperties(String paramString)
  {
    Properties localProperties = new Properties();
    Iterator localIterator = this.options.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Option)localIterator.next();
      if ((paramString.equals(((Option)localObject).getOpt())) || (paramString.equals(((Option)localObject).getLongOpt())))
      {
        localObject = ((Option)localObject).getValuesList();
        if (((List)localObject).size() >= 2) {
          localProperties.put(((List)localObject).get(0), ((List)localObject).get(1));
        } else if (((List)localObject).size() == 1) {
          localProperties.put(((List)localObject).get(0), "true");
        }
      }
    }
    return localProperties;
  }
  
  public String getOptionValue(char paramChar)
  {
    return getOptionValue(String.valueOf(paramChar));
  }
  
  public String getOptionValue(char paramChar, String paramString)
  {
    return getOptionValue(String.valueOf(paramChar), paramString);
  }
  
  public String getOptionValue(String paramString)
  {
    paramString = getOptionValues(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString[0];
  }
  
  public String getOptionValue(String paramString1, String paramString2)
  {
    paramString1 = getOptionValue(paramString1);
    if (paramString1 != null) {
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public String[] getOptionValues(char paramChar)
  {
    return getOptionValues(String.valueOf(paramChar));
  }
  
  public String[] getOptionValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.options.iterator();
    while (localIterator.hasNext())
    {
      Option localOption = (Option)localIterator.next();
      if ((paramString.equals(localOption.getOpt())) || (paramString.equals(localOption.getLongOpt()))) {
        localArrayList.addAll(localOption.getValuesList());
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public Option[] getOptions()
  {
    List localList = this.options;
    return (Option[])localList.toArray(new Option[localList.size()]);
  }
  
  public Object getParsedOptionValue(String paramString)
    throws ParseException
  {
    String str = getOptionValue(paramString);
    paramString = resolveOption(paramString);
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.getType();
    } while (str == null);
    return TypeHandler.createValue(str, paramString);
  }
  
  public boolean hasOption(char paramChar)
  {
    return hasOption(String.valueOf(paramChar));
  }
  
  public boolean hasOption(String paramString)
  {
    return this.options.contains(resolveOption(paramString));
  }
  
  public Iterator iterator()
  {
    return this.options.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.CommandLine
 * JD-Core Version:    0.7.0.1
 */