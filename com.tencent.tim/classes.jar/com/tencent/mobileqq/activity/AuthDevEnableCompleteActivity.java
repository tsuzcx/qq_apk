package com.tencent.mobileqq.activity;

import abgt;
import afsf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import uhj;

public class AuthDevEnableCompleteActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private String aLb;
  private boolean aRH;
  private int bDY;
  private Button cW;
  private LinearLayout fS;
  private ArrayList<abgt> oQ;
  
  private View a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
      }
      return null;
    }
    View localView = getLayoutInflater().inflate(2131561311, this.fS, false);
    if ((localView == null) || (this.fS == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
      }
      return null;
    }
    localView.setOnClickListener(new uhj(this));
    ImageView localImageView = (ImageView)localView.findViewById(2131364570);
    TextView localTextView1 = (TextView)localView.findViewById(2131372190);
    TextView localTextView2 = (TextView)localView.findViewById(2131379625);
    TextView localTextView3 = (TextView)localView.findViewById(2131369154);
    if ((localImageView == null) || (localTextView1 == null) || (localTextView2 == null) || (localTextView3 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
      }
      return null;
    }
    localImageView.setVisibility(0);
    localTextView1.setText(paramString1);
    localTextView2.setText(getString(2131693191));
    localTextView3.setText(paramString2);
    return localView;
  }
  
  private void initUI()
  {
    super.setContentView(2131561305);
    setTitle(2131693215);
    this.cW = ((Button)findViewById(2131363858));
    this.fS = ((LinearLayout)findViewById(2131378092));
    if ((this.cW == null) || (this.fS == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
      }
      return;
    }
    Object localObject1 = (TextView)findViewById(2131369579);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.cW.setOnClickListener(this);
    this.oQ = afsf.a().cW();
    int k = this.oQ.size();
    int j = 0;
    int i = 0;
    Object localObject2;
    boolean bool1;
    label171:
    boolean bool2;
    for (;;)
    {
      if (j < k)
      {
        localObject2 = (abgt)this.oQ.get(j);
        if (localObject2 == null)
        {
          j += 1;
        }
        else if ((((abgt)localObject2).authState == 1) || (((abgt)localObject2).authState == 2))
        {
          bool1 = true;
          if (((((abgt)localObject2).cH == null) || (!((abgt)localObject2).cH.equals(NetConnInfoCenter.GUID))) && (((abgt)localObject2).authState != 1)) {
            break label361;
          }
          ((abgt)localObject2).bCo = true;
          bool2 = false;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      localObject1 = a(((abgt)localObject2).strDeviceName, ((abgt)localObject2).strDeviceTypeInfo, bool1, bool2, ((abgt)localObject2).bCo);
      if (localObject1 != null)
      {
        ((abgt)localObject2).cox = i;
        i += 1;
        localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131369468);
        if (k == 1) {
          ((RelativeLayout)localObject2).setBackgroundResource(2130839682);
        }
        for (;;)
        {
          this.fS.addView((View)localObject1);
          break;
          bool1 = false;
          break label171;
          if (i == 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130839701);
          } else if (j == k - 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130839689);
          } else {
            ((RelativeLayout)localObject2).setBackgroundResource(2130839695);
          }
        }
        try
        {
          afsf.a().u(null, this.app.getCurrentAccountUin(), 10);
          return;
        }
        catch (Exception localException)
        {
          return;
        }
      }
      break;
      label361:
      bool2 = true;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if ((AuthDevOpenUgActivity.OH()) && (this.aRH))
    {
      finish();
      startActivity(new Intent(this, LoginInfoActivity.class));
    }
    return false;
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
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
      }
      try
      {
        afsf.a().u(null, this.app.getCurrentAccountUin(), 11);
        label70:
        if ((this.oQ != null) && (this.fS != null))
        {
          int k = this.oQ.size();
          int i = 0;
          if (i < k)
          {
            localObject = (abgt)this.oQ.get(i);
            int j = ((abgt)localObject).cox;
            View localView;
            if (j >= 0)
            {
              localView = this.fS.getChildAt(j);
              if (localView != null) {
                break label146;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if (((ImageView)localView.findViewById(2131364570)).getVisibility() == 0) {}
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label190;
                }
                if (((abgt)localObject).authState != 0) {
                  break;
                }
                ((abgt)localObject).authState = 3;
                break;
              }
              ((abgt)localObject).authState = 0;
            }
          }
        }
        label146:
        label190:
        afsf.a().a(this.app, this.oQ);
        Object localObject = new Intent(this, AuthDevActivity.class);
        ((Intent)localObject).putExtra("auth_dev_open", true);
        if (this.aLb != null)
        {
          ((Intent)localObject).putExtra("country_code", this.bDY);
          ((Intent)localObject).putExtra("phone_num", this.aLb);
        }
        startActivity((Intent)localObject);
        overridePendingTransition(0, 2130772013);
        afsf.a().dbK();
        finish();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
        }
        finish();
        overridePendingTransition(0, 2130772013);
      }
      catch (Exception localException)
      {
        break label70;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.aRH = ((Bundle)localObject).getBoolean("h5_flag");
    this.aLb = ((Bundle)localObject).getString("phone_num");
    this.bDY = ((Bundle)localObject).getInt("country_code");
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "on Create AuthDevEnableCompleteActivity！");
    }
    super.onCreate(paramBundle);
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity
 * JD-Core Version:    0.7.0.1
 */