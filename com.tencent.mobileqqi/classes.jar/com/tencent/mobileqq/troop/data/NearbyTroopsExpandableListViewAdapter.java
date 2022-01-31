package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import NearbyGroup.XiaoQuInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FavOpenTroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity.UIHandler;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import gzf;
import java.util.ArrayList;
import java.util.Iterator;

public class NearbyTroopsExpandableListViewAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  public static final int d = 30;
  public int a;
  public long a;
  public Context a;
  public QQAppInterface a;
  public NearbyTroopsActivity.UIHandler a;
  public NearbyOpenTroop a;
  public ArrayList a;
  public boolean a;
  public int b;
  public ArrayList b;
  public boolean b;
  public int c;
  public ArrayList c;
  public boolean c;
  public ArrayList d;
  public boolean d;
  public boolean e = false;
  
  public NearbyTroopsExpandableListViewAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, NearbyTroopsActivity.UIHandler paramUIHandler)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    a(4);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler = paramUIHandler;
    paramContext = (NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_b_of_type_Int = paramContext.f;
    this.jdField_c_of_type_Int = paramContext.x;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramQQAppInterface.a());
      return;
    }
    catch (NumberFormatException paramContext) {}
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_d_of_type_JavaUtilArrayList.size() == 0) {}
    GroupAreaWrapper localGroupAreaWrapper;
    do
    {
      return 0;
      if (paramInt == this.jdField_d_of_type_JavaUtilArrayList.size() + 1)
      {
        if (this.jdField_c_of_type_Boolean) {}
        for (paramInt = 1;; paramInt = 0) {
          return paramInt;
        }
      }
      localGroupAreaWrapper = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(paramInt - 1);
    } while (localGroupAreaWrapper == null);
    return localGroupAreaWrapper.a();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int j = 3;
    int i = j;
    int k;
    if (paramInt1 == 0)
    {
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      k = this.jdField_c_of_type_JavaUtilArrayList.size();
      if (paramInt2 >= paramInt1) {
        break label36;
      }
      i = 1;
    }
    label36:
    do
    {
      return i;
      i = j;
    } while (paramInt2 >= paramInt1 + k);
    return 2;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    b(paramInt1, paramInt2, paramString, paramBitmap);
  }
  
  public void a(GroupInfo paramGroupInfo)
  {
    if ((this.jdField_d_of_type_JavaUtilArrayList == null) || (this.jdField_d_of_type_JavaUtilArrayList.size() == 0)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        while (!((Iterator)localObject1).hasNext()) {
          localObject1 = this.jdField_d_of_type_JavaUtilArrayList.iterator();
        }
        localObject2 = (GroupAreaWrapper)((Iterator)localObject1).next();
      } while ((((GroupAreaWrapper)localObject2).d != 0) || (((GroupAreaWrapper)localObject2).jdField_a_of_type_NearbyGroupGroupArea == null));
      localObject2 = ((GroupAreaWrapper)localObject2).jdField_a_of_type_NearbyGroupGroupArea;
    } while (!((GroupArea)localObject2).strAreaName.equals(paramGroupInfo.strLocation));
    if ((((GroupArea)localObject2).vGroupInfo != null) && (((GroupArea)localObject2).vGroupInfo.size() != 0))
    {
      localObject1 = ((GroupArea)localObject2).vGroupInfo;
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((GroupInfo)((Iterator)localObject2).next()).lCode == paramGroupInfo.lCode) {
          return;
        }
      }
      ((ArrayList)localObject1).add(0, paramGroupInfo);
    }
    notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAbsListView.r() == paramAbsListView.a() - 1) && (!this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.sendEmptyMessage(1);
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList1;
    this.jdField_c_of_type_JavaUtilArrayList = paramArrayList2;
    this.jdField_d_of_type_JavaUtilArrayList = paramArrayList3;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.jdField_c_of_type_JavaUtilArrayList.size();
    switch (paramInt1)
    {
    default: 
      return paramInt2;
    case 2: 
      return paramInt2 - i;
    }
    return paramInt2 - i - j;
  }
  
  public void b()
  {
    b(1);
  }
  
  public void b(int paramInt)
  {
    paramInt -= 1;
    if (paramInt >= this.jdField_d_of_type_JavaUtilArrayList.size()) {}
    Object localObject1;
    GroupArea localGroupArea;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(paramInt);
      } while ((localObject1 == null) || (((GroupAreaWrapper)localObject1).d != 0) || (((GroupAreaWrapper)localObject1).jdField_a_of_type_NearbyGroupGroupArea == null));
      localGroupArea = ((GroupAreaWrapper)localObject1).jdField_a_of_type_NearbyGroupGroupArea;
      localObject2 = localGroupArea.vGroupInfo;
    } while ((localObject2 == null) || (localGroupArea == null));
    ((GroupAreaWrapper)localObject1).jdField_a_of_type_Boolean = true;
    long l1 = localGroupArea.dwGroupStartIdx;
    long l2 = ((ArrayList)localObject2).size();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.obtainMessage();
      ((Message)localObject1).what = 4;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("index", l1 + l2);
      ((Bundle)localObject2).putLong("count", 30L);
      ((Bundle)localObject2).putInt("lat", localGroupArea.iLat);
      ((Bundle)localObject2).putInt("lon", localGroupArea.iLon);
      ((Bundle)localObject2).putString("name", localGroupArea.strAreaName);
      ((Message)localObject1).setData((Bundle)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.sendMessage((Message)localObject1);
    }
    notifyDataSetChanged();
  }
  
  public void b(FacePreloadBaseAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    a(paramViewHolder, paramBitmap);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null) {
      localObject = ((FriendManager)localObject).d();
    }
    while ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int j = ((ArrayList)localObject).size();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      for (;;)
      {
        if ((i < j) && (i < 5))
        {
          localStringBuilder.append(((FavOpenTroopInfo)((ArrayList)localObject).get(j - 1 - i)).troopName + "，");
          i += 1;
          continue;
          localObject = null;
          break;
        }
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(new gzf(1, this.jdField_a_of_type_AndroidContentContext.getString(2131560291), 2130838358, j + this.jdField_a_of_type_AndroidContentContext.getString(2131560292), localStringBuilder.toString()));
    }
  }
  
  public void c(int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.jdField_c_of_type_JavaUtilArrayList.size();
    if (paramInt < i) {
      d(paramInt);
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt >= i + j) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
          localObject1 = (XiaoQuInfo)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt - i);
        } while (localObject1 == null);
        localObject1 = ((XiaoQuInfo)localObject1).strURL;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("from", "1");
        ((Intent)localObject2).putExtra("open_url", (String)localObject1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        TroopQQBrowserHelper.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        return;
        paramInt = paramInt - j - i;
      } while ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilArrayList.size()));
      localObject1 = (GroupInfo)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    } while ((((GroupInfo)localObject1).dwGroupFlagExt & 0x100000) == 0L);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyOpenTroop != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyOpenTroop.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyOpenTroop.a.cancel();
    }
    Object localObject2 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyOpenTroop = new NearbyOpenTroop(String.valueOf(((GroupInfo)localObject1).lCode), ((GroupInfo)localObject1).strName, (Activity)localObject2, (QQAppInterface)((BaseActivity)localObject2).getAppRuntime(), ((BaseActivity)localObject2).d());
    this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyOpenTroop.a((GroupInfo)localObject1, 1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "Clk_open_group", 45, 0, "" + ((GroupInfo)localObject1).lCode, "", "", "");
  }
  
  public void d()
  {
    notifyDataSetChanged();
  }
  
  public void d(int paramInt)
  {
    switch (((gzf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a())
    {
    default: 
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FavOpenTroopActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    a();
  }
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        return new Object();
      }
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = this.jdField_c_of_type_JavaUtilArrayList.size();
      int j = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (paramInt2 < paramInt1) {
        return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
      }
      if (paramInt2 < paramInt1 + i) {
        return this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2 - paramInt1);
      }
      if (paramInt2 < j + (paramInt1 + i)) {
        return this.jdField_b_of_type_JavaUtilArrayList.get(paramInt2 - paramInt1 - i);
      }
      return null;
    }
    if (paramInt1 > this.jdField_d_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    GroupAreaWrapper localGroupAreaWrapper = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(paramInt1 - 1);
    if (localGroupAreaWrapper == null) {
      return null;
    }
    return localGroupAreaWrapper.a();
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (this.jdField_b_of_type_Boolean))
    {
      paramView = NearbyTroops.e(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup = (NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext;
      paramInt1 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.getHeight() - paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getHeight();
      if (paramViewGroup.e.getVisibility() != 0) {
        break label495;
      }
      paramInt1 -= paramViewGroup.e.getHeight();
    }
    label403:
    label492:
    label495:
    for (;;)
    {
      NearbyTroops.a(paramView, paramInt1, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext);
      return paramView;
      int i;
      if (paramInt1 == 0)
      {
        i = a(paramInt1, paramInt2);
        if ((paramView != null) && ((paramView.getTag() instanceof NearbyTroops.CustomViewHolder)) && (!(paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder))) {
          break label492;
        }
        paramView = NearbyTroops.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      for (;;)
      {
        if (i == 1)
        {
          paramViewGroup = NearbyTroops.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
          NearbyTroops.a(paramViewGroup, (gzf)this.jdField_a_of_type_JavaUtilArrayList.get(b(i, paramInt2)));
          paramView = paramViewGroup;
        }
        Object localObject;
        for (;;)
        {
          if (paramView != null) {
            break label403;
          }
          return null;
          if (i == 2)
          {
            NearbyTroops.a(paramView, (XiaoQuInfo)this.jdField_c_of_type_JavaUtilArrayList.get(b(i, paramInt2)), this.jdField_a_of_type_AndroidContentContext);
            paramViewGroup = paramView;
            break;
          }
          paramViewGroup = paramView;
          if (i != 3) {
            break;
          }
          NearbyTroops.a(paramView, (GroupInfo)this.jdField_b_of_type_JavaUtilArrayList.get(b(i, paramInt2)), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, true, this.jdField_a_of_type_Long);
          a((NearbyTroops.CustomViewHolder)paramView.getTag(), null);
          paramViewGroup = paramView;
          break;
          if (paramInt1 == this.jdField_d_of_type_JavaUtilArrayList.size() + 1)
          {
            if (paramView != null)
            {
              localObject = paramView;
              if ((paramView.getTag() instanceof NearbyTroops.MoreBtnViewHolder)) {}
            }
            else
            {
              localObject = NearbyTroops.f(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
            }
            NearbyTroops.a((View)localObject);
            paramView = (View)localObject;
          }
          else
          {
            localObject = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(paramInt1 - 1);
            if (localObject != null) {
              paramView = ((GroupAreaWrapper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, paramInt1, paramInt2, paramView, paramViewGroup);
            } else {
              paramView = null;
            }
          }
        }
        paramViewGroup = paramView.getTag();
        if ((paramViewGroup instanceof NearbyTroops.CustomViewHolder))
        {
          localObject = (NearbyTroops.CustomViewHolder)paramViewGroup;
          ((NearbyTroops.CustomViewHolder)localObject).jdField_c_of_type_Int = paramInt1;
          ((NearbyTroops.CustomViewHolder)localObject).jdField_a_of_type_Int = paramInt2;
        }
        if ((paramViewGroup instanceof NearbyTroops.MoreBtnViewHolder))
        {
          localObject = (NearbyTroops.MoreBtnViewHolder)paramViewGroup;
          ((NearbyTroops.MoreBtnViewHolder)localObject).jdField_b_of_type_Int = paramInt1;
          ((NearbyTroops.MoreBtnViewHolder)localObject).jdField_a_of_type_Int = paramInt2;
        }
        if ((!(paramViewGroup instanceof NearbyTroops.MoreBtnViewHolder)) || (!((NearbyTroops.MoreBtnViewHolder)paramViewGroup).jdField_a_of_type_Boolean)) {
          paramView.setOnClickListener(this);
        }
        return paramView;
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramInt == 0)) {
      return 1;
    }
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_c_of_type_JavaUtilArrayList.size() + this.jdField_b_of_type_JavaUtilArrayList.size();
    }
    return a(paramInt);
  }
  
  public Object getGroup(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_b_of_type_Boolean) {
        localObject = new Object();
      }
    }
    while (paramInt > this.jdField_d_of_type_JavaUtilArrayList.size()) {
      return localObject;
    }
    return this.jdField_d_of_type_JavaUtilArrayList.get(paramInt - 1);
  }
  
  public int getGroupCount()
  {
    if (this.jdField_b_of_type_Boolean) {
      return 1;
    }
    return this.jdField_d_of_type_JavaUtilArrayList.size() + 1 + 1;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (Object localObject = (NearbyTroops.GroupViewHolder)paramView.getTag();; localObject = null)
    {
      if ((paramInt == 0) && (this.jdField_b_of_type_Boolean)) {
        if ((localObject == null) || (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int != 1)) {
          paramView = NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
        }
      }
      label109:
      do
      {
        do
        {
          do
          {
            return paramView;
            if (paramInt != 0) {
              break label109;
            }
            if (!this.e) {
              break;
            }
          } while ((localObject != null) && (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int == 2));
          return NearbyTroops.c(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
        } while ((localObject != null) && (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int == 1));
        return NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
        if (paramInt != this.jdField_d_of_type_JavaUtilArrayList.size() + 1) {
          break;
        }
      } while ((localObject != null) && (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int == 1));
      return NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      localObject = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(paramInt - 1);
      if (localObject == null) {
        return null;
      }
      return ((GroupAreaWrapper)localObject).a(this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, paramView, paramViewGroup);
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    int i;
    if ((paramView instanceof NearbyTroops.MoreBtnViewHolder))
    {
      paramView = (NearbyTroops.MoreBtnViewHolder)paramView;
      i = paramView.jdField_b_of_type_Int;
      if (i != 0) {}
    }
    int j;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramView.jdField_a_of_type_Boolean);
        b(i);
        return;
      } while (!(paramView instanceof NearbyTroops.CustomViewHolder));
      paramView = (NearbyTroops.CustomViewHolder)paramView;
      i = paramView.jdField_c_of_type_Int;
      j = paramView.jdField_a_of_type_Int;
      if (i == 0)
      {
        c(j);
        return;
      }
      paramView = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(i - 1);
    } while (paramView == null);
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, j, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter
 * JD-Core Version:    0.7.0.1
 */