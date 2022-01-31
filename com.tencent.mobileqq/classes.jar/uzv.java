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

public class uzv
  implements uni<vaq<qqstory_service.ReqStorySubmitRateData>, vco>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ume.a("StorySvc.submit_rate_data");
  }
  
  uzv(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    wsv.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new vaq(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    ung.a().a((unk)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new uzv(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull vaq<qqstory_service.ReqStorySubmitRateData> paramvaq, @Nullable vco paramvco, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramvaq = (uro)urr.a(5);
    StoryVideoItem localStoryVideoItem = paramvaq.a(this.c);
    int i;
    long l;
    label57:
    uzw localuzw;
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
      localuzw = new uzw();
      if ((!paramErrorMessage.isFail()) && (paramvco != null)) {
        break label213;
      }
      wsv.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localuzw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localuzw.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localuzw.jdField_b_of_type_JavaLangString = this.c;
      localuzw.jdField_a_of_type_Int = i;
      localuzw.jdField_b_of_type_Int = j;
      localuzw.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localuzw.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localuzw.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localuzw.jdField_a_of_type_Long;
        paramvaq.a(localStoryVideoItem);
      }
      uht.a().dispatch(localuzw);
      xnw.a(QQStoryContext.a());
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
        paramErrorMessage.mergeFrom(paramvco.a);
        localuzw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localuzw.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localuzw.jdField_b_of_type_JavaLangString = this.c;
        localuzw.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localuzw.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localuzw.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localuzw.c = paramErrorMessage.comment_id.get();
        localuzw.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        wsv.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localuzw.jdField_a_of_type_Int), Integer.valueOf(localuzw.jdField_b_of_type_Int), Long.valueOf(localuzw.jdField_a_of_type_Long), Integer.valueOf(localuzw.c), Long.valueOf(localuzw.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramvaq)
      {
        paramvaq.printStackTrace();
        wsv.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramvaq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzv
 * JD-Core Version:    0.7.0.1
 */