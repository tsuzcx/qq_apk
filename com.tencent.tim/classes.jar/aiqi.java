import com.tencent.mobileqq.activity.BaseChatPie;

public class aiqi
  extends aiqd
{
  public aiqi(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public boolean apk()
  {
    return true;
  }
  
  public void ccU()
  {
    if ((this.mBaseChatPie instanceof xys)) {
      ((xys)this.mBaseChatPie).ccU();
    }
  }
  
  public boolean isAdmin()
  {
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Aiqd$b.mCurType = 2;
    this.jdField_a_of_type_Aiqd$b.mCurUin = this.mBaseChatPie.oL();
    if (this.jdField_a_of_type_Aiqd$b.mCurUin == null) {
      this.jdField_a_of_type_Aiqd$b.mCurUin = "";
    }
    this.jdField_a_of_type_Aiqd$a = new aiqd.a();
    this.jdField_a_of_type_Aiqd$a.mainAction = "c2c_AIO";
    this.jdField_a_of_type_Aiqd$a.deQ = -1;
    this.jdField_a_of_type_Aiqd$a.bPt = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqi
 * JD-Core Version:    0.7.0.1
 */