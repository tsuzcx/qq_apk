import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class apeq
  extends BaseAdapter
  implements Handler.Callback, apcp, apei.a, AbsListView.e
{
  public static String TAG = "TroopFileExpandableListAdapter<QFile>";
  private List<apbr> HK = new ArrayList();
  private List<apbr> HL = new ArrayList(20);
  private apeh jdField_a_of_type_Apeh;
  private apsf jdField_a_of_type_Apsf;
  public String aEG = "";
  public long aqC;
  private apei.a jdField_b_of_type_Apei$a;
  private TroopFileTransferManager jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  public int blU;
  private boolean cPU;
  private boolean cPm;
  private boolean cQe;
  private int cYl = 0;
  private QQAppInterface mApp;
  private Context mContext;
  public Handler mHandler;
  public int mLastVisibleIndex;
  private boolean mScrolling;
  private long mTroopUin;
  private Map<UUID, apei> nB = new HashMap();
  
  public apeq(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.mTroopUin = paramLong;
    this.mContext = paramContext;
    this.aEG = paramString;
    this.cYl = paramInt;
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(this);
    this.jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, this.mTroopUin);
    this.jdField_a_of_type_Apsf = apsf.a(this.mApp, this.mTroopUin);
    this.jdField_a_of_type_Apsf.aEG = this.aEG;
    if (!this.jdField_a_of_type_Apsf.a(this)) {
      this.jdField_a_of_type_Apsf.registerObserver(this);
    }
  }
  
  private List<apbr> br(List<apbr> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apbr localapbr = (apbr)paramList.next();
      if ((TextUtils.isEmpty(localapbr.mFileId)) || (!localapbr.mFileId.contains("online_doc_folder_"))) {
        localArrayList.add(localapbr);
      }
    }
    return localArrayList;
  }
  
  protected void Fk(int paramInt)
  {
    if (this.jdField_a_of_type_Apeh != null) {
      this.jdField_a_of_type_Apeh.Fk(paramInt);
    }
  }
  
  public void WC(int paramInt) {}
  
  public void a(apbr paramapbr, String paramString)
  {
    if (paramapbr == null) {}
    do
    {
      do
      {
        apsf.a locala;
        do
        {
          return;
          if (!this.aEG.equals("/")) {
            break;
          }
          locala = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get("/" + this.aqC);
        } while ((locala == null) || (locala.BE == null));
        apbr localapbr = (apbr)this.jdField_a_of_type_Apsf.nO.get(paramString);
        if ((localapbr != null) && (localapbr.cPN))
        {
          localapbr.dTl += 1;
          localapbr.setModifyTime((int)NetConnInfoCenter.getServerTime());
          j = this.HK.size();
          i = 0;
          if (i < j)
          {
            if (localapbr != this.HK.get(i)) {
              break;
            }
            locala.BE.remove(i);
          }
          locala.BE.add(0, localapbr);
          locala.a = null;
          a(locala.BE, locala.mIsEnd, 0, false);
        }
      } while (!this.aEG.equals(paramString));
      paramString = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get(paramString + this.aqC);
    } while ((paramString == null) || (paramString.BE == null));
    boolean bool = paramString.mIsEnd;
    int j = this.HK.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((apbr)this.HK.get(i)).cPN) && (paramapbr.Lg() >= ((apbr)this.HK.get(i)).Lg()))
        {
          paramString.BE.add(i, paramapbr);
          paramString.nR.put(paramapbr.mFileId, paramapbr);
          a(paramString.BE, paramString.mIsEnd, 0, false);
        }
      }
      else
      {
        paramString.a = null;
        return;
        i += 1;
        break;
      }
      if ((i == j - 1) && (bool))
      {
        paramString.BE.add(paramapbr);
        paramString.nR.put(paramapbr.mFileId, paramapbr);
        a(paramString.BE, paramString.mIsEnd, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(apeh paramapeh)
  {
    this.jdField_a_of_type_Apeh = paramapeh;
  }
  
  public void a(List<apbr> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramList == null) {}
    do
    {
      return;
      this.nB.clear();
      this.HK.clear();
      this.HK.addAll(br(paramList));
      if (paramList.size() == 0)
      {
        if ("/".equals(this.aEG))
        {
          Fk(3);
          return;
        }
        Fk(6);
        return;
      }
      this.cPU = false;
      notifyDataSetChanged();
      Fk(4);
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Apsf.F(this.aEG, this.aqC)) || (this.jdField_a_of_type_Apeh == null));
    this.jdField_a_of_type_Apeh.Fl(7);
  }
  
  public void a(List<apbr> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.aEG.equals(paramString)) || (this.aqC != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Apeh != null) {
        this.jdField_a_of_type_Apeh.Fl(3);
      }
      ahao.OS(2131699769);
    } while (!this.HK.isEmpty());
    Fk(1);
    return;
    if (this.jdField_a_of_type_Apeh != null) {
      this.jdField_a_of_type_Apeh.Fl(4);
    }
    a(paramList, paramBoolean, 0, false);
  }
  
  public void a(boolean paramBoolean, apbr paramapbr)
  {
    if (this.HL == null) {
      return;
    }
    if (paramapbr == null) {
      QLog.i(TAG, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.HL.contains(paramapbr)) {
        this.HL.add(paramapbr);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Apei$a != null) {
        this.jdField_b_of_type_Apei$a.a(paramBoolean, paramapbr);
      }
      notifyDataSetChanged();
      return;
      this.HL.remove(paramapbr);
    }
  }
  
  public void b(apei.a parama)
  {
    this.jdField_b_of_type_Apei$a = parama;
  }
  
  public boolean b(apbr paramapbr)
  {
    if ((this.HL == null) || (this.HL.isEmpty())) {
      return false;
    }
    return this.HL.contains(paramapbr);
  }
  
  public void dXH()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Apeh != null)
    {
      i = this.jdField_a_of_type_Apeh.getFirstVisiblePosition();
      j = this.jdField_a_of_type_Apeh.getLastVisiblePosition();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.HK.size())) {
        return;
      }
      Object localObject = (apbr)this.HK.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (apei)this.nB.get(((apbr)localObject).Id);
        if (localObject != null)
        {
          ((apei)localObject).d(this.mTroopUin, this.mApp);
          ((apei)localObject).c(this.mTroopUin, this.mApp);
        }
      }
      j = 0;
      i = 0;
    }
  }
  
  public int getCount()
  {
    return this.HK.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.HK.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    if (paramInt >= this.HK.size()) {
      QLog.i(TAG, 1, "getView: error. position[" + paramInt + "] fileListSize[" + this.HK.size() + "]");
    }
    apbr localapbr = (apbr)this.HK.get(paramInt);
    if (paramView == null)
    {
      apei localapei = new apei(this.mApp, this.mContext, this.mTroopUin, 2131561056, this.cYl);
      localapei.a(this);
      paramView = localapei.convertView;
      if (paramView == null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      paramView.setTag(localapei);
      localObject = localapei;
    }
    for (;;)
    {
      label157:
      this.nB.put(localapbr.Id, localObject);
      if (localObject != null)
      {
        ((apei)localObject).b = localapbr;
        ((apei)localObject).setSelectMode(this.cQe);
        ((apei)localObject).c(this.mTroopUin, this.mApp);
        if ((!this.cQe) || (!b(localapbr))) {
          break label285;
        }
      }
      label285:
      for (boolean bool = true;; bool = false)
      {
        ((apei)localObject).Rx(bool);
        ((apei)localObject).a(this.mTroopUin, this.mContext, this.mApp, this.mScrolling);
        localObject = paramView;
        break;
        localObject = paramView.getTag();
        if (!(localObject instanceof apei)) {
          break label291;
        }
        localObject = (apei)localObject;
        break label157;
      }
      label291:
      localObject = null;
    }
  }
  
  public List<apbr> gy()
  {
    return this.HL;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.cPm)
      {
        this.mScrolling = false;
        dXH();
      }
    }
  }
  
  public void j(apbr paramapbr)
  {
    if ((paramapbr.Status == 2) || (paramapbr.Status == 3)) {
      return;
    }
    int j = this.HK.size();
    apbr localapbr = (apbr)this.jdField_a_of_type_Apsf.nO.get(paramapbr.mParentId);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.HK.get(i) == null) || (!((apbr)this.HK.get(i)).mFileId.equals(paramapbr.mFileId))) {
          break label451;
        }
        apsf.a locala = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get(this.aEG + this.aqC);
        if (locala == null) {
          break label451;
        }
        if ((locala.BE != null) && (locala.nR != null))
        {
          locala.nR.remove(((apbr)this.HK.get(i)).mFileId);
          if (i >= locala.BE.size()) {
            break label421;
          }
          paramapbr = (apbr)locala.BE.remove(i);
          if ((paramapbr != null) && (paramapbr.Status != 12) && (localapbr != null)) {
            localapbr.dTl -= 1;
          }
          if ((paramapbr != null) && (paramapbr.Status != 12)) {
            locala.a = null;
          }
          this.cPU = false;
          a(locala.BE, locala.mIsEnd, 0, false);
        }
      }
      for (;;)
      {
        if ((localapbr == null) || (!"/".equals(this.aEG)) || (this.aqC != 0L) || (!localapbr.cPN)) {
          break label449;
        }
        localapbr.setModifyTime((int)NetConnInfoCenter.getServerTime());
        paramapbr = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get(localapbr.mParentId + this.aqC);
        if (paramapbr == null) {
          break;
        }
        if (paramapbr.BE != null)
        {
          paramapbr.BE.remove(localapbr);
          paramapbr.BE.add(0, localapbr);
        }
        paramapbr.a = null;
        a(paramapbr.BE, paramapbr.mIsEnd, 0, false);
        return;
        label421:
        QLog.e(TAG, 1, "<TroopFile> onDelete remove has err.index>size" + i);
      }
      label449:
      break;
      label451:
      i += 1;
    }
  }
  
  public void jP(int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool = aqiw.isNetworkAvailable(this.mContext);
    if ((bool) && (this.jdField_a_of_type_Apsf.d(paramInt1, this.aEG, this.aqC)))
    {
      paramInt1 = 1;
      localObject = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get(this.aEG + this.aqC);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((apsf.a)localObject).BE;; localObject = null)
    {
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (!bool)
        {
          Fk(0);
          a((List)localObject, true, paramInt2, true);
        }
        return;
        paramInt1 = 0;
        break;
      }
      if (bool)
      {
        if (paramInt1 != 0) {}
        for (paramInt1 = i;; paramInt1 = 2)
        {
          Fk(paramInt1);
          return;
        }
      }
      Fk(1);
      apsv.A(this.mApp, this.mTroopUin);
      return;
    }
  }
  
  public void k(apbr paramapbr)
  {
    if (paramapbr == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          apei localapei;
          do
          {
            return;
            switch (paramapbr.Status)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.aEG.equals(paramapbr.mParentId)) && (this.aqC == 0L)) {
                break label146;
              }
              localapei = (apei)this.nB.get(paramapbr.Id);
            }
          } while ((localapei == null) || (!localapei.b.Id.equals(paramapbr.Id)));
          localapei.b = paramapbr;
          localapei.a(this.mTroopUin, this.mContext, this.mApp, this.mScrolling);
          paramapbr = (apbr)this.jdField_a_of_type_Apsf.nO.get(paramapbr.mParentId);
        } while (paramapbr == null);
        paramapbr = (apei)this.nB.get(paramapbr.Id);
      } while (paramapbr == null);
      paramapbr.a(this.mTroopUin, this.mContext, this.mApp, this.mScrolling);
      return;
    } while (this.nB.remove(paramapbr.Id) == null);
    this.cPU = false;
    notifyDataSetChanged();
  }
  
  public void l(apbr paramapbr) {}
  
  public void m(apbr paramapbr)
  {
    Object localObject;
    apsf.a locala;
    if ((paramapbr.IsNewStatus) && (paramapbr.Status == 6))
    {
      localObject = (apbr)this.jdField_a_of_type_Apsf.nO.get(paramapbr.mParentId);
      if ((localObject == null) || (!this.aEG.equals(((apbr)localObject).mParentId)) || (!((apbr)localObject).cPN)) {
        break label251;
      }
      locala = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get(((apbr)localObject).mParentId + this.aqC);
      if ((locala != null) && (locala.BE != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(paramapbr.AX()))
      {
        if (paramapbr.aqT != 0L) {
          break;
        }
        paramapbr.cob = aqgv.a(this.mApp, this.mApp.getCurrentAccountUin(), this.mTroopUin + "", 1, 0);
      }
      locala.BE.remove(localObject);
      ((apbr)localObject).setModifyTime(paramapbr.Lg());
      ((apbr)localObject).dTl += 1;
      locala.BE.add(0, localObject);
      a(locala.BE, locala.mIsEnd, 0, false);
      locala.a = null;
      if (!this.aEG.equals(paramapbr.mParentId)) {
        break label618;
      }
      localObject = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get(paramapbr.mParentId + this.aqC);
    } while ((localObject == null) || (((apsf.a)localObject).BE == null));
    boolean bool = ((apsf.a)localObject).mIsEnd;
    int j = this.HK.size();
    label397:
    int i;
    if (TextUtils.isEmpty(paramapbr.AX()))
    {
      if (paramapbr.aqT == 0L) {
        paramapbr.cob = aqgv.a(this.mApp, this.mApp.getCurrentAccountUin(), this.mTroopUin + "", 1, 0);
      }
    }
    else
    {
      if (this.HK.size() == 0)
      {
        ((apsf.a)localObject).BE.add(paramapbr);
        ((apsf.a)localObject).nR.put(paramapbr.mFileId, paramapbr);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((apbr)this.HK.get(i)).cPN) && (paramapbr.Lg() >= ((apbr)this.HK.get(i)).Lg()))
        {
          ((apsf.a)localObject).BE.add(i, paramapbr);
          ((apsf.a)localObject).nR.put(paramapbr.mFileId, paramapbr);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((apsf.a)localObject).a = null;
        a(((apsf.a)localObject).BE, ((apsf.a)localObject).mIsEnd, 0, false);
        return;
        paramapbr.x(this.mApp, this.mTroopUin);
        break;
        paramapbr.x(this.mApp, this.mTroopUin);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((apsf.a)localObject).BE.add(paramapbr);
        ((apsf.a)localObject).nR.put(paramapbr.mFileId, paramapbr);
      }
      i += 1;
    }
    label618:
    this.cPU = false;
  }
  
  public void n(apbr paramapbr)
  {
    if ((paramapbr.cPN) && ("/".equals(this.aEG)) && (this.aqC == 0L))
    {
      paramapbr.Id = UUID.randomUUID();
      this.jdField_a_of_type_Apsf.nP.put(paramapbr.Id, paramapbr);
      this.jdField_a_of_type_Apsf.nO.put(paramapbr.mFileId, paramapbr);
      apsf.a locala = (apsf.a)this.jdField_a_of_type_Apsf.nQ.get(this.aEG + this.aqC);
      if (locala != null)
      {
        if ((locala.BE != null) && (locala.nR != null))
        {
          locala.BE.add(0, paramapbr);
          locala.nR.put(paramapbr.mFileId, paramapbr);
        }
        this.jdField_a_of_type_Apsf.nO.put(paramapbr.mFileId, paramapbr);
        a(locala.BE, locala.mIsEnd, 0, false);
        locala.a = null;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.blU = paramInt3;
    this.mLastVisibleIndex = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.cPm = true;
      QLog.e(TAG, 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      this.mHandler.sendEmptyMessageDelayed(1, 1000L);
      if ((this.mLastVisibleIndex == this.blU - 2) && (this.jdField_a_of_type_Apsf != null))
      {
        if (!this.jdField_a_of_type_Apsf.F(this.aEG, this.aqC)) {
          break label88;
        }
        if (this.jdField_a_of_type_Apeh != null) {
          this.jdField_a_of_type_Apeh.Fl(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Apeh.Fl(7);
      } while (apsv.a(this.mApp, this.mContext, this.mTroopUin) == 0);
      this.jdField_a_of_type_Apsf.G(this.aEG, this.aqC);
      return;
    }
    this.cPm = false;
    this.mScrolling = true;
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_Apsf != null) {
      this.jdField_a_of_type_Apsf.unregisterObserver(this);
    }
    if (this.HL != null) {
      this.HL.clear();
    }
  }
  
  public void setSelectMode(boolean paramBoolean)
  {
    this.cQe = paramBoolean;
    if ((!paramBoolean) && (this.HL != null)) {
      this.HL.clear();
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apeq
 * JD-Core Version:    0.7.0.1
 */