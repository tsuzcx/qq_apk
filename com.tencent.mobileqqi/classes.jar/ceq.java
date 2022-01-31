import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;

public class ceq
  extends TroopQZoneUploadAlbumObserver
{
  public ceq(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return;
    }
    paramObject = (String)paramObject;
    this.a.a(8, paramObject, -2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ceq
 * JD-Core Version:    0.7.0.1
 */