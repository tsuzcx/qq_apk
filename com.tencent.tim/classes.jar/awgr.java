import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class awgr
  extends awfr
  implements avzi
{
  private byte bI = 115;
  private boolean inited;
  public int mFrom = 4;
  public int mSource = 0;
  private Map<Integer, awgr.a> qj = new HashMap();
  private Map<String, Integer> qo = new HashMap();
  
  private void a(awgr.a parama)
  {
    int i = 0;
    if (TextUtils.isEmpty(parama.cPZ)) {
      return;
    }
    if (TextUtils.isEmpty(parama.cPZ)) {
      i = 101;
    }
    while (i != 0)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "call qzone upload ret:" + i);
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("status", 2);
        localJSONObject1.put("code", i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", parama.id);
        localJSONObject2.put("url", "");
        localJSONObject1.put("data", localJSONObject2);
        localJSONObject1.put("msg", "");
        this.f.callJs(parama.czP, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException parama)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", parama);
        return;
        parama.atT = awgq.aw(this.f.mRuntime.getActivity(), parama.cPZ);
        if ((!TextUtils.isEmpty(parama.atT)) && (new File(parama.atT).exists()))
        {
          this.qo.put(parama.atT, Integer.valueOf(parama.id));
          if (!awgq.cw(parama.atT, parama.bid)) {
            i = 102;
          }
        }
        else
        {
          i = 103;
        }
      }
      catch (Exception parama)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", parama);
      }
    }
  }
  
  private void aE(String... paramVarArgs)
  {
    QLog.i("js-upload: QzoneUploadPlugin", 1, "notify client receive upload task.");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", 1);
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      QLog.d("js-upload: QzoneUploadPlugin", 1, "callback invoke ... task.jsCallback:" + paramVarArgs.getString("callback"));
      this.f.callJs(paramVarArgs.getString("callback"), new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", paramVarArgs);
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", paramVarArgs);
    }
  }
  
  private void init()
  {
    avzf.a().a(this);
    this.inited = true;
  }
  
  /* Error */
  protected void aD(String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 56
    //   2: iconst_1
    //   3: ldc 208
    //   5: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: new 80	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: iconst_0
    //   14: aaload
    //   15: invokespecial 183	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: new 8	awgr$a
    //   22: dup
    //   23: aload_0
    //   24: aload_2
    //   25: ldc 91
    //   27: invokevirtual 212	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   30: invokespecial 215	awgr$a:<init>	(Lawgr;I)V
    //   33: astore_1
    //   34: aload_1
    //   35: aload_2
    //   36: ldc 217
    //   38: invokevirtual 191	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 48	awgr$a:cPZ	Ljava/lang/String;
    //   44: aload_1
    //   45: aload_2
    //   46: ldc 218
    //   48: invokevirtual 191	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: putfield 167	awgr$a:bid	Ljava/lang/String;
    //   54: aload_1
    //   55: aload_2
    //   56: ldc 187
    //   58: invokevirtual 191	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 111	awgr$a:czP	Ljava/lang/String;
    //   64: aload_1
    //   65: ifnull +26 -> 91
    //   68: aload_0
    //   69: getfield 38	awgr:qj	Ljava/util/Map;
    //   72: aload_1
    //   73: getfield 93	awgr$a:id	I
    //   76: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aload_1
    //   80: invokeinterface 164 3 0
    //   85: pop
    //   86: aload_0
    //   87: aload_1
    //   88: invokespecial 220	awgr:a	(Lawgr$a;)V
    //   91: return
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: ldc 56
    //   97: iconst_1
    //   98: ldc 122
    //   100: aload_2
    //   101: invokestatic 125	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: goto -40 -> 64
    //   107: astore_2
    //   108: aconst_null
    //   109: astore_1
    //   110: ldc 56
    //   112: iconst_1
    //   113: ldc 222
    //   115: aload_2
    //   116: invokestatic 125	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: goto -55 -> 64
    //   122: astore_2
    //   123: goto -13 -> 110
    //   126: astore_2
    //   127: goto -32 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	awgr
    //   0	130	1	paramVarArgs	String[]
    //   18	38	2	localJSONObject	JSONObject
    //   92	9	2	localJSONException1	JSONException
    //   107	9	2	localException1	Exception
    //   122	1	2	localException2	Exception
    //   126	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   8	34	92	org/json/JSONException
    //   8	34	107	java/lang/Exception
    //   34	64	122	java/lang/Exception
    //   34	64	126	org/json/JSONException
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.bI))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      paramString = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.bI) && (j == -1)) {}
      return true;
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("QzoneUpload")) || (this.f == null) || (this.f.mRuntime == null)) {}
    while (!paramString3.equals("ups")) {
      return false;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      if (!this.inited) {
        init();
      }
      aE(paramVarArgs);
      aD(paramVarArgs);
    }
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == this.bI) {}
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("js-upload: QzoneUploadPlugin", 1, "call js function, bundle is empty");
        return;
      }
    } while (!"cmd.qzoneUploadUps".equals(paramString));
    int j = paramBundle.getInt("param.uploadStatus", -1);
    int i = paramBundle.getInt("param.uploadResult", -1);
    paramString = paramBundle.getString("param.tmpLocalFile");
    Object localObject = paramBundle.getString("param.uploadResultUrl");
    QLog.w("js-upload: QzoneUploadPlugin", 1, "onWebEvent status:" + j + " code:" + i + " url:" + (String)localObject);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "localTmpPath == null !!");
      return;
    }
    paramBundle = (Integer)this.qo.get(paramString);
    if (paramBundle == null)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "ITaskId == null");
      return;
    }
    j = paramBundle.intValue();
    paramBundle = (awgr.a)this.qj.get(Integer.valueOf(j));
    if (paramBundle == null)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "task == null, id:" + j);
      return;
    }
    paramBundle.url = ((String)localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("status", 4);
      ((JSONObject)localObject).put("code", i);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramBundle.id);
      localJSONObject.put("url", paramBundle.url);
      ((JSONObject)localObject).put("data", localJSONObject);
      ((JSONObject)localObject).put("msg", "");
      QLog.d("js-upload: QzoneUploadPlugin", 1, "callback invoke ... task.jsCallback:" + paramBundle.czP + " result:" + ((JSONObject)localObject).toString());
      this.f.callJs(paramBundle.czP, new String[] { ((JSONObject)localObject).toString() });
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new File(paramString);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      this.qj.remove(Integer.valueOf(j));
      this.qo.remove(paramString);
      paramBundle.atT = null;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", localJSONException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", localException);
      }
    }
  }
  
  class a
  {
    public String atT;
    public String bid;
    public String cPZ;
    public String czP;
    public int id;
    public String url;
    
    public a(int paramInt)
    {
      this.id = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgr
 * JD-Core Version:    0.7.0.1
 */