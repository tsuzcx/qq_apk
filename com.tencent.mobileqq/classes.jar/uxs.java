import android.util.LruCache;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder;
import com.tencent.mobileqq.data.MessageForPoke;

public class uxs
  extends LruCache
{
  public uxs(GivingHeartItemBuilder paramGivingHeartItemBuilder, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, MessageForPoke paramMessageForPoke1, MessageForPoke paramMessageForPoke2)
  {
    if ((paramMessageForPoke1 != null) && (!paramMessageForPoke1.isPlayed))
    {
      paramMessageForPoke1.setPlayed(this.a.b);
      paramMessageForPoke1.mFrameState.a = false;
      paramMessageForPoke1.mFrameState.c = true;
      paramMessageForPoke1.mUnlimitedState.a = false;
      paramMessageForPoke1.mUnlimitedState.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxs
 * JD-Core Version:    0.7.0.1
 */