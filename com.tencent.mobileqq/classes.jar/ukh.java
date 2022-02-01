import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class ukh
{
  public SparseArray<ukg> a = new SparseArray();
  
  public ukh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public ukg a(int paramInt)
  {
    return (ukg)this.a.get(paramInt);
  }
  
  public void a(int paramInt, ukg paramukg)
  {
    this.a.put(paramInt, paramukg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukh
 * JD-Core Version:    0.7.0.1
 */