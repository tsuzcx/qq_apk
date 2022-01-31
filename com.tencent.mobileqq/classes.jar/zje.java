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

public abstract class zje
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public zil a;
  public zin a;
  protected zir a;
  public zis a;
  private zjj jdField_a_of_type_Zjj;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    this.jdField_a_of_type_Zir.a().a = this.jdField_a_of_type_Zis.a();
    this.jdField_a_of_type_Zin.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Zin.o();
    this.jdField_a_of_type_Zin.a.setSelectionToNothing();
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
    localAnimationView.setId(2131362576);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public zil a()
  {
    return this.jdField_a_of_type_Zil;
  }
  
  public zil a(Activity paramActivity, zir paramzir)
  {
    return new zjb(paramActivity, paramzir);
  }
  
  public zin a()
  {
    return this.jdField_a_of_type_Zin;
  }
  
  public abstract zin a(Activity paramActivity, zir paramzir);
  
  public abstract zir a(Activity paramActivity);
  
  public zis a()
  {
    return this.jdField_a_of_type_Zis;
  }
  
  public abstract zis a(Activity paramActivity, zir paramzir);
  
  public zjj a()
  {
    return this.jdField_a_of_type_Zjj;
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
        if (this.jdField_a_of_type_Zjj != this.jdField_a_of_type_Zin) {
          break label121;
        }
        if (this.jdField_a_of_type_Zis != null) {
          break;
        }
        this.jdField_a_of_type_Zis = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Zir);
      } while (this.jdField_a_of_type_Zis == null);
      this.jdField_a_of_type_Zis.a(this);
      this.jdField_a_of_type_Zis.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Zis.a(this);
      this.jdField_a_of_type_Zis.k();
      this.jdField_a_of_type_Zin.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Zjj = this.jdField_a_of_type_Zis;
      return;
    } while (this.jdField_a_of_type_Zjj != this.jdField_a_of_type_Zis);
    this.jdField_a_of_type_Zin.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Zjj != null) {
      this.jdField_a_of_type_Zjj.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Zir = a(paramActivity);
    this.jdField_a_of_type_Zil = a(paramActivity, this.jdField_a_of_type_Zir);
    if (this.jdField_a_of_type_Zin == null)
    {
      this.jdField_a_of_type_Zin = a(paramActivity, this.jdField_a_of_type_Zir);
      this.jdField_a_of_type_Zin.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Zin.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Zin.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Zjj = this.jdField_a_of_type_Zin;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Zjj != null) {
      this.jdField_a_of_type_Zjj.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Zin.k();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    zjd localzjd = this.jdField_a_of_type_Zir.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Zin.n();
      this.jdField_a_of_type_Zis.a();
      localzjd.a = this.jdField_a_of_type_Zis.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Zin.b(paramBoolean);
      return;
      this.jdField_a_of_type_Zin.i();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Zjj != null) {
      return this.jdField_a_of_type_Zjj.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Zjj.p();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Zjj == this.jdField_a_of_type_Zin)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Zjj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Zil.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Zjj.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Zjj.s();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Zin != null) {
      this.jdField_a_of_type_Zin.f();
    }
    if (this.jdField_a_of_type_Zis != null) {
      this.jdField_a_of_type_Zis.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zje
 * JD-Core Version:    0.7.0.1
 */