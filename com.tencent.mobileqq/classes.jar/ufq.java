import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ufq
  extends uff<ufo>
{
  protected List<uer> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      uer localuer = (uer)((Iterator)localObject).next();
      if ((localuer.jdField_b_of_type_Long >= ((ufo)a()).jdField_a_of_type_Long) && (localuer.jdField_b_of_type_Long <= ((ufo)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localuer);
      }
    }
    return localArrayList;
  }
  
  protected List<ueq> a(@NonNull List<uer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ueq(((ufo)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((ufo)a()).jdField_a_of_type_Long, ((ufo)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((ufo)a()).c;
    Object localObject = uro.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((ufo)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((ufo)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(ueq.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((ufo)a()).jdField_b_of_type_Int) {
            break;
          }
          return null;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<ueq> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufq
 * JD-Core Version:    0.7.0.1
 */