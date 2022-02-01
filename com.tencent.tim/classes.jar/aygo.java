import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.JobSegment;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class aygo
  extends aygy
  implements View.OnClickListener, aydl
{
  private ImageView IS;
  private ImageView IT;
  private ayil jdField_a_of_type_Ayil;
  private ayoy jdField_a_of_type_Ayoy;
  private rsr jdField_a_of_type_Rsr;
  private rpg.a c;
  private FrameLayout cH;
  private int eKd;
  private int eKe;
  private View mRootView;
  private ViewStub n;
  private TextView uj;
  
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
  
  private void afj(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.c = rpg.a(getContext(), 0, 0, null);
      this.c.tW(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.c.getView().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfi = this.c.a();
        paramInt = 0;
        while (paramInt < arrayOfi.length)
        {
          arrayOfi[paramInt].setText(localObject.jr[paramInt]);
          paramInt += 1;
        }
        this.uj.setText(this.c.a().getText());
        this.cH.removeAllViews();
        this.cH.addView(this.c.getView());
        this.c.tZ(true);
        if (this.jdField_a_of_type_Rsr != null) {
          this.jdField_a_of_type_Rsr.uk(false);
        }
        this.IS.setBackgroundResource(2130845385);
        this.IT.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        rpg.i[] arrayOfi;
        return;
        this.c.a().setHint(acfp.m(2131705638));
        this.uj.setText("");
        this.uj.setHint(acfp.m(2131705651));
      }
    }
    this.jdField_a_of_type_Rsr = new rsr(getContext());
    this.jdField_a_of_type_Rsr.setRatable(false);
    this.jdField_a_of_type_Rsr.setRate(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_Rsr.az().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_Rsr.t(((aypc.b)localObject).jn);
      this.uj.setText(localObject.jn[0]);
    }
    for (;;)
    {
      this.cH.removeAllViews();
      this.cH.addView(this.jdField_a_of_type_Rsr.az());
      this.jdField_a_of_type_Rsr.uk(true);
      if (this.c != null) {
        this.c.tZ(false);
      }
      this.IT.setBackgroundResource(2130845385);
      this.IS.setBackgroundResource(0);
      return;
      this.uj.setText("");
      this.uj.setHint(acfp.m(2131705530));
    }
  }
  
  private void bsk()
  {
    if (this.mRootView == null)
    {
      this.mRootView = this.n.inflate();
      this.cH = ((FrameLayout)this.mRootView.findViewById(2131373574));
      this.IS = ((ImageView)this.mRootView.findViewById(2131382083));
      this.IS.setOnClickListener(this);
      this.IT = ((ImageView)this.mRootView.findViewById(2131376626));
      this.IT.setOnClickListener(this);
      this.uj = ((TextView)this.mRootView.findViewById(2131369276));
      this.uj.setOnClickListener(this);
      this.mRootView.findViewById(2131363243).setOnClickListener(this);
    }
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
  
  public JobSegment<ayqb, ayqb> a(int paramInt)
  {
    if (this.eKd == 1000) {
      return null;
    }
    if (this.eKd == 1001) {
      return this.jdField_a_of_type_Ayoy.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.eKd);
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
  
  public void a(InteractPasterParcelData paramInteractPasterParcelData) {}
  
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
  
  public boolean onBackPressed()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mRootView != null)
    {
      bool1 = bool2;
      if (this.mRootView.getVisibility() == 0)
      {
        this.b.changeState(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131382083: 
    case 2131376626: 
    case 2131369276: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.eKe = 1000;
        afj(1000);
        continue;
        this.eKe = 1001;
        afj(1001);
        continue;
        localObject = f(this.eKd);
        this.eKd = this.eKe;
        if (this.eKe == 1000)
        {
          this.b.r(35, localObject);
        }
        else
        {
          ((Bundle)localObject).putInt("interact_type", this.eKe);
          this.b.r(38, localObject);
        }
      }
    }
    if (this.eKe == 1000)
    {
      localObject = this.c.a();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].ub(false);
        i += 1;
      }
      localObject = this.c.getBitmap();
      rpg.i[] arrayOfi = this.c.a();
      Rect[] arrayOfRect = new Rect[arrayOfi.length];
      String[] arrayOfString = new String[arrayOfi.length];
      i = 0;
      while (i < arrayOfi.length)
      {
        arrayOfRect[i] = arrayOfi[i].getRect();
        arrayOfString[i] = arrayOfi[i].getText().toString();
        i += 1;
      }
      this.jdField_a_of_type_Ayil.a(f(this.eKd), arrayOfString, (Bitmap)localObject, arrayOfRect, false);
    }
    for (;;)
    {
      this.eKd = this.eKe;
      this.b.changeState(0);
      break;
      if (this.eKe == 1001)
      {
        this.jdField_a_of_type_Rsr.uj(false);
        localObject = f(this.eKd);
        ((Bundle)localObject).putInt("interact_type", 1001);
        this.jdField_a_of_type_Ayoy.a((Bundle)localObject, new aypc.b(this.jdField_a_of_type_Rsr.aa(), this.jdField_a_of_type_Rsr.C(), this.jdField_a_of_type_Rsr.a(), false));
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.n = ((ViewStub)y(2131369316));
    a(aydl.class, this);
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.mRootView != null) && (this.mRootView.getVisibility() == 0)) {
        this.mRootView.setVisibility(8);
      }
      return;
      bsk();
      this.mRootView.setVisibility(0);
      cC(this.eKd, false);
      afj(this.eKd);
      return;
      cC(this.eKd, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygo
 * JD-Core Version:    0.7.0.1
 */