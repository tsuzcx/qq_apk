import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.gamecenter.view.ShadowView;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class abdp
  extends BaseAdapter
{
  private boolean bnX;
  public View.OnClickListener cn;
  boolean isNightMode;
  public QQAppInterface k;
  public ArrayList<anxi> mDataList;
  public LayoutInflater mInflater;
  
  public abdp(QQAppInterface paramQQAppInterface, ArrayList<anxi> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.k = paramQQAppInterface;
    this.mDataList = paramArrayList;
    this.mInflater = LayoutInflater.from(this.k.getApplication());
    this.cn = paramOnClickListener;
    this.isNightMode = ThemeUtil.isInNightMode(this.k);
    this.bnX = anlm.ayn();
  }
  
  private int a(anxi paramanxi)
  {
    if ((paramanxi.type != 3) && (paramanxi.type != 7)) {}
    label172:
    label174:
    label178:
    for (;;)
    {
      return 0;
      if ((paramanxi.eY instanceof SubAccountMessage)) {
        paramanxi = ((SubAccountMessage)paramanxi.eY).subUin;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramanxi)) {
          break label178;
        }
        Object localObject = (anxi)this.mDataList.get(0);
        if ((((anxi)localObject).type != 2) || (((anxi)localObject).eY == null) || (!(((anxi)localObject).eY instanceof ArrayList))) {
          break;
        }
        localObject = (ArrayList)((anxi)localObject).eY;
        int i = 0;
        for (;;)
        {
          if (i >= ((ArrayList)localObject).size()) {
            break label172;
          }
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)((anxi)((ArrayList)localObject).get(i)).eY;
          if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(paramanxi)))
          {
            return i;
            if (!(paramanxi.eY instanceof SubAccountInfo)) {
              break label174;
            }
            paramanxi = ((SubAccountInfo)paramanxi.eY).subuin;
            break;
          }
          i += 1;
        }
        break;
        paramanxi = "";
      }
    }
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i;
    if (paramView == null)
    {
      i = 2131563136;
      if (paramInt2 == 7)
      {
        i = 2131563137;
        paramView = this.mInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new abdp.b();
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      anxi localanxi = (anxi)getItem(paramInt1);
      paramViewGroup.jdField_a_of_type_Anxi = localanxi;
      if (localanxi != null)
      {
        a(paramView, localanxi);
        paramView.setOnClickListener(this.cn);
        if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(localanxi.ciA))) {
          paramView.setContentDescription(localanxi.ciA);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2131563139;
      break;
      paramViewGroup = (abdp.b)paramView.getTag();
    }
  }
  
  private void a(abdp.b paramb, anxi paramanxi, View paramView)
  {
    paramb.c.setText(paramanxi.bQA);
    Object localObject = (SubAccountInfo)paramanxi.eY;
    if (localObject != null)
    {
      aqdj localaqdj = aqdj.a(this.k, 1, 1, ((SubAccountInfo)localObject).subuin);
      if (paramanxi.status == 0)
      {
        paramb.wZ.setBackgroundDrawable(null);
        paramb.h.setImageDrawable(localaqdj);
        paramb.h.setTag(((SubAccountInfo)localObject).subuin);
        localObject = anxk.a(this.k, ((SubAccountInfo)localObject).subuin);
        if (((anxk.b)localObject).unReadCount <= 0) {
          break label234;
        }
        aute.updateCustomNoteTxt(paramb.d, 1, ((anxk.b)localObject).unReadCount, 0, 99, null);
      }
    }
    else
    {
      label116:
      paramb.jdField_a_of_type_Anxi = paramanxi;
      if (!paramanxi.cKq) {
        break label246;
      }
      paramb.Ax.setScaleX(1.0F);
      paramb.Ax.setScaleY(1.0F);
      if (!anlm.Vr()) {}
      paramb.Ax.setBackgroundDrawable(paramb.Ax.getResources().getDrawable(2130847045));
    }
    for (;;)
    {
      paramView.setTag(paramb);
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).Wd(true);
      }
      paramView.setOnClickListener(this.cn);
      if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(paramanxi.ciA))) {
        paramView.setContentDescription(paramanxi.ciA);
      }
      return;
      paramb.wZ.setBackgroundResource(2130851378);
      break;
      label234:
      paramb.d.setVisibility(8);
      break label116;
      label246:
      paramb.Ax.setScaleX(0.93F);
      paramb.Ax.setScaleY(0.93F);
      paramb.Ax.setBackgroundDrawable(null);
    }
  }
  
  private void a(View paramView, anxi paramanxi)
  {
    if ((paramView == null) || (paramanxi == null)) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    switch (paramanxi.dNg)
    {
    default: 
      return;
    case 1: 
    case 2: 
      localObject1 = paramView.findViewById(2131365990);
      float f = aqgz.getDesity();
      View localView;
      if (this.isNightMode)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localView = paramView.findViewById(2131369540);
        localObject3 = paramView.getLayoutParams();
        if (!paramanxi.cKq) {
          break label328;
        }
        localObject2 = paramView.findViewById(2131369521);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(2130839682);
        if (localView != null) {
          localView.setVisibility(0);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296610));
        localObject1 = (UpArrowView)paramView.findViewById(2131362978);
        localObject2 = (ShadowView)paramView.findViewById(2131362998);
        if (localObject2 != null)
        {
          ((ShadowView)localObject2).setOriginColor(0);
          ((ShadowView)localObject2).setShadowProperties(wja.dp2px(6.0F, ((ShadowView)localObject2).getResources()), 0.0F, wja.dp2px(2.0F, ((ShadowView)localObject2).getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null)
        {
          if (this.isNightMode) {
            ((UpArrowView)localObject1).setTheme(true);
          }
          b((View)localObject1, paramanxi);
        }
      }
      for (;;)
      {
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        return;
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setVisibility(8);
        if (!(((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          break;
        }
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        if (paramanxi.dNg == 1) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f * 16.0F + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
        {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        label328:
        paramView.setBackgroundResource(2130839682);
        if (localView != null) {
          localView.setVisibility(8);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296608));
      }
    }
    if (paramanxi.cKq)
    {
      localObject1 = paramView.findViewById(2131369521);
      if (localObject1 != null) {
        break label601;
      }
      localObject1 = paramView;
    }
    label599:
    label601:
    for (;;)
    {
      localObject2 = (UpArrowView)paramView.findViewById(2131362978);
      localObject3 = (ShadowView)paramView.findViewById(2131362998);
      if (localObject3 != null)
      {
        ((ShadowView)localObject3).setOriginColor(0);
        ((ShadowView)localObject3).setShadowProperties(wja.dp2px(6.0F, ((ShadowView)localObject3).getResources()), 0.0F, wja.dp2px(2.0F, ((ShadowView)localObject3).getResources()), Color.parseColor("#B3E0E1E7"));
      }
      b((View)localObject2, paramanxi);
      ((View)localObject1).setBackgroundResource(2130839682);
      for (;;)
      {
        if (!this.isNightMode) {
          break label599;
        }
        localObject1 = paramView.findViewById(2131365990);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!paramanxi.cKq) {
          break;
        }
        localObject1 = (UpArrowView)paramView.findViewById(2131362978);
        paramView = (ShadowView)paramView.findViewById(2131362998);
        if (paramView != null)
        {
          paramView.setOriginColor(0);
          paramView.setShadowProperties(wja.dp2px(6.0F, paramView.getResources()), 0.0F, wja.dp2px(2.0F, paramView.getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null) {
          ((UpArrowView)localObject1).setTheme(true);
        }
        b((View)localObject1, paramanxi);
        return;
        paramView.setBackgroundResource(2130839682);
      }
      break;
    }
  }
  
  private void b(View paramView, anxi paramanxi)
  {
    if ((paramView == null) || (paramanxi == null)) {
      return;
    }
    int i = a(paramanxi);
    paramanxi = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int j = wja.dp2px(43.0F, paramView.getResources());
    paramanxi.leftMargin = (i * wja.dp2px(73.0F, paramView.getResources()) + j - wja.dp2px(6.0F, paramView.getResources()));
    paramView.setLayoutParams(paramanxi);
  }
  
  private View o(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    Object localObject;
    ArrayList localArrayList;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131563140, paramViewGroup, false);
      paramViewGroup = new abdp.a();
      paramViewGroup.jdField_a_of_type_Abdp$b = new abdp.b();
      paramViewGroup.jdField_a_of_type_Abdp$b.c = ((SingleLineTextView)paramView.findViewById(2131379769));
      paramViewGroup.jdField_a_of_type_Abdp$b.c.getPaint().setFakeBoldText(true);
      paramViewGroup.jdField_a_of_type_Abdp$b.h = ((FixSizeImageView)paramView.findViewById(2131368698));
      paramViewGroup.jdField_a_of_type_Abdp$b.wZ = ((ImageView)paramView.findViewById(2131368713));
      paramViewGroup.jdField_a_of_type_Abdp$b.d = ((DragTextView)paramView.findViewById(2131381286));
      paramViewGroup.jdField_a_of_type_Abdp$b.Ax = paramView.findViewById(2131368125);
      paramViewGroup.b = new abdp.b();
      paramViewGroup.b.c = ((SingleLineTextView)paramView.findViewById(2131379787));
      paramViewGroup.b.c.getPaint().setFakeBoldText(true);
      paramViewGroup.b.h = ((FixSizeImageView)paramView.findViewById(2131368704));
      paramViewGroup.b.wZ = ((ImageView)paramView.findViewById(2131368714));
      paramViewGroup.b.d = ((DragTextView)paramView.findViewById(2131381287));
      paramViewGroup.b.Ax = paramView.findViewById(2131368126);
      paramViewGroup.Au = paramView.findViewById(2131368725);
      paramViewGroup.Av = paramView.findViewById(2131368726);
      paramViewGroup.Aw = paramView.findViewById(2131362223);
      ((SingleLineTextView)paramView.findViewById(2131362177)).getPaint().setFakeBoldText(true);
      if ((paramViewGroup.Aw instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.Aw).Wd(true);
      }
      paramViewGroup.Aw.setOnClickListener(this.cn);
      paramView.setTag(paramViewGroup);
      localObject = (anxi)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Anxi = ((anxi)localObject);
      a(paramView, (anxi)localObject);
      localArrayList = (ArrayList)((anxi)localObject).eY;
      if (localArrayList.size() != 1) {
        break label484;
      }
      paramViewGroup.Au.setVisibility(0);
      paramViewGroup.Av.setVisibility(8);
      paramViewGroup.Aw.setVisibility(0);
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt >= localArrayList.size()) || (paramInt >= 2)) {
        return paramView;
      }
      anxi localanxi = (anxi)localArrayList.get(paramInt);
      abdp.b localb = paramViewGroup.jdField_a_of_type_Abdp$b;
      localObject = paramViewGroup.Au;
      if (paramInt == 1)
      {
        localb = paramViewGroup.b;
        localObject = paramViewGroup.Av;
      }
      a(localb, localanxi, (View)localObject);
      paramInt += 1;
      continue;
      paramViewGroup = (abdp.a)paramView.getTag();
      break;
      label484:
      paramInt = i;
      if (localArrayList.size() > 1)
      {
        paramViewGroup.Au.setVisibility(0);
        paramViewGroup.Av.setVisibility(0);
        paramViewGroup.Aw.setVisibility(8);
        paramInt = i;
      }
    }
    return paramView;
  }
  
  private View p(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    anxi localanxi;
    int j;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131563141, paramViewGroup, false);
      paramViewGroup = new abdp.b();
      paramViewGroup.h = ((FixSizeImageView)paramView.findViewById(2131368698));
      paramViewGroup.c = ((SingleLineTextView)paramView.findViewById(2131379769));
      paramViewGroup.d = ((DragTextView)paramView.findViewById(2131381288));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).Wd(true);
      }
      paramViewGroup.c.getPaint().setFakeBoldText(true);
      paramView.setTag(paramViewGroup);
      localanxi = (anxi)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Anxi = localanxi;
      SimpleAccount localSimpleAccount = (SimpleAccount)localanxi.eY;
      aqdj localaqdj = aqdj.a(this.k, 1, 1, localSimpleAccount.getUin());
      paramViewGroup.c.setText(localanxi.bQA);
      paramViewGroup.h.setTag(localSimpleAccount.getUin());
      paramViewGroup.h.setImageDrawable(localaqdj);
      paramViewGroup.d.setDragViewType(1, paramView);
      j = localanxi.unreadNum;
      if (j <= 0) {
        break label267;
      }
      i = 2130845715;
    }
    label267:
    for (paramInt = 3;; paramInt = 0)
    {
      aute.updateCustomNoteTxt(paramViewGroup.d, paramInt, j, i, 99, null);
      paramView.setOnClickListener(this.cn);
      if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(localanxi.ciA))) {
        paramView.setContentDescription(localanxi.ciA);
      }
      return paramView;
      paramViewGroup = (abdp.b)paramView.getTag();
      break;
    }
  }
  
  private View q(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    abdp.b localb;
    anxi localanxi;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    if (paramView == null)
    {
      paramViewGroup = this.mInflater.inflate(2131563135, paramViewGroup, false);
      localb = new abdp.b();
      localb.c = ((SingleLineTextView)paramViewGroup.findViewById(2131379769));
      localb.h = ((FixSizeImageView)paramViewGroup.findViewById(2131368698));
      localb.d = ((DragTextView)paramViewGroup.findViewById(2131381288));
      localb.C = ((SingleLineTextView)paramViewGroup.findViewById(2131365748));
      paramViewGroup.setTag(localb);
      localanxi = (anxi)getItem(paramInt);
      localb.jdField_a_of_type_Anxi = localanxi;
      localResources = this.k.getApplication().getResources();
      if (localanxi != null)
      {
        localSubAccountMessage = (SubAccountMessage)localanxi.eY;
        paramView = localSubAccountMessage.sendername;
        if (localSubAccountMessage.istroop == 1) {
          paramView = localResources.getString(2131720593);
        }
        if (!TextUtils.isEmpty(paramView)) {
          break label1176;
        }
      }
    }
    label260:
    label269:
    label530:
    label1176:
    for (Object localObject = localSubAccountMessage.senderuin;; localObject = paramView)
    {
      localb.c.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new aofk(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1) {
        if (localSubAccountMessage.unreadNum > 0)
        {
          paramView = localResources.getString(2131720594);
          localb.C.setText(paramView);
          if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
            localSubAccountMessage.mTimeString = aqmu.a(localSubAccountMessage.time * 1000L, true, anxk.ciB);
          }
          if (localSubAccountMessage.istroop != 1) {
            localb.c.setExtendText(localSubAccountMessage.mTimeString, 0);
          }
          if (!acbn.blA.equals(localSubAccountMessage.senderuin)) {
            break label911;
          }
        }
      }
      try
      {
        paramView = BitmapFactory.decodeResource(localResources, 2130843306);
        if (!this.bnX) {
          break label878;
        }
        paramView = QQAppInterface.b(paramView, aqhu.dZm, 50, 50);
        localb.h.setImageBitmap(paramView);
      }
      catch (OutOfMemoryError paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, QLog.getStackTraceString(paramView));
          }
        }
      }
      localb.d.setTag(Integer.valueOf(paramInt));
      int i1 = localSubAccountMessage.unreadNum;
      int i = 0;
      int j = 0;
      if ((i1 > 0) && (localSubAccountMessage.istroop == 1))
      {
        j = 2130851400;
        i = 1;
        paramView = "";
        paramInt = 0;
      }
      for (;;)
      {
        label445:
        localb.C.setExtendText(paramView, 1);
        localb.d.setDragViewType(0, paramViewGroup);
        aute.updateCustomNoteTxt(localb.d, i, i1, j, 99, null);
        StringBuilder localStringBuilder;
        float f;
        if ((AppSetting.enableTalkBack) && (TextUtils.isEmpty(localanxi.ciA)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject).append(",");
          if (localanxi.unreadNum == 0)
          {
            if (paramView != null) {
              localStringBuilder.append(paramView + ",");
            }
            localStringBuilder.append(localSubAccountMessage.mEmoRecentMsg).append(",").append(localSubAccountMessage.mTimeString);
            localanxi.ciA = localStringBuilder.toString();
          }
        }
        else
        {
          f = aqgz.getDesity();
          paramView = localResources.getColorStateList(2131167379);
          localObject = localResources.getColorStateList(2131167304);
          i = localResources.getColor(2131167410);
          localb.c.setTextColor((ColorStateList)localObject);
          localb.c.setExtendTextColor(paramView, 0);
          localb.c.setExtendTextSize(12.0F, 0);
          localb.c.setCompoundDrawablePadding((int)(3.0F * f));
          localb.c.setExtendTextPadding((int)(5.0F * f), 2);
          localb.c.setExtendTextColor(paramView, 2);
          localb.c.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label1156;
          }
          localb.C.setTextColor(i);
        }
        for (;;)
        {
          localb.C.setExtendTextColor(ColorStateList.valueOf(i), 1);
          localb.C.setExtendTextPadding((int)(f * 2.0F), 1);
          localb.C.setExtendTextSize(14.0F, 1);
          a(paramViewGroup, localanxi);
          paramViewGroup.setOnClickListener(this.cn);
          if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(localanxi.ciA))) {
            paramViewGroup.setContentDescription(localanxi.ciA);
          }
          if (this.isNightMode)
          {
            paramView = paramViewGroup.findViewById(2131366002);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          return paramViewGroup;
          localb = (abdp.b)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = localResources.getString(2131720595);
          break label260;
          localb.C.setText(localSubAccountMessage.mEmoRecentMsg);
          break label269;
          label878:
          paramView = QQAppInterface.getCircleFaceBitmap(paramView, 50, 50);
          break label384;
          paramView = aqdj.a(this.k, 1, 4, localSubAccountMessage.senderuin);
          localb.h.setTag(localSubAccountMessage.senderuin);
          localb.h.setImageDrawable(paramView);
          localb.h.setVisibility(0);
          break label393;
          if (i1 <= 0) {
            break label1168;
          }
          paramInt = 2130851404;
          int m = 3;
          if ((2 == localanxi.dNh) || (3 == localanxi.dNh))
          {
            paramView = "[" + localResources.getString(2131717467) + "]";
            n = 0;
            i = m;
            j = paramInt;
            paramInt = n;
            break label445;
          }
          i = m;
          j = paramInt;
          if (!"RED_PACKET".equals(localSubAccountMessage.subExtr)) {
            break label1168;
          }
          paramView = "";
          int n = 1;
          i = m;
          j = paramInt;
          paramInt = n;
          break label445;
          if (localanxi.unreadNum == 1)
          {
            localStringBuilder.append("有一条未读");
            break label530;
          }
          if (localanxi.unreadNum == 2)
          {
            localStringBuilder.append("有两条未读");
            break label530;
          }
          if (localanxi.unreadNum <= 0) {
            break label530;
          }
          localStringBuilder.append("有").append(localanxi.unreadNum).append("条未读,");
          break label530;
          localb.C.setTextColor(paramView);
        }
        paramView = "";
        paramInt = 0;
      }
    }
  }
  
  public int getCount()
  {
    if (this.mDataList != null) {
      return this.mDataList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size())) {
      return this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mDataList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size())) {
      return ((anxi)this.mDataList.get(paramInt)).type;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, "getView() position=" + paramInt + " viewType=" + i);
    }
    View localView;
    switch (i)
    {
    case 5: 
    default: 
      localView = paramView;
      if (paramView == null) {
        localView = this.mInflater.inflate(2131563138, paramViewGroup, false);
      }
      paramView = localView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = q(paramInt, paramView, paramViewGroup);
      continue;
      localView = p(paramInt, paramView, paramViewGroup);
      continue;
      localView = o(paramInt, paramView, paramViewGroup);
      continue;
      localView = a(paramInt, paramView, paramViewGroup, i);
    }
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public class a
    extends abdp.b
  {
    public View Au;
    public View Av;
    public View Aw;
    public abdp.b a;
    public abdp.b b;
    
    public a()
    {
      super();
    }
  }
  
  public class b
  {
    public View Ax;
    public SingleLineTextView C;
    public anxi a;
    public SingleLineTextView c;
    public DragTextView d;
    public FixSizeImageView h;
    public ImageView wZ;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdp
 * JD-Core Version:    0.7.0.1
 */