import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class vmm
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static vmm a()
  {
    return vmo.a();
  }
  
  public stSimpleMetaFeed a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    WSRedDotPushMsg localWSRedDotPushMsg = vnd.a();
    if (localWSRedDotPushMsg != null) {
      this.jdField_a_of_type_JavaLangString = localWSRedDotPushMsg.mPushId;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */