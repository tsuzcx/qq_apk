package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import axiy;

public class AEEditorOrderBroadcastReceiver
  extends BroadcastReceiver
{
  private a a;
  private boolean dtg;
  
  public AEEditorOrderBroadcastReceiver(a parama)
  {
    this.a = parama;
  }
  
  private IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_ORDER_CANCEL");
    localIntentFilter.addAction("AEEDITOR_ORDER_SAVE");
    localIntentFilter.addAction("AEEDITOR_ORDER_REMOVE_MISSION");
    return localIntentFilter;
  }
  
  public void gE(Context paramContext)
  {
    if ((!this.dtg) && (paramContext != null))
    {
      paramContext.registerReceiver(this, b());
      this.dtg = true;
    }
  }
  
  public void gF(Context paramContext)
  {
    if ((this.dtg) && (paramContext != null))
    {
      paramContext.unregisterReceiver(this);
      this.dtg = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("generate_mission");
    axiy.i("AEEditorOrderBroadcastReceiver", "[onReceive] action :" + paramContext);
    axiy.i("AEEditorOrderBroadcastReceiver", "[onReceive] mission :" + paramIntent);
    if ("AEEDITOR_ORDER_CANCEL".equals(paramContext)) {
      this.a.ach(paramIntent);
    }
    while (!"AEEDITOR_ORDER_REMOVE_MISSION".equals(paramContext)) {
      return;
    }
    this.a.aci(paramIntent);
  }
  
  public static abstract interface a
  {
    public abstract void ach(String paramString);
    
    public abstract void aci(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */