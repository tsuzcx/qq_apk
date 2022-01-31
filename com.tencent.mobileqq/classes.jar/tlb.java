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

public class tlb
  implements syq<tly<qqstory_service.ReqStorySubmitPollData>, tnw>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxm.a("StorySvc.submit_poll_data");
  }
  
  tlb(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    ved.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new tly(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    syo.a().a((sys)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new tlb(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull tly<qqstory_service.ReqStorySubmitPollData> paramtly, @Nullable tnw paramtnw, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtnw == null))
    {
      ved.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramtly = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramtly.mergeFrom(paramtnw.a);
      paramtnw = new tlc();
      paramtnw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramtly.result.error_code.get(), paramtly.result.error_desc.get().toStringUtf8());
      paramtnw.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramtnw.jdField_b_of_type_JavaLangString = this.c;
      paramtnw.jdField_a_of_type_Int = paramtly.comment_id.get();
      paramtnw.jdField_a_of_type_Long = paramtly.fake_id.get();
      paramtnw.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramtnw.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramtly.video_poll_result.get());
      int j = paramtnw.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (tcw)tcz.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      ved.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramtnw.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramtly.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramtly)
    {
      paramtly.printStackTrace();
      ved.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramtly);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    stb.a().dispatch(paramtnw);
    vze.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlb
 * JD-Core Version:    0.7.0.1
 */