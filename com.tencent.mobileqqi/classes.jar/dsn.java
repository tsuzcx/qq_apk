import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;

public class dsn
  extends FriendListObserver
{
  public dsn(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      return;
      paramString = ((FriendManager)this.a.b.getManager(8)).a(paramString);
    } while (paramString == null);
    TroopRequestActivity.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsn
 * JD-Core Version:    0.7.0.1
 */