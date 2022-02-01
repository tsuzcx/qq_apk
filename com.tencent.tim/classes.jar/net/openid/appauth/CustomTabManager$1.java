package net.openid.appauth;

import android.content.ComponentName;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

class CustomTabManager$1
  extends CustomTabsServiceConnection
{
  CustomTabManager$1(CustomTabManager paramCustomTabManager) {}
  
  private void setClient(@Nullable CustomTabsClient paramCustomTabsClient)
  {
    CustomTabManager.access$000(this.this$0).set(paramCustomTabsClient);
    CustomTabManager.access$100(this.this$0).countDown();
  }
  
  public void onCustomTabsServiceConnected(ComponentName paramComponentName, CustomTabsClient paramCustomTabsClient)
  {
    Logger.debug("CustomTabsService is connected", new Object[0]);
    paramCustomTabsClient.warmup(0L);
    setClient(paramCustomTabsClient);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Logger.debug("CustomTabsService is disconnected", new Object[0]);
    setClient(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.CustomTabManager.1
 * JD-Core Version:    0.7.0.1
 */