package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import end;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhotoMagicStickUtils
{
  private static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  private static int b = 0;
  
  static
  {
    a = 19922944;
  }
  
  public static List a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString2 == null) || ("$RecentAlbumId".equals(paramString1)))
    {
      paramString1 = AlbumUtil.a(paramContext, 210, 100, paramBoolean);
      paramContext = paramString1;
      if (paramString1.size() <= 0) {}
    }
    do
    {
      do
      {
        return paramContext;
        paramString1 = AlbumUtil.a(paramContext, "bucket_id='" + paramString1 + "'", -1, paramBoolean);
        paramContext = paramString1;
      } while (paramString1 == null);
      paramContext = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("PhotoListActivity", 2, "photo list size is:" + paramString1.size());
    return paramString1;
  }
  
  public static void a(Activity paramActivity, String paramString1, ActionSheet paramActionSheet, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    String str = paramActionSheet.a(paramInt);
    if (str == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "onBtnClickListener clikedBtn text:" + str);
    }
    Intent localIntent = paramActivity.getIntent();
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    if (paramActivity.getString(2131563204).equals(str)) {
      PhotoUtils.a(paramActivity, localIntent, 4, paramString1, paramString2, paramString3, paramString4);
    }
    for (;;)
    {
      paramActionSheet.dismiss();
      return;
      if (paramActivity.getString(2131561599).equals(str)) {
        PhotoUtils.a(paramActivity, localIntent, 5, paramString1, paramString2, paramString3, paramString4);
      } else if (paramActivity.getString(2131561896).equals(str)) {
        PhotoUtils.a(paramActivity, localIntent, 6, paramString1, paramString2, paramString3, paramString4);
      }
    }
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList, ActionSheet paramActionSheet, int paramInt)
  {
    Iterator localIterator = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    int k;
    int m;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l = new File(str).length();
      k = j;
      if (l > a) {
        k = j + 1;
      }
      m = (int)(i + l);
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("_photo", 2, "addExtraBtn path:" + str + ",len:" + l);
        i = m;
        j = k;
      }
    }
    if (paramInt == 0)
    {
      k = 1;
      if (paramInt != 3000) {
        break label323;
      }
      m = 1;
      label155:
      if (paramInt != 1) {
        break label329;
      }
      paramInt = 1;
      label162:
      paramInt = k | m | paramInt;
      if ((paramInt == 0) || (j > 0)) {
        break label334;
      }
    }
    label323:
    label329:
    label334:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "addExtraBtn showSendRaw:" + bool);
      }
      paramArrayList = PhotoUtils.b(paramArrayList);
      paramActionSheet.a(paramContext.getString(2131562937) + "(" + paramArrayList + ")", 5, false);
      if (!bool) {
        break label340;
      }
      paramArrayList = PhotoUtils.a(paramContext, i);
      paramActionSheet.a(paramContext.getString(2131562273) + "(" + paramArrayList + ")", 5, false);
      paramActionSheet.a(2131562851);
      return;
      k = 0;
      break;
      m = 0;
      break label155;
      paramInt = 0;
      break label162;
    }
    label340:
    if (paramInt != 0)
    {
      paramActionSheet.a(2131561476);
      return;
    }
    paramActionSheet.a(2131562851);
  }
  
  public static void a(String paramString1, Activity paramActivity, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramActivity, null);
    localActionSheet.a(2131561599, 5);
    localActionSheet.a(2131561896, 5);
    localActionSheet.d(2131561746);
    localActionSheet.a(new end(paramActivity, paramString1, localActionSheet, paramBoolean, paramString2, paramString3, paramString4));
    localActionSheet.show();
  }
  
  public static boolean a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    int j = 0;
    int i1 = 0;
    int k = 0;
    int m = 0;
    boolean bool1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      File localFile = new File(str);
      bool1 = PhotoUtils.a(localFile);
      int n = i1;
      if (bool1) {
        n = i1 + 1;
      }
      boolean bool2 = PhotoUtils.a(str);
      int i2 = k;
      if (bool2) {
        i2 = k + 1;
      }
      long l = localFile.length();
      int i3;
      int i4;
      if (l > a)
      {
        i3 = j + 1;
        i4 = i;
      }
      for (;;)
      {
        int i5 = (int)(m + l);
        m = i5;
        k = i2;
        i1 = n;
        j = i3;
        i = i4;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("_photo", 2, "addExtraBtn path:" + str + ",isGif:" + bool1 + ",isLarge:" + bool2 + ",len:" + l);
        m = i5;
        k = i2;
        i1 = n;
        j = i3;
        i = i4;
        break;
        i3 = j;
        i4 = i;
        if (l < b)
        {
          i4 = i + 1;
          i3 = j;
        }
      }
    }
    if (i1 == paramArrayList.size())
    {
      m = 1;
      if (k != paramArrayList.size()) {
        break label344;
      }
      k = 1;
      label282:
      if ((i >= paramArrayList.size()) || (m != 0) || (k != 0)) {
        break label350;
      }
      bool1 = true;
      label303:
      if ((!paramBoolean) || (j > 0) || (m != 0) || (k != 0)) {
        break label356;
      }
      i = 1;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if ((bool1) || (i != 0))
        {
          return true;
          m = 0;
          break;
          label344:
          k = 0;
          break label282;
          label350:
          bool1 = false;
          break label303;
          label356:
          i = 0;
          continue;
        }
        return false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils
 * JD-Core Version:    0.7.0.1
 */