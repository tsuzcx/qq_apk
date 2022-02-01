import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ixx
{
  VideoController a = null;
  Button bh = null;
  VideoAppInterface mApp = null;
  WeakReference<Context> mContext = null;
  VideoControlUI mControlUI;
  boolean mIsShown = false;
  Resources mRes = null;
  ViewGroup mRootView = null;
  
  public ixx(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, VideoControlUI paramVideoControlUI, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "ChildGuideUi");
    }
    this.mContext = new WeakReference(paramAVActivity);
    this.mApp = paramVideoAppInterface;
    this.mControlUI = paramVideoControlUI;
    this.mRootView = paramViewGroup;
    this.a = this.mApp.b();
  }
  
  public void bK(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    onBackPressed();
  }
  
  public void hide()
  {
    this.mIsShown = false;
    this.mControlUI.auU();
    this.mRootView.setVisibility(8);
  }
  
  void initUI()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "initUI");
    }
    if ((this.mContext != null) && (this.mContext.get() != null))
    {
      AVActivity localAVActivity = (AVActivity)this.mContext.get();
      if (localAVActivity != null)
      {
        localAVActivity.getLayoutInflater().inflate(2131559889, this.mRootView);
        this.mRes = localAVActivity.getResources();
      }
    }
    this.bh = ((Button)this.mRootView.findViewById(2131373961));
  }
  
  public boolean isShown()
  {
    return this.mIsShown;
  }
  
  public boolean onBackPressed()
  {
    hide();
    return true;
  }
  
  public void onDestroy()
  {
    this.mContext = null;
    this.mApp = null;
    this.a = null;
    this.mRootView = null;
    this.mRes = null;
    this.bh = null;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void show()
  {
    if ((this.mRes == null) || (this.bh == null)) {
      initUI();
    }
    this.mIsShown = true;
    this.mControlUI.auT();
    this.mRootView.setVisibility(0);
  }
  
  public boolean wa()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("com.tencent.av.count", 0);
    String str = "DoubleVideoChildLock_ShowGuide";
    if (this.mApp != null) {
      str = "DoubleVideoChildLock_ShowGuide" + this.mApp.getCurrentAccountUin();
    }
    if (localSharedPreferences.getInt(str, 0) == 0)
    {
      localSharedPreferences.edit().putInt(str, 1).commit();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixx
 * JD-Core Version:    0.7.0.1
 */