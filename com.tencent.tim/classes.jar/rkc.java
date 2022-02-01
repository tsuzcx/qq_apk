import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rkc
{
  public static final rkc e = new rkc(0, acfp.m(2131712340));
  public static final rkc f = new rkc(1, acfp.m(2131712337));
  public static final rkc g = new rkc(2, "QQ音乐曲库");
  public String aAQ;
  public String aAR;
  public int changeType;
  String desc = null;
  public int duration;
  public int end;
  public String id;
  int imageID = 0;
  String image_url = null;
  public int musicType = -1;
  String share_url = null;
  public int start;
  public String title;
  
  public rkc() {}
  
  public rkc(int paramInt, String paramString)
  {
    this.musicType = paramInt;
    this.title = paramString;
  }
  
  public rkc(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.musicType = paramInt1;
    this.title = paramString;
    this.imageID = paramInt2;
    this.changeType = paramInt3;
  }
  
  public rkc(qqstory_struct.MusicConfigInfo paramMusicConfigInfo)
  {
    this.title = paramMusicConfigInfo.title.get().toStringUtf8();
    this.aAQ = paramMusicConfigInfo.audio_url.get().toStringUtf8();
    this.musicType = 3;
    this.id = String.valueOf(paramMusicConfigInfo.id.get());
  }
  
  public rkc(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.aAQ = paramString.optString("audio_url");
      if (paramString.has("type")) {}
      for (this.musicType = paramString.optInt("type");; this.musicType = 2)
      {
        this.id = paramString.optString("id");
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MusicInfo", 2, QLog.getStackTraceString(paramString));
      }
    }
  }
  
  /* Error */
  public static final ArrayList<rkc> d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 144
    //   3: invokestatic 149	aqfe:get	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_0
    //   7: new 151	org/json/JSONArray
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 152	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 155	org/json/JSONArray:length	()I
    //   22: istore_2
    //   23: new 157	java/util/ArrayList
    //   26: dup
    //   27: iload_2
    //   28: invokespecial 160	java/util/ArrayList:<init>	(I)V
    //   31: astore_0
    //   32: iconst_0
    //   33: istore_1
    //   34: aload_0
    //   35: astore_3
    //   36: iload_1
    //   37: iload_2
    //   38: if_icmpge +53 -> 91
    //   41: aload_0
    //   42: new 2	rkc
    //   45: dup
    //   46: aload 4
    //   48: iload_1
    //   49: invokevirtual 162	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   52: invokespecial 163	rkc:<init>	(Ljava/lang/String;)V
    //   55: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: iload_1
    //   60: iconst_1
    //   61: iadd
    //   62: istore_1
    //   63: goto -29 -> 34
    //   66: astore 4
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_0
    //   71: astore_3
    //   72: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +16 -> 91
    //   78: ldc 133
    //   80: iconst_2
    //   81: aload 4
    //   83: invokestatic 137	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   86: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_0
    //   90: astore_3
    //   91: aload_3
    //   92: areturn
    //   93: astore 4
    //   95: goto -25 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   33	30	1	i	int
    //   22	17	2	j	int
    //   35	57	3	localContext	Context
    //   15	32	4	localJSONArray	JSONArray
    //   66	16	4	localJSONException1	JSONException
    //   93	1	4	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   7	32	66	org/json/JSONException
    //   41	59	93	org/json/JSONException
  }
  
  public static final void d(Context paramContext, ArrayList<rkc> paramArrayList)
  {
    Object localObject = null;
    if (paramArrayList != null)
    {
      int j = paramArrayList.size();
      localObject = new JSONArray();
      int i = 0;
      while (i < j)
      {
        ((JSONArray)localObject).put(((rkc)paramArrayList.get(i)).mZ());
        i += 1;
      }
      localObject = ((JSONArray)localObject).toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      aqfe.remove(paramContext, "qqstory_savedMusicList");
      return;
    }
    aqfe.J(paramContext, "qqstory_savedMusicList", (String)localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    rkc localrkc = (rkc)paramObject;
    if ((localrkc.musicType == 0) && (this.musicType == 0)) {
      return true;
    }
    if ((localrkc.musicType == 1) && (this.musicType == 1)) {
      return true;
    }
    if ((localrkc.musicType == this.musicType) && (localrkc.title != null) && (localrkc.title.equals(this.title)) && (localrkc.aAQ != null) && (localrkc.aAQ.equals(this.aAQ))) {
      return true;
    }
    return super.equals(paramObject);
  }
  
  public void g(rkc paramrkc)
  {
    this.id = paramrkc.id;
    this.title = paramrkc.title;
    this.desc = paramrkc.desc;
    this.aAQ = paramrkc.aAQ;
    this.image_url = paramrkc.image_url;
    this.share_url = paramrkc.share_url;
    this.imageID = paramrkc.imageID;
    this.musicType = paramrkc.musicType;
    this.changeType = paramrkc.changeType;
    this.aAR = paramrkc.aAR;
    this.start = paramrkc.start;
    this.end = paramrkc.end;
    this.duration = paramrkc.duration;
  }
  
  public String mZ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", this.title);
      localJSONObject.put("audio_url", this.aAQ);
      localJSONObject.put("type", 3);
      localJSONObject.put("id", this.id);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MusicInfo", 2, QLog.getStackTraceString(localJSONException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkc
 * JD-Core Version:    0.7.0.1
 */