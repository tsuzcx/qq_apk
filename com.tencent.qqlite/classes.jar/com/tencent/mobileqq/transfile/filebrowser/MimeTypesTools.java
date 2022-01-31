package com.tencent.mobileqq.transfile.filebrowser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class MimeTypesTools
{
  private static MimeTypes jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes;
  public static final String a = "MimeTypesTools";
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static Bitmap a(Context paramContext, String paramString)
  {
    return a(b(paramContext, paramString));
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType(paramString);
    paramString = localPackageManager.queryIntentActivities(localIntent, 65536);
    if ((paramString != null) && (paramString.size() > 0)) {
      return ((ResolveInfo)paramString.get(0)).loadIcon(localPackageManager);
    }
    return paramContext.getResources().getDrawable(2130839443);
  }
  
  private static MimeTypes a(Context paramContext)
  {
    a(paramContext);
    return jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.toLowerCase();
    }
    return a(paramContext).a(str);
  }
  
  private static void a(Context paramContext)
  {
    MimeTypeParser localMimeTypeParser;
    if (!jdField_a_of_type_Boolean)
    {
      localMimeTypeParser = new MimeTypeParser();
      paramContext = paramContext.getResources().getXml(2131099648);
    }
    try
    {
      jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes = localMimeTypeParser.a(paramContext);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: XmlPullParserException");
    }
    catch (IOException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: IOException");
    }
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = paramString.lastIndexOf(".");
      } while (i < 0);
      paramString = paramString.substring(i, paramString.length());
    } while ((!".jpg".equalsIgnoreCase(paramString)) && (!".png".equalsIgnoreCase(paramString)) && (!".gif".equalsIgnoreCase(paramString)) && (!".jpeg".equalsIgnoreCase(paramString)) && (!".bmp".equalsIgnoreCase(paramString)));
    return true;
  }
  
  public static Drawable b(Context paramContext, String paramString)
  {
    return a(paramContext, a(paramContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools
 * JD-Core Version:    0.7.0.1
 */