import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.Queue;

class uvi
  extends SimpleJob<Void>
{
  uvi(uvh paramuvh, String paramString, Context paramContext, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (!uvh.a(this.jdField_a_of_type_Uvh, this.jdField_a_of_type_AndroidContentContext)) {
      QLog.i("MsgTabStoryVideoPreloader", 2, "当前网络状态, 不启动预下载");
    }
    do
    {
      return null;
      QLog.i("MsgTabStoryVideoPreloader", 2, "启动消息TAB节点预加载器");
      paramJobContext = uvh.a(this.jdField_a_of_type_Uvh, this.jdField_a_of_type_JavaUtilList);
    } while ((paramJobContext.isEmpty()) || (!this.jdField_a_of_type_Uvh.a()));
    uvh.a(this.jdField_a_of_type_Uvh);
    uvh.a(this.jdField_a_of_type_Uvh, paramJobContext);
    this.jdField_a_of_type_Uvh.b();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvi
 * JD-Core Version:    0.7.0.1
 */