import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class utr
  implements IEventReceiver
{
  public int a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected ssv a;
  private utt jdField_a_of_type_Utt;
  private utu jdField_a_of_type_Utu;
  
  public utr(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_Ssv = new uts(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdl)tcz.a(2)).b(this.jdField_a_of_type_JavaLangString);
    tsr.a().addObserver(this.jdField_a_of_type_Ssv);
    this.jdField_a_of_type_Utt = new utt(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Utt);
    this.jdField_a_of_type_Utu = new utu(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Utu);
  }
  
  public void b()
  {
    tsr.a().removeObserver(this.jdField_a_of_type_Ssv);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Utt);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Utu);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utr
 * JD-Core Version:    0.7.0.1
 */