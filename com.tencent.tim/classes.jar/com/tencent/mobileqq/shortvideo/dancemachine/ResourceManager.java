package com.tencent.mobileqq.shortvideo.dancemachine;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.facedancegame.ExpressionTemplateConfig;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceTemplateConfig;
import com.tencent.sveffects.SLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResourceManager
{
  private static volatile ResourceManager INSTANCE;
  private static final String TAG = "DanceResMgrLog";
  public static String sLittleBoyFilterPath;
  public static String sRootDanceStageQQPath = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/postureRecognizeStage/";
  public static String sRootDanceStageTestPath = Environment.getExternalStorageDirectory() + "/postureRecognizeStage/";
  public static String sTestFaceLittleBoyFilterPath;
  public static String sTestGestureDetectLibSoLocPath = null;
  public static String sTestGestureDetectLibSoPath;
  public static String sTestLittleBoyFilterPath;
  public float compressRatio = 1.0F;
  public List<DancePosture> dancePostures;
  public int durationTime = 0;
  public boolean isCompressed = false;
  public GameNumberResource mGameNumberResource;
  public GamingResource mGamingResource;
  public GeneralResource mGeneralResource;
  public LBGeneralResource mLBGeneraResource;
  private String mLittleBoyFilterRoot;
  public List<LyricItem> mLyricsList;
  private Comparator<LyricItem> mLyricsOrderCompare = new ResourceManager.1(this);
  private int mPostureType = 0;
  public ReadyResource mReadyResource;
  public ScanResource mScanResource;
  public ShareResource mShareResource;
  public StartResource mStartResource;
  private String postureRecognizePath;
  private Map<String, Posture> postures;
  
  static
  {
    sLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/video_niania_iOS/";
    sTestLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/video_niania_iOS/";
    sTestFaceLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/face_dance/";
    sTestGestureDetectLibSoPath = "/sdcard/725_so/";
  }
  
  private boolean checkResExist()
  {
    return new File(this.postureRecognizePath).exists();
  }
  
  private void createDanceStageResource()
  {
    this.mGeneralResource = new GeneralResource();
    this.mScanResource = new ScanResource();
    this.mReadyResource = new ReadyResource();
    this.mStartResource = new StartResource();
    this.mGamingResource = new GamingResource();
    this.mGameNumberResource = new GameNumberResource();
    this.mShareResource = new ShareResource();
  }
  
  public static ResourceManager getInstance()
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new ResourceManager();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private void parseCompressConfig()
  {
    this.compressRatio = 1.0F;
    this.isCompressed = false;
    Object localObject = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("compress.json").toString()) + "";
    try
    {
      localObject = new JSONObject((String)localObject);
      this.isCompressed = ((JSONObject)localObject).optBoolean("isCompressed", false);
      if (this.isCompressed)
      {
        this.compressRatio = ((float)((JSONObject)localObject).optDouble("compressRatio", 1.0D));
        if (this.compressRatio > 1.0F) {
          this.compressRatio = 1.0F;
        }
        if (this.compressRatio < 0.2F) {
          this.compressRatio = 0.2F;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void parseLittleBoyConfig()
  {
    if (this.postures == null) {
      this.postures = new HashMap();
    }
    label36:
    Object localObject2;
    int i;
    label136:
    Object localObject3;
    Object localObject4;
    label224:
    Object localObject6;
    for (;;)
    {
      Object localObject1;
      if (this.dancePostures == null)
      {
        this.dancePostures = new ArrayList();
        localObject1 = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("tConfig.json").toString()) + "";
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (this.mPostureType != 0) {
          break label691;
        }
        localObject2 = ((JSONObject)localObject1).getJSONArray("allGestures");
        if (localObject2 == null)
        {
          return;
          this.postures.clear();
          continue;
          this.dancePostures.clear();
          break label36;
        }
        else
        {
          i = 0;
          if (i >= ((JSONArray)localObject2).length()) {
            break label475;
          }
          localObject5 = ((JSONArray)localObject2).optJSONObject(i);
          if (localObject5 == null) {
            break label1322;
          }
          localObject3 = ((JSONObject)localObject5).optString("id", "");
          localObject4 = new Posture();
          ((Posture)localObject4).id = ((String)localObject3);
          if (TextUtils.isEmpty(((Posture)localObject4).id)) {
            break label1322;
          }
          localObject5 = ((JSONObject)localObject5).optJSONArray("matchTemplate");
          ((Posture)localObject4).gestureConfigs = new ArrayList();
          j = 0;
          if (j < ((JSONArray)localObject5).length())
          {
            localObject6 = MatchTemplateConfig.parseConfig(((JSONArray)localObject5).get(j).toString());
            if (localObject6 == null) {
              break label1329;
            }
            ((Posture)localObject4).gestureConfigs.add(localObject6);
            break label1329;
          }
          if (((Posture)localObject4).gestureConfigs.size() == 0) {
            break label1322;
          }
          ((Posture)localObject4).blastPicture = (this.mLittleBoyFilterRoot + "others/dismiss.png");
          ((Posture)localObject4).danceCartoon = new ArrayList();
          localObject5 = new File(this.mLittleBoyFilterRoot + "gestures/" + (String)localObject3);
          if ((!((File)localObject5).exists()) || (!((File)localObject5).isDirectory())) {
            resourceCheck((String)localObject3);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
    Object localObject5 = ((File)localObject5).listFiles();
    int j = 0;
    label398:
    if (j < localObject5.length)
    {
      if (localObject5[j].isFile()) {
        ((Posture)localObject4).danceCartoon.add(localObject5[j].getAbsolutePath());
      }
    }
    else {
      label938:
      if (((Posture)localObject4).danceCartoon.size() == 0)
      {
        resourceCheck((String)localObject3);
      }
      else
      {
        this.postures.put(localObject3, localObject4);
        break label1322;
        label475:
        localObject2 = localJSONException.optJSONArray("dances");
        label691:
        label719:
        if (localObject2 != null)
        {
          i = 0;
          label491:
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).optJSONObject(i);
            if (localObject3 == null) {
              break label1343;
            }
            localObject4 = new DancePosture();
            localObject5 = ((JSONObject)localObject3).optString("gestureId", "");
            if (!this.postures.containsKey(localObject5)) {
              break label1343;
            }
            ((DancePosture)localObject4).id = ((String)localObject5);
            ((DancePosture)localObject4).postureType = 0;
            ((DancePosture)localObject4).appearTime = ((JSONObject)localObject3).optDouble("appearTime", 0.0D);
            if (((DancePosture)localObject4).appearTime < 0.0D) {
              ((DancePosture)localObject4).appearTime = 0.0D;
            }
            ((DancePosture)localObject4).appearCol = ((JSONObject)localObject3).optInt("appearCol", 0);
            if ((((DancePosture)localObject4).appearCol != 1) && (((DancePosture)localObject4).appearCol != 2)) {
              ((DancePosture)localObject4).appearCol = 1;
            }
            ((DancePosture)localObject4).speed = ((JSONObject)localObject3).optDouble("speed", 0.25D);
            if ((((DancePosture)localObject4).speed <= 0.0D) || (((DancePosture)localObject4).speed > 1.0D)) {
              ((DancePosture)localObject4).speed = 0.25D;
            }
            this.dancePostures.add(localObject4);
            break label1343;
            if (this.mPostureType == 1)
            {
              localObject3 = localJSONException.getJSONArray("expressionList");
              localObject2 = new ArrayList();
              i = 0;
              if (i < ((JSONArray)localObject3).length())
              {
                localObject4 = ExpressionTemplateConfig.parseConfig(((JSONArray)localObject3).getString(i));
                if (localObject4 == null) {
                  break label1350;
                }
                ((ArrayList)localObject2).add(localObject4);
                break label1350;
              }
              localObject3 = localJSONException.getJSONArray("matchTemplate");
              i = 0;
              label766:
              if (i < ((JSONArray)localObject3).length())
              {
                localObject4 = FaceDanceTemplateConfig.parseConfig(((JSONArray)localObject3).getString(i), (List)localObject2);
                if (localObject4 == null) {
                  break label1357;
                }
                localObject5 = new Posture();
                ((Posture)localObject5).id = ((FaceDanceTemplateConfig)localObject4).mTemplateID;
                if (TextUtils.isEmpty(((Posture)localObject5).id)) {
                  break label1357;
                }
                ((Posture)localObject5).blastPicture = (this.mLittleBoyFilterRoot + "others/dismiss.png");
                ((Posture)localObject5).faceDanceConfig = ((FaceDanceTemplateConfig)localObject4);
                ((Posture)localObject5).danceCartoon = new ArrayList();
                localObject6 = new File(this.mLittleBoyFilterRoot + "gestures/" + ((FaceDanceTemplateConfig)localObject4).mTemplateID);
                if ((!((File)localObject6).exists()) || (!((File)localObject6).isDirectory())) {
                  break label1357;
                }
                localObject6 = ((File)localObject6).listFiles();
                j = 0;
                if (j < localObject6.length)
                {
                  if (!localObject6[j].isFile()) {
                    break label1364;
                  }
                  ((Posture)localObject5).danceCartoon.add(localObject6[j].getAbsolutePath());
                  break label1364;
                }
                if (((Posture)localObject5).danceCartoon.size() == 0) {
                  break label1357;
                }
                this.postures.put(((FaceDanceTemplateConfig)localObject4).mTemplateID, localObject5);
                break label1357;
              }
              localObject2 = localJSONException.getJSONArray("dances");
              i = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        localObject4 = new DancePosture();
        localObject5 = ((JSONObject)localObject3).getString("gestureId");
        if (this.postures.containsKey(localObject5))
        {
          ((DancePosture)localObject4).id = ((String)localObject5);
          ((DancePosture)localObject4).postureType = 1;
          ((DancePosture)localObject4).appearTime = ((JSONObject)localObject3).getDouble("appearTime");
          if (((DancePosture)localObject4).appearTime < 0.0D) {
            ((DancePosture)localObject4).appearTime = 0.0D;
          }
          ((DancePosture)localObject4).appearCol = ((JSONObject)localObject3).getInt("appearCol");
          if ((((DancePosture)localObject4).appearCol != 1) && (((DancePosture)localObject4).appearCol != 2)) {
            ((DancePosture)localObject4).appearCol = 1;
          }
          ((DancePosture)localObject4).speed = ((JSONObject)localObject3).getDouble("speed");
          if ((((DancePosture)localObject4).speed <= 0.0D) || (((DancePosture)localObject4).speed > 1.0D)) {
            ((DancePosture)localObject4).speed = 0.25D;
          }
          this.dancePostures.add(localObject4);
        }
      }
      else
      {
        if (localJSONException.optInt("randomDance", 0) != 1) {
          break;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < this.dancePostures.size())
        {
          localArrayList.add(((DancePosture)this.dancePostures.get(i)).id);
          i += 1;
        }
        Collections.shuffle(localArrayList);
        i = 0;
        while (i < localArrayList.size())
        {
          ((DancePosture)this.dancePostures.get(i)).id = ((String)localArrayList.get(i));
          i += 1;
        }
        break;
        label1322:
        i += 1;
        break label136;
        label1329:
        j += 1;
        break label224;
        j += 1;
        break label398;
        label1343:
        i += 1;
        break label491;
        label1350:
        i += 1;
        break label719;
        label1357:
        i += 1;
        break label766;
        label1364:
        j += 1;
        break label938;
      }
      i += 1;
    }
  }
  
  private void parseLyricsConfig()
  {
    if ((!QmcfManager.isQQRun) && (this.mPostureType == 0))
    {
      if (this.mLyricsList != null) {
        break label97;
      }
      this.mLyricsList = new ArrayList();
    }
    Object localObject;
    for (;;)
    {
      localObject = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("lyrics.json").toString()) + "";
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject))) {
        break;
      }
      return;
      label97:
      this.mLyricsList.clear();
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("lyricsList")) {
          break;
        }
        localObject = ((JSONObject)localObject).getJSONArray("lyricsList");
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          int j = localJSONObject.optInt("startTime", 0);
          int k = localJSONObject.optInt("endTime", 0);
          if (j > k) {
            break label268;
          }
          LyricItem localLyricItem = new LyricItem();
          localLyricItem.text = localJSONObject.optString("text", "");
          localLyricItem.startTime = j;
          localLyricItem.endTime = k;
          localLyricItem.status = 0;
          this.mLyricsList.add(localLyricItem);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      Collections.sort(this.mLyricsList, this.mLyricsOrderCompare);
      return;
      label268:
      i += 1;
    }
  }
  
  private void parseParamConfig()
  {
    this.durationTime = 30000;
    String str = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("params.json").toString()) + "";
    try
    {
      this.durationTime = ((int)(new JSONObject(str).getJSONObject("postureParam").optDouble("gameDuration", 30.0D) * 1000.0D));
      if (this.durationTime > 60000) {
        this.durationTime = 60000;
      }
      if (this.durationTime <= 0) {
        this.durationTime = 30000;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  /* Error */
  public static String readFileContent(String paramString)
  {
    // Byte code:
    //   0: new 164	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 90	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 170	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 472	java/io/BufferedReader
    //   29: dup
    //   30: new 474	java/io/FileReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 477	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   38: invokespecial 480	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: invokevirtual 483	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +34 -> 84
    //   53: aload_1
    //   54: astore_0
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: goto -19 -> 42
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 484	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: ifnull -48 -> 24
    //   75: aload_1
    //   76: invokevirtual 487	java/io/BufferedReader:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: areturn
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 487	java/io/BufferedReader:close	()V
    //   92: aload_2
    //   93: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: areturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 487	java/io/BufferedReader:close	()V
    //   108: aload_1
    //   109: athrow
    //   110: astore_0
    //   111: goto -19 -> 92
    //   114: astore_0
    //   115: goto -7 -> 108
    //   118: astore_1
    //   119: goto -19 -> 100
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -60 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   41	48	1	localBufferedReader	java.io.BufferedReader
    //   97	12	1	localObject1	Object
    //   118	1	1	localObject2	Object
    //   124	1	1	localObject3	Object
    //   16	40	2	localStringBuilder	StringBuilder
    //   64	29	2	localException1	java.lang.Exception
    //   122	1	2	localException2	java.lang.Exception
    //   48	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   44	49	64	java/lang/Exception
    //   55	61	64	java/lang/Exception
    //   75	79	81	java/lang/Exception
    //   26	42	97	finally
    //   88	92	110	java/lang/Exception
    //   104	108	114	java/lang/Exception
    //   44	49	118	finally
    //   55	61	118	finally
    //   67	71	118	finally
    //   26	42	122	java/lang/Exception
  }
  
  private void resourceCheck(String paramString)
  {
    if (("C".equals(paramString)) && (!TextUtils.isEmpty(this.mLittleBoyFilterRoot)))
    {
      paramString = new File(this.mLittleBoyFilterRoot + "params.json");
      if (paramString.exists())
      {
        paramString.delete();
        if (SLog.isEnable()) {
          SLog.e("DanceResMgrLog", "ResourceCheck fail, delete params file!");
        }
      }
    }
  }
  
  public Map<String, Posture> getAllBoyPosture()
  {
    return this.postures;
  }
  
  public List<String> getAllSound()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mGameNumberResource.scoreSound);
    localArrayList.add(this.mReadyResource.oneSound);
    localArrayList.add(this.mReadyResource.twoSound);
    localArrayList.add(this.mReadyResource.threeSound);
    localArrayList.add(this.mReadyResource.readySound);
    localArrayList.add(this.mStartResource.startSound);
    localArrayList.add(this.mGamingResource.goodSound);
    localArrayList.add(this.mGamingResource.greatSound);
    localArrayList.add(this.mGamingResource.missSound);
    localArrayList.add(this.mGamingResource.perfectSound);
    return localArrayList;
  }
  
  public List<DancePosture> getDancePostures()
  {
    return this.dancePostures;
  }
  
  public String getLittleBoyFilterRootPath()
  {
    return this.mLittleBoyFilterRoot;
  }
  
  public List<LyricItem> getLyricsList()
  {
    if (this.mPostureType != 0) {
      return null;
    }
    return this.mLyricsList;
  }
  
  public Posture getPostureById(String paramString)
  {
    if (this.postures.containsKey(paramString)) {
      return (Posture)this.postures.get(paramString);
    }
    return null;
  }
  
  public int getPostureType()
  {
    return this.mPostureType;
  }
  
  public void setLittleBoyFilterRootPath(String paramString)
  {
    this.mLittleBoyFilterRoot = paramString;
    if ((this.mLittleBoyFilterRoot == null) || ("".equals(this.mLittleBoyFilterRoot))) {
      this.mLittleBoyFilterRoot = sLittleBoyFilterPath;
    }
    parseLittleBoyConfig();
    parseParamConfig();
    parseLyricsConfig();
    parseCompressConfig();
    this.mLBGeneraResource = new LBGeneralResource();
  }
  
  public void setPostureType(int paramInt)
  {
    this.mPostureType = paramInt;
  }
  
  public void setRootDanceStagePath(String paramString)
  {
    this.postureRecognizePath = paramString;
    if ((this.postureRecognizePath == null) || ("".equals(this.postureRecognizePath))) {
      this.postureRecognizePath = sRootDanceStageQQPath;
    }
    createDanceStageResource();
  }
  
  public static class DancePosture
  {
    public static final int DANCE_POSTURE = 0;
    public static final int HAND_GESTURE = 1;
    public int appearCol;
    public double appearTime;
    boolean haveCreated = false;
    public String id;
    public int postureType;
    public double speed;
  }
  
  public class GameNumberResource
  {
    public List<String> gameNums = new ArrayList();
    private String prefix = ResourceManager.this.postureRecognizePath + "number/";
    public String scoreSound = this.prefix + "score.mp3";
    
    public GameNumberResource()
    {
      int i = 0;
      while (i < 10)
      {
        this.gameNums.add(this.prefix + "gamenum_" + i + ".png");
        i += 1;
      }
    }
  }
  
  public class GamingResource
  {
    public String good = this.prefix + "good.png";
    public String goodSound = this.prefix + "good.mp3";
    public String good_background = this.prefix + "good_background.png";
    public String good_mongolian = this.prefix + "good_mongolian.png";
    public String great = this.prefix + "great.png";
    public String greatSound = this.prefix + "great.mp3";
    public String great_background = this.prefix + "great_background.png";
    public String great_mongolian = this.prefix + "great_mongolian.png";
    public String miss = this.prefix + "miss.png";
    public String missSound = this.prefix + "miss.mp3";
    public String miss_background = this.prefix + "miss_background.png";
    public String miss_mongolian = this.prefix + "miss_mongolian.png";
    public String perfect = this.prefix + "perfect.png";
    public String perfectSound = this.prefix + "perfect.mp3";
    public String perfect_background = this.prefix + "perfect_background.png";
    public String perfect_mongolian = this.prefix + "perfect_mongolian.png";
    private String prefix = ResourceManager.this.postureRecognizePath + "gaming/";
    private String recogRect = "recogrect";
    public List<String> recogRects = new ArrayList();
    public String timeBackground = this.prefix + "timeBackGround.png";
    private String timeFront = "timeFront";
    public List<String> timeFronts = new ArrayList();
    public String volumSoundPic = this.prefix + "volume/sound.png";
    public String volumSoundPicSingle = this.prefix + "volume/sound_single.png";
    
    public GamingResource()
    {
      int i = 0;
      while (i < 4)
      {
        this.recogRects.add(this.prefix + this.recogRect + (i + 1) + ".png");
        i += 1;
      }
      this.timeFronts.add(this.prefix + this.timeFront + ".png");
      i = j;
      while (i < 3)
      {
        this.timeFronts.add(this.prefix + this.timeFront + (i + 1) + ".png");
        i += 1;
      }
    }
  }
  
  public class GeneralResource
  {
    public String bgPic = this.prefix_bgm + "bg.png";
    private String prefix_bgm = ResourceManager.this.postureRecognizePath;
    
    public GeneralResource() {}
  }
  
  public class LBGeneralResource
  {
    public String bgmV = this.prefix_bgm + "background-music-aac.mp3";
    private String prefix_bgm = ResourceManager.this.mLittleBoyFilterRoot;
    
    public LBGeneralResource() {}
  }
  
  public static class LyricItem
  {
    public static final int STATUS_INIT = 0;
    public static final int STATUS_INVALID = 2;
    public static final int STATUS_WORK = 1;
    public int endTime;
    public int startTime;
    public int status;
    public String text;
  }
  
  public static class Posture
  {
    public String blastPicture;
    public List<String> danceCartoon;
    public FaceDanceTemplateConfig faceDanceConfig;
    public List<MatchTemplateConfig> gestureConfigs;
    public String id;
  }
  
  public class ReadyResource
  {
    public String oneSound = this.prefix + "one.mp3";
    private String prefix = ResourceManager.this.postureRecognizePath + "ready/";
    public String ready = this.prefix + "ready.png";
    public List<String> readyNums = new ArrayList();
    public String readySound = this.prefix + "ready.mp3";
    public String threeSound = this.prefix + "three.mp3";
    public String twoSound = this.prefix + "two.mp3";
    
    public ReadyResource()
    {
      int i = 1;
      while (i <= 3)
      {
        this.readyNums.add(this.prefix + "ready" + i + ".png");
        i += 1;
      }
    }
  }
  
  public class ScanResource
  {
    public String bottomText = this.prefix_scan + "bottom_text.png";
    public String facebottomText = this.faceprefix_scan + "face_bottom_text.png";
    public String facemaskPic = this.faceprefix_scan + "facemask.png";
    private String faceprefix_scan = ResourceManager.this.postureRecognizePath + "faceScan/";
    public String facerecognizePic = this.faceprefix_scan + "facerecognize.png";
    public String facetopText = this.faceprefix_scan + "face_top_text.png";
    public String maskPic = this.prefix_scan + "mask.png";
    private String prefix_scan = ResourceManager.this.postureRecognizePath + "bodyScan/";
    public String recognizePic = this.prefix_scan + "recognize.png";
    public String scanBg = this.prefix_scan + "scan_bg.png";
    public String scanContent = this.prefix_scan + "scan_content.png";
    public String scanPic = this.prefix_scan + "scan.png";
    public String topText = this.prefix_scan + "top_text.png";
    
    public ScanResource() {}
  }
  
  public class ShareResource
  {
    public String button = this.prefix + "button.png";
    public String levelA = this.prefix + "levelA.png";
    public String levelB = this.prefix + "levelB.png";
    public String levelC = this.prefix + "levelC.png";
    public String levelS = this.prefix + "levelS.png";
    private String prefix = ResourceManager.this.postureRecognizePath + "share/";
    public String shareBg = this.prefix + "shareBg.png";
    public String shareScoreBg = this.prefix + "shareScoreBg.png";
    
    public ShareResource() {}
  }
  
  public class StartResource
  {
    private String prefix = ResourceManager.this.postureRecognizePath + "start/";
    public String startPic = this.prefix + "start.png";
    public String startSound = this.prefix + "start.mp3";
    
    public StartResource() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager
 * JD-Core Version:    0.7.0.1
 */