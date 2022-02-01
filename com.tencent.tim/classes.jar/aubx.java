import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.fileviewer.FileVideoOnlinePlayerFragment;

public class aubx
  extends aubv
  implements View.OnClickListener, atzy.b
{
  protected boolean cft;
  protected long iu;
  
  public aubx(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
  }
  
  public void djB()
  {
    if (aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {
      this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131694130));
    }
    while (this.jdField_a_of_type_Atzy.cn())
    {
      this.jdField_a_of_type_Aucs.showTip(false);
      this.jdField_a_of_type_Aucs.VI(false);
      return;
      this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131694132));
    }
    this.jdField_a_of_type_Aucs.showTip(true);
    this.jdField_a_of_type_Aucs.VI(true);
  }
  
  public void djC()
  {
    if (this.cft) {
      return;
    }
    this.cft = true;
    this.jdField_a_of_type_Aucs.showTip(true);
    this.jdField_a_of_type_Aucs.VI(false);
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    this.jdField_a_of_type_Atzy.ax(4);
  }
  
  public void djD() {}
  
  public void fO(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "clickPlay url = " + paramString1 + ", cookie = " + paramString2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("fileid", this.jdField_a_of_type_Atzy.ve());
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("cookie", paramString2);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.b.start(this.mContext, localIntent, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
    }
    this.jdField_a_of_type_Atzy.ax(3);
  }
  
  public void init()
  {
    super.init();
    String str = this.mContext.getString(2131694129);
    this.jdField_a_of_type_Aucs.a(str, false, this);
    this.jdField_a_of_type_Aucs.showTip(false);
    if ((this.jdField_a_of_type_Atzy.a(this)) && (QLog.isColorLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "requestWhitelist 本地信息为空!!!!");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (System.currentTimeMillis() - this.iu < 500L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
        }
      }
      else
      {
        this.iu = System.currentTimeMillis();
        if (this.jdField_a_of_type_Atzy.ch()) {
          QQToast.a(BaseApplicationImpl.getContext(), 1, "在线预览失败，请重试", 0).show(this.jdField_a_of_type_Atzy.getTitleBarHeight());
        } else {
          this.jdField_a_of_type_Atzy.a(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubx
 * JD-Core Version:    0.7.0.1
 */