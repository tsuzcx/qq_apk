package com.tencent.mobileqq.activity.selectmember;

import aayj;
import acff;
import acxw;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectMemberFromFriendGroup
  extends SelectMemberInnerFrame
{
  a a;
  private final ArrayList<Groups> lj = new ArrayList();
  public List<Groups> vB = new ArrayList();
  List<Entity> vC = new ArrayList();
  
  public SelectMemberFromFriendGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public SelectMemberFromFriendGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectMemberFromFriendGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aQT()
  {
    Object localObject1 = this.e.a().a();
    if (localObject1 != null)
    {
      Object localObject3 = ((acxw)localObject1).q(true);
      if (localObject3 != null)
      {
        Object localObject2 = this.e.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            try
            {
              if ((((RecentUser)localObject4).getType() == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr.contains(((RecentUser)localObject4).uin)))
              {
                localObject4 = ((acff)this.e.getManager(51)).b(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend())) {
                  ((List)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131718631);
          ((Groups)localObject2).group_friend_count = ((List)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.lj.add(0, localObject2);
          this.vC = ((List)localObject1);
        }
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 1, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public void a(Groups paramGroups, boolean paramBoolean)
  {
    if (paramGroups.group_id == 1003) {}
    Object localObject;
    ArrayList localArrayList;
    for (paramGroups = this.vC;; paramGroups = ((acff)this.e.getManager(51)).p(paramGroups.group_id))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.so;
      localArrayList = new ArrayList();
      paramGroups = paramGroups.iterator();
      while (paramGroups.hasNext())
      {
        Friends localFriends = (Friends)paramGroups.next();
        if ((localObject == null) || (!((List)localObject).contains(localFriends.uin))) {
          localArrayList.add(SelectMemberActivity.a(localFriends.uin, localFriends.getFriendNickWithAlias(), 0, "-1"));
        }
      }
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e(localArrayList, false);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramGroups = localArrayList.iterator();
      while (paramGroups.hasNext())
      {
        localObject = (ResultRecord)paramGroups.next();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.Bd(((ResultRecord)localObject).uin);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.cz(false);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.cAc();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.cAh();
    }
  }
  
  boolean a(Groups paramGroups)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.so;
    if (localArrayList == null) {
      return false;
    }
    acff localacff = (acff)this.e.getManager(51);
    if (paramGroups.group_id == 1003) {}
    for (paramGroups = this.vC;; paramGroups = localacff.p(paramGroups.group_id))
    {
      paramGroups = paramGroups.iterator();
      do
      {
        if (!paramGroups.hasNext()) {
          break;
        }
      } while (localArrayList.contains(((Friends)paramGroups.next()).uin));
      return false;
    }
    return true;
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719450), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689896));
    notifyDataSetChanged();
  }
  
  void initData()
  {
    Object localObject = (acff)this.e.getManager(51);
    if (localObject != null) {}
    for (localObject = ((acff)localObject).co();; localObject = null)
    {
      if (((localObject == null) || (((List)localObject).size() == 0)) && (localObject == null)) {
        localObject = new ArrayList();
      }
      for (;;)
      {
        aQT();
        int i = ((List)localObject).size() - 1;
        if (i >= 0)
        {
          Groups localGroups = (Groups)((List)localObject).get(i);
          if (localGroups.group_friend_count == 0) {}
          for (;;)
          {
            i -= 1;
            break;
            this.lj.add(localGroups);
          }
        }
        return;
      }
    }
  }
  
  void initView()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    XListView localXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    localXListView.setDivider(null);
    localLinearLayout.addView(localXListView);
    localXListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberFromFriendGroup$a = new a();
    localXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberFromFriendGroup$a);
    setContentView(localLinearLayout);
  }
  
  public void notifyDataSetChanged()
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.aQ;
    ArrayList localArrayList2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.so;
    acff localacff = (acff)this.e.getManager(51);
    Iterator localIterator1 = this.lj.iterator();
    int i = 0;
    Groups localGroups;
    if (localIterator1.hasNext())
    {
      localGroups = (Groups)localIterator1.next();
      Object localObject;
      if (localGroups.group_id == 1003)
      {
        localObject = this.vC;
        localObject = ((List)localObject).iterator();
      }
      label181:
      do
      {
        Friends localFriends;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localFriends = (Friends)((Iterator)localObject).next();
        } while ((localArrayList2 != null) && (localArrayList2.contains(localFriends.uin)));
        Iterator localIterator2 = localArrayList1.iterator();
        j = 0;
        for (;;)
        {
          if (localIterator2.hasNext())
          {
            if (!((ResultRecord)localIterator2.next()).uin.equals(localFriends.uin)) {
              break label285;
            }
            j = 1;
            continue;
            localObject = localacff.p(localGroups.group_id);
            break;
          }
        }
      } while (j != 0);
    }
    for (int j = 0;; j = 1)
    {
      if (j == 0)
      {
        if (!this.vB.contains(localGroups)) {
          break label282;
        }
        this.vB.remove(localGroups);
        i = 1;
      }
      label282:
      for (;;)
      {
        break;
        if (!this.vB.contains(localGroups))
        {
          this.vB.add(localGroups);
          i = 1;
          continue;
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberFromFriendGroup$a.notifyDataSetChanged();
          }
          return;
        }
      }
      label285:
      break label181;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initData();
    initView();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public String qN()
  {
    return null;
  }
  
  public class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      return SelectMemberFromFriendGroup.a(SelectMemberFromFriendGroup.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return SelectMemberFromFriendGroup.a(SelectMemberFromFriendGroup.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(SelectMemberFromFriendGroup.this.a).inflate(2131560609, null);
        paramView = new a();
        paramView.checkBox = ((CheckBox)localView.findViewById(2131364587));
        paramView.name = ((TextView)localView.findViewById(2131368150));
        paramView.OK = ((TextView)localView.findViewById(2131368151));
        localView.setTag(paramView);
        localView.setOnClickListener(new aayj(this));
        paramView.position = paramInt;
        paramView.c = ((Groups)getItem(paramInt));
        int i = paramView.c.group_friend_count;
        paramView.OK.setText("" + i);
        paramView.name.setText(paramView.c.group_name);
        paramView.checkBox.setTag(paramView);
        if (!SelectMemberFromFriendGroup.this.a(paramView.c)) {
          break label254;
        }
        paramView.checkBox.setEnabled(false);
        paramView.checkBox.setChecked(false);
        label197:
        if (SelectMemberFromFriendGroup.a(SelectMemberFromFriendGroup.this).size() != 1) {
          break label288;
        }
        localView.setBackgroundResource(2130839689);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        a locala = (a)paramView.getTag();
        localView = paramView;
        paramView = locala;
        break;
        label254:
        paramView.checkBox.setEnabled(true);
        paramView.checkBox.setChecked(SelectMemberFromFriendGroup.this.vB.contains(paramView.c));
        break label197;
        label288:
        if (SelectMemberFromFriendGroup.a(SelectMemberFromFriendGroup.this).size() == 2)
        {
          if (paramInt == 0) {
            localView.setBackgroundResource(2130839701);
          } else {
            localView.setBackgroundResource(2130839689);
          }
        }
        else if (paramInt == 0) {
          localView.setBackgroundResource(2130839701);
        } else if (paramInt == SelectMemberFromFriendGroup.a(SelectMemberFromFriendGroup.this).size() - 1) {
          localView.setBackgroundResource(2130839689);
        } else {
          localView.setBackgroundResource(2130839695);
        }
      }
    }
    
    public class a
    {
      TextView OK;
      public Groups c;
      public CheckBox checkBox;
      TextView name;
      int position;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup
 * JD-Core Version:    0.7.0.1
 */