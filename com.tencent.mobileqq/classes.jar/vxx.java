import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class vxx
  extends vxv<vyf>
{
  public vxx()
  {
    a(new vyf());
  }
  
  private List<vxg> a(vyi paramvyi, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramvyi.jdField_a_of_type_Vyj.jdField_a_of_type_Int >= paramInt1)) || (paramvyi.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramvyi.a() >= ((vyf)a()).b)
      {
        localObject1 = new vxg(((vyf)a()).jdField_a_of_type_Int);
        ((vxg)localObject1).a(this.a);
        ((vxg)localObject1).d = paramvyi.jdField_a_of_type_Vyj.jdField_a_of_type_JavaLangString;
        ((vxg)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramvyi.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (vyi)((Iterator)localObject2).next();
          ((vxg)localObject1).jdField_a_of_type_JavaUtilList.add(((vyi)localObject3).jdField_a_of_type_Vyj.jdField_a_of_type_JavaLangString);
        }
        paramvyi.a();
        ykq.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramvyi = new ArrayList(1);
        paramvyi.add(localObject1);
        return paramvyi;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramvyi.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (vyi)((Iterator)localObject3).next();
      localObject5 = a((vyi)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((vyi)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((vyf)a()).b) && (paramvyi.jdField_a_of_type_Vyj.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new vxg(((vyf)a()).jdField_a_of_type_Int);
      ((vxg)localObject3).a(this.a);
      ((vxg)localObject3).d = paramvyi.jdField_a_of_type_Vyj.jdField_a_of_type_JavaLangString;
      ((vxg)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((vyi)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (vyi)((Iterator)localObject4).next();
          ((vxg)localObject3).jdField_a_of_type_JavaUtilList.add(((vyi)localObject5).jdField_a_of_type_Vyj.jdField_a_of_type_JavaLangString);
        }
      }
      paramvyi.a();
      ykq.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private vyh a(HashMap<String, List<vxh>> paramHashMap)
  {
    paramHashMap = new vyh(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<vxg> a(List<vxh> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (vxh)paramList.next();
      if (localHashMap.containsKey(((vxh)localObject1).c))
      {
        ((List)localHashMap.get(((vxh)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((vxh)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    ykq.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((vyf)a()).d), Integer.valueOf(((vyf)a()).e));
    paramList = a(paramList.a(), ((vyf)a()).d, ((vyf)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (vxg)((Iterator)localObject1).next();
        if ((((vxg)localObject2).jdField_a_of_type_JavaUtilList == null) || (((vxg)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          ykq.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          zdl.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((vxg)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((vxg)localObject2).a(localArrayList);
          ((vxg)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxx
 * JD-Core Version:    0.7.0.1
 */