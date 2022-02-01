package com.tencent.mobileqq.activity;

import acfd;
import acmf;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import anxr;
import aqdj;
import aqgv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vvv;
import vvw;
import vvy;
import vwa;
import vwb;

public class SubAccountBindActivity
  extends SubAccountBaseActivity
{
  MqqHandler b = new vvv(this);
  acmf c = new vvw(this);
  View.OnClickListener cU = new vvy(this);
  View.OnClickListener cV = new vwa(this);
  private LinearLayout fJ;
  acfd g = new vwb(this);
  private List<SimpleAccount> qg;
  
  private SimpleAccount a(String paramString)
  {
    Iterator localIterator = this.qg.iterator();
    while (localIterator.hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)localIterator.next();
      if (paramString.equals(localSimpleAccount.getUin())) {
        return localSimpleAccount;
      }
    }
    return null;
  }
  
  private void bFn()
  {
    if ((this.fJ == null) || (this.fJ.getChildCount() <= 0)) {}
    label265:
    for (;;)
    {
      return;
      int j = this.fJ.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label265;
        }
        Object localObject1 = this.fJ.getChildAt(i);
        Object localObject2 = ((View)localObject1).getTag();
        if (localObject2 == null) {
          break;
        }
        int k = ((Integer)localObject2).intValue();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.qg.get(k);
        if (localSimpleAccount == null) {
          break;
        }
        ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368698);
        TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131372190);
        TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131361874);
        localObject1 = (ImageView)((View)localObject1).findViewById(2131364570);
        localObject2 = aqgv.n(this.app, localSimpleAccount.getUin());
        localObject1 = localObject2;
        if (localSimpleAccount.isLogined()) {
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equals(localSimpleAccount.getUin())) {}
          }
          else
          {
            localObject1 = aqgv.o(this.app, localSimpleAccount.getUin());
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localSimpleAccount.getUin();
        }
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(localSimpleAccount.getUin());
        localObject1 = aqdj.a(this.app, 1, localSimpleAccount.getUin());
        if (localObject1 != null) {
          localImageView.setBackgroundDrawable((Drawable)localObject1);
        }
        i += 1;
      }
    }
  }
  
  private void initAccountList()
  {
    if (this.qg == null) {
      this.qg = new ArrayList();
    }
    for (;;)
    {
      Object localObject = getAppRuntime().getApplication().getAllAccounts();
      if (localObject == null) {
        break;
      }
      this.qg.addAll((Collection)localObject);
      localObject = a(this.app.getAccount());
      this.qg.remove(localObject);
      localObject = ((anxr)this.app.getManager(61)).dK();
      if (localObject == null) {
        break;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        SimpleAccount localSimpleAccount = a((String)((List)localObject).get(i));
        this.qg.remove(localSimpleAccount);
        i += 1;
      }
      this.qg.clear();
    }
    if (this.qg != null) {
      this.qg.add(null);
    }
  }
  
  protected boolean ao(boolean paramBoolean)
  {
    initAccountList();
    Object localObject;
    if ((paramBoolean) && (this.qg.size() == 1) && (this.qg.get(0) == null))
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this, SubLoginActivity.class);
      ((Intent)localObject).putExtra("fromWhere", this.aOa);
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    this.fJ.removeAllViews();
    int i = 0;
    if (i < this.qg.size())
    {
      if (this.qg.get(i) == null)
      {
        localObject = getLayoutInflater().inflate(2131558442, this.fJ, false);
        ((TextView)((View)localObject).findViewById(2131372285)).setText(2131720540);
        ((View)localObject).setOnClickListener(this.cV);
        ((View)localObject).setTag(null);
        this.fJ.addView((View)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = getLayoutInflater().inflate(2131558443, this.fJ, false);
        if ((localObject instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localObject).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localObject).setBGType(2);
        }
        ((View)localObject).setTag(Integer.valueOf(i));
        ((ImageView)((View)localObject).findViewById(2131368698)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((View)localObject).setOnClickListener(this.cU);
        this.fJ.addView((View)localObject);
      }
    }
    bFn();
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563143);
    setTitle(2131720550);
    setContentBackgroundResource(2130838900);
    this.fJ = ((LinearLayout)findViewById(2131361877));
    if (!ao(true)) {
      return false;
    }
    this.app.setHandler(getClass(), this.b);
    addObserver(this.g);
    addObserver(this.c);
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.c);
    removeObserver(this.g);
    this.app.removeHandler(getClass());
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity
 * JD-Core Version:    0.7.0.1
 */