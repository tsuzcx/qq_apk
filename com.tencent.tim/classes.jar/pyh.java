import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqAddGroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspAddGroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.VideoObject;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class pyh
  extends ppw<pzx>
{
  private final HashMap<String, List<String>> fm = new HashMap();
  private final List<Long> nc;
  private final List<Integer> nd;
  private final int source;
  
  public pyh(String paramString, List<String> paramList, List<Long> paramList1, List<Integer> paramList2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("union_id should not be empty");
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      throw new IllegalArgumentException("vidList is empty");
    }
    this.fm.put(paramString, Collections.unmodifiableList(paramList));
    this.nc = paramList1;
    this.nd = paramList2;
    this.source = paramInt;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspAddGroupVideo localRspAddGroupVideo = new qqstory_group.RspAddGroupVideo();
    try
    {
      localRspAddGroupVideo.mergeFrom(paramArrayOfByte);
      return new pzx(localRspAddGroupVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        ram.w("AddGroupVideoRequest", "decodeResponse", paramArrayOfByte);
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_group.ReqAddGroupVideo localReqAddGroupVideo = new qqstory_group.ReqAddGroupVideo();
    Iterator localIterator = this.fm.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      qqstory_group.GroupVideo localGroupVideo = new qqstory_group.GroupVideo();
      localGroupVideo.source.set(this.source);
      localGroupVideo.union_id.set(ByteStringMicro.copyFromUtf8((String)((Map.Entry)localObject).getKey()));
      int i = 0;
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        qqstory_group.VideoObject localVideoObject = new qqstory_group.VideoObject();
        localVideoObject.vid.set(ByteStringMicro.copyFromUtf8(str));
        localVideoObject.ts.set(((Long)this.nc.get(i)).longValue() / 1000L);
        localVideoObject.time_zone.set(((Integer)this.nd.get(i)).intValue());
        localGroupVideo.video_obj_list.add(localVideoObject);
        i += 1;
      }
      localReqAddGroupVideo.group_video_list.add(localGroupVideo);
    }
    return localReqAddGroupVideo.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StoryGroupSvc.add_video");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyh
 * JD-Core Version:    0.7.0.1
 */