import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.ArrayList;

public class aiae
{
  private static volatile aiae a;
  private INetInfoHandler b = new aiaf(this);
  private Context mContext;
  private boolean mEnable;
  private ArrayList<aiae.a> mListeners = new ArrayList();
  BroadcastReceiver mReceiver = new aiag(this);
  
  private aiae(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    KR(true);
  }
  
  public static aiae a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aiae(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void KR(boolean paramBoolean)
  {
    if (this.mEnable == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      localIntentFilter.addAction("VolumeBtnDown");
      this.mContext.registerReceiver(this.mReceiver, localIntentFilter);
      AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this.b);
      return;
    }
    this.mContext.unregisterReceiver(this.mReceiver);
    this.mListeners.clear();
    AppNetConnInfo.unregisterNetInfoHandler(this.b);
  }
  
  public void a(aiae.a parama)
  {
    if ((parama != null) && (this.mListeners.contains(parama))) {
      this.mListeners.remove(parama);
    }
  }
  
  public boolean aoF()
  {
    if (this.mListeners == null) {}
    while (this.mListeners.size() <= 0) {
      return false;
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void KO(boolean paramBoolean);
    
    public abstract void KP(boolean paramBoolean);
    
    public abstract void PJ(int paramInt);
    
    public abstract void drI();
    
    public abstract void drJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiae
 * JD-Core Version:    0.7.0.1
 */