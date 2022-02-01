import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

public class ugj
{
  public int a;
  public SparseIntArray a;
  public String a;
  public List<stSimpleMetaFeed> a;
  private ukb a;
  public String b;
  public List<stFeed> b;
  
  private ugj()
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
    if (uov.a(paramList)) {
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
    upe.b("WSVideoDataManager", "position map: " + this.jdField_a_of_type_AndroidUtilSparseIntArray.toString());
    return localArrayList;
  }
  
  public static ugj a()
  {
    return ugl.a();
  }
  
  private ujj a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, ugm paramugm)
  {
    return new ugk(this, paramBoolean1, paramBoolean2, paramugm, paramInt);
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, ugm paramugm)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
    List localList = a(paramList);
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    if (paramugm == null) {}
    do
    {
      return;
      if (paramInt == 9)
      {
        if (paramBoolean1)
        {
          paramugm.a(false, this.jdField_b_of_type_JavaUtilList, paramBoolean2);
          return;
        }
        paramugm.a(true, paramList, paramBoolean2);
        return;
      }
    } while (paramInt != 10);
    paramugm.a(true, localList, paramBoolean2);
  }
  
  public ujv a(uif paramuif)
  {
    ujv localujv = paramuif.jdField_a_of_type_Ujv;
    Object localObject = localujv;
    if (localujv == null) {
      localObject = new ukv();
    }
    ((ukv)localObject).a(paramuif);
    return localObject;
  }
  
  public ukb a()
  {
    return this.jdField_a_of_type_Ukb;
  }
  
  public ukb a(uif paramuif, long paramLong, int paramInt)
  {
    ukb localukb2 = paramuif.jdField_a_of_type_Ukb;
    ukb localukb1 = localukb2;
    if (localukb2 == null) {
      localukb1 = new ukb();
    }
    localukb1.jdField_a_of_type_Ukf = paramuif.jdField_a_of_type_Ukf;
    localukb1.jdField_a_of_type_AndroidViewViewGroup = paramuif.a();
    localukb1.jdField_a_of_type_Ujv = paramuif.jdField_a_of_type_Ujv;
    localukb1.jdField_a_of_type_Int = 2;
    localukb1.jdField_a_of_type_Long = paramLong;
    localukb1.jdField_b_of_type_Boolean = false;
    localukb1.jdField_b_of_type_Int = paramInt;
    localukb1.jdField_a_of_type_JavaLangString = "follow_tab";
    return localukb1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Ukb != null) {
      this.jdField_a_of_type_Ukb = null;
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
  
  public void a(uif paramuif)
  {
    paramuif = paramuif.jdField_a_of_type_Ukb;
    if ((paramuif != null) && ((paramuif.jdField_a_of_type_Boolean) || ((paramuif.jdField_a_of_type_Uke != null) && (paramuif.jdField_a_of_type_Uke.e() != 0)))) {
      paramuif.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(ukb paramukb)
  {
    this.jdField_a_of_type_Ukb = paramukb;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, ugm<T> paramugm)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "")
    {
      paramString = new uju(new unl(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramugm), 3001);
      ujn.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugj
 * JD-Core Version:    0.7.0.1
 */