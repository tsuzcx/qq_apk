import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class amsz
  extends amtl
{
  private Drawable dC;
  
  public amsz(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  private void a(amxy paramamxy, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.dC == null)
      {
        this.dC = paramamxy.getTitleView().getContext().getResources().getDrawable(2130842599);
        this.dC.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.dC, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(amxy paramamxy, ampx paramampx)
  {
    TextView localTextView = paramamxy.getTitleView();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (paramampx != null))
    {
      localContext = localTextView.getContext();
      if (!(paramampx instanceof amqy)) {
        break label73;
      }
      paramampx = ((amqy)paramampx).a();
      if ((paramampx != null) && (localContext != null))
      {
        if (paramampx.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(paramamxy, localTextView, bool);
      }
    }
    label68:
    label73:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while (!(paramampx instanceof ampc));
      paramampx = (ampc)paramampx;
    } while ((paramampx == null) || (localContext == null));
    a(paramamxy, localTextView, paramampx.awd());
  }
  
  protected void a(amxy paramamxy, ampx paramampx)
  {
    super.a(paramamxy, paramampx);
    if ((paramampx instanceof amqy))
    {
      Object localObject = (amqy)paramampx;
      PublicAccountInfo localPublicAccountInfo = ((amqy)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((amqy)localObject).getKeyword())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        paramamxy.getTitleView().setText((CharSequence)localObject);
      }
    }
    b(paramamxy, paramampx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsz
 * JD-Core Version:    0.7.0.1
 */