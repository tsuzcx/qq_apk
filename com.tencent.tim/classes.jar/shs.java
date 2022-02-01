import android.widget.TextView;
import java.util.Map;

class shs
  extends pem
{
  shs(shq paramshq, xaf.a parama) {}
  
  public void bjH()
  {
    super.bjH();
    shq.a(this.this$0, this.b, true);
  }
  
  public void w(String paramString, int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)shq.b(this.this$0).get(Integer.valueOf(this.b.pos));
    if ((localInteger != null) && (localInteger.intValue() > paramInt2) && (paramInt1 != localInteger.intValue()) && (Math.abs(paramInt1 - localInteger.intValue()) > 100))
    {
      this.b.IU.setText((CharSequence)shq.c(this.this$0).get(Integer.valueOf(this.b.pos)));
      return;
    }
    shq.b(this.this$0).put(Integer.valueOf(this.b.pos), Integer.valueOf(paramInt2));
    shq.c(this.this$0).put(Integer.valueOf(this.b.pos), paramString);
    this.b.IU.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shs
 * JD-Core Version:    0.7.0.1
 */