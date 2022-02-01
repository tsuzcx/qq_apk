import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;

public class yug
  extends ytv
{
  public QIMNotifyAddFriend a;
  
  public yug(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    this.a = paramQIMNotifyAddFriend;
    this.Kz = paramQIMNotifyAddFriend.pushTime;
  }
  
  public String getUin()
  {
    return String.valueOf(this.a.uin);
  }
  
  public boolean isReaded()
  {
    return this.a.hasRead;
  }
  
  public String o(QQAppInterface paramQQAppInterface)
  {
    return "getMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yug
 * JD-Core Version:    0.7.0.1
 */