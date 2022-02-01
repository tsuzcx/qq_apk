import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.ReqBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.RspBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListReq;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListRsp;
import tencent.kandian.ugc.topic_info.TopicInfo;

public class mnn
  extends lji<ColumnInfo, ByteString>
{
  private int aTJ;
  private QQAppInterface app = (QQAppInterface)kxm.getAppRuntime();
  private boolean cj;
  
  private void a(lji.a<ColumnInfo, ByteString> parama, byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new oidb_0xe31.RspBody();
        ((oidb_0xe31.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if ((!((oidb_0xe31.RspBody)localObject).topic_list_req_rsp.has()) || (((oidb_0xe31.RspBody)localObject).topic_list_req_rsp.topics.size() == 0))
        {
          QLog.e("RIJUGC.MyColumnModel", 1, "handleSuccessResult no column data!");
          return;
        }
        paramArrayOfByte = ((oidb_0xe31.RspBody)localObject).topic_list_req_rsp;
        localObject = paramArrayOfByte.topics.get();
        i = 0;
        if (i < ((List)localObject).size())
        {
          ColumnInfo localColumnInfo = new ColumnInfo((topic_info.TopicInfo)((List)localObject).get(i));
          if (a(localColumnInfo)) {
            localArrayList.add(localColumnInfo);
          }
        }
        else
        {
          QLog.i("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork success, topicList.num = " + localArrayList.size());
          this.mTotalSize = paramArrayOfByte.total.get();
          parama.a(true, paramArrayOfByte.is_end.get(), paramArrayOfByte.total.get(), localArrayList, ByteString.encodeUtf8(paramArrayOfByte.cookie.get().toStringUtf8()), paramInt, "");
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
        }
        parama.a(false, true, 0, new ArrayList(), null, paramInt, "");
        return;
      }
      i += 1;
    }
  }
  
  private boolean a(ColumnInfo paramColumnInfo)
  {
    return !paramColumnInfo.coverUrl.isEmpty();
  }
  
  public void a(lji.b<ColumnInfo> paramb) {}
  
  public void a(ByteString paramByteString, lji.a<ColumnInfo, ByteString> parama)
  {
    QLog.i("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork start request cookie = " + paramByteString);
    if (this.cj)
    {
      QLog.i("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork return since mIsRequesting is true start = " + paramByteString);
      return;
    }
    this.cj = true;
    oidb_0xe31.TopicListReq localTopicListReq = new oidb_0xe31.TopicListReq();
    localTopicListReq.uid.set(Long.parseLong(this.app.getCurrentAccountUin()));
    if (paramByteString != null) {
      localTopicListReq.cookie.set(ByteStringMicro.copyFrom(paramByteString.toByteArray()));
    }
    localTopicListReq.num.set(10);
    if (this.aTJ != 0) {
      localTopicListReq.top_topic_id.set(this.aTJ);
    }
    paramByteString = new oidb_0xe31.ReqBody();
    paramByteString.topic_list_req_req.set(localTopicListReq);
    jnm.a(this.app, new mno(this, parama), paramByteString.toByteArray(), "OidbSvc.0xe31", 3633, 3);
  }
  
  public void cC(List<ColumnInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnn
 * JD-Core Version:    0.7.0.1
 */