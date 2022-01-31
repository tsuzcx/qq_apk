import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;

public class uuw
  implements DialogInterface.OnClickListener
{
  public uuw(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    vei.a(this.a.a(), "clk_sure", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuw
 * JD-Core Version:    0.7.0.1
 */