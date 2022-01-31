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

public class tld
  implements syq<tly<qqstory_service.ReqStorySubmitRateData>, tnw>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxm.a("StorySvc.submit_rate_data");
  }
  
  tld(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    ved.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new tly(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    syo.a().a((sys)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new tld(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull tly<qqstory_service.ReqStorySubmitRateData> paramtly, @Nullable tnw paramtnw, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramtly = (tcw)tcz.a(5);
    StoryVideoItem localStoryVideoItem = paramtly.a(this.c);
    int i;
    long l;
    label57:
    tle localtle;
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
      localtle = new tle();
      if ((!paramErrorMessage.isFail()) && (paramtnw != null)) {
        break label213;
      }
      ved.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localtle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localtle.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localtle.jdField_b_of_type_JavaLangString = this.c;
      localtle.jdField_a_of_type_Int = i;
      localtle.jdField_b_of_type_Int = j;
      localtle.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localtle.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localtle.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localtle.jdField_a_of_type_Long;
        paramtly.a(localStoryVideoItem);
      }
      stb.a().dispatch(localtle);
      vze.a(QQStoryContext.a());
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
        paramErrorMessage.mergeFrom(paramtnw.a);
        localtle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localtle.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localtle.jdField_b_of_type_JavaLangString = this.c;
        localtle.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localtle.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localtle.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localtle.c = paramErrorMessage.comment_id.get();
        localtle.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        ved.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localtle.jdField_a_of_type_Int), Integer.valueOf(localtle.jdField_b_of_type_Int), Long.valueOf(localtle.jdField_a_of_type_Long), Integer.valueOf(localtle.c), Long.valueOf(localtle.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramtly)
      {
        paramtly.printStackTrace();
        ved.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramtly);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tld
 * JD-Core Version:    0.7.0.1
 */