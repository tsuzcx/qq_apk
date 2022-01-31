import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class trv
{
  public QQCircleFeedBase.StTabInfo a;
  
  public trv(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    this.a = paramStTabInfo;
  }
  
  public static trv a(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    return new trv(paramStTabInfo);
  }
  
  public int a()
  {
    return this.a.tabType.get();
  }
  
  public String a()
  {
    return this.a.tabName.get();
  }
  
  public int b()
  {
    return this.a.status.get();
  }
  
  public String b()
  {
    return this.a.attachInfo.get();
  }
  
  public int c()
  {
    switch (a())
    {
    case 5: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 4;
    case 3: 
      return 6;
    case 4: 
      return 5;
    }
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trv
 * JD-Core Version:    0.7.0.1
 */