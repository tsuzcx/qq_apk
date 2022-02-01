import android.content.Context;
import com.tencent.common.app.AppInterface;

public abstract class adkl
  implements adkt.c
{
  public int cHX = 0;
  protected AppInterface mAppInterface;
  protected Context mContext;
  protected int mSessionType;
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    this.mContext = paramContext;
    this.mAppInterface = paramAppInterface;
  }
  
  public void pause()
  {
    this.cHX = 3;
  }
  
  public int qe()
  {
    return this.cHX;
  }
  
  public void resume()
  {
    this.cHX = 2;
  }
  
  public int start()
  {
    return 0;
  }
  
  public void stop() {}
  
  public void uninit()
  {
    this.cHX = 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkl
 * JD-Core Version:    0.7.0.1
 */