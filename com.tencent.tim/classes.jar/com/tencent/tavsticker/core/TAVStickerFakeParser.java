package com.tencent.tavsticker.core;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerImageEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.model.TAVStickerLayerType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class TAVStickerFakeParser
{
  private static final String DURATION_TIME = "duration";
  private static final String ID = "id";
  private static final String IMAGE_EFFECTS = "imageEffects";
  private static final String JSON_FILE_NAME = "template.json";
  private static final String LAYER = "layer";
  private static final String LOOP = "loop";
  private static final String NAME = "name";
  private static final String SPEED = "speed";
  private static final String START_TIME = "start";
  private static final String TIME_EFFECTS = "timeEffects";
  private static final String USER_DATA = "userData";
  private static final String USER_DATA_TAG = "#userData";
  
  /* Error */
  public static List<TAVStickerLayerInfo> fakeDataFromJson()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 57	com/tencent/tavsticker/TAVStickerHelper:getContext	()Landroid/content/Context;
    //   5: invokevirtual 63	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: ldc 18
    //   10: invokevirtual 69	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_1
    //   16: aload_0
    //   17: invokevirtual 75	java/io/InputStream:available	()I
    //   20: newarray byte
    //   22: astore_2
    //   23: aload_0
    //   24: astore_1
    //   25: aload_0
    //   26: aload_2
    //   27: invokevirtual 79	java/io/InputStream:read	([B)I
    //   30: pop
    //   31: aload_0
    //   32: astore_1
    //   33: new 81	java/lang/String
    //   36: dup
    //   37: aload_2
    //   38: ldc 83
    //   40: invokespecial 86	java/lang/String:<init>	([BLjava/lang/String;)V
    //   43: invokestatic 90	com/tencent/tavsticker/core/TAVStickerFakeParser:parse	(Ljava/lang/String;)Ljava/util/List;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokevirtual 93	java/io/InputStream:close	()V
    //   59: aload_1
    //   60: astore_2
    //   61: aload_2
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   68: aload_1
    //   69: areturn
    //   70: astore_2
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   79: aload_3
    //   80: astore_2
    //   81: aload_0
    //   82: ifnull -21 -> 61
    //   85: aload_0
    //   86: invokevirtual 93	java/io/InputStream:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 93	java/io/InputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   116: goto -7 -> 109
    //   119: astore_0
    //   120: goto -19 -> 101
    //   123: astore_2
    //   124: goto -51 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	43	0	localInputStream	java.io.InputStream
    //   63	2	0	localException1	java.lang.Exception
    //   72	14	0	localObject1	Object
    //   91	2	0	localException2	java.lang.Exception
    //   98	12	0	localObject2	Object
    //   119	1	0	localObject3	Object
    //   15	91	1	localObject4	Object
    //   111	2	1	localException3	java.lang.Exception
    //   22	40	2	localObject5	Object
    //   70	6	2	localException4	java.lang.Exception
    //   80	1	2	localObject6	Object
    //   123	1	2	localException5	java.lang.Exception
    //   1	79	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   55	59	63	java/lang/Exception
    //   2	14	70	java/lang/Exception
    //   85	89	91	java/lang/Exception
    //   2	14	98	finally
    //   105	109	111	java/lang/Exception
    //   16	23	119	finally
    //   25	31	119	finally
    //   33	47	119	finally
    //   75	79	119	finally
    //   16	23	123	java/lang/Exception
    //   25	31	123	java/lang/Exception
    //   33	47	123	java/lang/Exception
  }
  
  private static List<TAVStickerLayerInfo> parse(String paramString)
    throws JSONException
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramString.optJSONObject(i).optJSONObject("layer");
        Object localObject4 = ((JSONObject)localObject1).opt("timeEffects");
        Object localObject2 = ((JSONObject)localObject1).opt("imageEffects");
        Object localObject3 = ((JSONObject)localObject1).opt("userData");
        localObject1 = CMTimeRange.CMTimeRangeInvalid;
        localObject4 = parseTimeEffects(localObject4);
        localObject2 = parseImageEffects(localObject2);
        localObject3 = parseUserDataList(localObject3);
        localArrayList.add(new TAVStickerLayerInfo(0, TAVStickerLayerType.Image, (CMTimeRange)localObject1, (List)localObject4, (List)localObject2, (List)localObject3));
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerImageEffect> parseImageEffects(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    float f1;
    float f2;
    if ((paramObject instanceof JSONObject))
    {
      localObject1 = (JSONObject)paramObject;
      f1 = (float)((JSONObject)localObject1).optDouble("start", 0.0D);
      f2 = (float)((JSONObject)localObject1).optDouble("duration", 0.0D);
      paramObject = ((JSONObject)localObject1).optString("id", "");
      localObject1 = ((JSONObject)localObject1).optString("name", "");
      localArrayList.add(new TAVStickerLayerInfo.TAVStickerImageEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), paramObject, (String)localObject1));
    }
    for (;;)
    {
      return localArrayList;
      if ((paramObject instanceof JSONArray))
      {
        paramObject = (JSONArray)paramObject;
        int j = paramObject.length();
        int i = 0;
        while (i < j)
        {
          Object localObject2 = paramObject.optJSONObject(i);
          f1 = (float)((JSONObject)localObject2).optDouble("start", 0.0D);
          f2 = (float)((JSONObject)localObject2).optDouble("duration", 0.0D);
          localObject1 = ((JSONObject)localObject2).optString("id", "");
          localObject2 = ((JSONObject)localObject2).optString("name", "");
          localArrayList.add(new TAVStickerLayerInfo.TAVStickerImageEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), (String)localObject1, (String)localObject2));
          i += 1;
        }
      }
    }
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerTimeEffect> parseTimeEffects(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    float f1;
    float f2;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      f1 = (float)paramObject.optDouble("start", 0.0D);
      f2 = (float)paramObject.optDouble("duration", 0.0D);
      localArrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), CMTimeRange.CMTimeRangeInvalid, false));
    }
    for (;;)
    {
      return localArrayList;
      if ((paramObject instanceof JSONArray))
      {
        paramObject = (JSONArray)paramObject;
        int j = paramObject.length();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = paramObject.optJSONObject(i);
          f1 = (float)localJSONObject.optDouble("start", 0.0D);
          f2 = (float)localJSONObject.optDouble("duration", 0.0D);
          localArrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), CMTimeRange.CMTimeRangeInvalid, false));
          i += 1;
        }
      }
    }
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerUserData> parseUserDataList(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(CMTimeRange.CMTimeRangeInvalid, "#userData\r" + paramObject.toString()));
    }
    for (;;)
    {
      return localArrayList;
      if ((paramObject instanceof JSONArray))
      {
        paramObject = (JSONArray)paramObject;
        int j = paramObject.length();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = paramObject.optJSONObject(i);
          localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(CMTimeRange.CMTimeRangeInvalid, "#userData\r" + localJSONObject.toString()));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerFakeParser
 * JD-Core Version:    0.7.0.1
 */