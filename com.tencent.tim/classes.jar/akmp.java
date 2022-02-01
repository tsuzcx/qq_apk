import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;

public class akmp
  extends akpf
{
  private boolean csX;
  private boolean csY;
  
  public akmp(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void ab(MotionEvent paramMotionEvent)
  {
    super.ab(paramMotionEvent);
    if ((this.csX) || (this.csY)) {
      aklz.cN("0X800AC97", 0);
    }
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.csX = true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.csY = true;
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmp
 * JD-Core Version:    0.7.0.1
 */