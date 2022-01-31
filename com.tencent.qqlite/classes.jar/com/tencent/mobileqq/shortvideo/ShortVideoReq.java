package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.Logger;
import java.util.UUID;

public class ShortVideoReq
  implements Comparable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int g = 200;
  public static final int h = 201;
  public static final int i = 202;
  private static final int j = 200;
  public MessageForShortVideo a;
  public ShortVideoDownloadInfo a;
  public ShortVideoUploadInfo a;
  public UiCallBack a;
  public String a;
  public String b;
  public int d = -1;
  public int e;
  public int f = 201;
  
  public ShortVideoReq()
  {
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(ShortVideoReq paramShortVideoReq)
  {
    if (this.f < paramShortVideoReq.f) {
      return -1;
    }
    if (this.f > paramShortVideoReq.f) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    int k = 6;
    if (paramShortVideoDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramShortVideoDownloadInfo.jdField_a_of_type_Int = this.e;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo = paramShortVideoDownloadInfo;
    if (paramShortVideoDownloadInfo.b == 0) {}
    for (;;)
    {
      this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.b, 0, k);
      return;
      if (paramShortVideoDownloadInfo.b == 3000) {
        k = 17;
      } else if (paramShortVideoDownloadInfo.b == 1) {
        k = 9;
      }
    }
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    int k = 6;
    if (paramShortVideoUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramShortVideoUploadInfo.jdField_a_of_type_Int = this.e;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
    if (paramShortVideoUploadInfo.b == 0) {}
    for (;;)
    {
      this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.b, 1, k);
      return;
      if (paramShortVideoUploadInfo.b == 3000) {
        k = 17;
      } else if (paramShortVideoUploadInfo.b == 1) {
        k = 9;
      }
    }
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoReq
 * JD-Core Version:    0.7.0.1
 */