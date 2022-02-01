package com.tencent.qqmail.bottle.fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.bottle.controller.BottleThrowController.BottleLocationWatcher;
import com.tencent.qqmail.bottle.controller.BottleThrowController.OnBottleThrowWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.view.QMTopBar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment.TransitionConfig;
import rx.Observable;

public class BottleThrowFragment
  extends BottleBaseFragment
{
  private static final String TAG = "BottleThrowFragment";
  private static final long mPeriod = 500L;
  private BottleManager mBottleManager = null;
  private String mCityName = null;
  private TextView mContentLength = null;
  private BottleThrowController mController = null;
  private Drawable mDrawableGray = null;
  private Drawable mDrawableHigh = null;
  private EditText mEditText = null;
  private String mGeo = null;
  private final Handler mHandler = new BottleThrowFragment.3(this);
  private String mLoadingLocation = null;
  private TextView mLocationCity = null;
  private final BottleThrowController.BottleLocationWatcher mLocationWatcher = new BottleThrowFragment.8(this);
  private int mOldSoftInputMode = 0;
  private LoadingTimerTask mTask = null;
  private final TextWatcher mTextWatcher = new BottleThrowFragment.6(this);
  private final BottleThrowController.OnBottleThrowWatcher mThrowWatcher = new BottleThrowFragment.7(this);
  private Timer mTimer = new Timer();
  
  public BottleThrowFragment()
  {
    super(false);
  }
  
  private void confirmBack()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131691012))).setMessage(getString(2131691014)).addAction(2131691246, new BottleThrowFragment.10(this))).addAction(2131691015, new BottleThrowFragment.9(this))).create().show();
  }
  
  private void handleCancelButton()
  {
    hideComposeVKB();
    if (this.mEditText.getText().toString().trim().length() > 0)
    {
      confirmBack();
      return;
    }
    popBackStack();
  }
  
  private void handleSendButton()
  {
    hideComposeVKB();
    setFragmentResult(-1, new HashMap());
    popBackStack();
  }
  
  private void hideComposeVKB()
  {
    KeyBoardHelper.hideKeyBoard(this.mEditText);
  }
  
  private void initTopbar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setButtonLeftNormal(2131691253);
    localQMTopBar.setButtonRightBlue(2131691011);
    if (localQMTopBar.getButtonRight() != null) {
      localQMTopBar.getButtonRight().setEnabled(false);
    }
    localQMTopBar.setButtonLeftOnclickListener(new BottleThrowFragment.4(this));
    localQMTopBar.setButtonRightOnclickListener(new BottleThrowFragment.5(this));
  }
  
  private void renderLocation(String paramString)
  {
    if (this.mTask != null) {
      this.mTask.cancel();
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.mLocationCity.setCompoundDrawables(this.mDrawableGray, null, null, null);
      this.mLocationCity.setTextColor(getResources().getColor(2131167531));
      this.mLocationCity.setText(2131690977);
      setLocationInfo(null, null);
      return;
    }
    this.mLocationCity.setCompoundDrawables(this.mDrawableHigh, null, null, null);
    this.mLocationCity.setTextColor(getResources().getColor(2131167519));
    this.mLocationCity.setText(paramString);
  }
  
  private void renderLocationLoading()
  {
    if (this.mTask != null) {
      this.mTask.cancel();
    }
    this.mTask = new LoadingTimerTask(null);
    this.mLocationCity.setCompoundDrawables(this.mDrawableHigh, null, null, null);
    this.mLocationCity.setTextColor(getResources().getColor(2131167519));
    this.mLocationCity.setText(this.mLoadingLocation);
    this.mTimer.schedule(this.mTask, 500L, 500L);
    setLocationInfo(null, null);
  }
  
  private void setLocationInfo(String paramString1, String paramString2)
  {
    this.mGeo = paramString1;
    this.mCityName = paramString2;
  }
  
  private void showComposeVKB()
  {
    KeyBoardHelper.showSoftInputDelay(this.mEditText, 300L);
  }
  
  public QMTopBar getTopBar()
  {
    return (QMTopBar)findViewById(2131363609);
  }
  
  public void initDataSource()
  {
    this.mBottleManager = BottleManager.getInstance();
    this.mController = this.mBottleManager.getBottleThrowController();
    this.mDrawableHigh = getResources().getDrawable(2130838982);
    this.mDrawableGray = getResources().getDrawable(2130838983);
    this.mDrawableHigh.setBounds(0, 0, this.mDrawableHigh.getMinimumWidth(), this.mDrawableHigh.getMinimumHeight());
    this.mDrawableGray.setBounds(0, 0, this.mDrawableGray.getMinimumWidth(), this.mDrawableGray.getMinimumHeight());
    this.mBottleManager.logEvent("Event_Bottle_Enter_Throw");
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopbar();
    this.mEditText = ((EditText)findViewById(2131363608));
    this.mEditText.addTextChangedListener(this.mTextWatcher);
    this.mLocationCity = ((TextView)findViewById(2131363606));
    this.mContentLength = ((TextView)findViewById(2131363597));
    this.mLoadingLocation = getString(2131690976);
    if (this.mController.isOpenedLBS()) {
      RxPermissions.getInstance(getActivity()).request(new String[] { "android.permission.ACCESS_FINE_LOCATION" }).subscribe(new BottleThrowFragment.1(this));
    }
    this.mLocationCity.setOnClickListener(new BottleThrowFragment.2(this));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return LayoutInflater.from(getActivity()).inflate(2131558781, null, false);
  }
  
  public void onBackPressed()
  {
    handleCancelButton();
  }
  
  public void onBackground()
  {
    super.onBackground();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    this.mController.bindOnBottleThrowWatcher(this.mThrowWatcher, paramBoolean);
    this.mController.bindLocationWatch(this.mLocationWatcher, paramBoolean);
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      handleCancelButton();
      return true;
    }
    if (paramInt == 82) {}
    while (paramInt != 3) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onRelease()
  {
    this.mController.abortLoadLocality();
  }
  
  public void onWindowConfiguration(boolean paramBoolean)
  {
    Window localWindow = getActivity().getWindow();
    if (paramBoolean)
    {
      this.mOldSoftInputMode = localWindow.getAttributes().softInputMode;
      if (getActivity().getWindowManager().getDefaultDisplay().getHeight() <= 320)
      {
        localWindow.setSoftInputMode(36);
        return;
      }
      localWindow.setSoftInputMode(20);
      return;
    }
    if (this.mOldSoftInputMode == 0)
    {
      localWindow.getAttributes().softInputMode = this.mOldSoftInputMode;
      localWindow.setSoftInputMode(0);
      return;
    }
    localWindow.setSoftInputMode(this.mOldSoftInputMode);
  }
  
  public int refreshData()
  {
    if (this.mController.isOpenedLBS())
    {
      if (RxPermissions.getInstance(getActivity()).isGranted("android.permission.ACCESS_FINE_LOCATION"))
      {
        this.mController.loadLocality(false);
        return 0;
      }
      renderLocation(null);
      return 0;
    }
    renderLocation(null);
    return 0;
  }
  
  public void render(int paramInt)
  {
    showComposeVKB();
  }
  
  class LoadingTimerTask
    extends TimerTask
  {
    private LoadingTimerTask() {}
    
    public void run()
    {
      BottleThrowFragment.this.mHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment
 * JD-Core Version:    0.7.0.1
 */