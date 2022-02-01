import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

public class xmj
  extends wjd
  implements amfh, amif.a, amii.a
{
  public static long Jd;
  private static RichStatus c;
  long Je;
  SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager;
  public MessageForRichState a;
  xmj.b jdField_a_of_type_Xmj$b = new xmj.b(null);
  HashSet<xmj.a> aE = new HashSet();
  amhj jdField_b_of_type_Amhj;
  AIOAnimationConatiner jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = null;
  long lastClickTime;
  protected Handler sHandler = new Handler(Looper.getMainLooper());
  
  xmj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
    this.jdField_a_of_type_Xmj$b.ej = new WeakReference(this);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
    this.jdField_b_of_type_Amhj = ((amhj)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)paramQQAppInterface.getManager(58));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.report(3, 1);
    }
    if (this.jdField_b_of_type_Amhj != null) {
      this.jdField_b_of_type_Amhj.addListener(this.jdField_a_of_type_Xmj$b);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.adapter.notifyDataSetChanged();
    }
  }
  
  private void a(MessageForRichState paramMessageForRichState)
  {
    if (c == null) {
      c = new RichStatus(null);
    }
    c.feedsId = paramMessageForRichState.feedId;
    c.tplId = paramMessageForRichState.tplId;
    RichStatus localRichStatus = c;
    if (TextUtils.isEmpty(paramMessageForRichState.actionId))
    {
      i = c.actionId;
      localRichStatus.actionId = i;
      c.actionText = paramMessageForRichState.actionText;
      localRichStatus = c;
      if (!TextUtils.isEmpty(paramMessageForRichState.dataId)) {
        break label268;
      }
      i = c.dataId;
      label94:
      localRichStatus.dataId = i;
      c.dataText = paramMessageForRichState.dataText;
      c.locationText = paramMessageForRichState.locText;
      localRichStatus = c;
      if (!TextUtils.isEmpty(paramMessageForRichState.locPos)) {
        break label279;
      }
    }
    label268:
    label279:
    for (int i = c.locationPosition;; i = Integer.parseInt(paramMessageForRichState.locPos))
    {
      localRichStatus.locationPosition = i;
      c.time = paramMessageForRichState.time;
      c.fontId = paramMessageForRichState.fontId;
      c.fontType = paramMessageForRichState.fontType;
      c.plainText = null;
      if ((paramMessageForRichState.plainText == null) || (paramMessageForRichState.plainText.length() <= 0)) {
        break label290;
      }
      c.plainText = new ArrayList(paramMessageForRichState.plainText.length());
      i = 0;
      while (i < paramMessageForRichState.plainText.length())
      {
        c.plainText.add(paramMessageForRichState.plainText.optString(i));
        i += 1;
      }
      i = Integer.parseInt(paramMessageForRichState.actionId);
      break;
      i = Integer.parseInt(paramMessageForRichState.dataId);
      break label94;
    }
    label290:
    c.topicFromJson(paramMessageForRichState.topics);
    c.topicPosFromJson(paramMessageForRichState.topicsPos);
  }
  
  private void cdY()
  {
    Intent localIntent = new Intent(this.mContext, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", this.sessionInfo.aTl);
    localIntent.putExtra("key_uin_name", this.sessionInfo.aTn);
    localIntent.putExtra("key_open_via", "history-liaotian");
    PublicFragmentActivity.b.start(this.mContext, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    anot.a(this.app, "CliOper", "", "", "signiture", "aio_clk_his", 0, 0, "", "", "", "");
    anot.a(this.app, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "1", "", "");
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "signature_aio", "click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void doReport()
  {
    if (System.currentTimeMillis() - this.Je > 2000L)
    {
      this.Je = System.currentTimeMillis();
      anot.a(null, "dc00898", "", "", "0X800A4EB", "0X800A4EB", 0, 0, "0", "0", "", "");
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = ((MessageForRichState)paramMessageRecord);
    Jd = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout = (xmj.a)parama;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOSignViewHolder", 2, "convertView is null, create SignatureView.");
      }
      paramMessageRecord = new BoxShadowLayout(this.mContext);
      parama = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = wja.dp2px(6.0F, this.mContext.getResources());
      parama.leftMargin = i;
      parama.rightMargin = i;
      paramMessageRecord.setLayoutParams(parama);
      paramLinearLayout.a = new amia(this.mContext, this.app, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin);
      paramLinearLayout.a.a(this);
      paramLinearLayout.a.a(this);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState);
    paramLinearLayout.a.uniseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout.a.uin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin;
    paramLinearLayout.a.istroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.istroop;
    paramLinearLayout.a.feedsId = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedId;
    paramLinearLayout.a.tplId = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.tplId;
    paramLinearLayout.a.count = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.count;
    paramLinearLayout.a.zanFlag = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.zanFlag;
    if (this.sessionInfo.a.k != null) {
      paramLinearLayout.a.titleColor = this.sessionInfo.a.k.getDefaultColor();
    }
    parama = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.ver;
    if ((parama != null) && (parama.equals("1.0"))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time <= 0L) {
        break label608;
      }
    }
    label576:
    label608:
    for (parama = aqmu.a(this.mContext, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time * 1000L);; parama = null)
    {
      if (this.sessionInfo.aTn != null)
      {
        paramView = this.sessionInfo.aTn;
        paramView = aoij.M(20, paramView);
        paramwlz = paramView + acfp.m(2131713935);
        paramLinearLayout.a.title = paramwlz;
        if (aTl)
        {
          paramwlz = c.getPlainText();
          if (paramLinearLayout.E != null) {
            break label576;
          }
          paramLinearLayout.E = new StringBuilder();
        }
      }
      for (;;)
      {
        paramLinearLayout.E.append(paramView);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time > 0L) {
          paramLinearLayout.E.append("于").append(parama);
        }
        paramLinearLayout.E.append("更新了签名，内容是：").append(paramwlz);
        paramMessageRecord.setContentDescription(paramLinearLayout.E.toString());
        paramLinearLayout.a.a(c);
        this.app.a().aO(this.sessionInfo.aTl, c.time);
        ThreadManager.post(new RichStatItemBuilder.1(this), 8, null, true);
        doReport();
        return paramMessageRecord;
        paramView = this.sessionInfo.aTl;
        break;
        if (paramLinearLayout.E.length() > 0) {
          paramLinearLayout.E.delete(0, paramLinearLayout.E.length());
        }
      }
    }
  }
  
  protected wjd.a a()
  {
    xmj.a locala = new xmj.a();
    this.aE.add(locala);
    return locala;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.adapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(amif paramamif)
  {
    Resources localResources;
    if (!TextUtils.isEmpty(c.feedsId))
    {
      localResources = this.mContext.getResources();
      if (aqiw.isNetSupport(this.mContext)) {
        break label62;
      }
      QQToast.a(this.mContext, localResources.getString(2131693404), 0).show(((BaseActivity)this.mContext).getTitleBarHeight());
    }
    label62:
    int i;
    int j;
    do
    {
      return;
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.lastClickTime) < 200L)
      {
        QQToast.a(this.mContext, localResources.getString(2131691542), 0).show(((BaseActivity)this.mContext).getTitleBarHeight());
        return;
      }
      this.lastClickTime = l;
      try
      {
        paramamif = (amia)paramamif;
        i = paramamif.count;
        if (paramamif.zanFlag != 0) {
          break;
        }
        paramamif.zanFlag = 1;
        anot.a(this.app, "CliOper", "", "", "signiture", "aio_act_on", 0, 0, "", "", "", "");
        j = 1;
        i += 1;
        paramamif.count = i;
        paramamif.dNE();
        ((SignatureHandler)this.app.getBusinessHandler(41)).l(this.sessionInfo.aTl, paramamif.feedsId, 255, j);
        return;
      }
      catch (Exception paramamif) {}
    } while (!QLog.isColorLevel());
    QLog.i("ChatItemBuilder", 2, paramamif.getMessage(), paramamif);
    return;
    paramamif.zanFlag = 0;
    i -= 1;
    if (i > 0) {}
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "signiture", "aio_act_off", 0, 0, "", "", "", "");
      j = 0;
      break;
      i = 0;
    }
  }
  
  public void a(amii paramamii, View paramView)
  {
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick topic=", paramamii });
    paramamii = paramamii.getData();
    if ((paramamii instanceof Pair))
    {
      paramamii = (Pair)paramamii;
      if (QLog.isColorLevel()) {
        QLog.i("ChatItemBuilder", 2, String.format("aio onTopicClick [%d,%s]", new Object[] { paramamii.first, paramamii.second }));
      }
      amin.u(this.mContext, amin.K(((Integer)paramamii.first).intValue(), (String)paramamii.second), -1);
    }
  }
  
  public void a(View paramView, int paramInt, amif paramamif)
  {
    int i = 2;
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3)
    {
      cdY();
      paramInt = i;
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X800A98E", "0X800A98E", paramInt, 0, "0", "0", "", "");
      return;
      if (paramInt == 4)
      {
        a(paramamif);
        paramInt = 3;
      }
      else
      {
        cdY();
        paramInt = 1;
      }
    }
  }
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatItemBuilder", 2, "RichStatItemBuilder destroy");
    }
    Object localObject = this.aE.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xmj.a locala = (xmj.a)((Iterator)localObject).next();
      if (locala.a != null) {
        locala.a.destroy();
      }
    }
    if (this.jdField_b_of_type_Amhj != null) {
      this.jdField_b_of_type_Amhj.removeListener(this.jdField_a_of_type_Xmj$b);
    }
    localObject = (VasQuickUpdateManager)this.app.getManager(184);
    this.jdField_b_of_type_Amhj = null;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  }
  
  public static class a
    extends wjd.a
  {
    public amia a;
  }
  
  static class b
    implements amfi
  {
    public WeakReference<xmj> ej;
    
    public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
    {
      if (this.ej.get() != null) {
        xmj.a((xmj)this.ej.get(), paramInt1, paramInt2, paramBitmap, paramInt3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmj
 * JD-Core Version:    0.7.0.1
 */