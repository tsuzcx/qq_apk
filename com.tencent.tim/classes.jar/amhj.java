import PersonalState.UserProfile;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import protocol.KQQConfig.GetResourceReqInfo;

public class amhj
  implements amfa.b, Manager
{
  private static Object[] jdField_e_of_type_ArrayOfJavaLangObject = new Object[2];
  private static volatile WeakReference<amhj> hK;
  private HashMap<Long, UserProfile> R;
  private LinkedList<amff> X;
  private accz jdField_a_of_type_Accz;
  private amho jdField_a_of_type_Amho;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private long aiF;
  private long aiG;
  private byte[] at;
  private aclv jdField_b_of_type_Aclv;
  private amfa jdField_b_of_type_Amfa;
  private AsyncTask<Void, Void, ArrayList<UserProfile>> jdField_b_of_type_AndroidOsAsyncTask;
  private ArrayList<amhg> bh = new ArrayList();
  private ArrayList<UserProfile> bi;
  private ArrayList<UserProfile> bj;
  private long cJ;
  private volatile AsyncTask<Void, Integer, Integer> jdField_e_of_type_AndroidOsAsyncTask;
  private HashSet<String> jdField_j_of_type_JavaUtilHashSet;
  private LinkedList<amfh> jdField_j_of_type_JavaUtilLinkedList;
  private LinkedList<amfi> l;
  private LinkedList<amfk> m;
  private long mUpdateTime;
  private LinkedList<amfj> n;
  private volatile SparseArray<amev> jdField_q_of_type_AndroidUtilSparseArray = new SparseArray();
  private QQAppInterface jdField_q_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private amhj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_j_of_type_JavaUtilHashSet = new HashSet();
    this.mUpdateTime = y().getLong("k_update_time", 0L);
  }
  
  private int D(boolean paramBoolean)
  {
    int i = 101;
    if (this.jdField_q_of_type_AndroidUtilSparseArray.size() == 0) {
      i = 102;
    }
    long l1;
    do
    {
      return i;
      l1 = System.currentTimeMillis();
      if (Math.abs(this.mUpdateTime - l1) <= 43200000L) {
        break;
      }
    } while (!paramBoolean);
    if (Math.abs(this.aiG - l1) > 300000L)
    {
      this.aiG = l1;
      return 101;
    }
    return 100;
  }
  
  private int IH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local");
    }
    if (this.jdField_e_of_type_AndroidOsAsyncTask != null) {
      return 100;
    }
    this.jdField_e_of_type_AndroidOsAsyncTask = new amhk(this).execute(new Void[0]);
    return 100;
  }
  
  private int II()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Remote:" + l1 + ", " + this.aiF + ", " + "rich_status_android");
    }
    if (Math.abs(l1 - this.aiF) > 240000L)
    {
      accy localaccy = (accy)this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(4);
      if (this.jdField_a_of_type_Accz == null) {
        dNs();
      }
      localaccy.a(null, new GetResourceReqInfo[] { localaccy.d() });
      this.aiF = l1;
    }
    return 100;
  }
  
  public static amhj a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != paramQQAppInterface) {
      return (amhj)((QQAppInterface)localObject).getManager(15);
    }
    if (hK != null) {}
    for (localObject = (amhj)hK.get();; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = new amhj(paramQQAppInterface);
        hK = new WeakReference(paramQQAppInterface);
        return paramQQAppInterface;
      }
      ((amhj)localObject).jdField_j_of_type_JavaUtilHashSet.clear();
      ((amhj)localObject).aiF = 0L;
      ((amhj)localObject).cJ = 0L;
      ((amhj)localObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
      if (((amhj)localObject).jdField_a_of_type_Accz != null)
      {
        ((amhj)localObject).jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(((amhj)localObject).jdField_a_of_type_Accz);
        ((amhj)localObject).jdField_a_of_type_Accz = null;
      }
      if (((amhj)localObject).jdField_a_of_type_Amho != null)
      {
        ((amhj)localObject).jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(((amhj)localObject).jdField_a_of_type_Amho);
        ((amhj)localObject).jdField_a_of_type_Amho = null;
      }
      if (((amhj)localObject).jdField_b_of_type_Amfa != null) {
        ((amhj)localObject).jdField_b_of_type_Amfa.reset();
      }
      if (((amhj)localObject).jdField_b_of_type_Aclv != null)
      {
        ((amhj)localObject).jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(((amhj)localObject).jdField_b_of_type_Aclv);
        ((amhj)localObject).jdField_b_of_type_Aclv = null;
      }
      ((amhj)localObject).jdField_q_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      return localObject;
    }
  }
  
  private boolean a(SparseArray<amev> paramSparseArray1, SparseArray<amev> paramSparseArray2)
  {
    int i = 0;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons(" + paramSparseArray1 + ", " + paramSparseArray2 + ")");
    }
    File localFile = amfa.H();
    boolean bool1;
    if (localFile == null)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir is null");
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (!localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir does not exist!");
            }
            return true;
          }
          if (localFile.canWrite()) {
            break;
          }
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir can not write!");
        return false;
        if (paramSparseArray1 != null) {
          break;
        }
        paramSparseArray1 = localFile.listFiles();
        k = paramSparseArray1.length;
        if (i < k)
        {
          paramSparseArray2 = paramSparseArray1[i];
          if (paramSparseArray2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
          }
        }
        bool2 = localFile.canWrite();
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
      return bool2;
      ArrayList localArrayList = new ArrayList();
      int k = paramSparseArray2.size();
      i = 0;
      while (i < k)
      {
        amev localamev1 = (amev)paramSparseArray2.valueAt(i);
        amev localamev2 = (amev)paramSparseArray1.get(localamev1.id);
        if ((localamev2 != null) && (localamev2.bigIcon != null) && (!localamev2.bigIcon.equalsIgnoreCase(localamev1.bigIcon))) {
          localArrayList.add(localamev2.id + "_s_" + 201);
        }
        if ((localamev2 != null) && (localamev2.bZO != null) && (!localamev2.bZO.equalsIgnoreCase(localamev1.bZO))) {
          localArrayList.add(localamev2.id + "_s_" + 200);
        }
        i += 1;
      }
      paramSparseArray1 = localArrayList.iterator();
      while (paramSparseArray1.hasNext())
      {
        paramSparseArray2 = new File(localFile, (String)paramSparseArray1.next());
        if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
      }
      bool2 = localFile.canWrite();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
    return bool2;
  }
  
  private Object[] a(InputStream paramInputStream)
  {
    int k = -1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "parseXmlFile(" + paramInputStream + ")");
    }
    Object[] arrayOfObject = new Object[2];
    if (paramInputStream == null) {
      return arrayOfObject;
    }
    Object localObject2 = new amhp();
    for (;;)
    {
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, (DefaultHandler)localObject2);
        SparseArray localSparseArray = ((amhp)localObject2).i();
        localObject2 = ((amhp)localObject2).dz();
        if (localSparseArray.size() > 1) {
          arrayOfObject[0] = localSparseArray;
        }
        if (((ArrayList)localObject2).size() > 0) {
          arrayOfObject[1] = localObject2;
        }
      }
      catch (ParserConfigurationException localParserConfigurationException)
      {
        localParserConfigurationException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (SAXException localSAXException)
      {
        localSAXException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw localObject1;
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
          continue;
        }
        int i = -1;
        continue;
      }
      try
      {
        paramInputStream.close();
        if (QLog.isColorLevel())
        {
          paramInputStream = new StringBuilder().append("parseXmlFile return, action num: ");
          if (arrayOfObject[0] != null)
          {
            i = ((SparseArray)arrayOfObject[0]).size();
            paramInputStream = paramInputStream.append(i).append(" tag num: ");
            i = k;
            if (arrayOfObject[1] != null) {
              i = ((ArrayList)arrayOfObject[1]).size();
            }
            QLog.d("Q.richstatus.xml", 2, i);
          }
        }
        else
        {
          return arrayOfObject;
        }
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  private boolean avN()
  {
    int i = D(true);
    if (i != 100)
    {
      ja(i);
      return true;
    }
    return false;
  }
  
  private void ax(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    c().edit().putBoolean("k_sync_ss", paramBoolean).putLong("k_ss_time", l1).commit();
  }
  
  private SharedPreferences c()
  {
    return this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("rich_status" + this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  private void dNs()
  {
    this.jdField_a_of_type_Accz = new amhl(this);
    this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Accz);
  }
  
  private void dNt()
  {
    this.jdField_a_of_type_Amho = new amhm(this);
    this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Amho);
  }
  
  private void dNu()
  {
    this.jdField_b_of_type_Aclv = new amhn(this);
    this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Aclv);
  }
  
  private SharedPreferences y()
  {
    return this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("rich_status", 0);
  }
  
  public int E(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "setSyncShuoShuo " + paramBoolean);
    }
    if (this.jdField_a_of_type_Amho == null) {
      dNt();
    }
    StatusServlet.Q(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    return 100;
  }
  
  public void PD(String paramString)
  {
    this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "sp_hot_status", paramString).commit();
  }
  
  protected void Ph(boolean paramBoolean)
  {
    if (((this.jdField_j_of_type_JavaUtilLinkedList == null) || (this.jdField_j_of_type_JavaUtilLinkedList.size() == 0)) && ((this.l == null) || (this.l.size() == 0)))
    {
      this.jdField_j_of_type_JavaUtilHashSet.clear();
      return;
    }
    Iterator localIterator = this.jdField_j_of_type_JavaUtilHashSet.iterator();
    label50:
    String str;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localObject1 = str.split("_");
        localObject2 = (amev)this.jdField_q_of_type_AndroidUtilSparseArray.get(Integer.parseInt(localObject1[0]));
        if (localObject2 != null) {
          if (localObject1.length == 3) {
            if (Integer.parseInt(localObject1[2]) == 201) {
              localObject1 = ((amev)localObject2).bigIcon;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_b_of_type_Amfa.a(str, null, (String)localObject1);
        if (localObject2 == null) {
          break label50;
        }
        a(str, (String)localObject1, (Bitmap)localObject2, 1);
        break label50;
        localObject1 = ((amev)localObject2).bZO;
        continue;
        if ((localObject1.length != 2) || (TextUtils.isEmpty(((amev)localObject2).bZQ))) {
          break label226;
        }
        localObject1 = ((amev)localObject2).bZQ.replace("$U", localObject1[1]);
        continue;
      }
      localIterator.remove();
      break label50;
      if (!paramBoolean) {
        break;
      }
      this.jdField_j_of_type_JavaUtilHashSet.clear();
      return;
      label226:
      localObject1 = null;
    }
  }
  
  public int a(RichStatus paramRichStatus, int paramInt)
  {
    if (paramRichStatus == null) {}
    for (;;)
    {
      return 100;
      if (QLog.isColorLevel()) {
        QLog.i("Q.richstatus.set", 2, String.format("changeStatus %d,%d [%s]", new Object[] { Integer.valueOf(paramRichStatus.actionId), Integer.valueOf(paramInt), paramRichStatus.toSpannableString(null) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
      if (paramRichStatus.isEmpty()) {
        if (this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramRichStatus = new NewIntent(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), StatusServlet.class);
          paramRichStatus.putExtra("k_cmd", 8);
          this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramRichStatus);
        }
      }
      while (this.jdField_a_of_type_Amho == null)
      {
        dNt();
        return 100;
        byte[] arrayOfByte = paramRichStatus.encode();
        NewIntent localNewIntent = new NewIntent(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), StatusServlet.class);
        localNewIntent.putExtra("k_cmd", 9);
        localNewIntent.putExtra("k_tpl_id", paramRichStatus.tplId);
        localNewIntent.putExtra("k_font_id", paramRichStatus.fontId);
        localNewIntent.putExtra("k_sign_len", arrayOfByte.length);
        localNewIntent.putExtra("k_sign_data", arrayOfByte);
        localNewIntent.putExtra("k_source", paramInt);
        this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
  
  public amev a(int paramInt)
  {
    amev localamev = (amev)this.jdField_q_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localamev == null) {
      avN();
    }
    return localamev;
  }
  
  public RichStatus a(String paramString, boolean paramBoolean)
  {
    Object localObject = (acff)this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      paramString = ((acff)localObject).a(paramString, paramBoolean);
      if (paramString == null) {}
    }
    for (paramString = paramString.getRichStatus();; paramString = null)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = new RichStatus(null);
      }
      return localObject;
    }
  }
  
  public RichStatus a(boolean paramBoolean)
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      return localObject2;
    }
    Object localObject1 = (acff)this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject1 != null)
    {
      localObject1 = ((acff)localObject1).a(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
      if (localObject1 == null) {}
    }
    for (localObject1 = ((ExtensionInfo)localObject1).getRichStatus();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return new RichStatus(null);
    }
  }
  
  protected ArrayList<UserProfile> a(ArrayList<UserProfile> paramArrayList1, ArrayList<UserProfile> paramArrayList2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (paramInt == -1)
    {
      localArrayList.addAll(paramArrayList1);
      localObject1 = paramArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject1 = paramArrayList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      if (((UserProfile)localObject2).bSex == paramInt)
      {
        localArrayList.add(localObject2);
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject2 = Long.valueOf(0L);
    try
    {
      long l1 = Long.parseLong(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject1 = Long.valueOf(l1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.richstatus.xml", 2, localException.toString());
          localObject1 = localObject2;
          continue;
          localException.bAge = ((UserProfile)localObject2).bAge;
          localException.bSex = ((UserProfile)localObject2).bSex;
          localException.strDesc = ((UserProfile)localObject2).strDesc;
        }
      }
      this.R = localHashMap;
      if (!QLog.isColorLevel()) {
        break label385;
      }
      QLog.d("Q.richstatus.mate", 2, "mergeFriendsStrangers " + paramArrayList1.size() + " " + paramArrayList2.size() + " " + paramInt + "=" + localArrayList.size());
    }
    localHashMap.put(localObject1, new UserProfile());
    localObject1 = paramArrayList2.iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label306;
      }
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject2).lEctID));
      if (localUserProfile != null) {
        break;
      }
      localArrayList.add(localObject2);
    }
    label306:
    return localArrayList;
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    if ((paramString2 == null) && (paramBitmap != null)) {
      this.jdField_j_of_type_JavaUtilHashSet.remove(paramString1);
    }
    paramString1 = paramString1.split("_");
    int i;
    if (paramString1.length == 3)
    {
      if (this.jdField_j_of_type_JavaUtilLinkedList != null)
      {
        paramInt = Integer.parseInt(paramString1[0]);
        i = Integer.parseInt(paramString1[2]);
        paramString1 = this.jdField_j_of_type_JavaUtilLinkedList.iterator();
        while (paramString1.hasNext()) {
          ((amfh)paramString1.next()).a(paramInt, i, paramBitmap);
        }
      }
    }
    else if ((paramString1.length == 2) && (this.l != null))
    {
      i = Integer.parseInt(paramString1[0]);
      int k = Integer.parseInt(paramString1[1]);
      paramString1 = this.l.iterator();
      while (paramString1.hasNext()) {
        ((amfi)paramString1.next()).a(i, k, paramBitmap, paramInt);
      }
    }
  }
  
  public boolean a(File paramFile, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "saveActions(" + paramFile + ", " + paramLong + ")");
    }
    for (;;)
    {
      try
      {
        Object localObject1 = a(new FileInputStream(paramFile));
        ??? = (SparseArray)localObject1[0];
        ArrayList localArrayList = (ArrayList)localObject1[1];
        if ((??? != null) && (((SparseArray)???).size() > 0) && (localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject1 = this.jdField_q_of_type_AndroidUtilSparseArray;
          synchronized (this.jdField_q_of_type_AndroidUtilSparseArray)
          {
            AsyncTask localAsyncTask = this.jdField_e_of_type_AndroidOsAsyncTask;
            if (localAsyncTask != null) {
              localAsyncTask.cancel(true);
            }
            this.jdField_q_of_type_AndroidUtilSparseArray = ((SparseArray)???);
            if ((localArrayList == null) || (localArrayList.size() <= 0)) {}
          }
        }
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (FileNotFoundException paramFile)
      {
        synchronized (this.bh)
        {
          this.bh.clear();
          this.bh.addAll(localArrayList);
          this.mUpdateTime = System.currentTimeMillis();
          ??? = new File(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir(), "rich_status.xml");
          if ((paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)))
          {
            paramFile = y().edit();
            paramFile.putLong("k_version", paramLong).putLong("k_update_time", this.mUpdateTime).commit();
            if (a((SparseArray)localObject1, this.jdField_q_of_type_AndroidUtilSparseArray)) {
              paramFile.putLong("k_icon", paramLong).commit();
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "saveActions return with " + bool);
            }
            return bool;
            paramFile = finally;
            throw paramFile;
            paramFile = paramFile;
            paramFile.printStackTrace();
            bool = false;
          }
        }
      }
      QLog.d("Q.richstatus.xml", 2, "saveActions rename failed!");
    }
  }
  
  public void addListener(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          if ((paramObject instanceof amfh))
          {
            if (this.jdField_j_of_type_JavaUtilLinkedList == null)
            {
              this.jdField_j_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_j_of_type_JavaUtilLinkedList.add((amfh)paramObject);
            }
          }
          else
          {
            if ((paramObject instanceof amff))
            {
              if (this.X != null) {
                break label228;
              }
              this.X = new LinkedList();
              this.X.add((amff)paramObject);
            }
            if ((paramObject instanceof amfi))
            {
              if (this.l != null) {
                break label254;
              }
              this.l = new LinkedList();
              this.l.add((amfi)paramObject);
            }
            if ((paramObject instanceof amfk))
            {
              if (this.m != null) {
                break label280;
              }
              this.m = new LinkedList();
              this.m.add((amfk)paramObject);
            }
            if (!(paramObject instanceof amfj)) {
              break;
            }
            if (this.n != null) {
              break label306;
            }
            this.n = new LinkedList();
            this.n.add((amfj)paramObject);
            break;
          }
        }
        finally {}
        label280:
        if (!this.jdField_j_of_type_JavaUtilLinkedList.contains(paramObject))
        {
          this.jdField_j_of_type_JavaUtilLinkedList.add((amfh)paramObject);
          continue;
          label228:
          if (!this.X.contains(paramObject))
          {
            this.X.add((amff)paramObject);
            continue;
            label254:
            if (!this.l.contains(paramObject))
            {
              this.l.add((amfi)paramObject);
              continue;
              if (!this.m.contains(paramObject)) {
                this.m.add((amfk)paramObject);
              }
            }
          }
        }
      }
      label306:
      if (!this.n.contains(paramObject)) {
        this.n.add((amfj)paramObject);
      }
    }
  }
  
  public boolean avO()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null;
  }
  
  public boolean avP()
  {
    SharedPreferences localSharedPreferences = c();
    boolean bool = localSharedPreferences.getBoolean("k_sync_ss", false);
    long l1 = System.currentTimeMillis();
    if ((Math.abs(l1 - this.cJ) > 180000L) && (Math.abs(l1 - localSharedPreferences.getLong("k_ss_time", 0L)) > 60000L))
    {
      if (this.jdField_a_of_type_Amho == null) {
        dNt();
      }
      this.cJ = l1;
      StatusServlet.dM(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo " + bool);
    }
    return bool;
  }
  
  public RichStatus c()
  {
    return a(true);
  }
  
  public boolean cE(long paramLong)
  {
    long l2 = y().getLong("k_version", 65L);
    long l1 = l2;
    if (l2 < 65L) {
      l1 = 65L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "StatusManager.isNewVersion(): localVersion " + l1 + " serverVersion " + paramLong + ", builtInVersion " + 65L);
    }
    return paramLong > l1;
  }
  
  public String d(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return paramString1.replace("$I", Integer.toString(paramInt1)).replace("$U", Integer.toString(paramInt2)).replace("$A", this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$N", paramString2);
  }
  
  protected ArrayList<UserProfile> e(ArrayList<UserProfile> paramArrayList)
  {
    HashMap localHashMap = this.R;
    int k = paramArrayList.size();
    Object localObject;
    if ((localHashMap != null) && (localHashMap.size() > 0) && (k > 0))
    {
      i = k - 1;
      while (i > -1)
      {
        localObject = (UserProfile)paramArrayList.get(i);
        UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject).lEctID));
        if (localUserProfile != null)
        {
          localUserProfile.bAge = ((UserProfile)localObject).bAge;
          localUserProfile.bSex = ((UserProfile)localObject).bSex;
          localUserProfile.strDesc = ((UserProfile)localObject).strDesc;
          paramArrayList.remove(i);
        }
        i -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("filterFriends ").append(k).append(" - ");
      if (localHashMap == null) {
        break label186;
      }
    }
    label186:
    for (int i = localHashMap.size();; i = -1)
    {
      QLog.d("Q.richstatus.mate", 2, i + "=" + paramArrayList.size());
      return paramArrayList;
    }
  }
  
  public long gK()
  {
    return y().getLong("k_version", 0L);
  }
  
  public void hP(long paramLong)
  {
    ((SignatureHandler)this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(41)).hP(paramLong);
    if (this.jdField_b_of_type_Aclv == null) {
      dNu();
    }
  }
  
  public Bitmap i(int paramInt1, int paramInt2)
  {
    localObject7 = null;
    if (this.jdField_b_of_type_Amfa == null) {
      this.jdField_b_of_type_Amfa = new amfa("StatusIcon_", this);
    }
    localObject3 = (amev)this.jdField_q_of_type_AndroidUtilSparseArray.get(paramInt1);
    Object localObject5 = paramInt1 + "_s_" + paramInt2;
    Object localObject6 = this.jdField_b_of_type_Amfa;
    Object localObject1;
    if (localObject3 != null) {
      if (paramInt2 == 201)
      {
        localObject1 = ((amev)localObject3).bigIcon;
        localObject6 = ((amfa)localObject6).a((String)localObject5, null, (String)localObject1);
        if ((localObject3 == null) && (avN()) && (localObject6 == null)) {
          this.jdField_j_of_type_JavaUtilHashSet.add(localObject5);
        }
        if (paramInt2 != 201) {
          break label257;
        }
      }
    }
    try
    {
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject5 = (Bitmap)BaseApplicationImpl.sImageCache.get("StatusIcon_RichStatusDefaultBig");
        localObject1 = localObject5;
        localObject3 = localObject7;
        if (localObject5 == null) {
          localObject1 = localObject5;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        label209:
        localObject2 = null;
        label257:
        localObject3 = localObject7;
      }
    }
    try
    {
      localObject5 = aqcu.decodeResource(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130850434);
      localObject1 = localObject5;
      BaseApplicationImpl.sImageCache.put("StatusIcon_RichStatusDefaultSmall", localObject5, (byte)0);
      localObject3 = localObject7;
      localObject1 = localObject5;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject4 = localObject7;
      break label209;
      localObject2 = null;
      break label209;
      localObject2 = null;
      localObject4 = localObject7;
      break label209;
    }
    if (localObject6 != null) {
      localObject1 = localObject6;
    }
    while (paramInt2 == 201)
    {
      return localObject1;
      localObject1 = ((amev)localObject3).bZO;
      break;
      localObject1 = null;
      break;
      localObject1 = aqcu.decodeResource(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130850434);
      localObject3 = localObject7;
      break label209;
      if (paramInt2 != 200) {
        break label382;
      }
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject3 = (Bitmap)BaseApplicationImpl.sImageCache.get("StatusIcon_RichStatusDefaultSmall");
        if (localObject3 != null) {
          break label377;
        }
        localObject3 = aqcu.decodeResource(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130850435);
        BaseApplicationImpl.sImageCache.put("StatusIcon_RichStatusDefaultSmall", localObject3, (byte)0);
        localObject1 = null;
        break label209;
      }
      localObject3 = aqcu.decodeResource(this.jdField_q_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130850435);
      localObject1 = null;
      break label209;
    }
    return localObject3;
  }
  
  public int ja(int paramInt)
  {
    if (paramInt == 102) {
      return IH();
    }
    if (paramInt == 101) {
      return II();
    }
    return -1;
  }
  
  public void onDestroy() {}
  
  public int r(ArrayList<amhg> paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("array list is null");
    }
    paramArrayList.clear();
    if (this.bh.size() > 0) {
      paramArrayList.addAll(this.bh);
    }
    return D(false);
  }
  
  public void removeListener(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (((paramObject instanceof amfh)) && (this.jdField_j_of_type_JavaUtilLinkedList != null)) {
        this.jdField_j_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof amff)) && (this.X != null)) {
        this.X.remove(paramObject);
      }
      if (((paramObject instanceof amfi)) && (this.l != null)) {
        this.l.remove(paramObject);
      }
      if (((paramObject instanceof amfk)) && (this.m != null)) {
        this.m.remove(paramObject);
      }
    } while ((!(paramObject instanceof amfj)) || (this.n == null));
    this.n.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhj
 * JD-Core Version:    0.7.0.1
 */