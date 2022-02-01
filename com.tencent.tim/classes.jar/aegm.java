import android.text.TextUtils;
import com.tencent.mobileqq.confess.BaseMsgListFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class aegm
  extends acfd
{
  public aegm(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof HashMap))) {}
    try
    {
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      do
      {
        Map.Entry localEntry;
        do
        {
          if (!paramObject.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)paramObject.next();
        } while (localEntry == null);
        paramBoolean = this.this$0.X((String)localEntry.getKey(), 2);
      } while (!paramBoolean);
      i = 1;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        int i = 0;
        continue;
        i = 0;
      }
    }
    if (i != 0) {
      this.this$0.cWP();
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.this$0.X(paramString, 1))) {
      this.this$0.cWP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegm
 * JD-Core Version:    0.7.0.1
 */