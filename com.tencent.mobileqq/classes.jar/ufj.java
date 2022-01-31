import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Luer;>;

public class ufj
  extends uff<ufn>
{
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private int jdField_a_of_type_Int = 1;
  private ufe jdField_a_of_type_Ufe;
  
  private int a(List<uer> paramList)
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
          l1 = a(((uer)paramList.get(m)).b);
          k = i;
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
          xmh.a("we found the error time pic:" + paramList.get(m), new Object[0]);
          k = j;
          l1 = l2;
        }
        j = i;
        k = i;
        l1 = l2;
        if (((uer)paramList.get(m)).b - l2 > 86400L)
        {
          k = i + 1;
          j = k;
          l1 = a(((uer)paramList.get(m)).b);
        }
      }
      else
      {
        wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", "caculatePictureDistribution=" + i);
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
  
  protected List<ueq> a(@NonNull List<uer> paramList)
  {
    Object localObject1 = new uga();
    paramList = new ArrayList(paramList);
    uef.b(paramList);
    int i = a(paramList) / this.jdField_a_of_type_Int;
    String[] arrayOfString = new String[1];
    ((uga)localObject1).a(i + 1);
    paramList = ((uga)localObject1).a(paramList, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      localObject1 = (List)paramList.get(i);
      Collections.sort((List)localObject1, new ufk(this));
      localObject2 = new ueq(this.jdField_a_of_type_Ueq.jdField_a_of_type_Int, (List)localObject1);
      ((ueq)localObject2).a(((uer)((List)localObject1).get(0)).b, ((uer)((List)localObject1).get(((List)localObject1).size() - 1)).b);
      localArrayList.add(localObject2);
      i += 1;
    }
    paramList = "k means split : k=" + localArrayList.size();
    Collections.sort(localArrayList, new ufl(this));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = localArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ueq)((Iterator)localObject2).next();
      paramList = paramList + "[ s=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((ueq)localObject3).f() * 1000L)) + " e=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((ueq)localObject3).g() * 1000L)) + " c=" + ((ueq)localObject3).b() + "]";
    }
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", paramList);
    localObject2 = "(k=" + localArrayList.size() + " " + paramList + ");";
    paramList = (String)((urk)urr.a(10)).b("key_album_debug_k", "");
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
    for (paramList = (String)localObject2 + (String)localObject1;; paramList = (List<uer>)localObject2)
    {
      this.jdField_a_of_type_Ufe.a = paramList;
      this.jdField_a_of_type_Ufe.b = arrayOfString[0];
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
  
  public void a(ufe paramufe)
  {
    this.jdField_a_of_type_Ufe = paramufe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufj
 * JD-Core Version:    0.7.0.1
 */