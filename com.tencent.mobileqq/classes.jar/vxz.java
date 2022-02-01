import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lvxh;>;

public class vxz
  extends vxv<vyd>
{
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private int jdField_a_of_type_Int = 1;
  private vxu jdField_a_of_type_Vxu;
  
  private int a(List<vxh> paramList)
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
          l1 = a(((vxh)paramList.get(m)).b);
          k = i;
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
          zdl.a("we found the error time pic:" + paramList.get(m), new Object[0]);
          k = j;
          l1 = l2;
        }
        j = i;
        k = i;
        l1 = l2;
        if (((vxh)paramList.get(m)).b - l2 > 86400L)
        {
          k = i + 1;
          j = k;
          l1 = a(((vxh)paramList.get(m)).b);
        }
      }
      else
      {
        ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", "caculatePictureDistribution=" + i);
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
  
  protected List<vxg> a(@NonNull List<vxh> paramList)
  {
    Object localObject1 = new vyq();
    paramList = new ArrayList(paramList);
    vwv.b(paramList);
    int i = a(paramList) / this.jdField_a_of_type_Int;
    String[] arrayOfString = new String[1];
    ((vyq)localObject1).a(i + 1);
    paramList = ((vyq)localObject1).a(paramList, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      localObject1 = (List)paramList.get(i);
      Collections.sort((List)localObject1, new vya(this));
      localObject2 = new vxg(this.jdField_a_of_type_Vxg.jdField_a_of_type_Int, (List)localObject1);
      ((vxg)localObject2).a(((vxh)((List)localObject1).get(0)).b, ((vxh)((List)localObject1).get(((List)localObject1).size() - 1)).b);
      localArrayList.add(localObject2);
      i += 1;
    }
    paramList = "k means split : k=" + localArrayList.size();
    Collections.sort(localArrayList, new vyb(this));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = localArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (vxg)((Iterator)localObject2).next();
      paramList = paramList + "[ s=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((vxg)localObject3).f() * 1000L)) + " e=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((vxg)localObject3).g() * 1000L)) + " c=" + ((vxg)localObject3).b() + "]";
    }
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", paramList);
    localObject2 = "(k=" + localArrayList.size() + " " + paramList + ");";
    paramList = (String)((wjl)wjs.a(10)).b("key_album_debug_k", "");
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
    for (paramList = (String)localObject2 + (String)localObject1;; paramList = (List<vxh>)localObject2)
    {
      this.jdField_a_of_type_Vxu.a = paramList;
      this.jdField_a_of_type_Vxu.b = arrayOfString[0];
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
  
  public void a(vxu paramvxu)
  {
    this.jdField_a_of_type_Vxu = paramvxu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxz
 * JD-Core Version:    0.7.0.1
 */