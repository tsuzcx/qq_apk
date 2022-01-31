import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ujz
  extends ujo<ujx>
{
  protected List<uja> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      uja localuja = (uja)((Iterator)localObject).next();
      if ((localuja.jdField_b_of_type_Long >= ((ujx)a()).jdField_a_of_type_Long) && (localuja.jdField_b_of_type_Long <= ((ujx)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localuja);
      }
    }
    return localArrayList;
  }
  
  protected List<uiz> a(@NonNull List<uja> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new uiz(((ujx)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((ujx)a()).jdField_a_of_type_Long, ((ujx)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((ujx)a()).c;
    Object localObject = uvx.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((ujx)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((ujx)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(uiz.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((ujx)a()).jdField_b_of_type_Int) {
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
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<uiz> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujz
 * JD-Core Version:    0.7.0.1
 */