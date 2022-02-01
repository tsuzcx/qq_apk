package com.tencent.qqmail.account.helper;

import com.tencent.qqmail.account.fragment.LoginGmailAuthFragment;
import com.tencent.qqmail.account.fragment.LoginGmailWebFragment;
import com.tencent.qqmail.account.fragment.LoginTaskFragment;
import com.tencent.qqmail.model.mail.QMSettingManager;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

public class GmailLoginHelper
{
  private static AuthorizationException authorizationException;
  private static AuthorizationResponse authorizationResponse;
  private static boolean isAuth = QMSettingManager.sharedInstance().isEnableGmailAuth();
  
  public static AuthorizationException getAuthorizationException()
  {
    return authorizationException;
  }
  
  public static AuthorizationResponse getAuthorizationResponse()
  {
    return authorizationResponse;
  }
  
  public static void handleSchemaPush(String paramString)
  {
    QMSettingManager.sharedInstance().setEnableGmailAuth("open".equals(paramString));
  }
  
  public static LoginTaskFragment select()
  {
    if (isAuth) {
      return new LoginGmailAuthFragment();
    }
    return new LoginGmailWebFragment();
  }
  
  public static LoginTaskFragment select(String paramString)
  {
    if (isAuth) {
      return new LoginGmailAuthFragment(paramString);
    }
    return new LoginGmailWebFragment(paramString);
  }
  
  public static void setAuthorizationException(AuthorizationException paramAuthorizationException)
  {
    authorizationException = paramAuthorizationException;
  }
  
  public static void setAuthorizationResponse(AuthorizationResponse paramAuthorizationResponse)
  {
    authorizationResponse = paramAuthorizationResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.GmailLoginHelper
 * JD-Core Version:    0.7.0.1
 */