import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPagerAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmoticonViewPager;
import com.tencent.mobileqq.emoticonview.FavPanelViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class foq
  implements Runnable
{
  public foq(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    QLog.d("belina", 2, "updateFavEmoticonPanel");
    if ((EmoticonMainPanel.b() == 1) && (EmoticonMainPanel.d() == 0) && (EmoticonMainPanel.b(this.a) != null) && (EmoticonMainPanel.b(this.a).size() > 0))
    {
      EmoticonViewBinder localEmoticonViewBinder = (EmoticonViewBinder)EmoticonMainPanel.b(this.a).get(0);
      if ((localEmoticonViewBinder != null) && ((localEmoticonViewBinder instanceof FavPanelViewBinder))) {
        ((FavPanelViewBinder)localEmoticonViewBinder).a(true);
      }
      if (EmoticonMainPanel.a(this.a) != null) {
        EmoticonMainPanel.a(this.a).notifyDataSetChanged();
      }
      EmoticonMainPanel.a(this.a, EmoticonMainPanel.b(this.a));
      if (EmoticonMainPanel.a(this.a) != null)
      {
        EmoticonMainPanel.a(this.a).a(EmoticonMainPanel.c(this.a));
        EmoticonMainPanel.a(this.a).setAdapter(EmoticonMainPanel.a(this.a));
        EmoticonMainPanel.a(this.a).setCurrentItem(0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foq
 * JD-Core Version:    0.7.0.1
 */