import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView;
import com.tencent.qphone.base.util.QLog;

public class otq
  implements View.OnTouchListener
{
  public otq(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (PublicAccountImageCollectionMainActivity.a(this.this$0))
    {
      this.this$0.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "current operation is" + paramMotionEvent.getAction());
      }
      if ((paramMotionEvent.getAction() == 1) && (this.this$0.aB[0] < this.this$0.aA[0]))
      {
        PublicAccountImageCollectionMainActivity.a(this.this$0).setImageMatrix(this.this$0.y);
        PublicAccountImageCollectionMainActivity.a(this.this$0).setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      return true;
    }
    this.this$0.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otq
 * JD-Core Version:    0.7.0.1
 */