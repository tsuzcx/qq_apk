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

public class tko
  implements syt<tmb<qqstory_service.ReqBatchStoryPollData>, tnz>
{
  public static final String a;
  public ArrayList<String> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a("StorySvc.batch_poll_data");
  }
  
  public tko(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      new tko(paramList.subList(i, Math.min(i + 5, j))).a();
      i += 5;
    }
  }
  
  public void a()
  {
    Object localObject = new qqstory_service.ReqBatchStoryPollData();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((qqstory_service.ReqBatchStoryPollData)localObject).vid_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    localObject = new tmb(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    syr.a().a((syv)localObject, this);
  }
  
  public void a(@NonNull tmb<qqstory_service.ReqBatchStoryPollData> paramtmb, @Nullable tnz paramtnz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtnz == null))
    {
      veg.c("Q.qqstory.pollData.GetVidPollInfoHandler", "Error onCmdRespond:%s", paramErrorMessage);
      return;
    }
    paramtmb = new qqstory_service.RspBatchStoryPollData();
    Object localObject;
    StoryVideoItem localStoryVideoItem;
    int j;
    qqstory_struct.UserInfo localUserInfo;
    QQUserUIItem localQQUserUIItem;
    for (;;)
    {
      try
      {
        paramtmb.mergeFrom(paramtnz.a);
        paramtnz = (tcz)tdc.a(5);
        paramErrorMessage = new tkp();
        i = 0;
        if (i >= paramtmb.poll_info_list.size()) {
          break;
        }
        localObject = (qqstory_struct.VidPollInfo)paramtmb.poll_info_list.get(i);
        localStoryVideoItem = paramtnz.a(((qqstory_struct.VidPollInfo)localObject).vid.get().toStringUtf8());
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
      catch (InvalidProtocolBufferMicroException paramtmb)
      {
        veg.c("Q.qqstory.pollData.GetVidPollInfoHandler", "onCmdRespond Request parse Error!", paramtmb);
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
      paramtnz.a(localStoryVideoItem);
      label271:
      paramErrorMessage.a.add(localObject);
      i += 1;
    }
    int i = 0;
    while (i < paramtmb.rate_info_list.size())
    {
      localObject = (qqstory_struct.VidRateInfo)paramtmb.rate_info_list.get(i);
      veg.b("Q.qqstory.pollData.GetVidPollInfoHandler", "onCmdRespond, VidRateInfo:[vid=%s, selfRateResult=%s, totalRateCount=%s, totalRateScore=%s]", ((qqstory_struct.VidRateInfo)localObject).vid.get().toStringUtf8(), Integer.valueOf(((qqstory_struct.VidRateInfo)localObject).self_rate_result.get()), Integer.valueOf(((qqstory_struct.VidRateInfo)localObject).total_rate_count.get()), Long.valueOf(((qqstory_struct.VidRateInfo)localObject).total_rate_score.get()));
      localStoryVideoItem = paramtnz.a(((qqstory_struct.VidRateInfo)localObject).vid.get().toStringUtf8());
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
        paramtnz.a(localStoryVideoItem);
      }
      paramErrorMessage.b.add(localObject);
      i += 1;
    }
    ste.a().dispatch(paramErrorMessage);
    vzh.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tko
 * JD-Core Version:    0.7.0.1
 */