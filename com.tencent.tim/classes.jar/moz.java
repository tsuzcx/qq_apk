import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class moz
  extends amtl
{
  private amsf.a a;
  private Set<String> ac = new HashSet();
  
  moz(aqdf paramaqdf, amsf.a parama, Set<String> paramSet)
  {
    super(paramaqdf);
    this.a = parama;
    this.ac = paramSet;
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    if ((paramampx instanceof mpc))
    {
      paramampx = ((mpc)paramampx).a().hh();
      paramamxy = paramamxy.w();
      Drawable localDrawable = paramamxy.getResources().getDrawable(2130840645);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramampx = URLDrawable.getDrawable(paramampx, localURLDrawableOptions);
      paramampx.setTag(aqbn.e(140, 140));
      paramampx.setDecodeHandler(aqbn.o);
      paramamxy.setImageDrawable(paramampx);
      return;
    }
    super.a(paramampx, paramamxy);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    super.c(paramampx, paramamxy);
    if ((this.a != null) && (!this.ac.contains(paramampx.getUin()))) {
      paramamxy.getView().setOnClickListener(new mpa(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moz
 * JD-Core Version:    0.7.0.1
 */