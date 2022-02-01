import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;

public class yvj
  extends yvg
{
  public yvj(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, yvg.a parama)
  {
    super(paramQQAppInterface, paramContext, paramXListView, parama);
  }
  
  protected yvb a()
  {
    return new yvf(this.mContext, this.mApp, true);
  }
  
  protected void init()
  {
    super.init();
    anot.a(null, "dc00899", "Grp_recom", "", "no_search_result", "exp", 0, 0, "", "", "", "");
  }
  
  public void refresh()
  {
    super.refresh();
    anot.a(null, "dc00899", "Grp_recom", "", "no_search_result", "exp", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvj
 * JD-Core Version:    0.7.0.1
 */