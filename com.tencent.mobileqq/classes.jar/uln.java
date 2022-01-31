import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class uln
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tka>
{
  public uln(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tka paramtka)
  {
    if ((TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.b)) && (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.c)) && (paramtka.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (!paramtka.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramtka = paramtka.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtka.hasNext())
      {
        umu localumu = (umu)paramtka.next();
        if (paramQQStoryShareGroupProfileActivity.c.equals(localumu.a))
        {
          paramQQStoryShareGroupProfileActivity.b = localumu.b;
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
    return tka.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uln
 * JD-Core Version:    0.7.0.1
 */