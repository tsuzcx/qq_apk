package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MBundle;
import Protocol.MGuide.MDoraemonRes;
import Protocol.MGuide.MDoraemonZip;
import Protocol.MGuide.MIntent;
import Protocol.MGuide.MSolution;
import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import taiji.ca;
import taiji.ch;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;

public class m
{
  private ReentrantLock a = new ReentrantLock();
  private HashSet b = new HashSet();
  private HashSet c = new HashSet();
  
  static MSolution a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    int i = ca.b(paramInt);
    Object localObject1 = com.tencent.qqpimsecure.taiji.n.a(paramContext).a(i);
    if ((localObject1 == null) || (((SolutionItem)localObject1).soluInfo == null)) {}
    for (localObject1 = h.a(paramContext, i); (localObject1 == null) || (((MSolution)localObject1).mJumpIntent == null); localObject1 = (MSolution)ch.a(((SolutionItem)localObject1).soluInfo, new MSolution(), false)) {
      return null;
    }
    Object localObject2 = a(paramContext, (MSolution)localObject1, i);
    if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
      return null;
    }
    int j = ((Integer)((Pair)localObject2).second).intValue();
    if (((MSolution)localObject1).mHelpStyle == 5)
    {
      if ((((MSolution)localObject1).mHelpDoraemonZip == null) || (TextUtils.isEmpty(((MSolution)localObject1).mHelpDoraemonZip.mDoraemonZipUrl)) || (((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList == null) || (((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.isEmpty())) {
        return null;
      }
      localObject2 = b(paramContext, (MSolution)localObject1, i, j);
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
        return null;
      }
      paramInt = 0;
      while (paramInt < ((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.size())
      {
        ((MDoraemonRes)((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.get(paramInt)).mFileList.clear();
        ((MDoraemonRes)((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.get(paramInt)).mFileList.addAll((Collection)((ArrayList)localObject2).get(paramInt));
        paramInt += 1;
      }
    }
    if ((((MSolution)localObject1).mHelpImageList != null) && (!((MSolution)localObject1).mHelpImageList.isEmpty()))
    {
      localObject2 = a(paramContext, (MSolution)localObject1, i, j);
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
        return null;
      }
      ((MSolution)localObject1).mHelpImageList = ((ArrayList)localObject2);
    }
    f.a(paramContext, i, 0, j);
    return localObject1;
  }
  
  static Intent a(MSolution paramMSolution)
  {
    if ((paramMSolution == null) || (paramMSolution.mJumpIntent == null)) {
      return null;
    }
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mAction)) {
      localIntent.setAction(paramMSolution.mJumpIntent.mAction);
    }
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mUri)) {
      localIntent.setData(Uri.parse(paramMSolution.mJumpIntent.mUri));
    }
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mType)) {
      localIntent.setType(paramMSolution.mJumpIntent.mType);
    }
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mPackage))
    {
      localIntent.setPackage(paramMSolution.mJumpIntent.mPackage);
      if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mClass)) {
        localIntent.setClassName(paramMSolution.mJumpIntent.mPackage, paramMSolution.mJumpIntent.mClass);
      }
    }
    localIntent.setFlags(paramMSolution.mJumpIntent.mFlags);
    Iterator localIterator;
    if (paramMSolution.mJumpIntent.mCategories != null)
    {
      localIterator = paramMSolution.mJumpIntent.mCategories.keySet().iterator();
      while (localIterator.hasNext()) {
        localIntent.addCategory((String)localIterator.next());
      }
    }
    if (paramMSolution.mJumpIntent.mExtras != null) {
      localIterator = paramMSolution.mJumpIntent.mExtras.iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        MBundle localMBundle = (MBundle)localIterator.next();
        try
        {
          switch (localMBundle.mValueType)
          {
          case 1: 
            localIntent.putExtra(localMBundle.mKey, Integer.parseInt(localMBundle.mValue));
          }
        }
        catch (Throwable localThrowable)
        {
          cl.a("ManualSolutionManager", localThrowable.getMessage());
        }
        continue;
        localIntent.putExtra(localThrowable.mKey, Long.parseLong(localThrowable.mValue));
        continue;
        localIntent.putExtra(localThrowable.mKey, localThrowable.mValue);
        continue;
        localIntent.putExtra(localThrowable.mKey, Boolean.parseBoolean(localThrowable.mValue));
        continue;
        localIntent.putExtra(localThrowable.mKey, Short.parseShort(localThrowable.mValue));
      }
      else
      {
        if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mUidKey)) {
          localIntent.putExtra(paramMSolution.mJumpIntent.mUidKey, Process.myUid());
        }
        return localIntent;
      }
    }
  }
  
  private static Pair a(Context paramContext, MSolution paramMSolution, int paramInt)
  {
    if (((paramMSolution.mIntentCheck & 0x1) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mAction)))
    {
      cl.d("ManualSolutionManager", "invalid solution, intent action is empty, adapterID:" + paramInt);
      f.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if (((paramMSolution.mIntentCheck & 0x2) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mUri)))
    {
      cl.d("ManualSolutionManager", "invalid solution, intent uri is empty, adapterID:" + paramInt);
      f.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if (((paramMSolution.mIntentCheck & 0x4) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mType)))
    {
      cl.d("ManualSolutionManager", "invalid solution, intent type is empty, adapterID:" + paramInt);
      f.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if ((paramMSolution.mIntentCheck & 0x8) != 0) {
      return b(paramContext, paramMSolution, paramInt);
    }
    return new Pair(Boolean.valueOf(true), Integer.valueOf(0));
  }
  
  private static m a()
  {
    return p.a();
  }
  
  private static ArrayList a(Context paramContext, MSolution paramMSolution, int paramInt1, int paramInt2)
  {
    String str2 = paramContext.getFilesDir() + "/mguide_solution";
    Object localObject1 = new File(str2);
    if (((File)localObject1).exists())
    {
      if ((!((File)localObject1).isDirectory()) && ((!((File)localObject1).delete()) || (!((File)localObject1).mkdir()))) {
        return null;
      }
    }
    else if (!((File)localObject1).mkdir()) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramMSolution.mHelpImageList.iterator();
    int i = 1;
    String str1;
    if (localIterator.hasNext()) {
      str1 = (String)localIterator.next();
    }
    for (;;)
    {
      String str3;
      File localFile;
      try
      {
        if (!str1.contains("/")) {
          break label407;
        }
        localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          f.a(paramContext, paramInt1, 1, paramInt2);
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = str1;
        continue;
        str3 = str2 + "/" + localObject2;
        localFile = new File(str3);
        if (localFile == null) {
          break label256;
        }
      }
      if (!localFile.exists())
      {
        label256:
        localArrayList2.add(str3);
        localArrayList3.add(localObject2);
        localArrayList4.add(str1);
        i = 0;
      }
      for (;;)
      {
        break;
        localArrayList1.add(str3);
      }
      if (i == 0)
      {
        if (!paramMSolution.mHelpImageLocal)
        {
          paramInt1 = 0;
          while (paramInt1 < localArrayList4.size())
          {
            a().a(paramContext, (String)localArrayList4.get(paramInt1), (String)localArrayList2.get(paramInt1), str2, true, false);
            paramInt1 += 1;
          }
        }
        paramInt1 = 0;
        while (paramInt1 < localArrayList2.size())
        {
          a().a(paramContext, (String)localArrayList3.get(paramInt1), (String)localArrayList2.get(paramInt1), str2, false);
          paramInt1 += 1;
        }
        return null;
      }
      return localArrayList1;
      label407:
      Object localObject2 = str1;
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramContext = new n(this, paramString2, paramContext, paramString1, paramBoolean, paramString3);
    com.tencent.qqpimsecure.taiji.f.a().d().addTask(paramContext, "Move");
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = new o(this, paramString2, paramString1, paramBoolean2, paramString3, paramBoolean1, paramContext);
    com.tencent.qqpimsecure.taiji.f.a().d().addTask(paramContext, "Download");
  }
  
  private static Pair b(Context paramContext, MSolution paramMSolution, int paramInt)
  {
    if ((TextUtils.isEmpty(paramMSolution.mJumpIntent.mPackage)) || (TextUtils.isEmpty(paramMSolution.mJumpIntent.mClass)))
    {
      cl.d("ManualSolutionManager", "invalid solution, intent package or class is empty, adapterID:" + paramInt);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).setClassName(paramMSolution.mJumpIntent.mPackage, paramMSolution.mJumpIntent.mClass);
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramMSolution.mJumpIntent.mPackage, 0);
        if (localPackageInfo == null) {
          break label644;
        }
        i = localPackageInfo.versionCode;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject2 = localPackageManager.resolveActivity((Intent)localObject2, 0);
          if ((localObject2 == null) || (((ResolveInfo)localObject2).activityInfo == null))
          {
            cl.d("ManualSolutionManager", "invalid solution, intent resolveActivity intentInfo or activityInfo is null, adapterID:" + paramInt);
            f.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
            localThrowable1 = localThrowable1;
            localObject1 = null;
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          Object localObject3 = null;
          continue;
          if ((!paramContext.getPackageName().equals(paramMSolution.mJumpIntent.mPackage)) && (!localObject3.activityInfo.exported))
          {
            cl.d("ManualSolutionManager", "invalid solution, intent activityInfo package is not exported, adapterID:" + paramInt);
            f.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
          if ((!TextUtils.isEmpty(localObject3.activityInfo.permission)) && (localPackageManager.checkPermission(localObject3.activityInfo.permission, paramContext.getPackageName()) == -1))
          {
            cl.d("ManualSolutionManager", "invalid solution, intent activityInfo permission is denied, adapterID:" + paramInt);
            f.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
          int j = localPackageManager.getApplicationEnabledSetting(paramMSolution.mJumpIntent.mPackage);
          if ((j == 2) || (j == 3) || (j == 4))
          {
            cl.d("ManualSolutionManager", "invalid solution, intent package state is disabled, adapterID:" + paramInt);
            f.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
          if ((paramMSolution.mHelpInfoAdapter != null) && (!paramMSolution.mHelpInfoAdapter.isEmpty()))
          {
            if (localObject1 == null)
            {
              cl.d("ManualSolutionManager", "invalid solution, intent pkgInfo is null, adapterID:" + paramInt);
              f.a(paramContext, paramInt, 1, i);
              return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
            }
            if (!paramMSolution.mHelpInfoAdapter.containsKey(Integer.valueOf(i))) {
              break label595;
            }
            paramContext = (String)paramMSolution.mHelpInfoAdapter.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(paramContext)) {
              paramMSolution.mHelpInfo = paramContext;
            }
          }
          return new Pair(Boolean.valueOf(true), Integer.valueOf(i));
        }
      }
      label595:
      cl.d("ManualSolutionManager", "invalid solution, intent pkgVerCode is wrong, adapterID:" + paramInt);
      f.a(paramContext, paramInt, 1, i);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
      label644:
      int i = 0;
    }
  }
  
  private static ArrayList b(Context paramContext, MSolution paramMSolution, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = new ArrayList();
    String str2 = paramContext.getFilesDir() + "/mguide_solution";
    Object localObject1 = new File(str2);
    if (((File)localObject1).exists())
    {
      if ((!((File)localObject1).isDirectory()) && ((!((File)localObject1).delete()) || (!((File)localObject1).mkdir()))) {
        return null;
      }
    }
    else if (!((File)localObject1).mkdir()) {
      return null;
    }
    String str1 = paramMSolution.mHelpDoraemonZip.mDoraemonZipUrl;
    try
    {
      if (str1.contains("/"))
      {
        localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          f.a(paramContext, paramInt1, 1, paramInt2);
          return null;
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        Object localObject2 = str1;
        continue;
        if (localObject2.contains(".")) {}
        for (Object localObject3 = localObject2.substring(0, localObject2.lastIndexOf("."));; localObject3 = localObject2)
        {
          String str3 = str2 + "/" + localObject2;
          int j = paramMSolution.mHelpDoraemonZip.mDoraemonResList.size();
          int i = 0;
          Object localObject4;
          ArrayList localArrayList2;
          label319:
          Object localObject6;
          if (i < j)
          {
            localObject4 = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i)).mFileList;
            int k = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i)).mDoraemonType;
            if (((k == 1) || (k == 2)) && ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())))
            {
              f.a(paramContext, paramInt1, 1, paramInt2);
              return null;
            }
            localArrayList2 = new ArrayList();
            Iterator localIterator = ((ArrayList)localObject4).iterator();
            if (localIterator.hasNext())
            {
              localObject6 = (String)localIterator.next();
              localObject4 = localObject6;
            }
          }
          for (;;)
          {
            try
            {
              if (((String)localObject6).contains("/")) {
                localObject4 = ((String)localObject6).substring(((String)localObject6).lastIndexOf("/") + 1);
              }
              if (TextUtils.isEmpty((CharSequence)localObject4))
              {
                f.a(paramContext, paramInt1, 1, paramInt2);
                return null;
              }
              localObject4 = str2 + "/" + (String)localObject3 + "/" + (String)localObject4;
              localObject6 = new File((String)localObject4);
              if ((localObject6 == null) || (!((File)localObject6).exists()))
              {
                paramInt1 = 0;
                if (paramInt1 != 0) {
                  continue;
                }
                if (!paramMSolution.mHelpImageLocal)
                {
                  a().a(paramContext, str1, str3, str2, true, true);
                  return null;
                }
              }
              else
              {
                localArrayList2.add(localObject4);
                break label319;
                localArrayList1.add(localArrayList2);
                i += 1;
                break;
              }
              a().a(paramContext, localObject2, str3, str2, true);
              continue;
              return localArrayList1;
            }
            catch (Throwable localThrowable2)
            {
              Object localObject5 = localObject6;
              continue;
            }
            paramInt1 = 1;
          }
        }
        localObject2 = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.m
 * JD-Core Version:    0.7.0.1
 */