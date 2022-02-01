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

class wwz
  extends SimpleJob<Void>
{
  wwz(wwx paramwwx, String paramString, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = new ArrayList();
    paramVarArgs = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVarArgs.hasNext())
    {
      Object localObject = (StoryVideoItem)paramVarArgs.next();
      wkq localwkq = wkq.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localwkq.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localwkq.c);
        }
        this.jdField_a_of_type_Wwx.b.add(localwkq.c);
        paramJobContext.add(localwkq);
      }
      localObject = wkq.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((wkq)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((wkq)localObject).c);
        }
        this.jdField_a_of_type_Wwx.b.add(((wkq)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_Wwx.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwz
 * JD-Core Version:    0.7.0.1
 */