import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import mqq.app.AppRuntime.Status;

public class aktm
{
  public static void L(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str1;
    if (paramQQAppInterface != null)
    {
      if (!paramBoolean) {
        break label41;
      }
      str1 = "0X8009DDE";
      if (!paramBoolean) {
        break label47;
      }
    }
    label41:
    label47:
    for (String str2 = "0X8009DDE";; str2 = "0X8009DDF")
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      str1 = "0X8009DDF";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong)
  {
    int i;
    if ((paramQQAppInterface != null) && (paramStatus != null)) {
      switch (aktn.mk[paramStatus.ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 1)
      {
        j = i;
        if (paramLong > 0L) {
          j = (int)paramLong;
        }
      }
      if (j != 0) {
        anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009DDB", "0X8009DDB", j, 0, "", "", "", "");
      }
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong, AutoReplyText paramAutoReplyText)
  {
    if ((paramQQAppInterface != null) && (paramAutoReplyText != null) && (aktk.a(paramStatus)))
    {
      int i = 1;
      if (paramAutoReplyText.getTextId() == 2147483647) {
        i = 2;
      }
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009DDC", "0X8009DDC", i, 0, "", "", "", "");
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong)
  {
    int i = -1;
    switch (aktn.mk[paramStatus.ordinal()])
    {
    }
    for (;;)
    {
      int j = i;
      if (i == 1)
      {
        j = i;
        if (paramLong > 0L) {
          j = (int)paramLong;
        }
      }
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009DE0", "0X8009DE0", j, 0, "", "", "", "");
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
  
  public static void dA(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009DDA", "0X8009DDA", 0, 0, "", "", "", "");
    }
  }
  
  public static void dB(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009DDD", "0X8009DDD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktm
 * JD-Core Version:    0.7.0.1
 */