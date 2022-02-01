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

public class wcz
  implements vqp<wdw<qqstory_service.ReqStorySubmitPollData>, wfu>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = vpl.a("StorySvc.submit_poll_data");
  }
  
  wcz(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    xvv.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new wdw(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    vqn.a().a((vqr)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new wcz(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull wdw<qqstory_service.ReqStorySubmitPollData> paramwdw, @Nullable wfu paramwfu, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwfu == null))
    {
      xvv.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramwdw = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramwdw.mergeFrom(paramwfu.a);
      paramwfu = new wda();
      paramwfu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramwdw.result.error_code.get(), paramwdw.result.error_desc.get().toStringUtf8());
      paramwfu.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramwfu.jdField_b_of_type_JavaLangString = this.c;
      paramwfu.jdField_a_of_type_Int = paramwdw.comment_id.get();
      paramwfu.jdField_a_of_type_Long = paramwdw.fake_id.get();
      paramwfu.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramwfu.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramwdw.video_poll_result.get());
      int j = paramwfu.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (vuu)vux.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      xvv.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramwfu.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramwdw.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramwdw)
    {
      paramwdw.printStackTrace();
      xvv.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramwdw);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    vli.a().dispatch(paramwfu);
    yqh.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcz
 * JD-Core Version:    0.7.0.1
 */