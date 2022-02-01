import cooperation.qzone.statistic.access.concept.Collector;

public class awbc
  extends awbf
{
  protected boolean dpI = true;
  protected int ezO = 50;
  protected long timespan = 30000L;
  
  public awbc(long paramLong, int paramInt, boolean paramBoolean)
  {
    nP(paramLong);
    acj(paramInt);
    WX(paramBoolean);
  }
  
  public void WX(boolean paramBoolean)
  {
    this.dpI = paramBoolean;
  }
  
  public boolean a(Collector paramCollector)
  {
    int i;
    int j;
    label30:
    int k;
    if (paramCollector.a().size() > 0)
    {
      i = 1;
      if (System.currentTimeMillis() - paramCollector.iQ() <= this.timespan) {
        break label89;
      }
      j = 1;
      if (paramCollector.a().size() < this.ezO) {
        break label94;
      }
      k = 1;
      label47:
      if ((!this.dpI) || (!paramCollector.isStopped())) {
        break label100;
      }
    }
    label89:
    label94:
    label100:
    for (int m = 1;; m = 0)
    {
      if ((i == 0) || ((j == 0) && (k == 0) && (m == 0))) {
        break label106;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label30;
      k = 0;
      break label47;
    }
    label106:
    return false;
  }
  
  public void acj(int paramInt)
  {
    this.ezO = paramInt;
  }
  
  public void nP(long paramLong)
  {
    this.timespan = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbc
 * JD-Core Version:    0.7.0.1
 */