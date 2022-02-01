package com.tencent.secprotocol;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.secframework.TsakDispatchSrv;
import com.tencent.secprotocol.t.ReportLogHelper;
import com.tencent.secprotocol.t.s;
import com.tencent.secprotocol.utils.IPutListener;
import com.tencent.token.aa;
import com.tencent.token.ae;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ai;
import com.tencent.token.aj;
import com.tencent.token.ak;
import com.tencent.token.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ByteData
  extends TsakDispatchSrv
{
  public static final String BMP_ARRIVE_TIME = "bmp_arrive_time_stamp";
  public static final int MSG_CMD_SUBTASK_WRITE_SP = 1;
  public static final String MY_VERSION = "0.4.4";
  public static final long REQUEST_TIME_BUFF = 43200L;
  public static final int RH_SCV = 1;
  public static final String SP_MARK_TIME = "mark_time_";
  public static final String TIME_STAMP_NAME = "byte_data_time_stamp";
  public static final String VAL_ARRIVE_TIME = "val_arrive_time";
  public static boolean isMsf = false;
  public static final boolean isPrint = true;
  public static Handler mDataHandler;
  public static String processName = "";
  public static String sSessionID = "";
  public af cData = null;
  public String filterName = "";
  public boolean filterStatus = false;
  public HandlerThread handlerThread = null;
  public ae mBmpMgr = null;
  public Context mContext = null;
  public boolean mPoxyInit = false;
  public boolean mPoxyNativeLoaded = false;
  public final String mThradName = "ByteThread";
  public final String mUin = null;
  public final byte[] status = { 0, 0, 0, 0 };
  
  private boolean checkObject(long paramLong, Object paramObject)
  {
    if (paramLong == 0L) {
      return false;
    }
    return (!(paramObject instanceof byte[])) || (paramObject == null) || (((byte[])paramObject).length <= 0);
  }
  
  private boolean checkProgressName()
  {
    if (!processName.isEmpty())
    {
      String[] arrayOfString = processName.split(":");
      StringBuilder localStringBuilder = new StringBuilder("temp[temp.length-1]: ");
      localStringBuilder.append(arrayOfString[(arrayOfString.length - 1)]);
      logCat("poxy_java", localStringBuilder.toString());
      if (arrayOfString[(arrayOfString.length - 1)].equalsIgnoreCase("msf"))
      {
        isMsf = true;
        return true;
      }
    }
    return isMsf;
  }
  
  private boolean checkToa()
  {
    if (!isMsf)
    {
      Object localObject = this.mContext;
      StringBuilder localStringBuilder = new StringBuilder("bmp_arrive_time_stamp_");
      localStringBuilder.append(processName);
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      long l1 = System.currentTimeMillis();
      long l2 = l1 - ((SharedPreferences)localObject).getLong("val_arrive_time", 0L);
      if ((l2 > 43200L) && (l2 > 0L))
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("val_arrive_time", l1);
        ((SharedPreferences.Editor)localObject).commit();
        return true;
      }
      return false;
    }
    return true;
  }
  
  private native byte[] getByte(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private Context getContext()
  {
    return this.mContext;
  }
  
  public static ByteData getInstance()
  {
    return e.a;
  }
  
  private void initLoadlibrary()
  {
    if (this.mPoxyInit) {
      return;
    }
    if (this.mPoxyNativeLoaded) {
      return;
    }
    if (aa.a(this.mContext, "poxy"))
    {
      this.mPoxyNativeLoaded = true;
      this.mPoxyInit = true;
      return;
    }
    this.status[3] = 10;
  }
  
  public static void logCat(String paramString1, String paramString2) {}
  
  private void setContext(Context paramContext)
  {
    if ((paramContext instanceof Context)) {
      this.mContext = paramContext;
    }
  }
  
  private void writeSp(long paramLong)
  {
    try
    {
      if ((this.mPoxyNativeLoaded) && (this.mPoxyInit))
      {
        Object localObject = s.md5sum(this.cData.e);
        Context localContext = this.mContext;
        StringBuilder localStringBuilder = new StringBuilder("mark_time_");
        localStringBuilder.append(processName);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject);
        localObject = localContext.getSharedPreferences(localStringBuilder.toString(), 4).edit();
        ((SharedPreferences.Editor)localObject).putLong("byte_data_time_stamp", paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        sSessionID = String.valueOf(paramLong);
        this.cData.f = sSessionID;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public byte[] getCode(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (checkObject(paramLong1, paramObject4))
    {
      paramObject1 = this.status;
      paramObject1[3] = 12;
      return paramObject1;
    }
    if ((this.status[1] == 0) && (this.mPoxyNativeLoaded) && (this.mPoxyInit))
    {
      this.cData.e = ((String)paramObject3);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.cData.b);
      localArrayList.add("1");
      localArrayList.add(this.cData.e);
      localArrayList.add((String)paramObject5);
      localArrayList.add(this.cData.d);
      localArrayList.add(this.cData.f);
      localArrayList.add((String)paramObject1);
      localArrayList.add(this.cData.g);
      localArrayList.add(processName);
      ReportLogHelper.report(5, 0);
      return getByte(this.mContext, paramLong1, paramLong2, paramLong3, paramLong4, (String[])localArrayList.toArray(new String[localArrayList.size()]), paramObject2, paramObject3, paramObject4);
    }
    paramObject1 = this.status;
    if (paramObject1[3] == 0) {
      paramObject1[3] = 13;
    }
    return this.status;
  }
  
  public byte[] getSign(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return getCode(1L, 0L, 0L, 0L, "", "", paramString1, paramArrayOfByte, paramString2);
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramContext != getInstance().getContext()) && (!this.mPoxyInit) && (paramContext != null)) {
      try
      {
        processName = s.getProcessName(paramContext);
        this.mBmpMgr = new ae(paramContext, processName);
        this.cData = new af(paramContext, paramString1, "", paramString2, paramString3, sSessionID, paramString5, "0.4.4");
        setContext(paramContext);
        initLoadlibrary();
        checkProgressName();
        super.setTerminalInfo(paramContext, paramString1, paramString2, new a());
        paramContext = new StringBuilder("isMsf: ");
        paramContext.append(isMsf);
        logCat("poxy_java", paramContext.toString());
        ReportLogHelper.report(4, 0);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    logCat("poxy_java", "init fail!");
  }
  
  public void myTasks(int paramInt, ah paramah)
  {
    if (paramInt == 1) {
      writeSp(Long.valueOf((String)paramah.c).longValue());
    }
  }
  
  public void processFilterSwitch(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      this.filterStatus = paramBoolean;
      this.filterName = paramString;
      return;
    }
    this.filterStatus = paramBoolean;
    this.filterName = "";
  }
  
  public void runTime(final int paramInt1, final String paramString, final int paramInt2)
  {
    if ((this.mPoxyNativeLoaded) && (this.mPoxyInit))
    {
      if ((this.filterStatus) && (!processName.equalsIgnoreCase(this.filterName))) {
        return;
      }
      try
      {
        super.getTaskHandler().post(new d(paramInt1, paramInt2, paramString));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setData(final String paramString)
  {
    if ((this.mPoxyNativeLoaded) && (this.mPoxyInit)) {
      try
      {
        super.getTaskHandler().post(new b(paramString));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setDataEx(final String paramString1, final String paramString2)
  {
    if ((this.mPoxyNativeLoaded) && (this.mPoxyInit)) {
      try
      {
        super.getTaskHandler().post(new c(paramString1, paramString2));
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public class a
    implements x
  {
    public a() {}
  }
  
  public class b
    implements Runnable
  {
    public b(String paramString) {}
    
    public void run()
    {
      try
      {
        if (!ByteData.access$200(ByteData.this))
        {
          ByteData.logCat("poxy_java", "time is not arrive！");
          return;
        }
        ReportLogHelper.report(2, 4);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new aj(ByteData.access$300(ByteData.this)).a(10, paramString, ByteData.access$400(ByteData.this));
        JSONObject localJSONObject3 = ByteData.access$500(ByteData.this).a();
        localJSONObject1.put(ak.a(19), localJSONObject2);
        localJSONObject1.put(ak.a(20), localJSONObject3);
        ByteData.this.executeTask(164, 10, 0, localJSONObject1.toString(), new a());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public class a
      implements IPutListener
    {
      public a() {}
      
      public void onResult(Object paramObject, int paramInt)
      {
        if ((paramInt == 0) && (paramObject != null))
        {
          ae localae = ByteData.access$500(ByteData.this);
          Object localObject1 = (String)paramObject;
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            int i = ((JSONObject)localObject1).optInt("st");
            long l = ((JSONObject)localObject1).optLong("ver");
            String str = ((JSONObject)localObject1).optString("hs");
            localObject1 = Base64.decode(((JSONObject)localObject1).optString("sd"), 0);
            paramInt = 1;
            if (i == 0)
            {
              boolean bool = ae.a((byte[])localObject1, str);
              if (bool)
              {
                try
                {
                  Object localObject2 = new File(localae.d);
                  if (((File)localObject2).exists()) {
                    ((File)localObject2).delete();
                  }
                  ((File)localObject2).createNewFile();
                  localObject2 = new FileOutputStream((File)localObject2);
                  try
                  {
                    ((FileOutputStream)localObject2).write((byte[])localObject1);
                    ((FileOutputStream)localObject2).close();
                  }
                  catch (Exception localException1) {}
                  try
                  {
                    ((FileOutputStream)localObject2).close();
                  }
                  catch (IOException localIOException)
                  {
                    localIOException.printStackTrace();
                  }
                }
                catch (Exception localException2)
                {
                  localObject2 = null;
                }
                localException2.printStackTrace();
                paramInt = 0;
                if (paramInt != 0)
                {
                  localae.a(l, str);
                  ReportLogHelper.report(2, 0);
                }
                else
                {
                  ReportLogHelper.report(2, 2);
                }
              }
              else
              {
                ReportLogHelper.report(2, 3);
              }
            }
            else
            {
              ReportLogHelper.report(2, 1);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          ByteData.logCat("poxy_java", "data: ".concat(String.valueOf(paramObject)));
        }
      }
    }
  }
  
  public class c
    implements Runnable
  {
    public c(String paramString1, String paramString2) {}
    
    public void run()
    {
      try
      {
        ByteData.access$400(ByteData.this).e = paramString1;
        ReportLogHelper.report(3, 2);
        final ai localai = new ai();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new aj(ByteData.access$300(ByteData.this)).a(11, paramString2, ByteData.access$400(ByteData.this));
        JSONObject localJSONObject1 = new JSONObject();
        Object localObject;
        try
        {
          localJSONObject1.put(ak.a(24), 1);
          localJSONObject1.put(ak.a(26), "");
          localJSONObject1.put(ak.a(25), "");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          localObject = null;
        }
        localJSONObject2.put(ak.a(19), localJSONObject3);
        localJSONObject2.put(ak.a(20), localObject);
        ByteData.this.executeTask(165, 11, 0, localJSONObject2.toString(), new a(localai));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public final class a
      implements IPutListener
    {
      public a(ai paramai) {}
      
      public final void onResult(Object paramObject, int paramInt)
      {
        if ((paramInt == 0) && (paramObject != null))
        {
          String str = ByteData.c.this.b;
          Object localObject = (String)paramObject;
          try
          {
            localObject = new JSONObject((String)localObject);
            paramInt = ((JSONObject)localObject).optInt(ak.a(29));
            long l = ((JSONObject)localObject).optLong(ak.a(30));
            localObject = ((JSONObject)localObject).optString(ak.a(31));
            if (paramInt == 0)
            {
              ReportLogHelper.report(3, 0);
              ByteData.getInstance().getCode(0L, 0L, 0L, l, localObject, null, null, null, str);
            }
            else
            {
              ReportLogHelper.report(3, 1);
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          ByteData.logCat("poxy_java", "test, data: ".concat(String.valueOf(paramObject)));
          return;
        }
      }
    }
  }
  
  public class d
    implements Runnable
  {
    public d(int paramInt1, int paramInt2, String paramString) {}
    
    public void run()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ByteData.access$400(ByteData.this).b);
      localArrayList.add("1");
      localArrayList.add(ByteData.access$400(ByteData.this).e);
      localArrayList.add("");
      localArrayList.add(ByteData.access$400(ByteData.this).d);
      localArrayList.add(ByteData.access$400(ByteData.this).f);
      localArrayList.add("");
      localArrayList.add(ByteData.access$400(ByteData.this).g);
      localArrayList.add(ByteData.access$600());
      ByteData localByteData = ByteData.this;
      ByteData.access$700(localByteData, ByteData.access$300(localByteData), 2L, paramInt1, 0L, paramInt2, (String[])localArrayList.toArray(new String[localArrayList.size()]), ByteData.access$400(ByteData.this).g, ByteData.access$400(ByteData.this).d, paramString);
    }
  }
  
  public static class e
  {
    public static final ByteData a = new ByteData(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData
 * JD-Core Version:    0.7.0.1
 */