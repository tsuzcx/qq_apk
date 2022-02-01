package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Option
  implements Serializable, Cloneable
{
  public static final int UNINITIALIZED = -1;
  public static final int UNLIMITED_VALUES = -2;
  private static final long serialVersionUID = 1L;
  private String argName = "arg";
  private String description;
  private String longOpt;
  private int numberOfArgs = -1;
  private String opt;
  private boolean optionalArg;
  private boolean required;
  private Object type;
  private List values = new ArrayList();
  private char valuesep;
  
  public Option(String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    this(paramString1, null, false, paramString2);
  }
  
  public Option(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
    throws IllegalArgumentException
  {
    OptionValidator.validateOption(paramString1);
    this.opt = paramString1;
    this.longOpt = paramString2;
    if (paramBoolean) {
      this.numberOfArgs = 1;
    }
    this.description = paramString3;
  }
  
  public Option(String paramString1, boolean paramBoolean, String paramString2)
    throws IllegalArgumentException
  {
    this(paramString1, null, paramBoolean, paramString2);
  }
  
  private void add(String paramString)
  {
    if ((this.numberOfArgs > 0) && (this.values.size() > this.numberOfArgs - 1)) {
      throw new RuntimeException("Cannot add value, list full.");
    }
    this.values.add(paramString);
  }
  
  private boolean hasNoValues()
  {
    return this.values.isEmpty();
  }
  
  private void processValue(String paramString)
  {
    String str = paramString;
    int j;
    if (hasValueSeparator()) {
      j = getValueSeparator();
    }
    for (int i = paramString.indexOf(j);; i = paramString.indexOf(j))
    {
      str = paramString;
      if (i != -1)
      {
        if (this.values.size() == this.numberOfArgs - 1) {
          str = paramString;
        }
      }
      else
      {
        add(str);
        return;
      }
      add(paramString.substring(0, i));
      paramString = paramString.substring(i + 1);
    }
  }
  
  public boolean addValue(String paramString)
  {
    throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
  }
  
  void addValueForProcessing(String paramString)
  {
    switch (this.numberOfArgs)
    {
    default: 
      processValue(paramString);
      return;
    }
    throw new RuntimeException("NO_ARGS_ALLOWED");
  }
  
  void clearValues()
  {
    this.values.clear();
  }
  
  public Object clone()
  {
    try
    {
      Option localOption = (Option)super.clone();
      localOption.values = new ArrayList(this.values);
      return localOption;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException("A CloneNotSupportedException was thrown: " + localCloneNotSupportedException.getMessage());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Option)paramObject;
      if (this.opt != null)
      {
        if (this.opt.equals(paramObject.opt)) {}
      }
      else {
        while (paramObject.opt != null) {
          return false;
        }
      }
      if (this.longOpt == null) {
        break;
      }
    } while (this.longOpt.equals(paramObject.longOpt));
    for (;;)
    {
      return false;
      if (paramObject.longOpt == null) {
        break;
      }
    }
  }
  
  public String getArgName()
  {
    return this.argName;
  }
  
  public int getArgs()
  {
    return this.numberOfArgs;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public int getId()
  {
    return getKey().charAt(0);
  }
  
  String getKey()
  {
    if (this.opt == null) {
      return this.longOpt;
    }
    return this.opt;
  }
  
  public String getLongOpt()
  {
    return this.longOpt;
  }
  
  public String getOpt()
  {
    return this.opt;
  }
  
  public Object getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    if (hasNoValues()) {
      return null;
    }
    return (String)this.values.get(0);
  }
  
  public String getValue(int paramInt)
    throws IndexOutOfBoundsException
  {
    if (hasNoValues()) {
      return null;
    }
    return (String)this.values.get(paramInt);
  }
  
  public String getValue(String paramString)
  {
    String str = getValue();
    if (str != null) {
      paramString = str;
    }
    return paramString;
  }
  
  public char getValueSeparator()
  {
    return this.valuesep;
  }
  
  public String[] getValues()
  {
    if (hasNoValues()) {
      return null;
    }
    return (String[])this.values.toArray(new String[this.values.size()]);
  }
  
  public List getValuesList()
  {
    return this.values;
  }
  
  public boolean hasArg()
  {
    return (this.numberOfArgs > 0) || (this.numberOfArgs == -2);
  }
  
  public boolean hasArgName()
  {
    return (this.argName != null) && (this.argName.length() > 0);
  }
  
  public boolean hasArgs()
  {
    return (this.numberOfArgs > 1) || (this.numberOfArgs == -2);
  }
  
  public boolean hasLongOpt()
  {
    return this.longOpt != null;
  }
  
  public boolean hasOptionalArg()
  {
    return this.optionalArg;
  }
  
  public boolean hasValueSeparator()
  {
    return this.valuesep > 0;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.opt != null) {}
    for (int i = this.opt.hashCode();; i = 0)
    {
      if (this.longOpt != null) {
        j = this.longOpt.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public boolean isRequired()
  {
    return this.required;
  }
  
  public void setArgName(String paramString)
  {
    this.argName = paramString;
  }
  
  public void setArgs(int paramInt)
  {
    this.numberOfArgs = paramInt;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setLongOpt(String paramString)
  {
    this.longOpt = paramString;
  }
  
  public void setOptionalArg(boolean paramBoolean)
  {
    this.optionalArg = paramBoolean;
  }
  
  public void setRequired(boolean paramBoolean)
  {
    this.required = paramBoolean;
  }
  
  public void setType(Object paramObject)
  {
    this.type = paramObject;
  }
  
  public void setValueSeparator(char paramChar)
  {
    this.valuesep = paramChar;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer().append("[ option: ");
    localStringBuffer.append(this.opt);
    if (this.longOpt != null) {
      localStringBuffer.append(" ").append(this.longOpt);
    }
    localStringBuffer.append(" ");
    if (hasArgs()) {
      localStringBuffer.append("[ARG...]");
    }
    for (;;)
    {
      localStringBuffer.append(" :: ").append(this.description);
      if (this.type != null) {
        localStringBuffer.append(" :: ").append(this.type);
      }
      localStringBuffer.append(" ]");
      return localStringBuffer.toString();
      if (hasArg()) {
        localStringBuffer.append(" [ARG]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.Option
 * JD-Core Version:    0.7.0.1
 */