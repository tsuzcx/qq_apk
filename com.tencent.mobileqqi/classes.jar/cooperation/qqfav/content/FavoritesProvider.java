package cooperation.qqfav.content;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
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
  private static final String d = "com.qqfav.data.BizRelatedData$Proxy";
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private Map jdField_a_of_type_JavaUtilMap;
  private String e = null;
  
  private Favorites.IProxy a(Uri paramUri)
  {
    int i = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    if (i == -1) {
      paramUri = null;
    }
    AppRuntime localAppRuntime;
    Favorites.IProxy localIProxy;
    do
    {
      return paramUri;
      paramUri = paramUri.getLastPathSegment();
      localAppRuntime = getRuntime(paramUri);
      if (localAppRuntime == null) {
        return null;
      }
      if (!this.e.equals(paramUri)) {
        break;
      }
      localIProxy = (Favorites.IProxy)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      paramUri = localIProxy;
    } while (localIProxy != null);
    switch (i)
    {
    }
    do
    {
      return null;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.e = paramUri;
      break;
      paramUri = (Favorites.IProxy)QfavHelper.a("com.qqfav.data.BizRelatedData$Proxy", new Class[] { AppRuntime.class }, new Object[] { localAppRuntime });
    } while (paramUri == null);
    return (Favorites.IProxy)this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramUri);
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
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.favorites", "biz_related/#", 100);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.e = "";
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.content.FavoritesProvider
 * JD-Core Version:    0.7.0.1
 */