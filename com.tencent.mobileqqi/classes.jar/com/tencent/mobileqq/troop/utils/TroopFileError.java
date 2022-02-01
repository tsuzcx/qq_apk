package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import gxo;
import gxp;
import gxr;
import gxs;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class TroopFileError
{
  public static final int A = 306;
  public static final int B = 307;
  public static final int C = 308;
  public static final int D = 309;
  public static final int E = 400;
  public static final int F = 401;
  public static final int G = 402;
  public static final int H = 403;
  public static final int I = 500;
  public static final int J = 501;
  public static final int K = 502;
  public static final int L = 503;
  public static final int M = 504;
  public static final int N = 505;
  public static final int O = 600;
  public static final int P = 601;
  public static final int Q = 602;
  public static final int R = 603;
  public static final int S = 700;
  public static final int T = 701;
  public static final int U = 702;
  public static final int V = 703;
  public static final int W = 704;
  public static final int X = 705;
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
  public static final int u = 300;
  public static final int v = 301;
  public static final int w = 302;
  public static final int x = 303;
  public static final int y = 304;
  public static final int z = 305;
  
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
    gxs localgxs = new gxs(paramLong);
    DialogUtil.a(paramContext, 230, paramContext.getResources().getString(2131560375), paramContext.getResources().getString(2131560376), 2131560315, 2131560316, localgxs, localgxs).show();
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
      new Handler(Looper.getMainLooper()).post(new gxp(paramContext, paramString1, paramString2, paramInt));
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.b(paramContext, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    localQQCustomDialog.setPositiveButton(paramContext.getResources().getString(paramInt), new gxr());
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
      i1 = paramContext.getResources().getDimensionPixelSize(2131427376);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new gxo(paramBoolean, paramContext, paramString, i1));
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
    QQToast.a(paramContext, 2130837961, paramString, 0).b(i1);
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
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(21);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new TroopFileError.SimpleErrorInfo(paramString, paramLong, paramInt1, paramInt2));
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
    int i1 = 1;
    if ((paramSimpleErrorInfo == null) || (paramContext == null)) {
      return;
    }
    String str = TroopFileUtils.a(paramSimpleErrorInfo.jdField_a_of_type_JavaLangString);
    switch (paramSimpleErrorInfo.jdField_a_of_type_Int)
    {
    default: 
      i1 = 0;
      paramSimpleErrorInfo = null;
      paramQQAppInterface = null;
    }
    while (i1 != 0)
    {
      a(paramContext, paramSimpleErrorInfo, paramQQAppInterface, 2131562539);
      return;
      paramSimpleErrorInfo = a(paramQQAppInterface, 2131560348);
      paramQQAppInterface = a(paramQQAppInterface, 2131560349);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560350);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      a(paramContext, paramLong);
      i1 = 0;
      paramSimpleErrorInfo = null;
      paramQQAppInterface = null;
      continue;
      paramSimpleErrorInfo = a(paramQQAppInterface, 2131560351);
      paramQQAppInterface = a(paramQQAppInterface, 2131560352, new Object[] { str });
      continue;
      paramSimpleErrorInfo = a(paramQQAppInterface, 2131560353);
      paramQQAppInterface = a(paramQQAppInterface, 2131560354, new Object[] { str });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560355);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560356);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560360);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramSimpleErrorInfo = a(paramQQAppInterface, 2131560353);
      paramQQAppInterface = a(paramQQAppInterface, 2131560357, new Object[] { str });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560358);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560359);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560374);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramSimpleErrorInfo = a(paramQQAppInterface, 2131560363);
      paramQQAppInterface = a(paramQQAppInterface, 2131560361, new Object[] { str });
      continue;
      paramSimpleErrorInfo = a(paramQQAppInterface, 2131560353);
      paramQQAppInterface = a(paramQQAppInterface, 2131560362, new Object[] { str });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560364, new Object[] { str });
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560365, new Object[] { str });
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560366, new Object[] { str });
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560349);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560367);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560368);
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560369, new Object[] { str });
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560370, new Object[] { str });
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131560371, new Object[] { str });
      paramSimpleErrorInfo = null;
      i1 = 0;
      continue;
      if (TroopFileInfo.FileStatus.a(paramSimpleErrorInfo.jdField_b_of_type_Int))
      {
        paramQQAppInterface = a(paramQQAppInterface, 2131560372, new Object[] { str });
        paramSimpleErrorInfo = null;
        i1 = 0;
      }
      else
      {
        paramQQAppInterface = a(paramQQAppInterface, 2131560373, new Object[] { str });
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131560374);
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131560379);
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131560380);
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        a(paramContext, a(paramQQAppInterface, 2131560381, new Object[] { str }), true);
        return;
        paramQQAppInterface = a(paramQQAppInterface, 2131560382);
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131560383);
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131560384);
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131560385);
        paramSimpleErrorInfo = null;
        i1 = 0;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131560386);
        paramSimpleErrorInfo = null;
        i1 = 0;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError
 * JD-Core Version:    0.7.0.1
 */