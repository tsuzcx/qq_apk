import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import java.util.Iterator;
import java.util.List;

public class amdo
  extends BrowserBaseView
{
  public ImageButton aD;
  public ImageButton an;
  public amcu b;
  private int bFu;
  public ShareActionSheet d;
  public ImageButton k;
  public RelativeLayout lL;
  
  public amdo(Activity paramActivity, amcu paramamcu)
  {
    super(paramActivity, paramamcu);
    this.b = paramamcu;
  }
  
  private int IE()
  {
    int i = 0;
    switch (amcj.a().IB())
    {
    }
    for (;;)
    {
      if (amcj.a().avB()) {
        i = 6;
      }
      return i;
      i = 1;
      continue;
      i = 5;
      continue;
      i = 4;
    }
  }
  
  private int a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null)) {}
    switch (paramRichMediaBrowserInfo.baseData.getType())
    {
    default: 
    case 100: 
    case 102: 
    case 101: 
      do
      {
        return 0;
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        if ((paramRichMediaBrowserInfo.istroop != 1) || (!paramRichMediaBrowserInfo.bjg)) {
          break;
        }
        return 2;
        return 2;
        paramRichMediaBrowserInfo = (AIOVideoData)paramRichMediaBrowserInfo.baseData;
        if (paramRichMediaBrowserInfo.mBusiType == 0) {
          return 4;
        }
      } while (paramRichMediaBrowserInfo.mBusiType != 1);
      return 3;
    }
    return 5;
    return 1;
  }
  
  private int fk(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt == 1004) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1020) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 1036) || (paramInt == 10002) || (paramInt == 10003) || (paramInt == 10004)) {
      return 3;
    }
    return 4;
  }
  
  public void ON(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.k != null)
    {
      localImageButton = this.k;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void OO(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.lL != null)
    {
      localRelativeLayout = this.lL;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void OP(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.an != null)
    {
      localImageButton = this.an;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void OQ(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.aD != null)
    {
      localImageButton = this.aD;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void OR(boolean paramBoolean)
  {
    this.b.a().dMo();
  }
  
  public boolean SH()
  {
    return (!amcj.a().avB()) && (amcj.a().Iz() != 1037) && (top.eD(amcj.a().Iz()) != 1044) && (top.eD(amcj.a().Iz()) != 1032) && (amcj.a().IB() != 3) && (amcj.a().IB() != 4) && (amcj.a().avG());
  }
  
  public boolean avJ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.k != null)
    {
      bool1 = bool2;
      if (this.k.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean back()
  {
    super.back();
    if (amcj.a().avE())
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", amdj.a((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData));
        this.mContext.setResult(-1, localIntent);
      }
    }
    if (amcj.a().avC()) {
      this.mContext.setResult(-1, this.mContext.getIntent());
    }
    return false;
  }
  
  public boolean c(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return false;
  }
  
  public void dMJ()
  {
    this.d.dismiss();
  }
  
  protected void dMK()
  {
    if (amcj.a().IB() == 2) {}
    for (int i = 1;; i = 0)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
      amdl.a(this.mContext, amcj.a().yO(), amcj.a().Iz(), localRichMediaBrowserInfo);
      this.mContext.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
      this.mContext.overridePendingTransition(2130772362, 2130772302);
      if (i == 0) {
        this.mContext.finish();
      }
      this.b.c.dME();
      return;
    }
  }
  
  protected void dML()
  {
    anot.a(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    showActionSheet(2);
  }
  
  public void dMM()
  {
    ImmersionHelper localImmersionHelper = this.b.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBaseView", 2, "doQuitImmersion, basePresenter.isActionSheetVisibleBeforeImm = " + localImmersionHelper.cCf + " , basePresenter.isActionSheetVisibleBeforeImm , basePresenter.isDanmakuVisibleBeforeImm = " + localImmersionHelper.cCg);
    }
    if (localImmersionHelper.cCf) {
      ON(true);
    }
    if (localImmersionHelper.cCg) {
      this.b.OL(true);
    }
    this.b.a().dMp();
    this.b.dMw();
    this.b.dMt();
    showContentView(true);
    OO(true);
  }
  
  public void dMN() {}
  
  public void dMO()
  {
    this.b.a().dMn();
    this.b.a().cCe = false;
    this.b.a().dMm();
  }
  
  public void dMP()
  {
    dMM();
    dMO();
  }
  
  public void fG(long paramLong) {}
  
  public boolean needEnterRectAnimation()
  {
    boolean bool = true;
    if (amcj.a().IC() == 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean needExitRectAnimation()
  {
    if (((amcj.a().IC() == -3321) || (amcj.a().IC() == 1)) && (!amcj.a().avE())) {
      return false;
    }
    if (amcj.a().ID() == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    for (int i = localRunningAppProcessInfo.pid;; i = -2147483648) {
      return i == amcj.a().ID();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.d != null)
    {
      this.d.setItemClickListener(null);
      this.d.dismiss();
    }
    aqfv.a().clear();
    if (this.b != null) {
      this.b.a().dMn();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    this.b.a();
    ON(true);
    if (amcj.a().IB() == 4) {
      ON(false);
    }
  }
  
  public void onEnterAnimationStart()
  {
    ON(false);
  }
  
  public void onExitAnimationStart()
  {
    ON(false);
    showContentView(false);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    anot.a(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (amcj.a().IB() == 4) {
      return true;
    }
    try
    {
      showActionSheet(1);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 2, "onItemLongClick, showActionSheet");
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 1, "onItemLongClick showActionSheet exception: " + paramAdapterView.getMessage());
      }
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!amcj.a().avA())
    {
      if (!this.b.SL()) {
        break label91;
      }
      notifyImageModelDataChanged();
    }
    label91:
    label239:
    label242:
    for (;;)
    {
      this.b.a().cCe = false;
      this.b.a().dMp();
      this.b.dMw();
      this.b.dMt();
      this.b.a().dMn();
      this.b.a().dMm();
      if (!this.isInExitAnim) {
        ON(true);
      }
      return;
      int i = this.b.getCount();
      if (amcj.a().avE())
      {
        if (i - paramInt <= 0) {
          break label239;
        }
        if (paramInt > i - 25) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if ((i == 1) || (paramInt == 0) || (this.bFu == i)) {
          break label242;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 4, "[onItemSelected] loadMedias: mLastLoadCount=" + this.bFu);
        this.bFu = this.b.getCount();
        if (RichMediaBrowserManager.getInstance().getProvider() == null) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().loadMedias(0);
        break;
        paramInt = 0;
        continue;
        if (paramInt < 25)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        if (this.b.getSelectedItem() != null)
        {
          showActionSheet(3);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 2, "onKeyDown, showActionSheet");
        }
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 1, "onKeyDown showActionSheet exception = " + paramKeyEvent.getMessage());
        return true;
      }
    }
    return false;
  }
  
  public void showActionSheet(int paramInt)
  {
    QLog.d("AIOBrowserBaseView", 2, "TimShareTest Class Name is " + getClass());
    if (this.d == null)
    {
      localObject = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject).context = this.mContext;
      this.d = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    }
    this.d.setRowVisibility(0, 0, 0);
    this.d.setOnDismissListener(new amdp(this));
    Object localObject = this.b.getSelectedItem();
    int j = a((RichMediaBrowserInfo)localObject);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {}
    for (int i = ((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).istroop;; i = 0)
    {
      i = fk(i);
      int m = IE();
      if (paramInt == 2) {
        paramInt = 1;
      }
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", j, 0, String.valueOf(i), String.valueOf(m), String.valueOf(paramInt), "");
        return;
        if (paramInt == 1) {
          paramInt = 2;
        } else {
          paramInt = 0;
        }
      }
    }
  }
  
  public void showContentView(boolean paramBoolean)
  {
    this.b.showContentView(paramBoolean);
    if (paramBoolean) {
      dMN();
    }
  }
  
  public void wj(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdo
 * JD-Core Version:    0.7.0.1
 */