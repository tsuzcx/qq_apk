import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afdh
{
  private static afdf.a a;
  
  public static void HK(String paramString)
  {
    if (a == null) {
      a = afdf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    if (paramString.equals(a.bDd)) {
      afdl.iF("0X80094AB");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 += 1L;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str1 = paramQQAppInterface.getAccount();
    a = afdf.a(paramQQAppInterface);
    int k = afdg.x(localBaseApplication, str1);
    long l = afdg.e(localBaseApplication, str1);
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocGrayTipsUtils", 2, "addGrayTipMsg friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", uinType = " + paramInt + ", selfUin = " + str1 + ", time = " + paramLong1 + ", msgseq = " + paramLong2 + ", msgUid = " + paramLong3 + ", times = " + k + ", lastShowTime = " + l);
    }
    int i;
    if (AudioHelper.jY(10) == 1)
    {
      i = 1;
      j = i;
      if (i != 0)
      {
        AudioHelper.UA(acfp.m(2131715217) + a.bBw);
        if (TextUtils.isEmpty(a.bBw)) {
          break label483;
        }
      }
    }
    label483:
    for (int j = 1;; j = 0)
    {
      if (((a.mEnable) && (k < a.ctb) && (paramLong1 - l > 30L) && (!paramString2.equals(str1))) || (j != 0))
      {
        String str2 = a.bBw;
        String str3 = str2 + a.bDc;
        paramString1 = new ahwa(paramString1, paramString2, str3, paramInt, -5040, 3276801, paramLong1);
        paramString1.bLT = (String.valueOf(paramLong2) + "_" + String.valueOf(paramLong1));
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocGrayTipsUtils", 2, "addGrayTipMsg grayTipParam.grayTipKey = " + paramString1.bLT);
        }
        paramString2 = new Bundle();
        paramString2.putInt("key_action", 1);
        paramString2.putString("key_action_DATA", a.bDd);
        paramString1.addHightlightItem(str2.length(), str3.length(), paramString2);
        paramString2 = new MessageForUniteGrayTip();
        paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
        if (ahwb.a(paramQQAppInterface, paramString2))
        {
          afdg.s(localBaseApplication, str1, k + 1);
          afdg.k(localBaseApplication, str1, paramLong1);
          afdl.iF("0X80094AA");
        }
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdh
 * JD-Core Version:    0.7.0.1
 */