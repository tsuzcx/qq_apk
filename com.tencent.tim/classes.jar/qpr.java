import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;

public class qpr
  extends qqe.a
{
  public qpr(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    pye.a locala = new pye.a();
    locala.collectionId = paramVideoCollectionItem.collectionId;
    locala.nb = paramVideoCollectionItem.collectionVideoUIItemList;
    pmi.a().dispatch(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpr
 * JD-Core Version:    0.7.0.1
 */