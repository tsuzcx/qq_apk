import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.SimpleJob;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.5.1;
import mqq.os.MqqHandler;

public class ayiz
  extends SimpleJob<Bitmap>
{
  public ayiz(LocalVideoSelectActivity paramLocalVideoSelectActivity, String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    super(paramString);
  }
  
  /* Error */
  protected Bitmap a(@android.support.annotation.NonNull com.tribe.async.async.JobContext paramJobContext, @Nullable java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 13	ayiz:this$0	Ldov/com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;
    //   9: invokevirtual 31	dov/com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore 4
    //   14: aload 4
    //   16: getstatic 37	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   19: aconst_null
    //   20: ldc 39
    //   22: iconst_1
    //   23: anewarray 41	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: getfield 15	ayiz:b	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   32: getfield 47	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   35: invokestatic 51	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   38: aastore
    //   39: aconst_null
    //   40: invokestatic 57	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +200 -> 245
    //   48: aload_2
    //   49: invokeinterface 63 1 0
    //   54: ifeq +186 -> 240
    //   57: aload 4
    //   59: aload_0
    //   60: getfield 15	ayiz:b	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   63: getfield 47	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   66: iconst_1
    //   67: aconst_null
    //   68: invokestatic 69	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: astore 5
    //   73: aload 5
    //   75: astore_1
    //   76: aload 5
    //   78: ifnonnull +18 -> 96
    //   81: aload 4
    //   83: aload_0
    //   84: getfield 15	ayiz:b	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   87: getfield 47	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   90: iconst_3
    //   91: aconst_null
    //   92: invokestatic 69	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   95: astore_1
    //   96: aload_1
    //   97: astore 5
    //   99: aload_2
    //   100: invokeinterface 72 1 0
    //   105: istore_3
    //   106: iload_3
    //   107: ifne -11 -> 96
    //   110: aload_1
    //   111: astore 4
    //   113: aload_2
    //   114: ifnull +120 -> 234
    //   117: aload_2
    //   118: invokeinterface 76 1 0
    //   123: aload_1
    //   124: astore_2
    //   125: aload_1
    //   126: ifnonnull +14 -> 140
    //   129: invokestatic 81	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   132: getfield 84	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr;
    //   135: iconst_0
    //   136: invokevirtual 89	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:b	(Z)Landroid/graphics/Bitmap;
    //   139: astore_2
    //   140: aload_2
    //   141: areturn
    //   142: astore 4
    //   144: aconst_null
    //   145: astore 5
    //   147: aload_1
    //   148: astore_2
    //   149: aload 5
    //   151: astore_1
    //   152: aload_2
    //   153: astore 5
    //   155: ldc 91
    //   157: ldc 93
    //   159: iconst_2
    //   160: anewarray 95	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 15	ayiz:b	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   169: getfield 99	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload 4
    //   177: aastore
    //   178: invokestatic 105	ram:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aload_1
    //   182: astore 4
    //   184: aload_2
    //   185: ifnull +49 -> 234
    //   188: aload_2
    //   189: invokeinterface 76 1 0
    //   194: goto -71 -> 123
    //   197: astore_1
    //   198: aload 5
    //   200: ifnull +10 -> 210
    //   203: aload 5
    //   205: invokeinterface 76 1 0
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: aload_2
    //   214: astore 5
    //   216: goto -18 -> 198
    //   219: astore 4
    //   221: aconst_null
    //   222: astore_1
    //   223: goto -71 -> 152
    //   226: astore 4
    //   228: aload 5
    //   230: astore_1
    //   231: goto -79 -> 152
    //   234: aload 4
    //   236: astore_1
    //   237: goto -114 -> 123
    //   240: aconst_null
    //   241: astore_1
    //   242: goto -146 -> 96
    //   245: aconst_null
    //   246: astore_1
    //   247: goto -137 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	ayiz
    //   0	250	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	250	2	paramVarArgs	java.lang.Void[]
    //   105	2	3	bool	boolean
    //   12	100	4	localObject1	java.lang.Object
    //   142	34	4	localException1	java.lang.Exception
    //   182	1	4	localJobContext	com.tribe.async.async.JobContext
    //   219	1	4	localException2	java.lang.Exception
    //   226	9	4	localException3	java.lang.Exception
    //   1	228	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   14	44	142	java/lang/Exception
    //   14	44	197	finally
    //   155	181	197	finally
    //   48	73	212	finally
    //   81	96	212	finally
    //   99	106	212	finally
    //   48	73	219	java/lang/Exception
    //   81	96	226	java/lang/Exception
    //   99	106	226	java/lang/Exception
  }
  
  protected void ar(@Nullable Bitmap paramBitmap)
  {
    super.onResult(paramBitmap);
    ThreadManager.getUIHandler().post(new LocalVideoSelectActivity.5.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayiz
 * JD-Core Version:    0.7.0.1
 */