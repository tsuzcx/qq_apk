import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class amso
  extends amti
{
  public amso(aqdf paramaqdf)
  {
    super(paramaqdf, 268435456);
  }
  
  public void a(ampv paramampv, amxx paramamxx)
  {
    Object localObject1 = (ampw)paramampv;
    paramampv = ((amxv)paramamxx).p();
    if (paramampv != null)
    {
      List localList = ((ampw)localObject1).eX();
      if (localList != null)
      {
        paramampv.removeAllViews();
        int j = Math.min(localList.size(), ((ampw)localObject1).Ex());
        int i = 0;
        while (i < j)
        {
          localObject1 = new amzc(((amxv)paramamxx).v(), 268435456);
          Object localObject2 = ((amzc)localObject1).getView();
          ampx localampx = (ampx)localList.get(i);
          ((View)localObject2).setTag(2131381960, localampx);
          ((View)localObject2).setTag(2131381965, localObject1);
          ((View)localObject2).setTag(2131381961, Integer.valueOf(i));
          ((View)localObject2).setTag(2131381959, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131381962, this.a);
          if ((localampx instanceof amow)) {
            amxl.a((amow)localampx, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          paramampv.addView(((amzc)localObject1).getView(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localampx, (amxz)localObject1);
          i += 1;
        }
      }
    }
    if (paramamxx.R() != null) {
      paramamxx.R().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amso
 * JD-Core Version:    0.7.0.1
 */