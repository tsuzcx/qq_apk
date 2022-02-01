import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class axat
{
  private static volatile axat a;
  private long aBJ;
  private long aBK;
  private final int dLp = 2000;
  private boolean dtT;
  private final int eEt = 60000;
  private final int eEu = 1000;
  private int eEv;
  private Object mLock = new Object();
  
  public static axat a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new axat();
      }
      return a;
    }
    finally {}
  }
  
  private void eIu()
  {
    AppInterface localAppInterface = QQStoryContext.c();
    if (localAppInterface != null)
    {
      axbm localaxbm = (axbm)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new axav(this, localAppInterface));
      localaxbm.eIB();
    }
  }
  
  public void setListener()
  {
    if (!this.dtT)
    {
      LogicDataManager.getInstance().setOnGetQQNumberEventListener(new axau(this));
      this.dtT = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axat
 * JD-Core Version:    0.7.0.1
 */