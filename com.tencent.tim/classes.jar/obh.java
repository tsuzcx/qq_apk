import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class obh
  implements aolm.b
{
  aook a = new obi(this);
  private QQAppInterface app;
  TroopMemberApiService c;
  private aolm d;
  HashMap<String, Bundle> eE = new HashMap();
  HashMap<Long, Bundle> er = new HashMap();
  HashMap<Long, Bundle> es = new HashMap();
  private ArrayList<aool> lV = new ArrayList();
  private ArrayList<aoll> lW = new ArrayList();
  private ArrayList<aool> lX = new ArrayList();
  private String pUin;
  
  public obh(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.c = paramTroopMemberApiService;
    this.d = paramQQAppInterface.getNetEngine(0);
  }
  
  private void oY(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lW.iterator();
    while (localIterator.hasNext())
    {
      aoll localaoll = (aoll)localIterator.next();
      if (localaoll.bZ.equals(paramString)) {
        localArrayList.add(localaoll);
      }
    }
    this.lW.removeAll(localArrayList);
  }
  
  public void aN(Bundle paramBundle)
  {
    if (jqc.getNetWorkType() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.c.j(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.pUin = paramBundle.getString("pic_puin");
    aooi localaooi = this.app.a();
    this.a.addFilter(new Class[] { aojg.class });
    localaooi.a(this.a);
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.dOM = 10;
    localaool.dQ = str;
    localaool.mUniseq = ((Math.random() * 1000000.0D));
    localaool.mPeerUin = "0";
    localaool.mFileType = 24;
    localaool.ckW = "PAJSSDKPicUploadProcess";
    localaooi.a(localaool);
    this.er.put(Long.valueOf(localaool.mUniseq), paramBundle);
    this.es.put(Long.valueOf(localaool.mUniseq), paramBundle);
    this.lV.add(localaool);
  }
  
  public void aO(Bundle paramBundle)
  {
    int k = 0;
    if (jqc.getNetWorkType() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.c.j(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      aoll localaoll = new aoll();
      localaoll.f = this;
      localaoll.bZ = str;
      localaoll.mExcuteTimeLimit = 180000L;
      if (localaoll.bZ == null) {
        break;
      }
      Object localObject1 = localaoll.bZ.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localaoll.atY = (acbn.SDCARD_PATH + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(acbn.SDCARD_PATH + "c2bPIC/");
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
            this.c.j(26, paramBundle);
            return;
          }
          i += 1;
        }
      }
      if (this.d == null) {
        break;
      }
      this.d.a(localaoll);
      this.eE.put(str, paramBundle);
      this.lW.add(localaoll);
    } while (paramBundle.getInt("is_showProgress_tips") != 1);
    this.c.j(25, paramBundle);
    return;
    paramBundle.putString("pic_local_id", "-1");
    this.c.j(26, paramBundle);
  }
  
  public void aP(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_local_path");
    Object localObject = this.app.a();
    this.a.addFilter(new Class[] { aolq.class });
    ((aooi)localObject).a(this.a);
    localObject = new aool();
    ((aool)localObject).mSelfUin = this.app.getAccount();
    ((aool)localObject).mPeerUin = "255";
    ((aool)localObject).mUinType = 9999;
    ((aool)localObject).mFileType = 32;
    ((aool)localObject).mUniseq = ((Math.random() * 1000000.0D));
    ((aool)localObject).cNy = true;
    ((aool)localObject).dQ = str;
    ((aool)localObject).mBusiType = 102;
    ((aool)localObject).cNF = true;
    ((aool)localObject).dQL = 1;
    this.app.a().a((aool)localObject);
    this.er.put(Long.valueOf(((aool)localObject).mUniseq), paramBundle);
    this.es.put(Long.valueOf(((aool)localObject).mUniseq), paramBundle);
    this.lX.add(localObject);
  }
  
  public void aQ(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.app.a();
    this.a.addFilter(new Class[] { aolp.class });
    ((aooi)localObject).a(this.a);
    localObject = new aool();
    ((aool)localObject).mSelfUin = this.app.getAccount();
    ((aool)localObject).mPeerUin = "255";
    ((aool)localObject).mUinType = 9999;
    ((aool)localObject).mFileType = 32;
    ((aool)localObject).mUniseq = ((Math.random() * 1000.0D));
    ((aool)localObject).cNy = false;
    ((aool)localObject).cmo = str;
    ((aool)localObject).clR = (acbn.SDCARD_PATH + "c2bPTT/" + str + ".amr");
    if (new File(((aool)localObject).clR).exists())
    {
      paramBundle.putString("pic_local_id", new obu().fn(((aool)localObject).clR));
      this.c.j(26, paramBundle);
      return;
    }
    ((aool)localObject).cNz = true;
    ((aool)localObject).dQF = 5;
    this.app.a().a((aool)localObject);
    this.er.put(Long.valueOf(((aool)localObject).mUniseq), paramBundle);
    this.es.put(Long.valueOf(((aool)localObject).mUniseq), paramBundle);
    this.lX.add(localObject);
  }
  
  public void bde()
  {
    Object localObject2;
    if (this.d != null)
    {
      localObject1 = this.lW.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aoll)((Iterator)localObject1).next();
        this.d.b((aomg)localObject2);
      }
    }
    Object localObject1 = this.app.a();
    if (localObject1 != null)
    {
      localObject2 = this.lV.iterator();
      aool localaool;
      while (((Iterator)localObject2).hasNext())
      {
        localaool = (aool)((Iterator)localObject2).next();
        ((aooi)localObject1).aZ(localaool.mPeerUin, localaool.mUniseq);
      }
      localObject2 = this.lX.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localaool = (aool)((Iterator)localObject2).next();
        ((aooi)localObject1).ba(localaool.mPeerUin, localaool.mUniseq);
      }
    }
    this.er.clear();
    this.es.clear();
    this.eE.clear();
    this.lV.clear();
    this.lW.clear();
  }
  
  void eV(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lV.iterator();
    while (localIterator.hasNext())
    {
      aool localaool = (aool)localIterator.next();
      if (localaool.mUniseq == paramLong) {
        localArrayList.add(localaool);
      }
    }
    this.lV.removeAll(localArrayList);
  }
  
  void eW(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lX.iterator();
    while (localIterator.hasNext())
    {
      aool localaool = (aool)localIterator.next();
      if (localaool.mUniseq == paramLong) {
        localArrayList.add(localaool);
      }
    }
    this.lX.removeAll(localArrayList);
  }
  
  public void onResp(aomh paramaomh)
  {
    Object localObject;
    Bundle localBundle;
    if ((paramaomh != null) && ((paramaomh.b instanceof aoll)))
    {
      localObject = (aoll)paramaomh.b;
      if ((paramaomh.mResult == 0) || (paramaomh.mResult == 1))
      {
        localBundle = (Bundle)this.eE.remove(((aoll)localObject).bZ);
        oY(((aoll)localObject).bZ);
        if (localBundle != null)
        {
          if ((((aoll)localObject).bZ == null) || (paramaomh.mResult != 0)) {
            break label293;
          }
          paramaomh = ((aoll)localObject).bZ.split("/");
          if (paramaomh.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", paramaomh[(paramaomh.length - 2)]);
          localObject = ((aoll)localObject).atY;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          paramaomh = new File((String)localObject);
          if (!paramaomh.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = aqhq.estimateFileType((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (paramaomh.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.c.j(26, localBundle);
      return;
    }
    catch (Exception paramaomh)
    {
      localBundle.putString("pic_local_id", "-1");
      this.c.j(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.c.j(26, localBundle);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obh
 * JD-Core Version:    0.7.0.1
 */