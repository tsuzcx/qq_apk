package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.qphone.base.util.QLog;
import dki;
import dkj;
import dkl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileAppTabView
  extends QfileBaseLocalFileTabView
{
  private IClickListener_Ver51 a;
  public LinkedHashMap b = new LinkedHashMap();
  
  public QfileLocalFileAppTabView(Context paramContext)
  {
    super(paramContext);
    setEditbarButton(false, false, true, true, false);
  }
  
  private void d(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    String str = paramFileInfo.a();
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = "未安装";
    }
    if (!this.b.containsKey(localObject)) {
      this.b.put(localObject, new ArrayList());
    }
    Object localObject = (List)this.b.get(localObject);
    if (((List)localObject).contains(paramFileInfo) == true) {
      return;
    }
    int j = FileManagerUtil.a((List)localObject, paramFileInfo.b());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, paramFileInfo);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileLocalFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
  }
  
  protected void a()
  {
    this.b.clear();
    this.b.put("已安装", new ArrayList());
    this.b.put("未安装", new ArrayList());
    this.jdField_a_of_type_AndroidOsHandler = ThreadManager.b();
    this.jdField_a_of_type_AndroidOsHandler.post(new dkj(this));
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    if (localLooper.getThread() != localThread)
    {
      new Handler(localLooper).post(new dkl(this, paramFileInfo));
      return;
    }
    d(paramFileInfo);
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().S();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().X();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = new dki(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
  }
  
  public void g(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileInfo)paramArrayList.next());
      }
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a();
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(false, false, true, true, false);
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView
 * JD-Core Version:    0.7.0.1
 */