import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

public class ugl
{
  public int a;
  public SparseIntArray a;
  public String a;
  public List<stSimpleMetaFeed> a;
  private ukz a;
  public String b;
  public List<stFeed> b;
  
  private ugl()
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
    if (upw.a(paramList)) {
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
    uqf.b("WSVideoDataManager", "position map: " + this.jdField_a_of_type_AndroidUtilSparseIntArray.toString());
    return localArrayList;
  }
  
  public static ugl a()
  {
    return ugn.a();
  }
  
  private ukd a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, ugo paramugo)
  {
    return new ugm(this, paramBoolean1, paramBoolean2, paramugo, paramInt);
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, ugo paramugo)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
    List localList = a(paramList);
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    if (paramugo == null) {}
    do
    {
      return;
      if (paramInt == 9)
      {
        if (paramBoolean1)
        {
          paramugo.a(false, this.jdField_b_of_type_JavaUtilList, paramBoolean2);
          return;
        }
        paramugo.a(true, paramList, paramBoolean2);
        return;
      }
    } while (paramInt != 10);
    paramugo.a(true, localList, paramBoolean2);
  }
  
  public ukp a(uiu paramuiu)
  {
    ukp localukp = paramuiu.jdField_a_of_type_Ukp;
    Object localObject = localukp;
    if (localukp == null) {
      localObject = new ult();
    }
    ((ult)localObject).a(paramuiu);
    return localObject;
  }
  
  public ukz a()
  {
    return this.jdField_a_of_type_Ukz;
  }
  
  public ukz a(uiu paramuiu, long paramLong, int paramInt)
  {
    ukz localukz2 = paramuiu.jdField_a_of_type_Ukz;
    ukz localukz1 = localukz2;
    if (localukz2 == null) {
      localukz1 = new ukz();
    }
    localukz1.jdField_a_of_type_Uld = paramuiu.jdField_a_of_type_Uld;
    localukz1.jdField_a_of_type_AndroidViewViewGroup = paramuiu.a();
    localukz1.jdField_a_of_type_Ukp = paramuiu.jdField_a_of_type_Ukp;
    localukz1.jdField_a_of_type_Int = 2;
    localukz1.jdField_a_of_type_Long = paramLong;
    localukz1.jdField_b_of_type_Boolean = false;
    localukz1.jdField_b_of_type_Int = paramInt;
    localukz1.jdField_a_of_type_JavaLangString = "follow_tab";
    return localukz1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz = null;
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
  
  public void a(uiu paramuiu)
  {
    paramuiu = paramuiu.jdField_a_of_type_Ukz;
    if ((paramuiu != null) && ((paramuiu.jdField_a_of_type_Boolean) || ((paramuiu.jdField_a_of_type_Ulc != null) && (paramuiu.jdField_a_of_type_Ulc.e() != 0)))) {
      paramuiu.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(ukz paramukz)
  {
    this.jdField_a_of_type_Ukz = paramukz;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, ugo<T> paramugo)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "")
    {
      paramString = new uko(new uom(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramugo), 3001);
      ukh.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugl
 * JD-Core Version:    0.7.0.1
 */