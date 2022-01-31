package com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.Log;
import hiz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SDCardMountInforUtil
  implements ISDCardMountInfor
{
  private static SDCardMountInforUtil jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterSdcardmountinforutilSDCardMountInforUtil;
  private final int jdField_a_of_type_Int = 0;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new hiz(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private final File jdField_a_of_type_JavaIoFile = new File(Environment.getRootDirectory().getAbsoluteFile() + File.separator + "etc" + File.separator + "vold.conf");
  public final String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final int jdField_b_of_type_Int = 1;
  private final File jdField_b_of_type_JavaIoFile = new File(Environment.getRootDirectory().getAbsoluteFile() + File.separator + "etc" + File.separator + "vold.fstab");
  private final String jdField_b_of_type_JavaLangString = "mount_point";
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private final int jdField_c_of_type_Int = 2;
  private final String jdField_c_of_type_JavaLangString = "dev_mount";
  private int d = 0;
  private final int e = 2;
  
  private SDCardMountInforUtil(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b(paramContext);
    if (a() < 8) {
      this.d = 0;
    }
    for (;;)
    {
      a(this.d);
      return;
      if (a() < 11) {
        this.d = 1;
      } else {
        this.d = 2;
      }
    }
  }
  
  public static SDCardMountInforUtil a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterSdcardmountinforutilSDCardMountInforUtil == null) {
        jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterSdcardmountinforutilSDCardMountInforUtil = new SDCardMountInforUtil(paramContext);
      }
      paramContext = jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterSdcardmountinforutilSDCardMountInforUtil;
      return paramContext;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(this.jdField_a_of_type_JavaIoFile));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.startsWith("mount_point")) {
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
        }
      }
      d();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      return;
      localException.close();
      this.jdField_a_of_type_JavaUtilArrayList.trimToSize();
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      c();
      return;
    case 0: 
      a();
      return;
    }
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(this.jdField_b_of_type_JavaIoFile));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.startsWith("dev_mount")) {
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
        }
      }
      d();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      return;
      localException.close();
      this.jdField_a_of_type_JavaUtilArrayList.trimToSize();
    }
  }
  
  private void b(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
    localIntentFilter.addDataScheme("file");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      paramString = new File(paramString);
      if ((!paramString.exists()) || (paramString.list() == null)) {
        break;
      }
      paramString = paramString.list();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        Log.i("kapalai", "--------" + str);
        i += 1;
      }
    }
    return true;
  }
  
  @TargetApi(9)
  private void c()
  {
    if (this.d == 2)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      Object localObject = (StorageManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("storage");
      try
      {
        localObject = (String[])localObject.getClass().getMethod("getVolumePaths", null).invoke(localObject, null);
        int i = 0;
        int j = localObject.length;
        while ((i < j) && (!b(localObject[i])))
        {
          this.jdField_b_of_type_JavaUtilArrayList.add(i, localObject[i]);
          i += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.get(i) != null)
      {
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).split(" ");
        k = j;
        if (arrayOfString != null)
        {
          k = j;
          if (!b(arrayOfString[2]))
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(j, arrayOfString[2]);
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(j, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int a()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public ArrayList a()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < 1) {
      a(this.d);
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    paramContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    } while ((paramString.endsWith(this.jdField_a_of_type_JavaLangString)) || (!localFile.exists()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil
 * JD-Core Version:    0.7.0.1
 */