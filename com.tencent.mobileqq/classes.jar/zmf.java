import com.tencent.biz.qrcode.activity.QMiniResult;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.qbar.QBarResult;
import com.tencent.qphone.base.util.QLog;

public class zmf
  implements zmi
{
  public zmf(ScannerActivity paramScannerActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onMultiCancel");
    }
    this.a.doOnBackPressed();
  }
  
  public void a(QMiniResult paramQMiniResult, int paramInt, zmh paramzmh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onMultiSelectMini result:" + paramQMiniResult + " " + paramInt);
    }
    ScannerActivity.a(this.a, 2, "", paramQMiniResult.a, paramInt);
  }
  
  public void a(QBarResult paramQBarResult, int paramInt, zmh paramzmh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onMultiSelectQr result:" + paramQBarResult + " " + paramInt);
    }
    ScannerActivity.a(this.a, 1, paramQBarResult.a, paramQBarResult.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmf
 * JD-Core Version:    0.7.0.1
 */