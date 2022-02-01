import android.app.Activity;
import android.app.Dialog;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.save.FileSaveRunnable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ajlu
  implements Handler.Callback, Manager
{
  private long Xt;
  private ajls a;
  private agjg b;
  private boolean bXU;
  private boolean bXV;
  protected xui c;
  private boolean cpj;
  private ConcurrentHashMap<String, ajlq> gk = new ConcurrentHashMap();
  private QQAppInterface mApp;
  private Handler mHandler;
  
  public ajlu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt, ajlp paramajlp)
  {
    ajlq localajlq = new ajlq();
    localajlq.result = -1;
    localajlq.jdField_a_of_type_Ajlp = paramajlp;
    localajlq.errorCode = paramInt;
    localajlq.errorMessage = ajlo.getErrorMsg(paramInt);
    c(localajlq);
  }
  
  private void a(agzj paramagzj)
  {
    if (paramagzj != null) {
      paramagzj.a(paramagzj.vX(), new ajlw(this, paramagzj));
    }
  }
  
  private void a(ajlp paramajlp)
  {
    String str;
    if (paramajlp != null)
    {
      str = "";
      switch (paramajlp.fileType)
      {
      }
    }
    for (;;)
    {
      MC(str);
      return;
      if (paramajlp.c != null)
      {
        str = a(paramajlp.c.a);
        continue;
        if (paramajlp.jdField_a_of_type_Angi != null)
        {
          str = a(paramajlp.jdField_a_of_type_Angi.b);
          continue;
          if (paramajlp.jdField_a_of_type_Agzj != null) {
            str = paramajlp.jdField_a_of_type_Agzj.vW();
          }
        }
      }
    }
  }
  
  private void a(ajlp paramajlp, int paramInt)
  {
    if ((paramajlp != null) && (paramajlp.c != null))
    {
      paramajlp = a(paramajlp.c.a);
      ajlq localajlq = a(paramajlp);
      if ((localajlq != null) && (!localajlq.isCompleted))
      {
        paramInt /= 100;
        localajlq.progress = paramInt;
        a(paramajlp, localajlq);
        c(localajlq, paramInt);
      }
    }
  }
  
  private void a(ajlp paramajlp, int paramInt1, int paramInt2, String paramString)
  {
    ajlq localajlq;
    if ((paramajlp != null) && (paramajlp.c != null) && (paramajlp.c.a != null))
    {
      String str = a(paramajlp.c.a);
      localajlq = a(str);
      if ((localajlq != null) && (localajlq.jdField_a_of_type_Ajlp != null) && (!localajlq.isCompleted))
      {
        localajlq.isCompleted = true;
        localajlq.result = paramInt1;
        localajlq.progress = 100;
        a(str, localajlq);
        if (paramInt1 != 0) {
          break label136;
        }
        paramajlp = paramajlp.c.a.getFilePath();
        a(paramajlp, Utils.Crc64String(paramajlp + NetConnInfoCenter.getServerTime()), localajlq);
      }
    }
    return;
    label136:
    localajlq.errorCode = paramInt2;
    localajlq.errorMessage = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    c(localajlq);
  }
  
  private void a(ajlp paramajlp, boolean paramBoolean)
  {
    String str;
    ajlq localajlq;
    if ((paramajlp != null) && (paramajlp.jdField_a_of_type_Agzj != null))
    {
      str = paramajlp.jdField_a_of_type_Agzj.vW();
      localajlq = a(str);
      if ((localajlq == null) || (localajlq.isCompleted)) {
        break label97;
      }
      localajlq.isCompleted = true;
      localajlq.progress = 100;
      a(str, localajlq);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramajlp.fileType)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramajlp.fileType);
      return;
    case 4: 
    case 6: 
      label97:
      paramajlp = paramajlp.jdField_a_of_type_Agzj.vX();
      str = Utils.Crc64String(paramajlp + NetConnInfoCenter.getServerTime());
      localajlq.result = 0;
      a(paramajlp, str, localajlq);
      return;
    }
    a(paramajlp.jdField_a_of_type_Agzj);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramajlp.fileType);
    }
    localajlq.result = -1;
    c(localajlq);
  }
  
  private void a(ajlq paramajlq, long paramLong)
  {
    Message localMessage = this.mHandler.obtainMessage(4);
    localMessage.obj = paramajlq;
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(Activity paramActivity, Dialog paramDialog)
  {
    if ((paramDialog != null) && (paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiRichMediaSaveManager", 2, "showDialogSafe exception: " + paramActivity.getMessage());
    }
  }
  
  private void a(String paramString1, String paramString2, ajlq paramajlq)
  {
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiRichMediaSaveManager", 2, "savePictureFile fail, errorCode = " + i);
        }
        if ((paramajlq != null) && (paramajlq.jdField_a_of_type_Ajlp != null))
        {
          paramajlq.result = -1;
          paramajlq.errorCode = i;
          paramajlq.errorMessage = ajlo.getErrorMsg(i);
          c(paramajlq);
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
        new File(acbn.oM).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = aqhq.estimateFileType(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(acbn.oM, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.mHandler, paramajlq, false));
        return;
      }
      i = 0;
    }
  }
  
  private boolean aqY()
  {
    if (!this.gk.isEmpty())
    {
      Iterator localIterator = this.gk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ajlq localajlq = (ajlq)((Map.Entry)localIterator.next()).getValue();
        if ((localajlq == null) || (!localajlq.isCompleted)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean aqZ()
  {
    if (!this.gk.isEmpty())
    {
      Iterator localIterator = this.gk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ajlq localajlq = (ajlq)((Map.Entry)localIterator.next()).getValue();
        if ((localajlq != null) && (localajlq.djL == 1) && (!localajlq.isCompleted)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(ajlp paramajlp)
  {
    if (paramajlp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new ajlp());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramajlp.fileType);
    }
    String str;
    switch (paramajlp.fileType)
    {
    default: 
      return;
    case 1: 
      if (paramajlp.c != null)
      {
        str = a(paramajlp.c.a);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramajlp.c.b(new ajmd(this, str, paramajlp));
        akxj.a(paramajlp.c, this.mApp);
        return;
      }
      a(10007, paramajlp);
      return;
    case 2: 
      if (paramajlp.jdField_a_of_type_Angi != null)
      {
        str = a(paramajlp.jdField_a_of_type_Angi.b);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramajlp.jdField_a_of_type_Angi.b(new ajme(this, str, paramajlp));
        anfr.a(paramajlp.jdField_a_of_type_Angi, this.mApp);
        return;
      }
      a(10007, paramajlp);
      return;
    case 3: 
      if (paramajlp.jdField_a_of_type_Angi != null)
      {
        str = a(paramajlp.jdField_a_of_type_Angi.b);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramajlp.jdField_a_of_type_Angi.cFr = true;
        paramajlp.jdField_a_of_type_Angi.a = new ajmf(this, paramajlp, str);
        ((angd)this.mApp.getManager(95)).f(paramajlp);
        return;
      }
      a(10007, paramajlp);
      return;
    }
    if (paramajlp.jdField_a_of_type_Agzj != null)
    {
      str = paramajlp.jdField_a_of_type_Agzj.vW();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramajlp.jdField_a_of_type_Agzj.a(new ajmg(this, str, paramajlp));
      if (this.b != null) {
        this.b.a(paramajlp.jdField_a_of_type_Agzj.a());
      }
      paramajlp.jdField_a_of_type_Agzj.dkP();
      return;
    }
    a(10007, paramajlp);
  }
  
  private void b(ajlq paramajlq, int paramInt)
  {
    Message localMessage = this.mHandler.obtainMessage(6);
    localMessage.obj = paramajlq;
    localMessage.arg1 = paramInt;
    this.mHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, ajlq paramajlq)
  {
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiRichMediaSaveManager", 2, "saveShortVideoFile fail, errorCode = " + i);
        }
        if ((paramajlq != null) && (paramajlq.jdField_a_of_type_Ajlp != null))
        {
          paramajlq.result = -1;
          paramajlq.errorCode = i;
          paramajlq.errorMessage = ajlo.getErrorMsg(i);
          c(paramajlq);
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
        if (VersionUtils.isrFroyo()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(acbn.beb))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.nr(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.mHandler, paramajlq, false));
          return;
        }
      }
      i = 0;
    }
  }
  
  private boolean b(ajlp paramajlp)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramajlp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramajlp.fileType)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramajlp.c == null) || (paramajlp.c.a == null) || (paramajlp.c.j == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramajlp.c.j != null) && (paramajlp.c.j.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.mApp.a().a(aooi.o(paramajlp.c.j.md5, paramajlp.c.j.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof aoji)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (aoji)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((aoji)localObject).b(new ajma(this, paramajlp));
      continue;
      if ((paramajlp.jdField_a_of_type_Angi == null) || (paramajlp.jdField_a_of_type_Angi.b == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.mApp.a().a(paramajlp.jdField_a_of_type_Angi.b.peerUin, paramajlp.jdField_a_of_type_Angi.b.uniseq);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof aoji)) {
        break label74;
      }
      localObject = (aoji)localObject;
      if ((((aoji)localObject).h != null) && ((((aoji)localObject).h.mFileType == 7) || (((aoji)localObject).h.mFileType == 16) || (((aoji)localObject).h.mFileType == 18)))
      {
        ((aoji)localObject).cancel();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((aoji)localObject).b(new ajmb(this, paramajlp));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramajlp.jdField_a_of_type_Agzj == null) {
        break label74;
      }
      bool2 = paramajlp.jdField_a_of_type_Agzj.amI();
      bool1 = bool2;
      if (bool2)
      {
        paramajlp.jdField_a_of_type_Agzj.a(new ajmc(this, paramajlp));
        bool1 = bool2;
        if (this.b != null)
        {
          this.b.a(paramajlp.jdField_a_of_type_Agzj.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(ajlp paramajlp)
  {
    if (paramajlp != null) {}
    switch (paramajlp.fileType)
    {
    default: 
      return;
    case 1: 
      a(paramajlp, 0, 0, "");
      return;
    case 2: 
    case 3: 
      b(paramajlp, 0, 0, "");
      return;
    }
    a(paramajlp, true);
  }
  
  private void c(ajlq paramajlq)
  {
    Message localMessage = this.mHandler.obtainMessage(2);
    localMessage.obj = paramajlq;
    this.mHandler.sendMessage(localMessage);
  }
  
  private void c(ajlq paramajlq, int paramInt)
  {
    if (paramajlq != null)
    {
      paramajlq.progress = paramInt;
      d(paramajlq, paramInt);
    }
  }
  
  private void d(ajlq paramajlq, int paramInt)
  {
    Iterator localIterator = this.gk.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      ajlq localajlq = (ajlq)((Map.Entry)localIterator.next()).getValue();
      if ((localajlq != null) && (localajlq.jdField_a_of_type_Ajlp != null)) {
        switch (localajlq.jdField_a_of_type_Ajlp.fileType)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localajlq.jdField_a_of_type_Ajlp.c != null) && (localajlq.jdField_a_of_type_Ajlp.c.j != null)) {
          if (localajlq.isCompleted)
          {
            l += localajlq.jdField_a_of_type_Ajlp.c.j.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localajlq.jdField_a_of_type_Ajlp.c.j.size;
            l = (localajlq.progress / 100.0F * f2 + f1);
            continue;
            if ((localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi != null) && (localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.o != null)) {
              if (localajlq.isCompleted)
              {
                l += localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.o.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.o.videoFileSize;
                l = (localajlq.progress / 100.0F * f2 + f1);
                continue;
                if (localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Agzj != null) {
                  if (localajlq.isCompleted)
                  {
                    l += localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Agzj.gb();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Agzj.gb();
                    l = (localajlq.progress / 100.0F * f2 + f1);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (this.Xt > 0L) {}
    for (paramInt = (int)(100L * l / this.Xt);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "calculateWholeProgress totalProgress = " + paramInt);
      }
      paramajlq.djL = 0;
      b(paramajlq, paramInt);
      return;
    }
  }
  
  private void dyg()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveBegin");
    }
    this.cpj = true;
    this.Xt = gq();
    if (this.a != null) {
      this.a.bKd();
    }
  }
  
  private void dyh()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.a != null) {
      this.a.bKe();
    }
    this.cpj = false;
    this.Xt = 0L;
  }
  
  private void dyi()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.a != null) {
      this.a.bKf();
    }
  }
  
  private void dyj()
  {
    Iterator localIterator1 = this.gk.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      ajlq localajlq = (ajlq)localEntry.getValue();
      if ((localajlq != null) && (localajlq.jdField_a_of_type_Ajlp != null) && (localajlq.djL == 1))
      {
        Iterator localIterator2 = localajlq.jdField_a_of_type_Ajlp.ak.iterator();
        while (localIterator2.hasNext()) {
          ((ajlt)localIterator2.next()).bKe();
        }
        localajlq.djL = 0;
        a((String)localEntry.getKey(), localajlq);
      }
    }
  }
  
  private void dyk()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelDownloading");
    }
    if (this.gk.isEmpty()) {
      return;
    }
    Iterator localIterator = this.gk.entrySet().iterator();
    label39:
    ajlq localajlq;
    aqoi localaqoi;
    while (localIterator.hasNext())
    {
      localajlq = (ajlq)((Map.Entry)localIterator.next()).getValue();
      if ((localajlq != null) && (localajlq.jdField_a_of_type_Ajlp != null)) {
        switch (localajlq.jdField_a_of_type_Ajlp.fileType)
        {
        default: 
          break;
        case 1: 
          if ((localajlq.jdField_a_of_type_Ajlp.c != null) && (localajlq.jdField_a_of_type_Ajlp.c.j != null))
          {
            localaqoi = this.mApp.a().a(aooi.o(localajlq.jdField_a_of_type_Ajlp.c.j.md5, localajlq.jdField_a_of_type_Ajlp.c.j.uuid, 131075));
            if (localaqoi != null) {
              break label406;
            }
            localaqoi = this.mApp.a().a(aooi.o(localajlq.jdField_a_of_type_Ajlp.c.j.md5, localajlq.jdField_a_of_type_Ajlp.c.j.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localaqoi instanceof aoji)) {
        break label39;
      }
      ((aoji)localaqoi).cancel();
      break label39;
      if ((localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi != null) && (localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.b != null)) {}
      localaqoi = this.mApp.a().a(localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.b.peerUin, localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.b.uniseq);
      if (!(localaqoi instanceof aoji)) {
        break label39;
      }
      ((aoji)localaqoi).cancel();
      break label39;
      if ((localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi == null) || (localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.o == null)) {
        break label39;
      }
      ((angd)this.mApp.getManager(95)).g(localajlq.jdField_a_of_type_Ajlp);
      break label39;
      if (localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Agzj == null) {
        break label39;
      }
      localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Agzj.dkQ();
      break label39;
      break;
    }
  }
  
  private void dym()
  {
    if (!this.gk.isEmpty())
    {
      Iterator localIterator = this.gk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ajlq localajlq = (ajlq)((Map.Entry)localIterator.next()).getValue();
        if ((localajlq != null) && (localajlq.jdField_a_of_type_Ajlp != null)) {
          localajlq.jdField_a_of_type_Ajlp.ak.clear();
        }
      }
    }
  }
  
  private void e(ajlp paramajlp)
  {
    if (paramajlp != null)
    {
      paramajlp = paramajlp.ak.iterator();
      while (paramajlp.hasNext()) {
        ((ajlt)paramajlp.next()).bKe();
      }
    }
  }
  
  private void e(ajlq paramajlq)
  {
    HashMap localHashMap;
    if (paramajlq != null)
    {
      localHashMap = new HashMap();
      if (paramajlq.djL != 1) {
        break label69;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramajlq.result != 0) {
        break label83;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label69:
      localHashMap.put("isMultiSave", "0");
      break;
      label83:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramajlq.errorCode));
      localHashMap.put("isSuccess", paramajlq.errorMessage);
    }
  }
  
  private void f(ajlq paramajlq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramajlq != null)
    {
      d(paramajlq);
      if ((paramajlq.jdField_a_of_type_Ajmh != null) && (this.c != null)) {
        this.c.b(paramajlq.jdField_a_of_type_Ajmh.id, paramajlq.jdField_a_of_type_Ajmh.subId, paramajlq.jdField_a_of_type_Ajmh.type, paramajlq.jdField_a_of_type_Ajmh.result, paramajlq.jdField_a_of_type_Ajmh.filePath, paramajlq.jdField_a_of_type_Ajmh.cpk);
      }
    }
  }
  
  private void g(ajlq paramajlq)
  {
    Message localMessage = this.mHandler.obtainMessage(5);
    localMessage.obj = paramajlq;
    this.mHandler.sendMessage(localMessage);
  }
  
  private long gq()
  {
    if (!this.gk.isEmpty())
    {
      this.Xt = 0L;
      Iterator localIterator = this.gk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ajlq localajlq = (ajlq)((Map.Entry)localIterator.next()).getValue();
        if ((localajlq != null) && (localajlq.jdField_a_of_type_Ajlp != null)) {
          switch (localajlq.jdField_a_of_type_Ajlp.fileType)
          {
          default: 
            break;
          case 1: 
            if ((localajlq.jdField_a_of_type_Ajlp.c != null) && (localajlq.jdField_a_of_type_Ajlp.c.j != null)) {
              this.Xt += localajlq.jdField_a_of_type_Ajlp.c.j.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi != null) && (localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.o != null)) {
              this.Xt += localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Angi.o.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Agzj != null) {
              this.Xt += localajlq.jdField_a_of_type_Ajlp.jdField_a_of_type_Agzj.gb();
            }
            break;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "getTotalFileLength totalFileLength = " + this.Xt);
    }
    return this.Xt;
  }
  
  private void ly(List<ajlp> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      d((ajlp)paramList.next());
    }
  }
  
  public void MC(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.gk.remove(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("MultiRichMediaSaveManager", 2, "removeFileSaveResult exception = " + paramString.getMessage());
    }
  }
  
  public boolean S(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      paramChatMessage = a(h(paramChatMessage));
      return (paramChatMessage != null) && (paramChatMessage.djL == 1) && (!paramChatMessage.isCompleted) && (paramChatMessage.progress < 100);
    }
    return false;
  }
  
  public ajlq a(String paramString)
  {
    return (ajlq)this.gk.get(paramString);
  }
  
  public String a(akxl paramakxl)
  {
    if (paramakxl != null) {
      return paramakxl.peerUin + paramakxl.uniseq;
    }
    return "";
  }
  
  public String a(anfu paramanfu)
  {
    if (paramanfu != null) {
      return paramanfu.peerUin + paramanfu.uniseq;
    }
    return "";
  }
  
  public void a(ajls paramajls)
  {
    this.a = paramajls;
  }
  
  public void a(String paramString, ajlq paramajlq)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.gk.put(paramString, paramajlq);
    }
  }
  
  public void a(xui paramxui)
  {
    this.c = paramxui;
  }
  
  public boolean a(ajlp paramajlp)
  {
    boolean bool2 = true;
    if (paramajlp == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramajlp.fileType)
      {
      default: 
        return false;
      }
    } while ((paramajlp.c == null) || (paramajlp.c.j == null));
    Object localObject = paramajlp.c.j.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((akxl)localObject).getFilePath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramajlp.c.j.size))
        {
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("MultiRichMediaSaveManager", 2, "isFileExist picture exists");
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if (paramajlp.jdField_a_of_type_Angi == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramajlp.jdField_a_of_type_Angi.o, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramajlp.jdField_a_of_type_Angi.o == null) || (((File)localObject).length() != paramajlp.jdField_a_of_type_Angi.o.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramajlp.jdField_a_of_type_Agzj == null) {
        break;
      }
      return paramajlp.jdField_a_of_type_Agzj.checkFileExist();
    }
  }
  
  public boolean ar(List<ajlp> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        ajlp localajlp = (ajlp)paramList.next();
        if (!a(localajlp))
        {
          switch (localajlp.fileType)
          {
          }
          for (;;)
          {
            break;
            if ((localajlp.c != null) && (localajlp.c.j != null))
            {
              l += localajlp.c.j.size;
              continue;
              if ((localajlp.jdField_a_of_type_Angi != null) && (localajlp.jdField_a_of_type_Angi.o != null))
              {
                l += localajlp.jdField_a_of_type_Angi.o.videoFileSize;
                continue;
                if (localajlp.jdField_a_of_type_Agzj != null) {
                  l += localajlp.jdField_a_of_type_Agzj.gb();
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isSaveNeedTips totalSaveSize = " + l);
      }
      return l > 29360128L;
    }
    return false;
  }
  
  public void at(List<ajlp> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new ajlq();
      paramList.result = -1;
      paramList.errorCode = 10006;
      paramList.errorMessage = ajlo.getErrorMsg(10006);
      d(paramList);
    }
    for (;;)
    {
      return;
      if (aqZ()) {
        dyj();
      }
      if ((paramBoolean) && (ar(paramList)))
      {
        dyi();
        return;
      }
      ly(paramList);
      dyg();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ajlp localajlp = (ajlp)paramList.next();
        if (a(localajlp)) {
          c(localajlp);
        } else if (!b(localajlp)) {
          b(localajlp);
        }
      }
    }
  }
  
  public void b(ajlp paramajlp, int paramInt1, int paramInt2, String paramString)
  {
    ajlq localajlq;
    if ((paramajlp != null) && (paramajlp.jdField_a_of_type_Angi != null) && (paramajlp.jdField_a_of_type_Angi.b != null))
    {
      String str = a(paramajlp.jdField_a_of_type_Angi.b);
      localajlq = a(str);
      if ((localajlq != null) && (localajlq.jdField_a_of_type_Ajlp != null) && (!localajlq.isCompleted))
      {
        localajlq.isCompleted = true;
        localajlq.result = paramInt1;
        localajlq.progress = 100;
        a(str, localajlq);
        if (paramInt1 != 0) {
          break label196;
        }
        paramajlp = new File(paramajlp.jdField_a_of_type_Angi.b.localPath);
        if ((!paramajlp.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramajlp.getAbsolutePath(), new StringBuilder().append(paramajlp.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localajlq);
      }
    }
    return;
    label196:
    localajlq.errorCode = paramInt2;
    localajlq.errorMessage = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    c(localajlq);
  }
  
  public void b(Activity paramActivity, List<ajlp> paramList)
  {
    a(paramActivity, aqha.a(paramActivity, 230, paramActivity.getString(2131718936), paramActivity.getString(2131718935), new ajlv(this, paramList), new ajlz(this)));
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo id = " + paramLong);
    }
    if (paramInt2 != 256)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo type = " + paramInt2);
      }
      return;
    }
    String str = h(paramMessageForShortVideo);
    ajlq localajlq = a(str);
    if (localajlq != null)
    {
      localajlq.isCompleted = true;
      localajlq.result = -1;
      a(str, localajlq);
      g(localajlq);
    }
    ((angd)this.mApp.getManager(95)).g(ajlp.b(this.mApp, paramMessageForShortVideo));
    MC(str);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + paramLong);
    }
    if (paramInt2 != 256) {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo type = " + paramInt2);
      }
    }
    ajlp localajlp;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localajlp = ajlp.b(this.mApp, paramMessageForShortVideo);
          if ((localajlp != null) && (localajlp.jdField_a_of_type_Angi != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              ajlq localajlq = new ajlq();
              localajlq.jdField_a_of_type_Ajlp = localajlp;
              localajlq.djL = 1;
              a(paramMessageForShortVideo, localajlq);
            }
            if ((!a(localajlp)) || (localajlp.jdField_a_of_type_Angi.o == null) || (this.c == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localajlp.jdField_a_of_type_Angi.o, "mp4");
            this.c.b(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localajlp.jdField_a_of_type_Angi.cFr = true;
    localajlp.jdField_a_of_type_Angi.a = new ajly(this, paramLong, localajlp, paramMessageForShortVideo, paramInt1, paramInt2);
    ((angd)this.mApp.getManager(95)).f(localajlp);
  }
  
  public void cZp()
  {
    this.a = null;
  }
  
  public void d(ajlp paramajlp)
  {
    if (paramajlp != null) {
      switch (paramajlp.fileType)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (paramajlp.c == null);
            localajlq = new ajlq();
            localajlq.jdField_a_of_type_Ajlp = paramajlp;
            paramajlp = a(paramajlp.c.a);
          } while (TextUtils.isEmpty(paramajlp));
          this.gk.put(paramajlp, localajlq);
          return;
        } while (paramajlp.jdField_a_of_type_Angi == null);
        localajlq = new ajlq();
        localajlq.jdField_a_of_type_Ajlp = paramajlp;
        paramajlp = a(paramajlp.jdField_a_of_type_Angi.b);
      } while (TextUtils.isEmpty(paramajlp));
      this.gk.put(paramajlp, localajlq);
      return;
      if (this.b == null)
      {
        this.b = new agjg(this.mApp);
        this.b.dgV();
      }
    } while (paramajlp.jdField_a_of_type_Agzj == null);
    ajlq localajlq = new ajlq();
    localajlq.jdField_a_of_type_Ajlp = paramajlp;
    this.gk.put(paramajlp.jdField_a_of_type_Agzj.vW(), localajlq);
  }
  
  public void d(ajlq paramajlq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramajlq != null)
    {
      if (paramajlq.djL == 1)
      {
        if (paramajlq.jdField_a_of_type_Ajlp != null)
        {
          Iterator localIterator = paramajlq.jdField_a_of_type_Ajlp.ak.iterator();
          while (localIterator.hasNext())
          {
            ajlt localajlt = (ajlt)localIterator.next();
            if (paramajlq.result == 0) {
              localajlt.a(paramajlq, 100);
            }
            localajlt.a(paramajlq);
          }
        }
        a(paramajlq.jdField_a_of_type_Ajlp);
        e(paramajlq);
      }
    }
    else {
      return;
    }
    if (this.a != null) {
      this.a.a(paramajlq);
    }
    this.cpj = false;
    this.Xt = 0L;
    this.gk.clear();
    e(paramajlq);
  }
  
  public void d(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + paramLong);
    }
    if (paramInt2 != 24) {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage type = " + paramInt2);
      }
    }
    do
    {
      return;
      try
      {
        akxq localakxq = akxj.a(7, 1);
        localakxq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = aoiz.getFilePath(aoop.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          ajlq localajlq = new ajlq();
          localajlq.jdField_a_of_type_Ajlp = ajlp.a(paramMessageForPic);
          localajlq.djL = 1;
          a(str2, localajlq);
        }
        localakxq.b(new ajlx(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        akxj.a(localakxq, this.mApp);
        return;
      }
      catch (Exception paramMessageForPic) {}
    } while (!QLog.isColorLevel());
    QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage exception = " + paramMessageForPic.getMessage());
  }
  
  public void d(List<ajlp> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "reportSaveMultiFile fileSaveReqList is empty!");
      }
    }
    label569:
    for (;;)
    {
      return;
      String str = "";
      int k;
      int j;
      int i;
      label74:
      int m;
      int n;
      switch (paramInt1)
      {
      default: 
        paramList = paramList.iterator();
        k = 0;
        j = 0;
        i = 0;
        paramInt1 = 0;
        if (paramList.hasNext()) {
          switch (((ajlp)paramList.next()).fileType)
          {
          default: 
            m = k;
            n = j;
            k = paramInt1;
            j = i;
            i = n;
            paramInt1 = m;
          }
        }
        break;
      case 1: 
      case 2: 
        for (;;)
        {
          m = j;
          n = k;
          k = paramInt1;
          j = i;
          i = m;
          paramInt1 = n;
          break label74;
          str = "0X8009F89";
          break;
          str = "0X8009F8A";
          break;
          m = i;
          n = paramInt1 + 1;
          paramInt1 = k;
          i = j;
          j = m;
          k = n;
          continue;
          n = i + 1;
          m = paramInt1;
          paramInt1 = k;
          i = j;
          j = n;
          k = m;
          continue;
          n = j + 1;
          j = i;
          m = paramInt1;
          paramInt1 = k;
          i = n;
          k = m;
          continue;
          n = k + 1;
          k = i;
          m = paramInt1;
          paramInt1 = n;
          i = j;
          j = k;
          k = m;
        }
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label569;
        }
        anot.a(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "reportSaveMultiFile reportTag = " + str + ", fromType = " + paramInt2 + ", picCount = " + paramInt1 + ", videoCount = " + i + ", filePicCount = " + j + ", fileVideoCount = " + k);
        return;
        paramInt2 = 1;
        continue;
        paramInt2 = 2;
        continue;
        paramInt2 = 3;
        continue;
        paramInt2 = 4;
      }
    }
  }
  
  public void dyf()
  {
    dyk();
    dyl();
  }
  
  public void dyl()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    dym();
    this.gk.clear();
    this.a = null;
    this.bXU = false;
    this.bXV = false;
    this.cpj = false;
    this.Xt = 0L;
    if (this.b != null)
    {
      this.b.dgW();
      this.b = null;
    }
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void e(ajlq paramajlq, int paramInt)
  {
    if (paramajlq != null) {
      if (paramajlq.djL == 1)
      {
        if (paramajlq.jdField_a_of_type_Ajlp != null)
        {
          Iterator localIterator = paramajlq.jdField_a_of_type_Ajlp.ak.iterator();
          while (localIterator.hasNext()) {
            ((ajlt)localIterator.next()).a(paramajlq, paramInt);
          }
        }
      }
      else if (this.a != null) {
        this.a.a(paramajlq, paramInt);
      }
    }
  }
  
  public void e(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = h(paramMessageForPic);
    ajlq localajlq = a(paramMessageForPic);
    if (localajlq != null)
    {
      localajlq.isCompleted = true;
      localajlq.result = -1;
      a(paramMessageForPic, localajlq);
      g(localajlq);
      MC(paramMessageForPic);
    }
  }
  
  public String h(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.frienduin + paramChatMessage.uniseq;
    }
    return "";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    ajlq localajlq;
    if ((paramMessage.obj instanceof ajlq))
    {
      localajlq = (ajlq)paramMessage.obj;
      if (localajlq.jdField_a_of_type_Ajlp == null) {}
    }
    switch (paramMessage.what)
    {
    default: 
    case 6: 
    case 5: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return true;
          e(localajlq, paramMessage.arg1);
          return true;
        } while (localajlq.djL != 1);
        e(localajlq.jdField_a_of_type_Ajlp);
        return true;
        if (localajlq.djL == 1)
        {
          f(localajlq);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.bXU = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localajlq.errorCode + ", errorMsg = " + localajlq.errorMessage);
          }
        }
        for (;;)
        {
          paramMessage = localajlq.jdField_a_of_type_Ajlp.ak.iterator();
          while (paramMessage.hasNext()) {
            ((ajlt)paramMessage.next()).a(localajlq);
          }
          this.bXV = true;
        }
      } while (!aqY());
      b(localajlq, 100);
      if ((this.bXV) && (!this.bXU)) {
        localajlq.result = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localajlq.result);
        }
        this.bXU = false;
        this.bXV = false;
        if (this.b != null)
        {
          this.b.dgW();
          this.b = null;
        }
        a(localajlq, 200L);
        return true;
        if ((this.bXU) && (!this.bXV)) {
          localajlq.result = -1;
        } else {
          localajlq.result = 3;
        }
      }
    case 3: 
      paramMessage = localajlq.jdField_a_of_type_Ajlp.ak.iterator();
      while (paramMessage.hasNext()) {
        ((ajlt)paramMessage.next()).b(localajlq);
      }
    }
    d(localajlq);
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "onDestroy");
    }
    dyh();
    dyk();
    dyl();
  }
  
  public void unregisterCallback()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlu
 * JD-Core Version:    0.7.0.1
 */