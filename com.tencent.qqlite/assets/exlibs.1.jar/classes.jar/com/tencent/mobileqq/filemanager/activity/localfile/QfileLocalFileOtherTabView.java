package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.qphone.base.util.QLog;
import dlb;
import dlc;
import dle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileOtherTabView
  extends QfileBaseLocalFileTabView
{
  private IClickListener_Ver51 a;
  
  public QfileLocalFileOtherTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = null;
    setEditbarButton(false, false, true, true, true);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().V();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().aa();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = new dlb(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileLocalFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
  }
  
  public String a(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return "更多";
    }
    paramString = paramString.toLowerCase();
    if (".rar|.zip|.7z|.iso|.tar|.gz|".indexOf(paramString) >= 0) {
      return "压缩文件";
    }
    if (".txt|.html|.lit|.wdl|.ceb|.pdg|.epub|.caj|.umd|.jar|.mobi|".indexOf(paramString) >= 0) {
      return "电子书";
    }
    return "更多";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_AndroidOsHandler = ThreadManager.b();
    this.jdField_a_of_type_AndroidOsHandler.post(new dlc(this));
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new dle(this, paramFileInfo));
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
  
  protected void g()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a();
    a(true);
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
  
  public void j()
  {
    super.j();
    setEditbarButton(false, false, true, true, true);
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView
 * JD-Core Version:    0.7.0.1
 */