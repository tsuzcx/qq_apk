import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pkv
  extends pkn<pku.b>
{
  protected List<pkd> ah(@NonNull List<pkd.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new pkd(((pku.b)a()).type, paramList);
    paramList.M(((pku.b)a()).mStartTime, ((pku.b)a()).mEndTime);
    paramList.a(a());
    paramList.mAlbumName = ((pku.b)a()).mAlbumName;
    Object localObject = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.mAlbumName)) || (localStoryAlbumEntry.startTime < ((pku.b)a()).mStartTime) || (localStoryAlbumEntry.startTime > ((pku.b)a()).mEndTime)) {}
      }
      else
      {
        try
        {
          paramList.b(pkd.a(localStoryAlbumEntry));
          paramList.setId(localStoryAlbumEntry.getId());
          ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.getCount() >= ((pku.b)a()).bje) {
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
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<pkd> bE()
  {
    List localList = getData();
    if ((localList == null) || (localList.size() == 0))
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return ah(localList);
  }
  
  protected List<pkd.a> getData()
  {
    Object localObject = super.getData();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      pkd.a locala = (pkd.a)((Iterator)localObject).next();
      if ((locala.mCreateTime >= ((pku.b)a()).mStartTime) && (locala.mCreateTime <= ((pku.b)a()).mEndTime)) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkv
 * JD-Core Version:    0.7.0.1
 */