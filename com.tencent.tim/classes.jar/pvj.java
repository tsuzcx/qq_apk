import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.Queue;

class pvj
  extends SimpleJob<Void>
{
  pvj(pvi parampvi, String paramString, Context paramContext, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (!pvi.a(this.b, this.val$context)) {
      QLog.i("MsgTabStoryVideoPreloader", 2, "当前网络状态, 不启动预下载");
    }
    do
    {
      return null;
      QLog.i("MsgTabStoryVideoPreloader", 2, "启动消息TAB节点预加载器");
      paramJobContext = pvi.a(this.b, this.mE);
    } while ((paramJobContext.isEmpty()) || (!this.b.Hp()));
    pvi.a(this.b);
    pvi.a(this.b, paramJobContext);
    this.b.bmX();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvj
 * JD-Core Version:    0.7.0.1
 */