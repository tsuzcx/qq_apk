package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.dj;
import java.util.ArrayList;

class n
  extends BaseAdapter
{
  private UtilsMbInfoActivity a;
  private LayoutInflater b;
  
  public n(UtilsMbInfoActivity paramUtilsMbInfoActivity)
  {
    this.a = paramUtilsMbInfoActivity;
    this.b = LayoutInflater.from(paramUtilsMbInfoActivity);
  }
  
  private void a(View paramView, final int paramInt)
  {
    Object localObject = dj.a().c();
    if ((localObject == null) && (!this.a.mIsIniting))
    {
      this.a.getMbInfo();
      return;
    }
    if ((localObject != null) && (((MbInfoResult)localObject).mMbInfoItems != null))
    {
      if (((MbInfoResult)localObject).mMbInfoItems.size() <= paramInt) {
        return;
      }
      localObject = (MbInfoResult.MbInfoItem)((MbInfoResult)localObject).mMbInfoItems.get(paramInt);
      TextView localTextView1 = (TextView)paramView.findViewById(2131166222);
      TextView localTextView2 = (TextView)paramView.findViewById(2131166221);
      TextView localTextView3 = (TextView)paramView.findViewById(2131166223);
      if (((MbInfoResult.MbInfoItem)localObject).mName != null) {
        localTextView1.setText(((MbInfoResult.MbInfoItem)localObject).mName);
      }
      if (((MbInfoResult.MbInfoItem)localObject).mDesc != null) {
        localTextView2.setText(((MbInfoResult.MbInfoItem)localObject).mDesc);
      }
      if (((MbInfoResult.MbInfoItem)localObject).mOpName != null) {
        localTextView3.setText(((MbInfoResult.MbInfoItem)localObject).mOpName);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((this.a.mId == 51) && (this.a.mDetail.mBtnType == 1))
          {
            paramAnonymousView = new Intent(n.a(n.this), UtilsModSetMobileStep1Activity.class);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(n.a(n.this).getResources().getString(2131493571));
            localStringBuilder.append(this.a.mName);
            paramAnonymousView.putExtra("title", localStringBuilder.toString());
            paramAnonymousView.putExtra("op_type", 1);
            paramAnonymousView.putExtra("position", paramInt);
            n.a(n.this).startActivity(paramAnonymousView);
            return;
          }
          paramAnonymousView = new Intent(n.a(n.this), UtilsMbInfoItemActivity.class);
          paramAnonymousView.putExtra("position", paramInt);
          n.a(n.this).startActivity(paramAnonymousView);
        }
      });
      return;
    }
  }
  
  public int getCount()
  {
    MbInfoResult localMbInfoResult = dj.a().c();
    if ((localMbInfoResult != null) && (localMbInfoResult.mMbInfoItems != null)) {
      return localMbInfoResult.mMbInfoItems.size();
    }
    return 0;
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
      localView = this.b.inflate(2131296487, paramViewGroup, false);
    }
    a(localView, paramInt);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.n
 * JD-Core Version:    0.7.0.1
 */