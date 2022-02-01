package com.tencent.feedback.eup;

public class SoFile
{
  public final String arch;
  public final String fileName;
  public final String sha1;
  
  public SoFile(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      throw new RuntimeException("SoFile args should not be null!");
    }
    this.fileName = paramString1;
    this.arch = paramString2;
    this.sha1 = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.SoFile
 * JD-Core Version:    0.7.0.1
 */