import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.RspBody;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.UinHeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class axy
  extends CardObserver
{
  public axy(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void onImportQzonePhotos(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (NearbyPeopleProfileActivity.b(this.a) != 1) {}
    do
    {
      return;
      if ((!paramBoolean) || ((paramInt1 != 0) && (paramInt1 != 1))) {
        break;
      }
      if (paramInt1 == 0)
      {
        this.a.c();
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          if (paramArrayList.size() > 12) {}
          ArrayList localArrayList;
          for (paramInt1 = 12;; paramInt1 = paramArrayList.size())
          {
            localArrayList = new ArrayList(paramInt1);
            paramInt2 = 0;
            while (paramInt2 < paramInt1)
            {
              UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)paramArrayList.get(paramInt2);
              ayu localayu = new ayu(null);
              localayu.a = localHeadInfo.uint32_headid.get();
              localayu.c = localHeadInfo.str_headurl.get();
              localayu.b = (localayu.c + "250");
              localArrayList.add(localayu);
              paramInt2 += 1;
            }
          }
          NearbyPeopleProfileActivity.a(this.a).addAll(0, localArrayList);
          if (NearbyPeopleProfileActivity.a(this.a).size() > 13)
          {
            paramInt1 = NearbyPeopleProfileActivity.a(this.a).size() - 1;
            while (paramInt1 >= 12)
            {
              NearbyPeopleProfileActivity.a(this.a).remove(paramInt1);
              paramInt1 -= 1;
            }
            NearbyPeopleProfileActivity.a(this.a).add(NearbyPeopleProfileActivity.b(this.a));
          }
          NearbyPeopleProfileActivity.n(this.a);
          NearbyPeopleProfileActivity.a(this.a).a();
          NearbyPeopleProfileActivity.b(this.a).setVisibility(8);
          NearbyPeopleProfileActivity.a(this.a).setVisibility(8);
          NearbyPeopleProfileActivity.b(this.a).setVisibility(8);
          NearbyPeopleProfileActivity.d(this.a, true);
          if (paramInt4 > 0)
          {
            paramArrayList = DialogUtil.a(this.a, "最多可同步12张照片，精选照片，展示最好的自己吧。", 0, 0, null, null);
            paramArrayList.setPositiveButton(2131362791, new ayc(this, paramArrayList));
            paramArrayList.show();
          }
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800481C", "0X800481C", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 1);
    this.a.a.removeMessages(1001);
    this.a.a.sendEmptyMessageDelayed(1001, 2000L);
    return;
    this.a.c();
    NearbyPeopleProfileActivity.a(this.a, "导入失败");
  }
  
  protected void onNearbyCardDownload(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard)
  {
    if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != NearbyPeopleProfileActivity.a(this.a)) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(NearbyPeopleProfileActivity.a(this.a).a)))) {
      return;
    }
    this.a.c();
    Object localObject2;
    Object localObject3;
    if ((paramNearbyPeopleCard != null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      localObject3 = ((StringBuilder)localObject2).append("tinyid=").append(paramNearbyPeopleCard.tinyId).append(", uin=").append(paramNearbyPeopleCard.uin).append(", nickname=").append(paramNearbyPeopleCard.nickname).append(", gender=").append(paramNearbyPeopleCard.gender).append(", age=").append(paramNearbyPeopleCard.age).append(", birthday=").append(paramNearbyPeopleCard.birthday).append(", constellation=").append(paramNearbyPeopleCard.constellation).append(", distance=").append(paramNearbyPeopleCard.distance).append(", timeDiff=").append(paramNearbyPeopleCard.timeDiff).append(", photoInfoes=").append(paramNearbyPeopleCard.photoInfoes).append(", photoInfo_length=");
      if (paramNearbyPeopleCard.photoInfoes == null)
      {
        localObject1 = "null";
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", likeCount=").append(paramNearbyPeopleCard.likeCount).append(", oldPhotoCount=").append(paramNearbyPeopleCard.oldPhotoCount).append(", dateInfo=").append(paramNearbyPeopleCard.dateInfo).append(", dateInfo_length=");
        if (paramNearbyPeopleCard.dateInfo != null) {
          break label1056;
        }
        localObject1 = "null";
        label284:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", xuanYan=").append(paramNearbyPeopleCard.xuanYan).append(", xuanYan_length=");
        if (paramNearbyPeopleCard.xuanYan != null) {
          break label1069;
        }
        localObject1 = "null";
        ((StringBuilder)localObject3).append(localObject1).append(", maritalStatus=").append(paramNearbyPeopleCard.maritalStatus).append(", job=").append(paramNearbyPeopleCard.job).append(", company=").append(paramNearbyPeopleCard.company).append(", college=").append(paramNearbyPeopleCard.college).append(", hometownCountry=").append(paramNearbyPeopleCard.hometownCountry).append(", hometownProvice=").append(paramNearbyPeopleCard.hometownProvice).append(", hometownCity=").append(paramNearbyPeopleCard.hometownCity).append(", hometownDistrict=").append(paramNearbyPeopleCard.hometownDistrict).append(", bVoted=").append(paramNearbyPeopleCard.bVoted).append(", feedPreviewTime=").append(paramNearbyPeopleCard.feedPreviewTime).append(", qzoneFeed=").append(paramNearbyPeopleCard.qzoneFeed).append(", qzoneName=").append(paramNearbyPeopleCard.qzoneName).append(", qzonePicUrl_1=").append(paramNearbyPeopleCard.qzonePicUrl_1).append(", qzonePicUrl_2=").append(paramNearbyPeopleCard.qzonePicUrl_2).append(", qzonePicUrl_3=").append(paramNearbyPeopleCard.qzonePicUrl_3).append(", isPhotoUseCache=").append(paramNearbyPeopleCard.isPhotoUseCache).append(", switchQzone=").append(paramNearbyPeopleCard.switchQzone).append(", switchHobby=").append(paramNearbyPeopleCard.switchHobby).append(", uiShowControl=").append(paramNearbyPeopleCard.uiShowControl).append(", userFlag=").append(paramNearbyPeopleCard.userFlag).append(", strProfileUrl=");
        QLog.d("Q.nearby_people_card.", 2, "NearbyPeopleProfileActivity.onNearbyCardDownload(), isSuccess: " + paramBoolean + ", card = " + ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      if ((!paramBoolean) || (paramNearbyPeopleCard == null)) {
        break label1668;
      }
      NearbyPeopleProfileActivity.b(this.a, true);
      NearbyPeopleProfileActivity.a(this.a, paramNearbyPeopleCard);
      NearbyPeopleProfileActivity.a(this.a).a = NearbyPeopleProfileActivity.a(this.a).uin;
      NearbyPeopleProfileActivity.a(this.a).h = NearbyPeopleProfileActivity.a(this.a).nickname;
    }
    for (Object localObject1 = new GetPhotoList.RspBody();; localObject1 = null)
    {
      try
      {
        ((GetPhotoList.RspBody)localObject1).mergeFrom(paramNearbyPeopleCard.photoInfoes);
        if (((GetPhotoList.RspBody)localObject1).rpt_msg_uin_heads.has())
        {
          localObject2 = ((GetPhotoList.UinHeadInfo)((GetPhotoList.RspBody)localObject1).rpt_msg_uin_heads.get().get(0)).rpt_msg_headinfo.get();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("head size = ");
            if (localObject2 == null)
            {
              localObject1 = "null";
              QLog.d("Q.nearby_people_card.", 2, localObject1);
            }
          }
          else
          {
            if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
              break label1386;
            }
            int j = Math.min(12, ((List)localObject2).size());
            if (NearbyPeopleProfileActivity.a(this.a).size() <= 0) {
              continue;
            }
            localObject1 = (ayu)NearbyPeopleProfileActivity.a(this.a).get(NearbyPeopleProfileActivity.a(this.a).size() - 1);
            NearbyPeopleProfileActivity.a(this.a).clear();
            int i = 0;
            for (;;)
            {
              if (i < j)
              {
                localObject3 = (GetPhotoList.HeadInfo)((List)localObject2).get(i);
                ayu localayu = new ayu(null);
                localayu.a = ((GetPhotoList.HeadInfo)localObject3).uint32_headid.get();
                localayu.c = ((GetPhotoList.HeadInfo)localObject3).str_headurl.get();
                localayu.b = (localayu.c + "250");
                NearbyPeopleProfileActivity.a(this.a).add(localayu);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.nearby_people_card.", 2, "photo_id = " + localayu.a + ", big_pic_url = " + localayu.c);
                }
                i += 1;
                continue;
                localObject1 = Integer.valueOf(paramNearbyPeopleCard.photoInfoes.length);
                break;
                label1056:
                localObject1 = Integer.valueOf(paramNearbyPeopleCard.dateInfo.length);
                break label284;
                label1069:
                localObject1 = Integer.valueOf(paramNearbyPeopleCard.xuanYan.length);
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.", 2, "NearbyPeopleProfileActivity.onNearbyCardDownload(), parse head info fail.");
            continue;
            localObject1 = Integer.valueOf(localInvalidProtocolBufferMicroException.size());
          }
        }
        if ((localObject1 != null) && (localObject1 == NearbyPeopleProfileActivity.b(this.a))) {
          NearbyPeopleProfileActivity.a(this.a).add(localObject1);
        }
        NearbyPeopleProfileActivity.n(this.a);
      }
      if ((NearbyPeopleProfileActivity.b(this.a) == 3) && (NearbyPeopleProfileActivity.a(this.a) != null))
      {
        if (Utils.a(this.a.app.a(), NearbyPeopleProfileActivity.a(this.a).uin))
        {
          this.a.getIntent().putExtra("param_mode", 2);
          NearbyPeopleProfileActivity.a(this.a, 2);
        }
      }
      else
      {
        label1226:
        if (NearbyPeopleProfileActivity.b(this.a) != 1) {
          break label1646;
        }
        if (this.a.getIntent().getIntExtra("param_mode", 0) == 1)
        {
          if ((paramNearbyPeopleCard.oldPhotoCount <= 0) || (paramNearbyPeopleCard.age < 14) || (paramNearbyPeopleCard.age > 24) || (NearbyPeopleProfileActivity.a(this.a).size() > 1)) {
            break label1607;
          }
          NearbyPeopleProfileActivity.b(this.a).setVisibility(0);
          NearbyPeopleProfileActivity.a(this.a).setVisibility(0);
          NearbyPeopleProfileActivity.b(this.a).setVisibility(0);
          ReportController.b(this.a.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
        }
        label1359:
        NearbyPeopleProfileActivity.j(this.a);
      }
      for (;;)
      {
        this.a.app.a(new axz(this, paramNearbyPeopleCard));
        return;
        label1386:
        if (1 == NearbyPeopleProfileActivity.b(this.a)) {
          break;
        }
        NearbyPeopleProfileActivity.c(this.a, false);
        localObject1 = (ImageView)this.a.findViewById(2131298298);
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject1).setBackgroundDrawable(FaceDrawable.a(this.a.app, 1, NearbyPeopleProfileActivity.a(this.a).uin, 1, NearbyPeopleProfileActivity.a(this.a), NearbyPeopleProfileActivity.a(this.a)));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.a.n, this.a.n);
        localLayoutParams.setMargins((int)(NearbyPeopleProfileActivity.a(this.a) * 3.0F), (int)(NearbyPeopleProfileActivity.b(this.a) * 3.0F), 0, (int)(NearbyPeopleProfileActivity.c(this.a) * 3.0F));
        ((ImageView)localObject1).setLayoutParams(localLayoutParams);
        break;
        if (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin)) {
          break label1226;
        }
        localObject1 = (FriendsManager)this.a.app.getManager(43);
        if (localObject1 == null) {
          break label1226;
        }
        NearbyPeopleProfileActivity.a(this.a, ((FriendsManager)localObject1).b(NearbyPeopleProfileActivity.a(this.a).uin));
        break label1226;
        label1607:
        NearbyPeopleProfileActivity.b(this.a).setVisibility(8);
        NearbyPeopleProfileActivity.a(this.a).setVisibility(8);
        NearbyPeopleProfileActivity.b(this.a).setVisibility(8);
        break label1359;
        label1646:
        this.a.a.removeMessages(101);
        NearbyPeopleProfileActivity.b(this.a);
      }
      label1668:
      QQToast.a(this.a, "加载失败", 0).b(this.a.getTitleBarHeight());
      return;
    }
  }
  
  protected void onQueryImportQzonePhotoesStatus(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (NearbyPeopleProfileActivity.b(this.a) != 1) {}
    do
    {
      return;
      if ((!paramBoolean) || ((paramInt1 != 0) && (paramInt1 != 1))) {
        break;
      }
      if (paramInt1 == 0)
      {
        this.a.c();
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          if (paramArrayList.size() > 12) {}
          ArrayList localArrayList;
          for (paramInt1 = 12;; paramInt1 = paramArrayList.size())
          {
            localArrayList = new ArrayList(paramInt1);
            paramInt2 = 0;
            while (paramInt2 < paramInt1)
            {
              UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)paramArrayList.get(paramInt2);
              ayu localayu = new ayu(null);
              localayu.a = localHeadInfo.uint32_headid.get();
              localayu.c = localHeadInfo.str_headurl.get();
              localayu.b = (localayu.c + "250");
              localArrayList.add(localayu);
              paramInt2 += 1;
            }
          }
          NearbyPeopleProfileActivity.a(this.a).addAll(0, localArrayList);
          if (NearbyPeopleProfileActivity.a(this.a).size() > 13)
          {
            paramInt1 = NearbyPeopleProfileActivity.a(this.a).size() - 1;
            while (paramInt1 >= 12)
            {
              NearbyPeopleProfileActivity.a(this.a).remove(paramInt1);
              paramInt1 -= 1;
            }
            NearbyPeopleProfileActivity.a(this.a).add(NearbyPeopleProfileActivity.b(this.a));
          }
          NearbyPeopleProfileActivity.n(this.a);
          NearbyPeopleProfileActivity.a(this.a).a();
          NearbyPeopleProfileActivity.b(this.a).setVisibility(8);
          NearbyPeopleProfileActivity.a(this.a).setVisibility(8);
          NearbyPeopleProfileActivity.b(this.a).setVisibility(8);
          NearbyPeopleProfileActivity.d(this.a, true);
          if (paramInt4 > 0)
          {
            paramArrayList = DialogUtil.a(this.a, "最多可同步12张照片，精选照片，展示最好的自己吧。", 0, 0, null, null);
            paramArrayList.setPositiveButton(2131362791, new ayd(this, paramArrayList));
            paramArrayList.show();
          }
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800481C", "0X800481C", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 1);
    this.a.a.removeMessages(1001);
    this.a.a.sendEmptyMessageDelayed(1001, 2000L);
    return;
    this.a.c();
    NearbyPeopleProfileActivity.a(this.a, "导入失败");
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) == null) || (NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    while ((!Utils.a(paramString2, NearbyPeopleProfileActivity.a(this.a).uin)) || (!Utils.a(paramString1, this.a.app.a())) || (paramBoolean)) {
      return;
    }
    QQToast.a(this.a, 2131363901, 0).b(this.a.getTitleBarHeight());
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.likeCount -= 1;
    NearbyPeopleProfileActivity.a(this.a).bVoted = 0;
    NearbyPeopleProfileActivity.r(this.a);
  }
  
  protected void onUpdateNearbyPeoplePhotoList(boolean paramBoolean)
  {
    if (NearbyPeopleProfileActivity.b(this.a) != 1) {
      return;
    }
    if (paramBoolean)
    {
      NearbyPeopleProfileActivity.n(this.a);
      NearbyPeopleProfileActivity.c(this.a, true);
      this.a.app.a(new aya(this));
      return;
    }
    this.a.c();
    QQToast.a(this.a, "资料保存失败", 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onUpdateNearbyProfile(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard)
  {
    int j = 1;
    if (NearbyPeopleProfileActivity.b(this.a) != 1) {}
    while ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != NearbyPeopleProfileActivity.a(this.a)) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(NearbyPeopleProfileActivity.a(this.a).a)))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "NearbyPeopleProfileActivity.onUpdateNearbyProfile(), isSuccess: " + paramBoolean + ", card = " + paramNearbyPeopleCard);
    }
    this.a.c();
    int i;
    if ((paramBoolean) && (paramNearbyPeopleCard != null))
    {
      NearbyPeopleProfileActivity.d(this.a, false);
      QQToast.a(this.a, 2, "资料保存成功", 0).b(this.a.getTitleBarHeight());
      NearbyPeopleProfileActivity.a(this.a, paramNearbyPeopleCard);
      if (this.a.getIntent().getIntExtra("param_mode", 0) == 1)
      {
        NearbyPeopleProfileActivity.a(this.a, true);
        paramNearbyPeopleCard = new Intent();
        paramNearbyPeopleCard.putExtra("param_xuan_yan", NearbyPeopleProfileActivity.a(this.a).xuanYan);
        paramNearbyPeopleCard.putExtra("param_nickname", NearbyPeopleProfileActivity.a(this.a).nickname);
        paramNearbyPeopleCard.putExtra("param_gender", NearbyPeopleProfileActivity.a(this.a).gender);
        paramNearbyPeopleCard.putExtra("param_age", NearbyPeopleProfileActivity.a(this.a).age);
        paramNearbyPeopleCard.putExtra("param_career", NearbyPeopleProfileActivity.a(this.a).job);
        paramNearbyPeopleCard.putExtra("param_constellation", NearbyPeopleProfileActivity.a(this.a).constellation);
        paramNearbyPeopleCard.putExtra("param_marital_status", NearbyPeopleProfileActivity.a(this.a).maritalStatus);
        i = NearbyPeopleProfileActivity.a(this.a).size();
        if ((NearbyPeopleProfileActivity.a(this.a).size() <= 0) || (!((ayu)NearbyPeopleProfileActivity.a(this.a).get(NearbyPeopleProfileActivity.a(this.a).size() - 1)).equals(NearbyPeopleProfileActivity.b(this.a)))) {
          break label525;
        }
        i = NearbyPeopleProfileActivity.a(this.a).size() - 1;
      }
    }
    label525:
    for (;;)
    {
      paramNearbyPeopleCard.putExtra("param_photo_count", i);
      this.a.setResult(-1, paramNearbyPeopleCard);
      paramNearbyPeopleCard = this.a.app;
      if (this.a.getIntent().getIntExtra("param_mode", 0) == 1) {}
      for (i = j;; i = 2)
      {
        ReportController.b(paramNearbyPeopleCard, "CliOper", "", "", "0X8004823", "0X8004823", i, 0, "", "", "", "");
        return;
        if (NearbyPeopleProfileActivity.a(this.a) != 1) {
          NearbyPeopleProfileActivity.o(this.a);
        }
        NearbyPeopleProfileActivity.p(this.a);
        break;
      }
      QQToast.a(this.a, "资料保存失败", 0).b(this.a.getTitleBarHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axy
 * JD-Core Version:    0.7.0.1
 */