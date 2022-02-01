import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.view.MaskView;

public class aknr
  implements SurfaceHolder.Callback
{
  public aknr(ScanOcrActivity paramScanOcrActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ScanOcrActivity.a(this.this$0, paramSurfaceHolder);
    if (ScanOcrActivity.a(this.this$0) == null)
    {
      ScanOcrActivity.a(this.this$0, new akmz(this.this$0, this.this$0.jdField_a_of_type_Akmz$a, ScanOcrActivity.a(this.this$0)));
      ScanOcrActivity.a(this.this$0).Sb(this.this$0.dnO);
      ScanOcrActivity.a(this.this$0).c(this.this$0.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.i());
      if (ScanOcrActivity.a(this.this$0)) {
        ScanOcrActivity.a(this.this$0).open();
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknr
 * JD-Core Version:    0.7.0.1
 */