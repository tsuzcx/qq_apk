import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqdn
{
  private aqdp a;
  private QQAppInterface app;
  
  public aqdn(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private aqdp a()
  {
    aqdp localaqdp = new aqdp(new aqdo(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localaqdp);
    }
    return localaqdp;
  }
  
  public void Un(String paramString)
  {
    if (this.a == null) {
      this.a = a();
    }
    this.a.a(2, paramString, null, null, null);
  }
  
  public void Uo(String paramString)
  {
    if (this.a == null) {
      this.a = a();
    }
    this.a.a(1, paramString, null, null, null);
  }
  
  public void Up(String paramString)
  {
    if (this.a == null) {
      this.a = a();
    }
    this.a.a(4, paramString, null, null, null);
  }
  
  public void clear()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public void e(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.a == null) {
      this.a = a();
    }
    this.a.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdn
 * JD-Core Version:    0.7.0.1
 */