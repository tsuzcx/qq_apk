import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class abkv
{
  private abkx a;
  
  private boolean a(abkx paramabkx)
  {
    if (this.a == null) {}
    while (paramabkx.priority <= this.a.priority) {
      return true;
    }
    return false;
  }
  
  public int a(abrs paramabrs, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.b(paramabrs, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public abkx a()
  {
    return this.a;
  }
  
  public void a(abkx paramabkx)
  {
    if (a(paramabkx))
    {
      this.a = paramabkx;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramabkx.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramabkx.getClass().getSimpleName());
  }
  
  public void a(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.c(paramabrs, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramabrs, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, abrs paramabrs)
  {
    if (this.a != null)
    {
      this.a.b(paramQQAppInterface, paramabrs);
      this.a.priority = 9999;
    }
  }
  
  public void b(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.d(paramabrs, paramContext, paramQQAppInterface);
    }
  }
  
  public void cCF()
  {
    if (this.a != null)
    {
      this.a.cCF();
      this.a.priority = 9999;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkv
 * JD-Core Version:    0.7.0.1
 */