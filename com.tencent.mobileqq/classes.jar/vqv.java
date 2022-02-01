import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.common.app.AppInterface;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;

public class vqv
  extends SimpleJob
{
  public vqv(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, vqr paramvqr)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    for (;;)
    {
      NewIntent localNewIntent;
      try
      {
        paramJobContext = this.jdField_a_of_type_Vqr.a();
        paramArrayOfObject = Integer.valueOf(QQStoryCmdHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler).getAndIncrement());
        AppInterface localAppInterface = QQStoryContext.a();
        localNewIntent = new NewIntent(localAppInterface.getApp(), vrc.class);
        localNewIntent.putExtra("storySeq", paramArrayOfObject);
        localNewIntent.putExtra("cmd", this.jdField_a_of_type_Vqr.a());
        localNewIntent.putExtra("data", paramJobContext);
        localNewIntent.putExtra("start_time", System.currentTimeMillis());
        if (this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler.a.contains(Integer.valueOf(this.jdField_a_of_type_Vqr.b())))
        {
          localNewIntent.putExtra("timeout", 10000L);
          localNewIntent.putExtra("support_retry", true);
          QQStoryCmdHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler).put(paramArrayOfObject, this.jdField_a_of_type_Vqr);
          localAppInterface.startServlet(localNewIntent);
          return null;
        }
      }
      catch (QQStoryCmdHandler.IllegalUinException paramJobContext)
      {
        Bosses.get().scheduleJobDelayed(new vqw(this, "Q.qqstory.net:QQStoryCmdHandler", paramJobContext), 100);
        return null;
      }
      if (this.jdField_a_of_type_Vqr.a > 0L) {
        localNewIntent.putExtra("timeout", this.jdField_a_of_type_Vqr.a);
      }
    }
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqv
 * JD-Core Version:    0.7.0.1
 */