package com.tencent.token;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public final class bt
  extends cr
{
  private static b a;
  
  public static b a()
  {
    return a;
  }
  
  public static void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(Activity paramActivity, co paramco)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject2 = null;
    Object localObject1 = null;
    if (i >= 23)
    {
      if (paramco != null) {
        localObject1 = new e(paramco);
      }
      paramActivity.setEnterSharedElementCallback((SharedElementCallback)localObject1);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (paramco != null) {
        localObject1 = new d(paramco);
      }
      paramActivity.setEnterSharedElementCallback((SharedElementCallback)localObject1);
    }
  }
  
  public static void a(final Activity paramActivity, String[] paramArrayOfString, final int paramInt)
  {
    b localb = a;
    if ((localb != null) && (localb.a())) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof c)) {
        ((c)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
      return;
    }
    if ((paramActivity instanceof a)) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          int[] arrayOfInt = new int[this.a.length];
          PackageManager localPackageManager = paramActivity.getPackageManager();
          String str = paramActivity.getPackageName();
          int j = this.a.length;
          int i = 0;
          while (i < j)
          {
            arrayOfInt[i] = localPackageManager.checkPermission(this.a[i], str);
            i += 1;
          }
          ((bt.a)paramActivity).onRequestPermissionsResult(paramInt, this.a, arrayOfInt);
        }
      });
    }
  }
  
  public static void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }
  
  public static void b(Activity paramActivity, co paramco)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject2 = null;
    Object localObject1 = null;
    if (i >= 23)
    {
      if (paramco != null) {
        localObject1 = new e(paramco);
      }
      paramActivity.setExitSharedElementCallback((SharedElementCallback)localObject1);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (paramco != null) {
        localObject1 = new d(paramco);
      }
      paramActivity.setExitSharedElementCallback((SharedElementCallback)localObject1);
    }
  }
  
  public static void c(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
  }
  
  public static void d(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean a();
    
    public abstract boolean b();
  }
  
  public static abstract interface c
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
  
  static class d
    extends SharedElementCallback
  {
    protected co a;
    
    d(co paramco)
    {
      this.a = paramco;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      co localco = this.a;
      if ((paramView instanceof ImageView))
      {
        localObject1 = (ImageView)paramView;
        localObject2 = ((ImageView)localObject1).getDrawable();
        Drawable localDrawable = ((ImageView)localObject1).getBackground();
        if ((localObject2 != null) && (localDrawable == null))
        {
          localObject2 = co.a((Drawable)localObject2);
          if (localObject2 != null)
          {
            paramView = new Bundle();
            paramView.putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject2);
            paramView.putString("sharedElement:snapshot:imageScaleType", ((ImageView)localObject1).getScaleType().toString());
            if (((ImageView)localObject1).getScaleType() == ImageView.ScaleType.MATRIX)
            {
              paramMatrix = ((ImageView)localObject1).getImageMatrix();
              paramRectF = new float[9];
              paramMatrix.getValues(paramRectF);
              paramView.putFloatArray("sharedElement:snapshot:imageMatrix", paramRectF);
            }
            return paramView;
          }
        }
      }
      int j = Math.round(paramRectF.width());
      int i = Math.round(paramRectF.height());
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (j > 0)
      {
        localObject1 = localObject2;
        if (i > 0)
        {
          float f = Math.min(1.0F, co.b / (j * i));
          j = (int)(j * f);
          i = (int)(i * f);
          if (localco.a == null) {
            localco.a = new Matrix();
          }
          localco.a.set(paramMatrix);
          localco.a.postTranslate(-paramRectF.left, -paramRectF.top);
          localco.a.postScale(f, f);
          localObject1 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
          paramMatrix = new Canvas((Bitmap)localObject1);
          paramMatrix.concat(localco.a);
          paramView.draw(paramMatrix);
        }
      }
      return localObject1;
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return co.a(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
    
    public void onRejectSharedElements(List<View> paramList) {}
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  }
  
  static final class e
    extends bt.d
  {
    e(co paramco)
    {
      super();
    }
    
    public final void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
    {
      co.a(new co.a()
      {
        public final void a()
        {
          paramOnSharedElementsReadyListener.onSharedElementsReady();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bt
 * JD-Core Version:    0.7.0.1
 */