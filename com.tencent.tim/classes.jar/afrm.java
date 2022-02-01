import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.List;

public class afrm
  extends BaseAdapter
  implements URLDrawableDownListener
{
  protected afrl a;
  protected Context mContext;
  public List<afrl> mData;
  protected Handler mHandler;
  
  public afrm(Context paramContext, Handler paramHandler, afrl paramafrl)
  {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.a = paramafrl;
  }
  
  public static Bitmap k(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public int a(afrl paramafrl)
  {
    return paramafrl.t(this.mData);
  }
  
  public afrl a(int paramInt)
  {
    if ((this.mData != null) && (!this.mData.isEmpty()) && (paramInt >= 0) && (paramInt < this.mData.size())) {
      return (afrl)this.mData.get(paramInt);
    }
    return this.a;
  }
  
  public Long b(int paramInt)
  {
    return Long.valueOf(a(paramInt).getUniqueId());
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 1;
    }
    return this.mData.size();
  }
  
  public List<afrl> getData()
  {
    return this.mData;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = new URLImageView(this.mContext);
    }
    for (;;)
    {
      com.tencent.qphone.base.util.QLog.d("EmotionAdapter", 1, "getView position:" + paramInt);
      Object localObject;
      Drawable localDrawable;
      if ((this.mData != null) && (!this.mData.isEmpty()))
      {
        localObject = (afrl)this.mData.get(paramInt);
        localDrawable = ((afrl)localObject).e(this.mContext);
        if ((((afrl)localObject).ajO()) || (!((afrl)localObject).ajP())) {
          break label221;
        }
        ((URLImageView)paramView).setURLDrawableDownListener(this);
        label110:
        if ((!(localDrawable instanceof aixi)) || (((aixi)localDrawable).getBitmap() == null)) {
          break label232;
        }
        int i = wja.dp2px(100.0F, this.mContext.getResources());
        localObject = k(((aixi)localDrawable).getBitmap(), i, i);
        ((ImageView)paramView).setImageBitmap((Bitmap)localObject);
      }
      for (;;)
      {
        this.mHandler.removeMessages(1001);
        this.mHandler.obtainMessage(1001, paramInt, 0, localDrawable).sendToTarget();
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = this.a;
        break;
        label221:
        ((URLImageView)paramView).setURLDrawableDownListener(null);
        break label110;
        label232:
        ((ImageView)paramView).setImageDrawable(localDrawable);
      }
    }
  }
  
  public boolean jz(int paramInt)
  {
    return a(paramInt).a(this.a);
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    try
    {
      File localFile = paramURLDrawable.getFileInLocal();
      if (localFile == null) {
        break label74;
      }
      i = aqhu.fh(localFile.getAbsolutePath());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label74:
        int i = 0;
      }
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("EmotionAdapter", 0, "onLoadSuccessed,orientation");
    }
    AIOGalleryAdapter.updateRotation(paramView, paramURLDrawable, i);
    this.mHandler.removeMessages(1001);
    this.mHandler.obtainMessage(1001, -1, 1, paramURLDrawable).sendToTarget();
  }
  
  public void setData(List<afrl> paramList)
  {
    this.mData = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrm
 * JD-Core Version:    0.7.0.1
 */