import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.3;
import com.tencent.qphone.base.util.QLog;

public class nts
  implements jox
{
  public nts(ViolaAccessHelper.3 param3) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "downOffline  code " + paramInt + "  param " + paramString);
    }
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.a.a != null) {
          this.a.a.bbp();
        }
      }
    }
    while (this.a.a == null)
    {
      return;
      if (paramString.contains("url"))
      {
        QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.a.val$startTime) });
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.a.val$startTime;
      if (this.a.a != null) {
        this.a.a.bbp();
      }
      QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(l1 - l2) });
      return;
    }
    this.a.a.bbq();
  }
  
  public void progress(int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.uk(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nts
 * JD-Core Version:    0.7.0.1
 */