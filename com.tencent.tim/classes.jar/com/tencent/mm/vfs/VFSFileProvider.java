package com.tencent.mm.vfs;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class VFSFileProvider
  extends ContentProvider
{
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final Pattern PATH_SEPARATE = Pattern.compile("/");
  private String mAuthority;
  
  private static Uri contentUriToVfsUri(Uri paramUri)
  {
    Object localObject = paramUri.getPath();
    if ((localObject == null) || (((String)localObject).isEmpty())) {
      return null;
    }
    paramUri = (Uri)localObject;
    if (((String)localObject).startsWith("/")) {
      paramUri = ((String)localObject).substring(1);
    }
    String[] arrayOfString = PATH_SEPARATE.split(paramUri, 3);
    if (arrayOfString.length < 2) {
      return null;
    }
    localObject = new Uri.Builder();
    String str = arrayOfString[0];
    if (str.startsWith("@"))
    {
      if (arrayOfString.length < 3) {
        return null;
      }
      ((Uri.Builder)localObject).scheme(str.substring(1));
      if (arrayOfString[1].equals("@"))
      {
        ((Uri.Builder)localObject).authority(null);
        ((Uri.Builder)localObject).path(arrayOfString[2]);
      }
    }
    for (;;)
    {
      return ((Uri.Builder)localObject).build();
      ((Uri.Builder)localObject).authority(arrayOfString[1]);
      break;
      paramUri = paramUri.substring(str.length() + 1);
      ((Uri.Builder)localObject).scheme("wcf").authority(str).path(paramUri);
    }
  }
  
  static Uri vfsUriToContentUri(Uri paramUri, String paramString)
  {
    Object localObject = paramUri.getScheme();
    if ((localObject == null) || (((String)localObject).isEmpty()) || (((String)localObject).equals("file"))) {
      return null;
    }
    if (((String)localObject).equals("wcf")) {}
    StringBuilder localStringBuilder;
    for (paramUri = paramUri.getAuthority() + paramUri.getPath();; paramUri = (String)localObject + paramUri.getPath())
    {
      return new Uri.Builder().scheme("content").authority(paramString).path(paramUri).build();
      String str = paramUri.getAuthority();
      localStringBuilder = new StringBuilder().append("@").append((String)localObject).append('/');
      if (str != null)
      {
        localObject = str;
        if (!str.isEmpty()) {}
      }
      else
      {
        localObject = "@";
      }
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    this.mAuthority = paramProviderInfo.authority;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramString = contentUriToVfsUri(paramUri);
    if (paramString == null) {
      throw new IllegalArgumentException("No mapping found for " + paramUri);
    }
    if (new VFSFile(paramString).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    Object localObject = contentUriToVfsUri(paramUri);
    if (localObject == null) {
      throw new IllegalArgumentException("No mapping found for " + paramUri);
    }
    paramUri = ((Uri)localObject).getScheme();
    if ((paramUri != null) && (paramUri.equals("content")))
    {
      paramUri = getContext();
      if (paramUri != null) {
        paramUri = paramUri.getContentResolver().getType((Uri)localObject);
      }
    }
    do
    {
      return paramUri;
      paramUri = new VFSFile((Uri)localObject);
      int i = paramUri.getName().lastIndexOf('.');
      if (i < 0) {
        break;
      }
      paramUri = paramUri.getName().substring(i + 1);
      localObject = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      paramUri = (Uri)localObject;
    } while (localObject != null);
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
    throws FileNotFoundException
  {
    Object localObject = contentUriToVfsUri(paramUri);
    if (localObject == null) {
      throw new FileNotFoundException("File not found: " + paramUri);
    }
    localObject = FileSystemManager.instance().resolve((Uri)localObject);
    if (((FileSystemManager.Resolution)localObject).valid()) {
      try
      {
        paramUri = ((FileSystemManager.Resolution)localObject).fileSystem.openParcelFd(((FileSystemManager.Resolution)localObject).path, paramString);
        return paramUri;
      }
      catch (FileNotFoundException paramUri)
      {
        throw paramUri;
      }
    }
    throw new FileNotFoundException("File not found: " + paramUri);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = contentUriToVfsUri(paramUri);
    if (paramString1 == null) {
      throw new IllegalArgumentException("No mapping found for " + paramUri);
    }
    paramString1 = new VFSFile(paramString1);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
        i = k;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ("_size".equals(paramString2))
      {
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
        i = k;
        continue;
        paramUri = (String[])Arrays.copyOf(paramArrayOfString2, i);
        paramArrayOfString1 = Arrays.copyOf(paramArrayOfString1, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileProvider
 * JD-Core Version:    0.7.0.1
 */