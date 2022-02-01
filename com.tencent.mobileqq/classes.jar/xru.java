import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;

public class xru
  extends xtj
{
  public xru(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    wse localwse = new wse();
    localwse.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    localwse.jdField_a_of_type_JavaUtilList = paramVideoCollectionItem.collectionVideoUIItemList;
    wad.a().dispatch(localwse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xru
 * JD-Core Version:    0.7.0.1
 */