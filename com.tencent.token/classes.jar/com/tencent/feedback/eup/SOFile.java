package com.tencent.feedback.eup;

public class SOFile
{
  public final String arch;
  public final String fileName;
  public final String sha1;
  
  public SOFile(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      this.fileName = paramString1;
      this.arch = paramString2;
      this.sha1 = paramString3;
      return;
    }
    throw new RuntimeException("SOFile args should not be null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.SOFile
 * JD-Core Version:    0.7.0.1
 */