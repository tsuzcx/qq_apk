package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.eq;
import java.util.ArrayList;

class or
  extends BaseAdapter
{
  private UtilsMbInfoActivity a;
  private LayoutInflater b;
  
  public or(UtilsMbInfoActivity paramUtilsMbInfoActivity)
  {
    this.a = paramUtilsMbInfoActivity;
    this.b = LayoutInflater.from(paramUtilsMbInfoActivity);
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject = eq.a().c();
    if ((localObject == null) && (!this.a.mIsIniting)) {
      this.a.getMbInfo();
    }
    while ((localObject == null) || (((MbInfoResult)localObject).mMbInfoItems == null) || (((MbInfoResult)localObject).mMbInfoItems.size() <= paramInt)) {
      return;
    }
    localObject = (MbInfoResult.MbInfoItem)((MbInfoResult)localObject).mMbInfoItems.get(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131559408);
    TextView localTextView2 = (TextView)paramView.findViewById(2131559409);
    TextView localTextView3 = (TextView)paramView.findViewById(2131559411);
    if (((MbInfoResult.MbInfoItem)localObject).mName != null) {
      localTextView1.setText(((MbInfoResult.MbInfoItem)localObject).mName);
    }
    if (((MbInfoResult.MbInfoItem)localObject).mDesc != null) {
      localTextView2.setText(((MbInfoResult.MbInfoItem)localObject).mDesc);
    }
    if (((MbInfoResult.MbInfoItem)localObject).mOpName != null) {
      localTextView3.setText(((MbInfoResult.MbInfoItem)localObject).mOpName);
    }
    paramView.setOnClickListener(new os(this, (MbInfoResult.MbInfoItem)localObject, paramInt, paramInt));
  }
  
  public int getCount()
  {
    MbInfoResult localMbInfoResult = eq.a().c();
    if ((localMbInfoResult == null) || (localMbInfoResult.mMbInfoItems == null)) {
      return 0;
    }
    return localMbInfoResult.mMbInfoItems.size();
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.b.inflate(2130968806, paramViewGroup, false);
    }
    a(localView, paramInt);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.or
 * JD-Core Version:    0.7.0.1
 */