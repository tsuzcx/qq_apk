import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.DcReportUtil.1;
import com.tencent.mobileqq.statistics.DcReportUtil.2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class annx
{
  private static AtomicLong I = new AtomicLong(0L);
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str = "${count_unknown}|" + paramString2;
    paramString2 = str;
    if (!paramBoolean)
    {
      long l = I.incrementAndGet();
      paramString2 = "${report_seq_prefix}" + l + "|" + str;
    }
    if (paramQQAppInterface == null)
    {
      ThreadManager.post(new DcReportUtil.1(paramString1, paramString2), 5, null, true);
      return;
    }
    m(paramQQAppInterface, paramString1, paramString2, 1);
  }
  
  private static void m(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      anot localanot = paramQQAppInterface.a();
      if (localanot != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.getCurrentAccountUin());
        }
        localanot.U(paramString1, str, paramInt);
      }
    }
  }
  
  public static void o(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DcReportUtil", 2, "reportDCEvent tag or detail is null: " + paramString1 + ", " + paramString2);
      }
      return;
    }
    if (paramQQAppInterface == null)
    {
      ThreadManager.post(new DcReportUtil.2(paramString1, paramString2), 5, null, true);
      return;
    }
    m(paramQQAppInterface, paramString1, paramString2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annx
 * JD-Core Version:    0.7.0.1
 */