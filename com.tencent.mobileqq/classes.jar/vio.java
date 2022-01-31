import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;

public class vio
  extends wna
{
  public vio(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      ume.a(this.a.a, 10, paramView.uid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vio
 * JD-Core Version:    0.7.0.1
 */