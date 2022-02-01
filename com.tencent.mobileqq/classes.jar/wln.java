import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import java.util.Comparator;

public class wln
  implements Comparator<QQUserUIItem>
{
  public wln(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public int a(QQUserUIItem paramQQUserUIItem1, QQUserUIItem paramQQUserUIItem2)
  {
    return ampx.a(paramQQUserUIItem1.mComparePartInt, paramQQUserUIItem1.mCompareSpell, paramQQUserUIItem2.mComparePartInt, paramQQUserUIItem2.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wln
 * JD-Core Version:    0.7.0.1
 */