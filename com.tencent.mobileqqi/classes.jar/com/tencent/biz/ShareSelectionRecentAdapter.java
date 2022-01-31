package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ShareSelectionRecentAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 80;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private ImageWorker jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
  private final List jdField_a_of_type_JavaUtilList = a(paramList);
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private int b;
  
  public ShareSelectionRecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, List paramList)
  {
    this.b = paramInt;
    a(paramQQAppInterface);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(this.jdField_a_of_type_Float * 100.0F), (int)(this.jdField_a_of_type_Float * 100.0F));
    if (this.jdField_a_of_type_Float < 1.5D) {
      this.jdField_a_of_type_Int = 160;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      int i = localRecentUser.type;
      String str = localRecentUser.uin;
      switch (i)
      {
      case 1000: 
      case 1001: 
      case 1003: 
      case 1004: 
      case 1005: 
      case 1009: 
      case 1020: 
      case 1023: 
      case 1024: 
      case 4000: 
      case 5000: 
      case 7000: 
      default: 
        break;
      case 0: 
        if (!Utils.a(str)) {
          localArrayList.add(localRecentUser);
        }
        break;
      case 1: 
      case 3000: 
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)paramQQAppInterface.getManager(8));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(this.b, paramViewGroup, false);
    }
    Object localObject1 = (RecentUser)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localView.setTag(2131231416, Integer.valueOf(paramInt));
    TextView localTextView = (TextView)localView.findViewById(2131231395);
    ImageView localImageView = (ImageView)localView.findViewById(2131230940);
    if ((localTextView == null) || (localImageView == null)) {
      return localView;
    }
    localTextView.setMaxWidth(2147483647);
    localTextView.getLayoutParams().width = -1;
    String str = ((RecentUser)localObject1).uin;
    paramInt = ((RecentUser)localObject1).type;
    paramViewGroup = null;
    paramView = (QQServiceEntry.Tag)localImageView.getTag();
    Object localObject2 = paramView;
    if (paramView == null) {
      localObject2 = new QQServiceEntry.Tag();
    }
    localView.setTag(2131230985, null);
    localView.setTag(2131233145, Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      paramView = null;
    }
    for (;;)
    {
      if (paramView != null)
      {
        localObject1 = paramView;
        if (!"".equals(paramView)) {}
      }
      else
      {
        localObject1 = str;
      }
      localTextView.setText((CharSequence)localObject1);
      localImageView.setBackgroundDrawable(paramViewGroup);
      try
      {
        l = Long.valueOf(str).longValue();
        if (l <= 10000L) {
          localImageView.setImageDrawable(null);
        }
        ((QQServiceEntry.Tag)localObject2).jdField_a_of_type_JavaLangString = str;
        ((QQServiceEntry.Tag)localObject2).b = ((String)localObject1);
        ((QQServiceEntry.Tag)localObject2).jdField_a_of_type_Int = paramInt;
        localImageView.setTag(localObject2);
        localImageView.setClickable(false);
        localImageView.setFocusable(false);
        localImageView.setEnabled(false);
        localImageView.setLongClickable(false);
        localView.setBackgroundResource(2130837850);
        return localView;
        paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(str);
        if (paramView != null) {
          if (!TextUtils.isEmpty(paramView.remark)) {
            paramView = paramView.remark;
          }
        }
        for (;;)
        {
          if ((paramView == null) && (this.jdField_a_of_type_JavaUtilSet.add(str)))
          {
            paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            ((FriendListHandler)paramViewGroup.a(1)).a(str);
          }
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
          localView.setTag(str);
          localView.setTag(2131230985, new Object[] { Boolean.valueOf(false) });
          break;
          paramView = paramView.name;
          continue;
          paramView = ((RecentUser)localObject1).displayName;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str);
        if (paramView != null) {}
        for (localObject1 = paramView.troopname;; localObject1 = ((RecentUser)localObject1).displayName)
        {
          if (localObject1 != null)
          {
            paramView = (View)localObject1;
            paramViewGroup = localDrawable;
            if (!((String)localObject1).trim().equals("")) {
              break;
            }
          }
          paramView = str;
          paramViewGroup = localDrawable;
          break;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
        if (paramView == null) {}
        for (paramView = ((RecentUser)localObject1).displayName;; paramView = paramView.discussionName)
        {
          if ((paramView != null) && (paramView.length() != 0)) {
            break label609;
          }
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562504);
          paramViewGroup = ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(str, true);
          break;
        }
      }
      catch (NumberFormatException paramView)
      {
        label609:
        for (;;)
        {
          long l = 0L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.ShareSelectionRecentAdapter
 * JD-Core Version:    0.7.0.1
 */