import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMFollwerAdd;

public class yuf
  extends ytv
{
  public QIMFollwerAdd a;
  
  public yuf(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.a = paramQIMFollwerAdd;
    this.Kz = paramQIMFollwerAdd.upTime;
  }
  
  public String getUin()
  {
    return String.valueOf(this.a.uin);
  }
  
  public boolean isReaded()
  {
    return this.a.isRead;
  }
  
  public String o(QQAppInterface paramQQAppInterface)
  {
    return "getMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yuf
 * JD-Core Version:    0.7.0.1
 */