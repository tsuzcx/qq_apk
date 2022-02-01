import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.tim.teamwork.PadInfo;

public class amrz
  extends amtl
{
  public amrz(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    if ((paramampx instanceof amod))
    {
      amod localamod = (amod)paramampx;
      paramampx = paramamxy.w();
      paramampx.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramamxy = localamod.q;
      if (paramamxy != null) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                return;
                i = ahav.getFileType(paramamxy.fileName);
                if ((i == 0) || (i == 2))
                {
                  if ((paramampx instanceof AsyncImageView))
                  {
                    athu.d((AsyncImageView)paramampx, paramamxy);
                    return;
                  }
                  if (i == 0)
                  {
                    paramampx.setImageResource(2130839386);
                    return;
                  }
                  paramampx.setImageResource(2130839393);
                  return;
                }
                if (paramamxy.getCloudFileType() != 2) {
                  break;
                }
                paramamxy = athu.a(paramamxy);
                if (paramamxy.type == 1)
                {
                  paramampx.setImageResource(2130851565);
                  return;
                }
                if (paramamxy.type == 2)
                {
                  paramampx.setImageResource(2130851566);
                  return;
                }
                if (paramamxy.type == 3)
                {
                  paramampx.setImageResource(2130851567);
                  return;
                }
              } while (paramamxy.type != 4);
              paramampx.setImageResource(2130851577);
              return;
              i = athu.hL(i);
            } while (i <= 0);
            paramampx.setImageResource(i);
            return;
            if (!(paramampx instanceof amou)) {
              break;
            }
            paramampx = (amou)paramampx;
            paramamxy = paramamxy.w();
            paramamxy.setScaleType(ImageView.ScaleType.CENTER_CROP);
          } while (paramampx.a == null);
          paramamxy.setImageResource(2130845137);
          return;
        } while (!(paramampx instanceof amqx));
        paramampx = (amqx)paramampx;
        paramamxy = paramamxy.w();
        paramamxy.setScaleType(ImageView.ScaleType.CENTER_CROP);
      } while (paramampx.a == null);
      if (paramampx.a.type == 1)
      {
        paramamxy.setImageResource(2130851565);
        return;
      }
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
 * Qualified Name:     amrz
 * JD-Core Version:    0.7.0.1
 */