package cooperation.qqreader.shadow;

import android.content.Context;
import android.os.Bundle;
import avnq;
import avnr;
import avoc;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;

public class ReaderShadowImpl$1
  implements Runnable
{
  public ReaderShadowImpl$1(avnq paramavnq, Context paramContext, String paramString1, String paramString2, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback) {}
  
  public void run()
  {
    PluginManager localPluginManager = this.this$0.getPluginManager(this.val$context, this.val$uin, this.val$appId);
    avoc.u("ReaderShadowImpl", "enter: " + this.azL + ", frameVersion = " + "5");
    if (localPluginManager != null)
    {
      long l = System.currentTimeMillis();
      this.val$bundle.putString("hostuid", this.val$uin);
      this.val$bundle.putString("hostVersion", "3.4.4");
      this.val$bundle.putInt("key_frame_version", Integer.valueOf("5").intValue());
      this.val$bundle.putLong("entryTime", l);
      localPluginManager.enter(this.val$context, this.azL, this.val$bundle, new avnr(this, l));
      return;
    }
    avoc.e("ReaderShadowImpl", "[enter] pluginManager is null !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderShadowImpl.1
 * JD-Core Version:    0.7.0.1
 */