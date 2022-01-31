import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Space;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.4;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class tsf
  extends tvg
  implements TextureView.SurfaceTextureListener
{
  private int jdField_a_of_type_Int;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  private void a()
  {
    if (tpz.a().a() != null)
    {
      this.c = true;
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new tsg(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new tsi(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new tsj(this));
      QLog.d("QCircleFolderSplashPart", 4, "loadSplash video");
    }
  }
  
  private void b()
  {
    Object localObject;
    float f;
    int m;
    int k;
    int j;
    int i;
    if (this.c)
    {
      localObject = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidViewTextureView = new TextureView(a().getApplicationContext());
      this.jdField_a_of_type_AndroidViewTextureView.setSurfaceTextureListener(this);
      this.jdField_a_of_type_AndroidViewTextureView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewTextureView, 0, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(a());
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843576);
      this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new tsk(this));
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 8388661;
      ((FrameLayout.LayoutParams)localObject).topMargin = bdkf.b(32.0F);
      ((FrameLayout.LayoutParams)localObject).rightMargin = bdkf.b(16.0F);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(a());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      localObject = new DisplayMetrics();
      a().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      f = (float)(((DisplayMetrics)localObject).heightPixels * 1.0D / ((DisplayMetrics)localObject).widthPixels);
      if (f <= 1.777778F) {
        break label448;
      }
      m = bdkf.b(70.5F);
      k = bdkf.b(200.0F);
      j = bdkf.b(172.0F);
      i = bdkf.b(51.0F);
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).height = k;
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      localObject = new ImageView(a());
      ((ImageView)localObject).setImageResource(2130843579);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(j, i);
      localLayoutParams1.gravity = 81;
      localLayoutParams1.bottomMargin = m;
      Space localSpace = new Space(a());
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams2.weight = 1.0F;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localSpace, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams1);
      return;
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368905).setVisibility(0);
      new Handler().postDelayed(new QCircleFolderSplashPart.4(this), 2000L);
      break;
      label448:
      if (f > 1.5F)
      {
        m = bdkf.b(28.0F);
        k = bdkf.b(150.0F);
        if (((DisplayMetrics)localObject).widthPixels == 1080)
        {
          j = bdkf.b(172.0F);
          i = bdkf.b(51.0F);
        }
        else
        {
          j = bdkf.b(120.0F);
          i = bdkf.b(36.0F);
        }
      }
      else if (f > 1.333333F)
      {
        m = bdkf.b(26.0F);
        k = bdkf.b(100.0F);
        j = bdkf.b(106.0F);
        i = bdkf.b(32.0F);
      }
      else
      {
        m = bdkf.b(28.0F);
        k = bdkf.b(100.0F);
        j = bdkf.b(120.0F);
        i = bdkf.b(36.0F);
      }
    }
  }
  
  private void c()
  {
    float f2 = 1.0F;
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (this.jdField_a_of_type_AndroidViewTextureView == null)) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      a().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
      k = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
      m = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
      QLog.d("QCircleFolderSplashPart", 4, "screen, video = (" + i + ", " + j + "), (" + k + ", " + m + ")");
    } while ((i == k) && (j == m));
    float f4 = (float)(k * 1.0D / i);
    float f3 = (float)(m * 1.0D / j);
    float f1 = f4;
    if (f4 < 1.0F) {
      f1 = 1.0F;
    }
    if (f3 < 1.0F) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewTextureView.setScaleX(f1);
      this.jdField_a_of_type_AndroidViewTextureView.setScaleY(f2);
      f1 = (float)(j * 1.0D / i);
      if (f1 > 1.777778F) {
        i = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewTextureView.setTranslationY(i);
        this.jdField_a_of_type_AndroidViewTextureView.requestLayout();
        this.jdField_a_of_type_AndroidViewTextureView.invalidate();
        return;
        if (f1 > 1.5F) {
          i = bdkf.b(35.0F);
        } else if (f1 > 1.333333F) {
          i = bdkf.b(30.0F);
        } else {
          i = bdkf.b(35.0F);
        }
      }
      f2 = f3;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_a_of_type_AndroidViewTextureView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewTextureView);
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
  }
  
  private void e()
  {
    d();
    QLog.d("QCircleFolderSplashPart", 1, "hideSpashView");
    tpz.a().d();
    a().getWindow().clearFlags(1024);
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131372529));
    if ((this.jdField_b_of_type_Boolean) && (tpz.a().a()))
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373155));
      if (this.jdField_a_of_type_AndroidViewViewStub != null) {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      }
      a().getWindow().setFlags(1024, 1024);
      paramView = a().getIntent().getStringExtra("key_jump_from");
      this.jdField_a_of_type_Int = 0;
      if (!"3".equals(paramView)) {
        break label166;
      }
      this.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      QLog.d("QCircleFolderSplashPart", 1, "jumpFromSubAction:" + this.jdField_a_of_type_Int);
      a();
      b();
      tyj.a("", 19, this.jdField_a_of_type_Int);
      return;
      label166:
      if ("4".equals(paramView)) {
        this.jdField_a_of_type_Int = 2;
      }
    }
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
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      }
      e();
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewTextureView.requestFocus();
      }
    }
    else {
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
        for (;;)
        {
          paramActivity.printStackTrace();
        }
      }
    }
    e();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(new Surface(paramSurfaceTexture));
      c();
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
 * Qualified Name:     tsf
 * JD-Core Version:    0.7.0.1
 */