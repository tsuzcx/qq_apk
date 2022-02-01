package net.openid.appauth;

import android.support.annotation.Nullable;

class AuthState$1
  implements AuthorizationService.TokenResponseCallback
{
  AuthState$1(AuthState paramAuthState, AuthState.AuthStateAction paramAuthStateAction) {}
  
  public void onTokenRequestCompleted(@Nullable TokenResponse paramTokenResponse, @Nullable AuthorizationException paramAuthorizationException)
  {
    this.this$0.update(paramTokenResponse, paramAuthorizationException);
    if (paramAuthorizationException == null)
    {
      AuthState.access$002(this.this$0, false);
      this.val$action.execute(this.this$0.getAccessToken(), this.this$0.getIdToken(), null);
      return;
    }
    this.val$action.execute(null, null, paramAuthorizationException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthState.1
 * JD-Core Version:    0.7.0.1
 */