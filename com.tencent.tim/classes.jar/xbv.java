import android.util.LruCache;
import com.tencent.mobileqq.data.MessageForPoke;

class xbv
  extends LruCache<Long, MessageForPoke>
{
  xbv(xbu paramxbu, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, MessageForPoke paramMessageForPoke1, MessageForPoke paramMessageForPoke2)
  {
    if ((paramMessageForPoke1 != null) && (!paramMessageForPoke1.isPlayed))
    {
      paramMessageForPoke1.setPlayed(this.this$0.mApp);
      paramMessageForPoke1.mFrameState.hi = false;
      paramMessageForPoke1.mFrameState.aPN = true;
      paramMessageForPoke1.mUnlimitedState.hi = false;
      paramMessageForPoke1.mUnlimitedState.aPN = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbv
 * JD-Core Version:    0.7.0.1
 */