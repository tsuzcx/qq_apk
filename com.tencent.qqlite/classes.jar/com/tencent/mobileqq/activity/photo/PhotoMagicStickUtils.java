package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoMagicStickUtils
{
  private static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  private static int b = 0;
  
  static
  {
    a = 19922944;
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
      paramActionSheet.a(paramContext.getString(2131363943) + "(" + paramArrayList + ")", 5, false);
      if (!bool) {
        break label340;
      }
      paramArrayList = PhotoUtils.a(paramContext, i);
      paramActionSheet.a(paramContext.getString(2131363944) + "(" + paramArrayList + ")", 5, false);
      paramActionSheet.a(2131363953);
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
      paramActionSheet.a(2131363954);
      return;
    }
    paramActionSheet.a(2131363953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils
 * JD-Core Version:    0.7.0.1
 */