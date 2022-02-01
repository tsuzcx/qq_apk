import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class ajnk
{
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt, String paramString)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      paramQQAppInterface = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClickWebLink id:" + paramQQAppInterface + " willDowngradeSoon:" + paramMessageForUniteGrayTip + " url:" + paramString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ajoh paramajoh)
  {
    if (paramajoh != null)
    {
      anot.a(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", ajnu.i(paramajoh.type, paramajoh.ada), (int)(paramajoh.type * 10L + paramajoh.ada), 0, "", "", "", "");
      switch ((int)paramajoh.type)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramajoh, paramQQAppInterface, "C2C_click");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      anot.a(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ajoh paramajoh1, ajoh paramajoh2)
  {
    if (paramajoh1 != null) {
      anot.a(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", ajnu.i(paramajoh1.type, paramajoh1.ada), (int)(paramajoh1.type * 10L + paramajoh1.ada), 0, "", "", "", "");
    }
    if (paramajoh2 != null) {
      anot.a(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", ajnu.i(paramajoh2.type, paramajoh2.ada), (int)(paramajoh2.type * 10L + paramajoh2.ada), 0, "", "", "", "");
    }
    anot.a(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str1))
      {
        long l1 = ajnu.ap(str1);
        long l2 = ajnu.ao(str1);
        if ((ajnu.co(l1)) && (l2 >= 0L)) {
          anot.a(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E4", ajnu.i(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipExposure id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
  
  public static boolean bd(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str1))
      {
        long l1 = ajnu.ap(str1);
        long l2 = ajnu.ao(str1);
        if ((ajnu.co(l1)) && (l2 >= 0L)) {
          anot.a(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E5", ajnu.i(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
  
  public static void dt(QQAppInterface paramQQAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnk
 * JD-Core Version:    0.7.0.1
 */