import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View.OnClickListener;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.QFileBrowserActivity;
import com.tencent.tim.mvp.cloudfile.FileRecentListPresenter.3;
import com.tencent.tim.mvp.cloudfile.FileRecentListPresenter.5;
import com.tencent.tim.mvp.cloudfile.FileRecentListPresenter.6;
import com.tencent.tim.teamwork.PadInfo;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class auif
  extends auin
  implements Handler.Callback
{
  private List<auin.a> KS;
  private List<atkw> KT = new ArrayList();
  private List<atkw> KU = new ArrayList();
  private List<atiu> KV = new ArrayList();
  private atmk jdField_a_of_type_Atmk;
  private aulh jdField_a_of_type_Aulh;
  private aull jdField_a_of_type_Aull;
  private aulm jdField_a_of_type_Aulm = new auii(this);
  public Comparator<PadInfo> an = new auil(this);
  public Comparator<atiu> ao = new auim(this);
  private atgd b = new auij(this);
  aths.a c = new auig(this);
  private View.OnClickListener cn = new auik(this);
  private boolean diS = true;
  private boolean diT = true;
  private int epO = 0;
  private int erB;
  private int erC;
  private int erD;
  public final MqqHandler q = new aurf(Looper.getMainLooper(), this, true);
  private HashMap<String, PadInfo> qj;
  
  public auif(Context paramContext, QQAppInterface paramQQAppInterface, auhk.g paramg)
  {
    super(paramContext, paramQQAppInterface, paramg);
    this.jdField_a_of_type_Atmk = new atmk(paramQQAppInterface);
    this.qj = new HashMap();
  }
  
  private long a(PadInfo paramPadInfo)
  {
    long l2 = paramPadInfo.currentUserBrowseTime;
    long l1 = l2;
    if (this.app.getCurrentAccountUin().equals(String.valueOf(paramPadInfo.lastEditorUin)))
    {
      l1 = l2;
      if (paramPadInfo.lastEditTime >= paramPadInfo.currentUserBrowseTime) {
        l1 = paramPadInfo.lastEditTime;
      }
    }
    return l1;
  }
  
  private List<atkw> a(atkw paramatkw)
  {
    int k = 0;
    this.erD = 0;
    Object localObject = new ArrayList();
    int j = this.KU.size();
    if (paramatkw.getFileType() == 0)
    {
      int i = 0;
      while (i < j)
      {
        atkw localatkw = (atkw)this.KU.get(i);
        if (localatkw.getFileType() == 0) {
          ((List)localObject).add(localatkw);
        }
        i += 1;
      }
      int m = ((List)localObject).size();
      i = 0;
      if (i < m) {
        if (((atkw)((List)localObject).get(i)).a.historyId != paramatkw.a.historyId) {}
      }
      for (;;)
      {
        if (i < 30)
        {
          j = 0;
          label134:
          localObject = ((List)localObject).subList(j, Math.min(m, i + 30));
          i = k;
        }
        for (;;)
        {
          if (i >= ((List)localObject).size()) {
            break label225;
          }
          if (((atkw)((List)localObject).get(i)).a.historyId == paramatkw.a.historyId)
          {
            this.erD = i;
            return localObject;
            i += 1;
            break;
            j = i - 30;
            break label134;
          }
          i += 1;
        }
        label225:
        return localObject;
        i = 0;
      }
    }
    return localObject;
  }
  
  private void a(atkw paramatkw, List<atkw> paramList)
  {
    Intent localIntent = new Intent(this.mContext, QFileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramatkw.a());
    localIntent.putExtra("qfile_browser_forward_file_info", paramatkw.a());
    paramatkw = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramatkw.add(((atkw)paramList.next()).a());
    }
    localIntent.putExtra("qfile_browser_forward_file_list", paramatkw);
    localIntent.putExtra("qfile_browser_forward_file_index", this.erD);
    localIntent.putExtra("qfile_browser_entrance_type", 1);
    this.mContext.startActivity(localIntent);
  }
  
  private void aaM(int paramInt)
  {
    ThreadManager.postImmediately(new FileRecentListPresenter.3(this, paramInt), null, true);
  }
  
  private void aaO(int paramInt)
  {
    ThreadManager.postImmediately(new FileRecentListPresenter.5(this, paramInt), null, true);
  }
  
  private void aaP(int paramInt)
  {
    ThreadManager.postImmediately(new FileRecentListPresenter.6(this, paramInt), null, true);
  }
  
  private void b(int paramInt1, boolean paramBoolean, int paramInt2, List<atkw> paramList, int paramInt3, String paramString)
  {
    this.diT = paramBoolean;
    QLog.e("FileRecentListPresenter", 1, "handleDBResult query cloud file recent history finish. fileType[" + paramInt1 + "] hasMore[" + String.valueOf(paramBoolean) + "] errCode[" + paramInt3 + "] errMsg[" + paramString + "] opType[" + paramInt2 + "]");
    if (paramInt2 == 1)
    {
      this.KU.clear();
      this.KU.addAll(paramList);
      if (paramInt1 == 0)
      {
        aaM(1);
        return;
      }
      this.q.sendMessage(this.q.obtainMessage(2, paramInt1, 0, null));
      return;
    }
    this.KU.addAll(paramList);
    if (paramInt1 == 0)
    {
      aaO(2);
      return;
    }
    this.q.sendMessage(this.q.obtainMessage(5, paramInt1, 0, null));
  }
  
  private List<atkw> bt(List<PadInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PadInfo localPadInfo = (PadInfo)paramList.next();
      atky localatky = new atky();
      localatky.fileName = localPadInfo.title;
      localatky.relatedType = 7;
      localatky.fQ = localPadInfo;
      localatky.lastTime = a(localPadInfo);
      localArrayList.add(localatky);
    }
    return localArrayList;
  }
  
  private void evb()
  {
    if (this.jdField_a_of_type_Aull != null) {
      this.jdField_a_of_type_Aull.qh();
    }
  }
  
  private void evc()
  {
    this.erB += Math.min(20, this.KT.size() - this.erB);
    if (this.erB >= this.KT.size() - 1) {
      this.diS = false;
    }
    this.jdField_a_of_type_Auhk$g.f(true, 2, true);
  }
  
  private void gP(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileRecentListPresenter", 1, "deleteRecentHistoryInfo. fileId[" + paramString + "] deleteType[" + paramInt + "]");
    }
    Object localObject2 = null;
    Object localObject1;
    int j;
    int i;
    if (paramInt == 0)
    {
      localObject1 = localObject2;
      if (this.KT != null)
      {
        localObject1 = localObject2;
        if (this.KT.size() > 0)
        {
          j = this.KT.size();
          i = 0;
          if (i >= j) {
            break label376;
          }
          localObject1 = (atkw)this.KT.get(i);
          if (!((PadInfo)((atkw)localObject1).fQ).pad_url.equals(paramString)) {
            break label208;
          }
          paramString = (String)localObject1;
          if (i <= this.erB) {
            this.erB -= 1;
          }
        }
      }
    }
    label162:
    label208:
    label336:
    label373:
    label376:
    for (paramString = (String)localObject1;; paramString = null)
    {
      localObject1 = paramString;
      for (;;)
      {
        if (localObject1 != null)
        {
          if (paramInt != 0) {
            break label336;
          }
          this.KT.remove(localObject1);
        }
        for (;;)
        {
          this.KV.remove(localObject1);
          this.jdField_a_of_type_Auhk$g.f(true, 1, true);
          return;
          i += 1;
          break;
          localObject1 = localObject2;
          if (this.KU == null) {
            break label162;
          }
          localObject1 = localObject2;
          if (this.KU.size() <= 0) {
            break label162;
          }
          j = this.KU.size();
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= j) {
              break;
            }
            localObject1 = (atkw)this.KU.get(i);
            if (new String(((atkw)localObject1).a.fileIdBytes, Charset.forName("UTF-8")).equals(paramString))
            {
              if (i > this.erC) {
                break label373;
              }
              this.erC -= 1;
              break;
            }
            i += 1;
          }
          this.KU.remove(localObject1);
          atgi.a().a(((atkw)localObject1).a.historyId, new auih(this));
        }
      }
    }
  }
  
  private void initListData()
  {
    this.erB = 0;
    this.erC = 0;
    this.diT = true;
    this.diS = true;
    this.KT.clear();
    this.KU.clear();
    this.KV.clear();
  }
  
  private void kU(int paramInt1, int paramInt2)
  {
    int i = this.KU.size();
    CloudHistoryInfo localCloudHistoryInfo;
    if ((i > 0) && (paramInt2 != 1)) {
      localCloudHistoryInfo = ((atkw)this.KU.get(i - 1)).a;
    }
    for (;;)
    {
      long l1 = localCloudHistoryInfo.historyId;
      long l2 = localCloudHistoryInfo.operateTime;
      long l3 = localCloudHistoryInfo.historySeq;
      this.jdField_a_of_type_Atmk.a(paramInt1, 20, paramInt2, l1, l2, l3);
      return;
      localCloudHistoryInfo = new CloudHistoryInfo();
      localCloudHistoryInfo.historyId = 0L;
      localCloudHistoryInfo.operateTime = 0L;
      localCloudHistoryInfo.historySeq = 0L;
    }
  }
  
  private boolean mY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.diT;
    case 0: 
      return (this.diS) || (this.diT);
    }
    return this.diS;
  }
  
  public boolean aJq()
  {
    return true;
  }
  
  public boolean aJr()
  {
    return true;
  }
  
  public boolean aJs()
  {
    return false;
  }
  
  public void aaK(int paramInt)
  {
    hl();
    paramInt = ((auin.a)this.KS.get(paramInt)).tabIndex;
    if (QLog.isColorLevel()) {
      QLog.e("FileRecentListPresenter", 1, "loadDataList. is need refresh data, file show type [" + paramInt + "]");
    }
    initListData();
    if (paramInt == 1)
    {
      aaM(1);
      return;
    }
    kU(paramInt, 1);
  }
  
  public void aaL(int paramInt)
  {
    hl();
    paramInt = ((auin.a)hl().get(paramInt)).tabIndex;
    if (!mY(paramInt))
    {
      this.jdField_a_of_type_Auhk$g.f(true, 2, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FileRecentListPresenter", 1, "waterchen loadMoreDataList. is need load more data, file show type [" + paramInt + "]");
    }
    if (paramInt == 1)
    {
      evc();
      return;
    }
    kU(paramInt, 2);
  }
  
  public void aaN(int paramInt)
  {
    hl();
    auin.a locala = (auin.a)this.KS.get(paramInt);
    this.epO = locala.tabIndex;
    initListData();
    if (locala.tabIndex == 1)
    {
      aaM(1);
      return;
    }
    kU(locala.tabIndex, 1);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 14001)
    {
      this.jdField_a_of_type_Aulh.e(2, 2, false, false);
      if (QLog.isColorLevel()) {
        QLog.i("FileRecentListPresenter", 1, "doOnActivityResult. open a teamwork file and back, check the new file info.");
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QLog.i("FileRecentListPresenter", 1, "msgType[" + paramMessage.what + "]");
    switch (paramMessage.what)
    {
    case 4: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                if (this.epO == 0)
                {
                  aaP(1);
                  return true;
                }
              } while (this.epO != 1);
              this.erB = Math.min(20, this.KT.size());
              this.jdField_a_of_type_Auhk$g.f(true, 1, isComplete());
              return true;
              i = paramMessage.arg1;
              if (QLog.isColorLevel()) {
                QLog.e("FileRecentListPresenter", 1, "loadRecentDataList finish. loadType [" + i + "] curFileType[" + this.epO + "]");
              }
            } while (i != this.epO);
            this.jdField_a_of_type_Auhk$g.f(true, 1, isComplete());
            return true;
          } while (this.epO != 0);
          this.jdField_a_of_type_Auhk$g.f(true, 1, isComplete());
          this.jdField_a_of_type_Aulh.VT(false);
          return true;
          i = paramMessage.arg1;
          if (QLog.isColorLevel()) {
            QLog.e("FileRecentListPresenter", 1, "loadMoreDataList finish. loadType [" + i + "] curFileType[" + this.epO + "]");
          }
        } while (i != this.epO);
        this.jdField_a_of_type_Auhk$g.f(true, 2, isComplete());
        return true;
      } while (this.epO != 0);
      this.jdField_a_of_type_Auhk$g.f(true, 2, isComplete());
      return true;
    case 7: 
      this.jdField_a_of_type_Auhk$g.f(false, 3, isComplete());
      return true;
    case 8: 
      paramMessage = (auif.a)paramMessage.obj;
      b(paramMessage.fileType, paramMessage.diU, paramMessage.operateType, paramMessage.KW, paramMessage.errorCode, paramMessage.errMsg);
      return true;
    case 9: 
      paramMessage = (PadInfo)paramMessage.obj;
      if (paramMessage != null)
      {
        PadInfo localPadInfo = (PadInfo)this.qj.get(paramMessage.pad_url);
        if (localPadInfo != null) {
          localPadInfo.title = paramMessage.title;
        }
      }
      this.jdField_a_of_type_Auhk$g.f(false, 3, isComplete());
      return true;
    }
    gP((String)paramMessage.obj, paramMessage.arg1);
    return true;
  }
  
  public List<atiu> hk()
  {
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.e("FileRecentListPresenter", 1, "getFileList. file show type [" + this.epO + "]");
    }
    switch (this.epO)
    {
    default: 
      localArrayList.addAll(this.KU);
      return localArrayList;
    case 0: 
      localArrayList.addAll(this.KV);
      return localArrayList;
    }
    localArrayList.addAll(this.KT.subList(0, this.erB));
    return localArrayList;
  }
  
  public List<auin.a> hl()
  {
    if (this.KS == null)
    {
      this.KS = new ArrayList();
      this.KS.add(new auin.a(this, 0, 2131693844));
      this.KS.add(new auin.a(this, 1, 2131693852));
      this.KS.add(new auin.a(this, 2, 2131693846));
      this.KS.add(new auin.a(this, 3, 2131693850));
      this.KS.add(new auin.a(this, 4, 2131693853));
      this.KS.add(new auin.a(this, 5, 2131693849));
    }
    return this.KS;
  }
  
  public boolean isComplete()
  {
    return !mY(this.epO);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Aull = ((aull)this.app.getManager(372));
    this.jdField_a_of_type_Aulh = ((aulh)this.app.getBusinessHandler(178));
    this.app.addObserver(this.jdField_a_of_type_Aulm);
    this.app.addObserver(this.b);
    aths.a().a(this.c);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Aulm);
    this.app.removeObserver(this.b);
    aths.a().b(this.c);
  }
  
  public View.OnClickListener x()
  {
    return this.cn;
  }
  
  class a
  {
    List<atkw> KW;
    boolean diU;
    String errMsg;
    int errorCode;
    int fileType;
    int operateType;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auif
 * JD-Core Version:    0.7.0.1
 */