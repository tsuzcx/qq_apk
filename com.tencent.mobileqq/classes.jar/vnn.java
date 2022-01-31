import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class vnn
  implements View.OnClickListener
{
  public vnn(TextItemBuilder paramTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = AIOUtils.a(paramView);
    if (!(localObject instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject = (MessageForText)localObject;
        } while (TextItemBuilder.a(this.a));
        if (((MessageForText)localObject).msgtype == -1003)
        {
          AIOUtils.m = true;
          localObject = PkgTools.a(((MessageForText)localObject).action);
          localObject = JumpParser.a(this.a.a, paramView.getContext(), (String)localObject);
          if (localObject != null) {
            ((JumpAction)localObject).b();
          }
        }
      } while (!(paramView instanceof ETTextView));
      paramView = (ETTextView)paramView;
      if (paramView.c())
      {
        paramView.a(true);
        return;
      }
    } while (!paramView.b());
    paramView.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnn
 * JD-Core Version:    0.7.0.1
 */