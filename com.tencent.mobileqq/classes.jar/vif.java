import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class vif
  implements vig
{
  public int a;
  protected String a;
  protected List<vja> a;
  protected vih a;
  protected boolean a;
  private List<vim> b;
  private List<vim> c = new ArrayList();
  
  public vif(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<vil> paramList, String paramString) {}
  
  @NonNull
  protected List<vim> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<vim> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(vih paramvih)
  {
    xvv.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Vih = paramvih;
    paramvih = a();
    if ((paramvih == null) || (paramvih.isEmpty()))
    {
      xvv.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      xvv.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramvih = new vil(this.jdField_a_of_type_Int, paramvih);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramvih);
    paramvih = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (vja)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (vil)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          xvv.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((vil)localObject3).toString());
          ((vja)localObject2).a((vil)localObject3);
          localObject3 = ((vja)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            xvv.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            xvv.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              vil localvil = (vil)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localvil);
              } else {
                paramvih.add(localvil);
              }
            }
          }
        }
      }
      if (paramvih.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramvih;
      paramvih = (vih)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(vja paramvja)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramvja);
  }
  
  protected void b(List<vil> paramList)
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
          Iterator localIterator = ((vil)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            vim localvim = (vim)localIterator.next();
            this.c.remove(localvim);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      xvv.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Vih.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<vil> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vif
 * JD-Core Version:    0.7.0.1
 */