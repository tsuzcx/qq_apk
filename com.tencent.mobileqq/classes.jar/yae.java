import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class yae
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected vzx a;
  private yag jdField_a_of_type_Yag;
  private yah jdField_a_of_type_Yah;
  
  public yae(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Vzx = new yaf(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wke)wjs.a(2)).b(this.jdField_a_of_type_JavaLangString);
    wzk.a().addObserver(this.jdField_a_of_type_Vzx);
    this.jdField_a_of_type_Yag = new yag(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yag);
    this.jdField_a_of_type_Yah = new yah(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yah);
  }
  
  public void b()
  {
    wzk.a().removeObserver(this.jdField_a_of_type_Vzx);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yag);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yah);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yae
 * JD-Core Version:    0.7.0.1
 */