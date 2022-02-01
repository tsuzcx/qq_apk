import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.2;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.3;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.4;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.5;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.6;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppUIPresenter.7;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class mro
{
  private mtg.b a;
  private ADVideoAppDownloadManager b;
  private Context mContext;
  public boolean resumeDownload;
  
  public mro(mtg.b paramb, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.a = paramb;
    this.b = paramADVideoAppDownloadManager;
    this.mContext = paramContext;
  }
  
  private boolean DW()
  {
    return (this.a.lM != null) && (this.a.B != null);
  }
  
  private boolean DX()
  {
    return (this.a != null) && (this.a.bq.getVisibility() == 0);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, mrm parammrm)
  {
    if ((paramDownloadInfo == null) || (parammrm == null) || (TextUtils.isEmpty(paramDownloadInfo.packageName)) || (TextUtils.isEmpty(paramDownloadInfo.appId)) || (TextUtils.isEmpty(parammrm.mPackageName)) || (TextUtils.isEmpty(parammrm.mPackageName))) {
      return false;
    }
    return paramDownloadInfo.packageName.equals(parammrm.mPackageName);
  }
  
  private void d(mrm parammrm, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, parammrm, paramInt));
        do
        {
          return;
        } while (parammrm == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + parammrm.mPackageName);
        }
        localTextView = this.a.rp;
        localProgressBar = this.a.A;
        localImageView = this.a.jJ;
      } while ((localProgressBar == null) || (localTextView == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      parammrm.mState = 4;
      localProgressBar.setProgress(paramInt);
      parammrm.aTP = paramInt;
      if (DW()) {
        this.a.B.setProgress(paramInt);
      }
      this.resumeDownload = false;
    } while (this.b == null);
    this.b.d(parammrm);
  }
  
  private void i(mrm parammrm)
  {
    String str1 = parammrm.mPackageName;
    String str2 = parammrm.mAppID;
    String str3 = parammrm.mDownloadUrl;
    parammrm = parammrm.mAppName;
    Bundle localBundle = new Bundle();
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 5);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, str1);
    localBundle.putString(aryv.PARAM_SNG_APPID, str2);
    localBundle.putString(aryv.PARAM_URL, str3);
    localBundle.putString(aryv.PARAM_APPNAME, parammrm);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + parammrm + ", url:" + str3);
    }
    aryr.G(localBundle);
  }
  
  private void k(mrm parammrm)
  {
    if ((this.a.A != null) && (parammrm != null) && (parammrm.mState == 4)) {
      this.b.a(parammrm, parammrm.aTP);
    }
  }
  
  private void l(mrm parammrm)
  {
    if ((this.a.A != null) && (parammrm != null)) {
      this.b.a(parammrm, 0);
    }
  }
  
  private void launchApp(Context paramContext, String paramString)
  {
    jzk.launchApp(paramContext, paramString);
  }
  
  private void o(mrm parammrm)
  {
    p(parammrm);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, mrm parammrm)
  {
    if (a(paramDownloadInfo, parammrm)) {
      parammrm.mState = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, mrm parammrm)
  {
    if (a(paramDownloadInfo, parammrm)) {
      j(parammrm);
    }
  }
  
  public void a(String paramString1, String paramString2, mrm parammrm)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    if (a(localDownloadInfo, parammrm)) {
      m(parammrm);
    }
  }
  
  public void a(List<DownloadInfo> paramList, mrm parammrm)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, parammrm))
        {
          parammrm.mState = 3;
          if ((TextUtils.isEmpty(parammrm.mDownloadUrl)) && (!TextUtils.isEmpty(localDownloadInfo.urlStr))) {
            parammrm.mDownloadUrl = localDownloadInfo.urlStr;
          }
          if (!this.resumeDownload)
          {
            this.resumeDownload = true;
            aRA();
          }
          e(parammrm, localDownloadInfo.progress);
        }
      }
    }
  }
  
  public void aRA()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this));
    }
    while ((this.a == null) || (!this.resumeDownload)) {
      return;
    }
    this.a.aor = true;
    if ((this.a.lx != null) && (knd.c(this.a.a.d))) {
      this.a.lx.setVisibility(8);
    }
    for (;;)
    {
      this.a.rm.setVisibility(8);
      this.a.lv.setVisibility(8);
      this.a.e.setVisibility(8);
      ImageView localImageView = this.a.jJ;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      if (!DW()) {
        break;
      }
      this.a.lM.setVisibility(0);
      this.a.rv.setVisibility(8);
      return;
      if (this.a.lx != null) {
        this.a.lx.setVisibility(0);
      }
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo, mrm parammrm) {}
  
  public void b(String paramString1, String paramString2, mrm parammrm)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    if (a(localDownloadInfo, parammrm)) {
      o(parammrm);
    }
  }
  
  public void c(DownloadInfo paramDownloadInfo, mrm parammrm)
  {
    if (a(paramDownloadInfo, parammrm)) {
      p(parammrm);
    }
  }
  
  public void c(String paramString1, String paramString2, mrm parammrm) {}
  
  public void c(mrm parammrm, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, " updatUIByClick  cState = " + paramInt);
    }
    if (parammrm == null)
    {
      QLog.d("ADVideoAppUIPresenter", 1, "updatUIByClick cgdtAppBtnData == null");
      parammrm = this.a.A;
      parammrm = this.a.rp;
      parammrm = this.a.jJ;
      if (this.resumeDownload) {
        if (this.resumeDownload) {
          break label111;
        }
      }
      for (;;)
      {
        this.resumeDownload = bool;
        return;
        if (parammrm != null) {
          parammrm.setVisibility(8);
        }
        this.b.aRz();
        break;
        label111:
        bool = false;
      }
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.b.a(parammrm, 0);
      return;
    case 1: 
      launchApp(this.mContext, parammrm.mPackageName);
      return;
    case 3: 
      this.resumeDownload = false;
      j(parammrm);
      return;
    case 4: 
      this.resumeDownload = true;
      k(parammrm);
      return;
    case 5: 
      i(parammrm);
      return;
    }
    l(parammrm);
  }
  
  public void d(DownloadInfo paramDownloadInfo, mrm parammrm)
  {
    if (a(paramDownloadInfo, parammrm)) {
      n(parammrm);
    }
  }
  
  public void e(mrm parammrm, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    TextView localTextView;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, parammrm, paramInt));
      do
      {
        return;
      } while ((parammrm == null) || (parammrm.mState != 3));
      localTextView = this.a.rp;
      localProgressBar = this.a.A;
      localImageView = this.a.jJ;
    } while ((localTextView == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (DW()) {
      this.a.B.setProgress(paramInt);
    }
    parammrm.aTP = paramInt;
  }
  
  public void j(mrm parammrm)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, parammrm));
        do
        {
          return;
        } while (parammrm == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + parammrm.mPackageName);
        }
        localTextView = this.a.rp;
        localProgressBar = this.a.A;
        localImageView = this.a.jJ;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      parammrm.mState = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        parammrm.aTP = i;
      }
      localProgressBar.setProgress(i);
      if (this.b != null) {
        this.b.d(parammrm);
      }
    } while (!DW());
  }
  
  public void m(mrm parammrm)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, parammrm));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      do
      {
        return;
        localTextView = this.a.rp;
        localImageView = this.a.jJ;
      } while ((localTextView == null) || (parammrm == null) || (!parammrm.isValid()));
      parammrm.mState = 1;
    } while ((DW()) && (localImageView == null));
    if (DX())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130843559);
  }
  
  public void n(mrm parammrm)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, parammrm));
    }
    ImageView localImageView;
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      do
      {
        return;
        localTextView = this.a.rp;
        localProgressBar = this.a.A;
        localImageView = this.a.jJ;
      } while ((localTextView == null) || (localProgressBar == null) || (parammrm == null) || (!parammrm.isValid()));
      localProgressBar.setProgress(100);
      if (DW()) {
        this.a.B.setProgress(100);
      }
      parammrm.aTP = 100;
      parammrm.mState = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (DX())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130843559);
  }
  
  public void p(mrm parammrm)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.6(this, parammrm));
    }
    while ((this.a.rp == null) || (parammrm == null)) {
      return;
    }
    if (DW()) {}
    parammrm.mState = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mro
 * JD-Core Version:    0.7.0.1
 */