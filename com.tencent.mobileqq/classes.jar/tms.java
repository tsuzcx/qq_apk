import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tms
{
  public static tms a()
  {
    return tmu.a();
  }
  
  public List<tmv> a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtils.isEmpty(paramArrayList))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((paramArrayList.get(i) instanceof stSimpleMetaFeed))
        {
          stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(i);
          tmv localtmv = new tmv();
          localtmv.a(localstSimpleMetaFeed);
          localArrayList.add(localtmv);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, WSRedDotPushMsg paramWSRedDotPushMsg, List<stSimpleMetaFeed> paramList, tmr paramtmr)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "";
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((stSimpleMetaFeed)paramList.next()).id);
      }
    }
    paramList = str;
    if (paramWSRedDotPushMsg != null) {
      paramList = paramWSRedDotPushMsg.mMsgData;
    }
    paramWSRedDotPushMsg = new tmt(this, paramtmr);
    byte b1;
    if (paramBoolean1)
    {
      b1 = 1;
      if (!paramBoolean2) {
        break label155;
      }
    }
    label155:
    for (byte b2 = 1;; b2 = 0)
    {
      paramWSRedDotPushMsg = new the(new tkn("", b1, b2, localArrayList, paramInt, "", "", "", paramList), null, paramWSRedDotPushMsg, 1001);
      tgx.a().a(paramWSRedDotPushMsg);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tms
 * JD-Core Version:    0.7.0.1
 */