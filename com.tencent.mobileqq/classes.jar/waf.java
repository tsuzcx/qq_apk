import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class waf
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, uys>
{
  public waf(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull uys paramuys)
  {
    if ((TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.b)) && (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.c)) && (paramuys.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (!paramuys.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramuys = paramuys.jdField_a_of_type_JavaUtilList.iterator();
      while (paramuys.hasNext())
      {
        wbm localwbm = (wbm)paramuys.next();
        if (paramQQStoryShareGroupProfileActivity.c.equals(localwbm.a))
        {
          paramQQStoryShareGroupProfileActivity.b = localwbm.b;
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
    return uys.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     waf
 * JD-Core Version:    0.7.0.1
 */