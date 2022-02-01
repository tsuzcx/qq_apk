import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class wys
  extends wyv
{
  public wys(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561785);
  }
  
  public void a(wvn paramwvn)
  {
    yuk.a("FriendNodeViewHolder", "bindData %s", paramwvn);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(paramwvn.b);
      b(zpp.b(paramwvn.g));
      if (!wyd.h) {
        break label180;
      }
    }
    label180:
    for (localObject = bhlg.m(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + paramwvn.b + ", name = " + (String)localObject, " list: ", String.valueOf(paramwvn.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramwvn) });
      }
      super.a(paramwvn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wys
 * JD-Core Version:    0.7.0.1
 */