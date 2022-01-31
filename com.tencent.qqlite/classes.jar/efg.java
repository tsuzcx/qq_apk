import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class efg
  implements View.OnClickListener
{
  public efg(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onClick(View paramView)
  {
    new StructMsgClickHandler(paramView).a("web", this.a.mSourceUrl, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     efg
 * JD-Core Version:    0.7.0.1
 */