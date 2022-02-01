package android.view.onestep;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import java.io.File;

public class OneStepDragUtils
{
  public static void dragFile(View paramView, Context paramContext, File paramFile, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3) {}
  
  public static void dragFile(View paramView, Context paramContext, File paramFile, String paramString1, String paramString2) {}
  
  public static void dragImage(View paramView, Context paramContext, Bitmap paramBitmap, File paramFile, String paramString) {}
  
  public static void dragImage(View paramView, Context paramContext, File paramFile, String paramString)
  {
    dragImage(paramView, paramContext, null, paramFile, paramString);
  }
  
  public static void dragLink(View paramView, Context paramContext, CharSequence paramCharSequence) {}
  
  public static void dragMultipleImage(View paramView, Context paramContext, File[] paramArrayOfFile, String[] paramArrayOfString) {}
  
  public static void dragText(View paramView, Context paramContext, CharSequence paramCharSequence) {}
  
  public static void dragText(View paramView, Context paramContext, CharSequence paramCharSequence, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.view.onestep.OneStepDragUtils
 * JD-Core Version:    0.7.0.1
 */