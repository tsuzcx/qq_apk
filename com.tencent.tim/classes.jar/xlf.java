import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.io.File;
import java.util.List;

public class xlf
  extends xlc
{
  private Drawable mDefaultDrawable;
  
  public xlf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(xlf.a parama)
  {
    String str = this.a.uZ();
    if (aqhq.fileExistsAndNotEmpty(str))
    {
      int i = this.a.Eh();
      int j = this.a.Ei();
      if ((i == 0) || (j == 0)) {
        a(parama, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = parama.bUt;
      localURLDrawableOptions.mRequestHeight = parama.bUu;
      localURLDrawableOptions.mLoadingDrawable = new afei(Color.rgb(214, 214, 214), parama.bUt, parama.bUu);
      localURLDrawableOptions.mFailedDrawable = aoop.getFailedDrawable();
      localURLDrawableOptions.mGifRoundCorner = 6.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      parama = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      parama.setAutoDownload(true);
      return parama;
    }
    this.a.dgX();
    return getDefaultDrawable();
  }
  
  private void a(String paramString1, String paramString2, xlf.a parama, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (parama.hA != null)
    {
      parama.hA.removeAllViews();
      ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).removeView(parama.hA);
    }
    Object localObject1 = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject1).setId(2131364471);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839282);
    parama.hA = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, wja.dp2px(55.0F, this.mContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131373231);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131373231);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131373231);
      if (parama.c.mIsSend)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(6.0F, this.mContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = ahbr.aD(parama.bUt, parama.bUu);
        paramViewGroup = new TextView(this.mContext);
        paramViewGroup.setId(2131364471);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(7.0F, this.mContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(7.0F, this.mContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = wja.dp2px(7.0F, this.mContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.mContext, null);
        ((TextView)localObject2).setId(2131364474);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = wja.dp2px(7.0F, this.mContext.getResources());
        localLayoutParams.rightMargin = wja.dp2px(7.0F, this.mContext.getResources());
        localLayoutParams.bottomMargin = wja.dp2px(7.0F, this.mContext.getResources());
        if (i != 1) {
          break label592;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364471);
        label414:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = ahbr.a(this.mContext, i, parama.bUt, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (parama.c != null) {
        parama.c.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(6.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      break;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      break;
      label592:
      localLayoutParams.addRule(12);
      break label414;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      paramViewGroup.setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      paramViewGroup.setGravity(5);
    }
  }
  
  private void a(xlf.a parama)
  {
    if (parama.jdField_E_of_type_AndroidViewView == null) {
      return;
    }
    parama.c.setVisibility(4);
    parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(getDefaultDrawable());
    }
    for (;;)
    {
      Object localObject = new TextView(this.mContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(acfp.m(2131715737));
      ((TextView)localObject).setCompoundDrawablePadding(wja.dp2px(7.0F, this.mContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130850764, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(parama.bUt, parama.bUu);
      ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = aqhq.bP(this.a.getFileSize());
      a(this.a.getFileName(), (String)localObject, parama, localRelativeLayout, true);
      parama.hH = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(getDefaultDrawable());
    }
  }
  
  private void a(xlf.a parama, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(parama);
    Object localObject = aqhq.bP(this.a.getFileSize());
    a(this.a.getFileName(), (String)localObject, parama, (RelativeLayout)parama.jdField_E_of_type_AndroidViewView, false);
    parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (parama.hH != null)
    {
      parama.hH.removeAllViews();
      ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).removeView(parama.hH);
    }
    localObject = a(parama);
    parama.c.setImageResource(2130845196);
    parama.c.setImageDrawable((Drawable)localObject);
    b(parama, paramBaseChatItemLayout);
  }
  
  private void a(xlf.a parama, String paramString)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = ahav.i(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      parama.bUt = i;
      parama.bUu = j;
      this.a.ia(i, j);
    }
    b(parama);
  }
  
  private void b(xlf.a parama)
  {
    int i = this.a.Eh();
    int j = this.a.Ei();
    label24:
    Object localObject;
    if (i > 0)
    {
      if (j <= 0) {
        break label127;
      }
      localObject = ShortVideoUtils.d(i, j);
      i = localObject[0];
      j = localObject[1];
      localObject = parama.c.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      parama.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      parama.bUt = i;
      parama.bUu = j;
      return;
      i = 640;
      break;
      label127:
      j = 480;
      break label24;
      label134:
      if ((((ViewGroup.LayoutParams)localObject).width == i) && (((ViewGroup.LayoutParams)localObject).height == j)) {
        break label75;
      }
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      parama.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(xlf.a parama, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.a.bF();
    if (i == 1)
    {
      if (!aqhq.fileExistsAndNotEmpty(this.a.uZ()))
      {
        b(parama);
        a(parama);
      }
      return;
    }
    if (i == 3)
    {
      i = this.a.Ek();
      if (i < 100)
      {
        parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, parama.mMessage.frienduin + parama.mMessage.uniseq);
        return;
      }
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, parama.mMessage.frienduin + parama.mMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = acfp.m(2131715720);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850763);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = acfp.m(2131715729);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq))
      {
        parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130850763);
        parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, parama.mMessage.frienduin + parama.mMessage.uniseq);
        return;
      }
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850763);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq))
    {
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, parama.mMessage.frienduin + parama.mMessage.uniseq);
      return;
    }
    parama.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  protected View a(BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject;
    if ((parame instanceof xlf.a))
    {
      localObject = (xlf.a)parame;
      parame = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = parame;
      if (parame == null)
      {
        localObject = new RelativeLayout(this.mContext);
        parame = new BubbleVideoView(this.mContext);
        parame.setId(2131373231);
        parame.setScaleType(ImageView.ScaleType.CENTER_CROP);
        parame.setRadius(15.0F);
        parame.TE(true);
        parame.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
        ((RelativeLayout)localObject).addView(parame);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.mContext);
        localMessageProgressView.setId(2131364545);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        parame.setOnClickListener(this);
        super.a(parame, paramwlz);
        paramView.c = parame;
        paramView.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      parame = this.a.d();
      boolean bool = parame.isSend();
      paramView.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.c.mIsSend != bool)
      {
        paramView.c.setSend(bool);
        paramView.c.invalidate();
      }
      paramView.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView, paramwlz);
      paramView.jdField_b_of_type_ComTencentMobileqqWidgetMessageProgressView.bind(parame.frienduin + parame.uniseq);
      paramView.jdField_E_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new xlf.a();
      paramView.jdField_E_of_type_JavaLangStringBuilder = parame.jdField_E_of_type_JavaLangStringBuilder;
      paramView.mMessage = parame.mMessage;
      paramView.jdField_E_of_type_AndroidViewView = parame.jdField_E_of_type_AndroidViewView;
      paramView.jdField_b_of_type_Adxp = parame.jdField_b_of_type_Adxp;
      paramView.a = parame.a;
      paramView.bvc = parame.bvc;
      paramView.pos = parame.pos;
      paramView.count = parame.count;
      paramView.aRY = parame.aRY;
      paramView.uin = parame.uin;
      parame = null;
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if (paramView != null)
    {
      paramView = wja.a(paramView);
      if ((paramView != null) && (xlf.a.class.isInstance(paramView)))
      {
        paramView = (xlf.a)paramView;
        if (paramView != null) {
          return paramView.c;
        }
      }
    }
    return null;
  }
  
  protected List<Integer> a(aqoa paramaqoa, wko.a parama)
  {
    return this.a.ab(3);
  }
  
  protected BaseBubbleBuilder.e b()
  {
    return new xlf.a();
  }
  
  protected List<Integer> b(aqoa paramaqoa, wko.a parama)
  {
    return this.a.ac(3);
  }
  
  protected void b(int paramInt, ChatMessage paramChatMessage)
  {
    this.a.NU(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131372030: 
      j(paramChatMessage);
      return;
    }
    super.m(paramChatMessage);
  }
  
  protected String e(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return this.mContext.getString(2131693637);
    }
    return this.mContext.getString(2131693634);
  }
  
  protected void fu(View paramView)
  {
    if ((paramView.getId() != 2131373231) && (paramView.getId() != 2131364545)) {
      return;
    }
    this.a.u(3, paramView);
  }
  
  public Drawable getDefaultDrawable()
  {
    if (this.mDefaultDrawable == null)
    {
      float f = this.mDensity;
      this.mDefaultDrawable = new wye(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.mDefaultDrawable;
  }
  
  public class a
    extends xlc.a
  {
    public MessageProgressView b;
    public int bUt;
    public int bUu;
    public BubbleImageView c;
    public RelativeLayout hA;
    public RelativeLayout hH;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlf
 * JD-Core Version:    0.7.0.1
 */