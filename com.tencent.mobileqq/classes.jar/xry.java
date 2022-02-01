import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xry
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wqn>
{
  public xry(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wqn paramwqn)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.jdField_a_of_type_JavaLangString, paramwqn.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((paramwqn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "update sharegroup info: " + paramwqn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.toString());
      }
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramwqn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramwqn);
  }
  
  public Class acceptEventClass()
  {
    return wqn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xry
 * JD-Core Version:    0.7.0.1
 */