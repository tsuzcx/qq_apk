package cooperation.qqfav.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import avja;
import avjk;
import avjk.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppContentProvider;

public class FavoritesProvider
  extends AppContentProvider
  implements avjk
{
  private String cLp;
  private UriMatcher f;
  private Map<Integer, avjk.a> pY;
  
  private avjk.a a(Uri paramUri)
  {
    int i = 1;
    int n = this.f.match(paramUri);
    if (n == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav|FavoritesProvider", 2, "getProxy| mismatch! uri=" + paramUri.toString());
      }
      return null;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    int k;
    if (Thread.currentThread().getId() == 1L) {
      k = 1;
    }
    Object localObject;
    for (;;)
    {
      int m = 0;
      localObject = null;
      label79:
      if (((localBaseApplicationImpl == null) || (localObject == null)) && (k == 0) && (m < 10)) {
        try
        {
          Thread.sleep(30L);
          localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          int j = i;
          if (localBaseApplicationImpl != null)
          {
            j = i;
            if (i != 0)
            {
              avja.bN(false);
              j = 0;
            }
            localObject = localBaseApplicationImpl.getRuntime();
          }
          m += 1;
          i = j;
          break label79;
          k = 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if ((localInterruptedException == null) || (localObject == null)) {
      return null;
    }
    paramUri = paramUri.getLastPathSegment();
    if (this.cLp.equals(paramUri))
    {
      localObject = (avjk.a)this.pY.get(Integer.valueOf(n));
      if (localObject != null) {
        switch (n)
        {
        }
      }
    }
    for (;;)
    {
      switch (n)
      {
      default: 
        return null;
        if (localObject.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$Proxy"))
        {
          return localObject;
          if (localObject.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$GlobalSearchProxy"))
          {
            return localObject;
            if (QLog.isColorLevel())
            {
              QLog.e("qqfav|FavoritesProvider", 2, "getProxy|match cacheuin but provider null, match=" + n + ",uin=" + paramUri);
              continue;
              this.pY.clear();
              this.cLp = paramUri;
              if (QLog.isDevelopLevel()) {
                QLog.e("qqfav|FavoritesProvider", 4, "getProxy|cache uin unmatch, match=" + n + ",uin=" + paramUri);
              }
            }
          }
        }
        break;
      }
    }
    for (paramUri = (avjk.a)avja.b("com.qqfav.data.BizRelatedData$Proxy", null, null); paramUri != null; paramUri = (avjk.a)avja.b("com.qqfav.data.BizRelatedData$GlobalSearchProxy", null, null))
    {
      this.pY.put(Integer.valueOf(n), paramUri);
      return paramUri;
    }
    if (QLog.isColorLevel()) {
      QLog.e("qqfav|FavoritesProvider", 2, "getProxy|never should goto here");
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    avjk.a locala = a(paramUri);
    if (locala != null) {
      return locala.delete(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    avjk.a locala = a(paramUri);
    if (locala != null) {
      return locala.insert(paramUri, paramContentValues);
    }
    return null;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.f = new UriMatcher(-1);
    this.f.addURI("tim.favorites", "biz_related/#", 100);
    this.f.addURI("tim.favorites", "global_search/#", 101);
    this.pY = new HashMap();
    this.cLp = "";
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    avjk.a locala = a(paramUri);
    if (QLog.isDevelopLevel()) {
      QLog.d("qqfav|FavoritesProvider", 4, "query|" + locala + ",uri=" + paramUri + ",selection=" + paramString1);
    }
    if (locala != null) {
      return locala.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    avjk.a locala = a(paramUri);
    if (locala != null) {
      return locala.update(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qqfav.content.FavoritesProvider
 * JD-Core Version:    0.7.0.1
 */