import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskListRsp;

class pcd
  implements rxc.a<TaskCenterReader.TaskListRsp>
{
  pcd(pcc parampcc) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null) {
      pbv.a().setData((ArrayList)paramTaskListRsp.taskRecords.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcd
 * JD-Core Version:    0.7.0.1
 */