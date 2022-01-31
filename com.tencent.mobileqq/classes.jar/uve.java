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

public class uve
  extends unf
{
  public qqstory_service.RspMsgTabNodeVideoList a;
  public List<uup> a;
  public utx a;
  public byte[] a;
  
  public uve(utx paramutx, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
  {
    super(paramRspMsgTabNodeVideoList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Utx = paramutx;
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
      if (paramutx.jdField_a_of_type_Int == 12)
      {
        wsv.a("Q.qqstory:ReqMsgTabNodeVideoList", "new video list receive cookie:%s nodeInfo old size=%d, rsp.video_list size=%d", paramRspMsgTabNodeVideoList.cookie.get(), Integer.valueOf(paramutx.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramRspMsgTabNodeVideoList.video_list.size()));
        paramArrayOfByte = new HashSet();
        paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
        if (paramRspMsgTabNodeVideoList.hasNext())
        {
          localObject1 = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
          localObject2 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).feed_id.get().toStringUtf8();
          localObject3 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).video_index_list.get().iterator();
          i = 0;
          uup localuup;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Long)((Iterator)localObject3).next();
            localuup = uup.a(paramutx.jdField_a_of_type_JavaUtilList, ((Long)localObject4).longValue());
            if ((localuup != null) && (!paramArrayOfByte.contains(localObject4))) {
              break label339;
            }
            localuup = new uup();
            localuup.jdField_b_of_type_JavaLangString = ((String)localObject2);
            localuup.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
            localuup.jdField_a_of_type_Long = paramutx.jdField_a_of_type_JavaUtilList.size();
            localuup.jdField_a_of_type_Boolean = false;
            if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
              localuup.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
            }
            paramutx.jdField_a_of_type_JavaUtilList.add(localuup);
            this.jdField_a_of_type_JavaUtilList.add(localuup);
            paramArrayOfByte.add(localObject4);
          }
          for (;;)
          {
            i += 1;
            break label158;
            break;
            label339:
            localuup.jdField_b_of_type_JavaLangString = ((String)localObject2);
            localuup.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
            if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
              localuup.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
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
            localObject4 = uup.a(paramutx.jdField_a_of_type_JavaUtilList, ((Long)localObject3).longValue());
            if (localObject4 != null) {
              break label537;
            }
            wsv.e("Q.qqstory:ReqMsgTabNodeVideoList", "find index %d return null!, videoList is = %s", new Object[] { localObject3, paramutx.jdField_a_of_type_JavaUtilList });
          }
          for (;;)
          {
            i += 1;
            break label464;
            break;
            label537:
            ((uup)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((uup)localObject4).jdField_a_of_type_JavaLangString = ((ByteStringMicro)paramArrayOfByte.vid_list.get(i)).toStringUtf8();
            if (paramArrayOfByte.recommand_id_list.has()) {
              ((uup)localObject4).jdField_b_of_type_Long = ((Integer)paramArrayOfByte.recommand_id_list.get(i)).intValue();
            }
          }
        }
        this.jdField_a_of_type_JavaUtilList = paramutx.jdField_a_of_type_JavaUtilList;
      }
      if (!paramutx.a()) {
        wsv.d("Q.qqstory:ReqMsgTabNodeVideoList", "node info is not ok, %s", new Object[] { paramutx.jdField_a_of_type_JavaUtilList });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uve
 * JD-Core Version:    0.7.0.1
 */