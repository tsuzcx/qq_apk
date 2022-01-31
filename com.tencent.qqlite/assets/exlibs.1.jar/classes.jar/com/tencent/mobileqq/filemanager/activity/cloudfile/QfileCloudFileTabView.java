package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dkc;
import dkd;
import dkf;
import dkg;
import dkh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  QfileCloudFileTabView.IWeiYunImageEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = null;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = null;
  public long b;
  public String b;
  public boolean d;
  final int f = 15;
  public int g;
  private boolean g;
  private boolean h = false;
  
  public QfileCloudFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_g_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      l();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent == null) {
      k();
    }
    a(false);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = new dkc(this);
    }
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("document") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().v();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().A();
      continue;
      if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().w();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().B();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("video") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().x();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().C();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("music") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().y();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().D();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("other") == true) {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().z();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().E();
        }
      }
    }
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new QfileWeiYunImageExpandableListAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    setEditbarButton(false, true, false, true, true);
    return new QfileCloudFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    a(new dkg(this));
  }
  
  protected void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWeiYunFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramWeiYunFileInfo);
    }
    a(new dkh(this, paramWeiYunFileInfo));
  }
  
  protected void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, 0, 15, MessageCache.a());
  }
  
  public boolean a()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramWeiYunFileInfo);
    String str = QfileTimeUtils.a(paramWeiYunFileInfo.jdField_b_of_type_Long);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramWeiYunFileInfo);
    i();
    return true;
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        a((WeiYunFileInfo)paramArrayList.next());
      }
    }
  }
  
  public void h()
  {
    this.h = false;
    if (!NetworkUtil.f(a()))
    {
      FMToastUtil.a(2131363461);
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_g_of_type_Int * 15, 15, this.jdField_b_of_type_Long);
    f();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      t();
      return;
    }
    setEditbarButton(false, true, false, true, true);
    t();
  }
  
  void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = new dkd(this);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dkf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void n()
  {
    super.n();
    l();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */