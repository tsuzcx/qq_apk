import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class xnl
{
  private static xni jdField_a_of_type_Xni = new xni();
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  public List<xnh> a;
  public boolean a;
  private int b;
  
  public xnl()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public xnl(xnl paramxnl)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramxnl.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = paramxnl.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramxnl.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramxnl.jdField_a_of_type_Int;
    this.b = paramxnl.b;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public xnm a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i;
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        xnm localxnm1 = new xnm();
        if (paramInt1 == 0)
        {
          localxnm1.jdField_a_of_type_Boolean = bool;
          if (this.jdField_a_of_type_JavaUtilList.size() <= paramInt1) {
            break label330;
          }
          i = paramInt2;
          if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
            i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
          }
          if ((paramInt1 + i >= this.jdField_a_of_type_JavaUtilList.size()) && (a())) {
            localxnm1.b = true;
          }
          localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          localxnm1.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
          paramInt2 = paramInt1 + i;
          if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label309;
          }
          xnh localxnh1 = (xnh)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          Iterator localIterator = localxnm1.jdField_a_of_type_JavaUtilList.iterator();
          if (!localxnh1.b) {
            break label309;
          }
          if (!localIterator.hasNext()) {
            break;
          }
          xnh localxnh2 = (xnh)localIterator.next();
          if ((!localxnh2.b) || (!localxnh2.c.equals(localxnh1.c))) {
            continue;
          }
          localIterator.remove();
          xvv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localxnh2 });
          continue;
        }
        bool = false;
      }
      finally {}
    }
    if (localxnm2.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localxnm2.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
      xvv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localxnm2.jdField_a_of_type_JavaUtilList });
    }
    for (;;)
    {
      label309:
      this.b = (localxnm2.jdField_a_of_type_JavaUtilList.size() + paramInt1);
      return localxnm2;
      label330:
      localxnm2.b = a();
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
  
  public void a(List<xnh> paramList, String paramString, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      xvv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId list:set next cookie data count:%d, cookie:%s, isEnd:%b", new Object[] { Integer.valueOf(paramList.size()), paramString, Boolean.valueOf(paramBoolean) });
      xvv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "add feed list:%s", paramList);
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
      if (xvv.a()) {
        xvv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_Xni);
      if (xvv.a()) {
        xvv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnl
 * JD-Core Version:    0.7.0.1
 */