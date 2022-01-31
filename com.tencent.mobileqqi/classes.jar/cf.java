import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.DataLineObserver;

public class cf
  extends DataLineObserver
{
  public cf(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity) {}
  
  protected void a(long paramLong)
  {
    this.a.runOnUiThread(new cl(this));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new ck(this));
  }
  
  protected void a(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new cg(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new ci(this));
  }
  
  protected void b(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new ch(this));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new cj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.7.0.1
 */