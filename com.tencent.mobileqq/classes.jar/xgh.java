import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import java.util.Comparator;

public class xgh
  implements Comparator<QQUserUIItem>
{
  public xgh(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public int a(QQUserUIItem paramQQUserUIItem1, QQUserUIItem paramQQUserUIItem2)
  {
    return anjs.a(paramQQUserUIItem1.mComparePartInt, paramQQUserUIItem1.mCompareSpell, paramQQUserUIItem2.mComparePartInt, paramQQUserUIItem2.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgh
 * JD-Core Version:    0.7.0.1
 */