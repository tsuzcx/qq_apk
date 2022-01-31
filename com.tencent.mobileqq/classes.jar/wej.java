import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.DeleteStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public class wej
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, uvf>
{
  public wej(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull uvf paramuvf)
  {
    if (!paramQQStoryShareGroupProfileActivity.jdField_b_of_type_JavaLangString.equals(paramuvf.c)) {}
    while ((!paramuvf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) || (TextUtils.isEmpty(paramuvf.d)) || (!((uvn)uwa.a(19)).a(paramuvf.d).contains(paramuvf.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "get delete event. groupId=" + paramQQStoryShareGroupProfileActivity.jdField_b_of_type_JavaLangString + ", feedId=" + paramuvf.d);
    }
    ShareGroupItem localShareGroupItem;
    if (paramQQStoryShareGroupProfileActivity.a != null)
    {
      localShareGroupItem = paramQQStoryShareGroupProfileActivity.a;
      int i = localShareGroupItem.videoCount - 1;
      localShareGroupItem.videoCount = i;
      if (i == 0)
      {
        ThreadManager.getUIHandler().postDelayed(new QQStoryShareGroupProfileActivity.DeleteStoryVideoEventReceiver.1(this, paramQQStoryShareGroupProfileActivity), 400L);
        return;
      }
    }
    if (paramQQStoryShareGroupProfileActivity.isResume())
    {
      if (paramuvf.jdField_b_of_type_Boolean)
      {
        localShareGroupItem = ((wfw)uwa.a(7)).a(paramQQStoryShareGroupProfileActivity.jdField_b_of_type_JavaLangString);
        if ((localShareGroupItem != null) && (localShareGroupItem.headerUnionIdList.contains(paramuvf.jdField_b_of_type_JavaLangString))) {
          QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, true);
        }
      }
      paramQQStoryShareGroupProfileActivity.b(false);
      return;
    }
    if (paramuvf.jdField_b_of_type_Boolean)
    {
      paramQQStoryShareGroupProfileActivity.jdField_b_of_type_Boolean = true;
      paramQQStoryShareGroupProfileActivity.c = true;
      return;
    }
    paramQQStoryShareGroupProfileActivity.jdField_b_of_type_Boolean = true;
  }
  
  public Class acceptEventClass()
  {
    return uvf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wej
 * JD-Core Version:    0.7.0.1
 */