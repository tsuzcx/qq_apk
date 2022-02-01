package com.tencent.device.msg.activities;

import acej;
import acfp;
import aczy;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqge;
import arxa;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import jjh;
import jll;
import syw;
import szt;
import szu;
import tao;
import tas;

public class DeviceTipActivity
  extends BaseActivity
{
  public static String TAG = "DeviceTipActivity";
  public static boolean aOh;
  private static int bAp = 30000;
  BroadcastReceiver X = null;
  DeviceInfo a;
  String aIh;
  String aIi = "";
  Rect aj = null;
  Rect ak = null;
  Rect al = null;
  int axf = 0;
  ShimmerTextView b = null;
  int bAq = 0;
  int bAr = 0;
  Runnable bJ = new DeviceTipActivity.1(this);
  Button cH = null;
  Button cI = null;
  Button cJ;
  Bitmap dg;
  LinearLayout fr = null;
  ImageView gG = null;
  ImageView gH = null;
  ImageView gI = null;
  ImageView gL = null;
  RelativeLayout ge = null;
  private final Handler mHandler = new Handler();
  int mLastX = 0;
  TextView mNameView = null;
  Bundle mParams = null;
  int mScreenHeight;
  TextView mTipsTextView = null;
  TextView nc;
  View.OnTouchListener o = new b();
  int screenWidth;
  ProgressBar u = null;
  
  private void auk()
  {
    this.ak = new Rect();
    this.ak.top = this.gG.getTop();
    this.ak.bottom = this.gG.getBottom();
    this.ak.left = this.gG.getLeft();
    this.ak.right = this.gG.getRight();
    this.aj = new Rect();
    this.aj.left = this.gG.getLeft();
    this.aj.right = this.gG.getRight();
    this.al = new Rect();
    this.al.top = this.gI.getTop();
    this.al.bottom = this.gI.getBottom();
    this.al.left = this.gI.getLeft();
    this.al.right = this.gI.getRight();
  }
  
  private boolean hasSmartBar()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if ((Build.DEVICE.equals("mx2")) || (Build.DEVICE.equals("mx4pro"))) {
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
        return false;
      }
    }
    return false;
  }
  
  private void init()
  {
    this.X = new a();
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject1).addAction("SmartDevice_receiveDPMsg");
    ((IntentFilter)localObject1).addAction("SmartDevice_ReceiveDPACKMsg");
    ((IntentFilter)localObject1).addAction("On_OccupyMicrophoneNotify_Push");
    super.registerReceiver(this.X, (IntentFilter)localObject1);
    initData();
    initUI();
    this.fr = ((LinearLayout)super.findViewById(2131374238));
    this.mTipsTextView = ((TextView)this.fr.findViewById(2131374233));
    this.u = ((ProgressBar)this.fr.findViewById(2131374239));
    localObject1 = (ImageView)super.findViewById(2131381752);
    Object localObject2 = super.getResources();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2;
    if (this.screenWidth <= 320)
    {
      localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298201);
      ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.fr.getLayoutParams();
      localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298369);
      this.fr.setLayoutParams(localLayoutParams1);
      if ((acej.aV() == 20.0F) || (acej.aV() == 18.0F) || (acej.aV() == 17.0F))
      {
        localLayoutParams1 = (RelativeLayout.LayoutParams)this.nc.getLayoutParams();
        localLayoutParams2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        if (this.screenWidth > 540) {
          break label525;
        }
        localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298378);
        this.nc.setLayoutParams(localLayoutParams1);
        localLayoutParams2.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298203);
        ((ImageView)localObject1).setLayoutParams(localLayoutParams2);
      }
    }
    for (;;)
    {
      if (acej.aV() == 20.0F)
      {
        localObject1 = (Button)super.findViewById(2131374106);
        localObject2 = (RelativeLayout.LayoutParams)((Button)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = super.getResources().getDimensionPixelSize(2131298026);
        ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (Button)super.findViewById(2131374109);
        localObject2 = (RelativeLayout.LayoutParams)((Button)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = super.getResources().getDimensionPixelSize(2131298026);
        ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((this.mScreenHeight <= 800) || ((hasSmartBar()) && (this.mScreenHeight <= 1280)))
      {
        localObject1 = (RelativeLayout)super.findViewById(2131374102);
        localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.mTipsTextView.setText(this.aIi);
      this.mTipsTextView.setVisibility(0);
      aOh = true;
      return;
      if (this.screenWidth > 540) {
        break;
      }
      localLayoutParams1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      int i = ((Resources)localObject2).getDimensionPixelSize(2131298200);
      localLayoutParams1.topMargin = (i - (i - i * 2 / 3));
      ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
      break;
      label525:
      localLayoutParams2.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298201);
      ((ImageView)localObject1).setLayoutParams(localLayoutParams2);
    }
  }
  
  private void initData()
  {
    this.mParams = super.getIntent().getBundleExtra("key_params");
    if (this.mParams == null)
    {
      this.mParams = super.getIntent().getExtras();
      if (this.mParams == null)
      {
        arxa.a().showToast(2131692621);
        return;
      }
    }
    this.aIh = this.mParams.getString("uin");
    this.aIi = this.mParams.getString("digest");
    this.a = ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(this.aIh));
    this.dg = DeviceHeadMgr.getInstance().getDeviceHeadByPID(this.a.productId);
  }
  
  private void ze(int paramInt)
  {
    DataPoint localDataPoint = new DataPoint();
    localDataPoint.mApiName = "set_data_point";
    localDataPoint.mDin = this.a.din;
    localDataPoint.mProperityId = 1600008;
    localDataPoint.mValue = String.valueOf(paramInt);
    localDataPoint.mValueType = "string";
    ((syw)this.app.getBusinessHandler(51)).a(localDataPoint, 0, this.a.din, 3);
  }
  
  public void bCg()
  {
    if (this.a != null)
    {
      tao localtao = new tao(this);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_tip", true);
      localtao.a(this.a, localBundle, false);
      ((syw)this.app.getBusinessHandler(51)).ag(this.a.din, this.a.productId);
      ze(1);
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.screenWidth = jll.getScreenWidth(super.getApplicationContext());
    this.mScreenHeight = jll.getScreenHeight(super.getApplicationContext());
    super.setContentView(2131559221);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    super.getWindow().addFlags(2097152);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!aczy.bd(this)) {
        aczy.a(this, 3, new szt(this));
      }
    }
    for (;;)
    {
      return true;
      init();
      continue;
      init();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDestroy");
    }
    aqge.bVz();
    if (this.X != null) {
      super.unregisterReceiver(this.X);
    }
    aOh = false;
    this.X = null;
    this.gG = null;
    this.gH = null;
    this.cH = null;
    this.cI = null;
    this.b = null;
    this.aj = null;
    this.ak = null;
    this.al = null;
    this.gI = null;
    this.o = null;
    this.fr = null;
    this.mTipsTextView = null;
    this.u = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aqge.a(2131230755, -1, null);
    this.mHandler.postDelayed(this.bJ, bAp);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    aqge.bVz();
  }
  
  protected void initUI()
  {
    this.ge = ((RelativeLayout)super.findViewById(2131381740));
    this.gI = ((ImageView)super.findViewById(2131373954));
    this.gG = ((ImageView)super.findViewById(2131374103));
    this.gG.setBackgroundResource(2130843019);
    this.gG.setOnTouchListener(this.o);
    this.cH = ((Button)super.findViewById(2131374109));
    this.cI = ((Button)super.findViewById(2131374108));
    Drawable localDrawable = super.getResources().getDrawable(2130842828);
    this.cI.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
    this.cI.setText(acfp.m(2131705024));
    this.cI.setOnClickListener(new szu(this));
    this.axf = super.getApplicationContext().getResources().getDimensionPixelSize(2131298212);
    this.b = ((ShimmerTextView)super.findViewById(2131374105));
    this.b.setText(acfp.m(2131705025));
    this.gH = ((ImageView)super.findViewById(2131374104));
    localDrawable = jjh.d(super.getApplicationContext(), 2130842960);
    if (localDrawable != null) {
      this.ge.setBackgroundDrawable(localDrawable);
    }
    for (;;)
    {
      this.gL = ((ImageView)super.findViewById(2131381752));
      if (this.dg != null) {
        this.gL.setImageBitmap(this.dg);
      }
      this.mNameView = ((TextView)super.findViewById(2131381753));
      if (this.a != null) {
        this.mNameView.setText(tas.a(this.a));
      }
      this.nc = ((TextView)super.findViewById(2131374265));
      this.cH.setVisibility(8);
      this.nc.setVisibility(8);
      this.cJ = ((Button)super.findViewById(2131374106));
      this.cJ.setVisibility(8);
      return;
      this.ge.setBackgroundResource(2130842960);
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    @TargetApi(12)
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if ((paramContext != null) && (paramContext.equals("homekey"))) {
          DeviceTipActivity.this.finish();
        }
      }
      long l;
      do
      {
        do
        {
          do
          {
            return;
            if (paramContext.equals("android.intent.action.SCREEN_OFF"))
            {
              aqge.bVz();
              return;
            }
            if (paramContext.equals("android.intent.action.SCREEN_ON"))
            {
              aqge.a(2131230755, -1, null);
              return;
            }
            if (!paramContext.equals("SmartDevice_receiveDPMsg")) {
              break;
            }
          } while ((DataPoint)paramIntent.getExtras().getParcelable("dataPoint") != null);
          return;
        } while (!paramContext.equals("On_OccupyMicrophoneNotify_Push"));
        if (QLog.isColorLevel()) {
          QLog.d(DeviceTipActivity.TAG, 2, "DeviceTipActivity intent.getExtras() : " + paramIntent.getExtras());
        }
        paramContext = paramIntent.getExtras();
        l = paramContext.getLong("din", 0L);
        paramContext = paramContext.getString("uin", "");
      } while ((!DeviceTipActivity.this.aIh.equals(String.valueOf(Long.valueOf(l)))) || (TextUtils.isEmpty(paramContext)));
      DeviceTipActivity.this.finish();
    }
  }
  
  class b
    implements View.OnTouchListener
  {
    b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        DeviceTipActivity.this.mLastX = ((int)paramMotionEvent.getRawX());
        DeviceTipActivity.c(DeviceTipActivity.this);
        continue;
        int i = (int)paramMotionEvent.getRawX() - DeviceTipActivity.this.mLastX;
        if (i > 2)
        {
          DeviceTipActivity.this.b.setVisibility(4);
          DeviceTipActivity.this.gH.setVisibility(4);
        }
        paramView = DeviceTipActivity.this.aj;
        paramView.left += i;
        paramView = DeviceTipActivity.this.aj;
        paramView.right = (i + paramView.right);
        if (DeviceTipActivity.this.aj.right >= DeviceTipActivity.this.axf)
        {
          DeviceTipActivity.this.aj.right = DeviceTipActivity.this.axf;
          DeviceTipActivity.this.aj.left = (DeviceTipActivity.this.aj.right - DeviceTipActivity.this.gG.getWidth());
        }
        if (DeviceTipActivity.this.aj.left <= DeviceTipActivity.this.bAr)
        {
          DeviceTipActivity.this.aj.left = DeviceTipActivity.this.bAr;
          DeviceTipActivity.this.aj.right = (DeviceTipActivity.this.aj.left + DeviceTipActivity.this.gG.getWidth());
        }
        DeviceTipActivity.this.gG.layout(DeviceTipActivity.this.aj.left, DeviceTipActivity.this.ak.top, DeviceTipActivity.this.aj.right, DeviceTipActivity.this.ak.bottom);
        DeviceTipActivity.this.gI.layout(DeviceTipActivity.this.aj.left - DeviceTipActivity.this.bAr, DeviceTipActivity.this.al.top, DeviceTipActivity.this.al.right, DeviceTipActivity.this.al.bottom);
        DeviceTipActivity.this.mLastX = ((int)paramMotionEvent.getRawX());
        continue;
        if (DeviceTipActivity.this.aj.right == DeviceTipActivity.this.axf)
        {
          DeviceTipActivity.this.bCg();
        }
        else if (DeviceTipActivity.this.aj.right < DeviceTipActivity.this.axf)
        {
          DeviceTipActivity.this.gG.layout(DeviceTipActivity.this.ak.left, DeviceTipActivity.this.ak.top, DeviceTipActivity.this.ak.right, DeviceTipActivity.this.ak.bottom);
          DeviceTipActivity.this.gI.layout(DeviceTipActivity.this.al.left, DeviceTipActivity.this.al.top, DeviceTipActivity.this.al.right, DeviceTipActivity.this.al.bottom);
          DeviceTipActivity.this.b.setVisibility(0);
          DeviceTipActivity.this.gH.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity
 * JD-Core Version:    0.7.0.1
 */