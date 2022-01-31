import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.StringUtil;

public final class esh
  implements Runnable
{
  public esh(QQAppInterface paramQQAppInterface, long paramLong, String paramString, CardHandler paramCardHandler) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject1;
    long l;
    if (localEntityManager != null)
    {
      localObject1 = null;
      if (this.jdField_a_of_type_Long > 0L) {
        localObject1 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (!StringUtil.b(this.jdField_a_of_type_JavaLangString)) {
          localObject2 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_JavaLangString });
        }
      }
      if (localObject2 != null)
      {
        localObject1 = ((NearbyPeopleCard)localObject2).vSeed;
        l = ((NearbyPeopleCard)localObject2).feedPreviewTime;
        localEntityManager.a();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Long > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0", 41, l, (byte)0, 0L, 0L, (byte[])localObject1, "", NearbyProfileUtil.a(), 10004, null, this.jdField_a_of_type_Long, true);
      }
      while (StringUtil.b(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, 0L, (byte)0, 0L, 0L, null, "", NearbyProfileUtil.a(), 10004, null, 0L, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, 6, l, (byte)0, 0L, 0L, (byte[])localObject1, "", NearbyProfileUtil.a(), 10004, null, 0L, true);
      return;
      l = 0L;
      localObject1 = null;
      break;
      l = 0L;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     esh
 * JD-Core Version:    0.7.0.1
 */