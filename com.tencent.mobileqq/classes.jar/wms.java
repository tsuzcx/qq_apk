import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class wms
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected ulw a;
  private wmu jdField_a_of_type_Wmu;
  private wmv jdField_a_of_type_Wmv;
  
  public wms(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Ulw = new wmt(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((uwm)uwa.a(2)).b(this.jdField_a_of_type_JavaLangString);
    vls.a().addObserver(this.jdField_a_of_type_Ulw);
    this.jdField_a_of_type_Wmu = new wmu(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wmu);
    this.jdField_a_of_type_Wmv = new wmv(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wmv);
  }
  
  public void b()
  {
    vls.a().removeObserver(this.jdField_a_of_type_Ulw);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wmu);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wmv);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wms
 * JD-Core Version:    0.7.0.1
 */