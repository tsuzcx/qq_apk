import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ayty
{
  private final Class<? extends aygy> O;
  private int actionType;
  private Set<Integer> dF = new HashSet();
  private final int dFa;
  private final int eMQ;
  
  private ayty(int paramInt1, int paramInt2, int paramInt3, Class<? extends aygy> paramClass)
  {
    this.actionType = paramInt1;
    this.dFa = paramInt2;
    this.eMQ = paramInt3;
    this.O = paramClass;
  }
  
  static ayty a(int paramInt1, int paramInt2, int paramInt3, Class<? extends aygy> paramClass)
  {
    return new ayty(paramInt1, paramInt2, paramInt3, paramClass);
  }
  
  void eTE()
  {
    if (this.dF.size() > 0)
    {
      Iterator localIterator = this.dF.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        LpReportInfo_pf00064.allReport(this.actionType, this.dFa, localInteger.intValue());
        QZLog.d("QzoneEditPictureAndVide", 2, new Object[] { "performReport ", toString() + " with " + localInteger });
      }
    }
    LpReportInfo_pf00064.allReport(this.actionType, this.dFa, this.eMQ);
    QZLog.d("QzoneEditPictureAndVide", 2, "performReport " + toString());
  }
  
  Class<? extends aygy> k()
  {
    return this.O;
  }
  
  public String toString()
  {
    return "QzoneEditPictureReportModel{actionType=" + this.actionType + ", subActionType=" + this.dFa + ", reserve=" + this.eMQ + '}';
  }
  
  void v(Set<Integer> paramSet)
  {
    this.dF.addAll(paramSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayty
 * JD-Core Version:    0.7.0.1
 */