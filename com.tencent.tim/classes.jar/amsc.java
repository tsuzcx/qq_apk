import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class amsc
  extends amsf
{
  private List<PhoneContact> vG;
  
  public amsc(aqdf paramaqdf, amsf.a parama, List<PhoneContact> paramList)
  {
    super(paramaqdf, parama);
    this.vG = paramList;
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    boolean bool = true;
    super.b(paramampx, paramamxy);
    int i;
    int j;
    if (paramamxy.N() != null)
    {
      paramampx = (amop)paramampx;
      if (this.vG != null)
      {
        Iterator localIterator = this.vG.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramampx.f.contactID) {
          break label197;
        }
        paramamxy.N().setText(acfp.m(2131704425));
        i = 1;
      }
    }
    label191:
    label197:
    for (;;)
    {
      break;
      j = 0;
      label101:
      if (!TextUtils.isEmpty(paramampx.getDescription()))
      {
        paramamxy.N().setText(paramampx.getDescription());
        j = 1;
      }
      paramampx = paramamxy.N();
      if (j != 0)
      {
        i = 0;
        paramampx.setVisibility(i);
        paramampx = paramamxy.getView();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        paramampx.setClickable(bool);
        if (paramamxy.v() != null) {
          paramamxy.v().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(ampx paramampx, amxy paramamxy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsc
 * JD-Core Version:    0.7.0.1
 */