package com.tencent.token.ui.base;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.FacePwdIndexActivity;
import com.tencent.token.utils.s;
import java.util.List;

final class ab
  extends BaseAdapter
{
  private List a;
  private Dialog b;
  private LayoutInflater c;
  private FacePwdIndexActivity d;
  
  public ab(FacePwdIndexActivity paramFacePwdIndexActivity, Dialog paramDialog, List paramList)
  {
    this.c = LayoutInflater.from(paramFacePwdIndexActivity);
    this.b = paramDialog;
    this.a = paramList;
    this.d = paramFacePwdIndexActivity;
  }
  
  public final int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2130903086, paramViewGroup, false);
    }
    paramView = localView.findViewById(2131296550);
    if (paramInt == getCount() - 1) {
      paramView.setVisibility(4);
    }
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131296563);
      if (this.a != null)
      {
        paramViewGroup = (QQUser)this.a.get(paramInt);
        if (paramViewGroup != null)
        {
          paramView.setText(paramViewGroup.mNickName + "(" + s.e(paramViewGroup.mRealUin) + ")");
          localView.setOnClickListener(new ac(this, paramViewGroup));
        }
      }
      return localView;
      paramView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ab
 * JD-Core Version:    0.7.0.1
 */