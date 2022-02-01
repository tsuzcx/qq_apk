package com.tencent.qqmail.utilities.otherapprule;

public class AppNotNotify
{
  private String packageName;
  private String packageVersion;
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getPackageVersion()
  {
    return this.packageVersion;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setPackageVersion(String paramString)
  {
    this.packageVersion = paramString;
  }
  
  public String toString()
  {
    return String.format("%s,%s", new Object[] { this.packageName, this.packageVersion });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.otherapprule.AppNotNotify
 * JD-Core Version:    0.7.0.1
 */