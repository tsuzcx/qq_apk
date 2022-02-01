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

public final class xy
  extends BaseAdapter
{
  public boolean a = true;
  public View b;
  a c = new a();
  private UtilsGameProtectActivity d;
  private LayoutInflater e;
  private ListView f;
  private Handler g;
  
  public xy(UtilsGameProtectActivity paramUtilsGameProtectActivity, ListView paramListView, Handler paramHandler)
  {
    this.d = paramUtilsGameProtectActivity;
    this.e = LayoutInflater.from(paramUtilsGameProtectActivity);
    this.f = paramListView;
    this.g = paramHandler;
  }
  
  public static void a()
  {
    int j = ta.a().d.b();
    int i = 0;
    while (i < j)
    {
      sk localsk = ta.a().b(i);
      if (localsk != null) {
        localsk.e = false;
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
          localStringBuilder.append(((sk)localObject).b);
          localStringBuilder.append(", ");
          localStringBuilder.append(localTextView.getText());
          xa.c(localStringBuilder.toString());
          if ((paramBoolean) && (!((sk)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((sk)localObject).f) {
            paramb.setVisibility(0);
          } else {
            paramb.setVisibility(4);
          }
          if ((!((sk)localObject).e) && (ta.a().d()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((sk)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if ((!ta.a().d()) && (!this.d.mIsIniting)) {
            this.d.queryGameProtectStatus();
          }
          localTextView.setText(((sk)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.a) {
      return ta.a().d.c();
    }
    return ta.a().d.b();
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
    sk localsk = ta.a().b(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.e.inflate(2131296477, paramViewGroup, false);
    }
    paramView = new StringBuilder("game protect getview: ");
    paramView.append(localsk.a);
    xa.c(paramView.toString());
    paramView = new b(localView, localsk);
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
      paramCompoundButton = (xy.b)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      Object localObject = paramCompoundButton.f;
      View localView = paramCompoundButton.a;
      if ((localObject != null) && (localView != null) && (ta.a().d()))
      {
        if (paramBoolean != ((sk)localObject).c) {
          return;
        }
        if (((sk)localObject).e) {
          return;
        }
        ((sk)localObject).e = true;
        xy.this.a(paramCompoundButton, false);
        localObject = xy.this;
        com.tencent.token.ui.UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
        com.tencent.token.ui.AccountPageActivity.mNeedRefreshEval = true;
        new xy.1((xy)localObject, paramCompoundButton).a(new sk[0]);
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
    sk f;
    
    b(View paramView, sk paramsk)
    {
      this.a = paramView;
      this$1 = this.a;
      if (xy.this == null) {
        return;
      }
      this.f = paramsk;
      this.d = ((SwitchButton)xy.this.findViewById(2131165558));
      this.b = ((TextView)this.a.findViewById(2131166229));
      this.c = ((ProgressBar)this.a.findViewById(2131165560));
      this.e = ((ImageView)this.a.findViewById(2131166230));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xy
 * JD-Core Version:    0.7.0.1
 */