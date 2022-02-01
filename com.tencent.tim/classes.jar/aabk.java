import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import org.json.JSONObject;

public class aabk
{
  public static String a(int paramInt, avox.a parama, aabj paramaabj, String paramString)
  {
    int i = 2;
    if (parama != null)
    {
      int j = avor.c(parama.bus_type, 2);
      i = j;
      if (!aqmr.isEmpty(parama.biz_params)) {
        try
        {
          String str = new JSONObject(parama.biz_params).optString("memo", "");
          parama = str;
          if (bS(str) >= 18) {
            parama = str.substring(0, 18) + "...";
          }
          boolean bool = aqmr.isEmpty(parama);
          i = j;
          if (!bool) {
            return parama;
          }
        }
        catch (Exception parama)
        {
          parama.printStackTrace();
          i = j;
        }
      }
    }
    return paramaabj.c(paramInt, i, paramString);
  }
  
  public static int an(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 == 1)
    {
      paramInt1 = i;
      if (paramInt2 == 1) {
        paramInt1 = 0;
      }
      return paramInt1;
    }
    return RedPacketManager.getEnterType(paramInt1);
  }
  
  public static int bS(String paramString)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString)) {
      i = paramString.replaceAll("[\\u4e00-\\u9fa5]", "aa").length() - paramString.length();
    }
    return i;
  }
  
  public static String c(EditText paramEditText)
  {
    String str = paramEditText.getText().toString();
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = paramEditText.getHint();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = paramEditText.getResources().getString(2131699043);
      }
    }
    else
    {
      return localObject;
    }
    return ((CharSequence)localObject).toString();
  }
  
  public static String hY(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replaceAll("[\\u4e00-\\u9fa5,，。、 ]", "");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabk
 * JD-Core Version:    0.7.0.1
 */