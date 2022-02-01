import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.armap.wealthgod.ARMapThreadStubReceiver;
import com.tencent.qphone.base.util.QLog;

public class rwc
  implements Handler.Callback
{
  private rwc.a a;
  private BroadcastReceiver mBroadcastReceiver;
  private Context mContext;
  private String mFrom;
  private Handler mUiHandler;
  
  public rwc(Context paramContext)
  {
    this.mContext = paramContext;
    this.mUiHandler = new Handler(this);
    bxb();
  }
  
  private void bxb()
  {
    if (this.mBroadcastReceiver == null)
    {
      this.mBroadcastReceiver = new rwd(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
      this.mContext.registerReceiver(this.mBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void bxc()
  {
    if (this.mBroadcastReceiver != null)
    {
      this.mContext.unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
  }
  
  public void a(String paramString, long paramLong, rwc.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("callUpToolProc from=%s", new Object[] { paramString }));
    }
    this.a = parama;
    this.mFrom = paramString;
    parama = new Intent(this.mContext, ARMapThreadStubReceiver.class);
    parama.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD");
    parama.putExtra("from", paramString);
    this.mContext.sendBroadcast(parama);
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeMessages(108);
      this.mUiHandler.sendEmptyMessageDelayed(108, paramLong);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.a != null) {
        this.a.aup();
      }
    }
  }
  
  public void onDestroy()
  {
    bxc();
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeCallbacksAndMessages(null);
      this.mUiHandler = null;
    }
    this.mContext = null;
    this.a = null;
  }
  
  public static abstract interface a
  {
    public abstract void aup();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwc
 * JD-Core Version:    0.7.0.1
 */