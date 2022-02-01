import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mvp.cloudfile.FeedListPresenter.1;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;

public class auhw
  extends augv
  implements auhk.f
{
  private HandlerThread E;
  private List<atiu> KP = new ArrayList();
  private List<PadInfo> KQ = new ArrayList();
  private List<atiu> KR = new ArrayList();
  atgd a;
  public auhk.g a;
  private long ayL;
  private long ayM;
  private long ayN;
  private long ayO;
  private HashSet<Object> bO = new HashSet();
  aulm c = new auhz(this);
  public Handler dW;
  private boolean diQ;
  private int erA;
  private Object fT;
  private List<atiu> fl = new ArrayList();
  private boolean hasmore = true;
  
  public auhw(QQAppInterface paramQQAppInterface, auhk.g paramg)
  {
    super(paramQQAppInterface, paramg);
    this.jdField_a_of_type_Atgd = new auhy(this);
    this.jdField_a_of_type_Auhk$g = paramg;
  }
  
  private void clearCacheData()
  {
    this.bO.clear();
    this.KP.clear();
    this.KQ.clear();
    this.KR.clear();
    this.fT = null;
    this.diQ = false;
    this.hasmore = true;
  }
  
  private void euW()
  {
    if ((!isComplete()) && (this.KR.size() < 10))
    {
      if (this.KR.size() > 0) {
        aaJ(2);
      }
    }
    else {
      return;
    }
    aaJ(1);
  }
  
  private void euY()
  {
    aull localaull = null;
    try
    {
      if (this.app != null) {
        localaull = (aull)this.app.getManager(372);
      }
      if (localaull != null)
      {
        if (QLog.isColorLevel()) {
          this.ayO = System.currentTimeMillis();
        }
        this.KQ = localaull.hp();
        athu.nJ(this.KQ);
        if (QLog.isColorLevel())
        {
          long l = System.currentTimeMillis();
          QLog.d("FeedListPresenter", 2, "getPadListData time= " + String.valueOf(l - this.ayO) + "ms");
        }
      }
      return;
    }
    finally {}
  }
  
  private void euZ()
  {
    if (this.app != null) {}
    for (Object localObject = (ateh)this.app.getBusinessHandler(180);; localObject = null)
    {
      if (this.erA == 2) {
        if ((this.KP.size() < 14) && (this.hasmore)) {
          if (!this.bO.contains(this.fT))
          {
            this.bO.add(this.fT);
            if (localObject != null)
            {
              if (QLog.isColorLevel()) {
                this.ayN = System.currentTimeMillis();
              }
              ((ateh)localObject).a(this.erA, this.fT, null);
            }
          }
        }
      }
      while (localObject == null)
      {
        do
        {
          return;
          localObject = W();
        } while ((localObject == null) || (!(localObject instanceof PadInfo)));
        localObject = this.dW.obtainMessage();
        ((Message)localObject).what = 101;
        this.dW.sendMessage((Message)localObject);
        return;
        localObject = this.dW.obtainMessage();
        ((Message)localObject).what = 101;
        this.dW.sendMessage((Message)localObject);
        return;
      }
      if (QLog.isColorLevel()) {
        this.ayM = System.currentTimeMillis();
      }
      ((ateh)localObject).a(this.erA, null, null);
      return;
    }
  }
  
  private void nU(List<atiu> paramList)
  {
    if (paramList.size() > 0)
    {
      this.KP.addAll(paramList);
      this.fT = paramList.get(paramList.size() - 1);
    }
  }
  
  public void VO(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      if (i < 14) {}
      try
      {
        if ((this.KP.size() == 0) && (this.KQ.size() == 0))
        {
          ThreadManager.getUIHandler().post(new FeedListPresenter.1(this, paramBoolean));
          return;
        }
        if ((this.KP.size() == 0) && (this.KQ.size() > 0))
        {
          this.KR.add(this.KQ.get(0));
          this.KQ.remove(0);
        }
        else if ((this.KP.size() > 0) && (this.KQ.size() == 0))
        {
          this.KR.add(this.KP.get(0));
          this.KP.remove(0);
        }
      }
      finally {}
      if (auqb.c(this.KP.get(0)) > ((PadInfo)this.KQ.get(0)).getSortTime())
      {
        this.KR.add(this.KP.get(0));
        this.KP.remove(0);
      }
      else
      {
        this.KR.add(this.KQ.get(0));
        this.KQ.remove(0);
      }
      i += 1;
    }
  }
  
  public Object W()
  {
    if (!this.KR.isEmpty()) {
      return this.KR.get(this.KR.size() - 1);
    }
    return null;
  }
  
  public void aaJ(int paramInt)
  {
    this.erA = paramInt;
    if (this.erA == 0)
    {
      Message localMessage = this.dW.obtainMessage();
      localMessage.what = 105;
      this.dW.sendMessage(localMessage);
    }
    euZ();
  }
  
  public void gO(String paramString, int paramInt)
  {
    aull localaull = (aull)this.app.getManager(372);
    int i = 0;
    boolean bool1 = false;
    if (i < this.KR.size())
    {
      Object localObject1;
      Object localObject2;
      boolean bool2;
      if ((this.KR.get(i) instanceof FileManagerEntity))
      {
        localObject1 = (FileManagerEntity)this.KR.get(i);
        localObject2 = ((FileManagerEntity)localObject1).getPadUrl();
        bool2 = bool1;
        if (localObject2 != null)
        {
          bool2 = bool1;
          if (((String)localObject2).equals(paramString))
          {
            bool2 = bool1;
            if (localaull != null)
            {
              localObject2 = localaull.a((String)localObject2, paramInt);
              bool2 = bool1;
              if (localObject2 != null)
              {
                ((FileManagerEntity)localObject1).cloudFile.onlineFileExt.permissionType = athu.kZ(((PadInfo)localObject2).policy);
                bool2 = true;
                atgi.a().updateOnlineInfo(((FileManagerEntity)localObject1).cloudFile.onlineFileExt);
              }
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break;
        bool2 = bool1;
        if ((this.KR.get(i) instanceof PadInfo))
        {
          localObject1 = (PadInfo)this.KR.get(i);
          localObject2 = ((PadInfo)localObject1).pad_url;
          bool2 = bool1;
          if (localObject2 != null)
          {
            bool2 = bool1;
            if (((String)localObject2).equals(paramString))
            {
              bool2 = bool1;
              if (localaull != null)
              {
                localObject2 = localaull.a((String)localObject2, paramInt);
                bool2 = bool1;
                if (localObject2 != null)
                {
                  ((PadInfo)localObject1).policy = ((PadInfo)localObject2).policy;
                  bool2 = bool1;
                }
              }
            }
          }
        }
      }
    }
    if ((this.jdField_a_of_type_Auhk$g != null) && (this.jdField_a_of_type_Auhk$g.Pp())) {
      this.jdField_a_of_type_Auhk$g.f(bool1, 3, isComplete());
    }
  }
  
  public List<atiu> hk()
  {
    return this.KR;
  }
  
  public boolean isComplete()
  {
    return (this.KP.size() == 0) && (this.KQ.size() == 0) && (!this.hasmore);
  }
  
  protected void onCreate()
  {
    this.app.addObserver(this.jdField_a_of_type_Atgd);
    this.app.addObserver(this.c);
    this.E = new HandlerThread("syncCacheList");
    this.E.start();
    this.dW = new auhx(this, this.E.getLooper());
  }
  
  protected void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
    this.app.removeObserver(this.c);
    clearCacheData();
    if (this.E != null) {
      this.E.quit();
    }
    this.dW.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhw
 * JD-Core Version:    0.7.0.1
 */