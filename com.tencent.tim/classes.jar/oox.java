import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class oox
{
  private String mPushId;
  
  public static oox a()
  {
    return oox.a.b();
  }
  
  public String getPushId()
  {
    return this.mPushId;
  }
  
  public void init()
  {
    WSRedDotPushMsg localWSRedDotPushMsg = opn.b();
    if (localWSRedDotPushMsg != null) {
      this.mPushId = localWSRedDotPushMsg.mPushId;
    }
  }
  
  public void release()
  {
    this.mPushId = "";
  }
  
  static class a
  {
    private static final oox a = new oox(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oox
 * JD-Core Version:    0.7.0.1
 */