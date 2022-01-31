package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import dsk;
import dsn;
import dso;
import dsp;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseActionBarDataLineFile
  extends BaseQfileActionBar
{
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private long c = 0L;
  
  public BaseActionBarDataLineFile(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private View.OnClickListener a()
  {
    return new dsp(this);
  }
  
  private void i()
  {
    a(1, false);
    a(2, false);
    a(3, false);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)))
    {
      a(0, false);
      a(1, false);
      a(3, false);
      return;
    }
    a(0, true);
    a(1, true);
    a(3, true);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new dsn(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(MpFileConstant.d);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new dso(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  }
  
  private void o()
  {
    long l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 8) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 1)) {}
    for (localObject = ((Activity)localObject).getString(2131361992) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; localObject = ((Activity)localObject).getString(2131361993) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  private void p()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    MpfileTaskInfo localMpfileTaskInfo = localDataLineHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    if (localMpfileTaskInfo != null) {}
    for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = localDataLineHandler.a().a(localMpfileTaskInfo.c, localMpfileTaskInfo.d, localMpfileTaskInfo.jdField_b_of_type_Long);; this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = localDataLineHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      return;
    }
  }
  
  private void q()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localDataLineHandler.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label156;
        }
        DataLineReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localDataLineHandler.a(localArrayList)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().c(localDataLineMsgRecord.msgId);
      return;
      label156:
      DataLineReportUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    }
    FMToastUtil.a(2131361870);
  }
  
  private void r()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq), true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
    {
      Object localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131298065);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = (Button)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131297856);
      if (localObject != null) {
        ((Button)localObject).setEnabled(true);
      }
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131298072);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131298073);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
    }
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1) && (!this.jdField_b_of_type_Boolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "重新下载", 2130838521, 2130838522, a());
    }
  }
  
  public void a(Activity paramActivity)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    if ((localDataLineHandler != null) && (this.jdField_a_of_type_JavaLangString != null)) {
      b(paramActivity, "发送到电脑", 2130838513, 2130838514, ActionBarUtil.a(localDataLineHandler, (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a() == 0) {
      b(paramActivity, "保存到手机", 2130838515, 2130838516, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    b(paramActivity, "存到微云", 2130838523, 2130838524, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    super.a(paramActivity);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
      a(2, "收藏", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      a(2, FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "发给好友", 2130838517, 2130838518, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 10000, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().d();
      if ((i != 3) && (i != 0)) {
        break label198;
      }
      c();
    }
    label198:
    do
    {
      do
      {
        return;
        if (i != 2) {
          break;
        }
        h();
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend);
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131298065);
    } while (paramObject == null);
    paramObject.setVisibility(8);
    return;
    a();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 6) {
        break label59;
      }
      m();
    }
    label59:
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 7) {
      return;
    }
    k();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
    for (Object localObject1 = "恢复发送";; localObject1 = "恢复下载")
    {
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 7) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq != 0L))
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6)
        {
          localObject2 = localObject1;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
          {
            localObject2 = localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress != 0.0F) {}
            }
          }
        }
      }
      else
      {
        localObject2 = "下载原文件";
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131298065);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        i();
      }
      a(0, (String)localObject2, new dsk(this));
      return;
    }
  }
  
  protected void d()
  {
    DataLineMsgRecord localDataLineMsgRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if ((localDataLineMsgRecord.strMoloKey != null) && (DataLineMsgSet.isSingle(localDataLineMsgRecord)))
      {
        if (!localDataLineMsgRecord.isReportPause)
        {
          localDataLineMsgRecord.isReportPause = true;
          DataLineReportUtil.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
        }
        localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
      return;
      if ((localDataLineMsgRecord.isReportPause) || (localDataLineMsgRecord.msgtype != -2335)) {
        break;
      }
      localDataLineMsgRecord.isReportPause = true;
      DataLineReportUtil.m(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7)
      {
        this.jdField_a_of_type_Boolean = true;
        ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID);
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6) {
      n();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 7) {
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile
 * JD-Core Version:    0.7.0.1
 */