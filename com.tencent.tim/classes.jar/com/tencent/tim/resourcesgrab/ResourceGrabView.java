package com.tencent.tim.resourcesgrab;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import aqnm;
import aujj;
import aujm;
import aujn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

public class ResourceGrabView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button H;
  private long aQ;
  TextView afs;
  private WeakReference<Activity> bn;
  private Application.ActivityLifecycleCallbacks d = new aujn(this);
  private boolean diY;
  boolean diZ = false;
  private Button hI;
  private Button hJ;
  private Button hK;
  private WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
  private WindowManager mWindowManager;
  
  public ResourceGrabView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ResourceGrabView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ResourceGrabView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559034, this, true);
    initView();
  }
  
  private Fragment d()
  {
    Activity localActivity = getCurActivity();
    if ((localActivity instanceof FragmentActivity)) {
      return ((FragmentActivity)localActivity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
    }
    return null;
  }
  
  private void evp()
  {
    setOnTouchListener(new aujm(this));
  }
  
  private void evr()
  {
    Button localButton = this.hI;
    if (this.diY)
    {
      str = "关闭";
      localButton.setText(str);
      localButton = this.hJ;
      if (!this.diZ) {
        break label47;
      }
    }
    label47:
    for (String str = "不发送";; str = "发送")
    {
      localButton.setText(str);
      return;
      str = "开启";
      break;
    }
  }
  
  private Activity getCurActivity()
  {
    Activity localActivity = null;
    if (this.bn != null) {
      localActivity = (Activity)this.bn.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  private void initView()
  {
    this.mWindowManager = ((WindowManager)getContext().getSystemService("window"));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(aqnm.dpToPx(6.0F));
    localGradientDrawable.setColor(-1);
    localGradientDrawable.setStroke(aqnm.dpToPx(1.5F), getResources().getColor(2131167407));
    setBackgroundDrawable(localGradientDrawable);
    this.hI = ((Button)findViewById(2131364012));
    this.hJ = ((Button)findViewById(2131363991));
    this.H = ((Button)findViewById(2131363823));
    this.hK = ((Button)findViewById(2131363815));
    this.afs = ((TextView)findViewById(2131380899));
    this.hI.setOnClickListener(this);
    this.hJ.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.hK.setOnClickListener(this);
    evp();
  }
  
  public void VR(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "enableGrabResourceName on: " + paramBoolean);
    }
    Object localObject = d();
    if (!paramBoolean) {
      if ((localObject instanceof ResourceGrabFragment))
      {
        localObject = (ResourceGrabFragment)localObject;
        ((ResourceGrabFragment)localObject).a(this);
        ((ResourceGrabFragment)localObject).evo();
      }
    }
    do
    {
      return;
      if ((localObject instanceof ResourceGrabFragment))
      {
        localObject = (ResourceGrabFragment)localObject;
        ((ResourceGrabFragment)localObject).a(this);
        ((ResourceGrabFragment)localObject).evl();
        return;
      }
      localObject = getCurActivity();
    } while (!(localObject instanceof FragmentActivity));
    ResourceGrabFragment localResourceGrabFragment = new ResourceGrabFragment();
    localResourceGrabFragment.a(this);
    ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction().add(localResourceGrabFragment, "ResourceGrabFragment").commitAllowingStateLoss();
    localResourceGrabFragment.evl();
  }
  
  public void evq()
  {
    try
    {
      this.mWindowManager.removeView(this);
      aujj.a().a = null;
      VR(false);
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.d);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ResourceGrabView", 1, "hideFromWindow error : " + localException);
    }
  }
  
  void evs()
  {
    this.diY = false;
    this.hI.setText("开启");
    this.diZ = false;
    this.hJ.setText("发送");
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.diY)
      {
        this.hI.setText("开启");
        VR(false);
        Toast.makeText(getContext(), "资源获取功能已关闭", 0).show();
        label95:
        if (this.diY) {
          break label141;
        }
      }
      for (;;)
      {
        this.diY = bool1;
        break;
        this.hI.setText("关闭");
        VR(true);
        Toast.makeText(getContext(), "资源获取功能已开启", 0).show();
        break label95;
        label141:
        bool1 = false;
      }
      if (this.diZ)
      {
        this.hJ.setText("发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已关闭", 0).show();
        label176:
        if (this.diZ) {
          break label219;
        }
      }
      label219:
      for (bool1 = bool2;; bool1 = false)
      {
        this.diZ = bool1;
        break;
        this.hJ.setText("不发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已开启", 0).show();
        break label176;
      }
      evq();
      continue;
      this.afs.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.resourcesgrab.ResourceGrabView
 * JD-Core Version:    0.7.0.1
 */