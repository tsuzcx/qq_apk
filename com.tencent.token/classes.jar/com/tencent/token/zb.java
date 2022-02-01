package com.tencent.token;

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
import com.tencent.token.ui.UtilsMbInfoActivity;
import com.tencent.token.ui.UtilsMbInfoItemActivity;
import com.tencent.token.ui.UtilsModSetMobileStep1Activity;
import java.util.ArrayList;

public final class zb
  extends BaseAdapter
{
  private UtilsMbInfoActivity a;
  private LayoutInflater b;
  
  public zb(UtilsMbInfoActivity paramUtilsMbInfoActivity)
  {
    this.a = paramUtilsMbInfoActivity;
    this.b = LayoutInflater.from(paramUtilsMbInfoActivity);
  }
  
  public final int getCount()
  {
    MbInfoResult localMbInfoResult = abh.a().c();
    if ((localMbInfoResult != null) && (localMbInfoResult.mMbInfoItems != null)) {
      return localMbInfoResult.mMbInfoItems.size();
    }
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.b.inflate(2131296501, paramViewGroup, false);
    }
    paramView = abh.a().c();
    if ((paramView == null) && (!this.a.mIsIniting))
    {
      this.a.getMbInfo();
      return localView;
    }
    if ((paramView != null) && (paramView.mMbInfoItems != null))
    {
      if (paramView.mMbInfoItems.size() <= paramInt) {
        return localView;
      }
      paramView = (MbInfoResult.MbInfoItem)paramView.mMbInfoItems.get(paramInt);
      paramViewGroup = (TextView)localView.findViewById(2131166279);
      TextView localTextView1 = (TextView)localView.findViewById(2131166278);
      TextView localTextView2 = (TextView)localView.findViewById(2131166280);
      if (paramView.mName != null) {
        paramViewGroup.setText(paramView.mName);
      }
      if (paramView.mDesc != null) {
        localTextView1.setText(paramView.mDesc);
      }
      if (paramView.mOpName != null) {
        localTextView2.setText(paramView.mOpName);
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if ((paramView.mId == 51) && (paramView.mDetail.mBtnType == 1))
          {
            paramAnonymousView = new Intent(zb.a(zb.this), UtilsModSetMobileStep1Activity.class);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(zb.a(zb.this).getResources().getString(2131493581));
            localStringBuilder.append(paramView.mName);
            paramAnonymousView.putExtra("title", localStringBuilder.toString());
            paramAnonymousView.putExtra("op_type", 1);
            paramAnonymousView.putExtra("position", paramInt);
            zb.a(zb.this).startActivity(paramAnonymousView);
            return;
          }
          paramAnonymousView = new Intent(zb.a(zb.this), UtilsMbInfoItemActivity.class);
          paramAnonymousView.putExtra("position", paramInt);
          zb.a(zb.this).startActivity(paramAnonymousView);
        }
      });
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zb
 * JD-Core Version:    0.7.0.1
 */