package smartisanos.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.onestep.OneStepDragUtils;
import android.view.onestep.OneStepManager;
import java.io.File;

@Deprecated
public class SidebarUtils
{
  public static void dragFile(View paramView, Context paramContext, File paramFile, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    OneStepDragUtils.dragFile(paramView, paramContext, paramFile, paramString, paramBitmap1, paramBitmap2, paramBitmap3);
  }
  
  public static void dragFile(View paramView, Context paramContext, File paramFile, String paramString1, String paramString2)
  {
    OneStepDragUtils.dragFile(paramView, paramContext, paramFile, paramString1, paramString2);
  }
  
  public static void dragImage(View paramView, Context paramContext, Bitmap paramBitmap, File paramFile, String paramString)
  {
    OneStepDragUtils.dragImage(paramView, paramContext, paramBitmap, paramFile, paramString);
  }
  
  public static void dragImage(View paramView, Context paramContext, File paramFile, String paramString)
  {
    OneStepDragUtils.dragImage(paramView, paramContext, paramFile, paramString);
  }
  
  public static void dragLink(View paramView, Context paramContext, CharSequence paramCharSequence)
  {
    OneStepDragUtils.dragLink(paramView, paramContext, paramCharSequence);
  }
  
  public static void dragMultipleImage(View paramView, Context paramContext, File[] paramArrayOfFile, String[] paramArrayOfString)
  {
    OneStepDragUtils.dragMultipleImage(paramView, paramContext, paramArrayOfFile, paramArrayOfString);
  }
  
  public static void dragText(View paramView, Context paramContext, CharSequence paramCharSequence)
  {
    OneStepDragUtils.dragText(paramView, paramContext, paramCharSequence);
  }
  
  public static void dragText(View paramView, Context paramContext, CharSequence paramCharSequence, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    OneStepDragUtils.dragText(paramView, paramContext, paramCharSequence, paramBitmap1, paramBitmap2, paramBitmap3);
  }
  
  public static boolean isSidebarShowing(Context paramContext)
  {
    paramContext = (OneStepManager)paramContext.getSystemService("onestep");
    if (paramContext != null) {
      return paramContext.isInOneStepMode();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smartisanos.util.SidebarUtils
 * JD-Core Version:    0.7.0.1
 */