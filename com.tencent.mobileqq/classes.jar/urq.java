import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class urq
  implements uni<vck, vcl>
{
  urq(urp paramurp) {}
  
  public void a(@NonNull vck paramvck, @Nullable vcl paramvcl, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramvcl == null) {
      wsv.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramvcl });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        wsv.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramvcl);
        this.a.jdField_a_of_type_Long = paramvcl.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        wsv.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramvcl });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramvcl.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramvcl.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramvcl.a);
    paramvck = paramvcl.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramvck))
    {
      ((urk)urr.a(10)).b("key_story_player_promote_url", paramvck);
      this.a.b = paramvck;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urq
 * JD-Core Version:    0.7.0.1
 */