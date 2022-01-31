import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class egp
  implements View.OnClickListener
{
  public egp(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onClick(View paramView)
  {
    new StructMsgClickHandler(paramView).a("web", this.a.mSourceUrl, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egp
 * JD-Core Version:    0.7.0.1
 */