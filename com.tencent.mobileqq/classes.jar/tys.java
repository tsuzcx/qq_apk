import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tys
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, sxb>
{
  public tys(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull sxb paramsxb)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.jdField_a_of_type_JavaLangString, paramsxb.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((paramsxb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxb.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "update sharegroup info: " + paramsxb.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.toString());
      }
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramsxb.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramsxb);
  }
  
  public Class acceptEventClass()
  {
    return sxb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tys
 * JD-Core Version:    0.7.0.1
 */