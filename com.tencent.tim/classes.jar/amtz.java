import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class amtz
  extends amsf
{
  public amtz(aqdf paramaqdf, amsf.a parama)
  {
    super(paramaqdf, parama);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    if (TextUtils.isEmpty(paramampx.getDescription()))
    {
      paramamxy.N().setVisibility(8);
      ((amzm)paramamxy).d().setVisibility(0);
      if (paramamxy.z() != null)
      {
        paramampx = ((amre)paramampx).zb();
        if (!TextUtils.isEmpty(paramampx)) {
          break label127;
        }
        paramamxy.z().setVisibility(8);
      }
    }
    for (;;)
    {
      paramamxy.O().setVisibility(8);
      return;
      paramamxy.N().setVisibility(0);
      paramamxy.N().setText(paramampx.getDescription());
      ((amzm)paramamxy).d().setVisibility(8);
      break;
      label127:
      paramamxy.z().setVisibility(0);
      paramamxy.z().setText(paramampx);
    }
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    super.c(paramampx, paramamxy);
    ((amzm)paramamxy).d().setOnClickListener(new amua(this, paramampx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtz
 * JD-Core Version:    0.7.0.1
 */