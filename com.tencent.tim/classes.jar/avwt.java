import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class avwt
  implements ScaleGestureDetector.OnScaleGestureListener
{
  avwt(avws paramavws) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    avws.a(this.this$0, 1.0F - f + avws.b(this.this$0));
    if (avws.a(this.this$0) == 0) {
      avws.a(this.this$0, Math.max(avws.c(this.this$0), Math.min(1.5F, avws.b(this.this$0))));
    }
    for (;;)
    {
      avws.b(this.this$0, avws.b(this.this$0) / avws.d(this.this$0));
      if (avws.a(this.this$0) != null) {
        avws.a(this.this$0).bo(avws.b(this.this$0));
      }
      return true;
      avws.a(this.this$0, Math.max(avws.c(this.this$0), Math.min(1.0F, avws.b(this.this$0))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwt
 * JD-Core Version:    0.7.0.1
 */