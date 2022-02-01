import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FriendViewHolder.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class wpp
  extends wpo
{
  private FaceDrawable a;
  
  public void a(wly paramwly)
  {
    super.a(paramwly);
    this.itemView.setTag(paramwly.a);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str1 = String.valueOf(paramwly.b);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable = FaceDrawable.getFaceDrawable((AppInterface)localObject, 1, str1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
      String str2 = ContactUtils.getFriendShowName((QQAppInterface)localObject, str1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      ThreadManager.post(new FriendViewHolder.1(this, (QQAppInterface)localObject, str1), 8, null, true);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FriendViewHolder userItem = " + paramwly.b + ", name = " + str2 + ", faceDrawable = " + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpp
 * JD-Core Version:    0.7.0.1
 */