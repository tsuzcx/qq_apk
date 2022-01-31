import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class uen
  extends QQUIEventReceiver<uec, sql>
{
  public uen(@NonNull uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull sql paramsql)
  {
    if (uec.a(paramuec) == null) {
      urk.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramsql.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramsql.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      urk.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramsql.toString());
      paramsql = (szr)paramsql.jdField_a_of_type_JavaUtilMap.get(uec.a(paramuec));
    } while (paramsql == null);
    paramsql = ((sqj)sqg.a(27)).a(uec.a(paramuec).a(), paramsql.a);
    uec.a(paramuec).b(paramsql, true);
    paramuec.a();
  }
  
  public Class acceptEventClass()
  {
    return sql.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uen
 * JD-Core Version:    0.7.0.1
 */