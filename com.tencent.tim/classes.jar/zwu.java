import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import java.io.File;

public class zwu
  extends zug
{
  private String baX = "";
  private boolean bub;
  
  zwu(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.bub = paramIntent.getBooleanExtra("from_tribe_slideshow", false);
    this.baX = paramIntent.getStringExtra("from_tribe_class_name");
    ((zuc)this.mOtherCommonData).a(this.bub, this.mPhotoCommonData);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10012)
    {
      if ((paramInt2 == -1) && (this.bub))
      {
        ((NewPhotoPreviewActivity)this.mActivity).setResult(paramInt2, paramIntent);
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
      do
      {
        do
        {
          return;
        } while (!this.bub);
        paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      } while (TextUtils.isEmpty(paramIntent));
      aqhq.cn(new File(paramIntent).getParent());
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    super.onMagicStickClick(paramView, paramInt1, paramBundle, paramInt2, paramIntent);
    if ((this.a.baT != null) && (!TextUtils.isEmpty(this.baX)))
    {
      if (!TroopBarPublishActivity.class.getSimpleName().equals(this.baX)) {
        break label60;
      }
      aprl.e("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
    }
    label60:
    while (!TroopBarReplyActivity.class.getSimpleName().equals(this.baX)) {
      return;
    }
    aprl.e("reply", "clk_photo_edit", 0, 0, new String[0]);
  }
  
  protected void submit()
  {
    if (this.bub)
    {
      rmc.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
      return;
    }
    super.submit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwu
 * JD-Core Version:    0.7.0.1
 */