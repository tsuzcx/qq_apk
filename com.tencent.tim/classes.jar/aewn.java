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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class aewn
  implements View.OnClickListener
{
  private XEditTextEx f;
  private Runnable gm = new LiteCopyPromptHelper.4(this);
  private QQAppInterface mApp;
  private Context mContext;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private View mPromptView;
  private ViewGroup mRootView;
  private TextWatcher textWatcher = new aewo(this);
  
  public aewn(Context paramContext, ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx)
  {
    this.mApp = paramQQAppInterface;
    this.mRootView = paramViewGroup;
    this.mContext = paramContext;
    this.f = paramXEditTextEx;
  }
  
  private View f(String paramString)
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131559793, this.mRootView, false);
    ((TextView)localView.findViewById(2131373708)).setText(new aofk(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131369277);
    paramString.leftMargin = wja.dp2px(14.0F, this.mContext.getResources());
    ((RelativeLayout)this.mRootView.findViewById(2131364469)).addView(localView, paramString);
    return localView;
  }
  
  public void cXA()
  {
    this.mHandler.removeCallbacks(this.gm);
    this.gm.run();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.mApp.getManager(320);
    if ((localObject instanceof aewm))
    {
      localObject = ((aewm)localObject).getPrompt();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        cXA();
        this.mPromptView = f((String)localObject);
        this.mHandler.postDelayed(this.gm, 5000L);
        jnn[] arrayOfjnn = new jnn[1];
        arrayOfjnn[0] = new jnn(this.mRootView, new aewp(this, arrayOfjnn));
        if (this.mPromptView != null) {
          this.mPromptView.setOnClickListener(new aewq(this, (String)localObject));
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate()
  {
    if (this.f != null)
    {
      this.f.O(this);
      this.f.addTextChangedListener(this.textWatcher);
    }
  }
  
  public void onDestroy()
  {
    this.mHandler.removeCallbacks(this.gm);
    this.gm.run();
    if (this.f != null) {
      this.f.removeTextChangedListener(this.textWatcher);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewn
 * JD-Core Version:    0.7.0.1
 */