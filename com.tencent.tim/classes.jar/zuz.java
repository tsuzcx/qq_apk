import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import java.util.ArrayList;

public class zuz
  extends ztv
{
  zuz(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean VR()
  {
    if ((this.mActivity != null) && (((NewPhotoListActivity)this.mActivity).getIntent() != null)) {
      return ((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("pic_back_type_result", false);
    }
    return false;
  }
  
  private boolean VS()
  {
    return this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum;
  }
  
  private void cM(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
    ((NewPhotoListActivity)this.mActivity).finish();
  }
  
  private void zL(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.lastTimeShowToast >= 1000L)
    {
      this.a.lastTimeShowToast = l;
      QQToast.a(this.mActivity, paramString, 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
    }
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    if ((paramLocalMediaInfo.selectStatus == 2) && (paramBoolean) && (!VS()))
    {
      zL(String.format(((NewPhotoListActivity)this.mActivity).getString(2131689978), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return false;
    }
    return super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    paramView = new Intent();
    if (VR())
    {
      if (paramAdapterView == null) {}
      for (paramAdapterView = "";; paramAdapterView = paramAdapterView.path)
      {
        paramView.putExtra("PhotoConst.SELECTED_PATHS", paramAdapterView);
        cM(paramView);
        return;
      }
    }
    if (paramAdapterView == null) {}
    for (paramAdapterView = "";; paramAdapterView = paramAdapterView.path)
    {
      paramView.putExtra("PhotoConst.SELECTED_PATHS", paramAdapterView);
      paramView.putExtra("pic_choose_in_node_id", ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("pic_choose_in_node_id", 0));
      paramView.putExtra("pic_result_back_type", 1);
      AETemplateInfoFragment.W(this.mActivity, paramView);
      break;
    }
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if ((!VS()) && (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1))
    {
      zL(String.format(((NewPhotoListActivity)this.mActivity).getString(2131689978), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return;
    }
    super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
  }
  
  public void onSendBtnClick(View paramView)
  {
    if (VS())
    {
      zL(String.format(((NewPhotoListActivity)this.mActivity).getString(2131689979), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    paramView.putExtra("pic_choose_in_node_id", ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("pic_choose_in_node_id", 0));
    paramView.putExtra("pic_result_back_type", 0);
    AETemplateInfoFragment.W(this.mActivity, paramView);
    axim.a().eLc();
    cM(paramView);
  }
  
  public void updateButton()
  {
    super.updateButton();
    String str = ((NewPhotoListActivity)this.mActivity).getString(2131717066);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(true);
    if (VS())
    {
      ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130850768);
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130838048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zuz
 * JD-Core Version:    0.7.0.1
 */