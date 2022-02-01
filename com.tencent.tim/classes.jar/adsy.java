import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;

public class adsy
  extends zug
{
  private boolean bQF;
  private String bvv;
  private String bvw;
  
  public adsy(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.bvv = paramIntent.getStringExtra("key_ark_app_res_path");
    this.bQF = paramIntent.getBooleanExtra("key_should_compress", false);
    this.bvw = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new adsz(this));
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    if ("FROM_PHOTO_LIST".equals(this.a.from))
    {
      Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      localIntent.putExtra("key_ark_app_res_path", this.bvv);
      localIntent.putExtra("key_should_compress", this.bQF);
      localIntent.putExtra("key_ark_app_engine_res_dir", this.bvw);
      localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
      localIntent.putExtra("enter_from", 3);
    }
    super.onBackPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsy
 * JD-Core Version:    0.7.0.1
 */