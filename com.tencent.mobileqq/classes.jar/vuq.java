import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;

class vuq
  extends vxr
{
  private boolean jdField_a_of_type_Boolean;
  
  vuq(vup paramvup, wcz paramwcz, QCircleFeedCleanPlayView paramQCircleFeedCleanPlayView, String paramString1, String paramString2) {}
  
  public void a()
  {
    vup.a(this.jdField_a_of_type_Vup, this.jdField_a_of_type_Wcz, false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Wcz.a(false);
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCleanPlayView.d();
    vtn.a(8, 4, vup.a(this.jdField_a_of_type_Vup, this.jdField_a_of_type_JavaLangString), vup.a(this.jdField_a_of_type_Vup));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = (Long)vup.a(this.jdField_a_of_type_Vup).get(this.b);
    if ((paramString == null) || (paramString.longValue() <= paramInt2) || (paramInt1 == paramString.longValue()) || (Math.abs(paramInt1 - paramString.longValue()) <= 100L)) {
      vup.a(this.jdField_a_of_type_Vup).put(this.b, Long.valueOf(paramInt2));
    }
    vup.a(this.jdField_a_of_type_Vup, this.jdField_a_of_type_Wcz, vup.a(this.jdField_a_of_type_Vup, paramInt1, paramInt2));
    if ((paramInt2 > 3000) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Wcz.a(true);
    }
    while ((paramInt2 > 3000) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Wcz.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuq
 * JD-Core Version:    0.7.0.1
 */