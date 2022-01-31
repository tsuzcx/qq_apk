package com.tencent.mobileqq.transfile;

import android.content.ContentValues;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class GrpTransfileProcessor
  extends CommenTransFileProcessor
{
  public GrpTransfileProcessor(String paramString1, int paramInt, String paramString2, boolean paramBoolean, TransFileController paramTransFileController)
  {
    super(paramString1, paramInt, paramString2, paramBoolean, paramTransFileController);
  }
  
  protected byte a()
  {
    return 3;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte);
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    boolean bool = true;
    ContentValues localContentValues = new ContentValues();
    String str;
    int i;
    if (paramBoolean)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 1) {
        break label123;
      }
      i = 1;
    }
    for (;;)
    {
      label40:
      long l = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aa == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        str = TransfileUtile.a(str, l, i, paramBoolean);
        localContentValues.put("msg", str);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, this.ao, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c, str);
        return;
        str = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
        break;
        label123:
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {
          break label228;
        }
        QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d + "", 0);
        i = j;
        if (localMessage == null) {
          break label40;
        }
        i = j;
        if (localMessage.pttUrl == null) {
          break label40;
        }
        i = j;
        if (!localMessage.pttUrl.equals(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i)) {
          break label40;
        }
        localMessage.pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
        i = j;
        break label40;
      }
      label228:
      i = 0;
    }
  }
  
  protected byte[] a(String paramString)
  {
    return paramString.getBytes();
  }
  
  protected byte b()
  {
    return 0;
  }
  
  protected byte[] b()
  {
    return null;
  }
  
  protected void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.d, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 1) {}
    for (;;)
    {
      a(true);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {}
    }
  }
  
  protected void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.d, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c);
    a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 1) {
      ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, ImageUtil.a(BaseApplication.getContext(), Uri.parse(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)), 160, 160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GrpTransfileProcessor
 * JD-Core Version:    0.7.0.1
 */