import android.widget.TextView;

public class amsm
  extends amtl
{
  public amsm(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((paramampx instanceof amnr))
    {
      amnr localamnr = (amnr)paramampx;
      localTextView = ((amxu)paramamxy).T();
      paramampx = ((amxu)paramamxy).U();
      paramamxy = ((amxu)paramamxy).V();
      if (localTextView != null)
      {
        localCharSequence = localamnr.v();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (paramamxy != null) {
          paramamxy.setVisibility(8);
        }
      }
      if (paramampx != null)
      {
        paramamxy = localamnr.w();
        if (paramamxy != null) {
          break label115;
        }
        paramampx.setText("");
      }
    }
    label96:
    label115:
    do
    {
      do
      {
        return;
        localTextView.setText(localCharSequence);
        if (paramamxy == null) {
          break;
        }
        paramamxy.setVisibility(0);
        break;
        paramampx.setText(paramamxy);
        return;
      } while (!(paramampx instanceof amnq));
      paramampx = (amnq)paramampx;
      paramamxy = ((amxu)paramamxy).W();
    } while (paramamxy == null);
    paramampx = paramampx.u();
    if (paramampx == null)
    {
      paramamxy.setText("");
      return;
    }
    paramamxy.setText(paramampx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsm
 * JD-Core Version:    0.7.0.1
 */