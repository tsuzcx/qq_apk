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

public class wxo
  implements wld<wyl<qqstory_service.ReqStorySubmitPollData>, xaj>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = wjz.a("StorySvc.submit_poll_data");
  }
  
  wxo(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    yqp.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new wyl(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    wlb.a().a((wlf)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new wxo(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull wyl<qqstory_service.ReqStorySubmitPollData> paramwyl, @Nullable xaj paramxaj, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxaj == null))
    {
      yqp.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramwyl = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramwyl.mergeFrom(paramxaj.a);
      paramxaj = new wxp();
      paramxaj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramwyl.result.error_code.get(), paramwyl.result.error_desc.get().toStringUtf8());
      paramxaj.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramxaj.jdField_b_of_type_JavaLangString = this.c;
      paramxaj.jdField_a_of_type_Int = paramwyl.comment_id.get();
      paramxaj.jdField_a_of_type_Long = paramwyl.fake_id.get();
      paramxaj.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramxaj.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramwyl.video_poll_result.get());
      int j = paramxaj.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (wpj)wpm.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      yqp.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramxaj.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramwyl.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramwyl)
    {
      paramwyl.printStackTrace();
      yqp.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramwyl);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    wfo.a().dispatch(paramxaj);
    zlq.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxo
 * JD-Core Version:    0.7.0.1
 */