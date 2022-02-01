import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.util.VersionUtils;
import java.util.List;

public class xle
  extends xlc
{
  public xle(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(xle.a parama)
  {
    if (this.a.bF() == 3)
    {
      i = this.a.Ek();
      parama.j.setProgress(i);
      parama.j.setVisibility(0);
      if ((parama.bUv >= 0) && (i - parama.bUv > 1))
      {
        parama.bUv = i;
        QQAppInterface.EI(this.mContext.getString(2131693638) + i);
      }
      parama.j.setContentDescription(this.mContext.getString(2131693638) + i);
      i = wja.dp2px(14.0F, this.mContext.getResources());
      j = wja.dp2px(18.0F, this.mContext.getResources());
      if (this.a.alo())
      {
        parama.r.setPadding(i, i, j, 0);
        return;
      }
      parama.r.setPadding(j, i, i, 0);
      return;
    }
    parama.j.setVisibility(8);
    int i = wja.dp2px(14.0F, this.mContext.getResources());
    int j = wja.dp2px(18.0F, this.mContext.getResources());
    if (this.a.alo())
    {
      parama.r.setPadding(i, i, j, i);
      return;
    }
    parama.r.setPadding(j, i, i, i);
  }
  
  private void a(xle.a parama, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.a.getFileName();
    ahav.b(parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    parama.T.setText(paramBaseChatItemLayout);
    long l = this.a.getFileSize();
    parama.U.setText(ahbj.j(l, this.mContext.getResources().getDisplayMetrics().densityDpi));
    a(parama);
    b(parama);
  }
  
  private String aY(long paramLong)
  {
    int i = (int)Math.ceil(paramLong * 1.0D / 86400L);
    return String.format(this.mContext.getString(2131693631), new Object[] { Integer.valueOf(i) });
  }
  
  private void b(xle.a parama)
  {
    String str2 = "";
    int i = this.a.bF();
    String str1;
    if (i == 1) {
      str1 = " / " + this.mContext.getString(2131693594);
    }
    while (!TextUtils.isEmpty(str1))
    {
      parama.V.setVisibility(0);
      parama.V.setText(str1);
      return;
      if (i == 6)
      {
        str1 = " / " + this.mContext.getString(2131693593);
      }
      else if (i == 2)
      {
        i = this.a.Ej();
        if (i == 3)
        {
          str1 = " / " + this.mContext.getString(2131693598);
        }
        else
        {
          str1 = str2;
          if (i == 6) {
            str1 = " / " + this.mContext.getString(2131693597);
          }
        }
      }
      else if (i == 4)
      {
        str1 = " / " + this.mContext.getString(2131693596);
      }
      else
      {
        long l;
        if (i == 2)
        {
          l = this.a.fE();
          if (l == -1L)
          {
            str1 = " / " + this.mContext.getString(2131693594);
          }
          else
          {
            str1 = str2;
            if (l != 0L) {
              str1 = aY(l);
            }
          }
        }
        else
        {
          i = this.a.Ej();
          str1 = str2;
          if (i != 1) {
            if (i == 2)
            {
              str1 = " / " + this.mContext.getString(2131693599);
            }
            else
            {
              str1 = str2;
              if (i != 4) {
                if (i == 5)
                {
                  str1 = " / " + this.mContext.getString(2131693591);
                }
                else if (i == 6)
                {
                  str1 = " / " + this.mContext.getString(2131693591);
                }
                else
                {
                  l = this.a.fE();
                  if (l == -1L)
                  {
                    str1 = " / " + this.mContext.getString(2131693593);
                  }
                  else
                  {
                    str1 = str2;
                    if (l != 0L) {
                      str1 = aY(l);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    parama.V.setVisibility(8);
  }
  
  protected View a(BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xle.a locala = (xle.a)parame;
    parame = paramView;
    if (paramView == null)
    {
      int i = wja.dp2px(14.0F, this.mContext.getResources());
      int j = wja.dp2px(6.0F, this.mContext.getResources());
      parame = new RelativeLayout(this.mContext);
      parame.setId(2131364503);
      Object localObject1 = this.mContext.getResources();
      parame.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296404), ((Resources)localObject1).getDimensionPixelSize(2131296406), ((Resources)localObject1).getDimensionPixelSize(2131296403), ((Resources)localObject1).getDimensionPixelSize(2131296405));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.bOh, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131299515);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131368698);
      parame.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      locala.E = paramView;
      paramView = new LinearLayout(this.mContext);
      paramView.setMinimumHeight(wja.dp2px(76.0F, this.mContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364503);
      parame.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject1).setId(2131367050);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      locala.r = ((RelativeLayout)localObject1);
      k = wja.dp2px(48.0F, this.mContext.getResources());
      localObject2 = new AsyncImageView(this.mContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131364472);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.mContext, null);
      ((TextView)localObject2).setId(2131364474);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364472);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      locala.T = ((TextView)localObject2);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setId(2131364471);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364474);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      locala.U = ((TextView)localObject2);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setId(2131364476);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364471);
      localLayoutParams.addRule(8, 2131364471);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      locala.V = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.mContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131364475);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.mContext.getResources().getDrawable(2130845209));
      localObject2 = new LinearLayout.LayoutParams(-1, wja.dp2px(2.0F, this.mContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      locala.j = ((ProgressBar)localObject1);
      locala.E = parame;
    }
    parame.setOnClickListener(this);
    super.a(parame, paramwlz);
    locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(locala, paramBaseChatItemLayout);
    return parame;
  }
  
  protected List<Integer> a(aqoa paramaqoa, wko.a parama)
  {
    return this.a.ab(1);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame)
  {
    if (paramChatMessage.isSend())
    {
      parame.E.setBackgroundResource(2130851006);
      return;
    }
    parame.E.setBackgroundResource(2130850829);
  }
  
  protected BaseBubbleBuilder.e b()
  {
    return new xle.a();
  }
  
  protected List<Integer> b(aqoa paramaqoa, wko.a parama)
  {
    return this.a.ac(1);
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
      return this.mContext.getString(2131693635);
    }
    return this.mContext.getString(2131693632);
  }
  
  protected void fu(View paramView)
  {
    if (paramView.getId() == 2131364503) {
      this.a.u(1, paramView);
    }
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public class a
    extends xlc.a
  {
    public TextView T;
    public TextView U;
    public TextView V;
    public AsyncImageView a;
    public int bUv;
    public ProgressBar j;
    public RelativeLayout r;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xle
 * JD-Core Version:    0.7.0.1
 */