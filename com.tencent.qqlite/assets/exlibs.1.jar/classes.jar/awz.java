import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;

public class awz
  implements Runnable
{
  public awz(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    if (localEntityManager != null) {
      if (NearbyPeopleProfileActivity.a(this.a) <= 0L) {
        break label289;
      }
    }
    label289:
    for (Object localObject2 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(NearbyPeopleProfileActivity.a(this.a)) });; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!StringUtil.b(NearbyPeopleProfileActivity.a(this.a).jdField_a_of_type_JavaLangString)) {
          localObject1 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.a).jdField_a_of_type_JavaLangString });
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject2).tinyId = NearbyPeopleProfileActivity.a(this.a);
        ((NearbyPeopleCard)localObject2).uin = NearbyPeopleProfileActivity.a(this.a).jdField_a_of_type_JavaLangString;
      }
      ((NearbyPeopleCard)localObject2).nickname = NearbyPeopleProfileActivity.a(this.a).h;
      ((NearbyPeopleCard)localObject2).age = NearbyPeopleProfileActivity.a(this.a).jdField_b_of_type_Int;
      ((NearbyPeopleCard)localObject2).gender = NearbyPeopleProfileActivity.a(this.a).jdField_a_of_type_Byte;
      ((NearbyPeopleCard)localObject2).maritalStatus = NearbyPeopleProfileActivity.a(this.a).jdField_b_of_type_Byte;
      ((NearbyPeopleCard)localObject2).job = NearbyPeopleProfileActivity.a(this.a).jdField_c_of_type_Int;
      ((NearbyPeopleCard)localObject2).constellation = NearbyPeopleProfileActivity.a(this.a).jdField_c_of_type_Byte;
      ((NearbyPeopleCard)localObject2).xuanYan = NearbyPeopleProfileActivity.a(this.a).jdField_a_of_type_ArrayOfByte;
      ((NearbyPeopleCard)localObject2).distance = NearbyPeopleProfileActivity.a(this.a).jdField_b_of_type_JavaLangString;
      ((NearbyPeopleCard)localObject2).timeDiff = null;
      this.a.a.obtainMessage(101, localObject2).sendToTarget();
      localEntityManager.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awz
 * JD-Core Version:    0.7.0.1
 */