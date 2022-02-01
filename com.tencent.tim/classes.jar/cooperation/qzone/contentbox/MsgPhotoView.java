package cooperation.qzone.contentbox;

import acfp;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoop;
import aqnm;
import avtg;
import avth;
import avts;
import awij;
import awkj;
import awmx;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import cooperation.qzone.contentbox.model.MQButtonCell;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.MQUserClientShowInfo;
import cooperation.qzone.contentbox.model.MQUserPersonalData;
import cooperation.qzone.contentbox.model.MQUserPersonalProfile;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgPhotoView
  extends BaseMsgView
{
  private static final int eyz = aqnm.dpToPx(36.0F);
  private ImageView HA;
  private ImageView HB;
  private ImageView HC;
  private ImageView HD;
  private ImageView Hy;
  private ImageView Hz;
  private boolean Mr;
  private avts a;
  private ImageView aS;
  private TextView agn;
  private TextView ago;
  private TextView agp;
  private TextView agq;
  private TextView agr;
  private TextView ags;
  private TextView agt;
  private LinearLayout bJ;
  private FrameLayout cx;
  private ImageView da;
  private RelativeLayout fE;
  private AnyScaleTypeImageView g;
  View.OnClickListener gG = new avth(this);
  private TextView hn;
  View.OnClickListener listener = new avtg(this);
  private ImageView mAvatarImage;
  private TextView mDesc2;
  private TextView mLikeNum;
  private TextView mNickNameView;
  private ImageView mVideoIcon;
  private LinearLayout ml;
  private LinearLayout mm;
  private RelativeLayout nI;
  private RelativeLayout nJ;
  private RelativeLayout nK;
  
  public MsgPhotoView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MsgPhotoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MsgPhotoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private ArrayList<String> V(ArrayList<MQPhotoCell> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        MQPhotoCell localMQPhotoCell = (MQPhotoCell)paramArrayList.get(i);
        if ((localMQPhotoCell != null) && (!TextUtils.isEmpty(localMQPhotoCell.coverUrl))) {
          localArrayList.add(localMQPhotoCell.coverUrl);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void WM(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
        localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png", (URLDrawable.URLDrawableOptions)localObject);
      } while (localObject == null);
      this.HD.setImageDrawable((Drawable)localObject);
      this.HD.setVisibility(0);
    } while (this.Mr);
    awkj.lm(13, 1);
  }
  
  private void a(MQUserClientShowInfo paramMQUserClientShowInfo)
  {
    if ((paramMQUserClientShowInfo == null) || (TextUtils.isEmpty(paramMQUserClientShowInfo.unionVipUrl)) || (paramMQUserClientShowInfo.unionIconWidth == 0) || (paramMQUserClientShowInfo.unionIconHeight == 0)) {}
    do
    {
      return;
      this.HB.setVisibility(0);
      this.HC.setVisibility(8);
      this.HD.setVisibility(8);
      if ((paramMQUserClientShowInfo.unionIconWidth > 0) && (paramMQUserClientShowInfo.unionIconHeight > 0))
      {
        localObject = this.HB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = aqnm.dpToPx(paramMQUserClientShowInfo.unionIconWidth / 2.0F);
        ((ViewGroup.LayoutParams)localObject).height = aqnm.dpToPx(paramMQUserClientShowInfo.unionIconHeight / 2.0F);
        this.HB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramMQUserClientShowInfo = paramMQUserClientShowInfo.unionVipUrl;
      Object localObject = new awij();
      ((awij)localObject).hb(paramMQUserClientShowInfo, 10);
      ((awij)localObject).setScale(aqnm.getScreenWidth() / 720.0F);
      ((awij)localObject).Xb(true);
      ((awij)localObject).eDG();
      ((awij)localObject).start();
      this.HB.setImageDrawable((Drawable)localObject);
    } while (this.Mr);
    awkj.lm(12, 1);
  }
  
  private void bq(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt1 == 0)) {
      this.HC.setVisibility(8);
    }
    boolean bool;
    label90:
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = new a(this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b, this.HD, paramInt2, this.Mr);
        localObject2 = awmx.a();
        if (paramInt3 != 1) {
          break;
        }
        bool = true;
        localObject1 = ((awmx)localObject2).getYellowVipIcon(paramInt1, paramInt2, bool, false, "", 8, (VipResourcesListener)localObject1);
      } while (localObject1 == null);
      Object localObject2 = this.HC;
      if (paramInt2 != 2) {
        break label144;
      }
      bool = true;
      ((ImageView)localObject2).setTag(Boolean.valueOf(bool));
      this.HC.setImageDrawable((Drawable)localObject1);
      this.HC.setVisibility(0);
    } while (this.Mr);
    if (paramInt2 == 2) {}
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      awkj.lm(paramInt1, 1);
      return;
      bool = false;
      break;
      label144:
      bool = false;
      break label90;
    }
  }
  
  private void eBR()
  {
    if ((this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg == null) || (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData == null) || (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData.mUserPersonalProfileMap == null))
    {
      QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo vip data = null");
      return;
    }
    MQUserPersonalProfile localMQUserPersonalProfile = (MQUserPersonalProfile)this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData.mUserPersonalProfileMap.get(this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.user_avatar);
    if (localMQUserPersonalProfile == null)
    {
      QZLog.e("MsgPhotoView", "MsgVip showPersonalVipInfo userPersonalProfile = null");
      return;
    }
    if (QZLog.isColorLevel()) {
      QZLog.i("MsgPhotoView", 2, "MsgVip showPersonalVipInfo isRepeat = " + this.Mr + "\n data = " + this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData.convertToJson());
    }
    if ((localMQUserPersonalProfile.userClientShowInfo == null) || (localMQUserPersonalProfile.userClientShowInfo.iVip == 0) || (localMQUserPersonalProfile.userClientShowInfo.iLevel == 0))
    {
      bq(localMQUserPersonalProfile.vipLevel, localMQUserPersonalProfile.vip, localMQUserPersonalProfile.isAnnualVip);
      if (localMQUserPersonalProfile.isLoversVip != 1) {
        break label205;
      }
    }
    label205:
    for (boolean bool = true;; bool = false)
    {
      WM(bool);
      return;
      a(localMQUserPersonalProfile.userClientShowInfo);
      break;
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b = new BaseMsgView.b(this);
    LayoutInflater.from(this.mContext).inflate(2131562595, this);
    this.bJ = ((LinearLayout)findViewById(2131363212));
    this.mAvatarImage = ((ImageView)findViewById(2131363175));
    this.mNickNameView = ((TextView)findViewById(2131372384));
    this.g = ((AnyScaleTypeImageView)findViewById(2131363404));
    this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager = ((QzoneMsgViewPager)findViewById(2131381929));
    initViewPager();
    this.agn = ((TextView)findViewById(2131365722));
    this.mDesc2 = ((TextView)findViewById(2131365723));
    this.ago = ((TextView)findViewById(2131365724));
    this.agp = ((TextView)findViewById(2131365725));
    this.agq = ((TextView)findViewById(2131365726));
    this.agr = ((TextView)findViewById(2131365727));
    this.cx = ((FrameLayout)findViewById(2131363201));
    this.ml = ((LinearLayout)findViewById(2131370439));
    this.nI = ((RelativeLayout)findViewById(2131370440));
    this.fE = ((RelativeLayout)findViewById(2131364998));
    this.da = ((ImageView)findViewById(2131370443));
    this.mLikeNum = ((TextView)findViewById(2131370448));
    this.aS = ((ImageView)findViewById(2131365014));
    this.hn = ((TextView)findViewById(2131365039));
    this.mm = ((LinearLayout)findViewById(2131378180));
    this.nJ = ((RelativeLayout)findViewById(2131375091));
    this.nK = ((RelativeLayout)findViewById(2131376593));
    this.Hy = ((ImageView)findViewById(2131375092));
    this.Hz = ((ImageView)findViewById(2131376594));
    this.ags = ((TextView)findViewById(2131375093));
    this.agt = ((TextView)findViewById(2131376595));
    this.nI.setOnClickListener(this.listener);
    this.fE.setOnClickListener(this.listener);
    this.nJ.setOnClickListener(this.listener);
    this.nK.setOnClickListener(this.listener);
    this.HA = ((ImageView)findViewById(2131376198));
    this.mVideoIcon = ((ImageView)findViewById(2131381715));
    this.HB = ((ImageView)findViewById(2131368944));
    this.HC = ((ImageView)findViewById(2131368945));
    this.HD = ((ImageView)findViewById(2131368943));
    this.HB.setOnClickListener(this.gG);
    this.HC.setOnClickListener(this.gG);
    this.HD.setOnClickListener(this.gG);
    setOnClickListener(this.listener);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b != null)
    {
      this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b = null;
    }
  }
  
  protected boolean r(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (Drawable)paramMessage.obj;
      this.mAvatarImage.setImageDrawable(paramMessage);
    }
  }
  
  public void setData(boolean paramBoolean1, MQMsg paramMQMsg, boolean paramBoolean2)
  {
    this.Mr = paramBoolean1;
    if (paramMQMsg == null) {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg = paramMQMsg;
    if ((!TextUtils.isEmpty(paramMQMsg.user_avatar)) && (!TextUtils.isEmpty(paramMQMsg.user_nick)))
    {
      this.bJ.setVisibility(0);
      ThreadManager.getSubThreadHandler().post(new MsgPhotoView.2(this, paramMQMsg));
      this.mNickNameView.setText(paramMQMsg.user_nick);
    }
    Object localObject1 = paramMQMsg.msgBody;
    if ((localObject1 != null) && (((MQMsgBody)localObject1).photolist != null)) {
      if (((MQMsgBody)localObject1).photolist.size() > 1) {
        if ((paramMQMsg.msgType != 9) || (TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          break label1563;
        }
      }
    }
    label790:
    label1319:
    for (int i = ((MQMsgBody)localObject1).photolist.size();; i = 0)
    {
      Object localObject2;
      if ((((MQMsgBody)localObject1).photolist != null) && (((MQMsgBody)localObject1).photolist.size() > 9))
      {
        if ((paramMQMsg.msgType == 9) && (!TextUtils.isEmpty(paramMQMsg.eventTitle))) {
          ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 3));
        }
      }
      else
      {
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.setVisibility(0);
        localObject2 = V(((MQMsgBody)localObject1).photolist);
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter = new QzoneMsgPagerAdapter(this.mContext, (ArrayList)localObject2);
        this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.setAdapter(this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter);
      }
      label297:
      label1217:
      label1352:
      label1376:
      for (;;)
      {
        int j;
        if (localObject1 != null)
        {
          j = ((MQMsgBody)localObject1).mediaType;
          if (j != 1) {
            break label790;
          }
          if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
          {
            this.ago.setVisibility(0);
            this.ago.setText(((MQMsgBody)localObject1).content);
            this.HA.setVisibility(8);
          }
          if (j == 3) {
            this.mVideoIcon.setVisibility(0);
          }
          if ((paramMQMsg.msgType != 9) || (TextUtils.isEmpty(paramMQMsg.eventTitle))) {
            break label886;
          }
          this.agp.setVisibility(0);
          this.agp.setText(paramMQMsg.eventTitle);
          this.agq.setVisibility(0);
          this.agq.setText("摄于" + paramMQMsg.capTime);
          findViewById(2131376581).setVisibility(0);
          findViewById(2131380169).setVisibility(0);
          if (paramBoolean2)
          {
            ((ImageView)findViewById(2131380170)).setImageResource(2130849344);
            ((TextView)findViewById(2131380171)).setTextColor(-7500397);
          }
          if (((MQMsgBody)localObject1).photolist != null)
          {
            this.agr.setVisibility(0);
            this.agr.setText(" " + i + "张照片 ∙ 上传前仅自己可见");
          }
        }
        label495:
        if ((localObject1 != null) && (((MQMsgBody)localObject1).vecUserAvatar != null))
        {
          this.cx.setVisibility(0);
          this.cx.removeAllViews();
          if (5 < ((MQMsgBody)localObject1).vecUserAvatar.size()) {}
          for (i = 5;; i = ((MQMsgBody)localObject1).vecUserAvatar.size())
          {
            j = 0;
            while (j < i)
            {
              localObject2 = new UserListItemView(this.mContext, 0);
              ((UserListItemView)localObject2).setUin((String)((MQMsgBody)localObject1).vecUserAvatar.get(j));
              ((UserListItemView)localObject2).setTranslationX(eyz * j);
              this.cx.addView((View)localObject2, 0);
              j += 1;
            }
            ((MQMsgBody)localObject1).photolist = new ArrayList(((MQMsgBody)localObject1).photolist.subList(0, 9));
            break;
            if (((MQMsgBody)localObject1).photolist.size() != 1) {
              break label1557;
            }
            localObject2 = (MQPhotoCell)((MQMsgBody)localObject1).photolist.get(0);
            if ((localObject2 == null) || (TextUtils.isEmpty(((MQPhotoCell)localObject2).coverUrl))) {
              break label1557;
            }
            this.g.setVisibility(0);
            switch (((MQPhotoCell)localObject2).type)
            {
            default: 
              localObject2 = e(((MQPhotoCell)localObject2).coverUrl);
              this.g.setImageDrawable((Drawable)localObject2);
              i = 0;
              break;
            case 2: 
              URLDrawable localURLDrawable = g();
              if (localURLDrawable != null)
              {
                this.g.setImageDrawable(localURLDrawable);
                i = 0;
                break;
              }
              localObject2 = e(((MQPhotoCell)localObject2).coverUrl);
              this.g.setImageDrawable((Drawable)localObject2);
              i = 0;
              break;
              if (!TextUtils.isEmpty(((MQMsgBody)localObject1).title))
              {
                this.mDesc2.setVisibility(0);
                this.mDesc2.setText(((MQMsgBody)localObject1).title);
              }
              if (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))
              {
                this.agn.setVisibility(0);
                this.agn.setText(((MQMsgBody)localObject1).content);
              }
              if ((!TextUtils.isEmpty(((MQMsgBody)localObject1).title)) || (!TextUtils.isEmpty(((MQMsgBody)localObject1).content))) {
                break label297;
              }
              this.HA.setVisibility(8);
              break label297;
              label886:
              if (paramMQMsg.msgType == 11)
              {
                if (!TextUtils.isEmpty(paramMQMsg.msgBody.coverPicUrl))
                {
                  localObject2 = (ImageView)findViewById(2131376581);
                  ((ImageView)localObject2).setVisibility(0);
                  ((ImageView)localObject2).setImageDrawable(e(paramMQMsg.msgBody.coverPicUrl));
                }
                this.agn.setVisibility(8);
                this.agr.setVisibility(0);
                this.agr.setText(paramMQMsg.msgBody.content);
                break label495;
              }
              findViewById(2131376581).setVisibility(8);
              findViewById(2131380169).setVisibility(8);
              this.agp.setVisibility(8);
              this.agq.setVisibility(8);
              this.agr.setVisibility(8);
              break label495;
            }
          }
          this.HA.setVisibility(8);
        }
        else
        {
          if (paramMQMsg.msgInteractData != null)
          {
            if ((paramMQMsg.msgInteractData.type == 1) && (paramMQMsg.msgInteractData.likeCell != null))
            {
              this.ml.setVisibility(0);
              if (!paramMQMsg.msgInteractData.likeCell.liked) {
                break label1319;
              }
              this.da.setImageResource(2130849332);
              if (paramMQMsg.msgInteractData.likeCell.totalLike <= 0) {
                break label1352;
              }
              this.mLikeNum.setText(paramMQMsg.msgInteractData.likeCell.totalLike + "");
              this.mLikeNum.setVisibility(0);
              if (paramMQMsg.msgInteractData.totalComment <= 0) {
                break label1376;
              }
              this.hn.setText(paramMQMsg.msgInteractData.totalComment + "");
              this.hn.setVisibility(0);
              if (paramBoolean2)
              {
                this.mLikeNum.setTextColor(-7500397);
                this.hn.setTextColor(-7500397);
                this.aS.setImageResource(2130849327);
              }
            }
            if (paramMQMsg.msgInteractData.type != 2) {
              break label1400;
            }
            this.mm.setVisibility(0);
            if (paramBoolean2)
            {
              this.Hy.setImageResource(2130849338);
              this.Hz.setImageResource(2130849341);
              this.ags.setTextColor(-7500397);
              this.agt.setTextColor(-7500397);
            }
          }
          label1400:
          while ((paramMQMsg.msgInteractData.type != 3) || (paramMQMsg.msgInteractData.buttonInfos == null) || (paramMQMsg.msgInteractData.buttonInfos.size() <= 0))
          {
            eBR();
            return;
            localObject1 = this.da;
            if (paramBoolean2) {}
            for (i = 2130849335;; i = 2130849334)
            {
              ((ImageView)localObject1).setImageResource(i);
              break;
            }
            this.mLikeNum.setText(acfp.m(2131708529));
            this.mLikeNum.setVisibility(0);
            break label1167;
            this.hn.setText(acfp.m(2131708530));
            this.hn.setVisibility(0);
            break label1217;
          }
          localObject1 = (MQButtonCell)paramMQMsg.msgInteractData.buttonInfos.get(0);
          findViewById(2131380169).setVisibility(0);
          paramMQMsg = (TextView)findViewById(2131380171);
          paramMQMsg.setText(((MQButtonCell)localObject1).words);
          paramMQMsg.setTypeface(Typeface.DEFAULT_BOLD);
          localObject1 = e(((MQButtonCell)localObject1).iconUrl);
          if (paramBoolean2)
          {
            paramMQMsg.setTextColor(-7500397);
            ((URLDrawable)localObject1).setColorFilter(-7500397, PorterDuff.Mode.SRC_ATOP);
          }
          for (;;)
          {
            ((ImageView)findViewById(2131380170)).setImageDrawable((Drawable)localObject1);
            break;
            ((URLDrawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
          }
          i = 0;
        }
      }
    }
  }
  
  public void setMsgOnClickListener(avts paramavts)
  {
    this.jdField_a_of_type_Avts = paramavts;
  }
  
  static class a
    implements VipResourcesListener
  {
    private boolean Mr;
    private int eyA;
    private WeakReference<Handler> mHandler;
    private WeakReference<ImageView> mImageView;
    
    public a(Handler paramHandler, ImageView paramImageView, int paramInt, boolean paramBoolean)
    {
      this.mHandler = new WeakReference(paramHandler);
      this.mImageView = new WeakReference(paramImageView);
      this.eyA = paramInt;
      this.Mr = paramBoolean;
    }
    
    public void onFailed() {}
    
    public void onLoaded(Drawable paramDrawable)
    {
      Handler localHandler = (Handler)this.mHandler.get();
      if ((paramDrawable != null) && (localHandler != null)) {
        localHandler.post(new MsgPhotoView.WeakVipResourcesListener.1(this, paramDrawable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView
 * JD-Core Version:    0.7.0.1
 */