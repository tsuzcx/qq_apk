import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amsu
  extends amti
{
  public amsu(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  protected amsp<ampx, amxy> a(aqdf paramaqdf)
  {
    return new amsv(paramaqdf);
  }
  
  public void a(ampv paramampv, amxx paramamxx)
  {
    paramampv = (ampw)paramampv;
    LinearLayout localLinearLayout = ((amyc)paramamxx).p();
    List localList;
    int k;
    int i;
    ampt localampt;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = paramampv.eX();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          paramampv = (ampx)localList.get(i);
          if ((paramampv instanceof ampt))
          {
            localampt = (ampt)paramampv;
            localObject2 = null;
            if (amrf.jh(localampt.IU()) == 1)
            {
              localObject2 = LayoutInflater.from(paramamxx.getView().getContext()).inflate(2131563034, null);
              paramampv = ((View)localObject2).findViewById(2131369424);
              localObject1 = new amxs((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (paramampv != null))
      {
        ((View)localObject2).setTag(2131381960, localampt);
        ((View)localObject2).setTag(2131381965, localObject1);
        ((View)localObject2).setTag(2131381961, Integer.valueOf(i));
        ((View)localObject2).setTag(2131381959, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131381962, this.a);
        amxl.a(localampt, k, i);
        int m = localampt.pE();
        int n = localampt.pF();
        if ((localampt instanceof ampy))
        {
          j = localampt.dDv;
          label240:
          amxl.b(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localampt, (amxz)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (amrf.jh(localampt.IU()) != 2) {
          break label538;
        }
        localObject2 = LayoutInflater.from(paramamxx.getView().getContext()).inflate(2131563041, null);
        paramampv = ((View)localObject2).findViewById(2131369424);
        localObject1 = new amyb((View)localObject2);
        break label137;
        j = 0;
        break label240;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localampt.IU());
        continue;
        if ((paramampv instanceof amow))
        {
          paramampv = (amow)paramampv;
          localObject1 = new amzc(localLinearLayout, paramampv.IW());
          localObject2 = ((amzc)localObject1).getView();
          ((View)localObject2).setTag(2131381960, paramampv);
          ((View)localObject2).setTag(2131381965, localObject1);
          ((View)localObject2).setTag(2131381961, Integer.valueOf(i));
          ((View)localObject2).setTag(2131381959, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131381962, this.a);
          amxl.a(paramampv, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((amzc)localObject1).getView(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(paramampv, (amxz)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (paramamxx.R() != null) {
        paramamxx.R().setVisibility(8);
      }
      return;
      label538:
      paramampv = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsu
 * JD-Core Version:    0.7.0.1
 */