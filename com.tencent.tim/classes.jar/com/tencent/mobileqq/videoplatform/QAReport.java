package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import java.util.HashMap;

public class QAReport
{
  public static final String LOG_TAG = "[VideoPlatForm]QAReport";
  public static final String REPORT_EVENT_NAME = "actVideoSDKPlay";
  public static final String REPORT_KEY_AUDIO_BITRATE = "param_audioBitRate";
  public static final String REPORT_KEY_AUDIO_CHANNELS = "param_audioChannels";
  public static final String REPORT_KEY_AUDIO_CODEC = "param_audioCodec";
  public static final String REPORT_KEY_AUDIO_PROFILE = "param_audioProfile";
  public static final String REPORT_KEY_AUDIO_SAMPLERATE = "param_audioSampleRate";
  public static final String REPORT_KEY_BUFF_COUNT = "param_buffCount";
  public static final String REPORT_KEY_BUFF_TOTAL_COMSUME = "param_buffTotalConsume";
  public static final String REPORT_KEY_BUSI_TPYE = "param_busiType";
  public static final String REPORT_KEY_CONTAINER_FORMAT = "param_containerFormat";
  public static final String REPORT_KEY_DECODE_FF_COST = "param_decodeFFCost";
  public static final String REPORT_KEY_ERR_CODE = "param_errCode";
  public static final String REPORT_KEY_ERR_INFO = "param_errInfo";
  public static final String REPORT_KEY_ERR_MODULE = "param_errModule";
  public static final String REPORT_KEY_ERR_TYPE = "param_errType";
  public static final String REPORT_KEY_FILE_ID = "param_fileID";
  public static final String REPORT_KEY_FILE_SIZE = "param_fileSize";
  public static final String REPORT_KEY_FIRST_BUFF_COMSUME = "param_firstBuffConsume";
  public static final String REPORT_KEY_FIST_DECODE = "param_firsDecode";
  public static final String REPORT_KEY_HA_ERRO = "param_haErro";
  public static final String REPORT_KEY_HA_STRATEGY = "param_haStrategy";
  public static final String REPORT_KEY_IS_LOOP = "param_isLoop";
  public static final String REPORT_KEY_IS_MEDIACODEC = "param_ismediacodec";
  public static final String REPORT_KEY_IS_MUTE = "param_isMute";
  public static final String REPORT_KEY_LAST_DECODE = "param_lastDecode";
  public static final String REPORT_KEY_PLAYER_TYPE = "param_playerType";
  public static final String REPORT_KEY_PLAY_TYPE = "param_playType";
  public static final String REPORT_KEY_PLAY_URL = "param_playUrl";
  public static final String REPORT_KEY_SKIP_FRAMES_COUNT = "param_skipFramesCount";
  public static final String REPORT_KEY_SKIP_LOT_FRAMES = "param_skipLotFrame";
  public static final String REPORT_KEY_SUCCESSED = "param_isSuccessed";
  public static final String REPORT_KEY_TOTAL_PLAY_TIME = "param_totalPlayTime";
  public static final String REPORT_KEY_VIDEO_BITRATE = "param_videoBitRate";
  public static final String REPORT_KEY_VIDEO_CODEC = "param_videoCodec";
  public static final String REPORT_KEY_VIDEO_DURATION = "param_videoDuration";
  public static final String REPORT_KEY_VIDEO_HEIGHT = "param_videoHeight";
  public static final String REPORT_KEY_VIDEO_PROFILE = "param_videoProfile";
  public static final String REPORT_KEY_VIDEO_WIDTH = "param_videoWidth";
  public static final String REPORT_PLAYER_VER = "param_playerVer";
  public long audioBitRate;
  public int audioChannels;
  public String audioCodec;
  public String audioProfile;
  public long audioSampleRate;
  public long bufferCount;
  public String containerFormat;
  public long decodeFirstFrameCost;
  public int dwErrCode;
  public int errCode;
  public String errDetailInfo;
  public int errModule;
  public int errType;
  public long fileSize;
  public long firstBuffConsume;
  public long firstRenderTime;
  public int firstTryDecoderMode = -1;
  public int haStrategyReturnCode = -1;
  public boolean hasStarted;
  public int isMediaCodec;
  public boolean isSkipLotsOfFrames;
  public boolean isSuccessed;
  public int lastTryDecoderMode = -1;
  public long openPlayerTime;
  public int playerHaErrorCode = -1;
  public int playerType;
  public String playerVersion;
  public int skipFramesTotalCount;
  public long startPlayTime;
  public long stopPlayTime;
  public long totalBufferingDuration;
  public long totalPlayTime;
  public long videoBitRate;
  public String videoCodec;
  public long videoDuration;
  public int videoHeight;
  public VideoPlayParam videoPlayParam;
  public String videoProfile;
  public int videoWidth;
  
  private void addVideoInfo(HashMap<String, String> paramHashMap)
  {
    int k = 1;
    String str2 = "";
    String str3;
    String str4;
    int i;
    String str1;
    label63:
    int j;
    if (this.videoPlayParam != null)
    {
      str3 = this.videoPlayParam.mFileID;
      str4 = this.videoPlayParam.mSceneName;
      if (!this.videoPlayParam.mIsLocal) {
        break label163;
      }
      i = 0;
      if (!this.videoPlayParam.mIsLocal) {
        break label168;
      }
      str1 = this.videoPlayParam.mVideoPath;
      if (!this.videoPlayParam.mIsLoop) {
        break label211;
      }
      j = 1;
      label75:
      if (!this.videoPlayParam.mIsMute) {
        break label216;
      }
    }
    for (;;)
    {
      this.fileSize = this.videoPlayParam.mFileSize;
      paramHashMap.put("param_fileID", str3);
      paramHashMap.put("param_playType", String.valueOf(i));
      paramHashMap.put("param_isLoop", String.valueOf(j));
      paramHashMap.put("param_isMute", String.valueOf(k));
      if (str4 != null) {
        paramHashMap.put("param_busiType", str4);
      }
      paramHashMap.put("param_playUrl", str1);
      return;
      label163:
      i = 1;
      break;
      label168:
      str1 = str2;
      if (this.videoPlayParam.mUrls == null) {
        break label63;
      }
      str1 = str2;
      if (this.videoPlayParam.mUrls.length <= 0) {
        break label63;
      }
      str1 = this.videoPlayParam.mUrls[0];
      break label63;
      label211:
      j = 0;
      break label75;
      label216:
      k = 0;
    }
  }
  
  /* Error */
  public void doReport(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +15 -> 18
    //   6: aload_0
    //   7: getfield 234	com/tencent/mobileqq/videoplatform/QAReport:hasStarted	Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifne +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: new 214	java/util/HashMap
    //   21: dup
    //   22: invokespecial 235	java/util/HashMap:<init>	()V
    //   25: astore_3
    //   26: aload_0
    //   27: aload_3
    //   28: invokespecial 237	com/tencent/mobileqq/videoplatform/QAReport:addVideoInfo	(Ljava/util/HashMap;)V
    //   31: aload_0
    //   32: invokestatic 243	java/lang/System:currentTimeMillis	()J
    //   35: putfield 245	com/tencent/mobileqq/videoplatform/QAReport:stopPlayTime	J
    //   38: aload_0
    //   39: invokestatic 251	com/tencent/superplayer/api/SuperPlayerSDKMgr:getSDKVersion	()Ljava/lang/String;
    //   42: putfield 253	com/tencent/mobileqq/videoplatform/QAReport:playerVersion	Ljava/lang/String;
    //   45: aload_0
    //   46: iload_1
    //   47: putfield 255	com/tencent/mobileqq/videoplatform/QAReport:isSuccessed	Z
    //   50: aload_0
    //   51: getfield 257	com/tencent/mobileqq/videoplatform/QAReport:startPlayTime	J
    //   54: lconst_0
    //   55: lcmp
    //   56: ifle +25 -> 81
    //   59: aload_0
    //   60: getfield 245	com/tencent/mobileqq/videoplatform/QAReport:stopPlayTime	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +16 -> 81
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 245	com/tencent/mobileqq/videoplatform/QAReport:stopPlayTime	J
    //   73: aload_0
    //   74: getfield 257	com/tencent/mobileqq/videoplatform/QAReport:startPlayTime	J
    //   77: lsub
    //   78: putfield 259	com/tencent/mobileqq/videoplatform/QAReport:totalPlayTime	J
    //   81: aload_0
    //   82: getfield 261	com/tencent/mobileqq/videoplatform/QAReport:openPlayerTime	J
    //   85: lconst_0
    //   86: lcmp
    //   87: ifle +25 -> 112
    //   90: aload_0
    //   91: getfield 263	com/tencent/mobileqq/videoplatform/QAReport:firstRenderTime	J
    //   94: lconst_0
    //   95: lcmp
    //   96: ifle +16 -> 112
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 263	com/tencent/mobileqq/videoplatform/QAReport:firstRenderTime	J
    //   104: aload_0
    //   105: getfield 261	com/tencent/mobileqq/videoplatform/QAReport:openPlayerTime	J
    //   108: lsub
    //   109: putfield 265	com/tencent/mobileqq/videoplatform/QAReport:firstBuffConsume	J
    //   112: aload_3
    //   113: ldc 125
    //   115: aload_0
    //   116: getfield 253	com/tencent/mobileqq/videoplatform/QAReport:playerVersion	Ljava/lang/String;
    //   119: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: aload_3
    //   124: ldc 101
    //   126: aload_0
    //   127: getfield 255	com/tencent/mobileqq/videoplatform/QAReport:isSuccessed	Z
    //   130: invokestatic 268	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   133: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload_3
    //   138: ldc 44
    //   140: aload_0
    //   141: getfield 270	com/tencent/mobileqq/videoplatform/QAReport:errCode	I
    //   144: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   147: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_3
    //   152: ldc 50
    //   154: aload_0
    //   155: getfield 272	com/tencent/mobileqq/videoplatform/QAReport:errModule	I
    //   158: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   161: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: pop
    //   165: aload_3
    //   166: ldc 53
    //   168: aload_0
    //   169: getfield 274	com/tencent/mobileqq/videoplatform/QAReport:errType	I
    //   172: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   175: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: pop
    //   179: aload_3
    //   180: ldc 47
    //   182: aload_0
    //   183: getfield 276	com/tencent/mobileqq/videoplatform/QAReport:errDetailInfo	Ljava/lang/String;
    //   186: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: pop
    //   190: aload_3
    //   191: ldc 62
    //   193: aload_0
    //   194: getfield 265	com/tencent/mobileqq/videoplatform/QAReport:firstBuffConsume	J
    //   197: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   200: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: aload_3
    //   205: ldc 29
    //   207: aload_0
    //   208: getfield 281	com/tencent/mobileqq/videoplatform/QAReport:bufferCount	J
    //   211: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   214: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: aload_3
    //   219: ldc 32
    //   221: aload_0
    //   222: getfield 283	com/tencent/mobileqq/videoplatform/QAReport:totalBufferingDuration	J
    //   225: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   228: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: aload_3
    //   233: ldc 98
    //   235: aload_0
    //   236: getfield 285	com/tencent/mobileqq/videoplatform/QAReport:isSkipLotsOfFrames	Z
    //   239: invokestatic 268	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   242: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: aload_3
    //   247: ldc 95
    //   249: aload_0
    //   250: getfield 287	com/tencent/mobileqq/videoplatform/QAReport:skipFramesTotalCount	I
    //   253: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   256: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload_3
    //   261: ldc 86
    //   263: aload_0
    //   264: getfield 289	com/tencent/mobileqq/videoplatform/QAReport:playerType	I
    //   267: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   270: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: aload_3
    //   275: ldc 65
    //   277: aload_0
    //   278: getfield 174	com/tencent/mobileqq/videoplatform/QAReport:firstTryDecoderMode	I
    //   281: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   284: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: aload_3
    //   289: ldc 83
    //   291: aload_0
    //   292: getfield 176	com/tencent/mobileqq/videoplatform/QAReport:lastTryDecoderMode	I
    //   295: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   298: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: aload_3
    //   303: ldc 71
    //   305: aload_0
    //   306: getfield 178	com/tencent/mobileqq/videoplatform/QAReport:haStrategyReturnCode	I
    //   309: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   312: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   315: pop
    //   316: aload_3
    //   317: ldc 68
    //   319: aload_0
    //   320: getfield 180	com/tencent/mobileqq/videoplatform/QAReport:playerHaErrorCode	I
    //   323: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   326: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: pop
    //   330: aload_3
    //   331: ldc 113
    //   333: aload_0
    //   334: getfield 291	com/tencent/mobileqq/videoplatform/QAReport:videoDuration	J
    //   337: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   340: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   343: pop
    //   344: aload_3
    //   345: ldc 110
    //   347: aload_0
    //   348: getfield 293	com/tencent/mobileqq/videoplatform/QAReport:videoCodec	Ljava/lang/String;
    //   351: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: pop
    //   355: aload_3
    //   356: ldc 119
    //   358: aload_0
    //   359: getfield 295	com/tencent/mobileqq/videoplatform/QAReport:videoProfile	Ljava/lang/String;
    //   362: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: aload_3
    //   367: ldc 107
    //   369: aload_0
    //   370: getfield 297	com/tencent/mobileqq/videoplatform/QAReport:videoBitRate	J
    //   373: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   376: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   379: pop
    //   380: aload_3
    //   381: ldc 20
    //   383: aload_0
    //   384: getfield 299	com/tencent/mobileqq/videoplatform/QAReport:audioCodec	Ljava/lang/String;
    //   387: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   390: pop
    //   391: aload_3
    //   392: ldc 23
    //   394: aload_0
    //   395: getfield 301	com/tencent/mobileqq/videoplatform/QAReport:audioProfile	Ljava/lang/String;
    //   398: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: pop
    //   402: aload_3
    //   403: ldc 26
    //   405: aload_0
    //   406: getfield 303	com/tencent/mobileqq/videoplatform/QAReport:audioSampleRate	J
    //   409: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   412: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   415: pop
    //   416: aload_3
    //   417: ldc 17
    //   419: aload_0
    //   420: getfield 305	com/tencent/mobileqq/videoplatform/QAReport:audioChannels	I
    //   423: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   426: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   429: pop
    //   430: aload_3
    //   431: ldc 14
    //   433: aload_0
    //   434: getfield 307	com/tencent/mobileqq/videoplatform/QAReport:audioBitRate	J
    //   437: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   440: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   443: pop
    //   444: aload_3
    //   445: ldc 104
    //   447: aload_0
    //   448: getfield 259	com/tencent/mobileqq/videoplatform/QAReport:totalPlayTime	J
    //   451: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   454: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: pop
    //   458: aload_3
    //   459: ldc 59
    //   461: aload_0
    //   462: getfield 212	com/tencent/mobileqq/videoplatform/QAReport:fileSize	J
    //   465: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   468: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload_3
    //   473: ldc 41
    //   475: aload_0
    //   476: getfield 309	com/tencent/mobileqq/videoplatform/QAReport:decodeFirstFrameCost	J
    //   479: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   482: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload_3
    //   487: ldc 116
    //   489: aload_0
    //   490: getfield 311	com/tencent/mobileqq/videoplatform/QAReport:videoHeight	I
    //   493: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   496: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: aload_3
    //   501: ldc 122
    //   503: aload_0
    //   504: getfield 313	com/tencent/mobileqq/videoplatform/QAReport:videoWidth	I
    //   507: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   510: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   513: pop
    //   514: aload_3
    //   515: ldc 38
    //   517: aload_0
    //   518: getfield 315	com/tencent/mobileqq/videoplatform/QAReport:containerFormat	Ljava/lang/String;
    //   521: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: pop
    //   525: aload_3
    //   526: ldc 77
    //   528: aload_0
    //   529: getfield 317	com/tencent/mobileqq/videoplatform/QAReport:isMediaCodec	I
    //   532: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   535: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   538: pop
    //   539: aconst_null
    //   540: ldc 11
    //   542: aload_0
    //   543: getfield 255	com/tencent/mobileqq/videoplatform/QAReport:isSuccessed	Z
    //   546: lconst_0
    //   547: lconst_0
    //   548: aload_3
    //   549: ldc 185
    //   551: invokestatic 323	com/tencent/mobileqq/videoplatform/util/ReportUtil:report	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   554: goto -539 -> 15
    //   557: astore_3
    //   558: aload_0
    //   559: monitorexit
    //   560: aload_3
    //   561: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	this	QAReport
    //   0	562	1	paramBoolean	boolean
    //   10	2	2	bool	boolean
    //   25	524	3	localHashMap	HashMap
    //   557	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	11	557	finally
    //   18	81	557	finally
    //   81	112	557	finally
    //   112	554	557	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.QAReport
 * JD-Core Version:    0.7.0.1
 */