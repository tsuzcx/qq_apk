import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;

public class xbl
  implements woy<xcg<qqstory_service.ReqStorySubmitRateData>, xee>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = wnu.a("StorySvc.submit_rate_data");
  }
  
  xbl(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    yuk.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new xcg(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    wow.a().a((wpa)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new xbl(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull xcg<qqstory_service.ReqStorySubmitRateData> paramxcg, @Nullable xee paramxee, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramxcg = (wte)wth.a(5);
    StoryVideoItem localStoryVideoItem = paramxcg.a(this.c);
    int i;
    long l;
    label57:
    xbm localxbm;
    if (localStoryVideoItem != null)
    {
      i = localStoryVideoItem.mRateResult;
      if (localStoryVideoItem != null) {
        j = localStoryVideoItem.mTotalRateCount;
      }
      if (localStoryVideoItem == null) {
        break label205;
      }
      l = localStoryVideoItem.mTotalScore;
      localxbm = new xbm();
      if ((!paramErrorMessage.isFail()) && (paramxee != null)) {
        break label213;
      }
      yuk.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localxbm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localxbm.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localxbm.jdField_b_of_type_JavaLangString = this.c;
      localxbm.jdField_a_of_type_Int = i;
      localxbm.jdField_b_of_type_Int = j;
      localxbm.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localxbm.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localxbm.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localxbm.jdField_a_of_type_Long;
        paramxcg.a(localStoryVideoItem);
      }
      wjj.a().dispatch(localxbm);
      zpl.a(QQStoryContext.a());
      return;
      i = -1;
      break;
      label205:
      l = -1L;
      break label57;
      label213:
      paramErrorMessage = new qqstory_service.RspStorySubmitRateData();
      try
      {
        paramErrorMessage.mergeFrom(paramxee.a);
        localxbm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localxbm.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localxbm.jdField_b_of_type_JavaLangString = this.c;
        localxbm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localxbm.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localxbm.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localxbm.c = paramErrorMessage.comment_id.get();
        localxbm.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        yuk.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localxbm.jdField_a_of_type_Int), Integer.valueOf(localxbm.jdField_b_of_type_Int), Long.valueOf(localxbm.jdField_a_of_type_Long), Integer.valueOf(localxbm.c), Long.valueOf(localxbm.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramxcg)
      {
        paramxcg.printStackTrace();
        yuk.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramxcg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbl
 * JD-Core Version:    0.7.0.1
 */