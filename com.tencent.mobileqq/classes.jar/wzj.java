import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wzj
  extends QQUIEventReceiver<wzb, xfd>
{
  public wzj(@NonNull wzb paramwzb)
  {
    super(paramwzb);
  }
  
  public void a(@NonNull wzb paramwzb, @NonNull xfd paramxfd)
  {
    wzl localwzl = paramwzb.a;
    if (localwzl != null) {
      localwzl.a(paramwzb.a());
    }
    for (;;)
    {
      wxj.b("edit_video", "face_list_success", 0, paramxfd.a.errorCode, new String[0]);
      return;
      wxe.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return xfd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzj
 * JD-Core Version:    0.7.0.1
 */