import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class uos
  extends SimpleJob<Object>
{
  uos(uom paramuom, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramVarArgs = ((uvx)uwa.a(5)).a();
    paramJobContext = new ArrayList(paramVarArgs.size());
    paramVarArgs = paramVarArgs.iterator();
    while (paramVarArgs.hasNext()) {
      paramJobContext.add(new uqf((StoryVideoItem)paramVarArgs.next()));
    }
    this.a.a(paramJobContext);
    wxe.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "had load local task size " + paramJobContext.size());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uos
 * JD-Core Version:    0.7.0.1
 */