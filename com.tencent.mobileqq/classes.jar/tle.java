import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

public class tle
  implements syt<tmb<qqstory_service.ReqStorySubmitPollData>, tnz>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a("StorySvc.submit_poll_data");
  }
  
  tle(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    veg.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new tmb(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    syr.a().a((syv)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new tle(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull tmb<qqstory_service.ReqStorySubmitPollData> paramtmb, @Nullable tnz paramtnz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtnz == null))
    {
      veg.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramtmb = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramtmb.mergeFrom(paramtnz.a);
      paramtnz = new tlf();
      paramtnz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramtmb.result.error_code.get(), paramtmb.result.error_desc.get().toStringUtf8());
      paramtnz.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramtnz.jdField_b_of_type_JavaLangString = this.c;
      paramtnz.jdField_a_of_type_Int = paramtmb.comment_id.get();
      paramtnz.jdField_a_of_type_Long = paramtmb.fake_id.get();
      paramtnz.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramtnz.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramtmb.video_poll_result.get());
      int j = paramtnz.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (tcz)tdc.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      veg.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramtnz.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramtmb.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramtmb)
    {
      paramtmb.printStackTrace();
      veg.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramtmb);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    ste.a().dispatch(paramtnz);
    vzh.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tle
 * JD-Core Version:    0.7.0.1
 */