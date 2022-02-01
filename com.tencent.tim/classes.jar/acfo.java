import com.tencent.mobileqq.app.GuardManager;
import com.tencent.qphone.base.util.QLog;

public class acfo
{
  public static final String[] eg = { "EMPTY", "BG_FETCH", "FG_MAIN", "FG_OTHER", "BG_GUARD", "BG_UNGUARD", "LITE_GUARD", "LITE_UNGUARD", "DEAD" };
  private static final String[] eh = { "MSG", "RESUME", "TICK", "FG", "BG", "ENTER", "MAIN" };
  protected long PL;
  protected long PM;
  public GuardManager c;
  public int mId;
  
  protected void DE(String paramString) {}
  
  protected void Dp(String paramString) {}
  
  protected void Dq(String paramString)
  {
    this.PM = 0L;
    this.PL = 0L;
  }
  
  public void cHe()
  {
    this.PL += 1L;
    this.PM += 1L;
  }
  
  protected void cHf() {}
  
  protected void es(String paramString) {}
  
  public final void y(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, eg[this.mId] + " onEvent " + eh[paramInt] + ", " + paramObject + ", " + this.PL + ", " + this.PM);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      cHe();
      return;
    case 0: 
      cHf();
      return;
    case 3: 
      Dp((String)paramObject);
      return;
    case 4: 
      DE((String)paramObject);
      return;
    case 5: 
      Dq((String)paramObject);
      return;
    case 6: 
      this.c.x(2, null);
      return;
    }
    es((String)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acfo
 * JD-Core Version:    0.7.0.1
 */