import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpic.HotPicPageView.a;
import com.tencent.mobileqq.hotpic.HotPicPageView.c;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoData.a;
import com.tencent.mobileqq.hotpic.HotVideoData.b;
import com.tencent.qphone.base.util.QLog;

public class ahzi
  implements HotVideoData.a
{
  public ahzi(HotPicPageView.a parama, HotVideoData paramHotVideoData, HotPicPageView.c paramc, URLDrawable paramURLDrawable) {}
  
  public void a(HotVideoData.b paramb)
  {
    if (paramb.mResult)
    {
      this.a.url = paramb.wM();
      if (this.jdField_b_of_type_ComTencentMobileqqHotpicHotPicPageView$c.a() == this.a)
      {
        this.jdField_b_of_type_ComTencentMobileqqHotpicHotPicPageView$c.X(this.B);
        this.B.setAutoDownload(true);
        this.B.restartDownload();
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "onFileDownloadFailed:" + this.a.picIndex + " GetUrlFailed msg:" + paramb.mMessage);
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqHotpicHotPicPageView$c.a() != this.a);
    this.jdField_b_of_type_ComTencentMobileqqHotpicHotPicPageView$c.PD(-10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzi
 * JD-Core Version:    0.7.0.1
 */