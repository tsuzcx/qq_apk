import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class qun
  extends SimpleJob<Object>
{
  qun(qul paramqul, String paramString1, String paramString2, String paramString3, int paramInt, View paramView)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    Object localObject = (psn)psx.a(19);
    paramJobContext = new ArrayList();
    paramVarArgs = ((psn)localObject).a(qul.a(this.this$0).mUid, paramJobContext);
    if ((paramVarArgs == null) || (paramVarArgs.size() == 0))
    {
      rom.fail("data key null for unionId:%s", new Object[] { qul.a(this.this$0).mUid });
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.aye);
    qul.a(this.this$0).eA(localArrayList);
    int i = paramVarArgs.indexOf(this.aye);
    if (i == -1)
    {
      ram.e("Q.qqstory.memories.MemoriesVideoListSegment", "onVideoItemClick but can't find item, collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.aye, paramJobContext, this.val$vid, Integer.valueOf(i), Integer.valueOf(this.val$position), paramVarArgs });
      return null;
    }
    localObject = ((psn)localObject).a(pxg.fT(qul.a(this.this$0).mUid));
    if ((localObject != null) && (((MemoryInfoEntry)localObject).isEnd == 1)) {}
    localObject = ((ptf)psx.a(2)).b(qul.a(this.this$0).mUid);
    ThreadManager.getUIHandler().post(new MemoriesVideoListSegment.2.1(this, paramJobContext, i, paramVarArgs, (QQUserUIItem)localObject));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qun
 * JD-Core Version:    0.7.0.1
 */