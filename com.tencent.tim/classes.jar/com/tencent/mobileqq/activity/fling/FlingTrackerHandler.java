package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import aqen;
import java.lang.ref.WeakReference;

public class FlingTrackerHandler
  extends FlingHandler
  implements TopLayout.OnDraggingListener
{
  private ContentWrapView jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView;
  private TopLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout;
  private ImageView eT;
  private Runnable eY = new FlingTrackerHandler.1(this);
  private int mCount;
  private Handler mHandler = new Handler();
  private View mInnerView;
  
  public FlingTrackerHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if ((paramInt1 & paramInt2) != 0)
    {
      if ((paramInt1 | paramInt2) != -1) {
        break label30;
      }
      m = j;
    }
    label30:
    int k;
    label42:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label42;
      n = m;
    }
  }
  
  /* Error */
  private void coE()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 84	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:pW	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 50	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:eT	Landroid/widget/ImageView;
    //   14: invokevirtual 90	android/widget/ImageView:getMeasuredWidth	()I
    //   17: istore_1
    //   18: aload_0
    //   19: getfield 50	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:eT	Landroid/widget/ImageView;
    //   22: invokevirtual 93	android/widget/ImageView:getMeasuredHeight	()I
    //   25: istore_2
    //   26: aload_0
    //   27: aload_3
    //   28: iload_1
    //   29: iload_2
    //   30: invokevirtual 97	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:decodeSampledBitmapFromFile	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull -26 -> 9
    //   38: aload_0
    //   39: getfield 50	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:eT	Landroid/widget/ImageView;
    //   42: aload_3
    //   43: invokevirtual 101	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   46: return
    //   47: astore_3
    //   48: iconst_0
    //   49: ifeq -40 -> 9
    //   52: aload_0
    //   53: getfield 50	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:eT	Landroid/widget/ImageView;
    //   56: aconst_null
    //   57: invokevirtual 101	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   60: return
    //   61: astore_3
    //   62: iconst_0
    //   63: ifeq +11 -> 74
    //   66: aload_0
    //   67: getfield 50	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:eT	Landroid/widget/ImageView;
    //   70: aconst_null
    //   71: invokevirtual 101	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	FlingTrackerHandler
    //   17	12	1	i	int
    //   25	5	2	j	int
    //   4	39	3	localObject1	Object
    //   47	1	3	localOutOfMemoryError	OutOfMemoryError
    //   61	14	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	34	47	java/lang/OutOfMemoryError
    //   26	34	61	finally
  }
  
  private String pW()
  {
    Activity localActivity = (Activity)this.eD.get();
    if (localActivity != null) {
      return ScreenCapture.getSnapPath(localActivity, yd());
    }
    return null;
  }
  
  protected boolean Vj()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.getParent() != null);
  }
  
  public void cancelDrag()
  {
    aqen.cr((Activity)this.eD.get());
  }
  
  protected void coC()
  {
    if ((MI()) && (this.mHandler != null)) {
      this.mHandler.postDelayed(this.eY, 100L);
    }
  }
  
  protected void coD()
  {
    Object localObject = (Activity)this.eD.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
      if ((Vj()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.getParent().equals(localObject)))
      {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null) && (this.mInnerView.getParent().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.removeView(this.mInnerView);
          ((ViewGroup)localObject).addView(this.mInnerView);
        }
        if ((this.eT != null) && (this.eT.getDrawable() != null))
        {
          localObject = this.eT.getDrawable();
          if ((localObject instanceof BitmapDrawable))
          {
            localObject = ((BitmapDrawable)localObject).getBitmap();
            if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
              ((Bitmap)localObject).recycle();
            }
          }
          this.eT.setImageDrawable(null);
        }
      }
    } while (this.mHandler == null);
    this.mHandler.removeCallbacks(this.eY);
  }
  
  public Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = b(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public void endDrag()
  {
    Activity localActivity = (Activity)this.eD.get();
    if (localActivity != null)
    {
      aqen.cr(localActivity);
      localActivity.onBackPressed();
      localActivity.overridePendingTransition(2130772083, 2130772083);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (Vj()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.onConfigChanged(paramConfiguration);
    }
  }
  
  public void startDrag()
  {
    aqen.cq((Activity)this.eD.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingTrackerHandler
 * JD-Core Version:    0.7.0.1
 */