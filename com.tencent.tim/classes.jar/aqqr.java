import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqqr
{
  public static aqqs a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = acbn.bmQ + paramInt + File.separator + "config.json";
    paramQQAppInterface = VasQuickUpdateManager.getFileFromLocal(paramQQAppInterface, 1000L, "signature.item." + paramInt + ".json", (String)localObject, true, null);
    try
    {
      paramQQAppInterface = aqhq.b(paramQQAppInterface, -1);
      if (paramQQAppInterface == null)
      {
        QLog.e("SignatureTemplateConfig", 1, "read config fail result = null");
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      QLog.e("SignatureTemplateConfig", 1, "read config fail", paramQQAppInterface);
      return null;
    }
    localObject = new aqqs(Integer.toString(paramInt));
    a(paramQQAppInterface, (aqqs)localObject);
    return localObject;
  }
  
  public static void a(String paramString, aqqs paramaqqs)
  {
    Object localObject;
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() != 1)) {
        break label882;
      }
      localObject = ((JSONArray)localObject).getJSONObject(0);
      if (((JSONObject)localObject).optInt("platId") == 1)
      {
        paramaqqs.efa();
        return;
      }
      paramaqqs.cvY = ((JSONObject)localObject).optString("qqVer", "0.0.0");
      if (AppSetting.bs(paramaqqs.cvY) < 0)
      {
        paramaqqs.efa();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SignatureTemplateConfig", 1, "getSignatureTemplateInfoFromFile error: " + paramString.getMessage());
      return;
    }
    paramaqqs.name = ((JSONObject)localObject).optString("name", acfp.m(2131714561));
    paramaqqs.type = ((JSONObject)localObject).optInt("type", -1);
    paramaqqs.feeType = ((JSONObject)localObject).optInt("feeType", 1);
    paramaqqs.actUrl = ((JSONObject)localObject).optString("actUrl", null);
    paramaqqs.ecb = ((JSONObject)localObject).optInt("newOrHot", 0);
    paramaqqs.platId = ((JSONObject)localObject).optInt("platId");
    paramaqqs.fontColor = ((JSONObject)localObject).optString("fontColor", "");
    paramaqqs.signType = ((JSONObject)localObject).optInt("signType", 0);
    for (;;)
    {
      int j;
      int i;
      try
      {
        Color.parseColor(paramaqqs.fontColor);
        paramaqqs.cwe = ((JSONObject)localObject).optString("defText", "");
        paramaqqs.cwf = ((JSONObject)localObject).optString("defTextColor", "");
      }
      catch (Exception localException2)
      {
        try
        {
          Color.parseColor(paramaqqs.cwf);
          paramaqqs.cwg = ((JSONObject)localObject).optString("timeAndLocation", "");
        }
        catch (Exception localException2)
        {
          try
          {
            Color.parseColor(paramaqqs.cwg);
            paramaqqs.ecc = ((JSONObject)localObject).optInt("isLimited", 1);
            paramaqqs.cwh = ((JSONObject)localObject).optString("startTime");
            paramaqqs.endTime = ((JSONObject)localObject).optString("endTime");
            paramaqqs.cwi = ((JSONObject)localObject).optString("dot9png");
            paramaqqs.cover = ((JSONObject)localObject).optString("cover");
            paramaqqs.cvZ = ((JSONObject)localObject).optString("aio_2");
            paramaqqs.cwa = ((JSONObject)localObject).optString("aio_3");
            paramaqqs.cwb = ((JSONObject)localObject).optString("aio_4");
            paramaqqs.icon = ((JSONObject)localObject).optString("icon");
            paramaqqs.view = ((JSONObject)localObject).optString("view");
            paramaqqs.cwc = ((JSONObject)localObject).optString("action_off");
            paramaqqs.cwd = ((JSONObject)localObject).optString("action_on");
            paramaqqs.backgroundColor = ((JSONObject)localObject).optString("backgroundColor");
            paramaqqs.shadowColor = ((JSONObject)localObject).optString("shadowColor");
            paramaqqs.materialVersion = ((JSONObject)localObject).optInt("materialVersion");
            if (paramString.has("dynamicItem"))
            {
              localObject = paramString.getJSONArray("dynamicItem");
              j = 0;
              if (j < ((JSONArray)localObject).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
                i = localJSONObject.optInt("aio_rows", -1);
                if ((i != 0) && ((i <= 1) || (i >= 6))) {
                  break label883;
                }
                aqqs.a[] arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label890;
                }
                k = i;
                arrayOfa[k].ecd = i;
                arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label898;
                }
                k = i;
                arrayOfa[k].cwj = localJSONObject.optString("pngZip");
                arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label906;
                }
                k = i;
                arrayOfa[k].posX = ((float)localJSONObject.optDouble("posX", 0.0D));
                arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label914;
                }
                k = i;
                arrayOfa[k].posY = ((float)localJSONObject.optDouble("posY", 0.0D));
                arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label922;
                }
                k = i;
                arrayOfa[k].width = ((float)localJSONObject.optDouble("width", 0.0D));
                arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label930;
                }
                k = i;
                arrayOfa[k].height = ((float)localJSONObject.optDouble("height", 0.0D));
                arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label938;
                }
                k = i;
                arrayOfa[k].ece = localJSONObject.optInt("repeatTimes", 0);
                arrayOfa = paramaqqs.jdField_a_of_type_ArrayOfAqqs$a;
                if (i != 0) {
                  break label946;
                }
                arrayOfa[i].interval = localJSONObject.optInt("interval", 0);
                break label883;
                localException1 = localException1;
                paramaqqs.fontColor = "";
                continue;
                localException2 = localException2;
                paramaqqs.cwf = "";
              }
            }
          }
          catch (Exception localException3)
          {
            paramaqqs.cwg = "";
            continue;
            paramString = paramString.optJSONArray("imgItem");
            if ((paramString != null) && (paramString.length() > 0))
            {
              paramString = paramString.getJSONObject(0);
              paramaqqs.getClass();
              localObject = new aqqs.b(paramaqqs);
              ((aqqs.b)localObject).content = paramString.optString("content");
              ((aqqs.b)localObject).imgUrl = paramString.optString("img");
              ((aqqs.b)localObject).width = paramString.optInt("imgWidth");
              ((aqqs.b)localObject).height = paramString.optInt("imgHeight");
              ((aqqs.b)localObject).coverUrl = paramString.optString("imgCover");
              paramaqqs.jdField_a_of_type_Aqqs$b = ((aqqs.b)localObject);
            }
          }
        }
      }
      label882:
      return;
      label883:
      j += 1;
      continue;
      label890:
      int k = i - 1;
      continue;
      label898:
      k = i - 1;
      continue;
      label906:
      k = i - 1;
      continue;
      label914:
      k = i - 1;
      continue;
      label922:
      k = i - 1;
      continue;
      label930:
      k = i - 1;
      continue;
      label938:
      k = i - 1;
      continue;
      label946:
      i -= 1;
    }
  }
  
  /* Error */
  public static aqqr.a[] a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 367	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 368	java/util/LinkedHashMap:<init>	()V
    //   7: astore 7
    //   9: new 31	java/io/File
    //   12: dup
    //   13: getstatic 373	com/tencent/mobileqq/app/SignatureManager:hv	Ljava/lang/String;
    //   16: invokespecial 374	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: iconst_m1
    //   22: invokestatic 58	aqhq:b	(Ljava/io/File;I)Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +24 -> 51
    //   30: aconst_null
    //   31: areturn
    //   32: astore_0
    //   33: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +1592 -> 1628
    //   39: ldc 60
    //   41: iconst_2
    //   42: ldc 70
    //   44: aload_0
    //   45: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto +1580 -> 1628
    //   51: new 93	org/json/JSONObject
    //   54: dup
    //   55: aload_0
    //   56: aload_0
    //   57: ldc_w 380
    //   60: invokevirtual 385	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   63: aload_0
    //   64: invokevirtual 386	java/lang/String:length	()I
    //   67: invokevirtual 390	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   70: checkcast 382	java/lang/String
    //   73: invokespecial 94	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   76: ldc 96
    //   78: invokevirtual 393	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore_0
    //   82: aload_0
    //   83: ldc_w 395
    //   86: invokevirtual 283	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   89: astore 8
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: aload 8
    //   96: invokevirtual 106	org/json/JSONArray:length	()I
    //   99: if_icmpge +71 -> 170
    //   102: aload 8
    //   104: iload_3
    //   105: invokevirtual 110	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 9
    //   110: new 6	aqqr$a
    //   113: dup
    //   114: invokespecial 396	aqqr$a:<init>	()V
    //   117: astore 10
    //   119: aload 10
    //   121: aload 9
    //   123: ldc_w 398
    //   126: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   129: putfield 404	aqqr$a:eca	I
    //   132: aload 10
    //   134: aload 9
    //   136: ldc_w 406
    //   139: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 412	aqqr$a:cvX	Ljava/lang/String;
    //   145: aload 7
    //   147: aload 10
    //   149: getfield 404	aqqr$a:eca	I
    //   152: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aload 10
    //   157: invokeinterface 422 3 0
    //   162: pop
    //   163: iload_3
    //   164: iconst_1
    //   165: iadd
    //   166: istore_3
    //   167: goto -74 -> 93
    //   170: aload_0
    //   171: ldc_w 424
    //   174: invokevirtual 393	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   177: astore 8
    //   179: aload 8
    //   181: invokevirtual 428	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   184: astore 9
    //   186: aload 9
    //   188: invokeinterface 433 1 0
    //   193: ifeq +1346 -> 1539
    //   196: aload 8
    //   198: aload 9
    //   200: invokeinterface 437 1 0
    //   205: checkcast 382	java/lang/String
    //   208: invokevirtual 283	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   211: astore 10
    //   213: iconst_0
    //   214: istore 4
    //   216: iload 4
    //   218: aload 10
    //   220: invokevirtual 106	org/json/JSONArray:length	()I
    //   223: if_icmpge -37 -> 186
    //   226: aload 10
    //   228: iload 4
    //   230: invokevirtual 110	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   233: astore 12
    //   235: new 75	aqqs
    //   238: dup
    //   239: aload 12
    //   241: ldc_w 439
    //   244: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokespecial 83	aqqs:<init>	(Ljava/lang/String;)V
    //   250: astore 11
    //   252: aload 12
    //   254: ldc 96
    //   256: invokevirtual 283	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   259: astore 13
    //   261: iconst_0
    //   262: istore_3
    //   263: iload_3
    //   264: aload 13
    //   266: invokevirtual 106	org/json/JSONArray:length	()I
    //   269: if_icmpge +729 -> 998
    //   272: aload 13
    //   274: iload_3
    //   275: invokevirtual 110	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   278: astore 14
    //   280: aload 14
    //   282: ldc 112
    //   284: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   287: iconst_1
    //   288: if_icmpne +6 -> 294
    //   291: goto +1339 -> 1630
    //   294: aload 11
    //   296: aload 14
    //   298: ldc 121
    //   300: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: putfield 130	aqqs:cvY	Ljava/lang/String;
    //   306: aload 11
    //   308: getfield 130	aqqs:cvY	Ljava/lang/String;
    //   311: invokestatic 135	com/tencent/common/config/AppSetting:bs	(Ljava/lang/String;)I
    //   314: iflt +1316 -> 1630
    //   317: aload 14
    //   319: ldc 142
    //   321: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   324: ifeq +631 -> 955
    //   327: aload 14
    //   329: ldc 142
    //   331: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: astore_0
    //   335: aload 11
    //   337: aload_0
    //   338: putfield 150	aqqs:name	Ljava/lang/String;
    //   341: aload 14
    //   343: ldc 152
    //   345: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   348: ifeq +1289 -> 1637
    //   351: aload 14
    //   353: ldc 152
    //   355: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   358: istore 5
    //   360: aload 11
    //   362: iload 5
    //   364: putfield 158	aqqs:type	I
    //   367: aload 14
    //   369: ldc 160
    //   371: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   374: ifeq +1269 -> 1643
    //   377: aload 14
    //   379: ldc 160
    //   381: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   384: istore 5
    //   386: aload 11
    //   388: iload 5
    //   390: putfield 162	aqqs:feeType	I
    //   393: aload 14
    //   395: ldc 164
    //   397: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   400: ifeq +1249 -> 1649
    //   403: aload 14
    //   405: ldc 164
    //   407: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore_0
    //   411: aload 11
    //   413: aload_0
    //   414: putfield 166	aqqs:actUrl	Ljava/lang/String;
    //   417: aload 14
    //   419: ldc 168
    //   421: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   424: ifeq +1230 -> 1654
    //   427: aload 14
    //   429: ldc 168
    //   431: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   434: istore 5
    //   436: aload 11
    //   438: iload 5
    //   440: putfield 171	aqqs:ecb	I
    //   443: aload 11
    //   445: aload 14
    //   447: ldc 112
    //   449: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   452: putfield 173	aqqs:platId	I
    //   455: aload 14
    //   457: ldc 175
    //   459: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   462: ifeq +1198 -> 1660
    //   465: aload 14
    //   467: ldc 175
    //   469: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   472: astore_0
    //   473: aload 11
    //   475: aload_0
    //   476: putfield 179	aqqs:fontColor	Ljava/lang/String;
    //   479: aload 11
    //   481: getfield 179	aqqs:fontColor	Ljava/lang/String;
    //   484: invokestatic 188	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   487: pop
    //   488: aload 14
    //   490: ldc 190
    //   492: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   495: ifeq +1171 -> 1666
    //   498: aload 14
    //   500: ldc 190
    //   502: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore_0
    //   506: aload 11
    //   508: aload_0
    //   509: putfield 193	aqqs:cwe	Ljava/lang/String;
    //   512: aload 14
    //   514: ldc 195
    //   516: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   519: ifeq +1153 -> 1672
    //   522: aload 14
    //   524: ldc 195
    //   526: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   529: astore_0
    //   530: aload 11
    //   532: aload_0
    //   533: putfield 198	aqqs:cwf	Ljava/lang/String;
    //   536: aload 11
    //   538: getfield 198	aqqs:cwf	Ljava/lang/String;
    //   541: invokestatic 188	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   544: pop
    //   545: aload 14
    //   547: ldc 200
    //   549: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   552: ifeq +1126 -> 1678
    //   555: aload 14
    //   557: ldc 200
    //   559: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   562: astore_0
    //   563: aload 11
    //   565: aload_0
    //   566: putfield 203	aqqs:cwg	Ljava/lang/String;
    //   569: aload 11
    //   571: getfield 203	aqqs:cwg	Ljava/lang/String;
    //   574: invokestatic 188	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   577: pop
    //   578: aload 14
    //   580: ldc 205
    //   582: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   585: ifeq +1099 -> 1684
    //   588: aload 14
    //   590: ldc 205
    //   592: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   595: istore 5
    //   597: aload 11
    //   599: iload 5
    //   601: putfield 208	aqqs:ecc	I
    //   604: aload 14
    //   606: ldc 210
    //   608: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   611: ifeq +1079 -> 1690
    //   614: aload 14
    //   616: ldc 210
    //   618: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   621: astore_0
    //   622: aload 11
    //   624: aload_0
    //   625: putfield 216	aqqs:cwh	Ljava/lang/String;
    //   628: aload 14
    //   630: ldc 218
    //   632: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   635: ifeq +1061 -> 1696
    //   638: aload 14
    //   640: ldc 218
    //   642: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   645: astore_0
    //   646: aload 11
    //   648: aload_0
    //   649: putfield 220	aqqs:endTime	Ljava/lang/String;
    //   652: aload 14
    //   654: ldc 222
    //   656: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   659: ifeq +1043 -> 1702
    //   662: aload 14
    //   664: ldc 222
    //   666: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   669: astore_0
    //   670: aload 11
    //   672: aload_0
    //   673: putfield 225	aqqs:cwi	Ljava/lang/String;
    //   676: aload 14
    //   678: ldc_w 264
    //   681: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   684: ifeq +1024 -> 1708
    //   687: aload 14
    //   689: ldc_w 264
    //   692: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   695: astore_0
    //   696: aload 11
    //   698: aload_0
    //   699: putfield 266	aqqs:backgroundColor	Ljava/lang/String;
    //   702: aload 14
    //   704: ldc 227
    //   706: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   709: ifeq +15 -> 724
    //   712: aload 11
    //   714: aload 14
    //   716: ldc 227
    //   718: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   721: putfield 229	aqqs:cover	Ljava/lang/String;
    //   724: aload 14
    //   726: ldc 231
    //   728: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   731: ifeq +15 -> 746
    //   734: aload 11
    //   736: aload 14
    //   738: ldc 231
    //   740: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 234	aqqs:cvZ	Ljava/lang/String;
    //   746: aload 14
    //   748: ldc 236
    //   750: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   753: ifeq +15 -> 768
    //   756: aload 11
    //   758: aload 14
    //   760: ldc 236
    //   762: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   765: putfield 239	aqqs:cwa	Ljava/lang/String;
    //   768: aload 14
    //   770: ldc 241
    //   772: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   775: ifeq +15 -> 790
    //   778: aload 11
    //   780: aload 14
    //   782: ldc 241
    //   784: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   787: putfield 244	aqqs:cwb	Ljava/lang/String;
    //   790: aload 14
    //   792: ldc 246
    //   794: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   797: ifeq +15 -> 812
    //   800: aload 11
    //   802: aload 14
    //   804: ldc 246
    //   806: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   809: putfield 248	aqqs:icon	Ljava/lang/String;
    //   812: aload 14
    //   814: ldc 250
    //   816: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   819: ifeq +15 -> 834
    //   822: aload 11
    //   824: aload 14
    //   826: ldc 250
    //   828: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   831: putfield 252	aqqs:view	Ljava/lang/String;
    //   834: aload 14
    //   836: ldc 254
    //   838: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   841: ifeq +15 -> 856
    //   844: aload 11
    //   846: aload 14
    //   848: ldc 254
    //   850: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   853: putfield 257	aqqs:cwc	Ljava/lang/String;
    //   856: aload 14
    //   858: ldc_w 259
    //   861: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   864: ifeq +766 -> 1630
    //   867: aload 11
    //   869: aload 14
    //   871: ldc_w 259
    //   874: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   877: putfield 262	aqqs:cwd	Ljava/lang/String;
    //   880: goto +750 -> 1630
    //   883: astore_0
    //   884: new 31	java/io/File
    //   887: dup
    //   888: getstatic 373	com/tencent/mobileqq/app/SignatureManager:hv	Ljava/lang/String;
    //   891: invokespecial 374	java/io/File:<init>	(Ljava/lang/String;)V
    //   894: astore 7
    //   896: aload 7
    //   898: invokevirtual 442	java/io/File:exists	()Z
    //   901: ifeq +17 -> 918
    //   904: aload 7
    //   906: invokevirtual 445	java/io/File:isFile	()Z
    //   909: ifeq +9 -> 918
    //   912: aload 7
    //   914: invokevirtual 448	java/io/File:delete	()Z
    //   917: pop
    //   918: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   921: ifeq +32 -> 953
    //   924: ldc 60
    //   926: iconst_2
    //   927: new 12	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   934: ldc_w 450
    //   937: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: aload_0
    //   941: invokevirtual 451	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   944: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 454	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   953: aconst_null
    //   954: areturn
    //   955: ldc_w 455
    //   958: invokestatic 148	acfp:m	(I)Ljava/lang/String;
    //   961: astore_0
    //   962: goto -627 -> 335
    //   965: astore_0
    //   966: aload 11
    //   968: ldc 177
    //   970: putfield 179	aqqs:fontColor	Ljava/lang/String;
    //   973: goto -485 -> 488
    //   976: astore_0
    //   977: aload 11
    //   979: ldc 177
    //   981: putfield 198	aqqs:cwf	Ljava/lang/String;
    //   984: goto -439 -> 545
    //   987: astore_0
    //   988: aload 11
    //   990: ldc 177
    //   992: putfield 203	aqqs:cwg	Ljava/lang/String;
    //   995: goto -417 -> 578
    //   998: aload 12
    //   1000: ldc_w 276
    //   1003: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1006: ifeq +387 -> 1393
    //   1009: aload 12
    //   1011: ldc_w 276
    //   1014: invokevirtual 283	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1017: astore 13
    //   1019: iconst_0
    //   1020: istore 5
    //   1022: iload 5
    //   1024: aload 13
    //   1026: invokevirtual 106	org/json/JSONArray:length	()I
    //   1029: if_icmpge +364 -> 1393
    //   1032: aload 13
    //   1034: iload 5
    //   1036: invokevirtual 110	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1039: astore 14
    //   1041: aload 14
    //   1043: ldc_w 285
    //   1046: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1049: ifeq +692 -> 1741
    //   1052: aload 14
    //   1054: ldc_w 285
    //   1057: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1060: istore_3
    //   1061: goto +653 -> 1714
    //   1064: aload 11
    //   1066: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1069: astore_0
    //   1070: iload_3
    //   1071: ifne +675 -> 1746
    //   1074: iload_3
    //   1075: istore 6
    //   1077: aload_0
    //   1078: iload 6
    //   1080: aaload
    //   1081: iload_3
    //   1082: putfield 293	aqqs$a:ecd	I
    //   1085: aload 11
    //   1087: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1090: astore_0
    //   1091: iload_3
    //   1092: ifne +662 -> 1754
    //   1095: iload_3
    //   1096: istore 6
    //   1098: aload_0
    //   1099: iload 6
    //   1101: aaload
    //   1102: astore 15
    //   1104: aload 14
    //   1106: ldc_w 295
    //   1109: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1112: ifeq +650 -> 1762
    //   1115: aload 14
    //   1117: ldc_w 295
    //   1120: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1123: astore_0
    //   1124: aload 15
    //   1126: aload_0
    //   1127: putfield 298	aqqs$a:cwj	Ljava/lang/String;
    //   1130: aload 11
    //   1132: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1135: astore_0
    //   1136: iload_3
    //   1137: ifne +631 -> 1768
    //   1140: iload_3
    //   1141: istore 6
    //   1143: aload_0
    //   1144: iload 6
    //   1146: aaload
    //   1147: astore_0
    //   1148: aload 14
    //   1150: ldc_w 300
    //   1153: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1156: ifeq +620 -> 1776
    //   1159: aload 14
    //   1161: ldc_w 300
    //   1164: invokevirtual 459	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1167: dstore_1
    //   1168: aload_0
    //   1169: dload_1
    //   1170: d2f
    //   1171: putfield 307	aqqs$a:posX	F
    //   1174: aload 11
    //   1176: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1179: astore_0
    //   1180: iload_3
    //   1181: ifne +600 -> 1781
    //   1184: iload_3
    //   1185: istore 6
    //   1187: aload_0
    //   1188: iload 6
    //   1190: aaload
    //   1191: astore_0
    //   1192: aload 14
    //   1194: ldc_w 309
    //   1197: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1200: ifeq +589 -> 1789
    //   1203: aload 14
    //   1205: ldc_w 309
    //   1208: invokevirtual 459	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1211: dstore_1
    //   1212: aload_0
    //   1213: dload_1
    //   1214: d2f
    //   1215: putfield 311	aqqs$a:posY	F
    //   1218: aload 11
    //   1220: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1223: astore_0
    //   1224: iload_3
    //   1225: ifne +569 -> 1794
    //   1228: iload_3
    //   1229: istore 6
    //   1231: aload_0
    //   1232: iload 6
    //   1234: aaload
    //   1235: astore_0
    //   1236: aload 14
    //   1238: ldc_w 313
    //   1241: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1244: ifeq +558 -> 1802
    //   1247: aload 14
    //   1249: ldc_w 313
    //   1252: invokevirtual 459	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1255: dstore_1
    //   1256: aload_0
    //   1257: dload_1
    //   1258: d2f
    //   1259: putfield 315	aqqs$a:width	F
    //   1262: aload 11
    //   1264: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1267: astore_0
    //   1268: iload_3
    //   1269: ifne +538 -> 1807
    //   1272: iload_3
    //   1273: istore 6
    //   1275: aload_0
    //   1276: iload 6
    //   1278: aaload
    //   1279: astore_0
    //   1280: aload 14
    //   1282: ldc_w 317
    //   1285: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1288: ifeq +527 -> 1815
    //   1291: aload 14
    //   1293: ldc_w 317
    //   1296: invokevirtual 459	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1299: dstore_1
    //   1300: aload_0
    //   1301: dload_1
    //   1302: d2f
    //   1303: putfield 319	aqqs$a:height	F
    //   1306: aload 11
    //   1308: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1311: astore_0
    //   1312: iload_3
    //   1313: ifne +507 -> 1820
    //   1316: iload_3
    //   1317: istore 6
    //   1319: aload_0
    //   1320: iload 6
    //   1322: aaload
    //   1323: astore_0
    //   1324: aload 14
    //   1326: ldc_w 321
    //   1329: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1332: ifeq +496 -> 1828
    //   1335: aload 14
    //   1337: ldc_w 321
    //   1340: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1343: istore 6
    //   1345: aload_0
    //   1346: iload 6
    //   1348: putfield 324	aqqs$a:ece	I
    //   1351: aload 11
    //   1353: getfield 288	aqqs:jdField_a_of_type_ArrayOfAqqs$a	[Laqqs$a;
    //   1356: astore_0
    //   1357: iload_3
    //   1358: ifne +476 -> 1834
    //   1361: aload_0
    //   1362: iload_3
    //   1363: aaload
    //   1364: astore_0
    //   1365: aload 14
    //   1367: ldc_w 326
    //   1370: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1373: ifeq +468 -> 1841
    //   1376: aload 14
    //   1378: ldc_w 326
    //   1381: invokevirtual 401	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1384: istore_3
    //   1385: aload_0
    //   1386: iload_3
    //   1387: putfield 328	aqqs$a:interval	I
    //   1390: goto +342 -> 1732
    //   1393: aload 12
    //   1395: ldc_w 330
    //   1398: invokevirtual 100	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1401: astore_0
    //   1402: aload_0
    //   1403: ifnull +100 -> 1503
    //   1406: aload_0
    //   1407: invokevirtual 106	org/json/JSONArray:length	()I
    //   1410: ifle +93 -> 1503
    //   1413: aload_0
    //   1414: iconst_0
    //   1415: invokevirtual 110	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1418: astore_0
    //   1419: aload 11
    //   1421: invokevirtual 334	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1424: pop
    //   1425: new 336	aqqs$b
    //   1428: dup
    //   1429: aload 11
    //   1431: invokespecial 339	aqqs$b:<init>	(Laqqs;)V
    //   1434: astore 12
    //   1436: aload 12
    //   1438: aload_0
    //   1439: ldc_w 341
    //   1442: invokevirtual 213	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1445: putfield 343	aqqs$b:content	Ljava/lang/String;
    //   1448: aload 12
    //   1450: aload_0
    //   1451: ldc_w 345
    //   1454: invokevirtual 213	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1457: putfield 348	aqqs$b:imgUrl	Ljava/lang/String;
    //   1460: aload 12
    //   1462: aload_0
    //   1463: ldc_w 350
    //   1466: invokevirtual 116	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1469: putfield 352	aqqs$b:width	I
    //   1472: aload 12
    //   1474: aload_0
    //   1475: ldc_w 354
    //   1478: invokevirtual 116	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1481: putfield 356	aqqs$b:height	I
    //   1484: aload 12
    //   1486: aload_0
    //   1487: ldc_w 358
    //   1490: invokevirtual 213	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1493: putfield 361	aqqs$b:coverUrl	Ljava/lang/String;
    //   1496: aload 11
    //   1498: aload 12
    //   1500: putfield 364	aqqs:jdField_a_of_type_Aqqs$b	Laqqs$b;
    //   1503: aload 7
    //   1505: aload 11
    //   1507: getfield 158	aqqs:type	I
    //   1510: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1513: invokeinterface 463 2 0
    //   1518: checkcast 6	aqqr$a
    //   1521: astore_0
    //   1522: aload_0
    //   1523: ifnull +323 -> 1846
    //   1526: aload_0
    //   1527: getfield 467	aqqr$a:CX	Ljava/util/ArrayList;
    //   1530: aload 11
    //   1532: invokevirtual 473	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1535: pop
    //   1536: goto +310 -> 1846
    //   1539: aload 7
    //   1541: invokeinterface 477 1 0
    //   1546: invokeinterface 482 1 0
    //   1551: astore_0
    //   1552: aload_0
    //   1553: invokeinterface 433 1 0
    //   1558: ifeq +38 -> 1596
    //   1561: aload_0
    //   1562: invokeinterface 437 1 0
    //   1567: checkcast 484	java/util/Map$Entry
    //   1570: invokeinterface 487 1 0
    //   1575: checkcast 6	aqqr$a
    //   1578: getfield 467	aqqr$a:CX	Ljava/util/ArrayList;
    //   1581: invokevirtual 490	java/util/ArrayList:size	()I
    //   1584: ifne -32 -> 1552
    //   1587: aload_0
    //   1588: invokeinterface 493 1 0
    //   1593: goto -41 -> 1552
    //   1596: aload 7
    //   1598: invokeinterface 497 1 0
    //   1603: invokeinterface 500 1 0
    //   1608: anewarray 6	aqqr$a
    //   1611: astore_0
    //   1612: aload 7
    //   1614: invokeinterface 497 1 0
    //   1619: aload_0
    //   1620: invokeinterface 504 2 0
    //   1625: pop
    //   1626: aload_0
    //   1627: areturn
    //   1628: aconst_null
    //   1629: areturn
    //   1630: iload_3
    //   1631: iconst_1
    //   1632: iadd
    //   1633: istore_3
    //   1634: goto -1371 -> 263
    //   1637: iconst_m1
    //   1638: istore 5
    //   1640: goto -1280 -> 360
    //   1643: iconst_1
    //   1644: istore 5
    //   1646: goto -1260 -> 386
    //   1649: aconst_null
    //   1650: astore_0
    //   1651: goto -1240 -> 411
    //   1654: iconst_0
    //   1655: istore 5
    //   1657: goto -1221 -> 436
    //   1660: ldc 177
    //   1662: astore_0
    //   1663: goto -1190 -> 473
    //   1666: ldc 177
    //   1668: astore_0
    //   1669: goto -1163 -> 506
    //   1672: ldc 177
    //   1674: astore_0
    //   1675: goto -1145 -> 530
    //   1678: ldc 177
    //   1680: astore_0
    //   1681: goto -1118 -> 563
    //   1684: iconst_1
    //   1685: istore 5
    //   1687: goto -1090 -> 597
    //   1690: ldc 177
    //   1692: astore_0
    //   1693: goto -1071 -> 622
    //   1696: ldc 177
    //   1698: astore_0
    //   1699: goto -1053 -> 646
    //   1702: ldc 177
    //   1704: astore_0
    //   1705: goto -1035 -> 670
    //   1708: ldc 177
    //   1710: astore_0
    //   1711: goto -1015 -> 696
    //   1714: iload_3
    //   1715: ifeq -651 -> 1064
    //   1718: iload_3
    //   1719: iconst_1
    //   1720: if_icmple +12 -> 1732
    //   1723: iload_3
    //   1724: bipush 6
    //   1726: if_icmpge +6 -> 1732
    //   1729: goto -665 -> 1064
    //   1732: iload 5
    //   1734: iconst_1
    //   1735: iadd
    //   1736: istore 5
    //   1738: goto -716 -> 1022
    //   1741: iconst_m1
    //   1742: istore_3
    //   1743: goto -29 -> 1714
    //   1746: iload_3
    //   1747: iconst_1
    //   1748: isub
    //   1749: istore 6
    //   1751: goto -674 -> 1077
    //   1754: iload_3
    //   1755: iconst_1
    //   1756: isub
    //   1757: istore 6
    //   1759: goto -661 -> 1098
    //   1762: ldc 177
    //   1764: astore_0
    //   1765: goto -641 -> 1124
    //   1768: iload_3
    //   1769: iconst_1
    //   1770: isub
    //   1771: istore 6
    //   1773: goto -630 -> 1143
    //   1776: dconst_0
    //   1777: dstore_1
    //   1778: goto -610 -> 1168
    //   1781: iload_3
    //   1782: iconst_1
    //   1783: isub
    //   1784: istore 6
    //   1786: goto -599 -> 1187
    //   1789: dconst_0
    //   1790: dstore_1
    //   1791: goto -579 -> 1212
    //   1794: iload_3
    //   1795: iconst_1
    //   1796: isub
    //   1797: istore 6
    //   1799: goto -568 -> 1231
    //   1802: dconst_0
    //   1803: dstore_1
    //   1804: goto -548 -> 1256
    //   1807: iload_3
    //   1808: iconst_1
    //   1809: isub
    //   1810: istore 6
    //   1812: goto -537 -> 1275
    //   1815: dconst_0
    //   1816: dstore_1
    //   1817: goto -517 -> 1300
    //   1820: iload_3
    //   1821: iconst_1
    //   1822: isub
    //   1823: istore 6
    //   1825: goto -506 -> 1319
    //   1828: iconst_0
    //   1829: istore 6
    //   1831: goto -486 -> 1345
    //   1834: iload_3
    //   1835: iconst_1
    //   1836: isub
    //   1837: istore_3
    //   1838: goto -477 -> 1361
    //   1841: iconst_0
    //   1842: istore_3
    //   1843: goto -458 -> 1385
    //   1846: iload 4
    //   1848: iconst_1
    //   1849: iadd
    //   1850: istore 4
    //   1852: goto -1636 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1855	0	paramQQAppInterface	QQAppInterface
    //   1167	650	1	d	double
    //   92	1751	3	i	int
    //   214	1637	4	j	int
    //   358	1379	5	k	int
    //   1075	755	6	m	int
    //   7	1606	7	localObject1	Object
    //   89	108	8	localObject2	Object
    //   108	91	9	localObject3	Object
    //   117	110	10	localObject4	Object
    //   250	1281	11	localaqqs	aqqs
    //   233	1266	12	localObject5	Object
    //   259	774	13	localJSONArray	JSONArray
    //   278	1099	14	localJSONObject	JSONObject
    //   1102	23	15	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	32	java/lang/OutOfMemoryError
    //   0	20	883	java/lang/Exception
    //   20	26	883	java/lang/Exception
    //   33	48	883	java/lang/Exception
    //   51	91	883	java/lang/Exception
    //   93	163	883	java/lang/Exception
    //   170	186	883	java/lang/Exception
    //   186	213	883	java/lang/Exception
    //   216	261	883	java/lang/Exception
    //   263	291	883	java/lang/Exception
    //   294	335	883	java/lang/Exception
    //   335	360	883	java/lang/Exception
    //   360	386	883	java/lang/Exception
    //   386	411	883	java/lang/Exception
    //   411	436	883	java/lang/Exception
    //   436	473	883	java/lang/Exception
    //   473	479	883	java/lang/Exception
    //   488	506	883	java/lang/Exception
    //   506	530	883	java/lang/Exception
    //   530	536	883	java/lang/Exception
    //   545	563	883	java/lang/Exception
    //   563	569	883	java/lang/Exception
    //   578	597	883	java/lang/Exception
    //   597	622	883	java/lang/Exception
    //   622	646	883	java/lang/Exception
    //   646	670	883	java/lang/Exception
    //   670	696	883	java/lang/Exception
    //   696	724	883	java/lang/Exception
    //   724	746	883	java/lang/Exception
    //   746	768	883	java/lang/Exception
    //   768	790	883	java/lang/Exception
    //   790	812	883	java/lang/Exception
    //   812	834	883	java/lang/Exception
    //   834	856	883	java/lang/Exception
    //   856	880	883	java/lang/Exception
    //   955	962	883	java/lang/Exception
    //   966	973	883	java/lang/Exception
    //   977	984	883	java/lang/Exception
    //   988	995	883	java/lang/Exception
    //   998	1019	883	java/lang/Exception
    //   1022	1061	883	java/lang/Exception
    //   1064	1070	883	java/lang/Exception
    //   1077	1091	883	java/lang/Exception
    //   1104	1124	883	java/lang/Exception
    //   1124	1136	883	java/lang/Exception
    //   1148	1168	883	java/lang/Exception
    //   1168	1180	883	java/lang/Exception
    //   1192	1212	883	java/lang/Exception
    //   1212	1224	883	java/lang/Exception
    //   1236	1256	883	java/lang/Exception
    //   1256	1268	883	java/lang/Exception
    //   1280	1300	883	java/lang/Exception
    //   1300	1312	883	java/lang/Exception
    //   1324	1345	883	java/lang/Exception
    //   1345	1357	883	java/lang/Exception
    //   1365	1385	883	java/lang/Exception
    //   1385	1390	883	java/lang/Exception
    //   1393	1402	883	java/lang/Exception
    //   1406	1503	883	java/lang/Exception
    //   1503	1522	883	java/lang/Exception
    //   1526	1536	883	java/lang/Exception
    //   1539	1552	883	java/lang/Exception
    //   1552	1593	883	java/lang/Exception
    //   1596	1626	883	java/lang/Exception
    //   479	488	965	java/lang/Exception
    //   536	545	976	java/lang/Exception
    //   569	578	987	java/lang/Exception
  }
  
  public static String cb(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(acbn.bmQ);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public ArrayList<aqqs> CX = new ArrayList();
    public String cvX;
    public int eca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqr
 * JD-Core Version:    0.7.0.1
 */