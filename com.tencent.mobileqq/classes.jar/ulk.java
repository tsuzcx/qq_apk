import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulk
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tjj>
{
  public ulk(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tjj paramtjj)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.jdField_a_of_type_JavaLangString, paramtjj.jdField_a_of_type_JavaLangString)) {}
    while ((paramtjj.b) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onGetShareGroupVideos: 是否来自缓存=" + paramtjj.b + " groupId=" + paramQQStoryShareGroupProfileActivity.b + ", event=" + paramtjj.toString());
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramtjj);
  }
  
  public Class acceptEventClass()
  {
    return tjj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulk
 * JD-Core Version:    0.7.0.1
 */