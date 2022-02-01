import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lwgh;>;

public class wgz
  extends wgv<whd>
{
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private int jdField_a_of_type_Int = 1;
  private wgu jdField_a_of_type_Wgu;
  
  private int a(List<wgh> paramList)
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
          l1 = a(((wgh)paramList.get(m)).b);
          k = i;
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
          znw.a("we found the error time pic:" + paramList.get(m), new Object[0]);
          k = j;
          l1 = l2;
        }
        j = i;
        k = i;
        l1 = l2;
        if (((wgh)paramList.get(m)).b - l2 > 86400L)
        {
          k = i + 1;
          j = k;
          l1 = a(((wgh)paramList.get(m)).b);
        }
      }
      else
      {
        yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", "caculatePictureDistribution=" + i);
        return i;
      }
      m += 1;
      i = k;
      l2 = l1;
    }
  }
  
  private long a(long paramLong)
  {
    return jdField_a_of_type_JavaTextSimpleDateFormat.parse(jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong * 1000L))).getTime() / 1000L;
  }
  
  protected List<wgg> a(@NonNull List<wgh> paramList)
  {
    Object localObject1 = new whq();
    paramList = new ArrayList(paramList);
    wfv.b(paramList);
    int i = a(paramList) / this.jdField_a_of_type_Int;
    String[] arrayOfString = new String[1];
    ((whq)localObject1).a(i + 1);
    paramList = ((whq)localObject1).a(paramList, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      localObject1 = (List)paramList.get(i);
      Collections.sort((List)localObject1, new wha(this));
      localObject2 = new wgg(this.jdField_a_of_type_Wgg.jdField_a_of_type_Int, (List)localObject1);
      ((wgg)localObject2).a(((wgh)((List)localObject1).get(0)).b, ((wgh)((List)localObject1).get(((List)localObject1).size() - 1)).b);
      localArrayList.add(localObject2);
      i += 1;
    }
    paramList = "k means split : k=" + localArrayList.size();
    Collections.sort(localArrayList, new whb(this));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = localArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (wgg)((Iterator)localObject2).next();
      paramList = paramList + "[ s=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((wgg)localObject3).f() * 1000L)) + " e=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((wgg)localObject3).g() * 1000L)) + " c=" + ((wgg)localObject3).b() + "]";
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", paramList);
    localObject2 = "(k=" + localArrayList.size() + " " + paramList + ");";
    paramList = (String)((wta)wth.a(10)).b("key_album_debug_k", "");
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
    for (paramList = (String)localObject2 + (String)localObject1;; paramList = (List<wgh>)localObject2)
    {
      this.jdField_a_of_type_Wgu.a = paramList;
      this.jdField_a_of_type_Wgu.b = arrayOfString[0];
      return localArrayList;
      label500:
      i += 1;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(wgu paramwgu)
  {
    this.jdField_a_of_type_Wgu = paramwgu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgz
 * JD-Core Version:    0.7.0.1
 */