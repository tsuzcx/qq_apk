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
import com.tencent.token.cq;
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
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131559202);
    TextView localTextView1 = (TextView)paramView.findViewById(2131559203);
    TextView localTextView2 = (TextView)paramView.findViewById(2131559204);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131559206);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131559205);
    localTextView1.setText(paramQQUser.mNickName);
    if ((paramQQUser.mUinMask != null) && (paramQQUser.mUinMask.length() > 0)) {
      localTextView2.setText(paramQQUser.mUinMask);
    }
    for (;;)
    {
      localImageView1.setImageDrawable(g.a(paramQQUser.mRealUin + "", paramQQUser.mUin + ""));
      if (!this.c) {
        break;
      }
      localImageView3.setVisibility(0);
      localImageView2.setVisibility(4);
      localImageView3.setTag(paramQQUser);
      localImageView3.setOnClickListener(this.a.mDeleteListener);
      return;
      localTextView2.setText(l.e(paramQQUser.mRealUin));
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
    int i = cq.a().d();
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
    int i = cq.a().d();
    if ((paramInt != 0) || (i == 0)) {}
    try
    {
      paramViewGroup = this.b.inflate(2130968743, paramViewGroup, false);
      paramViewGroup.findViewById(2131558992).setVisibility(0);
      paramViewGroup.setOnClickListener(this.d);
      return paramViewGroup;
    }
    catch (InflateException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
      paramViewGroup = paramView;
    }
    paramViewGroup = this.b.inflate(2130968745, paramViewGroup, false);
    for (paramView = paramViewGroup;; paramView = paramViewGroup)
    {
      QQUser localQQUser = cq.a().a(paramInt);
      paramViewGroup = paramView;
      if (localQQUser == null) {
        return paramViewGroup;
      }
      a(paramView, localQQUser);
      return paramView;
      if (paramInt >= i) {
        break;
      }
      paramViewGroup = this.b.inflate(2130968744, paramViewGroup, false);
    }
    paramViewGroup = this.b.inflate(2130968743, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this.d);
    return paramViewGroup;
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.r
 * JD-Core Version:    0.7.0.1
 */