import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVidInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class vyk
  extends vqm
{
  public qqstory_service.RspMsgTabNodeVideoList a;
  public List<vxv> a;
  public vxd a;
  public byte[] a;
  
  public vyk(vxd paramvxd, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
  {
    super(paramRspMsgTabNodeVideoList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Vxd = paramvxd;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (paramRspMsgTabNodeVideoList.video_list != null)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int i;
      label158:
      Object localObject4;
      if (paramvxd.jdField_a_of_type_Int == 12)
      {
        xvv.a("Q.qqstory:ReqMsgTabNodeVideoList", "new video list receive cookie:%s nodeInfo old size=%d, rsp.video_list size=%d", paramRspMsgTabNodeVideoList.cookie.get(), Integer.valueOf(paramvxd.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramRspMsgTabNodeVideoList.video_list.size()));
        paramArrayOfByte = new HashSet();
        paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
        if (paramRspMsgTabNodeVideoList.hasNext())
        {
          localObject1 = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
          localObject2 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).feed_id.get().toStringUtf8();
          localObject3 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).video_index_list.get().iterator();
          i = 0;
          vxv localvxv;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Long)((Iterator)localObject3).next();
            localvxv = vxv.a(paramvxd.jdField_a_of_type_JavaUtilList, ((Long)localObject4).longValue());
            if ((localvxv != null) && (!paramArrayOfByte.contains(localObject4))) {
              break label339;
            }
            localvxv = new vxv();
            localvxv.jdField_b_of_type_JavaLangString = ((String)localObject2);
            localvxv.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
            localvxv.jdField_a_of_type_Long = paramvxd.jdField_a_of_type_JavaUtilList.size();
            localvxv.jdField_a_of_type_Boolean = false;
            if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
              localvxv.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
            }
            paramvxd.jdField_a_of_type_JavaUtilList.add(localvxv);
            this.jdField_a_of_type_JavaUtilList.add(localvxv);
            paramArrayOfByte.add(localObject4);
          }
          for (;;)
          {
            i += 1;
            break label158;
            break;
            label339:
            localvxv.jdField_b_of_type_JavaLangString = ((String)localObject2);
            localvxv.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
            if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
              localvxv.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
            }
          }
        }
      }
      else
      {
        paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
        if (paramRspMsgTabNodeVideoList.hasNext())
        {
          paramArrayOfByte = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
          localObject1 = paramArrayOfByte.feed_id.get().toStringUtf8();
          localObject2 = paramArrayOfByte.video_index_list.get().iterator();
          i = 0;
          label464:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            localObject4 = vxv.a(paramvxd.jdField_a_of_type_JavaUtilList, ((Long)localObject3).longValue());
            if (localObject4 != null) {
              break label537;
            }
            xvv.e("Q.qqstory:ReqMsgTabNodeVideoList", "find index %d return null!, videoList is = %s", new Object[] { localObject3, paramvxd.jdField_a_of_type_JavaUtilList });
          }
          for (;;)
          {
            i += 1;
            break label464;
            break;
            label537:
            ((vxv)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((vxv)localObject4).jdField_a_of_type_JavaLangString = ((ByteStringMicro)paramArrayOfByte.vid_list.get(i)).toStringUtf8();
            if (paramArrayOfByte.recommand_id_list.has()) {
              ((vxv)localObject4).jdField_b_of_type_Long = ((Integer)paramArrayOfByte.recommand_id_list.get(i)).intValue();
            }
          }
        }
        this.jdField_a_of_type_JavaUtilList = paramvxd.jdField_a_of_type_JavaUtilList;
      }
      if (!paramvxd.a()) {
        xvv.d("Q.qqstory:ReqMsgTabNodeVideoList", "node info is not ok, %s", new Object[] { paramvxd.jdField_a_of_type_JavaUtilList });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyk
 * JD-Core Version:    0.7.0.1
 */