package com.tencent.qqmail.account;

import androidx.annotation.Nullable;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService.TokenResponseCallback;
import net.openid.appauth.TokenResponse;

class LoginManager$11
  implements AuthorizationService.TokenResponseCallback
{
  LoginManager$11(LoginManager paramLoginManager, AuthorizationResponse paramAuthorizationResponse) {}
  
  public void onTokenRequestCompleted(@Nullable TokenResponse paramTokenResponse, @Nullable AuthorizationException paramAuthorizationException)
  {
    if (paramTokenResponse != null)
    {
      paramAuthorizationException = paramTokenResponse.accessToken;
      String str1 = paramTokenResponse.refreshToken;
      String str2 = paramTokenResponse.tokenType;
      long l = paramTokenResponse.accessTokenExpirationTime.longValue();
      paramTokenResponse = paramTokenResponse.idToken;
      QMLog.log(4, "LoginManager", "fetch token success  accessToken: " + paramAuthorizationException + " refreshToken: " + str1 + " tokenType: " + str2 + " expiresIn: " + l + " idToken: " + paramTokenResponse);
      QMWatcherCenter.triggerGMailGetTokenSuccess(this.val$response.authorizationCode, paramAuthorizationException, str2, l, str1, paramTokenResponse);
      return;
    }
    QMLog.log(6, "LoginManager", "fetch token error " + paramAuthorizationException);
    QMWatcherCenter.triggerGMailGetTokenError(this.val$response.authorizationCode, new QMNetworkError(5, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.11
 * JD-Core Version:    0.7.0.1
 */