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

class wnk
  extends SimpleJob<Void>
{
  wnk(wni paramwni, String paramString, List paramList)
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
      wbk localwbk = wbk.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localwbk.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localwbk.c);
        }
        this.jdField_a_of_type_Wni.b.add(localwbk.c);
        paramJobContext.add(localwbk);
      }
      localObject = wbk.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((wbk)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((wbk)localObject).c);
        }
        this.jdField_a_of_type_Wni.b.add(((wbk)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_Wni.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnk
 * JD-Core Version:    0.7.0.1
 */