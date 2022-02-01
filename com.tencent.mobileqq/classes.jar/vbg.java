import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;

public class vbg
{
  public static vbg a()
  {
    return new vbg();
  }
  
  private vfg a(String paramString, int paramInt)
  {
    return new vbi(this, paramInt, paramString);
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
      vbw.a().a(localFollowEvent);
      return;
      localFollowEvent.setIsFollow(2);
    }
  }
  
  public void a(String paramString)
  {
    vmp.b("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + paramString);
    paramString = new vfr(new vks(paramString), null, new vbh(this), 4006);
    vfk.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt)
  {
    vmp.b("WSUserBusiness", "[actionChangeFollow] personID : " + paramString + "  followStatus:" + paramInt);
    c(paramString, paramInt);
    paramString = new vfr(new vkt(paramString, paramInt), null, a(paramString, paramInt), 4005);
    vfk.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbg
 * JD-Core Version:    0.7.0.1
 */