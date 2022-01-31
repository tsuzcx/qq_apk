package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiListenerManager
{
  ArrayList a = new ArrayList();
  ArrayList b = new ArrayList();
  ArrayList c = new ArrayList();
  
  public void a()
  {
    synchronized (this.a)
    {
      this.a.clear();
      synchronized (this.b)
      {
        this.b.clear();
      }
    }
    synchronized (this.c)
    {
      this.c.clear();
      return;
      localObject1 = finally;
      throw localObject1;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage.isMagicFaceDownloading)
    {
      localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((MagicFaceDownloadListener)localIterator.next()).c(paramEmoticonPackage);
      }
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonPackageDownloadListener)localIterator.next()).onPackageStart(paramEmoticonPackage);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
          ((EmoticonPackageDownloadListener)localIterator.next()).onJsonComplete(paramEmoticonPackage, paramInt);
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonPackageChangedListener)localIterator.next()).a(paramEmoticonPackage, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b != null)
    {
      if (paramInt2 != 0) {}
      for (;;)
      {
        synchronized (this.b)
        {
          Iterator localIterator = this.b.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ((EmoticonPackageDownloadListener)localIterator.next()).onCoverComplete(paramEmoticonPackage, paramInt1, paramInt3);
        }
        paramInt3 = 0;
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if ((paramEmoticonPackage.status == 2) && (EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
        if (paramQQAppInterface != null) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
        }
      }
      for (;;)
      {
        if (!paramEmoticonPackage.isMagicFaceDownloading) {
          break label143;
        }
        paramQQAppInterface = this.c.iterator();
        while (paramQQAppInterface.hasNext()) {
          ((MagicFaceDownloadListener)paramQQAppInterface.next()).b(paramEmoticonPackage);
        }
        break;
        paramEmoticonPackage.status = 0;
      }
      label143:
      ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticonPackage);
      paramQQAppInterface = this.b.iterator();
      while (paramQQAppInterface.hasNext()) {
        ((EmoticonPackageDownloadListener)paramQQAppInterface.next()).onPackageEnd(paramEmoticonPackage, paramInt);
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      if (3 == paramEmoticonPackage.jobType)
      {
        localObject = new ArrayList();
        paramQQAppInterface = (EmoticonManager)paramQQAppInterface.getManager(13);
        Iterator localIterator = paramQQAppInterface.b().iterator();
        while (localIterator.hasNext())
        {
          EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
          if (!"100000".equals(localEmoticonPackage.epId)) {
            ((ArrayList)localObject).add(localEmoticonPackage.epId);
          }
        }
        paramQQAppInterface.c();
        paramQQAppInterface.b((List)localObject);
      }
      c(paramEmoticonPackage);
      paramQQAppInterface = BaseApplicationImpl.a().getSharedPreferences("QQLite", 0);
      Object localObject = paramQQAppInterface.getString("LAST_ADD_EMO_PACKAGE", "");
      localObject = (String)localObject + "|" + paramEmoticonPackage.epId;
      paramQQAppInterface.edit().putString("LAST_ADD_EMO_PACKAGE", (String)localObject).commit();
    } while (3 != paramEmoticonPackage.jobType);
    paramQQAppInterface.edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
  }
  
  public void a(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {
      return;
    }
    synchronized (this.a)
    {
      if (!this.a.contains(paramEmoticonPackageChangedListener)) {
        this.a.add(paramEmoticonPackageChangedListener);
      }
      return;
    }
  }
  
  public void a(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    if (paramEmoticonPackageDownloadListener == null) {
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.contains(paramEmoticonPackageDownloadListener)) {
        this.b.add(paramEmoticonPackageDownloadListener);
      }
      return;
    }
  }
  
  public void a(MagicFaceDownloadListener paramMagicFaceDownloadListener)
  {
    if (paramMagicFaceDownloadListener == null) {
      return;
    }
    synchronized (this.c)
    {
      if (!this.c.contains(paramMagicFaceDownloadListener)) {
        this.c.add(paramMagicFaceDownloadListener);
      }
      return;
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonPackageChangedListener)localIterator.next()).a(paramEmoticonPackage);
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        ((EmoticonPackageDownloadListener)localIterator.next()).onPackageProgress(paramEmoticonPackage, paramInt1, paramInt2);
      }
    }
  }
  
  public void b(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {
      return;
    }
    synchronized (this.a)
    {
      if (this.a.contains(paramEmoticonPackageChangedListener)) {
        this.a.remove(paramEmoticonPackageChangedListener);
      }
      return;
    }
  }
  
  public void b(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    if (paramEmoticonPackageDownloadListener == null) {
      return;
    }
    synchronized (this.b)
    {
      if (this.b.contains(paramEmoticonPackageDownloadListener)) {
        this.b.remove(paramEmoticonPackageDownloadListener);
      }
      return;
    }
  }
  
  public void b(MagicFaceDownloadListener paramMagicFaceDownloadListener)
  {
    if (paramMagicFaceDownloadListener == null) {
      return;
    }
    synchronized (this.c)
    {
      if (this.c.contains(paramMagicFaceDownloadListener)) {
        this.c.remove(paramMagicFaceDownloadListener);
      }
      return;
    }
  }
  
  protected void c(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonPackageChangedListener)localIterator.next()).b(paramEmoticonPackage);
    }
  }
  
  public void d(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator;
    if (paramEmoticonPackage.isMagicFaceDownloading)
    {
      synchronized (this.c)
      {
        localIterator = this.c.iterator();
        if (localIterator.hasNext()) {
          ((MagicFaceDownloadListener)localIterator.next()).a(paramEmoticonPackage);
        }
      }
      return;
    }
    synchronized (this.b)
    {
      localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        ((EmoticonPackageDownloadListener)localIterator.next()).onPackageEnd(paramEmoticonPackage, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiListenerManager
 * JD-Core Version:    0.7.0.1
 */