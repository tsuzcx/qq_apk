package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import dte;
import dtf;
import dtg;
import dth;
import dti;
import dtj;
import dtk;
import dtl;

public class ActionBarUtil
{
  public static View.OnClickListener a(Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dti(paramActivity, paramString, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(DataLineHandler paramDataLineHandler, BaseActivity paramBaseActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dtj(paramString, paramDataLineHandler, paramBaseActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dtf(paramFileManagerEntity, paramQQAppInterface, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, IFileBrowser paramIFileBrowser, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dte(paramIFileBrowser, paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dth(paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dtk(paramQQAppInterface, paramFileManagerEntity, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dtg(paramFileManagerEntity, paramQQAppInterface, paramInt, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new dtl(paramString, paramActivity, paramQQAppInterface, paramIActionBarClickEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil
 * JD-Core Version:    0.7.0.1
 */