import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;

public class uuv
  implements DialogInterface.OnClickListener
{
  public uuv(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.f();
    paramDialogInterface.dismiss();
    vei.a(this.a.a(), "clk_sure", 0, 0, new String[] { "2", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuv
 * JD-Core Version:    0.7.0.1
 */