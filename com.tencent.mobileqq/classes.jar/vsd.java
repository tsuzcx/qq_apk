import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;

class vsd
  extends vuq
{
  vsd(vsc paramvsc, vzj paramvzj, QCircleFeedCleanPlayView paramQCircleFeedCleanPlayView, String paramString1, String paramString2) {}
  
  public void a()
  {
    vsc.a(this.jdField_a_of_type_Vsc, this.jdField_a_of_type_Vzj, false);
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCleanPlayView.d();
    vrc.a(8, 4, vsc.a(this.jdField_a_of_type_Vsc, this.jdField_a_of_type_JavaLangString), vsc.a(this.jdField_a_of_type_Vsc));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = (Long)vsc.a(this.jdField_a_of_type_Vsc).get(this.b);
    if ((paramString == null) || (paramString.longValue() <= paramInt2) || (paramInt1 == paramString.longValue()) || (Math.abs(paramInt1 - paramString.longValue()) <= 100L)) {
      vsc.a(this.jdField_a_of_type_Vsc).put(this.b, Long.valueOf(paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsd
 * JD-Core Version:    0.7.0.1
 */