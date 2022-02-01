import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wgx
  extends wgv<whf>
{
  public wgx()
  {
    a(new whf());
  }
  
  private List<wgg> a(whi paramwhi, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramwhi.jdField_a_of_type_Whj.jdField_a_of_type_Int >= paramInt1)) || (paramwhi.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramwhi.a() >= ((whf)a()).b)
      {
        localObject1 = new wgg(((whf)a()).jdField_a_of_type_Int);
        ((wgg)localObject1).a(this.a);
        ((wgg)localObject1).d = paramwhi.jdField_a_of_type_Whj.jdField_a_of_type_JavaLangString;
        ((wgg)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramwhi.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (whi)((Iterator)localObject2).next();
          ((wgg)localObject1).jdField_a_of_type_JavaUtilList.add(((whi)localObject3).jdField_a_of_type_Whj.jdField_a_of_type_JavaLangString);
        }
        paramwhi.a();
        yuk.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramwhi = new ArrayList(1);
        paramwhi.add(localObject1);
        return paramwhi;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramwhi.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (whi)((Iterator)localObject3).next();
      localObject5 = a((whi)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((whi)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((whf)a()).b) && (paramwhi.jdField_a_of_type_Whj.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new wgg(((whf)a()).jdField_a_of_type_Int);
      ((wgg)localObject3).a(this.a);
      ((wgg)localObject3).d = paramwhi.jdField_a_of_type_Whj.jdField_a_of_type_JavaLangString;
      ((wgg)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((whi)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (whi)((Iterator)localObject4).next();
          ((wgg)localObject3).jdField_a_of_type_JavaUtilList.add(((whi)localObject5).jdField_a_of_type_Whj.jdField_a_of_type_JavaLangString);
        }
      }
      paramwhi.a();
      yuk.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private whh a(HashMap<String, List<wgh>> paramHashMap)
  {
    paramHashMap = new whh(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<wgg> a(List<wgh> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (wgh)paramList.next();
      if (localHashMap.containsKey(((wgh)localObject1).c))
      {
        ((List)localHashMap.get(((wgh)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((wgh)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    yuk.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((whf)a()).d), Integer.valueOf(((whf)a()).e));
    paramList = a(paramList.a(), ((whf)a()).d, ((whf)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (wgg)((Iterator)localObject1).next();
        if ((((wgg)localObject2).jdField_a_of_type_JavaUtilList == null) || (((wgg)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          yuk.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          znw.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((wgg)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((wgg)localObject2).a(localArrayList);
          ((wgg)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgx
 * JD-Core Version:    0.7.0.1
 */