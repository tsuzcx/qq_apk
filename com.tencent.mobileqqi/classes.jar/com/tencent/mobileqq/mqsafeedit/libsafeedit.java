package com.tencent.mobileqq.mqsafeedit;

public class libsafeedit
{
  private static String mpwdText = "";
  
  public static byte[] byteSafeEditTextToMD5(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue()) {}
    do
    {
      return null;
      paramBoolean = getpwdText(paramBoolean.booleanValue());
    } while (paramBoolean == null);
    return MD5.toMD5Byte(StringUtil.toSemiAngleString(paramBoolean));
  }
  
  public static boolean checkPassLegal(String paramString)
  {
    return mpwdText.equals(paramString);
  }
  
  public static boolean checkPassLen()
  {
    return mpwdText.length() < 1;
  }
  
  public static void clearPassBuffer()
  {
    mpwdText = "";
  }
  
  public static void getLoginLegal(String paramString)
  {
    if ((paramString == null) || (paramString.toString().length() == 0)) {
      return;
    }
    mpwdText = paramString.toString();
  }
  
  public static String getpwdText(boolean paramBoolean)
  {
    if (paramBoolean) {
      return mpwdText;
    }
    return null;
  }
  
  public static String strSafeEditTextToMD5(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue()) {}
    do
    {
      return null;
      paramBoolean = getpwdText(paramBoolean.booleanValue());
    } while (paramBoolean == null);
    return MD5.toMD5(StringUtil.toSemiAngleString(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.libsafeedit
 * JD-Core Version:    0.7.0.1
 */