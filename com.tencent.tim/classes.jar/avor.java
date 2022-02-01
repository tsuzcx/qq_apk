import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;

public class avor
{
  private static long iu;
  private static DecimalFormat j = new DecimalFormat("#0.00");
  
  static
  {
    j.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, WtTicketPromise paramWtTicketPromise)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramWtTicketPromise = (TicketManager)paramQQAppInterface.getManager(2);
    if (paramWtTicketPromise != null) {}
    for (paramQQAppInterface = paramWtTicketPromise.getPskey(paramQQAppInterface.getCurrentAccountUin(), paramString);; paramQQAppInterface = "") {
      return paramQQAppInterface;
    }
  }
  
  public static String a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1 = (String)paramMap.get(str2);
        if (QLog.isColorLevel()) {
          QLog.i("QwUtils", 2, "appendKV2Schema key: " + str2 + " value: " + str1);
        }
        paramString = str1;
        if (paramBoolean) {}
        try
        {
          paramString = URLEncoder.encode(str1);
          localStringBuffer.append("&").append(String.format("%s=%s", new Object[] { str2, paramString }));
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            QLog.i("QwUtils", 2, "error encode key: " + str2 + " value: " + str1);
            paramString = str1;
          }
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(Ticket paramTicket, String paramString)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null) && (paramTicket._pskey_map.get(paramString) != null))
    {
      QLog.i("QwUtils", 2, "preGetKey. PSk Done. psk!=null");
      return new String((byte[])paramTicket._pskey_map.get(paramString));
    }
    QLog.i("QwUtils", 2, "preGetKey error from ticket");
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, avor.a parama)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString, new avos(parama, paramString));
    if (!aqmr.isEmpty(paramQQAppInterface))
    {
      if (parama != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletUtils", 2, "get pskey syn success!");
        }
        parama.ansyBack(0, new String[] { paramQQAppInterface });
      }
      return;
    }
    QLog.e("QWalletUtils", 1, "get pskey syn. PSk is empty!");
  }
  
  public static String aB(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = j.format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  public static void bI(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
  }
  
  public static int c(Object paramObject, int paramInt)
  {
    paramObject = paramObject + "";
    int i = paramInt;
    if (!TextUtils.isEmpty(paramObject)) {}
    try
    {
      i = Integer.valueOf(paramObject).intValue();
      return i;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return paramInt;
  }
  
  public static String c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
    throws Exception
  {
    if (paramInt < 0) {
      return "0";
    }
    paramString1 = new BigDecimal(paramString1);
    paramString2 = new BigDecimal(paramString2);
    if (paramBoolean) {
      return new DecimalFormat("#0.00").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
    }
    return new DecimalFormat("#0.##").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
  }
  
  public static void dm(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QwUtils", 2, "startQQBrowserActivity url=" + paramString);
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramContext.startActivity(localIntent);
  }
  
  public static float h(String paramString)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0.0F;
  }
  
  public static String hX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(aB(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public static String i(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      try
      {
        String str = c(paramString, "100", 2, paramBoolean);
        return str;
      }
      catch (Exception localException) {}
    }
    try
    {
      localException.printStackTrace();
      try
      {
        paramString = rL(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "0";
      }
      if (paramInt == 1) {
        return new DecimalFormat("#0.00").format(paramString);
      }
      return "";
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean qH()
  {
    long l = System.currentTimeMillis();
    if (iu + 1000L > l) {
      return true;
    }
    iu = l;
    return false;
  }
  
  public static String rL(String paramString)
    throws Exception
  {
    if ((paramString == null) || (!paramString.matches("\\-?[0-9]+"))) {
      throw new Exception("金额格式有误");
    }
    int i;
    if (paramString.charAt(0) == '-')
    {
      paramString = paramString.substring(1);
      i = 1;
    }
    for (;;)
    {
      if ((paramString.startsWith("0")) && (paramString.length() > 1))
      {
        paramString = paramString.substring(1);
      }
      else
      {
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramString.length() == 1) {
          localStringBuffer.append("0.0").append(paramString);
        }
        while (i == 1)
        {
          return "-" + localStringBuffer.toString();
          if (paramString.length() == 2) {
            localStringBuffer.append("0.").append(paramString);
          } else {
            localStringBuffer.append(paramString.substring(0, paramString.length() - 2)).append(".").append(paramString.substring(paramString.length() - 2));
          }
        }
        return localStringBuffer.toString();
        i = 0;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ansyBack(int paramInt, String... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avor
 * JD-Core Version:    0.7.0.1
 */