import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class uxc
  extends uxf
{
  public uxc(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561491);
  }
  
  public void a(utx paramutx)
  {
    wsv.a("FriendNodeViewHolder", "bindData %s", paramutx);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(paramutx.b);
      b(xoa.b(paramutx.g));
      if (!uwn.h) {
        break label180;
      }
    }
    label180:
    for (localObject = bdbt.m(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + paramutx.b + ", name = " + (String)localObject, " list: ", String.valueOf(paramutx.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramutx) });
      }
      super.a(paramutx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxc
 * JD-Core Version:    0.7.0.1
 */