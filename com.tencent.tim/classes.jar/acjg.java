import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import java.util.Comparator;

class acjg
  implements Comparator<QIMNotifyAddFriend>
{
  acjg(acjf paramacjf) {}
  
  public int a(QIMNotifyAddFriend paramQIMNotifyAddFriend1, QIMNotifyAddFriend paramQIMNotifyAddFriend2)
  {
    return (int)(paramQIMNotifyAddFriend2.pushTime - paramQIMNotifyAddFriend1.pushTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acjg
 * JD-Core Version:    0.7.0.1
 */