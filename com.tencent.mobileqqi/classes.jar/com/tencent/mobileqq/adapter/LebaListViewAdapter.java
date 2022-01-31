package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import fcz;
import java.util.List;

public class LebaListViewAdapter
  extends BaseAdapter
{
  public static final int a = -1;
  public static final String a = "empty_normal";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 0;
  public static final String b = "empty_header_footer";
  public static final int c = 1;
  public static final int d = 2;
  private float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new fcz(this);
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  private List jdField_a_of_type_JavaUtilList;
  public String c = "";
  private int e;
  private int f;
  
  public LebaListViewAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = paramInt1;
    this.f = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, LebaViewItem paramLebaViewItem)
  {
    if ((paramCornerListItemHolder == null) || (paramLebaViewItem == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName))) {
      return;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("qzone_feedlist"))
    {
      b(paramCornerListItemHolder, paramLebaViewItem);
      return;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId > 0L)
    {
      c(paramCornerListItemHolder, paramLebaViewItem);
      return;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.isNew == 0) {
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, "updateNormal.newflag=" + paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.isNew);
      }
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramCornerListItemHolder.c.setVisibility(8);
      paramCornerListItemHolder.d.setVisibility(8);
      paramCornerListItemHolder.e.setVisibility(8);
      return;
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private boolean a(TextView paramTextView, long paramLong)
  {
    if (paramTextView != null)
    {
      if (paramLong <= 0L) {
        paramTextView.setVisibility(8);
      }
    }
    else {
      return false;
    }
    if (paramLong > 99L)
    {
      paramTextView.setText("99+");
      paramTextView.setVisibility(0);
      return true;
    }
    paramTextView.setText(paramLong + "");
    paramTextView.setVisibility(0);
    return true;
  }
  
  private void b(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, LebaViewItem paramLebaViewItem)
  {
    paramLebaViewItem = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
    if (paramLebaViewItem != null) {}
    for (int i = paramLebaViewItem.a(QZoneManager.FeedType.mySpacefeed); a(paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView, i); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, "updateQZoneFlag.num=" + i);
      }
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramCornerListItemHolder.c.setVisibility(8);
      paramCornerListItemHolder.d.setVisibility(8);
      paramCornerListItemHolder.e.setVisibility(8);
      return;
    }
    if (paramLebaViewItem != null) {}
    for (i = paramLebaViewItem.a(QZoneManager.FeedType.friendSpace); (i > 0) && (paramLebaViewItem.a().length() > 3); i = 0)
    {
      paramCornerListItemHolder.d.setVisibility(0);
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramCornerListItemHolder.c.setVisibility(8);
      this.c = paramLebaViewItem.a();
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, "updateQZoneFlag.latestfriend=" + this.c);
      }
      paramLebaViewItem = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramLebaViewItem.what = 1;
      paramLebaViewItem.obj = paramCornerListItemHolder.d;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramLebaViewItem, 500L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaListViewAdapter", 2, "updateQZoneFlag.noflag");
    }
    paramCornerListItemHolder.e.setVisibility(8);
    paramCornerListItemHolder.d.setVisibility(8);
    paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramCornerListItemHolder.c.setVisibility(8);
  }
  
  private void c(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, LebaViewItem paramLebaViewItem)
  {
    URLDrawable localURLDrawable = null;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "");
    int i;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      i = localAppInfo.type.get();
    }
    for (paramLebaViewItem = localAppInfo.icon_url.get();; paramLebaViewItem = localException)
    {
      switch (i)
      {
      default: 
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCornerListItemHolder.c.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.e.setVisibility(8);
        return;
      case 0: 
        paramCornerListItemHolder.c.setVisibility(0);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.e.setVisibility(8);
        return;
      case 3: 
        paramCornerListItemHolder.c.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        if (!TextUtils.isEmpty(paramLebaViewItem)) {}
        try
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839213);
          }
          localURLDrawable = URLDrawable.getDrawable(paramLebaViewItem, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
          if (localURLDrawable != null)
          {
            i = (int)(35.0F * this.jdField_a_of_type_Float);
            localURLDrawable.setBounds(0, 0, i, i);
            paramCornerListItemHolder.d.setImageDrawable(localURLDrawable);
            paramCornerListItemHolder.d.setVisibility(0);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("LebaListViewAdapter", 2, "red icon load error, iconUrl=" + paramLebaViewItem);
            }
            paramLebaViewItem = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839213);
            paramCornerListItemHolder.d.setImageDrawable(paramLebaViewItem);
            paramCornerListItemHolder.d.setVisibility(0);
            localException.printStackTrace();
          }
        }
        paramCornerListItemHolder.e.setVisibility(8);
        return;
      case 1: 
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramCornerListItemHolder.c.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.e.setVisibility(8);
        return;
      }
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      a(paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView, localAppInfo.num.get());
      paramCornerListItemHolder.c.setVisibility(8);
      paramCornerListItemHolder.d.setVisibility(8);
      paramCornerListItemHolder.e.setVisibility(8);
      return;
      i = -1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(LebaViewItem paramLebaViewItem)
  {
    return !TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_JavaLangString);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return null;
    }
    return (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    if (localLebaViewItem.jdField_a_of_type_JavaLangString.equals("empty_header_footer")) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItem(paramInt) == null) {
      return paramView;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    if (paramInt == 0) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903201, null);
    }
    for (;;)
    {
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      return paramViewGroup;
      int i = getItemViewType(paramInt);
      if (i == 0)
      {
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.e, null);
          paramViewGroup = new LebaListViewAdapter.CornerListItemHolder(this);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131231554));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231556));
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231555));
          paramViewGroup.d = ((ImageView)paramView.findViewById(2131231559));
          paramViewGroup.e = ((ImageView)paramView.findViewById(2131231560));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231295));
          paramViewGroup.c = ((ImageView)paramView.findViewById(2131231558));
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231557));
          paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131231561);
          paramView.setTag(paramViewGroup);
          label227:
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
          if (localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            break label323;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          label262:
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
          switch (localLebaViewItem.jdField_a_of_type_Int)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramViewGroup, localLebaViewItem);
          paramViewGroup = paramView;
          break;
          paramViewGroup = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
          break label227;
          label323:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838958);
          break label262;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      if (i == 1)
      {
        View localView = paramView;
        if (paramView == null) {
          localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.f, null);
        }
        paramViewGroup = localView;
        if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)
        {
          paramViewGroup = localView;
          if (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName))
          {
            localView.setContentDescription(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
            paramViewGroup = localView;
          }
        }
      }
      else if (i == 2)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903201, null);
        }
      }
      else
      {
        paramViewGroup = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!a((LebaViewItem)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListViewAdapter
 * JD-Core Version:    0.7.0.1
 */