import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class aexi
  extends aexh
{
  private aeyh.a a;
  private boolean bWV;
  
  public aexi(aexj paramaexj)
  {
    super(paramaexj);
  }
  
  public void HB(boolean paramBoolean)
  {
    this.bWV = paramBoolean;
  }
  
  public aeyh.a a()
  {
    return this.a;
  }
  
  public aeyj a(aeyr paramaeyr)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramaeyr);
      if (localView != null) {
        aewr.a().a().getHandler().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramaeyr);
  }
  
  public void a(aeyh.a parama)
  {
    this.a = parama;
  }
  
  public boolean aiA()
  {
    return this.bWV;
  }
  
  public int getType()
  {
    return -2147483647;
  }
  
  public void reset()
  {
    super.reset();
    this.bWV = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexi
 * JD-Core Version:    0.7.0.1
 */