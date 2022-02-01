import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class xkl
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private amsu jdField_a_of_type_Amsu = new xkm(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private xkn jdField_a_of_type_Xkn;
  private xko jdField_a_of_type_Xko;
  private xkp jdField_a_of_type_Xkp;
  private xkq jdField_a_of_type_Xkq;
  private xkr jdField_a_of_type_Xkr;
  private int b = -1;
  
  public xkl(String paramString, @NonNull xkq paramxkq)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Xkq = paramxkq;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xkr = new xkr(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xkr);
    wkp.a().addObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_Xkn = new xkn(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xkn);
    this.jdField_a_of_type_Xko = new xko(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xko);
    this.jdField_a_of_type_Xkp = new xkp(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xkp);
  }
  
  public void a(boolean paramBoolean)
  {
    xvv.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((vvj)vux.a(2)).b(this.jdField_a_of_type_JavaLangString);
      xvv.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    xvv.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new wcg().a(1, new vwe("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xkr);
    wkp.a().removeObserver(this.jdField_a_of_type_Amsu);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xkn);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xko);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xkp);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkl
 * JD-Core Version:    0.7.0.1
 */