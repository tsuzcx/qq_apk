package com.tencent.qqmail.utilities;

public class QMIndexCounter
{
  private static QMIndexCounter _instance = new QMIndexCounter();
  private Integer index = Integer.valueOf(0);
  
  public static QMIndexCounter shareInstance()
  {
    return _instance;
  }
  
  public Integer getFileIndex()
  {
    Integer localInteger = Integer.valueOf(this.index.intValue() + 1);
    this.index = localInteger;
    return localInteger;
  }
  
  public Integer getIndex()
  {
    return this.index;
  }
  
  public void setIndex(Integer paramInteger)
  {
    this.index = paramInteger;
  }
  
  public void setIndexByName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    i = str.lastIndexOf('_');
    if (i > 0)
    {
      str = str.substring(i + 1);
      paramString = null;
    }
    try
    {
      i = Integer.parseInt(str);
      paramString = Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      label51:
      break label51;
    }
    if ((paramString != null) && (paramString.intValue() > this.index.intValue())) {
      this.index = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMIndexCounter
 * JD-Core Version:    0.7.0.1
 */