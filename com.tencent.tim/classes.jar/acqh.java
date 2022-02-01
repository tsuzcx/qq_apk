import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class acqh
{
  public static void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = getSharedPreferences(paramContext, paramString).edit();
      paramContext.putBoolean("show_unread_msg", paramBoolean);
      paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.i("HiddenChatUtil", 2, "setHiddenSession ac[" + paramString + "], open[" + paramBoolean + "]");
  }
  
  public static void b(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = getSharedPreferences(paramContext, paramString).edit();
      paramContext.putBoolean("show_video_msg", paramBoolean);
      paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.i("HiddenChatUtil", 2, "setVideoMsg ac[" + paramString + "], open[" + paramBoolean + "]");
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    boolean bool2;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      paramContext = getSharedPreferences(paramContext, paramString1);
      bool2 = paramContext.getBoolean("show_video_msg", false);
      bool1 = bool2;
      if (!bool2)
      {
        paramContext = paramContext.getString("KeyHiddenChatList", "");
        String str = paramString2 + "|" + paramInt + ";";
        if ((TextUtils.isEmpty(paramContext)) || (!paramContext.contains(str))) {
          bool2 = true;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("HiddenChatUtil", 2, String.format("isShowVideoMsg ac[%s], uin[%s], type[%s], show[%s], cur[%s], list[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool2), str, paramContext }));
          bool1 = bool2;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.i("HiddenChatUtil", 2, String.format("isShowVideoMsg ac[%s], uin[%s], type[%s], show[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool1) }));
    return bool1;
  }
  
  public static boolean e(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return true;
    }
    return getSharedPreferences(paramContext, paramString).getBoolean("show_unread_msg", true);
  }
  
  public static boolean f(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return true;
    }
    return getSharedPreferences(paramContext, paramString).getBoolean("show_video_msg", false);
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("PrefHiddenChat" + paramString, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqh
 * JD-Core Version:    0.7.0.1
 */