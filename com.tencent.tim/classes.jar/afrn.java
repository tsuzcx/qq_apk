import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afrn
{
  private long FH = 9223372036854775807L;
  private long FI = 9223372036854775807L;
  private long FJ = 9223372036854775807L;
  private QQAppInterface app;
  private int bFx = 3;
  private int bWY = 60;
  private volatile boolean bjm;
  private String mFriendUin;
  private int mSessionType;
  
  public afrn(String paramString, int paramInt)
  {
    this.mFriendUin = paramString;
    this.mSessionType = paramInt;
    this.app = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
  }
  
  public static afpu a(MessageForMarketFace paramMessageForMarketFace)
  {
    return ((ajdg)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(14)).a(paramMessageForMarketFace.mMarkFaceMessage);
  }
  
  public static Drawable a(Context paramContext, afrq paramafrq)
  {
    Object localObject = paramafrq.h;
    if ((localObject instanceof MessageForMarketFace))
    {
      paramContext = a((MessageForMarketFace)localObject);
      if (paramContext == null) {
        break label170;
      }
    }
    label170:
    for (paramContext = paramContext.a("fromAIO", true);; paramContext = null)
    {
      paramafrq.cay = true;
      URL localURL;
      do
      {
        return paramContext;
        if (!(localObject instanceof MessageForPic)) {
          break;
        }
        localURL = aoop.a((MessageForPic)localObject, 1);
        if (aoiz.getFile(localURL.toString()) != null)
        {
          paramContext = URLDrawable.getDrawable(localURL, a(paramContext, (int)((MessageForPic)localObject).width, (int)((MessageForPic)localObject).height));
          paramafrq.cay = true;
          return paramContext;
        }
        localURL = xkl.a((MessageForPic)localObject);
        localObject = URLDrawable.getDrawable(localURL, a(paramContext, ((MessageForPic)localObject).thumbWidth, ((MessageForPic)localObject).thumbHeight));
        paramafrq.cay = false;
        paramContext = (Context)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("EmotionDataManager", 2, new Object[] { "init view,big pic not exist:", aoiz.getFile(localURL.toString()) });
      return localObject;
      return null;
    }
  }
  
  private static URLDrawable.URLDrawableOptions a(Context paramContext, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "AIOEmotionFragment";
    localURLDrawableOptions.mRequestWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    localURLDrawableOptions.mRequestHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    localURLDrawableOptions.mLoadingDrawable = new afei(paramInt1, paramInt2);
    return localURLDrawableOptions;
  }
  
  public static EmoticonPackage a(String paramString)
  {
    return ((ajdg)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(14)).b(paramString);
  }
  
  private List<MessageRecord> bf(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      if (((MessageRecord)localObject1).shmsgseq < this.FI) {
        this.FI = ((MessageRecord)localObject1).shmsgseq;
      }
      if (((MessageRecord)localObject1).versionCode < this.bFx) {
        this.bFx = ((MessageRecord)localObject1).versionCode;
      }
      if ((((MessageRecord)localObject1).getId() > 0L) && (((MessageRecord)localObject1).getId() < this.FH)) {
        this.FH = ((MessageRecord)localObject1).getId();
      }
      if (((MessageRecord)localObject1).time < this.FJ) {
        this.FJ = ((MessageRecord)localObject1).time;
      }
      Object localObject2;
      if ((localObject1 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject1;
        ((MessageForPic)localObject2).parse();
        if ((!d((MessageForPic)localObject2)) && (xkl.a((MessageForPic)localObject2))) {
          localArrayList.add(localObject1);
        }
      }
      else if ((localObject1 instanceof MessageForMarketFace))
      {
        localArrayList.add(localObject1);
      }
      else if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        if (((MessageForMixedMsg)localObject1).msgElemList != null)
        {
          localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof MessageForPic))
            {
              localObject2 = (MessageForPic)localObject2;
              ((MessageForPic)localObject2).parse();
              if (xkl.a((MessageForPic)localObject2)) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void reset()
  {
    this.bjm = false;
    this.FH = 9223372036854775807L;
    this.FI = 9223372036854775807L;
    this.bFx = 3;
    this.FJ = 9223372036854775807L;
    this.bWY = 60;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        if ((!paramString.equals(this.mFriendUin)) || (this.mSessionType != paramInt)) {
          break label480;
        }
        if (paramBoolean) {
          reset();
        }
        if (this.bWY < 60) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDataManager", 2, "getEmotionDataIncremental start");
        }
        long l = System.currentTimeMillis();
        localArrayList = new ArrayList();
        if (paramLong != -1L)
        {
          paramString = this.app.a();
          if (paramString != null) {
            localArrayList.addAll(bf(paramString.k(paramLong)));
          }
          if (!QLog.isColorLevel()) {
            break label482;
          }
          paramInt = localArrayList.size();
          if (paramString != null) {
            break label485;
          }
          paramBoolean = true;
          QLog.d("EmotionDataManager", 2, new Object[] { "getEmotionDataIncremental end, tempList.size: ", Integer.valueOf(paramInt), "  ", Boolean.valueOf(paramBoolean) });
          break label482;
        }
        int[] arrayOfInt = new int[4];
        int[] tmp175_173 = arrayOfInt;
        tmp175_173[0] = -2007;
        int[] tmp181_175 = tmp175_173;
        tmp181_175[1] = -20000;
        int[] tmp187_181 = tmp181_175;
        tmp187_181[2] = -2000;
        int[] tmp193_187 = tmp187_181;
        tmp193_187[3] = -1035;
        tmp193_187;
        if (!this.bjm)
        {
          List localList2 = this.app.a(paramInt).a(paramString, paramInt, tmp181_175);
          localList1 = localList2;
          if (localList2.size() < 60)
          {
            localList1 = this.app.b().a(paramString, paramInt, tmp181_175, 60);
            this.bWY = localList1.size();
          }
          if (!this.bjm) {
            this.bjm = true;
          }
          tmp175_173.addAll(0, bf(localList1));
          if ((tmp175_173.size() < 30) && (this.bWY >= 60)) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EmotionDataManager", 2, "getEmotionDataIncremental end, tempList.size: " + tmp175_173.size() + ", cost:" + (System.currentTimeMillis() - l));
          break;
        }
        if (top.fs(paramInt))
        {
          this.FI -= 1L;
          localList1 = this.app.b().a(paramString, paramInt, this.FH, this.bFx, this.FI, tmp181_175, 60);
          this.bWY = localList1.size();
          continue;
        }
        List localList1 = this.app.b().a(paramString, paramInt, this.FH, this.bFx, this.FJ, tmp181_175, 60);
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("EmotionDataManager", 2, "out of memory", paramString);
        return null;
      }
      continue;
      label480:
      return null;
      label482:
      return tmp175_173;
      label485:
      paramBoolean = false;
    }
    return tmp175_173;
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, -1L);
  }
  
  public boolean d(MessageForPic paramMessageForPic)
  {
    return ykm.d(paramMessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrn
 * JD-Core Version:    0.7.0.1
 */