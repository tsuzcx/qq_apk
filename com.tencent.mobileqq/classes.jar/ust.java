import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class ust
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private ajxj jdField_a_of_type_Ajxj = new usu(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private usv jdField_a_of_type_Usv;
  private usw jdField_a_of_type_Usw;
  private usx jdField_a_of_type_Usx;
  private usy jdField_a_of_type_Usy;
  private usz jdField_a_of_type_Usz;
  private int b = -1;
  
  public ust(String paramString, @NonNull usy paramusy)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Usy = paramusy;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Usz = new usz(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Usz);
    tsr.a().addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_Usv = new usv(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Usv);
    this.jdField_a_of_type_Usw = new usw(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Usw);
    this.jdField_a_of_type_Usx = new usx(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Usx);
  }
  
  public void a(boolean paramBoolean)
  {
    ved.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdl)tcz.a(2)).b(this.jdField_a_of_type_JavaLangString);
      ved.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    ved.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new tki().a(1, new teg("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Usz);
    tsr.a().removeObserver(this.jdField_a_of_type_Ajxj);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Usv);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Usw);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Usx);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ust
 * JD-Core Version:    0.7.0.1
 */