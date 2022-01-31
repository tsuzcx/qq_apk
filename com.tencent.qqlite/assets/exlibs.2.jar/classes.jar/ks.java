import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.mobileqq.app.MessageObserver;

public class ks
  extends MessageObserver
{
  public ks(TroopRedTouchHandler paramTroopRedTouchHandler) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (105 == paramInt) {
      this.a.a(105, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ks
 * JD-Core Version:    0.7.0.1
 */