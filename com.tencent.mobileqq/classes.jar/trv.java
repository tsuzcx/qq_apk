import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskListRsp;

class trv
  implements zac<TaskCenterReader.TaskListRsp>
{
  trv(trt paramtrt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null)
    {
      this.a.setDatas((ArrayList)paramTaskListRsp.taskRecords.get());
      if ((this.a.a != null) && (trt.b(this.a) != null))
      {
        this.a.a.removeAllViews();
        paramString = String.valueOf(paramTaskListRsp.myFuel.get()).toCharArray();
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          char c = paramString[i];
          ImageView localImageView = new ImageView(trt.c(this.a));
          localImageView.setImageResource(trt.a(this.a)[java.lang.Character.getNumericValue(c)]);
          this.a.a.addView(localImageView);
          i += 1;
        }
      }
      trt.a(this.a, paramTaskListRsp.taskEntranceUrl.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trv
 * JD-Core Version:    0.7.0.1
 */