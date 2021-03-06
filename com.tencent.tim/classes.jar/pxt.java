import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchStoryPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchStoryPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VidPollInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VidRateInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class pxt
  implements ppv.b<pyl<qqstory_service.ReqBatchStoryPollData>, pzy>
{
  public static final String CMD = ppf.fQ("StorySvc.batch_poll_data");
  public ArrayList<String> mQ = new ArrayList();
  
  public pxt(List<String> paramList)
  {
    this.mQ.addAll(paramList);
  }
  
  public static void ei(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      new pxt(paramList.subList(i, Math.min(i + 5, j))).sendRequest();
      i += 5;
    }
  }
  
  public void a(@NonNull pyl<qqstory_service.ReqBatchStoryPollData> parampyl, @Nullable pzy parampzy, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (parampzy == null))
    {
      ram.e("Q.qqstory.pollData.GetVidPollInfoHandler", "Error onCmdRespond:%s", paramErrorMessage);
      return;
    }
    parampyl = new qqstory_service.RspBatchStoryPollData();
    Object localObject;
    StoryVideoItem localStoryVideoItem;
    int j;
    qqstory_struct.UserInfo localUserInfo;
    QQUserUIItem localQQUserUIItem;
    for (;;)
    {
      try
      {
        parampyl.mergeFrom(parampzy.bytes);
        parampzy = (psu)psx.a(5);
        paramErrorMessage = new pxt.a();
        i = 0;
        if (i >= parampyl.poll_info_list.size()) {
          break;
        }
        localObject = (qqstory_struct.VidPollInfo)parampyl.poll_info_list.get(i);
        localStoryVideoItem = parampzy.a(((qqstory_struct.VidPollInfo)localObject).vid.get().toStringUtf8());
        if (localStoryVideoItem == null) {
          break label271;
        }
        localStoryVideoItem.mPollUsers.clear();
        localStoryVideoItem.mPollResult = ((qqstory_struct.VidPollInfo)localObject).self_poll_result.get();
        int k = ((qqstory_struct.VidPollInfo)localObject).video_poll_result.size();
        localStoryVideoItem.mPollNumbers = new int[k];
        j = 0;
        if (j < k)
        {
          localStoryVideoItem.mPollNumbers[j] = ((Integer)((qqstory_struct.VidPollInfo)localObject).video_poll_result.get(j)).intValue();
          j += 1;
          continue;
        }
        j = 0;
      }
      catch (InvalidProtocolBufferMicroException parampyl)
      {
        ram.e("Q.qqstory.pollData.GetVidPollInfoHandler", "onCmdRespond Request parse Error!", parampyl);
        return;
      }
      while (j < ((qqstory_struct.VidPollInfo)localObject).video_poll_users.size())
      {
        localUserInfo = (qqstory_struct.UserInfo)((qqstory_struct.VidPollInfo)localObject).video_poll_users.get(j);
        localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.convertFrom(localUserInfo);
        localStoryVideoItem.mPollUsers.add(localQQUserUIItem);
        j += 1;
      }
      parampzy.a(localStoryVideoItem);
      label271:
      paramErrorMessage.mY.add(localObject);
      i += 1;
    }
    int i = 0;
    while (i < parampyl.rate_info_list.size())
    {
      localObject = (qqstory_struct.VidRateInfo)parampyl.rate_info_list.get(i);
      ram.b("Q.qqstory.pollData.GetVidPollInfoHandler", "onCmdRespond, VidRateInfo:[vid=%s, selfRateResult=%s, totalRateCount=%s, totalRateScore=%s]", ((qqstory_struct.VidRateInfo)localObject).vid.get().toStringUtf8(), Integer.valueOf(((qqstory_struct.VidRateInfo)localObject).self_rate_result.get()), Integer.valueOf(((qqstory_struct.VidRateInfo)localObject).total_rate_count.get()), Long.valueOf(((qqstory_struct.VidRateInfo)localObject).total_rate_score.get()));
      localStoryVideoItem = parampzy.a(((qqstory_struct.VidRateInfo)localObject).vid.get().toStringUtf8());
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = ((qqstory_struct.VidRateInfo)localObject).self_rate_result.get();
        localStoryVideoItem.mTotalRateCount = ((qqstory_struct.VidRateInfo)localObject).total_rate_count.get();
        localStoryVideoItem.mTotalScore = ((qqstory_struct.VidRateInfo)localObject).total_rate_score.get();
        localStoryVideoItem.mRateUsers.clear();
        j = 0;
        while (j < ((qqstory_struct.VidRateInfo)localObject).video_rate_users.size())
        {
          localUserInfo = (qqstory_struct.UserInfo)((qqstory_struct.VidRateInfo)localObject).video_rate_users.get(j);
          localQQUserUIItem = new QQUserUIItem();
          localQQUserUIItem.convertFrom(localUserInfo);
          localStoryVideoItem.mRateUsers.add(localQQUserUIItem);
          j += 1;
        }
        parampzy.a(localStoryVideoItem);
      }
      paramErrorMessage.mZ.add(localObject);
      i += 1;
    }
    pmi.a().dispatch(paramErrorMessage);
    rpk.aC(QQStoryContext.a());
  }
  
  public void sendRequest()
  {
    Object localObject = new qqstory_service.ReqBatchStoryPollData();
    Iterator localIterator = this.mQ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((qqstory_service.ReqBatchStoryPollData)localObject).vid_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    localObject = new pyl(CMD, (MessageMicro)localObject, null);
    ppv.a().a((ppw)localObject, this);
  }
  
  public static final class a
    extends plt
  {
    public List<qqstory_struct.VidPollInfo> mY = new ArrayList();
    public List<qqstory_struct.VidRateInfo> mZ = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxt
 * JD-Core Version:    0.7.0.1
 */