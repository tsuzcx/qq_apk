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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class sxz
{
  public sxg a;
  private sye a;
  public boolean aOd;
  public boolean aOe;
  public sxi b;
  public sxn b;
  public sxm c;
  ViewGroup cI;
  private boolean hasStart;
  private Activity mContext;
  
  private void bBW()
  {
    this.c.a().thubmRect = this.jdField_b_of_type_Sxn.q();
    this.jdField_b_of_type_Sxi.bBN();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_b_of_type_Sxi.exitAnimation();
    this.jdField_b_of_type_Sxi.b.setSelectionToNothing();
  }
  
  public boolean Ny()
  {
    return false;
  }
  
  public AnimationView a()
  {
    AnimationView localAnimationView = new AnimationView(this.mContext, null);
    localAnimationView.setId(2131362725);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public sxg a()
  {
    return this.jdField_a_of_type_Sxg;
  }
  
  public sxg a(Activity paramActivity, sxm paramsxm)
  {
    return new sxw(paramActivity, paramsxm);
  }
  
  public sxi a()
  {
    return this.jdField_b_of_type_Sxi;
  }
  
  public abstract sxi a(Activity paramActivity, sxm paramsxm);
  
  public abstract sxm a(Activity paramActivity);
  
  public sxn a()
  {
    return this.jdField_b_of_type_Sxn;
  }
  
  public abstract sxn a(Activity paramActivity, sxm paramsxm);
  
  public sye a()
  {
    return this.jdField_a_of_type_Sye;
  }
  
  public void bBV()
  {
    if (!Ny()) {}
    label121:
    do
    {
      do
      {
        do
        {
          return;
        } while (a().isAnimating());
        if (this.jdField_a_of_type_Sye != this.jdField_b_of_type_Sxi) {
          break label121;
        }
        if (this.jdField_b_of_type_Sxn != null) {
          break;
        }
        this.jdField_b_of_type_Sxn = a(this.mContext, this.c);
      } while (this.jdField_b_of_type_Sxn == null);
      this.jdField_b_of_type_Sxn.b(this);
      this.jdField_b_of_type_Sxn.onCreate(this.cI);
      this.jdField_b_of_type_Sxn.b(this);
      this.jdField_b_of_type_Sxn.onStart();
      this.jdField_b_of_type_Sxi.getRootView().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Sye = this.jdField_b_of_type_Sxn;
      return;
    } while (this.jdField_a_of_type_Sye != this.jdField_b_of_type_Sxn);
    this.jdField_b_of_type_Sxi.getRootView().post(new GalleryManager.2(this));
  }
  
  public void bh(Activity paramActivity)
  {
    if ((!this.hasStart) && (this.jdField_a_of_type_Sye == this.jdField_b_of_type_Sxi)) {
      vl(false);
    }
    this.hasStart = true;
  }
  
  public RelativeLayout f()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    this.mContext.addContentView(localRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    return localRelativeLayout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Sye != null) {
      this.jdField_a_of_type_Sye.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Sye != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Sxg.isAnimating());
      }
      if ((!a().isAnimating()) && (!this.jdField_a_of_type_Sye.back())) {}
      return true;
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Sye != null) {
      this.jdField_a_of_type_Sye.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Activity paramActivity)
  {
    this.mContext = paramActivity;
    this.c = a(paramActivity);
    this.jdField_a_of_type_Sxg = a(paramActivity, this.c);
    if (this.jdField_b_of_type_Sxi == null)
    {
      this.jdField_b_of_type_Sxi = a(paramActivity, this.c);
      this.jdField_b_of_type_Sxi.b(this);
    }
    if (Ny()) {
      this.cI = f();
    }
    this.jdField_b_of_type_Sxi.onCreate(this.cI);
    if (this.cI == null) {
      this.cI = this.jdField_b_of_type_Sxi.getRootView();
    }
    if (this.cI != null) {
      this.cI.addView(a());
    }
    this.jdField_a_of_type_Sye = this.jdField_b_of_type_Sxi;
    this.aOe = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.cI != null) && (!this.aOe) && (Build.VERSION.SDK_INT >= 16)) {
      this.cI.setSystemUiVisibility(4);
    }
  }
  
  public void onDestroy(Activity paramActivity)
  {
    if (this.jdField_b_of_type_Sxi != null) {
      this.jdField_b_of_type_Sxi.onDestroy();
    }
    if (this.jdField_b_of_type_Sxn != null) {
      this.jdField_b_of_type_Sxn.onDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Sye != null) {
      return this.jdField_a_of_type_Sye.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Sye.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Sye.onResume();
  }
  
  public void vl(boolean paramBoolean)
  {
    this.jdField_b_of_type_Sxi.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    sxy localsxy = this.c.a();
    if (paramBoolean)
    {
      this.jdField_b_of_type_Sxi.bBO();
      this.jdField_b_of_type_Sxn.bBR();
      localsxy.thubmRect = this.jdField_b_of_type_Sxn.q();
    }
    for (;;)
    {
      this.jdField_b_of_type_Sxi.vk(paramBoolean);
      return;
      this.jdField_b_of_type_Sxi.onEnter();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxz
 * JD-Core Version:    0.7.0.1
 */