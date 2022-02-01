import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc.1;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc.2;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class abrb
{
  private static final Set<String> bH = new SpriteCommFunc.1();
  
  public static void F(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopAllTask]", ",from:", paramString });
    }
    if (!abrj.U(paramQQAppInterface)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("type", 0);
      paramQQAppInterface = abrj.a(paramQQAppInterface);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null))
      {
        QLog.e("cmshow_scripted_SpriteCommFunc", 1, "[stopAllTask], spriteContext or getSurfaceView is null.");
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("cmshow_scripted_SpriteCommFunc", 1, "[stopAllTask],", paramQQAppInterface);
      return;
    }
    ApolloCmdChannel.getChannel(paramQQAppInterface.getApp()).callbackFromRequest(paramQQAppInterface.a().getLuaState(), 0, "sc.stop_all_task.local", paramString.toString());
  }
  
  public static boolean S(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = abrj.T(paramQQAppInterface);
    boolean bool2 = abrj.S(paramQQAppInterface);
    return (bool1) || (bool2);
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopTaskByMsg], msgId", Long.valueOf(paramLong), ",from:", paramString });
    }
    if (!abrj.U(paramQQAppInterface)) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = abrj.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramString = paramQQAppInterface.a(paramLong);
    if (paramString == null)
    {
      QLog.w("cmshow_scripted_SpriteCommFunc", 2, "task NOT exist, msgId:" + paramLong);
      return;
    }
    ThreadManager.post(new SpriteCommFunc.2(paramQQAppInterface, paramString), 5, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[showOrHideSprite]", ",from:", paramString });
    }
    if (!abrj.U(paramQQAppInterface)) {}
    do
    {
      abrg localabrg;
      do
      {
        do
        {
          return;
        } while (!bH.contains(paramString));
        localabrg = abrj.a(paramQQAppInterface);
      } while (localabrg == null);
      abrc localabrc = abrj.a(paramQQAppInterface);
      if (localabrc != null) {
        localabrc.bw(paramString, paramBoolean);
      }
      if (abrj.S(paramQQAppInterface))
      {
        QLog.i("cmshow_scripted_SpriteCommFunc", 1, "showOrHideSprite double should hide");
        return;
      }
      paramQQAppInterface = localabrg.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.j(paramBoolean, false, paramString);
  }
  
  public static boolean v(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[isSpriteActive]", ",from:", paramString });
    }
    if (!abrj.U(paramQQAppInterface)) {}
    do
    {
      do
      {
        return false;
        paramQQAppInterface = abrj.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.Zg();
  }
  
  public static boolean w(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    do
    {
      return false;
      paramQQAppInterface = abrj.a(paramQQAppInterface);
    } while ((paramQQAppInterface == null) || (!paramQQAppInterface.jy(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrb
 * JD-Core Version:    0.7.0.1
 */