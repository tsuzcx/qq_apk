import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ujq
  extends ujo<ujy>
{
  public ujq()
  {
    a(new ujy());
  }
  
  private List<uiz> a(ukb paramukb, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramukb.jdField_a_of_type_Ukc.jdField_a_of_type_Int >= paramInt1)) || (paramukb.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramukb.a() >= ((ujy)a()).b)
      {
        localObject1 = new uiz(((ujy)a()).jdField_a_of_type_Int);
        ((uiz)localObject1).a(this.a);
        ((uiz)localObject1).d = paramukb.jdField_a_of_type_Ukc.jdField_a_of_type_JavaLangString;
        ((uiz)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramukb.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ukb)((Iterator)localObject2).next();
          ((uiz)localObject1).jdField_a_of_type_JavaUtilList.add(((ukb)localObject3).jdField_a_of_type_Ukc.jdField_a_of_type_JavaLangString);
        }
        paramukb.a();
        wxe.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramukb = new ArrayList(1);
        paramukb.add(localObject1);
        return paramukb;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramukb.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ukb)((Iterator)localObject3).next();
      localObject5 = a((ukb)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((ukb)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((ujy)a()).b) && (paramukb.jdField_a_of_type_Ukc.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new uiz(((ujy)a()).jdField_a_of_type_Int);
      ((uiz)localObject3).a(this.a);
      ((uiz)localObject3).d = paramukb.jdField_a_of_type_Ukc.jdField_a_of_type_JavaLangString;
      ((uiz)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((ukb)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ukb)((Iterator)localObject4).next();
          ((uiz)localObject3).jdField_a_of_type_JavaUtilList.add(((ukb)localObject5).jdField_a_of_type_Ukc.jdField_a_of_type_JavaLangString);
        }
      }
      paramukb.a();
      wxe.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private uka a(HashMap<String, List<uja>> paramHashMap)
  {
    paramHashMap = new uka(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<uiz> a(List<uja> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (uja)paramList.next();
      if (localHashMap.containsKey(((uja)localObject1).c))
      {
        ((List)localHashMap.get(((uja)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((uja)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    wxe.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((ujy)a()).d), Integer.valueOf(((ujy)a()).e));
    paramList = a(paramList.a(), ((ujy)a()).d, ((ujy)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (uiz)((Iterator)localObject1).next();
        if ((((uiz)localObject2).jdField_a_of_type_JavaUtilList == null) || (((uiz)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          wxe.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          xqq.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((uiz)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((uiz)localObject2).a(localArrayList);
          ((uiz)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujq
 * JD-Core Version:    0.7.0.1
 */