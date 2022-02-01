package com.tencent.token;

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
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.bean.LoginProtectResult.a;
import com.tencent.token.ui.PCMobileQQVerifyedDevicesActivity;
import com.tencent.token.ui.UtilsLoginProtectActivity;
import com.tencent.token.ui.base.SwitchButton;
import com.tmsdk.TMSDKContext;
import java.util.List;

public final class yb
  extends BaseAdapter
{
  private UtilsLoginProtectActivity a;
  private LayoutInflater b;
  private b c;
  private b d;
  private View.OnClickListener e = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      TMSDKContext.saveActionData(1150079);
      paramAnonymousView = new Intent(yb.a(yb.this), PCMobileQQVerifyedDevicesActivity.class);
      yb.a(yb.this).startActivity(paramAnonymousView);
    }
  };
  private a f = new a();
  
  public yb(UtilsLoginProtectActivity paramUtilsLoginProtectActivity)
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
        paramb.c.setText(2131493757);
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
      localObject = new SpannableString(this.a.getString(2131493740));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2130968627)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length(), 33);
      paramb.c.setText((CharSequence)localObject);
      return;
    }
  }
  
  public final void a(wy paramwy, int[] paramArrayOfInt)
  {
    if (paramwy.b())
    {
      com.tencent.token.ui.AccountPageActivity.mNeedRefreshEval = true;
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
      return;
    }
    wy.a(this.a.getResources(), paramwy);
    this.a.showTipDialog(2131493534, paramwy.c);
    this.d.f.d = false;
    this.c.f.d = false;
    a(this.c);
    a(this.d);
  }
  
  public final int getCount()
  {
    if ((this.a.mLoginProtectResult != null) && (this.a.mLoginProtectResult.mLists.size() != 0)) {
      return this.a.mLoginProtectResult.mLists.size();
    }
    return 0;
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.b.inflate(2131296481, paramViewGroup, false);
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
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private yb.b b;
    
    a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = (yb.b)paramCompoundButton.getTag();
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
          yb.a(yb.this, paramCompoundButton);
          localObject = yb.a(yb.this).getItem(80);
          if ((!paramCompoundButton.f.c) && (!((LoginProtectResult.a)localObject).e))
          {
            yb.a(yb.this).showUserDialog(2131492986, yb.a(yb.this).getResources().getString(2131493703), 2131493702, 2131493029, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                yb.c(yb.this).f.d = true;
                yb.a(yb.this, yb.c(yb.this));
                paramAnonymousInt = yb.a.a(yb.a.this).f.a;
                boolean bool = yb.a.a(yb.a.this).f.c;
                paramAnonymousDialogInterface = sa.a();
                String str = yb.a(yb.this).mA2;
                Handler localHandler = yb.a(yb.this).mHandler;
                paramAnonymousDialogInterface.a(0L, new int[] { paramAnonymousInt, 71 }, new int[] { bool ^ true, 1 }, str, localHandler);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                yb.a.a(yb.a.this).f.d = false;
                yb.a(yb.this, yb.a.a(yb.a.this));
              }
            });
            return;
          }
          i = paramCompoundButton.f.a;
          paramBoolean = paramCompoundButton.f.c;
          paramCompoundButton = sa.a();
          localObject = yb.a(yb.this).mA2;
          localHandler = yb.a(yb.this).mHandler;
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
        yb.a(yb.this, paramCompoundButton);
        Object localObject = yb.a(yb.this).getItem(82);
        if ((paramCompoundButton.f.e) && (((LoginProtectResult.a)localObject).c))
        {
          yb.a(yb.this).showUserDialog(2131492986, yb.a(yb.this).getResources().getString(2131493684), 2131493702, 2131493029, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              yb.b(yb.this).f.d = true;
              yb.a(yb.this, yb.b(yb.this));
              boolean bool = yb.a.a(yb.a.this).f.e;
              paramAnonymousDialogInterface = sa.a();
              String str = yb.a(yb.this).mA2;
              Handler localHandler = yb.a(yb.this).mHandler;
              paramAnonymousDialogInterface.a(0L, new int[] { 71, 82 }, new int[] { bool ^ true, 0 }, str, localHandler);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              yb.a.a(yb.a.this).f.d = false;
              yb.a(yb.this, yb.a.a(yb.a.this));
            }
          });
          return;
        }
        paramBoolean = paramCompoundButton.f.e;
        paramCompoundButton = sa.a();
        localObject = yb.a(yb.this).mA2;
        Handler localHandler = yb.a(yb.this).mHandler;
        paramCompoundButton.a(0L, new int[] { 71 }, new int[] { paramBoolean ^ true }, (String)localObject, localHandler);
        return;
      }
    }
  }
  
  final class b
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
      if (yb.this == null) {
        return;
      }
      this.f = parama;
      this.b = ((TextView)yb.this.findViewById(2131165711));
      this.c = ((TextView)this.a.findViewById(2131165434));
      this.e = ((SwitchButton)this.a.findViewById(2131165709));
      this.d = ((ProgressBar)this.a.findViewById(2131165691));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yb
 * JD-Core Version:    0.7.0.1
 */