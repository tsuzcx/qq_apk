package com.tencent.qqmail.utilities.audio;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMLoading;
import java.io.IOException;

public class QMAudioPlayBar
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener
{
  public static final String AUDIO_PLAY_COMPLETE = "audioPlayComplete";
  private SeekBar.OnSeekBarChangeListener barChangeListener = new QMAudioPlayBar.3(this);
  private CompoundButton.OnCheckedChangeListener clickListener = new QMAudioPlayBar.4(this);
  private String currentSrc;
  private Activity mActivity;
  private Button mCloseBtn;
  private Runnable mCompleteEvent = null;
  private TextView mCur_tv;
  private Handler mHandler = new Handler();
  private View mLoading;
  private MediaPlayer mMediaPlayer;
  private View mPlayBarView;
  private TextView mRest_tv;
  private SeekBar mSeekBar;
  private ToggleButton mTb;
  private Runnable mUpdateRunnable = new QMAudioPlayBar.1(this);
  
  public QMAudioPlayBar(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    initPlayBar();
  }
  
  private void initMediaPlay(String paramString)
  {
    try
    {
      if (this.mMediaPlayer == null) {
        this.mMediaPlayer = new MediaPlayer();
      }
      this.mMediaPlayer.setDataSource(paramString);
      this.mMediaPlayer.setOnPreparedListener(this);
      this.mMediaPlayer.prepareAsync();
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (SecurityException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (IllegalStateException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (IOException paramString)
    {
      this.mTb.setVisibility(0);
      this.mTb.setChecked(true);
      this.mSeekBar.setEnabled(true);
      this.mLoading.setVisibility(8);
      ((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.mActivity).setMessage(this.mActivity.getString(2131718660)).addAction(2131718660, new QMAudioPlayBar.2(this))).create().show();
    }
  }
  
  private void initPlayBar()
  {
    if (this.mActivity.findViewById(2131373371) == null)
    {
      Object localObject = ((LayoutInflater)this.mActivity.getSystemService("layout_inflater")).inflate(2131558757, null);
      this.currentSrc = "";
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, (int)QMApplicationContext.sharedInstance().getResources().getDimension(2131299664));
      if ((StatusBarUtil.availableVersion()) && (Build.VERSION.SDK_INT < 21))
      {
        localLayoutParams.height = ((int)QMApplicationContext.sharedInstance().getResources().getDimension(2131299664) + StatusBarUtil.getStatusBarHeight());
        ((View)localObject).setPadding(0, StatusBarUtil.getStatusBarHeight(), 0, 0);
      }
      this.mActivity.addContentView((View)localObject, localLayoutParams);
      this.mPlayBarView = this.mActivity.findViewById(2131373371);
      localObject = new QMLoading(QMApplicationContext.sharedInstance(), QMLoading.SIZE_MINI);
      ((RelativeLayout)this.mPlayBarView.findViewById(2131368744)).addView((View)localObject);
      this.mCur_tv = ((TextView)this.mPlayBarView.findViewById(2131373373));
      this.mSeekBar = ((SeekBar)this.mPlayBarView.findViewById(2131373375));
      this.mRest_tv = ((TextView)this.mPlayBarView.findViewById(2131373374));
      this.mTb = ((ToggleButton)this.mPlayBarView.findViewById(2131373376));
      this.mCloseBtn = ((Button)this.mPlayBarView.findViewById(2131373372));
      this.mLoading = this.mPlayBarView.findViewById(2131373389);
      this.mSeekBar.setOnSeekBarChangeListener(this.barChangeListener);
      this.mTb.setOnCheckedChangeListener(this.clickListener);
      this.mCloseBtn.setOnClickListener(new QMAudioPlayBar.5(this));
    }
  }
  
  private void resetPlay()
  {
    this.mTb.setChecked(false);
    this.mCur_tv.setText("00:00");
    this.mSeekBar.setProgress(0);
    this.mMediaPlayer.seekTo(0);
  }
  
  public void close()
  {
    forceClose(false);
  }
  
  public void forceClose(boolean paramBoolean)
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.currentSrc = "";
    }
    this.mPlayBarView.setVisibility(8);
    if (!paramBoolean) {
      QMNotification.postNotification("audioPlayComplete", null);
    }
  }
  
  public String getCurrentSrc()
  {
    return this.currentSrc;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    resetPlay();
    if (this.mCompleteEvent != null) {
      this.mCompleteEvent.run();
    }
    forceClose(false);
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.mMediaPlayer.start();
    this.mMediaPlayer.setOnCompletionListener(this);
    this.mTb.setVisibility(0);
    this.mTb.setChecked(true);
    this.mSeekBar.setEnabled(true);
    this.mLoading.setVisibility(8);
    this.mCur_tv.setText("00:00");
    this.mSeekBar.setProgress(0);
    this.mSeekBar.setMax(this.mMediaPlayer.getDuration() / 1000);
    this.mRest_tv.setText(DateExtension.getTimeMinuteSecondString(this.mMediaPlayer.getDuration()));
    this.mHandler.post(this.mUpdateRunnable);
  }
  
  public void play(String paramString)
  {
    this.mPlayBarView.setVisibility(0);
    this.currentSrc = paramString;
    initMediaPlay(paramString);
    this.mTb.setVisibility(8);
    this.mLoading.setVisibility(0);
    this.mSeekBar.setEnabled(false);
    this.mRest_tv.setText("00:00");
    this.mCur_tv.setText("00:00");
    this.mSeekBar.setProgress(0);
  }
  
  public void setOnCompleteEvent(Runnable paramRunnable)
  {
    this.mCompleteEvent = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioPlayBar
 * JD-Core Version:    0.7.0.1
 */