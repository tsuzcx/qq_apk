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

public class txk
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  private rvi jdField_a_of_type_Rvi;
  public boolean a;
  
  public txk(rvi paramrvi, ADVideoAppDownloadManager paramADVideoAppDownloadManager, Context paramContext)
  {
    this.jdField_a_of_type_Rvi = paramrvi;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    obb.a(paramContext, paramString);
  }
  
  private void a(ProgressBar paramProgressBar, TextView paramTextView, String paramString)
  {
    paramProgressBar.setProgress(0);
    paramTextView.setText(paramString);
    if (a())
    {
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Rvi.l.setText(paramString);
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Rvi == null) {
      return;
    }
    TextView localTextView1 = this.jdField_a_of_type_Rvi.e;
    TextView localTextView2 = this.jdField_a_of_type_Rvi.l;
    TextView localTextView3 = this.jdField_a_of_type_Rvi.k;
    TextView localTextView4 = this.jdField_a_of_type_Rvi.d;
    twb.a(localTextView1, paramString);
    twb.a(localTextView2, paramString);
    twb.a(localTextView3, paramString);
    twb.a(localTextView4, paramString);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Rvi.p != null) && (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, txh paramtxh)
  {
    if ((paramDownloadInfo == null) || (paramtxh == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramtxh.d)) || (TextUtils.isEmpty(paramtxh.d))) {
      return false;
    }
    return paramDownloadInfo.e.equals(paramtxh.d);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Rvi != null) && (this.jdField_a_of_type_Rvi.o.getVisibility() == 0);
  }
  
  private void c(txh paramtxh, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ProgressBar localProgressBar;
      do
      {
        ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.2(this, paramtxh, paramInt));
        do
        {
          return;
        } while (paramtxh == null);
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppUIPresenter", 2, "pauseDownloadUi " + paramtxh.d);
        }
        localProgressBar = this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetProgressBar;
        localObject = this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetImageView;
      } while (localProgressBar == null);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      Object localObject = amtj.a(2131699075);
      twb.a(this.jdField_a_of_type_Rvi.e, (String)localObject);
      paramtxh.jdField_a_of_type_Int = 4;
      localProgressBar.setProgress(paramInt);
      paramtxh.b = paramInt;
      if (a())
      {
        twb.a(this.jdField_a_of_type_Rvi.l, (String)localObject);
        this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c(paramtxh);
  }
  
  private void e(txh paramtxh)
  {
    String str1 = paramtxh.d;
    String str2 = paramtxh.jdField_a_of_type_JavaLangString;
    String str3 = paramtxh.c;
    paramtxh = paramtxh.e;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bibw.k, 5);
    localBundle.putString(bibw.f, str1);
    localBundle.putString(bibw.b, str2);
    localBundle.putString(bibw.j, str3);
    localBundle.putString(bibw.l, paramtxh);
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramtxh + ", url:" + str3);
    }
    bibs.a(localBundle);
  }
  
  private void f(txh paramtxh)
  {
    if ((this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramtxh != null) && (paramtxh.jdField_a_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramtxh, paramtxh.b);
    }
  }
  
  private void g(txh paramtxh)
  {
    if ((this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetProgressBar != null) && (paramtxh != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramtxh, 0);
    }
  }
  
  private void h(txh paramtxh)
  {
    tqa.a(paramtxh, new txl(this, paramtxh));
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.8(this));
    }
    while ((this.jdField_a_of_type_Rvi == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Rvi.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidViewView != null)
    {
      if (!twr.a(this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a)) {
        break label157;
      }
      this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      ImageView localImageView = this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      if (!a()) {
        break;
      }
      this.jdField_a_of_type_Rvi.p.setVisibility(0);
      this.jdField_a_of_type_Rvi.k.setVisibility(8);
      return;
      label157:
      this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, txh paramtxh)
  {
    if (a(paramDownloadInfo, paramtxh)) {
      paramtxh.jdField_a_of_type_Int = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, txh paramtxh)
  {
    if (a(paramDownloadInfo, paramtxh)) {
      a(paramtxh);
    }
  }
  
  public void a(String paramString1, String paramString2, txh paramtxh)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramtxh)) {
      b(paramtxh);
    }
  }
  
  public void a(List<DownloadInfo> paramList, txh paramtxh)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramtxh))
        {
          paramtxh.jdField_a_of_type_Int = 3;
          if ((TextUtils.isEmpty(paramtxh.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramtxh.c = localDownloadInfo.d;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            a();
          }
          b(paramtxh, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void a(txh paramtxh)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.1(this, paramtxh));
    }
    do
    {
      TextView localTextView;
      ProgressBar localProgressBar;
      ImageView localImageView;
      do
      {
        return;
        if (paramtxh == null) {
          break;
        }
        twp.a("ADVideoAppDownloadManager", "pauseDownloadUi " + paramtxh.d);
        localTextView = this.jdField_a_of_type_Rvi.e;
        localProgressBar = this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetImageView;
      } while ((localTextView == null) || (localProgressBar == null));
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      paramtxh.jdField_a_of_type_Int = 4;
      int i = localProgressBar.getProgress();
      if ((i != 0) && (i != 100)) {
        paramtxh.b = i;
      }
      localProgressBar.setProgress(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c(paramtxh);
      }
      paramtxh = amtj.a(2131699077);
      twb.a(this.jdField_a_of_type_Rvi.e, paramtxh);
    } while (!a());
    twb.a(this.jdField_a_of_type_Rvi.l, paramtxh);
    return;
    twp.a("ADVideoAppDownloadManager", "pauseDownloadUi : appDownloadData = null");
  }
  
  public void a(txh paramtxh, int paramInt)
  {
    boolean bool = true;
    twp.a("ADVideoAppDownloadManager", "updatUIByClick  cState = " + paramInt);
    if (paramtxh == null)
    {
      twp.a("ADVideoAppDownloadManager", "updatUIByClick cgdtAppBtnData == null");
      paramtxh = this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetProgressBar;
      TextView localTextView = this.jdField_a_of_type_Rvi.e;
      ImageView localImageView = this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        a(paramtxh, localTextView, amtj.a(2131699079));
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
        a(paramtxh, localTextView, amtj.a(2131699078));
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramtxh, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_AndroidContentContext, paramtxh.d);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      a(paramtxh);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(paramtxh);
      return;
    case 5: 
      e(paramtxh);
      return;
    }
    g(paramtxh);
  }
  
  public void b(DownloadInfo paramDownloadInfo, txh paramtxh) {}
  
  public void b(String paramString1, String paramString2, txh paramtxh)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramtxh)) {
      h(paramtxh);
    }
  }
  
  public void b(txh paramtxh)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.4(this, paramtxh));
      do
      {
        return;
      } while ((paramtxh == null) || (!paramtxh.a()));
      a(amtj.a(2131699086));
      paramtxh.jdField_a_of_type_Int = 1;
      paramtxh = this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetImageView;
    } while (paramtxh == null);
    if (b())
    {
      paramtxh.setVisibility(8);
      return;
    }
    paramtxh.setVisibility(0);
    paramtxh.setImageResource(2130842739);
  }
  
  public void b(txh paramtxh, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.3(this, paramtxh, paramInt));
      do
      {
        return;
      } while ((paramtxh == null) || (paramtxh.jdField_a_of_type_Int != 3));
      localObject = this.jdField_a_of_type_Rvi.e;
      localProgressBar = this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetProgressBar;
      localImageView = this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetImageView;
    } while ((localObject == null) || (localProgressBar == null));
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppUIPresenter", 2, "updateBtnProgressUI " + paramInt);
    }
    Object localObject = amtj.a(2131699082) + paramInt + "%";
    twb.a(this.jdField_a_of_type_Rvi.e, (String)localObject);
    localProgressBar.setProgress(paramInt);
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    if (a())
    {
      twb.a(this.jdField_a_of_type_Rvi.l, (String)localObject);
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    paramtxh.b = paramInt;
  }
  
  public void c(DownloadInfo paramDownloadInfo, txh paramtxh)
  {
    if (a(paramDownloadInfo, paramtxh)) {
      d(paramtxh);
    }
  }
  
  public void c(String paramString1, String paramString2, txh paramtxh) {}
  
  public void c(txh paramtxh)
  {
    if (paramtxh == null) {}
    ImageView localImageView;
    do
    {
      ProgressBar localProgressBar;
      do
      {
        return;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.5(this, paramtxh));
          return;
        }
        localProgressBar = this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetProgressBar;
        localImageView = this.jdField_a_of_type_Rvi.jdField_c_of_type_AndroidWidgetImageView;
      } while ((localProgressBar == null) || (paramtxh == null) || (!paramtxh.a()));
      a(amtj.a(2131699074));
      localProgressBar.setProgress(100);
      if (a()) {
        this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
      }
      paramtxh.b = 100;
      paramtxh.jdField_a_of_type_Int = 5;
    } while ((localImageView == null) || (localImageView == null));
    if (b())
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130842739);
  }
  
  public void d(DownloadInfo paramDownloadInfo, txh paramtxh)
  {
    if (a(paramDownloadInfo, paramtxh)) {
      c(paramtxh);
    }
  }
  
  public void d(txh paramtxh)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ADVideoAppUIPresenter.7(this, paramtxh));
    }
    TextView localTextView;
    do
    {
      return;
      localTextView = this.jdField_a_of_type_Rvi.e;
    } while ((localTextView == null) || (paramtxh == null));
    localTextView.setText(amtj.a(2131699076));
    if (a()) {
      this.jdField_a_of_type_Rvi.l.setText(amtj.a(2131699081));
    }
    paramtxh.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txk
 * JD-Core Version:    0.7.0.1
 */