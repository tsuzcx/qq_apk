package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.ca;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.bean.LoginProtectResult.a;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SwitchButton;
import com.tmsdk.TMSDKContext;
import java.util.List;

class m
  extends BaseAdapter
{
  private UtilsLoginProtectActivity a;
  private LayoutInflater b;
  private b c;
  private b d;
  private View.OnClickListener e = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      TMSDKContext.saveActionData(1150079);
      paramAnonymousView = new Intent(m.a(m.this), PCMobileQQVerifyedDevicesActivity.class);
      m.a(m.this).startActivity(paramAnonymousView);
    }
  };
  private a f = new a();
  
  public m(UtilsLoginProtectActivity paramUtilsLoginProtectActivity)
  {
    this.a = paramUtilsLoginProtectActivity;
    this.b = LayoutInflater.from(paramUtilsLoginProtectActivity);
  }
  
  private void a(b paramb)
  {
    Object localObject = paramb.f;
    if ((localObject == null) || (paramb.a == null)) {
      return;
    }
    paramb.e.setVisibility(0);
    if (((LoginProtectResult.a)localObject).d)
    {
      paramb.d.setVisibility(0);
      paramb.e.setEnabled(false);
      paramb.b.setText(((LoginProtectResult.a)localObject).b);
    }
    switch (((LoginProtectResult.a)localObject).a)
    {
    case 81: 
    default: 
      return;
    case 80: 
      this.c = paramb;
      if (((LoginProtectResult.a)localObject).e) {
        paramb.e.a(false, false);
      }
      for (;;)
      {
        paramb.c.setOnClickListener(this.e);
        paramb.e.setOnCheckedChangeListener(this.f);
        localObject = new SpannableString(this.a.getString(2131231593));
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131492896)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length(), 33);
        paramb.c.setText((CharSequence)localObject);
        return;
        paramb.d.setVisibility(4);
        paramb.e.setEnabled(true);
        break;
        paramb.e.a(true, false);
      }
    }
    this.d = paramb;
    if (((LoginProtectResult.a)localObject).c) {
      paramb.e.a(false, false);
    }
    for (;;)
    {
      paramb.e.setOnCheckedChangeListener(this.f);
      paramb.c.setText(2131231610);
      return;
      paramb.e.a(true, false);
    }
  }
  
  public void a(e parame, int[] paramArrayOfInt)
  {
    if (parame.b())
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
      parame = this.d.f;
      if (!this.d.f.c) {}
      for (boolean bool = true;; bool = false)
      {
        parame.c = bool;
        a(this.d);
        break;
      }
      this.c.f.d = false;
      parame = this.c.f;
      if (!this.c.f.e) {}
      for (bool = true;; bool = false)
      {
        parame.e = bool;
        a(this.c);
        break;
      }
    }
    e.a(this.a.getResources(), parame);
    this.a.showTipDialog(2131231390, parame.c);
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
    paramViewGroup = new b(paramView, (LoginProtectResult.a)this.a.mLoginProtectResult.mLists.get(paramInt));
    paramViewGroup.e.setTag(paramViewGroup);
    a(paramViewGroup);
    return paramView;
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private m.b b;
    
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      int i = 1;
      paramCompoundButton = (m.b)paramCompoundButton.getTag();
      if ((paramCompoundButton == null) || (paramCompoundButton.f == null) || (paramCompoundButton.a == null)) {}
      do
      {
        do
        {
          do
          {
            return;
            this.b = paramCompoundButton;
          } while (paramCompoundButton.f.d);
          switch (paramCompoundButton.f.a)
          {
          case 81: 
          default: 
            return;
          }
        } while (paramBoolean != paramCompoundButton.f.e);
        if (!paramBoolean) {
          TMSDKContext.saveActionData(1150077);
        }
        for (;;)
        {
          paramCompoundButton.f.d = true;
          m.a(m.this, paramCompoundButton);
          localObject = m.a(m.this).getItem(82);
          if ((!paramCompoundButton.f.e) || (!((LoginProtectResult.a)localObject).c)) {
            break;
          }
          m.a(m.this).showUserDialog(2131230843, m.a(m.this).getResources().getString(2131231537), 2131231555, 2131230886, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              m.b(m.this).f.d = true;
              m.a(m.this, m.b(m.this));
              if (m.a.a(m.a.this).f.e) {}
              for (paramAnonymousInt = 0;; paramAnonymousInt = 1)
              {
                paramAnonymousDialogInterface = ca.a();
                String str = m.a(m.this).mA2;
                Handler localHandler = m.a(m.this).mHandler;
                paramAnonymousDialogInterface.a(0L, new int[] { 71, 82 }, new int[] { paramAnonymousInt, 0 }, str, localHandler);
                return;
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              m.a.a(m.a.this).f.d = false;
              m.a(m.this, m.a.a(m.a.this));
            }
          });
          return;
          TMSDKContext.saveActionData(1150078);
        }
        if (paramCompoundButton.f.e) {}
        for (i = 0;; i = 1)
        {
          paramCompoundButton = ca.a();
          localObject = m.a(m.this).mA2;
          localHandler = m.a(m.this).mHandler;
          paramCompoundButton.a(0L, new int[] { 71 }, new int[] { i }, (String)localObject, localHandler);
          return;
        }
      } while (paramBoolean != paramCompoundButton.f.c);
      paramCompoundButton.f.d = true;
      m.a(m.this, paramCompoundButton);
      Object localObject = m.a(m.this).getItem(80);
      if ((!paramCompoundButton.f.c) && (!((LoginProtectResult.a)localObject).e))
      {
        m.a(m.this).showUserDialog(2131230843, m.a(m.this).getResources().getString(2131231556), 2131231555, 2131230886, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            m.c(m.this).f.d = true;
            m.a(m.this, m.c(m.this));
            int i = m.a.a(m.a.this).f.a;
            if (m.a.a(m.a.this).f.c) {}
            for (paramAnonymousInt = 0;; paramAnonymousInt = 1)
            {
              paramAnonymousDialogInterface = ca.a();
              String str = m.a(m.this).mA2;
              Handler localHandler = m.a(m.this).mHandler;
              paramAnonymousDialogInterface.a(0L, new int[] { i, 71 }, new int[] { paramAnonymousInt, 1 }, str, localHandler);
              return;
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            m.a.a(m.a.this).f.d = false;
            m.a(m.this, m.a.a(m.a.this));
          }
        });
        return;
      }
      int j = paramCompoundButton.f.a;
      if (paramCompoundButton.f.c) {
        i = 0;
      }
      paramCompoundButton = ca.a();
      localObject = m.a(m.this).mA2;
      Handler localHandler = m.a(m.this).mHandler;
      paramCompoundButton.a(0L, new int[] { j }, new int[] { i }, (String)localObject, localHandler);
    }
  }
  
  class b
  {
    public View a;
    public TextView b;
    public TextView c;
    public ProgressBar d;
    public SwitchButton e;
    public LoginProtectResult.a f;
    
    b(View paramView, LoginProtectResult.a parama)
    {
      this.a = paramView;
      if (this.a == null) {
        return;
      }
      this.f = parama;
      this.b = ((TextView)this.a.findViewById(2131559385));
      this.c = ((TextView)this.a.findViewById(2131559388));
      this.e = ((SwitchButton)this.a.findViewById(2131559386));
      this.d = ((ProgressBar)this.a.findViewById(2131559387));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.m
 * JD-Core Version:    0.7.0.1
 */