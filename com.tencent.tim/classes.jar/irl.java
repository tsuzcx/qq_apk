import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.ExpressionItem;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.List;

public class irl
{
  public static final double[] WEIGHT = { 0.2D, 0.2D, 0.3D, 0.06D, 0.06D, 0.06D, 0.12D };
  
  public static irl.b a(irl.a parama, List<PointF> paramList, float[] paramArrayOfFloat)
  {
    irl.b localb = new irl.b();
    Object localObject = parama.expressionFeat;
    float[] arrayOfFloat = parama.expressionAngle;
    double[] arrayOfDouble = parama.expressionWeight;
    int[] arrayOfInt = parama.cB;
    if ((localObject == null) || (paramList == null) || (arrayOfFloat == null) || (arrayOfFloat.length < 3) || (arrayOfDouble == null) || (arrayOfDouble.length < 7)) {
      return localb;
    }
    localObject = FaceOffUtil.getFullCoords(FaceDetectUtil.facePointf83to90((List)localObject), 2.0F);
    parama = paramList;
    if (paramList.size() == 83) {
      parama = FaceDetectUtil.facePointf83to90(paramList);
    }
    List localList = FaceOffUtil.getFullCoords(parama, 2.0F);
    if ((localList.size() < 106) || (((List)localObject).size() < 106)) {
      return localb;
    }
    parama = new ArrayList(((List)localObject).size());
    paramList = new ArrayList(localList.size());
    float f1 = AlgoUtils.getDistance((PointF)((List)localObject).get(99), (PointF)((List)localObject).get(105));
    float f2 = AlgoUtils.getDistance((PointF)((List)localObject).get(99), (PointF)((List)localObject).get(101));
    float f3 = AlgoUtils.getDistance((PointF)localList.get(99), (PointF)localList.get(105));
    float f4 = AlgoUtils.getDistance((PointF)localList.get(99), (PointF)localList.get(101));
    int i = 0;
    while (i < ((List)localObject).size())
    {
      parama.add(new PointF(((PointF)((List)localObject).get(i)).x / f1, ((PointF)((List)localObject).get(i)).y / f2));
      paramList.add(new PointF(((PointF)localList.get(i)).x / f3, ((PointF)localList.get(i)).y / f4));
      i += 1;
    }
    localObject = new float[7];
    float f9 = distanceOfPoint((PointF)parama.get(37), (PointF)parama.get(41)) / distanceOfPoint((PointF)parama.get(35), (PointF)parama.get(39));
    float f6 = distanceOfPoint((PointF)paramList.get(37), (PointF)paramList.get(41)) / distanceOfPoint((PointF)paramList.get(35), (PointF)paramList.get(39));
    if ((f6 > f9) && (arrayOfInt[0] == 1)) {}
    for (f1 = (f6 - f9) / 4 + f9;; f1 = f6)
    {
      localObject[0] = getSimilarityOfValue(f9, f1, 0.18F, 0.5F);
      float f10 = distanceOfPoint((PointF)parama.get(47), (PointF)parama.get(51)) / distanceOfPoint((PointF)parama.get(45), (PointF)parama.get(49));
      float f7 = distanceOfPoint((PointF)paramList.get(47), (PointF)paramList.get(51)) / distanceOfPoint((PointF)paramList.get(45), (PointF)paramList.get(49));
      if ((f7 > f10) && (arrayOfInt[1] == 1)) {}
      for (f2 = (f7 - f10) / 4 + f10;; f2 = f7)
      {
        localObject[1] = getSimilarityOfValue(f10, f2, 0.18F, 0.5F);
        float f11 = distanceOfPoint((PointF)parama.get(73), (PointF)parama.get(81)) / distanceOfPoint((PointF)parama.get(65), (PointF)parama.get(66));
        float f8 = distanceOfPoint((PointF)paramList.get(73), (PointF)paramList.get(81)) / distanceOfPoint((PointF)paramList.get(65), (PointF)paramList.get(66));
        if ((f8 > f11) && (arrayOfInt[2] == 1)) {}
        for (f3 = (f8 - f11) / 4 + f11;; f3 = f8)
        {
          localObject[2] = getSimilarityOfValue(f11, f3, 0.05F, 0.6F);
          localObject[3] = getSimilarityOfValue(arrayOfFloat[0], paramArrayOfFloat[0], -15.0F, 15.0F);
          f4 = arrayOfFloat[0];
          f4 = paramArrayOfFloat[0];
          localObject[4] = getSimilarityOfValue(arrayOfFloat[1], paramArrayOfFloat[1], -20.0F, 20.0F);
          localObject[5] = getSimilarityOfValue(arrayOfFloat[2], paramArrayOfFloat[2], -15.0F, 15.0F);
          f4 = (((PointF)parama.get(44)).x - ((PointF)parama.get(35)).x) / (((PointF)parama.get(39)).x - ((PointF)parama.get(35)).x);
          float f5 = (((PointF)parama.get(54)).x - ((PointF)parama.get(45)).x) / (((PointF)parama.get(49)).x - ((PointF)parama.get(45)).x);
          float f12 = (((PointF)paramList.get(44)).x - ((PointF)paramList.get(35)).x) / (((PointF)paramList.get(39)).x - ((PointF)paramList.get(35)).x);
          float f13 = (((PointF)paramList.get(54)).x - ((PointF)paramList.get(45)).x) / (((PointF)paramList.get(49)).x - ((PointF)paramList.get(45)).x);
          localObject[6] = getSimilarityOfValue((f4 + f5) / 2.0F, (f13 + f12) / 2.0F, 0.25F, 0.75F);
          f5 = 0.0F;
          f4 = 0.0F;
          parama = new StringBuilder("Score:");
          paramList = new StringBuilder("Weight:");
          i = 0;
          while (i < 7)
          {
            f5 = (float)(f5 + arrayOfDouble[i] * localObject[i]);
            f4 = (float)(f4 + arrayOfDouble[i]);
            parama.append("[").append(localObject[i]).append("]");
            paramList.append("[").append(arrayOfDouble[i]).append("]");
            i += 1;
          }
          f4 = f5 / f4;
          if (QLog.isColorLevel()) {
            QLog.d("AVActUtil", 2, "raymond__ getExpressionSimilarity2 ,totalScore = " + 100.0F * f4 + "," + parama.toString() + paramList.toString());
          }
          if (QLog.isColorLevel())
          {
            QLog.d("AVActUtil", 2, "raymond getExpressionSimilarity2 ,distSrc_leftEye = " + f9 + ",distSrc_rightEye = " + f10 + ",distSrc_Mouth = " + f11 + ",totalParam = " + f4);
            QLog.d("AVActUtil", 2, "raymond getExpressionSimilarity2 ,distUser_leftEye = " + f6 + ",distUser_rightEye = " + f7 + ",distUser_Mouth = " + f8);
            QLog.d("AVActUtil", 2, "raymond getExpressionSimilarity2 ,distUser_leftEyeRefine = " + f1 + ",distUser_rightEyeRefine = " + f2 + ",distUser_MouthRefine = " + f3);
          }
          localb.score = (f4 * 100.0F);
          localb.hu = f9;
          localb.hv = f10;
          localb.hw = f6;
          localb.hx = f7;
          return localb;
        }
      }
    }
  }
  
  public static boolean a(float paramFloat, double[] paramArrayOfDouble, int[] paramArrayOfInt, irl.a parama, List<PointF> paramList, float[] paramArrayOfFloat)
  {
    boolean bool = false;
    parama.expressionWeight = paramArrayOfDouble;
    parama.cB = paramArrayOfInt;
    float f = a(parama, paramList, paramArrayOfFloat).score;
    if (f > paramFloat) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVActUtil", 2, "raymond checkMoreLikeNormalFaceExpression ,normalFaceExpressionScore = " + f + ",targetScore = " + paramFloat + ",result = " + bool);
    }
    return bool;
  }
  
  public static boolean a(irl.b paramb)
  {
    boolean bool = false;
    if ((paramb.hu < paramb.hv) && (paramb.hv - paramb.hu > 0.05D)) {
      if (paramb.hw <= paramb.hx) {
        break label117;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVActUtil", 2, "raymond checkEyeOpenCloseValid ,result = " + bool);
      }
      return bool;
      if ((paramb.hu <= paramb.hv) || (paramb.hu - paramb.hv <= 0.05D) || (paramb.hw >= paramb.hx)) {
        label117:
        bool = true;
      }
    }
  }
  
  public static float[] a(float[] paramArrayOfFloat)
  {
    return new float[] { (float)(paramArrayOfFloat[1] * 180.0F / 3.141592653589793D), (float)(paramArrayOfFloat[2] * 180.0F / 3.141592653589793D), (float)(paramArrayOfFloat[0] * 180.0F / 3.141592653589793D) };
  }
  
  /* Error */
  public static List<irl.a> c(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: invokestatic 228	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: new 112	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 230
    //   27: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 232
    //   36: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_0
    //   43: new 234	java/io/File
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 238	java/io/File:exists	()Z
    //   56: ifeq +381 -> 437
    //   59: aload_1
    //   60: invokevirtual 241	java/io/File:isFile	()Z
    //   63: ifeq +374 -> 437
    //   66: aload_1
    //   67: invokevirtual 238	java/io/File:exists	()Z
    //   70: ifeq +954 -> 1024
    //   73: aload_1
    //   74: invokevirtual 241	java/io/File:isFile	()Z
    //   77: ifeq +947 -> 1024
    //   80: new 243	java/io/FileInputStream
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: astore_0
    //   89: aload_0
    //   90: astore 4
    //   92: aload_0
    //   93: astore_1
    //   94: aload 4
    //   96: astore_0
    //   97: aload_1
    //   98: ifnull +914 -> 1012
    //   101: new 248	java/io/InputStreamReader
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 251	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   109: astore 5
    //   111: new 253	java/io/BufferedReader
    //   114: dup
    //   115: aload 5
    //   117: sipush 1024
    //   120: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   123: astore 6
    //   125: aload_0
    //   126: astore 9
    //   128: aload 5
    //   130: astore 8
    //   132: aload 6
    //   134: astore 10
    //   136: aload_1
    //   137: astore 7
    //   139: new 258	java/lang/StringBuffer
    //   142: dup
    //   143: invokespecial 259	java/lang/StringBuffer:<init>	()V
    //   146: astore 4
    //   148: aload_0
    //   149: astore 9
    //   151: aload 5
    //   153: astore 8
    //   155: aload 6
    //   157: astore 10
    //   159: aload_1
    //   160: astore 7
    //   162: aload 6
    //   164: invokevirtual 262	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   167: astore 13
    //   169: aload 13
    //   171: ifnull +290 -> 461
    //   174: aload_0
    //   175: astore 9
    //   177: aload 5
    //   179: astore 8
    //   181: aload 6
    //   183: astore 10
    //   185: aload_1
    //   186: astore 7
    //   188: aload 4
    //   190: aload 13
    //   192: invokevirtual 265	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   195: pop
    //   196: goto -48 -> 148
    //   199: astore 7
    //   201: aload 6
    //   203: astore 4
    //   205: aload 7
    //   207: astore 6
    //   209: aload_0
    //   210: astore 9
    //   212: aload 5
    //   214: astore 8
    //   216: aload 4
    //   218: astore 10
    //   220: aload_1
    //   221: astore 7
    //   223: ldc 141
    //   225: aload 6
    //   227: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: aload 6
    //   232: invokestatic 274	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   235: pop
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 277	java/io/BufferedReader:close	()V
    //   246: aload 5
    //   248: ifnull +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 278	java/io/InputStreamReader:close	()V
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 281	java/io/InputStream:close	()V
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 282	java/io/FileInputStream:close	()V
    //   272: aconst_null
    //   273: astore_1
    //   274: aload 12
    //   276: astore_0
    //   277: aload_1
    //   278: ifnull +642 -> 920
    //   281: aload_1
    //   282: getstatic 288	com/tencent/ttpic/openapi/util/VideoMaterialUtil$FACE_EXPRESSION_ITEM_FILED:EXPRESSION_LIST	Lcom/tencent/ttpic/openapi/util/VideoMaterialUtil$FACE_EXPRESSION_ITEM_FILED;
    //   285: getfield 292	com/tencent/ttpic/openapi/util/VideoMaterialUtil$FACE_EXPRESSION_ITEM_FILED:value	Ljava/lang/String;
    //   288: invokevirtual 298	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   291: astore_1
    //   292: aload 12
    //   294: astore_0
    //   295: aload_1
    //   296: ifnull +624 -> 920
    //   299: new 64	java/util/ArrayList
    //   302: dup
    //   303: invokespecial 299	java/util/ArrayList:<init>	()V
    //   306: astore_0
    //   307: iconst_0
    //   308: istore_2
    //   309: iload_2
    //   310: aload_1
    //   311: invokevirtual 304	org/json/JSONArray:length	()I
    //   314: if_icmpge +690 -> 1004
    //   317: new 6	irl$a
    //   320: dup
    //   321: invokespecial 305	irl$a:<init>	()V
    //   324: astore 4
    //   326: aload_1
    //   327: iload_2
    //   328: invokevirtual 309	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   331: astore 5
    //   333: aload 4
    //   335: aload 5
    //   337: getstatic 315	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:EXPRESSION_ID	Lcom/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED;
    //   340: getfield 316	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:value	Ljava/lang/String;
    //   343: invokevirtual 319	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: putfield 322	irl$a:expressionID	Ljava/lang/String;
    //   349: aload 5
    //   351: getstatic 325	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:EXPRESSION_FEAT	Lcom/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED;
    //   354: getfield 316	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:value	Ljava/lang/String;
    //   357: invokevirtual 298	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   360: astore 6
    //   362: aload 6
    //   364: ifnull +281 -> 645
    //   367: aload 4
    //   369: new 64	java/util/ArrayList
    //   372: dup
    //   373: invokespecial 299	java/util/ArrayList:<init>	()V
    //   376: putfield 33	irl$a:expressionFeat	Ljava/util/List;
    //   379: iconst_0
    //   380: istore_3
    //   381: iload_3
    //   382: aload 6
    //   384: invokevirtual 304	org/json/JSONArray:length	()I
    //   387: iconst_2
    //   388: idiv
    //   389: if_icmpge +256 -> 645
    //   392: aload 4
    //   394: getfield 33	irl$a:expressionFeat	Ljava/util/List;
    //   397: new 73	android/graphics/PointF
    //   400: dup
    //   401: aload 6
    //   403: iload_3
    //   404: iconst_2
    //   405: imul
    //   406: invokevirtual 329	org/json/JSONArray:optInt	(I)I
    //   409: i2f
    //   410: aload 6
    //   412: iload_3
    //   413: iconst_2
    //   414: imul
    //   415: iconst_1
    //   416: iadd
    //   417: invokevirtual 329	org/json/JSONArray:optInt	(I)I
    //   420: i2f
    //   421: invokespecial 89	android/graphics/PointF:<init>	(FF)V
    //   424: invokeinterface 93 2 0
    //   429: pop
    //   430: iload_3
    //   431: iconst_1
    //   432: iadd
    //   433: istore_3
    //   434: goto -53 -> 381
    //   437: invokestatic 335	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   440: invokevirtual 341	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   443: aload_0
    //   444: invokevirtual 347	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   447: astore_1
    //   448: aconst_null
    //   449: astore_0
    //   450: goto -353 -> 97
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_0
    //   456: aconst_null
    //   457: astore_1
    //   458: goto -361 -> 97
    //   461: aload_0
    //   462: astore 9
    //   464: aload 5
    //   466: astore 8
    //   468: aload 6
    //   470: astore 10
    //   472: aload_1
    //   473: astore 7
    //   475: aload 4
    //   477: invokevirtual 348	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   480: astore 4
    //   482: aload_0
    //   483: astore 9
    //   485: aload 5
    //   487: astore 8
    //   489: aload 6
    //   491: astore 10
    //   493: aload_1
    //   494: astore 7
    //   496: aload 4
    //   498: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   501: ifne +505 -> 1006
    //   504: aload_0
    //   505: astore 9
    //   507: aload 5
    //   509: astore 8
    //   511: aload 6
    //   513: astore 10
    //   515: aload_1
    //   516: astore 7
    //   518: new 356	org/json/JSONTokener
    //   521: dup
    //   522: aload 4
    //   524: invokespecial 357	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   527: invokevirtual 361	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   530: checkcast 294	org/json/JSONObject
    //   533: astore 4
    //   535: aload 6
    //   537: ifnull +8 -> 545
    //   540: aload 6
    //   542: invokevirtual 277	java/io/BufferedReader:close	()V
    //   545: aload 5
    //   547: ifnull +8 -> 555
    //   550: aload 5
    //   552: invokevirtual 278	java/io/InputStreamReader:close	()V
    //   555: aload_1
    //   556: ifnull +7 -> 563
    //   559: aload_1
    //   560: invokevirtual 281	java/io/InputStream:close	()V
    //   563: aload 4
    //   565: astore_1
    //   566: aload_0
    //   567: ifnull -293 -> 274
    //   570: aload_0
    //   571: invokevirtual 282	java/io/FileInputStream:close	()V
    //   574: aload 4
    //   576: astore_1
    //   577: goto -303 -> 274
    //   580: astore_0
    //   581: aload 4
    //   583: astore_1
    //   584: goto -310 -> 274
    //   587: astore_0
    //   588: aconst_null
    //   589: astore_1
    //   590: goto -316 -> 274
    //   593: astore 4
    //   595: aconst_null
    //   596: astore_0
    //   597: aconst_null
    //   598: astore 5
    //   600: aconst_null
    //   601: astore_1
    //   602: aload 7
    //   604: astore 6
    //   606: aload 6
    //   608: ifnull +8 -> 616
    //   611: aload 6
    //   613: invokevirtual 277	java/io/BufferedReader:close	()V
    //   616: aload 5
    //   618: ifnull +8 -> 626
    //   621: aload 5
    //   623: invokevirtual 278	java/io/InputStreamReader:close	()V
    //   626: aload_1
    //   627: ifnull +7 -> 634
    //   630: aload_1
    //   631: invokevirtual 281	java/io/InputStream:close	()V
    //   634: aload_0
    //   635: ifnull +7 -> 642
    //   638: aload_0
    //   639: invokevirtual 282	java/io/FileInputStream:close	()V
    //   642: aload 4
    //   644: athrow
    //   645: aload 5
    //   647: getstatic 364	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:EXPRESSION_ANGLE	Lcom/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED;
    //   650: getfield 316	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:value	Ljava/lang/String;
    //   653: invokevirtual 298	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   656: astore 6
    //   658: aload 6
    //   660: ifnull +53 -> 713
    //   663: aload 6
    //   665: invokevirtual 304	org/json/JSONArray:length	()I
    //   668: iconst_3
    //   669: if_icmpne +44 -> 713
    //   672: aload 4
    //   674: iconst_3
    //   675: newarray float
    //   677: dup
    //   678: iconst_0
    //   679: aload 6
    //   681: iconst_0
    //   682: invokevirtual 368	org/json/JSONArray:optDouble	(I)D
    //   685: d2f
    //   686: fastore
    //   687: dup
    //   688: iconst_1
    //   689: aload 6
    //   691: iconst_1
    //   692: invokevirtual 368	org/json/JSONArray:optDouble	(I)D
    //   695: d2f
    //   696: fastore
    //   697: dup
    //   698: iconst_2
    //   699: aload 6
    //   701: iconst_2
    //   702: invokevirtual 368	org/json/JSONArray:optDouble	(I)D
    //   705: d2f
    //   706: fastore
    //   707: invokestatic 371	irl:convertJsonAngle2NormalAngle	([F)[F
    //   710: putfield 37	irl$a:expressionAngle	[F
    //   713: aload 5
    //   715: getstatic 374	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:EXPRESSION_WEIGHT	Lcom/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED;
    //   718: getfield 316	com/tencent/ttpic/openapi/util/VideoMaterialUtil$EXPRESSION_ITEM_FILED:value	Ljava/lang/String;
    //   721: invokevirtual 298	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   724: astore 6
    //   726: aload 6
    //   728: ifnull +50 -> 778
    //   731: aload 6
    //   733: invokevirtual 304	org/json/JSONArray:length	()I
    //   736: bipush 7
    //   738: if_icmpne +40 -> 778
    //   741: aload 4
    //   743: bipush 7
    //   745: newarray double
    //   747: putfield 40	irl$a:expressionWeight	[D
    //   750: iconst_0
    //   751: istore_3
    //   752: iload_3
    //   753: bipush 7
    //   755: if_icmpge +31 -> 786
    //   758: aload 4
    //   760: getfield 40	irl$a:expressionWeight	[D
    //   763: iload_3
    //   764: aload 6
    //   766: iload_3
    //   767: invokevirtual 368	org/json/JSONArray:optDouble	(I)D
    //   770: dastore
    //   771: iload_3
    //   772: iconst_1
    //   773: iadd
    //   774: istore_3
    //   775: goto -23 -> 752
    //   778: aload 4
    //   780: getstatic 24	irl:WEIGHT	[D
    //   783: putfield 40	irl$a:expressionWeight	[D
    //   786: aload 5
    //   788: ldc_w 376
    //   791: invokevirtual 298	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   794: astore 6
    //   796: aload 6
    //   798: ifnull +59 -> 857
    //   801: aload 6
    //   803: invokevirtual 304	org/json/JSONArray:length	()I
    //   806: iconst_3
    //   807: if_icmpne +50 -> 857
    //   810: aload 4
    //   812: iconst_3
    //   813: newarray int
    //   815: putfield 44	irl$a:cB	[I
    //   818: aload 4
    //   820: getfield 44	irl$a:cB	[I
    //   823: iconst_0
    //   824: aload 6
    //   826: iconst_0
    //   827: invokevirtual 329	org/json/JSONArray:optInt	(I)I
    //   830: iastore
    //   831: aload 4
    //   833: getfield 44	irl$a:cB	[I
    //   836: iconst_1
    //   837: aload 6
    //   839: iconst_1
    //   840: invokevirtual 329	org/json/JSONArray:optInt	(I)I
    //   843: iastore
    //   844: aload 4
    //   846: getfield 44	irl$a:cB	[I
    //   849: iconst_2
    //   850: aload 6
    //   852: iconst_2
    //   853: invokevirtual 329	org/json/JSONArray:optInt	(I)I
    //   856: iastore
    //   857: aload 5
    //   859: ldc_w 378
    //   862: invokevirtual 319	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   865: astore 5
    //   867: aload 5
    //   869: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   872: ifne +23 -> 895
    //   875: aload 5
    //   877: ldc_w 379
    //   880: invokevirtual 384	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   883: ifeq +12 -> 895
    //   886: aload_0
    //   887: aload 4
    //   889: invokeinterface 93 2 0
    //   894: pop
    //   895: iload_2
    //   896: iconst_1
    //   897: iadd
    //   898: istore_2
    //   899: goto -590 -> 309
    //   902: astore_1
    //   903: aload 11
    //   905: astore_0
    //   906: aload_1
    //   907: invokevirtual 387	org/json/JSONException:printStackTrace	()V
    //   910: ldc 141
    //   912: ldc_w 389
    //   915: aload_1
    //   916: invokestatic 391	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   919: pop
    //   920: aload_0
    //   921: areturn
    //   922: astore_1
    //   923: goto -17 -> 906
    //   926: astore_0
    //   927: goto -285 -> 642
    //   930: astore 4
    //   932: aconst_null
    //   933: astore 5
    //   935: aload 7
    //   937: astore 6
    //   939: goto -333 -> 606
    //   942: astore 4
    //   944: aload 7
    //   946: astore 6
    //   948: goto -342 -> 606
    //   951: astore 4
    //   953: aload 10
    //   955: astore 6
    //   957: aload 9
    //   959: astore_0
    //   960: aload 8
    //   962: astore 5
    //   964: aload 7
    //   966: astore_1
    //   967: goto -361 -> 606
    //   970: astore 6
    //   972: aconst_null
    //   973: astore_0
    //   974: aconst_null
    //   975: astore 5
    //   977: aconst_null
    //   978: astore 4
    //   980: aconst_null
    //   981: astore_1
    //   982: goto -773 -> 209
    //   985: astore 6
    //   987: aconst_null
    //   988: astore 5
    //   990: aconst_null
    //   991: astore 4
    //   993: goto -784 -> 209
    //   996: astore 6
    //   998: aconst_null
    //   999: astore 4
    //   1001: goto -792 -> 209
    //   1004: aload_0
    //   1005: areturn
    //   1006: aconst_null
    //   1007: astore 4
    //   1009: goto -474 -> 535
    //   1012: aconst_null
    //   1013: astore 5
    //   1015: aconst_null
    //   1016: astore 6
    //   1018: aconst_null
    //   1019: astore 4
    //   1021: goto -486 -> 535
    //   1024: aconst_null
    //   1025: astore_0
    //   1026: goto -937 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1029	0	paramString1	java.lang.String
    //   0	1029	1	paramString2	java.lang.String
    //   308	591	2	i	int
    //   380	395	3	j	int
    //   90	492	4	localObject1	Object
    //   593	295	4	localObject2	Object
    //   930	1	4	localObject3	Object
    //   942	1	4	localObject4	Object
    //   951	1	4	localObject5	Object
    //   978	42	4	localObject6	Object
    //   109	905	5	localObject7	Object
    //   123	833	6	localObject8	Object
    //   970	1	6	localException1	java.lang.Exception
    //   985	1	6	localException2	java.lang.Exception
    //   996	1	6	localException3	java.lang.Exception
    //   1016	1	6	localObject9	Object
    //   7	180	7	str1	java.lang.String
    //   199	7	7	localException4	java.lang.Exception
    //   221	744	7	str2	java.lang.String
    //   130	831	8	localObject10	Object
    //   126	832	9	str3	java.lang.String
    //   134	820	10	localObject11	Object
    //   1	903	11	localObject12	Object
    //   4	289	12	localObject13	Object
    //   167	24	13	str4	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   139	148	199	java/lang/Exception
    //   162	169	199	java/lang/Exception
    //   188	196	199	java/lang/Exception
    //   475	482	199	java/lang/Exception
    //   496	504	199	java/lang/Exception
    //   518	535	199	java/lang/Exception
    //   437	448	453	java/io/IOException
    //   540	545	580	java/io/IOException
    //   550	555	580	java/io/IOException
    //   559	563	580	java/io/IOException
    //   570	574	580	java/io/IOException
    //   241	246	587	java/io/IOException
    //   251	256	587	java/io/IOException
    //   260	264	587	java/io/IOException
    //   268	272	587	java/io/IOException
    //   43	89	593	finally
    //   437	448	593	finally
    //   281	292	902	org/json/JSONException
    //   299	307	902	org/json/JSONException
    //   309	362	922	org/json/JSONException
    //   367	379	922	org/json/JSONException
    //   381	430	922	org/json/JSONException
    //   645	658	922	org/json/JSONException
    //   663	713	922	org/json/JSONException
    //   713	726	922	org/json/JSONException
    //   731	750	922	org/json/JSONException
    //   758	771	922	org/json/JSONException
    //   778	786	922	org/json/JSONException
    //   786	796	922	org/json/JSONException
    //   801	857	922	org/json/JSONException
    //   857	895	922	org/json/JSONException
    //   611	616	926	java/io/IOException
    //   621	626	926	java/io/IOException
    //   630	634	926	java/io/IOException
    //   638	642	926	java/io/IOException
    //   101	111	930	finally
    //   111	125	942	finally
    //   139	148	951	finally
    //   162	169	951	finally
    //   188	196	951	finally
    //   223	236	951	finally
    //   475	482	951	finally
    //   496	504	951	finally
    //   518	535	951	finally
    //   43	89	970	java/lang/Exception
    //   437	448	970	java/lang/Exception
    //   101	111	985	java/lang/Exception
    //   111	125	996	java/lang/Exception
  }
  
  public static float[] convertJsonAngle2NormalAngle(float[] paramArrayOfFloat)
  {
    return new float[] { paramArrayOfFloat[0], paramArrayOfFloat[2], paramArrayOfFloat[1] };
  }
  
  private static float distanceOfPoint(PointF paramPointF1, PointF paramPointF2)
  {
    return (float)Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  private static float getSimilarityOfValue(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 < paramFloat3) {
      paramFloat1 = paramFloat3;
    }
    for (;;)
    {
      if (paramFloat1 > paramFloat4) {}
      for (float f = paramFloat4;; f = paramFloat1)
      {
        if (paramFloat2 < paramFloat3) {}
        for (paramFloat1 = paramFloat3;; paramFloat1 = paramFloat2)
        {
          paramFloat2 = paramFloat1;
          if (paramFloat1 > paramFloat4) {
            paramFloat2 = paramFloat4;
          }
          paramFloat2 = Math.abs(f - paramFloat2) * 2.0F / (paramFloat4 - paramFloat3);
          paramFloat1 = paramFloat2;
          if (paramFloat2 > 1.0D) {
            paramFloat1 = 1.0F;
          }
          return 1.0F - smoothStep(paramFloat1);
        }
      }
    }
  }
  
  private static float smoothStep(float paramFloat)
  {
    return paramFloat * paramFloat * paramFloat * paramFloat * (35.0F - 84.0F * paramFloat + 70.0F * paramFloat * paramFloat - 20.0F * paramFloat * paramFloat * paramFloat);
  }
  
  public static class a
    extends ExpressionItem
  {
    public int[] cB;
  }
  
  public static class b
  {
    public float hu;
    public float hv;
    public float hw;
    public float hx;
    public float score;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irl
 * JD-Core Version:    0.7.0.1
 */