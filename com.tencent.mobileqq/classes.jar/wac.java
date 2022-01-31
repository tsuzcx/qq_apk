import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wac
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, uyb>
{
  public wac(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull uyb paramuyb)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.jdField_a_of_type_JavaLangString, paramuyb.jdField_a_of_type_JavaLangString)) {}
    while ((paramuyb.b) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onGetShareGroupVideos: 是否来自缓存=" + paramuyb.b + " groupId=" + paramQQStoryShareGroupProfileActivity.b + ", event=" + paramuyb.toString());
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramuyb);
  }
  
  public Class acceptEventClass()
  {
    return uyb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wac
 * JD-Core Version:    0.7.0.1
 */