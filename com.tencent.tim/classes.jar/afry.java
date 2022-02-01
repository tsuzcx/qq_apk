import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class afry
  extends SosoInterface.a
{
  afry(afrx paramafrx, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("EnterpriseQQManager", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if (paramInt == 0) {
      paramInt = i;
    }
    afrx.a locala;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.cd;
      double d2 = ???.ce;
      afrx.a(this.this$0, d1);
      afrx.b(this.this$0, d2);
      afrx.a(this.this$0, System.currentTimeMillis());
      synchronized (afrx.access$200())
      {
        if ((afrx.a(this.this$0) == null) || (afrx.a(this.this$0).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = afrx.a(this.this$0).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          locala = (afrx.a)localIterator1.next();
        } while (locala == null);
        this.this$0.a(afrx.a(this.this$0), afrx.a(this.this$0), locala.VJ, locala.VK, true, d1, d2);
      }
      paramInt = 0;
      continue;
      afrx.a(this.this$0).clear();
    }
    label362:
    for (;;)
    {
      afrx.a(this.this$0, null);
      afrx.a(this.this$0, null);
      return;
      synchronized (afrx.access$200())
      {
        if ((afrx.a(this.this$0) == null) || (afrx.a(this.this$0).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = afrx.a(this.this$0).iterator();
        while (localIterator2.hasNext())
        {
          locala = (afrx.a)localIterator2.next();
          if (locala != null) {
            this.this$0.a(afrx.a(this.this$0), afrx.a(this.this$0), locala.VJ, locala.VK, false, 0.0D, 0.0D);
          }
        }
      }
      afrx.a(this.this$0).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afry
 * JD-Core Version:    0.7.0.1
 */