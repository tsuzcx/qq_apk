import android.text.TextUtils;
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

public class veq
  extends urt<vgv>
{
  private final HashMap<String, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final List<Long> jdField_a_of_type_JavaUtilList;
  private final List<Integer> b;
  private final int c;
  
  public veq(String paramString, List<String> paramList, List<Long> paramList1, List<Integer> paramList2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("union_id should not be empty");
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      throw new IllegalArgumentException("vidList is empty");
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Collections.unmodifiableList(paramList));
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.c = paramInt;
  }
  
  public String a()
  {
    return uqn.a("StoryGroupSvc.add_video");
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspAddGroupVideo localRspAddGroupVideo = new qqstory_group.RspAddGroupVideo();
    try
    {
      localRspAddGroupVideo.mergeFrom(paramArrayOfByte);
      return new vgv(localRspAddGroupVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        wxe.b("AddGroupVideoRequest", "decodeResponse", paramArrayOfByte);
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqAddGroupVideo localReqAddGroupVideo = new qqstory_group.ReqAddGroupVideo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      qqstory_group.GroupVideo localGroupVideo = new qqstory_group.GroupVideo();
      localGroupVideo.source.set(this.c);
      localGroupVideo.union_id.set(ByteStringMicro.copyFromUtf8((String)((Map.Entry)localObject).getKey()));
      int i = 0;
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        qqstory_group.VideoObject localVideoObject = new qqstory_group.VideoObject();
        localVideoObject.vid.set(ByteStringMicro.copyFromUtf8(str));
        localVideoObject.ts.set(((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue() / 1000L);
        localVideoObject.time_zone.set(((Integer)this.b.get(i)).intValue());
        localGroupVideo.video_obj_list.add(localVideoObject);
        i += 1;
      }
      localReqAddGroupVideo.group_video_list.add(localGroupVideo);
    }
    return localReqAddGroupVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     veq
 * JD-Core Version:    0.7.0.1
 */