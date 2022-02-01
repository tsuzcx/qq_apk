import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.b;

public class aldh
  implements View.OnClickListener, View.OnLongClickListener, BubblePopupWindow.b
{
  private TextView Xg;
  private alas jdField_a_of_type_Alas;
  private aldh.a jdField_a_of_type_Aldh$a;
  private BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
  
  private aldh(TextView paramTextView, alas paramalas)
  {
    this.Xg = paramTextView;
    this.jdField_a_of_type_Alas = paramalas;
  }
  
  private void a(aldh.a parama)
  {
    this.jdField_a_of_type_Aldh$a = parama;
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2, aldh.a parama)
  {
    if (paramTextView != null)
    {
      alas localalas = new alas(paramString1);
      localalas.gU(paramString2, paramString1);
      paramString1 = new aldh(paramTextView, localalas);
      paramString1.a(parama);
      paramTextView.setOnLongClickListener(paramString1);
      paramTextView.setText(paramTextView.getText(), TextView.BufferType.SPANNABLE);
    }
  }
  
  private void copyContent(String paramString)
  {
    if (paramString != null) {
      try
      {
        Object localObject = BaseApplicationImpl.getApplication();
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT < 11)
          {
            ((android.text.ClipboardManager)((Context)localObject).getSystemService("clipboard")).setText(paramString);
            return;
          }
          localObject = (android.content.ClipboardManager)((Context)localObject).getSystemService("clipboard");
          alkw.a((android.content.ClipboardManager)localObject, paramString);
          ((android.content.ClipboardManager)localObject).setText(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TextViewCopyAction", 0, "copyContent fail.", paramString);
      }
    }
  }
  
  private void dFe()
  {
    int k;
    if (this.Xg != null)
    {
      k = this.Xg.getText().toString().length();
      if (!(this.Xg.getText() instanceof Spannable)) {
        break label104;
      }
    }
    label71:
    label104:
    for (Spannable localSpannable = (Spannable)this.Xg.getText();; localSpannable = null)
    {
      int i;
      if (localSpannable != null) {
        if (this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan == null) {
          i = 1714664933;
        }
      }
      try
      {
        int j = Color.parseColor("#33000000");
        i = j;
      }
      catch (Exception localException)
      {
        break label71;
      }
      this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(i);
      localSpannable.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, 0, k, 17);
      return;
    }
  }
  
  private void dFf()
  {
    if (this.Xg != null)
    {
      Spannable localSpannable = null;
      if ((this.Xg.getText() instanceof Spannable)) {
        localSpannable = (Spannable)this.Xg.getText();
      }
      if (localSpannable != null) {
        localSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
      }
    }
  }
  
  public static void m(TextView paramTextView, String paramString)
  {
    if (paramTextView != null)
    {
      String str = paramTextView.getText().toString();
      alas localalas = new alas(str);
      localalas.gU(paramString, str);
      paramTextView.setOnLongClickListener(new aldh(paramTextView, localalas));
      paramTextView.setText(paramTextView.getText(), TextView.BufferType.SPANNABLE);
    }
  }
  
  public void onClick(View paramView)
  {
    String str = null;
    if (this.jdField_a_of_type_Alas != null)
    {
      if (!(paramView instanceof TextView)) {
        break label100;
      }
      str = ((TextView)paramView).getText().toString();
    }
    label100:
    for (str = this.jdField_a_of_type_Alas.mJ(str);; str = this.jdField_a_of_type_Alas.mContent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TextViewCopyAction", 0, String.format("onClick copyResult=%s", new Object[] { str }));
      }
      if (!TextUtils.isEmpty(str))
      {
        copyContent(str);
        if (this.jdField_a_of_type_Aldh$a != null) {
          this.jdField_a_of_type_Aldh$a.copyContent(str);
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  public void onDismiss()
  {
    dFf();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Alas != null)
    {
      aqoa localaqoa = new aqoa();
      this.jdField_a_of_type_Alas.e(localaqoa);
      dFe();
      aqgq.a(paramView, localaqoa, this, this);
      if (this.jdField_a_of_type_Aldh$a != null) {
        this.jdField_a_of_type_Aldh$a.bwR();
      }
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void bwR();
    
    public abstract void copyContent(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldh
 * JD-Core Version:    0.7.0.1
 */