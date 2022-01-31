import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.common.galleryactivity.GalleryManager.1;
import com.tencent.common.galleryactivity.GalleryManager.2;
import com.tencent.image.QQLiveImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class xpz
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public xpg a;
  public xpi a;
  protected xpm a;
  public xpn a;
  private xqe jdField_a_of_type_Xqe;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    this.jdField_a_of_type_Xpm.a().a = this.jdField_a_of_type_Xpn.a();
    this.jdField_a_of_type_Xpi.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Xpi.o();
    this.jdField_a_of_type_Xpi.a.setSelectionToNothing();
    QQLiveImage.releaseAll(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidAppActivity.addContentView(localRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    return localRelativeLayout;
  }
  
  public AnimationView a()
  {
    AnimationView localAnimationView = new AnimationView(this.jdField_a_of_type_AndroidAppActivity, null);
    localAnimationView.setId(2131362549);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public xpg a()
  {
    return this.jdField_a_of_type_Xpg;
  }
  
  public xpg a(Activity paramActivity, xpm paramxpm)
  {
    return new xpw(paramActivity, paramxpm);
  }
  
  public xpi a()
  {
    return this.jdField_a_of_type_Xpi;
  }
  
  public abstract xpi a(Activity paramActivity, xpm paramxpm);
  
  public abstract xpm a(Activity paramActivity);
  
  public xpn a()
  {
    return this.jdField_a_of_type_Xpn;
  }
  
  public abstract xpn a(Activity paramActivity, xpm paramxpm);
  
  public xqe a()
  {
    return this.jdField_a_of_type_Xqe;
  }
  
  public void a()
  {
    if (!a()) {}
    label121:
    do
    {
      do
      {
        do
        {
          return;
        } while (a().a());
        if (this.jdField_a_of_type_Xqe != this.jdField_a_of_type_Xpi) {
          break label121;
        }
        if (this.jdField_a_of_type_Xpn != null) {
          break;
        }
        this.jdField_a_of_type_Xpn = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Xpm);
      } while (this.jdField_a_of_type_Xpn == null);
      this.jdField_a_of_type_Xpn.a(this);
      this.jdField_a_of_type_Xpn.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Xpn.a(this);
      this.jdField_a_of_type_Xpn.k();
      this.jdField_a_of_type_Xpi.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Xqe = this.jdField_a_of_type_Xpn;
      return;
    } while (this.jdField_a_of_type_Xqe != this.jdField_a_of_type_Xpn);
    this.jdField_a_of_type_Xpi.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Xqe != null) {
      this.jdField_a_of_type_Xqe.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xpm = a(paramActivity);
    this.jdField_a_of_type_Xpg = a(paramActivity, this.jdField_a_of_type_Xpm);
    if (this.jdField_a_of_type_Xpi == null)
    {
      this.jdField_a_of_type_Xpi = a(paramActivity, this.jdField_a_of_type_Xpm);
      this.jdField_a_of_type_Xpi.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Xpi.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Xpi.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Xqe = this.jdField_a_of_type_Xpi;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Xqe != null) {
      this.jdField_a_of_type_Xqe.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Xpi.k();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    xpy localxpy = this.jdField_a_of_type_Xpm.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xpi.n();
      this.jdField_a_of_type_Xpn.a();
      localxpy.a = this.jdField_a_of_type_Xpn.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Xpi.b(paramBoolean);
      return;
      this.jdField_a_of_type_Xpi.i();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Xqe != null) {
      return this.jdField_a_of_type_Xqe.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Xqe.p();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Xqe == this.jdField_a_of_type_Xpi)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Xqe != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Xpg.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Xqe.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xqe.s();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Xpi != null) {
      this.jdField_a_of_type_Xpi.f();
    }
    if (this.jdField_a_of_type_Xpn != null) {
      this.jdField_a_of_type_Xpn.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xpz
 * JD-Core Version:    0.7.0.1
 */