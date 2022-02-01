package cooperation.qzone.contentbox;

import acfp;
import acym;
import acyu;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqnm;
import avts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class MsgCardView
  extends LinearLayout
{
  private static final int eys = aqnm.dpToPx(35.0F);
  private static final int eyt = aqnm.dpToPx(12.0F);
  private static final int eyu = aqnm.dpToPx(12.0F);
  private static final int eyv = aqnm.dpToPx(10.0F);
  private static final int eyw = aqnm.dpToPx(18.0F);
  private static final int eyx = aqnm.dpToPx(230.0F);
  private static final int eyy = aqnm.dpToPx(8.0F);
  private avts jdField_a_of_type_Avts;
  public QQDailyArkView a;
  private MsgPhotoView jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView;
  private TextView agj;
  private TextView agk;
  private TextView agl;
  private TextView agm;
  private QQAppInterface app;
  private RoundCornerLinearLayout b;
  private int bSZ = -1;
  private RoundCornerLinearLayout c;
  private FrameLayout cw;
  private ViewGroup eX;
  private Context mContext;
  private RelativeLayout mTitleContainer;
  private LinearLayout mk;
  
  public MsgCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    LayoutInflater.from(this.mContext).inflate(2131562591, this);
    this.mTitleContainer = ((RelativeLayout)findViewById(2131379809));
    this.agj = ((TextView)findViewById(2131379864));
    this.agk = ((TextView)findViewById(2131379811));
    this.b = ((RoundCornerLinearLayout)findViewById(2131372000));
    this.b.setRadius(eyy);
    this.c = ((RoundCornerLinearLayout)findViewById(2131372018));
    this.c.setRadius(eyy);
    this.cw = ((FrameLayout)findViewById(2131372019));
    this.agl = ((TextView)findViewById(2131372008));
    this.mk = ((LinearLayout)findViewById(2131372007));
    this.agm = ((TextView)findViewById(2131372040));
    this.eX = ((ViewGroup)findViewById(2131372001));
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView = ((QQDailyArkView)findViewById(2131362964));
  }
  
  private BaseMsgView a()
  {
    return this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView;
  }
  
  private void nK(long paramLong)
  {
    long l = System.currentTimeMillis() - paramLong;
    if (l < 3600000L)
    {
      this.agj.setText(acfp.m(2131708517));
      return;
    }
    l /= 3600000L;
    if (l < 24L)
    {
      this.agj.setText(String.format("%d小时前", new Object[] { Long.valueOf(l) }));
      return;
    }
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(paramLong));
    this.agj.setText(str);
  }
  
  public boolean aLE()
  {
    BaseMsgView localBaseMsgView = a();
    if ((localBaseMsgView == null) || (!localBaseMsgView.aLD())) {}
    label95:
    for (;;)
    {
      return false;
      if (this.mTitleContainer != null) {
        i = this.mTitleContainer.getMeasuredHeight();
      }
      for (int i = ((LinearLayout.LayoutParams)this.mTitleContainer.getLayoutParams()).topMargin + i;; i = 0)
      {
        if (i + eyv + getTop() < 0) {
          break label95;
        }
        i = ((ListView)getParent()).getMeasuredHeight();
        if (getTop() + getMeasuredHeight() - eyw > i) {
          break;
        }
        return true;
      }
    }
  }
  
  public TextView af()
  {
    return this.agl;
  }
  
  public LinearLayout r()
  {
    return this.mk;
  }
  
  public void recycle()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView != null) {
      this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView.recycle();
    }
  }
  
  public void setData(int paramInt, MQMsg paramMQMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMQMsg == null)
    {
      this.mTitleContainer.setVisibility(8);
      this.b.removeAllViews();
      this.c.removeAllViews();
      this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView = null;
    }
    label900:
    label910:
    for (;;)
    {
      return;
      Object localObject;
      label116:
      int i;
      if (paramBoolean2)
      {
        String str = new SimpleDateFormat("MM月dd日").format(new Date(paramMQMsg.pushTime * 1000L));
        localObject = str;
        if (str.startsWith("0")) {
          localObject = str.substring(1);
        }
        this.agm.setText((CharSequence)localObject);
        this.agm.setVisibility(0);
        this.mTitleContainer.setVisibility(8);
        if (!paramBoolean1) {
          break label797;
        }
        this.agk.setTextColor(-1);
        this.agm.setTextColor(-1);
        this.agj.setTextColor(-11580352);
        this.mk.setBackgroundColor(-15263977);
        this.eX.setBackgroundResource(2130849354);
        this.cw.setBackgroundResource(2130849354);
        this.agl.setTextColor(-5723992);
        this.agl.setBackgroundResource(2130849329);
        label196:
        this.eX.setPadding(aqnm.dip2px(5.0F), 0, aqnm.dip2px(5.0F), 0);
        this.b.removeAllViews();
        if (paramBoolean2)
        {
          localObject = new TextView(this.mContext);
          ((TextView)localObject).setPadding(aqnm.dip2px(12.0F), 0, 0, 0);
          ((TextView)localObject).setGravity(16);
          ((TextView)localObject).setTextSize(17.0F);
          if (!paramBoolean1) {
            break label878;
          }
          i = -198683;
          label279:
          ((TextView)localObject).setTextColor(i);
          if ((paramMQMsg.msgType == 10) || (paramMQMsg.msgType == 11)) {
            ((TextView)localObject).setTypeface(Typeface.DEFAULT_BOLD);
          }
          ((TextView)localObject).setText(paramMQMsg.title);
          this.b.addView((View)localObject, new LinearLayout.LayoutParams(-1, aqnm.dip2px(51.0F)));
          localObject = new View(this.mContext);
          if (!paramBoolean1) {
            break label886;
          }
          i = -15066598;
          label366:
          ((View)localObject).setBackgroundColor(i);
          this.b.addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
        }
        this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView = new MsgPhotoView(this.mContext);
        this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView.setApp(this.app);
        localObject = this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView;
        if (this.bSZ != paramInt) {
          break label894;
        }
        paramBoolean2 = true;
        label434:
        ((MsgPhotoView)localObject).setData(paramBoolean2, paramMQMsg, paramBoolean1);
        this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView.setMsgOnClickListener(this.jdField_a_of_type_Avts);
        this.b.addView(this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView);
        this.bSZ = paramInt;
        if ((paramMQMsg.bottomCell == null) || (paramMQMsg.bottomCell.userAvatar == null) || (paramMQMsg.bottomCell.userAvatar.size() <= 0)) {
          break label900;
        }
        this.c.removeAllViews();
        localObject = new MsgMoreView(this.mContext);
        ((MsgMoreView)localObject).setData(paramMQMsg, paramBoolean1);
        ((MsgMoreView)localObject).setMsgOnClickListener(this.jdField_a_of_type_Avts);
        this.c.setVisibility(0);
        this.c.addView((View)localObject);
      }
      for (;;)
      {
        if ((!acyu.f(paramMQMsg.expand)) || (!acyu.bN(paramMQMsg.pushTime))) {
          break label910;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.setDarkMode(paramBoolean1);
        paramMQMsg = paramMQMsg.expand;
        localObject = acyu.jG((String)paramMQMsg.get("metaData"));
        if (this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.adc()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.B((String)paramMQMsg.get("appname"), (String)paramMQMsg.get("appview"), (String)paramMQMsg.get("appversion"), (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MsgCardView", 1, "QQDailyArkView exposed");
        }
        anot.a(null, "dc00898", "", "", "0X800AC01", "0X800AC01", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.setExpReported(true);
        if (!(this.mContext instanceof QZoneMsgActivity)) {
          break;
        }
        ((QZoneMsgActivity)this.mContext).a.a(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.a);
        return;
        this.agm.setVisibility(8);
        this.agk.setText(paramMQMsg.title);
        nK(paramMQMsg.pushTime * 1000L);
        this.mTitleContainer.setVisibility(0);
        break label116;
        label797:
        this.agk.setTextColor(-16777216);
        this.agm.setTextColor(-16777216);
        this.agj.setTextColor(-5196865);
        this.mk.setBackgroundColor(-1);
        this.eX.setBackgroundResource(2130849353);
        this.cw.setBackgroundResource(2130849353);
        this.agl.setTextColor(-16578534);
        this.agl.setBackgroundResource(2130849328);
        break label196;
        label878:
        i = -16578534;
        break label279;
        label886:
        i = -1315339;
        break label366;
        label894:
        paramBoolean2 = false;
        break label434;
        this.cw.setVisibility(8);
      }
    }
  }
  
  public void setMsgOnClickListener(avts paramavts)
  {
    this.jdField_a_of_type_Avts = paramavts;
  }
  
  public void startPlay()
  {
    BaseMsgView localBaseMsgView = a();
    if ((localBaseMsgView == null) || (!localBaseMsgView.aLD())) {
      return;
    }
    localBaseMsgView.startPlay();
  }
  
  public void stopPlay()
  {
    BaseMsgView localBaseMsgView = a();
    if ((localBaseMsgView == null) || (!localBaseMsgView.aLD())) {
      return;
    }
    localBaseMsgView.stopPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgCardView
 * JD-Core Version:    0.7.0.1
 */