package com.tencent.qqmail.trd.guava;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Splitter
{
  private boolean mOmitEmpty = false;
  private String mOn;
  private boolean mTrimResult = false;
  
  private Splitter(String paramString)
  {
    this.mOn = paramString;
  }
  
  public static Splitter on(String paramString)
  {
    return new Splitter(paramString);
  }
  
  public Splitter omitEmptyStrings()
  {
    this.mOmitEmpty = true;
    return this;
  }
  
  public List<String> split(String paramString)
  {
    paramString = StringUtils.split(paramString, this.mOn);
    ArrayList localArrayList = Lists.newArrayList();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString[i];
      if (((!this.mOmitEmpty) && (!this.mTrimResult)) || (!StringUtils.isEmpty(localCharSequence))) {
        localArrayList.add(localCharSequence);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public Splitter trimResults()
  {
    this.mTrimResult = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.guava.Splitter
 * JD-Core Version:    0.7.0.1
 */