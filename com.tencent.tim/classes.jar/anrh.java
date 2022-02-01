import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class anrh
  implements View.OnLongClickListener
{
  public anrh(StructMsgForGeneralShare paramStructMsgForGeneralShare, wlz paramwlz) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    anqu localanqu = (anqu)paramView.getTag();
    if (!TextUtils.isEmpty(localanqu.chH)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localanqu.chH).intValue();
    }
    return this.g.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrh
 * JD-Core Version:    0.7.0.1
 */