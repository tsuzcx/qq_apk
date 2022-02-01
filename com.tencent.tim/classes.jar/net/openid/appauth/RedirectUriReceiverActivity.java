package net.openid.appauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class RedirectUriReceiverActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startActivity(AuthorizationManagementActivity.createResponseHandlingIntent(this, getIntent().getData()));
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.RedirectUriReceiverActivity
 * JD-Core Version:    0.7.0.1
 */