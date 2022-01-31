import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.GVideoUpdateUtil.OnGVideoUpdateListener;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;

public class waj
  implements GVideoUpdateUtil.OnGVideoUpdateListener
{
  public waj(VideoStatusTipsBar paramVideoStatusTipsBar, Intent paramIntent) {}
  
  public void a(Context paramContext, String paramString)
  {
    paramContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     waj
 * JD-Core Version:    0.7.0.1
 */