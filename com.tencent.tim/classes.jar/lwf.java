import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class lwf
{
  public static lwf a = new lwf();
  private boolean alD;
  private boolean alE;
  private boolean alF;
  
  private void aNO()
  {
    aNP();
    lvx.aNJ();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new lvv());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new lvt());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new lvn());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new lvq());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new lvp());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new lvu());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new lvs());
    lvg.a().aND();
    lve.a().aNC();
  }
  
  private void aNP()
  {
    lvx.aNK();
    PTSNativeModuleRegistry.clearNativeModule();
    lur.a().aNy();
  }
  
  private void reset()
  {
    this.alF = false;
    this.alD = false;
    this.alE = false;
    aNP();
  }
  
  public boolean CP()
  {
    return this.alF;
  }
  
  public boolean CQ()
  {
    return this.alD;
  }
  
  public boolean CR()
  {
    return (this.alD) || (this.alE);
  }
  
  void init()
  {
    reset();
    PTSSwitchManager.1 local1 = new PTSSwitchManager.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwf
 * JD-Core Version:    0.7.0.1
 */