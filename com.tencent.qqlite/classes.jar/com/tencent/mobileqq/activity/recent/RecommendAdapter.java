package com.tencent.mobileqq.activity.recent;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ckn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendAdapter
  extends PagerAdapter
{
  private static final int jdField_a_of_type_Int = 50;
  public static final String a = "RecommendAdapter";
  private static final int b = 7;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ckn(this);
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private List jdField_a_of_type_JavaUtilList = null;
  
  public RecommendAdapter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public void a()
  {
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(OnRecentUserOpsListener paramOnRecentUserOpsListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    a(null);
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(50);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|updateItem");
    }
    return paramView != null;
  }
  
  public boolean a(View paramView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|updateItem uin: " + paramString);
    }
    if ((paramView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      localObject = paramView.findViewWithTag(paramString);
    } while (localObject == null);
    paramView = (ImageView)((View)localObject).findViewWithTag("head");
    Object localObject = (TextView)((View)localObject).findViewWithTag("name");
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, (byte)3, true);
    if (localBitmap == null) {}
    for (;;)
    {
      ((TextView)localObject).setText(ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
      return true;
      paramView.setImageBitmap(localBitmap);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int j = a() / 7;
    if (a() % 7 == 0) {}
    for (int i = 0;; i = 1) {
      return i + j;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|instantiateItem position: " + paramInt);
    }
    if ((a() == 0) && (QLog.isColorLevel())) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|instantiateItem data list is empty!");
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecommendAdapter
 * JD-Core Version:    0.7.0.1
 */