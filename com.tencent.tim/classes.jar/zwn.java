import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;

public class zwn
  extends zug
{
  boolean bsG;
  
  protected zwn(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    this.a.btm = true;
    super.initData(paramIntent);
    Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
    if (localObject != null)
    {
      if (PresendPicMgr.a(null) != null) {
        PresendPicMgr.a(null).release();
      }
      localObject = PresendPicMgr.b(akxc.a.a(((BinderWarpper)localObject).binder));
      if (!"FromFastImage".equals(this.a.from)) {
        break label236;
      }
    }
    label236:
    for (this.a.busiType = 1037;; this.a.busiType = 1008)
    {
      String str = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) != 1)
      {
        ((PresendPicMgr)localObject).cE(str, this.a.busiType);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "  initData , presendMgr = " + localObject + ",picpath = " + str + ",from = " + this.a.from + ",mBusiType = " + this.a.busiType);
        }
      }
      this.bsG = paramIntent.getBooleanExtra("callFromFastImage", false);
      if ("FromFastImage".equals(this.a.from)) {
        zsz.crE();
      }
      if ("FromCamera".equals(this.a.from)) {
        zsz.crC();
      }
      return;
    }
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).backToPhotoListBtn.setText(2131696917);
    ((NewPhotoPreviewActivity)this.mActivity).cancelTv.setVisibility(4);
    ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
    ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null) {
      if (!"FromCamera".equals(this.a.from)) {
        break label44;
      }
    }
    label44:
    for (int i = 1016;; i = 1017)
    {
      localPresendPicMgr.IP(i);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (this.a.baT != null)
    {
      anot.a(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.bsG) {
        anot.a(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
      }
    }
    super.onMagicStickClick(paramView, paramInt1, paramBundle, paramInt2, paramIntent);
  }
  
  protected void submit()
  {
    if ("FromFastImage".equals(this.a.from))
    {
      anot.a(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      zsz.crF();
    }
    if ("FromCamera".equals(this.a.from)) {
      zsz.crD();
    }
    super.submit();
    anot.a(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwn
 * JD-Core Version:    0.7.0.1
 */