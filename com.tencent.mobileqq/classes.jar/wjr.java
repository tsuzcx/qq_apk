import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class wjr
  implements wfk<wul, wum>
{
  wjr(wjq paramwjq) {}
  
  public void a(@NonNull wul paramwul, @Nullable wum paramwum, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramwum == null) {
      ykq.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramwum });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        ykq.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramwum);
        this.a.jdField_a_of_type_Long = paramwum.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        ykq.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramwum });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramwum.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramwum.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramwum.a);
    paramwul = paramwum.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramwul))
    {
      ((wjl)wjs.a(10)).b("key_story_player_promote_url", paramwul);
      this.a.b = paramwul;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjr
 * JD-Core Version:    0.7.0.1
 */