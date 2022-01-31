package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import diz;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileRecentImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  static final int jdField_a_of_type_Int = 6;
  private static final int jdField_d_of_type_Int = 4;
  private float jdField_a_of_type_Float = 0.0F;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private int jdField_b_of_type_Int = 50;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_c_of_type_Int = 0;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  
  public QfileRecentImageExpandableListAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener3;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Int = ((int)(6.0F * this.jdField_a_of_type_Float));
    this.jdField_b_of_type_Int = a(4);
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt + 1) * 6)) / paramInt;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    diz localdiz = (diz)paramView.getTag();
    int i = 0;
    for (;;)
    {
      View localView;
      if (i < 4)
      {
        localView = b(paramInt1, paramInt2 * 4 + i, paramBoolean, localdiz.a[i], paramViewGroup);
        if (localView != null) {}
      }
      else
      {
        return paramView;
      }
      localdiz.a[i] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      ((LinearLayout.LayoutParams)localObject).width = this.jdField_b_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).height = this.jdField_b_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).leftMargin = this.jdField_c_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_c_of_type_Int;
      paramView.addView(localView);
      i += 1;
    }
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new diz(null));
    return paramViewGroup;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    View localView;
    for (FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramViewGroup;; localView = null)
    {
      if (localFileManagerEntity == null) {
        return null;
      }
      if (paramView == null) {
        paramViewGroup = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903425, null);
          paramViewGroup = paramView;
          paramView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          localObject = new QfileRecentImageExpandableListAdapter.ImageHolder(this);
          paramViewGroup = paramView;
          ((QfileRecentImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296283));
          paramViewGroup = paramView;
          ((QfileRecentImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298024));
          paramViewGroup = paramView;
          ((QfileRecentImageExpandableListAdapter.ImageHolder)localObject).b = ((ImageView)paramView.findViewById(2131296798));
          paramViewGroup = paramView;
          paramView.setTag(localObject);
          paramViewGroup = (ViewGroup)localObject;
          try
          {
            paramViewGroup.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
            paramViewGroup.jdField_a_of_type_Int = paramInt2;
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130839067);
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
            paramInt1 = paramInt2 / 4;
            localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362015), new Object[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf((paramInt2 & 0x3) + 1) });
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
            if ((localFileManagerEntity.strFilePath == null) || (localFileManagerEntity.strFilePath.length() <= 0) || (!FileUtil.b(localFileManagerEntity.strFilePath))) {
              continue;
            }
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileManagerEntity.strFilePath);
            if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) || (!FMDataCache.a(localFileManagerEntity))) {
              continue;
            }
            paramViewGroup.b.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131427353));
            paramView.setOnLongClickListener(null);
            return paramView;
          }
          catch (Exception localException)
          {
            paramViewGroup = paramView;
          }
        }
        catch (Exception paramView)
        {
          Object localObject;
          localView = paramView;
          continue;
        }
        localException.printStackTrace();
        QLog.e("#######", 1, localException.toString());
        return paramViewGroup;
        paramViewGroup = paramView;
        localObject = (QfileRecentImageExpandableListAdapter.ImageHolder)paramView.getTag();
        paramViewGroup = (ViewGroup)localObject;
        continue;
        if ((localException.strThumbPath != null) && (localException.strThumbPath.length() > 0))
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localException.strThumbPath);
          continue;
          paramViewGroup.b.setVisibility(4);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          return paramView;
        }
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i == paramInt1)
      {
        localObject = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str);
        if (paramInt2 >= ((List)localObject).size()) {
          return null;
        }
        return ((List)localObject).get(paramInt2);
      }
      i += 1;
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    int k = 0;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i != paramInt) {
          break label82;
        }
        paramInt = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size();
        if (paramInt < 4) {
          j = 1;
        }
      }
      else
      {
        return j;
      }
      return paramInt / 4 + 1;
      label82:
      i += 1;
    }
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupCount()
  {
    return this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */