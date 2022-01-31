import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class uja
{
  private static uix jdField_a_of_type_Uix = new uix();
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  public List<uiw> a;
  public boolean a;
  private int b;
  
  public uja()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public uja(uja paramuja)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramuja.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = paramuja.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramuja.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramuja.jdField_a_of_type_Int;
    this.b = paramuja.b;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ujb a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i;
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        ujb localujb1 = new ujb();
        if (paramInt1 == 0)
        {
          localujb1.jdField_a_of_type_Boolean = bool;
          if (this.jdField_a_of_type_JavaUtilList.size() <= paramInt1) {
            break label330;
          }
          i = paramInt2;
          if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
            i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
          }
          if ((paramInt1 + i >= this.jdField_a_of_type_JavaUtilList.size()) && (a())) {
            localujb1.b = true;
          }
          localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          localujb1.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
          paramInt2 = paramInt1 + i;
          if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label309;
          }
          uiw localuiw1 = (uiw)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          Iterator localIterator = localujb1.jdField_a_of_type_JavaUtilList.iterator();
          if (!localuiw1.b) {
            break label309;
          }
          if (!localIterator.hasNext()) {
            break;
          }
          uiw localuiw2 = (uiw)localIterator.next();
          if ((!localuiw2.b) || (!localuiw2.c.equals(localuiw1.c))) {
            continue;
          }
          localIterator.remove();
          urk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localuiw2 });
          continue;
        }
        bool = false;
      }
      finally {}
    }
    if (localujb2.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localujb2.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
      urk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localujb2.jdField_a_of_type_JavaUtilList });
    }
    for (;;)
    {
      label309:
      this.b = (localujb2.jdField_a_of_type_JavaUtilList.size() + paramInt1);
      return localujb2;
      label330:
      localujb2.b = a();
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
  
  public void a(List<uiw> paramList, String paramString, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      urk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId list:set next cookie data count:%d, cookie:%s, isEnd:%b", new Object[] { Integer.valueOf(paramList.size()), paramString, Boolean.valueOf(paramBoolean) });
      urk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "add feed list:%s", paramList);
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
      if (urk.a()) {
        urk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_Uix);
      if (urk.a()) {
        urk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
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
 * Qualified Name:     uja
 * JD-Core Version:    0.7.0.1
 */