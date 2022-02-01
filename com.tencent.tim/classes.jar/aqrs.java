import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class aqrs
{
  public static boolean a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    boolean bool = true;
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VasUserData", 2, "set, key=" + paramString1 + ", value=" + paramString2);
    }
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1))) {
      QLog.d("VasUserData", 1, "get, app and key MUST NOT be null, context=" + paramAppRuntime + ", key=" + paramString1);
    }
    Context localContext;
    do
    {
      return false;
      localContext = paramAppRuntime.getApplication().getApplicationContext();
    } while (localContext == null);
    Uri localUri = Uri.parse("content://tim.friendlist/individuationUserData/" + paramAppRuntime.getAccount());
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    paramAppRuntime = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramAppRuntime = "";
    }
    localContentValues.put("value", paramAppRuntime);
    int i = localContext.getContentResolver().update(localUri, localContentValues, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("VasUserData", 2, "[Performance] set, duration=" + (SystemClock.uptimeMillis() - l) + ", result=" + i);
    }
    if (i >= 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static String d(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VasUserData", 2, "get, key=" + paramString);
    }
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("VasUserData", 1, "get, app and key MUST NOT be null, context=" + paramAppRuntime + ", key=" + paramString);
    }
    do
    {
      Context localContext;
      do
      {
        return localObject1;
        localContext = paramAppRuntime.getApplication().getApplicationContext();
      } while (localContext == null);
      paramAppRuntime = Uri.parse("content://tim.friendlist/individuationUserData/" + paramAppRuntime.getAccount());
      paramString = alld.query(localContext.getContentResolver(), paramAppRuntime, null, "key=?", new String[] { paramString }, null);
      paramAppRuntime = localObject2;
      if (paramString != null)
      {
        paramAppRuntime = localObject2;
        if (paramString.moveToFirst()) {
          paramAppRuntime = paramString.getString(paramString.getColumnIndex("value"));
        }
      }
      if (paramString != null) {
        paramString.close();
      }
      localObject1 = paramAppRuntime;
    } while (!QLog.isColorLevel());
    QLog.d("VasUserData", 2, "[Performance] get, duration=" + (SystemClock.uptimeMillis() - l));
    return paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrs
 * JD-Core Version:    0.7.0.1
 */