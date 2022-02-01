import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;

public class ung
{
  public static ung a()
  {
    return new ung();
  }
  
  private uqy a(String paramString, int paramInt)
  {
    return new uni(this, paramInt, paramString);
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
      unw.a().a(localFollowEvent);
      return;
      localFollowEvent.setIsFollow(2);
    }
  }
  
  public void a(String paramString)
  {
    uya.b("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + paramString);
    paramString = new urj(new uwe(paramString), null, new unh(this), 4006);
    urc.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt)
  {
    uya.b("WSUserBusiness", "[actionChangeFollow] personID : " + paramString + "  followStatus:" + paramInt);
    c(paramString, paramInt);
    paramString = new urj(new uwf(paramString, paramInt), null, a(paramString, paramInt), 4005);
    urc.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ung
 * JD-Core Version:    0.7.0.1
 */