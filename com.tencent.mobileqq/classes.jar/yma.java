import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class yma
{
  private static ylx jdField_a_of_type_Ylx = new ylx();
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  public List<ylw> a;
  public boolean a;
  private int b;
  
  public yma()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public yma(yma paramyma)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramyma.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = paramyma.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramyma.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramyma.jdField_a_of_type_Int;
    this.b = paramyma.b;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ymb a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i;
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        ymb localymb1 = new ymb();
        if (paramInt1 == 0)
        {
          localymb1.jdField_a_of_type_Boolean = bool;
          if (this.jdField_a_of_type_JavaUtilList.size() <= paramInt1) {
            break label330;
          }
          i = paramInt2;
          if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
            i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
          }
          if ((paramInt1 + i >= this.jdField_a_of_type_JavaUtilList.size()) && (a())) {
            localymb1.b = true;
          }
          localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          localymb1.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
          paramInt2 = paramInt1 + i;
          if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label309;
          }
          ylw localylw1 = (ylw)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          Iterator localIterator = localymb1.jdField_a_of_type_JavaUtilList.iterator();
          if (!localylw1.b) {
            break label309;
          }
          if (!localIterator.hasNext()) {
            break;
          }
          ylw localylw2 = (ylw)localIterator.next();
          if ((!localylw2.b) || (!localylw2.c.equals(localylw1.c))) {
            continue;
          }
          localIterator.remove();
          yuk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localylw2 });
          continue;
        }
        bool = false;
      }
      finally {}
    }
    if (localymb2.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localymb2.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
      yuk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localymb2.jdField_a_of_type_JavaUtilList });
    }
    for (;;)
    {
      label309:
      this.b = (localymb2.jdField_a_of_type_JavaUtilList.size() + paramInt1);
      return localymb2;
      label330:
      localymb2.b = a();
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
  
  public void a(List<ylw> paramList, String paramString, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      yuk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId list:set next cookie data count:%d, cookie:%s, isEnd:%b", new Object[] { Integer.valueOf(paramList.size()), paramString, Boolean.valueOf(paramBoolean) });
      yuk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "add feed list:%s", paramList);
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
      if (yuk.a()) {
        yuk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_Ylx);
      if (yuk.a()) {
        yuk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
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
 * Qualified Name:     yma
 * JD-Core Version:    0.7.0.1
 */