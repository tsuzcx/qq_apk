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

public class tlg
  implements syt<tmb<qqstory_service.ReqStorySubmitRateData>, tnz>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a("StorySvc.submit_rate_data");
  }
  
  tlg(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    veg.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new tmb(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    syr.a().a((syv)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new tlg(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull tmb<qqstory_service.ReqStorySubmitRateData> paramtmb, @Nullable tnz paramtnz, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramtmb = (tcz)tdc.a(5);
    StoryVideoItem localStoryVideoItem = paramtmb.a(this.c);
    int i;
    long l;
    label57:
    tlh localtlh;
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
      localtlh = new tlh();
      if ((!paramErrorMessage.isFail()) && (paramtnz != null)) {
        break label213;
      }
      veg.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localtlh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localtlh.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localtlh.jdField_b_of_type_JavaLangString = this.c;
      localtlh.jdField_a_of_type_Int = i;
      localtlh.jdField_b_of_type_Int = j;
      localtlh.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localtlh.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localtlh.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localtlh.jdField_a_of_type_Long;
        paramtmb.a(localStoryVideoItem);
      }
      ste.a().dispatch(localtlh);
      vzh.a(QQStoryContext.a());
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
        paramErrorMessage.mergeFrom(paramtnz.a);
        localtlh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localtlh.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localtlh.jdField_b_of_type_JavaLangString = this.c;
        localtlh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localtlh.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localtlh.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localtlh.c = paramErrorMessage.comment_id.get();
        localtlh.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        veg.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localtlh.jdField_a_of_type_Int), Integer.valueOf(localtlh.jdField_b_of_type_Int), Long.valueOf(localtlh.jdField_a_of_type_Long), Integer.valueOf(localtlh.c), Long.valueOf(localtlh.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramtmb)
      {
        paramtmb.printStackTrace();
        veg.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramtmb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlg
 * JD-Core Version:    0.7.0.1
 */