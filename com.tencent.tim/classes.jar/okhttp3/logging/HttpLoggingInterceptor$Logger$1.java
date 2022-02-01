package okhttp3.logging;

import okhttp3.internal.platform.Platform;

class HttpLoggingInterceptor$Logger$1
  implements HttpLoggingInterceptor.Logger
{
  public void log(String paramString)
  {
    Platform.get().log(4, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.logging.HttpLoggingInterceptor.Logger.1
 * JD-Core Version:    0.7.0.1
 */