package com.tencent.mobileqq.activity.contact.troop;

import abfy;
import abfy.a;
import acms;
import acnd;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import apuh;
import aqdj;
import aqhu;
import aqiw;
import auuo;
import com.tencent.biz.ui.MultiLineLayout;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import ywq;
import ywr;
import yws;
import ywt;

public class ShowExternalTroopListActivity
  extends IphoneTitleBarActivity
  implements abfy.a, View.OnClickListener, auuo
{
  protected TextView Mc;
  protected TextView Md;
  public TextView Me;
  public abfy a;
  public String aZM = null;
  String aZN = null;
  protected acnd b;
  protected TroopManager b;
  protected boolean bpu;
  protected RedDotTextView c;
  public int cbG;
  public Activity context;
  protected Button eq;
  public View.OnClickListener eu = new yws(this);
  public boolean gV;
  protected View header;
  public PullRefreshHeader i;
  protected RelativeLayout io;
  public Handler mHandler = new ywt(this);
  public XListView mListView;
  public boolean xv;
  
  public ShowExternalTroopListActivity()
  {
    this.jdField_b_of_type_Acnd = new ywq(this);
  }
  
  private boolean UK()
  {
    if (aqiw.isNetworkAvailable(getActivity()))
    {
      ((acms)this.app.getBusinessHandler(20)).ad(this.aZM, 0, 0);
      this.gV = true;
      return true;
    }
    QQToast.a(this, 2130840117, getString(2131699827), 0).show(getResources().getDimensionPixelSize(2131299627));
    return false;
  }
  
  private void cmy()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).edit().putLong("rec_last_ext_show_troop_list_refresh_time", l).commit();
  }
  
  private long ex()
  {
    return getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).getLong("rec_last_ext_show_troop_list_refresh_time", 0L);
  }
  
  private void initViews()
  {
    setContentViewNoTitle(2131560866);
    Object localObject1 = (LinearLayout)findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((LinearLayout)localObject1).setFitsSystemWindows(true);
    }
    setTitle(2131698396);
    this.Mc = ((TextView)findViewById(2131369579));
    Intent localIntent = getIntent();
    this.xv = localIntent.getExtras().getBoolean("isHost");
    Object localObject2 = localIntent.getExtras().getString("leftViewText");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getString(2131691039);
    }
    this.Mc.setText((CharSequence)localObject1);
    this.Mc.setOnClickListener(this);
    this.c = ((RedDotTextView)findViewById(2131369612));
    this.c.setContentDescription(getString(2131698399));
    this.c.setText(2131698398);
    this.c.setOnClickListener(this);
    String str;
    if (!this.xv)
    {
      this.c.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.c);
      this.io = ((RelativeLayout)findViewById(2131374472));
      localObject1 = LayoutInflater.from(this).inflate(2131560865, null);
      this.Me = ((TextView)((View)localObject1).findViewById(2131380396));
      this.Me.setText(getString(2131698445));
      this.Md = ((TextView)findViewById(2131372416));
      this.eq = ((Button)findViewById(2131378094));
      this.eq.setOnClickListener(this);
      if (!this.xv) {
        this.eq.setVisibility(8);
      }
      this.mListView = ((XListView)findViewById(2131374356));
      this.mListView.setContentBackground(2130851805);
      this.header = LayoutInflater.from(this).inflate(2131560789, this.mListView, false);
      this.mListView.addHeaderView(this.header);
      if (this.xv) {
        this.mListView.addHeaderView((View)localObject1);
      }
      this.aZM = localIntent.getExtras().getString("dest_uin_str");
      this.aZN = localIntent.getExtras().getString("from_troop_uin");
      this.a = new abfy(getActivity(), this.app, this, this.mListView, this.xv, this.aZM);
      this.mListView.setAdapter(this.a);
      this.a.notifyDataSetChanged();
      this.i = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559847, this.mListView, false));
      this.mListView.setOverScrollHeader(this.i);
      this.mListView.setOverScrollListener(this);
      this.mListView.setContentBackground(2130838901);
      localObject2 = this.app;
      str = this.aZM;
      if (!this.xv) {
        break label561;
      }
    }
    label561:
    for (localObject1 = "0";; localObject1 = "1")
    {
      anot.a((QQAppInterface)localObject2, "P_CliOper", "Grp_join", "", "person_data", "exp_grp", 0, 0, str, (String)localObject1, "" + localIntent.getIntExtra("from", 0), "");
      return;
      this.c.setVisibility(0);
      break;
    }
  }
  
  private void updateView()
  {
    ImageView localImageView = (ImageView)this.header.findViewById(2131368962);
    Object localObject = aqhu.aU();
    localImageView.setImageDrawable(aqdj.a(this.app, 1, this.aZM, 3, (Drawable)localObject, (Drawable)localObject));
    this.header.findViewById(2131365360).bringToFront();
    ThreadManager.post(new ShowExternalTroopListActivity.2(this), 8, null, true);
    localObject = (TextView)this.header.findViewById(2131370126);
    ThreadManager.post(new ShowExternalTroopListActivity.3(this, (TextView)this.header.findViewById(2131372361), (TextView)localObject), 8, null, true);
    localImageView.setOnClickListener(new ywr(this, localImageView));
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.i.Q(ex());
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.i.S(ex());
    if ((!UK()) && (this.mHandler != null)) {
      this.mHandler.sendEmptyMessageDelayed(101, 1000L);
    }
    return true;
  }
  
  public void ab(List<String> paramList, boolean paramBoolean)
  {
    MultiLineLayout localMultiLineLayout = (MultiLineLayout)this.header.findViewById(2131379200);
    localMultiLineLayout.setShowLine(2);
    localMultiLineLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < paramList.size())
      {
        TextView localTextView = new TextView(this);
        localTextView.setBackgroundResource(2130844712);
        localTextView.setTextSize(2, 14.0F);
        if (paramBoolean) {
          localTextView.setMaxWidth((int)(77.0F * this.mDensity));
        }
        localTextView.setSingleLine();
        localTextView.setTextColor(-1);
        localTextView.setShadowLayer(0.0F, 0.0F, 2.0F, Color.parseColor("#000000"));
        localTextView.setGravity(17);
        localTextView.setText((CharSequence)paramList.get(j));
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localMultiLineLayout.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        localTextView.setOnClickListener(this.eu);
        j += 1;
      }
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.i.R(ex());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null)) {
      this.bpu = paramIntent.getBooleanExtra("isDataChanged", false);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.context = this;
    this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
    addObserver(this.jdField_b_of_type_Acnd);
    initViews();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_b_of_type_Acnd);
    if (this.a != null) {
      this.a.destroy();
    }
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isDataChanged", this.bpu);
      setResult(-1, localIntent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    removeObserver(this.jdField_b_of_type_Acnd);
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.xv)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.eh().size() == 0))
      {
        showEmptyView();
        return;
      }
      this.io.setVisibility(8);
      this.mListView.setAdapter(this.a);
    }
    UK();
    updateView();
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    addObserver(this.jdField_b_of_type_Acnd);
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    switch (j)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 0);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.putExtra("is_from_show_ext_troop_list", true);
      localIntent.setClass(this, TroopActivity.class);
      startActivityForResult(localIntent, 1);
      if (j == 2131369612)
      {
        anot.a(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_mana", 0, 0, "", "", "", "");
      }
      else if (j == 2131378094)
      {
        anot.a(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_set", 0, 0, "", "", "", "");
        continue;
        localIntent = new Intent();
        localIntent.putExtra("isDataChanged", this.bpu);
        setResult(-1, localIntent);
        onBackPressed();
      }
    }
  }
  
  public Bitmap s(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int m = 0;
    if (paramBitmap == null) {
      paramBitmap = localBitmap;
    }
    label161:
    do
    {
      return paramBitmap;
      int n = getResources().getDisplayMetrics().widthPixels;
      int i1 = (int)(120.0F * this.mDensity);
      int j = paramBitmap.getHeight();
      int k = paramBitmap.getWidth();
      if (k * i1 > j * n)
      {
        i1 = n * j / i1;
        n = (k - i1) / 2;
        k = i1;
      }
      for (;;)
      {
        if ((j != 0) && (k != 0)) {
          break label161;
        }
        paramBitmap = localBitmap;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IphoneTitleBarActivity", 2, "getMidBitmap error! height = " + j + " ;width = " + k);
        return null;
        n = i1 * k / n;
        m = (j - n) / 2;
        j = n;
        n = 0;
      }
      localBitmap = Bitmap.createBitmap(paramBitmap, n, m, k, j);
      paramBitmap = localBitmap;
    } while (localBitmap.isMutable());
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2, true);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      localBitmap.recycle();
    }
    return paramBitmap;
  }
  
  public void showEmptyView()
  {
    if (this.gV) {
      return;
    }
    this.Me.setVisibility(8);
    this.io.setVisibility(0);
    this.mListView.setAdapter(null);
    if (this.xv)
    {
      this.Md.setCompoundDrawablesWithIntrinsicBounds(0, 2130844668, 0, 0);
      this.Md.setText(2131698405);
      anot.a(this.app, "P_CliOper", "Grp_join", "", "join_page", "exp_blank", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.mListView.setEmptyView(this.io);
      return;
      this.Md.setCompoundDrawablesWithIntrinsicBounds(0, 2130844558, 0, 0);
      this.Md.setText(2131698408);
      QQToast.a(this, 1, getString(2131698407), 0).show(getTitleBarHeight());
    }
  }
  
  public void zn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = TroopInfoActivity.c(paramString, 18);
    Activity localActivity = getActivity();
    if (this.xv) {}
    for (int j = 1;; j = 2)
    {
      apuh.a(localActivity, localBundle, j);
      if (!this.xv) {
        break;
      }
      anot.a(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "1", "", "");
      return;
    }
    anot.a(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "0", "", "");
  }
  
  public static abstract interface a
  {
    public abstract void bf(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity
 * JD-Core Version:    0.7.0.1
 */