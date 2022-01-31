package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import eqf;
import eqg;
import eqi;
import eqj;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class TroopFileError
{
  public static final int A = 305;
  public static final int B = 306;
  public static final int C = 307;
  public static final int D = 308;
  public static final int E = 309;
  public static final int F = 400;
  public static final int G = 401;
  public static final int H = 402;
  public static final int I = 403;
  public static final int J = 500;
  public static final int K = 501;
  public static final int L = 502;
  public static final int M = 503;
  public static final int N = 504;
  public static final int O = 505;
  public static final int P = 600;
  public static final int Q = 601;
  public static final int R = 602;
  public static final int S = 603;
  public static final int T = 700;
  public static final int U = 701;
  public static final int V = 702;
  public static final int W = 703;
  public static final int X = 704;
  public static final int Y = 705;
  public static final int Z = 706;
  public static final int a = 0;
  public static WeakReference a = null;
  public static final int b = 1;
  public static final int c = 100;
  public static final int d = 101;
  public static final int e = 102;
  public static final int f = 103;
  public static final int g = 104;
  public static final int h = 105;
  public static final int i = 106;
  public static final int j = 107;
  public static final int k = 200;
  public static final int l = 201;
  public static final int m = 202;
  public static final int n = 203;
  public static final int o = 204;
  public static final int p = 205;
  public static final int q = 206;
  public static final int r = 207;
  public static final int s = 208;
  public static final int t = 209;
  public static final int u = 210;
  public static final int v = 300;
  public static final int w = 301;
  public static final int x = 302;
  public static final int y = 303;
  public static final int z = 304;
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getApplication().getResources().getString(paramInt);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramQQAppInterface, paramInt), paramVarArgs);
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    eqj localeqj = new eqj(paramLong);
    DialogUtil.a(paramContext, 230, paramContext.getResources().getString(2131362282), paramContext.getResources().getString(2131362283), 2131362217, 2131362218, localeqj, localeqj).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new eqg(paramContext, paramString1, paramString2, paramInt));
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.b(paramContext, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    localQQCustomDialog.setPositiveButton(paramContext.getResources().getString(paramInt), new eqi());
    localQQCustomDialog.show();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i1;
    try
    {
      i1 = paramContext.getResources().getDimensionPixelSize(2131492887);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new eqf(paramBoolean, paramContext, paramString, i1));
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(paramContext, 2, paramString, 0).b(i1);
      return;
    }
    QQToast.a(paramContext, 2130838006, paramString, 0).b(i1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    a(paramQQAppInterface, paramLong, 7, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, null, paramInt1, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramInt2 == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(19);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new TroopFileError.SimpleErrorInfo(paramString, paramLong, paramInt1, paramInt2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    if ((paramQQAppInterface == null) || (paramSimpleErrorInfo == null) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(19);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramSimpleErrorInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.c((BusinessObserver)a.get());
      a = null;
    }
    a = new WeakReference(paramTroopFileErrorObserver);
    paramQQAppInterface.a(paramTroopFileErrorObserver);
  }
  
  public static void a(TroopFileError.SimpleErrorInfo paramSimpleErrorInfo, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramSimpleErrorInfo == null) || (paramContext == null)) {
      return;
    }
    String str3 = TroopFileUtils.a(paramSimpleErrorInfo.jdField_a_of_type_JavaLangString);
    String str2 = null;
    String str1 = null;
    int i2 = 2131362802;
    int i1 = 0;
    switch (paramSimpleErrorInfo.jdField_a_of_type_Int)
    {
    default: 
      paramQQAppInterface = str2;
    }
    for (;;)
    {
      if (i1 == 0) {
        break label1153;
      }
      if ((a == null) || (a.get() == null) || (((TroopFileError.TroopFileErrorObserver)a.get()).jdField_a_of_type_Int == paramSimpleErrorInfo.jdField_a_of_type_Int)) {
        break;
      }
      ((TroopFileError.TroopFileErrorObserver)a.get()).jdField_a_of_type_Int = paramSimpleErrorInfo.jdField_a_of_type_Int;
      a(paramContext, str1, paramQQAppInterface, i2);
      return;
      str1 = a(paramQQAppInterface, 2131362255);
      paramQQAppInterface = a(paramQQAppInterface, 2131362256);
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362257);
      continue;
      a(paramContext, paramLong);
      paramQQAppInterface = str2;
      continue;
      str1 = a(paramQQAppInterface, 2131362258);
      paramQQAppInterface = a(paramQQAppInterface, 2131362259, new Object[] { str3 });
      i1 = 1;
      continue;
      str1 = a(paramQQAppInterface, 2131362260);
      paramQQAppInterface = a(paramQQAppInterface, 2131362261, new Object[] { str3 });
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362262);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362263);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362267);
      continue;
      str1 = a(paramQQAppInterface, 2131362260);
      paramQQAppInterface = a(paramQQAppInterface, 2131362264, new Object[] { str3 });
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362265);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362266);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362281);
      continue;
      str1 = a(paramQQAppInterface, 2131362295);
      str2 = a(paramQQAppInterface, 2131362296);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i1 = 1;
      i2 = 2131362294;
      paramQQAppInterface = str2;
      continue;
      str1 = a(paramQQAppInterface, 2131362270);
      paramQQAppInterface = a(paramQQAppInterface, 2131362268, new Object[] { str3 });
      i1 = 1;
      continue;
      str1 = a(paramQQAppInterface, 2131362260);
      paramQQAppInterface = a(paramQQAppInterface, 2131362269, new Object[] { str3 });
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362271, new Object[] { str3 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362272, new Object[] { str3 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362273, new Object[] { str3 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362256);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362274);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362275);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362276, new Object[] { str3 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362277, new Object[] { str3 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131362278, new Object[] { str3 });
      continue;
      if (TroopFileInfo.FileStatus.a(paramSimpleErrorInfo.jdField_b_of_type_Int))
      {
        paramQQAppInterface = a(paramQQAppInterface, 2131362279, new Object[] { str3 });
      }
      else
      {
        paramQQAppInterface = a(paramQQAppInterface, 2131362280, new Object[] { str3 });
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362281);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362286);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362287);
        continue;
        a(paramContext, a(paramQQAppInterface, 2131362288, new Object[] { str3 }), true);
        return;
        paramQQAppInterface = a(paramQQAppInterface, 2131362289);
        continue;
        paramQQAppInterface = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362290);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362291);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362292);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362293);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131362297);
      }
    }
    label1153:
    a(paramContext, paramQQAppInterface);
  }
  
  public static boolean a(TroopFileInfo paramTroopFileInfo, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramTroopFileInfo == null) || (paramContext == null)) {
      return false;
    }
    a(new TroopFileError.SimpleErrorInfo(paramTroopFileInfo.c, paramLong, paramTroopFileInfo.g, paramTroopFileInfo.h), paramLong, paramQQAppInterface, paramContext);
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    paramQQAppInterface.c(paramTroopFileErrorObserver);
    if ((a != null) && (a.get() == paramTroopFileErrorObserver)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError
 * JD-Core Version:    0.7.0.1
 */