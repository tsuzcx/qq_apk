import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aopn
  extends aopm
  implements aolm.b
{
  private aopn.a a;
  public aoll f;
  
  public aopn(QQAppInterface paramQQAppInterface, String paramString, aopn.a parama, aoll paramaoll)
  {
    super(paramQQAppInterface, paramString);
    this.f = paramaoll;
    this.a = parama;
  }
  
  public void onResp(aomh paramaomh)
  {
    this.a.onResp(paramaomh);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    this.a.onUpdateProgeress(paramaomg, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.f);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.f);
    this.f.f = this;
    this.a.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.f.bZ + ", " + this.a + "]";
  }
  
  public static abstract interface a
    extends aolm.b
  {
    public abstract void a(aopn paramaopn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopn
 * JD-Core Version:    0.7.0.1
 */