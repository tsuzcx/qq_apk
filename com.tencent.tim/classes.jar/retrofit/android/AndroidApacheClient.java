package retrofit.android;

import android.net.http.AndroidHttpClient;
import retrofit.client.ApacheClient;

public final class AndroidApacheClient
  extends ApacheClient
{
  public AndroidApacheClient()
  {
    super(AndroidHttpClient.newInstance("Retrofit"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.android.AndroidApacheClient
 * JD-Core Version:    0.7.0.1
 */