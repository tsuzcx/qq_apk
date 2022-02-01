package com.tencent.mobileqq.activity.selectmember;

import abeg;
import abeg.a;
import acff;
import acfp;
import acxw;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqgv;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private XListView I;
  private a a;
  private EditText ax;
  private acff f;
  private List<RecentUser> vz = new ArrayList();
  
  public RecentMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void czY()
  {
    this.vz.clear();
    Object localObject1 = this.e.a().a();
    if (localObject1 != null)
    {
      Object localObject2 = ((acxw)localObject1).q(true);
      if (localObject2 != null)
      {
        localObject1 = this.e.getCurrentAccountUin();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser != null) {
            try
            {
              if ((localRecentUser.getType() == 0) && (Long.parseLong(localRecentUser.uin) >= 10000L) && (!localRecentUser.uin.equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr.contains(localRecentUser.uin)))
              {
                Friends localFriends = this.f.b(localRecentUser.uin);
                if ((localFriends != null) && (localFriends.isFriend())) {
                  this.vz.add(localRecentUser);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719450), acfp.m(2131713707));
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$a.notifyDataSetChanged();
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$a.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    b localb = (b)paramView.getTag();
    if ((localb != null) && (localb.uin != null) && (localb.checkBox != null) && (localb.fe != null) && (localb.checkBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localb.uin, localb.fe.getText().toString(), 0, "-1");
      localb.checkBox.setChecked(bool);
      if (AppSetting.enableTalkBack)
      {
        if (!localb.checkBox.isChecked()) {
          break label139;
        }
        paramView.setContentDescription(localb.fe.getText().toString() + acfp.m(2131713705));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label139:
      paramView.setContentDescription(localb.fe.getText().toString() + acfp.m(2131713708));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131563073);
    this.f = ((acff)this.e.getManager(51));
    this.I = ((XListView)findViewById(2131382384));
    this.I.setSelector(2131167595);
    paramBundle = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131563007, this.I, false);
    this.ax = ((EditText)paramBundle.findViewById(2131366542));
    ((Button)paramBundle.findViewById(2131363801)).setVisibility(8);
    this.I.addHeaderView(paramBundle);
    czY();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$a = new a();
    this.I.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$a);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$a.destroy();
    }
    super.onDestroy();
  }
  
  public String qN()
  {
    return "-1";
  }
  
  class a
    extends abeg
  {
    public a()
    {
      super(RecentMemberInnerFrame.this.e, RecentMemberInnerFrame.a(RecentMemberInnerFrame.this), 1, true);
    }
    
    public int getCount()
    {
      if (RecentMemberInnerFrame.a(RecentMemberInnerFrame.this) == null) {
        return 0;
      }
      return RecentMemberInnerFrame.a(RecentMemberInnerFrame.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < RecentMemberInnerFrame.a(RecentMemberInnerFrame.this).size())) {
        return RecentMemberInnerFrame.a(RecentMemberInnerFrame.this).get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      View localView;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localObject = (RecentMemberInnerFrame.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
      RecentUser localRecentUser;
      for (;;)
      {
        localRecentUser = (RecentUser)getItem(paramInt);
        if (localRecentUser != null) {
          break;
        }
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        paramView = new RecentMemberInnerFrame.b(RecentMemberInnerFrame.this, null);
        localView = RecentMemberInnerFrame.this.a.getLayoutInflater().inflate(2131563063, paramViewGroup, false);
        paramView.checkBox = ((CheckBox)localView.findViewById(2131364587));
        paramView.pQ = ((ImageView)localView.findViewById(2131368698));
        paramView.fe = ((TextView)localView.findViewById(2131372190));
        localView.setTag(paramView);
      }
      if (RecentMemberInnerFrame.this.a.iX(localRecentUser.uin))
      {
        paramView.checkBox.setChecked(true);
        label168:
        paramView.pQ.setImageBitmap(a(1, localRecentUser.uin));
        localObject = RecentMemberInnerFrame.a(RecentMemberInnerFrame.this).b(localRecentUser.uin);
        if (localObject != null) {
          break label348;
        }
        localObject = "";
        label211:
        paramView.fe.setText((CharSequence)localObject);
        paramView.uin = localRecentUser.uin;
        if ((RecentMemberInnerFrame.this.a.so == null) || (!RecentMemberInnerFrame.this.a.so.contains(localRecentUser.uin))) {
          break label358;
        }
        paramView.checkBox.setEnabled(false);
        label271:
        if (AppSetting.enableTalkBack)
        {
          if ((!paramView.checkBox.isChecked()) || (!paramView.checkBox.isEnabled())) {
            break label369;
          }
          localView.setContentDescription((String)localObject + acfp.m(2131713709));
        }
      }
      for (;;)
      {
        localView.setOnClickListener(RecentMemberInnerFrame.this);
        break;
        paramView.checkBox.setChecked(false);
        break label168;
        label348:
        localObject = aqgv.c((Friends)localObject);
        break label211;
        label358:
        paramView.checkBox.setEnabled(true);
        break label271;
        label369:
        localView.setContentDescription((String)localObject + acfp.m(2131713706));
      }
    }
  }
  
  class b
    extends abeg.a
  {
    public CheckBox checkBox;
    public TextView fe;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */