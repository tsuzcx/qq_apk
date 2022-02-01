package net.openid.appauth.connectivity;

import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.Preconditions;

public final class DefaultConnectionBuilder
  implements ConnectionBuilder
{
  private static final int CONNECTION_TIMEOUT_MS = (int)TimeUnit.SECONDS.toMillis(15L);
  private static final String HTTPS_SCHEME = "https";
  public static final DefaultConnectionBuilder INSTANCE = new DefaultConnectionBuilder();
  private static final int READ_TIMEOUT_MS = (int)TimeUnit.SECONDS.toMillis(10L);
  
  @NonNull
  public HttpURLConnection openConnection(@NonNull Uri paramUri)
    throws IOException
  {
    Preconditions.checkNotNull(paramUri, "url must not be null");
    Preconditions.checkArgument("https".equals(paramUri.getScheme()), "only https connections are permitted");
    paramUri = (HttpURLConnection)new URL(paramUri.toString()).openConnection();
    paramUri.setConnectTimeout(CONNECTION_TIMEOUT_MS);
    paramUri.setReadTimeout(READ_TIMEOUT_MS);
    paramUri.setInstanceFollowRedirects(false);
    return paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.connectivity.DefaultConnectionBuilder
 * JD-Core Version:    0.7.0.1
 */