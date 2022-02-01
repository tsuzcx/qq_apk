import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class txp
  implements beuq
{
  private beuo jdField_a_of_type_Beuo;
  beyf jdField_a_of_type_Beyf = new txq(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<beyg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<beum> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<beyg> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public txp(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_Beuo = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      beum localbeum = (beum)localIterator.next();
      if (localbeum.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localbeum);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Beuo != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (beum)((Iterator)localObject1).next();
        this.jdField_a_of_type_Beuo.b((bevl)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      beyg localbeyg;
      while (((Iterator)localObject2).hasNext())
      {
        localbeyg = (beyg)((Iterator)localObject2).next();
        ((beyb)localObject1).a(localbeyg.jdField_c_of_type_JavaLangString, localbeyg.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localbeyg = (beyg)((Iterator)localObject2).next();
        ((beyb)localObject1).b(localbeyg.jdField_c_of_type_JavaLangString, localbeyg.jdField_a_of_type_Long);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  void a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      beyg localbeyg = (beyg)localIterator.next();
      if (localbeyg.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbeyg);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (nnr.a() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    beyb localbeyb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Beyf.addFilter(new Class[] { berh.class });
    localbeyb.a(this.jdField_a_of_type_Beyf);
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.jdField_c_of_type_Int = 10;
    localbeyg.i = str;
    localbeyg.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localbeyg.jdField_c_of_type_JavaLangString = "0";
    localbeyg.jdField_b_of_type_Int = 24;
    localbeyg.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localbeyb.a(localbeyg);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localbeyg.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localbeyg.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbeyg);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      beyg localbeyg = (beyg)localIterator.next();
      if (localbeyg.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbeyg);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (nnr.a() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = this;
      localbeum.jdField_a_of_type_JavaLangString = str;
      localbeum.jdField_c_of_type_Long = 180000L;
      if (localbeum.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localbeum.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localbeum.jdField_c_of_type_JavaLangString = (antf.ba + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(antf.ba + "c2bPIC/");
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((File)localObject2).listFiles();
      if (localObject2 != null)
      {
        int i = 0;
        int j;
        while (i < localObject2.length)
        {
          if (!localObject2[i].isDirectory())
          {
            j = localObject2[i].getName().lastIndexOf(".");
            if (j != -1) {
              localArrayList.add(localObject2[i].getName().substring(0, j));
            }
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          j = k;
          if (i < localArrayList.size())
          {
            if (((String)localObject1).equalsIgnoreCase((String)localArrayList.get(i))) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            paramBundle.putString("pic_local_id", (String)localObject1);
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
            return;
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_Beuo == null) {
        break;
      }
      this.jdField_a_of_type_Beuo.a(localbeum);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localbeum);
    } while (paramBundle.getInt("is_showProgress_tips") != 1);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramBundle);
    return;
    paramBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_local_path");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Beyf.addFilter(new Class[] { beuu.class });
    ((beyb)localObject).a(this.jdField_a_of_type_Beyf);
    localObject = new beyg();
    ((beyg)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((beyg)localObject).jdField_c_of_type_JavaLangString = "255";
    ((beyg)localObject).jdField_a_of_type_Int = 9999;
    ((beyg)localObject).jdField_b_of_type_Int = 32;
    ((beyg)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((beyg)localObject).jdField_a_of_type_Boolean = true;
    ((beyg)localObject).i = str;
    ((beyg)localObject).jdField_e_of_type_Int = 102;
    ((beyg)localObject).m = true;
    ((beyg)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((beyg)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((beyg)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((beyg)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Beyf.addFilter(new Class[] { beut.class });
    ((beyb)localObject).a(this.jdField_a_of_type_Beyf);
    localObject = new beyg();
    ((beyg)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((beyg)localObject).jdField_c_of_type_JavaLangString = "255";
    ((beyg)localObject).jdField_a_of_type_Int = 9999;
    ((beyg)localObject).jdField_b_of_type_Int = 32;
    ((beyg)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((beyg)localObject).jdField_a_of_type_Boolean = false;
    ((beyg)localObject).jdField_e_of_type_JavaLangString = str;
    ((beyg)localObject).h = (antf.ba + "c2bPTT/" + str + ".amr");
    if (new File(((beyg)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new tyl().a(((beyg)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((beyg)localObject).jdField_c_of_type_Boolean = true;
    ((beyg)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((beyg)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((beyg)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((beyg)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(bevm parambevm)
  {
    Object localObject;
    Bundle localBundle;
    if ((parambevm != null) && ((parambevm.jdField_a_of_type_Bevl instanceof beum)))
    {
      localObject = (beum)parambevm.jdField_a_of_type_Bevl;
      if ((parambevm.jdField_a_of_type_Int == 0) || (parambevm.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((beum)localObject).jdField_a_of_type_JavaLangString);
        a(((beum)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((beum)localObject).jdField_a_of_type_JavaLangString == null) || (parambevm.jdField_a_of_type_Int != 0)) {
            break label293;
          }
          parambevm = ((beum)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (parambevm.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", parambevm[(parambevm.length - 2)]);
          localObject = ((beum)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          parambevm = new File((String)localObject);
          if (!parambevm.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = bhmi.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (parambevm.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception parambevm)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txp
 * JD-Core Version:    0.7.0.1
 */