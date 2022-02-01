import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class rjr
{
  private rjr.a a;
  private boolean aIt;
  protected BroadcastReceiver ao = new rjs(this);
  private Context mContext;
  private Handler mUiHandler;
  
  public rjr(Context paramContext, rjr.a parama, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mUiHandler = paramHandler;
    this.a = parama;
    paramContext = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    paramContext.addAction("action_music_start");
    paramContext.addAction("action_music_refresh_list");
    this.mContext.registerReceiver(this.ao, paramContext);
  }
  
  private void aT(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "songMid not exist");
      }
      sendMessage(7, this.mContext.getResources().getString(2131700434));
      return;
    }
    if (!aqiw.isNetSupport(this.mContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "Net not Support");
      }
      sendMessage(7, this.mContext.getResources().getString(2131700439));
      return;
    }
    if (aqiw.isMobileNetWork(this.mContext)) {
      sendMessage(7, this.mContext.getResources().getString(2131700438));
    }
    ((QIMMusicConfigManager)axov.a(2)).a(paramString, this.aIt, new rjt(this));
  }
  
  public void destory()
  {
    this.mContext.unregisterReceiver(this.ao);
  }
  
  public void sendMessage(int paramInt, Object paramObject)
  {
    paramObject = this.mUiHandler.obtainMessage(paramInt, paramObject);
    this.mUiHandler.sendMessage(paramObject);
  }
  
  public static abstract interface a
  {
    public abstract void buZ();
    
    public abstract void bva();
    
    public abstract void c(rkc paramrkc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjr
 * JD-Core Version:    0.7.0.1
 */