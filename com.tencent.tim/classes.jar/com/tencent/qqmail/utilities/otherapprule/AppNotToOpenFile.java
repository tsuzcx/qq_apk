package com.tencent.qqmail.utilities.otherapprule;

import com.tencent.qqmail.trd.guava.Joiner;
import java.util.ArrayList;

public class AppNotToOpenFile
{
  public static final String LINE_SEP = ";";
  private ArrayList<String> allowMimeList;
  private String packageName;
  
  public ArrayList<String> getAllowMimeList()
  {
    return this.allowMimeList;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public void setAllowMimeList(ArrayList<String> paramArrayList)
  {
    this.allowMimeList = paramArrayList;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public String toString()
  {
    String str = "";
    if (this.allowMimeList != null) {
      str = Joiner.on(";").skipNulls().join(this.allowMimeList);
    }
    return String.format("%s,%s", new Object[] { this.packageName, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.otherapprule.AppNotToOpenFile
 * JD-Core Version:    0.7.0.1
 */