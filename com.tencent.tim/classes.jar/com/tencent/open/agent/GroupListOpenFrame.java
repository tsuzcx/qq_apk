package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arqw;
import arqx;
import artj;
import artl;
import arwt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class GroupListOpenFrame
  extends OpenFrame
{
  protected EditText I;
  protected TextView Xf;
  protected a a;
  protected RecommendListManager a;
  protected TextView acR;
  protected XListView j;
  
  public GroupListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void WU(String paramString)
  {
    this.acR.setText(paramString);
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    arwt.d("GroupListOpenFrame", "-->onStart()");
    this.b.b(false, true, "", this.b.getString(2131691785));
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_a_of_type_Artl.Nf() == 0)
    {
      this.Xf.setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$a.notifyDataSetChanged();
      return;
      this.Xf.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.notifyDataSetChanged();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    arwt.d("GroupListOpenFrame", "-->onCreate()");
    super.setContentView(2131563073);
    this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$a = new a();
    this.j = ((XListView)super.findViewById(2131382384));
    paramBundle = (LinearLayout)super.getActivity().getLayoutInflater().inflate(2131559880, null);
    paramBundle.findViewById(2131363801).setVisibility(8);
    this.Xf = ((TextView)paramBundle.findViewById(2131379568));
    this.acR = ((TextView)paramBundle.findViewById(2131379569));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager = ((RecommendListManager)paramBundle.findViewById(2131378545));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setActivity(this.b);
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.onCreate();
    this.j.setSelector(2131167595);
    this.j.addHeaderView(paramBundle);
    this.j.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$a);
    this.I = ((EditText)paramBundle.findViewById(2131366542));
    this.I.setOnTouchListener(new arqw(this));
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.notifyDataSetChanged();
    arwt.d("GroupListOpenFrame", "-->onResume()");
    super.onResume();
  }
  
  public class a
    extends artj
  {
    protected a() {}
    
    public int getCount()
    {
      return GroupListOpenFrame.this.a.Ng();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      int i;
      if (paramView == null)
      {
        paramView = new a();
        localView = GroupListOpenFrame.this.mLayoutInflater.inflate(2131559881, GroupListOpenFrame.this.j, false);
        paramView.Zw = ((TextView)localView.findViewById(2131363743));
        paramView.txt = ((TextView)localView.findViewById(2131368163));
        paramView.layout = ((RelativeLayout)localView.findViewById(2131368162));
        localView.setTag(paramView);
        localObject = GroupListOpenFrame.this.a.ee(paramInt);
        paramView.Zw.setText((CharSequence)localObject);
        paramView.txt.setText(String.valueOf(GroupListOpenFrame.this.a.kI(paramInt)));
        i = (int)(10.0F * GroupListOpenFrame.this.b.mDensity);
        if (paramInt != 0) {
          break label222;
        }
        paramView.layout.setBackgroundResource(2130839701);
      }
      for (;;)
      {
        paramView.layout.setPadding(i, 0, i, 0);
        paramView.layout.setOnClickListener(new arqx(this, paramInt, (String)localObject));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label222:
        if (paramInt == getCount() - 1) {
          paramView.layout.setBackgroundResource(2130839689);
        } else {
          paramView.layout.setBackgroundResource(2130839695);
        }
      }
    }
    
    public class a
    {
      public TextView Zw;
      public RelativeLayout layout;
      public TextView txt;
      
      protected a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame
 * JD-Core Version:    0.7.0.1
 */