package com.tencent.hotpatch;

import acmg;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tnn;
import tnp;

public class PatchResolveForDalvik
{
  private static boolean aPO;
  public static int bCw = 0;
  
  public static void b(Context paramContext, tnp paramtnp)
  {
    Object localObject;
    if (!aPO)
    {
      if ((Build.CPU_ABI.toLowerCase(Locale.US).contains("x86")) || (SoLoadUtil.aFe())) {
        aPO = SoLoadUtil.a(paramContext, "qq_patch", 0, false, false);
      }
    }
    else
    {
      if (aPO) {
        break label132;
      }
      bCw = 609;
      localObject = acmg.a(BaseApplicationImpl.sApplication, 0);
      QLog.d("PatchLogTag", 1, "PatchResolveForDalvik tryResolvePatchClass unload as resolve lib load failed unloadResult=" + (String)localObject);
      if ("Success".equals(localObject))
      {
        tnh.bCv = 0;
        tnh.aJB = "";
      }
    }
    for (;;)
    {
      PatchReporter.reportPatchEvent(paramContext, "", "actPatchResolve", bCw, paramtnp.ot());
      return;
      aPO = SoLoadUtilNew.loadSoByName(paramContext, "qq_patch");
      break;
      label132:
      localObject = ((tnn)paramtnp.a()).bC();
      int i = e((List)localObject, ((ArrayList)localObject).size());
      bCw = i % 10 + 600;
      if (bCw != 600)
      {
        localObject = acmg.a(BaseApplicationImpl.sApplication, 0);
        QLog.d("PatchLogTag", 1, "PatchResolveForDalvik tryResolvePatchClass unload as resolve patch class failed unloadResult=" + (String)localObject + ", resolveResult=" + i);
        if ("Success".equals(localObject))
        {
          tnh.bCv = 0;
          tnh.aJB = "";
        }
      }
      else
      {
        QLog.d("PatchLogTag", 1, "PatchResolveForDalvik tryResolvePatchClass success");
      }
    }
  }
  
  public static int e(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() != paramInt) || (paramInt <= 0)) {
      return 1;
    }
    String[] arrayOfString = new String[paramInt];
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    if (i < paramInt)
    {
      Object localObject = (String)paramList.get(i);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return i * 10 + 1;
      }
      localObject = ((String)localObject).split("-");
      if ((localObject == null) || (localObject.length != 2)) {
        return i * 10 + 1;
      }
      int j;
      int k;
      try
      {
        j = Integer.parseInt(localObject[0]);
        k = Integer.parseInt(localObject[1]);
        if ((j <= 0) || (j > DexReleasor.sExtraDexes.length + 1) || (k < 0)) {
          return i * 10 + 1;
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return i * 10 + 1;
      }
      if (j == 1) {}
      for (localObject = "Lcom/tencent/common/app/BaseApplicationImpl;";; localObject = "L" + InjectUtils.getStartupClassName(j - 2) + ";")
      {
        arrayOfString[i] = localObject;
        arrayOfInt[i] = k;
        i += 1;
        break;
      }
    }
    return nativeResolvePatchClass(arrayOfString, arrayOfInt, paramInt);
  }
  
  public static native int nativeResolvePatchClass(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.hotpatch.PatchResolveForDalvik
 * JD-Core Version:    0.7.0.1
 */