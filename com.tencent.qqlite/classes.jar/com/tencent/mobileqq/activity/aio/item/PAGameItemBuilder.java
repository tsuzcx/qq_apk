package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import bwa;
import bwb;
import bwc;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import org.json.JSONObject;

public class PAGameItemBuilder
  extends AbstractChatItemBuilder
{
  private static final long jdField_b_of_type_Long = 1000L;
  private long jdField_a_of_type_Long = 0L;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bwa(this);
  private final int[] jdField_a_of_type_ArrayOfInt = { 2130837562, 2130837563, 2130837564 };
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  
  public PAGameItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.b = new bwb(this);
  }
  
  private void a(Bundle paramBundle) {}
  
  /* Error */
  private void a(PAMessage.Item paramItem)
  {
    // Byte code:
    //   0: new 60	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: getfield 66	com/tencent/mobileqq/data/PAMessage$Item:a_rankListUrl	Ljava/lang/String;
    //   8: invokespecial 69	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 73	org/json/JSONObject:length	()I
    //   18: iconst_2
    //   19: if_icmpeq +4 -> 23
    //   22: return
    //   23: aload 4
    //   25: ldc 75
    //   27: invokevirtual 79	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_3
    //   31: aload_1
    //   32: aload 4
    //   34: ldc 80
    //   36: invokevirtual 79	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokestatic 86	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   42: i2l
    //   43: putfield 89	com/tencent/mobileqq/data/PAMessage$Item:appId	J
    //   46: new 91	android/os/Bundle
    //   49: dup
    //   50: invokespecial 94	android/os/Bundle:<init>	()V
    //   53: astore 4
    //   55: new 60	org/json/JSONObject
    //   58: dup
    //   59: aload_1
    //   60: getfield 97	com/tencent/mobileqq/data/PAMessage$Item:rankListDownload	Ljava/lang/String;
    //   63: invokespecial 69	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   66: astore 5
    //   68: aload 5
    //   70: invokevirtual 73	org/json/JSONObject:length	()I
    //   73: bipush 6
    //   75: if_icmpne +181 -> 256
    //   78: aload 4
    //   80: getstatic 101	com/tencent/open/downloadnew/DownloadConstants:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: aload 5
    //   85: ldc 80
    //   87: invokevirtual 79	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 105	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 4
    //   95: getstatic 108	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   98: aload 5
    //   100: ldc 110
    //   102: invokevirtual 79	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokevirtual 105	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 4
    //   110: getstatic 113	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   113: aload 5
    //   115: ldc 75
    //   117: invokevirtual 79	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 105	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload 4
    //   125: getstatic 116	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   128: aload 5
    //   130: ldc 118
    //   132: invokevirtual 79	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 105	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 4
    //   140: getstatic 121	com/tencent/open/downloadnew/DownloadConstants:d	Ljava/lang/String;
    //   143: aload 5
    //   145: ldc 123
    //   147: invokevirtual 126	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   150: invokevirtual 130	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   153: aload 4
    //   155: getstatic 132	com/tencent/open/downloadnew/DownloadConstants:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   158: aload 5
    //   160: ldc 134
    //   162: invokevirtual 79	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokevirtual 105	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_3
    //   169: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +84 -> 256
    //   175: aload_1
    //   176: getfield 89	com/tencent/mobileqq/data/PAMessage$Item:appId	J
    //   179: lconst_0
    //   180: lcmp
    //   181: ifne +64 -> 245
    //   184: iconst_0
    //   185: istore_2
    //   186: iload_2
    //   187: ifeq +69 -> 256
    //   190: aload_0
    //   191: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   194: aload 4
    //   196: getstatic 116	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   199: invokevirtual 143	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 148	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   205: ifeq +45 -> 250
    //   208: aload_0
    //   209: getfield 49	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   212: aload_0
    //   213: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   216: aconst_null
    //   217: aload_1
    //   218: getfield 89	com/tencent/mobileqq/data/PAMessage$Item:appId	J
    //   221: aload_3
    //   222: invokestatic 153	com/tencent/mobileqq/activity/aio/item/PASingleItemBuilder:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;)Z
    //   225: pop
    //   226: return
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 156	java/lang/NumberFormatException:printStackTrace	()V
    //   232: return
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 157	org/json/JSONException:printStackTrace	()V
    //   238: return
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 157	org/json/JSONException:printStackTrace	()V
    //   244: return
    //   245: iconst_1
    //   246: istore_2
    //   247: goto -61 -> 186
    //   250: aload_0
    //   251: aload 4
    //   253: invokespecial 159	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:a	(Landroid/os/Bundle;)V
    //   256: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	PAGameItemBuilder
    //   0	257	1	paramItem	PAMessage.Item
    //   185	62	2	i	int
    //   30	192	3	str	String
    //   11	241	4	localObject	java.lang.Object
    //   66	93	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   31	46	227	java/lang/NumberFormatException
    //   0	22	233	org/json/JSONException
    //   23	31	233	org/json/JSONException
    //   31	46	233	org/json/JSONException
    //   228	232	233	org/json/JSONException
    //   55	168	239	org/json/JSONException
  }
  
  private boolean a(PAMessage.Item paramItem)
  {
    try
    {
      paramItem = new JSONObject(paramItem.rankListDownload).optString("p");
      boolean bool = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramItem);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramItem)
    {
      paramItem.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, android.widget.LinearLayout paramLinearLayout, com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    // Byte code:
    //   0: new 167	android/widget/LinearLayout
    //   3: dup
    //   4: aload_0
    //   5: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: invokespecial 170	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   11: astore_2
    //   12: aload_2
    //   13: checkcast 167	android/widget/LinearLayout
    //   16: iconst_1
    //   17: invokevirtual 174	android/widget/LinearLayout:setOrientation	(I)V
    //   20: aload_1
    //   21: checkcast 176	com/tencent/mobileqq/data/MessageForPubAccount
    //   24: astore_3
    //   25: aload_3
    //   26: getfield 180	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   29: astore 4
    //   31: fconst_1
    //   32: getstatic 185	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:d	F
    //   35: fmul
    //   36: f2i
    //   37: istore 8
    //   39: aload 4
    //   41: getfield 191	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   44: astore 9
    //   46: aload_2
    //   47: checkcast 193	android/view/ViewGroup
    //   50: astore 10
    //   52: iconst_0
    //   53: istore 6
    //   55: iload 6
    //   57: aload 9
    //   59: invokevirtual 198	java/util/ArrayList:size	()I
    //   62: if_icmpge +886 -> 948
    //   65: new 200	bwc
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 201	bwc:<init>	(Lcom/tencent/mobileqq/activity/aio/item/PAGameItemBuilder;)V
    //   73: astore 11
    //   75: aload 9
    //   77: iload 6
    //   79: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   82: checkcast 62	com/tencent/mobileqq/data/PAMessage$Item
    //   85: astore 12
    //   87: aload 11
    //   89: iconst_5
    //   90: putfield 208	bwc:jdField_a_of_type_Int	I
    //   93: aload 11
    //   95: aload 12
    //   97: getfield 211	com/tencent/mobileqq/data/PAMessage$Item:url	Ljava/lang/String;
    //   100: putfield 213	bwc:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   103: aload 11
    //   105: aload 4
    //   107: getfield 216	com/tencent/mobileqq/data/PAMessage:type	I
    //   110: putfield 218	bwc:jdField_b_of_type_Int	I
    //   113: aload 11
    //   115: aload 12
    //   117: getfield 221	com/tencent/mobileqq/data/PAMessage$Item:actionUrl	Ljava/lang/String;
    //   120: putfield 222	bwc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   123: aload 11
    //   125: aload 12
    //   127: getfield 225	com/tencent/mobileqq/data/PAMessage$Item:nativeJumpString	Ljava/lang/String;
    //   130: putfield 226	bwc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   133: aload 11
    //   135: aload_3
    //   136: getfield 229	com/tencent/mobileqq/data/MessageForPubAccount:uniseq	J
    //   139: putfield 230	bwc:jdField_a_of_type_Long	J
    //   142: aload 11
    //   144: iload 6
    //   146: putfield 232	bwc:jdField_c_of_type_Int	I
    //   149: iload 6
    //   151: ifne +12 -> 163
    //   154: iload 6
    //   156: iconst_1
    //   157: iadd
    //   158: istore 6
    //   160: goto -105 -> 55
    //   163: iload 6
    //   165: iconst_1
    //   166: if_icmpne +423 -> 589
    //   169: aload_0
    //   170: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   173: invokestatic 238	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   176: ldc 239
    //   178: aconst_null
    //   179: invokevirtual 243	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   182: astore_1
    //   183: aload_1
    //   184: ldc 244
    //   186: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   189: checkcast 252	android/widget/ImageView
    //   192: astore 14
    //   194: aload_1
    //   195: ldc 253
    //   197: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   200: checkcast 255	android/widget/TextView
    //   203: astore 13
    //   205: aload 9
    //   207: iconst_0
    //   208: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   211: checkcast 62	com/tencent/mobileqq/data/PAMessage$Item
    //   214: getfield 258	com/tencent/mobileqq/data/PAMessage$Item:cover	Ljava/lang/String;
    //   217: astore 15
    //   219: aload 14
    //   221: aload 15
    //   223: invokestatic 264	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   226: invokevirtual 268	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   229: aload 9
    //   231: iconst_0
    //   232: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   235: checkcast 62	com/tencent/mobileqq/data/PAMessage$Item
    //   238: getfield 271	com/tencent/mobileqq/data/PAMessage$Item:title	Ljava/lang/String;
    //   241: astore 14
    //   243: aload 14
    //   245: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +331 -> 579
    //   251: aload 13
    //   253: aload 14
    //   255: invokevirtual 275	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   258: aload_1
    //   259: ldc_w 276
    //   262: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   265: checkcast 252	android/widget/ImageView
    //   268: astore 14
    //   270: aload_1
    //   271: ldc_w 277
    //   274: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   277: checkcast 252	android/widget/ImageView
    //   280: astore 15
    //   282: aload_1
    //   283: ldc_w 278
    //   286: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   289: checkcast 255	android/widget/TextView
    //   292: astore 16
    //   294: aload_1
    //   295: ldc_w 279
    //   298: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   301: checkcast 255	android/widget/TextView
    //   304: astore 17
    //   306: aload_1
    //   307: ldc_w 280
    //   310: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   313: checkcast 255	android/widget/TextView
    //   316: astore 18
    //   318: aload_1
    //   319: ldc_w 281
    //   322: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   325: checkcast 283	android/widget/RelativeLayout
    //   328: astore 13
    //   330: aload_0
    //   331: aload 12
    //   333: invokespecial 285	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:a	(Lcom/tencent/mobileqq/data/PAMessage$Item;)Z
    //   336: ifeq +479 -> 815
    //   339: aload 12
    //   341: ldc_w 287
    //   344: putfield 290	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   347: aload 18
    //   349: aload 12
    //   351: getfield 290	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   354: invokevirtual 275	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   357: aload 16
    //   359: aload 12
    //   361: getfield 271	com/tencent/mobileqq/data/PAMessage$Item:title	Ljava/lang/String;
    //   364: invokestatic 294	com/tencent/biz/common/util/Util:e	(Ljava/lang/String;)Ljava/lang/String;
    //   367: invokevirtual 275	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   370: aload 17
    //   372: aload 12
    //   374: getfield 297	com/tencent/mobileqq/data/PAMessage$Item:desc	Ljava/lang/String;
    //   377: invokevirtual 275	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   380: new 299	android/util/DisplayMetrics
    //   383: dup
    //   384: invokespecial 300	android/util/DisplayMetrics:<init>	()V
    //   387: astore 18
    //   389: aload_0
    //   390: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   393: checkcast 302	android/app/Activity
    //   396: invokevirtual 306	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   399: invokeinterface 312 1 0
    //   404: aload 18
    //   406: invokevirtual 318	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   409: aload 12
    //   411: getfield 290	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   414: invokevirtual 321	java/lang/String:length	()I
    //   417: iconst_4
    //   418: if_icmple +419 -> 837
    //   421: iconst_4
    //   422: istore 7
    //   424: aload 18
    //   426: getfield 324	android/util/DisplayMetrics:widthPixels	I
    //   429: iload 7
    //   431: bipush 15
    //   433: imul
    //   434: sipush 151
    //   437: iadd
    //   438: i2f
    //   439: aload_0
    //   440: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   443: invokevirtual 330	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   446: invokestatic 335	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   449: isub
    //   450: istore 7
    //   452: aload 16
    //   454: iload 7
    //   456: invokevirtual 338	android/widget/TextView:setMaxWidth	(I)V
    //   459: iload 6
    //   461: iconst_1
    //   462: if_icmpeq +10 -> 472
    //   465: aload 17
    //   467: iload 7
    //   469: invokevirtual 338	android/widget/TextView:setMaxWidth	(I)V
    //   472: aload 15
    //   474: aload 12
    //   476: getfield 258	com/tencent/mobileqq/data/PAMessage$Item:cover	Ljava/lang/String;
    //   479: invokestatic 264	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   482: invokevirtual 268	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   485: iload 6
    //   487: iconst_3
    //   488: if_icmpgt +375 -> 863
    //   491: aload 14
    //   493: aload_0
    //   494: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   497: invokevirtual 330	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   500: aload_0
    //   501: getfield 22	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_ArrayOfInt	[I
    //   504: iload 6
    //   506: iconst_1
    //   507: isub
    //   508: iaload
    //   509: invokevirtual 343	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   512: invokevirtual 268	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   515: aload 10
    //   517: aload_1
    //   518: invokevirtual 347	android/view/ViewGroup:addView	(Landroid/view/View;)V
    //   521: aload 13
    //   523: aload 11
    //   525: invokevirtual 351	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   528: aload 13
    //   530: aload_0
    //   531: getfield 34	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:b	Landroid/view/View$OnClickListener;
    //   534: invokevirtual 355	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   537: aload_1
    //   538: aload 11
    //   540: invokevirtual 356	android/view/View:setTag	(Ljava/lang/Object;)V
    //   543: aload_1
    //   544: aload_0
    //   545: getfield 29	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   548: invokevirtual 357	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   551: aload_1
    //   552: aload 5
    //   554: invokevirtual 361	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   557: aload_1
    //   558: aload 5
    //   560: invokevirtual 365	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   563: goto -409 -> 154
    //   566: astore 15
    //   568: aload 14
    //   570: ldc_w 366
    //   573: invokevirtual 369	android/widget/ImageView:setImageResource	(I)V
    //   576: goto -347 -> 229
    //   579: aload 13
    //   581: bipush 8
    //   583: invokevirtual 372	android/widget/TextView:setVisibility	(I)V
    //   586: goto -328 -> 258
    //   589: iload 6
    //   591: aload 9
    //   593: invokevirtual 198	java/util/ArrayList:size	()I
    //   596: iconst_1
    //   597: isub
    //   598: if_icmpne +120 -> 718
    //   601: aload_0
    //   602: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   605: invokestatic 238	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   608: ldc_w 373
    //   611: aconst_null
    //   612: invokevirtual 243	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   615: astore_1
    //   616: aload_1
    //   617: new 375	android/widget/RelativeLayout$LayoutParams
    //   620: dup
    //   621: iconst_m1
    //   622: ldc_w 376
    //   625: aload_0
    //   626: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   629: invokevirtual 330	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   632: invokestatic 335	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   635: invokespecial 379	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   638: invokevirtual 383	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   641: aload_1
    //   642: iconst_0
    //   643: iconst_0
    //   644: iconst_0
    //   645: iconst_0
    //   646: invokevirtual 387	android/view/View:setPadding	(IIII)V
    //   649: aload_1
    //   650: aload_0
    //   651: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   654: invokevirtual 330	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   657: ldc_w 388
    //   660: invokevirtual 343	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   663: invokevirtual 391	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   666: aload_1
    //   667: ldc_w 392
    //   670: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   673: astore 13
    //   675: new 375	android/widget/RelativeLayout$LayoutParams
    //   678: dup
    //   679: iconst_m1
    //   680: iload 8
    //   682: invokespecial 379	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   685: astore 14
    //   687: aload 14
    //   689: ldc_w 393
    //   692: aload_0
    //   693: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   696: invokevirtual 330	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   699: invokestatic 335	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   702: iconst_0
    //   703: iconst_0
    //   704: iconst_0
    //   705: invokevirtual 396	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   708: aload 13
    //   710: aload 14
    //   712: invokevirtual 383	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   715: goto -457 -> 258
    //   718: aload_0
    //   719: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   722: invokestatic 238	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   725: ldc_w 373
    //   728: aconst_null
    //   729: invokevirtual 243	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   732: astore_1
    //   733: aload_1
    //   734: ldc_w 392
    //   737: invokevirtual 250	android/view/View:findViewById	(I)Landroid/view/View;
    //   740: astore 13
    //   742: new 375	android/widget/RelativeLayout$LayoutParams
    //   745: dup
    //   746: iconst_m1
    //   747: iload 8
    //   749: invokespecial 379	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   752: astore 14
    //   754: iload 6
    //   756: iconst_2
    //   757: if_icmpne +34 -> 791
    //   760: aload 14
    //   762: ldc_w 397
    //   765: aload_0
    //   766: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   769: invokevirtual 330	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   772: invokestatic 335	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   775: iconst_0
    //   776: iconst_0
    //   777: iconst_0
    //   778: invokevirtual 396	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   781: aload 13
    //   783: aload 14
    //   785: invokevirtual 383	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   788: goto -530 -> 258
    //   791: aload 14
    //   793: ldc_w 393
    //   796: aload_0
    //   797: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   800: invokevirtual 330	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   803: invokestatic 335	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   806: iconst_0
    //   807: iconst_0
    //   808: iconst_0
    //   809: invokevirtual 396	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   812: goto -31 -> 781
    //   815: aload 12
    //   817: getfield 290	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   820: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   823: ifeq -476 -> 347
    //   826: aload 12
    //   828: ldc_w 399
    //   831: putfield 290	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   834: goto -487 -> 347
    //   837: aload 12
    //   839: getfield 290	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   842: invokevirtual 321	java/lang/String:length	()I
    //   845: istore 7
    //   847: goto -423 -> 424
    //   850: astore 12
    //   852: aload 15
    //   854: ldc_w 366
    //   857: invokevirtual 369	android/widget/ImageView:setImageResource	(I)V
    //   860: goto -375 -> 485
    //   863: aload 14
    //   865: invokevirtual 403	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   868: astore 12
    //   870: aload 14
    //   872: bipush 8
    //   874: invokevirtual 404	android/widget/ImageView:setVisibility	(I)V
    //   877: new 255	android/widget/TextView
    //   880: dup
    //   881: aload_0
    //   882: getfield 41	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   885: invokespecial 405	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   888: astore 14
    //   890: aload 14
    //   892: bipush 17
    //   894: invokevirtual 408	android/widget/TextView:setGravity	(I)V
    //   897: aload 14
    //   899: iload 6
    //   901: invokestatic 412	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   904: invokevirtual 275	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   907: aload 14
    //   909: getstatic 418	android/graphics/Typeface:DEFAULT_BOLD	Landroid/graphics/Typeface;
    //   912: invokevirtual 422	android/widget/TextView:setTypeface	(Landroid/graphics/Typeface;)V
    //   915: aload 14
    //   917: iconst_2
    //   918: ldc_w 423
    //   921: invokevirtual 427	android/widget/TextView:setTextSize	(IF)V
    //   924: aload_1
    //   925: checkcast 283	android/widget/RelativeLayout
    //   928: aload 14
    //   930: aload 12
    //   932: invokevirtual 430	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   935: goto -420 -> 515
    //   938: astore 12
    //   940: aload 12
    //   942: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   945: goto -430 -> 515
    //   948: aload_2
    //   949: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	950	0	this	PAGameItemBuilder
    //   0	950	1	paramMessageRecord	MessageRecord
    //   0	950	2	paramViewHolder	AbstractChatItemBuilder.ViewHolder
    //   0	950	3	paramView	View
    //   0	950	4	paramLinearLayout	android.widget.LinearLayout
    //   0	950	5	paramOnLongClickAndTouchListener	com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener
    //   53	847	6	i	int
    //   422	424	7	j	int
    //   37	711	8	k	int
    //   44	548	9	localArrayList	java.util.ArrayList
    //   50	466	10	localViewGroup	android.view.ViewGroup
    //   73	466	11	localbwc	bwc
    //   85	753	12	localItem	PAMessage.Item
    //   850	1	12	localException1	Exception
    //   868	63	12	localLayoutParams	android.view.ViewGroup.LayoutParams
    //   938	3	12	localException2	Exception
    //   203	579	13	localObject1	java.lang.Object
    //   192	737	14	localObject2	java.lang.Object
    //   217	256	15	localObject3	java.lang.Object
    //   566	287	15	localException3	Exception
    //   292	161	16	localTextView1	android.widget.TextView
    //   304	162	17	localTextView2	android.widget.TextView
    //   316	109	18	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   219	229	566	java/lang/Exception
    //   472	485	850	java/lang/Exception
    //   491	515	938	java/lang/Exception
    //   863	935	938	java/lang/Exception
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new bwc(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      PublicAccountUtil.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131298983, this.jdField_a_of_type_AndroidContentContext.getString(2131363073));
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAGameItemBuilder
 * JD-Core Version:    0.7.0.1
 */