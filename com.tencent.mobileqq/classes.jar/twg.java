import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class twg
{
  public SparseArray<twf> a = new SparseArray();
  
  public twg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public twf a(int paramInt)
  {
    return (twf)this.a.get(paramInt);
  }
  
  public void a(int paramInt, twf paramtwf)
  {
    this.a.put(paramInt, paramtwf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twg
 * JD-Core Version:    0.7.0.1
 */