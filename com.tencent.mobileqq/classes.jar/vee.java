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

public class vee
  implements urr<vez<qqstory_service.ReqStorySubmitRateData>, vgx>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqn.a("StorySvc.submit_rate_data");
  }
  
  vee(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    wxe.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new vez(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    urp.a().a((urt)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new vee(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull vez<qqstory_service.ReqStorySubmitRateData> paramvez, @Nullable vgx paramvgx, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramvez = (uvx)uwa.a(5);
    StoryVideoItem localStoryVideoItem = paramvez.a(this.c);
    int i;
    long l;
    label57:
    vef localvef;
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
      localvef = new vef();
      if ((!paramErrorMessage.isFail()) && (paramvgx != null)) {
        break label213;
      }
      wxe.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localvef.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localvef.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localvef.jdField_b_of_type_JavaLangString = this.c;
      localvef.jdField_a_of_type_Int = i;
      localvef.jdField_b_of_type_Int = j;
      localvef.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localvef.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localvef.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localvef.jdField_a_of_type_Long;
        paramvez.a(localStoryVideoItem);
      }
      umc.a().dispatch(localvef);
      xsf.a(QQStoryContext.a());
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
        paramErrorMessage.mergeFrom(paramvgx.a);
        localvef.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localvef.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localvef.jdField_b_of_type_JavaLangString = this.c;
        localvef.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localvef.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localvef.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localvef.c = paramErrorMessage.comment_id.get();
        localvef.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        wxe.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localvef.jdField_a_of_type_Int), Integer.valueOf(localvef.jdField_b_of_type_Int), Long.valueOf(localvef.jdField_a_of_type_Long), Integer.valueOf(localvef.c), Long.valueOf(localvef.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramvez)
      {
        paramvez.printStackTrace();
        wxe.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramvez);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vee
 * JD-Core Version:    0.7.0.1
 */