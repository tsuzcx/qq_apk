import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class txn
  implements bdvw
{
  private bdvu jdField_a_of_type_Bdvu;
  bdzm jdField_a_of_type_Bdzm = new txo(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<bdzn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<bdvs> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<bdzn> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public txn(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_Bdvu = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bdvs localbdvs = (bdvs)localIterator.next();
      if (localbdvs.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localbdvs);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Bdvu != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bdvs)((Iterator)localObject1).next();
        this.jdField_a_of_type_Bdvu.b((bdws)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      bdzn localbdzn;
      while (((Iterator)localObject2).hasNext())
      {
        localbdzn = (bdzn)((Iterator)localObject2).next();
        ((bdzi)localObject1).a(localbdzn.jdField_c_of_type_JavaLangString, localbdzn.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localbdzn = (bdzn)((Iterator)localObject2).next();
        ((bdzi)localObject1).b(localbdzn.jdField_c_of_type_JavaLangString, localbdzn.jdField_a_of_type_Long);
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
      bdzn localbdzn = (bdzn)localIterator.next();
      if (localbdzn.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbdzn);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (nlw.a() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    bdzi localbdzi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Bdzm.addFilter(new Class[] { bdsp.class });
    localbdzi.a(this.jdField_a_of_type_Bdzm);
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.jdField_c_of_type_Int = 10;
    localbdzn.i = str;
    localbdzn.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localbdzn.jdField_c_of_type_JavaLangString = "0";
    localbdzn.jdField_b_of_type_Int = 24;
    localbdzn.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localbdzi.a(localbdzn);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localbdzn.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localbdzn.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbdzn);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bdzn localbdzn = (bdzn)localIterator.next();
      if (localbdzn.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbdzn);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (nlw.a() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      bdvs localbdvs = new bdvs();
      localbdvs.jdField_a_of_type_Bdvw = this;
      localbdvs.jdField_a_of_type_JavaLangString = str;
      localbdvs.jdField_c_of_type_Long = 180000L;
      if (localbdvs.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localbdvs.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localbdvs.jdField_c_of_type_JavaLangString = (anhk.ba + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(anhk.ba + "c2bPIC/");
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
      if (this.jdField_a_of_type_Bdvu == null) {
        break;
      }
      this.jdField_a_of_type_Bdvu.a(localbdvs);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localbdvs);
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
    this.jdField_a_of_type_Bdzm.addFilter(new Class[] { bdwb.class });
    ((bdzi)localObject).a(this.jdField_a_of_type_Bdzm);
    localObject = new bdzn();
    ((bdzn)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((bdzn)localObject).jdField_c_of_type_JavaLangString = "255";
    ((bdzn)localObject).jdField_a_of_type_Int = 9999;
    ((bdzn)localObject).jdField_b_of_type_Int = 32;
    ((bdzn)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((bdzn)localObject).jdField_a_of_type_Boolean = true;
    ((bdzn)localObject).i = str;
    ((bdzn)localObject).jdField_e_of_type_Int = 102;
    ((bdzn)localObject).l = true;
    ((bdzn)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bdzn)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((bdzn)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((bdzn)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Bdzm.addFilter(new Class[] { bdwa.class });
    ((bdzi)localObject).a(this.jdField_a_of_type_Bdzm);
    localObject = new bdzn();
    ((bdzn)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((bdzn)localObject).jdField_c_of_type_JavaLangString = "255";
    ((bdzn)localObject).jdField_a_of_type_Int = 9999;
    ((bdzn)localObject).jdField_b_of_type_Int = 32;
    ((bdzn)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((bdzn)localObject).jdField_a_of_type_Boolean = false;
    ((bdzn)localObject).jdField_e_of_type_JavaLangString = str;
    ((bdzn)localObject).h = (anhk.ba + "c2bPTT/" + str + ".amr");
    if (new File(((bdzn)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new tyj().a(((bdzn)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((bdzn)localObject).jdField_b_of_type_Boolean = true;
    ((bdzn)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bdzn)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((bdzn)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((bdzn)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(bdwt parambdwt)
  {
    Object localObject;
    Bundle localBundle;
    if ((parambdwt != null) && ((parambdwt.jdField_a_of_type_Bdws instanceof bdvs)))
    {
      localObject = (bdvs)parambdwt.jdField_a_of_type_Bdws;
      if ((parambdwt.jdField_a_of_type_Int == 0) || (parambdwt.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((bdvs)localObject).jdField_a_of_type_JavaLangString);
        a(((bdvs)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((bdvs)localObject).jdField_a_of_type_JavaLangString == null) || (parambdwt.jdField_a_of_type_Int != 0)) {
            break label293;
          }
          parambdwt = ((bdvs)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (parambdwt.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", parambdwt[(parambdwt.length - 2)]);
          localObject = ((bdvs)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          parambdwt = new File((String)localObject);
          if (!parambdwt.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = bgmg.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (parambdwt.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception parambdwt)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txn
 * JD-Core Version:    0.7.0.1
 */