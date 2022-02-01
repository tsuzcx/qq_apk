import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1;
import java.util.Timer;
import java.util.TimerTask;

public class aixt
{
  public aixt.a a;
  public aixw a;
  public String bPU = "non-ver";
  public String bPV;
  public String bPW;
  public String bPX;
  public String bPY;
  public boolean cmB = true;
  public boolean cmC;
  public boolean cmD = true;
  public boolean cmE;
  public boolean cmF;
  public int count = 0;
  public int dgh;
  public int dgi;
  public int dgj = 50;
  public int dgk = 30;
  public int dgl;
  public int dgm;
  public int dgn;
  public int dgo;
  public int dgp;
  public boolean fullScreen;
  public boolean isAutoPlay = true;
  public String subTitle;
  TimerTask timerTask = new ActionGlobalData.1(this);
  public String title;
  public int titleColor;
  public String type = "send";
  public int value;
  public int windowHeight;
  public int windowWidth;
  public float xb;
  
  public void a(aixt.a parama)
  {
    this.a = parama;
  }
  
  public void dvo()
  {
    this.xb = this.dgi;
    ThreadManager.getTimer().schedule(this.timerTask, 0L, 100L);
  }
  
  public static abstract interface a
  {
    public abstract void cHe();
    
    public abstract void dvp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixt
 * JD-Core Version:    0.7.0.1
 */