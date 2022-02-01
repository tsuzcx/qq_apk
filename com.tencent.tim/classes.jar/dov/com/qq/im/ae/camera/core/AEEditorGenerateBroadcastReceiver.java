package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import axiy;

public class AEEditorGenerateBroadcastReceiver
  extends BroadcastReceiver
{
  private a a;
  private boolean dtg;
  
  public AEEditorGenerateBroadcastReceiver(a parama)
  {
    this.a = parama;
  }
  
  private IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_ERROR");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_DOWNLOADING");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_READY");
    return localIntentFilter;
  }
  
  public void gE(@NonNull Context paramContext)
  {
    if ((!this.dtg) && (paramContext != null))
    {
      paramContext.registerReceiver(this, b());
      this.dtg = true;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      axiy.e("AEEditorGenerateBroadcastReceiver", "[onReceive] : action is null");
    }
    String str1;
    String str2;
    String str3;
    do
    {
      float f;
      int i;
      do
      {
        return;
        str1 = paramIntent.getStringExtra("generate_mission");
        str2 = paramIntent.getStringExtra("generate_path");
        str3 = paramIntent.getStringExtra("generate_thumb_ptah");
        f = paramIntent.getFloatExtra("generate_progress", 0.0F);
        i = paramIntent.getIntExtra("generate_thumb_ptah", 0);
        axiy.i("AEEditorGenerateBroadcastReceiver", "[onReceive] action :" + paramContext);
        axiy.i("AEEditorGenerateBroadcastReceiver", "[onReceive] mission :" + str1);
        axiy.i("AEEditorGenerateBroadcastReceiver", "[onReceive] path :" + str2);
        axiy.i("AEEditorGenerateBroadcastReceiver", "[onReceive] thumbPath :" + str3);
        axiy.i("AEEditorGenerateBroadcastReceiver", "[onReceive] progress :" + f);
        axiy.i("AEEditorGenerateBroadcastReceiver", "[onReceive] errorcode :" + i);
      } while (this.a == null);
      if ("AEEDITOR_GENERATE_STATUS_ERROR".equals(paramContext))
      {
        this.a.onAETavSessionExportError(str1, i);
        return;
      }
      if ("AEEDITOR_GENERATE_STATUS_DOWNLOADING".equals(paramContext))
      {
        this.a.onAETavSessionExporting(str1, f);
        return;
      }
    } while (!"AEEDITOR_GENERATE_STATUS_READY".equals(paramContext));
    this.a.bF(str1, str2, str3);
  }
  
  public static abstract interface a
  {
    public abstract void bF(String paramString1, String paramString2, String paramString3);
    
    public abstract void onAETavSessionExportError(String paramString, int paramInt);
    
    public abstract void onAETavSessionExporting(String paramString, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */