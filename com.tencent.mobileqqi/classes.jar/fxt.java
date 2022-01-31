import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileController;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerImageInfo;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class fxt
  extends BaseFileController
{
  static final String jdField_a_of_type_JavaLangString = "<FileAssistant>QfileBaseBusiFileController";
  protected QQAppInterface a;
  protected BaseFileViewerActivity a;
  protected FileManagerEntity a;
  protected ForwardFileInfo a;
  @SuppressLint({"UseSparseArrays"})
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public fxt(BaseFileViewerActivity paramBaseFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity = paramBaseFileViewerActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseFileViewerActivity.b;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBaseFileViewerActivity.getIntent().getParcelableExtra("fileinfo"));
  }
  
  public ViewerData a()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      localObject = null;
    }
    ViewerData localViewerData;
    do
    {
      do
      {
        return localObject;
        localViewerData = new ViewerData();
        localViewerData.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.c();
        localViewerData.c = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
        localViewerData.jdField_d_of_type_JavaLangString = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        localViewerData.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.f();
        localViewerData.jdField_b_of_type_Boolean = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        localObject = localViewerData;
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 5);
      localObject = localViewerData;
    } while (!FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath));
    localViewerData.m = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
    return localViewerData;
  }
  
  protected String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(paramInt);
  }
  
  protected void a() {}
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.a();
    if (localObject == null) {}
    FileViewerImageInfo localFileViewerImageInfo;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = ((List)localObject).iterator();
      }
      localFileViewerImageInfo = (FileViewerImageInfo)((Iterator)localObject).next();
    } while (localFileViewerImageInfo.jdField_a_of_type_Long != paramLong);
    localFileViewerImageInfo.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(Bundle paramBundle, Intent paramIntent) {}
  
  public void a(View paramView)
  {
    FileCategoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.onBackPressed();
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = ((FileManagerEntity)paramObject);
    FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
  }
  
  protected void a(List paramList) {}
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 6)
    {
      FileManagerEntity localFileManagerEntity2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity == null)
      {
        localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId <= 0L) {
          break label98;
        }
      }
      label98:
      for (FileManagerEntity localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);; localFileManagerEntity1 = null)
      {
        localFileManagerEntity2.relatedEntity = localFileManagerEntity1;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.status == 1))) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Menu paramMenu)
  {
    paramMenu.clear();
    Object localObject = new ArrayList();
    FileCategoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_JavaUtilMap.clear();
    a((List)localObject);
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      MenuItemCompat.setShowAsAction(paramMenu.add(0, i, 0, a(localInteger.intValue())), 0);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localInteger);
      localInteger.intValue();
      i += 1;
    }
    return true;
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramMenuItem.getItemId()))).intValue())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("<FileAssistant>QfileBaseBusiFileController", 2, "bug, why come here, which" + paramMenuItem.getItemId());
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.f();
      return true;
      c();
      continue;
      QfavBuilder.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, 3);
      continue;
      d();
      continue;
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      continue;
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      continue;
      b();
    }
  }
  
  protected void b() {}
  
  public void b(View paramView)
  {
    Object localObject = new ArrayList();
    FileCategoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_JavaUtilMap.clear();
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, null);
    a((List)localObject);
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localInteger);
      if (localInteger.intValue() == 2131558799) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(localInteger.intValue()), 3);
      }
      for (;;)
      {
        i += 1;
        break;
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(localInteger.intValue()), 0);
      }
    }
    paramView.a(new fxu(this, paramView));
    paramView.d(2131561746);
    paramView.show();
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    Object localObject = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_JavaLangString = "file_forward";
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 71;
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    ((FileManagerReporter.fileAssistantReportData)localObject).c = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
    localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
    ((ForwardFileInfo)localObject).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType);
    ((ForwardFileInfo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    ((ForwardFileInfo)localObject).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    ((ForwardFileInfo)localObject).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    ((ForwardFileInfo)localObject).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
    ((ForwardFileInfo)localObject).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    ((ForwardFileInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    ((ForwardFileInfo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin != 0L) {
      ((ForwardFileInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
    }
    localBundle.putInt("forward_type", 0);
    localBundle.putParcelable("fileinfo", (Parcelable)localObject);
    localBundle.putBoolean("not_forward", true);
    localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, ForwardRecentActivity.class);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("forward_type", 0);
    ((Intent)localObject).putExtra("forward_text", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    a(localBundle, (Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.startActivityForResult((Intent)localObject, 103);
  }
  
  void d()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity == null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId <= 0L) {
        break label239;
      }
    }
    label239:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);; localObject1 = null)
    {
      ((FileManagerEntity)localObject2).relatedEntity = ((FileManagerEntity)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.status != 2)) {
        break;
      }
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
      ((ForwardFileInfo)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.cloudType);
      ((ForwardFileInfo)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.nSessionId);
      ((ForwardFileInfo)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.fileName);
      ((ForwardFileInfo)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.uniseq);
      ((ForwardFileInfo)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.WeiYunFileId);
      ((ForwardFileInfo)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.fileSize);
      ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.strFilePath);
      ((ForwardFileInfo)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.Uuid);
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, QfileFileViewerActivity.class);
      ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.startActivityForResult((Intent)localObject2, 104);
      return;
    }
    if (!NetworkUtil.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity))
    {
      FMToastUtil.a(2131562488);
      return;
    }
    FileCategoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.nSessionId;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void e(View paramView)
  {
    d();
  }
  
  public void f(View paramView)
  {
    super.f(paramView);
  }
  
  public void g(View paramView)
  {
    super.g(paramView);
  }
  
  public void h(View paramView)
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, null);
    paramView.a(2131558701, 0);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Integer.valueOf(2131558701));
    Map localMap;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      paramView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560772, new Object[] { Integer.valueOf(0) }));
      localMap = this.jdField_a_of_type_JavaUtilMap;
      i = 2;
      localMap.put(Integer.valueOf(1), Integer.valueOf(2131560772));
    }
    for (;;)
    {
      int j = i;
      if (a())
      {
        paramView.a(2131558703, 0);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Integer.valueOf(2131558703));
        j = i + 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
      {
        paramView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558745, new Object[] { Integer.valueOf(0) }));
        localMap = this.jdField_a_of_type_JavaUtilMap;
        i = j + 1;
        localMap.put(Integer.valueOf(j), Integer.valueOf(2131558745));
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558727), 0);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Integer.valueOf(2131558727));
      }
      paramView.a(new fxv(this, paramView));
      paramView.d(2131561746);
      paramView.show();
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxt
 * JD-Core Version:    0.7.0.1
 */