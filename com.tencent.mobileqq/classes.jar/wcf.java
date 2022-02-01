import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wcf
  implements wcg
{
  public int a;
  protected String a;
  protected List<wda> a;
  protected wch a;
  protected boolean a;
  private List<wcm> b;
  private List<wcm> c = new ArrayList();
  
  public wcf(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<wcl> paramList, String paramString) {}
  
  @NonNull
  protected List<wcm> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<wcm> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(wch paramwch)
  {
    yqp.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Wch = paramwch;
    paramwch = a();
    if ((paramwch == null) || (paramwch.isEmpty()))
    {
      yqp.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      yqp.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramwch = new wcl(this.jdField_a_of_type_Int, paramwch);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramwch);
    paramwch = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (wda)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (wcl)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          yqp.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((wcl)localObject3).toString());
          ((wda)localObject2).a((wcl)localObject3);
          localObject3 = ((wda)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            yqp.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            yqp.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              wcl localwcl = (wcl)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localwcl);
              } else {
                paramwch.add(localwcl);
              }
            }
          }
        }
      }
      if (paramwch.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramwch;
      paramwch = (wch)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(wda paramwda)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramwda);
  }
  
  protected void b(List<wcl> paramList)
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
          Iterator localIterator = ((wcl)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            wcm localwcm = (wcm)localIterator.next();
            this.c.remove(localwcm);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      yqp.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Wch.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<wcl> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcf
 * JD-Core Version:    0.7.0.1
 */