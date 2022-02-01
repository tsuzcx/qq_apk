import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QzonePluginProxyActivity;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class ales
{
  public static int dsI = -16692;
  public static int dsJ = -16693;
  
  public static Drawable C(int paramInt)
  {
    Iterator localIterator = aler.ES.iterator();
    while (localIterator.hasNext())
    {
      alev localalev = (alev)localIterator.next();
      if (paramInt == localalev.id) {
        return localalev.fm.getConstantState().newDrawable();
      }
    }
    return null;
  }
  
  private static Class<?> a(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = QzonePluginProxyActivity.c(paramContext).loadClass(paramString);
          return localObject2;
        }
        catch (Throwable paramContext)
        {
          QLog.e("StickyNotePublishUtils", 1, "loadQZoneClass, failed to load class from qzone plugin class loader.");
        }
        localThrowable = localThrowable;
        QLog.e("StickyNotePublishUtils", 1, "loadQZoneClass, failed to load class from normal class loader.");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return localObject1;
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, String paramString, boolean paramBoolean, avys paramavys)
  {
    try
    {
      paramContext = a(paramContext, "com.qzone.publish.stickynote.StickyNotePublishProxy");
      if (paramContext != null) {
        paramContext.getMethod("modifyStickyNotePriv", new Class[] { Long.TYPE, Long.TYPE, String.class, Boolean.TYPE, avys.class }).invoke(null, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Boolean.valueOf(paramBoolean), paramavys });
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("StickyNotePublishUtils", 1, "modifyStickyNotePriv fail.", paramContext);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, avys paramavys)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickyNotePublishUtils", 0, String.format("publishStickyNote, hostUin=%s publishUin=%s isPublic=%s bgColor=%s bgVersion=%s vasExtendInfo=%s content=%s callback=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3, paramString4, paramavys }));
    }
    if ((paramContext == null) || (paramQQAppInterface == null) || (paramLong1 == 0L) || (paramLong2 == 0L) || (TextUtils.isEmpty(paramString4))) {
      QLog.e("StickyNotePublishUtils", 1, "publishStickyNote, params invalid.");
    }
    for (;;)
    {
      return;
      boolean bool1 = avsn.c(paramContext, paramQQAppInterface);
      boolean bool2 = avsn.d(paramContext, paramQQAppInterface);
      if ((!bool1) || (!bool2))
      {
        QLog.e("StickyNotePublishUtils", 1, String.format("publishStickyNote, init fail. initEnv=%s initServlet=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        return;
      }
      try
      {
        paramContext = a(paramContext, "com.qzone.publish.stickynote.StickyNotePublishProxy");
        if (paramContext != null)
        {
          paramContext.getMethod("publishStickyNote", new Class[] { Long.TYPE, Long.TYPE, Boolean.TYPE, String.class, String.class, String.class, String.class, avys.class }).invoke(null, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3, paramString4, paramavys });
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("StickyNotePublishUtils", 1, "publishStickyNote fail.", paramContext);
      }
    }
  }
  
  public static String d(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      if ((paramEditText.getText() instanceof aofr))
      {
        aofr localaofr = (aofr)paramEditText.getText();
        if (localaofr != null) {
          return localaofr.AE();
        }
      }
      if ((paramEditText != null) && (paramEditText.getEditableText() != null)) {
        return paramEditText.getEditableText().toString();
      }
    }
    return null;
  }
  
  public static String e(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      paramEditText = d(paramEditText);
      if (!TextUtils.isEmpty(paramEditText)) {
        return awif.sh(paramEditText.replaceAll(acfp.aE(2130968993), acfp.aE(2130968994)).replaceAll(acfp.aE(2130968992), "/MM"));
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ales
 * JD-Core Version:    0.7.0.1
 */