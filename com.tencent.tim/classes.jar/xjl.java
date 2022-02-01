import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.HashMap;

public class xjl
  extends ahvw
{
  public HashMap<Long, Integer> gL = new HashMap();
  
  public xjl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    Object localObject1 = paramView;
    try
    {
      if (!(parama instanceof xjl.a))
      {
        localObject1 = paramView;
        QLog.e("LoverChattingGrayTipItemBuilder", 1, "diffclashh =" + parama.getClass());
      }
      localObject1 = paramView;
      locala = (xjl.a)parama;
      parama = paramView;
      if (paramView == null)
      {
        localObject1 = paramView;
        paramView = LayoutInflater.from(this.mContext).inflate(2131558671, null);
        localObject1 = paramView;
        locala.mTextView = ((TextView)paramView.findViewById(2131368124));
        localObject1 = paramView;
        locala.mImageView = ((ImageView)paramView.findViewById(2131370922));
        localObject1 = paramView;
        localObject2 = locala.mTextView.getLayoutParams();
        parama = paramView;
        localObject1 = paramView;
        if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
        {
          localObject1 = paramView;
          localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
          parama = paramView;
          localObject1 = paramView;
          if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != BaseChatItemLayout.bOg)
          {
            localObject1 = paramView;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = BaseChatItemLayout.bOg;
            parama = paramView;
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        xjl.a locala;
        Object localObject2;
        parama = (wjd.a)localObject1;
      }
    }
    try
    {
      locala.mTextView.setLineSpacing(0.0F, 1.0F);
      locala.mTextView.setIncludeFontPadding(true);
      locala.mTextView.setMovementMethod(null);
      locala.mTextView.setTextColor(parama.getResources().getColorStateList(2131167621));
      if (this.gL == null) {
        this.gL = new HashMap();
      }
      if (!this.gL.containsKey(Long.valueOf(paramMessageRecord.uniseq)))
      {
        paramView = ObjectAnimator.ofFloat(locala.mImageView, "scaleX", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
        localObject1 = ObjectAnimator.ofFloat(locala.mImageView, "scaleY", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).play(paramView).with((Animator)localObject1);
        ((AnimatorSet)localObject2).setDuration(3000L);
        ((AnimatorSet)localObject2).start();
        this.gL.put(Long.valueOf(paramMessageRecord.uniseq), Integer.valueOf(1));
        localObject1 = paramMessageRecord.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = "1";
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", paramView, "", "1"));
        if (QLog.isColorLevel()) {
          QLog.d("LoverChattingGrayTipItemBuilder", 2, "revoke msg grayTipItemBuilder msg uinseq=  message" + paramMessageRecord.msg.hashCode());
        }
      }
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if ((paramMessageRecord.tipParam != null) && (paramMessageRecord.tipParam.xg != null))
      {
        long l1 = paramMessageRecord.uniseq;
        long l2 = locala.mPosition;
        if (QLog.isColorLevel()) {
          QLog.d("LoverChattingGrayTipItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
        }
        paramView = paramMessageRecord.getHightlightMsgText(this.app, paramLinearLayout.getContext(), false, locala.mTextView);
        paramMessageRecord = paramMessageRecord.tipParam.xg;
        locala.mTextView.setText(paramView);
        locala.mTextView.setClickable(true);
        locala.mTextView.setFocusable(true);
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return parama;
      }
      locala.mTextView.setText(paramMessageRecord.msg);
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      if (AppSetting.enableTalkBack)
      {
        locala.mTextView.setAccessibilityDelegate(null);
        return parama;
      }
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("LoverChattingGrayTipItemBuilder", 2, "LoverChattingGrayTipItemBuilder  exception " + paramMessageRecord.toString());
      return parama;
    }
    return parama;
  }
  
  protected wjd.a a()
  {
    return new xjl.a();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  public aqob[] a(View paramView)
  {
    return new aqoa().a();
  }
  
  public class a
    extends wjd.a
  {
    public ImageView mImageView;
    public TextView mTextView;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjl
 * JD-Core Version:    0.7.0.1
 */