import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class anlp
  implements anlv
{
  private static Map<String, anlo> nf = new HashMap();
  private static HashMap<String, String> ns = new HashMap();
  private static HashMap<String, String> nt = new HashMap();
  private long VF;
  private anlz jdField_a_of_type_Anlz;
  private LoadParam.LoadItem jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem;
  private LoadParam jdField_a_of_type_ComTencentMobileqqSoloadLoadParam;
  private boolean cIp;
  private boolean cIq = true;
  private boolean cIr;
  private String ceG = "";
  private String ceH;
  private int dJY;
  
  private int a(@NonNull SoLoadInfo paramSoLoadInfo)
  {
    this.ceG = paramSoLoadInfo.curLoadVer;
    int j = paramSoLoadInfo.curCode;
    int i;
    if (j == 0) {
      i = a(paramSoLoadInfo.pathToLoad, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, paramSoLoadInfo.configSoUrl);
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (j != 2);
      i = j;
    } while (!a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem));
    return 0;
  }
  
  private int a(String paramString, LoadParam.LoadItem paramLoadItem)
  {
    int i = 0;
    if (!new File(paramString).exists()) {
      i = 5;
    }
    while (paramLoadItem.lops.isDownloadOnly) {
      return i;
    }
    try
    {
      System.load(paramString);
      ns.put(paramLoadItem.name, this.ceG);
      nt.put(paramLoadItem.name, paramString);
      return 0;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.DownSoLoader", 1, paramString, new Object[0]);
      this.ceH = aagd.c(paramString);
    }
    return 6;
  }
  
  private int a(String paramString1, LoadParam.LoadItem paramLoadItem, String paramString2)
  {
    int i = a(paramString1, paramLoadItem);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + i + ",filePath=" + paramString1);
    }
    if (i == 0)
    {
      anma.a(paramLoadItem, paramString1);
      anma.a(paramLoadItem, this.ceG, paramString1, paramString2);
    }
    while (!b(paramLoadItem)) {
      return i;
    }
    return 0;
  }
  
  private LoadExtResult a(int paramInt)
  {
    String str = null;
    if (paramInt == 6) {
      str = this.ceH;
    }
    return a(paramInt, str);
  }
  
  private LoadExtResult a(int paramInt, SoLoadInfo paramSoLoadInfo)
  {
    this.dJY = paramSoLoadInfo.subErrCode;
    this.cIp = paramSoLoadInfo.isFinishDownload;
    return a(paramInt);
  }
  
  private LoadExtResult a(int paramInt, String paramString)
  {
    int i = 1;
    this.cIr = true;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.VF;
    VACDReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, "ver=" + this.ceG, "load.item.load", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, paramInt, paramString);
    LoadExtResult localLoadExtResult = LoadExtResult.create(paramInt, 1, this.cIp, this.cIq, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, (String)nt.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name));
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC))
    {
      anlo localanlo = (anlo)nf.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      paramString = localanlo;
      if (localanlo == null) {
        paramString = new anlo();
      }
      boolean bool = aqiw.isNetSupport(BaseApplicationImpl.getApplication());
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      int j = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[onLoadResult]AsyncFailInfo:" + paramString + ",name:" + this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name + ",isNetSupport:" + bool + ",curTime=" + l3 + ",netType=" + j);
      }
      if (bool)
      {
        paramString.dJZ = paramInt;
        paramString.netType = j;
        paramString.amf = l3;
        paramString.dKa = this.dJY;
        nf.put(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, paramString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType == LoadParam.CALL_TYPE_SYNC) {
      localLoadExtResult.failInfo = ((anlo)nf.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name));
    }
    if (this.jdField_a_of_type_Anlz != null) {
      this.jdField_a_of_type_Anlz.a(paramInt, localLoadExtResult);
    }
    if (this.cIp) {}
    for (;;)
    {
      anot.a(null, "dc00899", "SoLoad", "", "resSingle", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType, paramInt, this.ceG, i + "", l1 - l2 + "", "");
      return localLoadExtResult;
      if (this.cIq) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  private boolean a(LoadParam.LoadItem paramLoadItem)
  {
    String str = paramLoadItem.lops.getOldSoPath();
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      int i = a(str, paramLoadItem);
      VACDReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.load.oldpath", null, i, null);
      return i == 0;
    }
    return false;
  }
  
  private boolean ayr()
  {
    boolean bool = false;
    if (ns.containsKey(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name))
    {
      this.cIq = false;
      this.ceG = ((String)ns.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name));
      bool = true;
    }
    return bool;
  }
  
  private void b(LoadParam paramLoadParam, anlz paramanlz)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam = paramLoadParam;
    this.jdField_a_of_type_Anlz = paramanlz;
    this.VF = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem = ((LoadParam.LoadItem)paramLoadParam.mLoadItems.get(0));
    VACDReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.start", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, 0, null);
  }
  
  private boolean b(LoadParam.LoadItem paramLoadItem)
  {
    if (paramLoadItem.lops.isLoadLastSuccWhenFail)
    {
      String str = anma.b(paramLoadItem);
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramLoadItem);
        VACDReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.load.last", null, i, null);
        return i == 0;
      }
    }
    return false;
  }
  
  @Deprecated
  public static List<String> gn()
  {
    return new LinkedList(ns.keySet());
  }
  
  public static String nw(String paramString)
  {
    return (String)ns.get(paramString);
  }
  
  public void QI(String paramString)
  {
    if ((!this.cIr) && (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType != LoadParam.CALL_TYPE_SYNC))
    {
      a(8, paramString);
      return;
    }
    VACDReportUtil.a("ver=" + this.ceG, "SoLoadModule", "SoLoadSingle", "Exception", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, 2, paramString);
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    b(paramLoadParam, null);
    if (ayr()) {
      return a(0);
    }
    paramLoadParam = new anlu(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem).a();
    return a(a(paramLoadParam), paramLoadParam);
  }
  
  public void a(LoadParam paramLoadParam, anlz paramanlz)
  {
    b(paramLoadParam, paramanlz);
    if (ayr())
    {
      a(0);
      return;
    }
    new anlr(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem).a(new anlq(this));
  }
  
  public boolean pr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name;
      str2 = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.soFileName;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (!paramString.contains(str2)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlp
 * JD-Core Version:    0.7.0.1
 */