package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import dvw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class QfileTabBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
  QfileBaseTabView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = null;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new dvw(this);
  public TabBarView a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public int b;
  HashMap b;
  HashMap c = new LinkedHashMap();
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903435, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298067));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298068));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
  }
  
  public QfileBaseTabView a(int paramInt)
  {
    Object localObject = (QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return localObject;
    }
    switch (((Integer)this.c.get(Integer.valueOf(paramInt))).intValue())
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
      return localObject;
      localObject = new QfileRecentAllFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileRecentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileRecentPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileRecentMediaFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileRecentAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileAppTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFilePicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileDocTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileLocalFileOtherTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "document");
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "picture");
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "video");
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "music");
      ((QfileBaseTabView)localObject).b();
      continue;
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "other");
      ((QfileBaseTabView)localObject).b();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.i();
    }
  }
  
  public void a(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = a(paramInt);
    if (localQfileBaseTabView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == localQfileBaseTabView);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
      {
        if (a()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.p();
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.m();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.j();
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.n();
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.jdField_a_of_type_Int, paramString);
    this.c.put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString, Class paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.jdField_a_of_type_Int, paramString);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), paramClass);
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.c(paramArrayList);
  }
  
  boolean a()
  {
    return true;
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0);
      i += 1;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      if (localQfileBaseTabView != null) {
        localQfileBaseTabView.c();
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelected(false);
    this.c.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.d(paramArrayList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
  }
  
  public void c(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a(paramArrayList);
  }
  
  public void d(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.f(paramArrayList);
  }
  
  public void e(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.g(paramArrayList);
  }
  
  public void f(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.e(paramArrayList);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void setSelectedTab(int paramInt)
  {
    Iterator localIterator = this.c.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (((Integer)this.c.get(Integer.valueOf(j))).intValue() != paramInt)
      {
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i, true);
      }
    }
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j())
    {
      i = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView instanceof QfileBaseCloudFileTabView)) {
        i = paramInt + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */