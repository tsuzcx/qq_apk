package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.compress.Utils;
import java.util.UUID;

public class PicReq
  implements Comparable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int k = 200;
  public static final int l = 201;
  public static final int m = 202;
  private static final int n = 200;
  public MessageForPic a;
  public CompressInfo a;
  public PicDownloadInfo a;
  public PicFowardInfo a;
  public PicUploadInfo a;
  public UiCallBack a;
  public String a;
  public String b;
  public int h = -1;
  public int i;
  public int j = 201;
  
  public PicReq()
  {
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(PicReq paramPicReq)
  {
    if (this.j < paramPicReq.j) {
      return -1;
    }
    if (this.j > paramPicReq.j) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo != null)
    {
      paramCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (!Utils.a(paramCompressInfo.c)) {
        break label33;
      }
      paramCompressInfo.f = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
      return;
      label33:
      if (Utils.b(paramCompressInfo.c)) {
        paramCompressInfo.f = 1;
      } else {
        paramCompressInfo.f = 0;
      }
    }
  }
  
  public void a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicDownloadInfo.jdField_a_of_type_Int = this.i;
    this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramPicDownloadInfo;
    int i2 = 1;
    int i1;
    if (this.h == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatthumb";
      i1 = 65537;
    }
    for (;;)
    {
      this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, 0, i1);
      return;
      if (this.h == 6)
      {
        i1 = 131075;
        this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatraw";
      }
      else
      {
        i1 = i2;
        if (this.h == 5)
        {
          this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatimg";
          i1 = i2;
        }
      }
    }
  }
  
  public void a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int = this.i;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = this.i;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo = paramPicFowardInfo;
    int i1 = -1;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null) {
      i1 = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b;
    }
    this.b = Logger.a(i1, 2, 1);
  }
  
  public void a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicUploadInfo.jdField_a_of_type_Int = this.i;
    this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = paramPicUploadInfo;
    this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b, 1, 1);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicUiCallBack = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReq
 * JD-Core Version:    0.7.0.1
 */