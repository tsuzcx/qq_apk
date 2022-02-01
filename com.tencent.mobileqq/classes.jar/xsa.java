import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class xsa
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wqt>
{
  public xsa(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wqt paramwqt)
  {
    if ((TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.b)) && (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.c)) && (paramwqt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (!paramwqt.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramwqt = paramwqt.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwqt.hasNext())
      {
        xth localxth = (xth)paramwqt.next();
        if (paramQQStoryShareGroupProfileActivity.c.equals(localxth.a))
        {
          paramQQStoryShareGroupProfileActivity.b = localxth.b;
          if (QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity)) {
            break label111;
          }
        }
      }
    }
    label111:
    for (boolean bool = true;; bool = false)
    {
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, bool);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wqt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsa
 * JD-Core Version:    0.7.0.1
 */