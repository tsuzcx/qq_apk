import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;

public class zsc
  implements Runnable
{
  public zsc(FTSDBManager paramFTSDBManager) {}
  
  public void run()
  {
    if (this.a.a()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (SQLiteFTSUtils.g(FTSDBManager.a(this.a)))
          {
            FTSDBManager.a(this.a);
            return;
          }
        } while ((!SQLiteFTSUtils.h(FTSDBManager.a(this.a))) || (this.a.b));
        FTSDBManager.a(this.a);
        ThreadRegulator.a().b();
      } while (FTSDBManager.a(this.a));
      if ((FTSDBManager.b(this.a) > 10) || (FTSDBManager.c(this.a) == 1))
      {
        FTSDBManager.a(this.a);
        return;
      }
    } while (FTSDBManager.c(this.a) != -1);
    this.a.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsc
 * JD-Core Version:    0.7.0.1
 */