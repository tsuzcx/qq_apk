package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel
  extends DataSetObservable
{
  static final String ATTRIBUTE_ACTIVITY = "activity";
  static final String ATTRIBUTE_TIME = "time";
  static final String ATTRIBUTE_WEIGHT = "weight";
  static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  static final String TAG_HISTORICAL_RECORD = "historical-record";
  static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map sDataModelRegistry = new HashMap();
  private static final Object sRegistryLock = new Object();
  private final List mActivities = new ArrayList();
  private ActivityChooserModel.OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivityChooserModel.ActivitySorter mActivitySorter = new ActivityChooserModel.DefaultSorter();
  boolean mCanReadHistoricalData = true;
  final Context mContext;
  private final List mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  final String mHistoryFileName;
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
  
  private boolean addHistoricalRecord(ActivityChooserModel.HistoricalRecord paramHistoricalRecord)
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
          this.mActivities.add(new ActivityChooserModel.ActivityResolveInfo(localResolveInfo));
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
    new ActivityChooserModel.PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.mHistoricalRecords), this.mHistoryFileName });
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
    //   1: getfield 119	android/support/v7/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 143	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   8: invokevirtual 256	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 262	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc_w 264
    //   21: invokeinterface 270 3 0
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iconst_1
    //   30: if_icmpeq +18 -> 48
    //   33: iload_1
    //   34: iconst_2
    //   35: if_icmpeq +13 -> 48
    //   38: aload_3
    //   39: invokeinterface 273 1 0
    //   44: istore_1
    //   45: goto -17 -> 28
    //   48: ldc 40
    //   50: aload_3
    //   51: invokeinterface 276 1 0
    //   56: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifne +55 -> 114
    //   62: new 250	org/xmlpull/v1/XmlPullParserException
    //   65: dup
    //   66: ldc_w 281
    //   69: invokespecial 282	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: astore_3
    //   74: getstatic 72	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   77: new 133	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 284
    //   87: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 143	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   94: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: aload_3
    //   101: invokestatic 290	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   104: pop
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 295	java/io/FileInputStream:close	()V
    //   113: return
    //   114: aload_0
    //   115: getfield 96	android/support/v7/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   118: astore 4
    //   120: aload 4
    //   122: invokeinterface 189 1 0
    //   127: aload_3
    //   128: invokeinterface 273 1 0
    //   133: istore_1
    //   134: iload_1
    //   135: iconst_1
    //   136: if_icmpne +14 -> 150
    //   139: aload_2
    //   140: ifnull -27 -> 113
    //   143: aload_2
    //   144: invokevirtual 295	java/io/FileInputStream:close	()V
    //   147: return
    //   148: astore_2
    //   149: return
    //   150: iload_1
    //   151: iconst_3
    //   152: if_icmpeq -25 -> 127
    //   155: iload_1
    //   156: iconst_4
    //   157: if_icmpeq -30 -> 127
    //   160: ldc 37
    //   162: aload_3
    //   163: invokeinterface 276 1 0
    //   168: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +57 -> 228
    //   174: new 250	org/xmlpull/v1/XmlPullParserException
    //   177: dup
    //   178: ldc_w 297
    //   181: invokespecial 282	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   184: athrow
    //   185: astore_3
    //   186: getstatic 72	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   189: new 133	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 284
    //   199: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_0
    //   203: getfield 143	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   206: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: aload_3
    //   213: invokestatic 290	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   216: pop
    //   217: aload_2
    //   218: ifnull -105 -> 113
    //   221: aload_2
    //   222: invokevirtual 295	java/io/FileInputStream:close	()V
    //   225: return
    //   226: astore_2
    //   227: return
    //   228: aload 4
    //   230: new 243	android/support/v7/widget/ActivityChooserModel$HistoricalRecord
    //   233: dup
    //   234: aload_3
    //   235: aconst_null
    //   236: ldc 8
    //   238: invokeinterface 301 3 0
    //   243: aload_3
    //   244: aconst_null
    //   245: ldc 11
    //   247: invokeinterface 301 3 0
    //   252: invokestatic 307	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   255: aload_3
    //   256: aconst_null
    //   257: ldc 14
    //   259: invokeinterface 301 3 0
    //   264: invokestatic 313	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   267: invokespecial 316	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   270: invokeinterface 151 2 0
    //   275: pop
    //   276: goto -149 -> 127
    //   279: astore_3
    //   280: aload_2
    //   281: ifnull +7 -> 288
    //   284: aload_2
    //   285: invokevirtual 295	java/io/FileInputStream:close	()V
    //   288: aload_3
    //   289: athrow
    //   290: astore_2
    //   291: return
    //   292: astore_2
    //   293: goto -5 -> 288
    //   296: astore_2
    //   297: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	ActivityChooserModel
    //   27	131	1	i	int
    //   11	133	2	localFileInputStream	java.io.FileInputStream
    //   148	74	2	localIOException1	java.io.IOException
    //   226	59	2	localIOException2	java.io.IOException
    //   290	1	2	localIOException3	java.io.IOException
    //   292	1	2	localIOException4	java.io.IOException
    //   296	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   15	36	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   73	90	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   185	71	3	localIOException5	java.io.IOException
    //   279	10	3	localObject	Object
    //   118	111	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   12	26	73	org/xmlpull/v1/XmlPullParserException
    //   38	45	73	org/xmlpull/v1/XmlPullParserException
    //   48	73	73	org/xmlpull/v1/XmlPullParserException
    //   114	127	73	org/xmlpull/v1/XmlPullParserException
    //   127	134	73	org/xmlpull/v1/XmlPullParserException
    //   160	185	73	org/xmlpull/v1/XmlPullParserException
    //   228	276	73	org/xmlpull/v1/XmlPullParserException
    //   143	147	148	java/io/IOException
    //   12	26	185	java/io/IOException
    //   38	45	185	java/io/IOException
    //   48	73	185	java/io/IOException
    //   114	127	185	java/io/IOException
    //   127	134	185	java/io/IOException
    //   160	185	185	java/io/IOException
    //   228	276	185	java/io/IOException
    //   221	225	226	java/io/IOException
    //   12	26	279	finally
    //   38	45	279	finally
    //   48	73	279	finally
    //   74	105	279	finally
    //   114	127	279	finally
    //   127	134	279	finally
    //   160	185	279	finally
    //   186	217	279	finally
    //   228	276	279	finally
    //   109	113	290	java/io/IOException
    //   284	288	292	java/io/IOException
    //   0	12	296	java/io/FileNotFoundException
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
      addHistoricalRecord(new ActivityChooserModel.HistoricalRecord((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
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
          addHistoricalRecord(new ActivityChooserModel.HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserModel
 * JD-Core Version:    0.7.0.1
 */