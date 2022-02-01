import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskListRsp;

class ovu
  implements rxc.a<TaskCenterReader.TaskListRsp>
{
  ovu(ovs paramovs) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null)
    {
      this.a.setDatas((ArrayList)paramTaskListRsp.taskRecords.get());
      if ((this.a.eC != null) && (ovs.b(this.a) != null))
      {
        this.a.eC.removeAllViews();
        paramString = String.valueOf(paramTaskListRsp.myFuel.get()).toCharArray();
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          char c = paramString[i];
          ImageView localImageView = new ImageView(ovs.c(this.a));
          localImageView.setImageResource(ovs.a(this.a)[java.lang.Character.getNumericValue(c)]);
          this.a.eC.addView(localImageView);
          i += 1;
        }
      }
      ovs.a(this.a, paramTaskListRsp.taskEntranceUrl.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovu
 * JD-Core Version:    0.7.0.1
 */