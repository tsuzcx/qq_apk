import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;
import com.tribe.async.dispatch.IEventReceiver;

public class rji
  implements IEventReceiver
{
  public rji.b a;
  public ImageButton ac;
  public XEditTextEx c;
  public View.OnClickListener cL;
  public String mKeyword;
  public final View mRootView;
  public TextView yG;
  
  public rji(View paramView)
  {
    this.mRootView = paramView;
    init(paramView);
  }
  
  private void init(View paramView)
  {
    this.ac = ((ImageButton)paramView.findViewById(2131363244));
    this.yG = ((TextView)paramView.findViewById(2131365121));
    this.c = ((XEditTextEx)paramView.findViewById(2131366256));
    paramView = new SpannableString(acfp.m(2131712202));
    paramView.setSpan(new AbsoluteSizeSpan(14, true), 0, paramView.length(), 33);
    this.c.setHint(paramView);
    this.c.addTextChangedListener(new rji.a());
    this.c.setOnEditorActionListener(new rjj(this));
  }
  
  public int getVisibility()
  {
    return this.mRootView.getVisibility();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void p(View.OnClickListener paramOnClickListener)
  {
    this.ac.setOnClickListener(paramOnClickListener);
  }
  
  public void q(View.OnClickListener paramOnClickListener)
  {
    this.cL = paramOnClickListener;
    this.yG.setOnClickListener(paramOnClickListener);
  }
  
  public void setVisibility(int paramInt)
  {
    this.mRootView.setVisibility(paramInt);
  }
  
  public class a
    implements TextWatcher
  {
    public a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      String str = rot.L(paramEditable.toString(), 30);
      if (str.length() < paramEditable.length()) {
        paramEditable.replace(0, paramEditable.length(), str);
      }
      rji.this.mKeyword = paramEditable.toString();
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      paramCharSequence = paramCharSequence.toString();
      rji.this.mKeyword = paramCharSequence;
      ram.d("Q.qqstory.record.label.QQStoryAddVideoLabelView", "keyword = " + rji.this.mKeyword);
      if (rji.this.a != null) {
        rji.this.a.onTextChanged(rji.this.mKeyword);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onTextChanged(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rji
 * JD-Core Version:    0.7.0.1
 */