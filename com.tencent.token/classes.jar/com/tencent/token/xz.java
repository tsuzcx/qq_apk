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

public final class xz
  extends BaseAdapter
{
  public boolean a = true;
  public View b;
  a c = new a();
  private UtilsGameProtectActivity d;
  private LayoutInflater e;
  private ListView f;
  private Handler g;
  
  public xz(UtilsGameProtectActivity paramUtilsGameProtectActivity, ListView paramListView, Handler paramHandler)
  {
    this.d = paramUtilsGameProtectActivity;
    this.e = LayoutInflater.from(paramUtilsGameProtectActivity);
    this.f = paramListView;
    this.g = paramHandler;
  }
  
  public static void a()
  {
    int j = tb.a().d.b();
    int i = 0;
    while (i < j)
    {
      sl localsl = tb.a().b(i);
      if (localsl != null) {
        localsl.e = false;
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
          localStringBuilder.append(((sl)localObject).b);
          localStringBuilder.append(", ");
          localStringBuilder.append(localTextView.getText());
          xb.c(localStringBuilder.toString());
          if ((paramBoolean) && (!((sl)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((sl)localObject).f) {
            paramb.setVisibility(0);
          } else {
            paramb.setVisibility(4);
          }
          if ((!((sl)localObject).e) && (tb.a().d()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((sl)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if ((!tb.a().d()) && (!this.d.mIsIniting)) {
            this.d.queryGameProtectStatus();
          }
          localTextView.setText(((sl)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.a) {
      return tb.a().d.c();
    }
    return tb.a().d.b();
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
    sl localsl = tb.a().b(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.e.inflate(2131296477, paramViewGroup, false);
    }
    paramView = new StringBuilder("game protect getview: ");
    paramView.append(localsl.a);
    xb.c(paramView.toString());
    paramView = new b(localView, localsl);
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
      paramCompoundButton = (xz.b)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      Object localObject = paramCompoundButton.f;
      View localView = paramCompoundButton.a;
      if ((localObject != null) && (localView != null) && (tb.a().d()))
      {
        if (paramBoolean != ((sl)localObject).c) {
          return;
        }
        if (((sl)localObject).e) {
          return;
        }
        ((sl)localObject).e = true;
        xz.this.a(paramCompoundButton, false);
        localObject = xz.this;
        com.tencent.token.ui.UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
        com.tencent.token.ui.AccountPageActivity.mNeedRefreshEval = true;
        new xz.1((xz)localObject, paramCompoundButton).a(new sl[0]);
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
    sl f;
    
    b(View paramView, sl paramsl)
    {
      this.a = paramView;
      this$1 = this.a;
      if (xz.this == null) {
        return;
      }
      this.f = paramsl;
      this.d = ((SwitchButton)xz.this.findViewById(2131165558));
      this.b = ((TextView)this.a.findViewById(2131166229));
      this.c = ((ProgressBar)this.a.findViewById(2131165560));
      this.e = ((ImageView)this.a.findViewById(2131166230));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xz
 * JD-Core Version:    0.7.0.1
 */