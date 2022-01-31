package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import bze;
import bzf;
import bzg;
import bzh;
import bzi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.photopreview.PhotoPreviewConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class AIOGalleryUtils
{
  static final int jdField_a_of_type_Int = 0;
  public static final Handler a = null;
  private static final String jdField_a_of_type_JavaLangString = "AIOGalleryUtils";
  static final int b = 2;
  static final int c = 3;
  public static final int d = 1;
  
  static
  {
    if (BaseApplicationImpl.a.getProcessName().endsWith(":peak"))
    {
      a = new bzi();
      return;
    }
  }
  
  public static AIOImageData a(MessageForPic paramMessageForPic)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.a = paramMessageForPic.uniseq;
    localAIOImageData.jdField_d_of_type_Int = paramMessageForPic.subMsgId;
    int i;
    if (paramMessageForPic.isMixed)
    {
      i = 1;
      localAIOImageData.jdField_d_of_type_JavaLangString = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label130;
      }
    }
    label130:
    for (localAIOImageData.jdField_e_of_type_JavaLangString = localAIOImageData.jdField_d_of_type_JavaLangString;; localAIOImageData.jdField_e_of_type_JavaLangString = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, 1, null).toString()))
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.f = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, 131075, null).toString());
      }
      localAIOImageData.g = paramMessageForPic.uuid;
      localAIOImageData.c = paramMessageForPic.groupFileID;
      localAIOImageData.jdField_d_of_type_Long = paramMessageForPic.width;
      localAIOImageData.jdField_e_of_type_Long = paramMessageForPic.height;
      return localAIOImageData;
      i = 65537;
      break;
    }
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    new File(AppConstants.au).mkdirs();
    String str = paramString;
    if (paramString.indexOf(".") == -1)
    {
      str = FileUtils.a(paramFile.getAbsolutePath());
      str = paramString + "." + str;
    }
    paramString = new File(AppConstants.au, str);
    if (!paramString.exists()) {
      try
      {
        if (paramString.createNewFile()) {
          b(paramActivity, paramFile, paramString);
        }
        return;
      }
      catch (IOException paramFile)
      {
        do
        {
          QQToast.a(paramActivity, paramActivity.getString(2131363452), 0).a();
        } while (!QLog.isColorLevel());
        QLog.e("AIOGalleryUtils", 2, "", paramFile);
        return;
      }
    }
    DialogUtil.a(paramActivity, 230).setTitle(paramActivity.getString(2131363454)).setMessage(paramActivity.getString(2131363456)).setPositiveButton(paramActivity.getString(2131363455), new bzf(paramActivity, paramFile, paramString)).setNegativeButton(paramActivity.getString(2131362798), new bze()).show();
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt)
  {
    new bzh(paramContext, paramInt, paramQQAppInterface, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private static int b(Context paramContext, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)paramContext).getAppRuntime();
    paramContext = ImageUtil.a(paramContext, Uri.parse(paramString));
    Object localObject = new File(paramContext);
    if ((!((File)localObject).exists()) || (((File)localObject).length() > 20480L)) {
      ImageUtil.a(BaseApplication.getContext(), paramString, paramContext, PhotoPreviewConstant.g, PhotoPreviewConstant.g);
    }
    if (!new File(paramContext).exists()) {
      ImageUtil.a(BaseApplication.getContext(), paramString, paramContext, PhotoPreviewConstant.g, PhotoPreviewConstant.g);
    }
    paramContext = localQQAppInterface.a().createEntityManager();
    localObject = paramContext.a(CustomEmotionData.class, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      int j = 0;
      for (int i = 1;; i = k)
      {
        k = i;
        if (j >= ((List)localObject).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject).get(j)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(j)).emoPath))) {
          return 2;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = localQQAppInterface.a();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    paramContext.a((Entity)localObject);
    paramContext.a();
    ChatActivityFacade.a(localQQAppInterface, paramString);
    return 0;
  }
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2)
  {
    new bzg(paramFile2, paramFile1, paramActivity).execute(new Void[0]);
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    paramContext = ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).a().createEntityManager();
    List localList = paramContext.a(CustomEmotionData.class, false, null, null, null, null, null, null);
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        int j = ((CustomEmotionData)localList.get(i)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(i)).emoPath)))
        {
          paramContext.a();
          return true;
        }
        i += 1;
      }
    }
    paramContext.a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils
 * JD-Core Version:    0.7.0.1
 */