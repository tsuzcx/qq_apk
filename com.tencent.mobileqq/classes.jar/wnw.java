import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;

public class wnw
  implements DialogInterface.OnClickListener
{
  public wnw(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.f();
    paramDialogInterface.dismiss();
    wxj.a(this.a.a(), "clk_sure", 0, 0, new String[] { "2", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnw
 * JD-Core Version:    0.7.0.1
 */