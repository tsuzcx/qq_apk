package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dua;
import dub;
import duc;
import dud;
import due;
import java.util.Timer;

public class LocalMusicFileView
  extends FileViewBase
  implements IFileViewMusicEvent
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FileViewMusicService jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService;
  private final String jdField_a_of_type_JavaLangString = "LocalMusicFileView";
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public LocalMusicFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      Object localObject = new Time();
      ((Time)localObject).set(i);
      localObject = ((Time)localObject).format("%M:%S");
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838596);
      k();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838597);
    l();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131298070));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new dua(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297856));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new dub(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298074));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new duc(this));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298075));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new dud(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298073));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298072));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298071));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalMusicFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297990)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297650)).setText(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())
    {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b()) {
        break label252;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = FileViewMusicService.a();
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c() != 6) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c() != 7)) || (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b())))) {
        break label263;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      g_();
      return;
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      break;
      label252:
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
    }
    label263:
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_JavaLangString);
    Object localObject = new Time();
    ((Time)localObject).set(i);
    localObject = ((Time)localObject).format("%M:%S");
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      localObject = new Time();
      ((Time)localObject).set(j);
      localObject = ((Time)localObject).format("%M:%S");
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(i);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a())) {
        break label484;
      }
    }
    label484:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        break label489;
      }
      a(bool);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("00:00");
      break;
    }
    label489:
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.i())
    {
      i();
      return;
    }
    a(bool);
  }
  
  private void i()
  {
    FileManagerReporter.a("0X8004BE0");
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_JavaLangString)) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      a(true);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a();
  }
  
  private void j()
  {
    FileManagerReporter.a("0X8004BE1");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a();
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.b();
    }
  }
  
  private void k()
  {
    l();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new due(this), 0L, 1000L);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903442, paramViewGroup, false);
    g();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131361983);
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
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
    h();
  }
  
  public void c()
  {
    h();
  }
  
  public void d()
  {
    l();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("00:00");
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.b();
    }
  }
  
  public void g_()
  {
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView
 * JD-Core Version:    0.7.0.1
 */