import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lpkd.a;>;

public class pkr
  extends pkn<pku.a>
{
  static SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd");
  private pkm c;
  private int mInterval = 1;
  
  private long G(long paramLong)
    throws ParseException
  {
    return t.parse(t.format(Long.valueOf(paramLong * 1000L))).getTime() / 1000L;
  }
  
  private int i(List<pkd.a> paramList)
  {
    int i = 1;
    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long l2 = -1L;
    int m = 0;
    for (;;)
    {
      int j;
      long l1;
      int k;
      if (m < paramList.size())
      {
        if (l2 < 0L) {
          j = i;
        }
        try
        {
          l1 = G(((pkd.a)paramList.get(m)).mCreateTime);
          k = i;
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
          rom.fail("we found the error time pic:" + paramList.get(m), new Object[0]);
          k = j;
          l1 = l2;
        }
        j = i;
        k = i;
        l1 = l2;
        if (((pkd.a)paramList.get(m)).mCreateTime - l2 > 86400L)
        {
          k = i + 1;
          j = k;
          l1 = G(((pkd.a)paramList.get(m)).mCreateTime);
        }
      }
      else
      {
        ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", "caculatePictureDistribution=" + i);
        return i;
      }
      m += 1;
      i = k;
      l2 = l1;
    }
  }
  
  protected List<pkd> ah(@NonNull List<pkd.a> paramList)
  {
    Object localObject1 = new pla();
    paramList = new ArrayList(paramList);
    pju.dI(paramList);
    int i = i(paramList) / this.mInterval;
    String[] arrayOfString = new String[1];
    ((pla)localObject1).vF(i + 1);
    paramList = ((pla)localObject1).b(paramList, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      localObject1 = (List)paramList.get(i);
      Collections.sort((List)localObject1, new pks(this));
      localObject2 = new pkd(this.a.mAlbumType, (List)localObject1);
      ((pkd)localObject2).M(((pkd.a)((List)localObject1).get(0)).mCreateTime, ((pkd.a)((List)localObject1).get(((List)localObject1).size() - 1)).mCreateTime);
      localArrayList.add(localObject2);
      i += 1;
    }
    paramList = "k means split : k=" + localArrayList.size();
    Collections.sort(localArrayList, new pkt(this));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = localArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (pkd)((Iterator)localObject2).next();
      paramList = paramList + "[ s=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((pkd)localObject3).getStartTime() * 1000L)) + " e=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((pkd)localObject3).getEndTime() * 1000L)) + " c=" + ((pkd)localObject3).getCount() + "]";
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", paramList);
    localObject2 = "(k=" + localArrayList.size() + " " + paramList + ");";
    paramList = (String)((psr)psx.a(10)).c("key_album_debug_k", "");
    if (!TextUtils.isEmpty(paramList))
    {
      localObject3 = paramList.split(";");
      paramList = "";
      i = 0;
      localObject1 = paramList;
      if (i < localObject3.length)
      {
        paramList = localObject3[i] + paramList;
        if (i != 8) {
          break label500;
        }
        localObject1 = paramList;
      }
    }
    for (paramList = (String)localObject2 + (String)localObject1;; paramList = (List<pkd.a>)localObject2)
    {
      this.c.asU = paramList;
      this.c.asV = arrayOfString[0];
      return localArrayList;
      label500:
      i += 1;
      break;
    }
  }
  
  public void c(pkm parampkm)
  {
    this.c = parampkm;
  }
  
  public void setInterval(int paramInt)
  {
    this.mInterval = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkr
 * JD-Core Version:    0.7.0.1
 */