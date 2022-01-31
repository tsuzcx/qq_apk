package com.dataline.activities;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l;
import m;
import n;
import u;

public class DLFileViewerActivity
  extends DLBaseFileViewActivity
{
  public static final String a = "DLFileViewerActivity ";
  public static final String b = "dl_file_info_session_id";
  public static final String c = "dl_file_use_set";
  public static final String d = "dl_file_type";
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new n(this);
  private DataLineMsgRecord jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private int h = 0;
  
  private int a(List paramList, DataLineMsgSet paramDataLineMsgSet, long paramLong)
  {
    paramDataLineMsgSet = paramDataLineMsgSet.values().iterator();
    int i = 0;
    u localu;
    if (paramDataLineMsgSet.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramDataLineMsgSet.next();
      if (((localDataLineMsgRecord.msgtype != -2000) && ((localDataLineMsgRecord.msgtype != -2005) || (FileManagerUtil.a(localDataLineMsgRecord.filename) != 0)) && ((localDataLineMsgRecord.msgtype != -2335) || (!localDataLineMsgRecord.bIsMoloImage))) || (!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress != 1.0F)) {
        break label199;
      }
      localu = new u(this, localDataLineMsgRecord);
      localu.e = false;
      if ((localDataLineMsgRecord.path != null) && (new File(localDataLineMsgRecord.path).exists()))
      {
        localu.jdField_b_of_type_JavaLangString = localDataLineMsgRecord.path;
        label155:
        paramList.add(localu);
        if (localDataLineMsgRecord.sessionid != paramLong) {
          break label199;
        }
        i = paramList.size() - 1;
      }
    }
    label199:
    for (;;)
    {
      break;
      localu.jdField_b_of_type_JavaLangString = null;
      break label155;
      return i;
    }
  }
  
  private DLFileInfo a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    DLFileInfo localDLFileInfo = new DLFileInfo();
    localDLFileInfo.jdField_b_of_type_JavaLangString = paramDataLineMsgRecord.filename;
    localDLFileInfo.jdField_b_of_type_Long = paramDataLineMsgRecord.filesize;
    localDLFileInfo.jdField_a_of_type_JavaLangString = paramDataLineMsgRecord.path;
    localDLFileInfo.jdField_a_of_type_Long = paramDataLineMsgRecord.sessionid;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      if (!paramDataLineMsgRecord.issuc)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.SENDFAILED;
          return localDLFileInfo;
        }
        localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVFAILED;
        return localDLFileInfo;
      }
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.SENDING;
          return localDLFileInfo;
        }
        localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVING;
        return localDLFileInfo;
      }
      localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.DONE;
      return localDLFileInfo;
    }
    if (paramDataLineMsgRecord.fileMsgStatus == 2L)
    {
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.SENDFAILED;
        return localDLFileInfo;
      }
      localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVFAILED;
      return localDLFileInfo;
    }
    localDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.FILECOMING;
    return localDLFileInfo;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = new ComponentName(paramContext, JumpActivity.class);
    if (paramBoolean) {}
    for (int i = 0;; i = 2)
    {
      localPackageManager.setComponentEnabledSetting(paramContext, i, 1);
      if (QLog.isColorLevel()) {
        QLog.d("DLFileViewerActivity ", 2, "EnableViewByQQ : " + paramBoolean);
      }
      return;
    }
  }
  
  private void r()
  {
    if (((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE) || (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.SENDFAILED)) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey == null)) {
      this.p.setVisibility(0);
    }
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.bIsMoloImage))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838585);
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloIconUrl);
      return;
    }
    a_();
    b();
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Int != 0) {}
    while (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = ((u)this.jdField_a_of_type_ComTencentWidgetGallery.a()).jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      return;
    }
  }
  
  private void u()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.b.a(8);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)
    {
      localDataLineHandler.b(111);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord)) {
          break label127;
        }
        DataLineReportUtil.d(this.b);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid));
      if (!localDataLineHandler.a(localArrayList)) {
        break;
      }
      this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVING;
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus = 0L;
      this.b.a().c(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
      return;
      label127:
      DataLineReportUtil.e(this.b);
    }
    FMToastUtil.a(2131558544);
  }
  
  private void v()
  {
    ((DataLineHandler)this.b.a(8)).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, true);
    this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.SENDING;
  }
  
  protected float a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.progress;
    }
    return 0.0F;
  }
  
  protected int a(List paramList)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.issuc) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.progress == 1.0F))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet != null) {
        j = a(paramList, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
      }
      do
      {
        return j;
        localObject = this.b.a().a(true).iterator();
        i = 0;
        j = i;
      } while (!((Iterator)localObject).hasNext());
      int j = a(paramList, (DataLineMsgSet)((Iterator)localObject).next(), this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
      if (j == 0) {
        break label217;
      }
      int i = j;
    }
    label217:
    for (;;)
    {
      break;
      localObject = new u(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      ((u)localObject).e = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path != null) && (new File(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path).exists())) {
        ((u)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path;
      }
      for (;;)
      {
        paramList.add(localObject);
        return 0;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath != null) {
          ((u)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath;
        } else {
          ((u)localObject).jdField_b_of_type_JavaLangString = null;
        }
      }
    }
  }
  
  protected long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId;
    }
    return 0L;
  }
  
  protected void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId = paramLong;
    this.b.a().c(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
  }
  
  protected void d()
  {
    this.p.setVisibility(4);
    if (((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE) || (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.SENDFAILED)) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey == null)) {
      this.p.setVisibility(0);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      int i = this.h;
      setTitle(i + 1 + "/" + this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
    setTitle(2131558562);
  }
  
  protected void d(int paramInt)
  {
    this.h = paramInt;
    d();
  }
  
  @SuppressLint({"NewApi"})
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int i = 0;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    long l = paramBundle.getLongExtra("dl_file_info_session_id", -1L);
    if (paramBundle.getBooleanExtra("dl_file_use_set", false)) {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.b.a().a(l);
    }
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("dl_file_type", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = this.b.a().b(l);
    boolean bool;
    DataLineMsgRecord localDataLineMsgRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)
    {
      bool = true;
      this.c = bool;
      a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      if ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null))
      {
        paramBundle = (DataLineHandler)this.b.a(8);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.bIsApkFile) {
          break label233;
        }
        localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
        if (paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey)) {
          i = 1;
        }
      }
    }
    label233:
    for (localDataLineMsgRecord.nAppStatus = i;; this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nAppStatus = 1)
    {
      if (this.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_Int = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename);
      }
      a(this.jdField_a_of_type_Int);
      r();
      s();
      return true;
      bool = false;
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    DataLineMsgRecord localDataLineMsgRecord;
    int i;
    if ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null))
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.b.a(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.bIsApkFile) {
        break label86;
      }
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
      if (!localDataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey)) {
        break label81;
      }
      i = 1;
    }
    label81:
    label86:
    for (localDataLineMsgRecord.nAppStatus = i;; this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nAppStatus = 1)
    {
      f();
      return;
      i = 0;
      break;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      b_();
      d();
      if (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.DONE) {
        break;
      }
      if (this.jdField_a_of_type_Int == 0) {
        c(2131558729);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey == null)
      {
        this.p.setVisibility(0);
        this.p.invalidate();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.bIsApkFile) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nAppStatus != 1)) {
            c(2131558561);
          } else {
            c(2131558498);
          }
        }
        else {
          c(2131558727);
        }
      }
    }
    super.f();
  }
  
  protected void h()
  {
    Object localObject;
    m localm;
    int j;
    if (NetworkUtil.e(a())) {
      if ((FileManagerUtil.a()) && (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_Long > 5242880L))
      {
        localObject = new l(this);
        localm = new m(this);
        if (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.SENDFAILED) {
          break label164;
        }
        j = 2131558502;
      }
    }
    for (int i = 2131558756;; i = 2131558757)
    {
      String str = getString(i);
      DialogUtil.a(a(), 230, getString(j), str, 2131561746, 2131558509, (DialogInterface.OnClickListener)localObject, localm).show();
      return;
      localObject = this.b.a().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
      if (localObject != null) {
        ((DataLineMsgSet)localObject).setPaused(false);
      }
      if (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.SENDFAILED)
      {
        u();
        return;
      }
      v();
      return;
      FMToastUtil.a(2131562488);
      return;
      label164:
      j = 2131558505;
    }
  }
  
  protected void i()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.b.a(8);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null) && (DataLineMsgSet.isSingle(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.isReportPause)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.k(this.b);
      }
      localDataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.groupId, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid, false);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.isSendFromLocal()) {
        break label143;
      }
    }
    label143:
    for (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.SENDFAILED;; this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVFAILED)
    {
      f();
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.isReportPause) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgtype != -2335)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.isReportPause = true;
      DataLineReportUtil.m(this.b);
      break;
    }
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.b.a(8);
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.bIsApkFile) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nAppStatus == 1))
      {
        int i = localDataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey);
        if (i == 2) {
          FMToastUtil.a(2131558735);
        }
        while (i == 0) {
          return;
        }
        FMToastUtil.a(2131558528);
        return;
      }
      localDataLineHandler.b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey);
      return;
    }
    super.m();
  }
  
  protected void n()
  {
    t();
    super.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.activities.DLFileViewerActivity
 * JD-Core Version:    0.7.0.1
 */