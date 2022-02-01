import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agvu
  implements View.OnClickListener
{
  agvu(agvt paramagvt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = agvt.a(this.a);
    String str = this.a.jdField_a_of_type_Aguk.vO();
    if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((agil)localObject).a(this.a.mContext, str, agvt.a(this.a))))
    {
      int i = ahbr.hP(this.a.jdField_a_of_type_Aguk.getFileType());
      anot.a(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      localObject = this.a.jdField_a_of_type_Aguk.a();
      if (localObject != null)
      {
        ((agss)localObject).iE();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JQ(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvu
 * JD-Core Version:    0.7.0.1
 */