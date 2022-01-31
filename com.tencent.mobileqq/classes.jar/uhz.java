import android.graphics.Matrix;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher.FlingRunnable;
import com.tencent.qphone.base.util.QLog;

public class uhz
  implements uhr
{
  public uhz(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (PhotoViewAttacher.a(this.a).a()) {}
    ViewParent localViewParent;
    do
    {
      return;
      if (PhotoViewAttacher.a(this.a) != null) {
        PhotoViewAttacher.a(this.a).a(paramFloat1, paramFloat2);
      }
      PhotoViewAttacher.a(this.a).postTranslate(paramFloat1, paramFloat2);
      PhotoViewAttacher.a(this.a);
      QLog.d("PhotoViewAttacher", 4, "onDrag dx:" + paramFloat1 + " dy:" + paramFloat2 + " mAllowParentInterceptOnEdge:" + PhotoViewAttacher.a(this.a) + " mBlockParentIntercept:" + PhotoViewAttacher.b(this.a) + " mHorizontalScrollEdge:" + PhotoViewAttacher.a(this.a) + " mVerticalScrollEdge:" + PhotoViewAttacher.b(this.a) + " imageviewHashCode:" + PhotoViewAttacher.a(this.a).hashCode());
      localViewParent = PhotoViewAttacher.a(this.a).getParent();
    } while (localViewParent == null);
    localViewParent.requestDisallowInterceptTouchEvent(this.a.a(paramFloat1, paramFloat2));
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    QLog.d("PhotoViewAttacher", 4, "onScale scalefactor:" + paramFloat1 + " curScale:" + this.a.a() + " focusX:" + paramFloat2 + " focusY:" + paramFloat3);
    float f = this.a.a();
    if (((f > PhotoViewAttacher.b()) && (paramFloat1 > 1.0F)) || ((f < PhotoViewAttacher.c()) && (paramFloat1 < 1.0F))) {
      return;
    }
    if (PhotoViewAttacher.a(this.a) != null) {
      PhotoViewAttacher.a(this.a).a(paramFloat1, paramFloat2, paramFloat3);
    }
    PhotoViewAttacher.a(this.a).postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    PhotoViewAttacher.a(this.a);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    QLog.d("PhotoViewAttacher", 2, "onFling startX:" + paramFloat1 + " startY:" + paramFloat2 + " getScale:" + this.a.a() + " velocityX:" + paramFloat3 + " velocityY:" + paramFloat4);
    if (this.a.a() == 1.0F) {
      return;
    }
    PhotoViewAttacher.a(this.a, new PhotoViewAttacher.FlingRunnable(this.a, PhotoViewAttacher.a(this.a).getContext()));
    PhotoViewAttacher.a(this.a).a(PhotoViewAttacher.a(this.a, PhotoViewAttacher.a(this.a)), PhotoViewAttacher.b(this.a, PhotoViewAttacher.a(this.a)), (int)paramFloat3, (int)paramFloat4);
    PhotoViewAttacher.a(this.a).post(PhotoViewAttacher.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhz
 * JD-Core Version:    0.7.0.1
 */