import android.view.View;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

public class cyi
  implements AdapterView.OnItemClickListener
{
  public cyi(Leba paramLeba) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (Leba.b(this.a))
    {
      Leba.b(this.a, false);
      this.a.a(paramView, paramInt, null);
      this.a.a.postDelayed(new cyj(this), 500L);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cyi
 * JD-Core Version:    0.7.0.1
 */