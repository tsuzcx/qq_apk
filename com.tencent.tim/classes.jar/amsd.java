import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class amsd
  extends amsf
{
  public amsd(aqdf paramaqdf, amsf.a parama)
  {
    super(paramaqdf, parama);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    if (TextUtils.isEmpty(paramampx.getDescription()))
    {
      paramamxy.N().setVisibility(8);
      ((amxr)paramamxy).d().setVisibility(0);
    }
    for (;;)
    {
      if (paramamxy.O() != null)
      {
        paramampx = paramampx.g();
        if (!TextUtils.isEmpty(paramampx)) {
          break;
        }
        paramamxy.O().setVisibility(8);
      }
      return;
      paramamxy.N().setVisibility(0);
      paramamxy.N().setText(paramampx.getDescription());
      ((amxr)paramamxy).d().setVisibility(8);
    }
    paramamxy.O().setVisibility(0);
    paramamxy.O().setText(paramampx);
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    super.c(paramampx, paramamxy);
    ((amxr)paramamxy).d().setOnClickListener(new amse(this, paramampx));
  }
  
  public void d(ampx paramampx, amxy paramamxy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsd
 * JD-Core Version:    0.7.0.1
 */