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

public class xkl
{
  public static final xkl a;
  public static final xkl b;
  public static final xkl c;
  int a;
  public String a;
  public int b;
  public String b;
  public int c;
  String c;
  public int d;
  public String d;
  public int e;
  String e;
  public int f;
  String f;
  public String g;
  
  static
  {
    jdField_a_of_type_Xkl = new xkl(0, alud.a(2131711332));
    jdField_b_of_type_Xkl = new xkl(1, alud.a(2131711329));
    jdField_c_of_type_Xkl = new xkl(2, "QQ音乐曲库");
  }
  
  public xkl()
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
  }
  
  public xkl(int paramInt, String paramString)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public xkl(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public xkl(qqstory_struct.MusicConfigInfo paramMusicConfigInfo)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = paramMusicConfigInfo.title.get().toStringUtf8();
    this.jdField_d_of_type_JavaLangString = paramMusicConfigInfo.audio_url.get().toStringUtf8();
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramMusicConfigInfo.id.get());
  }
  
  public xkl(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_b_of_type_JavaLangString = paramString.optString("title");
      this.jdField_d_of_type_JavaLangString = paramString.optString("audio_url");
      if (paramString.has("type")) {}
      for (this.jdField_b_of_type_Int = paramString.optInt("type");; this.jdField_b_of_type_Int = 2)
      {
        this.jdField_a_of_type_JavaLangString = paramString.optString("id");
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
  public static final ArrayList<xkl> a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 135
    //   3: invokestatic 140	bdea:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_0
    //   7: new 142	org/json/JSONArray
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 143	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 146	org/json/JSONArray:length	()I
    //   22: istore_2
    //   23: new 148	java/util/ArrayList
    //   26: dup
    //   27: iload_2
    //   28: invokespecial 151	java/util/ArrayList:<init>	(I)V
    //   31: astore_0
    //   32: iconst_0
    //   33: istore_1
    //   34: aload_0
    //   35: astore_3
    //   36: iload_1
    //   37: iload_2
    //   38: if_icmpge +53 -> 91
    //   41: aload_0
    //   42: new 2	xkl
    //   45: dup
    //   46: aload 4
    //   48: iload_1
    //   49: invokevirtual 153	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   52: invokespecial 154	xkl:<init>	(Ljava/lang/String;)V
    //   55: invokevirtual 158	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   72: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +16 -> 91
    //   78: ldc 125
    //   80: iconst_2
    //   81: aload 4
    //   83: invokestatic 129	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   86: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public static final void a(Context paramContext, ArrayList<xkl> paramArrayList)
  {
    Object localObject = null;
    if (paramArrayList != null)
    {
      int j = paramArrayList.size();
      localObject = new JSONArray();
      int i = 0;
      while (i < j)
      {
        ((JSONArray)localObject).put(((xkl)paramArrayList.get(i)).a());
        i += 1;
      }
      localObject = ((JSONArray)localObject).toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      bdea.a(paramContext, "qqstory_savedMusicList");
      return;
    }
    bdea.a(paramContext, "qqstory_savedMusicList", (String)localObject);
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("audio_url", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("type", 3);
      localJSONObject.put("id", this.jdField_a_of_type_JavaLangString);
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
  
  public void a(xkl paramxkl)
  {
    this.jdField_a_of_type_JavaLangString = paramxkl.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramxkl.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramxkl.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramxkl.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramxkl.jdField_e_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = paramxkl.jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramxkl.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramxkl.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramxkl.jdField_c_of_type_Int;
    this.g = paramxkl.g;
    this.jdField_d_of_type_Int = paramxkl.jdField_d_of_type_Int;
    this.jdField_e_of_type_Int = paramxkl.jdField_e_of_type_Int;
    this.jdField_f_of_type_Int = paramxkl.jdField_f_of_type_Int;
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
    xkl localxkl = (xkl)paramObject;
    if ((localxkl.jdField_b_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0)) {
      return true;
    }
    if ((localxkl.jdField_b_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1)) {
      return true;
    }
    if ((localxkl.jdField_b_of_type_Int == this.jdField_b_of_type_Int) && (localxkl.jdField_b_of_type_JavaLangString != null) && (localxkl.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (localxkl.jdField_d_of_type_JavaLangString != null) && (localxkl.jdField_d_of_type_JavaLangString.equals(this.jdField_d_of_type_JavaLangString))) {
      return true;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xkl
 * JD-Core Version:    0.7.0.1
 */