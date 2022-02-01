import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

public class unc
{
  public int a;
  public SparseIntArray a;
  public String a;
  public List<stSimpleMetaFeed> a;
  private urt a;
  public String b;
  public List<stFeed> b;
  
  private unc()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  private List<stSimpleMetaFeed> a(List<stFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (uxr.a(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      stFeed localstFeed = (stFeed)paramList.get(i);
      if ((localstFeed.feed_type == 2) && (localstFeed.feed != null))
      {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_b_of_type_JavaUtilList.size() + i, this.jdField_a_of_type_JavaUtilList.size() + localArrayList.size());
        localArrayList.add(localstFeed.feed);
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    uya.b("WSVideoDataManager", "position map: " + this.jdField_a_of_type_AndroidUtilSparseIntArray.toString());
    return localArrayList;
  }
  
  public static unc a()
  {
    return une.a();
  }
  
  private uqy a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong, unf paramunf)
  {
    return new und(this, paramBoolean1, paramBoolean2, paramLong, paramInt, paramunf);
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, unf paramunf)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
    List localList = a(paramList);
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    if (paramunf == null) {}
    do
    {
      return;
      if (paramInt == 9)
      {
        if (paramBoolean1)
        {
          paramunf.a(false, this.jdField_b_of_type_JavaUtilList, paramBoolean2);
          return;
        }
        paramunf.a(true, paramList, paramBoolean2);
        return;
      }
    } while (paramInt != 10);
    paramunf.a(true, localList, paramBoolean2);
  }
  
  private void a(urj paramurj, long paramLong, int paramInt, boolean paramBoolean)
  {
    uya.a("weishi-beacon", "请求关注流耗时：" + paramLong + "毫秒");
    switch (paramInt)
    {
    }
    for (String str = "focus";; str = "fullscreen_videoplay")
    {
      uvw.a().a(paramLong, paramurj.a, str, paramBoolean);
      return;
    }
  }
  
  public urk a(upp paramupp)
  {
    urk localurk = paramupp.jdField_a_of_type_Urk;
    Object localObject = localurk;
    if (localurk == null) {
      localObject = new utn();
    }
    ((utn)localObject).a(paramupp);
    return localObject;
  }
  
  public urt a()
  {
    return this.jdField_a_of_type_Urt;
  }
  
  public urt a(upp paramupp, long paramLong, int paramInt)
  {
    urt localurt2 = paramupp.jdField_a_of_type_Urt;
    urt localurt1 = localurt2;
    if (localurt2 == null) {
      localurt1 = new urt();
    }
    localurt1.jdField_a_of_type_Urx = paramupp.jdField_a_of_type_Urx;
    localurt1.jdField_a_of_type_AndroidViewViewGroup = paramupp.a();
    localurt1.jdField_a_of_type_Urk = paramupp.jdField_a_of_type_Urk;
    localurt1.jdField_a_of_type_Int = 2;
    localurt1.jdField_a_of_type_Long = paramLong;
    localurt1.jdField_b_of_type_Boolean = false;
    localurt1.jdField_b_of_type_Int = paramInt;
    localurt1.jdField_a_of_type_JavaLangString = "follow_tab";
    return localurt1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Urt != null) {
      this.jdField_a_of_type_Urt = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
  }
  
  public void a(List<stFeed> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = 15;
    a(paramList);
  }
  
  public void a(upp paramupp)
  {
    paramupp = paramupp.jdField_a_of_type_Urt;
    if ((paramupp != null) && ((paramupp.jdField_a_of_type_Boolean) || ((paramupp.jdField_a_of_type_Urw != null) && (paramupp.jdField_a_of_type_Urw.e() != 0)))) {
      paramupp.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(urt paramurt)
  {
    this.jdField_a_of_type_Urt = paramurt;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong, unf<T> paramunf)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "")
    {
      paramString = new urj(new uwg(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramLong, paramunf), 3001);
      urc.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unc
 * JD-Core Version:    0.7.0.1
 */