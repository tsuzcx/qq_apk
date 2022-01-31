import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class tsa
{
  public QQCircleFeedBase.StTabInfo a;
  private boolean a;
  
  public tsa(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo = paramStTabInfo;
  }
  
  public static tsa a(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    return new tsa(paramStTabInfo);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo.tabType.get();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo.tabName.get();
  }
  
  public tsa a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
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
  
  public String b()
  {
    return this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo.attachInfo.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsa
 * JD-Core Version:    0.7.0.1
 */