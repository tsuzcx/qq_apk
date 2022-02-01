package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import coi;
import coj;
import cok;
import col;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.filebrowser.FileUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class FriendProfileImageAvatar
  extends FriendProfileImageModel
  implements HttpDownloadUtil.HttpDownloadListener
{
  public static final int a = 10001;
  static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  static final int e = 4;
  public Handler a;
  private FriendListObserver a;
  public String a;
  public URL a;
  public boolean a;
  public int f;
  
  public FriendProfileImageAvatar(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cok(this);
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new coi(this);
  }
  
  public int a()
  {
    return 1;
  }
  
  public Drawable a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.e)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.e);
        }
      }
    }
    return localObject1;
  }
  
  public FriendProfileImageModel.ProfileImageInfo a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo;
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 0) {
      i = 0;
    }
    this.h = i;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo, true);
      c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = paramProfileImageInfo;
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, boolean paramBoolean)
  {
    int i = paramProfileImageInfo.h;
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && ((paramProfileImageInfo.h == 0) || (paramProfileImageInfo.h == 3)))
    {
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.b(new coj(this, paramProfileImageInfo));
    }
    if (paramProfileImageInfo.h == 0) {
      paramProfileImageInfo.h = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "load: uin=" + paramProfileImageInfo.e + ",state=" + paramProfileImageInfo.h + ", bState=" + i + ", bGetHeadInfo=" + this.jdField_a_of_type_Boolean + ", isFromClickEvent=" + paramBoolean);
      }
      return;
      if ((!paramBoolean) && (paramProfileImageInfo.h == 3))
      {
        paramProfileImageInfo.h = 4;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 400L);
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void a(BaseActivity paramBaseActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    paramProfileImageInfo.jdField_a_of_type_JavaLangString = null;
    paramProfileImageInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.b);
    paramProfileImageInfo.d = ProfileCardUtil.a(this.b);
    b(paramProfileImageInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = paramProfileImageInfo;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "downloadHDAvatar uin : " + paramString);
    }
    Setting localSetting = (Setting)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(Setting.class, paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      if (!localSetting.url.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = localSetting.url;
        a(localSetting.uin, localSetting.bFaceFlags, localSetting.url);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("Q.profilecard.Avatar", 2, "downloadHDAvatar|has download path = " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(paramString);
  }
  
  public void a(String paramString1, byte paramByte, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_a_of_type_Boolean = true;
    c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    new col(this, "FriendProfileImageAvatar", paramByte, paramString2, paramString1).start();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "onHttpStart() url = " + paramString);
    }
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.toString().equals(paramString)))
    {
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.toString().equals(paramString)))
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      paramString = Message.obtain();
      paramString.what = 1;
      paramString.arg1 = ((int)((float)paramLong2 / (float)paramLong1 * 100.0F));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    for (;;)
    {
      try
      {
        int i = paramProfileImageInfo.h;
        if (FileUtils.c(paramProfileImageInfo.d))
        {
          paramProfileImageInfo.h = 6;
          paramProfileImageInfo.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Avatar", 2, "updateState: uin=" + paramProfileImageInfo.e + ",state=" + paramProfileImageInfo.h + ", beforeState=" + i);
          }
          return;
        }
        if (FileUtils.c(paramProfileImageInfo.c)) {
          paramProfileImageInfo.h = 3;
        } else {
          paramProfileImageInfo.h = 0;
        }
      }
      finally {}
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void b(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar
 * JD-Core Version:    0.7.0.1
 */