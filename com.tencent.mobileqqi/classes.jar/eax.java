import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class eax
  implements View.OnClickListener
{
  public eax(TextItemBuilder paramTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = AIOUtils.a(paramView);
    if (!(localObject instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w(ChatItemBuilder.a, 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    do
    {
      do
      {
        return;
        localObject = (MessageForText)localObject;
      } while (((MessageForText)localObject).msgtype != -1003);
      localObject = PkgTools.c(((MessageForText)localObject).action);
      paramView = JumpParser.a(TextItemBuilder.a(this.a), paramView.getContext(), (String)localObject);
    } while (paramView == null);
    paramView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eax
 * JD-Core Version:    0.7.0.1
 */