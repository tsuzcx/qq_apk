import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class apag
  extends apab
  implements View.OnClickListener
{
  private List<String> Hu = new ArrayList();
  private MessageRecord K;
  private MessageRecord L;
  private apag.a jdField_a_of_type_Apag$a;
  private TroopAioKeywordTipInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo;
  private achq b;
  private apat c;
  private boolean cPx;
  private boolean cPy;
  private int dSw;
  private int dSx;
  private Runnable fQ = new TroopAioKeywordTipBar.4(this);
  private boolean mIsShowing;
  private int mScrollState;
  
  public apag()
  {
    this.jdField_b_of_type_Achq = new apah(this);
  }
  
  private void Kk(boolean paramBoolean)
  {
    if ((!this.bvv) || (this.jdField_a_of_type_Apag$a == null) || (!this.mIsShowing) || (this.fs.indexOfChild(this.jdField_a_of_type_Apag$a.container) < 0)) {}
    TranslateAnimation localTranslateAnimation;
    do
    {
      return;
      localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setAnimationListener(new apaj(this, paramBoolean));
    } while (this.jdField_a_of_type_Apag$a.container.getAnimation() != null);
    this.jdField_a_of_type_Apag$a.container.startAnimation(localTranslateAnimation);
  }
  
  private void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo = paramTroopAioKeywordTipInfo;
    this.K = paramMessageRecord;
    if (!iD()) {
      return;
    }
    this.dSw = this.jdField_a_of_type_Wki.K(paramMessageRecord.uniseq);
    if (this.jdField_a_of_type_Apag$a == null)
    {
      this.jdField_a_of_type_Apag$a = new apag.a();
      this.jdField_a_of_type_Apag$a.container = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131560755, null));
      this.jdField_a_of_type_Apag$a.container.setOnClickListener(this);
      this.jdField_a_of_type_Apag$a.a = ((URLThemeImageView)this.jdField_a_of_type_Apag$a.container.findViewById(2131380206));
      this.jdField_a_of_type_Apag$a.title = ((TextView)this.jdField_a_of_type_Apag$a.container.findViewById(2131380209));
      this.jdField_a_of_type_Apag$a.summary = ((TextView)this.jdField_a_of_type_Apag$a.container.findViewById(2131380208));
      this.jdField_a_of_type_Apag$a.arrow = ((ImageView)this.jdField_a_of_type_Apag$a.container.findViewById(2131380205));
      this.jdField_a_of_type_Apag$a.arrow.setImageResource(2130851779);
    }
    this.jdField_a_of_type_Apag$a.container.setBackgroundResource(2130844676);
    for (;;)
    {
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.icon);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = aqhu.at();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setDecodeHandler(aqbn.b);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        this.jdField_a_of_type_Apag$a.a.setImageDrawable((Drawable)localObject1);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.title))
        {
          this.jdField_a_of_type_Apag$a.title.setVisibility(8);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.summary)) {
            break label690;
          }
          this.jdField_a_of_type_Apag$a.summary.setVisibility(8);
          if (this.fs.indexOfChild(this.jdField_a_of_type_Apag$a.container) < 0)
          {
            localObject1 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject1).topMargin = aqcx.dip2px(this.context, 18.0F);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11);
            this.fs.addView(this.jdField_a_of_type_Apag$a.container, (ViewGroup.LayoutParams)localObject1);
          }
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Apag$a.container.getLayoutParams();
          int i = apmz.a(this.fs, new int[] { 2131380368, 2131374819, 2131374907, 2131374902 });
          if (i > 0) {
            ((RelativeLayout.LayoutParams)localObject1).addRule(3, i);
          }
          this.jdField_a_of_type_Apag$a.container.setVisibility(0);
          localObject1 = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
          ((Animation)localObject1).setDuration(500L);
          this.mIsShowing = true;
          ((Animation)localObject1).setAnimationListener(new apai(this));
          if (this.jdField_a_of_type_Apag$a.container.getAnimation() == null) {
            this.jdField_a_of_type_Apag$a.container.startAnimation((Animation)localObject1);
          }
          localObject2 = new anov(this.app).a("dc00899").b("Grp_AIO").c("notice_center_new");
          if (!paramMessageRecord.isSend()) {
            break label721;
          }
          localObject1 = "exp_keyword_input";
          ((anov)localObject2).d((String)localObject1).a(new String[] { paramMessageRecord.frienduin, String.valueOf(paramTroopAioKeywordTipInfo.ruleId), paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword") }).report();
          return;
        }
      }
      catch (MalformedURLException paramMessageRecord)
      {
        QLog.i("TroopAioKeywordTipBar", 1, "tryShow,e=" + paramMessageRecord.toString());
        return;
      }
      this.jdField_a_of_type_Apag$a.title.setVisibility(0);
      this.jdField_a_of_type_Apag$a.title.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.title);
      continue;
      label690:
      this.jdField_a_of_type_Apag$a.summary.setVisibility(0);
      this.jdField_a_of_type_Apag$a.summary.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.summary);
      continue;
      label721:
      Object localObject1 = "exp_keyword_msg";
    }
  }
  
  private boolean bc(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return lW(this.jdField_a_of_type_Wki.L(paramMessageRecord.uniseq));
  }
  
  private void dYl()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) && (this.K != null) && (!this.Hu.contains(this.K.getExtInfoFromExtStr("key_aio_keyword") + "_" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId)) && (this.K.isSend())) {
      this.Hu.add(this.K.getExtInfoFromExtStr("key_aio_keyword") + "_" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId);
    }
  }
  
  private void dYm()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) && (this.K != null) && (this.K.isSend())) {
      this.Hu.remove(this.K.getExtInfoFromExtStr("key_aio_keyword") + "_" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId);
    }
  }
  
  private boolean iD()
  {
    boolean bool = true;
    if ((!bc(this.K)) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo == null)) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("tryShow, not inVisiblePosition,tipInfo is null");
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) {
          break label64;
        }
        QLog.i("TroopAioKeywordTipBar", 2, bool);
      }
    }
    label64:
    label94:
    do
    {
      do
      {
        return false;
        bool = false;
        break;
        if (this.mScrollState == 0) {
          break label94;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TroopAioKeywordTipBar", 2, "tryShow, mScrollState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE");
      return false;
      if ((this.c == null) || (!this.c.aAP())) {
        break label129;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAioKeywordTipBar", 2, "tryShow, hasRightTopTipBar");
    return false;
    label129:
    return true;
  }
  
  private boolean lW(int paramInt)
  {
    if (paramInt < 0) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      k = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      m = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    } while ((paramInt < i - j) || (paramInt > k - m));
    return true;
  }
  
  public void Ru(boolean paramBoolean)
  {
    this.cPy = paramBoolean;
  }
  
  public void a(apat paramapat)
  {
    this.c = paramapat;
  }
  
  public boolean aAI()
  {
    return this.mIsShowing;
  }
  
  public void at(int paramInt, long paramLong)
  {
    this.mScrollState = paramInt;
    if (!this.bvv) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollStateChange,isInitSuccess == false");
      }
    }
    do
    {
      return;
      if (this.mScrollState == 0)
      {
        if ((this.mIsShowing) && (!lW(this.dSw))) {
          Kk(false);
        }
        lK(paramLong);
        return;
      }
    } while (!this.cPx);
    ThreadManager.getUIHandler().removeCallbacks(this.fQ);
    this.cPx = false;
  }
  
  protected void cbf()
  {
    this.cPy = false;
    this.app.removeObserver(this.jdField_b_of_type_Achq);
    if ((this.fs != null) && (this.jdField_a_of_type_Apag$a != null) && (this.fs.indexOfChild(this.jdField_a_of_type_Apag$a.container) >= 0))
    {
      this.fs.removeView(this.jdField_a_of_type_Apag$a.container);
      this.jdField_a_of_type_Apag$a = null;
    }
    this.mIsShowing = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo = null;
    this.K = null;
    this.dSw = -1;
    this.Hu.clear();
  }
  
  public View cx()
  {
    if (this.jdField_a_of_type_Apag$a != null) {
      return this.jdField_a_of_type_Apag$a.container;
    }
    return null;
  }
  
  public void dYj()
  {
    if (!this.bvv) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollToBottom,isInitSuccess == false");
      }
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Wki.getList().size();
      if (i != this.dSx) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAioKeywordTipBar", 2, "curMsgCount == mLastScrollToBottomListViewCount");
    return;
    this.dSx = i;
    at(0, 0L);
  }
  
  public void dYk()
  {
    if (!this.bvv) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioListRefresh,isInitSuccess == false");
      }
    }
    while (this.K == null) {
      return;
    }
    this.dSw = this.jdField_a_of_type_Wki.K(this.K.uniseq);
  }
  
  public void lK(long paramLong)
  {
    if (!this.cPx)
    {
      ThreadManager.getUIHandler().postDelayed(this.fQ, paramLong);
      this.cPx = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo == null) || (this.K == null))
    {
      QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo == null || mCurrentTipMR != null");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    dYm();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url)) {}
    label533:
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$GCODE$")) {
          localObject1 = ((String)localObject2).replace("$GCODE$", this.K.frienduin);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$TEXT$")) {
          break label533;
        }
        if (!(this.K instanceof MessageForText)) {
          continue;
        }
        localObject1 = ((String)localObject1).replace("$TEXT$", aqgo.encodeToString(((MessageForText)this.K).sb.toString().getBytes(), 0));
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$KEYWORD$")) {
          localObject2 = ((String)localObject1).replace("$KEYWORD$", aqgo.encodeToString(this.K.getExtInfoFromExtStr("key_aio_keyword").getBytes(), 0));
        }
        if (!((String)localObject2).startsWith("http")) {
          continue;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(this.context, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        this.context.startActivity((Intent)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "onClick, url=" + (String)localObject2);
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject1;
        QLog.i("TroopAioKeywordTipBar", 1, "error=" + localException.toString() + ",url=" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url);
        continue;
      }
      localObject2 = new anov(this.app).a("dc00899").b("Grp_AIO").c("notice_center_new");
      if (this.K.isSend())
      {
        localObject1 = "clk_keyword_input";
        ((anov)localObject2).d((String)localObject1).a(new String[] { this.K.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId), this.K.getExtInfoFromExtStr("key_aio_keyword") }).report();
        Kk(true);
        break;
        if (!(this.K instanceof MessageForStructing)) {
          break label533;
        }
        localObject2 = (MessageForStructing)this.K;
        if (!(((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)) {
          break label533;
        }
        localObject1 = ((String)localObject1).replace("$TEXT$", aqgo.encodeToString(((AbsShareMsg)((MessageForStructing)localObject2).structingMsg).mContentTitle.getBytes(), 0));
        continue;
        if (!((String)localObject2).startsWith("mqqapi")) {
          continue;
        }
        localObject1 = aqik.c(this.app, this.context, (String)localObject2);
        if (localObject1 == null) {
          continue;
        }
        ((aqhv)localObject1).ace();
        continue;
        QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo.url is empty");
        continue;
      }
      String str = "clk_keyword_msg";
    }
  }
  
  protected void onInit()
  {
    this.app.addObserver(this.jdField_b_of_type_Achq);
  }
  
  class a
  {
    public URLThemeImageView a;
    public ImageView arrow;
    public ViewGroup container;
    public TextView summary;
    public TextView title;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apag
 * JD-Core Version:    0.7.0.1
 */