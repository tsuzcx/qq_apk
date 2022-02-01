import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.QQStoryObserver.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class pme
  extends SimpleJob<Object>
{
  pme(pmd parampmd, String paramString1, String paramString2, Boolean paramBoolean, boolean paramBoolean1, int paramInt)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (ptf)psx.a(2);
    paramVarArgs = paramJobContext.b(this.atK);
    if (paramVarArgs != null) {
      if (!this.N.booleanValue()) {
        break label61;
      }
    }
    label61:
    for (int i = 1;; i = 0)
    {
      paramVarArgs.isSubscribe = i;
      paramJobContext.a(paramVarArgs);
      ThreadManager.getUIHandler().post(new QQStoryObserver.1.1(this));
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pme
 * JD-Core Version:    0.7.0.1
 */