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

public class wdb
  implements vqp<wdw<qqstory_service.ReqStorySubmitRateData>, wfu>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = vpl.a("StorySvc.submit_rate_data");
  }
  
  wdb(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    xvv.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new wdw(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    vqn.a().a((vqr)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new wdb(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull wdw<qqstory_service.ReqStorySubmitRateData> paramwdw, @Nullable wfu paramwfu, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramwdw = (vuu)vux.a(5);
    StoryVideoItem localStoryVideoItem = paramwdw.a(this.c);
    int i;
    long l;
    label57:
    wdc localwdc;
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
      localwdc = new wdc();
      if ((!paramErrorMessage.isFail()) && (paramwfu != null)) {
        break label213;
      }
      xvv.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localwdc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwdc.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localwdc.jdField_b_of_type_JavaLangString = this.c;
      localwdc.jdField_a_of_type_Int = i;
      localwdc.jdField_b_of_type_Int = j;
      localwdc.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localwdc.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localwdc.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localwdc.jdField_a_of_type_Long;
        paramwdw.a(localStoryVideoItem);
      }
      vli.a().dispatch(localwdc);
      yqh.a(QQStoryContext.a());
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
        paramErrorMessage.mergeFrom(paramwfu.a);
        localwdc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localwdc.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localwdc.jdField_b_of_type_JavaLangString = this.c;
        localwdc.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localwdc.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localwdc.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localwdc.c = paramErrorMessage.comment_id.get();
        localwdc.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        xvv.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localwdc.jdField_a_of_type_Int), Integer.valueOf(localwdc.jdField_b_of_type_Int), Long.valueOf(localwdc.jdField_a_of_type_Long), Integer.valueOf(localwdc.c), Long.valueOf(localwdc.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramwdw)
      {
        paramwdw.printStackTrace();
        xvv.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramwdw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdb
 * JD-Core Version:    0.7.0.1
 */