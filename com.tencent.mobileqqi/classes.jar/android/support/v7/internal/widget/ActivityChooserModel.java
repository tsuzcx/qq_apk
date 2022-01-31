package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityChooserModel
  extends DataSetObservable
{
  private static final String ATTRIBUTE_ACTIVITY = "activity";
  private static final String ATTRIBUTE_TIME = "time";
  private static final String ATTRIBUTE_WEIGHT = "weight";
  private static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final String TAG_HISTORICAL_RECORD = "historical-record";
  private static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map sDataModelRegistry = new HashMap();
  private static final Object sRegistryLock = new Object();
  private final List mActivities = new ArrayList();
  private ActivityChooserModel.OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivityChooserModel.ActivitySorter mActivitySorter = new ActivityChooserModel.DefaultSorter(this, null);
  private boolean mCanReadHistoricalData = true;
  private final Context mContext;
  private final List mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  private final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  private boolean mReloadActivities = false;
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      this.mHistoryFileName = (paramString + ".xml");
      return;
    }
    this.mHistoryFileName = paramString;
  }
  
  private boolean addHisoricalRecord(ActivityChooserModel.HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
    if (bool)
    {
      this.mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      persistHistoricalDataIfNeeded();
      sortActivitiesIfNeeded();
      notifyChanged();
    }
    return bool;
  }
  
  private void ensureConsistentState()
  {
    boolean bool1 = loadActivitiesIfNeeded();
    boolean bool2 = readHistoricalDataIfNeeded();
    pruneExcessiveHistoricalRecordsIfNeeded();
    if ((bool1 | bool2))
    {
      sortActivitiesIfNeeded();
      notifyChanged();
    }
  }
  
  private void executePersistHistoryAsyncTaskBase()
  {
    new ActivityChooserModel.PersistHistoryAsyncTask(this, null).execute(new Object[] { new ArrayList(this.mHistoricalRecords), this.mHistoryFileName });
  }
  
  private void executePersistHistoryAsyncTaskSDK11()
  {
    new ActivityChooserModel.PersistHistoryAsyncTask(this, null).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Object[] { new ArrayList(this.mHistoricalRecords), this.mHistoryFileName });
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel2 = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      ActivityChooserModel localActivityChooserModel1 = localActivityChooserModel2;
      if (localActivityChooserModel2 == null)
      {
        localActivityChooserModel1 = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel1);
      }
      return localActivityChooserModel1;
    }
  }
  
  private boolean loadActivitiesIfNeeded()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mReloadActivities)
    {
      bool1 = bool2;
      if (this.mIntent != null)
      {
        this.mReloadActivities = false;
        this.mActivities.clear();
        List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
          this.mActivities.add(new ActivityChooserModel.ActivityResolveInfo(this, localResolveInfo));
          i += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void persistHistoricalDataIfNeeded()
  {
    if (!this.mReadShareHistoryCalled) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.mHistoricalRecordsChanged) {}
    do
    {
      return;
      this.mHistoricalRecordsChanged = false;
    } while (TextUtils.isEmpty(this.mHistoryFileName));
    if (Build.VERSION.SDK_INT >= 11)
    {
      executePersistHistoryAsyncTaskSDK11();
      return;
    }
    executePersistHistoryAsyncTaskBase();
  }
  
  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int j = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
    if (j <= 0) {}
    for (;;)
    {
      return;
      this.mHistoricalRecordsChanged = true;
      int i = 0;
      while (i < j)
      {
        ActivityChooserModel.HistoricalRecord localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)this.mHistoricalRecords.remove(0);
        i += 1;
      }
    }
  }
  
  private boolean readHistoricalDataIfNeeded()
  {
    if ((this.mCanReadHistoricalData) && (this.mHistoricalRecordsChanged) && (!TextUtils.isEmpty(this.mHistoryFileName)))
    {
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = true;
      readHistoricalDataImpl();
      return true;
    }
    return false;
  }
  
  /* Error */
  private void readHistoricalDataImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 121	android/support/v7/internal/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 145	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   8: invokevirtual 278	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 284	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: aconst_null
    //   19: invokeinterface 290 3 0
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iconst_1
    //   28: if_icmpeq +18 -> 46
    //   31: iload_1
    //   32: iconst_2
    //   33: if_icmpeq +13 -> 46
    //   36: aload_3
    //   37: invokeinterface 293 1 0
    //   42: istore_1
    //   43: goto -17 -> 26
    //   46: ldc 40
    //   48: aload_3
    //   49: invokeinterface 296 1 0
    //   54: invokevirtual 299	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifne +55 -> 112
    //   60: new 272	org/xmlpull/v1/XmlPullParserException
    //   63: dup
    //   64: ldc_w 301
    //   67: invokespecial 302	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_3
    //   72: getstatic 72	android/support/v7/internal/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   75: new 135	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 304
    //   85: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_0
    //   89: getfield 145	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   92: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload_3
    //   99: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   102: pop
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 315	java/io/FileInputStream:close	()V
    //   111: return
    //   112: aload_0
    //   113: getfield 96	android/support/v7/internal/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   116: astore 4
    //   118: aload 4
    //   120: invokeinterface 220 1 0
    //   125: aload_3
    //   126: invokeinterface 293 1 0
    //   131: istore_1
    //   132: iload_1
    //   133: iconst_1
    //   134: if_icmpne +14 -> 148
    //   137: aload_2
    //   138: ifnull -27 -> 111
    //   141: aload_2
    //   142: invokevirtual 315	java/io/FileInputStream:close	()V
    //   145: return
    //   146: astore_2
    //   147: return
    //   148: iload_1
    //   149: iconst_3
    //   150: if_icmpeq -25 -> 125
    //   153: iload_1
    //   154: iconst_4
    //   155: if_icmpeq -30 -> 125
    //   158: ldc 37
    //   160: aload_3
    //   161: invokeinterface 296 1 0
    //   166: invokevirtual 299	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne +57 -> 226
    //   172: new 272	org/xmlpull/v1/XmlPullParserException
    //   175: dup
    //   176: ldc_w 317
    //   179: invokespecial 302	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: astore_3
    //   184: getstatic 72	android/support/v7/internal/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   187: new 135	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 304
    //   197: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_0
    //   201: getfield 145	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   204: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload_3
    //   211: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   214: pop
    //   215: aload_2
    //   216: ifnull -105 -> 111
    //   219: aload_2
    //   220: invokevirtual 315	java/io/FileInputStream:close	()V
    //   223: return
    //   224: astore_2
    //   225: return
    //   226: aload 4
    //   228: new 265	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord
    //   231: dup
    //   232: aload_3
    //   233: aconst_null
    //   234: ldc 8
    //   236: invokeinterface 321 3 0
    //   241: aload_3
    //   242: aconst_null
    //   243: ldc 11
    //   245: invokeinterface 321 3 0
    //   250: invokestatic 327	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   253: aload_3
    //   254: aconst_null
    //   255: ldc 14
    //   257: invokeinterface 321 3 0
    //   262: invokestatic 333	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   265: invokespecial 336	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   268: invokeinterface 160 2 0
    //   273: pop
    //   274: goto -149 -> 125
    //   277: astore_3
    //   278: aload_2
    //   279: ifnull +7 -> 286
    //   282: aload_2
    //   283: invokevirtual 315	java/io/FileInputStream:close	()V
    //   286: aload_3
    //   287: athrow
    //   288: astore_2
    //   289: return
    //   290: astore_2
    //   291: goto -5 -> 286
    //   294: astore_2
    //   295: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	ActivityChooserModel
    //   25	131	1	i	int
    //   11	131	2	localFileInputStream	java.io.FileInputStream
    //   146	74	2	localIOException1	java.io.IOException
    //   224	59	2	localIOException2	java.io.IOException
    //   288	1	2	localIOException3	java.io.IOException
    //   290	1	2	localIOException4	java.io.IOException
    //   294	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   15	34	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   71	90	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   183	71	3	localIOException5	java.io.IOException
    //   277	10	3	localObject	Object
    //   116	111	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   12	24	71	org/xmlpull/v1/XmlPullParserException
    //   36	43	71	org/xmlpull/v1/XmlPullParserException
    //   46	71	71	org/xmlpull/v1/XmlPullParserException
    //   112	125	71	org/xmlpull/v1/XmlPullParserException
    //   125	132	71	org/xmlpull/v1/XmlPullParserException
    //   158	183	71	org/xmlpull/v1/XmlPullParserException
    //   226	274	71	org/xmlpull/v1/XmlPullParserException
    //   141	145	146	java/io/IOException
    //   12	24	183	java/io/IOException
    //   36	43	183	java/io/IOException
    //   46	71	183	java/io/IOException
    //   112	125	183	java/io/IOException
    //   125	132	183	java/io/IOException
    //   158	183	183	java/io/IOException
    //   226	274	183	java/io/IOException
    //   219	223	224	java/io/IOException
    //   12	24	277	finally
    //   36	43	277	finally
    //   46	71	277	finally
    //   72	103	277	finally
    //   112	125	277	finally
    //   125	132	277	finally
    //   158	183	277	finally
    //   184	215	277	finally
    //   226	274	277	finally
    //   107	111	288	java/io/IOException
    //   282	286	290	java/io/IOException
    //   0	12	294	java/io/FileNotFoundException
  }
  
  private boolean sortActivitiesIfNeeded()
  {
    if ((this.mActivitySorter != null) && (this.mIntent != null) && (!this.mActivities.isEmpty()) && (!this.mHistoricalRecords.isEmpty()))
    {
      this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
      return true;
    }
    return false;
  }
  
  public Intent chooseActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == null) {
        return null;
      }
      ensureConsistentState();
      Object localObject2 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt);
      localObject2 = new ComponentName(((ActivityChooserModel.ActivityResolveInfo)localObject2).resolveInfo.activityInfo.packageName, ((ActivityChooserModel.ActivityResolveInfo)localObject2).resolveInfo.activityInfo.name);
      Intent localIntent1 = new Intent(this.mIntent);
      localIntent1.setComponent((ComponentName)localObject2);
      if (this.mActivityChoserModelPolicy != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent2)) {
          return null;
        }
      }
      addHisoricalRecord(new ActivityChooserModel.HistoricalRecord((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mActivities.size();
      return i;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i;
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        List localList = this.mActivities;
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (((ActivityChooserModel.ActivityResolveInfo)localList.get(i)).resolveInfo == paramResolveInfo) {
            return i;
          }
        }
        else {
          return -1;
        }
      }
      i += 1;
    }
  }
  
  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      if (!this.mActivities.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }
  
  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }
  
  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }
  
  public void setActivitySorter(ActivityChooserModel.ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter == paramActivitySorter) {
        return;
      }
      this.mActivitySorter = paramActivitySorter;
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    for (;;)
    {
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f = localActivityResolveInfo2.weight - localActivityResolveInfo1.weight + 5.0F;
          addHisoricalRecord(new ActivityChooserModel.HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize == paramInt) {
        return;
      }
      this.mHistoryMaxSize = paramInt;
      pruneExcessiveHistoricalRecordsIfNeeded();
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == paramIntent) {
        return;
      }
      this.mIntent = paramIntent;
      this.mReloadActivities = true;
      ensureConsistentState();
      return;
    }
  }
  
  public void setOnChooseActivityListener(ActivityChooserModel.OnChooseActivityListener paramOnChooseActivityListener)
  {
    synchronized (this.mInstanceLock)
    {
      this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel
 * JD-Core Version:    0.7.0.1
 */