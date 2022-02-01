import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class wpd
  extends wpg
{
  public wpd(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561731);
  }
  
  public void a(wly paramwly)
  {
    ykq.a("FriendNodeViewHolder", "bindData %s", paramwly);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(paramwly.b);
      b(zfe.b(paramwly.g));
      if (!woo.h) {
        break label180;
      }
    }
    label180:
    for (localObject = ContactUtils.getFriendShowName(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + paramwly.b + ", name = " + (String)localObject, " list: ", String.valueOf(paramwly.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramwly) });
      }
      super.a(paramwly);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpd
 * JD-Core Version:    0.7.0.1
 */