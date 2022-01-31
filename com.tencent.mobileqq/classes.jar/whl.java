import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class whl
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private alox jdField_a_of_type_Alox = new whm(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private whn jdField_a_of_type_Whn;
  private who jdField_a_of_type_Who;
  private whp jdField_a_of_type_Whp;
  private whq jdField_a_of_type_Whq;
  private whr jdField_a_of_type_Whr;
  private int b = -1;
  
  public whl(String paramString, @NonNull whq paramwhq)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Whq = paramwhq;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Whr = new whr(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Whr);
    vhj.a().addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_Whn = new whn(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Whn);
    this.jdField_a_of_type_Who = new who(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Who);
    this.jdField_a_of_type_Whp = new whp(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Whp);
  }
  
  public void a(boolean paramBoolean)
  {
    wsv.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((usd)urr.a(2)).b(this.jdField_a_of_type_JavaLangString);
      wsv.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    wsv.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new uza().a(1, new usy("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Whr);
    vhj.a().removeObserver(this.jdField_a_of_type_Alox);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Whn);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Who);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Whp);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whl
 * JD-Core Version:    0.7.0.1
 */