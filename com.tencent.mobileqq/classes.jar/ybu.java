import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class ybu
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, xai>
{
  public ybu(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull xai paramxai)
  {
    if ((TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.b)) && (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.c)) && (paramxai.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (!paramxai.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramxai = paramxai.jdField_a_of_type_JavaUtilList.iterator();
      while (paramxai.hasNext())
      {
        ydb localydb = (ydb)paramxai.next();
        if (paramQQStoryShareGroupProfileActivity.c.equals(localydb.a))
        {
          paramQQStoryShareGroupProfileActivity.b = localydb.b;
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
    return xai.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybu
 * JD-Core Version:    0.7.0.1
 */