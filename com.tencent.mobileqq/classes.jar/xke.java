import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;

public class xke
  extends yop
{
  public xke(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      wnu.a(this.a.a, 10, paramView.uid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xke
 * JD-Core Version:    0.7.0.1
 */