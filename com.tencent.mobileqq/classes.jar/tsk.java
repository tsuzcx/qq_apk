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
import java.io.IOException;
import mqq.app.AppActivity;

public class tsk
  extends tvv
  implements TextureView.SurfaceTextureListener, bksu
{
  private int jdField_a_of_type_Int;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AECircleBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver = new AECircleBroadcastReceiver(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new QCircleFolderSplashPart.6(this);
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  private void a()
  {
    if (tpz.a().a() != null)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.a(a());
      tra.a(a());
      azjs.a().a("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new tsl(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new tsn(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new tso(this));
      QLog.d("QCircleFolderSplashPart", 4, "loadSplash video");
    }
  }
  
  private void b()
  {
    Object localObject = new DisplayMetrics();
    a().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.topMargin = (((DisplayMetrics)localObject).heightPixels * 2 / 3 - bdoo.a(20.0F));
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.topMargin = (((DisplayMetrics)localObject).heightPixels * 2 / 3 - bdoo.a(20.0F));
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new tsp(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368923).setVisibility(0);
    tzv.a("", 19, 3L, 0L, "2");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QCircleFolderSplashPart.7(this), 4000L);
  }
  
  private void d()
  {
    Object localObject;
    float f;
    int k;
    int j;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewTextureView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewTextureView.setSurfaceTextureListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new tsq(this));
      localObject = new DisplayMetrics();
      a().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      f = (float)(((DisplayMetrics)localObject).heightPixels * 1.0D / ((DisplayMetrics)localObject).widthPixels);
      if (f <= 1.777778F) {
        break label167;
      }
      k = bdoo.b(70.5F);
      j = bdoo.b(120.0F);
      i = bdoo.b(36.0F);
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = j;
      ((RelativeLayout.LayoutParams)localObject).height = i;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = k;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      c();
      break;
      label167:
      if (f > 1.5F)
      {
        k = bdoo.b(28.0F);
        j = bdoo.b(120.0F);
        i = bdoo.b(36.0F);
      }
      else if (f > 1.333333F)
      {
        k = bdoo.b(26.0F);
        j = bdoo.b(106.0F);
        i = bdoo.b(32.0F);
      }
      else
      {
        k = bdoo.b(28.0F);
        j = bdoo.b(120.0F);
        i = bdoo.b(36.0F);
      }
    }
  }
  
  private void e()
  {
    QLog.d("QCircleFolderSplashPart", 1, "release...");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.b(a());
    this.e = false;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_a_of_type_AndroidViewTextureView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewTextureView);
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidWidgetImageView);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_c_of_type_AndroidWidgetImageView);
      }
      this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
  }
  
  private void f()
  {
    e();
    QLog.d("QCircleFolderSplashPart", 1, "hideSpashView");
    tpz.a().d();
    a().getWindow().clearFlags(1024);
  }
  
  private void g()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      ((AppActivity)a()).requestPermissions(new tsr(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    h();
  }
  
  private void h()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", 6);
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", blat.A.a());
    blax.b(a(), localBundle);
  }
  
  public String a()
  {
    return "QCircleFolderSplashPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131372554));
    if ((this.jdField_b_of_type_Boolean) && (tpz.a().a()))
    {
      ThreadManager.excute(new QCircleFolderSplashPart.1(this), 16, null, true);
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373184));
      if (this.jdField_a_of_type_AndroidViewViewStub != null) {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      }
      this.jdField_a_of_type_AndroidViewTextureView = ((TextureView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376960));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363466));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363467));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368874));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367818));
      a().getWindow().setFlags(1024, 1024);
      paramView = a().getIntent().getStringExtra("key_jump_from");
      this.jdField_a_of_type_Int = 0;
      if (!"3".equals(paramView)) {
        break label284;
      }
      this.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      QLog.d("QCircleFolderSplashPart", 1, "jumpFromSubAction:" + this.jdField_a_of_type_Int);
      a();
      d();
      tzv.a("", 19, this.jdField_a_of_type_Int);
      return;
      label284:
      if ("4".equals(paramView)) {
        this.jdField_a_of_type_Int = 2;
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.d("QCircleFolderSplashPart", 1, new Object[] { "onDownLoadFinish... filepath:", paramString });
    this.d = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(null);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(null);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(null);
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      f();
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        break label111;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewTextureView.requestFocus();
      if (tpz.a().a() == null) {
        break label104;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(a(), tpz.a().a());
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        QLog.d("QCircleFolderSplashPart", 4, "mediaplayer prepareAsync");
        tqt.a().a(false);
        return;
      }
      catch (IOException paramActivity)
      {
        paramActivity.printStackTrace();
        QLog.d("QCircleFolderSplashPart", 4, "setSource or prepare error", paramActivity);
        c();
        continue;
      }
      label104:
      c();
    }
    label111:
    f();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    f();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(new Surface(paramSurfaceTexture));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsk
 * JD-Core Version:    0.7.0.1
 */