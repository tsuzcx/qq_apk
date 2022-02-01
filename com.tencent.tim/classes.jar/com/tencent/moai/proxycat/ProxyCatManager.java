package com.tencent.moai.proxycat;

import android.content.Context;
import com.tencent.moai.proxycat.util.Logger;
import com.tencent.moai.proxycat.util.LoggerDelegate;
import java.util.ArrayList;

public class ProxyCatManager
{
  private static Context context;
  private static ProxyCatManager instance = new ProxyCatManager();
  private String forwardHost = "accounts.google.com";
  private ArrayList<String> ipsToForward = new ArrayList();
  private String proxyHost = "gp.mail.qq.com";
  private String proxyIp;
  private String proxyName = "secondaccount";
  private int proxyPort = 443;
  private String proxyPwd = "secondpassword@123";
  
  public static ProxyCatManager getInstance()
  {
    return instance;
  }
  
  public Context getContext()
  {
    return context;
  }
  
  public String getForwardHost()
  {
    return this.forwardHost;
  }
  
  public ArrayList<String> getIpsToForward()
  {
    return this.ipsToForward;
  }
  
  public String getProxyHost()
  {
    return this.proxyHost;
  }
  
  public String getProxyIp()
  {
    return this.proxyIp;
  }
  
  public String getProxyName()
  {
    return this.proxyName;
  }
  
  public int getProxyPort()
  {
    return this.proxyPort;
  }
  
  public String getProxyPwd()
  {
    return this.proxyPwd;
  }
  
  public void init(Context paramContext)
  {
    context = paramContext;
  }
  
  public void initLogger(LoggerDelegate paramLoggerDelegate)
  {
    Logger.setDelegate(paramLoggerDelegate);
  }
  
  public void setForwardHost(String paramString)
  {
    this.forwardHost = paramString;
  }
  
  public void setIpsToForward(ArrayList<String> paramArrayList)
  {
    this.ipsToForward = paramArrayList;
  }
  
  public void setProxyHost(String paramString)
  {
    this.proxyHost = paramString;
  }
  
  public void setProxyIp(String paramString)
  {
    this.proxyIp = paramString;
  }
  
  public void setProxyName(String paramString)
  {
    this.proxyName = paramString;
  }
  
  public void setProxyPort(int paramInt)
  {
    this.proxyPort = paramInt;
  }
  
  public void setProxyPwd(String paramString)
  {
    this.proxyPwd = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.ProxyCatManager
 * JD-Core Version:    0.7.0.1
 */