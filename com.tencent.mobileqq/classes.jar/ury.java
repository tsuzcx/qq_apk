import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

class ury
  extends Job<Object, Object, Object>
{
  ury(urx paramurx, String paramString, QQStoryCmdHandler.IllegalUinException paramIllegalUinException)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    wxe.d("Q.qqstory.net:QQStoryCmdHandler", "uin convert error");
    this.jdField_a_of_type_Urx.a.a().a(880002, this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler$IllegalUinException.getMessage(), null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ury
 * JD-Core Version:    0.7.0.1
 */