import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class vuw
  implements vqp<wfq, wfr>
{
  vuw(vuv paramvuv) {}
  
  public void a(@NonNull wfq paramwfq, @Nullable wfr paramwfr, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramwfr == null) {
      xvv.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramwfr });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        xvv.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramwfr);
        this.a.jdField_a_of_type_Long = paramwfr.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        xvv.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramwfr });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramwfr.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramwfr.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramwfr.a);
    paramwfq = paramwfr.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramwfq))
    {
      ((vuq)vux.a(10)).b("key_story_player_promote_url", paramwfq);
      this.a.b = paramwfq;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuw
 * JD-Core Version:    0.7.0.1
 */