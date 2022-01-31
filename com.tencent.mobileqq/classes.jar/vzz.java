import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;

public class vzz
  extends wbo
{
  public vzz(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    vad localvad = new vad();
    localvad.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    localvad.jdField_a_of_type_JavaUtilList = paramVideoCollectionItem.collectionVideoUIItemList;
    uht.a().dispatch(localvad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzz
 * JD-Core Version:    0.7.0.1
 */