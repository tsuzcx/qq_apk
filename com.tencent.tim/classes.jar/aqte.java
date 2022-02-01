import android.graphics.Rect;

public class aqte
{
  private aqtb.a a;
  private aqtb.b b;
  
  public aqte(aqtb.a parama, aqtb.b paramb)
  {
    this.a = parama;
    this.b = paramb;
  }
  
  public void onSizeChange(int paramInt1, int paramInt2)
  {
    this.b.setBounds(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void pause()
  {
    this.a.dTU();
  }
  
  public void release()
  {
    this.a.a(null);
    this.b.reset();
  }
  
  public void resume()
  {
    this.a.dTN();
  }
  
  public void start()
  {
    this.a.a(new aqtf(this));
    resume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqte
 * JD-Core Version:    0.7.0.1
 */