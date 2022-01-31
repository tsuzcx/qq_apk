import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class tik
  extends tin
{
  public tik(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561301);
  }
  
  public void a(tff paramtff)
  {
    ved.a("FriendNodeViewHolder", "bindData %s", paramtff);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(paramtff.b);
      b(vzi.b(paramtff.g));
      if (!thv.h) {
        break label180;
      }
    }
    label180:
    for (localObject = bbcz.m(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + paramtff.b + ", name = " + (String)localObject, " list: ", String.valueOf(paramtff.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramtff) });
      }
      super.a(paramtff);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tik
 * JD-Core Version:    0.7.0.1
 */