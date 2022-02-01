import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class yjy
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected wjd a;
  private yka jdField_a_of_type_Yka;
  private ykb jdField_a_of_type_Ykb;
  
  public yjy(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Wjd = new yjz(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wtt)wth.a(2)).b(this.jdField_a_of_type_JavaLangString);
    xiz.a().addObserver(this.jdField_a_of_type_Wjd);
    this.jdField_a_of_type_Yka = new yka(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yka);
    this.jdField_a_of_type_Ykb = new ykb(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Ykb);
  }
  
  public void b()
  {
    xiz.a().removeObserver(this.jdField_a_of_type_Wjd);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yka);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ykb);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjy
 * JD-Core Version:    0.7.0.1
 */