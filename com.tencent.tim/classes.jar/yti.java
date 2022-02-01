import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import java.util.ArrayList;
import java.util.Iterator;

public class yti
  extends acdv
{
  public yti(SystemMsgListView paramSystemMsgListView) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      long l = Long.parseLong(paramString);
      SystemMsgListView.a(this.this$0).gt(l);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.this$0).gt(paramLong);
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      if (!(paramObject instanceof ArrayList)) {
        break label76;
      }
    }
    label76:
    for (paramObject = (ArrayList)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if ((localObject instanceof Long)) {
            SystemMsgListView.a(this.this$0).gt(((Long)localObject).longValue());
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yti
 * JD-Core Version:    0.7.0.1
 */