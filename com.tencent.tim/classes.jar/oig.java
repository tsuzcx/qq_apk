import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;

public class oig
{
  public static oig a()
  {
    return new oig();
  }
  
  private oko a(String paramString, int paramInt)
  {
    return new oii(this, paramInt, paramString);
  }
  
  private void aZ(String paramString, int paramInt)
  {
    FollowEvent localFollowEvent = new FollowEvent();
    localFollowEvent.setPersonId(paramString);
    if (paramInt == 1) {
      localFollowEvent.setIsFollow(1);
    }
    for (;;)
    {
      oiv.a().b(localFollowEvent);
      return;
      localFollowEvent.setIsFollow(2);
    }
  }
  
  public void aY(String paramString, int paramInt)
  {
    ooz.d("WSUserBusiness", "[actionChangeFollow] personID : " + paramString + "  followStatus:" + paramInt);
    aZ(paramString, paramInt);
    paramString = new okz(new onn(paramString, paramInt), null, a(paramString, paramInt), 4005);
    oks.a().b(paramString);
  }
  
  public void changeFollow(String paramString, int paramInt)
  {
    aY(paramString, paramInt);
  }
  
  public void pB(String paramString)
  {
    ooz.d("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + paramString);
    paramString = new okz(new onm(paramString), null, new oih(this), 4006);
    oks.a().b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oig
 * JD-Core Version:    0.7.0.1
 */