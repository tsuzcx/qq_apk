import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class awhw
  implements awhy.a
{
  awhw(awhv paramawhv, IWebviewListener paramIWebviewListener) {}
  
  public void onPageFinished()
  {
    if (awhv.a(this.jdField_a_of_type_Awhv) == null) {}
    do
    {
      return;
      if (awhv.a(this.jdField_a_of_type_Awhv).getVisibility() != 0) {
        awhv.a(this.jdField_a_of_type_Awhv).setVisibility(0);
      }
    } while (this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener == null);
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener.onPageFinished();
  }
  
  public void onReceiveError(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhw
 * JD-Core Version:    0.7.0.1
 */