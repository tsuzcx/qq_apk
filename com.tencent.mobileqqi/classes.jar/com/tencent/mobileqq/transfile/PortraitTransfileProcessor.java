package com.tencent.mobileqq.transfile;

import QQService.CARDSETTYPE;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.lbs.LbsPortraitUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PortraitTransfileProcessor
  extends CommenTransFileProcessor
{
  private int aR;
  
  public PortraitTransfileProcessor(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3, TransFileController paramTransFileController)
  {
    super(paramString1, paramInt1, paramString2, paramBoolean, paramTransFileController);
    this.aR = paramInt3;
    if (paramInt2 > 0) {
      ak = paramInt2;
    }
  }
  
  protected byte a()
  {
    return 1;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return HexUtil.bytes2HexStr(paramArrayOfByte);
  }
  
  public void a()
  {
    super.a();
  }
  
  protected byte[] a(String paramString)
  {
    return HexUtil.hexStr2Bytes(paramString);
  }
  
  protected byte b()
  {
    return 0;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.PhotoWall.Trans", 2, "handleError");
    }
    if (QLog.isColorLevel())
    {
      if (paramHttpMsg2 != null)
      {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "resp.errCode = " + paramHttpMsg2.h);
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "resp.errDesc = " + paramHttpMsg2.ae);
      }
    }
    else if ((this.aR == 0) && (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a == 0))
    {
      CardHandler localCardHandler = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localCardHandler == null) {
        break label225;
      }
      localCardHandler.a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    for (;;)
    {
      super.b(paramHttpMsg1, paramHttpMsg2);
      if (1 != this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a) {
        break label232;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c, this.jdField_a_of_type_Short);
      return;
      QLog.d("Q.profilecard.PhotoWall.Trans", 2, "resp.errCode = " + this.at);
      QLog.d("Q.profilecard.PhotoWall.Trans", 2, "resp.errDesc = " + this.J);
      break;
      label225:
      ProfileCardUtil.a(null);
    }
    label232:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
  }
  
  protected byte[] b()
  {
    return null;
  }
  
  protected String d()
  {
    Object localObject2 = null;
    FMTSrvAddrProvider localFMTSrvAddrProvider = FMTSrvAddrProvider.a();
    Object localObject1 = localObject2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      localObject1 = localObject2;
      if (localFMTSrvAddrProvider != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a != 0) {
          break label87;
        }
        i = 1;
        if (i == 0) {
          break label92;
        }
      }
    }
    label87:
    label92:
    for (localObject1 = localFMTSrvAddrProvider.a(0);; localObject1 = localFMTSrvAddrProvider.a(1))
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = e();
      }
      QLog.i("Q.profilecard.PhotoWall.Trans", 2, "getServerAddress|url = " + (String)localObject2);
      return localObject2;
      i = 0;
      break;
    }
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a == 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u != 2003))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "接收中止了，删除没有接收完整的文件。");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "file = " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "key = " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e))
      {
        File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
  }
  
  protected void r()
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = 1003;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
    Object localObject1 = HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("LBS_PORTRAIT", 0).edit();
    ((SharedPreferences.Editor)localObject2).putString("LAST_PORTRAIT_FILEKEY", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c);
    ((SharedPreferences.Editor)localObject2).putString("LAST_PORTRAIT_PATH", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
    ((SharedPreferences.Editor)localObject2).commit();
    if (this.aR == 0) {
      LbsPortraitUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), (byte[])localObject1);
    }
    do
    {
      return;
      if (1 == this.aR)
      {
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
        localObject2 = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.c);
        if (localObject2 != null) {
          i = ((Card)localObject2).uFaceTimeStamp;
        }
        ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a((byte[])localObject1, i);
        return;
      }
    } while (2 != this.aR);
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), CARDSETTYPE.TYPE_SET_BACKGROUND.value(), (byte)0, null, HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c), null, null, null);
    localObject1 = CardHandler.a + "background" + "/" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c + ".jpg";
    localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e, (String)localObject1);
  }
  
  protected void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = 2003;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c, this.jdField_a_of_type_Short);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PortraitTransfileProcessor
 * JD-Core Version:    0.7.0.1
 */