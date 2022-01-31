package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewMusicEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import dtf;
import dth;
import dti;
import dtk;
import dtl;
import dtm;
import dtp;
import java.util.Timer;

public class LocalVideoFileView
  extends FileViewBase
  implements IFileViewMusicEvent
{
  private int jdField_a_of_type_Int = 0;
  final long jdField_a_of_type_Long = 86400L;
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FileViewMusicService jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService;
  private final String jdField_a_of_type_JavaLangString = "LocalVideoFileView";
  private Timer jdField_a_of_type_JavaUtilTimer;
  boolean jdField_a_of_type_Boolean = true;
  final long jdField_b_of_type_Long = 3600L;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  final long jdField_c_of_type_Long = 60L;
  private boolean jdField_c_of_type_Boolean = true;
  
  public LocalVideoFileView(Activity paramActivity)
  {
    super(paramActivity);
    paramActivity.setRequestedOrientation(-1);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_b_of_type_AndroidAppActivity.getSystemService("power")).newWakeLock(10, "LocalVideoFileView");
  }
  
  private String a(long paramLong)
  {
    long l3 = paramLong / 1000L;
    paramLong = l3 / 86400L;
    long l1 = l3 % 86400L / 3600L;
    long l2 = l3 % 86400L % 3600L / 60L;
    l3 = l3 % 86400L % 3600L % 60L;
    if (paramLong > 0L) {
      return String.format("%02d:%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    }
    if (l1 > 0L) {
      return String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    }
    return String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      String str = a(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838576);
      m();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838575);
    n();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298067));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298068));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298074));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131298065));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new dth(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297852));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new dti(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298075));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new dtk(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new dtl(this));
  }
  
  private void h()
  {
    this.jdField_c_of_type_Boolean = false;
    i();
  }
  
  private void i()
  {
    boolean bool2 = true;
    label47:
    IFileViewListener localIFileViewListener;
    if (!this.jdField_c_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        break label81;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null)
      {
        localIFileViewListener = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener;
        if (this.jdField_c_of_type_Boolean) {
          break label111;
        }
      }
    }
    label81:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIFileViewListener.c(bool1);
      return;
      bool1 = false;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label47;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalVideoFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    new Handler().postDelayed(new dtm(this), 100L);
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298073));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = FileViewMusicService.a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoFileView", 2, "play but musicService is null");
      }
    }
    do
    {
      return;
      FileManagerReporter.a("0X8004BE4");
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
    } while (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewSurfaceView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewSurfaceView.setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewSurfaceView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_AndroidAppActivity);
    a(true);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    FileManagerReporter.a("0X8004BE5");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a();
    a(false);
  }
  
  private void m()
  {
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new dtp(this), 0L, 1000L);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903443, paramViewGroup, false);
    g();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131361983);
  }
  
  public void a()
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocalVideoFileView", 2, "doOnFinish");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      FMToastUtil.a("对不起，该音频文件无法播放！");
    }
    for (;;)
    {
      a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.b();
      }
      return;
      FMToastUtil.a(paramString);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    j();
  }
  
  public void c()
  {
    j();
  }
  
  public void d()
  {
    n();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, false, i, j, this.jdField_a_of_type_Int * 1000, new dtf(this));
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("00:00");
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.b();
    }
    this.jdField_c_of_type_Boolean = false;
    h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838574);
      if (this.jdField_a_of_type_Boolean) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838577);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView
 * JD-Core Version:    0.7.0.1
 */