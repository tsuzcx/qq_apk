package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.global.h;
import java.lang.reflect.Method;
import java.util.List;

public class NetActiveVryOtherListActivity
  extends BaseActivity
{
  private qv mAdapter;
  private boolean mAddInfo = false;
  private Handler mHandler = new qu(this);
  private QQUser mUser;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private boolean onCreatePage = false;
  
  private void initView()
  {
    ListView localListView = (ListView)findViewById(2131559074);
    this.mAdapter = new qv(this, this, this.mVerifyResult.l());
    localListView.setAdapter(this.mAdapter);
  }
  
  public void finish()
  {
    super.finish();
    try
    {
      Activity.class.getDeclaredMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(this, new Object[] { Integer.valueOf(0), Integer.valueOf(2131034132) });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getStringExtra("sppkey") != null))
    {
      paramIntent = paramIntent.getStringExtra("sppkey");
      h.a("onActivityResult message=" + paramIntent);
      cw.a().d(this.mUser.mRealUin, paramIntent, this.mHandler);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968702);
    this.mBackArrowImg.setImageResource(2130838047);
    for (;;)
    {
      try
      {
        Activity.class.getDeclaredMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(this, new Object[] { Integer.valueOf(2131034131), Integer.valueOf(2131034131) });
        this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
        this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
        this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
        if ((this.mUser == null) || (this.mVerifyResult == null))
        {
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
        if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
          setNeverShowLockVerifyView();
        }
        this.onCreatePage = true;
        if (!this.mVerifyResult.a()) {
          break label224;
        }
      }
      ch.a().a(System.currentTimeMillis(), 222);
      while ((this.mVerifyResult.l() == null) || (this.mVerifyResult.l().size() == 0))
      {
        setTitle(2131231657);
        return;
        label224:
        ch.a().a(System.currentTimeMillis(), 224);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    finish();
    abi.c();
  }
  
  protected void onResume()
  {
    try
    {
      super.onResume();
      if (this.onCreatePage)
      {
        if (this.mHandler != null) {
          this.mHandler.postDelayed(new qt(this), 80L);
        }
        this.onCreatePage = false;
        return;
      }
      if (this.mAdapter != null)
      {
        this.mAdapter.notifyDataSetChanged();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryOtherListActivity
 * JD-Core Version:    0.7.0.1
 */