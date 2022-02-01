import com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.b;
import qqcircle.QQCircleDitto.StItemContainer;

public class pgo
  implements BaseWidgetView.b
{
  public pgo(QCirclePushRankItemView paramQCirclePushRankItemView) {}
  
  public void bja()
  {
    if (this.a.getData() != null) {
      pco.a("", 9, 3L, 0L, ((QQCircleDitto.StItemContainer)this.a.getData()).containerType + "", "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgo
 * JD-Core Version:    0.7.0.1
 */