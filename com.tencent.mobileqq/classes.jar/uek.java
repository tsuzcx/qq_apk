import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class uek
  implements uel
{
  public int a;
  protected String a;
  protected List<uff> a;
  protected uem a;
  protected boolean a;
  private List<uer> b;
  private List<uer> c = new ArrayList();
  
  public uek(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<ueq> paramList, String paramString) {}
  
  @NonNull
  protected List<uer> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<uer> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(uem paramuem)
  {
    wsv.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Uem = paramuem;
    paramuem = a();
    if ((paramuem == null) || (paramuem.isEmpty()))
    {
      wsv.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      wsv.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramuem = new ueq(this.jdField_a_of_type_Int, paramuem);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramuem);
    paramuem = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (uff)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (ueq)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          wsv.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((ueq)localObject3).toString());
          ((uff)localObject2).a((ueq)localObject3);
          localObject3 = ((uff)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            wsv.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            wsv.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              ueq localueq = (ueq)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localueq);
              } else {
                paramuem.add(localueq);
              }
            }
          }
        }
      }
      if (paramuem.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramuem;
      paramuem = (uem)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(uff paramuff)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramuff);
  }
  
  protected void b(List<ueq> paramList)
  {
    this.c = new ArrayList();
    this.c.addAll(this.b);
    if ((paramList != null) && (paramList.size() > 0))
    {
      c(paramList);
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Iterator localIterator = ((ueq)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            uer localuer = (uer)localIterator.next();
            this.c.remove(localuer);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      wsv.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Uem.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<ueq> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uek
 * JD-Core Version:    0.7.0.1
 */