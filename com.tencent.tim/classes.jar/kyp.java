import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kyp
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public static String TAG = "CommentFamilyConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d(TAG, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    paramString = kye.i(paramString);
    Object localObject = paramString.keySet();
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        localObject = ((Set)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = (String)paramString.get(str1);
          if (TextUtils.equals(str1, "rij_comment_family_entrance_switch")) {
            awit.acH(Integer.parseInt(str2));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      if (TextUtils.equals(str1, "rij_small_zhitiao_entrance_switch")) {
        awit.H("readinjjoy_notes_config", Integer.valueOf(Integer.parseInt(str2)));
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    awit.acH(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyp
 * JD-Core Version:    0.7.0.1
 */