package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class FaceDetectForThirdPartyManager
  implements Manager
{
  private ConcurrentHashMap<Integer, AppConf> fG;
  private QQAppInterface mApp;
  
  public FaceDetectForThirdPartyManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.fG = new ConcurrentHashMap(1);
  }
  
  public void a(int paramInt, AppConf paramAppConf)
  {
    this.fG.put(Integer.valueOf(paramInt), paramAppConf);
  }
  
  public void onDestroy()
  {
    this.fG.clear();
  }
  
  public static class AppConf
    implements Serializable
  {
    public int[] actionReq;
    public final List<FaceDetectForThirdPartyManager.AppWordings> al;
    public final String appName;
    public String colorSequence;
    public String debug;
    public String errMsg;
    public final int mode;
    public int ret;
    public String session;
    
    public AppConf(String paramString, List<FaceDetectForThirdPartyManager.AppWordings> paramList, int paramInt)
    {
      this.appName = paramString;
      this.al = new ArrayList(3);
      this.al.addAll(paramList);
      this.mode = paramInt;
    }
    
    public String toString()
    {
      return "appName=" + this.appName + " mode=" + this.mode + " colorSe=" + this.colorSequence + " session=" + this.session + " ret=" + this.ret + " errMsg=" + this.errMsg + " debug=" + this.debug;
    }
  }
  
  public static class AppWordings
    implements Serializable
  {
    public final int serviceType;
    public final String text;
    
    public AppWordings(int paramInt, String paramString)
    {
      this.serviceType = paramInt;
      this.text = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager
 * JD-Core Version:    0.7.0.1
 */