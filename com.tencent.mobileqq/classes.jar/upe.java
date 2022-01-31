import android.os.Handler;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgNumAnim;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim.AnimListener;
import java.util.List;

public class upe
  implements NumAnim.AnimListener
{
  public upe(GoldMsgNumAnim paramGoldMsgNumAnim) {}
  
  public void onFinished()
  {
    if (this.a.jdField_a_of_type_JavaUtilList.size() < 1) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, GoldMsgNumAnim.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upe
 * JD-Core Version:    0.7.0.1
 */