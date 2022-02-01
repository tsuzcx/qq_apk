import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.fileviewer.FileVideoOnlinePlayerFragment;

public class agwu
  extends agws
  implements aguk.b, View.OnClickListener
{
  protected boolean cft;
  private boolean cfu;
  protected long iu;
  
  public agwu(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
  }
  
  public void djB()
  {
    this.mContext.getString(2131694129);
    this.cfu = true;
    djU();
  }
  
  public void djC()
  {
    if (this.cft) {
      return;
    }
    this.cft = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.showTip(true);
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    this.jdField_a_of_type_Aguk.ax(4);
  }
  
  public void djD() {}
  
  protected void djU()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JQ(this.cfu);
    if (aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath())) {
      super.djU();
    }
    while (!this.cfu) {
      return;
    }
    String str = this.mContext.getString(2131694129);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(str, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JQ(this.cfu);
  }
  
  public void fO(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "clickPlay url = " + paramString1 + ", cookie = " + paramString2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("fileid", this.jdField_a_of_type_Aguk.ve());
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("cookie", paramString2);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.b.start(this.mContext, localIntent, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
    }
    this.jdField_a_of_type_Aguk.ax(3);
  }
  
  public void init()
  {
    super.init();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.showTip(false);
    if ((this.jdField_a_of_type_Aguk.a(this)) && (QLog.isColorLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "requestWhitelist 本地信息为空!!!!");
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.iu < 500L) {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.iu = System.currentTimeMillis();
      if (this.jdField_a_of_type_Aguk.ch()) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131709884), 0).show(this.jdField_a_of_type_Aguk.getTitleBarHeight());
      } else {
        this.jdField_a_of_type_Aguk.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwu
 * JD-Core Version:    0.7.0.1
 */