import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;

public class akhm
  extends ajpa
{
  public akhm(NearbyProfileFragment paramNearbyProfileFragment, long paramLong) {}
  
  public void O(long paramLong1, long paramLong2)
  {
    if ((this.gg == paramLong1) && (paramLong2 > 0L))
    {
      NearbyProfileFragment.a(this.b).tinyId = paramLong2;
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.b.a;
      if (!NearbyPeopleProfileActivity.kI(this.b.a.from)) {
        this.b.a.adP = paramLong2;
      }
      this.b.kq(paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhm
 * JD-Core Version:    0.7.0.1
 */