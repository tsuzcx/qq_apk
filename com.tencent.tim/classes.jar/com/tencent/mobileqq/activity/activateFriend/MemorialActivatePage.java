package com.tencent.mobileqq.activity.activateFriend;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqgv;
import aqmu;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MemorialActivatePage
  extends ActivateBasePage
  implements View.OnClickListener, aqdf.a
{
  private static final String aRX = acfp.m(2131708094);
  private static final String aRY = acfp.m(2131708096);
  private static String aRZ = "https://h5.qzone.qq.com/friend/day/%1$s/%2$s/friendDay?_wv=3&_proxy=1";
  private static String aSa = "https://h5.qzone.qq.com/lover/memosAct?_wv=1027&_proxy=1";
  private static final String aSb = acfp.m(2131708097);
  long HG;
  private TextView Hu;
  private TextView Hv;
  private TextView Hw;
  private TextView Hx;
  private aqdf jdField_a_of_type_Aqdf;
  private LetterSpacingTextView jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView;
  private AnyScaleTypeImageView jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  String aSc;
  String aSd;
  String aSe;
  String aSf;
  private LetterSpacingTextView jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView;
  private AnyScaleTypeImageView jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  int bNp;
  private LetterSpacingTextView jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView;
  private AnyScaleTypeImageView jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  private AnyScaleTypeImageView d;
  private QQAppInterface mApp;
  String mFriendUin;
  int mGender;
  String mJumpUrl;
  private ImageView rQ;
  private ImageView rR;
  private View vY;
  
  public MemorialActivatePage(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    super(paramContext);
    this.mApp = paramQQAppInterface;
    this.bNp = paramInt1;
    this.mFriendUin = paramString1;
    this.HG = paramInt2;
    this.aSc = paramString2;
    this.aSd = paramString3;
    this.aSe = paramString4;
    this.mGender = paramInt3;
    this.HG /= 86400L;
    this.HG *= 86400L;
    paramString2 = Calendar.getInstance();
    paramString2.setTimeInMillis(this.HG * 1000L);
    paramString3 = Calendar.getInstance();
    long l = System.currentTimeMillis();
    paramString3.setTimeInMillis(l);
    if (QLog.isColorLevel()) {
      QLog.d("MemorialActivatePage", 2, "time=" + paramString2.toString());
    }
    paramContext = String.format(paramContext.getString(2131700587), new Object[] { Integer.valueOf(Math.abs(paramString3.get(1) - paramString2.get(1))) });
    this.aSf = (paramContext + paramString5);
    if (this.jdField_a_of_type_Aqdf == null)
    {
      this.jdField_a_of_type_Aqdf = new aqdf(getContext(), paramQQAppInterface);
      this.jdField_a_of_type_Aqdf.a(this);
    }
    paramString3 = this.jdField_a_of_type_Aqdf.b(1, paramString1);
    if (paramString3 != null)
    {
      this.rR.setImageBitmap(paramString3);
      paramQQAppInterface = this.jdField_a_of_type_Aqdf.b(1, paramQQAppInterface.getCurrentAccountUin());
      if (paramQQAppInterface == null) {
        break label601;
      }
      this.rQ.setImageBitmap(paramQQAppInterface);
      label287:
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setSpacing(0.75F);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setText(paramContext);
      paramInt1 = new Long(Math.abs(l - this.HG * 1000L) / 86400000L).intValue();
      paramQQAppInterface = QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_friend_info_text", aRX);
      if (paramInt3 != 1) {
        break label632;
      }
      paramContext = acfp.m(2131708095);
      label359:
      paramContext = String.format(paramQQAppInterface, new Object[] { Integer.valueOf(paramInt1), paramContext });
      this.jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setSpacing(0.3F);
      this.jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setText(paramContext);
      this.Hu.setText(String.format("%d.%d.%d", new Object[] { Integer.valueOf(paramString2.get(1)), Integer.valueOf(paramString2.get(2) + 1), Integer.valueOf(paramString2.get(5)) }));
      paramContext = aqgv.D(this.mApp, this.mApp.getCurrentAccountUin());
      this.Hv.setText(paramContext);
      paramContext = aqgv.D(this.mApp, paramString1);
      this.Hw.setText(paramContext);
      if (this.bNp != 1) {
        break label642;
      }
    }
    label642:
    for (this.mJumpUrl = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_friend", aRZ), new Object[] { this.mApp.getCurrentAccountUin(), this.mFriendUin });; this.mJumpUrl = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_lover", aSa), new Object[] { this.mApp.getCurrentAccountUin(), this.mFriendUin }))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setSpacing(0.8F);
      paramContext = QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_more_btn", aRY);
      this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setText(paramContext);
      return;
      if (this.jdField_a_of_type_Aqdf.isPausing()) {
        break;
      }
      this.jdField_a_of_type_Aqdf.a(paramString1, 1, true, (byte)0);
      break;
      label601:
      if (this.jdField_a_of_type_Aqdf.isPausing()) {
        break label287;
      }
      this.jdField_a_of_type_Aqdf.a(this.mApp.getCurrentAccountUin(), 1, true, (byte)0);
      break label287;
      label632:
      paramContext = acfp.m(2131708098);
      break label359;
    }
  }
  
  protected void KR()
  {
    LpReportInfo_pf00064.allReport(220, 4, 1);
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    super.destroy();
  }
  
  public void fS(long paramLong)
  {
    CharSequence localCharSequence = aqmu.a(getContext(), 3, paramLong);
    this.iG.setText(localCharSequence);
    anot.a(this.mApp, "dc00898", "", "", "0X8007AD6", "0X8007AD6", this.bNp, 0, "", "", "", "");
  }
  
  public void initUI()
  {
    this.mRootView = this.mInflater.inflate(2131561174, this, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)this.mRootView.findViewById(2131371248));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_mcZzfPOOYR.png");
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)this.mRootView.findViewById(2131371249));
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_cqHXaEsvc6.png");
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)this.mRootView.findViewById(2131371258));
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_x6ZlQshbMQ.png");
    }
    this.d = ((AnyScaleTypeImageView)this.mRootView.findViewById(2131371247));
    if (this.d != null)
    {
      this.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.d.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_WTb508Bouk.png");
    }
    this.mRootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.Hu = ((TextView)this.mRootView.findViewById(2131379661));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView = ((LetterSpacingTextView)this.mRootView.findViewById(2131369155));
    this.jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView = ((LetterSpacingTextView)this.mRootView.findViewById(2131369156));
    this.rQ = ((ImageView)this.mRootView.findViewById(2131377977));
    this.rR = ((ImageView)this.mRootView.findViewById(2131367684));
    this.Hv = ((TextView)this.mRootView.findViewById(2131377978));
    this.Hw = ((TextView)this.mRootView.findViewById(2131367703));
    this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView = ((LetterSpacingTextView)this.mRootView.findViewById(2131381923));
    this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setOnClickListener(this);
    this.iG = ((TextView)this.mRootView.findViewById(2131362035));
    this.Hx = ((TextView)this.mRootView.findViewById(2131368058));
    this.vY = ((LinearLayout)this.mRootView.findViewById(2131381917));
    this.vY.setOnClickListener(this);
    int i;
    if (QzoneConfig.getInstance().getConfig("qqsetting", "QQSendFriendsMemorialDayGiftEnable", 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label487;
      }
      this.vY.setVisibility(0);
    }
    for (;;)
    {
      String str = QzoneConfig.getInstance().getConfig("qqsetting", "QQSendFriendsMemorialDayGiftText", aSb);
      if (!TextUtils.isEmpty(str)) {
        this.Hx.setText(str);
      }
      addView(this.mRootView);
      return;
      i = 0;
      break;
      label487:
      this.vY.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", this.mJumpUrl);
      ((Intent)localObject1).putExtra("injectrecommend", true);
      ((Intent)localObject1).setData(Uri.parse(this.mJumpUrl));
      getContext().startActivity((Intent)localObject1);
      anot.a(this.mApp, "dc00898", "", "", "0X8007AD7", "0X8007AD7", this.bNp, 0, "", "", "", "");
      LpReportInfo_pf00064.allReport(220, 4, 2);
      QZoneLoginReportHelper.reportLoginFromActivateFriend();
      continue;
      Object localObject2 = this.mFriendUin;
      localObject1 = new Date(System.currentTimeMillis());
      String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject1);
      String str2 = QzoneConfig.getInstance().getConfig("H5Url", "SendFriendsMemorialDayGiftUrl", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
      localObject1 = null;
      if (!TextUtils.isEmpty(str2)) {
        localObject1 = str2.replace("{to_uin}", (String)localObject2 + "_" + str1);
      }
      localObject2 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      getContext().startActivity((Intent)localObject2);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Aqdf.isPausing())
    {
      if (!paramString.equalsIgnoreCase(this.mApp.getCurrentAccountUin())) {
        break label34;
      }
      this.rQ.setImageBitmap(paramBitmap);
    }
    label34:
    while (!this.mFriendUin.equalsIgnoreCase(paramString)) {
      return;
    }
    this.rR.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.MemorialActivatePage
 * JD-Core Version:    0.7.0.1
 */