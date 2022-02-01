package com.tencent.mobileqq.richmedia.capture.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class CaptureRedDotConfig
  implements Serializable
{
  public static final String CACHE_RED_DOT_NAME = "qim_red_dot_config.cfg";
  public static final String DEFAULT_CATEGORY_ID = "defaultCategoryId";
  public static final String DEFAULT_CATEGORY_VERSION = "defaultCategoryVersion";
  public static final String DEFAULT_USE_ID = "defaultUseId";
  public static final String DEFAULT_USE_VERSION = "defaultUseVersion";
  public static final int DOT_DEFAULT_CATEGORY = 5;
  public static final int DOT_TYPE_DEFAULT_USE = 4;
  public static final int DOT_TYPE_ITEM_ICON = 3;
  public static final int DOT_TYPE_SECOND_ICON = 2;
  public static final int DOT_TYPE_TOP_ICON = 1;
  public static final String ICON_VERSION_ID = "iconRedDotVersion";
  public static final int ILLEGAL_INDEX = -1;
  public static final String RED_DOT_LIST = "itemNeedRedDot";
  public static final String RED_DOT_LIST_VERSION = "itemRedDotVersion";
  public static final String SHOW_RED_DOT = "needRedDot";
  public static int SHOW_TIME_DEFAULT = 86400000;
  public static final String TAG = "QIMRedDotConfig";
  public static final int TYPE_FILTER_REDDOT = 1;
  public static final int TYPE_PTV_TEMPLATE_REDDOT = 2;
  public static final String VERSION_ID = "redDotVersion";
  private static final long serialVersionUID = 1L;
  public HashMap<Integer, CategoryRedConfig> categories = new HashMap();
  public int defaultCategoryId;
  public int defaultCategoryVer;
  public String defaultUseId;
  public int defaultUseVer;
  public long firstShowTime;
  public boolean hasChoose;
  public boolean hasShow;
  public boolean hasUse;
  public int iconVersion;
  public transient boolean isShowing = false;
  public HashMap<String, RedDotItemConfig> redDotItems = new HashMap();
  public int redDotVersion;
  public boolean showRedDot;
  public int showTime;
  public int type;
  public transient boolean update = false;
  
  public CaptureRedDotConfig(int paramInt)
  {
    this.type = paramInt;
  }
  
  /* Error */
  public static CaptureRedDotConfig getRedDotConfigFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 122	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 16
    //   16: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore 4
    //   21: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +62 -> 86
    //   27: new 133	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   34: ldc 58
    //   36: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: iconst_2
    //   47: new 133	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   54: ldc 144
    //   56: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload 4
    //   61: invokevirtual 147	java/io/File:getPath	()Ljava/lang/String;
    //   64: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 149
    //   69: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 152	java/io/File:exists	()Z
    //   77: invokevirtual 155	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   80: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload 4
    //   88: invokevirtual 152	java/io/File:exists	()Z
    //   91: ifeq -84 -> 7
    //   94: new 161	java/io/ObjectInputStream
    //   97: dup
    //   98: new 163	java/io/BufferedInputStream
    //   101: dup
    //   102: new 165	java/io/FileInputStream
    //   105: dup
    //   106: aload 4
    //   108: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   111: invokespecial 171	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: invokespecial 172	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   117: astore_2
    //   118: aload_2
    //   119: astore_0
    //   120: aload_2
    //   121: invokevirtual 176	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   124: checkcast 2	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig
    //   127: astore_3
    //   128: aload_2
    //   129: astore_0
    //   130: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +47 -> 180
    //   136: aload_2
    //   137: astore_0
    //   138: new 133	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   145: ldc 58
    //   147: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: iconst_2
    //   158: new 133	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   165: ldc 178
    //   167: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_3
    //   171: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_3
    //   181: astore_0
    //   182: aload_2
    //   183: ifnull +9 -> 192
    //   186: aload_2
    //   187: invokevirtual 184	java/io/ObjectInputStream:close	()V
    //   190: aload_3
    //   191: astore_0
    //   192: aload_0
    //   193: areturn
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_1
    //   198: astore_0
    //   199: aload 4
    //   201: invokevirtual 187	java/io/File:delete	()Z
    //   204: pop
    //   205: aload_1
    //   206: astore_0
    //   207: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +33 -> 243
    //   213: aload_1
    //   214: astore_0
    //   215: ldc 58
    //   217: iconst_2
    //   218: new 133	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   225: ldc 189
    //   227: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_3
    //   231: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_1
    //   244: ifnull +51 -> 295
    //   247: aload_1
    //   248: invokevirtual 184	java/io/ObjectInputStream:close	()V
    //   251: aconst_null
    //   252: astore_0
    //   253: goto -61 -> 192
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_0
    //   259: goto -67 -> 192
    //   262: astore_1
    //   263: aconst_null
    //   264: astore_0
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 184	java/io/ObjectInputStream:close	()V
    //   273: aload_1
    //   274: athrow
    //   275: astore_0
    //   276: aload_3
    //   277: astore_0
    //   278: goto -86 -> 192
    //   281: astore_0
    //   282: goto -9 -> 273
    //   285: astore_1
    //   286: goto -21 -> 265
    //   289: astore_3
    //   290: aload_2
    //   291: astore_1
    //   292: goto -95 -> 197
    //   295: aconst_null
    //   296: astore_0
    //   297: goto -105 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramString1	String
    //   0	300	1	paramString2	String
    //   117	174	2	localObjectInputStream	java.io.ObjectInputStream
    //   127	64	3	localCaptureRedDotConfig	CaptureRedDotConfig
    //   194	83	3	localException1	java.lang.Exception
    //   289	1	3	localException2	java.lang.Exception
    //   19	181	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   94	118	194	java/lang/Exception
    //   247	251	256	java/io/IOException
    //   94	118	262	finally
    //   186	190	275	java/io/IOException
    //   269	273	281	java/io/IOException
    //   120	128	285	finally
    //   130	136	285	finally
    //   138	180	285	finally
    //   199	205	285	finally
    //   207	213	285	finally
    //   215	243	285	finally
    //   120	128	289	java/lang/Exception
    //   130	136	289	java/lang/Exception
    //   138	180	289	java/lang/Exception
  }
  
  public static void saveRedDotConfig(CaptureRedDotConfig paramCaptureRedDotConfig, String paramString1, String paramString2)
  {
    if ((paramCaptureRedDotConfig == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig" + paramString2, 2, "saveRedDotConfig|config= " + paramCaptureRedDotConfig);
    }
    ThreadManager.getFileThreadHandler().post(new CaptureRedDotConfig.1(paramString1, paramCaptureRedDotConfig, paramString2));
  }
  
  public boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      return showIconRedDot();
    case 2: 
      return showCategoryRedDot(paramInt2);
    }
    return showRedDot(paramInt2, paramString);
  }
  
  public boolean showCategoryRedDot(int paramInt)
  {
    CategoryRedConfig localCategoryRedConfig;
    if (this.categories.size() > 0)
    {
      localCategoryRedConfig = (CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt));
      if ((localCategoryRedConfig != null) && (localCategoryRedConfig.showRedDot))
      {
        if (localCategoryRedConfig.hasShow) {
          break label142;
        }
        if (localCategoryRedConfig.firstShowTime <= 0L) {
          break label123;
        }
        if (System.currentTimeMillis() - localCategoryRedConfig.firstShowTime < this.showTime)
        {
          localCategoryRedConfig.isShowing = true;
          return true;
        }
        this.update = true;
        localCategoryRedConfig.hasShow = true;
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot out of time | id=" + localCategoryRedConfig.categoryId);
        }
      }
    }
    for (;;)
    {
      return false;
      label123:
      this.update = true;
      localCategoryRedConfig.firstShowTime = System.currentTimeMillis();
      localCategoryRedConfig.isShowing = true;
      return true;
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot hasShow | id=" + localCategoryRedConfig.categoryId);
      }
    }
  }
  
  public boolean showIconRedDot()
  {
    if (!this.showRedDot) {}
    do
    {
      do
      {
        return false;
        if (!this.hasShow) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QIMRedDotConfig", 2, "showIconRedDot hasShow | type=" + this.type);
      return false;
      if (this.firstShowTime <= 0L) {
        break label133;
      }
      if (System.currentTimeMillis() - this.firstShowTime < this.showTime) {
        break;
      }
      this.hasShow = true;
      this.update = true;
    } while (!QLog.isColorLevel());
    QLog.d("QIMRedDotConfig", 2, "showIconRedDot out of time | type=" + this.type);
    return false;
    this.isShowing = true;
    return true;
    label133:
    this.firstShowTime = System.currentTimeMillis();
    this.isShowing = true;
    this.update = true;
    return true;
  }
  
  public boolean showRedDot(int paramInt, String paramString)
  {
    if ((this.redDotItems.isEmpty()) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (paramString.equals(this.defaultUseId)) {
      return false;
    }
    paramString = (RedDotItemConfig)this.redDotItems.get(paramString);
    if (paramString != null)
    {
      if (paramString.hasShow) {
        break label154;
      }
      if (paramString.firstShowTime <= 0L) {
        break label135;
      }
      if (System.currentTimeMillis() - paramString.firstShowTime < this.showTime)
      {
        paramString.isShowing = true;
        return true;
      }
      this.update = true;
      paramString.hasShow = true;
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig", 2, "showRedDot out of time | id=" + paramString.filterId);
      }
    }
    for (;;)
    {
      return false;
      label135:
      this.update = true;
      paramString.firstShowTime = System.currentTimeMillis();
      paramString.isShowing = true;
      return true;
      label154:
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig", 2, "showRedDot hasShow | id=" + paramString.filterId);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("QIMRedDotConfig{");
    localStringBuilder.append("type=").append(this.type);
    localStringBuilder.append(", iconVersion=").append(this.iconVersion);
    localStringBuilder.append(", showRedDot=").append(this.showRedDot);
    localStringBuilder.append(", hasShow=").append(this.hasShow);
    localStringBuilder.append(", firstShowTime=").append(this.firstShowTime);
    localStringBuilder.append(", defaultUseVer=").append(this.defaultUseVer);
    localStringBuilder.append(", defaultUseId='").append(this.defaultUseId).append('\'');
    localStringBuilder.append(", hasUse=").append(this.hasUse);
    localStringBuilder.append(", defaultCategoryVer=").append(this.defaultCategoryVer);
    localStringBuilder.append(", defaultCategoryId=").append(this.defaultCategoryId);
    localStringBuilder.append(", hasChoose=").append(this.hasChoose);
    localStringBuilder.append(", redDotVersion=").append(this.redDotVersion);
    localStringBuilder.append(", redDotItems=").append(this.redDotItems);
    localStringBuilder.append(", showTime=").append(this.showTime);
    Iterator localIterator = this.categories.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getValue() + "\n");
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public boolean updateRedDotInfo(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        this.update = true;
      }
      return bool;
      if ((!this.isShowing) || (this.hasShow)) {
        break;
      }
      this.hasShow = true;
      this.firstShowTime = 0L;
      this.isShowing = false;
      bool = true;
      continue;
      paramString = (CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt2));
      if ((paramString == null) || (!paramString.isShowing) || (paramString.hasShow)) {
        break;
      }
      paramString.hasShow = true;
      paramString.firstShowTime = 0L;
      paramString.isShowing = false;
      if (QLog.isColorLevel())
      {
        QLog.d("QIMRedDotConfig", 2, "更新has show = " + paramString.hasShow);
        bool = true;
        continue;
        paramString = (RedDotItemConfig)this.redDotItems.get(paramString);
        if ((paramString == null) || (!paramString.isShowing) || (paramString.hasShow)) {
          break;
        }
        paramString.hasShow = true;
        paramString.firstShowTime = 0L;
        paramString.isShowing = false;
        bool = true;
        continue;
        if ((TextUtils.isEmpty(this.defaultUseId)) || (this.hasUse)) {
          break;
        }
        this.hasUse = true;
        bool = true;
        continue;
        if ((this.defaultCategoryId == -1) || (this.hasChoose)) {
          break;
        }
        this.hasChoose = true;
        bool = true;
        continue;
      }
      bool = true;
    }
  }
  
  public static class CategoryRedConfig
    implements Serializable
  {
    public int categoryId;
    public long firstShowTime;
    public boolean hasShow;
    public transient boolean isShowing = false;
    public boolean showRedDot;
    public int version;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("categoryId=").append(this.categoryId);
      localStringBuilder.append(", version=").append(this.version);
      localStringBuilder.append(", showRedDot=").append(this.showRedDot);
      localStringBuilder.append(", hasShow=").append(this.hasShow);
      localStringBuilder.append(", firstShowTime=").append(this.firstShowTime);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class RedDotItemConfig
    implements Serializable
  {
    public String filterId;
    public long firstShowTime;
    public boolean hasShow;
    public transient boolean isShowing = false;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("RedDotItemConfig{");
      localStringBuilder.append("filterId='").append(this.filterId).append('\'');
      localStringBuilder.append(", hasShow=").append(this.hasShow);
      localStringBuilder.append(", firstShowTime=").append(this.firstShowTime);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig
 * JD-Core Version:    0.7.0.1
 */