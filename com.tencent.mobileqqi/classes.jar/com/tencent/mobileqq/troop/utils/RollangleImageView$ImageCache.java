package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import hbr;
import java.util.HashMap;
import java.util.LinkedList;

public class RollangleImageView$ImageCache
{
  private static ImageCache jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache = new ImageCache();
  public static final String a = "troopfileimage://";
  private Handler jdField_a_of_type_AndroidOsHandler;
  public HashMap a;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  public boolean a;
  
  private RollangleImageView$ImageCache()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838627));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838612));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838613));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838598));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838631));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838630));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838593));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838616));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838599));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838615));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838620));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838626));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838626));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new hbr(this, BaseApplication.getContext().getMainLooper());
  }
  
  public static ImageCache a()
  {
    return jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: ifnull -4 -> 11
    //   18: aload_0
    //   19: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   22: invokevirtual 97	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface 103 1 0
    //   32: ifeq -21 -> 11
    //   35: aload_2
    //   36: invokeinterface 107 1 0
    //   41: checkcast 109	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem
    //   44: astore_3
    //   45: aload_1
    //   46: aload_3
    //   47: getfield 111	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq -27 -> 26
    //   56: aload_0
    //   57: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   60: aload_3
    //   61: invokevirtual 120	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ImageCache
    //   0	73	1	paramString	String
    //   6	30	2	localObject	Object
    //   44	17	3	localQueueItem	RollangleImageView.ImageCache.QueueItem
    // Exception table:
    //   from	to	target	type
    //   2	7	68	finally
    //   18	26	68	finally
    //   26	65	68	finally
  }
  
  public Bitmap a(String paramString)
  {
    int i = -1;
    paramString = FileUtil.a(paramString);
    if (paramString != null) {
      i = FileManagerUtil.a(paramString);
    }
    return (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
  }
  
  public Bitmap a(String paramString, RollangleImageView paramRollangleImageView)
  {
    try
    {
      paramString = (Bitmap)BaseApplicationImpl.a.get("troopfileimage://" + paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   18: invokevirtual 158	java/util/LinkedList:clear	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	ImageCache
    //   6	2	1	localLinkedList	LinkedList
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally {}
  }
  
  /* Error */
  public Bitmap b(String paramString, RollangleImageView paramRollangleImageView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 141	com/tencent/common/app/BaseApplicationImpl:a	Landroid/support/v4/util/MQLruCache;
    //   5: new 143	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   12: ldc 9
    //   14: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 155	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 137	android/graphics/Bitmap
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   45: ifnonnull +14 -> 59
    //   48: aload_0
    //   49: new 93	java/util/LinkedList
    //   52: dup
    //   53: invokespecial 161	java/util/LinkedList:<init>	()V
    //   56: putfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   59: aload_0
    //   60: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   63: invokevirtual 164	java/util/LinkedList:isEmpty	()Z
    //   66: ifeq +21 -> 87
    //   69: new 166	java/lang/Thread
    //   72: dup
    //   73: new 168	hbq
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 171	hbq:<init>	(Lcom/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache;)V
    //   81: invokespecial 174	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   84: invokevirtual 177	java/lang/Thread:start	()V
    //   87: new 109	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem
    //   90: dup
    //   91: invokespecial 178	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: aload_2
    //   97: putfield 181	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView	Lcom/tencent/mobileqq/troop/utils/RollangleImageView;
    //   100: aload_3
    //   101: aload_1
    //   102: putfield 111	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: aload_0
    //   106: getfield 90	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   109: aload_3
    //   110: invokevirtual 184	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: aconst_null
    //   115: astore_1
    //   116: goto -79 -> 37
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	ImageCache
    //   0	124	1	paramString	String
    //   0	124	2	paramRollangleImageView	RollangleImageView
    //   30	80	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	119	finally
    //   41	59	119	finally
    //   59	87	119	finally
    //   87	114	119	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache
 * JD-Core Version:    0.7.0.1
 */