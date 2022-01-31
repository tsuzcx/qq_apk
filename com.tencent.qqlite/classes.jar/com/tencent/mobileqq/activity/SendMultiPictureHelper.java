package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;
import bjc;
import bjd;
import bje;
import bjf;
import bjg;
import bjh;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SendMultiPictureHelper
{
  static final String jdField_a_of_type_JavaLangString = "SendMultiPictureHelper";
  public int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new bje(this);
  public Bundle a;
  protected SendMultiPictureHelper.SendingFileInfo a;
  public BaseActivity a;
  public QQAppInterface a;
  public FMObserver a;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new bjc(this);
  public QQCustomDialog a;
  public ArrayList a;
  public List a;
  public boolean a;
  public int b;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new bjf(this);
  protected String b;
  public boolean b;
  public int c;
  DialogInterface.OnClickListener c;
  public String c;
  public boolean c;
  protected int d;
  public String d;
  public boolean d;
  protected String e;
  public String f;
  
  public SendMultiPictureHelper(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new bjd(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new bjg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    this.f = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364064);
  }
  
  private long a(String paramString1, int paramInt, String paramString2)
  {
    if (FileUtils.a(paramString1))
    {
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1001) && (paramInt != 3000)) {
        break label182;
      }
      ImageUtil.a(-1L, paramInt, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
      String str = ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, paramInt);
      ImageInfo localImageInfo = new ImageInfo();
      ImageUtil.a(4, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, str, true, localImageInfo, paramInt);
      paramString1 = localImageInfo.jdField_b_of_type_JavaLangString;
    }
    label182:
    for (;;)
    {
      long l1;
      if (!ImageUtil.a(null, paramString1, 1, null, "SendMultiPictureHelper.doSendPictues")) {
        l1 = 0L;
      }
      long l2;
      do
      {
        return l1;
        l2 = a(paramString1, paramString2, paramInt);
        a(paramInt, paramString2, paramString1, l2, 1009);
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("streamptt", 2, "ChatActivity.handleForwardData uploadImage,uniseq:" + l2 + ",filePath:" + paramString1 + ",curType:" + paramInt);
      return l2;
      return 0L;
    }
  }
  
  private long a(String paramString1, String paramString2, int paramInt)
  {
    long l = 0L;
    if (paramString1 != null)
    {
      paramString2 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = PicReq.a();
      paramString2.md5 = HexUtil.a(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      l = paramString2.uniseq;
    }
    return l;
  }
  
  private void a(int paramInt, String paramString, long paramLong)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString + paramLong);
    if ((paramString instanceof BaseTransProcessor)) {
      ((BaseTransProcessor)paramString).i();
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    if (paramInt1 == 1001)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString1, paramInt1, paramString2, paramLong);
      return;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString1;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_d_of_type_Int = paramInt2;
    localTransferRequest.h = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
  }
  
  private void e()
  {
    if (this.jdField_d_of_type_Int == 0)
    {
      i();
      return;
    }
    BaseTransProcessor localBaseTransProcessor = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
    if (localBaseTransProcessor != null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.w("SendMultiPictureHelper", 2, this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long + "has error");
        localBaseTransProcessor.h();
        a();
      }
      for (;;)
      {
        QLog.w("SendMultiPictureHelper", 2, "continue send " + this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        return;
        localBaseTransProcessor.f();
      }
    }
    QLog.w("SendMultiPictureHelper", 2, "processor null");
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void f()
  {
    Object localObject;
    if (this.jdField_d_of_type_Int == 0) {
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    do
    {
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, ((SendMultiPictureHelper.SendingFileInfo)localObject).jdField_a_of_type_Long, this.jdField_c_of_type_Int);
        do
        {
          return;
        } while (this.jdField_d_of_type_Int != 1);
        localObject = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        if (localObject == null) {
          break;
        }
        ((BaseTransProcessor)localObject).h();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      } while (!QLog.isColorLevel());
      QLog.d("SendMultiPictureHelper", 2, "stop send " + this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("SendMultiPictureHelper", 2, "processor null");
  }
  
  private void g()
  {
    if (this.jdField_d_of_type_Int == 0) {
      h();
    }
    while (this.jdField_d_of_type_Int != 1) {
      return;
    }
  }
  
  private void h()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      SendMultiPictureHelper.SendingFileInfo localSendingFileInfo = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      QLog.w("SendMultiPictureHelper", 2, "pauseSendFile index=" + this.jdField_a_of_type_Int + ",uniseq=" + localSendingFileInfo.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, localSendingFileInfo.jdField_a_of_type_Long, this.jdField_c_of_type_Int);
      return;
    }
  }
  
  private void i()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      SendMultiPictureHelper.SendingFileInfo localSendingFileInfo = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, localSendingFileInfo.jdField_a_of_type_Long, this.jdField_c_of_type_Int);
      return;
    }
  }
  
  public long a(SendMultiPictureHelper.SendingFileInfo paramSendingFileInfo, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_d_of_type_Int == 0) {
      return a(paramSendingFileInfo, paramString1, this.jdField_c_of_type_JavaLangString, paramInt);
    }
    if (this.jdField_d_of_type_Int == 1) {
      return a(paramSendingFileInfo.jdField_a_of_type_JavaLangString, paramInt, paramString2);
    }
    return 0L;
  }
  
  public long a(SendMultiPictureHelper.SendingFileInfo paramSendingFileInfo, String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendMultiPictureHelper", 2, "why FileManagerRSCenter is null???");
      }
      return 0L;
    }
    paramSendingFileInfo = paramSendingFileInfo.jdField_a_of_type_JavaLangString;
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSendingFileInfo, paramString1, paramString2, paramInt, true).uniseq;
  }
  
  public void a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SendMultiPictureHelper", 2, "sendNext " + (this.jdField_a_of_type_Int + 1));
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label264;
        }
        SendMultiPictureHelper.SendingFileInfo localSendingFileInfo = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        Object localObject2 = localSendingFileInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = localSendingFileInfo;
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists())
        {
          this.jdField_c_of_type_Boolean = true;
          Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((File)localObject2).getName() + "发送失败，己被移动或删除！", 0).show();
          if (!this.jdField_b_of_type_Boolean) {
            a();
          }
          return;
        }
        if (((File)localObject2).length() == 0L)
        {
          if (this.jdField_c_of_type_Int == 0) {
            Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364110), 0).show();
          }
        }
        else
        {
          localSendingFileInfo.jdField_a_of_type_Long = a(localSendingFileInfo, this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364111), 0).show();
      continue;
      label264:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      c();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, Bundle paramBundle, ArrayList paramArrayList)
  {
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Int = paramInt1;
    this.e = paramString3;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_d_of_type_Int = paramInt2;
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.e, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364067), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramString1 = paramArrayList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        paramString3 = new SendMultiPictureHelper.SendingFileInfo(this);
        paramString3.jdField_a_of_type_JavaLangString = paramString2;
        paramString3.jdField_a_of_type_Long = -1L;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPicUploadProcessor.class, ForwardImageProcessor.class });
    }
    paramString1 = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = 0;
    long l;
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.f, new Object[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
        l = a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1), this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long = l;
        paramInt1 += 1;
      }
      c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.f, new Object[] { Integer.valueOf(1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
    if (new File(paramString1).length() == 0L)
    {
      if (this.jdField_c_of_type_Int != 0) {
        break label613;
      }
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364110), 0).show();
    }
    for (;;)
    {
      l = a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long = l;
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bjh(this);
      }
      paramString1 = new IntentFilter();
      paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString1);
      return;
      label613:
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364111), 0).show();
    }
  }
  
  public void b()
  {
    Object localObject = "";
    if (this.jdField_d_of_type_Int == 1) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364065);
    }
    for (;;)
    {
      localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363524), (String)localObject, 2131364114, 2131362798, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).show();
      return;
      if (this.jdField_d_of_type_Int == 0) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364066);
      }
    }
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label35:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper
 * JD-Core Version:    0.7.0.1
 */