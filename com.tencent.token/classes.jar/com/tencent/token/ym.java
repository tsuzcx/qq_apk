package com.tencent.token;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.FacePwdIndexActivity;
import java.util.List;

public final class ym
  extends BaseAdapter
{
  private List<QQUser> a;
  private Dialog b;
  private LayoutInflater c;
  private FacePwdIndexActivity d;
  
  public ym(FacePwdIndexActivity paramFacePwdIndexActivity, Dialog paramDialog, List<QQUser> paramList)
  {
    this.c = LayoutInflater.from(paramFacePwdIndexActivity);
    this.b = paramDialog;
    this.a = paramList;
    this.d = paramFacePwdIndexActivity;
  }
  
  public final int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2131296333, paramViewGroup, false);
    }
    paramView = localView.findViewById(2131165447);
    if (paramInt == getCount() - 1) {
      paramView.setVisibility(4);
    } else {
      paramView.setVisibility(0);
    }
    paramView = (TextView)localView.findViewById(2131166073);
    paramViewGroup = this.a;
    if (paramViewGroup != null)
    {
      paramViewGroup = (QQUser)paramViewGroup.get(paramInt);
      if (paramViewGroup != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramViewGroup.mNickName);
        localStringBuilder.append("(");
        localStringBuilder.append(aad.e(paramViewGroup.mRealUin));
        localStringBuilder.append(")");
        paramView.setText(localStringBuilder.toString());
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            aae.b(paramViewGroup.mRealUin);
            ym.a(ym.this).dismiss();
            ym.b(ym.this).refreshList();
          }
        });
      }
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ym
 * JD-Core Version:    0.7.0.1
 */