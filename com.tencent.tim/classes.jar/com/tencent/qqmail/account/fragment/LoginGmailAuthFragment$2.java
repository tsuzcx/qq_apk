package com.tencent.qqmail.account.fragment;

import com.tencent.moai.proxycat.ProxyCatManager;
import com.tencent.moai.proxycat.util.Logger;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProxy;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import java.net.InetAddress;
import java.util.ArrayList;

class LoginGmailAuthFragment$2
  implements Runnable
{
  LoginGmailAuthFragment$2(LoginGmailAuthFragment paramLoginGmailAuthFragment) {}
  
  public void run()
  {
    ProxyCatManager.getInstance().initLogger(new LoginGmailAuthFragment.2.1(this));
    Object localObject = QMProxyUtil.getGmailHttpProxy();
    String str = ((QMProxy)localObject).getProxyHost();
    ProxyCatManager.getInstance().setProxyName(((QMProxy)localObject).getProxyUserName());
    ProxyCatManager.getInstance().setProxyPwd(((QMProxy)localObject).getProxyPassword());
    ProxyCatManager.getInstance().setProxyPort(((QMProxy)localObject).getProxyPort());
    localObject = ProxyCatManager.getInstance().getIpsToForward();
    ((ArrayList)localObject).add("172.217.X");
    ((ArrayList)localObject).add("216.58.X");
    ((ArrayList)localObject).add("64.233.X");
    ((ArrayList)localObject).add("74.125.X");
    try
    {
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName("accounts.google.com");
      int j = arrayOfInetAddress.length;
      int i = 0;
      while (i < j)
      {
        InetAddress localInetAddress = arrayOfInetAddress[i];
        ((ArrayList)localObject).add(localInetAddress.getHostAddress());
        Logger.i("LoginGmailAuthFragment", "host: " + "accounts.google.com" + " ip: " + localInetAddress.getHostAddress());
        i += 1;
      }
      localObject = InetAddress.getByName(str);
      ProxyCatManager.getInstance().setProxyIp(((InetAddress)localObject).getHostAddress());
      Logger.i("LoginGmailAuthFragment", "proxyHost: " + str + " ip: " + ((InetAddress)localObject).getHostAddress());
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "LoginGmailAuthFragment", "get host ip error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.2
 * JD-Core Version:    0.7.0.1
 */