import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class amte
  implements amsq<ampv, amxx>
{
  private amti a;
  private aqdf c;
  boolean cEj;
  
  public amte(aqdf paramaqdf, boolean paramBoolean)
  {
    this.c = paramaqdf;
    this.a = new amti(paramaqdf, paramBoolean);
    this.cEj = paramBoolean;
  }
  
  public void a(ampv paramampv, amxx paramamxx)
  {
    ampw localampw = (ampw)paramampv;
    amzf localamzf = (amzf)paramamxx;
    int i = localampw.Ex();
    LinearLayout localLinearLayout = localamzf.p();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localampw.eX();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          ampx localampx = (ampx)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.cEj)
          {
            localView = LayoutInflater.from(paramamxx.getView().getContext()).inflate(2131563038, null);
            paramampv = new amxu(localView);
            localView.setTag(2131381960, localampx);
            localView.setTag(2131381965, paramampv);
            localView.setTag(2131381961, Integer.valueOf(i));
            localView.setTag(2131381959, Integer.valueOf(localList.size()));
            localView.setTag(2131381962, this.a);
            amxl.a(localampx, k, i);
            m = localampx.pE();
            n = localampx.pF();
            if (!(localampx instanceof ampy)) {
              break label334;
            }
          }
          label334:
          for (int j = ((ampy)localampx).dDv;; j = 0)
          {
            amxl.b(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.a.a() != null) {
              this.a.a().a((ampv)localList.get(i), paramampv);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(paramamxx.getView().getContext()).inflate(2131563037, null);
            paramampv = new amzk(localView);
            break label142;
          }
        }
      }
    }
    paramampv = localampw.eX();
    if ((paramampv == null) || (paramampv.isEmpty()))
    {
      if (paramamxx.R() != null) {
        paramamxx.R().setVisibility(8);
      }
      localamzf.Hn.setVisibility(0);
      localamzf.Hn.setTag(2131381961, Integer.valueOf(-1));
      localamzf.Zr.setText(localampw.getKeyword());
      localamzf.Zs.setText(acfp.m(2131714130));
      localamzf.DE.setImageResource(2130846935);
      localamzf.Hn.setOnClickListener(new amtf(this, localampw));
      return;
    }
    localamzf.Hn.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amte
 * JD-Core Version:    0.7.0.1
 */