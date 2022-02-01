package com.tencent.token.ui;

import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tencent.token.utils.g;
import com.tencent.token.utils.l;

class r
  extends BaseAdapter
{
  ScanLoginAccountListActivity a;
  private LayoutInflater b;
  private boolean c;
  private View.OnClickListener d = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      r.this.a.addUser();
    }
  };
  
  public r(ScanLoginAccountListActivity paramScanLoginAccountListActivity)
  {
    this.a = paramScanLoginAccountListActivity;
    this.b = LayoutInflater.from(this.a);
  }
  
  private void a(View paramView, QQUser paramQQUser)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131165851);
    Object localObject1 = (TextView)paramView.findViewById(2131165852);
    Object localObject2 = (TextView)paramView.findViewById(2131165862);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131165796);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131165431);
    ((TextView)localObject1).setText(paramQQUser.mNickName);
    if ((paramQQUser.mUinMask != null) && (paramQQUser.mUinMask.length() > 0)) {
      ((TextView)localObject2).setText(paramQQUser.mUinMask);
    } else {
      ((TextView)localObject2).setText(l.e(paramQQUser.mRealUin));
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramQQUser.mRealUin);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramQQUser.mUin);
    ((StringBuilder)localObject2).append("");
    localImageView1.setImageDrawable(g.a((String)localObject1, ((StringBuilder)localObject2).toString()));
    if (this.c)
    {
      localImageView3.setVisibility(0);
      localImageView2.setVisibility(4);
      localImageView3.setTag(paramQQUser);
      localImageView3.setOnClickListener(this.a.mDeleteListener);
      return;
    }
    localImageView2.setVisibility(0);
    localImageView3.setVisibility(4);
    paramView.setTag(paramQQUser);
    paramView.setOnClickListener(this.a.mLoginListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean != this.c)
    {
      this.c = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public int getCount()
  {
    int i = cs.a().d();
    if (i >= 3) {
      return 3;
    }
    return i + 1;
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
    int i = cs.a().d();
    if ((paramInt != 0) || (i == 0)) {}
    try
    {
      paramViewGroup = this.b.inflate(2131296424, paramViewGroup, false);
      paramViewGroup.findViewById(2131165446).setVisibility(0);
      paramViewGroup.setOnClickListener(this.d);
      return paramViewGroup;
    }
    catch (InflateException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    paramViewGroup = this.b.inflate(2131296426, paramViewGroup, false);
    paramView = paramViewGroup;
    if (paramInt < i)
    {
      paramViewGroup = this.b.inflate(2131296425, paramViewGroup, false);
      paramView = paramViewGroup;
      paramViewGroup = cs.a().a(paramInt);
      if (paramViewGroup == null) {
        return paramView;
      }
      a(paramView, paramViewGroup);
      return paramView;
    }
    paramViewGroup = this.b.inflate(2131296424, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this.d);
    return paramViewGroup;
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.r
 * JD-Core Version:    0.7.0.1
 */