import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;

public abstract class jey
{
  public final VideoInviteActivity a;
  protected long mBegin = 0L;
  protected int mScreenHeight;
  protected int mScreenWidth;
  protected long mSeq;
  protected int oR = 0;
  protected long oY;
  
  public jey(VideoInviteActivity paramVideoInviteActivity)
  {
    this.a = paramVideoInviteActivity;
    this.mSeq = AudioHelper.hG();
    this.mScreenHeight = jll.getScreenWidth(this.a);
    this.mScreenHeight = jll.getScreenHeight(this.a);
  }
  
  public void BtnOnClick(View paramView) {}
  
  public void a(Context paramContext, String paramString, Intent paramIntent) {}
  
  public void a(jey paramjey)
  {
    if (paramjey != null)
    {
      this.mBegin = paramjey.mBegin;
      this.oY = paramjey.oY;
    }
  }
  
  public void avi() {}
  
  public <T extends View> T findViewById(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  public Resources getResources()
  {
    return this.a.getResources();
  }
  
  public String getString(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public void initUI() {}
  
  public void kA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mBegin = SystemClock.elapsedRealtime();
      return;
    }
    this.oY = SystemClock.elapsedRealtime();
  }
  
  public int mk()
  {
    return this.oR;
  }
  
  public void onBackPressed() {}
  
  public void onDestroy() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onRestart() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  protected void report(String paramString)
  {
    anot.a(null, "CliOper", "", "", paramString, paramString, 0, 0, Integer.toString(this.a.mOnlineStatus), Integer.toString(this.a.axP), Integer.toString(this.a.axQ), "");
  }
  
  public void updateUI() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jey
 * JD-Core Version:    0.7.0.1
 */