import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.remind.widget.IosTimepicker.a;
import com.tencent.mobileqq.remind.widget.IosTimepicker.b;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class aluz
{
  public static String FALSE;
  private static String TAG = "remind";
  public static String TRUE = "1";
  private static IosTimepicker.a a = new alva();
  public static boolean czC;
  
  static
  {
    FALSE = "0";
    czC = true;
  }
  
  public static int a(Context paramContext, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, int[] paramArrayOfInt)
  {
    return -9;
  }
  
  public static void a(Context paramContext, long paramLong, IosTimepicker.b paramb, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    ausj localausj;
    if (czC)
    {
      czC = false;
      localausj = ausj.d(paramContext);
      ((DispatchActionMoveScrollView)localausj.findViewById(2131362014)).cZW = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131563350, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      alux localalux = new alux(paramContext, 25);
      aluy localaluy1 = new aluy(paramContext, alve.gp, 25);
      aluy localaluy2 = new aluy(paramContext, alve.gq, 25);
      int i = (int)alve.Q(paramLong);
      int j = alve.W(paramLong);
      int k = alve.X(paramLong);
      IosTimepicker.a locala = a;
      ((IosTimepicker)localObject).a(paramContext, localausj, paramb, null, new BaseAdapter[] { localalux, localaluy1, localaluy2 }, new int[] { i, j, k }, locala);
      if (Build.VERSION.SDK_INT >= 11) {
        localausj.getWindow().setFlags(16777216, 16777216);
      }
      localausj.setActionContentView((View)localObject, null);
      localausj.setOnDismissListener(new alvb((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localausj.show();
      return;
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, paramContext.getMessage());
    }
  }
  
  public static Long getLong(String paramString)
  {
    long l2 = new Date().getTime() / 1000L;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      return Long.valueOf(l1);
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "getLong error: " + paramString.getMessage());
          paramString.printStackTrace();
          l1 = l2;
        }
      }
    }
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      return paramString1;
    }
    catch (JSONException paramString2)
    {
      do
      {
        paramString1 = str;
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "getString from json error:" + paramString2.getMessage());
    }
    return "";
  }
  
  public static boolean ox(String paramString)
  {
    return paramString.equalsIgnoreCase(TRUE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aluz
 * JD-Core Version:    0.7.0.1
 */