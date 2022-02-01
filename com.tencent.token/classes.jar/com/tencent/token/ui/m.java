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
import com.tencent.token.cb;
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
    if (localObject != null)
    {
      if (paramb.a == null) {
        return;
      }
      paramb.e.setVisibility(0);
      if (((LoginProtectResult.a)localObject).d)
      {
        paramb.d.setVisibility(0);
        paramb.e.setEnabled(false);
      }
      else
      {
        paramb.d.setVisibility(4);
        paramb.e.setEnabled(true);
      }
      paramb.b.setText(((LoginProtectResult.a)localObject).b);
      int i = ((LoginProtectResult.a)localObject).a;
      if (i != 80)
      {
        if (i != 82) {
          return;
        }
        this.d = paramb;
        if (((LoginProtectResult.a)localObject).c) {
          paramb.e.a(false, false);
        } else {
          paramb.e.a(true, false);
        }
        paramb.e.setOnCheckedChangeListener(this.f);
        paramb.c.setText(2131493754);
        return;
      }
      this.c = paramb;
      if (((LoginProtectResult.a)localObject).e) {
        paramb.e.a(false, false);
      } else {
        paramb.e.a(true, false);
      }
      paramb.c.setOnClickListener(this.e);
      paramb.e.setOnCheckedChangeListener(this.f);
      localObject = new SpannableString(this.a.getString(2131493737));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2130968627)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length(), 33);
      paramb.c.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void a(e parame, int[] paramArrayOfInt)
  {
    if (parame.b())
    {
      AccountPageActivity.mNeedRefreshEval = true;
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        int j = paramArrayOfInt[i];
        if (j != 71)
        {
          if (j == 82)
          {
            this.d.f.d = false;
            this.d.f.c ^= true;
            a(this.d);
          }
        }
        else
        {
          this.c.f.d = false;
          this.c.f.e ^= true;
          a(this.c);
        }
        i += 1;
      }
    }
    e.a(this.a.getResources(), parame);
    this.a.showTipDialog(2131493532, parame.c);
    this.d.f.d = false;
    this.c.f.d = false;
    a(this.c);
    a(this.d);
  }
  
  public int getCount()
  {
    if ((this.a.mLoginProtectResult != null) && (this.a.mLoginProtectResult.mLists.size() != 0)) {
      return this.a.mLoginProtectResult.mLists.size();
    }
    return 0;
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.b.inflate(2131296480, paramViewGroup, false);
    }
    if ((localView != null) && (this.a.mLoginProtectResult.mLists != null) && (this.a.mLoginProtectResult.mLists.size() != 0))
    {
      if (paramInt >= this.a.mLoginProtectResult.mLists.size()) {
        return localView;
      }
      paramView = new b(localView, (LoginProtectResult.a)this.a.mLoginProtectResult.mLists.get(paramInt));
      paramView.e.setTag(paramView);
      a(paramView);
      return localView;
    }
    return localView;
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private m.b b;
    
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = (m.b)paramCompoundButton.getTag();
      if ((paramCompoundButton != null) && (paramCompoundButton.f != null))
      {
        if (paramCompoundButton.a == null) {
          return;
        }
        this.b = paramCompoundButton;
        if (paramCompoundButton.f.d) {
          return;
        }
        int i = paramCompoundButton.f.a;
        if (i != 80)
        {
          if (i != 82) {
            return;
          }
          if (paramBoolean != paramCompoundButton.f.c) {
            return;
          }
          paramCompoundButton.f.d = true;
          m.a(m.this, paramCompoundButton);
          localObject = m.a(m.this).getItem(80);
          if ((!paramCompoundButton.f.c) && (!((LoginProtectResult.a)localObject).e))
          {
            m.a(m.this).showUserDialog(2131492985, m.a(m.this).getResources().getString(2131493700), 2131493699, 2131493028, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                m.c(m.this).f.d = true;
                m.a(m.this, m.c(m.this));
                paramAnonymousInt = m.a.a(m.a.this).f.a;
                boolean bool = m.a.a(m.a.this).f.c;
                paramAnonymousDialogInterface = cb.a();
                String str = m.a(m.this).mA2;
                Handler localHandler = m.a(m.this).mHandler;
                paramAnonymousDialogInterface.a(0L, new int[] { paramAnonymousInt, 71 }, new int[] { bool ^ true, 1 }, str, localHandler);
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
          i = paramCompoundButton.f.a;
          paramBoolean = paramCompoundButton.f.c;
          paramCompoundButton = cb.a();
          localObject = m.a(m.this).mA2;
          localHandler = m.a(m.this).mHandler;
          paramCompoundButton.a(0L, new int[] { i }, new int[] { paramBoolean ^ true }, (String)localObject, localHandler);
          return;
        }
        if (paramBoolean != paramCompoundButton.f.e) {
          return;
        }
        if (!paramBoolean) {
          TMSDKContext.saveActionData(1150077);
        } else {
          TMSDKContext.saveActionData(1150078);
        }
        paramCompoundButton.f.d = true;
        m.a(m.this, paramCompoundButton);
        Object localObject = m.a(m.this).getItem(82);
        if ((paramCompoundButton.f.e) && (((LoginProtectResult.a)localObject).c))
        {
          m.a(m.this).showUserDialog(2131492985, m.a(m.this).getResources().getString(2131493681), 2131493699, 2131493028, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              m.b(m.this).f.d = true;
              m.a(m.this, m.b(m.this));
              boolean bool = m.a.a(m.a.this).f.e;
              paramAnonymousDialogInterface = cb.a();
              String str = m.a(m.this).mA2;
              Handler localHandler = m.a(m.this).mHandler;
              paramAnonymousDialogInterface.a(0L, new int[] { 71, 82 }, new int[] { bool ^ true, 0 }, str, localHandler);
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
        paramBoolean = paramCompoundButton.f.e;
        paramCompoundButton = cb.a();
        localObject = m.a(m.this).mA2;
        Handler localHandler = m.a(m.this).mHandler;
        paramCompoundButton.a(0L, new int[] { 71 }, new int[] { paramBoolean ^ true }, (String)localObject, localHandler);
        return;
      }
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
      this$1 = this.a;
      if (m.this == null) {
        return;
      }
      this.f = parama;
      this.b = ((TextView)m.this.findViewById(2131165705));
      this.c = ((TextView)this.a.findViewById(2131165430));
      this.e = ((SwitchButton)this.a.findViewById(2131165703));
      this.d = ((ProgressBar)this.a.findViewById(2131165685));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.m
 * JD-Core Version:    0.7.0.1
 */