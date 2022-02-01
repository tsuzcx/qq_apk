package com.tencent.mobileqq.data;

import aczw;
import anaz;
import android.view.View;
import java.io.Serializable;

public class MessageForDeviceSingleStruct
  extends ChatMessage
{
  public static final int DATATYPE_SINGLESTRUCT_PIC = 1;
  public static final int DATATYPE_SINGLESTRUCT_VIDEO = 2;
  private static final String TAG = "MessageForDeviceSingleStruct";
  public long entityID;
  public String ext = "";
  public String faceRect = "";
  public long nAppearTime = anaz.gQ();
  public int nCoverChannelType = 0;
  public long nCoverSessionID = 0L;
  public int nDataType = 1;
  public int nMediaChannelType = 0;
  public long nMediaFileSize = 0L;
  public int nMediaFileStatus = 1;
  public float nMediaProgress = 0.0F;
  public long nMediaSessionID = 0L;
  public String strCoverKey = "";
  public String strCoverKey2;
  public String strCoverMD5 = "";
  public String strCoverPath = "";
  public String strDigest = "";
  public String strFileKey2;
  public String strGuideWords = "";
  public String strMediaFileName = "";
  public String strMediaKey = "";
  public String strMediaPath = "";
  public String strTitle = "";
  public String url = "";
  
  protected void doParse()
  {
    try
    {
      SingleStructMsgSerial localSingleStructMsgSerial = (SingleStructMsgSerial)aczw.c(this.msgData);
      if (localSingleStructMsgSerial != null)
      {
        this.nDataType = localSingleStructMsgSerial.nDataType;
        this.strTitle = localSingleStructMsgSerial.strTitle;
        this.nAppearTime = localSingleStructMsgSerial.nAppearTime;
        this.strDigest = localSingleStructMsgSerial.strDigest;
        this.strGuideWords = localSingleStructMsgSerial.strGuideWords;
        this.nCoverSessionID = localSingleStructMsgSerial.nCoverSessionID;
        this.strCoverPath = localSingleStructMsgSerial.strCoverPath;
        this.nMediaSessionID = localSingleStructMsgSerial.nMediaSessionID;
        this.strMediaPath = localSingleStructMsgSerial.strMediaPath;
        this.nMediaFileStatus = localSingleStructMsgSerial.nMediaFileStatus;
        this.nMediaProgress = localSingleStructMsgSerial.nMediaProgress;
        this.strMediaFileName = localSingleStructMsgSerial.strMediaFileName;
        this.nMediaFileSize = localSingleStructMsgSerial.nMediaFileSize;
        this.strCoverMD5 = localSingleStructMsgSerial.strCoverMD5;
        this.nMediaChannelType = localSingleStructMsgSerial.nMediaChannelType;
        this.nCoverChannelType = localSingleStructMsgSerial.nCoverChannelType;
        this.strMediaKey = localSingleStructMsgSerial.strMediaKey;
        this.strCoverKey = localSingleStructMsgSerial.strCoverKey;
        this.strFileKey2 = localSingleStructMsgSerial.strFileKey2;
        this.strCoverKey2 = localSingleStructMsgSerial.strCoverKey2;
        this.ext = localSingleStructMsgSerial.ext;
        this.msg = localSingleStructMsgSerial.strRecentMsg;
        this.faceRect = localSingleStructMsgSerial.faceRect;
        this.url = localSingleStructMsgSerial.url;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  /* Error */
  public boolean parseFromJson(String paramString)
  {
    // Byte code:
    //   0: new 155	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 158	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 160
    //   13: invokestatic 61	anaz:gQ	()J
    //   16: invokevirtual 164	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   19: putfield 167	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:time	J
    //   22: aload_0
    //   23: aload_1
    //   24: ldc 169
    //   26: ldc 170
    //   28: invokestatic 176	acfp:m	(I)Ljava/lang/String;
    //   31: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   34: putfield 55	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strTitle	Ljava/lang/String;
    //   37: aload_1
    //   38: ldc 182
    //   40: ldc 53
    //   42: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 51	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nDataType	I
    //   51: aload_2
    //   52: ldc 184
    //   54: invokevirtual 190	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   57: ifne +316 -> 373
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 51	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nDataType	I
    //   65: aload_0
    //   66: aload_1
    //   67: ldc 192
    //   69: invokestatic 61	anaz:gQ	()J
    //   72: invokevirtual 164	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   75: putfield 63	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nAppearTime	J
    //   78: aload_0
    //   79: aload_1
    //   80: ldc 194
    //   82: ldc 53
    //   84: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: putfield 65	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strDigest	Ljava/lang/String;
    //   90: aload_0
    //   91: aload_1
    //   92: ldc 196
    //   94: ldc 53
    //   96: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 67	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strGuideWords	Ljava/lang/String;
    //   102: aload_1
    //   103: ldc 198
    //   105: ldc 53
    //   107: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_2
    //   111: aload_2
    //   112: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +13 -> 128
    //   118: aload_0
    //   119: aload_2
    //   120: putfield 93	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey	Ljava/lang/String;
    //   123: aload_0
    //   124: iconst_1
    //   125: putfield 89	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nCoverChannelType	I
    //   128: aload_1
    //   129: ldc 206
    //   131: ldc 53
    //   133: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_2
    //   137: aload_2
    //   138: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +13 -> 154
    //   144: aload_0
    //   145: aload_2
    //   146: putfield 91	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strMediaKey	Ljava/lang/String;
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 87	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nMediaChannelType	I
    //   154: aload_1
    //   155: ldc 208
    //   157: ldc 53
    //   159: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore_2
    //   163: aload_2
    //   164: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   167: ifne +13 -> 180
    //   170: aload_0
    //   171: aload_2
    //   172: putfield 93	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey	Ljava/lang/String;
    //   175: aload_0
    //   176: iconst_2
    //   177: putfield 89	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nCoverChannelType	I
    //   180: aload_1
    //   181: ldc 210
    //   183: ldc 53
    //   185: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: astore_2
    //   189: aload_2
    //   190: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifne +13 -> 206
    //   196: aload_0
    //   197: aload_2
    //   198: putfield 91	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strMediaKey	Ljava/lang/String;
    //   201: aload_0
    //   202: iconst_2
    //   203: putfield 87	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nMediaChannelType	I
    //   206: aload_1
    //   207: ldc 212
    //   209: ldc 53
    //   211: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: astore_2
    //   215: aload_2
    //   216: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifne +34 -> 253
    //   222: aload_0
    //   223: aload_2
    //   224: putfield 93	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey	Ljava/lang/String;
    //   227: aload_0
    //   228: iconst_3
    //   229: putfield 89	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nCoverChannelType	I
    //   232: aload_1
    //   233: ldc 214
    //   235: ldc 53
    //   237: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   240: astore_2
    //   241: aload_2
    //   242: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +8 -> 253
    //   248: aload_0
    //   249: aload_2
    //   250: putfield 137	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey2	Ljava/lang/String;
    //   253: aload_1
    //   254: ldc 216
    //   256: ldc 53
    //   258: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   261: astore_2
    //   262: aload_2
    //   263: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +34 -> 300
    //   269: aload_0
    //   270: aload_2
    //   271: putfield 91	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strMediaKey	Ljava/lang/String;
    //   274: aload_0
    //   275: iconst_3
    //   276: putfield 87	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nMediaChannelType	I
    //   279: aload_1
    //   280: ldc 218
    //   282: ldc 53
    //   284: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   287: astore_2
    //   288: aload_2
    //   289: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifne +8 -> 300
    //   295: aload_0
    //   296: aload_2
    //   297: putfield 134	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strFileKey2	Ljava/lang/String;
    //   300: aload_1
    //   301: ldc 220
    //   303: invokevirtual 224	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   306: astore_2
    //   307: aload_2
    //   308: ifnull +39 -> 347
    //   311: aload_2
    //   312: invokevirtual 230	org/json/JSONArray:length	()I
    //   315: ifle +32 -> 347
    //   318: aload_2
    //   319: iconst_0
    //   320: invokevirtual 234	org/json/JSONArray:isNull	(I)Z
    //   323: ifne +24 -> 347
    //   326: aload_2
    //   327: iconst_0
    //   328: invokevirtual 238	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   331: invokevirtual 242	org/json/JSONObject:toString	()Ljava/lang/String;
    //   334: astore_2
    //   335: aload_2
    //   336: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   339: ifne +8 -> 347
    //   342: aload_0
    //   343: aload_2
    //   344: putfield 95	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:faceRect	Ljava/lang/String;
    //   347: aload_0
    //   348: aload_1
    //   349: ldc 243
    //   351: ldc 53
    //   353: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   356: putfield 97	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:url	Ljava/lang/String;
    //   359: aload_0
    //   360: aload_1
    //   361: ldc 244
    //   363: ldc 53
    //   365: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   368: putfield 99	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:ext	Ljava/lang/String;
    //   371: iconst_1
    //   372: ireturn
    //   373: aload_2
    //   374: ldc 246
    //   376: invokevirtual 190	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   379: ifne -314 -> 65
    //   382: aload_0
    //   383: iconst_2
    //   384: putfield 51	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nDataType	I
    //   387: goto -322 -> 65
    //   390: astore_1
    //   391: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +32 -> 426
    //   397: ldc 19
    //   399: iconst_2
    //   400: new 254	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 257
    //   410: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_1
    //   414: invokevirtual 264	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   417: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: iconst_0
    //   427: ireturn
    //   428: astore_1
    //   429: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   432: ifeq -6 -> 426
    //   435: ldc 19
    //   437: iconst_2
    //   438: new 254	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 271
    //   448: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_1
    //   452: invokevirtual 272	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: goto -38 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	MessageForDeviceSingleStruct
    //   0	467	1	paramString	String
    //   45	329	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	65	390	org/json/JSONException
    //   65	128	390	org/json/JSONException
    //   128	154	390	org/json/JSONException
    //   154	180	390	org/json/JSONException
    //   180	206	390	org/json/JSONException
    //   206	253	390	org/json/JSONException
    //   253	300	390	org/json/JSONException
    //   300	307	390	org/json/JSONException
    //   311	347	390	org/json/JSONException
    //   347	371	390	org/json/JSONException
    //   373	387	390	org/json/JSONException
    //   0	65	428	java/lang/Exception
    //   65	128	428	java/lang/Exception
    //   128	154	428	java/lang/Exception
    //   154	180	428	java/lang/Exception
    //   180	206	428	java/lang/Exception
    //   206	253	428	java/lang/Exception
    //   253	300	428	java/lang/Exception
    //   300	307	428	java/lang/Exception
    //   311	347	428	java/lang/Exception
    //   347	371	428	java/lang/Exception
    //   373	387	428	java/lang/Exception
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    SingleStructMsgSerial localSingleStructMsgSerial = new SingleStructMsgSerial(null);
    localSingleStructMsgSerial.nDataType = this.nDataType;
    localSingleStructMsgSerial.strTitle = this.strTitle;
    localSingleStructMsgSerial.nAppearTime = this.nAppearTime;
    localSingleStructMsgSerial.strDigest = this.strDigest;
    localSingleStructMsgSerial.strGuideWords = this.strGuideWords;
    localSingleStructMsgSerial.nCoverSessionID = this.nCoverSessionID;
    localSingleStructMsgSerial.strMediaKey = this.strMediaKey;
    localSingleStructMsgSerial.strCoverPath = this.strCoverPath;
    localSingleStructMsgSerial.strFileKey2 = this.strFileKey2;
    localSingleStructMsgSerial.strCoverKey2 = this.strCoverKey2;
    localSingleStructMsgSerial.nMediaSessionID = this.nMediaSessionID;
    localSingleStructMsgSerial.strCoverKey = this.strCoverKey;
    localSingleStructMsgSerial.strMediaPath = this.strMediaPath;
    localSingleStructMsgSerial.nMediaFileStatus = this.nMediaFileStatus;
    localSingleStructMsgSerial.nMediaProgress = this.nMediaProgress;
    localSingleStructMsgSerial.strMediaFileName = this.strMediaFileName;
    localSingleStructMsgSerial.nMediaFileSize = this.nMediaFileSize;
    localSingleStructMsgSerial.strCoverMD5 = this.strCoverMD5;
    localSingleStructMsgSerial.nMediaChannelType = this.nMediaChannelType;
    localSingleStructMsgSerial.nCoverChannelType = this.nCoverChannelType;
    localSingleStructMsgSerial.strRecentMsg = this.msg;
    localSingleStructMsgSerial.faceRect = this.faceRect;
    localSingleStructMsgSerial.url = this.url;
    localSingleStructMsgSerial.ext = this.ext;
    try
    {
      this.msgData = aczw.b(localSingleStructMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  static class SingleStructMsgSerial
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public String ext;
    public String faceRect;
    public long nAppearTime;
    public int nCoverChannelType;
    public long nCoverSessionID;
    public int nDataType;
    public int nMediaChannelType;
    public long nMediaFileSize;
    public int nMediaFileStatus;
    public float nMediaProgress;
    public long nMediaSessionID;
    public String strCoverKey;
    public String strCoverKey2;
    public String strCoverMD5;
    public String strCoverPath;
    public String strDigest;
    public String strFileKey2;
    public String strGuideWords;
    public String strMediaFileName;
    public String strMediaKey;
    public String strMediaPath;
    public String strRecentMsg;
    public String strTitle;
    public String url;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeviceSingleStruct
 * JD-Core Version:    0.7.0.1
 */