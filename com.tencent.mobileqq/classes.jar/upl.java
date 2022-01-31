import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
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
public class upl
  extends uuw
{
  protected final Object a;
  protected final ArrayList<String> a;
  protected final ConcurrentHashMap<String, upo> a;
  protected AtomicBoolean a;
  private upq a;
  protected final Object b = new Object();
  
  public upl()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(3);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(3);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Upq = new upq();
  }
  
  public static int a(String paramString)
  {
    long l = System.currentTimeMillis();
    String str = paramString + ".temp.mp4";
    wxe.b("Q.qqstory.publish.upload.VideoCompositeManager", "reEncodeVideoWithFFmpeg start!");
    int i = azkd.a(paramString, str, 0);
    if (i != 0) {
      QLog.e("Q.qqstory.publish.upload.VideoCompositeManager", 2, "[NewVersion]HwVideoMerge->merge: errcode=" + i);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.publish.upload.VideoCompositeManager", 2, "reEncodeVideoWithFFmpeg cost=" + (System.currentTimeMillis() - l));
      }
      return i;
      bdhb.d(paramString);
      bdhb.c(str, paramString);
      i = 0;
    }
  }
  
  private void a(String paramString, long paramLong, upo paramupo)
  {
    long l = SystemClock.elapsedRealtime();
    PublishVideoEntry localPublishVideoEntry = upd.a(paramString);
    if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {}
    for (paramString = "0";; paramString = "1")
    {
      wxj.b("publish_story", "video_composite_wait", a(localPublishVideoEntry), paramupo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { paramupo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg, String.valueOf(l - paramLong), String.valueOf(localPublishVideoEntry.videoDuration), paramString });
      return;
    }
  }
  
  private void a(upp paramupp, PublishVideoEntry paramPublishVideoEntry, long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    label96:
    boolean bool;
    if (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath))
    {
      str = "0";
      j = a(paramPublishVideoEntry);
      wxj.b("publish_story", "video_composite", j, paramupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { paramupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg, String.valueOf(paramLong), String.valueOf(paramPublishVideoEntry.videoDuration), str });
      if (!paramPublishVideoEntry.isPicture)
      {
        if (!paramPublishVideoEntry.hwEncodeRecordVideo) {
          break label253;
        }
        i = 1;
        wxj.b("publish_story", "video_encode", 0, i, new String[] { paramPublishVideoEntry.videoMaxrate + "", paramPublishVideoEntry.videoMinrate + "" });
      }
      a(j, paramupp.b, paramPublishVideoEntry);
      bool = paramupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
      if (!paramupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
        break label259;
      }
    }
    label259:
    for (String str = "1";; str = "0")
    {
      wxj.a("StoryMergeVideoSuc", bool, 0L, new String[] { str });
      if (!paramupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
        break label266;
      }
      wxj.a("StoryMergeVideoError", true, 0L, new String[] { String.valueOf(paramupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode) });
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
      str = wxj.b(i);
      l1 = paramPublishVideoEntry.videoDuration;
      if (!bool) {
        break label612;
      }
    }
    label612:
    for (paramupp = "2";; paramupp = "0")
    {
      wxj.a("time_composite", 10002, k, new String[] { str, String.valueOf(l1), paramupp, String.valueOf(j) });
      if ((blyz.c) && (!paramPublishVideoEntry.isPicture) && (blyz.g.a()))
      {
        l1 = blyz.g.a[0];
        long l2 = blyz.g.a[1];
        long l3 = blyz.g.a[2];
        long l4 = blyz.g.a[3];
        long l5 = blyz.g.a[4];
        if ((wxj.a(paramLong, 0L, 120000L)) && (wxj.a(l1, 0L, 120000L)) && (wxj.a(l2, 0L, 120000L)) && (wxj.a(l3, 0L, 10000L)) && (wxj.a(l4, 0L, 120000L)) && (wxj.a(l5, 0L, 120000L))) {
          wxj.a("MergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
        }
        blyz.g.c();
      }
      l1 = paramPublishVideoEntry.getLongExtra("composite_key_merge_thumb_cost", -1L);
      if ((!blyz.c) || (l1 <= 0L)) {
        break;
      }
      blyz.h.b();
      blyz.h.a(0, l1);
      blyz.h.a(1, paramLong);
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
  public upo a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 125	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 37	upl:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 32	upl:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 298	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 153	upo
    //   24: astore 7
    //   26: aload 6
    //   28: monitorexit
    //   29: aload 7
    //   31: ifnull +44 -> 75
    //   34: aload 7
    //   36: getfield 299	upo:b	Ljava/lang/String;
    //   39: invokestatic 303	xrg:b	(Ljava/lang/String;)Z
    //   42: ifeq +20 -> 62
    //   45: aload_0
    //   46: aload_1
    //   47: lload_3
    //   48: aload 7
    //   50: invokespecial 305	upl:a	(Ljava/lang/String;JLupo;)V
    //   53: aload 7
    //   55: areturn
    //   56: astore_1
    //   57: aload 6
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_0
    //   63: getfield 32	upl:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: aload 7
    //   68: getfield 307	upo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 310	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 313	upl:a	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 39	upl:b	Ljava/lang/Object;
    //   86: astore 6
    //   88: aload 6
    //   90: monitorenter
    //   91: ldc 74
    //   93: ldc_w 315
    //   96: iconst_1
    //   97: anewarray 34	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: invokestatic 318	wxe:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 39	upl:b	Ljava/lang/Object;
    //   111: ldc2_w 267
    //   114: invokevirtual 322	java/lang/Object:wait	(J)V
    //   117: ldc 74
    //   119: ldc_w 324
    //   122: iconst_1
    //   123: anewarray 34	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 318	wxe:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload 6
    //   135: monitorexit
    //   136: aload_0
    //   137: getfield 37	upl:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   140: astore 6
    //   142: aload 6
    //   144: monitorenter
    //   145: aload_0
    //   146: getfield 27	upl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: aload_1
    //   150: invokevirtual 328	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   153: istore 5
    //   155: aload_0
    //   156: getfield 32	upl:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   159: aload_1
    //   160: invokevirtual 298	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: checkcast 153	upo
    //   166: astore 7
    //   168: aload 6
    //   170: monitorexit
    //   171: aload 7
    //   173: ifnull +58 -> 231
    //   176: ldc 74
    //   178: ldc_w 330
    //   181: iconst_1
    //   182: anewarray 34	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 7
    //   189: aastore
    //   190: invokestatic 318	wxe:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: aload_1
    //   195: lload_3
    //   196: aload 7
    //   198: invokespecial 305	upl:a	(Ljava/lang/String;JLupo;)V
    //   201: aload 7
    //   203: areturn
    //   204: astore 7
    //   206: ldc 74
    //   208: ldc_w 332
    //   211: aload 7
    //   213: invokestatic 335	wxe:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   236: new 153	upo
    //   239: dup
    //   240: aload_0
    //   241: invokespecial 338	upo:<init>	(Lupl;)V
    //   244: astore 6
    //   246: aload 6
    //   248: new 158	com/tencent/biz/qqstory/base/ErrorMessage
    //   251: dup
    //   252: ldc_w 339
    //   255: ldc_w 341
    //   258: invokespecial 344	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   261: putfield 156	upo:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   264: ldc 74
    //   266: ldc_w 346
    //   269: iconst_1
    //   270: anewarray 34	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload_1
    //   276: aastore
    //   277: invokestatic 348	wxe:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: aload_0
    //   281: aload_1
    //   282: lload_3
    //   283: aload 6
    //   285: invokespecial 305	upl:a	(Ljava/lang/String;JLupo;)V
    //   288: aload 6
    //   290: areturn
    //   291: iload_2
    //   292: bipush 40
    //   294: if_icmple +93 -> 387
    //   297: new 153	upo
    //   300: dup
    //   301: aload_0
    //   302: invokespecial 338	upo:<init>	(Lupl;)V
    //   305: astore 7
    //   307: aload 7
    //   309: new 158	com/tencent/biz/qqstory/base/ErrorMessage
    //   312: dup
    //   313: ldc_w 349
    //   316: ldc_w 351
    //   319: invokespecial 344	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   322: putfield 156	upo:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   325: ldc 74
    //   327: ldc_w 353
    //   330: iconst_1
    //   331: anewarray 34	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload_1
    //   337: aastore
    //   338: invokestatic 348	wxe:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_0
    //   342: aload_1
    //   343: lload_3
    //   344: aload 7
    //   346: invokespecial 305	upl:a	(Ljava/lang/String;JLupo;)V
    //   349: aload_0
    //   350: getfield 37	upl:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   353: astore 6
    //   355: aload 6
    //   357: monitorenter
    //   358: aload_0
    //   359: getfield 27	upl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   362: aload_1
    //   363: invokevirtual 355	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   366: pop
    //   367: aload_0
    //   368: getfield 46	upl:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   371: iconst_0
    //   372: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
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
    //   0	394	0	this	upl
    //   0	394	1	paramString	String
    //   81	310	2	i	int
    //   3	341	3	l	long
    //   153	79	5	bool	boolean
    //   24	178	7	localupo1	upo
    //   204	8	7	localInterruptedException	java.lang.InterruptedException
    //   305	74	7	localupo2	upo
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
      int i = (int)bdhb.a(paramString);
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
      wxj.b("publish_story", "video_info", paramInt, i, new String[] { localObject, paramString, String.valueOf(paramPublishVideoEntry.recordFrames), str1 });
      wxe.b("Q.qqstory.publish.upload.VideoCompositeManager", "video info size:%d, duration:%s, framesCount:%d, bitRate:%s, picSize:%s", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(paramPublishVideoEntry.recordFrames), str1, localObject });
      return;
    }
    catch (Exception paramString)
    {
      wxe.b("Q.qqstory.publish.upload.VideoCompositeManager", "exception ", paramString);
    }
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String arg2, int paramInt, String arg4, String paramString3, long paramLong)
  {
    upp localupp = new upp(this);
    localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramInt, ???);
    localupp.jdField_a_of_type_JavaLangString = ???;
    localupp.b = paramString3;
    if ((paramInt == 0) && ((TextUtils.isEmpty(paramString3)) || (!xrg.b(paramString3)) || (bdhb.a(paramString3) < 100L))) {
      localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940007, String.format("vid:%s file:%s", new Object[] { ???, paramString3 }));
    }
    long l1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.remove(???)) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(???, localupp);
      l1 = 0L;
      ??? = "";
    }
    label1143:
    for (;;)
    {
      try
      {
        if (!localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
          continue;
        }
        if (!new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory()) {
          continue;
        }
        localObject1 = bdhb.a(paramPublishVideoEntry.mLocalRawVideoDir).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          l1 += bdhb.a((String)localObject2);
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
          wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "end composite result:%s", new Object[] { localupp });
          c();
          a(localupp, paramPublishVideoEntry, paramLong);
          return;
          l1 = bdhb.a(paramPublishVideoEntry.mLocalRawVideoDir);
          ??? = "" + paramPublishVideoEntry.mLocalRawVideoDir;
          continue;
          ??? = ???;
          wxe.c("Q.qqstory.publish.upload.VideoCompositeManager", "", ???);
          continue;
          wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
          continue;
          paramInt = 0;
          continue;
          boolean bool1 = false;
          continue;
          bool1 = false;
          continue;
          wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "failed to composite. let's save original video to album.");
          if ((paramPublishVideoEntry.hasFragments) && (!this.jdField_a_of_type_Upq.b(paramPublishVideoEntry.multiFragmentGroupId))) {
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
          ??? = vls.a(???, false);
          paramInt = azkd.a(paramPublishVideoEntry.mLocalRawVideoDir, ???, ???, 0);
          if (paramInt != 0) {
            continue;
          }
          wxe.b("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: success.");
          xrg.b(BaseApplication.getContext(), new File(???));
          continue;
          wxe.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: errcode=%s", new Object[] { Integer.valueOf(paramInt) });
          continue;
          wxe.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. AudioEncoder.encodeSafely: errcode=%s" + paramInt);
          continue;
          this.jdField_a_of_type_Upq.a();
        }
      }
      l2 = xrg.a();
      localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg = String.format("errorCode:%d, sdcard free size:%d, vf dir size:%d, vf filename:%s, oMsg:%s", new Object[] { Integer.valueOf(localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode), Long.valueOf(l2), Long.valueOf(l1), ???, localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
      if (l1 < 100L) {
        localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode = 940018;
      }
      wxe.e("Q.qqstory.publish.upload.VideoCompositeManager", localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      if ((localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramPublishVideoEntry.hasFragments))
      {
        upd.a(???, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC);
        l1 = xrg.a();
        wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "sdcard free size %d MB", new Object[] { Long.valueOf(l1 / 1024L / 1024L) });
        if (l1 < 104857600L)
        {
          if (!upd.b(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC)) {
            continue;
          }
          xrg.d(paramPublishVideoEntry.mLocalRawVideoDir);
          wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s all success so delete file:%s", new Object[] { paramPublishVideoEntry.multiFragmentGroupId, paramPublishVideoEntry.mLocalRawVideoDir });
        }
      }
      if ((localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (paramPublishVideoEntry.hasFragments)) {
        upd.a(???, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED);
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
          if (!localupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
            continue;
          }
          wxe.b("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task.");
          ??? = this.jdField_a_of_type_Upq.a(???);
          this.jdField_a_of_type_Upq.a(paramString3, ???);
          l1 = paramPublishVideoEntry.getLongExtra("groupUin", -1L);
          paramString3 = paramPublishVideoEntry.getStringExtra("pl", "");
          localObject1 = paramPublishVideoEntry.getStringExtra("i_l", "");
          wxe.a("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task. pl: %s", String.valueOf(paramString3));
          localObject2 = this.jdField_a_of_type_Upq;
          paramInt = paramPublishVideoEntry.videoWidth;
          i = paramPublishVideoEntry.videoHeight;
          if (l1 <= 0L) {
            continue;
          }
          bool1 = true;
          ((upq)localObject2).a(???, ???, null, paramInt, i, bool1, uxk.a(paramString3), uxj.a((String)localObject1));
          if (!paramPublishVideoEntry.hasFragments) {
            continue;
          }
          if (this.jdField_a_of_type_Upq.a(paramPublishVideoEntry.multiFragmentGroupId)) {
            this.jdField_a_of_type_Upq.a();
          }
        }
        umc.a().dispatch(localupp);
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
        wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "add composite vid:%s", new Object[] { paramString });
      }
      c();
      return;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "video composite ing");
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
        wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "no video to composite");
        return;
      }
    }
    wxe.d("Q.qqstory.publish.upload.VideoCompositeManager", "will composite vid:%s", new Object[] { str2 });
    long l = System.currentTimeMillis();
    if (blyz.c) {
      blyz.g.b();
    }
    Bosses.get().postJob(new upm(this, "Q.qqstory.publish.upload.VideoCompositeManager", str2, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upl
 * JD-Core Version:    0.7.0.1
 */