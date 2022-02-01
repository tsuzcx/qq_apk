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

public class ppz
  extends SimpleJob
{
  public ppz(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, ppw paramppw)
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
        paramJobContext = this.jdField_b_of_type_Ppw.encode();
        paramArrayOfObject = Integer.valueOf(QQStoryCmdHandler.a(this.jdField_b_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler).getAndIncrement());
        AppInterface localAppInterface = QQStoryContext.c();
        localNewIntent = new NewIntent(localAppInterface.getApp(), pqe.class);
        localNewIntent.putExtra("storySeq", paramArrayOfObject);
        localNewIntent.putExtra("cmd", this.jdField_b_of_type_Ppw.mg());
        localNewIntent.putExtra("data", paramJobContext);
        localNewIntent.putExtra("start_time", System.currentTimeMillis());
        if (this.jdField_b_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler.aB.contains(Integer.valueOf(this.jdField_b_of_type_Ppw.sr())))
        {
          localNewIntent.putExtra("timeout", 10000L);
          localNewIntent.putExtra("support_retry", true);
          QQStoryCmdHandler.a(this.jdField_b_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler).put(paramArrayOfObject, this.jdField_b_of_type_Ppw);
          localAppInterface.startServlet(localNewIntent);
          return null;
        }
      }
      catch (QQStoryCmdHandler.IllegalUinException paramJobContext)
      {
        Bosses.get().scheduleJobDelayed(new pqa(this, "Q.qqstory.net:QQStoryCmdHandler", paramJobContext), 100);
        return null;
      }
      if (this.jdField_b_of_type_Ppw.timeOut > 0L) {
        localNewIntent.putExtra("timeout", this.jdField_b_of_type_Ppw.timeOut);
      }
    }
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppz
 * JD-Core Version:    0.7.0.1
 */