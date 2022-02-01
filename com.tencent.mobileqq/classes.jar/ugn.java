import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;

public class ugn
{
  public static ugn a()
  {
    return new ugn();
  }
  
  private ujj a(String paramString, int paramInt)
  {
    return new ugp(this, paramInt, paramString);
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
      uhd.a().a(localFollowEvent);
      return;
      localFollowEvent.setIsFollow(2);
    }
  }
  
  public void a(String paramString)
  {
    upe.b("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + paramString);
    paramString = new uju(new unj(paramString), null, new ugo(this), 4006);
    ujn.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt)
  {
    upe.b("WSUserBusiness", "[actionChangeFollow] personID : " + paramString + "  followStatus:" + paramInt);
    c(paramString, paramInt);
    paramString = new uju(new unk(paramString, paramInt), null, a(paramString, paramInt), 4005);
    ujn.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugn
 * JD-Core Version:    0.7.0.1
 */