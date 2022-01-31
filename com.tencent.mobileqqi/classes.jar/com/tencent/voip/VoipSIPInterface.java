package com.tencent.voip;

import org.pjsip.pjsua.PjsuaAppCallback;
import org.pjsip.pjsua.pjsua;

public class VoipSIPInterface
{
  public int DelAccount(int paramInt)
  {
    return pjsua.pjsuaDelAccount(paramInt);
  }
  
  public int Destroy()
  {
    return pjsua.pjsuaDestroy();
  }
  
  public void Hangup() {}
  
  public int Init(int paramInt)
  {
    return pjsua.pjsuaInit(paramInt);
  }
  
  public int MakeCall(int paramInt, String paramString1, String paramString2)
  {
    return pjsua.pjsuaMakeCall(paramInt, paramString1, paramString2);
  }
  
  public int RegAccount(String paramString1, String paramString2, String paramString3)
  {
    return pjsua.pjsuaRegistAccount(paramString1, paramString2, paramString3);
  }
  
  public void SendDTMF(int paramInt, String paramString)
  {
    pjsua.pjsuaSendDTMF(paramInt, paramString);
  }
  
  public void SetCallBackObject(PjsuaAppCallback paramPjsuaAppCallback)
  {
    pjsua.setCallbackObject(paramPjsuaAppCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.voip.VoipSIPInterface
 * JD-Core Version:    0.7.0.1
 */