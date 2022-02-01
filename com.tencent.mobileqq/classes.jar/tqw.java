import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter.3;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter.4;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter.5;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter.7;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter.8;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class tqw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  private rog jdField_a_of_type_Rog;
  public boolean a;
  
  public tqw(rog paramrog, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.jdField_a_of_type_Rog = paramrog;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    nzq.a(paramContext, paramString);
  }
  
  private void a(ProgressBar paramProgressBar, TextView paramTextView, String paramString)
  {
    paramProgressBar.setProgress(0);
    paramTextView.setText(paramString);
    if (a())
    {
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Rog.l.setText(paramString);
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Rog == null) {
      return;
    }
    TextView localTextView1 = this.jdField_a_of_type_Rog.e;
    TextView localTextView2 = this.jdField_a_of_type_Rog.l;
    TextView localTextView3 = this.jdField_a_of_type_Rog.k;
    TextView localTextView4 = this.jdField_a_of_type_Rog.d;
    tph.a(localTextView1, paramString);
    tph.a(localTextView2, paramString);
    tph.a(localTextView3, paramString);
    tph.a(localTextView4, paramString);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Rog.p != null) && (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, tqt paramtqt)
  {
    if ((paramDownloadInfo == null) || (paramtqt == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramtqt.d)) || (TextUtils.isEmpty(paramtqt.d))) {
      return false;
    }
    return paramDownloadInfo.e.equals(paramtqt.d);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Rog != null) && (this.jdField_a_of_type_Rog.n.getVisibility() == 0);
  }
  
  private void c(tqt paramtqt, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ProgressBar localProgressBar;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, paramtqt, paramInt));
        do
        {
          return;
        } while (paramtqt == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramtqt.d);
        }
        localProgressBar = this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetProgressBar;
        localObject = this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetImageView;
      } while (localProgressBar == null);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      Object localObject = anzj.a(2131698840);
      tph.a(this.jdField_a_of_type_Rog.e, (String)localObject);
      paramtqt.jdField_a_of_type_Int = 4;
      localProgressBar.setProgress(paramInt);
      paramtqt.b = paramInt;
      if (a())
      {
        tph.a(this.jdField_a_of_type_Rog.l, (String)localObject);
        this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c(paramtqt);
  }
  
  private void e(tqt paramtqt)
  {
    String str1 = paramtqt.d;
    String str2 = paramtqt.jdField_a_of_type_JavaLangString;
    String str3 = paramtqt.c;
    paramtqt = paramtqt.e;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bjwo.k, 5);
    localBundle.putString(bjwo.f, str1);
    localBundle.putString(bjwo.b, str2);
    localBundle.putString(bjwo.j, str3);
    localBundle.putString(bjwo.l, paramtqt);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramtqt + ", url:" + str3);
    }
    bjwk.a(localBundle);
  }
  
  private void f(tqt paramtqt)
  {
    if ((this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramtqt != null) && (paramtqt.jdField_a_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramtqt, paramtqt.b);
    }
  }
  
  private void g(tqt paramtqt)
  {
    if ((this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramtqt != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramtqt, 0);
    }
  }
  
  private void h(tqt paramtqt)
  {
    tkk.a(paramtqt, new tqx(this, paramtqt));
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.8(this));
    }
    while ((this.jdField_a_of_type_Rog == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Rog.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidViewView != null)
    {
      if (!tqa.a(this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a)) {
        break label157;
      }
      this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      ImageView localImageView = this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      if (!a()) {
        break;
      }
      this.jdField_a_of_type_Rog.p.setVisibility(0);
      this.jdField_a_of_type_Rog.k.setVisibility(8);
      return;
      label157:
      this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, tqt paramtqt)
  {
    if (a(paramDownloadInfo, paramtqt)) {
      paramtqt.jdField_a_of_type_Int = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, tqt paramtqt)
  {
    if (a(paramDownloadInfo, paramtqt)) {
      a(paramtqt);
    }
  }
  
  public void a(String paramString1, String paramString2, tqt paramtqt)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramtqt)) {
      b(paramtqt);
    }
  }
  
  public void a(List<DownloadInfo> paramList, tqt paramtqt)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramtqt))
        {
          paramtqt.jdField_a_of_type_Int = 3;
          if ((TextUtils.isEmpty(paramtqt.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramtqt.c = localDownloadInfo.d;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            a();
          }
          b(paramtqt, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void a(tqt paramtqt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, paramtqt));
    }
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        return;
        if (paramtqt == null) {
          break;
        }
        tpx.a("ADVideoAppDownloadManager", "pauseDownloadUi " + paramtqt.d);
        localTextView = this.jdField_a_of_type_Rog.e;
        localProgressBar = this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      paramtqt.jdField_a_of_type_Int = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        paramtqt.b = i;
      }
      localProgressBar.setProgress(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c(paramtqt);
      }
      paramtqt = anzj.a(2131698842);
      tph.a(this.jdField_a_of_type_Rog.e, paramtqt);
    } while (!a());
    tph.a(this.jdField_a_of_type_Rog.l, paramtqt);
    return;
    tpx.a("ADVideoAppDownloadManager", "pauseDownloadUi : appDownloadData = null");
  }
  
  public void a(tqt paramtqt, int paramInt)
  {
    boolean bool = true;
    tpx.a("ADVideoAppDownloadManager", "updatUIByClick  cState = " + paramInt);
    if (paramtqt == null)
    {
      tpx.a("ADVideoAppDownloadManager", "updatUIByClick cgdtAppBtnData == null");
      paramtqt = this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetProgressBar;
      TextView localTextView = this.jdField_a_of_type_Rog.e;
      ImageView localImageView = this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        a(paramtqt, localTextView, anzj.a(2131698844));
        if (this.jdField_a_of_type_Boolean) {
          break label135;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
        if (localImageView != null) {
          localImageView.setVisibility(8);
        }
        a(paramtqt, localTextView, anzj.a(2131698843));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.e();
        break;
        label135:
        bool = false;
      }
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramtqt, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_AndroidContentContext, paramtqt.d);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      a(paramtqt);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(paramtqt);
      return;
    case 5: 
      e(paramtqt);
      return;
    }
    g(paramtqt);
  }
  
  public void b(DownloadInfo paramDownloadInfo, tqt paramtqt) {}
  
  public void b(String paramString1, String paramString2, tqt paramtqt)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramtqt)) {
      h(paramtqt);
    }
  }
  
  public void b(tqt paramtqt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, paramtqt));
      do
      {
        return;
      } while ((paramtqt == null) || (!paramtqt.a()));
      a(anzj.a(2131698851));
      paramtqt.jdField_a_of_type_Int = 1;
      paramtqt = this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetImageView;
    } while (paramtqt == null);
    if (b())
    {
      paramtqt.setVisibility(8);
      return;
    }
    paramtqt.setVisibility(0);
    paramtqt.setImageResource(2130842693);
  }
  
  public void b(tqt paramtqt, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, paramtqt, paramInt));
      do
      {
        return;
      } while ((paramtqt == null) || (paramtqt.jdField_a_of_type_Int != 3));
      localObject = this.jdField_a_of_type_Rog.e;
      localProgressBar = this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetProgressBar;
      localImageView = this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetImageView;
    } while ((localObject == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    Object localObject = anzj.a(2131698847) + paramInt + "%";
    tph.a(this.jdField_a_of_type_Rog.e, (String)localObject);
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (a())
    {
      tph.a(this.jdField_a_of_type_Rog.l, (String)localObject);
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    paramtqt.b = paramInt;
  }
  
  public void c(DownloadInfo paramDownloadInfo, tqt paramtqt)
  {
    if (a(paramDownloadInfo, paramtqt)) {
      d(paramtqt);
    }
  }
  
  public void c(String paramString1, String paramString2, tqt paramtqt) {}
  
  public void c(tqt paramtqt)
  {
    if (paramtqt == null) {}
    ImageView localImageView;
    do
    {
      ProgressBar localProgressBar;
      do
      {
        return;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, paramtqt));
          return;
        }
        localProgressBar = this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rog.jdField_c_of_type_AndroidWidgetImageView;
      } while ((localProgressBar == null) || (paramtqt == null) || (!paramtqt.a()));
      a(anzj.a(2131698839));
      localProgressBar.setProgress(100);
      if (a()) {
        this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
      paramtqt.b = 100;
      paramtqt.jdField_a_of_type_Int = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842693);
  }
  
  public void d(DownloadInfo paramDownloadInfo, tqt paramtqt)
  {
    if (a(paramDownloadInfo, paramtqt)) {
      c(paramtqt);
    }
  }
  
  public void d(tqt paramtqt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this, paramtqt));
    }
    TextView localTextView;
    do
    {
      return;
      localTextView = this.jdField_a_of_type_Rog.e;
    } while ((localTextView == null) || (paramtqt == null));
    localTextView.setText(anzj.a(2131698841));
    if (a()) {
      this.jdField_a_of_type_Rog.l.setText(anzj.a(2131698846));
    }
    paramtqt.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqw
 * JD-Core Version:    0.7.0.1
 */