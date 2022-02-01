package wf7;

import android.net.wifi.ScanResult;
import java.util.Iterator;
import java.util.List;

class cw$1
  implements bp
{
  cw$1(cw paramcw) {}
  
  public void a(List<bn> paramList1, List<bn> paramList2) {}
  
  public void b(List<bn> paramList)
  {
    cw.a(this.iJ).b(-1L, 1, null);
  }
  
  public void c(List<bn> paramList)
  {
    cw.a(this.iJ).h(paramList);
    this.iJ.bu();
  }
  
  public void d(List<bn> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bn localbn = (bn)paramList.next();
      cw.a(this.iJ, localbn);
    }
    this.iJ.bu();
  }
  
  public void e(List<ScanResult> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cw.1
 * JD-Core Version:    0.7.0.1
 */