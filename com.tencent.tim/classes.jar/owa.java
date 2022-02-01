import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class owa
{
  public QQCircleFeedBase.StTabInfo a;
  private boolean ayM;
  
  public owa(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    this.a = paramStTabInfo;
  }
  
  public static owa a(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    return new owa(paramStTabInfo);
  }
  
  public boolean HE()
  {
    return this.ayM;
  }
  
  public owa a(boolean paramBoolean)
  {
    this.ayM = paramBoolean;
    return this;
  }
  
  public String ck()
  {
    return this.a.attachInfo.get();
  }
  
  public String getName()
  {
    return this.a.tabName.get();
  }
  
  public int getSource()
  {
    switch (getType())
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
  
  public int getType()
  {
    return this.a.tabType.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owa
 * JD-Core Version:    0.7.0.1
 */