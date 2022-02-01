package com.tencent.mobileqq.activity;

import acfp;
import achq;
import acmf;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anxj;
import anxk;
import anxr;
import aqgv;
import aqhu;
import ausj;
import auss;
import auvj;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import vwc;
import vwe;
import vwf;
import vwg;
import vwh;
import wja;

public class SubAccountUgActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener, Observer
{
  MqqHandler b = new vwf(this);
  boolean baA = false;
  boolean bay;
  public boolean baz;
  acmf d = new vwc(this);
  achq mMsgObserver = new vwg(this);
  public String subUin = "";
  
  private void a(anxk paramanxk, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((paramanxk == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (anxk.S(this.app, paramString)))
      {
        ath();
        paramString = paramanxk.W(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          paramanxk.a(this.app, this, localPair, new vwe(this, paramanxk, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void ya(boolean paramBoolean)
  {
    View localView = findViewById(2131378935);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (paramBoolean) {
        localView.setPadding(localView.getPaddingLeft(), wja.dp2px(260.0F, getResources()), localView.getPaddingRight(), localView.getPaddingBottom());
      }
    }
    else
    {
      return;
    }
    localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
  }
  
  void aQ()
  {
    StringBuilder localStringBuilder;
    if ((this.leftView != null) && (!this.baA))
    {
      Object localObject = this.app.b();
      localStringBuilder = new StringBuilder(acfp.m(2131715041)).append(getString(2131720735));
      if (localObject == null) {
        break label164;
      }
      int i = ((QQMessageFacade)localObject).bl();
      if (i <= 0) {
        break label143;
      }
      localObject = Integer.toString(i);
      if (i > 99) {
        localObject = "99+";
      }
      this.leftView.setText("");
      this.mLeftBackIcon.setVisibility(4);
      this.mLeftBackText.setVisibility(0);
      this.mLeftBackText.setText((CharSequence)localObject);
      this.leftView.setContentDescription("");
      this.leftView.bringToFront();
      localStringBuilder.append(i).append("条未读");
    }
    for (;;)
    {
      this.leftView.setContentDescription(localStringBuilder.toString());
      return;
      label143:
      this.leftView.setText("");
      this.mLeftBackText.setVisibility(8);
      continue;
      label164:
      this.leftView.setText("");
      this.mLeftBackText.setVisibility(8);
    }
  }
  
  public void bVH()
  {
    this.bay = false;
    View localView = findViewById(2131378935);
    TextView localTextView1 = (TextView)findViewById(2131378939);
    TextView localTextView2 = (TextView)findViewById(2131378940);
    ImageView localImageView = (ImageView)findViewById(2131378938);
    ((Button)findViewById(2131378936)).setText(2131720597);
    localView.setVisibility(8);
    localTextView1.setText(2131720609);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130851485);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.subUin = getIntent().getStringExtra("subAccount");
    this.baA = getIntent().getBooleanExtra("from_associated_activity", false);
    anxr localanxr = (anxr)this.app.getManager(61);
    this.bay = localanxr.pJ(this.subUin);
    boolean bool1 = false;
    paramBundle = anxk.b(this.app, this.subUin);
    boolean bool2;
    if (paramBundle != null)
    {
      bool2 = ((Boolean)paramBundle.first).booleanValue();
      bool1 = ((Boolean)paramBundle.second).booleanValue();
    }
    for (;;)
    {
      if (bool1)
      {
        anxj.j(this.app, this, this.subUin);
        finish();
        return false;
      }
      super.setContentView(2131563145);
      setTitle(2131720542);
      findViewById(2131377546).setOnClickListener(this);
      ImageView localImageView2 = (ImageView)findViewById(2131378937);
      ImageView localImageView1 = (ImageView)findViewById(2131378938);
      ((ThemeImageView)findViewById(2131378934)).setMaskShape(auvj.euM);
      TextView localTextView1 = (TextView)findViewById(2131378939);
      TextView localTextView2 = (TextView)findViewById(2131378940);
      Button localButton = (Button)findViewById(2131378936);
      View localView = findViewById(2131378935);
      Object localObject = this.app.getFaceBitmap(this.app.getAccount(), false);
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = aqhu.G();
      }
      localImageView2.setImageBitmap(paramBundle);
      localTextView1.setTextColor(getResources().getColor(2131167304));
      localTextView2.setVisibility(8);
      int i;
      if (this.bay)
      {
        if (!bool2) {
          break label677;
        }
        paramBundle = localanxr.h(this.subUin);
        if (paramBundle == null) {
          break label672;
        }
        i = ((Integer)paramBundle.first).intValue();
        if (i != 0) {
          switch (i)
          {
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        int j = i;
        if (i == 0) {
          j = 2131720607;
        }
        localTextView1.setTextColor(getResources().getColor(2131167304));
        paramBundle = this.app.getFaceBitmap(this.subUin, false);
        if (paramBundle != null) {
          localImageView1.setImageBitmap(paramBundle);
        }
        localObject = aqgv.c(this.app, this.subUin, true);
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (((String)localObject).length() != 0) {}
        }
        else
        {
          paramBundle = this.subUin;
        }
        localTextView1.setText(getString(j, new Object[] { paramBundle }));
        if (j == 2131720607)
        {
          localTextView2.setVisibility(0);
          label500:
          localButton.setText(2131720596);
          localView.setVisibility(0);
          ((Button)localView.findViewById(2131378929)).setOnClickListener(this);
          ((Button)localView.findViewById(2131378928)).setOnClickListener(this);
        }
        for (;;)
        {
          localButton.setOnClickListener(this);
          addObserver(this.d);
          addObserver(this.mMsgObserver);
          aQ();
          this.app.b().addObserver(this);
          this.app.setHandler(getClass(), this.b);
          if (isInMultiWindow()) {
            ya(true);
          }
          return true;
          i = 2131720602;
          break;
          i = 2131720603;
          break;
          i = 2131720600;
          break;
          i = 2131720602;
          break;
          i = 2131720602;
          break;
          i = 2131720607;
          break;
          localTextView2.setVisibility(8);
          break label500;
          localImageView1.setImageResource(2130851485);
        }
        label672:
        i = 0;
        break;
        label677:
        i = 0;
      }
      bool2 = false;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.d);
    removeObserver(this.mMsgObserver);
    this.app.removeHandler(getClass());
    this.app.b().deleteObserver(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
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
      Object localObject1 = new Intent();
      if (this.bay)
      {
        ((Intent)localObject1).putExtra("is_need_bind", false);
        ((Intent)localObject1).putExtra("subuin", this.subUin);
        ((Intent)localObject1).setClass(this, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("fromWhere", this.aOa);
        startActivity((Intent)localObject1);
      }
      else
      {
        ((Intent)localObject1).setClass(paramView.getContext(), SubAccountBindActivity.class);
        ((Intent)localObject1).putExtra("fromWhere", this.aOa);
        startActivity((Intent)localObject1);
        continue;
        localObject1 = (ausj)auss.a(getActivity(), null);
        ((ausj)localObject1).setMainTitle(2131720598);
        ((ausj)localObject1).addButton(getResources().getString(2131721528), 3);
        ((ausj)localObject1).addCancelButton(2131721058);
        ((ausj)localObject1).a(new vwh(this, (ausj)localObject1));
        ((ausj)localObject1).show();
        continue;
        Object localObject2 = this.subUin;
        localObject1 = "https://ti.qq.com/safe/forgetpw?source_id=2756";
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject2 });
        }
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.subUin);
        ((Intent)localObject2).putExtra("reqType", 3);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        startActivity((Intent)localObject2);
      }
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    ya(paramBoolean);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new SubAccountUgActivity.6(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity
 * JD-Core Version:    0.7.0.1
 */