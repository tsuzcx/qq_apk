import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class amsb
  extends amti
{
  public amsb(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  protected amsp<ampx, amxy> a(aqdf paramaqdf)
  {
    return new amsf(paramaqdf);
  }
  
  public void a(ampv paramampv, amxx paramamxx)
  {
    paramampv = (ampw)paramampv;
    LinearLayout localLinearLayout = ((amxq)paramamxx).p();
    if (localLinearLayout != null)
    {
      List localList = paramampv.eX();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), paramampv.Ex());
        int i = 0;
        if (i < k)
        {
          ampx localampx = (ampx)localList.get(i);
          View localView = LayoutInflater.from(paramamxx.getView().getContext()).inflate(2131563034, null);
          amxs localamxs = new amxs(localView);
          localView.setTag(2131381960, localampx);
          localView.setTag(2131381965, localamxs);
          localView.setTag(2131381961, Integer.valueOf(i));
          localView.setTag(2131381959, Integer.valueOf(localList.size()));
          localView.setTag(2131381962, this.a);
          amxl.a(localampx, k, i);
          int m = localampx.pE();
          int n = localampx.pF();
          if ((localampx instanceof ampy)) {}
          for (int j = ((ampy)localampx).dDv;; j = 0)
          {
            amxl.b(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localampx, localamxs);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramamxx.R() != null) {
      paramamxx.R().setVisibility(8);
    }
    if ((paramampv instanceof ampi))
    {
      paramampv = ((ampi)paramampv).a();
      paramamxx = ((amxq)paramamxx).a();
      if (paramamxx != null)
      {
        if (paramampv == null) {
          break label325;
        }
        paramamxx.getView().setVisibility(0);
        this.a.a(paramampv, paramamxx);
      }
    }
    return;
    label325:
    paramamxx.getView().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsb
 * JD-Core Version:    0.7.0.1
 */