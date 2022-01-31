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

public abstract class xpw
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public xpd a;
  public xpf a;
  protected xpj a;
  public xpk a;
  private xqb jdField_a_of_type_Xqb;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    this.jdField_a_of_type_Xpj.a().a = this.jdField_a_of_type_Xpk.a();
    this.jdField_a_of_type_Xpf.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Xpf.o();
    this.jdField_a_of_type_Xpf.a.setSelectionToNothing();
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
    localAnimationView.setId(2131362548);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public xpd a()
  {
    return this.jdField_a_of_type_Xpd;
  }
  
  public xpd a(Activity paramActivity, xpj paramxpj)
  {
    return new xpt(paramActivity, paramxpj);
  }
  
  public xpf a()
  {
    return this.jdField_a_of_type_Xpf;
  }
  
  public abstract xpf a(Activity paramActivity, xpj paramxpj);
  
  public abstract xpj a(Activity paramActivity);
  
  public xpk a()
  {
    return this.jdField_a_of_type_Xpk;
  }
  
  public abstract xpk a(Activity paramActivity, xpj paramxpj);
  
  public xqb a()
  {
    return this.jdField_a_of_type_Xqb;
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
        if (this.jdField_a_of_type_Xqb != this.jdField_a_of_type_Xpf) {
          break label121;
        }
        if (this.jdField_a_of_type_Xpk != null) {
          break;
        }
        this.jdField_a_of_type_Xpk = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Xpj);
      } while (this.jdField_a_of_type_Xpk == null);
      this.jdField_a_of_type_Xpk.a(this);
      this.jdField_a_of_type_Xpk.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Xpk.a(this);
      this.jdField_a_of_type_Xpk.k();
      this.jdField_a_of_type_Xpf.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Xqb = this.jdField_a_of_type_Xpk;
      return;
    } while (this.jdField_a_of_type_Xqb != this.jdField_a_of_type_Xpk);
    this.jdField_a_of_type_Xpf.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Xqb != null) {
      this.jdField_a_of_type_Xqb.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xpj = a(paramActivity);
    this.jdField_a_of_type_Xpd = a(paramActivity, this.jdField_a_of_type_Xpj);
    if (this.jdField_a_of_type_Xpf == null)
    {
      this.jdField_a_of_type_Xpf = a(paramActivity, this.jdField_a_of_type_Xpj);
      this.jdField_a_of_type_Xpf.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Xpf.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Xpf.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Xqb = this.jdField_a_of_type_Xpf;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Xqb != null) {
      this.jdField_a_of_type_Xqb.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Xpf.k();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    xpv localxpv = this.jdField_a_of_type_Xpj.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xpf.n();
      this.jdField_a_of_type_Xpk.a();
      localxpv.a = this.jdField_a_of_type_Xpk.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Xpf.b(paramBoolean);
      return;
      this.jdField_a_of_type_Xpf.i();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Xqb != null) {
      return this.jdField_a_of_type_Xqb.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Xqb.p();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Xqb == this.jdField_a_of_type_Xpf)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Xqb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Xpd.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Xqb.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xqb.s();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Xpf != null) {
      this.jdField_a_of_type_Xpf.f();
    }
    if (this.jdField_a_of_type_Xpk != null) {
      this.jdField_a_of_type_Xpk.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xpw
 * JD-Core Version:    0.7.0.1
 */