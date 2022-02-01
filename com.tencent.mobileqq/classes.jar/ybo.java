import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;

public class ybo
  extends ydd
{
  public ybo(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    xbt localxbt = new xbt();
    localxbt.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    localxbt.jdField_a_of_type_JavaUtilList = paramVideoCollectionItem.collectionVideoUIItemList;
    wjj.a().dispatch(localxbt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybo
 * JD-Core Version:    0.7.0.1
 */