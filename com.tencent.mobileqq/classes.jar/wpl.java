import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class wpl
  implements wld<xaf, xag>
{
  wpl(wpk paramwpk) {}
  
  public void a(@NonNull xaf paramxaf, @Nullable xag paramxag, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramxag == null) {
      yqp.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramxag });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        yqp.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramxag);
        this.a.jdField_a_of_type_Long = paramxag.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        yqp.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramxag });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramxag.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramxag.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramxag.a);
    paramxaf = paramxag.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramxaf))
    {
      ((wpf)wpm.a(10)).b("key_story_player_promote_url", paramxaf);
      this.a.b = paramxaf;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpl
 * JD-Core Version:    0.7.0.1
 */