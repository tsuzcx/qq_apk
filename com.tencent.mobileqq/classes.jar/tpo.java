import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class tpo
{
  public SparseArray<tpn> a = new SparseArray();
  
  public tpo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public tpn a(int paramInt)
  {
    return (tpn)this.a.get(paramInt);
  }
  
  public void a(int paramInt, tpn paramtpn)
  {
    this.a.put(paramInt, paramtpn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpo
 * JD-Core Version:    0.7.0.1
 */