import com.tencent.qphone.base.util.QLog;

public class anjf
{
  public static anjf a;
  private long alO;
  private long alP;
  private long alQ;
  private long alR;
  private long alS;
  private long alT;
  private long alU;
  private boolean cHg;
  private boolean cHh;
  private boolean cHi;
  private volatile boolean cHj;
  private final int dHJ = 20;
  private int dHK;
  
  public static anjf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anjf();
      }
      return a;
    }
    finally {}
  }
  
  private void clear()
  {
    this.cHj = false;
    this.dHK = 0;
    this.cHg = false;
    this.cHh = false;
    this.cHi = false;
    this.alO = 0L;
    this.alP = 0L;
    this.alQ = 0L;
    this.alR = 0L;
    this.alS = 0L;
  }
  
  public void ct(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if ((this.cHj) && (this.dHK <= 20))
    {
      this.dHK += 1;
      if (QLog.isColorLevel()) {
        QLog.i("GestureMonitorManager", 2, "start " + this.dHK + "");
      }
    }
    do
    {
      return;
      if ((this.cHj) && (this.dHK > 20))
      {
        doReport();
        clear();
        return;
      }
    } while (this.cHj);
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramBoolean1 = true;
      this.cHj = paramBoolean1;
      if (!this.cHj) {
        break label133;
      }
    }
    for (;;)
    {
      this.dHK = i;
      return;
      paramBoolean1 = false;
      break;
      label133:
      i = 0;
    }
  }
  
  public void dQD()
  {
    if (this.cHj) {
      this.alT = System.currentTimeMillis();
    }
  }
  
  public void dQE()
  {
    if (this.cHj)
    {
      this.alT = (System.currentTimeMillis() - this.alT);
      this.alO += this.alT;
      if (QLog.isColorLevel()) {
        QLog.i("GestureMonitorManager", 2, "GestureMonitorManager TotalDetetcorConsumer[startPreview] " + this.alT + "ms");
      }
    }
  }
  
  public void dQF()
  {
    if (this.cHj) {
      this.alU = System.currentTimeMillis();
    }
  }
  
  public void dQG()
  {
    if (this.cHj)
    {
      this.alU = (System.currentTimeMillis() - this.alU);
      this.alR += this.alU;
      if (QLog.isColorLevel()) {
        QLog.i("GestureMonitorManager", 2, "GestureMonitorManager GestureDrawConsumer[GestureDraw] " + this.alU + "ms");
      }
    }
  }
  
  public void doReport()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GestureMonitorManagerdoReport", 2, "GestureMonitorManager check Frame numbers[+20],[StartPreview:" + this.alO + "ms],[FaceDetector Aysn childThread:" + this.alQ + "ms],ms],[FaceDraw:" + this.alP + "ms],[GestureDetector Aysn childThread:" + this.alS + "ms],ms],[GestureDraw:" + this.alR + "ms]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjf
 * JD-Core Version:    0.7.0.1
 */