import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FriendViewHolder.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class pwy
  extends pwx
{
  private aqdj a;
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    this.itemView.setTag(parampuh.unionId);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str1 = String.valueOf(parampuh.uid);
      this.a = aqdj.a((AppInterface)localObject, 1, str1);
      this.mA.setImageDrawable(this.a);
      String str2 = aqgv.D((QQAppInterface)localObject, str1);
      this.titleTextView.setText(str2);
      ThreadManager.post(new FriendViewHolder.1(this, (QQAppInterface)localObject, str1), 8, null, true);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FriendViewHolder userItem = " + parampuh.uid + ", name = " + str2 + ", faceDrawable = " + this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwy
 * JD-Core Version:    0.7.0.1
 */