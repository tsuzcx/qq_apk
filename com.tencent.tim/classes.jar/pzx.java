import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspAddGroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.VideoStoryId;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tribe.async.utils.AssertUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class pzx
  extends ppu
{
  private final qqstory_group.RspAddGroupVideo a;
  
  public pzx(qqstory_group.RspAddGroupVideo paramRspAddGroupVideo)
  {
    super(paramRspAddGroupVideo.result);
    this.a = paramRspAddGroupVideo;
  }
  
  public List<pzx.a> bN()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.group_feed_list.get().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new pzx.a((qqstory_group.GroupFeed)localIterator.next()));
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "AddGroupVideoResponse{mRspAddGroupVideo=" + bN() + '}';
  }
  
  public static class a
  {
    @NonNull
    public final Map<String, String> fN;
    @NonNull
    public String feedId;
    @NonNull
    public final String unionId;
    
    public a(@NonNull qqstory_group.GroupFeed paramGroupFeed)
    {
      this.unionId = paramGroupFeed.union_id.get().toStringUtf8();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramGroupFeed.story_id_list.get().iterator();
      if (localIterator.hasNext())
      {
        qqstory_group.VideoStoryId localVideoStoryId = (qqstory_group.VideoStoryId)localIterator.next();
        String str = localVideoStoryId.story_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(str)) {}
        for (boolean bool = true;; bool = false)
        {
          AssertUtils.assertTrue(bool);
          localHashMap.put(localVideoStoryId.vid.get().toStringUtf8(), str);
          this.feedId = localVideoStoryId.feed_id.get().toStringUtf8();
          break;
        }
      }
      if (TextUtils.isEmpty(this.feedId)) {
        this.feedId = paramGroupFeed.feed_id.get().toStringUtf8();
      }
      this.fN = Collections.unmodifiableMap(localHashMap);
    }
    
    public String toString()
    {
      return "AddGroupFeed[" + this.unionId + "," + this.feedId + "," + this.fN + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzx
 * JD-Core Version:    0.7.0.1
 */