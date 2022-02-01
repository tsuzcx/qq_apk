import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;

public class ugp
{
  public static ugp a()
  {
    return new ugp();
  }
  
  private ukd a(String paramString, int paramInt)
  {
    return new ugr(this, paramInt, paramString);
  }
  
  private void c(String paramString, int paramInt)
  {
    FollowEvent localFollowEvent = new FollowEvent();
    localFollowEvent.setPersonId(paramString);
    if (paramInt == 1) {
      localFollowEvent.setIsFollow(1);
    }
    for (;;)
    {
      uhf.a().a(localFollowEvent);
      return;
      localFollowEvent.setIsFollow(2);
    }
  }
  
  public void a(String paramString)
  {
    uqf.b("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + paramString);
    paramString = new uko(new uok(paramString), null, new ugq(this), 4006);
    ukh.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt)
  {
    uqf.b("WSUserBusiness", "[actionChangeFollow] personID : " + paramString + "  followStatus:" + paramInt);
    c(paramString, paramInt);
    paramString = new uko(new uol(paramString, paramInt), null, a(paramString, paramInt), 4005);
    ukh.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugp
 * JD-Core Version:    0.7.0.1
 */