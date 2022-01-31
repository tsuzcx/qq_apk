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
import com.tencent.token.core.bean.e;
import com.tencent.token.global.d;
import com.tencent.token.ui.base.SwitchButton;
import java.util.List;

final class or
  extends BaseAdapter
{
  private UtilsLoginProtectActivity a;
  private LayoutInflater b;
  private oy c;
  private oy d;
  private View.OnClickListener e = new os(this);
  private ot f = new ot(this);
  
  public or(UtilsLoginProtectActivity paramUtilsLoginProtectActivity)
  {
    this.a = paramUtilsLoginProtectActivity;
    this.b = LayoutInflater.from(paramUtilsLoginProtectActivity);
  }
  
  private void a(oy paramoy)
  {
    Object localObject = paramoy.f;
    if ((localObject == null) || (paramoy.a == null)) {
      return;
    }
    paramoy.e.setVisibility(0);
    if (((e)localObject).d)
    {
      paramoy.d.setVisibility(0);
      paramoy.e.setEnabled(false);
      paramoy.b.setText(((e)localObject).b);
    }
    switch (((e)localObject).a)
    {
    case 81: 
    default: 
      return;
    case 80: 
      this.c = paramoy;
      if (((e)localObject).e) {
        paramoy.e.a(false, false);
      }
      for (;;)
      {
        paramoy.c.setOnClickListener(this.e);
        paramoy.e.setOnCheckedChangeListener(this.f);
        localObject = new SpannableString(this.a.getString(2131362237));
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131165246)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length(), 33);
        paramoy.c.setText((CharSequence)localObject);
        return;
        paramoy.d.setVisibility(4);
        paramoy.e.setEnabled(true);
        break;
        paramoy.e.a(true, false);
      }
    }
    this.d = paramoy;
    if (((e)localObject).c) {
      paramoy.e.a(false, false);
    }
    for (;;)
    {
      paramoy.e.setOnCheckedChangeListener(this.f);
      paramoy.c.setText(2131362238);
      return;
      paramoy.e.a(true, false);
    }
  }
  
  public final void a(d paramd, int[] paramArrayOfInt)
  {
    int i;
    if (paramd.a == 0) {
      i = 1;
    }
    while (i != 0)
    {
      AccountPageActivity.mNeedRefreshEval = true;
      i = 0;
      while (i < paramArrayOfInt.length) {
        switch (paramArrayOfInt[i])
        {
        default: 
          i += 1;
        }
      }
      i = 0;
      continue;
      this.d.f.d = false;
      paramd = this.d.f;
      if (!this.d.f.c) {}
      for (boolean bool = true;; bool = false)
      {
        paramd.c = bool;
        a(this.d);
        break;
      }
      this.c.f.d = false;
      paramd = this.c.f;
      if (!this.c.f.e) {}
      for (bool = true;; bool = false)
      {
        paramd.e = bool;
        a(this.c);
        break;
      }
    }
    d.a(this.a.getResources(), paramd);
    this.a.showTipDialog(2131361919, paramd.c);
    this.d.f.d = false;
    this.c.f.d = false;
    a(this.c);
    a(this.d);
  }
  
  public final int getCount()
  {
    if ((this.a.mLoginProtectResult == null) || (this.a.mLoginProtectResult.mLists.size() == 0)) {
      return 0;
    }
    return this.a.mLoginProtectResult.mLists.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.b.inflate(2130903237, paramViewGroup, false);
    }
    while ((paramView == null) || (this.a.mLoginProtectResult.mLists == null) || (this.a.mLoginProtectResult.mLists.size() == 0) || (paramInt >= this.a.mLoginProtectResult.mLists.size())) {
      return paramView;
    }
    paramViewGroup = new oy(this, paramView, (e)this.a.mLoginProtectResult.mLists.get(paramInt));
    paramViewGroup.e.setTag(paramViewGroup);
    a(paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.or
 * JD-Core Version:    0.7.0.1
 */