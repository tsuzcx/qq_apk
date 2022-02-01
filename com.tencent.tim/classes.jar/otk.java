import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity;
import com.tencent.mobileqq.widget.QQToast;

public class otk
  implements TextWatcher
{
  public otk(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    PublicAccountImageCollectionCommentActivity.a(this.a, paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramCharSequence.length() - paramInt2 + paramInt3 > 100)) {
      QQToast.a(this.a, 0, this.a.getString(2131697417), 0).show(this.a.getTitleBarHeight());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otk
 * JD-Core Version:    0.7.0.1
 */