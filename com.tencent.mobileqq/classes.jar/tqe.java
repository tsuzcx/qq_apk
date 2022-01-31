import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class tqe
  implements vwf
{
  tqe(tqc paramtqc, String paramString1, QCircleFeedCleanPlayView paramQCircleFeedCleanPlayView, String paramString2) {}
  
  public void a(vwa paramvwa)
  {
    Long localLong = (Long)tqc.a(this.jdField_a_of_type_Tqc).get(this.jdField_a_of_type_JavaLangString);
    if ((localLong != null) && (localLong.longValue() > 0L))
    {
      paramvwa.a(localLong.longValue());
      QLog.d("QCircleFeedPlayerHelper", 4, "playInner seekTo: " + localLong);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCleanPlayView.c();
    tzs.a(8, 4, tqc.a(this.jdField_a_of_type_Tqc, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqe
 * JD-Core Version:    0.7.0.1
 */