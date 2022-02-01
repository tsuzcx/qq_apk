import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class amty
  extends amsf
{
  public amty(aqdf paramaqdf, amsf.a parama, Set<String> paramSet)
  {
    super(paramaqdf, parama, paramSet);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    boolean bool = true;
    super.b(paramampx, paramamxy);
    if (paramamxy.N() != null)
    {
      paramampx = (amot)paramampx;
      if ((this.ac == null) || (!this.ac.contains(paramampx.getUin()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramampx.getDescription()))
      {
        paramamxy.N().setText(paramampx.getDescription());
        i = 1;
      }
      paramampx = paramamxy.N();
      int j;
      if (i != 0)
      {
        j = 0;
        paramampx.setVisibility(j);
        paramampx = paramamxy.getView();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        paramampx.setClickable(bool);
        if (paramamxy.v() != null) {
          paramamxy.v().setVisibility(8);
        }
        return;
        j = 8;
        break;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amty
 * JD-Core Version:    0.7.0.1
 */