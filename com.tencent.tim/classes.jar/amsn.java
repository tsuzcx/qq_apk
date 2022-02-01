import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class amsn
  extends amtl
{
  public amsn(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    if ((paramampx instanceof amou))
    {
      paramampx = (amou)paramampx;
      paramamxy = paramamxy.w();
      paramamxy.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (paramampx.a != null) {
        paramamxy.setImageResource(2130845137);
      }
    }
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
 * Qualified Name:     amsn
 * JD-Core Version:    0.7.0.1
 */