import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import java.util.Comparator;

public class vmv
  implements Comparator<QQUserUIItem>
{
  public vmv(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public int a(QQUserUIItem paramQQUserUIItem1, QQUserUIItem paramQQUserUIItem2)
  {
    return alqj.a(paramQQUserUIItem1.mComparePartInt, paramQQUserUIItem1.mCompareSpell, paramQQUserUIItem2.mComparePartInt, paramQQUserUIItem2.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmv
 * JD-Core Version:    0.7.0.1
 */