package com.tencent.token.ui;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.ui.base.SwitchButton;
import java.util.List;

class nu
  extends BaseAdapter
{
  private UtilsLoginProtectActivity a;
  private LayoutInflater b;
  private ob c;
  private ob d;
  private View.OnClickListener e = new nv(this);
  private nw f = new nw(this);
  
  public nu(UtilsLoginProtectActivity paramUtilsLoginProtectActivity)
  {
    this.a = paramUtilsLoginProtectActivity;
    this.b = LayoutInflater.from(paramUtilsLoginProtectActivity);
  }
  
  private void a(ob paramob)
  {
    Object localObject = paramob.f;
    if ((localObject == null) || (paramob.a == null)) {
      return;
    }
    paramob.e.setVisibility(0);
    if (((com.tencent.token.core.bean.f)localObject).d)
    {
      paramob.d.setVisibility(0);
      paramob.e.setEnabled(false);
      paramob.b.setText(((com.tencent.token.core.bean.f)localObject).b);
    }
    switch (((com.tencent.token.core.bean.f)localObject).a)
    {
    case 81: 
    default: 
      return;
    case 80: 
      this.c = paramob;
      if (((com.tencent.token.core.bean.f)localObject).e) {
        paramob.e.a(false, false);
      }
      for (;;)
      {
        paramob.c.setOnClickListener(this.e);
        paramob.e.setOnCheckedChangeListener(this.f);
        localObject = new SpannableString(this.a.getString(2131231593));
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131492896)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length(), 33);
        paramob.c.setText((CharSequence)localObject);
        return;
        paramob.d.setVisibility(4);
        paramob.e.setEnabled(true);
        break;
        paramob.e.a(true, false);
      }
    }
    this.d = paramob;
    if (((com.tencent.token.core.bean.f)localObject).c) {
      paramob.e.a(false, false);
    }
    for (;;)
    {
      paramob.e.setOnCheckedChangeListener(this.f);
      paramob.c.setText(2131231610);
      return;
      paramob.e.a(true, false);
    }
  }
  
  public void a(com.tencent.token.global.f paramf, int[] paramArrayOfInt)
  {
    if (paramf.b())
    {
      AccountPageActivity.mNeedRefreshEval = true;
      int i = 0;
      while (i < paramArrayOfInt.length) {
        switch (paramArrayOfInt[i])
        {
        default: 
          i += 1;
        }
      }
      this.d.f.d = false;
      paramf = this.d.f;
      if (!this.d.f.c) {}
      for (boolean bool = true;; bool = false)
      {
        paramf.c = bool;
        a(this.d);
        break;
      }
      this.c.f.d = false;
      paramf = this.c.f;
      if (!this.c.f.e) {}
      for (bool = true;; bool = false)
      {
        paramf.e = bool;
        a(this.c);
        break;
      }
    }
    com.tencent.token.global.f.a(this.a.getResources(), paramf);
    this.a.showTipDialog(2131231390, paramf.c);
    this.d.f.d = false;
    this.c.f.d = false;
    a(this.c);
    a(this.d);
  }
  
  public int getCount()
  {
    if ((this.a.mLoginProtectResult == null) || (this.a.mLoginProtectResult.mLists.size() == 0)) {
      return 0;
    }
    return this.a.mLoginProtectResult.mLists.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.b.inflate(2130968799, paramViewGroup, false);
    }
    while ((paramView == null) || (this.a.mLoginProtectResult.mLists == null) || (this.a.mLoginProtectResult.mLists.size() == 0) || (paramInt >= this.a.mLoginProtectResult.mLists.size())) {
      return paramView;
    }
    paramViewGroup = new ob(this, paramView, (com.tencent.token.core.bean.f)this.a.mLoginProtectResult.mLists.get(paramInt));
    paramViewGroup.e.setTag(paramViewGroup);
    a(paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nu
 * JD-Core Version:    0.7.0.1
 */