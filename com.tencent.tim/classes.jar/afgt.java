import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class afgt
  implements Handler.Callback, Manager
{
  private volatile ConcurrentLinkedQueue<afge> C = new ConcurrentLinkedQueue();
  private long Xt;
  private afgt.a a;
  private volatile CopyOnWriteArrayList<afge> aa = new CopyOnWriteArrayList();
  private boolean bXU;
  private boolean bXV;
  private volatile int cQL;
  private volatile int cQM;
  private QQAppInterface mApp;
  private Handler mHandler;
  
  public afgt(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2, afge paramafge)
  {
    this.cQL += 1;
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiEmotionSaveManager", 2, "realSaveEmo failed! errorCode = " + i);
        }
        if (paramafge != null)
        {
          paramafge.result = -1;
          paramafge.errorCode = i;
          paramafge.errorMessage = ajlo.getErrorMsg(i);
          paramString1 = this.mHandler.obtainMessage(2);
          paramString1.obj = paramafge;
          this.mHandler.sendMessage(paramString1);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!aqhq.fileExists(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        i = 0;
        Object localObject1 = paramString2;
        File localFile;
        do
        {
          if (i > 0) {
            localObject1 = paramString2 + "_" + i;
          }
          Object localObject2 = localObject1;
          if (!((String)localObject1).contains("."))
          {
            localObject2 = aqhq.estimateFileType(paramString1);
            localObject2 = (String)localObject1 + "." + (String)localObject2;
          }
          localFile = new File(afgd.oM, (String)localObject2);
          i += 1;
          localObject1 = localObject2;
        } while (localFile.exists());
        paramString2 = new File(paramString1);
        ThreadManager.getFileThreadHandler().post(new MultiEmotionSaveManager.1(this, localFile, paramString2, paramString1, paramafge));
        return;
      }
      i = 0;
    }
  }
  
  private void b(afge paramafge)
  {
    String str = System.nanoTime() + "";
    a(paramafge.emoPath, str, paramafge);
  }
  
  private void cZm()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "clearCatch");
    }
    this.C.clear();
    this.aa.clear();
    this.Xt = 0L;
    this.cQM = 0;
    this.bXU = false;
    this.bXV = false;
    this.cQL = 0;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  private void cZn()
  {
    if (this.a != null) {
      this.a.bKd();
    }
  }
  
  private void cZo()
  {
    if ((this.Xt == 0L) || (this.a == null)) {}
    int i;
    do
    {
      return;
      i = (int)(this.cQM * 100.0D / this.Xt);
      if (this.cQM == this.Xt) {
        i = 100;
      }
    } while (this.a == null);
    this.a.Mr(i);
  }
  
  public void a(afgt.a parama)
  {
    this.a = parama;
  }
  
  public void c(afge paramafge)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "saveComplete");
    }
    if (this.a != null) {
      this.a.a(paramafge);
    }
    cZm();
  }
  
  public void cZl()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "cancelMultiEmoSave");
    }
    cZm();
    if (this.a != null) {
      this.a.bKe();
    }
  }
  
  public void cZp()
  {
    this.a = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    afge localafge;
    if ((paramMessage.obj instanceof afge))
    {
      localafge = (afge)paramMessage.obj;
      if (localafge != null) {
        switch (paramMessage.what)
        {
        }
      }
    }
    do
    {
      return false;
      this.cQL -= 1;
      if (paramMessage.what == 2)
      {
        this.bXU = true;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localafge.errorCode + ", errorMsg = " + localafge.errorMessage);
        }
      }
      for (;;)
      {
        this.cQM += 1;
        cZo();
        paramMessage = (afge)this.C.poll();
        if (paramMessage == null) {
          break;
        }
        b(paramMessage);
        return false;
        this.bXV = true;
      }
    } while (this.cQL != 0);
    paramMessage = new afge();
    if (this.bXV) {
      paramMessage.result = 0;
    }
    for (;;)
    {
      c(paramMessage);
      return false;
      paramMessage.result = -1;
      paramMessage.errorCode = localafge.errorCode;
      paramMessage.errorMessage = localafge.errorMessage;
    }
  }
  
  public void jY(List<afmi> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList is empty!");
      }
      paramList = new afge();
      paramList.result = -1;
      paramList.errorCode = 10006;
      paramList.errorMessage = ajlo.getErrorMsg(10006);
      c(paramList);
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList count is :" + paramList.size());
      }
      cZm();
      paramList = paramList.iterator();
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (afmi)paramList.next();
        if ((localObject instanceof afmd))
        {
          localObject = (afmd)localObject;
          afge localafge = new afge();
          localafge.bDm = ((afmd)localObject).bnT;
          localafge.emoPath = ((afmd)localObject).path;
          this.aa.add(localafge);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MultiEmotionSaveManager", 2, "temp is not CustomEmoticonInfoBase class is " + localObject.getClass());
        }
      }
      if (this.aa.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList is empty!");
        }
        paramList = new afge();
        paramList.result = -1;
        paramList.errorCode = 10006;
        paramList.errorMessage = ajlo.getErrorMsg(10006);
        c(paramList);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList count is :" + this.aa.size());
      }
      cZn();
      this.Xt = this.aa.size();
      paramList = this.aa.iterator();
      while (paramList.hasNext())
      {
        localObject = (afge)paramList.next();
        if (this.cQL < 1) {
          b((afge)localObject);
        } else {
          this.C.add(localObject);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "onDestroy");
    }
    cZm();
  }
  
  public static abstract interface a
  {
    public abstract void Mr(int paramInt);
    
    public abstract void a(afge paramafge);
    
    public abstract void bKd();
    
    public abstract void bKe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgt
 * JD-Core Version:    0.7.0.1
 */