import android.util.Base64;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.ReqBody;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetReq;
import tencent.kandian.ugc.topic_info.TopicInfo;

public class mnh
  implements mnf.a
{
  private QQAppInterface app;
  
  public mnh(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void a(@NotNull ColumnInfo paramColumnInfo, mne parammne, int paramInt)
  {
    oidb_0xe33.TopicInfoSetReq localTopicInfoSetReq;
    if (QLog.isColorLevel())
    {
      if (paramInt == 1) {
        QLog.e("RIJUGC.ManagerColumnModel", 2, "ManageColumnModel createColumn: columnInfo : " + paramColumnInfo.toString());
      }
    }
    else
    {
      localTopicInfoSetReq = new oidb_0xe33.TopicInfoSetReq();
      if (paramInt != 1) {
        break label155;
      }
      localTopicInfoSetReq.operate_type.set(1);
    }
    for (;;)
    {
      localTopicInfoSetReq.info.set(paramColumnInfo.parseToTopicInfo());
      paramColumnInfo = new oidb_0xe33.ReqBody();
      paramColumnInfo.topic_info_set_req.set(localTopicInfoSetReq);
      jnm.a(this.app, new mni(this, parammne, paramInt), paramColumnInfo.toByteArray(), "OidbSvc.0xe33", 3635, 1);
      return;
      if (paramInt != 2) {
        break;
      }
      QLog.e("RIJUGC.ManagerColumnModel", 2, "ManageColumnModel editColumn: columnInfo : " + paramColumnInfo.toString());
      break;
      label155:
      if (paramInt == 2) {
        localTopicInfoSetReq.operate_type.set(2);
      }
    }
  }
  
  @Nullable
  public ColumnInfo a()
  {
    Object localObject1 = (String)awit.f("key_sp_readinjoy_column_info_sketch", "");
    if (((String)localObject1).isEmpty()) {
      return null;
    }
    topic_info.TopicInfo localTopicInfo = new topic_info.TopicInfo();
    try
    {
      localTopicInfo.mergeFrom(Base64.decode((String)localObject1, 0));
      localObject1 = new ColumnInfo(localTopicInfo);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("RIJUGC.ManagerColumnModel", 1, "getColumnSketch exception, e=" + localException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, mne parammne)
  {
    a(paramColumnInfo, parammne, 1);
  }
  
  public void aQH()
  {
    awit.H("key_sp_readinjoy_column_info_sketch", "");
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, mne parammne)
  {
    a(paramColumnInfo, parammne, 2);
  }
  
  public void d(@NotNull ColumnInfo paramColumnInfo)
  {
    awit.H("key_sp_readinjoy_column_info_sketch", Base64.encodeToString(paramColumnInfo.parseToTopicInfo().toByteArray(), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnh
 * JD-Core Version:    0.7.0.1
 */