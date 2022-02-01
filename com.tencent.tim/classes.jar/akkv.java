import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.1;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.2;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class akkv
  implements View.OnClickListener, aqdf.a
{
  TextView Wk;
  amhj a;
  public aqdf a;
  int actionId;
  int bMV = 0;
  View cH;
  boolean csG = false;
  BitmapDrawable h;
  LinearLayout jL;
  HashMap<Long, Boolean> lZ = new HashMap();
  Context mContext;
  float mDensity;
  int mScreenWidth;
  HashMap<Long, Boolean> ma = new HashMap();
  
  public akkv(Context paramContext)
  {
    this.mContext = paramContext;
    this.cH = LayoutInflater.from(this.mContext).inflate(2131561488, null);
    this.jL = ((LinearLayout)this.cH.findViewById(2131373861));
    this.Wk = ((TextView)this.cH.findViewById(2131379837));
    this.mScreenWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Aqdf = new aqdf(this.mContext, ((BaseActivity)this.mContext).app);
    this.jdField_a_of_type_Aqdf.a(this);
    this.jdField_a_of_type_Amhj = ((amhj)((BaseActivity)this.mContext).app.getManager(15));
    paramContext = ((BaseActivity)this.mContext).app.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("key_nearbyrecommender_title", this.mContext.getResources().getString(2131696233));
      this.Wk.setText(paramContext);
    }
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, SingleLineTextView paramSingleLineTextView)
  {
    paramImageView.setVisibility(8);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167366));
    VipOpenInfo localVipOpenInfo;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label84;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130851502);
      paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167439));
    }
    label84:
    do
    {
      return;
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130851502);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167439));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130851889);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167439));
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    arjh localarjh = new arjh(this.mContext.getResources(), this.jdField_a_of_type_Amhj.i(paramInt, 200), false, false);
    if (this.bMV == 0) {
      this.bMV = ((int)(paramSingleLineTextView.getTextSize() * 1.1F + 0.5F));
    }
    localarjh.setBounds(0, 0, this.bMV, this.bMV);
    paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(localarjh, null);
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, RespEncounterInfo paramRespEncounterInfo)
  {
    RichStatus localRichStatus;
    if (paramRespEncounterInfo.richState != null)
    {
      localRichStatus = RichStatus.parseStatus(paramRespEncounterInfo.richState.vState);
      localRichStatus.time = paramRespEncounterInfo.richState.uModifyTime;
    }
    for (paramRespEncounterInfo = localRichStatus;; paramRespEncounterInfo = null)
    {
      if ((paramRespEncounterInfo != null) && (!paramRespEncounterInfo.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramRespEncounterInfo.actionText)) {
          a(paramSingleLineTextView, paramRespEncounterInfo.actionId);
        }
        for (;;)
        {
          this.actionId = paramRespEncounterInfo.actionId;
          paramSingleLineTextView.setText(paramRespEncounterInfo.toSpannableString(null));
          paramSingleLineTextView.setVisibility(0);
          return;
          paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      this.actionId = 0;
      paramSingleLineTextView.setVisibility(8);
      return;
    }
  }
  
  public View a(RespEncounterInfo paramRespEncounterInfo)
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131559681, null);
    if ((localView != null) && (paramRespEncounterInfo != null))
    {
      localView.setTag(paramRespEncounterInfo);
      localView.setOnClickListener(this);
      a(localView, paramRespEncounterInfo);
    }
    return localView;
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo, ImageView paramImageView)
  {
    String str;
    Boolean localBoolean;
    try
    {
      if (paramRespEncounterInfo.tiny_id > 0L)
      {
        str = String.valueOf(paramRespEncounterInfo.tiny_id);
        if (this.csG)
        {
          localBoolean = (Boolean)this.lZ.get(Long.valueOf(paramRespEncounterInfo.tiny_id));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.lZ.put(Long.valueOf(paramRespEncounterInfo.tiny_id), Boolean.valueOf(true));
            ((BaseActivity)this.mContext).app.execute(new ChatPushCarrierHelper.1(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_Aqdf.a(32, str, 202);
        if (paramRespEncounterInfo == null)
        {
          if (!this.jdField_a_of_type_Aqdf.isPausing()) {
            this.jdField_a_of_type_Aqdf.a(str, 202, true, false);
          }
          if (this.h == null) {
            this.h = ((BitmapDrawable)aqhu.aU());
          }
          paramImageView.setImageDrawable(this.h);
          return;
        }
        paramImageView.setImageBitmap(paramRespEncounterInfo);
        return;
      }
    }
    catch (Throwable paramRespEncounterInfo)
    {
      paramRespEncounterInfo.printStackTrace();
      return;
    }
    if (paramRespEncounterInfo.lEctID > 0L)
    {
      str = String.valueOf(paramRespEncounterInfo.lEctID);
      if (this.csG)
      {
        localBoolean = (Boolean)this.ma.get(Long.valueOf(paramRespEncounterInfo.lEctID));
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          this.ma.put(Long.valueOf(paramRespEncounterInfo.lEctID), Boolean.valueOf(true));
          ((BaseActivity)this.mContext).app.execute(new ChatPushCarrierHelper.2(this, str, paramRespEncounterInfo));
        }
      }
      paramRespEncounterInfo = this.jdField_a_of_type_Aqdf.a(32, str, 200);
      if (paramRespEncounterInfo == null)
      {
        this.jdField_a_of_type_Aqdf.a(str, 200, true, false);
        if (this.h == null) {
          this.h = ((BitmapDrawable)aqhu.aU());
        }
        paramImageView.setImageDrawable(this.h);
        return;
      }
      paramImageView.setImageBitmap(paramRespEncounterInfo);
    }
  }
  
  public void a(View paramView, RespEncounterInfo paramRespEncounterInfo)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131368698);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131379402);
    Object localObject4 = (ImageView)paramView.findViewById(2131363111);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131369101);
    Object localObject1 = (TextView)paramView.findViewById(2131379476);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131382023);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131365656);
    Object localObject2 = (SingleLineTextView)paramView.findViewById(2131379700);
    Object localObject3 = paramView.findViewById(2131369877);
    TextView localTextView = (TextView)paramView.findViewById(2131372329);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131373082);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131364453);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131377895);
    View localView = paramView.findViewById(2131369968);
    paramView = (SingleLineTextView)paramView.findViewById(2131369262);
    this.mContext.getResources().getColor(2131167366);
    label222:
    int i;
    if (!TextUtils.isEmpty(paramRespEncounterInfo.strNick))
    {
      localSingleLineTextView1.setText(paramRespEncounterInfo.strNick.trim());
      if (paramRespEncounterInfo.authFlag != 1) {
        break label793;
      }
      ((ImageView)localObject4).setVisibility(0);
      ((TextView)localObject1).setVisibility(8);
      if (paramRespEncounterInfo.god_flag != 1) {
        break label860;
      }
      ((TextView)localObject1).setVisibility(0);
      localImageView5.setVisibility(0);
      if (paramRespEncounterInfo.cSex != 1) {
        break label803;
      }
      localImageView5.setBackgroundResource(2130846801);
      localObject4 = this.mContext.getResources().getDrawable(2130846424);
      ((TextView)localObject1).setBackgroundDrawable(apuh.a(this.mContext.getResources(), -17883, (Drawable)localObject4));
      ((TextView)localObject1).setText(acfp.m(2131703725));
      label311:
      ((SingleLineTextView)localObject2).setText(paramRespEncounterInfo.strDescription);
      ((SingleLineTextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0);
      ((View)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      i = this.mScreenWidth - (int)(189.0F * this.mDensity);
      localObject1 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      localObject2 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      localObject3 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localObject3 == null) || (!((VipOpenInfo)localObject3).bOpen)) {
        break label870;
      }
      i -= (int)Math.ceil(33.5F * this.mDensity);
    }
    label449:
    label1092:
    for (;;)
    {
      int j = i;
      if (paramRespEncounterInfo.authFlag == 1) {
        j = i - (int)Math.ceil(20.0F * this.mDensity);
      }
      i = j;
      if (paramRespEncounterInfo.watch_color != 0) {
        i = j - (int)Math.ceil(16.0F * this.mDensity);
      }
      localSingleLineTextView1.setMaxWidth(i);
      i = 0;
      localObject1 = new StringBuilder();
      switch (paramRespEncounterInfo.cSex)
      {
      default: 
        if (paramRespEncounterInfo.cAge != 0) {
          ((StringBuilder)localObject1).append(" ").append(String.valueOf(paramRespEncounterInfo.cAge));
        }
        if (paramRespEncounterInfo.constellation == 0)
        {
          label581:
          if ((paramRespEncounterInfo.profession_id > 0) && (paramRespEncounterInfo.profession_id < 14)) {
            break label980;
          }
          label597:
          if (((StringBuilder)localObject1).length() <= 0) {
            break label1003;
          }
          i = 1;
          paramView.setText(((StringBuilder)localObject1).toString());
          if (AppSetting.enableTalkBack) {
            paramView.setContentDescription(((StringBuilder)localObject1).toString());
          }
          paramView.setVisibility(0);
          label636:
          if (paramRespEncounterInfo.charm_shown != 1) {
            break label1045;
          }
          if (localImageView4.getVisibility() != 0) {
            localImageView4.setVisibility(0);
          }
          switch (paramRespEncounterInfo.charm_level)
          {
          default: 
            localImageView4.setImageResource(2130846341);
            if (AppSetting.enableTalkBack) {
              localImageView4.setContentDescription(acfp.m(2131703727));
            }
            label713:
            if (paramRespEncounterInfo.watch_color == 0)
            {
              localView.setVisibility(8);
              label727:
              if (paramRespEncounterInfo.nFaceNum < 6) {
                break label1072;
              }
              i += 1;
              localImageView3.setVisibility(0);
              label746:
              if (i <= 0) {
                break label1082;
              }
              localLinearLayout.setVisibility(0);
            }
            break;
          }
        }
        break;
      }
      for (;;)
      {
        a(paramRespEncounterInfo.vipBaseInfo, localImageView2, localSingleLineTextView1);
        a(paramRespEncounterInfo, localImageView1);
        a(localSingleLineTextView2, paramRespEncounterInfo);
        return;
        localSingleLineTextView1.setText("");
        break;
        ((ImageView)localObject4).setVisibility(8);
        break label222;
        localImageView5.setBackgroundResource(2130846801);
        localObject4 = this.mContext.getResources().getDrawable(2130846424);
        ((TextView)localObject1).setBackgroundDrawable(apuh.a(this.mContext.getResources(), -17883, (Drawable)localObject4));
        ((TextView)localObject1).setText(acfp.m(2131703728));
        break label311;
        label860:
        localImageView5.setVisibility(8);
        break label311;
        label870:
        if ((localObject1 != null) && (((VipOpenInfo)localObject1).bOpen))
        {
          i -= (int)Math.ceil(33.5F * this.mDensity);
          break label449;
        }
        if ((localObject2 == null) || (!((VipOpenInfo)localObject2).bOpen)) {
          break label1092;
        }
        i -= (int)Math.ceil(28.5F * this.mDensity);
        break label449;
        ((StringBuilder)localObject1).append("男");
        break label548;
        ((StringBuilder)localObject1).append("女");
        break label548;
        ((StringBuilder)localObject1).append(" ").append(aqep.c(paramRespEncounterInfo.constellation));
        break label581;
        label980:
        ((StringBuilder)localObject1).append(" ").append(aqek.cq[paramRespEncounterInfo.profession_id]);
        break label597;
        label1003:
        paramView.setVisibility(8);
        break label636;
        localImageView4.setImageResource(2130846343);
        break label696;
        localImageView4.setImageResource(2130846344);
        break label696;
        localImageView4.setImageResource(2130846345);
        break label696;
        if (localImageView4.getVisibility() == 4) {
          break label713;
        }
        localImageView4.setVisibility(4);
        break label713;
        localView.setVisibility(0);
        break label727;
        localImageView3.setVisibility(8);
        break label746;
        localLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
  }
  
  public void lH(List<RespEncounterInfo> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramList.get(i);
      View localView = a(localRespEncounterInfo);
      if ((localView != null) && (localRespEncounterInfo != null)) {
        this.jL.addView(localView, new LinearLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 84.0F)));
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (RespEncounterInfo)paramView.getTag();
    Object localObject1 = (acff)((BaseActivity)this.mContext).app.getManager(51);
    if (localObject1 != null) {}
    for (boolean bool = ((acff)localObject1).isFriend(Long.toString(((RespEncounterInfo)localObject2).lEctID));; bool = false)
    {
      Intent localIntent = new Intent(this.mContext, ChatActivity.class);
      localIntent.putExtra("uin", Long.toString(((RespEncounterInfo)localObject2).lEctID));
      localIntent.putExtra("from_where_to_aio", "nearby_recommend_people");
      if (bool)
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("rich_accost_sig", ((RespEncounterInfo)localObject2).sig);
        localObject1 = this.mContext.getString(2131696202);
        if (!"0".equals(String.valueOf(((RespEncounterInfo)localObject2).cSex))) {
          break label299;
        }
      }
      label299:
      for (localObject1 = String.format((String)localObject1, new Object[] { acfp.m(2131703726) });; localObject1 = String.format((String)localObject1, new Object[] { acfp.m(2131703724) }))
      {
        akkw.a(((BaseActivity)this.mContext).app, Long.toString(((RespEncounterInfo)localObject2).lEctID), Long.toString(((RespEncounterInfo)localObject2).lEctID), (String)localObject1, 1001, true, true);
        ((BaseActivity)this.mContext).startActivity(localIntent);
        localObject1 = Long.toString(((RespEncounterInfo)localObject2).lEctID);
        localObject2 = akkw.a(((BaseActivity)this.mContext).app);
        anot.a(((BaseActivity)this.mContext).app, "CliOper", "", "", "0X80055FC", "0X80055FC", 0, 0, localObject2[0], (String)localObject1, "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localIntent.putExtra("uintype", 1001);
        break;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CarrierHelper", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Aqdf.isPausing())) {
      return;
    }
    paramInt2 = this.jL.getChildCount();
    paramInt1 = 0;
    label80:
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      localObject = this.jL.getChildAt(paramInt1);
      if (localObject != null) {
        break label107;
      }
    }
    label107:
    RespEncounterInfo localRespEncounterInfo;
    do
    {
      paramInt1 += 1;
      break label80;
      break;
      localRespEncounterInfo = (RespEncounterInfo)((View)localObject).getTag();
      localObject = (ImageView)((View)localObject).findViewById(16908294);
    } while ((localObject == null) || (localRespEncounterInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(Long.toString(localRespEncounterInfo.lEctID))));
    ((ImageView)localObject).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkv
 * JD-Core Version:    0.7.0.1
 */