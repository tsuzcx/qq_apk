package com.tencent.qqmail.account;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import net.openid.appauth.connectivity.ConnectionBuilder;

class LoginManager$10
  implements ConnectionBuilder
{
  LoginManager$10(LoginManager paramLoginManager) {}
  
  @NonNull
  public HttpURLConnection openConnection(@NonNull Uri paramUri)
    throws IOException
  {
    paramUri = paramUri.toString();
    return QMHttpUtil.openConnection(QMProxyUtil.getGmailHttpProxy(), paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.10
 * JD-Core Version:    0.7.0.1
 */