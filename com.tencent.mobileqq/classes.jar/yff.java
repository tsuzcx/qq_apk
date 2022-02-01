import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class yff
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private anmu jdField_a_of_type_Anmu = new yfg(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private yfh jdField_a_of_type_Yfh;
  private yfi jdField_a_of_type_Yfi;
  private yfj jdField_a_of_type_Yfj;
  private yfk jdField_a_of_type_Yfk;
  private yfl jdField_a_of_type_Yfl;
  private int b = -1;
  
  public yff(String paramString, @NonNull yfk paramyfk)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Yfk = paramyfk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Yfl = new yfl(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yfl);
    xfe.a().addObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_Yfh = new yfh(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yfh);
    this.jdField_a_of_type_Yfi = new yfi(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yfi);
    this.jdField_a_of_type_Yfj = new yfj(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yfj);
  }
  
  public void a(boolean paramBoolean)
  {
    yqp.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wpy)wpm.a(2)).b(this.jdField_a_of_type_JavaLangString);
      yqp.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    yqp.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new wwv().a(1, new wqt("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yfl);
    xfe.a().removeObserver(this.jdField_a_of_type_Anmu);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yfh);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yfi);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yfj);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yff
 * JD-Core Version:    0.7.0.1
 */