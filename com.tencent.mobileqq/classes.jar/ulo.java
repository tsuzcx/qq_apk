import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulo
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tjx>
{
  public ulo(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tjx paramtjx)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.jdField_a_of_type_JavaLangString, paramtjx.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((paramtjx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjx.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "update sharegroup info: " + paramtjx.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.toString());
      }
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramtjx.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramtjx);
  }
  
  public Class acceptEventClass()
  {
    return tjx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulo
 * JD-Core Version:    0.7.0.1
 */