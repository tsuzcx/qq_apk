package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.compress.Utils;
import java.util.ArrayList;
import java.util.Iterator;
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
  public static final int h = 7;
  public static final int l = 200;
  public static final int m = 201;
  public static final int n = 202;
  private static final int o = 200;
  public MessageForPic a;
  public CompressInfo a;
  public PicDownloadInfo a;
  public PicFowardInfo a;
  public PicUploadInfo a;
  public UiCallBack a;
  public String a;
  public ArrayList a;
  public String b;
  public int i = -1;
  public int j;
  public int k = 201;
  
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
    if (this.k < paramPicReq.k) {
      return -1;
    }
    if (this.k > paramPicReq.k) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
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
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      PicFowardInfo localPicFowardInfo = (PicFowardInfo)localIterator.next();
      if (localPicFowardInfo != null)
      {
        if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
        {
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int = this.j;
        }
        if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
        {
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = this.j;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.b = Logger.a(((PicFowardInfo)paramArrayList.get(0)).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b, 2, 1);
  }
  
  public boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    paramCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if (Utils.a(paramCompressInfo.c)) {
      paramCompressInfo.f = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
      return true;
      if (Utils.b(paramCompressInfo.c)) {
        paramCompressInfo.f = 1;
      } else {
        paramCompressInfo.f = 0;
      }
    }
  }
  
  public boolean a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicDownloadInfo.jdField_a_of_type_Int = this.j;
    this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramPicDownloadInfo;
    int i1;
    if (this.i == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatthumb";
      i1 = 65537;
    }
    for (;;)
    {
      this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, 0, i1);
      return true;
      if (this.i == 6)
      {
        i1 = 131075;
        this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatraw";
      }
      else
      {
        if (this.i == 5) {
          this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatimg";
        }
        i1 = 1;
      }
    }
  }
  
  public boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int = this.j;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = this.j;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo = paramPicFowardInfo;
    int i1 = -1;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null) {
      i1 = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b;
    }
    this.b = Logger.a(i1, 2, 1);
    return true;
  }
  
  public boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicUploadInfo.jdField_a_of_type_Int = this.j;
    this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = paramPicUploadInfo;
    this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b, 1, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReq
 * JD-Core Version:    0.7.0.1
 */