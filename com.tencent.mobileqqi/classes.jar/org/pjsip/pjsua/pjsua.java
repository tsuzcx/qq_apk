package org.pjsip.pjsua;

public class pjsua
{
  public static int pjsuaDelAccount(int paramInt)
  {
    return pjsuaJNI.pjsuaDelAccount(paramInt);
  }
  
  public static int pjsuaDestroy()
  {
    return pjsuaJNI.pjsuaDestroy();
  }
  
  public static void pjsuaHangup() {}
  
  public static int pjsuaInit(int paramInt)
  {
    return pjsuaJNI.pjsuaInit(paramInt);
  }
  
  public static int pjsuaMakeCall(int paramInt, String paramString1, String paramString2)
  {
    return pjsuaJNI.pjsuaMakeCall(paramInt, paramString1, paramString2);
  }
  
  public static int pjsuaMute(boolean paramBoolean)
  {
    return pjsuaJNI.pjsuaMute(paramBoolean);
  }
  
  public static int pjsuaRegistAccount(String paramString1, String paramString2, String paramString3)
  {
    return pjsuaJNI.pjsuaRegistAccount(paramString1, paramString2, paramString3);
  }
  
  public static int pjsuaSendDTMF(int paramInt, String paramString)
  {
    return pjsuaJNI.pjsuaSendDTMF(paramInt, paramString);
  }
  
  public static void setCallbackObject(PjsuaAppCallback paramPjsuaAppCallback)
  {
    pjsuaJNI.setCallbackObject(PjsuaAppCallback.getCPtr(paramPjsuaAppCallback), paramPjsuaAppCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     org.pjsip.pjsua.pjsua
 * JD-Core Version:    0.7.0.1
 */