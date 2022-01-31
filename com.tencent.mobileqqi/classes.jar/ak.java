import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.DataLineObserver;

public class ak
  extends DataLineObserver
{
  public ak(LiteActivity paramLiteActivity) {}
  
  protected void a()
  {
    this.a.runOnUiThread(new am(this));
  }
  
  @TargetApi(11)
  protected void a(int paramInt, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.a.runOnUiThread(new as(this, paramString));
      return;
    }
    this.a.runOnUiThread(new at(this, paramString));
  }
  
  protected void a(long paramLong)
  {
    this.a.runOnUiThread(new au(this));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new ao(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new ap(this, paramLong1, paramBoolean2));
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    super.a(paramBoolean, paramLong);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new al(this, paramLong, paramString));
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new ar(this));
  }
  
  protected void b(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new aq(this, paramLong1));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new an(this, paramBoolean, paramLong, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ak
 * JD-Core Version:    0.7.0.1
 */