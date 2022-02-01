import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.ICloudAVEngine.d;
import java.util.Date;

final class asyg
  extends asye.a.b
{
  asyg(asye.a parama)
  {
    super(null);
  }
  
  public boolean a(String paramString, ICloudAVEngine.d paramd)
  {
    if (this.b.size() >= this.b.maxSize())
    {
      asye.a.a(this.b, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (paramd.mExpireTime > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, paramd.toString() }));
      }
      this.b.put(paramString, paramd);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, paramd.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyg
 * JD-Core Version:    0.7.0.1
 */