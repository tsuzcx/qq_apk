package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.push.b;
import com.tmsdk.TMSDKContext;

public class VerifySuccActivity
  extends BaseActivity
{
  private boolean bindMobileSucc;
  private Handler getUinlistHandler = new Handler();
  private boolean isHaveMobie;
  private boolean ish5zzb;
  private View.OnClickListener mBindButtonListener = new aff(this);
  private Handler mHandler = new afg(this);
  private String mMobile;
  private long mRealUin;
  private int mSourceId;
  
  private void init()
  {
    Object localObject2;
    Object localObject1;
    if (this.isHaveMobie) {
      if (this.bindMobileSucc)
      {
        setContentView(2130968611);
        setBackArrowHide();
        localObject2 = (TextView)findViewById(2131558647);
        localObject1 = (TextView)findViewById(2131558648);
        ((TextView)localObject2).setText(2131231363);
        localObject2 = (Button)findViewById(2131558649);
        if (this.mSourceId != 1) {
          break label238;
        }
        ((TextView)localObject1).setVisibility(0);
        ((Button)localObject2).setText(2131231243);
        ((TextView)localObject1).setText(2131231615);
        setNeverShowLockVerifyView();
        label89:
        ((Button)localObject2).setOnClickListener(new afd(this));
        setTitle(2131231618);
        localObject1 = (ImageView)findViewById(2131558646);
        ((ImageView)localObject1).postDelayed(new afe(this, (ImageView)localObject1), 100L);
        if (this.isHaveMobie)
        {
          localObject1 = (TextView)findViewById(2131558653);
          if (!this.bindMobileSucc) {
            break label285;
          }
          localObject2 = getString(2131230762) + " ";
          ((TextView)localObject1).setText((String)localObject2 + this.mMobile);
        }
      }
    }
    for (;;)
    {
      b.a().a(8);
      return;
      setContentView(2130968610);
      break;
      setContentView(2130968609);
      break;
      label238:
      if ((this.isHaveMobie) && (!this.bindMobileSucc)) {
        ((Button)localObject2).setText(2131230809);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label283;
        }
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131231615);
        break;
        ((Button)localObject2).setText(2131230808);
      }
      label283:
      break label89;
      label285:
      ((Button)findViewById(2131558654)).setOnClickListener(this.mBindButtonListener);
      ((TextView)localObject1).setText(getResources().getString(2131230789));
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (paramKeyEvent.getAction() == 0) {}
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent();
    this.mSourceId = paramBundle.getIntExtra("mSourceId", 0);
    this.mRealUin = paramBundle.getLongExtra("mRealUin", 0L);
    this.ish5zzb = paramBundle.getBooleanExtra("ish5zzb", false);
    this.isHaveMobie = paramBundle.getBooleanExtra("isHaveMobie", false);
    this.mMobile = paramBundle.getStringExtra("mMobile");
    this.bindMobileSucc = paramBundle.getBooleanExtra("bindMobileSucc", false);
    init();
    TMSDKContext.SaveStringData(1150090, this.mRealUin + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.VerifySuccActivity
 * JD-Core Version:    0.7.0.1
 */