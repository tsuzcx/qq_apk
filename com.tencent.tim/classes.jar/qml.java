import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.j;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import java.util.List;

public class qml
  extends XViewPager.j
{
  public qml(AbsVideoInfoWidget paramAbsVideoInfoWidget, StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    paramInt = this.d.bmz;
    if ((paramInt >= this.this$0.nR.size()) || (paramInt < 0))
    {
      ram.w(this.this$0.TAG, "Position error , get data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.this$0.nR.size()) });
      return;
    }
    qjq localqjq = (qjq)this.this$0.nR.get(paramInt);
    AbsVideoInfoWidget.a(this.this$0, localqjq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qml
 * JD-Core Version:    0.7.0.1
 */