import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class pwr
  extends pwp
{
  public int mType;
  
  public pwr(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131561902);
    this.mType = paramInt;
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    switch (this.mType)
    {
    default: 
      rom.fail(acfp.m(2131709146), new Object[0]);
      return;
    case 3: 
      this.itemView.setTag(Integer.valueOf(3));
      this.a.setNodeName(parampuh.title, false);
      String str = rpn.gn(parampuh.videoCover);
      if (!TextUtils.isEmpty(str)) {
        rt(str);
      }
      while ((parampuh.iO == null) || (parampuh.iO.isEmpty()))
      {
        this.a.dR(1, 1 - parampuh.unreadCount);
        return;
        this.a.a.setImageResource(2130847506);
      }
    }
    this.a.setNodeName(acfp.m(2131709145), false);
    this.a.a.setImageResource(2130847503);
    this.a.a.sv(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwr
 * JD-Core Version:    0.7.0.1
 */