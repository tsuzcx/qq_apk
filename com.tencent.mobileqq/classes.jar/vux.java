import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView;

public class vux
  extends GestureDetector.SimpleOnGestureListener
{
  private final vuy jdField_a_of_type_Vuy;
  
  public vux(PublicAccountImageView paramPublicAccountImageView, vuy paramvuy)
  {
    this.jdField_a_of_type_Vuy = paramvuy;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vux
 * JD-Core Version:    0.7.0.1
 */