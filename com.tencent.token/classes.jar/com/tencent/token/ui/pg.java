package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.fn;
import java.util.ArrayList;

final class pg
  extends BaseAdapter
{
  private UtilsMbInfoActivity a;
  private LayoutInflater b;
  
  public pg(UtilsMbInfoActivity paramUtilsMbInfoActivity)
  {
    this.a = paramUtilsMbInfoActivity;
    this.b = LayoutInflater.from(paramUtilsMbInfoActivity);
  }
  
  public final int getCount()
  {
    MbInfoResult localMbInfoResult = fn.a().c();
    if ((localMbInfoResult == null) || (localMbInfoResult.mMbInfoItems == null)) {
      return 0;
    }
    return localMbInfoResult.mMbInfoItems.size();
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.b.inflate(2130903243, paramViewGroup, false);
    }
    paramView = fn.a().c();
    if ((paramView == null) && (!this.a.mIsIniting)) {
      this.a.getMbInfo();
    }
    while ((paramView == null) || (paramView.mMbInfoItems == null) || (paramView.mMbInfoItems.size() <= paramInt)) {
      return localView;
    }
    paramView = (MbInfoResult.MbInfoItem)paramView.mMbInfoItems.get(paramInt);
    paramViewGroup = (TextView)localView.findViewById(2131297249);
    TextView localTextView1 = (TextView)localView.findViewById(2131297250);
    TextView localTextView2 = (TextView)localView.findViewById(2131297252);
    if (paramView.mName != null) {
      paramViewGroup.setText(paramView.mName);
    }
    if (paramView.mDesc != null) {
      localTextView1.setText(paramView.mDesc);
    }
    if (paramView.mOpName != null) {
      localTextView2.setText(paramView.mOpName);
    }
    localView.setOnClickListener(new ph(this, paramView, paramInt, paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pg
 * JD-Core Version:    0.7.0.1
 */