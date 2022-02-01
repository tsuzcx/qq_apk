import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class anrv
  implements View.OnClickListener
{
  anrv(anru paramanru) {}
  
  public void onClick(View paramView)
  {
    if (anru.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = Integer.parseInt(String.valueOf(paramView.getTag()));
        i = 0;
        if (i >= this.a.uh.size()) {
          break;
        }
        View localView = (View)anru.a(this.a).get(i);
        if (localView == null) {
          break label174;
        }
        if (i == j) {
          break label135;
        }
        anqu localanqu2 = (anqu)this.a.uh.get(i);
        if ((localanqu2 != null) && ((localanqu2 instanceof anrw))) {
          ((anrw)localanqu2).dTv();
        } else {
          localView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      label135:
      anqu localanqu1 = (anqu)this.a.uh.get(i);
      if ((localanqu1 != null) && ((localanqu1 instanceof anrw))) {
        ((anrw)localanqu1).toggle();
      }
      label174:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrv
 * JD-Core Version:    0.7.0.1
 */