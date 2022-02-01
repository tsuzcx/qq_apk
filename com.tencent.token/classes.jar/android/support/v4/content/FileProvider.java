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
import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
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
  private static final String ATTR_NAME = "name";
  private static final String ATTR_PATH = "path";
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final File DEVICE_ROOT = new File("/");
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  private static final String TAG_CACHE_PATH = "cache-path";
  private static final String TAG_EXTERNAL = "external-path";
  private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
  private static final String TAG_EXTERNAL_FILES = "external-files-path";
  private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
  private static final String TAG_FILES_PATH = "files-path";
  private static final String TAG_ROOT_PATH = "root-path";
  @GuardedBy("sCache")
  private static HashMap<String, PathStrategy> sCache = new HashMap();
  private PathStrategy mStrategy;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      File localFile = paramFile;
      if (str != null) {
        localFile = new File(paramFile, str);
      }
      i += 1;
      paramFile = localFile;
    }
    return paramFile;
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static PathStrategy getPathStrategy(Context paramContext, String paramString)
  {
    synchronized (sCache)
    {
      PathStrategy localPathStrategy2 = (PathStrategy)sCache.get(paramString);
      PathStrategy localPathStrategy1 = localPathStrategy2;
      if (localPathStrategy2 == null) {
        try
        {
          localPathStrategy1 = parsePathStrategy(paramContext, paramString);
          sCache.put(paramString, localPathStrategy1);
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
      return localPathStrategy1;
    }
  }
  
  public static Uri getUriForFile(@NonNull Context paramContext, @NonNull String paramString, @NonNull File paramFile)
  {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString)) {
        return 704643072;
      }
      if ("rw".equals(paramString)) {
        return 939524096;
      }
      if ("rwt".equals(paramString)) {
        return 1006632960;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mode: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 738197504;
  }
  
  private static PathStrategy parsePathStrategy(Context paramContext, String paramString)
  {
    SimplePathStrategy localSimplePathStrategy = new SimplePathStrategy(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser != null)
    {
      for (;;)
      {
        int i = localXmlResourceParser.next();
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          Object localObject2 = localXmlResourceParser.getName();
          Object localObject1 = null;
          String str1 = localXmlResourceParser.getAttributeValue(null, "name");
          String str2 = localXmlResourceParser.getAttributeValue(null, "path");
          if ("root-path".equals(localObject2))
          {
            paramString = DEVICE_ROOT;
          }
          else if ("files-path".equals(localObject2))
          {
            paramString = paramContext.getFilesDir();
          }
          else if ("cache-path".equals(localObject2))
          {
            paramString = paramContext.getCacheDir();
          }
          else if ("external-path".equals(localObject2))
          {
            paramString = Environment.getExternalStorageDirectory();
          }
          else if ("external-files-path".equals(localObject2))
          {
            localObject2 = ContextCompat.getExternalFilesDirs(paramContext, null);
            paramString = localObject1;
            if (localObject2.length > 0) {
              paramString = localObject2[0];
            }
          }
          else if ("external-cache-path".equals(localObject2))
          {
            localObject2 = ContextCompat.getExternalCacheDirs(paramContext);
            paramString = localObject1;
            if (localObject2.length > 0) {
              paramString = localObject2[0];
            }
          }
          else
          {
            paramString = localObject1;
            if (Build.VERSION.SDK_INT >= 21)
            {
              paramString = localObject1;
              if ("external-media-path".equals(localObject2))
              {
                localObject2 = paramContext.getExternalMediaDirs();
                paramString = localObject1;
                if (localObject2.length > 0) {
                  paramString = localObject2[0];
                }
              }
            }
          }
          if (paramString != null) {
            localSimplePathStrategy.addRoot(str1, buildPath(paramString, new String[] { str2 }));
          }
        }
      }
      return localSimplePathStrategy;
    }
    throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
  }
  
  public void attachInfo(@NonNull Context paramContext, @NonNull ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported)
    {
      if (paramProviderInfo.grantUriPermissions)
      {
        this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
        return;
      }
      throw new SecurityException("Provider must grant uri permissions");
    }
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String getType(@NonNull Uri paramUri)
  {
    paramUri = this.mStrategy.getFileForUri(paramUri);
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
  
  public Uri insert(@NonNull Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(@NonNull Uri paramUri, @NonNull String paramString)
  {
    return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    paramString1 = this.mStrategy.getFileForUri(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
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
    paramUri = copyOf(paramArrayOfString2, k);
    paramArrayOfString1 = copyOf(paramArrayOfString1, k);
    paramUri = new MatrixCursor(paramUri, 1);
    paramUri.addRow(paramArrayOfString1);
    return paramUri;
  }
  
  public int update(@NonNull Uri paramUri, ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static abstract interface PathStrategy
  {
    public abstract File getFileForUri(Uri paramUri);
    
    public abstract Uri getUriForFile(File paramFile);
  }
  
  static class SimplePathStrategy
    implements FileProvider.PathStrategy
  {
    private final String mAuthority;
    private final HashMap<String, File> mRoots = new HashMap();
    
    SimplePathStrategy(String paramString)
    {
      this.mAuthority = paramString;
    }
    
    void addRoot(String paramString, File paramFile)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          localObject = paramFile.getCanonicalFile();
          this.mRoots.put(paramString, localObject);
          return;
        }
        catch (IOException paramString)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to resolve canonical path for ");
          ((StringBuilder)localObject).append(paramFile);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString(), paramString);
        }
      }
      throw new IllegalArgumentException("Name must not be empty");
    }
    
    public File getFileForUri(Uri paramUri)
    {
      Object localObject2 = paramUri.getEncodedPath();
      int i = ((String)localObject2).indexOf('/', 1);
      Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
      localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
      localObject1 = (File)this.mRoots.get(localObject1);
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to resolve canonical path for ");
      ((StringBuilder)localObject1).append(paramUri);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unable to find configured root for ");
      ((StringBuilder)localObject1).append(paramUri);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    
    public Uri getUriForFile(File paramFile)
    {
      try
      {
        Object localObject2 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = this.mRoots.entrySet().iterator();
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
          return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(paramFile).build();
        }
        paramFile = new StringBuilder();
        paramFile.append("Failed to find configured root that contains ");
        paramFile.append((String)localObject2);
        throw new IllegalArgumentException(paramFile.toString());
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        label254:
        break label254;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to resolve canonical path for ");
      ((StringBuilder)localObject1).append(paramFile);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */