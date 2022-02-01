package com.tencent.tim.filemanager.activity;

import acde;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqiw;
import atpa;
import atpb;
import atpc;
import auds;
import aviq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Timer;

public class MPFileVerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button O;
  private View P;
  private a a;
  private TextView aZ;
  private QQAppInterface app;
  private long bL;
  private TextView bb;
  private Timer i = new Timer();
  private Activity mContext;
  View mView = null;
  
  public MPFileVerifyPwdView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = ((Activity)paramContext);
    this.app = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, a parama)
  {
    this.a = parama;
    this.mView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131561073, null).findViewById(2131381504);
    return this.mView;
  }
  
  public void finish()
  {
    this.a = null;
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
  }
  
  @TargetApi(11)
  public void ga()
  {
    this.P = this.mView.findViewById(2131381507);
    this.aZ = ((TextView)this.mView.findViewById(2131373866));
    this.aZ.setLongClickable(false);
    this.aZ.addTextChangedListener(new atpa(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.aZ.setTextIsSelectable(false);
      this.aZ.setCustomSelectionActionModeCallback(new atpb(this));
    }
    this.O = ((Button)this.mView.findViewById(2131381505));
    this.O.setOnClickListener(this);
    this.bb = ((TextView)this.mView.findViewById(2131371864));
    this.bb.setText(2131696032);
    this.bb.setTextColor(getResources().getColor(2131165781));
    this.bb.setOnClickListener(new atpc(this));
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      auds.JD(BaseApplicationImpl.getContext().getString(2131696270));
    }
  }
  
  public void gb()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public void gd()
  {
    this.mContext.runOnUiThread(new MPFileVerifyPwdView.4(this));
  }
  
  public void onClick(View paramView)
  {
    String str = this.aZ.getText().toString();
    if ((str == null) || (str.equals(""))) {
      auds.JD(BaseApplicationImpl.getContext().getString(2131696045));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.bb.setEnabled(true);
      this.bb.setTextColor(getResources().getColor(2131165781));
      if (str.length() < 6)
      {
        auds.JD(BaseApplicationImpl.getContext().getString(2131696046));
      }
      else if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
      {
        auds.JD(BaseApplicationImpl.getContext().getString(2131696270));
      }
      else
      {
        acde localacde = (acde)this.app.getBusinessHandler(8);
        localacde.a().j(str);
        this.bL = localacde.a().f(2);
        if (this.a != null) {
          this.a.m(this.bL);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void m(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.MPFileVerifyPwdView
 * JD-Core Version:    0.7.0.1
 */