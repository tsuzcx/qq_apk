import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import mqq.util.WeakReference;

class ausw
  extends ausj
{
  ausw(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  private void initView()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559225, null);
    localLinearLayout.findViewById(2131369671).setOnClickListener(new ausx(this));
    String str = getContext().getString(2131690652);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131380630);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1B90EE")), str.length() - 3, str.length() - 1, 33);
    localSpannableString.setSpan(new ausw.a(getContext(), null), str.length() - 3, str.length() - 1, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    addView(localLinearLayout);
  }
  
  static final class a
    extends ClickableSpan
  {
    private WeakReference<Context> mContext;
    
    private a(Context paramContext)
    {
      this.mContext = new WeakReference(paramContext);
    }
    
    public void onClick(@NonNull View paramView)
    {
      paramView = (Context)this.mContext.get();
      if (paramView != null)
      {
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", "https://support.qq.com/product/36028");
        paramView.startActivity(localIntent);
      }
    }
    
    public void updateDrawState(@NonNull TextPaint paramTextPaint)
    {
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausw
 * JD-Core Version:    0.7.0.1
 */