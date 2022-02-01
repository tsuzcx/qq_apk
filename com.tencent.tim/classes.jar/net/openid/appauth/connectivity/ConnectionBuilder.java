package net.openid.appauth.connectivity;

import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;

public abstract interface ConnectionBuilder
{
  @NonNull
  public abstract HttpURLConnection openConnection(@NonNull Uri paramUri)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.connectivity.ConnectionBuilder
 * JD-Core Version:    0.7.0.1
 */