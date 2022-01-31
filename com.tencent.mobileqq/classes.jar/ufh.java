import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ufh
  extends uff<ufp>
{
  public ufh()
  {
    a(new ufp());
  }
  
  private List<ueq> a(ufs paramufs, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramufs.jdField_a_of_type_Uft.jdField_a_of_type_Int >= paramInt1)) || (paramufs.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramufs.a() >= ((ufp)a()).b)
      {
        localObject1 = new ueq(((ufp)a()).jdField_a_of_type_Int);
        ((ueq)localObject1).a(this.a);
        ((ueq)localObject1).d = paramufs.jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString;
        ((ueq)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramufs.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ufs)((Iterator)localObject2).next();
          ((ueq)localObject1).jdField_a_of_type_JavaUtilList.add(((ufs)localObject3).jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString);
        }
        paramufs.a();
        wsv.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramufs = new ArrayList(1);
        paramufs.add(localObject1);
        return paramufs;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramufs.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ufs)((Iterator)localObject3).next();
      localObject5 = a((ufs)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((ufs)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((ufp)a()).b) && (paramufs.jdField_a_of_type_Uft.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new ueq(((ufp)a()).jdField_a_of_type_Int);
      ((ueq)localObject3).a(this.a);
      ((ueq)localObject3).d = paramufs.jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString;
      ((ueq)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((ufs)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ufs)((Iterator)localObject4).next();
          ((ueq)localObject3).jdField_a_of_type_JavaUtilList.add(((ufs)localObject5).jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString);
        }
      }
      paramufs.a();
      wsv.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private ufr a(HashMap<String, List<uer>> paramHashMap)
  {
    paramHashMap = new ufr(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<ueq> a(List<uer> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (uer)paramList.next();
      if (localHashMap.containsKey(((uer)localObject1).c))
      {
        ((List)localHashMap.get(((uer)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((uer)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    wsv.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((ufp)a()).d), Integer.valueOf(((ufp)a()).e));
    paramList = a(paramList.a(), ((ufp)a()).d, ((ufp)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ueq)((Iterator)localObject1).next();
        if ((((ueq)localObject2).jdField_a_of_type_JavaUtilList == null) || (((ueq)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          wsv.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          xmh.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((ueq)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((ueq)localObject2).a(localArrayList);
          ((ueq)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufh
 * JD-Core Version:    0.7.0.1
 */