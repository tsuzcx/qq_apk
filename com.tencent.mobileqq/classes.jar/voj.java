import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class voj
  extends vtt
{
  protected final Object a;
  protected final ArrayList<String> a;
  protected final ConcurrentHashMap<String, vom> a;
  protected AtomicBoolean a;
  private voo a;
  protected final Object b = new Object();
  
  public voj()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(3);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(3);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Voo = new voo();
  }
  
  public static int a(String paramString)
  {
    long l = System.currentTimeMillis();
    String str = paramString + ".temp.mp4";
    xvv.b("Q.qqstory.publish.upload.VideoCompositeManager", "reEncodeVideoWithFFmpeg start!");
    int i = HwVideoMerge.ffmpegReCodec(paramString, str, 0);
    if (i != 0) {
      QLog.e("Q.qqstory.publish.upload.VideoCompositeManager", 2, "[NewVersion]HwVideoMerge->merge: errcode=" + i);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.publish.upload.VideoCompositeManager", 2, "reEncodeVideoWithFFmpeg cost=" + (System.currentTimeMillis() - l));
      }
      return i;
      FileUtils.deleteFile(paramString);
      FileUtils.rename(str, paramString);
      i = 0;
    }
  }
  
  private void a(String paramString, long paramLong, vom paramvom)
  {
    long l = SystemClock.elapsedRealtime();
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.getPublishVideoEntry(paramString);
    if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {}
    for (paramString = "0";; paramString = "1")
    {
      xwa.b("publish_story", "video_composite_wait", a(localPublishVideoEntry), paramvom.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { paramvom.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg, String.valueOf(l - paramLong), String.valueOf(localPublishVideoEntry.videoDuration), paramString });
      return;
    }
  }
  
  private void a(von paramvon, PublishVideoEntry paramPublishVideoEntry, long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    label96:
    boolean bool;
    if (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath))
    {
      str = "0";
      j = a(paramPublishVideoEntry);
      xwa.b("publish_story", "video_composite", j, paramvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { paramvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg, String.valueOf(paramLong), String.valueOf(paramPublishVideoEntry.videoDuration), str });
      if (!paramPublishVideoEntry.isPicture)
      {
        if (!paramPublishVideoEntry.hwEncodeRecordVideo) {
          break label253;
        }
        i = 1;
        xwa.b("publish_story", "video_encode", 0, i, new String[] { paramPublishVideoEntry.videoMaxrate + "", paramPublishVideoEntry.videoMinrate + "" });
      }
      a(j, paramvon.b, paramPublishVideoEntry);
      bool = paramvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
      if (!paramvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
        break label259;
      }
    }
    label259:
    for (String str = "1";; str = "0")
    {
      xwa.a("StoryMergeVideoSuc", bool, 0L, new String[] { str });
      if (!paramvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
        break label266;
      }
      xwa.a("StoryMergeVideoError", true, 0L, new String[] { String.valueOf(paramvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode) });
      return;
      str = "1";
      break;
      label253:
      i = 0;
      break label96;
    }
    label266:
    int i = paramPublishVideoEntry.getIntExtra("composite_key_capturemode", 0);
    int j = paramPublishVideoEntry.getIntExtra("composite_key_entrance", 0);
    int k;
    long l1;
    if (paramPublishVideoEntry.businessId == 1)
    {
      bool = paramPublishVideoEntry.isPicture;
      k = (int)paramLong;
      str = xwa.b(i);
      l1 = paramPublishVideoEntry.videoDuration;
      if (!bool) {
        break label612;
      }
    }
    label612:
    for (paramvon = "2";; paramvon = "0")
    {
      xwa.a("time_composite", 10002, k, new String[] { str, String.valueOf(l1), paramvon, String.valueOf(j) });
      if ((bmxe.c) && (!paramPublishVideoEntry.isPicture) && (bmxe.g.a()))
      {
        l1 = bmxe.g.a[0];
        long l2 = bmxe.g.a[1];
        long l3 = bmxe.g.a[2];
        long l4 = bmxe.g.a[3];
        long l5 = bmxe.g.a[4];
        if ((xwa.a(paramLong, 0L, 120000L)) && (xwa.a(l1, 0L, 120000L)) && (xwa.a(l2, 0L, 120000L)) && (xwa.a(l3, 0L, 10000L)) && (xwa.a(l4, 0L, 120000L)) && (xwa.a(l5, 0L, 120000L))) {
          xwa.a("MergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
        }
        bmxe.g.c();
      }
      l1 = paramPublishVideoEntry.getLongExtra("composite_key_merge_thumb_cost", -1L);
      if ((!bmxe.c) || (l1 <= 0L)) {
        break;
      }
      bmxe.h.b();
      bmxe.h.a(0, l1);
      bmxe.h.a(1, paramLong);
      return;
    }
  }
  
  protected int a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (!paramPublishVideoEntry.isLocalPublish)
    {
      if (!paramPublishVideoEntry.isPicture) {
        return 1;
      }
      return 2;
    }
    if (!paramPublishVideoEntry.isPicture) {
      return 3;
    }
    return 4;
  }
  
  /* Error */
  public vom a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 126	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 37	voj:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 32	voj:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 301	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 155	vom
    //   24: astore 7
    //   26: aload 6
    //   28: monitorexit
    //   29: aload 7
    //   31: ifnull +44 -> 75
    //   34: aload 7
    //   36: getfield 302	vom:b	Ljava/lang/String;
    //   39: invokestatic 306	ypi:b	(Ljava/lang/String;)Z
    //   42: ifeq +20 -> 62
    //   45: aload_0
    //   46: aload_1
    //   47: lload_3
    //   48: aload 7
    //   50: invokespecial 308	voj:a	(Ljava/lang/String;JLvom;)V
    //   53: aload 7
    //   55: areturn
    //   56: astore_1
    //   57: aload 6
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_0
    //   63: getfield 32	voj:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: aload 7
    //   68: getfield 310	vom:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 313	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 316	voj:a	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 39	voj:b	Ljava/lang/Object;
    //   86: astore 6
    //   88: aload 6
    //   90: monitorenter
    //   91: ldc 74
    //   93: ldc_w 318
    //   96: iconst_1
    //   97: anewarray 34	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: invokestatic 322	xvv:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 39	voj:b	Ljava/lang/Object;
    //   111: ldc2_w 270
    //   114: invokevirtual 326	java/lang/Object:wait	(J)V
    //   117: ldc 74
    //   119: ldc_w 328
    //   122: iconst_1
    //   123: anewarray 34	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 322	xvv:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload 6
    //   135: monitorexit
    //   136: aload_0
    //   137: getfield 37	voj:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   140: astore 6
    //   142: aload 6
    //   144: monitorenter
    //   145: aload_0
    //   146: getfield 27	voj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: aload_1
    //   150: invokevirtual 332	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   153: istore 5
    //   155: aload_0
    //   156: getfield 32	voj:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   159: aload_1
    //   160: invokevirtual 301	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: checkcast 155	vom
    //   166: astore 7
    //   168: aload 6
    //   170: monitorexit
    //   171: aload 7
    //   173: ifnull +58 -> 231
    //   176: ldc 74
    //   178: ldc_w 334
    //   181: iconst_1
    //   182: anewarray 34	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 7
    //   189: aastore
    //   190: invokestatic 322	xvv:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: aload_1
    //   195: lload_3
    //   196: aload 7
    //   198: invokespecial 308	voj:a	(Ljava/lang/String;JLvom;)V
    //   201: aload 7
    //   203: areturn
    //   204: astore 7
    //   206: ldc 74
    //   208: ldc_w 336
    //   211: aload 7
    //   213: invokestatic 339	xvv:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: goto -83 -> 133
    //   219: astore_1
    //   220: aload 6
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    //   225: astore_1
    //   226: aload 6
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: iload 5
    //   233: ifne +58 -> 291
    //   236: new 155	vom
    //   239: dup
    //   240: aload_0
    //   241: invokespecial 342	vom:<init>	(Lvoj;)V
    //   244: astore 6
    //   246: aload 6
    //   248: new 160	com/tencent/biz/qqstory/base/ErrorMessage
    //   251: dup
    //   252: ldc_w 343
    //   255: ldc_w 345
    //   258: invokespecial 348	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   261: putfield 158	vom:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   264: ldc 74
    //   266: ldc_w 350
    //   269: iconst_1
    //   270: anewarray 34	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload_1
    //   276: aastore
    //   277: invokestatic 352	xvv:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: aload_0
    //   281: aload_1
    //   282: lload_3
    //   283: aload 6
    //   285: invokespecial 308	voj:a	(Ljava/lang/String;JLvom;)V
    //   288: aload 6
    //   290: areturn
    //   291: iload_2
    //   292: bipush 40
    //   294: if_icmple +93 -> 387
    //   297: new 155	vom
    //   300: dup
    //   301: aload_0
    //   302: invokespecial 342	vom:<init>	(Lvoj;)V
    //   305: astore 7
    //   307: aload 7
    //   309: new 160	com/tencent/biz/qqstory/base/ErrorMessage
    //   312: dup
    //   313: ldc_w 353
    //   316: ldc_w 355
    //   319: invokespecial 348	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   322: putfield 158	vom:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   325: ldc 74
    //   327: ldc_w 357
    //   330: iconst_1
    //   331: anewarray 34	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload_1
    //   337: aastore
    //   338: invokestatic 352	xvv:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_0
    //   342: aload_1
    //   343: lload_3
    //   344: aload 7
    //   346: invokespecial 308	voj:a	(Ljava/lang/String;JLvom;)V
    //   349: aload_0
    //   350: getfield 37	voj:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   353: astore 6
    //   355: aload 6
    //   357: monitorenter
    //   358: aload_0
    //   359: getfield 27	voj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   362: aload_1
    //   363: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   366: pop
    //   367: aload_0
    //   368: getfield 46	voj:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   371: iconst_0
    //   372: invokevirtual 362	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   375: aload 6
    //   377: monitorexit
    //   378: aload 7
    //   380: areturn
    //   381: astore_1
    //   382: aload 6
    //   384: monitorexit
    //   385: aload_1
    //   386: athrow
    //   387: iload_2
    //   388: iconst_1
    //   389: iadd
    //   390: istore_2
    //   391: goto -309 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	voj
    //   0	394	1	paramString	String
    //   81	310	2	i	int
    //   3	341	3	l	long
    //   153	79	5	bool	boolean
    //   24	178	7	localvom1	vom
    //   204	8	7	localInterruptedException	java.lang.InterruptedException
    //   305	74	7	localvom2	vom
    // Exception table:
    //   from	to	target	type
    //   13	29	56	finally
    //   57	60	56	finally
    //   91	133	204	java/lang/InterruptedException
    //   91	133	219	finally
    //   133	136	219	finally
    //   206	216	219	finally
    //   220	223	219	finally
    //   145	171	225	finally
    //   226	229	225	finally
    //   358	378	381	finally
    //   382	385	381	finally
  }
  
  protected void a(int paramInt, String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    try
    {
      int i = (int)FileUtils.getFileSizes(paramString);
      if (i <= 0) {
        return;
      }
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(9);
      String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(20);
      String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      String str3 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      ((MediaMetadataRetriever)localObject).release();
      localObject = str2 + "*" + str3;
      xwa.b("publish_story", "video_info", paramInt, i, new String[] { localObject, paramString, String.valueOf(paramPublishVideoEntry.recordFrames), str1 });
      xvv.b("Q.qqstory.publish.upload.VideoCompositeManager", "video info size:%d, duration:%s, framesCount:%d, bitRate:%s, picSize:%s", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(paramPublishVideoEntry.recordFrames), str1, localObject });
      return;
    }
    catch (Exception paramString)
    {
      xvv.b("Q.qqstory.publish.upload.VideoCompositeManager", "exception ", paramString);
    }
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String arg2, int paramInt, String arg4, String paramString3, long paramLong)
  {
    von localvon = new von(this);
    localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramInt, ???);
    localvon.jdField_a_of_type_JavaLangString = ???;
    localvon.b = paramString3;
    if ((paramInt == 0) && ((TextUtils.isEmpty(paramString3)) || (!ypi.b(paramString3)) || (FileUtils.getFileSizes(paramString3) < 100L))) {
      localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940007, String.format("vid:%s file:%s", new Object[] { ???, paramString3 }));
    }
    long l1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.remove(???)) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(???, localvon);
      l1 = 0L;
      ??? = "";
    }
    label1143:
    for (;;)
    {
      try
      {
        if (!localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
          continue;
        }
        if (!new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory()) {
          continue;
        }
        localObject1 = FileUtils.getChildFiles(paramPublishVideoEntry.mLocalRawVideoDir).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          l1 += FileUtils.getFileSizes((String)localObject2);
          ??? = ??? + (String)localObject2;
          continue;
          paramPublishVideoEntry = finally;
          throw paramPublishVideoEntry;
        }
        if (!TextUtils.isEmpty(???)) {
          break label1143;
        }
        ??? = paramPublishVideoEntry.mLocalRawVideoDir;
      }
      catch (Exception ???)
      {
        synchronized (this.b)
        {
          Object localObject1;
          Object localObject2;
          long l2;
          boolean bool2;
          int i;
          this.b.notifyAll();
          xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "end composite result:%s", new Object[] { localvon });
          c();
          a(localvon, paramPublishVideoEntry, paramLong);
          return;
          l1 = FileUtils.getFileSizes(paramPublishVideoEntry.mLocalRawVideoDir);
          ??? = "" + paramPublishVideoEntry.mLocalRawVideoDir;
          continue;
          ??? = ???;
          xvv.c("Q.qqstory.publish.upload.VideoCompositeManager", "", ???);
          continue;
          xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
          continue;
          paramInt = 0;
          continue;
          boolean bool1 = false;
          continue;
          bool1 = false;
          continue;
          xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "failed to composite. let's save original video to album.");
          if ((paramPublishVideoEntry.hasFragments) && (!this.jdField_a_of_type_Voo.b(paramPublishVideoEntry.multiFragmentGroupId))) {
            continue;
          }
          ??? = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          paramString3 = AudioEncoder.a(null, null, 0);
          paramString3.b = ???;
          paramString3.jdField_a_of_type_JavaLangString = paramPublishVideoEntry.mAudioFilePath;
          paramInt = AudioEncoder.a(paramString3);
          if (paramInt != 0) {
            continue;
          }
          ??? = wkp.a(???, false);
          paramInt = HwVideoMerge.merge(paramPublishVideoEntry.mLocalRawVideoDir, ???, ???, 0);
          if (paramInt != 0) {
            continue;
          }
          xvv.b("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: success.");
          ypi.b(BaseApplication.getContext(), new File(???));
          continue;
          xvv.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: errcode=%s", new Object[] { Integer.valueOf(paramInt) });
          continue;
          xvv.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. AudioEncoder.encodeSafely: errcode=%s" + paramInt);
          continue;
          this.jdField_a_of_type_Voo.a();
        }
      }
      l2 = ypi.a();
      localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg = String.format("errorCode:%d, sdcard free size:%d, vf dir size:%d, vf filename:%s, oMsg:%s", new Object[] { Integer.valueOf(localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode), Long.valueOf(l2), Long.valueOf(l1), ???, localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
      if (l1 < 100L) {
        localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode = 940018;
      }
      xvv.e("Q.qqstory.publish.upload.VideoCompositeManager", localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      if ((localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramPublishVideoEntry.hasFragments))
      {
        VideoCompositeHelper.updatePublishVideoProcessState(???, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC);
        l1 = ypi.a();
        xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "sdcard free size %d MB", new Object[] { Long.valueOf(l1 / 1024L / 1024L) });
        if (l1 < 104857600L)
        {
          if (!VideoCompositeHelper.isAllPartSuccess(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC)) {
            continue;
          }
          ypi.d(paramPublishVideoEntry.mLocalRawVideoDir);
          xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s all success so delete file:%s", new Object[] { paramPublishVideoEntry.multiFragmentGroupId, paramPublishVideoEntry.mLocalRawVideoDir });
        }
      }
      if ((localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (paramPublishVideoEntry.hasFragments)) {
        VideoCompositeHelper.updatePublishVideoProcessState(???, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED);
      }
      bool2 = paramPublishVideoEntry.getBooleanExtra("isEdited", false);
      if ((paramPublishVideoEntry.isLocalPublish) && (bool2))
      {
        paramInt = 1;
        if (((paramPublishVideoEntry.businessId != 1) && (paramPublishVideoEntry.businessId != 14)) || (paramPublishVideoEntry.isPicture)) {
          continue;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.upload.VideoCompositeManager", 2, "save from: story " + bool2 + " " + paramPublishVideoEntry.isLocalPublish + " " + bool1);
        }
        if ((bool1) || (paramInt != 0))
        {
          if (!localvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
            continue;
          }
          xvv.b("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task.");
          ??? = this.jdField_a_of_type_Voo.a(???);
          this.jdField_a_of_type_Voo.a(paramString3, ???);
          l1 = paramPublishVideoEntry.getLongExtra("groupUin", -1L);
          paramString3 = paramPublishVideoEntry.getStringExtra("pl", "");
          localObject1 = paramPublishVideoEntry.getStringExtra("i_l", "");
          xvv.a("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task. pl: %s", String.valueOf(paramString3));
          localObject2 = this.jdField_a_of_type_Voo;
          paramInt = paramPublishVideoEntry.videoWidth;
          i = paramPublishVideoEntry.videoHeight;
          if (l1 <= 0L) {
            continue;
          }
          bool1 = true;
          ((voo)localObject2).a(???, ???, null, paramInt, i, bool1, vwh.a(paramString3), vwg.a((String)localObject1));
          if (!paramPublishVideoEntry.hasFragments) {
            continue;
          }
          if (this.jdField_a_of_type_Voo.a(paramPublishVideoEntry.multiFragmentGroupId)) {
            this.jdField_a_of_type_Voo.a();
          }
        }
        vli.a().dispatch(localvon);
      }
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "add composite vid:%s", new Object[] { paramString });
      }
      c();
      return;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "video composite ing");
      return;
    }
    String str1 = "";
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      if (TextUtils.isEmpty(str1))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "no video to composite");
        return;
      }
    }
    xvv.d("Q.qqstory.publish.upload.VideoCompositeManager", "will composite vid:%s", new Object[] { str2 });
    long l = System.currentTimeMillis();
    if (bmxe.c) {
      bmxe.g.b();
    }
    Bosses.get().postJob(new vok(this, "Q.qqstory.publish.upload.VideoCompositeManager", str2, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voj
 * JD-Core Version:    0.7.0.1
 */