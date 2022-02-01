import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xrx
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wqc>
{
  public xrx(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wqc paramwqc)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.jdField_a_of_type_JavaLangString, paramwqc.jdField_a_of_type_JavaLangString)) {}
    while ((paramwqc.b) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onGetShareGroupVideos: 是否来自缓存=" + paramwqc.b + " groupId=" + paramQQStoryShareGroupProfileActivity.b + ", event=" + paramwqc.toString());
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramwqc);
  }
  
  public Class acceptEventClass()
  {
    return wqc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrx
 * JD-Core Version:    0.7.0.1
 */