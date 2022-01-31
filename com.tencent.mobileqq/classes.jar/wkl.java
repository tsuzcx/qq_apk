import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class wkl
{
  private static wki jdField_a_of_type_Wki = new wki();
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  public List<wkh> a;
  public boolean a;
  private int b;
  
  public wkl()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public wkl(wkl paramwkl)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramwkl.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = paramwkl.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramwkl.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramwkl.jdField_a_of_type_Int;
    this.b = paramwkl.b;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public wkm a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i;
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        wkm localwkm1 = new wkm();
        if (paramInt1 == 0)
        {
          localwkm1.jdField_a_of_type_Boolean = bool;
          if (this.jdField_a_of_type_JavaUtilList.size() <= paramInt1) {
            break label330;
          }
          i = paramInt2;
          if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
            i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
          }
          if ((paramInt1 + i >= this.jdField_a_of_type_JavaUtilList.size()) && (a())) {
            localwkm1.b = true;
          }
          localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          localwkm1.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
          paramInt2 = paramInt1 + i;
          if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label309;
          }
          wkh localwkh1 = (wkh)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          Iterator localIterator = localwkm1.jdField_a_of_type_JavaUtilList.iterator();
          if (!localwkh1.b) {
            break label309;
          }
          if (!localIterator.hasNext()) {
            break;
          }
          wkh localwkh2 = (wkh)localIterator.next();
          if ((!localwkh2.b) || (!localwkh2.c.equals(localwkh1.c))) {
            continue;
          }
          localIterator.remove();
          wsv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localwkh2 });
          continue;
        }
        bool = false;
      }
      finally {}
    }
    if (localwkm2.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localwkm2.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
      wsv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localwkm2.jdField_a_of_type_JavaUtilList });
    }
    for (;;)
    {
      label309:
      this.b = (localwkm2.jdField_a_of_type_JavaUtilList.size() + paramInt1);
      return localwkm2;
      label330:
      localwkm2.b = a();
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
  
  public void a(List<wkh> paramList, String paramString, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      wsv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId list:set next cookie data count:%d, cookie:%s, isEnd:%b", new Object[] { Integer.valueOf(paramList.size()), paramString, Boolean.valueOf(paramBoolean) });
      wsv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "add feed list:%s", paramList);
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
      if (wsv.a()) {
        wsv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_Wki);
      if (wsv.a()) {
        wsv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkl
 * JD-Core Version:    0.7.0.1
 */