package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import ccg;
import cch;
import cci;
import ccj;
import cck;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseHornListActivity
  extends IphoneTitleBarActivity
  implements FaceDecoder.DecodeTaskCompletionListener
{
  static final int jdField_a_of_type_Int = 0;
  static final long jdField_a_of_type_Long = 1000L;
  protected static boolean a = false;
  static final int b = 1;
  static final int c = 0;
  public static final String c = "http://imgcache.qq.com/club/horn/rel/myComment.html?_bid=179&uin=%1$s&pvsrc=nearby&_wv=5123";
  static final int d = 1;
  public static final String d = "http://imgcache.qq.com/club/horn/rel/comment.html?hornKey=%1$s&_bid=179&uin=%2$s&pvsrc=nearby&_wv=5123";
  static final int e = 0;
  static final int f = 1;
  static final int g = 2;
  static final int h = 3;
  static final int i = 4;
  public static final int j = 210000;
  public static final int k = 210001;
  public static final int l = 100351;
  public static final int m = 100352;
  public static final int n = 100353;
  public static final int o = 100354;
  public static final int p = 100355;
  private static final int q = 0;
  private static final int r = 1;
  private static final int s = 2;
  protected float a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Context a;
  protected BitmapDrawable a;
  public LayoutInflater a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ccg(this);
  public View a;
  protected ListView a;
  protected TextView a;
  public ccj a;
  public BaseHornListActivity.BaseHornAdapter a;
  public NearHornHandler a;
  public HornDetail a;
  protected FaceDecoder a;
  public String a;
  public List a;
  public String b;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public BaseHornListActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ccj = new ccj(this);
  }
  
  public static String a(String paramString)
  {
    int i2 = 1;
    if ((paramString == null) || ("".equals(paramString))) {
      return paramString;
    }
    paramString = new StringBuffer(paramString);
    while ((paramString.length() > 0) && (Character.isWhitespace(paramString.charAt(0)))) {
      paramString.deleteCharAt(0);
    }
    for (int i1 = paramString.length();; i1 = paramString.length())
    {
      if ((i1 <= 0) || (!Character.isWhitespace(paramString.charAt(i1 - 1))) || ((i1 > 1) && (paramString.charAt(i1 - 2) == '\024')))
      {
        if (i1 <= 1) {
          break;
        }
        while (i2 < i1)
        {
          if ((paramString.charAt(i2) == '\n') && (paramString.charAt(i2 - 1) != '\024')) {
            paramString.replace(i2, i2 + 1, " ");
          }
          i2 += 1;
        }
      }
      paramString.deleteCharAt(i1 - 1);
    }
    return paramString.toString();
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: new 134	java/io/ObjectInputStream
    //   3: dup
    //   4: aload_0
    //   5: aload_0
    //   6: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   9: getfield 140	com/tencent/mobileqq/app/NearHornHandler:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   12: invokevirtual 144	com/tencent/mobileqq/activity/BaseHornListActivity:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: invokespecial 147	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   25: aload_2
    //   26: invokevirtual 151	java/io/ObjectInputStream:readBoolean	()Z
    //   29: invokestatic 157	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: putfield 160	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   41: aload_2
    //   42: invokevirtual 151	java/io/ObjectInputStream:readBoolean	()Z
    //   45: invokestatic 157	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: putfield 162	com/tencent/mobileqq/app/NearHornHandler:b	Ljava/lang/Boolean;
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   57: aload_2
    //   58: invokevirtual 151	java/io/ObjectInputStream:readBoolean	()Z
    //   61: invokestatic 157	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   64: putfield 164	com/tencent/mobileqq/app/NearHornHandler:jdField_c_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   73: aload_2
    //   74: invokevirtual 151	java/io/ObjectInputStream:readBoolean	()Z
    //   77: invokestatic 157	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: putfield 166	com/tencent/mobileqq/app/NearHornHandler:jdField_d_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   83: aload_2
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   89: aload_2
    //   90: invokevirtual 169	java/io/ObjectInputStream:readInt	()I
    //   93: putfield 171	com/tencent/mobileqq/app/NearHornHandler:jdField_d_of_type_Int	I
    //   96: aload_2
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   102: aload_2
    //   103: invokevirtual 169	java/io/ObjectInputStream:readInt	()I
    //   106: putfield 173	com/tencent/mobileqq/app/NearHornHandler:jdField_e_of_type_Int	I
    //   109: aload_2
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   115: aload_2
    //   116: invokevirtual 169	java/io/ObjectInputStream:readInt	()I
    //   119: putfield 175	com/tencent/mobileqq/app/NearHornHandler:jdField_f_of_type_Int	I
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   128: aload_2
    //   129: invokevirtual 169	java/io/ObjectInputStream:readInt	()I
    //   132: putfield 177	com/tencent/mobileqq/app/NearHornHandler:jdField_g_of_type_Int	I
    //   135: aload_2
    //   136: astore_1
    //   137: aload_0
    //   138: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   141: aload_2
    //   142: invokevirtual 169	java/io/ObjectInputStream:readInt	()I
    //   145: putfield 179	com/tencent/mobileqq/app/NearHornHandler:i	I
    //   148: aload_2
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   154: aload_2
    //   155: invokevirtual 169	java/io/ObjectInputStream:readInt	()I
    //   158: putfield 181	com/tencent/mobileqq/app/NearHornHandler:h	I
    //   161: aload_2
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   167: aload_2
    //   168: invokevirtual 185	java/io/ObjectInputStream:readLong	()J
    //   171: putfield 187	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_Long	J
    //   174: aload_2
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   180: aload_2
    //   181: invokevirtual 190	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   184: putfield 192	com/tencent/mobileqq/app/NearHornHandler:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload_2
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   193: aload_2
    //   194: invokevirtual 190	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   197: putfield 194	com/tencent/mobileqq/app/NearHornHandler:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   200: aload_2
    //   201: astore_1
    //   202: aload_0
    //   203: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   206: aload_2
    //   207: invokevirtual 190	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   210: putfield 196	com/tencent/mobileqq/app/NearHornHandler:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   213: aload_2
    //   214: astore_1
    //   215: aload_0
    //   216: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   219: aload_2
    //   220: invokevirtual 190	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   223: putfield 198	com/tencent/mobileqq/app/NearHornHandler:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   226: aload_2
    //   227: astore_1
    //   228: aload_0
    //   229: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   232: aload_2
    //   233: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   236: checkcast 204	com/tencent/mobileqq/data/HornDetail
    //   239: putfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   242: aload_2
    //   243: astore_1
    //   244: aload_0
    //   245: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   248: getfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   251: ifnull +40 -> 291
    //   254: aload_2
    //   255: astore_1
    //   256: aload_0
    //   257: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   260: getfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   263: new 208	com/tencent/mobileqq/text/QQText
    //   266: dup
    //   267: aload_0
    //   268: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   271: getfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   274: getfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   277: invokeinterface 215 1 0
    //   282: iconst_3
    //   283: bipush 20
    //   285: invokespecial 218	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   288: putfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   291: aload_2
    //   292: astore_1
    //   293: aload_0
    //   294: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   297: aload_2
    //   298: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   301: checkcast 220	java/util/List
    //   304: putfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   307: aload_2
    //   308: astore_1
    //   309: aload_0
    //   310: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   313: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   316: ifnull +88 -> 404
    //   319: aload_2
    //   320: astore_1
    //   321: aload_0
    //   322: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   325: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   328: invokeinterface 226 1 0
    //   333: astore_3
    //   334: aload_2
    //   335: astore_1
    //   336: aload_3
    //   337: invokeinterface 231 1 0
    //   342: ifeq +62 -> 404
    //   345: aload_2
    //   346: astore_1
    //   347: aload_3
    //   348: invokeinterface 234 1 0
    //   353: checkcast 204	com/tencent/mobileqq/data/HornDetail
    //   356: astore 4
    //   358: aload_2
    //   359: astore_1
    //   360: aload 4
    //   362: new 208	com/tencent/mobileqq/text/QQText
    //   365: dup
    //   366: aload 4
    //   368: getfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   371: invokeinterface 215 1 0
    //   376: iconst_3
    //   377: bipush 20
    //   379: invokespecial 218	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   382: putfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   385: goto -51 -> 334
    //   388: astore_3
    //   389: aload_2
    //   390: astore_1
    //   391: aload_3
    //   392: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   395: aload_2
    //   396: ifnull +7 -> 403
    //   399: aload_2
    //   400: invokevirtual 240	java/io/ObjectInputStream:close	()V
    //   403: return
    //   404: aload_2
    //   405: astore_1
    //   406: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +42 -> 451
    //   412: aload_2
    //   413: astore_1
    //   414: ldc 247
    //   416: iconst_2
    //   417: new 249	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   424: ldc 252
    //   426: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_0
    //   430: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   433: getfield 140	com/tencent/mobileqq/app/NearHornHandler:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   436: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 258
    //   442: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 262	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload_2
    //   452: astore_1
    //   453: iconst_1
    //   454: putstatic 66	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_Boolean	Z
    //   457: aload_2
    //   458: ifnull -55 -> 403
    //   461: aload_2
    //   462: invokevirtual 240	java/io/ObjectInputStream:close	()V
    //   465: return
    //   466: astore_1
    //   467: aload_1
    //   468: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   471: return
    //   472: astore_1
    //   473: aload_1
    //   474: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   477: return
    //   478: astore_3
    //   479: aconst_null
    //   480: astore_2
    //   481: aload_2
    //   482: astore_1
    //   483: aload_3
    //   484: invokevirtual 263	java/lang/ClassNotFoundException:printStackTrace	()V
    //   487: aload_2
    //   488: ifnull -85 -> 403
    //   491: aload_2
    //   492: invokevirtual 240	java/io/ObjectInputStream:close	()V
    //   495: return
    //   496: astore_1
    //   497: aload_1
    //   498: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   501: return
    //   502: astore_2
    //   503: aconst_null
    //   504: astore_1
    //   505: aload_1
    //   506: ifnull +7 -> 513
    //   509: aload_1
    //   510: invokevirtual 240	java/io/ObjectInputStream:close	()V
    //   513: aload_2
    //   514: athrow
    //   515: astore_1
    //   516: aload_1
    //   517: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   520: goto -7 -> 513
    //   523: astore_2
    //   524: goto -19 -> 505
    //   527: astore_3
    //   528: goto -47 -> 481
    //   531: astore_3
    //   532: aconst_null
    //   533: astore_2
    //   534: goto -145 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	BaseHornListActivity
    //   20	433	1	localObjectInputStream1	java.io.ObjectInputStream
    //   466	2	1	localIOException1	java.io.IOException
    //   472	2	1	localIOException2	java.io.IOException
    //   482	1	1	localObjectInputStream2	java.io.ObjectInputStream
    //   496	2	1	localIOException3	java.io.IOException
    //   504	6	1	localObject1	Object
    //   515	2	1	localIOException4	java.io.IOException
    //   18	474	2	localObjectInputStream3	java.io.ObjectInputStream
    //   502	12	2	localObject2	Object
    //   523	1	2	localObject3	Object
    //   533	1	2	localObject4	Object
    //   333	15	3	localIterator	Iterator
    //   388	4	3	localIOException5	java.io.IOException
    //   478	6	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   527	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   531	1	3	localIOException6	java.io.IOException
    //   356	11	4	localHornDetail	HornDetail
    // Exception table:
    //   from	to	target	type
    //   21	35	388	java/io/IOException
    //   37	51	388	java/io/IOException
    //   53	67	388	java/io/IOException
    //   69	83	388	java/io/IOException
    //   85	96	388	java/io/IOException
    //   98	109	388	java/io/IOException
    //   111	122	388	java/io/IOException
    //   124	135	388	java/io/IOException
    //   137	148	388	java/io/IOException
    //   150	161	388	java/io/IOException
    //   163	174	388	java/io/IOException
    //   176	187	388	java/io/IOException
    //   189	200	388	java/io/IOException
    //   202	213	388	java/io/IOException
    //   215	226	388	java/io/IOException
    //   228	242	388	java/io/IOException
    //   244	254	388	java/io/IOException
    //   256	291	388	java/io/IOException
    //   293	307	388	java/io/IOException
    //   309	319	388	java/io/IOException
    //   321	334	388	java/io/IOException
    //   336	345	388	java/io/IOException
    //   347	358	388	java/io/IOException
    //   360	385	388	java/io/IOException
    //   406	412	388	java/io/IOException
    //   414	451	388	java/io/IOException
    //   453	457	388	java/io/IOException
    //   461	465	466	java/io/IOException
    //   399	403	472	java/io/IOException
    //   0	19	478	java/lang/ClassNotFoundException
    //   491	495	496	java/io/IOException
    //   0	19	502	finally
    //   509	513	515	java/io/IOException
    //   21	35	523	finally
    //   37	51	523	finally
    //   53	67	523	finally
    //   69	83	523	finally
    //   85	96	523	finally
    //   98	109	523	finally
    //   111	122	523	finally
    //   124	135	523	finally
    //   137	148	523	finally
    //   150	161	523	finally
    //   163	174	523	finally
    //   176	187	523	finally
    //   189	200	523	finally
    //   202	213	523	finally
    //   215	226	523	finally
    //   228	242	523	finally
    //   244	254	523	finally
    //   256	291	523	finally
    //   293	307	523	finally
    //   309	319	523	finally
    //   321	334	523	finally
    //   336	345	523	finally
    //   347	358	523	finally
    //   360	385	523	finally
    //   391	395	523	finally
    //   406	412	523	finally
    //   414	451	523	finally
    //   453	457	523	finally
    //   483	487	523	finally
    //   21	35	527	java/lang/ClassNotFoundException
    //   37	51	527	java/lang/ClassNotFoundException
    //   53	67	527	java/lang/ClassNotFoundException
    //   69	83	527	java/lang/ClassNotFoundException
    //   85	96	527	java/lang/ClassNotFoundException
    //   98	109	527	java/lang/ClassNotFoundException
    //   111	122	527	java/lang/ClassNotFoundException
    //   124	135	527	java/lang/ClassNotFoundException
    //   137	148	527	java/lang/ClassNotFoundException
    //   150	161	527	java/lang/ClassNotFoundException
    //   163	174	527	java/lang/ClassNotFoundException
    //   176	187	527	java/lang/ClassNotFoundException
    //   189	200	527	java/lang/ClassNotFoundException
    //   202	213	527	java/lang/ClassNotFoundException
    //   215	226	527	java/lang/ClassNotFoundException
    //   228	242	527	java/lang/ClassNotFoundException
    //   244	254	527	java/lang/ClassNotFoundException
    //   256	291	527	java/lang/ClassNotFoundException
    //   293	307	527	java/lang/ClassNotFoundException
    //   309	319	527	java/lang/ClassNotFoundException
    //   321	334	527	java/lang/ClassNotFoundException
    //   336	345	527	java/lang/ClassNotFoundException
    //   347	358	527	java/lang/ClassNotFoundException
    //   360	385	527	java/lang/ClassNotFoundException
    //   406	412	527	java/lang/ClassNotFoundException
    //   414	451	527	java/lang/ClassNotFoundException
    //   453	457	527	java/lang/ClassNotFoundException
    //   0	19	531	java/io/IOException
  }
  
  protected Boolean a(int paramInt, String paramString)
  {
    Boolean localBoolean1 = Boolean.valueOf(false);
    if (QLog.isColorLevel()) {
      QLog.i("NearHornRelated", 2, "publishTime is:" + this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_Long + "| valid time is:" + this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.i * 60 + "|current Time is:" + System.currentTimeMillis() / 1000L);
    }
    boolean bool;
    Boolean localBoolean2;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_Long + this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.i * 60 < System.currentTimeMillis() / 1000L)
    {
      bool = true;
      localBoolean2 = Boolean.valueOf(bool);
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject1 = localBoolean1;
      if (!localBoolean2.booleanValue())
      {
        if (paramInt != 0) {
          break label219;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
        } while (!((HornDetail)paramString.next()).uin.equals(localObject2));
      }
    }
    for (paramString = Boolean.valueOf(true);; paramString = localBoolean1)
    {
      localObject1 = paramString;
      for (;;)
      {
        if ((localBoolean2.booleanValue()) || (!((Boolean)localObject1).booleanValue())) {
          break label285;
        }
        return Boolean.valueOf(true);
        bool = false;
        break;
        label219:
        localObject1 = localBoolean1;
        if (paramInt == 1)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            localObject1 = localBoolean1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (!((HornDetail)((Iterator)localObject2).next()).hornKey.equals(paramString));
          localObject1 = Boolean.valueOf(true);
        }
      }
      label285:
      return Boolean.valueOf(false);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130839181);
    this.jdField_a_of_type_AndroidWidgetTextView.setHeight((int)(35.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetTextView, null, false);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramInt, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_AndroidWidgetListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (cck)((View)localObject).getTag();
          if ((localObject != null) && (paramString.equals(((cck)localObject).jdField_a_of_type_JavaLangString))) {
            ((cck)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqDataHornDetail == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.uin))) {
          break;
        }
        ((cck)this.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramCharSequence, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
  }
  
  protected void a(String paramString)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    localFrameLayout.setBackgroundResource(2130839181);
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setId(2131230821);
    localFrameLayout.addView(localTextView, new FrameLayout.LayoutParams(-1, -2));
    localTextView.setPadding((int)(15.0F * this.jdField_a_of_type_Float), (int)(32.0F * this.jdField_a_of_type_Float), 0, (int)(8.0F * this.jdField_a_of_type_Float));
    localTextView.setTextColor(getResources().getColor(2131361872));
    localTextView.setTextSize(14.0F);
    localTextView.setGravity(19);
    localTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localFrameLayout, null, false);
  }
  
  public void a(String paramString, int paramInt, ImageView paramImageView)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false, (byte)1);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
      }
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
  
  protected void b()
  {
    this.p.setVisibility(0);
    this.p.setImageResource(2130838009);
    this.p.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.p.setContentDescription("更多操作按钮，点击展开");
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 1)
    {
      super.setResult(1);
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler = ((NearHornHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(31));
    if ((paramBundle != null) && (!jdField_a_of_type_Boolean)) {
      e();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    super.doOnDestroy();
    Utils.a();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && ((this.jdField_a_of_type_AndroidAppDialog instanceof ActionSheet)))
    {
      ((ActionSheet)this.jdField_a_of_type_AndroidAppDialog).a();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler = null;
  }
  
  /* Error */
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 539	com/tencent/mobileqq/app/IphoneTitleBarActivity:doOnSaveInstanceState	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   9: ifnull +388 -> 397
    //   12: new 541	java/io/ObjectOutputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 303	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   24: getfield 140	com/tencent/mobileqq/app/NearHornHandler:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   27: iconst_0
    //   28: invokevirtual 545	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   31: invokespecial 548	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   42: getfield 160	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   45: invokevirtual 293	java/lang/Boolean:booleanValue	()Z
    //   48: invokevirtual 552	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: aload_0
    //   55: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   58: getfield 162	com/tencent/mobileqq/app/NearHornHandler:b	Ljava/lang/Boolean;
    //   61: invokevirtual 293	java/lang/Boolean:booleanValue	()Z
    //   64: invokevirtual 552	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_2
    //   70: aload_0
    //   71: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   74: getfield 164	com/tencent/mobileqq/app/NearHornHandler:jdField_c_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   77: invokevirtual 293	java/lang/Boolean:booleanValue	()Z
    //   80: invokevirtual 552	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   83: aload_2
    //   84: astore_1
    //   85: aload_2
    //   86: aload_0
    //   87: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   90: getfield 166	com/tencent/mobileqq/app/NearHornHandler:jdField_d_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   93: invokevirtual 293	java/lang/Boolean:booleanValue	()Z
    //   96: invokevirtual 552	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   106: getfield 171	com/tencent/mobileqq/app/NearHornHandler:jdField_d_of_type_Int	I
    //   109: invokevirtual 555	java/io/ObjectOutputStream:writeInt	(I)V
    //   112: aload_2
    //   113: astore_1
    //   114: aload_2
    //   115: aload_0
    //   116: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   119: getfield 173	com/tencent/mobileqq/app/NearHornHandler:jdField_e_of_type_Int	I
    //   122: invokevirtual 555	java/io/ObjectOutputStream:writeInt	(I)V
    //   125: aload_2
    //   126: astore_1
    //   127: aload_2
    //   128: aload_0
    //   129: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   132: getfield 175	com/tencent/mobileqq/app/NearHornHandler:jdField_f_of_type_Int	I
    //   135: invokevirtual 555	java/io/ObjectOutputStream:writeInt	(I)V
    //   138: aload_2
    //   139: astore_1
    //   140: aload_2
    //   141: aload_0
    //   142: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   145: getfield 177	com/tencent/mobileqq/app/NearHornHandler:jdField_g_of_type_Int	I
    //   148: invokevirtual 555	java/io/ObjectOutputStream:writeInt	(I)V
    //   151: aload_2
    //   152: astore_1
    //   153: aload_2
    //   154: aload_0
    //   155: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   158: getfield 179	com/tencent/mobileqq/app/NearHornHandler:i	I
    //   161: invokevirtual 555	java/io/ObjectOutputStream:writeInt	(I)V
    //   164: aload_2
    //   165: astore_1
    //   166: aload_2
    //   167: aload_0
    //   168: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   171: getfield 181	com/tencent/mobileqq/app/NearHornHandler:h	I
    //   174: invokevirtual 555	java/io/ObjectOutputStream:writeInt	(I)V
    //   177: aload_2
    //   178: astore_1
    //   179: aload_2
    //   180: aload_0
    //   181: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   184: getfield 187	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_Long	J
    //   187: invokevirtual 559	java/io/ObjectOutputStream:writeLong	(J)V
    //   190: aload_2
    //   191: astore_1
    //   192: aload_2
    //   193: aload_0
    //   194: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   197: getfield 192	com/tencent/mobileqq/app/NearHornHandler:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   200: invokevirtual 562	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   203: aload_2
    //   204: astore_1
    //   205: aload_2
    //   206: aload_0
    //   207: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   210: getfield 194	com/tencent/mobileqq/app/NearHornHandler:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   213: invokevirtual 562	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   216: aload_2
    //   217: astore_1
    //   218: aload_2
    //   219: aload_0
    //   220: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   223: getfield 196	com/tencent/mobileqq/app/NearHornHandler:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   226: invokevirtual 562	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   229: aload_2
    //   230: astore_1
    //   231: aload_2
    //   232: aload_0
    //   233: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   236: getfield 198	com/tencent/mobileqq/app/NearHornHandler:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   239: invokevirtual 562	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: astore_1
    //   244: aload_0
    //   245: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   248: getfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   251: ifnull +30 -> 281
    //   254: aload_2
    //   255: astore_1
    //   256: aload_0
    //   257: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   260: getfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   263: aload_0
    //   264: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   267: getfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   270: getfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   273: invokeinterface 215 1 0
    //   278: putfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   281: aload_2
    //   282: astore_1
    //   283: aload_2
    //   284: aload_0
    //   285: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   288: getfield 206	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_ComTencentMobileqqDataHornDetail	Lcom/tencent/mobileqq/data/HornDetail;
    //   291: invokevirtual 566	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   294: aload_2
    //   295: astore_1
    //   296: aload_0
    //   297: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   300: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   303: ifnull +95 -> 398
    //   306: aload_2
    //   307: astore_1
    //   308: aload_0
    //   309: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   312: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   315: invokeinterface 569 1 0
    //   320: ifle +78 -> 398
    //   323: aload_2
    //   324: astore_1
    //   325: aload_0
    //   326: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   329: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   332: invokeinterface 226 1 0
    //   337: astore_3
    //   338: aload_2
    //   339: astore_1
    //   340: aload_3
    //   341: invokeinterface 231 1 0
    //   346: ifeq +52 -> 398
    //   349: aload_2
    //   350: astore_1
    //   351: aload_3
    //   352: invokeinterface 234 1 0
    //   357: checkcast 204	com/tencent/mobileqq/data/HornDetail
    //   360: astore 4
    //   362: aload_2
    //   363: astore_1
    //   364: aload 4
    //   366: aload 4
    //   368: getfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   371: invokeinterface 215 1 0
    //   376: putfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   379: goto -41 -> 338
    //   382: astore_3
    //   383: aload_2
    //   384: astore_1
    //   385: aload_3
    //   386: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   389: aload_2
    //   390: ifnull +7 -> 397
    //   393: aload_2
    //   394: invokevirtual 570	java/io/ObjectOutputStream:close	()V
    //   397: return
    //   398: aload_2
    //   399: astore_1
    //   400: aload_2
    //   401: aload_0
    //   402: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   405: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   408: invokevirtual 566	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   411: aload_2
    //   412: astore_1
    //   413: aload_2
    //   414: invokevirtual 573	java/io/ObjectOutputStream:flush	()V
    //   417: aload_2
    //   418: astore_1
    //   419: aload_0
    //   420: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   423: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   426: ifnull +104 -> 530
    //   429: aload_2
    //   430: astore_1
    //   431: aload_0
    //   432: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   435: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   438: invokeinterface 569 1 0
    //   443: ifle +87 -> 530
    //   446: aload_2
    //   447: astore_1
    //   448: aload_0
    //   449: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   452: getfield 222	com/tencent/mobileqq/app/NearHornHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   455: invokeinterface 226 1 0
    //   460: astore_3
    //   461: aload_2
    //   462: astore_1
    //   463: aload_3
    //   464: invokeinterface 231 1 0
    //   469: ifeq +61 -> 530
    //   472: aload_2
    //   473: astore_1
    //   474: aload_3
    //   475: invokeinterface 234 1 0
    //   480: checkcast 204	com/tencent/mobileqq/data/HornDetail
    //   483: astore 4
    //   485: aload_2
    //   486: astore_1
    //   487: aload 4
    //   489: new 208	com/tencent/mobileqq/text/QQText
    //   492: dup
    //   493: aload 4
    //   495: getfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   498: invokeinterface 215 1 0
    //   503: iconst_3
    //   504: bipush 20
    //   506: invokespecial 218	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   509: putfield 212	com/tencent/mobileqq/data/HornDetail:content	Ljava/lang/CharSequence;
    //   512: goto -51 -> 461
    //   515: astore_3
    //   516: aload_1
    //   517: astore_2
    //   518: aload_3
    //   519: astore_1
    //   520: aload_2
    //   521: ifnull +7 -> 528
    //   524: aload_2
    //   525: invokevirtual 570	java/io/ObjectOutputStream:close	()V
    //   528: aload_1
    //   529: athrow
    //   530: aload_2
    //   531: astore_1
    //   532: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +43 -> 578
    //   538: aload_2
    //   539: astore_1
    //   540: ldc 247
    //   542: iconst_2
    //   543: new 249	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 575
    //   553: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: getfield 136	com/tencent/mobileqq/activity/BaseHornListActivity:jdField_a_of_type_ComTencentMobileqqAppNearHornHandler	Lcom/tencent/mobileqq/app/NearHornHandler;
    //   560: getfield 140	com/tencent/mobileqq/app/NearHornHandler:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   563: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: ldc_w 258
    //   569: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 262	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: aload_2
    //   579: ifnull -182 -> 397
    //   582: aload_2
    //   583: invokevirtual 570	java/io/ObjectOutputStream:close	()V
    //   586: return
    //   587: astore_1
    //   588: aload_1
    //   589: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   592: return
    //   593: astore_1
    //   594: aload_1
    //   595: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   598: return
    //   599: astore_2
    //   600: aload_2
    //   601: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   604: goto -76 -> 528
    //   607: astore_1
    //   608: aconst_null
    //   609: astore_2
    //   610: goto -90 -> 520
    //   613: astore_3
    //   614: aconst_null
    //   615: astore_2
    //   616: goto -233 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	BaseHornListActivity
    //   0	619	1	paramBundle	Bundle
    //   34	549	2	localObject1	Object
    //   599	2	2	localIOException1	java.io.IOException
    //   609	7	2	localObject2	Object
    //   337	15	3	localIterator1	Iterator
    //   382	4	3	localIOException2	java.io.IOException
    //   460	15	3	localIterator2	Iterator
    //   515	4	3	localObject3	Object
    //   613	1	3	localIOException3	java.io.IOException
    //   360	134	4	localHornDetail	HornDetail
    // Exception table:
    //   from	to	target	type
    //   37	51	382	java/io/IOException
    //   53	67	382	java/io/IOException
    //   69	83	382	java/io/IOException
    //   85	99	382	java/io/IOException
    //   101	112	382	java/io/IOException
    //   114	125	382	java/io/IOException
    //   127	138	382	java/io/IOException
    //   140	151	382	java/io/IOException
    //   153	164	382	java/io/IOException
    //   166	177	382	java/io/IOException
    //   179	190	382	java/io/IOException
    //   192	203	382	java/io/IOException
    //   205	216	382	java/io/IOException
    //   218	229	382	java/io/IOException
    //   231	242	382	java/io/IOException
    //   244	254	382	java/io/IOException
    //   256	281	382	java/io/IOException
    //   283	294	382	java/io/IOException
    //   296	306	382	java/io/IOException
    //   308	323	382	java/io/IOException
    //   325	338	382	java/io/IOException
    //   340	349	382	java/io/IOException
    //   351	362	382	java/io/IOException
    //   364	379	382	java/io/IOException
    //   400	411	382	java/io/IOException
    //   413	417	382	java/io/IOException
    //   419	429	382	java/io/IOException
    //   431	446	382	java/io/IOException
    //   448	461	382	java/io/IOException
    //   463	472	382	java/io/IOException
    //   474	485	382	java/io/IOException
    //   487	512	382	java/io/IOException
    //   532	538	382	java/io/IOException
    //   540	578	382	java/io/IOException
    //   37	51	515	finally
    //   53	67	515	finally
    //   69	83	515	finally
    //   85	99	515	finally
    //   101	112	515	finally
    //   114	125	515	finally
    //   127	138	515	finally
    //   140	151	515	finally
    //   153	164	515	finally
    //   166	177	515	finally
    //   179	190	515	finally
    //   192	203	515	finally
    //   205	216	515	finally
    //   218	229	515	finally
    //   231	242	515	finally
    //   244	254	515	finally
    //   256	281	515	finally
    //   283	294	515	finally
    //   296	306	515	finally
    //   308	323	515	finally
    //   325	338	515	finally
    //   340	349	515	finally
    //   351	362	515	finally
    //   364	379	515	finally
    //   385	389	515	finally
    //   400	411	515	finally
    //   413	417	515	finally
    //   419	429	515	finally
    //   431	446	515	finally
    //   448	461	515	finally
    //   463	472	515	finally
    //   474	485	515	finally
    //   487	512	515	finally
    //   532	538	515	finally
    //   540	578	515	finally
    //   582	586	587	java/io/IOException
    //   393	397	593	java/io/IOException
    //   524	528	599	java/io/IOException
    //   12	35	607	finally
    //   12	35	613	java/io/IOException
  }
  
  public void t_()
  {
    d();
    ActionSheet localActionSheet = ActionSheet.b(this);
    localActionSheet.c(2131562420);
    localActionSheet.c(2131562427);
    localActionSheet.d(2131561746);
    localActionSheet.a(new cch(this));
    localActionSheet.setOnDismissListener(new cci(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseHornListActivity
 * JD-Core Version:    0.7.0.1
 */