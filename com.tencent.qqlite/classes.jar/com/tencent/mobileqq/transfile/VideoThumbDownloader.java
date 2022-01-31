package com.tencent.mobileqq.transfile;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import ehy;
import java.io.File;
import java.io.OutputStream;

public class VideoThumbDownloader
  extends AbsDownloader
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "file://";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    a = new String[] { "DISTINCT _id", "_data" };
  }
  
  @SuppressLint({"NewApi"})
  private Bitmap a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.startsWith("file://")) {
        str = paramString.substring("file://".length());
      }
      paramString = str;
    } while (str.startsWith(File.separator));
    return File.separator + str;
  }
  
  private Bitmap b(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (Build.VERSION.SDK_INT < 5)
    {
      localObject = localCursor;
      label17:
      return localObject;
    }
    try
    {
      localCursor = a(paramString);
      paramString = (String)localObject;
      if (localCursor != null) {
        paramString = (String)localObject;
      }
    }
    finally
    {
      try
      {
        if (localCursor.getCount() > 0)
        {
          long l = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
          paramString = (String)localObject;
          if (localCursor.moveToFirst()) {
            paramString = MediaStore.Video.Thumbnails.getThumbnail(BaseApplicationImpl.getContext().getContentResolver(), l, 1, null);
          }
        }
        localObject = paramString;
        if (localCursor == null) {
          break label17;
        }
        localCursor.close();
        return paramString;
      }
      finally
      {
        break label112;
      }
      paramString = finally;
      localCursor = null;
    }
    label112:
    if (localCursor != null) {
      localCursor.close();
    }
    throw paramString;
  }
  
  public Cursor a(String paramString)
  {
    paramString = "_data='" + a(paramString) + "'" + " COLLATE NOCASE";
    return BaseApplicationImpl.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a, paramString, null, null);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.aq);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return AlbumThumbManager.a(BaseApplicationImpl.getContext()).a(paramDownloadParams.url, new ehy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VideoThumbDownloader
 * JD-Core Version:    0.7.0.1
 */