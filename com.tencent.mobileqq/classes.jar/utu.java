import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class utu
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected ssy a;
  private utw jdField_a_of_type_Utw;
  private utx jdField_a_of_type_Utx;
  
  public utu(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Ssy = new utv(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdo)tdc.a(2)).b(this.jdField_a_of_type_JavaLangString);
    tsu.a().addObserver(this.jdField_a_of_type_Ssy);
    this.jdField_a_of_type_Utw = new utw(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Utw);
    this.jdField_a_of_type_Utx = new utx(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Utx);
  }
  
  public void b()
  {
    tsu.a().removeObserver(this.jdField_a_of_type_Ssy);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Utw);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Utx);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utu
 * JD-Core Version:    0.7.0.1
 */