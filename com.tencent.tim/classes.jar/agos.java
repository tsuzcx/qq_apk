import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class agos
  implements amsq<ampx, amxy>
{
  public void b(ampx paramampx, amxy paramamxy)
  {
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
    if ((paramampx.g() == null) && (paramamxy.O() != null)) {
      paramamxy.O().setVisibility(8);
    }
    if ((paramamxy.O() != null) && (paramampx.g() != null))
    {
      paramamxy.O().setVisibility(0);
      paramamxy.O().setText(paramampx.g());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramamxy.w();
    Object localObject = (agor)paramampx;
    String str = ((agor)localObject).vp();
    localObject = ((agor)localObject).getFileName();
    if (aqhq.fileExistsAndNotEmpty(str)) {
      ahav.a(localAsyncImageView, str, ahav.getFileType((String)localObject));
    }
    for (;;)
    {
      paramamxy = paramamxy.getView();
      if (paramamxy != null) {
        paramamxy.setOnClickListener(new agot(this, paramampx));
      }
      return;
      localAsyncImageView.setDefaultImage(ahav.r((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agos
 * JD-Core Version:    0.7.0.1
 */