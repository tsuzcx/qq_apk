package smartisanos.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.TextDragPopupWindow;
import java.io.File;
import smartisanos.util.SidebarUtils;

public final class OneStepHelper
{
  private static OneStepHelper mInstance;
  private Context mContext;
  
  private OneStepHelper(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static OneStepHelper getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new OneStepHelper(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void dragFile(View paramView, File paramFile, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    SidebarUtils.dragFile(paramView, this.mContext, paramFile, paramString, paramBitmap1, paramBitmap2, paramBitmap3);
  }
  
  public void dragFile(View paramView, File paramFile, String paramString1, String paramString2)
  {
    SidebarUtils.dragFile(paramView, this.mContext, paramFile, paramString1, paramString2);
  }
  
  public void dragImage(View paramView, Bitmap paramBitmap, File paramFile, String paramString)
  {
    SidebarUtils.dragImage(paramView, this.mContext, paramFile, paramString);
  }
  
  public void dragImage(View paramView, File paramFile, String paramString)
  {
    SidebarUtils.dragImage(paramView, this.mContext, paramFile, paramString);
  }
  
  public void dragLink(View paramView, CharSequence paramCharSequence)
  {
    SidebarUtils.dragLink(paramView, this.mContext, paramCharSequence);
  }
  
  public void dragMultipleImages(View paramView, File[] paramArrayOfFile, String[] paramArrayOfString)
  {
    SidebarUtils.dragMultipleImage(paramView, this.mContext, paramArrayOfFile, paramArrayOfString);
  }
  
  public void dragText(View paramView, CharSequence paramCharSequence)
  {
    SidebarUtils.dragText(paramView, this.mContext, paramCharSequence);
  }
  
  public void dragText(View paramView, CharSequence paramCharSequence, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    SidebarUtils.dragText(paramView, this.mContext, paramCharSequence, paramBitmap1, paramBitmap2, paramBitmap3);
  }
  
  public boolean isOneStepShowing()
  {
    try
    {
      boolean bool = SidebarUtils.isSidebarShowing(this.mContext);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public TextDragPopupWindow showDragPopupText(View paramView, View.OnDragListener paramOnDragListener, String paramString, int paramInt1, int paramInt2)
  {
    paramView = new TextDragPopupWindow(paramView, paramOnDragListener);
    paramView.measureContent(paramString);
    paramView.show(paramInt1, paramInt2);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smartisanos.api.OneStepHelper
 * JD-Core Version:    0.7.0.1
 */