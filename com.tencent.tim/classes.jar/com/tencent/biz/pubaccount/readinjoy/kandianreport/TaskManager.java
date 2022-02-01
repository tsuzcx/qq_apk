package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import alkz;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import aqgz;
import aqhq;
import awit;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jpe;
import jqj;
import kbp;
import kxm;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class TaskManager
{
  private static String JSSCRIPT_CHECK_DIR;
  private static String JSSCRIPT_DISTRIBUTION_DIR;
  private static String JSSCRIPT_EXTRACTION_DIR;
  private static String JSSCRIPT_PROCESS_DIR;
  private static final String KANDIANREPORT_SCRIPTS_OFFLINE_BID = "3412";
  private static String SCRIPT_ROOT_PATH;
  private static final int SUPPORT_SCRIPT_VERSION = 1;
  private static final String TAG = "kandianreport.taskmanager";
  private static String TASK_CONFIG_DIR;
  public static final String TASK_ID = "kandianreport.taskmanager";
  public static final String TASK_ON = "kandianreport_ON";
  private static TaskManager _instance;
  private static List<String> configTaskIds;
  public static boolean isConfigureOn;
  private static boolean isStarted;
  private static long lastTime;
  public static int scriptVersion = -1;
  private static long timeLimit = 3600000L;
  private boolean isNetWorkStateRegistered;
  private INetInfoHandler netHandler = new TaskManager.1(this);
  private ArrayList<Task> taskList = new ArrayList();
  
  static
  {
    _instance = new TaskManager();
    try
    {
      isConfigureOn = getConfigOn();
      SCRIPT_ROOT_PATH = jpe.dO("3412") + "3412";
      JSSCRIPT_EXTRACTION_DIR = SCRIPT_ROOT_PATH + "/extraction";
      JSSCRIPT_PROCESS_DIR = SCRIPT_ROOT_PATH + "/process";
      JSSCRIPT_DISTRIBUTION_DIR = SCRIPT_ROOT_PATH + "/distribution";
      JSSCRIPT_CHECK_DIR = SCRIPT_ROOT_PATH + "/check";
      TASK_CONFIG_DIR = SCRIPT_ROOT_PATH + "/task_config";
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.taskmanager", 2, localThrowable.getLocalizedMessage());
    }
  }
  
  private TaskManager()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.2(this));
  }
  
  private void addConfigItem(ArrayList<Task.CONFIG_ITEM> paramArrayList, JSONObject paramJSONObject)
  {
    int j = 0;
    String str1 = paramJSONObject.optString("id");
    String str2 = paramJSONObject.optString("value");
    Object localObject2 = paramJSONObject.optJSONArray("output");
    Object localObject1 = paramJSONObject.optJSONArray("check");
    paramJSONObject = paramJSONObject.optJSONArray("args");
    Task.CONFIG_ITEM localCONFIG_ITEM = new Task.CONFIG_ITEM();
    localCONFIG_ITEM.id = str1;
    localCONFIG_ITEM.value = str2;
    int i;
    if (localObject2 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        str1 = (String)((JSONArray)localObject2).opt(i);
        localCONFIG_ITEM.output.add(str1);
        i += 1;
      }
    }
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = (String)((JSONArray)localObject1).opt(i);
        localCONFIG_ITEM.check.add(localObject2);
        i += 1;
      }
    }
    if (paramJSONObject != null)
    {
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject1 = (String)paramJSONObject.opt(i);
        localCONFIG_ITEM.args.add(localObject1);
        i += 1;
      }
    }
    paramArrayList.add(localCONFIG_ITEM);
  }
  
  public static String compress(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    int m = 1;
    if (k < paramString.length())
    {
      char c = paramString.charAt(k);
      label51:
      int j;
      if ((i == 0) && (c == '\\'))
      {
        i = 1;
        if (m == 0) {
          break label109;
        }
        j = m;
        if (c != ' ')
        {
          j = m;
          if (c != '\r')
          {
            j = m;
            if (c != '\n')
            {
              if (c != '\t') {
                break label109;
              }
              j = m;
            }
          }
        }
      }
      for (;;)
      {
        k += 1;
        m = j;
        break;
        i = 0;
        break label51;
        label109:
        localStringBuilder.append(c);
        j = m;
        if (c == '"')
        {
          j = m;
          if (i == 0) {
            if (m == 0) {
              j = 1;
            } else {
              j = 0;
            }
          }
        }
      }
    }
    return localStringBuilder.toString().replaceAll("\r\n", "\\\\r\\\\n");
  }
  
  private String formatArray(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      String str1 = "[";
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= paramArrayList.size()) {
          break;
        }
        str2 = str1;
        if (i != 0) {
          str2 = str1 + ',';
        }
        str1 = str2 + "'" + (String)paramArrayList.get(i) + "'";
        i += 1;
      }
    }
    String str2 = "[";
    return str2 + "]";
  }
  
  private ArrayList<String> getArgsByValue(ArrayList<Task.CONFIG_ITEM> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.CONFIG_ITEM localCONFIG_ITEM = (Task.CONFIG_ITEM)paramArrayList.next();
      if (localCONFIG_ITEM.value.equals(paramString)) {
        return localCONFIG_ITEM.args;
      }
    }
    return null;
  }
  
  private ArrayList<String> getCheckByValue(ArrayList<Task.CONFIG_ITEM> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.CONFIG_ITEM localCONFIG_ITEM = (Task.CONFIG_ITEM)paramArrayList.next();
      if (localCONFIG_ITEM.value.equals(paramString)) {
        return localCONFIG_ITEM.check;
      }
    }
    return null;
  }
  
  private ArrayList<String> getCheckName(Task paramTask, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramTask = getValueById(paramTask.check, paramArrayList);
    if ((paramTask != null) && (paramTask.length > 0)) {
      Collections.addAll(localArrayList, paramTask);
    }
    return localArrayList;
  }
  
  public static boolean getConfigOn()
  {
    return ((Integer)awit.f("kandianreport_ON", Integer.valueOf(0))).intValue() == 1;
  }
  
  public static TaskManager getInstance()
  {
    return _instance;
  }
  
  private String getMmapUtilsName(String paramString)
  {
    String str = kxm.getAppRuntime().getAccount();
    return str + "_" + paramString;
  }
  
  private ArrayList<String> getOutputByValue(ArrayList<Task.CONFIG_ITEM> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.CONFIG_ITEM localCONFIG_ITEM = (Task.CONFIG_ITEM)paramArrayList.next();
      if (localCONFIG_ITEM.value.equals(paramString)) {
        return localCONFIG_ITEM.output;
      }
    }
    return null;
  }
  
  private Task.CONFIG_ITEM[] getTasksById(ArrayList<Task.CONFIG_ITEM> paramArrayList, ArrayList<String> paramArrayList1)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      Task.CONFIG_ITEM[] arrayOfCONFIG_ITEM = new Task.CONFIG_ITEM[paramArrayList1.size()];
      int i = 0;
      while (i < paramArrayList1.size())
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          Task.CONFIG_ITEM localCONFIG_ITEM = (Task.CONFIG_ITEM)localIterator.next();
          if (localCONFIG_ITEM.id.equals(paramArrayList1.get(i))) {
            arrayOfCONFIG_ITEM[i] = localCONFIG_ITEM;
          }
        }
        i += 1;
      }
      return arrayOfCONFIG_ITEM;
    }
    return null;
  }
  
  private String[] getValueById(ArrayList<Task.CONFIG_ITEM> paramArrayList, ArrayList<String> paramArrayList1)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      String[] arrayOfString = new String[paramArrayList1.size()];
      int i = 0;
      while (i < paramArrayList1.size())
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          Task.CONFIG_ITEM localCONFIG_ITEM = (Task.CONFIG_ITEM)localIterator.next();
          if (localCONFIG_ITEM.id.equals(paramArrayList1.get(i))) {
            arrayOfString[i] = localCONFIG_ITEM.value;
          }
        }
        i += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  public static String getWifiStateJson(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("name", "NetworkEvent");
      localJSONObject1.put("timestamp", System.currentTimeMillis() / 1000L + "");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", paramString);
      if (paramString.equals("WIFI"))
      {
        paramString = alkz.a((WifiManager)BaseApplication.getContext().getSystemService("wifi"));
        if (paramString != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("kandianreport.taskmanager", 2, "checknetinfo get wifi ssid " + paramString.getSSID());
          }
          localJSONObject2.put("info", paramString.getBSSID());
        }
      }
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return localJSONObject1.toString();
  }
  
  private void importJs(Task paramTask, ArrayList<Task.CONFIG_ITEM> paramArrayList, int paramInt)
    throws Exception
  {
    JSContext localJSContext = paramTask.jsContext;
    String str;
    if (paramInt == Task.TYPE_EXTRACTION) {
      str = JSSCRIPT_EXTRACTION_DIR;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        paramArrayList = paramArrayList.iterator();
        for (;;)
        {
          if (!paramArrayList.hasNext()) {
            break label279;
          }
          Object localObject1 = (Task.CONFIG_ITEM)paramArrayList.next();
          Object localObject2 = str + "/" + ((Task.CONFIG_ITEM)localObject1).value + ".js";
          localObject1 = new File((String)localObject2);
          if (((File)localObject1).exists())
          {
            localObject2 = new StringBuffer();
            localObject1 = aqhq.readFileToString((File)localObject1);
            if (localJSContext == null) {
              continue;
            }
            localJSContext.evaluteStringWithException((String)localObject1, (StringBuffer)localObject2);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + localObject2);
            TaskException.reportException(paramTask.id, "evaluate js exception: " + localObject2);
            continue;
            if (paramInt == Task.TYPE_PROCESS)
            {
              str = JSSCRIPT_PROCESS_DIR;
              break;
            }
            if (paramInt == Task.TYPE_DISTRIBUTION)
            {
              str = JSSCRIPT_DISTRIBUTION_DIR;
              break;
            }
            if (paramInt != Task.TYPE_CHECK) {
              break label280;
            }
            str = JSSCRIPT_CHECK_DIR;
            break;
          }
          QLog.d("kandianreport.taskmanager", 2, "import js not exist: " + (String)localObject2);
        }
      }
      label279:
      return;
      label280:
      str = "";
    }
  }
  
  private void initTask(Task paramTask)
  {
    paramTask.jsContext = new JSContext();
    paramTask.jsContext.task = paramTask;
    paramTask.jsContext.initRIJStorage();
    paramTask.jsContext.registerFunction("doNext", new TaskManager.8(this, paramTask));
    paramTask.jsContext.registerFunction("setTimeout", new TaskManager.9(this, paramTask));
    paramTask.jsContext.registerFunction("QLog", new TaskManager.10(this));
    paramTask.jsContext.registerFunction("getTaskId", new TaskManager.11(this, paramTask));
    paramTask.jsContext.registerFunction("setInterval", new TaskManager.12(this, paramTask));
    paramTask.jsContext.registerFunction("reportToServer", new TaskManager.13(this));
    paramTask.jsContext.registerFunction("clearInterval", new TaskManager.14(this));
    paramTask.jsContext.registerFunction("getPlatformInfo", new TaskManager.15(this));
    paramTask.jsContext.registerFunction("createRIJStorage", new TaskManager.16(this));
    paramTask.jsContext.registerFunction("setValueForKey", new TaskManager.17(this));
    paramTask.jsContext.registerFunction("getValueForKey", new TaskManager.18(this));
    paramTask.jsContext.registerFunction("removeKey", new TaskManager.19(this));
    paramTask.jsContext.registerFunction("invalidate", new TaskManager.20(this));
    paramTask.jsContext.registerFunction("reportCustomEvent", new TaskManager.21(this));
    paramTask.jsContext.registerFunction("generateCustomData", new TaskManager.22(this));
    paramTask.jsContext.registerFunction("httpRequest", new TaskManager.23(this, paramTask));
    paramTask.jsContext.registerFunction("alert", new TaskManager.24(this));
    paramTask.jsContext.registerFunction("getAladdinConfig", new TaskManager.25(this));
    paramTask.jsContext.registerFunction("decodeBase64", new TaskManager.26(this));
    paramTask.jsContext.registerFunction("encodeBase64", new TaskManager.27(this));
    paramTask.jsContext.registerFunction("getUserUin", new TaskManager.28(this));
    paramTask.jsContext.registerFunction("isPublicVersion", new TaskManager.29(this));
    paramTask.status = Task.STATUS_INIT;
  }
  
  private boolean isTaskAvailable(Task paramTask)
  {
    int i = ((Integer)awit.f("kandianreport.taskmanager" + paramTask.id, Integer.valueOf(0))).intValue();
    return (i != Task.STATUS_FAIL) && (i != Task.STATUS_QUIT);
  }
  
  private Task readTaskConfigFile(File paramFile)
    throws Exception
  {
    return readTaskConfigJson(aqhq.readFileContent(paramFile));
  }
  
  private Task readTaskConfigJson(String paramString)
    throws Exception
  {
    int j = 0;
    paramString = new JSONObject(paramString);
    JSONArray localJSONArray1 = paramString.optJSONArray("filter");
    JSONArray localJSONArray2 = paramString.optJSONArray("extraction");
    JSONArray localJSONArray3 = paramString.optJSONArray("process");
    JSONArray localJSONArray4 = paramString.optJSONArray("distribution");
    JSONArray localJSONArray5 = paramString.optJSONArray("check");
    Task localTask = new Task();
    localTask.config = paramString;
    localTask.id = paramString.optString("id");
    int i;
    if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
    {
      i = 0;
      while (i < localJSONArray1.length())
      {
        addConfigItem(localTask.filter, (JSONObject)localJSONArray1.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
    {
      i = 0;
      while (i < localJSONArray2.length())
      {
        addConfigItem(localTask.extraction, (JSONObject)localJSONArray2.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray3 != null) && (localJSONArray3.length() > 0))
    {
      i = 0;
      while (i < localJSONArray3.length())
      {
        addConfigItem(localTask.process, (JSONObject)localJSONArray3.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray4 != null) && (localJSONArray4.length() > 0))
    {
      i = 0;
      while (i < localJSONArray4.length())
      {
        addConfigItem(localTask.distribution, (JSONObject)localJSONArray4.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray5 != null) && (localJSONArray5.length() > 0))
    {
      i = j;
      while (i < localJSONArray5.length())
      {
        addConfigItem(localTask.check, (JSONObject)localJSONArray5.opt(i));
        i += 1;
      }
    }
    return localTask;
  }
  
  private void readTaskIdsFromAladdinConfig()
  {
    configTaskIds = Arrays.asList(Aladdin.getConfig(177).getString("kandian_feature_compute_tasks", "").split("\\|"));
  }
  
  private void readTasksFromConfigFile()
    throws Exception
  {
    QLog.d("kandianreport.taskmanager", 1, "readTasksFromConfigFile...");
    if (aqhq.fileExists(TASK_CONFIG_DIR))
    {
      Object localObject1 = new File(TASK_CONFIG_DIR).listFiles();
      this.taskList.clear();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label163;
          }
          Object localObject2 = localObject1[i];
          try
          {
            localObject2 = readTaskConfigFile((File)localObject2);
            if ((configTaskIds != null) && (configTaskIds.size() > 0) && (("*".equals(configTaskIds.get(0))) || (configTaskIds.contains(((Task)localObject2).id)))) {
              this.taskList.add(localObject2);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("kandianreport.taskmanager", 2, localException.getMessage());
              TaskException.reportException(localException.getMessage());
            }
          }
          i += 1;
        }
      }
      label163:
      if (this.taskList.size() > 0)
      {
        localObject1 = this.taskList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          QLog.d("kandianreport.taskmanager", 1, ((Task)((Iterator)localObject1).next()).toString());
        }
      }
      QLog.d("kandianreport.taskmanager", 1, "tasklist empty");
    }
  }
  
  private void reportToServer(JSContext paramJSContext, String paramString1, String paramString2)
    throws Throwable
  {
    if (paramJSContext == null) {
      return;
    }
    paramString2 = new JSONObject(paramString2);
    paramString1 = getCheckScript(paramJSContext, paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        String str1 = (String)paramString1.next();
        StringBuffer localStringBuffer = new StringBuffer();
        String str2 = str1 + "('" + str1 + "')";
        Object localObject = paramJSContext.evaluteStringWithException(str2, localStringBuffer);
        if (!TextUtils.isEmpty(localStringBuffer))
        {
          markTaskFail(paramJSContext.task);
          QLog.d("kandianreport.taskmanager", 2, "evaluate js exception: " + str2 + " " + localStringBuffer);
          TaskException.reportException(paramJSContext.task.id, "evaluate js exception: " + str2 + " " + localStringBuffer);
        }
        if (((Double)localObject).doubleValue() == 1.0D) {
          paramString2.put(str1, 1);
        } else {
          paramString2.put(str1, 0);
        }
      }
    }
    paramString2.put("taskId", paramJSContext.task.id);
    paramString2.put("version", scriptVersion + "");
    TaskDistribution.report(paramString2.toString());
    paramString1 = new JSONObject();
    paramString1.put("taskId", paramJSContext.task.id);
    paramString1.put("version", scriptVersion + "");
    paramString1.put("so_version", KandianReportSoLoader.getSoVersion() + "");
    paramString1.put("phone", Build.MODEL);
    paramString1.put("sys_version", aqgz.getDeviceOSVersion());
    paramString1.put("qq_version", aqgz.getQQVersion());
    paramString1.put("appid", AppSetting.getAppId() + "");
    kbp.a(null, "", "0X800982F", "0X800982F", 0, 0, "", "", "", paramString1.toString(), false);
  }
  
  private void startTask(Task paramTask)
    throws Exception
  {
    importJs(paramTask, paramTask.extraction, Task.TYPE_EXTRACTION);
    importJs(paramTask, paramTask.process, Task.TYPE_PROCESS);
    importJs(paramTask, paramTask.distribution, Task.TYPE_DISTRIBUTION);
    importJs(paramTask, paramTask.check, Task.TYPE_CHECK);
    paramTask.status = Task.STATUS_ACCEPT;
  }
  
  private void startTasks()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.5(this));
  }
  
  private void startTasksIfExist()
  {
    try
    {
      if (isStarted) {
        return;
      }
      if (aqhq.fileExists(SCRIPT_ROOT_PATH)) {
        break label124;
      }
      QLog.d("kandianreport.taskmanager", 1, "startTasksIfExist: offline root dir is null");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("kandianreport.taskmanager", 2, "startAllTasks unexpected exception: " + localException.getMessage());
        TaskException.reportException("startAllTasks unexpected exception: " + localException.getMessage());
        return;
        try
        {
          if (jqj.D(SCRIPT_ROOT_PATH, "3412")) {
            continue;
          }
          KandianReportSoLoader.logAndReport("startTasksIfExist: verification failed");
          return;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("kandianreport.taskmanager", 1, localThrowable.getMessage());
          return;
        }
      }
    }
    catch (Error localError)
    {
      label124:
      QLog.d("kandianreport.taskmanager", 2, "startAllTasks unexpected error: " + localError.getMessage());
      TaskException.reportException("startAllTasks unexpected error: " + localError.getMessage());
    }
    readTaskIdsFromAladdinConfig();
    readTasksFromConfigFile();
    startTasksInList();
    KandianReportSoLoader.logAndReport("startTasksIfExist tasks size are: " + this.taskList.size());
    return;
  }
  
  private void startTasksInList()
  {
    QLog.d("kandianreport.taskmanager", 1, "startTasksInList...");
    Iterator localIterator = this.taskList.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      try
      {
        if (isTaskAvailable(localTask))
        {
          initTask(localTask);
          startTask(localTask);
        }
      }
      catch (Exception localException)
      {
        markTaskFail(localTask);
        QLog.d("kandianreport.taskmanager", 1, "startTasksInList unexpected exception: " + localException.getMessage());
        TaskException.reportException(localTask.id, "startTasksInList unexpected exception: " + localException.getMessage());
        continue;
        QLog.d("kandianreport.taskmanager", 1, localTask.id + " available status is " + localTask.status);
      }
      catch (Error localError)
      {
        markTaskFail(localTask);
        QLog.d("kandianreport.taskmanager", 1, "startTasksInList unexpected error: " + localError.getMessage());
        TaskException.reportException(localTask.id, "startTasksInList unexpected error: " + localError.getMessage());
      }
    }
    isStarted = true;
  }
  
  public void accept(String paramString)
  {
    if ((isConfigureOn) && (isStarted) && (!TextUtils.isEmpty(paramString)))
    {
      if (!KandianReportSoLoader.isSoFiledLoad()) {
        QLog.d("kandianreport.taskmanager", 2, "accept so not load");
      }
    }
    else {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new TaskManager.6(this, paramString));
  }
  
  public void downloadScripts(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime >= timeLimit) {
      TaskOfflineUtils.checkUpdate("3412", 1, new TaskManager.30(this, paramBoolean));
    }
    lastTime = l;
  }
  
  public ArrayList<String> getCheckScript(JSContext paramJSContext, String paramString)
  {
    paramJSContext = paramJSContext.task;
    if (paramJSContext != null)
    {
      ArrayList localArrayList = getCheckByValue(paramJSContext.filter, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getCheckName(paramJSContext, localArrayList);
      }
      localArrayList = getCheckByValue(paramJSContext.extraction, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getCheckName(paramJSContext, localArrayList);
      }
      localArrayList = getCheckByValue(paramJSContext.process, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getCheckName(paramJSContext, localArrayList);
      }
      paramString = getCheckByValue(paramJSContext.distribution, paramString);
      if ((paramString != null) && (paramString.size() > 0)) {
        return getCheckName(paramJSContext, paramString);
      }
    }
    return null;
  }
  
  public Task.CONFIG_ITEM[] getNextScript(JSContext paramJSContext, String paramString)
  {
    if (paramJSContext == null) {}
    do
    {
      do
      {
        return null;
        paramJSContext = paramJSContext.task;
      } while (paramJSContext == null);
      ArrayList localArrayList = getOutputByValue(paramJSContext.filter, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getTasksById(paramJSContext.extraction, localArrayList);
      }
      localArrayList = getOutputByValue(paramJSContext.extraction, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getTasksById(paramJSContext.process, localArrayList);
      }
      localArrayList = getOutputByValue(paramJSContext.process, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getTasksById(paramJSContext.distribution, localArrayList);
      }
      paramString = getOutputByValue(paramJSContext.distribution, paramString);
    } while ((paramString == null) || (paramString.size() <= 0));
    return getTasksById(paramJSContext.check, paramString);
  }
  
  public void markTaskFail(Task paramTask)
  {
    QLog.d("kandianreport.taskmanager", 2, "mark task fail " + paramTask.id);
    paramTask.status = Task.STATUS_FAIL;
    awit.H("kandianreport.taskmanager" + paramTask.id, Integer.valueOf(Task.STATUS_FAIL));
  }
  
  public void qlog(int paramInt, String paramString)
  {
    QLog.d("kandianreport.taskmanager", paramInt, paramString);
  }
  
  public void reStartTask(String paramString)
  {
    QLog.d("kandianreport.taskmanager", 1, "reStartTask: " + paramString);
    Iterator localIterator = this.taskList.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      if (localTask.id == paramString) {
        try
        {
          initTask(localTask);
          startTask(localTask);
          localTask.status = Task.STATUS_ACCEPT;
          awit.H("kandianreport.taskmanager" + paramString, Integer.valueOf(Task.STATUS_ACCEPT));
        }
        catch (Exception localException)
        {
          markTaskFail(localTask);
          QLog.d("kandianreport.taskmanager", 2, "reStartTask unexpected exception: " + localException.getMessage());
          TaskException.reportException(localTask.id, "reStartTask unexpected exception: " + localException.getMessage());
        }
        catch (Error localError)
        {
          markTaskFail(localTask);
          QLog.d("kandianreport.taskmanager", 2, "reStartTask unexpected error: " + localError.getMessage());
          TaskException.reportException(localTask.id, "reStartTask unexpected error: " + localError.getMessage());
        }
      }
    }
  }
  
  public void reset()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.7(this));
  }
  
  public void restartAllTasks()
  {
    QLog.d("kandianreport.taskmanager", 2, "restartAllTasks");
    stopAllTasks();
    startAllTasks();
  }
  
  public void restore()
  {
    QLog.d("kandianreport.taskmanager", 1, "restore");
    awit.H("kandianreport_ON", Integer.valueOf(1));
  }
  
  public void startAllTasks()
  {
    for (;;)
    {
      try
      {
        isConfigureOn = getConfigOn();
        if ((!isConfigureOn) || (isStarted)) {
          break label160;
        }
        KandianReportSoLoader.logAndReport("startAllTasks");
        if (!this.isNetWorkStateRegistered)
        {
          AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.netHandler);
          this.isNetWorkStateRegistered = true;
        }
        scriptVersion = TaskOfflineUtils.checkOffLineConfig("3412", 1).version;
        if (!KandianReportSoLoader.isSoFiledLoad()) {
          continue;
        }
        QLog.d("kandianreport.taskmanager", 1, "so loaded, now startTasks");
        startTasks();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("kandianreport.taskmanager", 2, "startAllTasks " + localThrowable);
        continue;
      }
      finally {}
      return;
      QLog.d("kandianreport.taskmanager", 1, "so not loaded, load first");
      if (!KandianReportSoLoader.isSoFileDownload())
      {
        KandianReportSoLoader.downLoadSoFiles(new TaskManager.3(this));
      }
      else
      {
        KandianReportSoLoader.loadSoFiles(new TaskManager.4(this));
        continue;
        label160:
        QLog.d("kandianreport.taskmanager", 2, "startAllTasks fail isConfigureOn: " + isConfigureOn + " isStarted: " + isStarted);
      }
    }
  }
  
  public void stopAllTasks()
  {
    try
    {
      if (isStarted)
      {
        QLog.d("kandianreport.taskmanager", 1, "stopAllTasks");
        isStarted = false;
        Iterator localIterator = this.taskList.iterator();
        while (localIterator.hasNext()) {
          stopTask(((Task)localIterator.next()).id);
        }
        this.isNetWorkStateRegistered = false;
      }
    }
    finally {}
  }
  
  public void stopTask(String paramString)
  {
    Iterator localIterator = this.taskList.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      if (localTask.id == paramString) {
        localTask.status = Task.STATUS_STOP;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager
 * JD-Core Version:    0.7.0.1
 */