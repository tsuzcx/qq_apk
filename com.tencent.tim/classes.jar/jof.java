import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class jof
{
  public static jof a;
  public static final int aCq = Color.rgb(64, 64, 65);
  public static final int aCr = Color.rgb(166, 166, 166);
  public static final int aCs = Color.argb(205, 255, 255, 255);
  public static final int aCt = Color.argb(154, 255, 255, 255);
  public static final int aCu = Color.rgb(19, 19, 19);
  public jof.c a;
  public jof.d a;
  public boolean aaQ;
  public HashMap<String, jof.b> cM = new HashMap();
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flags", paramInt1);
      localJSONObject.put("an_id", paramString1);
      localJSONObject.put("an_nick", paramString2);
      localJSONObject.put("head_protrait", paramInt2);
      localJSONObject.put("expire_time", paramInt3);
      localJSONObject.put("rankColor", paramString3);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousChatHelper", 2, "getJsonStr JSONException:" + paramString1.toString());
      }
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static jof.a a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("anonymous");
    paramMessageRecord = new jof.a();
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("flags")) {
        paramMessageRecord.flags = ((JSONObject)localObject).getInt("flags");
      }
      if (((JSONObject)localObject).has("an_id")) {
        paramMessageRecord.TF = ((JSONObject)localObject).getString("an_id");
      }
      if (((JSONObject)localObject).has("an_nick")) {
        paramMessageRecord.TG = ((JSONObject)localObject).getString("an_nick");
      }
      if (((JSONObject)localObject).has("head_protrait")) {
        paramMessageRecord.aCv = ((JSONObject)localObject).getInt("head_protrait");
      }
      if (((JSONObject)localObject).has("expire_time")) {
        paramMessageRecord.expire_time = ((JSONObject)localObject).getInt("expire_time");
      }
      if (((JSONObject)localObject).has("rankColor")) {
        paramMessageRecord.TH = ((JSONObject)localObject).optString("rankColor");
      }
      return paramMessageRecord;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramMessageRecord;
  }
  
  public static jof a()
  {
    if (jdField_a_of_type_Jof == null) {
      jdField_a_of_type_Jof = new jof();
    }
    return jdField_a_of_type_Jof;
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = paramContext.getSharedPreferences("anonymous_chat", 0);
    if (paramContext.getBoolean("first_enter_anonymous" + paramQQAppInterface.getCurrentAccountUin(), true))
    {
      paramContext.edit().putBoolean("first_enter_anonymous" + paramQQAppInterface.getCurrentAccountUin(), false).commit();
      return true;
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.extLong & 0x3) == 3;
  }
  
  public static String aV(int paramInt)
  {
    return "https://pub.idqqimg.com/pc/group/anony/portrait/img/" + paramInt + ".png";
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof ChatMessage)) && (((ChatMessage)paramMessageRecord).fakeSenderType == 2)) {}
    for (int i = 1;; i = 0) {
      return (i == 0) && (!paramMessageRecord.isMultiMsg) && (a(paramMessageRecord).flags == 2);
    }
  }
  
  public String I(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (this.jdField_a_of_type_Jof$c == null) {
      return null;
    }
    return this.jdField_a_of_type_Jof$c.content;
  }
  
  public jof.b a(String paramString)
  {
    return (jof.b)this.cM.get(paramString);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.aaQ) {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.aaQ = false;
      }
    }
    while (!dd(paramMessageRecord.frienduin)) {
      return;
    }
    jof.b localb = a(paramMessageRecord.frienduin);
    paramMessageRecord.vipBubbleID = localb.qt;
    paramMessageRecord.extLong |= 0x3;
    paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, localb.TI, localb.nickName, localb.aCw, localb.expireTime, localb.TH));
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousUpdate", 2, "nickName=" + paramString2 + ", vipBubbleId=" + paramLong + ", headId=" + paramInt1);
    }
    if (this.cM.containsKey(paramString1))
    {
      localb = (jof.b)this.cM.get(paramString1);
      localb.aCw = paramInt1;
      if ((paramString2 != null) && (!paramString2.equals(localb.nickName)) && (this.jdField_a_of_type_Jof$d != null)) {
        this.jdField_a_of_type_Jof$d.bm(paramString1, paramString2);
      }
      localb.nickName = paramString2;
      localb.qt = paramLong;
      localb.expireTime = paramInt2;
      localb.TI = paramString3;
      localb.TH = paramString4;
      this.cM.put(paramString1, localb);
      return;
    }
    jof.b localb = new jof.b(false);
    localb.aCw = paramInt1;
    localb.nickName = paramString2;
    localb.qt = paramLong;
    localb.expireTime = paramInt2;
    localb.TI = paramString3;
    localb.TH = paramString4;
    this.cM.put(paramString1, localb);
  }
  
  public void a(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramMessageRecord == null)) {}
    do
    {
      return;
      paramMessageRecord = svc.d(paramMessageRecord);
    } while (TextUtils.isEmpty(paramMessageRecord));
    if (this.jdField_a_of_type_Jof$c == null) {
      this.jdField_a_of_type_Jof$c = new jof.c();
    }
    this.jdField_a_of_type_Jof$c.TJ = paramString1;
    this.jdField_a_of_type_Jof$c.TI = paramString2;
    this.jdField_a_of_type_Jof$c.content = paramMessageRecord;
  }
  
  public void a(jof.d paramd)
  {
    this.jdField_a_of_type_Jof$d = paramd;
  }
  
  public void ayF()
  {
    this.jdField_a_of_type_Jof$d = null;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (this.aaQ) {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.aaQ = false;
      }
    }
    while (!dd(paramMessageRecord.frienduin)) {
      return;
    }
    jof.b localb = a(paramMessageRecord.frienduin);
    paramMessageRecord.vipBubbleID = localb.qt;
    paramMessageRecord.extLong |= 0x3;
    paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, null, localb.nickName, localb.aCw, localb.expireTime, localb.TH));
  }
  
  public void clear()
  {
    this.cM.clear();
  }
  
  public boolean dd(String paramString)
  {
    if (this.cM.containsKey(paramString)) {
      return ((jof.b)this.cM.get(paramString)).aaR;
    }
    return false;
  }
  
  public void l(boolean paramBoolean, String paramString)
  {
    if (this.cM.containsKey(paramString))
    {
      ((jof.b)this.cM.get(paramString)).aaR = paramBoolean;
      return;
    }
    this.cM.put(paramString, new jof.b(paramBoolean));
  }
  
  public static class a
  {
    public String TF;
    public String TG;
    public String TH;
    public int aCv;
    public int expire_time;
    public int flags;
    
    public byte[] B()
    {
      if (TextUtils.isEmpty(this.TF)) {}
      do
      {
        return null;
        try
        {
          byte[] arrayOfByte = this.TF.getBytes("ISO-8859-1");
          return arrayOfByte;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("AnonymousChatHelper", 2, "getByteAnId UnsupportedEncodingException");
      return null;
    }
  }
  
  public class b
  {
    public String TH;
    public String TI;
    public int aCw;
    public boolean aaR;
    public int expireTime;
    public String nickName;
    public long qt;
    
    public b(boolean paramBoolean)
    {
      this.aaR = paramBoolean;
    }
  }
  
  public class c
  {
    public String TI;
    public String TJ;
    public String content;
    
    public c() {}
  }
  
  public static abstract interface d
  {
    public abstract void bm(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jof
 * JD-Core Version:    0.7.0.1
 */