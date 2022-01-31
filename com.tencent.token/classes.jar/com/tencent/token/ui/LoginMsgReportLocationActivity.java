package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.cg;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.cw;
import com.tencent.token.ds;
import com.tencent.token.er;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.LoginMsgRightLetterView;
import com.tencent.token.ui.base.ProDialog;

public class LoginMsgReportLocationActivity
  extends BaseActivity
{
  private nb mAdapter;
  private ListView mCityList;
  ProDialog mDialogPro = null;
  public Handler mHandler = new no(this);
  private int mIndex;
  private boolean mIsFeedSuccess = false;
  private SafeMsgItem mItem;
  private LoginMsgRightLetterView mLetterList;
  private Button mMenuBarBtn;
  private String mNewLocation;
  private TextView mOverlay;
  private nt mOverlayThread;
  private int mPosition;
  
  private void init()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null) || (ds.a().f == null))
    {
      finish();
      return;
    }
    this.mPosition = getIntent().getExtras().getInt("position");
    this.mItem = ds.a().f.b(this.mPosition);
    this.mCityList = ((ListView)findViewById(2131559004));
    this.mLetterList = ((LoginMsgRightLetterView)findViewById(2131559005));
    this.mLetterList.setOnTouchingLetterChangedListener(new ns(this, null));
    this.mMenuBarBtn = ((Button)findViewById(2131559307));
    this.mMenuBarBtn.setVisibility(0);
    this.mMenuBarBtn.setText(getResources().getString(2131230896));
    this.mMenuBarBtn.setOnClickListener(new nr(this));
    this.mOverlayThread = new nt(this, null);
    initOverlay();
    cg localcg = cg.a();
    h.c("test city: " + localcg.d.length + "|" + localcg.c.length + "|" + localcg.f.length + "|" + localcg.g.length + "|" + localcg.e.length);
    this.mAdapter = new nb(this);
    this.mCityList.setAdapter(this.mAdapter);
  }
  
  private void initOverlay()
  {
    this.mOverlay = ((TextView)LayoutInflater.from(this).inflate(2130968686, null));
    this.mOverlay.setVisibility(4);
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-2, -2, 2, 24, -3);
    ((WindowManager)getSystemService("window")).addView(this.mOverlay, localLayoutParams);
  }
  
  public void cancelRequest()
  {
    cw.a().a(getClass().getName());
  }
  
  public void checkMenuBtnEnable(int paramInt)
  {
    if (paramInt == -1)
    {
      this.mMenuBarBtn.setClickable(false);
      this.mMenuBarBtn.setTextColor(getResources().getColor(2131492939));
      return;
    }
    this.mMenuBarBtn.setClickable(true);
    this.mMenuBarBtn.setTextColor(getResources().getColor(2131492905));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsFeedSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968687);
    init();
  }
  
  protected void onDestroy()
  {
    ((WindowManager)getSystemService("window")).removeView(this.mOverlay);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LoginMsgReportLocationActivity
 * JD-Core Version:    0.7.0.1
 */