import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.service.IQQServiceCallback;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.UtilsServiceForAV;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class bim
  extends IQQServiceForAV.Stub
{
  IBinder jdField_a_of_type_AndroidOsIBinder = null;
  
  public bim(QQServiceForAV paramQQServiceForAV) {}
  
  private void a(IBinder paramIBinder)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.getApplicationContext(), UtilsServiceForAV.class);
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.getApplicationContext().stopService(localIntent);
    if (this.jdField_a_of_type_AndroidOsIBinder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "linkToVideoProcessDeath");
      }
      this.jdField_a_of_type_AndroidOsIBinder = paramIBinder;
    }
    try
    {
      this.jdField_a_of_type_AndroidOsIBinder.linkToDeath(new bin(this), 0);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQServiceForAV", 2, "linkToVideoProcessDeath", paramIBinder);
    }
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    return ((FriendManager)QQServiceForAV.a(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV).getManager(8)).c(paramString);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getFaceBitmap uinType = " + paramInt + ", uin = " + paramString1 + ", extraUin = " + paramString2 + ", isRound = " + paramBoolean1);
    }
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    byte b;
    if (paramBoolean1)
    {
      b = 3;
      switch (paramInt)
      {
      default: 
        paramString1 = this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1, b, true);
      }
    }
    for (;;)
    {
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        paramString2 = paramString1;
        if (paramBoolean2)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQServiceForAV", 2, "getFaceBitmap failed, use default face!");
          }
          if (paramInt != 1) {
            break label340;
          }
          paramString2 = ImageUtil.c();
        }
      }
      return paramString2;
      b = 1;
      break;
      paramString1 = this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1, b, true);
      continue;
      paramString1 = this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1, b, false, false);
      continue;
      paramString1 = (BitmapDrawable)((DiscussionHandler)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(paramString1, false);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getBitmap();
        continue;
        if (!paramString1.startsWith("+")) {}
        for (;;)
        {
          paramString1 = ((BitmapDrawable)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString2, b)).getBitmap();
          break;
          label340:
          if (paramInt == 3000) {
            return ImageUtil.d();
          }
          return ImageUtil.a();
          paramString2 = paramString1;
        }
      }
      else
      {
        paramString1 = null;
      }
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getDisplayName uinType = " + paramInt + ", uin = " + paramString1 + ", extraUin = " + paramString2);
    }
    if ((paramString1 == null) || (paramString1.trim().length() == 0))
    {
      paramString2 = "";
      return paramString2;
    }
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    if (paramInt == 1006)
    {
      if (paramString1.startsWith("+")) {
        break label277;
      }
      if (!paramString2.startsWith("+")) {}
    }
    for (;;)
    {
      paramString1 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).f(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getDisplayName contact = " + paramString1);
      }
      if (paramString1 == null) {
        break;
      }
      return paramString1.name;
      return "";
      int i = ContactUtils.b(paramInt);
      String str;
      if (i == -1)
      {
        paramString2 = ContactUtils.b(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt);
        if (!TextUtils.isEmpty(paramString2))
        {
          str = paramString2;
          if (!paramString1.equals(paramString2)) {}
        }
        else
        {
          str = ContactUtils.b(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
        }
        if (!TextUtils.isEmpty(str)) {
          break label271;
        }
      }
      for (;;)
      {
        return paramString1;
        paramString2 = ContactUtils.a(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, i, 0);
        break;
        label271:
        paramString1 = str;
      }
      label277:
      paramString2 = paramString1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "stopPumpMessage");
    }
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "startPumpMessage uinType = " + paramInt + ", peerUin = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.b = paramString;
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Long = MessageCache.a();
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "setPeerInfo uinType = " + paramInt + ", peerUin = " + paramString1 + ", extraUin = " + paramString2);
    }
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.b = paramString1;
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.d = paramString2;
    this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Long = MessageCache.a();
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback)
  {
    if (paramIQQServiceCallback != null)
    {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_AndroidOsRemoteCallbackList.register(paramIQQServiceCallback);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "registerCallback");
      }
      a(paramIQQServiceCallback.asBinder());
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    return this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    return this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong) > 0L;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    return ((FriendManager)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString);
  }
  
  public long[] a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.a());
    }
    paramString = ((FriendManager)QQServiceForAV.b(this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV).getManager(8)).a(paramString);
    if (paramString != null)
    {
      int j = paramString.size();
      long[] arrayOfLong = new long[j];
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(i);
        if (localDiscussionMemberInfo != null) {
          arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i += 1;
      }
      return arrayOfLong;
    }
    return null;
  }
  
  public void b(IQQServiceCallback paramIQQServiceCallback)
  {
    if (paramIQQServiceCallback != null) {
      this.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_AndroidOsRemoteCallbackList.unregister(paramIQQServiceCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bim
 * JD-Core Version:    0.7.0.1
 */