import android.app.Activity;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.1;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.6;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.7;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver.a;
import java.io.IOException;
import mqq.app.AppActivity;

public class owk
  extends rxk
  implements TextureView.SurfaceTextureListener, AECircleBroadcastReceiver.a
{
  private ImageButton W;
  private AECircleBroadcastReceiver a = new AECircleBroadcastReceiver(this);
  private boolean ayR;
  private boolean ayS;
  private boolean ayT;
  private boolean ayU;
  private boolean ayV;
  private ViewGroup bD;
  private int bgz;
  private Runnable dg = new QCircleFolderSplashPart.6(this);
  private AnimationDrawable j;
  private ImageView lL;
  private ImageView lM;
  private ImageView lN;
  private ViewGroup mContainer;
  private MediaPlayer mMediaPlayer;
  private TextureView mTextureView;
  private Handler mUiHandler;
  private ViewStub n;
  
  private void bia()
  {
    if (oue.a().b() != null)
    {
      this.ayT = true;
      this.a.cO(getActivity());
      ovd.cu(getActivity());
      anjx.a().b("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
      this.mMediaPlayer = new MediaPlayer();
      this.mMediaPlayer.setOnPreparedListener(new owl(this));
      this.mMediaPlayer.setOnErrorListener(new own(this));
      this.mMediaPlayer.setOnCompletionListener(new owo(this));
      QLog.d("QCircleFolderSplashPart", 4, "loadSplash video");
    }
  }
  
  private void bib()
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.lL.getLayoutParams();
    localLayoutParams.topMargin = (((DisplayMetrics)localObject).heightPixels * 2 / 3 - aqnm.dip2px(20.0F));
    this.lL.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.lM.getLayoutParams();
    localLayoutParams.topMargin = (((DisplayMetrics)localObject).heightPixels * 2 / 3 - aqnm.dip2px(20.0F));
    this.lM.setLayoutParams(localLayoutParams);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    this.lL.startAnimation((Animation)localObject);
    this.lL.setVisibility(0);
    this.lM.setVisibility(0);
    this.lL.setOnClickListener(new owp(this));
  }
  
  private void bic()
  {
    this.bD.findViewById(2131369907).setVisibility(0);
    this.bD.setBackgroundColor(0);
    pco.a("", 19, 3L, 0L, "2");
    this.mUiHandler.postDelayed(new QCircleFolderSplashPart.7(this), 4000L);
  }
  
  private void bid()
  {
    Object localObject;
    float f;
    int m;
    int k;
    int i;
    if (this.ayT)
    {
      this.mTextureView.setVisibility(0);
      this.mTextureView.setSurfaceTextureListener(this);
      this.W.setOnClickListener(new owq(this));
      localObject = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      f = (float)(((DisplayMetrics)localObject).heightPixels * 1.0D / ((DisplayMetrics)localObject).widthPixels);
      if (f <= 1.777778F) {
        break label167;
      }
      m = aqnm.dpToPx(70.5F);
      k = aqnm.dpToPx(120.0F);
      i = aqnm.dpToPx(36.0F);
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.lN.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = k;
      ((RelativeLayout.LayoutParams)localObject).height = i;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = m;
      this.lN.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.lN.setVisibility(0);
      return;
      bic();
      break;
      label167:
      if (f > 1.5F)
      {
        m = aqnm.dpToPx(28.0F);
        k = aqnm.dpToPx(120.0F);
        i = aqnm.dpToPx(36.0F);
      }
      else if (f > 1.333333F)
      {
        m = aqnm.dpToPx(26.0F);
        k = aqnm.dpToPx(106.0F);
        i = aqnm.dpToPx(32.0F);
      }
      else
      {
        m = aqnm.dpToPx(28.0F);
        k = aqnm.dpToPx(120.0F);
        i = aqnm.dpToPx(36.0F);
      }
    }
  }
  
  private void bie()
  {
    release();
    QLog.d("QCircleFolderSplashPart", 1, "hideSpashView");
    oue.a().bhB();
    getActivity().getWindow().clearFlags(1024);
  }
  
  private void bif()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      ((AppActivity)getActivity()).requestPermissions(new owr(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    big();
  }
  
  private void big()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", 6);
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", axcg.A.getId());
    localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    localBundle.putInt("key_qcircle_entrance_type", 3);
    oux.b(getActivity(), localBundle, null, 6);
  }
  
  private void release()
  {
    QLog.d("QCircleFolderSplashPart", 1, "release...");
    this.mUiHandler.removeCallbacks(this.dg);
    this.a.cP(getActivity());
    this.ayV = false;
    if (this.bD != null)
    {
      if (this.mTextureView != null) {
        this.bD.removeView(this.mTextureView);
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      if (this.j != null)
      {
        this.j.stop();
        this.j = null;
      }
      if (this.lM != null) {
        this.bD.removeView(this.lM);
      }
      if (this.lL != null) {
        this.bD.removeView(this.lL);
      }
      if (this.lN != null) {
        this.bD.removeView(this.lN);
      }
      this.mContainer.removeView(this.bD);
      this.bD = null;
    }
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.mContainer = ((ViewGroup)paramView.findViewById(2131373904));
    if ((this.ayS) && (oue.a().Ht()))
    {
      ThreadManager.excute(new QCircleFolderSplashPart.1(this), 16, null, true);
      this.n = ((ViewStub)paramView.findViewById(2131374536));
      if (this.n != null) {
        this.bD = ((ViewGroup)this.n.inflate());
      }
      this.mTextureView = ((TextureView)this.bD.findViewById(2131378659));
      this.lL = ((ImageView)this.bD.findViewById(2131363738));
      this.lM = ((ImageView)this.bD.findViewById(2131363739));
      this.lN = ((ImageView)this.bD.findViewById(2131369854));
      this.W = ((ImageButton)this.bD.findViewById(2131368697));
      getActivity().getWindow().setFlags(1024, 1024);
      paramView = getActivity().getIntent().getStringExtra("key_jump_from");
      this.bgz = 0;
      if (!"3".equals(paramView)) {
        break label284;
      }
      this.bgz = 1;
    }
    for (;;)
    {
      QLog.d("QCircleFolderSplashPart", 1, "jumpFromSubAction:" + this.bgz);
      bia();
      bid();
      pco.h("", 19, this.bgz);
      return;
      label284:
      if ("4".equals(paramView)) {
        this.bgz = 2;
      }
    }
  }
  
  public String getLogTag()
  {
    return "QCircleFolderSplashPart";
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.setOnCompletionListener(null);
      this.mMediaPlayer.setOnErrorListener(null);
      this.mMediaPlayer.setOnPreparedListener(null);
      if (this.mMediaPlayer.isPlaying())
      {
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      bie();
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    if (this.mMediaPlayer != null)
    {
      if (this.ayR) {
        break label111;
      }
      this.ayR = true;
      this.mTextureView.requestFocus();
      if (oue.a().b() == null) {
        break label104;
      }
    }
    for (;;)
    {
      try
      {
        this.mMediaPlayer.setDataSource(getContext(), oue.a().b());
        this.mMediaPlayer.prepareAsync();
        QLog.d("QCircleFolderSplashPart", 4, "mediaplayer prepareAsync");
        ouy.a().setEnable(false);
        return;
      }
      catch (IOException paramActivity)
      {
        paramActivity.printStackTrace();
        QLog.d("QCircleFolderSplashPart", 4, "setSource or prepare error", paramActivity);
        bic();
        continue;
      }
      label104:
      bic();
    }
    label111:
    bie();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    bie();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.setSurface(new Surface(paramSurfaceTexture));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void qr(String paramString)
  {
    QLog.d("QCircleFolderSplashPart", 1, new Object[] { "onDownLoadFinish... filepath:", paramString });
    this.ayU = true;
  }
  
  public void rg(boolean paramBoolean)
  {
    this.ayS = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owk
 * JD-Core Version:    0.7.0.1
 */