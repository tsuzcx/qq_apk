import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aszg
  extends aszd.e
{
  private boolean dgJ;
  
  aszg(aszd paramaszd)
  {
    super(paramaszd, null);
  }
  
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      if ((paramInt4 == 1) || (paramInt4 == 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQProtect.QSec", 2, String.format("Invalid mode: %d", new Object[] { Integer.valueOf(paramInt4) }));
    return;
    asyx.a locala = aszd.a(this.this$0).b(paramInt1);
    if (locala != null) {
      aszd.a(this.this$0).cj(locala.eok, false);
    }
    for (;;)
    {
      locala.eok = paramInt1;
      locala.mLibType = paramInt2;
      locala.eol = paramInt3;
      locala.cGk = paramString1;
      locala.cGj = paramString2;
      aszd.a(this.this$0).a(locala, false);
      this.dgK = true;
      if ((paramInt4 != 1) || (aszd.a(this.this$0).f(paramInt1) != 1)) {
        break;
      }
      this.dgJ = true;
      aszd.b localb = (aszd.b)aszd.a(this.this$0).get(Integer.valueOf(paramInt1));
      if (localb == null) {
        break label236;
      }
      aszd.a(this.this$0, localb, paramString2, paramString1);
      if (localb.eon == 0) {
        break;
      }
      aszd.a(this.this$0).remove(Integer.valueOf(localb.eok));
      return;
      locala = new asyx.a();
    }
    label236:
    paramString1 = aszd.a(this.this$0, locala);
    aszd.a(this.this$0, paramString1);
  }
  
  public void esK()
  {
    if (this.dgK) {
      aszd.a(this.this$0).aIO();
    }
    if (this.dgJ) {
      aszd.d(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszg
 * JD-Core Version:    0.7.0.1
 */