package com.tencent.biz.lebasearch;

import aevs;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqhu;
import aqju;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import jsd;
import jse;
import jsf;
import jsh;
import jsi;
import wja;
import zjq;

public class LebaSearchPluginManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static int ICON_HEIGHT = 110;
  public static double aM = 0.5D;
  static double aN = 0.4D;
  public aevs a;
  public AccountDetailBounceScrollView a;
  byte aI;
  private boolean abs = true;
  private boolean abt;
  protected Button bC;
  Bitmap bR;
  public float density;
  public LinearLayout dp;
  List<aevs> fK = null;
  ImageView hl;
  ImageView hm;
  protected ImageView hn;
  public View iI;
  Handler mHandler = new jsi(this);
  View mRoot;
  protected TextView nr;
  public TextView ns;
  protected TextView nt;
  aqju p = null;
  long qy = -1L;
  aqju r = null;
  public int screenHeight = 0;
  
  public LebaSearchPluginManagerActivity()
  {
    this.jdField_a_of_type_Aevs = null;
  }
  
  private void azh()
  {
    if (this.jdField_a_of_type_Aevs.bo == 0)
    {
      this.bC.setBackgroundResource(2130839541);
      this.bC.setText(2131698209);
      if (this.jdField_a_of_type_Aevs.bo == this.aI) {
        break label71;
      }
    }
    label71:
    for (int i = -1;; i = 0)
    {
      setResult(i);
      return;
      this.bC.setBackgroundResource(2130839524);
      this.bC.setText(2131698213);
      break;
    }
  }
  
  private void initView()
  {
    this.mRoot = findViewById(2131377546);
    this.iI = findViewById(2131373418);
    this.iI.getViewTreeObserver().addOnGlobalLayoutListener(new jsd(this));
    this.mRoot.addOnLayoutChangeListener(new jse(this));
    this.dp = ((LinearLayout)super.findViewById(2131366130));
    ((RelativeLayout.LayoutParams)this.iI.getLayoutParams()).height = ((int)(this.screenHeight * aM));
    this.dp.setMinimumHeight((int)(this.screenHeight - getTitleBarHeight() - 56.0F * this.density));
    this.bC = ((Button)findViewById(2131378105));
    this.bC.setOnClickListener(this);
    this.ns = ((TextView)findViewById(2131373414));
    this.hn = ((ImageView)findViewById(2131373417));
    this.hl = ((ImageView)super.findViewById(2131368710));
    this.hl.setBackgroundResource(2130842444);
    this.hm = ((ImageView)super.findViewById(2131380016));
    this.nr = ((TextView)findViewById(2131373422));
    this.nt = ((TextView)findViewById(2131369579));
    this.nt.setText(getString(2131691039));
    this.nt.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView = ((AccountDetailBounceScrollView)super.findViewById(2131378501));
    if (!this.abs)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.hn.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.hl.getLayoutParams();
      if ((localObject1 != null) && (localObject2 != null))
      {
        int i = wja.dp2px(4.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject1).topMargin += i;
        ((RelativeLayout.LayoutParams)localObject2).topMargin += i;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setOnTouchListener(new jsf(this));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setOnScrollChangedListener(new jsh(this));
    Object localObject2 = this.jdField_a_of_type_Aevs.a;
    if (this.bR == null) {}
    for (Object localObject1 = null;; localObject1 = new BitmapDrawable(getResources(), this.bR))
    {
      this.hn.setImageDrawable((Drawable)localObject1);
      this.nr.setText(((LebaPluginInfo)localObject2).strResName);
      localObject1 = findViewById(2131370423);
      if (!this.abs) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#59D3FF"));
      }
      azh();
      return;
    }
  }
  
  private void lv(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.p == null) {
        this.p = Utils.createPluginSetDialogForMain(this.app, this, 1, this.jdField_a_of_type_Aevs.a.uiResId, this.jdField_a_of_type_Aevs.a.strResName, null, this.mHandler);
      }
      if (!this.p.isShowing()) {}
    }
    do
    {
      return;
      this.p.show();
      return;
      if (this.r == null) {
        this.r = Utils.createPluginSetDialogForMain(this.app, this, 2, this.jdField_a_of_type_Aevs.a.uiResId, this.jdField_a_of_type_Aevs.a.strResName, "", this.mHandler);
      }
    } while (this.r.isShowing());
    this.r.show();
  }
  
  private void ob(int paramInt)
  {
    this.screenHeight = paramInt;
    aM = this.iI.getHeight() / this.screenHeight;
    ((RelativeLayout.LayoutParams)this.iI.getLayoutParams()).height = ((int)(this.screenHeight * aM));
    this.dp.setMinimumHeight((int)(this.screenHeight - getTitleBarHeight() - this.density * 56.0F));
    paramInt = (int)(this.dp.getHeight() - this.screenHeight * (1.0D - aM) + this.density * 56.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setMaxOverScrollY(paramInt);
    if (this.abs)
    {
      oc(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY());
      od(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY());
    }
    this.mRoot.postInvalidate();
  }
  
  @TargetApi(11)
  private void od(int paramInt)
  {
    int j;
    if (paramInt >= 0)
    {
      if (!this.abt) {
        break label53;
      }
      j = 460;
    }
    for (int i = 443;; i = (int)(0.29D * this.screenHeight))
    {
      paramInt = this.iI.getHeight() - paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        break label88;
      }
      if (paramInt > i) {
        break;
      }
      this.nr.setVisibility(8);
      return;
      label53:
      j = (int)(0.39D * this.screenHeight);
    }
    this.nr.setVisibility(0);
    return;
    label88:
    if ((paramInt <= j) && (paramInt >= i))
    {
      float f;
      if (paramInt - i <= 0.01D * this.screenHeight) {
        f = 0.05F;
      }
      for (;;)
      {
        this.nr.setAlpha(f);
        return;
        if (paramInt - i <= 0.02D * this.screenHeight) {
          f = 0.15F;
        } else if (paramInt - i <= 0.03D * this.screenHeight) {
          f = 0.25F;
        } else if (paramInt - i <= 0.04D * this.screenHeight) {
          f = 0.35F;
        } else if (paramInt - i <= 0.05D * this.screenHeight) {
          f = 0.45F;
        } else if (paramInt - i <= 0.06D * this.screenHeight) {
          f = 0.55F;
        } else if (paramInt - i <= 0.07000000000000001D * this.screenHeight) {
          f = 0.65F;
        } else if (paramInt - i <= this.screenHeight * 0.08D) {
          f = 0.75F;
        } else if (paramInt - i <= this.screenHeight * 0.08D) {
          f = 0.85F;
        } else {
          f = 0.95F;
        }
      }
    }
    if (paramInt < i)
    {
      this.nr.setAlpha(0.0F);
      return;
    }
    this.nr.setAlpha(1.0F);
  }
  
  private boolean vz()
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.screenHeight = (getResources().getDisplayMetrics().heightPixels - i);
    this.density = super.getResources().getDisplayMetrics().density;
    this.qy = getIntent().getLongExtra("id", 0L);
    this.fK = zjq.a().dp();
    localObject = this.fK.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aevs localaevs = (aevs)((Iterator)localObject).next();
      if ((localaevs.a != null) && (localaevs.a.uiResId == this.qy)) {
        this.jdField_a_of_type_Aevs = localaevs;
      }
    }
    if ((this.jdField_a_of_type_Aevs == null) || (this.jdField_a_of_type_Aevs.a == null)) {
      return false;
    }
    this.aI = this.jdField_a_of_type_Aevs.bo;
    try
    {
      localObject = BitmapFactory.decodeResource(getResources(), 2130843183);
      this.bR = aqhu.r((Bitmap)localObject, 110, 110);
      ((Bitmap)localObject).recycle();
      label192:
      if ((Build.BRAND.startsWith("samsung")) || (Build.BRAND.startsWith("Coolpad"))) {}
      for (this.abs = false;; this.abs = true)
      {
        this.abt = Build.BOARD.equals("mx");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label192;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2131560011);
    zjq.cdv |= 0x1;
    if (!vz())
    {
      finish();
      return false;
    }
    initView();
    if (this.qy == 886L) {
      anot.a(this.app, "dc00899", "Grp_nearby", "", "dyn_set", "visit_nearby_intro", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.bR != null) && (!this.bR.isRecycled())) {
      this.bR.recycle();
    }
    super.doOnDestroy();
  }
  
  public void oc(int paramInt)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    ((RelativeLayout.LayoutParams)this.iI.getLayoutParams()).height = ((int)(this.screenHeight * aM));
    this.dp.setMinimumHeight((int)(this.screenHeight - getTitleBarHeight() - 56.0F * this.density));
    i = this.iI.getHeight() - paramInt;
    localObject = (RelativeLayout.LayoutParams)this.hn.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.hl.getLayoutParams();
    double d1 = aM;
    double d2 = (aN * d1 - 0.05D) / (d1 - 0.3D);
    double d3 = (i - this.screenHeight * 0.3D) / ((d1 - 0.3D) * this.screenHeight);
    if (i <= this.screenHeight * 0.3D)
    {
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(30.0F * this.density));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(30.0F * this.density));
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.screenHeight * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
      localLayoutParams.height = ((int)(32.0F * this.density));
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 1.0F * this.density));
    }
    for (;;)
    {
      this.hn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.hl.setLayoutParams(localLayoutParams);
      return;
      if (i >= d1 * this.screenHeight)
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(ICON_HEIGHT * this.density));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * aN - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + 10.0F * this.density));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 5.0F * this.density));
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)((30.0D + (ICON_HEIGHT - 30) * d3) * this.density));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((i - this.screenHeight * 0.3D) * d2 + this.screenHeight * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + (1.0D + 9.0D * d3) * this.density));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - (1.0D + 9.0D * d3) * this.density / 2.0D));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Aevs.bo != 0) {}
      for (boolean bool = true;; bool = false)
      {
        lv(bool);
        break;
      }
      finish();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity
 * JD-Core Version:    0.7.0.1
 */