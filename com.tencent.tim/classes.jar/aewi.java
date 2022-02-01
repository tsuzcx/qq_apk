import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class aewi
  implements View.OnClickListener, wvs
{
  private BaseChatPie c;
  private Runnable gm = new CopyPromptHelper.4(this);
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private View mPromptView;
  private TextWatcher textWatcher = new aewj(this);
  
  public aewi(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
  }
  
  private boolean aiq()
  {
    return this.c.mAIORootView.findViewById(2131364559).getVisibility() == 0;
  }
  
  private void cXz()
  {
    Object localObject = this.c.app.getManager(320);
    if ((localObject instanceof aewm))
    {
      localObject = ((aewm)localObject).getPrompt();
      if (QLog.isColorLevel()) {
        QLog.d("CopyPromptHelper", 2, "handlePrompt content : " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        cXA();
        this.mPromptView = f((String)localObject);
        this.mHandler.postDelayed(this.gm, 5000L);
        jnn[] arrayOfjnn = new jnn[1];
        arrayOfjnn[0] = new jnn(this.c.mAIORootView, new aewk(this, arrayOfjnn));
        if (this.mPromptView != null) {
          this.mPromptView.setOnClickListener(new aewl(this, (String)localObject));
        }
      }
    }
  }
  
  private View f(String paramString)
  {
    View localView = LayoutInflater.from(this.c.mContext).inflate(2131559793, this.c.mAIORootView, false);
    ((TextView)localView.findViewById(2131373708)).setText(new aofk(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131369277);
    paramString.leftMargin = wja.dp2px(14.0F, this.c.mContext.getResources());
    ((RelativeLayout)this.c.mAIORootView.findViewById(2131364469)).addView(localView, paramString);
    return localView;
  }
  
  public int[] C()
  {
    return new int[] { 3, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.c.a.O(this);
      this.c.a.addTextChangedListener(this.textWatcher);
      return;
      this.mHandler.removeCallbacks(this.gm);
      this.gm.run();
    } while (this.c.a == null);
    this.c.a.removeTextChangedListener(this.textWatcher);
  }
  
  public void cXA()
  {
    this.mHandler.removeCallbacks(this.gm);
    this.gm.run();
  }
  
  public void onClick(View paramView)
  {
    if (!aiq()) {
      cXz();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewi
 * JD-Core Version:    0.7.0.1
 */