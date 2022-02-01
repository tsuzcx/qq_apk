package com.tencent.token;

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
import com.tencent.token.ui.UtilsGameProtectActivity;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.UserTask;

public final class yx
  extends BaseAdapter
{
  public boolean a = true;
  public View b;
  a c = new a();
  private UtilsGameProtectActivity d;
  private LayoutInflater e;
  private ListView f;
  private Handler g;
  
  public yx(UtilsGameProtectActivity paramUtilsGameProtectActivity, ListView paramListView, Handler paramHandler)
  {
    this.d = paramUtilsGameProtectActivity;
    this.e = LayoutInflater.from(paramUtilsGameProtectActivity);
    this.f = paramListView;
    this.g = paramHandler;
  }
  
  public static void a()
  {
    int j = tu.a().d.c();
    int i = 0;
    while (i < j)
    {
      te localte = tu.a().b(i);
      if (localte != null) {
        localte.e = false;
      }
      i += 1;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean)
  {
    if ((paramb != null) && (paramb.f != null))
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (((UtilsGameProtectActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramb.f;
        TextView localTextView = paramb.b;
        SwitchButton localSwitchButton = paramb.d;
        ProgressBar localProgressBar = paramb.c;
        paramb = paramb.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (paramb != null))
        {
          if (localObject == null) {
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder("game protect: ");
          localStringBuilder.append(((te)localObject).b);
          localStringBuilder.append(", ");
          localStringBuilder.append(localTextView.getText());
          xv.c(localStringBuilder.toString());
          if ((paramBoolean) && (!((te)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((te)localObject).f) {
            paramb.setVisibility(0);
          } else {
            paramb.setVisibility(4);
          }
          if ((!((te)localObject).e) && (tu.a().d()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((te)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if ((!tu.a().d()) && (!this.d.mIsIniting)) {
            this.d.queryGameProtectStatus();
          }
          localTextView.setText(((te)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.a) {
      return tu.a().d.d();
    }
    return tu.a().d.c();
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    te localte = tu.a().b(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.e.inflate(2131296490, paramViewGroup, false);
    }
    paramView = new StringBuilder("game protect getview: ");
    paramView.append(localte.a);
    xv.c(paramView.toString());
    paramView = new b(localView, localte);
    paramView.d.setTag(paramView);
    paramView.d.setOnCheckedChangeListener(this.c);
    a(paramView, false);
    return localView;
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = (yx.b)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      Object localObject = paramCompoundButton.f;
      View localView = paramCompoundButton.a;
      if ((localObject != null) && (localView != null) && (tu.a().d()))
      {
        if (paramBoolean != ((te)localObject).c) {
          return;
        }
        if (((te)localObject).e) {
          return;
        }
        ((te)localObject).e = true;
        yx.this.a(paramCompoundButton, false);
        localObject = yx.this;
        com.tencent.token.ui.UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
        com.tencent.token.ui.AccountPageActivity.mNeedRefreshEval = true;
        new yx.1((yx)localObject, paramCompoundButton).a(new te[0]);
        return;
      }
    }
  }
  
  final class b
  {
    View a;
    TextView b;
    ProgressBar c;
    SwitchButton d;
    ImageView e;
    te f;
    
    b(View paramView, te paramte)
    {
      this.a = paramView;
      this$1 = this.a;
      if (yx.this == null) {
        return;
      }
      this.f = paramte;
      this.d = ((SwitchButton)yx.this.findViewById(2131165573));
      this.b = ((TextView)this.a.findViewById(2131166271));
      this.c = ((ProgressBar)this.a.findViewById(2131165575));
      this.e = ((ImageView)this.a.findViewById(2131166272));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yx
 * JD-Core Version:    0.7.0.1
 */