package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.android.tpush.logging.TLogger;
import java.net.HttpURLConnection;
import java.net.URL;

public class f
  extends AsyncTask<Void, Void, Bitmap>
{
  private String a;
  private View b;
  private Context c;
  private int d;
  
  public f(String paramString, View paramView, Context paramContext, int paramInt)
  {
    this.a = paramString;
    this.b = paramView;
    this.c = paramContext;
    this.d = paramInt;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = (HttpURLConnection)new URL(this.a).openConnection();
      paramVarArgs.setDoInput(true);
      paramVarArgs.connect();
      paramVarArgs = BitmapFactory.decodeStream(paramVarArgs.getInputStream());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask doInBackground :" + paramVarArgs.toString());
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    try
    {
      if (this.b != null) {
        if ((this.b instanceof ImageView))
        {
          if (paramBitmap != null) {
            ((ImageView)this.b).setImageBitmap(paramBitmap);
          }
        }
        else if (((this.b instanceof RelativeLayout)) && (paramBitmap != null))
        {
          int i = paramBitmap.getWidth();
          int j = paramBitmap.getHeight();
          float f1 = i / i;
          float f2 = this.b.getHeight() / j;
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(f1, f2);
          paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
          paramBitmap = RoundedBitmapDrawableFactory.create(this.c.getResources(), paramBitmap);
          paramBitmap.setAntiAlias(true);
          paramBitmap.setCornerRadius(this.d);
          this.b.setBackground(paramBitmap);
          return;
        }
      }
    }
    catch (Throwable paramBitmap)
    {
      TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask onPostExecute :" + paramBitmap.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.f
 * JD-Core Version:    0.7.0.1
 */