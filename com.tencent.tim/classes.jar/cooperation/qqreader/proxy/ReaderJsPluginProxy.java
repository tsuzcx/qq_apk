package cooperation.qqreader.proxy;

import android.os.Handler;

public abstract interface ReaderJsPluginProxy
{
  public abstract boolean call(String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  public abstract void onCreate();
  
  public abstract void onDestroy();
  
  public abstract void setHandler(Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.proxy.ReaderJsPluginProxy
 * JD-Core Version:    0.7.0.1
 */