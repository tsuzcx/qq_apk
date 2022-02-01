package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.f;
import com.tencent.token.ct;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.UserTask;

class j
  extends BaseAdapter
{
  public boolean a = true;
  a b = new a();
  private UtilsGameProtectActivity c;
  private LayoutInflater d;
  private ListView e;
  private Handler f;
  private View g;
  
  public j(UtilsGameProtectActivity paramUtilsGameProtectActivity, ListView paramListView, Handler paramHandler)
  {
    this.c = paramUtilsGameProtectActivity;
    this.d = LayoutInflater.from(paramUtilsGameProtectActivity);
    this.e = paramListView;
    this.f = paramHandler;
  }
  
  public void a()
  {
    int j = ct.a().f();
    int i = 0;
    while (i < j)
    {
      f localf = ct.a().b(i);
      if (localf != null) {
        localf.e = false;
      }
      i += 1;
    }
  }
  
  public void a(View paramView)
  {
    this.g = paramView;
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        j.c(j.this).findViewById(2131166219).setVisibility(8);
        j.c(j.this).findViewById(2131166218).setVisibility(8);
        j.c(j.this).setVisibility(8);
        paramAnonymousView = j.this;
        paramAnonymousView.a = false;
        paramAnonymousView.notifyDataSetChanged();
      }
    });
  }
  
  public void a(final b paramb)
  {
    UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
    AccountPageActivity.mNeedRefreshEval = true;
    new UserTask()
    {
      private f c = null;
      
      private void b(e paramAnonymouse)
      {
        if (this.c == null) {
          return;
        }
        e.a(j.b(j.this).getResources(), paramAnonymouse);
        j.b(j.this).showTipDialog(2131493533, paramAnonymouse.c);
      }
      
      public e a(f... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = paramb;
        if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.a() != null))
        {
          this.c = paramb.a();
          paramAnonymousVarArgs = ct.a();
          f localf = this.c;
          return paramAnonymousVarArgs.a(localf, localf.c ^ true);
        }
        return null;
      }
      
      public void a()
      {
        Object localObject = this.c;
        if (localObject == null) {
          return;
        }
        ((f)localObject).e = false;
        localObject = new e();
        ((e)localObject).b(10024);
        b((e)localObject);
        if (j.a(j.this) != null)
        {
          localObject = j.a(j.this).obtainMessage(3017);
          j.a(j.this).sendMessage((Message)localObject);
        }
      }
      
      public void a(e paramAnonymouse)
      {
        f localf = this.c;
        if (localf != null)
        {
          if (paramAnonymouse == null) {
            return;
          }
          localf.e = false;
          if (!paramAnonymouse.b()) {
            b(paramAnonymouse);
          }
          paramAnonymouse = paramb;
          if ((paramAnonymouse != null) && (paramAnonymouse.c() != null) && (this.c.b.equals(paramb.c().getText())))
          {
            j.this.a(paramb, true);
            return;
          }
          j.this.notifyDataSetChanged();
          return;
        }
      }
    }.c(new f[0]);
  }
  
  public void a(b paramb, boolean paramBoolean)
  {
    if ((paramb != null) && (paramb.a() != null))
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        if (((UtilsGameProtectActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramb.a();
        TextView localTextView = paramb.c();
        SwitchButton localSwitchButton = paramb.b();
        ProgressBar localProgressBar = paramb.d();
        paramb = paramb.e();
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (paramb != null))
        {
          if (localObject == null) {
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("game protect: ");
          localStringBuilder.append(((f)localObject).b);
          localStringBuilder.append(", ");
          localStringBuilder.append(localTextView.getText());
          g.c(localStringBuilder.toString());
          if ((paramBoolean) && (!((f)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((f)localObject).f) {
            paramb.setVisibility(0);
          } else {
            paramb.setVisibility(4);
          }
          if ((!((f)localObject).e) && (ct.a().p()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((f)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if ((!ct.a().p()) && (!this.c.mIsIniting)) {
            this.c.queryGameProtectStatus();
          }
          localTextView.setText(((f)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public int getCount()
  {
    if (this.a) {
      return ct.a().e();
    }
    return ct.a().f();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    f localf = ct.a().b(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.d.inflate(2131296476, paramViewGroup, false);
    }
    paramView = new StringBuilder();
    paramView.append("game protect getview: ");
    paramView.append(localf.a);
    g.c(paramView.toString());
    paramView = new b(localView, localf);
    paramView.b().setTag(paramView);
    paramView.b().setOnCheckedChangeListener(this.b);
    a(paramView, false);
    return localView;
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = (j.b)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      f localf = paramCompoundButton.a();
      View localView = paramCompoundButton.f();
      if ((localf != null) && (localView != null) && (ct.a().p()))
      {
        if (paramBoolean != localf.c) {
          return;
        }
        if (localf.e) {
          return;
        }
        localf.e = true;
        j.this.a(paramCompoundButton, false);
        j.this.a(paramCompoundButton);
        return;
      }
    }
  }
  
  class b
  {
    View a;
    TextView b;
    ProgressBar c;
    SwitchButton d;
    ImageView e;
    f f;
    
    b(View paramView, f paramf)
    {
      this.a = paramView;
      this$1 = this.a;
      if (j.this == null) {
        return;
      }
      this.f = paramf;
      this.d = ((SwitchButton)j.this.findViewById(2131165556));
      this.b = ((TextView)this.a.findViewById(2131166216));
      this.c = ((ProgressBar)this.a.findViewById(2131165558));
      this.e = ((ImageView)this.a.findViewById(2131166217));
    }
    
    public f a()
    {
      return this.f;
    }
    
    public SwitchButton b()
    {
      return this.d;
    }
    
    public TextView c()
    {
      return this.b;
    }
    
    public ProgressBar d()
    {
      return this.c;
    }
    
    public ImageView e()
    {
      return this.e;
    }
    
    public View f()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.j
 * JD-Core Version:    0.7.0.1
 */