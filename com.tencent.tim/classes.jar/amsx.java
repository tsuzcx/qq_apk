import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.tim.teamwork.PadInfo;

public class amsx
  extends amtl
{
  public amsx(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    if ((paramampx instanceof amqx))
    {
      paramampx = (amqx)paramampx;
      paramamxy = paramamxy.w();
      paramamxy.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (paramampx.a != null)
      {
        if (paramampx.a.type != 1) {
          break label51;
        }
        paramamxy.setImageResource(2130851565);
      }
    }
    label51:
    do
    {
      return;
      if (paramampx.a.type == 2)
      {
        paramamxy.setImageResource(2130851566);
        return;
      }
      if (paramampx.a.type == 3)
      {
        paramamxy.setImageResource(2130851567);
        return;
      }
    } while (paramampx.a.type != 4);
    paramamxy.setImageResource(2130851577);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    if ((paramamxy.getTitleView() != null) && (!TextUtils.isEmpty(paramampx.getTitle())))
    {
      paramamxy.getTitleView().setVisibility(0);
      paramamxy.getTitleView().setText(paramampx.getTitle());
    }
    if ((paramamxy.z() != null) && (!TextUtils.isEmpty(paramampx.f())))
    {
      paramamxy.z().setVisibility(0);
      paramamxy.z().setText(paramampx.f());
    }
    if ((paramamxy.N() != null) && (!TextUtils.isEmpty(paramampx.getDescription())))
    {
      paramamxy.N().setVisibility(0);
      paramamxy.N().setText(paramampx.getDescription());
    }
    if (paramamxy.O() != null)
    {
      if (TextUtils.isEmpty(paramampx.g())) {
        paramamxy.O().setVisibility(8);
      }
    }
    else {
      return;
    }
    paramamxy.O().setVisibility(0);
    paramamxy.O().setText(paramampx.g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsx
 * JD-Core Version:    0.7.0.1
 */