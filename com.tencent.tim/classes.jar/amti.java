import android.view.View;
import android.widget.TextView;
import java.util.List;

public class amti
  implements amsq<ampv, amxx>
{
  protected amsp a;
  private aqdf c;
  
  public amti(aqdf paramaqdf)
  {
    this.c = paramaqdf;
    this.a = a(paramaqdf);
  }
  
  public amti(aqdf paramaqdf, int paramInt)
  {
    this.c = paramaqdf;
    this.a = a(paramaqdf, paramInt);
  }
  
  public amti(aqdf paramaqdf, boolean paramBoolean)
  {
    this.c = paramaqdf;
    this.a = a(paramaqdf, paramBoolean);
  }
  
  public amsp a()
  {
    return this.a;
  }
  
  protected amsp<ampx, amxy> a(aqdf paramaqdf)
  {
    return new amtl(paramaqdf);
  }
  
  protected amsp<ampx, amxy> a(aqdf paramaqdf, int paramInt)
  {
    return new amrv(paramaqdf, paramInt);
  }
  
  protected amsp<ampx, amxy> a(aqdf paramaqdf, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramaqdf);
    }
    return new amsm(paramaqdf);
  }
  
  public void a(ampv paramampv, amxx paramamxx)
  {
    int i = 0;
    Object localObject = (ampw)paramampv;
    a(paramamxx, (ampw)localObject);
    int n = ((ampw)localObject).Ex();
    paramampv = paramamxx.gh();
    if ((paramampv != null) && (paramampv != null))
    {
      localObject = ((ampw)localObject).eX();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < paramampv.size())
        {
          j = 1;
          if (i >= ((List)localObject).size()) {
            break label296;
          }
          k = 1;
          label82:
          if (i >= n) {
            break label302;
          }
        }
        label296:
        label302:
        for (int m = 1;; m = 0)
        {
          if ((m & k & j) == 0) {
            break label308;
          }
          ((amxy)paramampv.get(i)).getView().setVisibility(0);
          ((amxy)paramampv.get(i)).getView().setTag(2131381960, ((List)localObject).get(i));
          ((amxy)paramampv.get(i)).getView().setTag(2131381965, paramampv.get(i));
          ((amxy)paramampv.get(i)).getView().setTag(2131381961, Integer.valueOf(i));
          ((amxy)paramampv.get(i)).getView().setTag(2131381959, Integer.valueOf(paramampv.size()));
          ((amxy)paramampv.get(i)).getView().setTag(2131381962, this.a);
          this.a.a((ampv)((List)localObject).get(i), (amxz)paramampv.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
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
  
  protected void a(amxx paramamxx, ampw paramampw)
  {
    if (paramamxx.getTitleView() != null) {
      paramamxx.getTitleView().setText(paramampw.getGroupName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amti
 * JD-Core Version:    0.7.0.1
 */