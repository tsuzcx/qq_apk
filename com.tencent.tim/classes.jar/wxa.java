import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper.1;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import mqq.os.MqqHandler;

public class wxa
  implements ScenesRecommendManager.a, wvs
{
  private long IH;
  private long II;
  private ygr jdField_a_of_type_Ygr;
  private yhf jdField_a_of_type_Yhf;
  private QQAppInterface app;
  private boolean bgo;
  private BaseActivity mActivity;
  private BaseChatPie mBaseChatPie;
  private Context mContext;
  private long mLastShowTime;
  private SessionInfo mSessionInfo;
  private MqqHandler q;
  
  public wxa(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPie = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.mSessionInfo = paramBaseChatPie.sessionInfo;
    this.q = paramBaseChatPie.getUIHandler();
  }
  
  public int[] C()
  {
    return new int[] { 13, 7 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    yhf localyhf;
    do
    {
      return;
      if (this.jdField_a_of_type_Yhf != null) {
        this.jdField_a_of_type_Yhf.a(null);
      }
      ScenesRecommendManager.a(this.app).a(null);
      return;
      localyhf = yhf.a(this.app);
    } while ((localyhf.hasInit()) || (!yhf.b(this.app.getApp(), this.app.getCurrentAccountUin(), false)));
    ThreadManager.executeOnSubThread(new StickerRecHelper.1(this, localyhf));
  }
  
  public boolean Sg()
  {
    return yhf.b(this.mContext, this.app.getCurrentUin(), false);
  }
  
  public boolean Sh()
  {
    return this.bgo;
  }
  
  public EmotionKeywordHorizonListView a(EditText paramEditText)
  {
    EmotionKeywordLayout localEmotionKeywordLayout = this.mBaseChatPie.a();
    localEmotionKeywordLayout.setEnableAnim(true);
    LinearLayout localLinearLayout = (LinearLayout)localEmotionKeywordLayout.findViewById(2131366342);
    EmotionKeywordHorizonListView localEmotionKeywordHorizonListView = (EmotionKeywordHorizonListView)localEmotionKeywordLayout.findViewById(2131366371);
    TextView localTextView = (TextView)localEmotionKeywordLayout.findViewById(2131366341);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null))
    {
      localEmotionKeywordLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localEmotionKeywordHorizonListView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localLinearLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localTextView.setTextColor(Color.parseColor("#8D8D93"));
    }
    this.jdField_a_of_type_Ygr = new ygr(this.mActivity, this.app, this.mSessionInfo, paramEditText, this.mBaseChatPie, localEmotionKeywordHorizonListView);
    localEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_Ygr);
    localEmotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
    if (this.jdField_a_of_type_Yhf == null) {
      this.jdField_a_of_type_Yhf = yhf.a(this.app);
    }
    this.jdField_a_of_type_Yhf.a(new ygr.a(this.jdField_a_of_type_Ygr));
    localEmotionKeywordLayout.setOnVisibilityListener(new wxb(this));
    ScenesRecommendManager.a(this.app).a(this);
    return localEmotionKeywordHorizonListView;
  }
  
  public void a(yho paramyho) {}
  
  public void ccR()
  {
    this.mLastShowTime = System.currentTimeMillis();
  }
  
  public void ccS()
  {
    this.II = System.currentTimeMillis();
    this.bgo = true;
    ((wwz)this.mBaseChatPie.a(41)).ccQ();
  }
  
  public void ccT()
  {
    this.bgo = false;
  }
  
  public boolean hJ(String paramString)
  {
    if (this.mBaseChatPie == null) {
      return false;
    }
    String str = this.mBaseChatPie.sessionInfo.aTl;
    QLog.i("ScenesRecommendManager", 0, "checkUinIsCurrentChat  uin = " + paramString + " | curUin = " + str);
    return str.equalsIgnoreCase(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxa
 * JD-Core Version:    0.7.0.1
 */