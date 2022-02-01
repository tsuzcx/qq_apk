import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class pvk
  extends SimpleJob<Void>
{
  pvk(pvi parampvi, String paramString, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = new ArrayList();
    paramVarArgs = this.mF.iterator();
    while (paramVarArgs.hasNext())
    {
      Object localObject = (StoryVideoItem)paramVarArgs.next();
      png localpng = png.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localpng.originalUrl))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localpng.originalUrl);
        }
        this.b.aF.add(localpng.originalUrl);
        paramJobContext.add(localpng);
      }
      localObject = png.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((png)localObject).originalUrl))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((png)localObject).originalUrl);
        }
        this.b.aF.add(((png)localObject).originalUrl);
        paramJobContext.add(localObject);
      }
      this.b.a.w(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvk
 * JD-Core Version:    0.7.0.1
 */