package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import dul;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

public class FileViewMusicService
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  private static FileViewMusicService jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  private int jdField_a_of_type_Int;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = null;
  IFileViewMusicEvent jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent;
  String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private final String b = "FileViewMusicService<FileAssistant>";
  
  public static FileViewMusicService a()
  {
    FileViewMusicService localFileViewMusicService1 = null;
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      localFileViewMusicService1 = (FileViewMusicService)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    FileViewMusicService localFileViewMusicService2 = localFileViewMusicService1;
    if (localFileViewMusicService1 == null)
    {
      localFileViewMusicService2 = new FileViewMusicService();
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localFileViewMusicService2);
    }
    return localFileViewMusicService2;
  }
  
  private void f()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
      {
        if (QLog.isDevelopLevel()) {
          throw new NullPointerException("没有初始化");
        }
        if (QLog.isColorLevel()) {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "musci path not init!");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    }
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      int i = localMediaPlayer.getDuration();
      localMediaPlayer.stop();
      localMediaPlayer.release();
      return i;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return 0;
    }
    catch (SecurityException paramString)
    {
      paramString.printStackTrace();
      return 0;
    }
    catch (IllegalStateException paramString)
    {
      paramString.printStackTrace();
      return 0;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public String a()
  {
    return FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {}
    int j;
    int i;
    do
    {
      return;
      j = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
      i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    } while ((j == 0) || (i == 0));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int k = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    float f = k / m;
    f = j / i;
    if ((j == k) && (i == m)) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.setFixedSize(j, i);
      return;
      if (f > 1.0F)
      {
        j = j * k / j;
        i = (int)(j / f);
      }
      else
      {
        i = i * m / i;
        j = (int)(i * f);
      }
    }
  }
  
  public void a(Activity paramActivity, SurfaceView paramSurfaceView)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceView.getHolder();
      if (Build.VERSION.SDK_INT < 11) {
        this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnVideoSizeChangedListener(new dul(this, paramActivity));
    }
  }
  
  public void a(IFileViewMusicEvent paramIFileViewMusicEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent = paramIFileViewMusicEvent;
  }
  
  public void a(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_JavaLangString = null;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(localFileInputStream.getFD());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_JavaLangString = paramString;
      bool = true;
    }
    catch (IllegalArgumentException paramString)
    {
      do
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a(null);
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[IllegalArgumentException]:" + paramString.toString());
      return false;
    }
    catch (SecurityException paramString)
    {
      do
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a(null);
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[SecurityException]:" + paramString.toString());
      return false;
    }
    catch (IllegalStateException paramString)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent == null) {
        break label238;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a(null);
      if (!QLog.isColorLevel()) {
        break label273;
      }
      QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[IllegalStateException]:" + paramString.toString());
      paramString.printStackTrace();
      return false;
    }
    catch (IOException paramString)
    {
      label238:
      do
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a("文件读取失败，文件不存在或格式不支持！");
        }
      } while (!QLog.isColorLevel());
      label273:
      QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[IOException]:" + paramString.toString());
    }
    return bool;
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = this;
    f();
  }
  
  public boolean b(String paramString)
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString) == true);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.e();
    }
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "what[" + paramInt1 + "],extra[" + paramInt2 + "]");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a("系统资源不足，文件解码失败！请稍后再试。");
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService
 * JD-Core Version:    0.7.0.1
 */