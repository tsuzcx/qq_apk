import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

class afqi
  implements ajdq<EmoticonPackage>
{
  afqi(afqh paramafqh, int paramInt1, int paramInt2, EditText paramEditText, QQAppInterface paramQQAppInterface) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    char[] arrayOfChar1 = afgc.a(this.cTe, this.cTf);
    char[] arrayOfChar2 = new char[5];
    arrayOfChar2[0] = '\024';
    arrayOfChar2[1] = arrayOfChar1[3];
    arrayOfChar2[2] = arrayOfChar1[2];
    arrayOfChar2[3] = arrayOfChar1[1];
    arrayOfChar2[4] = arrayOfChar1[0];
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      arrayOfChar2[1] = 'ǿ';
    }
    int i = this.bd.getSelectionStart();
    int j = this.bd.getSelectionEnd();
    this.bd.getEditableText().replace(i, j, String.valueOf(arrayOfChar2));
    this.bd.requestFocus();
    anot.a(this.val$app, "CliOper", "", "", "ep_mall", "0X800717E", 0, 0, this.cTe + "", this.cTf + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqi
 * JD-Core Version:    0.7.0.1
 */