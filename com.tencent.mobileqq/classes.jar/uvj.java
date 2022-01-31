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

class uvj
  extends SimpleJob<Void>
{
  uvj(uvh paramuvh, String paramString, List paramList)
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
      uja localuja = uja.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localuja.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localuja.c);
        }
        this.jdField_a_of_type_Uvh.b.add(localuja.c);
        paramJobContext.add(localuja);
      }
      localObject = uja.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((uja)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((uja)localObject).c);
        }
        this.jdField_a_of_type_Uvh.b.add(((uja)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_Uvh.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvj
 * JD-Core Version:    0.7.0.1
 */