import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.share.QZoneShareActivity;

public class avzv
  implements TextWatcher
{
  public avzv(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt3 == 0)) {
      try
      {
        QZoneShareActivity.b(this.this$0, QZoneShareActivity.a(this.this$0, paramCharSequence, paramInt1 + paramInt2));
        if (QZoneShareActivity.b(this.this$0) == -1)
        {
          QZoneShareActivity.g(this.this$0);
          return;
        }
        QZoneShareActivity.c(this.this$0, paramInt1);
        QZoneShareActivity.a(this.this$0, paramCharSequence.toString().substring(QZoneShareActivity.b(this.this$0), QZoneShareActivity.c(this.this$0) + paramInt2));
        return;
      }
      catch (Exception paramCharSequence)
      {
        QZoneShareActivity.g(this.this$0);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.bK.removeTextChangedListener(this);
    if (paramCharSequence == null)
    {
      this.this$0.bK.addTextChangedListener(this);
      QZoneShareActivity.g(this.this$0);
      return;
    }
    if ((paramInt3 == 1) && (paramInt2 == 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@")))
    {
      this.this$0.dy(false);
      this.this$0.rZ = true;
      paramCharSequence = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
      paramCharSequence.putExtra("param_only_friends", true);
      paramCharSequence.putExtra("param_min", 1);
      this.this$0.startActivityForResult(paramCharSequence, 1000);
    }
    if (QZoneShareActivity.a(this.this$0, QZoneShareActivity.a(this.this$0), false)) {
      this.this$0.bK.getEditableText().delete(QZoneShareActivity.b(this.this$0), QZoneShareActivity.c(this.this$0));
    }
    QZoneShareActivity.g(this.this$0);
    this.this$0.Ep();
    this.this$0.bK.addTextChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzv
 * JD-Core Version:    0.7.0.1
 */