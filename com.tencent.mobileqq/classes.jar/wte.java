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

class wte
  extends SimpleJob<Void>
{
  wte(wtc paramwtc, String paramString, List paramList)
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
      wgv localwgv = wgv.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localwgv.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localwgv.c);
        }
        this.jdField_a_of_type_Wtc.b.add(localwgv.c);
        paramJobContext.add(localwgv);
      }
      localObject = wgv.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((wgv)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((wgv)localObject).c);
        }
        this.jdField_a_of_type_Wtc.b.add(((wgv)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_Wtc.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wte
 * JD-Core Version:    0.7.0.1
 */