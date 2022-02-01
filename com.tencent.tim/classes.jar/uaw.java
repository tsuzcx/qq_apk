import android.app.Activity;
import java.util.Map;

public class uaw
  extends tzm
{
  protected String aKr;
  public String aKs;
  public String aKt;
  public boolean aQP;
  
  public uaw(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    super(paramActivity, paramInt, paramString1);
    this.aKr = paramString2;
  }
  
  public boolean Oz()
  {
    return this.bDp == 2;
  }
  
  protected Map<String, tze> V()
  {
    return ubc.a.b.get();
  }
  
  protected void bFd()
  {
    tzr.a().a(this.mUniqueKey, this.bDo, this.mAppid, this.aKr, new uax(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uaw
 * JD-Core Version:    0.7.0.1
 */