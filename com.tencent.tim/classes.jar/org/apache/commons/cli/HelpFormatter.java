package org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter
{
  public static final String DEFAULT_ARG_NAME = "arg";
  public static final int DEFAULT_DESC_PAD = 3;
  public static final int DEFAULT_LEFT_PAD = 1;
  public static final String DEFAULT_LONG_OPT_PREFIX = "--";
  public static final String DEFAULT_OPT_PREFIX = "-";
  public static final String DEFAULT_SYNTAX_PREFIX = "usage: ";
  public static final int DEFAULT_WIDTH = 74;
  public String defaultArgName = "arg";
  public int defaultDescPad = 3;
  public int defaultLeftPad = 1;
  public String defaultLongOptPrefix = "--";
  public String defaultNewLine = System.getProperty("line.separator");
  public String defaultOptPrefix = "-";
  public String defaultSyntaxPrefix = "usage: ";
  public int defaultWidth = 74;
  protected Comparator optionComparator = new OptionComparator(null);
  
  private static void appendOption(StringBuffer paramStringBuffer, Option paramOption, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramStringBuffer.append("[");
    }
    if (paramOption.getOpt() != null) {
      paramStringBuffer.append("-").append(paramOption.getOpt());
    }
    for (;;)
    {
      if ((paramOption.hasArg()) && (paramOption.hasArgName())) {
        paramStringBuffer.append(" <").append(paramOption.getArgName()).append(">");
      }
      if (!paramBoolean) {
        paramStringBuffer.append("]");
      }
      return;
      paramStringBuffer.append("--").append(paramOption.getLongOpt());
    }
  }
  
  private void appendOptionGroup(StringBuffer paramStringBuffer, OptionGroup paramOptionGroup)
  {
    if (!paramOptionGroup.isRequired()) {
      paramStringBuffer.append("[");
    }
    Object localObject = new ArrayList(paramOptionGroup.getOptions());
    Collections.sort((List)localObject, getOptionComparator());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      appendOption(paramStringBuffer, (Option)((Iterator)localObject).next(), true);
      if (((Iterator)localObject).hasNext()) {
        paramStringBuffer.append(" | ");
      }
    }
    if (!paramOptionGroup.isRequired()) {
      paramStringBuffer.append("]");
    }
  }
  
  protected String createPadding(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append(' ');
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  protected int findWrapPos(String paramString, int paramInt1, int paramInt2)
  {
    int j = -1;
    int k = paramString.indexOf('\n', paramInt2);
    if (k != -1)
    {
      i = k;
      if (k <= paramInt1) {}
    }
    else
    {
      i = paramString.indexOf('\t', paramInt2);
      if ((i == -1) || (i > paramInt1)) {
        break label58;
      }
    }
    i += 1;
    label58:
    do
    {
      return i;
      i = j;
    } while (paramInt2 + paramInt1 >= paramString.length());
    int i = paramInt2 + paramInt1;
    while (i >= paramInt2)
    {
      j = paramString.charAt(i);
      if ((j == 32) || (j == 10) || (j == 13)) {
        break;
      }
      i -= 1;
    }
    if (i > paramInt2) {
      return i;
    }
    paramInt1 = paramInt2 + paramInt1;
    while (paramInt1 <= paramString.length())
    {
      paramInt2 = paramString.charAt(paramInt1);
      if ((paramInt2 == 32) || (paramInt2 == 10) || (paramInt2 == 13)) {
        break;
      }
      paramInt1 += 1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 == paramString.length()) {
      paramInt2 = -1;
    }
    return paramInt2;
  }
  
  public String getArgName()
  {
    return this.defaultArgName;
  }
  
  public int getDescPadding()
  {
    return this.defaultDescPad;
  }
  
  public int getLeftPadding()
  {
    return this.defaultLeftPad;
  }
  
  public String getLongOptPrefix()
  {
    return this.defaultLongOptPrefix;
  }
  
  public String getNewLine()
  {
    return this.defaultNewLine;
  }
  
  public String getOptPrefix()
  {
    return this.defaultOptPrefix;
  }
  
  public Comparator getOptionComparator()
  {
    return this.optionComparator;
  }
  
  public String getSyntaxPrefix()
  {
    return this.defaultSyntaxPrefix;
  }
  
  public int getWidth()
  {
    return this.defaultWidth;
  }
  
  public void printHelp(int paramInt, String paramString1, String paramString2, Options paramOptions, String paramString3)
  {
    printHelp(paramInt, paramString1, paramString2, paramOptions, paramString3, false);
  }
  
  public void printHelp(int paramInt, String paramString1, String paramString2, Options paramOptions, String paramString3, boolean paramBoolean)
  {
    PrintWriter localPrintWriter = new PrintWriter(System.out);
    printHelp(localPrintWriter, paramInt, paramString1, paramString2, paramOptions, this.defaultLeftPad, this.defaultDescPad, paramString3, paramBoolean);
    localPrintWriter.flush();
  }
  
  public void printHelp(PrintWriter paramPrintWriter, int paramInt1, String paramString1, String paramString2, Options paramOptions, int paramInt2, int paramInt3, String paramString3)
  {
    printHelp(paramPrintWriter, paramInt1, paramString1, paramString2, paramOptions, paramInt2, paramInt3, paramString3, false);
  }
  
  public void printHelp(PrintWriter paramPrintWriter, int paramInt1, String paramString1, String paramString2, Options paramOptions, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new IllegalArgumentException("cmdLineSyntax not provided");
    }
    if (paramBoolean) {
      printUsage(paramPrintWriter, paramInt1, paramString1, paramOptions);
    }
    for (;;)
    {
      if ((paramString2 != null) && (paramString2.trim().length() > 0)) {
        printWrapped(paramPrintWriter, paramInt1, paramString2);
      }
      printOptions(paramPrintWriter, paramInt1, paramOptions, paramInt2, paramInt3);
      if ((paramString3 != null) && (paramString3.trim().length() > 0)) {
        printWrapped(paramPrintWriter, paramInt1, paramString3);
      }
      return;
      printUsage(paramPrintWriter, paramInt1, paramString1);
    }
  }
  
  public void printHelp(String paramString1, String paramString2, Options paramOptions, String paramString3)
  {
    printHelp(paramString1, paramString2, paramOptions, paramString3, false);
  }
  
  public void printHelp(String paramString1, String paramString2, Options paramOptions, String paramString3, boolean paramBoolean)
  {
    printHelp(this.defaultWidth, paramString1, paramString2, paramOptions, paramString3, paramBoolean);
  }
  
  public void printHelp(String paramString, Options paramOptions)
  {
    printHelp(this.defaultWidth, paramString, null, paramOptions, null, false);
  }
  
  public void printHelp(String paramString, Options paramOptions, boolean paramBoolean)
  {
    printHelp(this.defaultWidth, paramString, null, paramOptions, null, paramBoolean);
  }
  
  public void printOptions(PrintWriter paramPrintWriter, int paramInt1, Options paramOptions, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    renderOptions(localStringBuffer, paramInt1, paramOptions, paramInt2, paramInt3);
    paramPrintWriter.println(localStringBuffer.toString());
  }
  
  public void printUsage(PrintWriter paramPrintWriter, int paramInt, String paramString)
  {
    printWrapped(paramPrintWriter, paramInt, paramString.indexOf(' ') + 1 + this.defaultSyntaxPrefix.length(), this.defaultSyntaxPrefix + paramString);
  }
  
  public void printUsage(PrintWriter paramPrintWriter, int paramInt, String paramString, Options paramOptions)
  {
    paramString = new StringBuffer(this.defaultSyntaxPrefix).append(paramString).append(" ");
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList(paramOptions.getOptions());
    Collections.sort((List)localObject, getOptionComparator());
    localObject = ((List)localObject).iterator();
    label159:
    while (((Iterator)localObject).hasNext())
    {
      Option localOption = (Option)((Iterator)localObject).next();
      OptionGroup localOptionGroup = paramOptions.getOptionGroup(localOption);
      if (localOptionGroup != null) {
        if (!localArrayList.contains(localOptionGroup))
        {
          localArrayList.add(localOptionGroup);
          appendOptionGroup(paramString, localOptionGroup);
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label159;
        }
        paramString.append(" ");
        break;
        appendOption(paramString, localOption, localOption.isRequired());
      }
    }
    printWrapped(paramPrintWriter, paramInt, paramString.toString().indexOf(' ') + 1, paramString.toString());
  }
  
  public void printWrapped(PrintWriter paramPrintWriter, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    renderWrappedText(localStringBuffer, paramInt1, paramInt2, paramString);
    paramPrintWriter.println(localStringBuffer.toString());
  }
  
  public void printWrapped(PrintWriter paramPrintWriter, int paramInt, String paramString)
  {
    printWrapped(paramPrintWriter, paramInt, 0, paramString);
  }
  
  protected StringBuffer renderOptions(StringBuffer paramStringBuffer, int paramInt1, Options paramOptions, int paramInt2, int paramInt3)
  {
    Object localObject1 = createPadding(paramInt2);
    String str = createPadding(paramInt3);
    ArrayList localArrayList = new ArrayList();
    paramOptions = paramOptions.helpOptions();
    Collections.sort(paramOptions, getOptionComparator());
    Object localObject2 = paramOptions.iterator();
    paramInt2 = 0;
    if (((Iterator)localObject2).hasNext())
    {
      Option localOption = (Option)((Iterator)localObject2).next();
      StringBuffer localStringBuffer = new StringBuffer(8);
      if (localOption.getOpt() == null)
      {
        localStringBuffer.append((String)localObject1).append("   " + this.defaultLongOptPrefix).append(localOption.getLongOpt());
        label132:
        if (localOption.hasArg())
        {
          if (!localOption.hasArgName()) {
            break label256;
          }
          localStringBuffer.append(" <").append(localOption.getArgName()).append(">");
        }
        label169:
        localArrayList.add(localStringBuffer);
        if (localStringBuffer.length() <= paramInt2) {
          break label267;
        }
        paramInt2 = localStringBuffer.length();
      }
      label256:
      label267:
      for (;;)
      {
        break;
        localStringBuffer.append((String)localObject1).append(this.defaultOptPrefix).append(localOption.getOpt());
        if (!localOption.hasLongOpt()) {
          break label132;
        }
        localStringBuffer.append(',').append(this.defaultLongOptPrefix).append(localOption.getLongOpt());
        break label132;
        localStringBuffer.append(' ');
        break label169;
      }
    }
    paramOptions = paramOptions.iterator();
    int i = 0;
    while (paramOptions.hasNext())
    {
      localObject1 = (Option)paramOptions.next();
      localObject2 = new StringBuffer(localArrayList.get(i).toString());
      if (((StringBuffer)localObject2).length() < paramInt2) {
        ((StringBuffer)localObject2).append(createPadding(paramInt2 - ((StringBuffer)localObject2).length()));
      }
      ((StringBuffer)localObject2).append(str);
      if (((Option)localObject1).getDescription() != null) {
        ((StringBuffer)localObject2).append(((Option)localObject1).getDescription());
      }
      renderWrappedText(paramStringBuffer, paramInt1, paramInt2 + paramInt3, ((StringBuffer)localObject2).toString());
      if (paramOptions.hasNext()) {
        paramStringBuffer.append(this.defaultNewLine);
      }
      i += 1;
    }
    return paramStringBuffer;
  }
  
  protected StringBuffer renderWrappedText(StringBuffer paramStringBuffer, int paramInt1, int paramInt2, String paramString)
  {
    int j = findWrapPos(paramString, paramInt1, 0);
    if (j == -1)
    {
      paramStringBuffer.append(rtrim(paramString));
      return paramStringBuffer;
    }
    paramStringBuffer.append(rtrim(paramString.substring(0, j))).append(this.defaultNewLine);
    int i = paramInt2;
    if (paramInt2 >= paramInt1) {
      i = 1;
    }
    String str = createPadding(i);
    paramInt2 = j;
    for (;;)
    {
      paramString = str + paramString.substring(paramInt2).trim();
      j = findWrapPos(paramString, paramInt1, 0);
      if (j == -1)
      {
        paramStringBuffer.append(paramString);
        return paramStringBuffer;
      }
      paramInt2 = j;
      if (paramString.length() > paramInt1)
      {
        paramInt2 = j;
        if (j == i - 1) {
          paramInt2 = paramInt1;
        }
      }
      paramStringBuffer.append(rtrim(paramString.substring(0, paramInt2))).append(this.defaultNewLine);
    }
  }
  
  protected String rtrim(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    int i = paramString.length();
    while ((i > 0) && (Character.isWhitespace(paramString.charAt(i - 1)))) {
      i -= 1;
    }
    return paramString.substring(0, i);
  }
  
  public void setArgName(String paramString)
  {
    this.defaultArgName = paramString;
  }
  
  public void setDescPadding(int paramInt)
  {
    this.defaultDescPad = paramInt;
  }
  
  public void setLeftPadding(int paramInt)
  {
    this.defaultLeftPad = paramInt;
  }
  
  public void setLongOptPrefix(String paramString)
  {
    this.defaultLongOptPrefix = paramString;
  }
  
  public void setNewLine(String paramString)
  {
    this.defaultNewLine = paramString;
  }
  
  public void setOptPrefix(String paramString)
  {
    this.defaultOptPrefix = paramString;
  }
  
  public void setOptionComparator(Comparator paramComparator)
  {
    if (paramComparator == null)
    {
      this.optionComparator = new OptionComparator(null);
      return;
    }
    this.optionComparator = paramComparator;
  }
  
  public void setSyntaxPrefix(String paramString)
  {
    this.defaultSyntaxPrefix = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.defaultWidth = paramInt;
  }
  
  static class OptionComparator
    implements Comparator
  {
    private OptionComparator() {}
    
    OptionComparator(HelpFormatter.1 param1)
    {
      this();
    }
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (Option)paramObject1;
      paramObject2 = (Option)paramObject2;
      return paramObject1.getKey().compareToIgnoreCase(paramObject2.getKey());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.HelpFormatter
 * JD-Core Version:    0.7.0.1
 */