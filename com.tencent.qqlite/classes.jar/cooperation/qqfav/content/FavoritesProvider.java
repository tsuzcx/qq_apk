package cooperation.qqfav.content;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;

public class FavoritesProvider
  extends AppContentProvider
  implements Favorites
{
  private static final int jdField_a_of_type_Int = 100;
  private static final String d = "qqfav|FavoritesProvider";
  private static final String e = "com.qqfav.data.BizRelatedData$Proxy";
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private Map jdField_a_of_type_JavaUtilMap;
  private String f = null;
  
  private Favorites.IProxy a(Uri paramUri)
  {
    int i = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav|FavoritesProvider", 2, "getProxy| unmatch,uri=" + paramUri.toString());
      }
      paramUri = null;
    }
    String str;
    AppRuntime localAppRuntime;
    Favorites.IProxy localIProxy;
    do
    {
      return paramUri;
      str = paramUri.getLastPathSegment();
      localAppRuntime = getRuntime(str);
      if (localAppRuntime == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("qqfav|FavoritesProvider", 2, "getProxy| app null,uin=" + str);
        }
        return null;
      }
      if (!this.f.equals(str)) {
        break;
      }
      localIProxy = (Favorites.IProxy)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      paramUri = localIProxy;
    } while (localIProxy != null);
    if (QLog.isColorLevel()) {
      QLog.e("qqfav|FavoritesProvider", 2, "getProxy|match cacheuin but provider null, match=" + i + ",uin=" + str);
    }
    switch (i)
    {
    }
    do
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav|FavoritesProvider", 2, "getProxy|never should goto here");
      }
      return null;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.f = str;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.e("qqfav|FavoritesProvider", 4, "getProxy|cache uin unmatch, match=" + i + ",uin=" + str);
      break;
      paramUri = (Favorites.IProxy)QfavHelper.a("com.qqfav.data.BizRelatedData$Proxy", new Class[] { AppRuntime.class }, new Object[] { localAppRuntime });
    } while (paramUri == null);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramUri);
    return paramUri;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.a(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.a(paramUri, paramContentValues);
    }
    return null;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public boolean onCreate()
  {
    QfavHelper.a(getContext(), null);
    super.onCreate();
    this.jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqlite.favorites", "biz_related/#", 100);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.f = "";
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("query|");
      if (localIProxy != null) {
        break label118;
      }
    }
    label118:
    for (String str = "proxy null";; str = "proxy not null")
    {
      QLog.d("qqfav|FavoritesProvider", 4, str + ",uri=" + paramUri.toString() + ",proj=" + paramArrayOfString1.toString() + ",selection=" + paramString1 + ",args=" + paramArrayOfString2.toString());
      if (localIProxy == null) {
        break;
      }
      return localIProxy.a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.a(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qqfav.content.FavoritesProvider
 * JD-Core Version:    0.7.0.1
 */