import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.qphone.base.util.QLog;

public class aym
  implements Runnable
{
  public aym(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    NearbyPeopleProfileActivity.m(this.a);
    if (QLog.isColorLevel()) {
      QLog.i("Q.dating", 2, "updateDateSig sig = " + NearbyPeopleProfileActivity.a(this.a).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aym
 * JD-Core Version:    0.7.0.1
 */