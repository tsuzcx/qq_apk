import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;

public class abkw
{
  public static abhh.f a(QQAppInterface paramQQAppInterface, String paramString, ApolloBaseInfo paramApolloBaseInfo, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloDrawerInfoManager", 1, "checkDrawerRoleDressInfo param err");
      return null;
    }
    int i = 0;
    int[] arrayOfInt = null;
    int j = 0;
    abhh.f localf = null;
    int k = abhh.h(paramQQAppInterface, paramString);
    int m = paramApolloBaseInfo.apolloStatus;
    abkd localabkd = paramApolloBaseInfo.getApolloDress();
    if (localabkd != null)
    {
      i = localabkd.roleId;
      arrayOfInt = localabkd.M();
    }
    localabkd = paramApolloBaseInfo.getApolloDress3D();
    paramApolloBaseInfo = localf;
    if (localabkd != null)
    {
      j = localabkd.roleId;
      paramApolloBaseInfo = localabkd.M();
    }
    localf = new abhh.f();
    localf.roleId = i;
    localf.dressIds = arrayOfInt;
    localf.coO = j;
    localf.jN = paramApolloBaseInfo;
    localf.coP = m;
    localf.coQ = k;
    localf.coR = abrj.gf(paramInt);
    boolean bool;
    if (m != 1)
    {
      bool = true;
      QLog.e("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo apollo not open from:", Integer.valueOf(paramInt), ",apolloFeatureFlag:", Integer.valueOf(m) });
      abwh.a(localf.coR, 10, 101, new Object[] { "apollo not open, flag:", Integer.valueOf(m) });
    }
    for (;;)
    {
      localf.bDa = bool;
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.d("ApolloDrawerInfoManager", 2, new Object[] { "checkDrawerRoleDressInfo from:", Integer.valueOf(paramInt), ",result:", localf.toString() });
      }
      abwh.b(localf.coR, 10, new Object[] { localf.toString() });
      return localf;
      if ((k == 1) && ((i <= 0) || (arrayOfInt == null) || (arrayOfInt.length <= 0) || ((i > 0) && (!abvg.a(paramString, i, arrayOfInt, paramQQAppInterface)))))
      {
        bool = true;
        QLog.e("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo basic not ready, from:", Integer.valueOf(paramInt), ",result:", localf.toString() });
        abwh.a(localf.coR, 10, 111, new Object[] { "basic not ready:" + localf.toString() });
      }
      else
      {
        if ((k == 2) && ((j <= 0) || (paramApolloBaseInfo == null) || (paramApolloBaseInfo.length <= 0) || ((j > abxi.ctt) && (!abvg.a(paramString, j, paramApolloBaseInfo, paramQQAppInterface)))))
        {
          QLog.d("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo 3D not ready, from:", Integer.valueOf(paramInt), ",result:", localf.toString() });
          abwh.b(localf.coR, 10, new Object[] { "3D role/dress not ready but show basic" });
        }
        if (!ApolloEngine.BJ())
        {
          QLog.d("ApolloDrawerInfoManager", 1, "so is not ready");
          abwh.a(localf.coR, 10, 102, new Object[] { "so not ready" });
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  public static int c(int paramInt, long paramLong)
  {
    int i = paramInt * 400 / 540;
    if (i <= paramLong * 0.7D)
    {
      paramInt = i;
      if (i > 0) {}
    }
    else
    {
      paramInt = (int)(paramLong * 0.7D);
    }
    return paramInt;
  }
  
  public static int fW(int paramInt)
  {
    if (hO(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public static int fX(int paramInt)
  {
    if (hO(paramInt)) {
      return 3;
    }
    return 2;
  }
  
  public static boolean hO(int paramInt)
  {
    return paramInt == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkw
 * JD-Core Version:    0.7.0.1
 */