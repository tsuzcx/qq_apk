package com.tencent.mobileqq.activity.leba;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import ehr;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LebaShowListManager
{
  public static final int a = 1;
  private static LebaShowListManager jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final int b = 2;
  public static int c = 0;
  public ehr a;
  public HashMap a;
  protected List a;
  public boolean a;
  public HashMap b = new HashMap();
  
  private LebaShowListManager()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Ehr = new ehr(this, null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    c = 0;
  }
  
  private int a(int paramInt)
  {
    return paramInt / 100;
  }
  
  public static LebaShowListManager a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager = new LebaShowListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
    }
  }
  
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.startsWith("http://"))
      {
        paramString1 = paramString2;
        if (paramString2.length() > 7) {
          paramString1 = paramString2.substring(7);
        }
      }
      paramString1 = StringUtil.f(paramString1);
    }
    return paramContext.getFileStreamPath(paramString1);
  }
  
  private boolean a(LebaViewItem paramLebaViewItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) {
        if ((!"qzone_feedlist".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) && (!"nearby_friends".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)))
        {
          bool1 = bool2;
          if (!"com.tx.xingqubuluo.android".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i > 150) && (j > 150))
    {
      int k = i / 150;
      j /= 150;
      if (k <= j) {
        break label94;
      }
      i = j;
    }
    label94:
    for (;;)
    {
      localOptions.inSampleSize = i;
      localOptions.inJustDecodeBounds = false;
      return BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    }
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType != 1)) {
          localArrayList.add(localLebaViewItem);
        }
      }
    }
    return localList2;
  }
  
  public List a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "handleLocalList, [" + this.jdField_a_of_type_Boolean + "," + paramContext + "," + paramQQAppInterface + "]");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = paramQQAppInterface.a();
    ArrayList localArrayList3;
    Object localObject4;
    LebaViewItem localLebaViewItem;
    if (localObject1 != null)
    {
      localObject1 = new ArrayList((Collection)localObject1);
      localArrayList3 = new ArrayList();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (ResourcePluginInfo)localIterator.next();
        if ((localObject4 != null) && (((ResourcePluginInfo)localObject4).cLocalState != 0)) {
          localLebaViewItem = new LebaViewItem();
        }
      }
    }
    label544:
    label558:
    label701:
    for (;;)
    {
      try
      {
        for (;;)
        {
          if (((ResourcePluginInfo)localObject4).cDataType == 1) {
            break label558;
          }
          File localFile = a(paramContext, ((ResourcePluginInfo)localObject4).strPkgName, ((ResourcePluginInfo)localObject4).strResURL);
          URL localURL = new URL(((ResourcePluginInfo)localObject4).strResURL);
          Object localObject3;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localFile.getAbsolutePath()))
          {
            localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(localFile.getAbsolutePath());
            if (localObject1 != null) {
              break label544;
            }
            localObject3 = paramContext.getResources().getDrawable(2130838960);
            localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject3);
            if ((!localFile.exists()) || (localObject1 == null))
            {
              if ((localFile.exists()) && (localObject1 == null))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.lebatab.", 2, "handleLocalList.delete file.");
                }
                localFile.delete();
              }
              localObject1 = new HashMap();
              ((Map)localObject1).put("KEY", ((ResourcePluginInfo)localObject4).strPkgName);
              ((Map)localObject1).put("URL", localURL);
              ((Map)localObject1).put("FILE", localFile);
              localArrayList2.add(localObject1);
            }
            localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject4);
            if (((ResourcePluginInfo)localObject4).cDataType != 1)
            {
              localObject3 = JumpParser.a(paramQQAppInterface, paramContext, ((ResourcePluginInfo)localObject4).strGotoUrl);
              if ((localObject3 != null) && ("app".equals(((JumpAction)localObject3).a())))
              {
                localObject1 = ((JumpAction)localObject3).a("cmp");
                localObject4 = ((JumpAction)localObject3).a("pkg");
                if ((localObject1 != null) && (localObject4 != null))
                {
                  localObject3 = paramContext.getPackageManager();
                  localObject1 = new ComponentName((String)localObject4, (String)localObject1);
                }
              }
            }
          }
          try
          {
            ((PackageManager)localObject3).getActivityInfo((ComponentName)localObject1, 32);
            if ((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType == 0) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 826L)) {
              break;
            }
            localArrayList3.add(localLebaViewItem);
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            int i;
            localNameNotFoundException.printStackTrace();
          }
        }
        if (localFile.exists())
        {
          localObject1 = a(localFile);
          if (localObject1 == null) {
            break label701;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(localFile.getAbsolutePath(), localObject1);
          break label701;
          localObject3 = new BitmapDrawable((Bitmap)localObject1);
          continue;
          i = paramContext.getResources().getIdentifier(((ResourcePluginInfo)localObject4).strResURL, "drawable", paramContext.getPackageName());
          if (i == 0) {
            continue;
          }
          localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(i);
          continue;
          break;
          Collections.sort(localArrayList3, this.jdField_a_of_type_Ehr);
          paramContext = (RedTouchManager)paramQQAppInterface.getManager(34);
          if (paramContext == null)
          {
            paramContext = null;
            a().a(paramQQAppInterface, localArrayList3, paramContext);
            a(localArrayList1, a().b());
            paramQQAppInterface.f();
            if (localArrayList2.size() > 0) {
              paramQQAppInterface.a.a(localArrayList2);
            }
            return localArrayList1;
          }
          paramContext = paramContext.c();
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException) {}
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      c = 0;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    for (;;)
    {
      LebaViewItem localLebaViewItem;
      int j;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label246;
        }
        localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramLong3 == -9223372036854775808L)
        {
          localLebaViewItem.jdField_a_of_type_Long = paramLong2;
          i = 1;
          j = i;
          if (paramQQAppInterface != null)
          {
            j = i;
            if (i != 1) {}
          }
        }
      }
      for (;;)
      {
        try
        {
          paramQQAppInterface = (RedTouchManager)paramQQAppInterface.getManager(34);
          i = (int)paramLong1;
          if (paramLong3 != -9223372036854775808L) {
            continue;
          }
          j = paramQQAppInterface.a(i, paramBoolean, paramLong2);
        }
        catch (Exception paramQQAppInterface)
        {
          i = -2;
          j = i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.lebatab.mgr", 2, paramQQAppInterface.toString());
          j = i;
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + j);
        }
        return;
        if (paramLong2 != localLebaViewItem.jdField_a_of_type_Long) {
          break label252;
        }
        localLebaViewItem.jdField_a_of_type_Long = paramLong3;
        i = 1;
        break;
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
        paramLong2 = paramLong3;
      }
      label246:
      int i = 1;
      continue;
      label252:
      i = -2147483648;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList1, List paramList2)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList1 != null) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (paramList1 != null) {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
        }
        a(paramList2);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (RedTouchHandler)paramQQAppInterface.a(34);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(1, true, null);
          }
        }
        return;
        label111:
        i = paramList1.size();
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator1.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
          continue;
        }
        long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
        if (l == 0L) {
          continue;
        }
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator2.next();
        if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
          continue;
        }
        if (localAppSetting.setting.get())
        {
          b1 = 0;
          localLebaViewItem.jdField_a_of_type_Byte = b1;
          localLebaViewItem.jdField_a_of_type_Long = localAppSetting.modify_ts.get();
        }
      }
      byte b1 = 1;
    }
  }
  
  public void a(List paramList1, List paramList2)
  {
    Collections.sort(paramList2, this.jdField_a_of_type_Ehr);
    Iterator localIterator = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      LebaViewItem localLebaViewItem1 = (LebaViewItem)localIterator.next();
      LebaViewItem localLebaViewItem2;
      if ((a(localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.sPriority) != j) && (localLebaViewItem1 != paramList2.get(paramList2.size() - 1)))
      {
        localLebaViewItem2 = new LebaViewItem();
        if (paramList1.size() > 0) {
          if (i < 2)
          {
            ((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
            label123:
            localLebaViewItem2.jdField_a_of_type_JavaLangString = "empty_normal";
            label131:
            paramList1.add(localLebaViewItem2);
            j = a(localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.sPriority);
            localLebaViewItem1.jdField_a_of_type_Int = 1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        paramList1.add(localLebaViewItem1);
        break;
        ((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
        break label123;
        localLebaViewItem2.jdField_a_of_type_JavaLangString = "empty_normal";
        break label131;
        i += 1;
        localLebaViewItem1.jdField_a_of_type_Int = 3;
      }
    }
    if (paramList1.size() > 0) {
      if (i >= 2) {
        break label281;
      }
    }
    label281:
    for (((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;; ((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2)
    {
      paramList2 = new LebaViewItem();
      paramList2.jdField_a_of_type_JavaLangString = "empty_header_footer";
      paramList1.add(paramList2);
      return;
    }
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && ((localLebaViewItem.jdField_a_of_type_Byte == 0) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 0L)) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType == 1)) {
          localArrayList.add(localLebaViewItem);
        }
      }
    }
    return localList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaShowListManager
 * JD-Core Version:    0.7.0.1
 */