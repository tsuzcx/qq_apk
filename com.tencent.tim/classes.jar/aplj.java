import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.6;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class aplj
  extends aplb<aplj.a, apkt>
{
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  
  public aplj(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public aplj.a a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new aplj.a(this.mLayoutInflater.inflate(2131561743, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.mEditText.setOnClickListener(new aplk(this));
    if (this.e.Ls() != 0) {
      paramViewGroup.itemView.setPadding(this.e.Ls(), 0, this.e.Ls(), 0);
    }
    return paramViewGroup;
  }
  
  public void a(View paramView, aplj.a parama) {}
  
  public void a(aplj.a parama)
  {
    super.onViewDetachedFromWindow(parama);
  }
  
  public void a(aplj.a parama, apkt paramapkt, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parama.hashCode() + ", mData.position:" + paramapkt.mPosition + ", text:" + paramapkt.mText);
    if (parama.mTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + paramapkt.mPosition + ", text:" + paramapkt.mText + ",Listener:" + parama.mTextWatcher.toString());
      parama.mEditText.removeTextChangedListener(parama.mTextWatcher);
      parama.mTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parama.mEditText.setVisibility(8);
      parama.mTextView.setText(paramapkt.mText);
      if (TextUtils.isEmpty(paramapkt.mText))
      {
        parama.itemView.setVisibility(8);
        parama.mTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parama.mEditText.setVisibility(0);
      parama.mTextView.setVisibility(8);
      parama.mEditText.setText(paramapkt.mText);
      QLog.i("xmediaEditor", 1, "mData.position:" + paramapkt.mPosition + ", text:" + paramapkt.mText);
      parama.mEditText.setOnFocusChangeListener(null);
      parama.mEditText.setOnKeyListener(new apll(this, parama));
      parama.mEditText.setOnEditorActionListener(new aplm(this, parama));
      parama.mEditText.setOnFocusChangeListener(new apln(this, paramapkt, parama));
      parama.mTextWatcher = new aplo(this, parama, paramapkt);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + paramapkt.mPosition + ", text:" + paramapkt.mText + ",Listener:" + parama.mTextWatcher.toString());
      parama.mEditText.addTextChangedListener(parama.mTextWatcher);
      if (paramapkt.cRf)
      {
        parama.mEditText.setFocusable(true);
        parama.mEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parama, paramapkt));
      }
      while (this.e.aBh()) {
        if ((((apkt)parama.a).mPosition == 1) && (this.e.getAdapter().getItemCount() == 2))
        {
          parama.mEditText.setHint(this.e.getHint());
          return;
          parama.mEditText.clearFocus();
          parama.mEditText.setFocusable(false);
          parama.mEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parama.mEditText.setHint("");
          return;
        }
      }
      if ((((apkt)parama.a).mPosition == 0) && (this.e.getAdapter().getItemCount() == 1))
      {
        parama.mEditText.setHint(this.e.getHint());
        return;
      }
      parama.mEditText.setHint("");
      return;
    }
    parama.mTextView.setVisibility(0);
    parama.itemView.setVisibility(0);
  }
  
  public void b(aplj.a parama)
  {
    super.onViewRecycled(parama);
    apkt localapkt = (apkt)parama.a;
    if (parama.mTextWatcher != null)
    {
      parama.mEditText.removeTextChangedListener(parama.mTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((apkt)parama.a).mPosition + ", text:" + localapkt.mText + ",Listener:" + parama.mTextWatcher.toString());
      parama.mTextWatcher = null;
    }
    parama.mEditText.setOnFocusChangeListener(null);
    if (!localapkt.cRg) {
      localapkt.dUT = parama.mEditText.getSelectionStart();
    }
    for (;;)
    {
      parama.mEditText.clearFocus();
      parama.mEditText.setFocusable(false);
      parama.mEditText.setFocusableInTouchMode(false);
      return;
      localapkt.cRg = true;
    }
  }
  
  public String oH(String paramString)
  {
    paramString = (paramString + "a").split("\n");
    if (paramString.length > 0)
    {
      paramString = paramString[(paramString.length - 1)];
      if (Pattern.compile("^[1-9]\\d*[、,，.)）]\\d+").matcher(paramString).find()) {
        return "";
      }
      paramString = Pattern.compile("^[1-9]\\d*[、,，.)）]").matcher(paramString);
      if (paramString.find())
      {
        String str = paramString.group();
        paramString = str.substring(0, str.length() - 1);
        str = str.substring(str.length() - 1);
        int i = Integer.parseInt(paramString);
        return i + 1 + str;
      }
    }
    return "";
  }
  
  public static class a
    extends aplc.a<apkt>
  {
    public EditText mEditText;
    public TextView mTextView;
    public TextWatcher mTextWatcher;
    
    public a(View paramView)
    {
      super();
      this.mTextView = ((TextView)paramView.findViewById(2131379577));
      this.mEditText = ((EditText)paramView.findViewById(2131366278));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplj
 * JD-Core Version:    0.7.0.1
 */