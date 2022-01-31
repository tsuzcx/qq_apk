package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BaseDownloadProcessor
  extends BaseTransProcessor
{
  public static final boolean a = false;
  long jdField_a_of_type_Long = 0L;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  int ao = 0;
  int ap = 0;
  long jdField_b_of_type_Long = 0L;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
  String c;
  String d;
  String e = null;
  String f = null;
  
  public BaseDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_b_of_type_Boolean = false;
    if ((paramTransferRequest != null) && (paramTransferRequest.a != null)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramTransferRequest.a);
    }
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString.length() % 2 != 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      StringBuilder localStringBuilder = new StringBuilder(2);
      localStringBuilder.append(paramString[i]).append(paramString[(i + 1)]);
      arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(localStringBuilder.toString(), 16));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.B = 2001;
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "start ");
        }
      }
      super.a();
      return;
    }
    finally {}
  }
  
  byte[] a(String paramString1, String paramString2)
  {
    String str = null;
    Object localObject = str;
    if (paramString1 != null)
    {
      localObject = str;
      if (paramString1.length() == 32) {
        localObject = a(paramString1);
      }
    }
    paramString1 = (String)localObject;
    if (localObject == null)
    {
      paramString1 = (String)localObject;
      if (paramString2 != null)
      {
        int i = paramString2.indexOf(".");
        str = paramString2;
        if (i > 0) {
          str = paramString2.substring(0, i);
        }
        if (str.length() != 32) {
          break label85;
        }
        paramString1 = a(str);
      }
    }
    label85:
    do
    {
      do
      {
        do
        {
          return paramString1;
          if (str.length() != 38) {
            break;
          }
          paramString2 = str.substring(1, 37).replace("-", "");
          paramString1 = (String)localObject;
        } while (paramString2.length() != 32);
        return a(paramString2);
        paramString1 = (String)localObject;
      } while (str.length() != 34);
      paramString2 = str.substring(1, 33);
      paramString1 = (String)localObject;
    } while (paramString2.length() != 32);
    return a(paramString2);
  }
  
  public void b()
  {
    a(9366, "transfileController destroy");
    d();
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG", 2, "accountChanged transfileController destroy");
    }
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */