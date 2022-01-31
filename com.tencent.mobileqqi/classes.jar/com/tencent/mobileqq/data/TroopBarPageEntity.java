package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONException;
import org.json.JSONObject;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="id")
public class TroopBarPageEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_CONTINUE_SIGN_DAYS = "continue";
  protected static final String JSON_KEY_COVER = "cover";
  protected static final String JSON_KEY_CREATE_TIME = "create_time";
  protected static final String JSON_KEY_ERRNO = "errno";
  protected static final String JSON_KEY_EXSIT = "exsit";
  protected static final String JSON_KEY_FANS = "fans";
  protected static final String JSON_KEY_FLAG = "flag";
  protected static final String JSON_KEY_GROUP_COUNT = "group_count";
  protected static final String JSON_KEY_ICON_LISTS = "icon_list";
  protected static final String JSON_KEY_INTRO = "intro";
  protected static final String JSON_KEY_KEY_WORD = "key_word";
  protected static final String JSON_KEY_LOCATION = "location";
  protected static final String JSON_KEY_NAME = "name";
  protected static final String JSON_KEY_PAGE_LEVEL = "level";
  protected static final String JSON_KEY_PAGE_TYPE_LIST = "typelist";
  protected static final String JSON_KEY_PIC = "pic";
  protected static final String JSON_KEY_PIDS = "pids";
  protected static final String JSON_KEY_POST_CORNER_IMG_PREFIX = "subscript_icon_prefix";
  protected static final String JSON_KEY_RCMD_GROUND_NUM = "rcmdGroupNum";
  protected static final String JSON_KEY_RECOMMEND = "recommend";
  protected static final String JSON_KEY_RECOMMEND_PIDS = "recommend_pids";
  protected static final String JSON_KEY_RED_POINT_FLAG = "red_point_flag";
  protected static final String JSON_KEY_SIGN = "sign";
  protected static final String JSON_KEY_STAR_GROUP = "stargroup";
  protected static final String JSON_KEY_TODAY_PIDS = "today_pids";
  protected static final String JSON_KEY_TROOP_BAR = "bar";
  protected static final String JSON_KEY_USER_LEVEL_BIG_ICON_PREFIX = "big_grade_icon_prefix";
  protected static final String JSON_KEY_USER_LEVEL_SMALL_ICON_PREFIX = "small_grade_icon_prefix";
  private static final String TAG = "TroopBarPageEntity";
  protected static final int TROOP_BAR_EXSIT = 1;
  protected static final int TROOP_BAR_SIGN = 1;
  public static String sPostCornerImgPrefix;
  public static String sUserLevelBigIconPrefix;
  public static String sUserLevelSmallIconPrefix;
  public int continueSignDays;
  public String cover;
  public long create_time;
  @notColumn
  public TroopBarPageEntity.TypeListEntity curType = null;
  public int errno;
  public boolean exsit;
  public int fans;
  public int flag;
  public int group_count;
  public byte[] iconListBytes;
  public String intro;
  public String key_word;
  public String location;
  public String name;
  public String pic;
  public int pids;
  public int publishContent_Max_Word;
  public int publishContent_Min_Word;
  public int publishTitle_Max_Word;
  public int publishTitle_Min_Word;
  public int rcmdGroupNum;
  public byte[] recommendArrayBytes;
  public int recommend_pids;
  public int red_point_flag;
  public boolean sign;
  public int stargroup;
  public String test;
  public int today_pids;
  public byte[] troopBarBytes;
  public byte[] troopbarLevelBytes;
  public byte[] typeListBytes;
  
  /* Error */
  public java.util.ArrayList getIconListEntitys()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 139	com/tencent/mobileqq/data/TroopBarPageEntity:iconListBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 139	com/tencent/mobileqq/data/TroopBarPageEntity:iconListBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 155
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 155	java/util/ArrayList
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	java.lang.Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	java.lang.Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public TroopBarLevelEntity getLevel()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 163	com/tencent/mobileqq/data/TroopBarPageEntity:troopbarLevelBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 163	com/tencent/mobileqq/data/TroopBarPageEntity:troopbarLevelBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 165
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 165	com/tencent/mobileqq/data/TroopBarLevelEntity
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	java.lang.Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	java.lang.Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public java.util.ArrayList getRecommendArray()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 168	com/tencent/mobileqq/data/TroopBarPageEntity:recommendArrayBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 168	com/tencent/mobileqq/data/TroopBarPageEntity:recommendArrayBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 155
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 155	java/util/ArrayList
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	java.lang.Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	java.lang.Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public java.util.ArrayList getTypeList()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 171	com/tencent/mobileqq/data/TroopBarPageEntity:typeListBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 171	com/tencent/mobileqq/data/TroopBarPageEntity:typeListBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 155
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 155	java/util/ArrayList
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	java.lang.Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	java.lang.Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  public void readExternal(ObjectInput paramObjectInput) {}
  
  /* Error */
  public void refreshData(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_1
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: aload_1
    //   13: ldc 23
    //   15: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   18: putfield 185	com/tencent/mobileqq/data/TroopBarPageEntity:errno	I
    //   21: aload_0
    //   22: getfield 185	com/tencent/mobileqq/data/TroopBarPageEntity:errno	I
    //   25: ifne -15 -> 10
    //   28: new 187	com/tencent/mobileqq/data/TroopBarPageEntity$TroopBar
    //   31: dup
    //   32: aload_1
    //   33: ldc 89
    //   35: invokevirtual 193	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   38: invokespecial 195	com/tencent/mobileqq/data/TroopBarPageEntity$TroopBar:<init>	(Lorg/json/JSONObject;)V
    //   41: astore 6
    //   43: aload_0
    //   44: ldc 196
    //   46: putfield 198	com/tencent/mobileqq/data/TroopBarPageEntity:test	Ljava/lang/String;
    //   49: aload_0
    //   50: aload_1
    //   51: ldc 17
    //   53: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 203	com/tencent/mobileqq/data/TroopBarPageEntity:cover	Ljava/lang/String;
    //   59: aload_0
    //   60: aload_1
    //   61: ldc 62
    //   63: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   66: putfield 205	com/tencent/mobileqq/data/TroopBarPageEntity:pids	I
    //   69: aload_0
    //   70: aload_1
    //   71: ldc 29
    //   73: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   76: putfield 207	com/tencent/mobileqq/data/TroopBarPageEntity:fans	I
    //   79: aload_0
    //   80: aload_1
    //   81: ldc 86
    //   83: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   86: putfield 209	com/tencent/mobileqq/data/TroopBarPageEntity:today_pids	I
    //   89: aload_0
    //   90: aload_1
    //   91: ldc 20
    //   93: invokestatic 212	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)J
    //   96: putfield 214	com/tencent/mobileqq/data/TroopBarPageEntity:create_time	J
    //   99: aload_0
    //   100: aload_1
    //   101: ldc 59
    //   103: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   106: putfield 216	com/tencent/mobileqq/data/TroopBarPageEntity:pic	Ljava/lang/String;
    //   109: aload_0
    //   110: aload_1
    //   111: ldc 74
    //   113: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   116: putfield 218	com/tencent/mobileqq/data/TroopBarPageEntity:recommend_pids	I
    //   119: aload_0
    //   120: aload_1
    //   121: ldc 41
    //   123: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   126: putfield 220	com/tencent/mobileqq/data/TroopBarPageEntity:intro	Ljava/lang/String;
    //   129: aload_0
    //   130: aload_1
    //   131: ldc 32
    //   133: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   136: putfield 222	com/tencent/mobileqq/data/TroopBarPageEntity:flag	I
    //   139: aload_0
    //   140: aload_1
    //   141: ldc 50
    //   143: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   146: putfield 224	com/tencent/mobileqq/data/TroopBarPageEntity:name	Ljava/lang/String;
    //   149: aload_0
    //   150: aload_1
    //   151: ldc 14
    //   153: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   156: putfield 226	com/tencent/mobileqq/data/TroopBarPageEntity:continueSignDays	I
    //   159: aload_0
    //   160: aload_1
    //   161: ldc 14
    //   163: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   166: putfield 226	com/tencent/mobileqq/data/TroopBarPageEntity:continueSignDays	I
    //   169: aload_1
    //   170: ldc 65
    //   172: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   175: putstatic 228	com/tencent/mobileqq/data/TroopBarPageEntity:sPostCornerImgPrefix	Ljava/lang/String;
    //   178: aload_1
    //   179: ldc 92
    //   181: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   184: putstatic 230	com/tencent/mobileqq/data/TroopBarPageEntity:sUserLevelBigIconPrefix	Ljava/lang/String;
    //   187: aload_1
    //   188: ldc 95
    //   190: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   193: putstatic 232	com/tencent/mobileqq/data/TroopBarPageEntity:sUserLevelSmallIconPrefix	Ljava/lang/String;
    //   196: new 155	java/util/ArrayList
    //   199: dup
    //   200: invokespecial 233	java/util/ArrayList:<init>	()V
    //   203: astore 8
    //   205: aload_1
    //   206: ldc 71
    //   208: invokevirtual 237	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   211: astore 9
    //   213: iconst_0
    //   214: istore_2
    //   215: aload 8
    //   217: astore 7
    //   219: iload_2
    //   220: aload 9
    //   222: invokevirtual 243	org/json/JSONArray:length	()I
    //   225: if_icmpge +42 -> 267
    //   228: aload 8
    //   230: new 245	com/tencent/mobileqq/data/TroopBarPageEntity$Recommend
    //   233: dup
    //   234: aload 9
    //   236: iload_2
    //   237: invokevirtual 248	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   240: invokespecial 249	com/tencent/mobileqq/data/TroopBarPageEntity$Recommend:<init>	(Lorg/json/JSONObject;)V
    //   243: invokevirtual 253	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   246: pop
    //   247: iload_2
    //   248: iconst_1
    //   249: iadd
    //   250: istore_2
    //   251: goto -36 -> 215
    //   254: astore 6
    //   256: aconst_null
    //   257: astore 6
    //   259: goto -216 -> 43
    //   262: astore 7
    //   264: aconst_null
    //   265: astore 7
    //   267: aload_0
    //   268: aload_1
    //   269: ldc 47
    //   271: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   274: putfield 255	com/tencent/mobileqq/data/TroopBarPageEntity:location	Ljava/lang/String;
    //   277: aload_1
    //   278: ldc 26
    //   280: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   283: iconst_1
    //   284: if_icmpne +151 -> 435
    //   287: iconst_1
    //   288: istore_3
    //   289: aload_0
    //   290: iload_3
    //   291: putfield 257	com/tencent/mobileqq/data/TroopBarPageEntity:exsit	Z
    //   294: aload_0
    //   295: aload_1
    //   296: ldc 68
    //   298: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   301: putfield 259	com/tencent/mobileqq/data/TroopBarPageEntity:rcmdGroupNum	I
    //   304: aload_0
    //   305: aload_1
    //   306: ldc 83
    //   308: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   311: putfield 261	com/tencent/mobileqq/data/TroopBarPageEntity:stargroup	I
    //   314: aload_0
    //   315: aload_1
    //   316: ldc 35
    //   318: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   321: putfield 263	com/tencent/mobileqq/data/TroopBarPageEntity:group_count	I
    //   324: aload_1
    //   325: ldc 80
    //   327: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   330: iconst_1
    //   331: if_icmpne +109 -> 440
    //   334: iload 4
    //   336: istore_3
    //   337: aload_0
    //   338: iload_3
    //   339: putfield 265	com/tencent/mobileqq/data/TroopBarPageEntity:sign	Z
    //   342: aload_0
    //   343: aload_1
    //   344: ldc 44
    //   346: invokestatic 201	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   349: putfield 267	com/tencent/mobileqq/data/TroopBarPageEntity:key_word	Ljava/lang/String;
    //   352: aload_0
    //   353: aload_1
    //   354: ldc 77
    //   356: invokestatic 183	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   359: putfield 269	com/tencent/mobileqq/data/TroopBarPageEntity:red_point_flag	I
    //   362: new 165	com/tencent/mobileqq/data/TroopBarLevelEntity
    //   365: dup
    //   366: aload_1
    //   367: ldc 53
    //   369: invokevirtual 193	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   372: invokespecial 270	com/tencent/mobileqq/data/TroopBarLevelEntity:<init>	(Lorg/json/JSONObject;)V
    //   375: astore 8
    //   377: new 155	java/util/ArrayList
    //   380: dup
    //   381: invokespecial 233	java/util/ArrayList:<init>	()V
    //   384: astore 9
    //   386: aload_1
    //   387: ldc 56
    //   389: invokevirtual 237	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   392: astore 10
    //   394: iconst_0
    //   395: istore_2
    //   396: aload 9
    //   398: astore 5
    //   400: iload_2
    //   401: aload 10
    //   403: invokevirtual 243	org/json/JSONArray:length	()I
    //   406: if_icmpge +49 -> 455
    //   409: aload 9
    //   411: new 272	com/tencent/mobileqq/data/TroopBarPageEntity$TypeListEntity
    //   414: dup
    //   415: aload 10
    //   417: iload_2
    //   418: invokevirtual 248	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   421: invokespecial 273	com/tencent/mobileqq/data/TroopBarPageEntity$TypeListEntity:<init>	(Lorg/json/JSONObject;)V
    //   424: invokevirtual 253	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   427: pop
    //   428: iload_2
    //   429: iconst_1
    //   430: iadd
    //   431: istore_2
    //   432: goto -36 -> 396
    //   435: iconst_0
    //   436: istore_3
    //   437: goto -148 -> 289
    //   440: iconst_0
    //   441: istore_3
    //   442: goto -105 -> 337
    //   445: astore 8
    //   447: aconst_null
    //   448: astore 8
    //   450: goto -73 -> 377
    //   453: astore 9
    //   455: aload_1
    //   456: ldc 38
    //   458: invokevirtual 237	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   461: astore_1
    //   462: new 155	java/util/ArrayList
    //   465: dup
    //   466: invokespecial 233	java/util/ArrayList:<init>	()V
    //   469: astore 9
    //   471: iconst_0
    //   472: istore_2
    //   473: iload_2
    //   474: aload_1
    //   475: invokevirtual 243	org/json/JSONArray:length	()I
    //   478: if_icmpge +28 -> 506
    //   481: aload 9
    //   483: new 275	com/tencent/mobileqq/data/TroopBarIconFlagEntity
    //   486: dup
    //   487: aload_1
    //   488: iload_2
    //   489: invokevirtual 248	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   492: invokespecial 276	com/tencent/mobileqq/data/TroopBarIconFlagEntity:<init>	(Lorg/json/JSONObject;)V
    //   495: invokevirtual 253	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   498: pop
    //   499: iload_2
    //   500: iconst_1
    //   501: iadd
    //   502: istore_2
    //   503: goto -30 -> 473
    //   506: aload_0
    //   507: aload 9
    //   509: invokestatic 279	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/Object;)[B
    //   512: putfield 139	com/tencent/mobileqq/data/TroopBarPageEntity:iconListBytes	[B
    //   515: aload 6
    //   517: ifnull +55 -> 572
    //   520: aload_0
    //   521: aload 6
    //   523: invokestatic 279	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/Object;)[B
    //   526: putfield 281	com/tencent/mobileqq/data/TroopBarPageEntity:troopBarBytes	[B
    //   529: aload 5
    //   531: ifnull +12 -> 543
    //   534: aload_0
    //   535: aload 5
    //   537: invokestatic 279	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/Object;)[B
    //   540: putfield 171	com/tencent/mobileqq/data/TroopBarPageEntity:typeListBytes	[B
    //   543: aload 7
    //   545: ifnull +37 -> 582
    //   548: aload_0
    //   549: aload 7
    //   551: invokestatic 279	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/Object;)[B
    //   554: putfield 168	com/tencent/mobileqq/data/TroopBarPageEntity:recommendArrayBytes	[B
    //   557: aload 8
    //   559: ifnull +33 -> 592
    //   562: aload_0
    //   563: aload 8
    //   565: invokestatic 279	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/Object;)[B
    //   568: putfield 163	com/tencent/mobileqq/data/TroopBarPageEntity:troopbarLevelBytes	[B
    //   571: return
    //   572: aload_0
    //   573: iconst_0
    //   574: newarray byte
    //   576: putfield 281	com/tencent/mobileqq/data/TroopBarPageEntity:troopBarBytes	[B
    //   579: goto -50 -> 529
    //   582: aload_0
    //   583: iconst_0
    //   584: newarray byte
    //   586: putfield 168	com/tencent/mobileqq/data/TroopBarPageEntity:recommendArrayBytes	[B
    //   589: goto -32 -> 557
    //   592: aload_0
    //   593: iconst_0
    //   594: newarray byte
    //   596: putfield 163	com/tencent/mobileqq/data/TroopBarPageEntity:troopbarLevelBytes	[B
    //   599: return
    //   600: astore_1
    //   601: goto -86 -> 515
    //   604: astore 5
    //   606: aload 9
    //   608: astore 5
    //   610: goto -155 -> 455
    //   613: astore 7
    //   615: aload 8
    //   617: astore 7
    //   619: goto -352 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	TroopBarPageEntity
    //   0	622	1	paramJSONObject	JSONObject
    //   214	289	2	i	int
    //   288	154	3	bool1	boolean
    //   4	331	4	bool2	boolean
    //   1	535	5	localObject1	java.lang.Object
    //   604	1	5	localJSONException1	JSONException
    //   608	1	5	localObject2	java.lang.Object
    //   41	1	6	localTroopBar	TroopBarPageEntity.TroopBar
    //   254	1	6	localJSONException2	JSONException
    //   257	265	6	localObject3	java.lang.Object
    //   217	1	7	localObject4	java.lang.Object
    //   262	1	7	localJSONException3	JSONException
    //   265	285	7	localObject5	java.lang.Object
    //   613	1	7	localJSONException4	JSONException
    //   617	1	7	localObject6	java.lang.Object
    //   203	173	8	localObject7	java.lang.Object
    //   445	1	8	localJSONException5	JSONException
    //   448	168	8	localObject8	java.lang.Object
    //   211	199	9	localObject9	java.lang.Object
    //   453	1	9	localJSONException6	JSONException
    //   469	138	9	localArrayList	java.util.ArrayList
    //   392	24	10	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   28	43	254	org/json/JSONException
    //   196	205	262	org/json/JSONException
    //   362	377	445	org/json/JSONException
    //   377	386	453	org/json/JSONException
    //   455	471	600	org/json/JSONException
    //   473	499	600	org/json/JSONException
    //   506	515	600	org/json/JSONException
    //   386	394	604	org/json/JSONException
    //   400	428	604	org/json/JSONException
    //   205	213	613	org/json/JSONException
    //   219	247	613	org/json/JSONException
  }
  
  public void updateBannerDataAfterAction(String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if ((paramString == null) || (paramJSONObject == null)) {}
    do
    {
      return;
      if (paramString.equals("sign_in"))
      {
        this.sign = true;
        this.troopbarLevelBytes = TroopBarUtils.a(new TroopBarLevelEntity(paramJSONObject));
        return;
      }
    } while (!paramString.equals("follow"));
    this.exsit = true;
    if (TroopBarUtils.a(paramJSONObject, "sign") == 1) {}
    for (;;)
    {
      this.sign = bool;
      try
      {
        this.troopbarLevelBytes = TroopBarUtils.a(new TroopBarLevelEntity(paramJSONObject.getJSONObject("level")));
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TroopBarPageEntity", 2, "updateBannerDataAfterAction-->JSONException");
      return;
      bool = false;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPageEntity
 * JD-Core Version:    0.7.0.1
 */