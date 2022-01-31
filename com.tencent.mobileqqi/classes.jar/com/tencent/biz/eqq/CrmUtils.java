package com.tencent.biz.eqq;

import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class CrmUtils
{
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.extendType == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(EqqDetail paramEqqDetail)
  {
    return (paramEqqDetail != null) && (paramEqqDetail.followType == 1);
  }
  
  public static boolean a(PublicAccountInfo paramPublicAccountInfo)
  {
    return (paramPublicAccountInfo != null) && (paramPublicAccountInfo.extendType == 2);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.extendType == 2)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmUtils
 * JD-Core Version:    0.7.0.1
 */