import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoInteractFace.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class aygn
  extends aygy
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, aydl
{
  private ayil jdField_a_of_type_Ayil;
  private ayoy jdField_a_of_type_Ayoy;
  private boolean dza;
  private int eKd = 1000;
  private View mContainerView;
  
  public aygn(@NonNull aygz paramaygz, @NonNull ayil paramayil, ayoy paramayoy)
  {
    super(paramaygz);
    this.jdField_a_of_type_Ayil = paramayil;
    this.jdField_a_of_type_Ayoy = paramayoy;
  }
  
  @NonNull
  private aydk a()
  {
    aydk localaydk = (aydk)a(aydk.class);
    if (localaydk == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localaydk;
  }
  
  @NonNull
  private ayio a()
  {
    ayio localayio = (ayio)a(ayio.class);
    if (localayio == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localayio;
  }
  
  @NonNull
  private ayjt a()
  {
    aydg localaydg = (aydg)a(aydg.class);
    if (localaydg == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localaydg.a().b();
  }
  
  @NonNull
  private aykb a()
  {
    aydg localaydg = (aydg)a(aydg.class);
    if (localaydg == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localaydg.a().a();
  }
  
  private void cC(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((aykb)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((aykb)localObject).eSn();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((aykb)localObject).eSm();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((ayjt)localObject).a == null);
    if (paramBoolean)
    {
      ((ayjt)localObject).eSn();
      return;
    }
    ((ayjt)localObject).eSm();
  }
  
  private Bundle f(int paramInt)
  {
    Bundle localBundle = new Bundle();
    aykb.b localb = null;
    if (paramInt == 1000) {
      localb = a().a;
    }
    while (localb != null)
    {
      ayil.a(localBundle, localb);
      return localBundle;
      if (paramInt == 1001) {
        localb = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    if (this.eKd == 1000)
    {
      a().b(paramInt, paramayqb);
      return;
    }
    if (this.eKd == 1001)
    {
      a().b(paramInt, paramayqb);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.eKd);
  }
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData)
  {
    this.eKd = paramInteractPasterParcelData.type;
    Bitmap localBitmap = ((axpx)axov.a(15)).aW();
    if ((localBitmap == null) || (localBitmap.isRecycled())) {}
    do
    {
      do
      {
        return;
        localBitmap = Bitmap.createBitmap(localBitmap);
        if (this.eKd != 1000) {
          break;
        }
      } while (this.jdField_a_of_type_Ayil == null);
      this.jdField_a_of_type_Ayil.a(paramInteractPasterParcelData.jn, localBitmap, paramInteractPasterParcelData.g, paramInteractPasterParcelData.scaleValue, paramInteractPasterParcelData.nI, paramInteractPasterParcelData.translateXValue, paramInteractPasterParcelData.translateYValue, false);
      return;
    } while ((this.eKd != 1001) || (this.jdField_a_of_type_Ayoy == null));
    this.jdField_a_of_type_Ayoy.b(paramInteractPasterParcelData.jn, localBitmap, paramInteractPasterParcelData.g, paramInteractPasterParcelData.scaleValue, paramInteractPasterParcelData.nI, paramInteractPasterParcelData.translateXValue, paramInteractPasterParcelData.translateYValue, false);
  }
  
  public boolean aQs()
  {
    if (this.eKd == 1000) {
      return this.jdField_a_of_type_Ayil.aQH();
    }
    if (this.eKd == 1001) {
      return this.jdField_a_of_type_Ayoy.aQU();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.eKd);
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    super.d(paramInt1, paramInt2, paramObject);
    dLp();
  }
  
  public void dLp()
  {
    if ((this.mContainerView != null) && (this.mContainerView.getVisibility() == 0))
    {
      this.mContainerView.setVisibility(8);
      ((ViewGroup)this.jdField_a_of_type_Ayii.getRootView()).removeView(this.mContainerView);
      this.mContainerView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      localObject = null;
      rar.b((Activity)paramView.getContext(), "sticker_element", "0", (String)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131382083: 
    case 2131382084: 
      localObject = f(this.eKd);
      this.b.r(35, localObject);
      cC(1001, false);
      this.eKd = 1000;
      if (paramView.getId() == 2131382083) {
        rar.b("clk_vote_entry", RR(), 1, new String[0]);
      }
      for (;;)
      {
        localObject = "0";
        break;
        if (paramView.getId() == 2131382084) {
          rar.b("interact_cover", RR(), 1, new String[0]);
        }
      }
    }
    Object localObject = f(this.eKd);
    ((Bundle)localObject).putInt("interact_type", 1001);
    this.b.r(38, localObject);
    cC(1000, false);
    this.eKd = 1001;
    if (paramView.getId() == 2131376626) {
      rar.b("clk_vote_entry", RR(), 2, new String[0]);
    }
    for (;;)
    {
      localObject = "1";
      break;
      if (paramView.getId() == 2131376627) {
        rar.b("interact_cover", RR(), 2, new String[0]);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    a(aydl.class, this);
    if (this.dza) {}
    while (this.b.a.mMode != 0) {
      return;
    }
    this.b.b().getRootView().postDelayed(new EditVideoInteractFace.1(this), 1000L);
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Ayii == null) || (this.mContainerView == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoInteractFace", 2, "initTransitionRecommendView onGlobalLayout null");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = this.mContainerView.getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
      }
      localObject = this.b.c(8L);
    } while (localObject == null);
    int i = ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth() / 2;
    int k = this.mContainerView.getWidth() * 107 / 230;
    this.mContainerView.setX(j + i - k);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygn
 * JD-Core Version:    0.7.0.1
 */