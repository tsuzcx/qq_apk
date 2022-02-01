import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.1;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.2;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class lvy
{
  private static volatile lvy a;
  private static final String[] br = { "ugc_add_account" };
  private boolean alC;
  private List<String> iz = new ArrayList();
  
  private boolean CO()
  {
    return this.alC;
  }
  
  public static lvy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lvy();
      }
      return a;
    }
    finally {}
  }
  
  private void aNL()
  {
    PTSLiteSwitchManager.2 local2 = new PTSLiteSwitchManager.2(this);
    ThreadManager.getFileThreadHandler().post(local2);
  }
  
  private void reset()
  {
    this.alC = false;
    this.iz.clear();
    lvx.aNK();
  }
  
  public boolean CN()
  {
    return (CO()) && (lvl.a().CM());
  }
  
  public boolean dP(String paramString)
  {
    return (this.iz.contains(paramString)) && (lvl.a().CM());
  }
  
  void init()
  {
    reset();
    PTSLiteSwitchManager.1 local1 = new PTSLiteSwitchManager.1(this);
    ThreadManager.getFileThreadHandler().post(local1);
    aNL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvy
 * JD-Core Version:    0.7.0.1
 */