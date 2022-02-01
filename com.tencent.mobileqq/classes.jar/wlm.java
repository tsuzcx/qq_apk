import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class wlm
  extends SimpleJob<Void>
{
  public wlm(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, wlf paramwlf)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler.a(this.jdField_a_of_type_Wlf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlm
 * JD-Core Version:    0.7.0.1
 */