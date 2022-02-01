import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.WpsFileEditManager;
import com.tencent.tim.filemanager.core.WpsFileEditManager.h;
import java.util.Map;

public class atvl
  implements WpsFileEditManager.h
{
  public atvl(WpsFileEditManager paramWpsFileEditManager) {}
  
  public void bb(long paramLong, String paramString)
  {
    QLog.w("WpsFileEditManager", 1, "[WPSEDIT]<" + paramLong + "> onFileOverWriteBeCancelledByNewOw");
    WpsFileEditManager.a(this.this$0, paramLong, false, true, 0);
  }
  
  public void bc(long paramLong, String paramString)
  {
    QLog.i("WpsFileEditManager", 1, "[WPSEDIT]<" + paramLong + "> onFileOverWriteSuc.");
    WpsFileEditManager.a(this.this$0).remove(paramString);
    WpsFileEditManager.a(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { paramString } });
    WpsFileEditManager.a(this.this$0, paramLong, true, false, 0);
  }
  
  public void d(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    QLog.w("WpsFileEditManager", 1, "[WPSEDIT]<" + paramLong + "> onFileOverWriteFailed. writing:" + paramBoolean);
    if (!paramBoolean) {
      WpsFileEditManager.a(this.this$0).remove(paramString);
    }
    WpsFileEditManager.a(this.this$0, paramLong, false, false, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvl
 * JD-Core Version:    0.7.0.1
 */