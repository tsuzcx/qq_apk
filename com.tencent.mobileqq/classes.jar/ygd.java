import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class ygd
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected wfi a;
  private ygf jdField_a_of_type_Ygf;
  private ygg jdField_a_of_type_Ygg;
  
  public ygd(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Wfi = new yge(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wpy)wpm.a(2)).b(this.jdField_a_of_type_JavaLangString);
    xfe.a().addObserver(this.jdField_a_of_type_Wfi);
    this.jdField_a_of_type_Ygf = new ygf(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ygf);
    this.jdField_a_of_type_Ygg = new ygg(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ygg);
  }
  
  public void b()
  {
    xfe.a().removeObserver(this.jdField_a_of_type_Wfi);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ygf);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ygg);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygd
 * JD-Core Version:    0.7.0.1
 */