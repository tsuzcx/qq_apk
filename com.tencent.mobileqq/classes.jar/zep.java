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

public abstract class zep
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public zdw a;
  public zdy a;
  protected zec a;
  public zed a;
  private zeu jdField_a_of_type_Zeu;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    this.jdField_a_of_type_Zec.a().a = this.jdField_a_of_type_Zed.a();
    this.jdField_a_of_type_Zdy.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Zdy.o();
    this.jdField_a_of_type_Zdy.a.setSelectionToNothing();
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
  
  public zdw a()
  {
    return this.jdField_a_of_type_Zdw;
  }
  
  public zdw a(Activity paramActivity, zec paramzec)
  {
    return new zem(paramActivity, paramzec);
  }
  
  public zdy a()
  {
    return this.jdField_a_of_type_Zdy;
  }
  
  public abstract zdy a(Activity paramActivity, zec paramzec);
  
  public abstract zec a(Activity paramActivity);
  
  public zed a()
  {
    return this.jdField_a_of_type_Zed;
  }
  
  public abstract zed a(Activity paramActivity, zec paramzec);
  
  public zeu a()
  {
    return this.jdField_a_of_type_Zeu;
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
        if (this.jdField_a_of_type_Zeu != this.jdField_a_of_type_Zdy) {
          break label121;
        }
        if (this.jdField_a_of_type_Zed != null) {
          break;
        }
        this.jdField_a_of_type_Zed = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Zec);
      } while (this.jdField_a_of_type_Zed == null);
      this.jdField_a_of_type_Zed.a(this);
      this.jdField_a_of_type_Zed.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Zed.a(this);
      this.jdField_a_of_type_Zed.k();
      this.jdField_a_of_type_Zdy.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Zeu = this.jdField_a_of_type_Zed;
      return;
    } while (this.jdField_a_of_type_Zeu != this.jdField_a_of_type_Zed);
    this.jdField_a_of_type_Zdy.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Zeu != null) {
      this.jdField_a_of_type_Zeu.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Zec = a(paramActivity);
    this.jdField_a_of_type_Zdw = a(paramActivity, this.jdField_a_of_type_Zec);
    if (this.jdField_a_of_type_Zdy == null)
    {
      this.jdField_a_of_type_Zdy = a(paramActivity, this.jdField_a_of_type_Zec);
      this.jdField_a_of_type_Zdy.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Zdy.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Zdy.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Zeu = this.jdField_a_of_type_Zdy;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Zeu != null) {
      this.jdField_a_of_type_Zeu.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Zdy.k();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    zeo localzeo = this.jdField_a_of_type_Zec.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Zdy.n();
      this.jdField_a_of_type_Zed.a();
      localzeo.a = this.jdField_a_of_type_Zed.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Zdy.b(paramBoolean);
      return;
      this.jdField_a_of_type_Zdy.i();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Zeu != null) {
      return this.jdField_a_of_type_Zeu.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Zeu.p();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Zeu == this.jdField_a_of_type_Zdy)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Zeu != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Zdw.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Zeu.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Zeu.s();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Zdy != null) {
      this.jdField_a_of_type_Zdy.f();
    }
    if (this.jdField_a_of_type_Zed != null) {
      this.jdField_a_of_type_Zed.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zep
 * JD-Core Version:    0.7.0.1
 */