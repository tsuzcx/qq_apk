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

public class wxq
  implements wld<wyl<qqstory_service.ReqStorySubmitRateData>, xaj>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = wjz.a("StorySvc.submit_rate_data");
  }
  
  wxq(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    yqp.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new wyl(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    wlb.a().a((wlf)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new wxq(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull wyl<qqstory_service.ReqStorySubmitRateData> paramwyl, @Nullable xaj paramxaj, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramwyl = (wpj)wpm.a(5);
    StoryVideoItem localStoryVideoItem = paramwyl.a(this.c);
    int i;
    long l;
    label57:
    wxr localwxr;
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
      localwxr = new wxr();
      if ((!paramErrorMessage.isFail()) && (paramxaj != null)) {
        break label213;
      }
      yqp.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localwxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwxr.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localwxr.jdField_b_of_type_JavaLangString = this.c;
      localwxr.jdField_a_of_type_Int = i;
      localwxr.jdField_b_of_type_Int = j;
      localwxr.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localwxr.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localwxr.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localwxr.jdField_a_of_type_Long;
        paramwyl.a(localStoryVideoItem);
      }
      wfo.a().dispatch(localwxr);
      zlq.a(QQStoryContext.a());
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
        paramErrorMessage.mergeFrom(paramxaj.a);
        localwxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localwxr.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localwxr.jdField_b_of_type_JavaLangString = this.c;
        localwxr.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localwxr.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localwxr.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localwxr.c = paramErrorMessage.comment_id.get();
        localwxr.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        yqp.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localwxr.jdField_a_of_type_Int), Integer.valueOf(localwxr.jdField_b_of_type_Int), Long.valueOf(localwxr.jdField_a_of_type_Long), Integer.valueOf(localwxr.c), Long.valueOf(localwxr.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramwyl)
      {
        paramwyl.printStackTrace();
        yqp.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramwyl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxq
 * JD-Core Version:    0.7.0.1
 */