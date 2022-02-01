import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class amsr
  extends amti
{
  public amsr(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  protected amsp<ampx, amxy> a(aqdf paramaqdf)
  {
    return new amss(paramaqdf);
  }
  
  public void a(ampv paramampv, amxx paramamxx)
  {
    Object localObject = (ampw)paramampv;
    paramampv = ((amya)paramamxx).p();
    if (paramampv != null)
    {
      List localList = ((ampw)localObject).eX();
      if (localList != null)
      {
        paramampv.removeAllViews();
        int k = Math.min(localList.size(), ((ampw)localObject).Ex());
        int i = 0;
        if (i < k)
        {
          localObject = (ampx)localList.get(i);
          View localView = LayoutInflater.from(paramamxx.getView().getContext()).inflate(2131563041, null);
          amyb localamyb = new amyb(localView);
          localView.setTag(2131381960, localObject);
          localView.setTag(2131381965, localamyb);
          localView.setTag(2131381961, Integer.valueOf(i));
          localView.setTag(2131381959, Integer.valueOf(localList.size()));
          localView.setTag(2131381962, this.a);
          amxl.a((ampx)localObject, k, i);
          int m = ((ampx)localObject).pE();
          int n = ((ampx)localObject).pF();
          if ((localObject instanceof ampy)) {}
          for (int j = ((ampy)localObject).dDv;; j = 0)
          {
            amxl.b(m, n, localView, j);
            paramampv.addView(localView);
            this.a.a((ampv)localObject, localamyb);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramamxx.R() != null) {
      paramamxx.R().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsr
 * JD-Core Version:    0.7.0.1
 */