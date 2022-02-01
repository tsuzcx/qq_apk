import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.GuideTip2.5;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jib
  extends jit
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  jib.a a;
  public iya b;
  public Bitmap bi;
  public Bitmap bl;
  
  public jib(jht paramjht)
  {
    super(paramjht);
  }
  
  public static boolean i(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.jY(14) == 1) {
      return true;
    }
    return jll.a(paramVideoAppInterface).getBoolean("qav_UserGuide2_for_av_redbag", true);
  }
  
  public static void r(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {
      return;
    }
    paramVideoAppInterface = jll.a(paramVideoAppInterface).edit();
    paramVideoAppInterface.putBoolean("qav_UserGuide2_for_av_redbag", false);
    paramVideoAppInterface.commit();
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131368219);
    if (localRelativeLayout != null) {
      paramAVActivity = localRelativeLayout;
    }
    for (;;)
    {
      return paramAVActivity;
      localRelativeLayout = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2131559963, (RelativeLayout)paramAVActivity.findViewById(2131373916)).findViewById(2131368219);
      n(localRelativeLayout);
      awC();
      localRelativeLayout.findViewById(2131368220).setOnClickListener(new jic(this));
      Object localObject = localRelativeLayout.findViewById(2131368217);
      if (this.bi == null) {
        this.bi = jik.e("qav_redpacket_result_close.png", true);
      }
      if (this.bi != null) {
        ((View)localObject).setBackgroundDrawable(jlg.a(paramAVActivity.getResources(), this.bi, 2131166288));
      }
      ((View)localObject).setOnClickListener(new jid(this));
      String str = jik.ho();
      if (aqhq.fileExistsAndNotEmpty(str))
      {
        localObject = (VideoView)localRelativeLayout.findViewById(2131368222);
        ((VideoView)localObject).setVideoPath(str);
        ((VideoView)localObject).setZOrderOnTop(true);
        ((VideoView)localObject).setOnPreparedListener(this);
        ((VideoView)localObject).setOnErrorListener(this);
        ((VideoView)localObject).setZOrderMediaOverlay(true);
        if (Build.VERSION.SDK_INT >= 17) {
          ((VideoView)localObject).setOnInfoListener(this);
        }
        if (this.bl == null) {
          paramAVActivity = new MediaMetadataRetriever();
        }
        try
        {
          paramAVActivity.setDataSource(str);
          this.bl = paramAVActivity.getFrameAtTime(0L);
          paramAVActivity.release();
          paramAVActivity = localRelativeLayout;
          if (this.bl != null)
          {
            ((VideoView)localObject).setBackgroundDrawable(new BitmapDrawable(this.bl));
            return localRelativeLayout;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d(this.TAG, 1, "initDialog, Exception", localException);
          }
        }
      }
    }
    QLog.w(this.TAG, 1, "initDialog, no exist, path[" + localException + "]");
    return localRelativeLayout;
  }
  
  public boolean a(jib.a parama)
  {
    AVActivity localAVActivity = getAVActivity();
    if (localAVActivity == null) {
      return false;
    }
    this.a = parama;
    a(localAVActivity).setVisibility(0);
    r(this.mApp);
    jij.awN();
    return true;
  }
  
  void awB()
  {
    if (this.b != null)
    {
      this.mApp.deleteObserver(this.b);
      this.b = null;
    }
  }
  
  void awC()
  {
    if (this.b != null) {
      return;
    }
    this.b = new jif(this);
    this.mApp.addObserver(this.b);
  }
  
  boolean b(boolean paramBoolean, int paramInt)
  {
    awB();
    Object localObject = getAVActivity();
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)localObject).findViewById(2131368219);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        localObject = (RelativeLayout)((Activity)localObject).findViewById(2131373916);
        if (this.bl != null)
        {
          VideoView localVideoView = (VideoView)localRelativeLayout.findViewById(2131368222);
          if (localVideoView != null) {
            localVideoView.setBackgroundDrawable(new BitmapDrawable(this.bl));
          }
        }
        ((RelativeLayout)localObject).post(new GuideTip2.5(this, (RelativeLayout)localObject, localRelativeLayout));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.a != null)
      {
        this.a.ki(paramBoolean);
        this.a = null;
      }
      QLog.w(this.TAG, 1, "closeUI, bSend[" + paramBoolean + "], closeType[" + paramInt + "]");
      jij.C(paramBoolean, paramInt);
      return bool;
    }
  }
  
  void n(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new jie(this));
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.w(this.TAG, 1, "WL_DEBUG onError what = " + paramInt1 + ", extra = " + paramInt2);
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      paramMediaPlayer = getAVActivity();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer = (VideoView)paramMediaPlayer.findViewById(2131368222);
        if (paramMediaPlayer != null) {
          paramMediaPlayer.setBackgroundDrawable(null);
        }
      }
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.w(this.TAG, 1, "WL_DEBUG onPrepared");
    Object localObject = getAVActivity();
    if (localObject != null)
    {
      localObject = (VideoView)((AVActivity)localObject).findViewById(2131368222);
      if (localObject != null)
      {
        ((VideoView)localObject).start();
        paramMediaPlayer.setLooping(true);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ki(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jib
 * JD-Core Version:    0.7.0.1
 */