import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wga
  implements wgb
{
  public int a;
  protected String a;
  protected List<wgv> a;
  protected wgc a;
  protected boolean a;
  private List<wgh> b;
  private List<wgh> c = new ArrayList();
  
  public wga(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<wgg> paramList, String paramString) {}
  
  @NonNull
  protected List<wgh> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<wgh> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(wgc paramwgc)
  {
    yuk.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Wgc = paramwgc;
    paramwgc = a();
    if ((paramwgc == null) || (paramwgc.isEmpty()))
    {
      yuk.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      yuk.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramwgc = new wgg(this.jdField_a_of_type_Int, paramwgc);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramwgc);
    paramwgc = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (wgv)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (wgg)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          yuk.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((wgg)localObject3).toString());
          ((wgv)localObject2).a((wgg)localObject3);
          localObject3 = ((wgv)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            yuk.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            yuk.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              wgg localwgg = (wgg)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localwgg);
              } else {
                paramwgc.add(localwgg);
              }
            }
          }
        }
      }
      if (paramwgc.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramwgc;
      paramwgc = (wgc)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(wgv paramwgv)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramwgv);
  }
  
  protected void b(List<wgg> paramList)
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
          Iterator localIterator = ((wgg)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            wgh localwgh = (wgh)localIterator.next();
            this.c.remove(localwgh);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      yuk.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Wgc.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<wgg> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */