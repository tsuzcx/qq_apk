package org.pjsip.pjsua;

public class pjsuaJNI
{
  static {}
  
  public static final native void PjsuaAppCallback_change_ownership(PjsuaAppCallback paramPjsuaAppCallback, long paramLong, boolean paramBoolean);
  
  public static final native void PjsuaAppCallback_director_connect(PjsuaAppCallback paramPjsuaAppCallback, long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public static final native void PjsuaAppCallback_onCallState(long paramLong, PjsuaAppCallback paramPjsuaAppCallback, int paramInt1, int paramInt2);
  
  public static final native void PjsuaAppCallback_onCallStateSwigExplicitPjsuaAppCallback(long paramLong, PjsuaAppCallback paramPjsuaAppCallback, int paramInt1, int paramInt2);
  
  public static final native void PjsuaAppCallback_onRegState(long paramLong, PjsuaAppCallback paramPjsuaAppCallback, int paramInt1, int paramInt2, int paramInt3);
  
  public static final native void PjsuaAppCallback_onRegStateSwigExplicitPjsuaAppCallback(long paramLong, PjsuaAppCallback paramPjsuaAppCallback, int paramInt1, int paramInt2, int paramInt3);
  
  public static final native void PjsuaAppCallback_onRequestLog(long paramLong, PjsuaAppCallback paramPjsuaAppCallback, String paramString);
  
  public static final native void PjsuaAppCallback_onRequestLogSwigExplicitPjsuaAppCallback(long paramLong, PjsuaAppCallback paramPjsuaAppCallback, String paramString);
  
  public static void SwigDirector_PjsuaAppCallback_onCallState(PjsuaAppCallback paramPjsuaAppCallback, int paramInt1, int paramInt2)
  {
    paramPjsuaAppCallback.onCallState(paramInt1, paramInt2);
  }
  
  public static void SwigDirector_PjsuaAppCallback_onRegState(PjsuaAppCallback paramPjsuaAppCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    paramPjsuaAppCallback.onRegState(paramInt1, paramInt2, paramInt3);
  }
  
  public static void SwigDirector_PjsuaAppCallback_onRequestLog(PjsuaAppCallback paramPjsuaAppCallback, String paramString)
  {
    paramPjsuaAppCallback.onRequestLog(paramString);
  }
  
  public static final native void delete_PjsuaAppCallback(long paramLong);
  
  public static final native long new_PjsuaAppCallback();
  
  public static final native int pjsuaDelAccount(int paramInt);
  
  public static final native int pjsuaDestroy();
  
  public static final native void pjsuaHangup();
  
  public static final native int pjsuaInit(int paramInt);
  
  public static final native int pjsuaMakeCall(int paramInt, String paramString1, String paramString2);
  
  public static final native int pjsuaMute(boolean paramBoolean);
  
  public static final native int pjsuaRegistAccount(String paramString1, String paramString2, String paramString3);
  
  public static final native int pjsuaSendDTMF(int paramInt, String paramString);
  
  public static final native void setCallbackObject(long paramLong, PjsuaAppCallback paramPjsuaAppCallback);
  
  private static final native void swig_module_init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     org.pjsip.pjsua.pjsuaJNI
 * JD-Core Version:    0.7.0.1
 */