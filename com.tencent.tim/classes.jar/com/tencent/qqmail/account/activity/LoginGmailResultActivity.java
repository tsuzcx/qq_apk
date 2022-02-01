package com.tencent.qqmail.account.activity;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.helper.GmailLoginHelper;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

public class LoginGmailResultActivity
  extends BaseActivityEx
{
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), LoginGmailResultActivity.class);
  }
  
  public void initDataSource()
  {
    AuthorizationResponse localAuthorizationResponse = AuthorizationResponse.fromIntent(getActivity().getIntent());
    AuthorizationException localAuthorizationException = AuthorizationException.fromIntent(getActivity().getIntent());
    GmailLoginHelper.setAuthorizationResponse(localAuthorizationResponse);
    GmailLoginHelper.setAuthorizationException(localAuthorizationException);
  }
  
  public void initDom() {}
  
  public void initUI() {}
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render()
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.activity.LoginGmailResultActivity
 * JD-Core Version:    0.7.0.1
 */