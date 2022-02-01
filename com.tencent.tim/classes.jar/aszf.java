import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;

final class aszf
  implements asyj.a
{
  public aszd.b a;
  
  aszf(aszd paramaszd) {}
  
  public void ess()
  {
    this.a.eon = 26;
  }
  
  public void run()
  {
    if ((this.a.cGk == null) || (this.a.cGk.contains("..")))
    {
      this.a.eon = 15;
      return;
    }
    Object localObject = new File(this.a.cGk);
    if (!((File)localObject).exists())
    {
      this.a.eon = 12;
      return;
    }
    this.a.a = new aszn();
    if ((this.a.mLibType == 2) || (this.a.mLibType == 1)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 1) && (!aszw.h((File)localObject, null)))
      {
        this.a.eon = 10;
        return;
      }
      localObject = new Object[1];
      this.a.eon = QSecFramework.b(2L, this.a.mLibType, this.a.eok, 0L, this.a.cGk, null, null, (Object[])localObject);
      if ((localObject[0] == null) || (!(localObject[0] instanceof Integer))) {
        break;
      }
      this.a.eop = ((Integer)localObject[0]).intValue();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszf
 * JD-Core Version:    0.7.0.1
 */