package com.tencent.apkupdate.logic.data;

public class ApkUpdateDetail
{
  public static final int UpdateMethod_ByPatch = 4;
  public static final int UpdateMethod_GenPatch = 3;
  public static final int UpdateMethod_NoUpdate = 1;
  public static final int UpdateMethod_NoneRecord = 0;
  public static final int UpdateMethod_Normal = 2;
  public String fileMd5;
  public String newFeature;
  public int newapksize;
  public String packageName;
  public int patchsize;
  public String sigMd5;
  public int updatemethod;
  public String url;
  public int versioncode;
  public String versionname;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.apkupdate.logic.data.ApkUpdateDetail
 * JD-Core Version:    0.7.0.1
 */