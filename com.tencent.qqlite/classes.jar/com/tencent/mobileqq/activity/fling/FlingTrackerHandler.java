package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import ceg;
import com.tencent.mobileqq.utils.OSBuilderVersion;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class FlingTrackerHandler
  extends FlingHandler
  implements TopLayout.OnDraggingListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ContentWrapView jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView;
  private TopLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ceg(this);
  
  public FlingTrackerHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
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
  
  private String a()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null) {
      return ScreenCapture.getSnapPath(localActivity, a());
    }
    return null;
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 98	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:a	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   14: invokevirtual 103	android/widget/ImageView:getMeasuredWidth	()I
    //   17: istore_1
    //   18: aload_0
    //   19: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   22: invokevirtual 106	android/widget/ImageView:getMeasuredHeight	()I
    //   25: istore_2
    //   26: aload_0
    //   27: aload_3
    //   28: iload_1
    //   29: iload_2
    //   30: invokevirtual 110	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:decodeSampledBitmapFromFile	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull -26 -> 9
    //   38: aload_0
    //   39: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   42: aload_3
    //   43: invokevirtual 114	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   46: ldc 116
    //   48: iconst_4
    //   49: ldc 118
    //   51: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: return
    //   55: astore_3
    //   56: iconst_0
    //   57: ifeq -48 -> 9
    //   60: aload_0
    //   61: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   64: aconst_null
    //   65: invokevirtual 114	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   68: ldc 116
    //   70: iconst_4
    //   71: ldc 118
    //   73: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: return
    //   77: astore_3
    //   78: iconst_0
    //   79: ifeq +19 -> 98
    //   82: aload_0
    //   83: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   86: aconst_null
    //   87: invokevirtual 114	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   90: ldc 116
    //   92: iconst_4
    //   93: ldc 118
    //   95: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_3
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	FlingTrackerHandler
    //   17	12	1	i	int
    //   25	5	2	j	int
    //   4	39	3	localObject1	Object
    //   55	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   77	22	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	34	55	java/lang/OutOfMemoryError
    //   26	34	77	finally
  }
  
  public static void lockOrientation(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    int i = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getOrientation();
    switch (paramActivity.getResources().getConfiguration().orientation)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramActivity.setRequestedOrientation(i);
      return;
      if ((i == 0) || (i == 1) || (!OSBuilderVersion.b())) {
        break;
      }
      i = 8;
      continue;
      if ((i != 0) && (i != 3) && (OSBuilderVersion.b())) {
        i = 9;
      } else {
        i = 1;
      }
    }
  }
  
  public static void unlockOrientation(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(-1);
    }
  }
  
  protected void a()
  {
    if ((b()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.getParent() != null);
  }
  
  protected void b()
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.getParent().equals(localObject)))
      {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null) && (this.jdField_a_of_type_AndroidViewView.getParent().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.removeView(this.jdField_a_of_type_AndroidViewView);
          ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidViewView);
          QLog.i("sethmao", 4, "unwrap content view");
        }
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null))
        {
          localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
          if ((localObject instanceof BitmapDrawable))
          {
            localObject = ((BitmapDrawable)localObject).getBitmap();
            if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
              ((Bitmap)localObject).recycle();
            }
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void cancelDrag()
  {
    unlockOrientation((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
  
  public Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  public boolean deleteSnapFile()
  {
    boolean bool = false;
    File localFile = new File(a());
    if (localFile.exists()) {
      bool = localFile.delete();
    }
    return bool;
  }
  
  public void endDrag()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null)
    {
      unlockOrientation(localActivity);
      localActivity.onBackPressed();
      localActivity.overridePendingTransition(2130968607, 2130968607);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.onConfigChanged(paramConfiguration);
    }
  }
  
  public void startDrag()
  {
    lockOrientation((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingTrackerHandler
 * JD-Core Version:    0.7.0.1
 */