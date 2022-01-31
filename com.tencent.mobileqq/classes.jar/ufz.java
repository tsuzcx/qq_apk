import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import java.util.List;

public class ufz
  extends ucv
{
  public ufz(AbsVideoInfoWidget paramAbsVideoInfoWidget, StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b;
    if ((paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.size()) || (paramInt < 0))
    {
      ved.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b, "Position error , get data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.size()) });
      return;
    }
    uas localuas = (uas)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.get(paramInt);
    AbsVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget, localuas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufz
 * JD-Core Version:    0.7.0.1
 */