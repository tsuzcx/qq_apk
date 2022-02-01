import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import java.util.List;

public class xwg
  extends xtc
{
  public xwg(AbsVideoInfoWidget paramAbsVideoInfoWidget, StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b;
    if ((paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.size()) || (paramInt < 0))
    {
      yuk.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b, "Position error , get data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.size()) });
      return;
    }
    xqz localxqz = (xqz)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.get(paramInt);
    AbsVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget, localxqz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwg
 * JD-Core Version:    0.7.0.1
 */