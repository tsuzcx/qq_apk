import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class amyl
  extends amyf
{
  public final ArrayList<amyk> Ah = new ArrayList();
  
  public amyl(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    LinearLayout localLinearLayout = (LinearLayout)P(paramInt);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = aqcx.dip2px(paramViewGroup.getContext(), 13.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(null);
  }
  
  public void a(amqm paramamqm)
  {
    int i = 3;
    this.Ah.clear();
    LinearLayout localLinearLayout = (LinearLayout)P(this.acL);
    localLinearLayout.removeAllViews();
    if ((paramamqm.zA == null) || (paramamqm.zA.size() == 0)) {}
    int j;
    int k;
    label90:
    do
    {
      return;
      localObject = localLinearLayout.getContext();
      j = paramamqm.zA.size();
      if (j >= 3) {
        break;
      }
      k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject, 27.0F)) / i;
      i = 0;
    } while (i >= j);
    Object localObject = (amql)paramamqm.zA.get(i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
    switch (((amql)localObject).type)
    {
    }
    for (localObject = null;; localObject = new amym((ViewGroup)getView(), 0))
    {
      if (localObject != null)
      {
        ((amyk)localObject).getView().setLayoutParams(localLayoutParams);
        localLinearLayout.addView(((amyk)localObject).getView());
        this.Ah.add(localObject);
      }
      i += 1;
      break label90;
      i = paramamqm.zA.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyl
 * JD-Core Version:    0.7.0.1
 */