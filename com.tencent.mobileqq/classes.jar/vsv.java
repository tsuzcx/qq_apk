import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskListRsp;

class vsv
  implements aaav<TaskCenterReader.TaskListRsp>
{
  vsv(vsu paramvsu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null) {
      vqo.a().a((ArrayList)paramTaskListRsp.taskRecords.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsv
 * JD-Core Version:    0.7.0.1
 */