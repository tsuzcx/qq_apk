import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.ArrayList;

public final class uow
  extends uli
{
  public StoryVideoItem a;
  public GeneralFeedItem a;
  public ArrayList<uov> a;
  public final boolean a;
  public StoryVideoItem b;
  public boolean b;
  public boolean c;
  
  public uow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 940006) || (paramInt == 940007) || (paramInt == 940017) || (paramInt == 940018) || (paramInt == 941001) || (paramInt == 941002) || (paramInt == baxx.a(940017)) || (paramInt == baxx.a(9042)) || (paramInt == baxx.a(9070)) || (paramInt == baxx.a(9071)) || (paramInt / 100 == baxx.a(999000) / 100) || ((paramInt >= 5100) && (paramInt <= 5108));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 941001) || (paramInt == 941002);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isTroopLocalVideoOnly();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  public String toString()
  {
    return "StoryVideoPublishStatusEvent{mFakeStoryVideoItem=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + ", mSucStoryVideoItem=" + this.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + ", mCommentLikeFeedItem=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem + ", mShareGroupFakeItems=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uow
 * JD-Core Version:    0.7.0.1
 */