package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bnk;
import bnl;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShareSelectionFriendListAdapter
  extends BaseExpandableListAdapter
{
  protected static Bitmap a;
  protected float a;
  protected Context a;
  public QQAppInterface a;
  protected ImageWorker a;
  protected HashMap a;
  protected List a;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
  }
  
  public ShareSelectionFriendListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, List paramList)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(this.jdField_a_of_type_Float * 100.0F), (int)(this.jdField_a_of_type_Float * 100.0F));
    a(paramList, false);
  }
  
  public List a(int paramInt)
  {
    paramInt = ((Groups)getGroup(paramInt)).group_id;
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      Groups localGroups = (Groups)paramList.next();
      ArrayList localArrayList = ((ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(String.valueOf(localGroups.group_id));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localGroups.group_id), localArrayList);
    }
    if (paramBoolean) {
      super.notifyDataSetChanged();
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return a(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903228, paramViewGroup, false);
      paramViewGroup = new ShareSelectionFriendListAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231395));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Friends localFriends = (Friends)getChild(paramInt1, paramInt2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(localFriends));
      bnk localbnk = new bnk(this);
      bnl localbnl = new bnl(this, localFriends);
      this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a(jdField_a_of_type_AndroidGraphicsBitmap, localFriends.uin + false + "round", paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, localbnk, localbnl, true);
      return paramView;
      paramViewGroup = (ShareSelectionFriendListAdapter.ViewTag)paramView.getTag();
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (a(paramInt) == null) {
      return 0;
    }
    return a(paramInt).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903141, paramViewGroup, false);
      paramViewGroup = new ShareSelectionFriendListAdapter.GroupViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231389));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131231390));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      LocaleString.a(((Groups)getGroup(paramInt)).group_name, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
      paramViewGroup.b.setText(String.valueOf(getChildrenCount(paramInt)));
      return paramView;
      paramViewGroup = (ShareSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_JavaUtilList == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.ShareSelectionFriendListAdapter
 * JD-Core Version:    0.7.0.1
 */