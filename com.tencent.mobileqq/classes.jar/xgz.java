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

public abstract class xgz
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public xgg a;
  public xgi a;
  protected xgm a;
  public xgn a;
  private xhe jdField_a_of_type_Xhe;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    this.jdField_a_of_type_Xgm.a().a = this.jdField_a_of_type_Xgn.a();
    this.jdField_a_of_type_Xgi.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Xgi.o();
    this.jdField_a_of_type_Xgi.a.setSelectionToNothing();
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
    localAnimationView.setId(2131297010);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public xgg a()
  {
    return this.jdField_a_of_type_Xgg;
  }
  
  public xgg a(Activity paramActivity, xgm paramxgm)
  {
    return new xgw(paramActivity, paramxgm);
  }
  
  public xgi a()
  {
    return this.jdField_a_of_type_Xgi;
  }
  
  public abstract xgi a(Activity paramActivity, xgm paramxgm);
  
  public abstract xgm a(Activity paramActivity);
  
  public xgn a()
  {
    return this.jdField_a_of_type_Xgn;
  }
  
  public abstract xgn a(Activity paramActivity, xgm paramxgm);
  
  public xhe a()
  {
    return this.jdField_a_of_type_Xhe;
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
        if (this.jdField_a_of_type_Xhe != this.jdField_a_of_type_Xgi) {
          break label121;
        }
        if (this.jdField_a_of_type_Xgn != null) {
          break;
        }
        this.jdField_a_of_type_Xgn = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Xgm);
      } while (this.jdField_a_of_type_Xgn == null);
      this.jdField_a_of_type_Xgn.a(this);
      this.jdField_a_of_type_Xgn.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Xgn.a(this);
      this.jdField_a_of_type_Xgn.k();
      this.jdField_a_of_type_Xgi.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Xhe = this.jdField_a_of_type_Xgn;
      return;
    } while (this.jdField_a_of_type_Xhe != this.jdField_a_of_type_Xgn);
    this.jdField_a_of_type_Xgi.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Xhe != null) {
      this.jdField_a_of_type_Xhe.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xgm = a(paramActivity);
    this.jdField_a_of_type_Xgg = a(paramActivity, this.jdField_a_of_type_Xgm);
    if (this.jdField_a_of_type_Xgi == null)
    {
      this.jdField_a_of_type_Xgi = a(paramActivity, this.jdField_a_of_type_Xgm);
      this.jdField_a_of_type_Xgi.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Xgi.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Xgi.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Xhe = this.jdField_a_of_type_Xgi;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Xhe != null) {
      this.jdField_a_of_type_Xhe.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Xgi.k();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    xgy localxgy = this.jdField_a_of_type_Xgm.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xgi.n();
      this.jdField_a_of_type_Xgn.a();
      localxgy.a = this.jdField_a_of_type_Xgn.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Xgi.b(paramBoolean);
      return;
      this.jdField_a_of_type_Xgi.i();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Xhe != null) {
      return this.jdField_a_of_type_Xhe.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Xhe.p();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Xhe == this.jdField_a_of_type_Xgi)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Xhe != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Xgg.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Xhe.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xhe.s();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Xgi != null) {
      this.jdField_a_of_type_Xgi.f();
    }
    if (this.jdField_a_of_type_Xgn != null) {
      this.jdField_a_of_type_Xgn.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xgz
 * JD-Core Version:    0.7.0.1
 */