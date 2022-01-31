package com.tencent.token.ui;

import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

final class yq
  extends BaseAdapter
{
  ScanLoginAccountListActivity a;
  private LayoutInflater b;
  private boolean c;
  private View.OnClickListener d = new yr(this);
  
  public yq(ScanLoginAccountListActivity paramScanLoginAccountListActivity)
  {
    this.a = paramScanLoginAccountListActivity;
    this.b = LayoutInflater.from(this.a);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean != this.c)
    {
      this.c = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public final int getCount()
  {
    int i = ax.a().d();
    if (i >= 3) {
      return 3;
    }
    return i + 1;
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
    int i = ax.a().d();
    if ((paramInt != 0) || (i == 0)) {}
    try
    {
      paramViewGroup = this.b.inflate(2130903184, paramViewGroup, false);
      paramViewGroup.findViewById(2131296788).setVisibility(0);
      paramViewGroup.setOnClickListener(this.d);
      return paramViewGroup;
    }
    catch (InflateException paramViewGroup)
    {
      ImageView localImageView1;
      TextView localTextView1;
      paramViewGroup.printStackTrace();
      return paramView;
    }
    paramViewGroup = this.b.inflate(2130903186, paramViewGroup, false);
    paramView = paramViewGroup;
    paramViewGroup = ax.a().a(paramInt);
    if (paramViewGroup != null)
    {
      localImageView1 = (ImageView)paramView.findViewById(2131297018);
      localTextView1 = (TextView)paramView.findViewById(2131297019);
      TextView localTextView2 = (TextView)paramView.findViewById(2131297020);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131297022);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131297021);
      localTextView1.setText(paramViewGroup.mNickName);
      if ((paramViewGroup.mUinMask != null) && (paramViewGroup.mUinMask.length() > 0)) {
        localTextView2.setText(paramViewGroup.mUinMask);
      }
      for (;;)
      {
        localImageView1.setImageDrawable(k.a(paramViewGroup.mRealUin + "", paramViewGroup.mUin + ""));
        if (!this.c) {
          break label323;
        }
        localImageView3.setVisibility(0);
        localImageView2.setVisibility(4);
        localImageView3.setTag(paramViewGroup);
        localImageView3.setOnClickListener(this.a.mDeleteListener);
        return paramView;
        if (paramInt < i)
        {
          paramViewGroup = this.b.inflate(2130903185, paramViewGroup, false);
          paramView = paramViewGroup;
          break;
        }
        paramViewGroup = this.b.inflate(2130903184, paramViewGroup, false);
        paramViewGroup.setOnClickListener(this.d);
        return paramViewGroup;
        localTextView2.setText(s.e(paramViewGroup.mRealUin));
      }
      label323:
      localImageView2.setVisibility(0);
      localImageView3.setVisibility(4);
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.a.mLoginListener);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yq
 * JD-Core Version:    0.7.0.1
 */