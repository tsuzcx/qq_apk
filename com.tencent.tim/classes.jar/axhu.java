import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;

public class axhu
  extends ReportDialog
{
  private ImageView Ii;
  private axhu.a a;
  private TextView ahg;
  private TextView dx;
  private Button hU;
  private EditText mEditText;
  private int mMaxLength = 12;
  private transient TextPaint mTextPaint;
  
  public axhu(@NonNull Context paramContext)
  {
    super(paramContext, 2131755604);
    initView(paramContext);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setSoftInputMode(21);
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void dZQ()
  {
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.mTextPaint.setAntiAlias(true);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131558563, null);
    this.mEditText = ((EditText)paramContext.findViewById(2131366204));
    this.ahg = ((TextView)paramContext.findViewById(2131366206));
    this.dx = ((TextView)paramContext.findViewById(2131364221));
    this.hU = ((Button)paramContext.findViewById(2131365219));
    this.Ii = ((ImageView)paramContext.findViewById(2131364026));
    this.mEditText.addTextChangedListener(new axhv(this));
    this.hU.setOnClickListener(new axhw(this));
    this.dx.setOnClickListener(new axhx(this));
    this.Ii.setOnClickListener(new axhy(this));
    setContentView(paramContext);
  }
  
  public void a(axhu.a parama)
  {
    this.a = parama;
  }
  
  public void a(TextWMElement paramTextWMElement, boolean paramBoolean)
  {
    String str1 = paramTextWMElement.userValue;
    String str2 = paramTextWMElement.color;
    dZQ();
    if ((TextUtils.isEmpty(str1)) && (paramBoolean)) {
      if (!TextUtils.isEmpty(paramTextWMElement.fmtstr))
      {
        this.mEditText.setText(paramTextWMElement.fmtstr);
        this.mEditText.setSelection(paramTextWMElement.fmtstr.length());
      }
    }
    for (;;)
    {
      this.mEditText.selectAll();
      return;
      paramTextWMElement = StringUtils.removeUTF8Emoji(str1);
      this.mEditText.setText(paramTextWMElement);
      this.mEditText.setSelection(paramTextWMElement.length());
    }
  }
  
  public void adT(int paramInt)
  {
    this.mMaxLength = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void acF(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhu
 * JD-Core Version:    0.7.0.1
 */