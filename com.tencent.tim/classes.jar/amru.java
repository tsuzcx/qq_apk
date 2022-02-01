import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class amru
  extends amtl
{
  public amru(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    if ((paramampx instanceof amoc))
    {
      paramampx = (amoc)paramampx;
      paramamxy = paramamxy.w();
      paramamxy.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramampx = paramampx.q;
      if (paramampx != null) {
        break label36;
      }
    }
    label36:
    int i;
    do
    {
      return;
      i = ahav.getFileType(paramampx.fileName);
      if (((i == 0) || (i == 2)) && ((paramamxy instanceof AsyncImageView)))
      {
        athu.d((AsyncImageView)paramamxy, paramampx);
        return;
      }
      i = athu.hL(i);
    } while (i <= 0);
    paramamxy.setImageResource(i);
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
 * Qualified Name:     amru
 * JD-Core Version:    0.7.0.1
 */