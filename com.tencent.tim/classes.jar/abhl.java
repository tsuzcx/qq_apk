import com.tencent.mobileqq.DrawerPushItem;
import java.util.Comparator;

class abhl
  implements Comparator<DrawerPushItem>
{
  abhl(abhh paramabhh) {}
  
  public int a(DrawerPushItem paramDrawerPushItem1, DrawerPushItem paramDrawerPushItem2)
  {
    if (paramDrawerPushItem2.priority == paramDrawerPushItem1.priority) {
      return paramDrawerPushItem1.sub_priority - paramDrawerPushItem2.sub_priority;
    }
    return paramDrawerPushItem1.priority - paramDrawerPushItem2.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhl
 * JD-Core Version:    0.7.0.1
 */