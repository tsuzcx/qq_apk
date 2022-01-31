import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class usw
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private ajxl jdField_a_of_type_Ajxl = new usx(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private usy jdField_a_of_type_Usy;
  private usz jdField_a_of_type_Usz;
  private uta jdField_a_of_type_Uta;
  private utb jdField_a_of_type_Utb;
  private utc jdField_a_of_type_Utc;
  private int b = -1;
  
  public usw(String paramString, @NonNull utb paramutb)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Utb = paramutb;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Utc = new utc(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Utc);
    tsu.a().addObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_Usy = new usy(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Usy);
    this.jdField_a_of_type_Usz = new usz(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Usz);
    this.jdField_a_of_type_Uta = new uta(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Uta);
  }
  
  public void a(boolean paramBoolean)
  {
    veg.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdo)tdc.a(2)).b(this.jdField_a_of_type_JavaLangString);
      veg.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    veg.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new tkl().a(1, new tej("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Utc);
    tsu.a().removeObserver(this.jdField_a_of_type_Ajxl);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Usy);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Usz);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uta);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usw
 * JD-Core Version:    0.7.0.1
 */