import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wdl
  extends wda<wdj>
{
  protected List<wcm> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      wcm localwcm = (wcm)((Iterator)localObject).next();
      if ((localwcm.jdField_b_of_type_Long >= ((wdj)a()).jdField_a_of_type_Long) && (localwcm.jdField_b_of_type_Long <= ((wdj)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localwcm);
      }
    }
    return localArrayList;
  }
  
  protected List<wcl> a(@NonNull List<wcm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new wcl(((wdj)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((wdj)a()).jdField_a_of_type_Long, ((wdj)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((wdj)a()).c;
    Object localObject = wpj.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((wdj)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((wdj)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(wcl.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((wdj)a()).jdField_b_of_type_Int) {
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
      yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<wcl> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdl
 * JD-Core Version:    0.7.0.1
 */