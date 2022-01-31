import android.content.SharedPreferences;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerFacade;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.filebrowser.FileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public abstract class fxx
  extends fxt
{
  static final String b = "<FileAssistant>QfileBaseOfflineFileController";
  
  public fxx(QfileFileViewerActivity paramQfileFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQfileFileViewerActivity, paramFileManagerEntity);
    if (!paramFileManagerEntity.bSend)
    {
      paramFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("FileViewFirstTips", 0);
      if (paramFileManagerEntity.getBoolean("FileViewFirstTips5.0", false) != true) {}
    }
    else
    {
      return;
    }
    paramQfileFileViewerActivity = DialogUtil.a(paramQfileFileViewerActivity, 0);
    paramQfileFileViewerActivity.setTitle(2131558722);
    paramQfileFileViewerActivity.setMessage(2131558723);
    paramQfileFileViewerActivity.setNegativeButton(2131562539, new fxy(this, paramFileManagerEntity, paramQfileFileViewerActivity));
    paramQfileFileViewerActivity.show();
  }
  
  public ViewerData a()
  {
    ViewerData localViewerData = super.a();
    localViewerData.d = (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558715) + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, false) + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558712));
    localViewerData.jdField_h_of_type_Boolean = true;
    localViewerData.l = a(2131558750);
    Object localObject;
    if ((FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() > 0))
    {
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_JavaLangString = "file_preview_in";
      ((FileManagerReporter.fileAssistantReportData)localObject).b = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      localViewerData.jdField_h_of_type_JavaLangString = a(2131562558);
    }
    QfileFileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, localViewerData);
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    default: 
      localViewerData.jdField_g_of_type_JavaLangString = a(2131558725);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>QfileBaseOfflineFileController", 2, "should not come here ,entity:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      }
      break;
    }
    for (;;)
    {
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == 0) {
        localViewerData.jdField_a_of_type_Boolean = true;
      }
      if (!FMDataCache.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) {
        break;
      }
      localViewerData.jdField_g_of_type_Boolean = true;
      return localViewerData;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 8))
      {
        localViewerData.jdField_g_of_type_JavaLangString = a(2131558731);
      }
      else
      {
        localViewerData.jdField_g_of_type_JavaLangString = a(2131558730);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 5) {}
        for (localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560909);; localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558770))
        {
          localViewerData.jdField_g_of_type_JavaLangString = null;
          localViewerData.jdField_h_of_type_JavaLangString = null;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
        {
          localViewerData.jdField_g_of_type_JavaLangString = a(2131558726);
        }
        else
        {
          localViewerData.jdField_g_of_type_JavaLangString = a(2131558725);
          continue;
          long l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 8)) {}
          for (localObject = a(2131558732) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; localObject = a(2131558733) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
          {
            localViewerData.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
            localViewerData.jdField_a_of_type_JavaLangString = ((String)localObject);
            localViewerData.jdField_f_of_type_Boolean = true;
            break;
          }
          localViewerData.jdField_g_of_type_JavaLangString = a(2131558725);
        }
      }
    }
    localViewerData.jdField_g_of_type_Boolean = false;
    return localViewerData;
  }
  
  protected abstract String a();
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    paramObject = a();
    if (paramObject == null) {
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, true);
    }
    if (paramObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramObject;
    }
  }
  
  protected void a(List paramList)
  {
    boolean bool = true;
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList.add(Integer.valueOf(2131558801));
      if (a()) {
        paramList.add(Integer.valueOf(2131558803));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() == 10002)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 1) {
          bool = FMDataCache.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
        }
        while (!bool)
        {
          paramList.add(Integer.valueOf(2131558799));
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 2) {
            bool = FMDataCache.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
          }
        }
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend);
  }
  
  public void c(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 3) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        return;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      return;
    }
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity))
    {
      if ((FileManagerUtil.a()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L))
      {
        FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, 2131558759, 2131558757, new fxz(this));
        return;
      }
      e();
      return;
    }
    FMToastUtil.a(2131562488);
  }
  
  public void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() == 10002)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, null, -1, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxx
 * JD-Core Version:    0.7.0.1
 */