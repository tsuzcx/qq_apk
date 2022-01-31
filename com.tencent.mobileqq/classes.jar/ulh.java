import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;

public class ulh
  extends umw
{
  public ulh(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    tll localtll = new tll();
    localtll.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    localtll.jdField_a_of_type_JavaUtilList = paramVideoCollectionItem.collectionVideoUIItemList;
    stb.a().dispatch(localtll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulh
 * JD-Core Version:    0.7.0.1
 */