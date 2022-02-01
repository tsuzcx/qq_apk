import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abcx
{
  private static abcx a;
  
  private boolean O(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.b().f("2658655094", 1008);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      return abdi.T((ChatMessage)paramQQAppInterface.get(paramQQAppInterface.size() - 1));
    }
    return false;
  }
  
  public static abcx a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new abcx();
      }
      return a;
    }
    finally {}
  }
  
  public void E(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Object paramObject)
  {
    String str2 = "";
    String str1 = str2;
    if (paramObject != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(String.valueOf(paramObject))) {
        str1 = "|" + paramObject;
      }
    }
    paramString = System.currentTimeMillis() + "|" + "QQWeather" + "|" + "QQWeather_native" + "|" + paramString + "|" + "android" + str1;
    annx.o(paramQQAppInterface, "dc04698", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherDCReportHelper", 2, "reportWeather : " + paramString);
    }
  }
  
  public void bR(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((abdh.a.XS()) && (O(paramQQAppInterface)))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
    }
    label38:
    for (String str = "new_folder_weather_expose";; str = "folder_weather_expose")
    {
      E(paramQQAppInterface, str);
      return;
      i = 0;
      break;
    }
  }
  
  public void bS(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((abdh.a.XS()) && (O(paramQQAppInterface)))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
    }
    label38:
    for (String str = "new_folder_weather_click";; str = "folder_weather_click")
    {
      E(paramQQAppInterface, str);
      return;
      i = 0;
      break;
    }
  }
  
  public void f(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      if (!abdi.T(paramMessageRecord)) {
        break label24;
      }
    }
    label24:
    for (paramMessageRecord = "new_folder_weather_arrive";; paramMessageRecord = "folder_weather_arrive")
    {
      E(paramQQAppInterface, paramMessageRecord);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcx
 * JD-Core Version:    0.7.0.1
 */