import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.DataLineObserver;

public class p
  extends DataLineObserver
{
  public p(LiteActivity paramLiteActivity) {}
  
  protected void a()
  {
    this.a.runOnUiThread(new r(this));
  }
  
  @TargetApi(11)
  protected void a(int paramInt, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.a.runOnUiThread(new x(this, paramString));
      return;
    }
    this.a.runOnUiThread(new y(this, paramString));
  }
  
  protected void a(long paramLong)
  {
    this.a.runOnUiThread(new z(this));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new t(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new u(this, paramLong1, paramBoolean2));
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    super.a(paramBoolean, paramLong);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new s(this, paramBoolean, paramLong, paramString));
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new w(this));
  }
  
  protected void b(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new v(this, paramLong1));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new q(this, paramLong, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     p
 * JD-Core Version:    0.7.0.1
 */