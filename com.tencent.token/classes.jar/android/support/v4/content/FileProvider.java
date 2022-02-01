package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.token.cr;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String[] a = { "_display_name", "_size" };
  private static final File b = new File("/");
  private static HashMap<String, a> c = new HashMap();
  private a d;
  
  public static Uri a(Context paramContext, String paramString, File paramFile)
  {
    return a(paramContext, paramString).a(paramFile);
  }
  
  private static a a(Context paramContext, String paramString)
  {
    synchronized (c)
    {
      Object localObject2 = (a)c.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        try
        {
          localObject2 = new b(paramString);
          XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
          if (localXmlResourceParser != null)
          {
            for (;;)
            {
              int i = localXmlResourceParser.next();
              if (i == 1) {
                break label396;
              }
              if (i == 2)
              {
                Object localObject3 = localXmlResourceParser.getName();
                File localFile = null;
                String str1 = localXmlResourceParser.getAttributeValue(null, "name");
                String str2 = localXmlResourceParser.getAttributeValue(null, "path");
                if ("root-path".equals(localObject3))
                {
                  localObject1 = b;
                }
                else if ("files-path".equals(localObject3))
                {
                  localObject1 = paramContext.getFilesDir();
                }
                else if ("cache-path".equals(localObject3))
                {
                  localObject1 = paramContext.getCacheDir();
                }
                else if ("external-path".equals(localObject3))
                {
                  localObject1 = Environment.getExternalStorageDirectory();
                }
                else if ("external-files-path".equals(localObject3))
                {
                  localObject3 = cr.a(paramContext);
                  localObject1 = localFile;
                  if (localObject3.length > 0) {
                    localObject1 = localObject3[0];
                  }
                }
                else if ("external-cache-path".equals(localObject3))
                {
                  localObject3 = cr.b(paramContext);
                  localObject1 = localFile;
                  if (localObject3.length > 0) {
                    localObject1 = localObject3[0];
                  }
                }
                else
                {
                  localObject1 = localFile;
                  if (Build.VERSION.SDK_INT >= 21)
                  {
                    localObject1 = localFile;
                    if ("external-media-path".equals(localObject3))
                    {
                      localObject3 = paramContext.getExternalMediaDirs();
                      localObject1 = localFile;
                      if (localObject3.length > 0) {
                        localObject1 = localObject3[0];
                      }
                    }
                  }
                }
                if (localObject1 != null)
                {
                  localObject1 = a((File)localObject1, new String[] { str2 });
                  boolean bool = TextUtils.isEmpty(str1);
                  if (!bool) {
                    try
                    {
                      localFile = ((File)localObject1).getCanonicalFile();
                      ((b)localObject2).a.put(str1, localFile);
                    }
                    catch (IOException paramContext)
                    {
                      throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(localObject1)), paramContext);
                    }
                  }
                }
              }
            }
            throw new IllegalArgumentException("Name must not be empty");
            label396:
            c.put(paramString, localObject2);
            localObject1 = localObject2;
          }
          else
          {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
          }
        }
        catch (XmlPullParserException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
        catch (IOException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
      }
      return localObject1;
    }
  }
  
  private static File a(File paramFile, String... paramVarArgs)
  {
    int i = 0;
    while (i <= 0)
    {
      String str = paramVarArgs[0];
      File localFile = paramFile;
      if (str != null) {
        localFile = new File(paramFile, str);
      }
      i += 1;
      paramFile = localFile;
    }
    return paramFile;
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported)
    {
      if (paramProviderInfo.grantUriPermissions)
      {
        this.d = a(paramContext, paramProviderInfo.authority);
        return;
      }
      throw new SecurityException("Provider must grant uri permissions");
    }
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.d.a(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.d.a(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    paramUri = this.d.a(paramUri);
    int i;
    if ("r".equals(paramString)) {
      i = 268435456;
    } else if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString)) {
        i = 704643072;
      } else if ("rw".equals(paramString)) {
        i = 939524096;
      } else if ("rwt".equals(paramString)) {
        i = 1006632960;
      } else {
        throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(paramString)));
      }
    }
    else {
      i = 738197504;
    }
    return ParcelFileDescriptor.open(paramUri, i);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.d.a(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = a;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int i;
    for (int k = 0; j < m; k = i)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[k] = "_display_name";
        paramArrayOfString1[k] = paramString1.getName();
        i = k + 1;
      }
      else
      {
        i = k;
        if ("_size".equals(paramString2))
        {
          paramArrayOfString2[k] = "_size";
          paramArrayOfString1[k] = Long.valueOf(paramString1.length());
          i = k + 1;
        }
      }
      j += 1;
    }
    paramUri = new String[k];
    System.arraycopy(paramArrayOfString2, 0, paramUri, 0, k);
    paramString1 = new Object[k];
    System.arraycopy(paramArrayOfString1, 0, paramString1, 0, k);
    paramUri = new MatrixCursor(paramUri, 1);
    paramUri.addRow(paramString1);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static abstract interface a
  {
    public abstract Uri a(File paramFile);
    
    public abstract File a(Uri paramUri);
  }
  
  static final class b
    implements FileProvider.a
  {
    final HashMap<String, File> a = new HashMap();
    private final String b;
    
    b(String paramString)
    {
      this.b = paramString;
    }
    
    public final Uri a(File paramFile)
    {
      try
      {
        Object localObject2 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = this.a.entrySet().iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          String str = ((File)((Map.Entry)localObject1).getValue()).getPath();
          if ((((String)localObject2).startsWith(str)) && ((paramFile == null) || (str.length() > ((File)paramFile.getValue()).getPath().length()))) {
            paramFile = (File)localObject1;
          }
        }
        if (paramFile != null)
        {
          localObject1 = ((File)paramFile.getValue()).getPath();
          if (((String)localObject1).endsWith("/")) {
            localObject1 = ((String)localObject2).substring(((String)localObject1).length());
          } else {
            localObject1 = ((String)localObject2).substring(((String)localObject1).length() + 1);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Uri.encode((String)paramFile.getKey()));
          ((StringBuilder)localObject2).append('/');
          ((StringBuilder)localObject2).append(Uri.encode((String)localObject1, "/"));
          paramFile = ((StringBuilder)localObject2).toString();
          return new Uri.Builder().scheme("content").authority(this.b).encodedPath(paramFile).build();
        }
        throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(localObject2)));
      }
      catch (IOException localIOException)
      {
        label238:
        break label238;
      }
      throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramFile)));
    }
    
    public final File a(Uri paramUri)
    {
      Object localObject2 = paramUri.getEncodedPath();
      int i = ((String)localObject2).indexOf('/', 1);
      Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
      localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
      localObject1 = (File)this.a.get(localObject1);
      if (localObject1 != null) {
        paramUri = new File((File)localObject1, (String)localObject2);
      }
      try
      {
        localObject2 = paramUri.getCanonicalFile();
        if (((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
          return localObject2;
        }
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
      catch (IOException localIOException)
      {
        label100:
        break label100;
      }
      throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramUri)));
      throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(paramUri)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */