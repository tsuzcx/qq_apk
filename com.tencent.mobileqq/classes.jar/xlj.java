import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class xlj
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected vlc a;
  private xll jdField_a_of_type_Xll;
  private xlm jdField_a_of_type_Xlm;
  
  public xlj(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Vlc = new xlk(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((vvj)vux.a(2)).b(this.jdField_a_of_type_JavaLangString);
    wkp.a().addObserver(this.jdField_a_of_type_Vlc);
    this.jdField_a_of_type_Xll = new xll(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xll);
    this.jdField_a_of_type_Xlm = new xlm(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xlm);
  }
  
  public void b()
  {
    wkp.a().removeObserver(this.jdField_a_of_type_Vlc);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xll);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xlm);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlj
 * JD-Core Version:    0.7.0.1
 */