import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class lul
  implements URLDrawable.DownloadListener
{
  int aPT = 0;
  
  lul(lui paramlui, String paramString, DrawableUtil.DrawableCallBack paramDrawableCallBack, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    paramInt = this.aPT;
    this.aPT = (paramInt + 1);
    if (paramInt < 3) {
      this.g.restartDownload();
    }
    for (;;)
    {
      QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadFailed :" + this.val$path + "  reTry: " + this.aPT);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(false, this.g);
    }
  }
  
  public void onFileDownloadStarted()
  {
    QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadStarted :" + this.val$path);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadSucceed :" + this.val$path);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(true, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lul
 * JD-Core Version:    0.7.0.1
 */