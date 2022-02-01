import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1;

public class ajud
  extends ajrw
{
  public ajud(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      this.this$0.app.dE(this.this$0.app.getCurrentAccountUin(), 200);
      long l = ((Long)ajrb.c(this.this$0.app.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      if (l != 0L) {
        this.this$0.app.dE(String.valueOf(l), 202);
      }
    }
    this.this$0.runOnUiThread(new NearbyGuideActivity.2.1(this, paramBoolean1, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajud
 * JD-Core Version:    0.7.0.1
 */