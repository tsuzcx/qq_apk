import android.view.View;
import android.widget.TextView;
import java.util.List;

public class amsy
  extends amti
{
  public amsy(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  protected amsp<ampx, amxy> a(aqdf paramaqdf)
  {
    return new amsz(paramaqdf);
  }
  
  public void a(ampv paramampv, amxx paramamxx)
  {
    int i = 0;
    Object localObject = (ampw)paramampv;
    a(paramamxx, (ampw)localObject);
    int k = ((ampw)localObject).Ex();
    paramampv = paramamxx.gh();
    if ((paramampv != null) && (paramampv != null))
    {
      localObject = ((ampw)localObject).eX();
      if (localObject != null)
      {
        int m = Math.min(Math.min(paramampv.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((amxy)paramampv.get(i)).getView().setVisibility(0);
          ((amxy)paramampv.get(i)).getView().setTag(2131381960, ((List)localObject).get(i));
          ((amxy)paramampv.get(i)).getView().setTag(2131381965, paramampv.get(i));
          ((amxy)paramampv.get(i)).getView().setTag(2131381961, Integer.valueOf(i));
          ((amxy)paramampv.get(i)).getView().setTag(2131381959, Integer.valueOf(paramampv.size()));
          ((amxy)paramampv.get(i)).getView().setTag(2131381962, this.a);
          amxl.a((ampx)((List)localObject).get(i), m, i);
          int n = ((ampx)((List)localObject).get(i)).pE();
          int i1 = ((ampx)((List)localObject).get(i)).pF();
          View localView = ((amxy)paramampv.get(i)).getView();
          if ((((List)localObject).get(i) instanceof ampy)) {}
          for (int j = ((ampy)((List)localObject).get(i)).dDv;; j = 0)
          {
            amxl.b(n, i1, localView, j);
            this.a.a((ampv)((List)localObject).get(i), (amxz)paramampv.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < paramampv.size())
        {
          ((amxy)paramampv.get(i)).getView().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramampv.size())
      {
        ((amxy)paramampv.get(i)).getView().setVisibility(8);
        i += 1;
      }
    }
    if (paramamxx.R() != null) {
      paramamxx.R().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsy
 * JD-Core Version:    0.7.0.1
 */