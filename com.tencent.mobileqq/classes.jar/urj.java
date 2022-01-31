import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class urj
  extends QQUIEventReceiver<uqy, tdh>
{
  public urj(@NonNull uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull tdh paramtdh)
  {
    if (uqy.a(paramuqy) == null) {
      veg.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramtdh.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramtdh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      veg.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramtdh.toString());
      paramtdh = (tmn)paramtdh.jdField_a_of_type_JavaUtilMap.get(uqy.a(paramuqy));
    } while (paramtdh == null);
    paramtdh = ((tdf)tdc.a(27)).a(uqy.a(paramuqy).a(), paramtdh.a);
    uqy.a(paramuqy).b(paramtdh, true);
    paramuqy.a();
  }
  
  public Class acceptEventClass()
  {
    return tdh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urj
 * JD-Core Version:    0.7.0.1
 */