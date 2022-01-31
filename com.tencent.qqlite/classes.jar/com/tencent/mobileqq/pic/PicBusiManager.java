package com.tencent.mobileqq.pic;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import java.util.ArrayList;

public class PicBusiManager
{
  public static final int a = 1;
  private static final String a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  
  static
  {
    jdField_a_of_type_JavaLangString = PicBusiManager.class.getSimpleName();
  }
  
  static BasePicOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator(paramQQAppInterface);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator();
  }
  
  public static PicDownloadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static PicFowardInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static PicFowardInfo a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static PicReq a(int paramInt1, int paramInt2)
  {
    PicReq localPicReq = new PicReq();
    localPicReq.i = paramInt1;
    localPicReq.j = paramInt2;
    return localPicReq;
  }
  
  public static PicUploadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static ArrayList a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static void a(PicReq paramPicReq, QQAppInterface paramQQAppInterface)
  {
    if (paramPicReq == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,req == null");
      return;
    }
    BasePicOprerator localBasePicOprerator = a(paramPicReq.j, paramQQAppInterface);
    if (localBasePicOprerator == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,busiInterface == null,req.busiType:" + paramPicReq.j);
      return;
    }
    localBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq = paramPicReq;
    localBasePicOprerator.jdField_a_of_type_JavaLangString = paramPicReq.jdField_a_of_type_JavaLangString;
    localBasePicOprerator.b = paramPicReq.b;
    localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicUiCallBack);
    Logger.a(jdField_a_of_type_JavaLangString, "launch", "cmd:" + paramPicReq.i + ",busiType" + paramPicReq.j + "localUUID:" + paramPicReq.jdField_a_of_type_JavaLangString);
    switch (paramPicReq.i)
    {
    default: 
      return;
    case 0: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      return;
    case 4: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo, "chatthumb");
      return;
    case 5: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo, "chatimg");
      return;
    case 6: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo, "chatraw");
      return;
    case 1: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo);
      return;
    case 2: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo);
      return;
    case 3: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo);
      return;
    }
    localBasePicOprerator.a(paramPicReq.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicBusiManager
 * JD-Core Version:    0.7.0.1
 */