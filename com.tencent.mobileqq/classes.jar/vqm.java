import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskListRsp;

class vqm
  implements zxa<TaskCenterReader.TaskListRsp>
{
  vqm(vql paramvql) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null) {
      vog.a().a((ArrayList)paramTaskListRsp.taskRecords.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqm
 * JD-Core Version:    0.7.0.1
 */