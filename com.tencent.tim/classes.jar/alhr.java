import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.format.DateUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.vote.VoteHelper.1;
import com.tencent.mobileqq.profile.vote.VoteHelper.3;
import com.tencent.mobileqq.profile.vote.VoteHelper.4;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class alhr
{
  public static long agz = -1L;
  public static String bWs;
  public static String bWt;
  public static final Object eo;
  public static final Object mLock = new Object();
  public VisitorsActivity a;
  long agy;
  public QQAppInterface app;
  String bWp;
  String bWq;
  String bWr;
  int dub;
  int duc;
  public Handler mHandler;
  public Map<Long, Pair<CardProfile, AtomicInteger>> mx = new HashMap();
  public Map<Long, Pair<CardProfile, Pair<AtomicInteger, AtomicInteger>>> my = new HashMap();
  public ArrayList<Long> yF = new ArrayList();
  public ArrayList<Long> yG = new ArrayList();
  
  static
  {
    eo = new Object();
    bWs = "sp_key_vote_max_friend";
    bWt = "sp_key_vote_max_stranger";
  }
  
  public alhr(VisitorsActivity paramVisitorsActivity, Handler paramHandler, QQAppInterface paramQQAppInterface)
  {
    this.a = paramVisitorsActivity;
    this.mHandler = paramHandler;
    this.app = paramQQAppInterface;
    agz = -1L;
  }
  
  public static boolean bq(QQAppInterface paramQQAppInterface)
  {
    if (agz < 0L) {
      agz = paramQQAppInterface.getPreferences().getLong("keyShowDoubleZanPopTime", 0L);
    }
    if (DateUtils.isToday(agz)) {
      return false;
    }
    agz = System.currentTimeMillis();
    paramQQAppInterface.getPreferences().edit().putLong("keyShowDoubleZanPopTime", agz).commit();
    return true;
  }
  
  private void eG(ArrayList<Long> paramArrayList)
  {
    this.yG.clear();
    this.yF.clear();
    acff localacff = (acff)this.app.getManager(51);
    int i = 0;
    if (i < paramArrayList.size())
    {
      if ((Long)paramArrayList.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localacff.isFriend(Long.toString(((Long)paramArrayList.get(i)).longValue()))) {
          this.yF.add(paramArrayList.get(i));
        } else {
          this.yG.add(paramArrayList.get(i));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "fillTodayVoteArray " + paramArrayList.size() + " friend:" + this.yF.size() + " stranger:" + this.yG.size());
    }
  }
  
  public void Oe(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.agy > 2000L)
    {
      this.a.aL(0, paramString);
      this.agy = l;
    }
  }
  
  public int a(CardProfile paramCardProfile)
  {
    boolean bool3;
    Object localObject2;
    label52:
    int k;
    label63:
    int j;
    label78:
    boolean bool2;
    int n;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder("checkVote log ");
      bool3 = ((acff)this.app.getManager(51)).isFriend(Long.toString(paramCardProfile.lEctID));
      if (bool3)
      {
        localObject2 = this.yF;
        if (!bool3) {
          break label334;
        }
        k = this.dub;
        if (paramCardProfile.type != 2) {
          break label349;
        }
        if (!bool3) {
          break label343;
        }
        j = 5;
        if ((QLog.isColorLevel()) && (??? != null))
        {
          ((StringBuilder)???).append(",").append("limit").append("=").append(k);
          ((StringBuilder)???).append(",").append("isFrd").append("=").append(bool3);
          ((StringBuilder)???).append(",").append(paramCardProfile.getSimpleZanInfo());
          QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)???).toString());
        }
        bool2 = false;
        n = 0;
      }
    }
    for (;;)
    {
      boolean bool1;
      int i;
      label334:
      label343:
      label349:
      int m;
      synchronized (eo)
      {
        if (((ArrayList)localObject2).size() < k)
        {
          bool1 = true;
          i = 1;
          if ((bool1) || (i != 0)) {
            break label430;
          }
          if (!bool3) {
            break label421;
          }
          ??? = this.bWp;
          Oe(String.format((String)???, new Object[] { Integer.valueOf(k) }));
          anot.b(this.app, "CliOper", "", "0X8006579", "0X8006579", "", j, 1, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "checkVote " + paramCardProfile.lEctID + " logLevel:" + i + " can:" + bool1);
          }
          if (!bool1) {
            break label672;
          }
          return 1;
          localObject2 = this.yG;
          break label52;
          k = this.duc;
          break label63;
          j = 6;
          break label78;
          if (bool3)
          {
            j = 7;
            break label78;
          }
          j = 8;
          break label78;
        }
        m = 0;
        i = n;
        bool1 = bool2;
        if (m >= ((ArrayList)localObject2).size()) {
          continue;
        }
        if (((Long)((ArrayList)localObject2).get(m)).longValue() != paramCardProfile.lEctID) {
          break label680;
        }
        bool1 = true;
        i = 2;
      }
      label421:
      ??? = this.bWq;
      continue;
      label430:
      k = i;
      bool2 = bool1;
      if (bool1)
      {
        k = i;
        bool2 = bool1;
        if (paramCardProfile.bAvailableCnt <= 0L) {
          if (bool3)
          {
            if (!VipUtils.ce(this.app)) {
              break label618;
            }
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", Integer.toString(paramCardProfile.type), "");
            Oe("已点满SVIP专享20个赞啦~");
          }
        }
      }
      for (;;)
      {
        k = 4;
        bool2 = false;
        localObject2 = String.format(this.bWr, new Object[] { Long.valueOf(paramCardProfile.bTodayVotedCnt) });
        ??? = localObject2;
        if (paramCardProfile.bSex == 1) {
          ??? = ((String)localObject2).replace(acfp.m(2131716886), acfp.m(2131716884));
        }
        Oe((String)???);
        anot.b(this.app, "CliOper", "", "0X8006578", "0X8006578", "", j, 1, 0, "", "", "", "");
        i = k;
        bool1 = bool2;
        break;
        label618:
        if (bq(this.app)) {
          return 2;
        }
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", Integer.toString(paramCardProfile.type), "");
        Oe("非SVIP用户每天只能点10个赞哦～");
      }
      label672:
      return 0;
      ??? = null;
      break;
      label680:
      m += 1;
    }
  }
  
  public void a(CardProfile paramCardProfile, ImageView paramImageView, boolean paramBoolean)
  {
    int i = 1;
    label396:
    label661:
    label850:
    label856:
    label867:
    label880:
    for (;;)
    {
      Object localObject1;
      synchronized (mLock)
      {
        paramCardProfile.bAvailableCnt -= 1L;
        paramCardProfile.bTodayVotedCnt += 1L;
        if (paramCardProfile.type == 3)
        {
          paramCardProfile.bVoteCnt = ((short)(int)paramCardProfile.bTodayVotedCnt);
          paramCardProfile.dwLikeCustomId = PraiseManager.f(this.app);
          if (paramBoolean)
          {
            s = 0;
            paramCardProfile.bIsLastVoteCharged = s;
            i = 0;
            paramCardProfile.updateTime(System.currentTimeMillis() / 1000L);
          }
        }
        else
        {
          if ((!paramBoolean) && (i == 0)) {
            paramCardProfile.payVoteCount = ((short)(paramCardProfile.payVoteCount + 1));
          }
          boolean bool = ((acff)this.app.getManager(51)).isFriend(Long.toString(paramCardProfile.lEctID));
          if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity.VoteHelper", 2, "doVote, uin=" + paramCardProfile.lEctID + ", isFriend=" + bool);
          }
          if ((bool) || (!ajqh.cu(paramCardProfile.uSource))) {
            break label661;
          }
          if (this.my.containsKey(Long.valueOf(paramCardProfile.lEctID))) {
            continue;
          }
          localObject2 = new AtomicInteger(0);
          localObject1 = new AtomicInteger(0);
          Pair localPair = new Pair(localObject2, localObject1);
          this.my.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localPair));
          if (!paramBoolean) {
            continue;
          }
          ((AtomicInteger)localObject2).incrementAndGet();
          break label856;
          if (i >= this.a.pW.size()) {
            break label850;
          }
          localObject2 = (CardProfile)this.a.pW.get(i);
          if ((localObject2 == null) || (((CardProfile)localObject2).lEctID != paramCardProfile.lEctID)) {
            break label867;
          }
          ((CardProfile)localObject2).bTodayVotedCnt += 1L;
          ((CardProfile)localObject2).bAvailableCnt -= 1L;
          ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
          localObject1 = localObject2;
          if (!paramBoolean)
          {
            ((CardProfile)localObject2).payVoteCount = ((short)(((CardProfile)localObject2).payVoteCount + 1));
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = paramCardProfile.clone();
            ((CardProfile)localObject1).type = 3;
            ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
            ((CardProfile)localObject1).bAvailableCnt = paramCardProfile.bAvailableCnt;
            this.a.pW.add(0, localObject1);
            this.a.bXW();
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.i("VisitorsActivity.VoteHelper", 2, "onVoteClick add to FavList. uin:" + ((CardProfile)localObject1).lEctID);
              localObject2 = localObject1;
            }
          }
          ((CardProfile)localObject2).updateTime(System.currentTimeMillis() / 1000L);
          this.a.fR(paramCardProfile.lEctID);
          this.a.d(paramImageView, paramBoolean);
          if (!this.mHandler.hasMessages(6)) {
            this.mHandler.sendEmptyMessageDelayed(6, 2000L);
          }
          ThreadManager.post(new VoteHelper.1(this, paramCardProfile.lEctID, paramCardProfile.type, paramBoolean, paramCardProfile.uSource), 2, null, true);
          return;
        }
        short s = 1;
        continue;
        localObject1 = (Pair)((Pair)this.my.get(Long.valueOf(paramCardProfile.lEctID))).second;
        Object localObject2 = (AtomicInteger)((Pair)localObject1).first;
        localObject1 = (AtomicInteger)((Pair)localObject1).second;
        continue;
        ((AtomicInteger)localObject1).incrementAndGet();
      }
      if (!this.mx.containsKey(Long.valueOf(paramCardProfile.lEctID)))
      {
        localObject1 = new AtomicInteger(0);
        this.mx.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localObject1));
      }
      for (;;)
      {
        ((AtomicInteger)localObject1).incrementAndGet();
        break;
        localObject1 = (AtomicInteger)((Pair)this.mx.get(Long.valueOf(paramCardProfile.lEctID))).second;
      }
      for (;;)
      {
        if (i >= this.a.pV.size()) {
          break label880;
        }
        if (((CardProfile)this.a.pV.get(i)).lEctID == paramCardProfile.lEctID)
        {
          localObject1 = (CardProfile)this.a.pV.get(i);
          ((CardProfile)localObject1).bTodayVotedCnt += 1L;
          ((CardProfile)localObject1).bAvailableCnt -= 1L;
          break label514;
        }
        i += 1;
        continue;
        localObject1 = null;
        break label396;
        if (i != 0)
        {
          i = 0;
          break;
          i += 1;
          break;
        }
        i = 0;
      }
    }
  }
  
  public void a(ArrayList<Long> paramArrayList, int paramInt1, int paramInt2, long paramLong)
  {
    this.dub = paramInt1;
    this.duc = paramInt2;
    if (paramLong == 0L) {}
    synchronized (eo)
    {
      eG(paramArrayList);
      fB(bWs, this.dub);
      fB(bWt, this.duc);
      return;
    }
  }
  
  public boolean a(CardProfile paramCardProfile, ImageView paramImageView)
  {
    boolean bool = true;
    if (!aqiw.isNetSupport(this.a))
    {
      Oe(acfp.m(2131716885));
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = a(paramCardProfile);
      if (i == 0) {
        return false;
      }
    } while (i == 2);
    bool = aalb.q(this.app, Long.toString(paramCardProfile.lEctID));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "VisitorActivity->onClickVote, uin=" + paramCardProfile.lEctID + ", isFriend=" + bool);
    }
    if ((!bool) && (ajqh.cu(paramCardProfile.uSource))) {
      ((ajqh)this.app.getManager(207)).a(this.a, this.app, Long.toString(paramCardProfile.lEctID), new alhs(this, paramCardProfile, paramImageView), "511");
    }
    for (;;)
    {
      return false;
      a(paramCardProfile, paramImageView, true);
    }
  }
  
  public void aQ(long paramLong, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.k(this.app.getCurrentAccountUin(), paramLong, paramInt);
  }
  
  public int ab(String paramString, int paramInt)
  {
    paramInt = this.app.getPreferences().getInt(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "getSp key:" + paramString + " value:" + paramInt);
    }
    return paramInt;
  }
  
  public void b(CardProfile paramCardProfile)
  {
    int k = 0;
    for (;;)
    {
      synchronized (mLock)
      {
        localObject1 = (Pair)this.mx.get(Long.valueOf(paramCardProfile.lEctID));
        int i;
        if (localObject1 == null)
        {
          i = 0;
          break label433;
          if (j >= this.a.pV.size()) {
            break label427;
          }
          if (((CardProfile)this.a.pV.get(j)).lEctID != paramCardProfile.lEctID) {
            break label438;
          }
          localObject1 = (CardProfile)this.a.pV.get(j);
          j = k;
          if (localObject1 != null)
          {
            ((CardProfile)localObject1).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i);
            ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - i);
            j = k;
          }
          if (j < this.a.pW.size())
          {
            localObject1 = (CardProfile)this.a.pW.get(j);
            if ((localObject1 == null) || (((CardProfile)localObject1).lEctID != paramCardProfile.lEctID)) {
              break label445;
            }
            localObject1 = (CardProfile)this.a.pW.remove(j);
            ((CardProfile)localObject1).updateTime(paramCardProfile.lTime);
            ((CardProfile)localObject1).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i);
            ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - i);
            ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
            Object localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = paramCardProfile.clone();
              ((CardProfile)localObject2).type = 3;
              ((CardProfile)localObject2).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i);
              ((CardProfile)localObject2).bAvailableCnt = (paramCardProfile.bAvailableCnt - i);
              ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
            }
            if ((((CardProfile)localObject2).bTodayVotedCnt > 0L) && (((CardProfile)localObject2).bVoteCnt > 0)) {
              this.a.pW.add(0, localObject2);
            }
            this.a.fR(paramCardProfile.lEctID);
            this.a.bXW();
            if (QLog.isColorLevel()) {
              QLog.i("VisitorsActivity.VoteHelper", 2, "updateCardProfileToList. uin:" + paramCardProfile.lEctID + " todayCount:" + paramCardProfile.bTodayVotedCnt);
            }
          }
        }
        else
        {
          i = ((AtomicInteger)((Pair)localObject1).second).get();
        }
      }
      Object localObject1 = null;
      continue;
      label427:
      localObject1 = null;
      continue;
      label433:
      int j = 0;
      continue;
      label438:
      j += 1;
      continue;
      label445:
      j += 1;
    }
  }
  
  public void dFZ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "reqestVote");
    }
    long l1 = this.app.getLongAccountUin();
    acff localacff = (acff)this.app.getManager(51);
    Object localObject3 = this.mx.entrySet().iterator();
    long l2;
    Pair localPair;
    boolean bool;
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label228;
      }
      ??? = (Map.Entry)((Iterator)localObject3).next();
      l2 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      bool = localacff.isFriend(Long.toString(l2));
      synchronized (mLock)
      {
        if (((AtomicInteger)localPair.second).get() > 0) {
          break;
        }
      }
    }
    if (bool) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
    }
    for (;;)
    {
      ((AtomicInteger)localPair.second).set(0);
      break;
      this.a.jdField_a_of_type_Ajrs.b(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
    }
    label228:
    Iterator localIterator = this.my.entrySet().iterator();
    localObject3 = new ArrayList();
    while (localIterator.hasNext())
    {
      ??? = (Map.Entry)localIterator.next();
      l1 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      synchronized (mLock)
      {
        if ((((AtomicInteger)((Pair)localPair.second).first).get() > 0) || (((AtomicInteger)((Pair)localPair.second).second).get() > 0)) {}
      }
      ajqh.a locala = new ajqh.a();
      locala.dkt = ((AtomicInteger)((Pair)localPair.second).first).get();
      locala.dku = ((AtomicInteger)((Pair)localPair.second).second).get();
      locala.uin = l1;
      locala.source = ((int)((CardProfile)localPair.first).uSource);
      ((ArrayList)localObject3).add(locala);
      ((AtomicInteger)((Pair)localPair.second).first).set(0);
      ((AtomicInteger)((Pair)localPair.second).second).set(0);
    }
    this.a.jdField_a_of_type_Ajrs.D((ArrayList)localObject3, 511);
  }
  
  public void fB(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "saveSp key:" + paramString + " value:" + paramInt);
    }
    this.app.getPreferences().edit().putInt(paramString, paramInt).commit();
  }
  
  public void initData()
  {
    this.dub = ab(bWs, 0);
    this.duc = ab(bWs, 0);
    ArrayList localArrayList = new ArrayList();
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.iE(localArrayList);
    synchronized (eo)
    {
      eG(localArrayList);
      this.bWp = this.a.getResources().getString(2131701533);
      this.bWq = this.a.getResources().getString(2131701535);
      this.bWr = this.a.getResources().getString(2131701534);
      return;
    }
  }
  
  public void kG(long paramLong)
  {
    ThreadManager.postImmediately(new VoteHelper.4(this, paramLong), null, true);
  }
  
  public void t(String paramString, int paramInt, boolean paramBoolean)
  {
    ThreadManager.postImmediately(new VoteHelper.3(this, paramString, paramInt, paramBoolean), null, false);
  }
  
  public void u(String paramString, int paramInt, boolean paramBoolean)
  {
    int j = 0;
    long l = Long.valueOf(paramString).longValue();
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "onVoteError, uin:" + paramString + " voteNum:" + paramInt);
    }
    paramString = mLock;
    int i = 0;
    label315:
    for (;;)
    {
      try
      {
        if (i < this.a.pW.size())
        {
          CardProfile localCardProfile = (CardProfile)this.a.pW.get(i);
          if ((localCardProfile != null) && (localCardProfile.lEctID == l))
          {
            localCardProfile.bTodayVotedCnt -= paramInt;
            localCardProfile.bAvailableCnt += paramInt;
            localCardProfile.bVoteCnt = ((short)(localCardProfile.bVoteCnt - paramInt));
            if ((localCardProfile.bTodayVotedCnt > 0L) && (localCardProfile.bVoteCnt > 0)) {
              break label315;
            }
            this.a.pW.remove(i);
            i = 1;
            if (j < this.a.pV.size())
            {
              if (((CardProfile)this.a.pV.get(j)).lEctID == l)
              {
                localCardProfile = (CardProfile)this.a.pV.get(j);
                localCardProfile.bTodayVotedCnt -= paramInt;
                localCardProfile.bAvailableCnt += paramInt;
              }
            }
            else
            {
              this.a.fR(l);
              if (i != 0) {
                this.a.bXW();
              }
            }
          }
          else
          {
            i += 1;
            continue;
          }
          j += 1;
          continue;
        }
        i = 0;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhr
 * JD-Core Version:    0.7.0.1
 */