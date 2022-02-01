import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.Queue;

class wwy
  extends SimpleJob<Void>
{
  wwy(wwx paramwwx, String paramString, Context paramContext, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (!wwx.a(this.jdField_a_of_type_Wwx, this.jdField_a_of_type_AndroidContentContext)) {
      QLog.i("MsgTabStoryVideoPreloader", 2, "当前网络状态, 不启动预下载");
    }
    do
    {
      return null;
      QLog.i("MsgTabStoryVideoPreloader", 2, "启动消息TAB节点预加载器");
      paramJobContext = wwx.a(this.jdField_a_of_type_Wwx, this.jdField_a_of_type_JavaUtilList);
    } while ((paramJobContext.isEmpty()) || (!this.jdField_a_of_type_Wwx.a()));
    wwx.a(this.jdField_a_of_type_Wwx);
    wwx.a(this.jdField_a_of_type_Wwx, paramJobContext);
    this.jdField_a_of_type_Wwx.b();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwy
 * JD-Core Version:    0.7.0.1
 */