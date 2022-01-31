package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.FavoritesRemoteCommand;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;
import dqx;
import dqz;
import dra;

public class QfavFilePreviewController
  extends FilePreViewControllerBase
{
  public static final int a = 0;
  public static final String a = "QfavFilePreviewController";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private long jdField_a_of_type_Long = 0L;
  private FavoritesRemoteCommand.IRemoteCommandHandler jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler = new dqx(this);
  private String b = null;
  private String c = null;
  private String d = null;
  private int e = 0;
  private int f = 80;
  
  public QfavFilePreviewController(Bundle paramBundle)
  {
    QfavPluginProxyService.a().a(3, this.jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler);
    this.e = 2;
    new Handler(Looper.getMainLooper()).postDelayed(new dqz(this), 300000L);
  }
  
  public int a()
  {
    return 4;
  }
  
  public boolean a()
  {
    if (3 != this.e)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QfavFilePreviewController", 4, "sendCS: oldState = " + this.e + ", newState = STATE_REQUESTING.");
      }
      this.e = 1;
      return true;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new dra(this), 2000L);
    return true;
  }
  
  public void b()
  {
    QfavPluginProxyService.a().b(3, this.jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController
 * JD-Core Version:    0.7.0.1
 */