import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class auja
  extends augv
  implements auhk.f
{
  private List<atec> KX = new ArrayList();
  List<atiu> KY = new ArrayList();
  atgd jdField_a_of_type_Atgd = new aujb(this);
  private auhk.k jdField_a_of_type_Auhk$k;
  private atio b;
  private atio jdField_c_of_type_Atio;
  aulm jdField_c_of_type_Aulm = new aujc(this);
  private atio d;
  private atio e;
  private Object fU;
  private boolean isComplete;
  private List<atio> list = new ArrayList();
  private Map<String, atio> pE = new ConcurrentHashMap();
  private Map<String, atio> pF = new ConcurrentHashMap();
  private Map<String, Long> pG = new ConcurrentHashMap();
  private String version;
  
  public auja(QQAppInterface paramQQAppInterface, auhk.k paramk)
  {
    super(paramQQAppInterface, paramk);
    this.jdField_a_of_type_Auhk$k = paramk;
  }
  
  private boolean A(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (paramArrayOfByte = new String(paramArrayOfByte);; paramArrayOfByte = null) {
      return this.pE.containsKey(paramArrayOfByte);
    }
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, List<atiu> paramList, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt1 == 0) {
      break label4;
    }
    label4:
    while ((paramInt1 == 1) || (paramInt2 == 2)) {
      return;
    }
    if (paramArrayOfByte != null) {}
    for (String str = new String(paramArrayOfByte);; str = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TopLevelFileListPresenter", 2, "updateThumbInfo dirKeyStr:" + Arrays.toString(paramArrayOfByte) + " operationType:" + paramInt2 + " thumbVersion:" + paramString + " totalCount:" + paramInt3);
      }
      paramArrayOfByte = (atio)this.pF.get(str);
      if (paramArrayOfByte == null) {
        break;
      }
      str = paramArrayOfByte.EQ();
      if ((str == null) || (!str.equals(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TopLevelFileListPresenter", 2, "updateThumbInfo currentThumbVersion:" + str);
        }
        paramArrayOfByte.mx(paramList);
        paramArrayOfByte.YN(paramString);
        ((ateh)this.app.getBusinessHandler(180)).a(0, null);
      }
      paramArrayOfByte.aau(paramInt3);
      return;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte, List<atiu> paramList, int paramInt)
  {
    atgc localatgc = (atgc)this.app.getManager(373);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    atin localatin;
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (!(paramList instanceof atin)) {
        break label383;
      }
      localatin = (atin)paramList;
      if (QLog.isDevelopLevel()) {
        QLog.d("TopLevelFileListPresenter", 4, "refreshCloudFileData parentDirKey:" + Arrays.toString(paramArrayOfByte) + " dirKey:" + Arrays.toString(localatin.Y()));
      }
      if (!this.pE.containsKey(localatin.EP())) {
        break label380;
      }
      i = 1;
      label136:
      if (this.pF.containsKey(localatin.EP()))
      {
        paramList = (atio)this.pF.get(localatin.EP());
        paramList.a(localatin);
        localConcurrentHashMap.put(localatin.EP(), paramList);
      }
    }
    label380:
    label383:
    for (;;)
    {
      break;
      int j = 6;
      if (Arrays.equals(localatgc.aF(), localatin.Y())) {
        j = 2;
      }
      for (;;)
      {
        paramList = new atio(j, localatin);
        this.pF.put(localatin.EP(), paramList);
        break;
        if (Arrays.equals(localatgc.aG(), localatin.Y())) {
          j = 3;
        }
      }
      if (paramInt == 8)
      {
        if (i == 0)
        {
          this.pE.clear();
          this.pG.clear();
        }
        this.pE.putAll(localConcurrentHashMap);
      }
      for (;;)
      {
        evd();
        if ((paramInt == 8) && (i != 0)) {
          break;
        }
        return true;
        if (paramInt == 2)
        {
          this.pE.putAll(localConcurrentHashMap);
        }
        else
        {
          this.pE.clear();
          this.pE.putAll(localConcurrentHashMap);
          this.pG.clear();
        }
      }
      return false;
      break label136;
    }
  }
  
  private void euW()
  {
    if ((!isComplete()) && (this.list.size() < 10)) {
      ((ateh)this.app.getBusinessHandler(180)).N(2, this.fU);
    }
  }
  
  private void evd()
  {
    this.list.clear();
    Iterator localIterator = this.pE.values().iterator();
    while (localIterator.hasNext())
    {
      atio localatio = (atio)localIterator.next();
      this.list.add(localatio);
    }
    this.list.add(0, this.jdField_c_of_type_Atio);
    nV(this.list);
  }
  
  private void eve()
  {
    ArrayList localArrayList = new ArrayList();
    atlc localatlc1 = new atlc(6);
    atlc localatlc2 = new atlc(7);
    atlc localatlc3 = new atlc(3);
    atlc localatlc4 = new atlc(9);
    localArrayList.add(localatlc1);
    localArrayList.add(localatlc2);
    localArrayList.add(localatlc3);
    localArrayList.add(localatlc4);
    this.e.mx(localArrayList);
  }
  
  private void evf()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.KY);
    localArrayList.addAll(((aull)this.app.getManager(372)).hp());
    athu.nJ(localArrayList);
    this.b.mx(localArrayList);
  }
  
  private void evg() {}
  
  private void evh()
  {
    ArrayList localArrayList = new ArrayList();
    atlc localatlc1 = new atlc(6);
    atlc localatlc2 = new atlc(7);
    atlc localatlc3 = new atlc(3);
    atlc localatlc4 = new atlc(9);
    localArrayList.add(localatlc1);
    localArrayList.add(localatlc2);
    localArrayList.add(localatlc3);
    localArrayList.add(localatlc4);
    this.d.mx(localArrayList);
  }
  
  private void evi()
  {
    this.KX.clear();
    atec localatec1 = new atec(2130839399, 2131691624, 1);
    atec localatec2 = new atec(2130839401, 2131691622, 3);
    atec localatec3 = new atec(2130839400, 2131691623, 2);
    atec localatec4 = new atec(2130839402, 2131691625, 4);
    this.KX.add(localatec1);
    this.KX.add(localatec2);
    this.KX.add(localatec3);
    this.KX.add(localatec4);
    localatec1 = new atec(2130839403, 2131691626, 5);
    this.KX.add(localatec1);
  }
  
  private void nV(List<atio> paramList)
  {
    Collections.sort(paramList, new aujd(this));
  }
  
  private boolean y(byte[] paramArrayOfByte)
  {
    return Arrays.equals(((atgc)this.app.getManager(373)).aE(), paramArrayOfByte);
  }
  
  public Object W()
  {
    return this.fU;
  }
  
  protected void euT()
  {
    super.euT();
    this.jdField_a_of_type_Auhk$k = null;
  }
  
  public List<atio> hk()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext())
    {
      atio localatio = (atio)localIterator.next();
      if ((localatio.dirType != 3) || (localatio.ar(this.app) > 0)) {
        localArrayList.add(localatio);
      }
    }
    return localArrayList;
  }
  
  public List<atec> hm()
  {
    return this.KX;
  }
  
  public boolean isComplete()
  {
    return this.isComplete;
  }
  
  public void onCreate()
  {
    this.b = new atio(0, BaseApplicationImpl.getContext().getString(2131691582));
    this.d = new atio(4, BaseApplicationImpl.getContext().getString(2131691585));
    this.jdField_c_of_type_Atio = new atio(7, "");
    evh();
    evi();
    this.e = new atio(5, BaseApplicationImpl.getContext().getString(2131691587));
    eve();
    this.app.addObserver(this.jdField_a_of_type_Atgd);
    this.app.addObserver(this.jdField_c_of_type_Aulm);
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
    this.app.removeObserver(this.jdField_c_of_type_Aulm);
    this.pE.clear();
    this.pF.clear();
    this.pG.clear();
    this.KY.clear();
    this.list.clear();
    this.isComplete = false;
    this.version = null;
    this.fU = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auja
 * JD-Core Version:    0.7.0.1
 */