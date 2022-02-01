import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import java.lang.ref.WeakReference;

public class apwk
  extends apuv
{
  private String mTroopUin;
  private WeakReference<QQAppInterface> n;
  
  public apwk(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString2, paramString3, paramString4);
    this.n = new WeakReference(paramQQAppInterface);
    this.mTroopUin = paramString1;
  }
  
  public UsingTimeReportManager a()
  {
    if (this.n == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.n.get();
    if (localQQAppInterface == null) {
      return null;
    }
    return (UsingTimeReportManager)localQQAppInterface.getManager(241);
  }
  
  public void kj(long paramLong)
  {
    if (this.n == null) {}
    do
    {
      return;
      localObject = (QQAppInterface)this.n.get();
    } while (localObject == null);
    anov localanov = new anov((QQAppInterface)localObject).a("dc00899").b(this.mDepartment).c(this.mOpType).d(this.mOpName);
    if (this.mTroopUin != null) {}
    for (Object localObject = this.mTroopUin;; localObject = "")
    {
      localanov.a(new String[] { localObject, String.valueOf(paramLong) }).report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwk
 * JD-Core Version:    0.7.0.1
 */