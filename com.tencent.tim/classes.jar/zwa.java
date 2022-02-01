import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class zwa
  extends zug
{
  private final String TAG = "PhotoPreviewLogicAEPlay";
  
  zwa(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private boolean VS()
  {
    return this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum;
  }
  
  private void zL(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.lastTimeShowToast >= 700L)
    {
      this.a.lastTimeShowToast = l;
      QQToast.a(this.mActivity, paramString, 0).show(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new zwb(this));
  }
  
  public void onSelectClick(View paramView)
  {
    if ((!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()))) && (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      zL(String.format(((NewPhotoPreviewActivity)this.mActivity).getString(2131689978), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return;
    }
    super.onSelectClick(paramView);
  }
  
  public void updateButton()
  {
    super.updateButton();
    String str = ((NewPhotoPreviewActivity)this.mActivity).getString(2131717066);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText(str);
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
    if (VS())
    {
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setBackgroundResource(2130850768);
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setBackgroundResource(2130838048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwa
 * JD-Core Version:    0.7.0.1
 */