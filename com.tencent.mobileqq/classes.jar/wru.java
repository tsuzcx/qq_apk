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

public class wru
  implements wfk<wsr<qqstory_service.ReqStorySubmitPollData>, wup>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a("StorySvc.submit_poll_data");
  }
  
  wru(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    ykq.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new wsr(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    wfi.a().a((wfm)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new wru(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull wsr<qqstory_service.ReqStorySubmitPollData> paramwsr, @Nullable wup paramwup, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwup == null))
    {
      ykq.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramwsr = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramwsr.mergeFrom(paramwup.a);
      paramwup = new wrv();
      paramwup.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramwsr.result.error_code.get(), paramwsr.result.error_desc.get().toStringUtf8());
      paramwup.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramwup.jdField_b_of_type_JavaLangString = this.c;
      paramwup.jdField_a_of_type_Int = paramwsr.comment_id.get();
      paramwup.jdField_a_of_type_Long = paramwsr.fake_id.get();
      paramwup.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramwup.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramwsr.video_poll_result.get());
      int j = paramwup.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (wjp)wjs.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      ykq.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramwup.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramwsr.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramwsr)
    {
      paramwsr.printStackTrace();
      ykq.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramwsr);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    wad.a().dispatch(paramwup);
    zfa.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wru
 * JD-Core Version:    0.7.0.1
 */