import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class pqc
  extends SimpleJob<Void>
{
  public pqc(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, ppw paramppw)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler.a(this.jdField_b_of_type_Ppw);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqc
 * JD-Core Version:    0.7.0.1
 */