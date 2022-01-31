import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgNumAnim;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim.Ruler;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim.SpannableValue;

public class uma
  implements NumAnim.Ruler
{
  public uma(GoldMsgNumAnim paramGoldMsgNumAnim) {}
  
  public NumAnim.SpannableValue getNumber(double paramDouble)
  {
    String str = NumAnim.formatNumber(paramDouble, true);
    return new NumAnim.SpannableValue(str, 0, str.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uma
 * JD-Core Version:    0.7.0.1
 */