import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class akci
  extends ajrw
{
  public akci(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString)
  {
    if ((NearbyPeopleProfileActivity.a(this.this$0) == null) || (NearbyPeopleProfileActivity.a(this.this$0) == null)) {}
    String str;
    do
    {
      return;
      NearbyPeopleProfileActivity.a(this.this$0).charm = paramInt3;
      NearbyPeopleProfileActivity.a(this.this$0).charmLevel = paramInt4;
      NearbyPeopleProfileActivity.a(this.this$0).curThreshold = paramInt5;
      NearbyPeopleProfileActivity.a(this.this$0).nextThreshold = paramInt6;
      NearbyPeopleProfileActivity.a(this.this$0).b(NearbyPeopleProfileActivity.a(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("Charm", 2, "onGetCharmNotify() uin=" + this.this$0.app.getCurrentAccountUin());
      }
      str = aqmr.substring(paramString, "<head>", "</head>");
      paramString = aqmr.substring(paramString, "<body>", "</body>");
    } while (!this.this$0.isResume());
    aqlr.a(this.this$0, str, paramString, paramInt3 - paramInt1).show();
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ongetShowLove ").append("issuccess = ").append(paramBoolean1).append(" uin = ").append(paramLong).append(" canChat = ").append(paramBoolean2).append(" can ShowLove = ").append(paramBoolean3).append("sig:").append(paramArrayOfByte).append(paramString);
    afck.n("profileCard", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.this$0;
    if (this.this$0.mHandler != null)
    {
      this.this$0.mHandler.removeMessages(204);
      this.this$0.mHandler.sendEmptyMessage(205);
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        afck.n(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "onGetShowLoveLimit , can chat, someting is wrong" });
        NearbyPeopleProfileActivity.a(this.this$0).bOF();
      }
    }
    for (;;)
    {
      this.this$0.crE = false;
      return;
      if (paramBoolean3)
      {
        if (NearbyPeopleProfileActivity.a(this.this$0) != null)
        {
          paramArrayOfByte = NearbyPeopleProfileActivity.a(this.this$0).uin;
          paramArrayOfByte = NearbyPeopleProfileActivity.a(this.this$0).nickname;
          int i = NearbyPeopleProfileActivity.a(this.this$0).gender;
          aqep.b(this.this$0.e);
          QLog.d("Q.nearby_people_card.", 1, "ShowLoveEditorActivity 已在725下架");
        }
      }
      else
      {
        afck.n(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "cant show love, wording is " + paramString });
        paramArrayOfByte = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte = ((Activity)localObject).getResources().getString(2131701556);
        }
        afck.C(this.this$0, paramArrayOfByte);
        continue;
        afck.C((Activity)localObject, ((Activity)localObject).getString(2131701555));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramNearbyPeopleCard != null) && ((paramNearbyPeopleCard.tinyId == 0L) || (paramNearbyPeopleCard.tinyId != this.this$0.adP)) && ((TextUtils.isEmpty(paramNearbyPeopleCard.uin)) || ("0".equals(paramNearbyPeopleCard.uin)) || (!paramNearbyPeopleCard.uin.equals(this.this$0.e.uin))) && ((paramNearbyPeopleCard.nowId == 0L) || (paramNearbyPeopleCard.nowId != NearbyPeopleProfileActivity.a(this.this$0)))) {}
    label429:
    label469:
    label1118:
    label1136:
    do
    {
      Object localObject;
      do
      {
        return;
        this.this$0.aqz();
        localObject = aurh.c;
        if ((localObject != null) && (((aurh)localObject).aJB())) {
          ((aurh)localObject).aaZ(6);
        }
        if ((paramNearbyPeopleCard != null) && (QLog.isColorLevel()))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = localStringBuilder1.append("tinyid=").append(paramNearbyPeopleCard.tinyId).append(", uin=").append(paramNearbyPeopleCard.uin).append(", nickname=").append(paramNearbyPeopleCard.nickname).append(", gender=").append(paramNearbyPeopleCard.gender).append(", age=").append(paramNearbyPeopleCard.age).append(", birthday=").append(paramNearbyPeopleCard.birthday).append(", constellation=").append(paramNearbyPeopleCard.constellation).append(", distance=").append(paramNearbyPeopleCard.distance).append(", timeDiff=").append(paramNearbyPeopleCard.timeDiff).append(", photoInfoes=").append(paramNearbyPeopleCard.picInfo).append(", videoDetails=").append(paramNearbyPeopleCard.videoDetails).append(", commonLabelString=").append(paramNearbyPeopleCard.commonLabelString).append(", hiWanInfo=").append(paramNearbyPeopleCard.hiWanInfo).append(", videoInfo=").append(paramNearbyPeopleCard.videoInfo).append(", photoInfo_length=");
          if (paramNearbyPeopleCard.picList != null) {
            break;
          }
          localObject = "null";
          localStringBuilder2 = localStringBuilder2.append(localObject).append(", likeCount=").append(paramNearbyPeopleCard.likeCount).append(",likeCountInc=").append(paramNearbyPeopleCard.likeCountInc).append(", oldPhotoCount=").append(paramNearbyPeopleCard.oldPhotoCount).append(", dateInfo=").append(paramNearbyPeopleCard.dateInfo).append(", dateInfo_length=");
          if (paramNearbyPeopleCard.dateInfo != null) {
            break label1105;
          }
          localObject = "null";
          localStringBuilder2 = localStringBuilder2.append(localObject).append(", xuanYan=").append(paramNearbyPeopleCard.xuanYan).append(", xuanYan_length=");
          if (paramNearbyPeopleCard.xuanYan != null) {
            break label1118;
          }
          localObject = "null";
          localStringBuilder2.append(localObject).append(", maritalStatus=").append(paramNearbyPeopleCard.maritalStatus).append(", job=").append(paramNearbyPeopleCard.job).append(", charm=").append(paramNearbyPeopleCard.charm).append(",level=").append(paramNearbyPeopleCard.charmLevel).append(",next=").append(paramNearbyPeopleCard.nextThreshold).append(", company=").append(paramNearbyPeopleCard.company).append(", college=").append(paramNearbyPeopleCard.college).append(", hometownCountry=").append(paramNearbyPeopleCard.hometownCountry).append(", hometownProvice=").append(paramNearbyPeopleCard.hometownProvice).append(", hometownCity=").append(paramNearbyPeopleCard.hometownCity).append(", hometownDistrict=").append(paramNearbyPeopleCard.hometownDistrict).append(", bVoted=").append(paramNearbyPeopleCard.bVoted).append(", feedPreviewTime=").append(paramNearbyPeopleCard.feedPreviewTime).append(", qzoneFeed=").append(paramNearbyPeopleCard.qzoneFeed).append(", qzoneName=").append(paramNearbyPeopleCard.qzoneName).append(", qzonePicUrl_1=").append(paramNearbyPeopleCard.qzonePicUrl_1).append(", qzonePicUrl_2=").append(paramNearbyPeopleCard.qzonePicUrl_2).append(", qzonePicUrl_3=").append(paramNearbyPeopleCard.qzonePicUrl_3).append(", isPhotoUseCache=").append(paramNearbyPeopleCard.isPhotoUseCache).append(", switchQzone=").append(paramNearbyPeopleCard.switchQzone).append(", switchHobby=").append(paramNearbyPeopleCard.switchHobby).append(", uiShowControl=").append(paramNearbyPeopleCard.uiShowControl).append(", userFlag=").append(paramNearbyPeopleCard.userFlag).append(", strProfileUrl=").append(paramNearbyPeopleCard.strProfileUrl).append(", strVoteLimitedNotice=").append(paramNearbyPeopleCard.strVoteLimitedNotice).append(", bHaveVotedCnt=").append(paramNearbyPeopleCard.bHaveVotedCnt).append(", bAvailVoteCnt=").append(paramNearbyPeopleCard.bAvailVoteCnt).append(", hasStory=").append(paramNearbyPeopleCard.mHasStory);
          QLog.d("Q.nearby_people_card.", 2, "Q.nearby_people_card..onNearbyCardDownload(), isSuccess: " + paramBoolean1 + ", card = " + localStringBuilder1.toString());
        }
        if ((!paramBoolean1) || (paramNearbyPeopleCard == null)) {
          break label1136;
        }
        this.this$0.mUin = paramNearbyPeopleCard.uin;
        this.this$0.cru = true;
        this.this$0.a(paramNearbyPeopleCard, false, paramBoolean2);
        this.this$0.dAF();
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "onNearbyCardDownload: likeCount=" + paramNearbyPeopleCard.likeCount + ", bHaveVotedCnt=" + paramNearbyPeopleCard.bHaveVotedCnt + ", bAvailVoteCnt=" + paramNearbyPeopleCard.bAvailVoteCnt + ", bVoted=" + paramNearbyPeopleCard.bVoted);
        }
        ((ajqh)this.this$0.app.getManager(207)).cz(paramNearbyPeopleCard.uin, false);
      } while (!paramNearbyPeopleCard.uin.equals(this.this$0.app.getCurrentAccountUin()));
      if ((paramNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(paramNearbyPeopleCard.videoInfo.videoUrl)) && (!TextUtils.isEmpty(paramNearbyPeopleCard.videoInfo.bSZ))) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        aqmj.I(this.this$0, paramBoolean1);
        return;
        localObject = Integer.valueOf(paramNearbyPeopleCard.picList.size());
        break;
        localObject = Integer.valueOf(paramNearbyPeopleCard.dateInfo.length);
        break label429;
        localObject = Integer.valueOf(paramNearbyPeopleCard.xuanYan.length);
        break label469;
      }
    } while (paramBoolean2);
    label1105:
    this.this$0.showToast(acfp.m(2131708787));
  }
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onEditNearbyProfileCard");
    }
    if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != this.this$0.adP) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.this$0.e.uin)))) {}
    while ((this.this$0.mMode != 1) && (this.this$0.mMode != 2)) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.this$0.yi.size() > 1) {
        this.this$0.crz = true;
      }
      NearbyPeopleProfileActivity.b(this.this$0);
      if (this.this$0.crJ)
      {
        this.this$0.c.Mm(true);
        this.this$0.crJ = false;
      }
      this.this$0.getSharedPreferences("nearby_callback", 4).edit().putInt("nearby_now_edit_profile_code_int", 0);
    }
    this.this$0.b(paramBoolean1, paramNearbyPeopleCard, paramBoolean2, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString1, List<ajuu> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onSetPersonalInterestTags");
    }
    if (paramBoolean)
    {
      this.this$0.aqz();
      this.this$0.aL(2, acfp.m(2131708792));
      return;
    }
    this.this$0.aqz();
    this.this$0.aL(1, acfp.m(2131708783) + paramString2);
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.", 2, "onUpdateNearbyPeopleAuthVideo , uint32_headid = " + paramHeadInfo.uint32_headid.get() + ", str_headurl = " + paramHeadInfo.str_headurl.get() + ", str_video_url = " + paramHeadInfo.str_video_url.get());
    }
    byte[] arrayOfByte = NearbyPeopleProfileActivity.a(this.this$0).vSeed;
    long l = NearbyPeopleProfileActivity.a(this.this$0).feedPreviewTime;
    if (this.this$0.adP > 0L) {
      aqek.a(this.this$0.c, this.this$0.app, this.this$0.adP, null, this.this$0.dms, arrayOfByte, l, true, this.this$0.e.Gz, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.update_profile", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
      }
      return;
      if (!aqmr.isEmpty(this.this$0.e.uin)) {
        aqek.a(this.this$0.c, this.this$0.app, 0L, this.this$0.e.uin, this.this$0.dms, arrayOfByte, l, true, this.this$0.e.Gz, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
      }
    }
  }
  
  protected void ad(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = (ajqh)this.this$0.app.getManager(207);
      if (NearbyPeopleProfileActivity.a(this.this$0) != null) {
        NearbyPeopleProfileActivity.a(this.this$0).dAJ();
      }
      if ((this.this$0.mMode != 1) && (paramString.art()) && (!this.this$0.crH) && (NearbyPeopleProfileActivity.kI(this.this$0.from)))
      {
        this.this$0.crH = true;
        paramString = new ImageView(this.this$0);
        paramString.setScaleType(ImageView.ScaleType.FIT_XY);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        this.this$0.H = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/zan.png", localURLDrawableOptions);
        if (this.this$0.H.getStatus() != 1) {
          break label157;
        }
        this.this$0.b(paramString, this.this$0.H);
      }
    }
    return;
    label157:
    this.this$0.H.setURLDrawableListener(new akcj(this, paramString));
    this.this$0.H.startDownload();
  }
  
  protected void b(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1)
  {
    if (NearbyPeopleProfileActivity.a(this.this$0) != null) {
      NearbyPeopleProfileActivity.a(this.this$0).f(paramBoolean, paramInt, paramList);
    }
  }
  
  protected void fn(String paramString, int paramInt)
  {
    if (NearbyPeopleProfileActivity.a(this.this$0) != null) {
      NearbyPeopleProfileActivity.a(this.this$0).bB(paramString, paramInt);
    }
    this.this$0.dmB = paramInt;
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((NearbyPeopleProfileActivity.a(this.this$0) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.this$0).uin)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (aqft.equalsWithNullCheck(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!aqft.equalsWithNullCheck(paramString2, NearbyPeopleProfileActivity.a(this.this$0).uin)) || (!aqft.equalsWithNullCheck(paramString1, this.this$0.app.getCurrentAccountUin())));
      if (!paramBoolean)
      {
        this.this$0.showToast(this.this$0.getResources().getString(2131694933));
        paramString1 = NearbyPeopleProfileActivity.a(this.this$0);
        paramString1.likeCount -= 1;
        NearbyPeopleProfileActivity.a(this.this$0).bVoted = 0;
        paramString1 = NearbyPeopleProfileActivity.a(this.this$0);
        paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt + paramInt1));
        NearbyPeopleProfileActivity.a(this.this$0).dAJ();
        return;
      }
    } while (paramInt2 != 1);
    paramString1 = NearbyPeopleProfileActivity.a(this.this$0);
    paramString1.likeCount += paramInt1;
    NearbyPeopleProfileActivity.a(this.this$0).bVoted = 1;
    paramString1 = NearbyPeopleProfileActivity.a(this.this$0);
    paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt - paramInt1));
    if (NearbyPeopleProfileActivity.a(this.this$0).bAvailVoteCnt < 0) {
      NearbyPeopleProfileActivity.a(this.this$0).bAvailVoteCnt = 0;
    }
    NearbyPeopleProfileActivity.a(this.this$0).dAJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akci
 * JD-Core Version:    0.7.0.1
 */