import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;
import java.util.List;

public class xlb
  extends xlc
{
  private int bUr = (int)(BaseChatItemLayout.bNT * this.qn);
  private int bUs = BaseChatItemLayout.bNT;
  private Drawable mDefaultDrawable;
  private Drawable mLoadingDrawable;
  private float qn = 0.5625F;
  
  public xlb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(xlb.a parama)
  {
    Object localObject = this.a.uZ();
    if (aqhq.fileExistsAndNotEmpty((String)localObject))
    {
      i = this.a.Eh();
      int j = this.a.Ei();
      if ((i == 0) || (j == 0)) {
        a(parama, (String)localObject);
      }
      Drawable localDrawable1 = b(parama.bUt, parama.bUu);
      Drawable localDrawable2 = b(parama.bUt, parama.bUu);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      parama = localDrawable1;
      if (localObject != null) {
        parama = aoop.getDrawable((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return parama;
    }
    int i = this.a.El();
    if (i == 1)
    {
      a(parama, i);
      return getDefaultDrawable();
    }
    if (i == 2)
    {
      this.a.dgX();
      return b(parama.bUt, parama.bUu);
    }
    this.a.dgX();
    parama.wH.setVisibility(0);
    return getDefaultDrawable();
  }
  
  private void a(String paramString1, String paramString2, xlb.a parama)
  {
    if (parama.hA != null)
    {
      parama.hA.removeAllViews();
      ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).removeView(parama.hA);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setId(2131367049);
    localRelativeLayout.setBackgroundResource(2130839282);
    parama.hA = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, wja.dp2px(55.0F, this.mContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131373231);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131373231);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131373231);
    ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = ahbr.aD(parama.bUt, parama.bUu);
    localObject1 = new TextView(this.mContext);
    ((TextView)localObject1).setId(2131364471);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(7.0F, this.mContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(7.0F, this.mContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = wja.dp2px(7.0F, this.mContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.mContext, null);
    ((TextView)localObject2).setId(2131364474);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = wja.dp2px(7.0F, this.mContext.getResources());
    localLayoutParams.rightMargin = wja.dp2px(7.0F, this.mContext.getResources());
    localLayoutParams.bottomMargin = wja.dp2px(7.0F, this.mContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364471);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = ahbr.a(this.mContext, i, parama.bUt, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
      switch (i)
      {
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramString1);
      ((TextView)localObject1).setText(paramString2);
      return;
      localLayoutParams.addRule(12);
      break;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject1).setGravity(5);
    }
  }
  
  private void a(xlb.a parama)
  {
    FrameLayout localFrameLayout = parama.bd;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(getDefaultDrawable());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131369361);
      localTextView.setText(2131694741);
      localTextView.setCompoundDrawablePadding(wja.dp2px(7.0F, this.mContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130850764, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(parama.bUt, parama.bUu));
      return;
      localFrameLayout.setBackgroundDrawable(getDefaultDrawable());
    }
  }
  
  private void a(xlb.a parama, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = parama.bd;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label164;
      }
      localFrameLayout.setBackground(getDefaultDrawable());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131369361);
      localTextView.setText(2131693639);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(wja.dp2px(4.0F, this.mContext.getResources()));
      Drawable localDrawable = this.mContext.getResources().getDrawable(2130845723);
      localDrawable.setBounds(0, 0, wja.dp2px(28.0F, this.mContext.getResources()), wja.dp2px(28.0F, this.mContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(parama.bUt, parama.bUu));
      return;
      label164:
      localFrameLayout.setBackgroundDrawable(getDefaultDrawable());
    }
  }
  
  private void a(xlb.a parama, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (parama.bd != null) {
      parama.bd.setVisibility(8);
    }
    b(parama);
    parama.wH.setVisibility(8);
    Object localObject = a(parama);
    parama.c.setImageDrawable((Drawable)localObject);
    localObject = aqhq.bP(this.a.getFileSize());
    a(this.a.getFileName(), (String)localObject, parama);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(parama, paramBaseChatItemLayout);
  }
  
  private void a(xlb.a parama, String paramString)
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
  
  private void a(xlb.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.mContext);
        localPicProgressView.setRadius(this.mDensity * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131373231);
        localLayoutParams.addRule(8, 2131373231);
        localLayoutParams.addRule(5, 2131373231);
        localLayoutParams.addRule(7, 2131373231);
        ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(parama.mMessage.frienduin + parama.mMessage.uniseq);
        parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.a.Ek());
      }
    }
    if (!parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.sd(parama.mMessage.frienduin + parama.mMessage.uniseq))
    {
      ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).removeView(parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    parama.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private Drawable b(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.mLoadingDrawable == null)
    {
      localBitmap = null;
      if (!(aoop.am() instanceof SkinnableBitmapDrawable)) {
        break label60;
      }
      localBitmap = ((SkinnableBitmapDrawable)aoop.am()).getBitmap();
    }
    for (;;)
    {
      this.mLoadingDrawable = new afeg(this.mContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.mLoadingDrawable;
      label60:
      if ((aoop.am() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)aoop.am()).getBitmap();
      }
    }
  }
  
  private void b(xlb.a parama)
  {
    Object localObject = this.a.uZ();
    localObject = ahbh.a(this.a.Eh(), this.a.Ei(), (String)localObject);
    int i = ((ahbh.a)localObject).width;
    int j = ((ahbh.a)localObject).height;
    if ((i > 0) && (j > 0))
    {
      parama.bUt = i;
      parama.bUu = j;
      localObject = parama.c.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(parama.bUt, parama.bUu);
      parama.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == parama.bUt) && (((ViewGroup.LayoutParams)localObject).height == parama.bUu))
    {
      return;
      parama.bUt = this.bUr;
      parama.bUu = this.bUs;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = parama.bUt;
    ((ViewGroup.LayoutParams)localObject).height = parama.bUu;
    parama.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(xlb.a parama, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.a.bF();
    if (i == 1)
    {
      if (!aqhq.fileExistsAndNotEmpty(this.a.uZ()))
      {
        b(parama);
        a(parama);
        parama.wH.setVisibility(8);
        if (parama.hA != null)
        {
          parama.hA.removeAllViews();
          ((RelativeLayout)parama.jdField_E_of_type_AndroidViewView).removeView(parama.hA);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(parama, true);
      parama.wH.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(parama, false);
      return;
    }
    a(parama, false);
  }
  
  private Drawable getDefaultDrawable()
  {
    if (this.mDefaultDrawable == null)
    {
      float f = this.mDensity;
      this.mDefaultDrawable = new wye(Color.argb(255, 242, 242, 242), 255, f * 8.0F);
    }
    return this.mDefaultDrawable;
  }
  
  protected View a(BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject1;
    if ((parame instanceof xlb.a))
    {
      localObject1 = (xlb.a)parame;
      parame = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = parame;
      if (parame == null)
      {
        localObject1 = new RelativeLayout(this.mContext);
        parame = new BubbleImageView(this.mContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          parame.aAu = true;
        }
        parame.setId(2131373231);
        parame.setAdjustViewBounds(true);
        parame.setScaleType(ImageView.ScaleType.CENTER_CROP);
        parame.setRadius(15.0F);
        parame.TE(false);
        parame.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(parame, new RelativeLayout.LayoutParams(-2, -2));
        paramView.c = parame;
        parame = new FrameLayout(this.mContext);
        Object localObject2 = new TextView(this.mContext);
        ((TextView)localObject2).setId(2131369361);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        parame.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        parame.setVisibility(8);
        ((RelativeLayout)localObject1).addView(parame, new RelativeLayout.LayoutParams(-1, -1));
        paramView.bd = parame;
        parame = new LinearLayout(this.mContext);
        parame.setOrientation(1);
        parame.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(parame, (ViewGroup.LayoutParams)localObject2);
        paramView.wH = parame;
        localObject2 = new ImageView(this.mContext);
        ((ImageView)localObject2).setImageResource(2130839651);
        parame.addView((View)localObject2, new LinearLayout.LayoutParams(wja.dp2px(20.0F, this.mContext.getResources()), wja.dp2px(20.0F, this.mContext.getResources())));
        localObject2 = new TextView(this.mContext);
        ((TextView)localObject2).setText(2131693641);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(8.0F, this.mContext.getResources());
        parame.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramwlz);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_E_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new xlb.a();
      paramView.jdField_E_of_type_JavaLangStringBuilder = parame.jdField_E_of_type_JavaLangStringBuilder;
      paramView.mMessage = parame.mMessage;
      paramView.jdField_E_of_type_AndroidViewView = parame.jdField_E_of_type_AndroidViewView;
      paramView.b = parame.b;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
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
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (xlb.a.class.isInstance(paramView))) {
        return ((xlb.a)paramView).c;
      }
    }
    return null;
  }
  
  protected List<Integer> a(aqoa paramaqoa, wko.a parama)
  {
    return this.a.ab(2);
  }
  
  protected BaseBubbleBuilder.e b()
  {
    return new xlb.a();
  }
  
  protected List<Integer> b(aqoa paramaqoa, wko.a parama)
  {
    return this.a.ac(2);
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
      return this.mContext.getString(2131693636);
    }
    return this.mContext.getString(2131693633);
  }
  
  protected void fu(View paramView)
  {
    if (paramView.getId() == 2131364503)
    {
      paramView = wja.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!xlb.a.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (xlb.a)paramView;
    this.a.u(2, paramView.c);
  }
  
  public class a
    extends xlc.a
  {
    public PicProgressView a;
    public int bUt;
    public int bUu;
    public FrameLayout bd;
    public boolean bhF = true;
    public BubbleImageView c;
    public RelativeLayout hA;
    public View wH;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlb
 * JD-Core Version:    0.7.0.1
 */