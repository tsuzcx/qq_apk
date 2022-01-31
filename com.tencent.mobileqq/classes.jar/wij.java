import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class wij
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected uhn a;
  private wil jdField_a_of_type_Wil;
  private wim jdField_a_of_type_Wim;
  
  public wij(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Uhn = new wik(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((usd)urr.a(2)).b(this.jdField_a_of_type_JavaLangString);
    vhj.a().addObserver(this.jdField_a_of_type_Uhn);
    this.jdField_a_of_type_Wil = new wil(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wil);
    this.jdField_a_of_type_Wim = new wim(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wim);
  }
  
  public void b()
  {
    vhj.a().removeObserver(this.jdField_a_of_type_Uhn);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wil);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wim);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wij
 * JD-Core Version:    0.7.0.1
 */