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
import com.tencent.token.cr;
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
    int j = cr.a().f();
    int i = 0;
    while (i < j)
    {
      f localf = cr.a().b(i);
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
        j.c(j.this).findViewById(2131559431).setVisibility(8);
        j.c(j.this).findViewById(2131559430).setVisibility(8);
        j.c(j.this).setVisibility(8);
        j.this.a = false;
        j.this.notifyDataSetChanged();
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
        j.b(j.this).showTipDialog(2131231390, paramAnonymouse.c);
      }
      
      public e a(f... paramAnonymousVarArgs)
      {
        if ((paramb == null) || (paramb.a() == null)) {
          return null;
        }
        this.c = paramb.a();
        paramAnonymousVarArgs = cr.a();
        f localf = this.c;
        if (!this.c.c) {}
        for (boolean bool = true;; bool = false) {
          return paramAnonymousVarArgs.a(localf, bool);
        }
      }
      
      public void a()
      {
        if (this.c == null) {}
        do
        {
          return;
          this.c.e = false;
          localObject = new e();
          ((e)localObject).b(10024);
          b((e)localObject);
        } while (j.a(j.this) == null);
        Object localObject = j.a(j.this).obtainMessage(3017);
        j.a(j.this).sendMessage((Message)localObject);
      }
      
      public void a(e paramAnonymouse)
      {
        if ((this.c == null) || (paramAnonymouse == null)) {
          return;
        }
        this.c.e = false;
        if (paramAnonymouse.b()) {}
        while ((paramb != null) && (paramb.c() != null) && (this.c.b.equals(paramb.c().getText())))
        {
          j.this.a(paramb, true);
          return;
          b(paramAnonymouse);
        }
        j.this.notifyDataSetChanged();
      }
    }.c(new f[0]);
  }
  
  public void a(b paramb, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramb == null) || (paramb.a() == null) || (this.c == null) || (this.c.isFinishing())) {}
    f localf;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    do
    {
      do
      {
        return;
        localf = paramb.a();
        localTextView = paramb.c();
        localSwitchButton = paramb.b();
        localProgressBar = paramb.d();
        paramb = paramb.e();
      } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (paramb == null) || (localf == null));
      g.c("game protect: " + localf.b + ", " + localTextView.getText());
    } while ((paramBoolean) && (!localf.b.equals(localTextView.getText())));
    if (localf.f) {
      paramb.setVisibility(0);
    }
    while ((localf.e) || (!cr.a().p()))
    {
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if ((!cr.a().p()) && (!this.c.mIsIniting)) {
        this.c.queryGameProtectStatus();
      }
      localTextView.setText(localf.b);
      return;
      paramb.setVisibility(4);
    }
    localProgressBar.setVisibility(4);
    localSwitchButton.setVisibility(0);
    localSwitchButton.setEnabled(true);
    if (!localf.c) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localSwitchButton.a(paramBoolean, false);
      break;
    }
  }
  
  public int getCount()
  {
    if (this.a) {
      return cr.a().e();
    }
    return cr.a().f();
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
    f localf = cr.a().b(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.d.inflate(2130968795, paramViewGroup, false);
    }
    g.c("game protect getview: " + localf.a);
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
      if (paramCompoundButton == null) {}
      f localf;
      View localView;
      do
      {
        return;
        localf = paramCompoundButton.a();
        localView = paramCompoundButton.f();
      } while ((localf == null) || (localView == null) || (!cr.a().p()) || (paramBoolean != localf.c) || (localf.e));
      localf.e = true;
      j.this.a(paramCompoundButton, false);
      j.this.a(paramCompoundButton);
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
      if (this.a == null) {
        return;
      }
      this.f = paramf;
      this.d = ((SwitchButton)this.a.findViewById(2131559374));
      this.b = ((TextView)this.a.findViewById(2131559372));
      this.c = ((ProgressBar)this.a.findViewById(2131559375));
      this.e = ((ImageView)this.a.findViewById(2131559373));
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