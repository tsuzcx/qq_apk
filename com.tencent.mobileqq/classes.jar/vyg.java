import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vyg
  extends vxv<vye>
{
  protected List<vxh> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      vxh localvxh = (vxh)((Iterator)localObject).next();
      if ((localvxh.jdField_b_of_type_Long >= ((vye)a()).jdField_a_of_type_Long) && (localvxh.jdField_b_of_type_Long <= ((vye)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localvxh);
      }
    }
    return localArrayList;
  }
  
  protected List<vxg> a(@NonNull List<vxh> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new vxg(((vye)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((vye)a()).jdField_a_of_type_Long, ((vye)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((vye)a()).c;
    Object localObject = wjp.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((vye)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((vye)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(vxg.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((vye)a()).jdField_b_of_type_Int) {
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
      ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<vxg> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyg
 * JD-Core Version:    0.7.0.1
 */