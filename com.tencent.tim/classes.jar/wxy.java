import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wxy
  implements View.OnClickListener
{
  wxy(wxw.a parama) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (wxw.a.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (wxw.a.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (ahpj)((QQAppInterface)localObject).getBusinessHandler(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(wxw.a(this.a.b)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((ahpj)localObject).aJ(l1, wxw.a.a(this.a).dateType);
    }
    for (;;)
    {
      if (wxw.a.a(this.a) != null) {
        wxw.a.a(this.a).a(paramView, wxw.a.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((wxw.a.a(this.a).linkUrl != null) && (this.a.b.mContext != null))
      {
        anot.a(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", wxw.a.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        aqhv localaqhv = aqik.c((QQAppInterface)localObject, this.a.b.mContext, wxw.a.a(this.a).linkUrl);
        if (localaqhv != null) {
          localaqhv.ace();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + wxw.a.a(this.a).linkUrl);
          break;
          if (wxw.a.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            avpw.dp(this.a.b.mContext, wxw.a.a(this.a).linkUrl);
          } else {
            wxw.bk(this.a.b.mContext, wxw.a.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      anot.a(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", wxw.a.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (wxw.a(this.a.b) == null) {
        break;
      }
      wxw.a(this.a.b).a(wxw.a.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxy
 * JD-Core Version:    0.7.0.1
 */