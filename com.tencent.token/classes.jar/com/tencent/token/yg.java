package com.tencent.token;

import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.ScanLoginAccountListActivity;

public final class yg
  extends BaseAdapter
{
  public boolean a;
  ScanLoginAccountListActivity b;
  private LayoutInflater c;
  private View.OnClickListener d = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      yg.this.b.addUser();
    }
  };
  
  public yg(ScanLoginAccountListActivity paramScanLoginAccountListActivity)
  {
    this.b = paramScanLoginAccountListActivity;
    this.c = LayoutInflater.from(this.b);
  }
  
  public final int getCount()
  {
    int i = sz.a().k.a();
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
    int i = sz.a().k.a();
    if ((paramInt != 0) || (i == 0)) {}
    try
    {
      paramViewGroup = this.c.inflate(2131296425, paramViewGroup, false);
      paramViewGroup.findViewById(2131165448).setVisibility(0);
      paramViewGroup.setOnClickListener(this.d);
      return paramViewGroup;
    }
    catch (InflateException paramViewGroup)
    {
      ImageView localImageView1;
      Object localObject1;
      Object localObject2;
      ImageView localImageView2;
      ImageView localImageView3;
      paramViewGroup.printStackTrace();
    }
    paramViewGroup = this.c.inflate(2131296427, paramViewGroup, false);
    paramView = paramViewGroup;
    if (paramInt < i)
    {
      paramViewGroup = this.c.inflate(2131296426, paramViewGroup, false);
      paramView = paramViewGroup;
      paramViewGroup = sz.a().a(paramInt);
      if (paramViewGroup == null) {
        return paramView;
      }
      localImageView1 = (ImageView)paramView.findViewById(2131165855);
      localObject1 = (TextView)paramView.findViewById(2131165856);
      localObject2 = (TextView)paramView.findViewById(2131165866);
      localImageView2 = (ImageView)paramView.findViewById(2131165800);
      localImageView3 = (ImageView)paramView.findViewById(2131165433);
      ((TextView)localObject1).setText(paramViewGroup.mNickName);
      if ((paramViewGroup.mUinMask != null) && (paramViewGroup.mUinMask.length() > 0)) {
        ((TextView)localObject2).setText(paramViewGroup.mUinMask);
      } else {
        ((TextView)localObject2).setText(aac.e(paramViewGroup.mRealUin));
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramViewGroup.mRealUin);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramViewGroup.mUin);
      localImageView1.setImageDrawable(zy.a((String)localObject1, ((StringBuilder)localObject2).toString()));
      if (this.a)
      {
        localImageView3.setVisibility(0);
        localImageView2.setVisibility(4);
        localImageView3.setTag(paramViewGroup);
        localImageView3.setOnClickListener(this.b.mDeleteListener);
        return paramView;
      }
      localImageView2.setVisibility(0);
      localImageView3.setVisibility(4);
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.b.mLoginListener);
      return paramView;
    }
    paramViewGroup = this.c.inflate(2131296425, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this.d);
    return paramViewGroup;
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yg
 * JD-Core Version:    0.7.0.1
 */