import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class ugy
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected sgc a;
  private uha jdField_a_of_type_Uha;
  private uhb jdField_a_of_type_Uhb;
  
  public ugy(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Sgc = new ugz(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((sqs)sqg.a(2)).b(this.jdField_a_of_type_JavaLangString);
    tfy.a().addObserver(this.jdField_a_of_type_Sgc);
    this.jdField_a_of_type_Uha = new uha(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uha);
    this.jdField_a_of_type_Uhb = new uhb(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uhb);
  }
  
  public void b()
  {
    tfy.a().removeObserver(this.jdField_a_of_type_Sgc);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uha);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uhb);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugy
 * JD-Core Version:    0.7.0.1
 */