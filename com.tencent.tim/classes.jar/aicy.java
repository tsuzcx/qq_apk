import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class aicy
  implements aicn
{
  aicy(aicu paramaicu) {}
  
  public void ld(List<aidd> paramList)
  {
    if (aicu.a(this.this$0) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(aicu.a(this.this$0).a().cY);
      acjq localacjq = aicu.a(this.this$0).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aidd localaidd = (aidd)paramList.next();
        long[] arrayOfLong = new long[localaidd.Cu.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localaidd.Cu.get(i)).longValue();
          i += 1;
        }
        ((apuk)aicu.a(this.this$0).getManager(164)).lT(localaidd.groupUin);
        localacjq.a(1, String.valueOf(localaidd.groupUin), localaidd.userNum, arrayOfLong, 14, localaidd.ang, localaidd.gameId, localaidd.aqz);
        ((Map)localObject).remove(String.valueOf(localaidd.groupUin));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localacjq.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
        }
      }
      paramList = aicu.a(this.this$0).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicy
 * JD-Core Version:    0.7.0.1
 */