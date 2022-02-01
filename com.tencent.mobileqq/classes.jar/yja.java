import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class yja
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private anyu jdField_a_of_type_Anyu = new yjb(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private yjc jdField_a_of_type_Yjc;
  private yjd jdField_a_of_type_Yjd;
  private yje jdField_a_of_type_Yje;
  private yjf jdField_a_of_type_Yjf;
  private yjg jdField_a_of_type_Yjg;
  private int b = -1;
  
  public yja(String paramString, @NonNull yjf paramyjf)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Yjf = paramyjf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Yjg = new yjg(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yjg);
    xiz.a().addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_Yjc = new yjc(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yjc);
    this.jdField_a_of_type_Yjd = new yjd(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yjd);
    this.jdField_a_of_type_Yje = new yje(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yje);
  }
  
  public void a(boolean paramBoolean)
  {
    yuk.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wtt)wth.a(2)).b(this.jdField_a_of_type_JavaLangString);
      yuk.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    yuk.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new xaq().a(1, new wuo("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yjg);
    xiz.a().removeObserver(this.jdField_a_of_type_Anyu);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yjc);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yjd);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yje);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yja
 * JD-Core Version:    0.7.0.1
 */