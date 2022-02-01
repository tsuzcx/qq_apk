import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;

public class xak
  extends yev
{
  public xak(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      weg.a(this.a.a, 10, paramView.uid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xak
 * JD-Core Version:    0.7.0.1
 */