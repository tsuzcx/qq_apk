package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaIconDownloader;
import com.tencent.mobileqq.activity.LebaIconDownloader.DownloadListenerAdapter;
import com.tencent.mobileqq.activity.LebaIconDownloader.IDownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cqk;
import cql;
import java.util.List;

public class LebaListViewAdapter
  extends BaseAdapter
  implements LebaIconDownloader.IDownloadListener
{
  public static final String a = "empty_normal";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final String b = "empty_header_footer";
  public static final int d = -1;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  private float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  String c = "";
  private int h;
  private int i;
  private final int j = 1;
  private final int k = 1;
  private final int l = 10;
  private final int m = -6;
  
  public LebaListViewAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.h = paramInt1;
    this.i = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2, LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return;
        if (paramInt2 != 1) {
          break;
        }
      } while ((paramCornerListItemHolder == null) || (paramCornerListItemHolder.f == null));
      paramCornerListItemHolder.f.post(new cqk(this, paramCornerListItemHolder, paramDrawable, paramInt1));
      return;
    } while ((paramCornerListItemHolder == null) || (paramCornerListItemHolder.d == null));
    paramCornerListItemHolder.d.post(new cql(this, paramCornerListItemHolder, paramDrawable, paramInt1));
  }
  
  private void a(View paramView1, View paramView2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
      localLayoutParams.addRule(6, paramView2.getId());
      localLayoutParams.addRule(7, paramView2.getId());
      localLayoutParams.setMargins(0, 10, -6, 0);
      paramView1.setLayoutParams(localLayoutParams);
      paramView1.setVisibility(0);
      return;
    }
    paramView1.setVisibility(8);
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, View paramView, boolean paramBoolean)
  {
    paramImageView.setImageDrawable(LebaIconDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDrawable));
    paramImageView.setVisibility(0);
    a(paramView, paramImageView, paramBoolean);
  }
  
  private void a(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, LebaViewItem paramLebaViewItem)
  {
    if ((paramCornerListItemHolder == null) || (paramLebaViewItem == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName))) {
      return;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId > 0L)
    {
      b(paramCornerListItemHolder, paramLebaViewItem);
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
      paramCornerListItemHolder.f.setVisibility(8);
      paramCornerListItemHolder.g.setVisibility(8);
      return;
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Drawable localDrawable = LebaIconDownloader.b(this.jdField_a_of_type_AndroidContentContext, paramString);
    if (localDrawable != null)
    {
      if (paramInt2 == 1)
      {
        paramString = paramCornerListItemHolder.f;
        paramCornerListItemHolder = paramCornerListItemHolder.g;
        if (paramInt1 == 1) {}
        for (;;)
        {
          a(paramString, localDrawable, paramCornerListItemHolder, bool1);
          return;
          bool1 = false;
        }
      }
      paramString = paramCornerListItemHolder.d;
      paramCornerListItemHolder = paramCornerListItemHolder.g;
      if (paramInt1 == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        b(paramString, localDrawable, paramCornerListItemHolder, bool1);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838055);
      if (paramInt2 != 1) {
        break label225;
      }
      ImageView localImageView1 = paramCornerListItemHolder.f;
      ImageView localImageView2 = paramCornerListItemHolder.g;
      if (paramInt1 != 1) {
        break label219;
      }
      bool1 = true;
      label141:
      a(localImageView1, localDrawable, localImageView2, bool1);
    }
    for (;;)
    {
      LebaIconDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString, new LebaIconDownloader.DownloadListenerAdapter(this.jdField_a_of_type_AndroidContentContext, this, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramCornerListItemHolder }));
      return;
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839062);
      break;
      label219:
      bool1 = false;
      break label141;
      label225:
      b(paramCornerListItemHolder.d, localDrawable, paramCornerListItemHolder.g, false);
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
  
  private boolean a(TextView paramTextView, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTextView != null)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          paramTextView.setText(paramString);
          paramTextView.setVisibility(0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(ImageView paramImageView, Drawable paramDrawable, View paramView, boolean paramBoolean)
  {
    paramImageView.setImageDrawable(paramDrawable);
    paramImageView.setVisibility(0);
    a(paramView, paramImageView, paramBoolean);
  }
  
  private void b(LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, LebaViewItem paramLebaViewItem)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "");
    int i2;
    int i1;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      i2 = localAppInfo.type.get();
      paramLebaViewItem = localAppInfo.icon_url.get();
      i1 = localAppInfo.icon_flag.get();
    }
    for (int n = localAppInfo.icon_type.get();; n = 0)
    {
      switch (i2)
      {
      default: 
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCornerListItemHolder.c.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.e.setVisibility(8);
        paramCornerListItemHolder.f.setVisibility(8);
        paramCornerListItemHolder.g.setVisibility(8);
        return;
      case 0: 
        paramCornerListItemHolder.c.setVisibility(0);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.e.setVisibility(8);
        paramCornerListItemHolder.f.setVisibility(8);
        paramCornerListItemHolder.g.setVisibility(8);
        return;
      case 3: 
        paramCornerListItemHolder.c.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.f.setVisibility(8);
        paramCornerListItemHolder.g.setVisibility(8);
        if (!TextUtils.isEmpty(paramLebaViewItem)) {
          a(paramCornerListItemHolder, paramLebaViewItem, i1, n);
        }
        paramCornerListItemHolder.e.setVisibility(8);
        return;
      case 1: 
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        a(paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView, "NEW");
        paramCornerListItemHolder.c.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.e.setVisibility(8);
        paramCornerListItemHolder.f.setVisibility(8);
        paramCornerListItemHolder.g.setVisibility(8);
        return;
      case 2: 
        paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        a(paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView, localAppInfo.num.get());
        paramCornerListItemHolder.c.setVisibility(8);
        paramCornerListItemHolder.d.setVisibility(8);
        paramCornerListItemHolder.e.setVisibility(8);
        paramCornerListItemHolder.f.setVisibility(8);
        paramCornerListItemHolder.g.setVisibility(8);
        return;
      }
      paramLebaViewItem = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
      paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      a(paramCornerListItemHolder.jdField_b_of_type_AndroidWidgetTextView, paramLebaViewItem.a(localAppInfo));
      paramCornerListItemHolder.c.setVisibility(8);
      paramCornerListItemHolder.d.setVisibility(8);
      paramCornerListItemHolder.e.setVisibility(8);
      paramCornerListItemHolder.f.setVisibility(8);
      paramCornerListItemHolder.g.setVisibility(8);
      return;
      paramLebaViewItem = null;
      i2 = -1;
      i1 = 0;
    }
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if ((paramInt != 2) || (paramDrawable == null) || (paramVarArgs == null) || (paramVarArgs.length < 3)) {}
    while ((paramVarArgs[0] == null) || (paramVarArgs[1] == null) || (paramVarArgs[2] == null)) {
      return;
    }
    a(paramDrawable, ((Integer)paramVarArgs[0]).intValue(), ((Integer)paramVarArgs[1]).intValue(), (LebaListViewAdapter.CornerListItemHolder)paramVarArgs[2]);
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
    int n = getItemViewType(paramInt);
    if (n == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.h, null);
        paramViewGroup = new LebaListViewAdapter.CornerListItemHolder(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131296999));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297001));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297000));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131297004));
        paramViewGroup.e = ((ImageView)paramView.findViewById(2131297007));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296762));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131297003));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297002));
        paramViewGroup.f = ((ImageView)paramView.findViewById(2131297005));
        paramViewGroup.g = ((ImageView)paramView.findViewById(2131297006));
        paramView.setTag(paramViewGroup);
        label203:
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        if (localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label335;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label238:
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
        switch (localLebaViewItem.jdField_a_of_type_Int)
        {
        default: 
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837942);
          label290:
          a(paramViewGroup, localLebaViewItem);
          paramViewGroup = paramView;
        }
      }
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
      paramViewGroup = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
      break label203;
      label335:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838741);
      break label238;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837942);
      break label290;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837945);
      break label290;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837944);
      break label290;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837945);
      break label290;
      if (n == 1)
      {
        View localView = paramView;
        if (paramView == null) {
          localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.i, null);
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
      else if (n == 2)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903174, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListViewAdapter
 * JD-Core Version:    0.7.0.1
 */