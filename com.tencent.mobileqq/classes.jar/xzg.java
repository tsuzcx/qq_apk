import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class xzg
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private anvi jdField_a_of_type_Anvi = new xzh(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private xzi jdField_a_of_type_Xzi;
  private xzj jdField_a_of_type_Xzj;
  private xzk jdField_a_of_type_Xzk;
  private xzl jdField_a_of_type_Xzl;
  private xzm jdField_a_of_type_Xzm;
  private int b = -1;
  
  public xzg(String paramString, @NonNull xzl paramxzl)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Xzl = paramxzl;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xzm = new xzm(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xzm);
    wzk.a().addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Xzi = new xzi(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xzi);
    this.jdField_a_of_type_Xzj = new xzj(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xzj);
    this.jdField_a_of_type_Xzk = new xzk(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xzk);
  }
  
  public void a(boolean paramBoolean)
  {
    ykq.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wke)wjs.a(2)).b(this.jdField_a_of_type_JavaLangString);
      ykq.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    ykq.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new wrb().a(1, new wkz("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xzm);
    wzk.a().removeObserver(this.jdField_a_of_type_Anvi);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xzi);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xzj);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xzk);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzg
 * JD-Core Version:    0.7.0.1
 */