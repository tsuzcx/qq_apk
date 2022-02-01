import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class spj
  implements Manager
{
  public static boolean aAw = true;
  protected static BaseApplicationImpl d;
  private AppInterface app;
  
  public spj(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
    init();
  }
  
  public void init()
  {
    try
    {
      d = BaseApplicationImpl.getApplication();
      if (aAw) {
        aAw = false;
      }
      spp.a();
      QLog.i("Q.videostory.VSManager", 1, "init");
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spj
 * JD-Core Version:    0.7.0.1
 */