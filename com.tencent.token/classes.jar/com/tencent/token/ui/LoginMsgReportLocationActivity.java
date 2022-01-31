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
import com.tencent.token.af;
import com.tencent.token.bb;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.fo;
import com.tencent.token.global.e;
import com.tencent.token.o;
import com.tencent.token.ui.base.LoginMsgRightLetterView;
import com.tencent.token.ui.base.ProDialog;

public class LoginMsgReportLocationActivity
  extends BaseActivity
{
  private nx mAdapter;
  private ListView mCityList;
  ProDialog mDialogPro = null;
  public Handler mHandler = new ol(this);
  private int mIndex;
  private boolean mIsFeedSuccess = false;
  private SafeMsgItem mItem;
  private LoginMsgRightLetterView mLetterList;
  private Button mMenuBarBtn;
  private String mNewLocation;
  private TextView mOverlay;
  private oq mOverlayThread;
  private int mPosition;
  
  private void init()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null) || (bb.a().f == null))
    {
      finish();
      return;
    }
    this.mPosition = getIntent().getExtras().getInt("position");
    this.mItem = bb.a().f.b(this.mPosition);
    this.mCityList = ((ListView)findViewById(2131296800));
    this.mLetterList = ((LoginMsgRightLetterView)findViewById(2131296801));
    this.mLetterList.a(new op(this));
    this.mMenuBarBtn = ((Button)findViewById(2131297148));
    this.mMenuBarBtn.setVisibility(0);
    this.mMenuBarBtn.setText(getResources().getString(2131361806));
    this.mMenuBarBtn.setOnClickListener(new oo(this));
    this.mOverlayThread = new oq(this);
    initOverlay();
    o localo = o.a();
    e.c("test city: " + localo.d.length + "|" + localo.c.length + "|" + localo.f.length + "|" + localo.g.length + "|" + localo.e.length);
    this.mAdapter = new nx(this);
    this.mCityList.setAdapter(this.mAdapter);
  }
  
  private void initOverlay()
  {
    this.mOverlay = ((TextView)LayoutInflater.from(this).inflate(2130903129, null));
    this.mOverlay.setVisibility(4);
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-2, -2, 2, 24, -3);
    ((WindowManager)getSystemService("window")).addView(this.mOverlay, localLayoutParams);
  }
  
  public void cancelRequest()
  {
    af.a().a(getClass().getName());
  }
  
  public void checkMenuBtnEnable(int paramInt)
  {
    if (paramInt == -1)
    {
      this.mMenuBarBtn.setClickable(false);
      this.mMenuBarBtn.setTextColor(getResources().getColor(2131165214));
      return;
    }
    this.mMenuBarBtn.setClickable(true);
    this.mMenuBarBtn.setTextColor(getResources().getColor(2131165223));
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
    setContentView(2130903130);
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