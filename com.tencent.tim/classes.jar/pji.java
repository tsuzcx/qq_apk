import android.graphics.Matrix;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher.FlingRunnable;
import com.tencent.qphone.base.util.QLog;

public class pji
  implements pja
{
  public pji(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public void onDrag(float paramFloat1, float paramFloat2)
  {
    if (PhotoViewAttacher.a(this.this$0).isScaling()) {}
    ViewParent localViewParent;
    do
    {
      return;
      if (PhotoViewAttacher.a(this.this$0) != null) {
        PhotoViewAttacher.a(this.this$0).onDrag(paramFloat1, paramFloat2);
      }
      PhotoViewAttacher.a(this.this$0).postTranslate(paramFloat1, paramFloat2);
      PhotoViewAttacher.a(this.this$0);
      QLog.d("PhotoViewAttacher", 4, "onDrag dx:" + paramFloat1 + " dy:" + paramFloat2 + " mAllowParentInterceptOnEdge:" + PhotoViewAttacher.a(this.this$0) + " mBlockParentIntercept:" + PhotoViewAttacher.b(this.this$0) + " mHorizontalScrollEdge:" + PhotoViewAttacher.a(this.this$0) + " mVerticalScrollEdge:" + PhotoViewAttacher.b(this.this$0) + " imageviewHashCode:" + PhotoViewAttacher.a(this.this$0).hashCode());
      localViewParent = PhotoViewAttacher.a(this.this$0).getParent();
    } while (localViewParent == null);
    localViewParent.requestDisallowInterceptTouchEvent(this.this$0.w(paramFloat1, paramFloat2));
  }
  
  public void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    QLog.d("PhotoViewAttacher", 2, "onFling startX:" + paramFloat1 + " startY:" + paramFloat2 + " getScale:" + this.this$0.getScale() + " velocityX:" + paramFloat3 + " velocityY:" + paramFloat4);
    if (this.this$0.getScale() == 1.0F) {
      return;
    }
    PhotoViewAttacher.a(this.this$0, new PhotoViewAttacher.FlingRunnable(this.this$0, PhotoViewAttacher.a(this.this$0).getContext()));
    PhotoViewAttacher.a(this.this$0).fling(PhotoViewAttacher.a(this.this$0, PhotoViewAttacher.a(this.this$0)), PhotoViewAttacher.b(this.this$0, PhotoViewAttacher.a(this.this$0)), (int)paramFloat3, (int)paramFloat4);
    PhotoViewAttacher.a(this.this$0).post(PhotoViewAttacher.a(this.this$0));
  }
  
  public void onScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    QLog.d("PhotoViewAttacher", 4, "onScale scalefactor:" + paramFloat1 + " curScale:" + this.this$0.getScale() + " focusX:" + paramFloat2 + " focusY:" + paramFloat3);
    float f = this.this$0.getScale();
    if (((f > PhotoViewAttacher.av()) && (paramFloat1 > 1.0F)) || ((f < PhotoViewAttacher.aw()) && (paramFloat1 < 1.0F))) {
      return;
    }
    if (PhotoViewAttacher.a(this.this$0) != null) {
      PhotoViewAttacher.a(this.this$0).onScaleChange(paramFloat1, paramFloat2, paramFloat3);
    }
    PhotoViewAttacher.a(this.this$0).postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    PhotoViewAttacher.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pji
 * JD-Core Version:    0.7.0.1
 */