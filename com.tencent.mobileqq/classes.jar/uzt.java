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

public class uzt
  implements uni<vaq<qqstory_service.ReqStorySubmitPollData>, vco>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ume.a("StorySvc.submit_poll_data");
  }
  
  uzt(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    wsv.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new vaq(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    ung.a().a((unk)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new uzt(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull vaq<qqstory_service.ReqStorySubmitPollData> paramvaq, @Nullable vco paramvco, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvco == null))
    {
      wsv.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramvaq = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramvaq.mergeFrom(paramvco.a);
      paramvco = new uzu();
      paramvco.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramvaq.result.error_code.get(), paramvaq.result.error_desc.get().toStringUtf8());
      paramvco.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramvco.jdField_b_of_type_JavaLangString = this.c;
      paramvco.jdField_a_of_type_Int = paramvaq.comment_id.get();
      paramvco.jdField_a_of_type_Long = paramvaq.fake_id.get();
      paramvco.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramvco.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramvaq.video_poll_result.get());
      int j = paramvco.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (uro)urr.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      wsv.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramvco.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramvaq.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramvaq)
    {
      paramvaq.printStackTrace();
      wsv.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramvaq);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    uht.a().dispatch(paramvco);
    xnw.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzt
 * JD-Core Version:    0.7.0.1
 */