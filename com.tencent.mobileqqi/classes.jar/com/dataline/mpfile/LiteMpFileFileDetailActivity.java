package com.dataline.mpfile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import com.dataline.activities.DLBaseFileViewActivity;
import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.activity.photo.BaseImageInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cy;
import java.io.File;
import java.util.List;

public class LiteMpFileFileDetailActivity
  extends DLBaseFileViewActivity
{
  public static String a;
  private float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cy(this);
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  private long c;
  private long d;
  private long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LiteMpFileFileDetailActivity";
  }
  
  public LiteMpFileFileDetailActivity()
  {
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  static String a(String paramString)
  {
    return String.format("%s%s", new Object[] { MpfileDataCenter.a(), paramString });
  }
  
  private void r()
  {
    this.jdField_d_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Long = ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_Long);
    this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVING;
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  protected float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  protected int a(List paramList)
  {
    paramList.clear();
    BaseImageInfo localBaseImageInfo = new BaseImageInfo();
    localBaseImageInfo.jdField_e_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString.length() > 0) && (new File(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString).exists())) {
      localBaseImageInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString;
    }
    if (((localBaseImageInfo.jdField_b_of_type_JavaLangString == null) || (localBaseImageInfo.jdField_b_of_type_JavaLangString.length() == 0)) && (MpfileDataCenter.k != null) && (MpfileDataCenter.k.length() > 0)) {
      localBaseImageInfo.jdField_b_of_type_JavaLangString = String.format("http://%s:%d/qqmpfile/?action=thumbnail&fileid=%s", new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), this.jdField_b_of_type_JavaLangString });
    }
    paramList.add(localBaseImageInfo);
    return 0;
  }
  
  protected long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  protected void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = getIntent().getExtras().getString("fileId");
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      String str2 = getIntent().getExtras().getString("name");
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      long l = getIntent().getExtras().getLong("size");
      str2 = a(str1);
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_Int = FileManagerUtil.a(str1);
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      super.doOnCreate(paramBundle);
      paramBundle = new DLFileInfo();
      paramBundle.jdField_b_of_type_JavaLangString = str1;
      paramBundle.jdField_b_of_type_Long = l;
      paramBundle.jdField_a_of_type_JavaLangString = str2;
      paramBundle.jdField_a_of_type_Long = 0L;
      paramBundle.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.FILECOMING;
      localObject = ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a((String)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = ((MpfileTaskInfo)localObject).jdField_d_of_type_Long;
        this.jdField_b_of_type_Long = ((MpfileTaskInfo)localObject).jdField_a_of_type_Long;
        if (((MpfileTaskInfo)localObject).g != MpfileTaskInfo.jdField_a_of_type_Int) {
          break label294;
        }
        paramBundle.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.FILECOMING;
      }
      for (;;)
      {
        if (new File(str2).exists())
        {
          paramBundle.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.DONE;
          this.jdField_a_of_type_Float = 1.0F;
        }
        a(paramBundle);
        a(this.jdField_a_of_type_Int);
        a_();
        b();
        h(2131558590);
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.dataline.mpfile.download_progress");
        paramBundle.addAction("com.dataline.mpfile.download_completed");
        paramBundle.addAction(MpFileConstant.d);
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        return true;
        label294:
        if (((MpfileTaskInfo)localObject).g == MpfileTaskInfo.jdField_c_of_type_Int)
        {
          paramBundle.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.DONE;
          this.jdField_a_of_type_Float = 1.0F;
        }
        else if ((((MpfileTaskInfo)localObject).g == MpfileTaskInfo.jdField_d_of_type_Int) || (((MpfileTaskInfo)localObject).g == MpfileTaskInfo.e))
        {
          paramBundle.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVFAILED;
          this.jdField_a_of_type_Float = ((float)((MpfileTaskInfo)localObject).jdField_c_of_type_Long / (float)((MpfileTaskInfo)localObject).jdField_b_of_type_Long);
        }
        else
        {
          paramBundle.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVING;
          this.jdField_a_of_type_Float = ((float)((MpfileTaskInfo)localObject).jdField_c_of_type_Long / (float)((MpfileTaskInfo)localObject).jdField_b_of_type_Long);
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    f();
  }
  
  protected void h()
  {
    if (!NetworkUtil.e(this))
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      FMToastUtil.a(2131562488);
      return;
    }
    if (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_Long == 0L)
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      FMToastUtil.a("'" + this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString + "'" + BaseApplication.getContext().getResources().getString(2131558546));
      return;
    }
    if (((RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a() == 0)
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      FMToastUtil.a(2131558582);
      return;
    }
    r();
    f();
  }
  
  protected void i()
  {
    this.jdField_e_of_type_Boolean = true;
    ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().c(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVFAILED;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileFileDetailActivity
 * JD-Core Version:    0.7.0.1
 */