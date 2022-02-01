import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.a;
import com.tencent.qphone.base.util.QLog;

final class abso
  implements CmShowRenderView.a
{
  abso(CmShowRenderView paramCmShowRenderView) {}
  
  public void C(int paramInt, String paramString)
  {
    QLog.i("CmShowTest", 1, "onClick apolloId:" + paramString);
  }
  
  public void aH(int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onViewReady w:" + paramInt1);
    this.b.a("1669140032", "1174992642", 1.0F, 0, null);
    absm.d(this.b);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    QLog.i("CmShowTest", 1, "onActionComplete actionId:" + paramInt1 + " actionSeqId:" + paramInt2 + " playFragment:" + paramInt3);
    if (paramInt2 == 100)
    {
      absm.e(this.b);
      return;
    }
    if (paramInt2 == 101)
    {
      if (absm.access$300() < 3)
      {
        absm.access$308();
        absm.e(this.b);
        return;
      }
      absm.f(this.b);
      return;
    }
    absm.access$302(0);
  }
  
  public void f(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onActionStart actionId:" + paramInt1);
  }
  
  public void fX(String paramString)
  {
    QLog.i("CmShowTest", 1, "onLongTouch name:" + paramString);
  }
  
  public void m(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abso
 * JD-Core Version:    0.7.0.1
 */