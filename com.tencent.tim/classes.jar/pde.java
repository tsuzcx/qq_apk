import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;

class pde
  extends pem
{
  pde(pdd parampdd, pie parampie, QCircleFeedCleanPlayView paramQCircleFeedCleanPlayView, String paramString1, String paramString2) {}
  
  public void bjH()
  {
    pdd.a(this.this$0, this.jdField_a_of_type_Pie, false);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCleanPlayView.start();
    pcl.a(8, 4, pdd.a(this.this$0, this.dL));
  }
  
  public void w(String paramString, int paramInt1, int paramInt2)
  {
    paramString = (Long)pdd.a(this.this$0).get(this.val$url);
    if ((paramString == null) || (paramString.longValue() <= paramInt2) || (paramInt1 == paramString.longValue()) || (Math.abs(paramInt1 - paramString.longValue()) <= 100L)) {
      pdd.a(this.this$0).put(this.val$url, Long.valueOf(paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pde
 * JD-Core Version:    0.7.0.1
 */