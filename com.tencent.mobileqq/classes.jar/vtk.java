import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.Friend;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudRead.StGetFollowListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleRelation.RelationBiz;

class vtk
  implements zxa<FeedCloudRead.StGetFollowListRsp>
{
  vtk(vtj paramvtj) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    long l = 0L;
    Object localObject2;
    Object localObject1;
    if (paramBoolean) {
      if (paramLong == 0L)
      {
        if (paramStGetFollowListRsp != null) {}
        for (;;)
        {
          try
          {
            paramString = paramStGetFollowListRsp.relationInfo.get().iterator();
            if (!paramString.hasNext()) {
              break;
            }
            localObject2 = (FeedCloudMeta.StRelationInfo)paramString.next();
            localObject1 = new Friend();
            ((Friend)localObject1).mUin = Long.parseLong(((FeedCloudMeta.StRelationInfo)localObject2).id.get());
            if (((FeedCloudMeta.StRelationInfo)localObject2).busiData.get() != null)
            {
              QQCircleRelation.RelationBiz localRelationBiz = new QQCircleRelation.RelationBiz();
              localRelationBiz.mergeFrom(((FeedCloudMeta.StRelationInfo)localObject2).busiData.get().toByteArray());
              localObject2 = localRelationBiz.nick.get();
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                ((Friend)localObject1).mName = (((Friend)localObject1).mUin + "");
              }
            }
            else
            {
              vtj.a(this.a).add(localObject1);
              continue;
              return;
            }
          }
          catch (Exception paramString)
          {
            QLog.e("QCircleDoubleFollowUserHepler", 1, paramString, new Object[0]);
          }
          ((Friend)localObject1).mName = ((String)localObject2);
        }
        paramString = paramStGetFollowListRsp.attachInfo.get();
        localObject1 = paramStGetFollowListRsp.extInfo.mapInfo.get().iterator();
        paramLong = l;
      }
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FeedCloudCommon.Entry)((Iterator)localObject1).next();
        if ((localObject2 != null) && ("timestamp".equals(((FeedCloudCommon.Entry)localObject2).key.get()))) {
          paramLong = Long.parseLong(((FeedCloudCommon.Entry)localObject2).value.get());
        }
      }
      else
      {
        if (paramStGetFollowListRsp.hasNext.get() == 1)
        {
          vtj.a(this.a, paramString, paramLong);
          return;
        }
        vtj.a(this.a, (List)vtj.a(this.a).clone());
        this.a.a(vtj.a(this.a));
        uwz.a().a(System.currentTimeMillis());
        return;
        QLog.e("QCircleDoubleFollowUserHepler", 1, "doGetFollowUser fail: retCode:" + paramLong);
        return;
        QLog.e("QCircleDoubleFollowUserHepler", 1, "doGetFollowUser fail: stGetFollowListRsp is null");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtk
 * JD-Core Version:    0.7.0.1
 */