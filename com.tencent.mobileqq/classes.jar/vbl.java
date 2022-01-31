import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class vbl
  extends vbo
{
  public vbl(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561509);
  }
  
  public void a(uyg paramuyg)
  {
    wxe.a("FriendNodeViewHolder", "bindData %s", paramuyg);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(paramuyg.b);
      b(xsj.b(paramuyg.g));
      if (!vaw.h) {
        break label180;
      }
    }
    label180:
    for (localObject = bdgc.m(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + paramuyg.b + ", name = " + (String)localObject, " list: ", String.valueOf(paramuyg.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramuyg) });
      }
      super.a(paramuyg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbl
 * JD-Core Version:    0.7.0.1
 */