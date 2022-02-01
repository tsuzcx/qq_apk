import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class xlx
  extends wjd
{
  private static int screenWidth = -1;
  private final String aVC;
  private final int bVd;
  private final int bVe;
  private final int bVf;
  private final int bVg;
  private final int bVh;
  private final int bVi;
  private final int bVj;
  private final int bVk;
  private final int bVl;
  private final int bVm;
  private final int bVn;
  private final int bVo;
  
  public xlx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.mContext.getResources();
    this.bVd = wja.dp2px(251.0F, paramBaseAdapter);
    this.bVe = wja.dp2px(131.0F, paramBaseAdapter);
    this.bVf = wja.dp2px(128.5F, paramBaseAdapter);
    this.bVg = wja.dp2px(131.0F, paramBaseAdapter);
    this.bVh = wja.dp2px(122.5F, paramBaseAdapter);
    this.bVi = wja.dp2px(131.0F, paramBaseAdapter);
    this.bVj = wja.dp2px(16.0F, paramBaseAdapter);
    this.bVn = wja.dp2px(71.5F, paramBaseAdapter);
    this.bVo = wja.dp2px(74.0F, paramBaseAdapter);
    this.bVk = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.bVl = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.bVm = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.aVC = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.report(3, 2);
    }
  }
  
  private static String V(String paramString, int paramInt)
  {
    paramString = aqft.aI(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private int a(MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    int i = 1;
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() > 1) {
        i = 2;
      }
      return i;
    }
    if (!TextUtils.isEmpty(paramMessageForQzoneFeed.title)) {
      return 4;
    }
    return 3;
  }
  
  private View a(View paramView, xlx.a parama)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558921, null);
      parama.mRoot = paramView;
      parama.wJ = paramView.findViewById(2131362484);
      parama.wK = paramView.findViewById(2131362475);
      parama.Jz = ((TextView)paramView.findViewById(2131362496));
      parama.JA = ((TextView)paramView.findViewById(2131362488));
      parama.JB = ((TextView)paramView.findViewById(2131362499));
      parama.g = ((CornerImageView)paramView.findViewById(2131362493));
      localView = paramView;
      if (aTl)
      {
        parama.E = new StringBuilder();
        localView = paramView;
      }
    }
    if (aTl)
    {
      localView.setContentDescription(null);
      parama.E.replace(0, parama.E.length(), "");
    }
    return localView;
  }
  
  private static void a(CornerImageView paramCornerImageView, View paramView, MessageForQzoneFeed.MediaData paramMediaData, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    if (paramMediaData.uType == 1) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      paramCornerImageView.setRadius(paramArrayOfFloat);
      paramView = hx(paramMediaData.strImgUrl);
      if (!TextUtils.isEmpty(paramView)) {
        paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramURLDrawableOptions));
      }
      return;
      paramView.setVisibility(8);
    }
  }
  
  private void a(xlx.a parama)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.bVn;
    localURLDrawableOptions.mRequestHeight = this.bVo;
    parama.g.setVisibility(0);
    parama.g.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.bVj, this.bVj, 0.0F, 0.0F });
    parama.g.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    parama.g.setImageDrawable(URLDrawable.getDrawable(this.aVC, localURLDrawableOptions));
  }
  
  private void a(xlx.a parama, int paramInt)
  {
    if (parama.wL == null)
    {
      parama.wL = ((ViewStub)parama.mRoot.findViewById(2131362487)).inflate();
      parama.JI = ((TextView)parama.wL.findViewById(2131362485));
    }
    parama.wL.setOnClickListener(new xlz(this));
    parama.wL.setVisibility(0);
    if (parama.vb != null) {
      parama.vb.setVisibility(8);
    }
    if (parama.Jz != null) {
      parama.Jz.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = acfp.m(2131713085);
    }
    for (;;)
    {
      if (parama.JI != null) {
        parama.JI.setText(acfp.m(2131713093) + str + acfp.m(2131713100));
      }
      parama = new QZoneClickReport.a();
      parama.actionType = "330";
      parama.cMI = "3";
      parama.reserves = "1";
      QZoneClickReport.startReportImediately(this.app.getAccount(), parama);
      return;
      if (paramInt == 2) {
        str = acfp.m(2131713091);
      }
    }
  }
  
  private void a(xlx.a parama, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = aqft.aI(this.sessionInfo.aTn, this.bVk);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      parama.JA.setText((CharSequence)localObject);
      parama.JA.setVisibility(0);
      localCharSequence = aqmu.a(this.mContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(parama, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (aTl)
      {
        parama.E.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          parama.E.append("于").append(localCharSequence);
        }
        parama.E.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        parama.mRoot.setContentDescription(parama.E.toString());
      }
      return;
      b(parama, paramMessageForQzoneFeed);
      break;
      c(parama, paramMessageForQzoneFeed);
      break;
      e(parama, paramMessageForQzoneFeed);
      break;
      d(parama, paramMessageForQzoneFeed);
      break;
      String str1 = "";
      boolean bool1 = bool2;
      if (paramMessageForQzoneFeed.mapExt != null)
      {
        bool1 = bool2;
        if (paramMessageForQzoneFeed.mapExt.containsKey("isliked")) {
          bool1 = "1".equals(paramMessageForQzoneFeed.mapExt.get("isliked"));
        }
      }
      localObject = str1;
      if (paramMessageForQzoneFeed.mapExt != null)
      {
        localObject = str1;
        if (paramMessageForQzoneFeed.mapExt.containsKey("likekey")) {
          localObject = (String)paramMessageForQzoneFeed.mapExt.get("likekey");
        }
      }
      a(parama, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(xlx.a parama, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (parama.vb == null)
    {
      parama.vb = ((ViewStub)parama.mRoot.findViewById(2131362481)).inflate();
      parama.JF = ((TextView)parama.vb.findViewById(2131362501));
      parama.JG = ((TextView)parama.vb.findViewById(2131362498));
      parama.dp = ((ImageView)parama.vb.findViewById(2131362497));
      parama.JH = ((TextView)parama.vb.findViewById(2131362483));
    }
    parama.JF.setText(paramCharSequence);
    parama.JG.setText(aZ(paramInt1));
    paramCharSequence = parama.dp;
    if (paramBoolean) {}
    for (int i = 2130848389;; i = 2130848388)
    {
      paramCharSequence.setImageResource(i);
      parama.dp.setOnClickListener(new xma(this, paramBoolean, paramInt1, parama, paramString, paramInt2, paramMessageForQzoneFeed));
      parama.JH.setText(aZ(paramLong));
      parama.vb.setVisibility(0);
      if (parama.wL != null) {
        parama.wL.setVisibility(8);
      }
      if (parama.Jz != null) {
        parama.Jz.setVisibility(0);
      }
      return;
    }
  }
  
  private static String aZ(long paramLong)
  {
    if (paramLong > 100000000L) {
      return String.format("%.1f亿", new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) });
    }
    if (paramLong > 10000L) {
      return String.format("%.1f万", new Object[] { Float.valueOf((float)paramLong / 10000.0F) });
    }
    return String.format("%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  private void b(xlx.a parama, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    parama.wK.setVisibility(0);
    if (parama.wN != null) {
      parama.wN.setVisibility(8);
    }
    if (parama.wO != null) {
      parama.wO.setVisibility(8);
    }
    parama.JB.setVisibility(8);
    if (parama.wM == null)
    {
      parama.wM = ((ViewStub)parama.mRoot.findViewById(2131362500)).inflate();
      parama.d = ((CornerImageView)parama.mRoot.findViewById(2131362489));
      parama.ts = ((ImageView)parama.mRoot.findViewById(2131362502));
    }
    parama.wJ.setBackgroundResource(2130838330);
    parama.g.setVisibility(8);
    parama.wM.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = V(paramMessageForQzoneFeed.title, this.bVm);
      parama.Jz.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.bVd;
      paramMessageForQzoneFeed.mRequestHeight = this.bVe;
      a(parama.d, parama.ts, localMediaData, paramMessageForQzoneFeed, new float[] { this.bVj, this.bVj, this.bVj, this.bVj, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      parama.Jz.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(xlx.a parama, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    parama.wK.setVisibility(0);
    if (parama.wM != null) {
      parama.wM.setVisibility(8);
    }
    if (parama.wO != null) {
      parama.wO.setVisibility(8);
    }
    parama.JB.setVisibility(8);
    if (parama.wN == null)
    {
      parama.wN = ((ViewStub)parama.mRoot.findViewById(2131362495)).inflate();
      parama.e = ((CornerImageView)parama.mRoot.findViewById(2131362490));
      parama.tt = ((ImageView)parama.mRoot.findViewById(2131362503));
      parama.f = ((CornerImageView)parama.mRoot.findViewById(2131362491));
      parama.tu = ((ImageView)parama.mRoot.findViewById(2131362492));
      parama.JC = ((TextView)parama.mRoot.findViewById(2131362494));
    }
    parama.wJ.setBackgroundResource(2130838330);
    parama.g.setVisibility(8);
    parama.wN.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = V(paramMessageForQzoneFeed.title, this.bVm);
      parama.Jz.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      parama.JC.setText(String.format("共 %s 个", new Object[] { aZ(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.bVf;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.bVg;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.bVh;
      localURLDrawableOptions.mRequestHeight = this.bVi;
      a(parama.e, parama.tt, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.bVj, this.bVj, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(parama.f, parama.tu, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.bVj, this.bVj, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      parama.Jz.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      parama.JC.setText("");
    }
  }
  
  private void d(xlx.a parama, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    parama.wK.setVisibility(8);
    parama.JB.setVisibility(8);
    if (parama.wO == null)
    {
      parama.wO = ((ViewStub)parama.mRoot.findViewById(2131362478)).inflate();
      parama.JD = ((TextView)parama.mRoot.findViewById(2131362479));
      parama.JE = ((TextView)parama.mRoot.findViewById(2131362477));
    }
    parama.wJ.setBackgroundResource(2130838332);
    a(parama);
    parama.wO.setVisibility(0);
    String str = V(paramMessageForQzoneFeed.title, this.bVl);
    parama.JD.setText(str);
    parama.JE.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(xlx.a parama, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    parama.wK.setVisibility(8);
    if (parama.wO != null) {
      parama.wO.setVisibility(8);
    }
    parama.wJ.setBackgroundResource(2130838332);
    a(parama);
    parama.JB.setVisibility(0);
    parama.JB.setText(paramMessageForQzoneFeed.content);
  }
  
  public static String hx(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.indexOf("http");
    } while (i < 0);
    paramString = paramString.substring(i);
    try
    {
      new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (xlx.a)parama;
    parama = a(paramView, paramMessageRecord);
    paramMessageRecord.uniseq = paramLinearLayout.uniseq;
    paramMessageRecord.friendUin = paramLinearLayout.frienduin;
    paramMessageRecord.aVE = null;
    paramLinearLayout.coverImageUrl = hx(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.wJ.setOnClickListener(new xly(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = aurr.getArgumentsFromURL(paramLinearLayout.actionUrl);
    paramMessageRecord = null;
    if (paramView != null) {
      paramMessageRecord = (String)paramView.get("a");
    }
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.equals("4")) {
        break label280;
      }
      paramMessageRecord = "1";
    }
    for (;;)
    {
      paramView = new QZoneClickReport.a();
      paramView.actionType = "330";
      paramView.cMI = "1";
      paramView.reserves = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramView.reserves10 = "1";
      }
      paramView.reservesExt = new ArrayList();
      paramView.reservesExt.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.app.getAccount(), paramView);
      return parama;
      label280:
      if (paramMessageRecord.equals("311")) {
        paramMessageRecord = "2";
      } else if (paramMessageRecord.equals("2")) {
        paramMessageRecord = "3";
      } else {
        paramMessageRecord = "4";
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xlx.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  public boolean hO(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("fromAio", true);
    ocp.f(localIntent, paramString);
    this.mContext.startActivity(localIntent);
    return true;
  }
  
  class a
    extends wjd.a
  {
    TextView JA;
    TextView JB;
    TextView JC;
    TextView JD;
    TextView JE;
    TextView JF;
    TextView JG;
    TextView JH;
    TextView JI;
    TextView Jz;
    public String aVE;
    CornerImageView d;
    ImageView dp;
    CornerImageView e;
    CornerImageView f;
    public String friendUin;
    CornerImageView g;
    View mRoot;
    ImageView ts;
    ImageView tt;
    ImageView tu;
    public long uniseq;
    View vb;
    View wJ;
    View wK;
    View wL;
    View wM;
    View wN;
    View wO;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlx
 * JD-Core Version:    0.7.0.1
 */