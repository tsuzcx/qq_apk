import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class wlu
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private altm jdField_a_of_type_Altm = new wlv(this);
  public QQUserUIItem a;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private wlw jdField_a_of_type_Wlw;
  private wlx jdField_a_of_type_Wlx;
  private wly jdField_a_of_type_Wly;
  private wlz jdField_a_of_type_Wlz;
  private wma jdField_a_of_type_Wma;
  private int b = -1;
  
  public wlu(String paramString, @NonNull wlz paramwlz)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Wlz = paramwlz;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wma = new wma(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wma);
    vls.a().addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_Wlw = new wlw(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wlw);
    this.jdField_a_of_type_Wlx = new wlx(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wlx);
    this.jdField_a_of_type_Wly = new wly(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wly);
  }
  
  public void a(boolean paramBoolean)
  {
    wxe.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((uwm)uwa.a(2)).b(this.jdField_a_of_type_JavaLangString);
      wxe.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    wxe.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new vdj().a(1, new uxh("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wma);
    vls.a().removeObserver(this.jdField_a_of_type_Altm);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wlw);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wlx);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wly);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlu
 * JD-Core Version:    0.7.0.1
 */