import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class uga
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private ajjh jdField_a_of_type_Ajjh = new ugb(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ugc jdField_a_of_type_Ugc;
  private ugd jdField_a_of_type_Ugd;
  private uge jdField_a_of_type_Uge;
  private ugf jdField_a_of_type_Ugf;
  private ugg jdField_a_of_type_Ugg;
  private int b = -1;
  
  public uga(String paramString, @NonNull ugf paramugf)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ugf = paramugf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ugg = new ugg(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ugg);
    tfy.a().addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_Ugc = new ugc(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ugc);
    this.jdField_a_of_type_Ugd = new ugd(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ugd);
    this.jdField_a_of_type_Uge = new uge(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uge);
  }
  
  public void a(boolean paramBoolean)
  {
    urk.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((sqs)sqg.a(2)).b(this.jdField_a_of_type_JavaLangString);
      urk.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    urk.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new sxp().a(1, new srn("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ugg);
    tfy.a().removeObserver(this.jdField_a_of_type_Ajjh);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ugc);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ugd);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uge);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uga
 * JD-Core Version:    0.7.0.1
 */