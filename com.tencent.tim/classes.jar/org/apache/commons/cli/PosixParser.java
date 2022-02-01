package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PosixParser
  extends Parser
{
  private Option currentOption;
  private boolean eatTheRest;
  private Options options;
  private List tokens = new ArrayList();
  
  private void gobble(Iterator paramIterator)
  {
    if (this.eatTheRest) {
      while (paramIterator.hasNext()) {
        this.tokens.add(paramIterator.next());
      }
    }
  }
  
  private void init()
  {
    this.eatTheRest = false;
    this.tokens.clear();
  }
  
  private void processNonOptionToken(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.currentOption == null) || (!this.currentOption.hasArg())))
    {
      this.eatTheRest = true;
      this.tokens.add("--");
    }
    this.tokens.add(paramString);
  }
  
  private void processOptionToken(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.options.hasOption(paramString))) {
      this.eatTheRest = true;
    }
    if (this.options.hasOption(paramString)) {
      this.currentOption = this.options.getOption(paramString);
    }
    this.tokens.add(paramString);
  }
  
  protected void burstToken(String paramString, boolean paramBoolean)
  {
    int i = 1;
    for (;;)
    {
      if (i < paramString.length())
      {
        String str = String.valueOf(paramString.charAt(i));
        if (this.options.hasOption(str))
        {
          this.tokens.add("-" + str);
          this.currentOption = this.options.getOption(str);
          if ((!this.currentOption.hasArg()) || (paramString.length() == i + 1)) {
            break label140;
          }
          this.tokens.add(paramString.substring(i + 1));
        }
      }
      else
      {
        return;
      }
      if (paramBoolean)
      {
        processNonOptionToken(paramString.substring(i), true);
        return;
      }
      this.tokens.add(paramString);
      return;
      label140:
      i += 1;
    }
  }
  
  protected String[] flatten(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
  {
    init();
    this.options = paramOptions;
    Iterator localIterator = Arrays.asList(paramArrayOfString).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i;
      if (str.startsWith("--"))
      {
        i = str.indexOf('=');
        if (i == -1)
        {
          paramArrayOfString = str;
          label70:
          if (paramOptions.hasOption(paramArrayOfString)) {
            break label106;
          }
          processNonOptionToken(str, paramBoolean);
        }
      }
      for (;;)
      {
        gobble(localIterator);
        break;
        paramArrayOfString = str.substring(0, i);
        break label70;
        label106:
        this.currentOption = paramOptions.getOption(paramArrayOfString);
        this.tokens.add(paramArrayOfString);
        if (i != -1)
        {
          this.tokens.add(str.substring(i + 1));
          continue;
          if ("-".equals(str)) {
            this.tokens.add(str);
          } else if (str.startsWith("-"))
          {
            if ((str.length() == 2) || (paramOptions.hasOption(str))) {
              processOptionToken(str, paramBoolean);
            } else {
              burstToken(str, paramBoolean);
            }
          }
          else {
            processNonOptionToken(str, paramBoolean);
          }
        }
      }
    }
    return (String[])this.tokens.toArray(new String[this.tokens.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.PosixParser
 * JD-Core Version:    0.7.0.1
 */