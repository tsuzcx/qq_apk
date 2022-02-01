import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class vxa
  implements vxb
{
  public int a;
  protected String a;
  protected List<vxv> a;
  protected vxc a;
  protected boolean a;
  private List<vxh> b;
  private List<vxh> c = new ArrayList();
  
  public vxa(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<vxg> paramList, String paramString) {}
  
  @NonNull
  protected List<vxh> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<vxh> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(vxc paramvxc)
  {
    ykq.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Vxc = paramvxc;
    paramvxc = a();
    if ((paramvxc == null) || (paramvxc.isEmpty()))
    {
      ykq.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      ykq.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramvxc = new vxg(this.jdField_a_of_type_Int, paramvxc);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramvxc);
    paramvxc = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (vxv)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (vxg)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          ykq.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((vxg)localObject3).toString());
          ((vxv)localObject2).a((vxg)localObject3);
          localObject3 = ((vxv)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            ykq.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            ykq.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              vxg localvxg = (vxg)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localvxg);
              } else {
                paramvxc.add(localvxg);
              }
            }
          }
        }
      }
      if (paramvxc.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramvxc;
      paramvxc = (vxc)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(vxv paramvxv)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramvxv);
  }
  
  protected void b(List<vxg> paramList)
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
          Iterator localIterator = ((vxg)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            vxh localvxh = (vxh)localIterator.next();
            this.c.remove(localvxh);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      ykq.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Vxc.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<vxg> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxa
 * JD-Core Version:    0.7.0.1
 */