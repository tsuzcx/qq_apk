package com.tencent.mobileqq.troop.data;

public class TroopFileInfo$FileStatus
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  
  public static int a(String paramString)
  {
    int i1 = -1;
    if (paramString.equals("SCANNING")) {
      i1 = 0;
    }
    do
    {
      return i1;
      if (paramString.equals("UPLOADING")) {
        return 1;
      }
      if (paramString.equals("UPLOAD_SUSPEND")) {
        return 2;
      }
      if (paramString.equals("UPLOAD_INTERRUPT")) {
        return 3;
      }
      if (paramString.equals("FORWARDING")) {
        return 4;
      }
      if (paramString.equals("FORWARD_FAILED")) {
        return 5;
      }
      if (paramString.equals("UPLOADED")) {
        return 6;
      }
      if (paramString.equals("NOT_DOWNLOAD")) {
        return 7;
      }
      if (paramString.equals("DOWNLOADING")) {
        return 8;
      }
      if (paramString.equals("DOWNLOAD_SUSPEND")) {
        return 9;
      }
      if (paramString.equals("DOWNLOAD_INTERRUPT")) {
        return 10;
      }
      if (paramString.equals("DOWNLOADED")) {
        return 11;
      }
      if (paramString.equals("DELETED")) {
        return 12;
      }
    } while (!paramString.equals("OTHER_UPLOADING"));
    return 13;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "SCANNING";
    case 1: 
      return "UPLOADING";
    case 2: 
      return "UPLOAD_SUSPEND";
    case 3: 
      return "UPLOAD_INTERRUPT";
    case 4: 
      return "FORWARDING";
    case 5: 
      return "FORWARD_FAILED";
    case 6: 
      return "UPLOADED";
    case 7: 
      return "NOT_DOWNLOAD";
    case 8: 
      return "DOWNLOADING";
    case 9: 
      return "DOWNLOAD_SUSPEND";
    case 10: 
      return "DOWNLOAD_INTERRUPT";
    case 11: 
      return "DOWNLOADED";
    case 12: 
      return "DELETED";
    }
    return "OTHER_UPLOADING";
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus
 * JD-Core Version:    0.7.0.1
 */