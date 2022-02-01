package cooperation.wadl;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import awnx;
import awnz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class WadlProvider
  extends ContentProvider
{
  public static String cRN;
  public static boolean dqY;
  private static final UriMatcher e = new UriMatcher(-1);
  awnx a;
  private volatile AtomicBoolean bp = new AtomicBoolean(false);
  ContentResolver contentResolver;
  
  static
  {
    cRN = "";
    try
    {
      e.addURI("cooperation.tim.wadl.provider", "query_task_qqgame", 0);
      e.addURI("cooperation.tim.wadl.provider", "insert_task_qqgame", 1);
      e.addURI("cooperation.tim.wadl.provider", "update_task_qqgame", 2);
      e.addURI("cooperation.tim.wadl.provider", "delete_task_qqgame", 3);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("WadlProvider", 2, "WadlProvider amazing at ", localThrowable);
    }
  }
  
  public static Uri.Builder a(String paramString)
  {
    return Uri.parse("content://cooperation.tim.wadl.provider/" + paramString).buildUpon();
  }
  
  private void init()
  {
    if (!this.bp.getAndSet(true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WadlProvider", 2, "init...");
      }
      this.a = new awnx(getContext());
      this.a.a(this.a.getReadableDatabase(), this.a.getWritableDatabase());
      this.contentResolver = getContext().getContentResolver();
    }
  }
  
  @Nullable
  public Bundle call(@NonNull String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    boolean bool2 = false;
    Object localObject = null;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    do
    {
      do
      {
        return null;
        init();
      } while (!"isAvailable".equals(paramString1));
      if (dqY) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WadlProvider", 2, "call method=" + paramString1 + ",arg=" + paramString2 + ",extras=" + paramBundle + ",providerSwitch=" + dqY + ",retBundle=" + null);
    return null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localObject = localBaseApplicationImpl.getRuntime();
    }
    boolean bool3 = awnz.gx("com.tencent.mobileqq:TMAssistantDownloadSDKService");
    if (localObject != null) {
      bool2 = ((AppRuntime)localObject).isLogin();
    }
    for (boolean bool1 = ((AppRuntime)localObject).isRunning();; bool1 = false)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isRunning", bool1);
      ((Bundle)localObject).putBoolean("isLogin", bool2);
      ((Bundle)localObject).putBoolean("isTMRunning", bool3);
      if (QLog.isColorLevel()) {
        QLog.d("WadlProvider", 2, "call method=" + paramString1 + ",arg=" + paramString2 + ",extras=" + paramBundle + ",isRunning=" + bool1 + ",isLogin=" + bool2 + ",isTMRunning=" + bool3);
      }
      return localObject;
    }
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "delete uri=" + paramUri);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!dqY)) {}
    do
    {
      return 0;
      init();
      switch (e.match(paramUri))
      {
      default: 
        return 0;
      }
      if (!TextUtils.isEmpty(awnz.cx(paramUri.getQueryParameter("encryptStr"), cRN)))
      {
        int i = this.a.g(paramString, paramArrayOfString);
        this.contentResolver.notifyChange(paramUri, null);
        return i;
      }
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "delete fail, permission error!");
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    return "";
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "insert uri=" + paramUri);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!dqY)) {
      paramContentValues = null;
    }
    do
    {
      return paramContentValues;
      init();
      switch (e.match(paramUri))
      {
      default: 
        return paramUri;
      }
      if (!TextUtils.isEmpty(awnz.cx(paramUri.getQueryParameter("encryptStr"), cRN)))
      {
        this.a.a(paramContentValues);
        this.contentResolver.notifyChange(paramUri, null);
        return paramUri;
      }
      paramContentValues = paramUri;
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "insert fail, permission error!");
    return paramUri;
  }
  
  public boolean onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "onCreate");
    }
    return true;
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "query uri=" + paramUri);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!dqY))
    {
      paramUri = new MatrixCursor(new String[] { "ret_code" });
      paramUri.addRow(new Object[] { Integer.valueOf(-1000) });
    }
    do
    {
      Object localObject;
      do
      {
        return paramUri;
        init();
        localObject = null;
        switch (e.match(paramUri))
        {
        default: 
          return null;
        }
        if (TextUtils.isEmpty(awnz.cx(paramUri.getQueryParameter("encryptStr"), cRN))) {
          break;
        }
        paramArrayOfString1 = this.a.f(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
        paramUri = paramArrayOfString1;
      } while (!QLog.isColorLevel());
      QLog.d("WadlProvider", 2, "query cursor=" + paramArrayOfString1);
      return paramArrayOfString1;
      paramUri = localObject;
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "query fail, permission error!");
    return null;
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "update uri=" + paramUri + ",selection=" + paramString);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!dqY)) {}
    do
    {
      return 0;
      init();
      switch (e.match(paramUri))
      {
      default: 
        return 0;
      }
      if (!TextUtils.isEmpty(awnz.cx(paramUri.getQueryParameter("encryptStr"), cRN)))
      {
        int i = this.a.a(paramContentValues, paramString, paramArrayOfString);
        this.contentResolver.notifyChange(paramUri, null);
        return i;
      }
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "update fail, permission error!");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.wadl.WadlProvider
 * JD-Core Version:    0.7.0.1
 */