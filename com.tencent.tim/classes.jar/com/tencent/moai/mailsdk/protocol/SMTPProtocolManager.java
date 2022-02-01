package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.callback.LogoutCallBack;
import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.smtp.SMTPHandler;
import com.tencent.moai.mailsdk.task.TaskPool;
import com.tencent.moai.mailsdk.task.TaskPool.TaskRunnable;
import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SMTPProtocolManager
{
  private static final String TAG = "SMTPProtocolManager";
  private static final String TASK_TAG = "SMTPTask-";
  private static SMTPProtocolManager instance = new SMTPProtocolManager();
  private final Map<String, TaskPool> userTaskPool = new HashMap();
  
  private void clearTaskPool(Profile paramProfile, boolean paramBoolean)
  {
    synchronized (this.userTaskPool)
    {
      TaskPool localTaskPool = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
      if (localTaskPool != null)
      {
        if (paramBoolean)
        {
          localTaskPool.shutDownNow();
          this.userTaskPool.remove(getKey(paramProfile));
        }
      }
      else {
        return;
      }
      localTaskPool.shutDown();
    }
  }
  
  public static SMTPProtocolManager getInstance()
  {
    return instance;
  }
  
  private String getKey(Profile paramProfile)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(paramProfile.getSmtpName());
    localStringBuilder.append("^");
    if (paramProfile.isOauth()) {}
    for (String str = paramProfile.getAccessToken();; str = paramProfile.getSmtpPassword())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("^");
      localStringBuilder.append(paramProfile.getSmtpServer());
      localStringBuilder.append("^");
      localStringBuilder.append(paramProfile.getSmtpPort());
      localStringBuilder.append("^");
      localStringBuilder.append(paramProfile.getSmtpSSLPort());
      return localStringBuilder.toString();
    }
  }
  
  private TaskPool getTaskPoolByUser(Profile paramProfile)
  {
    synchronized (this.userTaskPool)
    {
      String str = getKey(paramProfile);
      TaskPool localTaskPool2 = (TaskPool)this.userTaskPool.get(str);
      TaskPool localTaskPool1 = localTaskPool2;
      if (localTaskPool2 == null)
      {
        localTaskPool1 = new TaskPool(paramProfile, 1, 4, 4);
        this.userTaskPool.put(str, localTaskPool1);
      }
      return localTaskPool1;
    }
  }
  
  private void handleAuthError(Profile paramProfile, MessageException paramMessageException)
  {
    synchronized (this.userTaskPool)
    {
      Object localObject = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
      if (localObject != null)
      {
        localObject = ((TaskPool)localObject).shutDownNow();
        this.userTaskPool.remove(getKey(paramProfile));
        paramProfile = ((List)localObject).iterator();
        while (paramProfile.hasNext())
        {
          localObject = (Runnable)paramProfile.next();
          if ((localObject instanceof TaskPool.TaskRunnable)) {
            ((TaskPool.TaskRunnable)localObject).getCallback().onError(paramMessageException);
          }
        }
      }
    }
  }
  
  private boolean isAuthError(MessageException paramMessageException)
  {
    return (paramMessageException.getResultCode() == 4) || (paramMessageException.getResultCode() == 8);
  }
  
  public void initProfile(Profile paramProfile)
  {
    getTaskPoolByUser(paramProfile);
  }
  
  public void login(Profile paramProfile, LoginCallBack paramLoginCallBack)
  {
    int i = 0;
    Object localObject = new StringBuilder().append("login name:").append(paramProfile.getSmtpName()).append(",");
    if (paramProfile.getSmtpPassword() != null) {
      i = paramProfile.getSmtpPassword().hashCode();
    }
    Logger.log(4, "SMTPProtocolManager", i);
    localObject = new SMTPHandler(paramProfile);
    try
    {
      ((SMTPHandler)localObject).setTag("ExtraHandler");
      ((SMTPHandler)localObject).openConnection();
      ((SMTPHandler)localObject).auth(true);
      Logger.log(4, "SMTPProtocolManager", "login success name:" + paramProfile.getSmtpName());
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginSuccess(paramProfile);
      }
      return;
    }
    catch (MessageException localMessageException)
    {
      Logger.log(6, "SMTPProtocolManager", "login error:" + localMessageException.getResultCode() + ":" + localMessageException.getDetailCode() + ":" + localMessageException.getDetailMessage());
      Logger.log(6, "SMTPProtocolManager", Log.getStackTraceString(localMessageException));
      clearTaskPool(paramProfile, false);
      if (localMessageException.getResultCode() == 4)
      {
        i = LoginUtility.getProtocolLoginError(localMessageException.getDetailMessage());
        String str = paramProfile.getSmtpName();
        if ((i != 3) && (str.contains("@")) && (!MailParser.canUseFullName(str)))
        {
          paramProfile.setSmtpName(MailParser.getUserName(str));
          login(paramProfile, paramLoginCallBack);
          return;
        }
      }
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginError(localMessageException.getResultCode(), localMessageException.getDetailCode(), localMessageException.getDetailMessage());
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.log(6, "SMTPProtocolManager", "login error:" + Log.getStackTraceString(localException));
      clearTaskPool(paramProfile, false);
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginError(1, 200001, localException.getMessage());
      }
      return;
    }
    finally
    {
      ((SMTPHandler)localObject).closeConnection();
    }
  }
  
  public void logout(Profile paramProfile, LogoutCallBack paramLogoutCallBack)
  {
    Logger.log(4, "SMTPProtocolManager", "logout name:" + paramProfile.getSmtpName());
    clearTaskPool(paramProfile, true);
    if (paramLogoutCallBack != null) {
      paramLogoutCallBack.onSuccess(paramProfile);
    }
  }
  
  public void sendMail(Profile paramProfile, Mail paramMail, SendMailCallBack paramSendMailCallBack)
  {
    Logger.log(4, "SMTPProtocolManager", "send mail:" + paramMail.getSubject() + ", utc:" + paramMail.getUtc());
    getTaskPoolByUser(paramProfile).post(new SMTPProtocolManager.1(this, "SMTPTask-sendMail", paramMail, paramSendMailCallBack), new SMTPProtocolManager.2(this, paramProfile, paramSendMailCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.SMTPProtocolManager
 * JD-Core Version:    0.7.0.1
 */