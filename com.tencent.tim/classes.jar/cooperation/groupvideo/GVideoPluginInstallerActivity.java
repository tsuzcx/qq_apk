package cooperation.groupvideo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.format.Time;
import android.widget.TextView;
import avfe;
import avff;
import avfh;
import avfw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;

public class GVideoPluginInstallerActivity
  extends IphoneTitleBarActivity
{
  final int MSG_QUIT = 4;
  public final String TAG = getClass().getSimpleName();
  avfw a;
  private final OnPluginInstallListener b = new avff(this);
  final String cKo = "TroopVideoPluginInstaller";
  Handler ea;
  final int ewQ = 1;
  final int ewR = 2;
  final int ewS = 3;
  private final Runnable iA = new GVideoPluginInstallerActivity.3(this);
  public final Handler mMainThreadHandler = new avfe(this, Looper.getMainLooper());
  public TextView mTextView;
  
  private void ezG()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      return;
    }
    if (this.leftView != null) {
      localIntent.putExtra("leftViewString", this.leftView.getText().toString());
    }
    avfh.a(this.app, this, localIntent, 1);
  }
  
  private void ezH()
  {
    this.mTextView.setText(getString(2131700022));
    this.mMainThreadHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  private String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    super.setContentView(2131560873);
    super.setTitle(getString(2131700024));
    if ((this.leftView != null) && (getIntent() != null)) {
      this.leftView.setText(getIntent().getExtras().getString("leftViewText"));
    }
    this.mTextView = ((TextView)findViewById(2131379419));
    this.mTextView.setText(getString(2131700023));
    this.a = ((avfw)this.app.getManager(27));
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mMainThreadHandler.removeCallbacksAndMessages(null);
    if (this.ea != null)
    {
      this.ea.removeCallbacksAndMessages(null);
      Looper localLooper = this.ea.getLooper();
      if (localLooper != null) {
        localLooper.quit();
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((!paramBoolean) || (this.a == null)) {
      return;
    }
    if (this.a.isPlugininstalled("group_video_plugin.apk"))
    {
      this.mMainThreadHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    if (avfh.cG(getApplicationContext()))
    {
      localObject = new Intent("com.tencent.process.exit");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("com.tencent.mobileqq:groupvideo");
      ((Intent)localObject).putStringArrayListExtra("procNameList", localArrayList);
      ((Intent)localObject).putExtra("verify", getLocalVerify(localArrayList, false));
      sendBroadcast((Intent)localObject);
      this.mMainThreadHandler.sendEmptyMessageDelayed(3, 200L);
      return;
    }
    Object localObject = new HandlerThread("TroopVideoPluginInstaller", 10);
    ((HandlerThread)localObject).start();
    this.ea = new Handler(((HandlerThread)localObject).getLooper());
    this.ea.postDelayed(this.iA, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.groupvideo.GVideoPluginInstallerActivity
 * JD-Core Version:    0.7.0.1
 */