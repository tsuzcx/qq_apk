import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class iju
  extends EffectConfigBase<FilterItem>
{
  static boolean RN;
  static boolean RO;
  FilterItem jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = null;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  
  public iju(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static boolean a(PendantItem paramPendantItem)
  {
    if (paramPendantItem == null) {
      return false;
    }
    boolean bool;
    if (AEFilterSupport.uP()) {
      if (!PendantItem.isOnlySupportOldFilter(paramPendantItem.getKind())) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectFilterTools", 2, String.format("isSupportFilter, ptu[%s], support[%s], kind[%s], id[%s]", new Object[] { Boolean.valueOf(AEFilterSupport.uP()), Boolean.valueOf(bool), Integer.valueOf(paramPendantItem.getKind()), paramPendantItem.getId() }));
      }
      return bool;
      bool = false;
      continue;
      if (!PendantItem.isOnlySupportNewFilter(paramPendantItem.getKind())) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static String getFileNameWithoutExtension(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf(File.separator);
      if (j != -1) {
        break;
      }
    } while (i == -1);
    return paramString.substring(0, i);
    if (i == -1) {
      return paramString.substring(j + 1);
    }
    if (j < i) {}
    for (paramString = paramString.substring(j + 1, i);; paramString = paramString.substring(j + 1)) {
      return paramString;
    }
  }
  
  public static boolean isSupport(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (RN) {
      bool1 = RN;
    }
    do
    {
      do
      {
        return bool1;
        if (!iow.va())
        {
          igd.aJ("EffectFilterTools", "isSupport Error: 1");
          return false;
        }
        bool1 = bool2;
      } while (!iow.k(4, 1400000L));
      if (paramContext == null) {
        break;
      }
      bool1 = bool2;
    } while (TextUtils.isEmpty(igl.b(132).content));
    paramContext = ioj.a();
    if ((paramContext != null) && (!paramContext.uC()))
    {
      igd.aJ("EffectFilterTools", "  isSupportFilter false");
      return false;
    }
    RN = true;
    return RN;
  }
  
  public static boolean tw()
  {
    if (RO) {
      return true;
    }
    if ((!iow.k(8, 1400000L)) && (!iow.k(4, 2150000L))) {
      return false;
    }
    ioj localioj = ioj.a();
    if ((localioj != null) && (!localioj.tw()))
    {
      igd.aJ("EffectFilterTools", "isSupportGesture false");
      return false;
    }
    RO = true;
    return RO;
  }
  
  public FilterDesc a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  }
  
  public Class<?> a()
  {
    return FilterItem.class;
  }
  
  public String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getResurl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = b(paramFilterItem);
      paramFilterItem = getFileNameWithoutExtension(paramFilterItem.getResurl());
      return str + paramFilterItem;
    }
    return null;
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramLong, null);
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getFilterName())))
    {
      b(paramLong, (FilterItem)a(paramPendantItem.getFilterName()));
      return;
    }
    b(paramLong, this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem);
  }
  
  protected void a(FilterItem paramFilterItem) {}
  
  public boolean a(long paramLong, FilterItem paramFilterItem)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = paramFilterItem;
    return b(paramLong, paramFilterItem);
  }
  
  boolean b(long paramLong, FilterItem paramFilterItem)
  {
    boolean bool = super.a(paramLong, paramFilterItem);
    iiv localiiv = VideoController.a().b();
    if (TextUtils.isEmpty(a(paramFilterItem)))
    {
      localiiv.b.clear(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    }
    for (;;)
    {
      if (paramFilterItem != null) {
        iju.a.b((FilterItem)a());
      }
      return bool;
      localiiv.b.set(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = new FilterDesc(Integer.valueOf(paramFilterItem.getFilterId()).intValue(), paramFilterItem.getPredownload(), paramFilterItem.getResurl(), paramFilterItem.getMd5(), paramFilterItem.getIconurl(), paramFilterItem.getIconMd5(), paramFilterItem.getId(), 0, b(paramFilterItem));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.type = paramFilterItem.getFiltertype();
    }
  }
  
  protected boolean cs(String paramString)
  {
    boolean bool2 = false;
    super.parse();
    boolean bool1 = bool2;
    int i;
    int j;
    if (this.mItemList != null)
    {
      paramString = this.mItemList.iterator();
      i = 0;
      j = 0;
      if (paramString.hasNext())
      {
        FilterItem localFilterItem = (FilterItem)paramString.next();
        long l = AudioHelper.hG();
        if (AudioHelper.aCz()) {
          QLog.w("EffectFilterTools", 1, "preDownloadResource, seq[" + l + "], res[" + localFilterItem.getResurl() + "], icon[" + localFilterItem.getIconurl() + "]");
        }
        if (localFilterItem.getPredownload() != 1) {
          break label189;
        }
        j += 1;
        if ((!TextUtils.isEmpty(localFilterItem.getResurl())) && (!localFilterItem.isUsable())) {
          a(l, localFilterItem);
        }
      }
    }
    label189:
    for (;;)
    {
      break;
      i += 1;
      continue;
      bool1 = bool2;
      if (i == j) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public int getConfigID()
  {
    return 132;
  }
  
  public List<FilterItem> y(String paramString)
  {
    paramString = super.y(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  public static class a
  {
    static boolean RP;
    static String TAG = "EffectFilterTools";
    static long lt;
    
    public static void a(FilterItem paramFilterItem, long paramLong)
    {
      paramFilterItem = paramFilterItem.getId();
      igd.aJ(TAG, "DataReport onStateReport:" + paramFilterItem + "|" + paramLong);
      HashMap localHashMap = new HashMap();
      localHashMap.put("filterName", paramFilterItem);
      localHashMap.put("duration", String.valueOf(paramLong));
      UserAction.onUserAction("actAVFunChatFilter", true, -1L, -1L, localHashMap, true);
      try
      {
        UserAction.flushObjectsToDB(true);
        return;
      }
      catch (Exception paramFilterItem)
      {
        igd.aL(TAG, paramFilterItem.getMessage());
      }
    }
    
    static void b(FilterItem paramFilterItem)
    {
      long l1 = System.currentTimeMillis();
      igd.aJ(TAG, "DataReport onUserdFilter:" + paramFilterItem + "|" + lt);
      if ((paramFilterItem != null) && (!paramFilterItem.isEmptyFilter()))
      {
        if (lt != 0L)
        {
          long l2 = l1 - lt;
          igd.aJ(TAG, "DataReport onUserdFilter:" + l2);
          if (l2 > 5000L)
          {
            RP = true;
            a(paramFilterItem, l2 / 1000L);
          }
        }
        igd.aJ(TAG, "DataReport onUserdFilter 33:" + lt);
      }
      lt = l1;
    }
    
    public static void c(VideoAppInterface paramVideoAppInterface)
    {
      if (paramVideoAppInterface.ch(1))
      {
        paramVideoAppInterface = (FilterItem)((iju)paramVideoAppInterface.a(1)).a();
        b(paramVideoAppInterface);
        igd.aJ(TAG, "DataReport onUserdFilter:" + paramVideoAppInterface + "|" + RP);
        if (!RP) {
          break label77;
        }
      }
      label77:
      for (paramVideoAppInterface = "0X80076B2";; paramVideoAppInterface = "0X80076B1")
      {
        iF(paramVideoAppInterface);
        return;
      }
    }
    
    public static void iF(String paramString)
    {
      anot.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
    
    public static void jdMethod_if(boolean paramBoolean)
    {
      igd.aJ(TAG, "DataReport onSupport:" + paramBoolean);
      if (paramBoolean) {}
      for (String str = "0X80076AF";; str = "0X80076B0")
      {
        iF(str);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iju
 * JD-Core Version:    0.7.0.1
 */