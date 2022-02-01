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

public class wrw
  implements wfk<wsr<qqstory_service.ReqStorySubmitRateData>, wup>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a("StorySvc.submit_rate_data");
  }
  
  wrw(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    ykq.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new wsr(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    wfi.a().a((wfm)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new wrw(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull wsr<qqstory_service.ReqStorySubmitRateData> paramwsr, @Nullable wup paramwup, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramwsr = (wjp)wjs.a(5);
    StoryVideoItem localStoryVideoItem = paramwsr.a(this.c);
    int i;
    long l;
    label57:
    wrx localwrx;
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
      localwrx = new wrx();
      if ((!paramErrorMessage.isFail()) && (paramwup != null)) {
        break label213;
      }
      ykq.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localwrx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwrx.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localwrx.jdField_b_of_type_JavaLangString = this.c;
      localwrx.jdField_a_of_type_Int = i;
      localwrx.jdField_b_of_type_Int = j;
      localwrx.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localwrx.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localwrx.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localwrx.jdField_a_of_type_Long;
        paramwsr.a(localStoryVideoItem);
      }
      wad.a().dispatch(localwrx);
      zfa.a(QQStoryContext.a());
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
        paramErrorMessage.mergeFrom(paramwup.a);
        localwrx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localwrx.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localwrx.jdField_b_of_type_JavaLangString = this.c;
        localwrx.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localwrx.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localwrx.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localwrx.c = paramErrorMessage.comment_id.get();
        localwrx.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        ykq.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localwrx.jdField_a_of_type_Int), Integer.valueOf(localwrx.jdField_b_of_type_Int), Long.valueOf(localwrx.jdField_a_of_type_Long), Integer.valueOf(localwrx.c), Long.valueOf(localwrx.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramwsr)
      {
        paramwsr.printStackTrace();
        ykq.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramwsr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrw
 * JD-Core Version:    0.7.0.1
 */