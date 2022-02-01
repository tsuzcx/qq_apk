import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class agoh
  implements amsq<ampx, amxy>
{
  private agom a;
  
  public void a(agom paramagom)
  {
    this.a = paramagom;
  }
  
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
    agog localagog = (agog)paramampx;
    View localView = paramamxy.getView();
    paramamxy = (AsyncImageView)paramamxy.w();
    String str = localagog.vp();
    int i = localagog.getFileType();
    if (!TextUtils.isEmpty(str))
    {
      ahav.a(paramamxy, str, i);
      paramamxy.setOnClickListener(new agoi(this, paramampx));
      paramamxy = (CheckBox)localView.findViewById(2131367036);
      if (localagog.Ey() <= 1) {
        break label336;
      }
      paramamxy.setVisibility(8);
    }
    for (;;)
    {
      paramamxy.setChecked(localagog.alP());
      localView.setOnClickListener(new agoj(this, paramampx));
      return;
      paramamxy.setDefaultImage(ahav.hL(i));
      break;
      label336:
      paramamxy.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agoh
 * JD-Core Version:    0.7.0.1
 */