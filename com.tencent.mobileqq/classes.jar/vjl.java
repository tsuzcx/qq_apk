import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vjl
  extends vja<vjj>
{
  protected List<vim> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      vim localvim = (vim)((Iterator)localObject).next();
      if ((localvim.jdField_b_of_type_Long >= ((vjj)a()).jdField_a_of_type_Long) && (localvim.jdField_b_of_type_Long <= ((vjj)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localvim);
      }
    }
    return localArrayList;
  }
  
  protected List<vil> a(@NonNull List<vim> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new vil(((vjj)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((vjj)a()).jdField_a_of_type_Long, ((vjj)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((vjj)a()).c;
    Object localObject = vuu.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((vjj)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((vjj)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(vil.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((vjj)a()).jdField_b_of_type_Int) {
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
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<vil> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjl
 * JD-Core Version:    0.7.0.1
 */