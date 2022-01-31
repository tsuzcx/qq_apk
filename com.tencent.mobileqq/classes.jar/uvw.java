import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class uvw
{
  private static uvt jdField_a_of_type_Uvt = new uvt();
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  public List<uvs> a;
  public boolean a;
  private int b;
  
  public uvw()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public uvw(uvw paramuvw)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramuvw.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = paramuvw.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramuvw.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramuvw.jdField_a_of_type_Int;
    this.b = paramuvw.b;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public uvx a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i;
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        uvx localuvx1 = new uvx();
        if (paramInt1 == 0)
        {
          localuvx1.jdField_a_of_type_Boolean = bool;
          if (this.jdField_a_of_type_JavaUtilList.size() <= paramInt1) {
            break label330;
          }
          i = paramInt2;
          if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
            i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
          }
          if ((paramInt1 + i >= this.jdField_a_of_type_JavaUtilList.size()) && (a())) {
            localuvx1.b = true;
          }
          localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          localuvx1.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
          paramInt2 = paramInt1 + i;
          if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label309;
          }
          uvs localuvs1 = (uvs)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          Iterator localIterator = localuvx1.jdField_a_of_type_JavaUtilList.iterator();
          if (!localuvs1.b) {
            break label309;
          }
          if (!localIterator.hasNext()) {
            break;
          }
          uvs localuvs2 = (uvs)localIterator.next();
          if ((!localuvs2.b) || (!localuvs2.c.equals(localuvs1.c))) {
            continue;
          }
          localIterator.remove();
          veg.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localuvs2 });
          continue;
        }
        bool = false;
      }
      finally {}
    }
    if (localuvx2.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localuvx2.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
      veg.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localuvx2.jdField_a_of_type_JavaUtilList });
    }
    for (;;)
    {
      label309:
      this.b = (localuvx2.jdField_a_of_type_JavaUtilList.size() + paramInt1);
      return localuvx2;
      label330:
      localuvx2.b = a();
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.b = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<uvs> paramList, String paramString, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      veg.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId list:set next cookie data count:%d, cookie:%s, isEnd:%b", new Object[] { Integer.valueOf(paramList.size()), paramString, Boolean.valueOf(paramBoolean) });
      veg.a("Q.qqstory.home.data.FeedListPageLoaderBase", "add feed list:%s", paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Int = this.b;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      if (veg.a()) {
        veg.a("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_Uvt);
      if (veg.a()) {
        veg.a("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    try
    {
      String str = "FeedIdListCache{mFeedIdListCache=" + this.jdField_a_of_type_JavaUtilList + ", mFeedIdNextCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mIsEnd=" + this.jdField_a_of_type_Boolean + ", mCurFeedIdPosition=" + this.jdField_a_of_type_Int + ", mTempFeedIdPosition=" + this.b + '}';
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvw
 * JD-Core Version:    0.7.0.1
 */