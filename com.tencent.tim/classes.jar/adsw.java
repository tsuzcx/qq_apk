import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.PhotoListLogicArk.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class adsw
  extends ztv
{
  private boolean bQF;
  private String bvv;
  private String bvw;
  
  public adsw(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    localIntent.putExtra("key_ark_app_res_path", this.bvv);
    localIntent.putExtra("key_should_compress", this.bQF);
    localIntent.putExtra("key_ark_app_engine_res_dir", this.bvw);
    localIntent.putExtra("enter_from", 3);
    return super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    paramIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    paramIntent.putExtra("enter_from", 3);
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.bvv = paramIntent.getStringExtra("key_ark_app_res_path");
    this.bQF = paramIntent.getBooleanExtra("key_should_compress", false);
    this.bvw = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void onBackPressed()
  {
    adst.a().a("callbackArk", null, null);
    ((NewPhotoListActivity)this.mActivity).finish();
    aqfy.anim(this.mActivity, false, false);
  }
  
  public void onSendBtnClick(View paramView)
  {
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((NewPhotoListActivity)this.mActivity).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    aqfy.clearCache();
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = aqhq.getFileSizes((String)paramView.next()) + l) {}
      if (ahav.amK())
      {
        ahal.a(this.mActivity, 2131693826, 2131693832, new adsx(this));
        return;
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(this.mPhotoCommonData.selectedPhotoList.size() * 128);
        int i = 0;
        while (i < this.mPhotoCommonData.selectedPhotoList.size())
        {
          paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), this.mPhotoCommonData.selectedPhotoList.get(i) }));
          i += 1;
        }
        QLog.d("PhotoListLogicArk", 2, paramView.toString());
      }
      ((NewPhotoListActivity)this.mActivity).showProgressDialog();
      ThreadManagerV2.executeOnSubThread(new PhotoListLogicArk.2(this));
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
      adst.a().a("callbackArk", null, null);
    }
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    adst.a().a("callbackArk", null, null);
    ((NewPhotoListActivity)this.mActivity).finish();
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void postInitUI()
  {
    super.postInitUI();
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if (localNewPhotoListActivity != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListLogicArk", 2, "ArkApp ark app res:" + this.bvv);
      }
      localNewPhotoListActivity.findViewById(2131373570).setVisibility(4);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    super.startPhotoPreviewActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsw
 * JD-Core Version:    0.7.0.1
 */