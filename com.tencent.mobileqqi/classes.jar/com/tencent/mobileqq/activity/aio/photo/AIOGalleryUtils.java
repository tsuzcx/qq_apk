package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
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
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import eca;
import ecb;
import ecc;
import ecd;
import ece;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
    if (BaseApplicationImpl.a.getProcessNames().endsWith(":peak"))
    {
      a = new ece();
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
        break label114;
      }
    }
    label114:
    for (localAIOImageData.e = localAIOImageData.jdField_d_of_type_JavaLangString;; localAIOImageData.e = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, 1, null).toString()))
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.f = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, 131075, null).toString());
      }
      localAIOImageData.g = paramMessageForPic.uuid;
      localAIOImageData.c = paramMessageForPic.groupFileID;
      return localAIOImageData;
      i = 65537;
      break;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, ArrayList paramArrayList)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = paramString1;
    QZoneHelper.a(paramActivity, localUserInfo, paramIntent, paramString2, paramString3, paramString4, paramString5, paramInt, paramArrayList, 7001);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    new File(AppConstants.ap).mkdirs();
    String str = paramString;
    if (paramString.indexOf(".") == -1)
    {
      str = FileUtils.a(paramFile.getAbsolutePath());
      str = paramString + "." + str;
    }
    paramString = new File(AppConstants.ap, str);
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
          QQToast.a(paramActivity, paramActivity.getString(2131561446), 0).a();
        } while (!QLog.isColorLevel());
        QLog.e("AIOGalleryUtils", 2, "", paramFile);
        return;
      }
    }
    DialogUtil.a(paramActivity, 230).setTitle(paramActivity.getString(2131562802)).setMessage(paramActivity.getString(2131561976)).setPositiveButton(paramActivity.getString(2131562765), new ecb(paramActivity, paramFile, paramString)).setNegativeButton(paramActivity.getString(2131562473), new eca()).show();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, AIOImageInfo paramAIOImageInfo, boolean paramBoolean, String paramString3)
  {
    if (paramAIOImageInfo == null) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = paramString1;
    paramString1 = paramAIOImageInfo.a.jdField_d_of_type_JavaLangString;
    String str = paramAIOImageInfo.a.g;
    long l2 = paramAIOImageInfo.a.b;
    long l1 = 0L;
    if (paramBoolean) {
      l1 = paramAIOImageInfo.a.c;
    }
    QZoneHelper.a(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, paramString1, str, l2, l1, -1);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = paramString1;
    paramString1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AIOImageInfo localAIOImageInfo = (AIOImageInfo)paramList.next();
      localArrayList1.add(localAIOImageInfo.a.g);
      localArrayList2.add(Long.valueOf(localAIOImageInfo.a.b));
      if (paramBoolean) {
        localArrayList3.add(Long.valueOf(localAIOImageInfo.a.c));
      }
      String str = localAIOImageInfo.a.jdField_d_of_type_JavaLangString;
      paramString1.add(str);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "fowardToQZoneGroupAlbums(), uuid:" + localAIOImageInfo.a.g + " time:" + localAIOImageInfo.a.b + " path:" + str);
      }
    }
    QZoneHelper.a(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, paramString1, localArrayList1, localArrayList2, localArrayList3, 98);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    QZoneHelper.a(paramActivity, localUserInfo, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    QZoneHelper.a(paramActivity, localUserInfo, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList3, paramInt);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt)
  {
    new ecd(paramContext, paramInt, paramQQAppInterface, paramURLDrawable, paramString).execute(new Void[0]);
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
    new ecc(paramFile2, paramFile1, paramActivity).execute(new Void[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils
 * JD-Core Version:    0.7.0.1
 */