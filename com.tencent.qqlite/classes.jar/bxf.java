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

public class bxf
  implements View.OnClickListener
{
  public bxf(TextItemBuilder paramTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (TextItemBuilder.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject = AIOUtils.a(paramView);
          if ((localObject instanceof MessageForText)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w(ChatItemBuilder.a, 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
        return;
        localObject = (MessageForText)localObject;
      } while (((MessageForText)localObject).msgtype != -1003);
      Object localObject = PkgTools.c(((MessageForText)localObject).action);
      paramView = JumpParser.a(this.a.a, paramView.getContext(), (String)localObject);
    } while (paramView == null);
    paramView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bxf
 * JD-Core Version:    0.7.0.1
 */