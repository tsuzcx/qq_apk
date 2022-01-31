package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;

public class NetActiveVryOtherListActivity
  extends BaseActivity
{
  private int mPageId;
  private View.OnClickListener mSelectMobileListener = new rm(this);
  private View.OnClickListener mSelectQQTokenListener = new rn(this);
  private View.OnClickListener mSelectQuesListener = new rl(this);
  private View.OnClickListener mSelectSkipListener = new ro(this);
  private View.OnTouchListener mTouchListener = new rp(this);
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  
  private void init()
  {
    int j = 1;
    Object localObject1 = (RelativeLayout)findViewById(2131296871);
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131296874);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131296877);
    View localView1 = findViewById(2131296880);
    View localView2 = findViewById(2131296870);
    Object localObject2 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    localObject2 = (TextView)findViewById(2131296593);
    int k;
    int m;
    if (this.mUpDetermin.mHaveMobile == 1)
    {
      k = 1;
      if (this.mUpDetermin.mQqtokenAppear != 1) {
        break label150;
      }
      m = 1;
      label112:
      if (this.mUpDetermin.mQuesAppear != 1) {
        break label156;
      }
    }
    label150:
    label156:
    for (int n = 1;; n = 0)
    {
      if ((k != 0) || (m != 0) || (n != 0)) {
        break label162;
      }
      finish();
      return;
      k = 0;
      break;
      m = 0;
      break label112;
    }
    label162:
    if (k != 0) {}
    for (;;)
    {
      int i = j;
      if (m != 0) {
        i = j + 1;
      }
      j = i;
      if (n != 0) {
        j = i + 1;
      }
      switch (j)
      {
      }
      for (;;)
      {
        ((RelativeLayout)localObject1).setOnTouchListener(this.mTouchListener);
        ((RelativeLayout)localObject1).setOnClickListener(this.mSelectMobileListener);
        localRelativeLayout1.setOnTouchListener(this.mTouchListener);
        localRelativeLayout1.setOnClickListener(this.mSelectQQTokenListener);
        localRelativeLayout2.setOnTouchListener(this.mTouchListener);
        localRelativeLayout2.setOnClickListener(this.mSelectQuesListener);
        localView1.setOnClickListener(this.mSelectSkipListener);
        setTitle(2131362363);
        setRightTitleImage(2130837951, new rq(this));
        if (this.mPageId != 7) {
          break;
        }
        localView1.setVisibility(4);
        ((TextView)localObject2).setVisibility(0);
        localObject1 = new SpannableString(getResources().getString(2131362360));
        ((SpannableString)localObject1).setSpan(new rr(this), 24, 28, 33);
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131165336)), 24, 28, 33);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setHighlightColor(0);
        return;
        if (k != 0)
        {
          if (m != 0) {
            localRelativeLayout2.setVisibility(8);
          } else {
            localRelativeLayout1.setVisibility(8);
          }
        }
        else
        {
          ((RelativeLayout)localObject1).setVisibility(8);
          continue;
          if (k != 0)
          {
            localRelativeLayout1.setVisibility(8);
            localRelativeLayout2.setVisibility(8);
          }
          if (m != 0)
          {
            ((RelativeLayout)localObject1).setVisibility(8);
            localRelativeLayout2.setVisibility(8);
          }
          if (n != 0)
          {
            ((RelativeLayout)localObject1).setVisibility(8);
            localRelativeLayout1.setVisibility(8);
            continue;
            localView2.setVisibility(8);
            ((RelativeLayout)localObject1).setVisibility(8);
            localRelativeLayout1.setVisibility(8);
            localRelativeLayout2.setVisibility(8);
          }
        }
      }
      j = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903146);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    this.mPageId = getIntent().getIntExtra("page_id", 0);
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    finish();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryOtherListActivity
 * JD-Core Version:    0.7.0.1
 */