import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class nat
  implements naq.c
{
  private HashSet<String> T = new HashSet();
  private nat.a jdField_a_of_type_Nat$a;
  private naw jdField_a_of_type_Naw;
  private int aVi;
  private String akx;
  private String aky;
  private AtomicBoolean ay = new AtomicBoolean(false);
  private kcr b;
  private byte[] bs;
  private ArrayList<VideoInfo> lt;
  private Activity mActivity;
  private QQAppInterface mApp;
  private int mRequestTimes;
  
  public nat(Activity paramActivity, ArrayList<VideoInfo> paramArrayList, int paramInt, Bundle paramBundle, naw paramnaw)
  {
    this.mActivity = paramActivity;
    this.lt = paramArrayList;
    this.jdField_a_of_type_Naw = paramnaw;
    this.aVi = paramInt;
    this.akx = paramBundle.getString("VIDEO_COMMON_DATA");
    this.bs = paramBundle.getByteArray("VIDEO_BUSINESS_INFO");
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    this.jdField_a_of_type_Nat$a = new nat.a(null);
    this.mApp.addObserver(this.jdField_a_of_type_Nat$a);
  }
  
  public void aVg()
  {
    if (this.ay.get()) {
      return;
    }
    this.ay.set(true);
    if (this.b == null) {
      this.b = ((kcr)this.mApp.getBusinessHandler(90));
    }
    Object localObject2 = this.jdField_a_of_type_Naw.f();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new VideoInfo();
    }
    if (((VideoInfo)localObject1).a != null) {}
    for (int i = ((VideoInfo)localObject1).a.aHc;; i = 0)
    {
      localObject2 = new ArrayList(this.jdField_a_of_type_Naw.d());
      this.b.a(this.jdField_a_of_type_Nat$a, this.mApp.getLongAccountUin(), (VideoInfo)localObject1, this.aVi, this.lt, ((VideoInfo)localObject1).WA, -1L, true, i, this.akx, this.aky, null, this.mRequestTimes, null, this.bs, 1, 1, (ArrayList)localObject2);
      return;
    }
  }
  
  public void doOnDestory()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_Nat$a);
  }
  
  public void tg(int paramInt)
  {
    if (paramInt >= this.lt.size() - 5) {
      aVg();
    }
  }
  
  class a
    extends kcs
  {
    private boolean apI;
    
    private a() {}
    
    private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2)
    {
      if (!TextUtils.isEmpty(paramVideoInfo1.title)) {
        paramVideoInfo2.title = paramVideoInfo1.title;
      }
      if ((paramVideoInfo1.jR != null) && (paramVideoInfo1.jR.size() > 0))
      {
        if (paramVideoInfo2.jR == null) {
          paramVideoInfo2.jR = new ArrayList();
        }
        paramVideoInfo2.jR.addAll(paramVideoInfo1.jR);
      }
      if ((paramVideoInfo2.ry <= 0L) && (paramVideoInfo1.ry > 0L)) {
        paramVideoInfo2.ry = paramVideoInfo1.ry;
      }
      if ((paramVideoInfo1.a != null) && (paramVideoInfo2.a == null))
      {
        paramVideoInfo2.a = paramVideoInfo1.a;
        paramVideoInfo2.busiType = paramVideoInfo1.busiType;
      }
      if (paramVideoInfo1.strategyID > 0) {
        paramVideoInfo2.strategyID = paramVideoInfo1.strategyID;
      }
      if (paramVideoInfo1.algorithmID > 0L) {
        paramVideoInfo2.algorithmID = paramVideoInfo1.algorithmID;
      }
      if ((paramVideoInfo2.width <= 0) && (paramVideoInfo1.width > 0)) {
        paramVideoInfo2.width = paramVideoInfo1.width;
      }
      if ((paramVideoInfo2.height <= 0) && (paramVideoInfo1.height > 0)) {
        paramVideoInfo2.height = paramVideoInfo1.height;
      }
      if ((paramVideoInfo2.duration <= 0) && (paramVideoInfo1.duration > 0)) {
        paramVideoInfo2.duration = paramVideoInfo1.duration;
      }
      if ((paramVideoInfo2.playCount <= 0) && (paramVideoInfo1.playCount > 0)) {
        paramVideoInfo2.playCount = paramVideoInfo1.playCount;
      }
      if ((paramVideoInfo2.likeCount <= 0) && (paramVideoInfo1.likeCount > 0)) {
        paramVideoInfo2.likeCount = paramVideoInfo1.likeCount;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.WA)) {
        paramVideoInfo2.WA = paramVideoInfo1.WA;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.accountName)) && (!TextUtils.isEmpty(paramVideoInfo1.accountName))) {
        paramVideoInfo2.accountName = paramVideoInfo1.accountName;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.hH)) && (!TextUtils.isEmpty(paramVideoInfo1.hH))) {
        paramVideoInfo2.hH = paramVideoInfo1.hH;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.Wz)) && (!TextUtils.isEmpty(paramVideoInfo1.Wz))) {
        paramVideoInfo2.Wz = paramVideoInfo1.Wz;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.vid)) && (!TextUtils.isEmpty(paramVideoInfo1.vid)))
      {
        paramVideoInfo2.vid = paramVideoInfo1.vid;
        paramVideoInfo2.busiType = paramVideoInfo1.busiType;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.webUrl)) && (!TextUtils.isEmpty(paramVideoInfo1.webUrl))) {
        paramVideoInfo2.webUrl = paramVideoInfo1.webUrl;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.summary)) && (!TextUtils.isEmpty(paramVideoInfo1.summary))) {
        paramVideoInfo2.summary = paramVideoInfo1.summary;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.title)) && (!TextUtils.isEmpty(paramVideoInfo1.title))) {
        paramVideoInfo2.title = paramVideoInfo1.title;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.WC)) && (!TextUtils.isEmpty(paramVideoInfo1.WC))) {
        paramVideoInfo2.WC = paramVideoInfo1.WC;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.thirdAction)) && (!TextUtils.isEmpty(paramVideoInfo1.thirdAction))) {
        paramVideoInfo2.thirdAction = paramVideoInfo1.thirdAction;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.videoUrl)) && (!TextUtils.isEmpty(paramVideoInfo1.videoUrl))) {
        paramVideoInfo2.videoUrl = paramVideoInfo1.videoUrl;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.videoUrl)) && (!TextUtils.isEmpty(paramVideoInfo1.videoUrl))) {
        paramVideoInfo2.videoUrl = paramVideoInfo1.videoUrl;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.recommendReason)) && (!TextUtils.isEmpty(paramVideoInfo1.recommendReason))) {
        paramVideoInfo2.recommendReason = paramVideoInfo1.recommendReason;
      }
      if (!paramVideoInfo2.adB) {
        paramVideoInfo2.isFollowed = paramVideoInfo1.isFollowed;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.coverUrl)) {
        paramVideoInfo2.coverUrl = paramVideoInfo1.coverUrl;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.WH)) {
        paramVideoInfo2.WH = paramVideoInfo1.WH;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.WI)) {
        paramVideoInfo2.WI = paramVideoInfo1.WI;
      }
      paramVideoInfo2.aHe = 0;
      muj.x(paramVideoInfo2);
    }
    
    private void onFailed()
    {
      nat.a(nat.this).aVl();
    }
    
    protected void o(boolean paramBoolean, Bundle paramBundle)
    {
      Object localObject1 = null;
      nat.a(nat.this).set(false);
      if (!paramBoolean) {
        onFailed();
      }
      for (;;)
      {
        nat.a(nat.this);
        ArrayList localArrayList;
        do
        {
          return;
          nat.a(nat.this, paramBundle.getString("VALUE_COOKIE", null));
          localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
        } while ((localArrayList == null) || (localArrayList.size() == 0));
        int i = nat.a(nat.this).size();
        Object localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject2).next();
          if (nat.a(nat.this).contains(localVideoInfo.vid)) {
            ((Iterator)localObject2).remove();
          }
          if (localVideoInfo.isAD) {
            muj.y(localVideoInfo);
          }
          nat.a(nat.this).add(localVideoInfo.vid);
        }
        nat.a(nat.this).addAll(localArrayList);
        localObject2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
        paramBundle = localObject1;
        if (nat.a(nat.this).size() > 0) {
          paramBundle = (VideoInfo)nat.a(nat.this).get(0);
        }
        if ((!this.apI) && (paramBundle != null) && (localObject2 != null))
        {
          if ((paramBundle.Wz != null) && (paramBundle.Wz.equals(((VideoInfo)localObject2).Wz)))
          {
            a(paramBundle, (VideoInfo)localObject2);
            paramBundle.a((VideoInfo)localObject2);
          }
          this.apI = true;
          nat.a(nat.this).th(0);
        }
        nat.a(nat.this).dd(i, localArrayList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nat
 * JD-Core Version:    0.7.0.1
 */