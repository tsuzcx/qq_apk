import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class pwm
  extends pwp
{
  public pwm(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561902);
  }
  
  public void r(puh parampuh)
  {
    ram.b("FriendNodeViewHolder", "bindData %s", parampuh);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(parampuh.uid);
      rt(rpn.gn(parampuh.videoCover));
      if (!pvz.aCs) {
        break label180;
      }
    }
    label180:
    for (localObject = aqgv.D(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + parampuh.uid + ", name = " + (String)localObject, " list: ", String.valueOf(parampuh.iO) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(parampuh) });
      }
      super.r(parampuh);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwm
 * JD-Core Version:    0.7.0.1
 */