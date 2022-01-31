package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import NearbyGroup.XiaoQuInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.WebBaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import emb;
import java.util.ArrayList;
import java.util.Iterator;

public class NearbyTroopsExpandableListViewAdapter
  extends WebBaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  public static final int h = 30;
  public long a;
  public Context a;
  protected NearbyTroopsBaseView.INearbyTroopContext a;
  public NearbyTroopsView.UIHandler a;
  public NearbyTroopsView a;
  public NearbyOpenTroop a;
  public ArrayList a;
  public boolean a;
  public ArrayList b;
  public boolean b;
  public ArrayList c;
  public boolean c;
  public int d;
  public ArrayList d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public int g = 0;
  
  public NearbyTroopsExpandableListViewAdapter(Context paramContext, ExpandableListView paramExpandableListView, NearbyTroopsView.UIHandler paramUIHandler, NearbyTroopsView paramNearbyTroopsView, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    super(paramContext, paramExpandableListView, 4);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext = paramINearbyTroopContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView = paramNearbyTroopsView;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = paramUIHandler;
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_f_of_type_Int;
    this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
    this.g = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.w;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
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
  
  public void a(int paramInt)
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
      } while ((localObject1 == null) || (((GroupAreaWrapper)localObject1).jdField_d_of_type_Int != 0) || (((GroupAreaWrapper)localObject1).jdField_a_of_type_NearbyGroupGroupArea == null));
      localGroupArea = ((GroupAreaWrapper)localObject1).jdField_a_of_type_NearbyGroupGroupArea;
      localObject2 = localGroupArea.vGroupInfo;
    } while ((localObject2 == null) || (localGroupArea == null));
    ((GroupAreaWrapper)localObject1).jdField_a_of_type_Boolean = true;
    long l1 = localGroupArea.dwGroupStartIdx;
    long l2 = ((ArrayList)localObject2).size();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.obtainMessage();
      ((Message)localObject1).what = 4;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("index", l1 + l2);
      ((Bundle)localObject2).putLong("count", 30L);
      ((Bundle)localObject2).putInt("lat", localGroupArea.iLat);
      ((Bundle)localObject2).putInt("lon", localGroupArea.iLon);
      ((Bundle)localObject2).putString("name", localGroupArea.strAreaName);
      ((Message)localObject1).setData((Bundle)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendMessage((Message)localObject1);
    }
    notifyDataSetChanged();
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
      } while ((((GroupAreaWrapper)localObject2).jdField_d_of_type_Int != 0) || (((GroupAreaWrapper)localObject2).jdField_a_of_type_NearbyGroupGroupArea == null));
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
  
  public void a(WebFacePreloadBaseAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    b(paramViewHolder, paramBitmap);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((paramAbsListView.r() == paramAbsListView.b() - 1) && (!this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(1);
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
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.jdField_c_of_type_JavaUtilArrayList.size();
    if (paramInt < i) {
      c(paramInt);
    }
    do
    {
      do
      {
        return;
        if (paramInt >= i + j) {
          break;
        }
        localObject = (XiaoQuInfo)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt - i);
      } while (localObject == null);
      Object localObject = ((XiaoQuInfo)localObject).strURL;
      Intent localIntent = new Intent();
      localIntent.putExtra("from", "1");
      localIntent.putExtra("open_url", (String)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      TroopQQBrowserHelper.a(this.jdField_a_of_type_AndroidContentContext, localIntent, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
      return;
      paramInt = paramInt - j - i;
    } while ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilArrayList.size()));
  }
  
  protected void b(WebFacePreloadBaseAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = a(paramViewHolder.jdField_a_of_type_JavaLangString, true);
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    switch (((emb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a())
    {
    default: 
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FavOpenTroopActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void f()
  {
    a(1);
  }
  
  public void g()
  {
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
      paramView = NearbyTroops.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup = (NearbyTroopsActivity)this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getHeight();
      paramInt1 = paramInt2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_f_of_type_AndroidViewView.getVisibility() == 0) {
        paramInt1 = paramInt2 - this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_f_of_type_AndroidViewView.getHeight();
      }
      NearbyTroops.a(paramView, paramInt1, this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidContentContext);
      return paramView;
    }
    int i;
    if (paramInt1 == 0)
    {
      i = a(paramInt1, paramInt2);
      if ((paramView != null) && ((paramView.getTag() instanceof NearbyTroops.CustomViewHolder)) && (!(paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder))) {
        break label505;
      }
      paramView = NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramBoolean);
    }
    label416:
    label505:
    for (;;)
    {
      if (i == 1)
      {
        paramViewGroup = NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramBoolean);
        NearbyTroops.a(paramViewGroup, (emb)this.jdField_a_of_type_JavaUtilArrayList.get(b(i, paramInt2)));
        paramView = paramViewGroup;
      }
      Object localObject;
      for (;;)
      {
        if (paramView != null) {
          break label416;
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
        NearbyTroops.a(paramView, (GroupInfo)this.jdField_b_of_type_JavaUtilArrayList.get(b(i, paramInt2)), this.jdField_a_of_type_AndroidContentContext, true, this.jdField_a_of_type_Long);
        b((NearbyTroops.CustomViewHolder)paramView.getTag(), null);
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
            localObject = NearbyTroops.e(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
          }
          NearbyTroops.a((View)localObject);
          paramView = (View)localObject;
        }
        else
        {
          localObject = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(paramInt1 - 1);
          if (localObject != null) {
            paramView = ((GroupAreaWrapper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext, this.jdField_a_of_type_AndroidContentContext, this, paramInt1, paramInt2, paramView, paramViewGroup);
          } else {
            paramView = null;
          }
        }
      }
      paramViewGroup = paramView.getTag();
      if ((paramViewGroup instanceof NearbyTroops.CustomViewHolder))
      {
        localObject = (NearbyTroops.CustomViewHolder)paramViewGroup;
        ((NearbyTroops.CustomViewHolder)localObject).c = paramInt1;
        ((NearbyTroops.CustomViewHolder)localObject).b = paramInt2;
      }
      if ((paramViewGroup instanceof NearbyTroops.MoreBtnViewHolder))
      {
        localObject = (NearbyTroops.MoreBtnViewHolder)paramViewGroup;
        ((NearbyTroops.MoreBtnViewHolder)localObject).b = paramInt1;
        ((NearbyTroops.MoreBtnViewHolder)localObject).jdField_a_of_type_Int = paramInt2;
      }
      if ((!(paramViewGroup instanceof NearbyTroops.MoreBtnViewHolder)) || (!((NearbyTroops.MoreBtnViewHolder)paramViewGroup).jdField_a_of_type_Boolean)) {
        paramView.setOnClickListener(this);
      }
      return paramView;
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
            if (!this.jdField_e_of_type_Boolean) {
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
  
  public void h()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = null;
    e();
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
      i = paramView.b;
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
        a(i);
        return;
      } while (!(paramView instanceof NearbyTroops.CustomViewHolder));
      paramView = (NearbyTroops.CustomViewHolder)paramView;
      i = paramView.c;
      j = paramView.b;
      if (i == 0)
      {
        b(j);
        return;
      }
      paramView = (GroupAreaWrapper)this.jdField_d_of_type_JavaUtilArrayList.get(i - 1);
    } while (paramView == null);
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), this.jdField_a_of_type_AndroidContentContext, j, this.g, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter
 * JD-Core Version:    0.7.0.1
 */