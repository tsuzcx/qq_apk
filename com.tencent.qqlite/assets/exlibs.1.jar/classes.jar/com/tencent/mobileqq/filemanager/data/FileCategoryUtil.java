package com.tencent.mobileqq.filemanager.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.dataline.util.file.MediaStoreUtil;
import dqz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileCategoryUtil
{
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static Comparator jdField_a_of_type_JavaUtilComparator = new dqz();
  
  public static int a(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = b(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
    paramContext = MediaStoreUtil.a(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      jdField_a_of_type_JavaUtilArrayList.addAll(paramContext);
    }
    a(jdField_a_of_type_JavaUtilArrayList);
  }
  
  private static void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    Collections.sort(paramList, jdField_a_of_type_JavaUtilComparator);
  }
  
  public static int b(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = c(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor b(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static int c(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = a(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor c(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static int d(Context paramContext)
  {
    return 0;
  }
  
  public static int e(Context paramContext)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryUtil
 * JD-Core Version:    0.7.0.1
 */