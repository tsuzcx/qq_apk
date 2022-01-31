package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletGetContactJsPlugin
  extends VasWebviewJsPlugin
{
  private static byte REQUESTCODE_TRANSFER = 1;
  private final String QQPIMSECURE_SAFE_SECURITYPAY_ISOPEN = "qw_charge_qqpimsecure_safe_isopen_securitypay";
  private final byte QWALLET_REQUEST_CONTACT = 16;
  private final String QWALLET_TOKEN_AIO_TRANSFER = "qw_charge_tenpayTransfer";
  private final String QWALLET_TOKEN_GET_ALL_CONTATC = "qw_charge_getAllContact";
  private final String QWALLET_TOKEN_GET_SELECT_CONTACT = "qw_charge_getSelectContact";
  private final String QWALLET_TOKEN_GOTO_QWALLET_HOME = "qw_charge_gotoQWalletHome";
  protected QWalletGetContactJsPlugin.ChooseQQFriendForTransferReceiver aioChoFriReceiver;
  private String mCallback = null;
  private Context mContext;
  
  private void chooseQQFriendsForTransfer(String paramString)
  {
    boolean bool2 = true;
    Object localObject1;
    if (this.mRuntime != null) {
      localObject1 = this.mRuntime.a();
    }
    for (;;)
    {
      if ((localObject1 == null) || (TextUtils.isEmpty(paramString)))
      {
        dochooseQQFriendsForTransferResult(null);
        return;
      }
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).optString("title", "选择联系人");
        int i = ((JSONObject)localObject2).optInt("type", 1);
        this.mCallback = ((JSONObject)localObject2).optString("callback");
        if ((i & 0x1) == 0) {}
        for (boolean bool1 = false;; bool1 = true)
        {
          if ((i & 0x2) == 0) {
            bool2 = false;
          }
          if (this.aioChoFriReceiver == null) {
            this.aioChoFriReceiver = new QWalletGetContactJsPlugin.ChooseQQFriendForTransferReceiver(this, new Handler());
          }
          Parcel localParcel = Parcel.obtain();
          this.aioChoFriReceiver.writeToParcel(localParcel, 0);
          localParcel.setDataPosition(0);
          localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
          localParcel.recycle();
          localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
          ((Intent)localObject1).putExtra("forward_type", 15);
          ((Intent)localObject1).putExtra("choose_friend_title", paramString);
          ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
          ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
          ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
          super.startActivityForResult((Intent)localObject1, REQUESTCODE_TRANSFER);
          return;
        }
        localObject1 = null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        dochooseQQFriendsForTransferResult(null);
        return;
      }
    }
  }
  
  private String comboApiName(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  private void doCallback(String paramString)
  {
    if ((!TextUtils.isEmpty(this.mCallback)) && (!TextUtils.isEmpty(paramString))) {
      callJs(this.mCallback, new String[] { paramString });
    }
  }
  
  /* Error */
  private JSONObject getAllContact()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 72	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:mContext	Landroid/content/Context;
    //   19: ifnonnull +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 96	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 216	org/json/JSONObject:<init>	()V
    //   31: astore 8
    //   33: new 218	org/json/JSONArray
    //   36: dup
    //   37: invokespecial 219	org/json/JSONArray:<init>	()V
    //   40: astore 9
    //   42: getstatic 225	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 72	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:mContext	Landroid/content/Context;
    //   51: invokevirtual 231	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: aload 5
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 237	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 5
    //   65: aload 6
    //   67: astore 4
    //   69: aload 5
    //   71: ifnull +90 -> 161
    //   74: aload 6
    //   76: astore 4
    //   78: aload 7
    //   80: astore_1
    //   81: aload 5
    //   83: invokeinterface 243 1 0
    //   88: ifeq +73 -> 161
    //   91: aload_3
    //   92: astore 4
    //   94: aload 4
    //   96: astore_1
    //   97: aload 4
    //   99: astore_2
    //   100: aload 5
    //   102: aload 5
    //   104: ldc 245
    //   106: invokeinterface 249 2 0
    //   111: invokeinterface 253 2 0
    //   116: astore_3
    //   117: aload 4
    //   119: astore_1
    //   120: aload 4
    //   122: astore_2
    //   123: aload_3
    //   124: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +94 -> 221
    //   130: aload 4
    //   132: astore_3
    //   133: aload_3
    //   134: astore 4
    //   136: aload 5
    //   138: ifnull +23 -> 161
    //   141: aload_3
    //   142: astore 4
    //   144: aload_3
    //   145: astore_1
    //   146: aload_3
    //   147: astore_2
    //   148: aload 5
    //   150: invokeinterface 256 1 0
    //   155: ifne -61 -> 94
    //   158: aload_3
    //   159: astore 4
    //   161: aload 4
    //   163: astore_1
    //   164: aload 4
    //   166: astore_2
    //   167: aload 8
    //   169: ldc_w 258
    //   172: aload 9
    //   174: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 4
    //   180: astore_1
    //   181: aload 4
    //   183: astore_2
    //   184: aload 8
    //   186: ldc_w 264
    //   189: iconst_0
    //   190: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 5
    //   196: ifnull +10 -> 206
    //   199: aload 5
    //   201: invokeinterface 270 1 0
    //   206: aload 4
    //   208: ifnull +10 -> 218
    //   211: aload 4
    //   213: invokeinterface 270 1 0
    //   218: aload 8
    //   220: areturn
    //   221: aload 4
    //   223: astore_1
    //   224: aload 4
    //   226: astore_2
    //   227: aload_0
    //   228: aload_3
    //   229: invokevirtual 273	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 6
    //   234: aload 4
    //   236: astore_3
    //   237: aload 4
    //   239: astore_1
    //   240: aload 4
    //   242: astore_2
    //   243: aload 5
    //   245: aload 5
    //   247: ldc_w 275
    //   250: invokeinterface 249 2 0
    //   255: invokeinterface 279 2 0
    //   260: ifle -127 -> 133
    //   263: aload 4
    //   265: astore_1
    //   266: aload 4
    //   268: astore_2
    //   269: aload 5
    //   271: aload 5
    //   273: ldc_w 281
    //   276: invokeinterface 249 2 0
    //   281: invokeinterface 253 2 0
    //   286: astore_3
    //   287: aload 4
    //   289: astore_1
    //   290: aload 4
    //   292: astore_2
    //   293: aload_0
    //   294: getfield 72	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:mContext	Landroid/content/Context;
    //   297: invokevirtual 231	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   300: getstatic 284	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   303: aconst_null
    //   304: new 196	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 286
    //   314: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aconst_null
    //   325: aconst_null
    //   326: invokevirtual 237	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   329: astore 4
    //   331: aload 4
    //   333: astore_3
    //   334: aload 4
    //   336: ifnull -203 -> 133
    //   339: aload 4
    //   341: astore_3
    //   342: aload 4
    //   344: astore_1
    //   345: aload 4
    //   347: astore_2
    //   348: aload 4
    //   350: invokeinterface 243 1 0
    //   355: ifeq -222 -> 133
    //   358: aload 4
    //   360: astore_1
    //   361: aload 4
    //   363: astore_2
    //   364: aload 4
    //   366: aload 4
    //   368: ldc_w 288
    //   371: invokeinterface 249 2 0
    //   376: invokeinterface 253 2 0
    //   381: astore_3
    //   382: aload 4
    //   384: astore_1
    //   385: aload 4
    //   387: astore_2
    //   388: aload_3
    //   389: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   392: ifeq +103 -> 495
    //   395: aload 4
    //   397: ifnull +19 -> 416
    //   400: aload 4
    //   402: astore_1
    //   403: aload 4
    //   405: astore_2
    //   406: aload 4
    //   408: invokeinterface 256 1 0
    //   413: ifne -55 -> 358
    //   416: aload 4
    //   418: astore_1
    //   419: aload 4
    //   421: astore_2
    //   422: aload 4
    //   424: invokeinterface 270 1 0
    //   429: aload 4
    //   431: astore_3
    //   432: goto -299 -> 133
    //   435: astore_3
    //   436: aload 5
    //   438: astore_2
    //   439: aload_3
    //   440: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   443: aload 8
    //   445: ldc_w 258
    //   448: aload 9
    //   450: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload 8
    //   456: ldc_w 264
    //   459: iconst_m1
    //   460: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   463: pop
    //   464: aload_2
    //   465: ifnull +9 -> 474
    //   468: aload_2
    //   469: invokeinterface 270 1 0
    //   474: aload_1
    //   475: ifnull -257 -> 218
    //   478: aload_1
    //   479: invokeinterface 270 1 0
    //   484: goto -266 -> 218
    //   487: astore_1
    //   488: aload_1
    //   489: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   492: goto -274 -> 218
    //   495: aload 4
    //   497: astore_1
    //   498: aload 4
    //   500: astore_2
    //   501: aload_0
    //   502: aload_3
    //   503: invokevirtual 292	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   506: astore_3
    //   507: aload 4
    //   509: astore_1
    //   510: aload 4
    //   512: astore_2
    //   513: new 96	org/json/JSONObject
    //   516: dup
    //   517: invokespecial 216	org/json/JSONObject:<init>	()V
    //   520: astore 7
    //   522: aload 4
    //   524: astore_1
    //   525: aload 4
    //   527: astore_2
    //   528: aload 7
    //   530: ldc_w 294
    //   533: aload 6
    //   535: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload 4
    //   541: astore_1
    //   542: aload 4
    //   544: astore_2
    //   545: aload 7
    //   547: ldc_w 296
    //   550: aload_3
    //   551: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   554: pop
    //   555: aload 4
    //   557: astore_1
    //   558: aload 4
    //   560: astore_2
    //   561: aload 9
    //   563: aload 7
    //   565: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   568: pop
    //   569: goto -174 -> 395
    //   572: astore_3
    //   573: aload_2
    //   574: astore_1
    //   575: aload_3
    //   576: astore_2
    //   577: aload 5
    //   579: ifnull +10 -> 589
    //   582: aload 5
    //   584: invokeinterface 270 1 0
    //   589: aload_1
    //   590: ifnull +9 -> 599
    //   593: aload_1
    //   594: invokeinterface 270 1 0
    //   599: aload_2
    //   600: athrow
    //   601: astore_1
    //   602: aload_1
    //   603: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   606: goto -400 -> 206
    //   609: astore_1
    //   610: aload_1
    //   611: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   614: goto -396 -> 218
    //   617: astore_3
    //   618: aload_3
    //   619: invokevirtual 193	org/json/JSONException:printStackTrace	()V
    //   622: goto -158 -> 464
    //   625: astore_3
    //   626: aload_2
    //   627: astore 5
    //   629: aload_3
    //   630: astore_2
    //   631: goto -54 -> 577
    //   634: astore_2
    //   635: aload_2
    //   636: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   639: goto -165 -> 474
    //   642: astore_3
    //   643: aload_3
    //   644: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   647: goto -58 -> 589
    //   650: astore_1
    //   651: aload_1
    //   652: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   655: goto -56 -> 599
    //   658: astore_2
    //   659: aconst_null
    //   660: astore 5
    //   662: aload 4
    //   664: astore_1
    //   665: goto -88 -> 577
    //   668: astore_3
    //   669: aconst_null
    //   670: astore_2
    //   671: goto -232 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	QWalletGetContactJsPlugin
    //   7	472	1	localObject1	Object
    //   487	2	1	localException1	java.lang.Exception
    //   497	97	1	localObject2	Object
    //   601	2	1	localException2	java.lang.Exception
    //   609	2	1	localException3	java.lang.Exception
    //   650	2	1	localException4	java.lang.Exception
    //   664	1	1	localObject3	Object
    //   9	622	2	localObject4	Object
    //   634	2	2	localException5	java.lang.Exception
    //   658	1	2	localObject5	Object
    //   670	1	2	localObject6	Object
    //   14	418	3	localObject7	Object
    //   435	68	3	localException6	java.lang.Exception
    //   506	45	3	str1	String
    //   572	4	3	localObject8	Object
    //   617	2	3	localJSONException	JSONException
    //   625	5	3	localObject9	Object
    //   642	2	3	localException7	java.lang.Exception
    //   668	1	3	localException8	java.lang.Exception
    //   11	652	4	localObject10	Object
    //   45	616	5	localObject11	Object
    //   1	533	6	str2	String
    //   4	560	7	localJSONObject1	JSONObject
    //   31	424	8	localJSONObject2	JSONObject
    //   40	522	9	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   81	91	435	java/lang/Exception
    //   100	117	435	java/lang/Exception
    //   123	130	435	java/lang/Exception
    //   148	158	435	java/lang/Exception
    //   167	178	435	java/lang/Exception
    //   184	194	435	java/lang/Exception
    //   227	234	435	java/lang/Exception
    //   243	263	435	java/lang/Exception
    //   269	287	435	java/lang/Exception
    //   293	331	435	java/lang/Exception
    //   348	358	435	java/lang/Exception
    //   364	382	435	java/lang/Exception
    //   388	395	435	java/lang/Exception
    //   406	416	435	java/lang/Exception
    //   422	429	435	java/lang/Exception
    //   501	507	435	java/lang/Exception
    //   513	522	435	java/lang/Exception
    //   528	539	435	java/lang/Exception
    //   545	555	435	java/lang/Exception
    //   561	569	435	java/lang/Exception
    //   478	484	487	java/lang/Exception
    //   81	91	572	finally
    //   100	117	572	finally
    //   123	130	572	finally
    //   148	158	572	finally
    //   167	178	572	finally
    //   184	194	572	finally
    //   227	234	572	finally
    //   243	263	572	finally
    //   269	287	572	finally
    //   293	331	572	finally
    //   348	358	572	finally
    //   364	382	572	finally
    //   388	395	572	finally
    //   406	416	572	finally
    //   422	429	572	finally
    //   501	507	572	finally
    //   513	522	572	finally
    //   528	539	572	finally
    //   545	555	572	finally
    //   561	569	572	finally
    //   199	206	601	java/lang/Exception
    //   211	218	609	java/lang/Exception
    //   443	464	617	org/json/JSONException
    //   439	443	625	finally
    //   443	464	625	finally
    //   618	622	625	finally
    //   468	474	634	java/lang/Exception
    //   582	589	642	java/lang/Exception
    //   593	599	650	java/lang/Exception
    //   42	65	658	finally
    //   42	65	668	java/lang/Exception
  }
  
  /* Error */
  private JSONObject getSelectContact(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: new 96	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 216	org/json/JSONObject:<init>	()V
    //   15: astore 7
    //   17: getstatic 225	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 72	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:mContext	Landroid/content/Context;
    //   25: invokevirtual 231	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload_3
    //   29: aconst_null
    //   30: ldc_w 301
    //   33: iconst_1
    //   34: anewarray 209	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 237	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 243 1 0
    //   54: ifeq +411 -> 465
    //   57: aload_0
    //   58: aload_2
    //   59: aload_2
    //   60: ldc 245
    //   62: invokeinterface 249 2 0
    //   67: invokeinterface 253 2 0
    //   72: invokevirtual 273	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_3
    //   76: aload_2
    //   77: aload_2
    //   78: ldc_w 275
    //   81: invokeinterface 249 2 0
    //   86: invokeinterface 279 2 0
    //   91: ifle +369 -> 460
    //   94: aload_0
    //   95: getfield 72	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:mContext	Landroid/content/Context;
    //   98: invokevirtual 231	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   101: getstatic 284	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   104: aconst_null
    //   105: new 196	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 286
    //   115: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokevirtual 237	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore_1
    //   131: aload_1
    //   132: astore 5
    //   134: aload_1
    //   135: astore 4
    //   137: aload_1
    //   138: invokeinterface 243 1 0
    //   143: ifeq +314 -> 457
    //   146: aload_1
    //   147: astore 5
    //   149: aload_1
    //   150: astore 4
    //   152: aload_0
    //   153: aload_1
    //   154: aload_1
    //   155: ldc_w 288
    //   158: invokeinterface 249 2 0
    //   163: invokeinterface 253 2 0
    //   168: invokevirtual 292	com/tencent/mobileqq/vaswebviewplugin/QWalletGetContactJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 6
    //   173: aload_1
    //   174: astore 5
    //   176: aload_1
    //   177: astore 4
    //   179: aload 6
    //   181: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +65 -> 249
    //   187: aload_1
    //   188: astore 5
    //   190: aload_1
    //   191: astore 4
    //   193: aload_3
    //   194: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +52 -> 249
    //   200: aload_1
    //   201: astore 5
    //   203: aload_1
    //   204: astore 4
    //   206: aload 7
    //   208: ldc_w 264
    //   211: iconst_0
    //   212: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload_1
    //   217: astore 5
    //   219: aload_1
    //   220: astore 4
    //   222: aload 7
    //   224: ldc_w 294
    //   227: aload_3
    //   228: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload_1
    //   233: astore 5
    //   235: aload_1
    //   236: astore 4
    //   238: aload 7
    //   240: ldc_w 296
    //   243: aload 6
    //   245: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   248: pop
    //   249: aload_2
    //   250: ifnull +9 -> 259
    //   253: aload_2
    //   254: invokeinterface 270 1 0
    //   259: aload_1
    //   260: ifnull +9 -> 269
    //   263: aload_1
    //   264: invokeinterface 270 1 0
    //   269: aload 7
    //   271: areturn
    //   272: astore_2
    //   273: aload_2
    //   274: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   277: goto -18 -> 259
    //   280: astore_1
    //   281: aload_1
    //   282: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   285: aload 7
    //   287: areturn
    //   288: astore_3
    //   289: aconst_null
    //   290: astore_1
    //   291: aload_3
    //   292: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   295: aload 7
    //   297: ldc_w 264
    //   300: iconst_m1
    //   301: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   304: pop
    //   305: aload 7
    //   307: ldc_w 294
    //   310: ldc_w 303
    //   313: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload 7
    //   319: ldc_w 296
    //   322: ldc_w 303
    //   325: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload_2
    //   330: ifnull +9 -> 339
    //   333: aload_2
    //   334: invokeinterface 270 1 0
    //   339: aload_1
    //   340: ifnull -71 -> 269
    //   343: aload_1
    //   344: invokeinterface 270 1 0
    //   349: aload 7
    //   351: areturn
    //   352: astore_1
    //   353: aload_1
    //   354: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   357: aload 7
    //   359: areturn
    //   360: astore_3
    //   361: aload_3
    //   362: invokevirtual 193	org/json/JSONException:printStackTrace	()V
    //   365: goto -36 -> 329
    //   368: astore 4
    //   370: aload_1
    //   371: astore_3
    //   372: aload 4
    //   374: astore_1
    //   375: aload_2
    //   376: ifnull +9 -> 385
    //   379: aload_2
    //   380: invokeinterface 270 1 0
    //   385: aload_3
    //   386: ifnull +9 -> 395
    //   389: aload_3
    //   390: invokeinterface 270 1 0
    //   395: aload_1
    //   396: athrow
    //   397: astore_2
    //   398: aload_2
    //   399: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   402: goto -63 -> 339
    //   405: astore_2
    //   406: aload_2
    //   407: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   410: goto -25 -> 385
    //   413: astore_2
    //   414: aload_2
    //   415: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   418: goto -23 -> 395
    //   421: astore_1
    //   422: aconst_null
    //   423: astore_2
    //   424: aload 4
    //   426: astore_3
    //   427: goto -52 -> 375
    //   430: astore_1
    //   431: aload 4
    //   433: astore_3
    //   434: goto -59 -> 375
    //   437: astore_1
    //   438: aload 5
    //   440: astore_3
    //   441: goto -66 -> 375
    //   444: astore_3
    //   445: aconst_null
    //   446: astore_1
    //   447: goto -156 -> 291
    //   450: astore_3
    //   451: aload 4
    //   453: astore_1
    //   454: goto -163 -> 291
    //   457: goto -284 -> 173
    //   460: aconst_null
    //   461: astore_1
    //   462: goto -289 -> 173
    //   465: aconst_null
    //   466: astore_3
    //   467: aconst_null
    //   468: astore_1
    //   469: goto -296 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	QWalletGetContactJsPlugin
    //   0	472	1	paramString	String
    //   1	253	2	localObject1	Object
    //   272	108	2	localException1	java.lang.Exception
    //   397	2	2	localException2	java.lang.Exception
    //   405	2	2	localException3	java.lang.Exception
    //   413	2	2	localException4	java.lang.Exception
    //   423	1	2	localObject2	Object
    //   20	208	3	localObject3	Object
    //   288	4	3	localException5	java.lang.Exception
    //   360	2	3	localJSONException	JSONException
    //   371	70	3	localObject4	Object
    //   444	1	3	localException6	java.lang.Exception
    //   450	1	3	localException7	java.lang.Exception
    //   466	1	3	localObject5	Object
    //   3	234	4	str1	String
    //   368	84	4	localObject6	Object
    //   132	307	5	str2	String
    //   6	238	6	str3	String
    //   15	343	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   253	259	272	java/lang/Exception
    //   263	269	280	java/lang/Exception
    //   17	46	288	java/lang/Exception
    //   343	349	352	java/lang/Exception
    //   295	329	360	org/json/JSONException
    //   291	295	368	finally
    //   295	329	368	finally
    //   361	365	368	finally
    //   333	339	397	java/lang/Exception
    //   379	385	405	java/lang/Exception
    //   389	395	413	java/lang/Exception
    //   17	46	421	finally
    //   48	131	430	finally
    //   137	146	437	finally
    //   152	173	437	finally
    //   179	187	437	finally
    //   193	200	437	finally
    //   206	216	437	finally
    //   222	232	437	finally
    //   238	249	437	finally
    //   48	131	444	java/lang/Exception
    //   137	146	450	java/lang/Exception
    //   152	173	450	java/lang/Exception
    //   179	187	450	java/lang/Exception
    //   193	200	450	java/lang/Exception
    //   206	216	450	java/lang/Exception
    //   222	232	450	java/lang/Exception
    //   238	249	450	java/lang/Exception
  }
  
  private boolean openContact()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.PICK");
    localIntent.setData(ContactsContract.Contacts.CONTENT_URI);
    super.startActivityForResult(localIntent, (byte)16);
    return true;
  }
  
  private void parseCallback(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.toLowerCase().indexOf("callback") < 0)) {
      return;
    }
    try
    {
      this.mCallback = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void dochooseQQFriendsForTransferResult(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "{\"resultCode\":-1}";
    }
    doCallback(str.toString());
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.mContext == null)) {}
    do
    {
      return false;
      paramJsBridgeListener = comboApiName(paramString2, paramString3);
    } while ((!"qw_charge_getSelectContact".equals(paramJsBridgeListener)) && (!"qw_charge_getAllContact".equals(paramJsBridgeListener)) && (!"qw_charge_gotoQWalletHome".equals(paramJsBridgeListener)) && (!"qw_charge_qqpimsecure_safe_isopen_securitypay".equals(paramJsBridgeListener)) && (!"qw_charge_tenpayTransfer".equals(paramJsBridgeListener)));
    QQToast.a(this.mContext, 2131364497, 0).a();
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte == 16) && (paramInt == -1) && (paramIntent != null) && (paramIntent.getData() != null))
    {
      String str = paramIntent.getData().getLastPathSegment();
      if ((str != null) && (str.length() > 0)) {
        new QWalletGetContactJsPlugin.SelectContactTask(this).execute(new String[] { str });
      }
    }
    if (paramByte == REQUESTCODE_TRANSFER)
    {
      if (paramIntent == null) {
        dochooseQQFriendsForTransferResult(null);
      }
    }
    else {
      return;
    }
    dochooseQQFriendsForTransferResult(paramIntent.getStringExtra("result"));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
      this.mContext = this.mRuntime.a().getApplicationContext();
    }
  }
  
  public String trimPhoneName(String paramString)
  {
    int j = 0;
    if ((paramString == null) || (paramString.equals(""))) {
      localObject = "";
    }
    String str;
    int i;
    do
    {
      return localObject;
      str = "";
      i = 0;
      localObject = str;
    } while (j >= paramString.length());
    if (i >= 10) {
      return str + "...";
    }
    Object localObject = paramString.substring(j, j + 1);
    if (((String)localObject).matches("[Α-￥]")) {
      i += 2;
    }
    for (;;)
    {
      str = str + (String)localObject;
      j += 1;
      break;
      i += 1;
    }
  }
  
  public String trimPhoneNumPre(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("+86"))
      {
        if (paramString.length() == 3) {
          return "";
        }
        str = paramString;
        if (paramString.length() > 3)
        {
          str = paramString;
          if (paramString.startsWith("+86")) {
            str = paramString.substring(3);
          }
        }
      }
      str = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
      paramString = str;
    } while (str.length() <= 11);
    return str.subSequence(str.length() - 11, str.length()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletGetContactJsPlugin
 * JD-Core Version:    0.7.0.1
 */