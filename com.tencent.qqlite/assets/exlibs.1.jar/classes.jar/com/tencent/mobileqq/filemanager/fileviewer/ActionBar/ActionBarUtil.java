package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import dsc;
import dsd;
import dse;
import dsf;
import dsg;
import dsh;
import dsi;
import dsj;

public class ActionBarUtil
{
  public static View.OnClickListener a(Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dsg(paramActivity, paramString, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(DataLineHandler paramDataLineHandler, BaseActivity paramBaseActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dsh(paramString, paramDataLineHandler, paramBaseActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dsd(paramFileManagerEntity, paramQQAppInterface, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, IFileBrowser paramIFileBrowser, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dsc(paramIFileBrowser, paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dsf(paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dsi(paramQQAppInterface, paramFileManagerEntity, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dse(paramFileManagerEntity, paramQQAppInterface, paramInt, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dsj(paramString, paramActivity, paramQQAppInterface, paramIActionBarClickEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil
 * JD-Core Version:    0.7.0.1
 */