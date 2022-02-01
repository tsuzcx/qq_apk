import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

public class vbc
{
  public int a;
  public SparseIntArray a;
  public String a;
  public List<stSimpleMetaFeed> a;
  private vgb a;
  public String b;
  public List<stFeed> b;
  
  private vbc()
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
    if (vmg.a(paramList)) {
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
    vmp.b("WSVideoDataManager", "position map: " + this.jdField_a_of_type_AndroidUtilSparseIntArray.toString());
    return localArrayList;
  }
  
  public static vbc a()
  {
    return vbe.a();
  }
  
  private vfg a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong, vbf paramvbf)
  {
    return new vbd(this, paramBoolean1, paramBoolean2, paramLong, paramInt, paramvbf);
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, vbf paramvbf)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
    List localList = a(paramList);
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    if (paramvbf == null) {}
    do
    {
      return;
      if (paramInt == 9)
      {
        if (paramBoolean1)
        {
          paramvbf.a(false, this.jdField_b_of_type_JavaUtilList, paramBoolean2);
          return;
        }
        paramvbf.a(true, paramList, paramBoolean2);
        return;
      }
    } while (paramInt != 10);
    paramvbf.a(true, localList, paramBoolean2);
  }
  
  private void a(vfr paramvfr, long paramLong, int paramInt, boolean paramBoolean)
  {
    vmp.a("weishi-beacon", "请求关注流耗时：" + paramLong + "毫秒");
    switch (paramInt)
    {
    }
    for (String str = "focus";; str = "fullscreen_videoplay")
    {
      vkk.a().a(paramLong, paramvfr.a, str, paramBoolean);
      return;
    }
  }
  
  public vfs a(vdq paramvdq)
  {
    vfs localvfs = paramvdq.jdField_a_of_type_Vfs;
    Object localObject = localvfs;
    if (localvfs == null) {
      localObject = new vhy();
    }
    ((vhy)localObject).a(paramvdq);
    return localObject;
  }
  
  public vgb a()
  {
    return this.jdField_a_of_type_Vgb;
  }
  
  public vgb a(vdq paramvdq, long paramLong, int paramInt)
  {
    vgb localvgb2 = paramvdq.jdField_a_of_type_Vgb;
    vgb localvgb1 = localvgb2;
    if (localvgb2 == null) {
      localvgb1 = new vgb();
    }
    localvgb1.jdField_a_of_type_Vgi = paramvdq.jdField_a_of_type_Vgi;
    localvgb1.jdField_a_of_type_AndroidViewViewGroup = paramvdq.a();
    localvgb1.jdField_a_of_type_Vfs = paramvdq.jdField_a_of_type_Vfs;
    localvgb1.jdField_a_of_type_Int = 2;
    localvgb1.jdField_a_of_type_Long = paramLong;
    localvgb1.jdField_b_of_type_Boolean = false;
    localvgb1.jdField_b_of_type_Int = paramInt;
    localvgb1.jdField_a_of_type_JavaLangString = "follow_tab";
    return localvgb1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Vgb != null) {
      this.jdField_a_of_type_Vgb = null;
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
  
  public void a(vdq paramvdq)
  {
    paramvdq = paramvdq.jdField_a_of_type_Vgb;
    if ((paramvdq != null) && ((paramvdq.jdField_a_of_type_Boolean) || ((paramvdq.jdField_a_of_type_Vgh != null) && (paramvdq.jdField_a_of_type_Vgh.e() != 0)))) {
      paramvdq.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(vgb paramvgb)
  {
    this.jdField_a_of_type_Vgb = paramvgb;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong, vbf<T> paramvbf)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "")
    {
      paramString = new vfr(new vku(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramLong, paramvbf), 3001);
      vfk.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbc
 * JD-Core Version:    0.7.0.1
 */