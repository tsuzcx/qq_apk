package com.tencent.mobileqq.utils;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class ForwardSendPicUtil
{
  private static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (paramString1 != null)
    {
      paramString4 = new PicUploadInfo.Builder();
      paramString4.a(paramString1);
      paramString4.d(1009);
      paramString4.d(paramString2);
      paramString4.c(TranDbRecord.PicDbRecord.e);
      paramString4.e(paramString3);
      paramString4.c(paramQQAppInterface.a());
      paramString4.e(paramInt);
      paramString1 = PicBusiManager.a(1, 1009);
      paramString1.a(paramString4.a());
      PicBusiManager.a(paramString1, paramQQAppInterface);
    }
    return 0L;
  }
  
  private static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = ImageUtil.a(paramContext, paramString, paramInt);
    ImageInfo localImageInfo = new ImageInfo();
    if (paramBoolean) {}
    for (int i = 7;; i = 4)
    {
      ImageUtil.a(i, paramContext, paramString, str, true, localImageInfo, paramInt);
      return localImageInfo.b;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean, Context paramContext)
  {
    String str = "ForwardSendPicUtil.sendPicTo." + paramContext.getClass().getSimpleName();
    ImageUtil.a(-1L, paramInt, true, "image_send_prepare", str + ", isQzoneShare=" + paramBoolean);
    paramString1 = a(paramContext, paramString1, paramInt, paramBoolean);
    if (!FileUtils.b(paramString1))
    {
      Toast.makeText(paramQQAppInterface.a(), paramQQAppInterface.a().getString(2131363423), 0).show();
      return false;
    }
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ForwardSendPicUtil
 * JD-Core Version:    0.7.0.1
 */