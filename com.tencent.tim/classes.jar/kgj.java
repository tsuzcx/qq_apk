import android.text.TextUtils;
import org.json.JSONObject;

public class kgj
{
  public String Za;
  public String Zb;
  public String Zc;
  public String Zd;
  public String Ze;
  public String Zf;
  public String Zg;
  public int aIB = -1;
  public int aIC;
  public String mJumpUrl;
  public int mPicHeight;
  public int mPicWidth;
  public long rU = -1L;
  
  /* Error */
  public static kgj a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +158 -> 162
    //   7: new 2	kgj
    //   10: dup
    //   11: invokespecial 42	kgj:<init>	()V
    //   14: astore_1
    //   15: new 44	org/json/JSONObject
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_1
    //   25: aload_0
    //   26: ldc 49
    //   28: invokevirtual 53	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   31: putfield 28	kgj:rU	J
    //   34: aload_1
    //   35: aload_0
    //   36: ldc 55
    //   38: invokevirtual 59	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   41: putfield 30	kgj:aIB	I
    //   44: aload_1
    //   45: aload_0
    //   46: ldc 61
    //   48: invokevirtual 59	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   51: putfield 63	kgj:aIC	I
    //   54: aload_1
    //   55: aload_0
    //   56: ldc 64
    //   58: invokevirtual 59	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   61: putfield 66	kgj:mPicWidth	I
    //   64: aload_1
    //   65: aload_0
    //   66: ldc 67
    //   68: invokevirtual 59	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   71: putfield 69	kgj:mPicHeight	I
    //   74: aload_1
    //   75: aload_0
    //   76: ldc 49
    //   78: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 75	kgj:Za	Ljava/lang/String;
    //   84: aload_1
    //   85: aload_0
    //   86: ldc 77
    //   88: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: putfield 79	kgj:Zb	Ljava/lang/String;
    //   94: aload_1
    //   95: aload_0
    //   96: ldc 80
    //   98: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 82	kgj:mJumpUrl	Ljava/lang/String;
    //   104: aload_1
    //   105: aload_0
    //   106: ldc 84
    //   108: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 86	kgj:Ze	Ljava/lang/String;
    //   114: aload_1
    //   115: aload_0
    //   116: ldc 88
    //   118: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 90	kgj:Zd	Ljava/lang/String;
    //   124: aload_1
    //   125: aload_0
    //   126: ldc 92
    //   128: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 94	kgj:Zg	Ljava/lang/String;
    //   134: aload_1
    //   135: aload_0
    //   136: ldc 96
    //   138: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   141: putfield 98	kgj:Zc	Ljava/lang/String;
    //   144: aload_1
    //   145: aload_0
    //   146: ldc 100
    //   148: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   151: putfield 102	kgj:Zf	Ljava/lang/String;
    //   154: aload_1
    //   155: areturn
    //   156: astore_0
    //   157: aconst_null
    //   158: areturn
    //   159: astore_0
    //   160: aload_1
    //   161: areturn
    //   162: aconst_null
    //   163: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   14	147	1	localkgj	kgj
    // Exception table:
    //   from	to	target	type
    //   0	15	156	java/lang/Exception
    //   15	154	159	java/lang/Exception
  }
  
  public String jdMethod_if()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.rU > 0L) {
        localJSONObject.put("medalid", this.rU);
      }
      if (this.aIB > 0) {
        localJSONObject.put("mMedalType", this.aIB);
      }
      if (this.aIC > 0) {
        localJSONObject.put("mIsJump", this.aIC);
      }
      if (this.mPicWidth > 0) {
        localJSONObject.put("mPicWidth", this.mPicWidth);
      }
      if (this.mPicHeight > 0) {
        localJSONObject.put("mPicHeight", this.mPicHeight);
      }
      if (!TextUtils.isEmpty(this.Za)) {
        localJSONObject.put("medal_name", this.Za);
      }
      if (!TextUtils.isEmpty("medal_url")) {
        localJSONObject.put("medal_url", this.Zb);
      }
      if (!TextUtils.isEmpty("mJumpUrl")) {
        localJSONObject.put("mJumpUrl", this.mJumpUrl);
      }
      if (!TextUtils.isEmpty("medal_scene")) {
        localJSONObject.put("medal_scene", this.Zd);
      }
      if (!TextUtils.isEmpty("medal_pos")) {
        localJSONObject.put("medal_pos", this.Ze);
      }
      if (!TextUtils.isEmpty("channelid")) {
        localJSONObject.put("channelid", this.Zc);
      }
      if (!TextUtils.isEmpty("feedsid")) {
        localJSONObject.put("feedsid", this.Zf);
      }
      if (!TextUtils.isEmpty("medal_uin")) {
        localJSONObject.put("medal_uin", this.Zg);
      }
    }
    catch (Exception localException)
    {
      label254:
      break label254;
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgj
 * JD-Core Version:    0.7.0.1
 */