import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;

public class enp
  extends BizTroopObserver
{
  public enp(NearbyOpenTroop paramNearbyOpenTroop) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (!paramString2.equals(this.a.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      NearbyOpenTroop.a(this.a);
      return;
    }
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.b = true;
      this.a.d = paramString1;
      this.a.e = paramString2;
      this.a.c = paramBoolean;
      this.a.f = paramString3;
      return;
    }
    NearbyOpenTroop.a(this.a, paramString1, paramString2, paramBoolean, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     enp
 * JD-Core Version:    0.7.0.1
 */