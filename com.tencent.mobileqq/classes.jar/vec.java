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

public class vec
  implements urr<vez<qqstory_service.ReqStorySubmitPollData>, vgx>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqn.a("StorySvc.submit_poll_data");
  }
  
  vec(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    wxe.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new vez(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    urp.a().a((urt)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new vec(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull vez<qqstory_service.ReqStorySubmitPollData> paramvez, @Nullable vgx paramvgx, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvgx == null))
    {
      wxe.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramvez = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramvez.mergeFrom(paramvgx.a);
      paramvgx = new ved();
      paramvgx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramvez.result.error_code.get(), paramvez.result.error_desc.get().toStringUtf8());
      paramvgx.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramvgx.jdField_b_of_type_JavaLangString = this.c;
      paramvgx.jdField_a_of_type_Int = paramvez.comment_id.get();
      paramvgx.jdField_a_of_type_Long = paramvez.fake_id.get();
      paramvgx.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramvgx.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramvez.video_poll_result.get());
      int j = paramvgx.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (uvx)uwa.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      wxe.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramvgx.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramvez.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramvez)
    {
      paramvez.printStackTrace();
      wxe.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramvez);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    umc.a().dispatch(paramvgx);
    xsf.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vec
 * JD-Core Version:    0.7.0.1
 */