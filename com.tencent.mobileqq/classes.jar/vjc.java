import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class vjc
  extends vja<vjk>
{
  public vjc()
  {
    a(new vjk());
  }
  
  private List<vil> a(vjn paramvjn, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramvjn.jdField_a_of_type_Vjo.jdField_a_of_type_Int >= paramInt1)) || (paramvjn.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramvjn.a() >= ((vjk)a()).b)
      {
        localObject1 = new vil(((vjk)a()).jdField_a_of_type_Int);
        ((vil)localObject1).a(this.a);
        ((vil)localObject1).d = paramvjn.jdField_a_of_type_Vjo.jdField_a_of_type_JavaLangString;
        ((vil)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramvjn.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (vjn)((Iterator)localObject2).next();
          ((vil)localObject1).jdField_a_of_type_JavaUtilList.add(((vjn)localObject3).jdField_a_of_type_Vjo.jdField_a_of_type_JavaLangString);
        }
        paramvjn.a();
        xvv.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramvjn = new ArrayList(1);
        paramvjn.add(localObject1);
        return paramvjn;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramvjn.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (vjn)((Iterator)localObject3).next();
      localObject5 = a((vjn)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((vjn)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((vjk)a()).b) && (paramvjn.jdField_a_of_type_Vjo.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new vil(((vjk)a()).jdField_a_of_type_Int);
      ((vil)localObject3).a(this.a);
      ((vil)localObject3).d = paramvjn.jdField_a_of_type_Vjo.jdField_a_of_type_JavaLangString;
      ((vil)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((vjn)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (vjn)((Iterator)localObject4).next();
          ((vil)localObject3).jdField_a_of_type_JavaUtilList.add(((vjn)localObject5).jdField_a_of_type_Vjo.jdField_a_of_type_JavaLangString);
        }
      }
      paramvjn.a();
      xvv.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private vjm a(HashMap<String, List<vim>> paramHashMap)
  {
    paramHashMap = new vjm(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<vil> a(List<vim> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (vim)paramList.next();
      if (localHashMap.containsKey(((vim)localObject1).c))
      {
        ((List)localHashMap.get(((vim)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((vim)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    xvv.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((vjk)a()).d), Integer.valueOf(((vjk)a()).e));
    paramList = a(paramList.a(), ((vjk)a()).d, ((vjk)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (vil)((Iterator)localObject1).next();
        if ((((vil)localObject2).jdField_a_of_type_JavaUtilList == null) || (((vil)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          xvv.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          yos.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((vil)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((vil)localObject2).a(localArrayList);
          ((vil)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjc
 * JD-Core Version:    0.7.0.1
 */