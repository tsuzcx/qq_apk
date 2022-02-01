import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wdc
  extends wda<wdk>
{
  public wdc()
  {
    a(new wdk());
  }
  
  private List<wcl> a(wdn paramwdn, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramwdn.jdField_a_of_type_Wdo.jdField_a_of_type_Int >= paramInt1)) || (paramwdn.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramwdn.a() >= ((wdk)a()).b)
      {
        localObject1 = new wcl(((wdk)a()).jdField_a_of_type_Int);
        ((wcl)localObject1).a(this.a);
        ((wcl)localObject1).d = paramwdn.jdField_a_of_type_Wdo.jdField_a_of_type_JavaLangString;
        ((wcl)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramwdn.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (wdn)((Iterator)localObject2).next();
          ((wcl)localObject1).jdField_a_of_type_JavaUtilList.add(((wdn)localObject3).jdField_a_of_type_Wdo.jdField_a_of_type_JavaLangString);
        }
        paramwdn.a();
        yqp.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramwdn = new ArrayList(1);
        paramwdn.add(localObject1);
        return paramwdn;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramwdn.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (wdn)((Iterator)localObject3).next();
      localObject5 = a((wdn)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((wdn)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((wdk)a()).b) && (paramwdn.jdField_a_of_type_Wdo.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new wcl(((wdk)a()).jdField_a_of_type_Int);
      ((wcl)localObject3).a(this.a);
      ((wcl)localObject3).d = paramwdn.jdField_a_of_type_Wdo.jdField_a_of_type_JavaLangString;
      ((wcl)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((wdn)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (wdn)((Iterator)localObject4).next();
          ((wcl)localObject3).jdField_a_of_type_JavaUtilList.add(((wdn)localObject5).jdField_a_of_type_Wdo.jdField_a_of_type_JavaLangString);
        }
      }
      paramwdn.a();
      yqp.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private wdm a(HashMap<String, List<wcm>> paramHashMap)
  {
    paramHashMap = new wdm(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<wcl> a(List<wcm> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (wcm)paramList.next();
      if (localHashMap.containsKey(((wcm)localObject1).c))
      {
        ((List)localHashMap.get(((wcm)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((wcm)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    yqp.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((wdk)a()).d), Integer.valueOf(((wdk)a()).e));
    paramList = a(paramList.a(), ((wdk)a()).d, ((wdk)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (wcl)((Iterator)localObject1).next();
        if ((((wcl)localObject2).jdField_a_of_type_JavaUtilList == null) || (((wcl)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          yqp.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          zkb.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((wcl)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((wcl)localObject2).a(localArrayList);
          ((wcl)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdc
 * JD-Core Version:    0.7.0.1
 */