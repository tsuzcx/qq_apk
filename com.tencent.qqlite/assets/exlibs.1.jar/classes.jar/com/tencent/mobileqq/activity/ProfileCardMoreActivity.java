package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import bba;
import bbb;
import bbc;
import bbd;
import bbe;
import bbg;
import bbh;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  private static final int i = 8;
  private static final int j = 1;
  private static final int k = 2;
  private static final int m = 0;
  private static final int n = 1;
  private static final int o = -1;
  long jdField_a_of_type_Long;
  public Intent a;
  public ProfileActivity.AllInOne a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new bbg(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bbe(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new bbc(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new bbd(this);
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public FormSimpleItem c;
  private String c;
  FormSimpleItem d;
  FormSimpleItem e;
  private int l = 0;
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 91	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 95	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 99	com/tencent/mobileqq/activity/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 104	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   23: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3292 -> 3322
    //   33: aload 11
    //   35: ldc 112
    //   37: aload_1
    //   38: invokevirtual 117	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   41: checkcast 112	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   44: astore 15
    //   46: aload 11
    //   48: ifnull +8 -> 56
    //   51: aload 11
    //   53: invokevirtual 119	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   56: aload 15
    //   58: ifnonnull +5 -> 63
    //   61: iconst_m1
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 121	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +844 -> 914
    //   73: aload_0
    //   74: getfield 121	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: astore 13
    //   79: iconst_0
    //   80: istore_2
    //   81: iconst_0
    //   82: istore_3
    //   83: aconst_null
    //   84: astore 12
    //   86: aload_0
    //   87: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   90: astore 11
    //   92: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   95: astore 14
    //   97: new 139	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   104: ldc 142
    //   106: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 13
    //   111: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 148
    //   116: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 16
    //   124: aload 11
    //   126: aload 14
    //   128: iconst_4
    //   129: anewarray 87	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: ldc 153
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: ldc 155
    //   141: aastore
    //   142: dup
    //   143: iconst_2
    //   144: ldc 157
    //   146: aastore
    //   147: dup
    //   148: iconst_3
    //   149: ldc 159
    //   151: aastore
    //   152: aload 16
    //   154: aconst_null
    //   155: aconst_null
    //   156: invokevirtual 165	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   159: astore 11
    //   161: iconst_0
    //   162: istore 4
    //   164: lconst_0
    //   165: lstore 8
    //   167: iload_3
    //   168: istore_2
    //   169: iload 4
    //   171: istore_3
    //   172: aload 11
    //   174: invokeinterface 171 1 0
    //   179: istore 10
    //   181: iload 10
    //   183: ifeq +3126 -> 3309
    //   186: aload 11
    //   188: iconst_0
    //   189: invokeinterface 175 2 0
    //   194: lstore 6
    //   196: iload_2
    //   197: istore 4
    //   199: aload 15
    //   201: getfield 178	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   204: astore 12
    //   206: aload 12
    //   208: ifnull +849 -> 1057
    //   211: aconst_null
    //   212: astore 14
    //   214: aload_0
    //   215: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   218: astore 12
    //   220: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   223: astore 16
    //   225: new 139	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   232: ldc 180
    //   234: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload 6
    //   239: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: ldc 185
    //   244: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 157
    //   249: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 187
    //   254: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 189
    //   259: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 148
    //   264: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 185
    //   269: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 159
    //   274: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc 187
    //   279: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 15
    //   284: getfield 178	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   287: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 148
    //   292: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 185
    //   297: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc 191
    //   302: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 187
    //   307: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iconst_2
    //   311: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: ldc 148
    //   316: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore 17
    //   324: aload 12
    //   326: aload 16
    //   328: iconst_5
    //   329: anewarray 87	java/lang/String
    //   332: dup
    //   333: iconst_0
    //   334: ldc 153
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: ldc 155
    //   341: aastore
    //   342: dup
    //   343: iconst_2
    //   344: ldc 157
    //   346: aastore
    //   347: dup
    //   348: iconst_3
    //   349: ldc 159
    //   351: aastore
    //   352: dup
    //   353: iconst_4
    //   354: ldc 191
    //   356: aastore
    //   357: aload 17
    //   359: aconst_null
    //   360: aconst_null
    //   361: invokevirtual 165	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   364: astore 12
    //   366: aload 12
    //   368: invokeinterface 197 1 0
    //   373: istore 10
    //   375: iload 10
    //   377: ifeq +568 -> 945
    //   380: iconst_1
    //   381: istore_3
    //   382: iconst_1
    //   383: istore_2
    //   384: aload 12
    //   386: astore 14
    //   388: aload 12
    //   390: ifnull +13 -> 403
    //   393: aload 12
    //   395: invokeinterface 200 1 0
    //   400: aconst_null
    //   401: astore 14
    //   403: aload 14
    //   405: ifnull +2897 -> 3302
    //   408: aload 14
    //   410: invokeinterface 200 1 0
    //   415: iconst_1
    //   416: istore_2
    //   417: iconst_1
    //   418: istore_3
    //   419: iload_3
    //   420: istore 5
    //   422: lload 6
    //   424: lstore 8
    //   426: iload_2
    //   427: istore 4
    //   429: aload 11
    //   431: ifnull +2858 -> 3289
    //   434: aload 11
    //   436: invokeinterface 200 1 0
    //   441: iload_3
    //   442: ifne +641 -> 1083
    //   445: iconst_1
    //   446: istore_3
    //   447: iconst_0
    //   448: istore_2
    //   449: new 202	android/content/ContentValues
    //   452: dup
    //   453: invokespecial 203	android/content/ContentValues:<init>	()V
    //   456: astore 14
    //   458: iload_3
    //   459: iconst_1
    //   460: if_icmpne +641 -> 1101
    //   463: aload_0
    //   464: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   467: getstatic 206	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   470: aload 14
    //   472: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   475: invokestatic 216	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   478: lstore 6
    //   480: aload 13
    //   482: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   485: ifne +51 -> 536
    //   488: aload 14
    //   490: invokevirtual 219	android/content/ContentValues:clear	()V
    //   493: aload 14
    //   495: ldc 153
    //   497: lload 6
    //   499: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   502: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   505: aload 14
    //   507: ldc 157
    //   509: ldc 231
    //   511: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload 14
    //   516: ldc 159
    //   518: aload 13
    //   520: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload_0
    //   524: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   527: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   530: aload 14
    //   532: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   535: pop
    //   536: aload 15
    //   538: getfield 237	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   541: ifnonnull +11 -> 552
    //   544: aload 15
    //   546: getfield 240	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   549: ifnull +93 -> 642
    //   552: aload 14
    //   554: invokevirtual 219	android/content/ContentValues:clear	()V
    //   557: aload 14
    //   559: ldc 153
    //   561: lload 6
    //   563: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   566: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   569: aload 14
    //   571: ldc 157
    //   573: ldc 242
    //   575: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload 15
    //   580: getfield 240	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   583: ifnull +15 -> 598
    //   586: aload 14
    //   588: ldc 159
    //   590: aload 15
    //   592: getfield 240	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   595: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload 15
    //   600: getfield 237	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   603: ifnull +15 -> 618
    //   606: aload 14
    //   608: ldc 244
    //   610: aload 15
    //   612: getfield 237	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   615: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 14
    //   620: ldc 191
    //   622: iconst_1
    //   623: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   629: aload_0
    //   630: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   633: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   636: aload 14
    //   638: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   641: pop
    //   642: aload 15
    //   644: getfield 178	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   647: ifnull +65 -> 712
    //   650: aload 14
    //   652: invokevirtual 219	android/content/ContentValues:clear	()V
    //   655: aload 14
    //   657: ldc 153
    //   659: lload 6
    //   661: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   664: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   667: aload 14
    //   669: ldc 157
    //   671: ldc 189
    //   673: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload 14
    //   678: ldc 159
    //   680: aload 15
    //   682: getfield 178	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   685: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: aload 14
    //   690: ldc 191
    //   692: iconst_2
    //   693: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   696: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   699: aload_0
    //   700: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   703: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   706: aload 14
    //   708: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   711: pop
    //   712: aload 15
    //   714: getfield 255	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   717: ifnull +65 -> 782
    //   720: aload 14
    //   722: invokevirtual 219	android/content/ContentValues:clear	()V
    //   725: aload 14
    //   727: ldc 153
    //   729: lload 6
    //   731: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   734: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   737: aload 14
    //   739: ldc 157
    //   741: ldc 189
    //   743: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: aload 14
    //   748: ldc 159
    //   750: aload 15
    //   752: getfield 255	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   755: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   758: aload 14
    //   760: ldc 191
    //   762: iconst_3
    //   763: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   766: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   769: aload_0
    //   770: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   773: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   776: aload 14
    //   778: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   781: pop
    //   782: aload 15
    //   784: getfield 258	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   787: ifnull +66 -> 853
    //   790: aload 14
    //   792: invokevirtual 219	android/content/ContentValues:clear	()V
    //   795: aload 14
    //   797: ldc 153
    //   799: lload 6
    //   801: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   804: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   807: aload 14
    //   809: ldc 157
    //   811: ldc_w 260
    //   814: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   817: aload 14
    //   819: ldc 159
    //   821: aload 15
    //   823: getfield 258	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   826: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: aload 14
    //   831: ldc 191
    //   833: iconst_2
    //   834: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   840: aload_0
    //   841: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   844: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   847: aload 14
    //   849: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   852: pop
    //   853: aload 14
    //   855: invokevirtual 219	android/content/ContentValues:clear	()V
    //   858: aload 14
    //   860: ldc 153
    //   862: lload 6
    //   864: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   867: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   870: aload 14
    //   872: ldc 157
    //   874: ldc_w 262
    //   877: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   880: aload 14
    //   882: ldc 159
    //   884: aload_1
    //   885: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: aload 14
    //   890: ldc 191
    //   892: iconst_2
    //   893: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   896: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   899: aload_0
    //   900: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   903: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   906: aload 14
    //   908: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   911: pop
    //   912: iconst_0
    //   913: ireturn
    //   914: aload 15
    //   916: getfield 265	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   919: ifnull +13 -> 932
    //   922: aload 15
    //   924: getfield 265	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   927: astore 13
    //   929: goto -850 -> 79
    //   932: aload_1
    //   933: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   936: ifne +2380 -> 3316
    //   939: aload_1
    //   940: astore 13
    //   942: goto -863 -> 79
    //   945: iconst_0
    //   946: istore_2
    //   947: iconst_0
    //   948: istore 4
    //   950: iload_2
    //   951: istore_3
    //   952: aload 12
    //   954: ifnull +2374 -> 3328
    //   957: iload 4
    //   959: istore_3
    //   960: aload 12
    //   962: invokeinterface 200 1 0
    //   967: iload_2
    //   968: istore_3
    //   969: goto +2359 -> 3328
    //   972: iload_2
    //   973: istore_3
    //   974: aload 12
    //   976: ifnull +2352 -> 3328
    //   979: iload_2
    //   980: istore_3
    //   981: aload 12
    //   983: invokeinterface 200 1 0
    //   988: iload_2
    //   989: istore_3
    //   990: goto +2338 -> 3328
    //   993: astore 12
    //   995: iload_3
    //   996: istore_2
    //   997: iconst_1
    //   998: istore_3
    //   999: iload_3
    //   1000: istore 5
    //   1002: lload 6
    //   1004: lstore 8
    //   1006: iload_2
    //   1007: istore 4
    //   1009: aload 11
    //   1011: ifnull +2278 -> 3289
    //   1014: aload 11
    //   1016: invokeinterface 200 1 0
    //   1021: goto -580 -> 441
    //   1024: astore 12
    //   1026: aload 14
    //   1028: ifnull +13 -> 1041
    //   1031: iload_2
    //   1032: istore 4
    //   1034: aload 14
    //   1036: invokeinterface 200 1 0
    //   1041: iload_2
    //   1042: istore 4
    //   1044: aload 12
    //   1046: athrow
    //   1047: astore 12
    //   1049: iconst_1
    //   1050: istore_3
    //   1051: iload 4
    //   1053: istore_2
    //   1054: goto -55 -> 999
    //   1057: iconst_0
    //   1058: istore_2
    //   1059: iconst_1
    //   1060: istore_3
    //   1061: goto -642 -> 419
    //   1064: astore_1
    //   1065: aload 12
    //   1067: astore 11
    //   1069: aload 11
    //   1071: ifnull +10 -> 1081
    //   1074: aload 11
    //   1076: invokeinterface 200 1 0
    //   1081: aload_1
    //   1082: athrow
    //   1083: iload_2
    //   1084: ifne +10 -> 1094
    //   1087: iconst_1
    //   1088: istore_3
    //   1089: iconst_0
    //   1090: istore_2
    //   1091: goto -642 -> 449
    //   1094: iconst_1
    //   1095: istore_2
    //   1096: iconst_0
    //   1097: istore_3
    //   1098: goto -649 -> 449
    //   1101: iload_2
    //   1102: iconst_1
    //   1103: if_icmpne +2050 -> 3153
    //   1106: aload 15
    //   1108: getfield 178	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1111: ifnull +123 -> 1234
    //   1114: aload 14
    //   1116: invokevirtual 219	android/content/ContentValues:clear	()V
    //   1119: aload 14
    //   1121: ldc 157
    //   1123: ldc 189
    //   1125: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1128: aload 14
    //   1130: ldc 159
    //   1132: aload 15
    //   1134: getfield 178	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1137: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1140: aload 14
    //   1142: ldc 191
    //   1144: iconst_2
    //   1145: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1148: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1151: aload_0
    //   1152: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1155: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1158: aload 14
    //   1160: new 139	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1167: ldc 180
    //   1169: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: lload 6
    //   1174: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1177: ldc 185
    //   1179: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: ldc 157
    //   1184: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: ldc 187
    //   1189: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: ldc 189
    //   1194: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: ldc 148
    //   1199: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: ldc 185
    //   1204: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: ldc 191
    //   1209: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: ldc 187
    //   1214: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: iconst_2
    //   1218: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1221: ldc 148
    //   1223: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: aconst_null
    //   1230: invokevirtual 269	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1233: pop
    //   1234: aload 15
    //   1236: getfield 237	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1239: ifnull +276 -> 1515
    //   1242: aconst_null
    //   1243: astore 11
    //   1245: aload_0
    //   1246: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1249: astore 12
    //   1251: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1254: astore 13
    //   1256: new 139	java/lang/StringBuilder
    //   1259: dup
    //   1260: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1263: ldc 180
    //   1265: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: lload 6
    //   1270: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1273: ldc 185
    //   1275: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: ldc 157
    //   1280: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: ldc 187
    //   1285: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: ldc 242
    //   1290: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: ldc 148
    //   1295: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: ldc 185
    //   1300: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: ldc 191
    //   1305: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: ldc 187
    //   1310: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: iconst_1
    //   1314: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: ldc 148
    //   1319: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: astore 16
    //   1327: aload 12
    //   1329: aload 13
    //   1331: iconst_5
    //   1332: anewarray 87	java/lang/String
    //   1335: dup
    //   1336: iconst_0
    //   1337: ldc 153
    //   1339: aastore
    //   1340: dup
    //   1341: iconst_1
    //   1342: ldc 155
    //   1344: aastore
    //   1345: dup
    //   1346: iconst_2
    //   1347: ldc 157
    //   1349: aastore
    //   1350: dup
    //   1351: iconst_3
    //   1352: ldc 244
    //   1354: aastore
    //   1355: dup
    //   1356: iconst_4
    //   1357: ldc 191
    //   1359: aastore
    //   1360: aload 16
    //   1362: aconst_null
    //   1363: aconst_null
    //   1364: invokevirtual 165	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1367: astore 12
    //   1369: aload 12
    //   1371: astore 11
    //   1373: aload 11
    //   1375: invokeinterface 197 1 0
    //   1380: ifeq +1291 -> 2671
    //   1383: aload 14
    //   1385: invokevirtual 219	android/content/ContentValues:clear	()V
    //   1388: aload 14
    //   1390: ldc 157
    //   1392: ldc 242
    //   1394: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: aload 14
    //   1399: ldc 244
    //   1401: aload 15
    //   1403: getfield 237	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1406: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1409: aload 14
    //   1411: ldc 191
    //   1413: iconst_1
    //   1414: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1417: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1420: aload_0
    //   1421: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1424: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1427: aload 14
    //   1429: new 139	java/lang/StringBuilder
    //   1432: dup
    //   1433: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1436: ldc 180
    //   1438: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: lload 6
    //   1443: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1446: ldc 185
    //   1448: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: ldc 157
    //   1453: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: ldc 187
    //   1458: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: ldc 242
    //   1463: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: ldc 148
    //   1468: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: ldc 185
    //   1473: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: ldc 191
    //   1478: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: ldc 187
    //   1483: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: iconst_1
    //   1487: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1490: ldc 148
    //   1492: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: aconst_null
    //   1499: invokevirtual 269	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1502: pop
    //   1503: aload 11
    //   1505: ifnull +10 -> 1515
    //   1508: aload 11
    //   1510: invokeinterface 200 1 0
    //   1515: aload 15
    //   1517: getfield 240	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1520: ifnull +276 -> 1796
    //   1523: aconst_null
    //   1524: astore 11
    //   1526: aload_0
    //   1527: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1530: astore 12
    //   1532: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1535: astore 13
    //   1537: new 139	java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1544: ldc 180
    //   1546: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: lload 6
    //   1551: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1554: ldc 185
    //   1556: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: ldc 157
    //   1561: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: ldc 187
    //   1566: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: ldc 242
    //   1571: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: ldc 148
    //   1576: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: ldc 185
    //   1581: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: ldc 191
    //   1586: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: ldc 187
    //   1591: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: iconst_1
    //   1595: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1598: ldc 148
    //   1600: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1606: astore 16
    //   1608: aload 12
    //   1610: aload 13
    //   1612: iconst_5
    //   1613: anewarray 87	java/lang/String
    //   1616: dup
    //   1617: iconst_0
    //   1618: ldc 153
    //   1620: aastore
    //   1621: dup
    //   1622: iconst_1
    //   1623: ldc 155
    //   1625: aastore
    //   1626: dup
    //   1627: iconst_2
    //   1628: ldc 157
    //   1630: aastore
    //   1631: dup
    //   1632: iconst_3
    //   1633: ldc 159
    //   1635: aastore
    //   1636: dup
    //   1637: iconst_4
    //   1638: ldc 191
    //   1640: aastore
    //   1641: aload 16
    //   1643: aconst_null
    //   1644: aconst_null
    //   1645: invokevirtual 165	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1648: astore 12
    //   1650: aload 12
    //   1652: astore 11
    //   1654: aload 11
    //   1656: invokeinterface 197 1 0
    //   1661: ifeq +1107 -> 2768
    //   1664: aload 14
    //   1666: invokevirtual 219	android/content/ContentValues:clear	()V
    //   1669: aload 14
    //   1671: ldc 157
    //   1673: ldc 242
    //   1675: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1678: aload 14
    //   1680: ldc 159
    //   1682: aload 15
    //   1684: getfield 240	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1687: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1690: aload 14
    //   1692: ldc 191
    //   1694: iconst_1
    //   1695: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1698: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1701: aload_0
    //   1702: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1705: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1708: aload 14
    //   1710: new 139	java/lang/StringBuilder
    //   1713: dup
    //   1714: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1717: ldc 180
    //   1719: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: lload 6
    //   1724: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1727: ldc 185
    //   1729: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: ldc 157
    //   1734: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: ldc 187
    //   1739: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: ldc 242
    //   1744: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: ldc 148
    //   1749: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: ldc 185
    //   1754: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: ldc 191
    //   1759: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: ldc 187
    //   1764: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: iconst_1
    //   1768: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1771: ldc 148
    //   1773: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1779: aconst_null
    //   1780: invokevirtual 269	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1783: pop
    //   1784: aload 11
    //   1786: ifnull +10 -> 1796
    //   1789: aload 11
    //   1791: invokeinterface 200 1 0
    //   1796: aload 15
    //   1798: getfield 255	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1801: ifnull +288 -> 2089
    //   1804: aconst_null
    //   1805: astore 11
    //   1807: aload_0
    //   1808: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1811: astore 12
    //   1813: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1816: astore 13
    //   1818: new 139	java/lang/StringBuilder
    //   1821: dup
    //   1822: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1825: ldc 180
    //   1827: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: lload 6
    //   1832: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1835: ldc 185
    //   1837: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: ldc 157
    //   1842: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: ldc 187
    //   1847: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: ldc 189
    //   1852: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: ldc 148
    //   1857: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: ldc 185
    //   1862: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: ldc 191
    //   1867: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: ldc 187
    //   1872: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: iconst_3
    //   1876: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1879: ldc 148
    //   1881: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1887: astore 16
    //   1889: aload 12
    //   1891: aload 13
    //   1893: iconst_5
    //   1894: anewarray 87	java/lang/String
    //   1897: dup
    //   1898: iconst_0
    //   1899: ldc 153
    //   1901: aastore
    //   1902: dup
    //   1903: iconst_1
    //   1904: ldc 155
    //   1906: aastore
    //   1907: dup
    //   1908: iconst_2
    //   1909: ldc 157
    //   1911: aastore
    //   1912: dup
    //   1913: iconst_3
    //   1914: ldc 159
    //   1916: aastore
    //   1917: dup
    //   1918: iconst_4
    //   1919: ldc 191
    //   1921: aastore
    //   1922: aload 16
    //   1924: aconst_null
    //   1925: aconst_null
    //   1926: invokevirtual 165	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1929: astore 12
    //   1931: aload 12
    //   1933: astore 11
    //   1935: aload 11
    //   1937: invokeinterface 197 1 0
    //   1942: ifeq +923 -> 2865
    //   1945: aload 14
    //   1947: invokevirtual 219	android/content/ContentValues:clear	()V
    //   1950: aload 14
    //   1952: ldc 153
    //   1954: lload 6
    //   1956: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1959: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1962: aload 14
    //   1964: ldc 157
    //   1966: ldc 189
    //   1968: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1971: aload 14
    //   1973: ldc 159
    //   1975: aload 15
    //   1977: getfield 255	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1980: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1983: aload 14
    //   1985: ldc 191
    //   1987: iconst_3
    //   1988: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1991: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1994: aload_0
    //   1995: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1998: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2001: aload 14
    //   2003: new 139	java/lang/StringBuilder
    //   2006: dup
    //   2007: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   2010: ldc 180
    //   2012: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: lload 6
    //   2017: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2020: ldc 185
    //   2022: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2025: ldc 157
    //   2027: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: ldc 187
    //   2032: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: ldc 189
    //   2037: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: ldc 148
    //   2042: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: ldc 185
    //   2047: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: ldc 191
    //   2052: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: ldc 187
    //   2057: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2060: iconst_3
    //   2061: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2064: ldc 148
    //   2066: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2072: aconst_null
    //   2073: invokevirtual 269	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2076: pop
    //   2077: aload 11
    //   2079: ifnull +10 -> 2089
    //   2082: aload 11
    //   2084: invokeinterface 200 1 0
    //   2089: aload 15
    //   2091: getfield 258	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2094: ifnull +291 -> 2385
    //   2097: aconst_null
    //   2098: astore 11
    //   2100: aload_0
    //   2101: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2104: astore 12
    //   2106: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2109: astore 13
    //   2111: new 139	java/lang/StringBuilder
    //   2114: dup
    //   2115: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   2118: ldc 180
    //   2120: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: lload 6
    //   2125: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2128: ldc 185
    //   2130: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2133: ldc 157
    //   2135: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: ldc 187
    //   2140: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: ldc_w 260
    //   2146: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: ldc 148
    //   2151: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: ldc 185
    //   2156: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: ldc 191
    //   2161: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: ldc 187
    //   2166: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2169: iconst_2
    //   2170: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2173: ldc 148
    //   2175: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2181: astore 16
    //   2183: aload 12
    //   2185: aload 13
    //   2187: iconst_5
    //   2188: anewarray 87	java/lang/String
    //   2191: dup
    //   2192: iconst_0
    //   2193: ldc 153
    //   2195: aastore
    //   2196: dup
    //   2197: iconst_1
    //   2198: ldc 155
    //   2200: aastore
    //   2201: dup
    //   2202: iconst_2
    //   2203: ldc 157
    //   2205: aastore
    //   2206: dup
    //   2207: iconst_3
    //   2208: ldc 159
    //   2210: aastore
    //   2211: dup
    //   2212: iconst_4
    //   2213: ldc 191
    //   2215: aastore
    //   2216: aload 16
    //   2218: aconst_null
    //   2219: aconst_null
    //   2220: invokevirtual 165	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2223: astore 12
    //   2225: aload 12
    //   2227: astore 11
    //   2229: aload 11
    //   2231: invokeinterface 197 1 0
    //   2236: ifeq +726 -> 2962
    //   2239: aload 14
    //   2241: invokevirtual 219	android/content/ContentValues:clear	()V
    //   2244: aload 14
    //   2246: ldc 153
    //   2248: lload 6
    //   2250: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2253: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2256: aload 14
    //   2258: ldc 157
    //   2260: ldc_w 260
    //   2263: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2266: aload 14
    //   2268: ldc 159
    //   2270: aload 15
    //   2272: getfield 258	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2275: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2278: aload 14
    //   2280: ldc 191
    //   2282: iconst_2
    //   2283: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2286: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2289: aload_0
    //   2290: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2293: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2296: aload 14
    //   2298: new 139	java/lang/StringBuilder
    //   2301: dup
    //   2302: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   2305: ldc 180
    //   2307: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: lload 6
    //   2312: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2315: ldc 185
    //   2317: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2320: ldc 157
    //   2322: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2325: ldc 187
    //   2327: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: ldc_w 260
    //   2333: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: ldc 148
    //   2338: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: ldc 185
    //   2343: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2346: ldc 191
    //   2348: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2351: ldc 187
    //   2353: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2356: iconst_2
    //   2357: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2360: ldc 148
    //   2362: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2365: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2368: aconst_null
    //   2369: invokevirtual 269	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2372: pop
    //   2373: aload 11
    //   2375: ifnull +10 -> 2385
    //   2378: aload 11
    //   2380: invokeinterface 200 1 0
    //   2385: aconst_null
    //   2386: astore 11
    //   2388: aload_0
    //   2389: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2392: astore 12
    //   2394: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2397: astore 13
    //   2399: new 139	java/lang/StringBuilder
    //   2402: dup
    //   2403: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   2406: ldc 180
    //   2408: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2411: lload 6
    //   2413: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2416: ldc 185
    //   2418: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2421: ldc 157
    //   2423: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: ldc 187
    //   2428: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2431: ldc_w 262
    //   2434: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2437: ldc 148
    //   2439: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: ldc 185
    //   2444: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2447: ldc 191
    //   2449: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2452: ldc 187
    //   2454: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: iconst_2
    //   2458: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2461: ldc 148
    //   2463: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2469: astore 15
    //   2471: aload 12
    //   2473: aload 13
    //   2475: iconst_5
    //   2476: anewarray 87	java/lang/String
    //   2479: dup
    //   2480: iconst_0
    //   2481: ldc 153
    //   2483: aastore
    //   2484: dup
    //   2485: iconst_1
    //   2486: ldc 155
    //   2488: aastore
    //   2489: dup
    //   2490: iconst_2
    //   2491: ldc 157
    //   2493: aastore
    //   2494: dup
    //   2495: iconst_3
    //   2496: ldc 159
    //   2498: aastore
    //   2499: dup
    //   2500: iconst_4
    //   2501: ldc 191
    //   2503: aastore
    //   2504: aload 15
    //   2506: aconst_null
    //   2507: aconst_null
    //   2508: invokevirtual 165	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2511: astore 12
    //   2513: aload 12
    //   2515: astore 11
    //   2517: aload 11
    //   2519: invokeinterface 197 1 0
    //   2524: ifeq +536 -> 3060
    //   2527: aload 14
    //   2529: invokevirtual 219	android/content/ContentValues:clear	()V
    //   2532: aload 14
    //   2534: ldc 153
    //   2536: lload 6
    //   2538: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2541: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2544: aload 14
    //   2546: ldc 157
    //   2548: ldc_w 262
    //   2551: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2554: aload 14
    //   2556: ldc 159
    //   2558: aload_1
    //   2559: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2562: aload 14
    //   2564: ldc 191
    //   2566: iconst_2
    //   2567: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2570: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2573: aload_0
    //   2574: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2577: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2580: aload 14
    //   2582: new 139	java/lang/StringBuilder
    //   2585: dup
    //   2586: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   2589: ldc 180
    //   2591: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2594: lload 6
    //   2596: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2599: ldc 185
    //   2601: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2604: ldc 157
    //   2606: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: ldc 187
    //   2611: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2614: ldc_w 262
    //   2617: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: ldc 148
    //   2622: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2625: ldc 185
    //   2627: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2630: ldc 191
    //   2632: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2635: ldc 187
    //   2637: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2640: iconst_2
    //   2641: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2644: ldc 148
    //   2646: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2649: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2652: aconst_null
    //   2653: invokevirtual 269	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2656: pop
    //   2657: aload 11
    //   2659: ifnull +10 -> 2669
    //   2662: aload 11
    //   2664: invokeinterface 200 1 0
    //   2669: iconst_1
    //   2670: ireturn
    //   2671: aload 14
    //   2673: invokevirtual 219	android/content/ContentValues:clear	()V
    //   2676: aload 14
    //   2678: ldc 153
    //   2680: lload 6
    //   2682: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2685: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2688: aload 14
    //   2690: ldc 157
    //   2692: ldc 242
    //   2694: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2697: aload 14
    //   2699: ldc 244
    //   2701: aload 15
    //   2703: getfield 237	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2706: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2709: aload 14
    //   2711: ldc 191
    //   2713: iconst_1
    //   2714: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2717: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2720: aload_0
    //   2721: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2724: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2727: aload 14
    //   2729: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2732: pop
    //   2733: goto -1230 -> 1503
    //   2736: astore 12
    //   2738: aload 11
    //   2740: ifnull -1225 -> 1515
    //   2743: aload 11
    //   2745: invokeinterface 200 1 0
    //   2750: goto -1235 -> 1515
    //   2753: astore_1
    //   2754: aload 11
    //   2756: ifnull +10 -> 2766
    //   2759: aload 11
    //   2761: invokeinterface 200 1 0
    //   2766: aload_1
    //   2767: athrow
    //   2768: aload 14
    //   2770: invokevirtual 219	android/content/ContentValues:clear	()V
    //   2773: aload 14
    //   2775: ldc 153
    //   2777: lload 6
    //   2779: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2782: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2785: aload 14
    //   2787: ldc 157
    //   2789: ldc 242
    //   2791: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2794: aload 14
    //   2796: ldc 159
    //   2798: aload 15
    //   2800: getfield 240	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2803: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2806: aload 14
    //   2808: ldc 191
    //   2810: iconst_1
    //   2811: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2814: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2817: aload_0
    //   2818: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2821: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2824: aload 14
    //   2826: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2829: pop
    //   2830: goto -1046 -> 1784
    //   2833: astore 12
    //   2835: aload 11
    //   2837: ifnull -1041 -> 1796
    //   2840: aload 11
    //   2842: invokeinterface 200 1 0
    //   2847: goto -1051 -> 1796
    //   2850: astore_1
    //   2851: aload 11
    //   2853: ifnull +10 -> 2863
    //   2856: aload 11
    //   2858: invokeinterface 200 1 0
    //   2863: aload_1
    //   2864: athrow
    //   2865: aload 14
    //   2867: invokevirtual 219	android/content/ContentValues:clear	()V
    //   2870: aload 14
    //   2872: ldc 153
    //   2874: lload 6
    //   2876: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2879: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2882: aload 14
    //   2884: ldc 157
    //   2886: ldc 189
    //   2888: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2891: aload 14
    //   2893: ldc 159
    //   2895: aload 15
    //   2897: getfield 255	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2900: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2903: aload 14
    //   2905: ldc 191
    //   2907: iconst_3
    //   2908: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2911: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2914: aload_0
    //   2915: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2918: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2921: aload 14
    //   2923: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2926: pop
    //   2927: goto -850 -> 2077
    //   2930: astore 12
    //   2932: aload 11
    //   2934: ifnull -845 -> 2089
    //   2937: aload 11
    //   2939: invokeinterface 200 1 0
    //   2944: goto -855 -> 2089
    //   2947: astore_1
    //   2948: aload 11
    //   2950: ifnull +10 -> 2960
    //   2953: aload 11
    //   2955: invokeinterface 200 1 0
    //   2960: aload_1
    //   2961: athrow
    //   2962: aload 14
    //   2964: invokevirtual 219	android/content/ContentValues:clear	()V
    //   2967: aload 14
    //   2969: ldc 153
    //   2971: lload 6
    //   2973: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2976: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2979: aload 14
    //   2981: ldc 157
    //   2983: ldc_w 260
    //   2986: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2989: aload 14
    //   2991: ldc 159
    //   2993: aload 15
    //   2995: getfield 258	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2998: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3001: aload 14
    //   3003: ldc 191
    //   3005: iconst_2
    //   3006: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3009: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3012: aload_0
    //   3013: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3016: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3019: aload 14
    //   3021: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3024: pop
    //   3025: goto -652 -> 2373
    //   3028: astore 12
    //   3030: aload 11
    //   3032: ifnull -647 -> 2385
    //   3035: aload 11
    //   3037: invokeinterface 200 1 0
    //   3042: goto -657 -> 2385
    //   3045: astore_1
    //   3046: aload 11
    //   3048: ifnull +10 -> 3058
    //   3051: aload 11
    //   3053: invokeinterface 200 1 0
    //   3058: aload_1
    //   3059: athrow
    //   3060: aload 14
    //   3062: invokevirtual 219	android/content/ContentValues:clear	()V
    //   3065: aload 14
    //   3067: ldc 153
    //   3069: lload 6
    //   3071: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3074: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3077: aload 14
    //   3079: ldc 157
    //   3081: ldc_w 262
    //   3084: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3087: aload 14
    //   3089: ldc 159
    //   3091: aload_1
    //   3092: invokevirtual 234	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3095: aload 14
    //   3097: ldc 191
    //   3099: iconst_2
    //   3100: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3103: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3106: aload_0
    //   3107: invokevirtual 131	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3110: getstatic 137	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3113: aload 14
    //   3115: invokevirtual 210	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3118: pop
    //   3119: goto -462 -> 2657
    //   3122: astore_1
    //   3123: aload 11
    //   3125: ifnull -456 -> 2669
    //   3128: aload 11
    //   3130: invokeinterface 200 1 0
    //   3135: goto -466 -> 2669
    //   3138: astore_1
    //   3139: aload 11
    //   3141: ifnull +10 -> 3151
    //   3144: aload 11
    //   3146: invokeinterface 200 1 0
    //   3151: aload_1
    //   3152: athrow
    //   3153: iconst_m1
    //   3154: ireturn
    //   3155: astore_1
    //   3156: goto -17 -> 3139
    //   3159: astore_1
    //   3160: aconst_null
    //   3161: astore 11
    //   3163: goto -40 -> 3123
    //   3166: astore_1
    //   3167: goto -121 -> 3046
    //   3170: astore 11
    //   3172: aconst_null
    //   3173: astore 11
    //   3175: goto -145 -> 3030
    //   3178: astore_1
    //   3179: goto -231 -> 2948
    //   3182: astore 11
    //   3184: aconst_null
    //   3185: astore 11
    //   3187: goto -255 -> 2932
    //   3190: astore_1
    //   3191: goto -340 -> 2851
    //   3194: astore 11
    //   3196: aconst_null
    //   3197: astore 11
    //   3199: goto -364 -> 2835
    //   3202: astore_1
    //   3203: goto -449 -> 2754
    //   3206: astore 11
    //   3208: aconst_null
    //   3209: astore 11
    //   3211: goto -473 -> 2738
    //   3214: astore_1
    //   3215: goto -2146 -> 1069
    //   3218: astore 11
    //   3220: aconst_null
    //   3221: astore 11
    //   3223: iconst_0
    //   3224: istore_3
    //   3225: lconst_0
    //   3226: lstore 6
    //   3228: goto -2229 -> 999
    //   3231: astore 12
    //   3233: lload 8
    //   3235: lstore 6
    //   3237: goto -2238 -> 999
    //   3240: astore 12
    //   3242: lload 8
    //   3244: lstore 6
    //   3246: iconst_1
    //   3247: istore_3
    //   3248: goto -2249 -> 999
    //   3251: astore 16
    //   3253: aload 12
    //   3255: astore 14
    //   3257: aload 16
    //   3259: astore 12
    //   3261: goto -2235 -> 1026
    //   3264: astore 16
    //   3266: aload 12
    //   3268: astore 14
    //   3270: iconst_1
    //   3271: istore_2
    //   3272: aload 16
    //   3274: astore 12
    //   3276: goto -2250 -> 1026
    //   3279: astore 14
    //   3281: goto -2309 -> 972
    //   3284: astore 14
    //   3286: goto -2314 -> 972
    //   3289: lload 8
    //   3291: lstore 6
    //   3293: iload 5
    //   3295: istore_3
    //   3296: iload 4
    //   3298: istore_2
    //   3299: goto -2858 -> 441
    //   3302: iconst_1
    //   3303: istore_2
    //   3304: iconst_1
    //   3305: istore_3
    //   3306: goto -2887 -> 419
    //   3309: lload 8
    //   3311: lstore 6
    //   3313: goto -2894 -> 419
    //   3316: aconst_null
    //   3317: astore 13
    //   3319: goto -3240 -> 79
    //   3322: aconst_null
    //   3323: astore 15
    //   3325: goto -3279 -> 46
    //   3328: iload_3
    //   3329: istore_2
    //   3330: iconst_1
    //   3331: istore_3
    //   3332: lload 6
    //   3334: lstore 8
    //   3336: goto -3164 -> 172
    //   3339: astore 12
    //   3341: aconst_null
    //   3342: astore 12
    //   3344: goto -2372 -> 972
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3347	0	this	ProfileCardMoreActivity
    //   0	3347	1	paramString	String
    //   80	3250	2	i1	int
    //   82	3250	3	i2	int
    //   162	3135	4	i3	int
    //   420	2874	5	i4	int
    //   194	3139	6	l1	long
    //   165	3170	8	l2	long
    //   179	197	10	bool	boolean
    //   26	3136	11	localObject1	Object
    //   3170	1	11	localException1	Exception
    //   3173	1	11	localObject2	Object
    //   3182	1	11	localException2	Exception
    //   3185	1	11	localObject3	Object
    //   3194	1	11	localException3	Exception
    //   3197	1	11	localObject4	Object
    //   3206	1	11	localException4	Exception
    //   3209	1	11	localObject5	Object
    //   3218	1	11	localException5	Exception
    //   3221	1	11	localObject6	Object
    //   84	898	12	localObject7	Object
    //   993	1	12	localException6	Exception
    //   1024	21	12	localObject8	Object
    //   1047	19	12	localException7	Exception
    //   1249	1265	12	localObject9	Object
    //   2736	1	12	localException8	Exception
    //   2833	1	12	localException9	Exception
    //   2930	1	12	localException10	Exception
    //   3028	1	12	localException11	Exception
    //   3231	1	12	localException12	Exception
    //   3240	14	12	localException13	Exception
    //   3259	16	12	localObject10	Object
    //   3339	1	12	localException14	Exception
    //   3342	1	12	localObject11	Object
    //   77	3241	13	localObject12	Object
    //   95	3174	14	localObject13	Object
    //   3279	1	14	localException15	Exception
    //   3284	1	14	localException16	Exception
    //   44	3280	15	localObject14	Object
    //   122	2095	16	localObject15	Object
    //   3251	7	16	localObject16	Object
    //   3264	9	16	localObject17	Object
    //   322	36	17	str	String
    // Exception table:
    //   from	to	target	type
    //   408	415	993	java/lang/Exception
    //   960	967	993	java/lang/Exception
    //   981	988	993	java/lang/Exception
    //   214	366	1024	finally
    //   199	206	1047	java/lang/Exception
    //   1034	1041	1047	java/lang/Exception
    //   1044	1047	1047	java/lang/Exception
    //   86	161	1064	finally
    //   1373	1503	2736	java/lang/Exception
    //   2671	2733	2736	java/lang/Exception
    //   1245	1369	2753	finally
    //   1654	1784	2833	java/lang/Exception
    //   2768	2830	2833	java/lang/Exception
    //   1526	1650	2850	finally
    //   1935	2077	2930	java/lang/Exception
    //   2865	2927	2930	java/lang/Exception
    //   1807	1931	2947	finally
    //   2229	2373	3028	java/lang/Exception
    //   2962	3025	3028	java/lang/Exception
    //   2100	2225	3045	finally
    //   2517	2657	3122	java/lang/Exception
    //   3060	3119	3122	java/lang/Exception
    //   2388	2513	3138	finally
    //   2517	2657	3155	finally
    //   3060	3119	3155	finally
    //   2388	2513	3159	java/lang/Exception
    //   2229	2373	3166	finally
    //   2962	3025	3166	finally
    //   2100	2225	3170	java/lang/Exception
    //   1935	2077	3178	finally
    //   2865	2927	3178	finally
    //   1807	1931	3182	java/lang/Exception
    //   1654	1784	3190	finally
    //   2768	2830	3190	finally
    //   1526	1650	3194	java/lang/Exception
    //   1373	1503	3202	finally
    //   2671	2733	3202	finally
    //   1245	1369	3206	java/lang/Exception
    //   172	181	3214	finally
    //   186	196	3214	finally
    //   199	206	3214	finally
    //   408	415	3214	finally
    //   960	967	3214	finally
    //   981	988	3214	finally
    //   1034	1041	3214	finally
    //   1044	1047	3214	finally
    //   86	161	3218	java/lang/Exception
    //   172	181	3231	java/lang/Exception
    //   186	196	3240	java/lang/Exception
    //   366	375	3251	finally
    //   393	400	3264	finally
    //   366	375	3279	java/lang/Exception
    //   393	400	3284	java/lang/Exception
    //   214	366	3339	java/lang/Exception
  }
  
  private void a(int paramInt1, FormSimpleItem paramFormSimpleItem, View paramView, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSimpleItem == null)) {}
    label102:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ArrayOfInt[paramInt1] != 1) {
            break label102;
          }
          paramFormSimpleItem.setVisibility(0);
          paramFormSimpleItem.setOnClickListener(this);
          if ((paramInt1 != paramInt2) || (paramInt1 != paramInt3)) {
            break;
          }
          paramFormSimpleItem.setBgType(0);
        } while (paramView == null);
        paramView.setVisibility(8);
        return;
        if (paramInt1 != paramInt2) {
          break;
        }
        paramFormSimpleItem.setBgType(1);
      } while (paramView == null);
      paramView.setVisibility(8);
      return;
      if (paramInt1 == paramInt3)
      {
        paramFormSimpleItem.setBgType(3);
        return;
      }
      paramFormSimpleItem.setBgType(2);
      return;
      paramFormSimpleItem.setVisibility(8);
    } while (paramView == null);
    paramView.setVisibility(8);
  }
  
  private String c()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.app, this.jdField_a_of_type_JavaLangString);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  private boolean c()
  {
    ShieldMsgManger localShieldMsgManger = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger == null) {
        break label152;
      }
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localShieldMsgManger.a((String)localObject);
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject == null) {}
      for (localObject = localShieldMsgManger; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = c();
      }
    }
    label152:
    return false;
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(String paramString)
  {
    DialogUtil.a(this, 230).setTitle(getString(2131363423)).setMessage(getString(2131363431)).setPositiveButton(2131362928, new bbb(this, paramString)).setNegativeButton(2131363114, new bba(this)).show();
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger != null) {}
      for (;;)
      {
        int i1;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = c();
          }
          long l1 = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l1));
          i1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localShieldMsgManger.b(i1, (List)localObject);
            i1 = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            i2 = i1;
            if (i2 == 0) {
              break label302;
            }
            if (paramBoolean) {
              break label297;
            }
            paramBoolean = bool;
            this.jdField_a_of_type_Boolean = paramBoolean;
            this.l |= 0x2;
            g();
            return;
            localShieldMsgManger.a(i1, (List)localObject);
            continue;
            i1 = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              i2 = 1;
              break;
              this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label297:
            paramBoolean = false;
          }
        }
      }
      label302:
      if (paramBoolean) {
        a(2131363416, 1);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        return;
        a(2131363415, 1);
      }
    }
    a(2131362790, 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    h();
    if ((this.l & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label72;
      }
      if (!paramBoolean2) {
        break label61;
      }
      a(2131363417, 2);
    }
    for (;;)
    {
      this.l &= 0xFFFFFFFD;
      this.jdField_a_of_type_Boolean = c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
      return;
      label61:
      a(2131363413, 2);
      continue;
      label72:
      if (paramBoolean2) {
        a(2131363416, 1);
      } else {
        a(2131363415, 1);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F), 0, paramInt2);
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (paramString = "";; paramString = this.jdField_b_of_type_JavaLangString)
    {
      localFormSimpleItem.setRightText(paramString);
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_b_of_type_JavaLangString);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  void c()
  {
    setContentViewB(2130903520);
    setTitle(2131364369);
    this.j.setVisibility(8);
    Object localObject1 = findViewById(2131296770);
    label88:
    int i2;
    int i5;
    if (this.jdField_a_of_type_ArrayOfInt[6] == 1)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131296780);
      if (this.jdField_a_of_type_ArrayOfInt[7] != 1) {
        break label189;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      i2 = -1;
      i5 = -1;
      if (!BmqqSegmentUtil.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label199;
      }
    }
    int i1;
    int i3;
    label189:
    label199:
    for (int i4 = 3;; i4 = 2)
    {
      i1 = 0;
      while (i1 <= i4)
      {
        int i6 = i2;
        int i7 = i5;
        if (this.jdField_a_of_type_ArrayOfInt[i1] == 1)
        {
          i3 = i2;
          if (i2 < 0) {
            i3 = i1;
          }
          i6 = i3;
          i7 = i5;
          if (i5 < i1)
          {
            i7 = i1;
            i6 = i3;
          }
        }
        i1 += 1;
        i2 = i6;
        i5 = i7;
      }
      ((View)localObject1).setVisibility(8);
      break;
      ((View)localObject1).setVisibility(8);
      break label88;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298369));
    a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, null, i2, i5);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298371));
    localObject1 = findViewById(2131298370);
    a(1, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, (View)localObject1, i2, i5);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298373));
    localObject1 = findViewById(2131298372);
    a(2, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, (View)localObject1, i2, i5);
    this.d = ((FormSimpleItem)findViewById(2131298375));
    localObject1 = findViewById(2131298374);
    if (BmqqSegmentUtil.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      a(3, this.d, (View)localObject1, i2, i5);
      i3 = -1;
      i2 = -1;
      i1 = 4;
      label366:
      if (i1 > 5) {
        break label420;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i1] != 1) {
        break label813;
      }
      if (i3 >= 0) {
        break label810;
      }
      i3 = i1;
      label387:
      if (i2 >= i1) {
        break label807;
      }
      i2 = i1;
    }
    label420:
    label807:
    label810:
    label813:
    for (;;)
    {
      i1 += 1;
      break label366;
      this.d.setVisibility(8);
      ((View)localObject1).setVisibility(8);
      break;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296768));
      localObject1 = findViewById(2131298376);
      label503:
      Object localObject2;
      if (this.jdField_a_of_type_ArrayOfInt[4] == 1) {
        if ((4 == i3) && (4 == i2))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          ((View)localObject1).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("屏蔽此人");
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            localObject2 = (FriendManager)this.app.getManager(8);
            if (localObject2 != null) {
              break label770;
            }
            localObject1 = null;
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
              localObject1 = ((FriendManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject1 != null) && (!Utils.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject1).group_name))) {
                this.jdField_c_of_type_JavaLangString = ((Groups)localObject1).group_name;
              }
            }
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
            {
              localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
              if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
                break label789;
              }
              localObject1 = "";
              label626:
              ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            }
            if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
            {
              localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
              if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                break label798;
              }
            }
          }
        }
      }
      for (localObject1 = "";; localObject1 = this.jdField_c_of_type_JavaLangString)
      {
        ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
        if (this.jdField_a_of_type_ArrayOfInt[4] == 1)
        {
          this.jdField_a_of_type_Boolean = c();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        }
        return;
        if (4 == i3)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
          ((View)localObject1).setVisibility(8);
          break;
        }
        if (4 == i2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        break;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        ((View)localObject1).setVisibility(8);
        break label503;
        localObject1 = ((FriendManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label535;
        localObject1 = this.jdField_b_of_type_JavaLangString;
        break label626;
      }
      continue;
      break label387;
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[8];
    int i1 = 0;
    while (i1 < 8)
    {
      this.jdField_a_of_type_ArrayOfInt[i1] = 0;
      i1 += 1;
    }
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 1;
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[2] = 1;
      if (BmqqSegmentUtil.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ArrayOfInt[3] = 1;
      }
      this.jdField_a_of_type_ArrayOfInt[5] = 1;
      this.jdField_a_of_type_ArrayOfInt[6] = 1;
      this.jdField_a_of_type_ArrayOfInt[7] = 1;
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
      {
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27)
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        return;
      }
    } while (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    this.jdField_a_of_type_ArrayOfInt[7] = 1;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    Object localObject;
    if (paramInt2 == -1) {
      localObject = null;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramIntent != null) {
      localObject = paramIntent.getStringExtra("result");
    }
    if (localObject == null) {}
    for (paramIntent = "";; paramIntent = (Intent)localObject)
    {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        if (!paramIntent.equals(this.jdField_b_of_type_JavaLangString))
        {
          localObject = (FriendListHandler)this.app.a(1);
          if (localObject != null)
          {
            ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent, false);
            this.l |= 0x1;
            b(paramIntent);
            return;
          }
          a(2131363890, 1);
          return;
        }
        a(2131363889, 0);
        return;
      }
      a(2131363449, 1);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    d();
    c();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    h();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  void e()
  {
    Object localObject1 = (FriendManager)this.app.getManager(8);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label180;
      }
    }
    label175:
    label180:
    for (Object localObject2 = ((Card)localObject1).strReMark;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {}
      }
      else
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 30)
        {
          localObject1 = a();
          if (localObject1 == null) {
            break label175;
          }
        }
      }
      for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;; localObject1 = null)
      {
        localObject2 = new Intent(this, EditActivity.class);
        boolean bool = true;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          bool = false;
        }
        ((Intent)localObject2).putExtra("title", 2131363031).putExtra("limit", 96).putExtra("current", (String)localObject1).putExtra("canPostNull", bool).putExtra("multiLine", false);
        startActivityForResult((Intent)localObject2, 1003);
        return;
        localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
    }
  }
  
  void f()
  {
    Object localObject = (FriendManager)this.app.getManager(8);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363381);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_a_of_type_Boolean == paramBoolean)) {
      return;
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1;
    if (paramView == null) {
      i1 = 0;
    }
    switch (i1)
    {
    default: 
    case 2131298369: 
    case 2131298371: 
    case 2131298373: 
    case 2131298375: 
      do
      {
        long l1;
        do
        {
          return;
          i1 = paramView.getId();
          break;
          l1 = System.currentTimeMillis();
        } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
        this.jdField_a_of_type_Long = l1;
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this);
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_more", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        e();
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        f();
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.a().post(new bbh(this));
      return;
    case 2131296770: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
      for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; paramView = null)
      {
        a(paramView);
        return;
      }
    }
    ProfileCardUtil.a(this, Long.toString(ProfileCardUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getAccount(), false);
    ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */