import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class uit
  implements uiu
{
  public int a;
  protected String a;
  protected List<ujo> a;
  protected uiv a;
  protected boolean a;
  private List<uja> b;
  private List<uja> c = new ArrayList();
  
  public uit(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<uiz> paramList, String paramString) {}
  
  @NonNull
  protected List<uja> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<uja> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(uiv paramuiv)
  {
    wxe.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Uiv = paramuiv;
    paramuiv = a();
    if ((paramuiv == null) || (paramuiv.isEmpty()))
    {
      wxe.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      wxe.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramuiv = new uiz(this.jdField_a_of_type_Int, paramuiv);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramuiv);
    paramuiv = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (ujo)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (uiz)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          wxe.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((uiz)localObject3).toString());
          ((ujo)localObject2).a((uiz)localObject3);
          localObject3 = ((ujo)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            wxe.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            wxe.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              uiz localuiz = (uiz)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localuiz);
              } else {
                paramuiv.add(localuiz);
              }
            }
          }
        }
      }
      if (paramuiv.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramuiv;
      paramuiv = (uiv)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(ujo paramujo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramujo);
  }
  
  protected void b(List<uiz> paramList)
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
          Iterator localIterator = ((uiz)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            uja localuja = (uja)localIterator.next();
            this.c.remove(localuja);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      wxe.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Uiv.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<uiz> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uit
 * JD-Core Version:    0.7.0.1
 */